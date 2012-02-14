package com.abner.fence.viewroot;

import java.io.IOException;

import javax.faces.component.ContextCallback;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;
import javax.faces.event.PhaseId;

import com.abner.fence.lifecycle.AsyncResponse;
import com.abner.fence.util.Ext;

import ext.base.ExtComponentMetaData;
import ext.base.IExt;
import ext.util.ComponentUtil;

class RerenderContextCallback implements ContextCallback {
	private PhaseId curPhase = null;

	protected RerenderContextCallback(PhaseId curPhase) {
		this.curPhase = curPhase;
	}

	private PhaseId getPhaseId() {
		return curPhase;
	}

	public void invokeContextCallback(FacesContext facesContext,
			UIComponent comp) {
		try {
			if (getPhaseId() == PhaseId.RENDER_RESPONSE) {
				if (comp instanceof IExt) {
					ExtComponentMetaData metadata = ComponentUtil
							.getMetadata((IExt) comp);
					if (metadata != null && !metadata.isUi()) {
						comp.encodeAll(facesContext);
						return;
					}
				}

				if (comp.isRendered()) {
					AsyncResponse async = AsyncResponse.getInstance();
					ResponseWriter writer = async.getResponseWriter();
					writer.startElement("render", comp);
					String id = comp.getClientId(facesContext);
					// 如果root是IExt组件，则输出的html元素加_html后缀
					if (IExt.class.isAssignableFrom(comp.getClass())) {
						id = id + Ext.SUFFIX_HTML_ID;
					}

					writer.writeAttribute("id", id, "id");
					try {
						writer.startElement("markup", comp);
						writer.write("<![CDATA[");
						EscapeCDATAWriter cdataWriter = new EscapeCDATAWriter(writer);
						facesContext.setResponseWriter(facesContext.getResponseWriter().cloneWithWriter(cdataWriter));

						comp.encodeAll(facesContext);

						facesContext.setResponseWriter(writer);
						writer.write("]]>");
						writer.endElement("markup");
					} catch (ConverterException ce) {
						throw ce;
					}
					writer.endElement("render");
				}
			} else {
				throw new IllegalStateException("I18N: Unexpected "
						+ "PhaseId passed to " + " PhaseAwareContextCallback: "
						+ curPhase.toString());
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
