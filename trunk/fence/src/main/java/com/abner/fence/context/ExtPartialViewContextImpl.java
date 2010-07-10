package com.abner.fence.context;

import java.io.IOException;
import java.util.Collection;

import javax.faces.component.ContextCallback;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialResponseWriter;
import javax.faces.context.PartialViewContext;
import javax.faces.context.PartialViewContextWrapper;
import javax.faces.event.PhaseId;

import com.abner.fence.handler.ExtHandler;
import com.abner.fence.utils.FacesUtils;
import com.abner.fence.utils.Strings;
import com.abner.fence.web.Params;

public class ExtPartialViewContextImpl extends PartialViewContextWrapper {

	public static final String HANDLER_EXECUTE_PARAM_NAME = "javax.faces.partial.handler";
	public static final String NONE_SOURCE_PARAM_NAME = "@none";

	private PartialViewContext wrapped;
	private PartialResponseWriter writerWrapped;
	private Boolean handlerRequest;
	private FacesContext ctx;

	public ExtPartialViewContextImpl(PartialViewContext wrapped, FacesContext context) {
		super();
		this.wrapped = wrapped;
		this.ctx = context;
	}

	@Override
	public PartialViewContext getWrapped() {
		return wrapped;
	}

	@Override
	public void setPartialRequest(boolean isPartialRequest) {
		wrapped.setPartialRequest(isPartialRequest);
	}

	public void processPartial(PhaseId phaseId) {
		if (this.isHandlerRequest() && phaseId == PhaseId.RENDER_RESPONSE) {
			this.processPartialHandler(phaseId);
		} else {
			wrapped.processPartial(phaseId);
		}
	}

	@Override
	public PartialResponseWriter getPartialResponseWriter() {
		PartialResponseWriter writer = wrapped.getPartialResponseWriter();
		if (this.writerWrapped == null)
			writerWrapped = new ExtPartialResponseWriter(writer);

		return writerWrapped;
	}

	public boolean isRenderRoot(String id) {
		Collection<String> ids = this.getRenderIds();
		if (ids != null && ids.contains(id)) {
			return true;
		}
		return false;
	}

	public boolean isHandlerRequest() {
		if (handlerRequest == null) {
			handlerRequest = null != ctx.getExternalContext().getRequestParameterMap().get(HANDLER_EXECUTE_PARAM_NAME);
		}
		return handlerRequest;
	}

	private void processPartialHandler(PhaseId phaseId) {
		String handlerId = Params.getParam(HANDLER_EXECUTE_PARAM_NAME).getStringValue();
		ExtHandler handler = FacesUtils.getBean(handlerId);
		if (handler == null)
			throw new IllegalArgumentException("the managebean with name '" + handlerId + "' is not exist.");

		String source = Params.getParam("javax.faces.source").getStringValue();
		if (Strings.isEmpty(source))
			return;

		final UIComponent[] comp = new UIComponent[1];
		if (!NONE_SOURCE_PARAM_NAME.equals(source)) {
			ctx.getViewRoot().invokeOnComponent(ctx, source, new ContextCallback() {
				public void invokeContextCallback(FacesContext context, UIComponent target) {
					comp[0] = target;
				}
			});

			if (comp[0] == null) {
				return;
			}
		} else {
			comp[0] = null;
		}
		
		try {
			handler.processHandler(ctx, comp[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
