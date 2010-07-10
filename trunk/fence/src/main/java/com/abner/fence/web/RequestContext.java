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

public class RequestContext implements Context {
	private final static String KEY = "_requestContext";

	private final Map<Object, Object> cachedData = new HashMap<Object, Object>();

	private RequestContext() {

	}

	synchronized public static RequestContext instance() {
		return instance(FacesContext.getCurrentInstance());
	}

	synchronized public static RequestContext instance(FacesContext facesContext) {
		return instance((HttpServletRequest) facesContext.getExternalContext().getRequest());
	}

	synchronized public static RequestContext instance(HttpServletRequest request) {
		RequestContext inst = (RequestContext) request.getAttribute(KEY);

		if (inst == null) {
			inst = new RequestContext();
			request.setAttribute(KEY, inst);
		}

		return inst;
	}

	synchronized public Object get(Object key) {
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
}
