package com.fence;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;

import com.abner.fence.utils.FacesUtils;

@ManagedBean
@SessionScoped
public class App implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3705860813591510647L;

	public String getAppPath() {
		HttpServletRequest req = (HttpServletRequest) FacesUtils.extContext().getRequest();
		String url = req.getRequestURL().toString();
		int end = url.indexOf("/", 8);
		url = url.substring(0, end);
		return FacesUtils.extContext().getRequestContextPath();
	}
}
