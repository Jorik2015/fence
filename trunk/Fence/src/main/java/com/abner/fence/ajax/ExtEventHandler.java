package com.abner.fence.ajax;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import javax.el.ELContext;
import javax.el.MethodExpression;
import javax.el.MethodNotFoundException;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.view.facelets.ComponentHandler;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagException;
import javax.faces.view.facelets.TagHandler;

public final class ExtEventHandler extends TagHandler {
	private final TagAttribute event;
	private final TagAttribute execute;
	private final TagAttribute render;
	private final TagAttribute onevent;
	private final TagAttribute onerror;
	private final TagAttribute disabled;
	private final TagAttribute immediate;
	private final TagAttribute listener;
	private final TagAttribute args;
	private final TagAttribute handler;
	private final TagAttribute confirm;

	/**
	 * @param config
	 */
	public ExtEventHandler(TagConfig config) {
		super(config);
		this.event = this.getAttribute("event");
		this.execute = this.getAttribute("execute");
		this.render = this.getAttribute("render");
		this.onevent = this.getAttribute("onevent");
		this.onerror = this.getAttribute("onerror");
		this.disabled = this.getAttribute("disabled");
		this.immediate = this.getAttribute("immediate");
		this.listener = this.getAttribute("listener");
		this.args = this.getAttribute("args");
		this.handler = this.getAttribute("handler");
		this.confirm = this.getAttribute("confirm");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sun.facelets.FaceletHandler#apply(com.sun.facelets.FaceletContext, javax.faces.component.UIComponent)
	 */
	public void apply(FaceletContext ctx, UIComponent parent) throws IOException {
		String eventName = getEventName();
		applyNested(ctx, parent, eventName);
	}

	public void applyAttachedObject(FacesContext context, UIComponent parent) {
		FaceletContext ctx = (FaceletContext) context.getAttributes().get(FaceletContext.FACELET_CONTEXT_KEY);
		applyAttachedObject(ctx, parent, getEventName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.view.AttachedObjectHandler#getFor()
	 */
	public String getFor() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.view.BehaviorHolderAttachedObjectHandler#getEventName()
	 */
	public String getEventName() {
		return (this.event != null) ? this.event.getValue() : null;
	}

	// Applies a nested AjaxHandler by adding the AjaxBehavior to the
	// parent component.
	private void applyNested(FaceletContext ctx, UIComponent parent, String eventName) {

		if (!ComponentHandler.isNew(parent)) {
			return;
		}

		// Composite component case
		if (UIComponent.isCompositeComponent(parent)) {
			throw new TagException(this.tag, "The EventHandler dose not support compositeComponent");
		} else if (parent instanceof ClientBehaviorHolder) {
			applyAttachedObject(ctx, parent, eventName);
		} else {
			throw new TagException(this.tag, "Unable to attach <s:event> to non-ClientBehaviorHolder parent");
		}
	}

	/**
	 * <p class="changed_added_2_0">
	 * </p>
	 * 
	 * @param ctx
	 * @param parent
	 * @param eventName
	 */
	private void applyAttachedObject(FaceletContext ctx, UIComponent parent, String eventName) {
		ClientBehaviorHolder bHolder = (ClientBehaviorHolder) parent;

		if (null == eventName) {
			eventName = bHolder.getDefaultEventName();
			if (null == eventName) {
				throw new TagException(this.tag, "Event attribute could not be determined: " + eventName);
			}
		} else {
			Collection<String> eventNames = bHolder.getEventNames();
			if (!eventNames.contains(eventName)) {
				throw new TagException(this.tag, getUnsupportedEventMessage(eventName, eventNames, parent));
			}
		}

		ExtAjaxBehavior ajaxBehavior = createAjaxBehavior(ctx, eventName);
		bHolder.addClientBehavior(eventName, ajaxBehavior);
	}

	// Construct our AjaxBehavior from tag parameters.
	private ExtAjaxBehavior createAjaxBehavior(FaceletContext ctx, String eventName) {
		Application application = ctx.getFacesContext().getApplication();
		ExtAjaxBehavior behavior = (ExtAjaxBehavior) application.createBehavior(ExtAjaxBehavior.BEHAVIOR_ID);

		setBehaviorAttribute(ctx, behavior, this.onevent, String.class);
		setBehaviorAttribute(ctx, behavior, this.onerror, String.class);
		setBehaviorAttribute(ctx, behavior, this.disabled, Boolean.class);
		setBehaviorAttribute(ctx, behavior, this.immediate, Boolean.class);
		setBehaviorAttribute(ctx, behavior, this.execute, Object.class);
		setBehaviorAttribute(ctx, behavior, this.render, Object.class);
		setBehaviorAttribute(ctx, behavior, this.args, String.class);
		setBehaviorAttribute(ctx, behavior, this.handler, String.class);
		setBehaviorAttribute(ctx, behavior, this.confirm, String.class);

		if (null != listener) {
			behavior.addAjaxBehaviorListener(new AjaxBehaviorListenerImpl(this.listener.getMethodExpression(ctx,
					Object.class, new Class[] { AjaxBehaviorEvent.class }), this.listener.getMethodExpression(ctx,
					Object.class, new Class[] {})));
		}

		return behavior;
	}

	// Sets the value from the TagAttribute on the behavior
	private void setBehaviorAttribute(FaceletContext ctx, ExtAjaxBehavior behavior, TagAttribute attr, Class<?> type) {
		if (attr != null) {
			behavior.setValueExpression(attr.getLocalName(), attr.getValueExpression(ctx, type));
		}
	}

	// Returns an error message for the case where the <f:ajax> event
	// attribute specified an unknown/unsupported event.
	private String getUnsupportedEventMessage(String eventName, Collection<String> eventNames, UIComponent parent) {
		StringBuilder builder = new StringBuilder(100);
		builder.append("'");
		builder.append(eventName);
		builder.append("' is not a supported event for ");
		builder.append(parent.getClass().getSimpleName());
		builder.append(".  Please specify one of these supported event names: ");

		// Might as well sort the event names for a cleaner error message.
		Collection<String> sortedEventNames = new TreeSet<String>(eventNames);
		Iterator<String> iter = sortedEventNames.iterator();

		boolean hasNext = iter.hasNext();
		while (hasNext) {
			builder.append(iter.next());

			hasNext = iter.hasNext();

			if (hasNext) {
				builder.append(", ");
			}
		}

		builder.append(".");

		return builder.toString();
	}
}

class AjaxBehaviorListenerImpl implements AjaxBehaviorListener, Serializable {
	private static final long serialVersionUID = -6056525197409773897L;

	private MethodExpression oneArgListener;
	private MethodExpression noArgListener;

	// Necessary for state saving
	public AjaxBehaviorListenerImpl() {
	}

	public AjaxBehaviorListenerImpl(MethodExpression oneArg, MethodExpression noArg) {
		this.oneArgListener = oneArg;
		this.noArgListener = noArg;
	}

	public void processAjaxBehavior(AjaxBehaviorEvent event) throws AbortProcessingException {
		final ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		try {
			noArgListener.invoke(elContext, new Object[] {});
		} catch (MethodNotFoundException mnfe) {
			// Attempt to call public void method(AjaxBehaviorEvent event)
			oneArgListener.invoke(elContext, new Object[] { event });
		}
	}

}
