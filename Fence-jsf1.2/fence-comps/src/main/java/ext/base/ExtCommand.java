package ext.base;

import javax.el.ELContext;
import javax.el.ELException;
import javax.el.MethodExpression;
import javax.el.MethodInfo;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.ActionSource;
import javax.faces.component.ActionSource2;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.FacesEvent;
import javax.faces.event.PhaseId;

import com.abner.fence.coop.CoopInterface;

import ext.BoxComponent;
import ext.annotation.ClientConfig;
import ext.annotation.JsonMode;

@SuppressWarnings("deprecation")
public class ExtCommand extends BoxComponent implements ActionSource2,
		AjaxExecute {
	public static final String COMPONENT_TYPE = "Ext.ExtCommand";

	public ExtCommand() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private Object successFn;

	@ClientConfig(JsonMode.Function)
	public Object getSuccessFn() {
		if (null != this.successFn) {
			return this.successFn;
		}
		ValueExpression _ve = getValueExpression("successFn");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setSuccessFn(Object successFn) {
		this.successFn = successFn;
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
				result = ((MethodExpressionMethodBindingAdapter) me)
						.getWrapped();
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
	 * @deprecated This has been replaced by
	 *             {@link #setActionExpression(javax.el.MethodExpression)}.
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
		return this.methodBindingActionListener;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated This has been replaced by
	 *             {@link #addActionListener(javax.faces.event.ActionListener)}.
	 */
	public void setActionListener(MethodBinding actionListener) {
		this.methodBindingActionListener = actionListener;
	}

	/**
	 * <p>
	 * The immediate flag.
	 * </p>
	 */
	private Boolean immediate;

	public boolean isImmediate() {

		if (this.immediate != null) {
			return (this.immediate);
		}
		ValueExpression ve = getValueExpression("immediate");
		if (ve != null) {
			try {
				return (Boolean.TRUE.equals(ve.getValue(getFacesContext()
						.getELContext())));
			} catch (ELException e) {
				throw new FacesException(e);
			}
		} else {
			return (false);
		}

	}

	public void setImmediate(boolean immediate) {
		this.immediate = immediate;
	}

	private MethodBinding methodBindingActionListener = null;

	// ---------------------------------------------------- ActionSource /
	// ActionSource2 Methods

	/**
	 * <p>
	 * The {@link MethodExpression} that, when invoked, yields the literal
	 * outcome value.
	 * </p>
	 */
	private MethodExpression actionExpression = null;

	public MethodExpression getActionExpression() {
		return actionExpression;
	}

	/**
	 * <p>
	 * Override the <code>UICommand</code> method to wrap the argument
	 * <code>MethodExpression</code> so that any return value it may yield from
	 * invocation is ignored and <code>null</code> is returned instead.
	 * </p>
	 */
	public void setActionExpression(final MethodExpression actionExpression) {
		MethodExpression me = new MethodExpression() {
			private static final long serialVersionUID = -2814853297324284566L;

			public boolean equals(Object other) {
				return actionExpression.equals(other);
			}

			public String getExpressionString() {
				return actionExpression.getExpressionString();
			}

			public int hashCode() {
				return actionExpression.hashCode();
			}

			public boolean isLiteralText() {
				return actionExpression.isLiteralText();
			}

			public MethodInfo getMethodInfo(ELContext context) {
				return actionExpression.getMethodInfo(context);
			}

			public Object invoke(ELContext context, Object[] params) {
				return actionExpression.invoke(context, params);
			}
		};
		this.actionExpression = me;
	}

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
	 * In addition to to the default {@link UIComponent#broadcast} processing,
	 * pass the {@link ActionEvent} being broadcast to the method referenced by
	 * <code>actionListener</code> (if any), and to the default
	 * {@link ActionListener} registered on the
	 * {@link javax.faces.application.Application}.
	 * </p>
	 * 
	 * @param event
	 *            {@link FacesEvent} to be broadcast
	 * 
	 * @throws AbortProcessingException
	 *             Signal the JavaServer Faces implementation that no further
	 *             processing on the current event should be performed
	 * @throws IllegalArgumentException
	 *             if the implementation class of this {@link FacesEvent} is not
	 *             supported by this component
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
	 * <p>
	 * Intercept <code>queueEvent</code> and, for {@link ActionEvent}s, mark the
	 * phaseId for the event to be <code>PhaseId.APPLY_REQUEST_VALUES</code> if
	 * the <code>immediate</code> flag is true,
	 * <code>PhaseId.INVOKE_APPLICATION</code> otherwise.
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

	// AjaxExcute
	/**
	 * <p>
	 * The name of a JavaScript event to intercept for sending Ajax requests. If
	 * not specified, the "onclick" JavaScript event is intercepted.
	 * </p>
	 */
	private String eventType = "click";

	/**
	 * <p>
	 * Get the name of a JavaScript event to intercept for sending Ajax
	 * requests. If not specified, the "onclick" JavaScript event is
	 * intercepted.
	 * </p>
	 */
	public String getEventType() {
		if (this.eventType != null) {
			return this.eventType;
		}
		ValueExpression ve = getValueExpression("eventType");
		if (ve != null) {
			return (String) ve.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	/**
	 * <p>
	 * Set the name of a JavaScript event to intercept for sending Ajax
	 * requests. If not specified, the "onclick" JavaScript event is
	 * intercepted.
	 * </p>
	 * 
	 * @see #getEventType()
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * <p>
	 * A comma separated list of client ids for which the "render" portion of
	 * the request processing lifecycle will be run when an Ajax transaction
	 * originates from within this zone. If not specified, the "render" portion
	 * of the request processing lifecycle will be run on this zone only.
	 * </p>
	 */
	private String render = null;

	/**
	 * <p>
	 * Get a comma separated list of client ids for which the "render" portion
	 * of the request processing lifecycle will be run when an Ajax transaction
	 * originates from within this zone. If not specified, the "render" portion
	 * of the request processing lifecycle will be run on this zone only.
	 * </p>
	 */
	public String getRender() {
		if (this.render != null) {
			return this.render;
		}
		ValueExpression ve = getValueExpression("render");
		if (ve != null) {
			return (String) ve.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	/**
	 * <p>
	 * Set a comma separated list of client ids for which the "render" portion
	 * of the request processing lifecycle will be run when an Ajax transaction
	 * originates from within this zone. If not specified, the "render" portion
	 * of the request processing lifecycle will be run on this zone only.
	 * </p>
	 * 
	 * @see #getRender()
	 */
	public void setRender(String render) {
		this.render = render;
	}

	
	// custom ===============================
	private String confirmText;

	@ClientConfig(value = JsonMode.Ignore)
	public String getConfirmText() {
		if (null != this.confirmText) {
			return this.confirmText;
		}
		ValueExpression _ve = getValueExpression("confirmText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setConfirmText(String confirmText) {
		this.confirmText = confirmText;
	}
	
	private Boolean transientRendered; 


	@Override
	public boolean isRendered() {
		boolean rendered;
		if(transientRendered != null)
			rendered = transientRendered;
		else
			rendered = super.isRendered();
		if(rendered && CoopInterface.isCoopActivated() && this.getActionExpression() != null)
			rendered = !CoopInterface.isActionRestricted(this.getActionExpression().getExpressionString());
		return rendered;
	}
	
	@Override
	public void setRendered(boolean rendered) {
		transientRendered = rendered;
	}

	private Object[] _values;

	public Object saveState(FacesContext context) {

		if (_values == null) {
			_values = new Object[6];
		}
		_values[0] = super.saveState(context);
		_values[1] = saveAttachedState(context, methodBindingActionListener);
		_values[2] = saveAttachedState(context, actionExpression);
		_values[3] = immediate;
		_values[4] = this.render;
		_values[5] = successFn;

		return (_values);
	}

	public void restoreState(FacesContext context, Object state) {
		_values = (Object[]) state;
		super.restoreState(context, _values[0]);
		methodBindingActionListener = (MethodBinding) restoreAttachedState(
				context, _values[1]);
		actionExpression = (MethodExpression) restoreAttachedState(context,
				_values[2]);
		immediate = (Boolean) _values[3];
		this.render = (String) _values[4];
		this.successFn = _values[5];
		this.handleConfig("successFn", this.successFn);
	}
}
