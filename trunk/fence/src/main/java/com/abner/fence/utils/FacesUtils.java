package com.abner.fence.utils;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.MethodExpressionActionListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abner.fence.resources.MessageFactory;

public final class FacesUtils {

	public static FacesContext context() {
		return FacesContext.getCurrentInstance();
	}

	public static ExternalContext extContext() {
		return context().getExternalContext();
	}

	public static String getHostPath() {
		HttpServletRequest req = (HttpServletRequest) extContext().getRequest();
		String url = req.getRequestURL().toString();
		int end = url.indexOf("/", 8);
		url = url.substring(0, end);
		return url;
	}

	public static String getAppPath() {
		return extContext().getRequestContextPath();
	}

	public static String getHostAppPath() {
		return getHostPath() + getAppPath();
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ELContext elContext = context().getELContext();

		ELResolver elResolver = ctx.getApplication().getELResolver();
		return (T) elResolver.getValue(elContext, null, beanName);
	}

	public static MethodExpression createMethodExpression(String expr) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ELContext elContext = context().getELContext();
		ExpressionFactory elFactory = ctx.getApplication().getExpressionFactory();
		return elFactory.createMethodExpression(elContext, expr, void.class, new Class<?>[] { ActionEvent.class });
	}

	public static ActionListener createActionListener(String expr) {
		return new MethodExpressionActionListener(createMethodExpression(expr));
	}

	public static ViewHandler getViewHandler(FacesContext context) {
		Application application = context.getApplication();
		assert (application != null);

		ViewHandler viewHandler = application.getViewHandler();
		assert (viewHandler != null);

		return viewHandler;
	}

	public static String getActionUrl(String url) {
		return getViewHandler(context()).getActionURL(context(), url);
	}

	public static void addErrorMessage(String string) {
		FacesMessage msg = MessageFactory.getMessage(context(), string);
		if (msg == null)
			msg = new FacesMessage(string);

		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		context().addMessage(null, msg);
	}

	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) extContext().getResponse();
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) extContext().getRequest();
	}
}
