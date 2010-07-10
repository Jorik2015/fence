package com.abner.fence.component;

import java.util.Collection;

import javax.el.MethodExpression;
import javax.faces.component.ActionSource;
import javax.faces.component.ActionSource2;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.FacesEvent;
import javax.faces.event.PhaseId;

import com.abner.fence.annotation.ClientConfig;
import com.abner.fence.commons.MethodBindingMethodExpressionAdapter;
import com.abner.fence.commons.MethodExpressionMethodBindingAdapter;
import com.abner.fence.commons.Enums.JsonMode;

import ext.BoxComponent;

@SuppressWarnings("deprecation")
@FacesComponent("Ext.ExtCommand")
public class ExtCommand extends BoxComponent implements ActionSource2 {
	public static final String COMPONENT_TYPE = "Ext.ExtCommand";

	public ExtCommand() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	/**
	 * Properties that are tracked by state saving.
	 */
	enum PropertyKeys {
		render,execute, confirmText, value, immediate, methodBindingActionListener, actionExpression,
	}

	@ClientConfig(value = JsonMode.Ignore)
	public String getRender() {
		return (String) this.getStateHelper().eval(PropertyKeys.render);
	}

	public void setRender(String render) {
		this.getStateHelper().put(PropertyKeys.render, render);
	}
	
	@ClientConfig(value = JsonMode.Ignore)
	public String getExecute() {
		return (String) this.getStateHelper().eval(PropertyKeys.execute);
	}

	public void setExecute(String execute) {
		this.getStateHelper().put(PropertyKeys.execute, execute);
	}

	@ClientConfig(value = JsonMode.Ignore)
	public String getConfirmText() {
		return (String) this.getStateHelper().eval(PropertyKeys.confirmText);
	}

	public void setConfirmText(String confirmText) {
		this.getStateHelper().put(PropertyKeys.confirmText, confirmText);
	}

	// -------------------------------------------------
	// ActionSource/ActionSource2 Properties

	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated This has been replaced by {@link #getActionExpression}.
	 */
	public MethodBinding getAction() {
		MethodBinding result = null;
		MethodExpression me;

		if (null != (me = getActionExpression())) {
			// if the MethodExpression is an instance of our private
			// wrapper class.
			if (me.getClass().equals(MethodExpressionMethodBindingAdapter.class)) {
				result = ((MethodExpressionMethodBindingAdapter) me).getWrapped();
			} else {
				// otherwise, this is a real MethodExpression. Wrap it
				// in a MethodBinding.
				result = new MethodBindingMethodExpressionAdapter(me);
			}
		}
		return result;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated This has been replaced by {@link #setActionExpression(javax.el.MethodExpression)}.
	 */
	public void setAction(MethodBinding action) {
		MethodExpressionMethodBindingAdapter adapter;
		if (null != action) {
			adapter = new MethodExpressionMethodBindingAdapter(action);
			setActionExpression(adapter);
		} else {
			setActionExpression(null);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated Use {@link #getActionListeners} instead.
	 */
	public MethodBinding getActionListener() {
		return (MethodBinding) getStateHelper().get(PropertyKeys.methodBindingActionListener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated This has been replaced by {@link #addActionListener(javax.faces.event.ActionListener)}.
	 */
	public void setActionListener(MethodBinding actionListener) {
		getStateHelper().put(PropertyKeys.methodBindingActionListener, actionListener);
	}

	/**
	 * <p>
	 * The immediate flag.
	 * </p>
	 */
	// private Boolean immediate;
	public boolean isImmediate() {

		return (Boolean) getStateHelper().eval(PropertyKeys.immediate, false);

	}

	public void setImmediate(boolean immediate) {

		getStateHelper().put(PropertyKeys.immediate, immediate);

	}

	/**
	 * <p>
	 * Returns the <code>value</code> property of the <code>UICommand</code>. This is most often rendered as a label.
	 * </p>
	 */
	public Object getValue() {

		return getStateHelper().eval(PropertyKeys.value);

	}

	/**
	 * <p>
	 * Sets the <code>value</code> property of the <code>UICommand</code>. This is most often rendered as a label.
	 * </p>
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(Object value) {

		getStateHelper().put(PropertyKeys.value, value);

	}

	// ---------------------------------------------------- ActionSource /
	// ActionSource2 Methods

	public MethodExpression getActionExpression() {
		return (MethodExpression) getStateHelper().get(PropertyKeys.actionExpression);
	}

	public void setActionExpression(MethodExpression actionExpression) {
		getStateHelper().put(PropertyKeys.actionExpression, actionExpression);
	}

	/**
	 * @throws NullPointerException
	 *             {@inheritDoc}
	 */
	public void addActionListener(ActionListener listener) {

		addFacesListener(listener);

	}

	public ActionListener[] getActionListeners() {

		ActionListener al[] = (ActionListener[]) getFacesListeners(ActionListener.class);
		return (al);

	}

	/**
	 * @throws NullPointerException
	 *             {@inheritDoc}
	 */
	public void removeActionListener(ActionListener listener) {

		removeFacesListener(listener);

	}

	// ----------------------------------------------------- UIComponent Methods

	/**
	 * <p>
	 * In addition to to the default {@link UIComponent#broadcast} processing, pass the {@link ActionEvent} being
	 * broadcast to the method referenced by <code>actionListener</code> (if any), and to the default
	 * {@link ActionListener} registered on the {@link javax.faces.application.Application}.
	 * </p>
	 * 
	 * @param event
	 *            {@link FacesEvent} to be broadcast
	 * 
	 * @throws AbortProcessingException
	 *             Signal the JavaServer Faces implementation that no further processing on the current event should be
	 *             performed
	 * @throws IllegalArgumentException
	 *             if the implementation class of this {@link FacesEvent} is not supported by this component
	 * @throws NullPointerException
	 *             if <code>event</code> is <code>null</code>
	 */
	public void broadcast(FacesEvent event) throws AbortProcessingException {

		// Perform standard superclass processing (including calling our
		// ActionListeners)
		super.broadcast(event);

		if (event instanceof ActionEvent) {
			FacesContext context = getFacesContext();

			// Notify the specified action listener method (if any)
			MethodBinding mb = getActionListener();
			if (mb != null) {
				mb.invoke(context, new Object[] { event });
			}

			// Invoke the default ActionListener
			ActionListener listener = context.getApplication().getActionListener();
			if (listener != null) {
				listener.processAction((ActionEvent) event);
			}
		}
	}

	/**
	 * 
	 * <p>
	 * Intercept <code>queueEvent</code> and take the following action. If the event is an
	 * <code>{@link ActionEvent}</code>, obtain the <code>UIComponent</code> instance from the event. If the component
	 * is an <code>{@link ActionSource}</code> obtain the value of its "immediate" property. If it is true, mark the
	 * phaseId for the event to be <code>PhaseId.APPLY_REQUEST_VALUES</code> otherwise, mark the phaseId to be
	 * <code>PhaseId.INVOKE_APPLICATION</code>. The event must be passed on to <code>super.queueEvent()</code> before
	 * returning from this method.
	 * </p>
	 */

	public void queueEvent(FacesEvent e) {
		UIComponent c = e.getComponent();
		if (e instanceof ActionEvent && c instanceof ActionSource) {
			if (((ActionSource) c).isImmediate()) {
				e.setPhaseId(PhaseId.APPLY_REQUEST_VALUES);
			} else {
				e.setPhaseId(PhaseId.INVOKE_APPLICATION);
			}
		}
		super.queueEvent(e);
	}

	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
		return superEvent;
	}

	public String getDefaultEventName() {
		return "click";
	}
}
