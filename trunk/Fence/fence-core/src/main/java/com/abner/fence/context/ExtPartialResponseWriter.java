package com.abner.fence.context;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.PartialResponseWriter;
import javax.faces.context.ResponseWriter;

import com.abner.fence.component.ExtComponent;
import com.abner.fence.utils.ExtUtils;
import com.abner.fence.utils.FacesUtils;
import com.abner.fence.utils.RenderKitUtils;

public class ExtPartialResponseWriter extends PartialResponseWriter {
	private ResponseWriter writer;

	public ExtPartialResponseWriter(ResponseWriter writer) {
		super(writer);
	}

	/**
	 * the method is not wrapped. note
	 * 
	 * @return
	 */
	public ResponseWriter getWrapped_() {
		return writer;
	}

	@Override
	public void endDocument() throws IOException {
		this.startEval();

		this.renderExtJS();

		this.endEval();

		super.endDocument();
	}

	private void renderExtJS() throws IOException {
		RenderKitUtils.writePageScript(this);
	}

	@Override
	public void startUpdate(String targetId) throws IOException {
		UIComponent comp = FacesUtils.context().getViewRoot().findComponent(targetId);
		if (comp instanceof ExtComponent) {
			targetId += ExtUtils.SUFFIX_HTML_ID;
		}
		super.startUpdate(targetId);
	}

}
