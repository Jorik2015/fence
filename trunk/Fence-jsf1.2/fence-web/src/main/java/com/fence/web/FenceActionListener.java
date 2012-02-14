package com.fence.web;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.component.ActionSource;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.EvaluationException;
import javax.faces.el.MethodBinding;
import javax.faces.el.MethodNotFoundException;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

@SuppressWarnings("deprecation")
public class FenceActionListener implements ActionListener {

	public void processAction(ActionEvent event)
			throws AbortProcessingException {
		this.process(event);
	}

	private void process(ActionEvent event) throws AbortProcessingException {
		UIComponent source = event.getComponent();
		ActionSource actionSource = (ActionSource) source;
		FacesContext context = FacesContext.getCurrentInstance();

		Application application = context.getApplication();

		Object invokeResult;
		String outcome = null;
		MethodBinding binding;

		binding = actionSource.getAction();
		if (binding != null) {
			try {
				if (null != (invokeResult = binding.invoke(context, null))) {
					outcome = invokeResult.toString();
				}
				// else, default to null, as assigned above.
			} catch (MethodNotFoundException e) {
				throw new FacesException(binding.getExpressionString() + ": "
						+ e.getMessage(), e);
			} catch (EvaluationException e) {
				throw new FacesException(binding.getExpressionString() + ": "
						+ e.getMessage(), e);
			}
		}

		// Retrieve the NavigationHandler instance..
		NavigationHandler navHandler = application.getNavigationHandler();

		// Invoke nav handling..
		navHandler.handleNavigation(context, (null != binding) ? binding
				.getExpressionString() : null, outcome);

		// Trigger a switch to Render Response if needed
		context.renderResponse();
	}
}
