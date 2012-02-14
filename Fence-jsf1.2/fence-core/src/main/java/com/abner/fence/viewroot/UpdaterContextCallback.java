package com.abner.fence.viewroot;

import java.io.IOException;
import java.util.List;

import javax.faces.component.ContextCallback;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import com.abner.fence.lifecycle.AsyncResponse;
import com.abner.fence.util.WriterUtils;
import com.abner.fence.web.RequestContext;

public class UpdaterContextCallback implements ContextCallback {
	private PhaseId curPhase = null;
	private static String only_pending = "only_pending";

	@SuppressWarnings("unused")
	private PhaseId getPhaseId() {
		return curPhase;
	}

	public UpdaterContextCallback(PhaseId curPhase) {
		this.curPhase = curPhase;
	}

	public void invokeContextCallback(FacesContext context, UIComponent comp) {
		Boolean pending = (Boolean)RequestContext.instance().get(only_pending);
		if(pending != null && pending.booleanValue())
			return;
		
		RequestContext.instance().put(only_pending, Boolean.TRUE);
		
		AsyncResponse async = AsyncResponse.getInstance();
		try {
			List<UIComponent> childs = comp.getChildren();
			for(UIComponent child : childs){
				child.encodeAll(context);
			}
			WriterUtils.writeExecuteScript(async.getResponseWriter());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
