package com.abner.action;

import java.io.InputStream;

import javax.faces.context.ExternalContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Controller;

import ext.util.FacesUtils;

@Controller("loadSourceAction")
public class LoadSourceAction {
	
	public String loadSource() {
		ExternalContext extContext = FacesUtils.extContext();
		HttpServletRequest req = (HttpServletRequest) extContext.getRequest();
		String url = req.getRequestURI();
		url = url.substring(url.lastIndexOf("faces/") + 5);
		try {
			InputStream is = (InputStream) extContext.getResource(url).getContent();
			byte[] b = new byte[is.available()];
			is.read(b, 0, is.available());

			return StringEscapeUtils.escapeJavaScript(new String(b));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage() + url);
		}
	}
}
