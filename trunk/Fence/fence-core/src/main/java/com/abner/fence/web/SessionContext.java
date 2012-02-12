/**
 * This software is under the license of GNU Lesser General Public License(LGPL).
 * You may obtain a copy of the License at
 *   http://www.gnu.org/copyleft/lesser.html.
 */

package com.abner.fence.web;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author abner
 * 
 */
public class SessionContext implements Context {
	private final static String KEY = "_sessionContext";
	int maxKeyIndex = 0;
	private final Map<Object, Object> cachedData = new HashMap<Object, Object>();

	private SessionContext() {
	}

	synchronized public static SessionContext instance() {
		return instance(FacesContext.getCurrentInstance());
	}

	synchronized public static SessionContext instance(FacesContext facesContext) {
		return instance((HttpServletRequest) facesContext.getExternalContext().getRequest());
	}

	synchronized public static SessionContext instance(HttpServletRequest request) {
		SessionContext inst = (SessionContext) request.getSession().getAttribute(KEY);

		if (inst == null) {
			inst = new SessionContext();
			request.getSession().setAttribute(KEY, inst);
		}

		return inst;
	}

	synchronized public Object get(Object key) {
		if (key == null)
			return null;
		return cachedData.get(key);
	}

	synchronized public void put(Object key, Object value) {
		cachedData.put(key, value);
	}

	synchronized public void remove(Object key) {
		cachedData.remove(key);
	}

	public void reset() {
		cachedData.clear();
	}

	synchronized public String genUniqueKey(String prefix) {
		String key;
		maxKeyIndex++;
		while (cachedData.containsKey((key = prefix + maxKeyIndex)))
			maxKeyIndex++;
		return key;
	}
}
