package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.abner.fence.resources.ScriptManager;
import com.abner.fence.util.JSUtils;
import com.abner.fence.util.RequestUtils;
import com.abner.fence.web.ExtMessage;

import ext.Message;
import ext.Window;
import ext.util.StringUtil;

public class ExtMessageRenderer extends ExtWindowRenderer {

	@Override
	public void beforeEncodeBegin(FacesContext context, Window component)
			throws IOException {
		super.beforeEncodeBegin(context, component);
		HtmlOutputText text = new HtmlOutputText();
		component.getChildren().add(text);
	}

	@Override
	public void afterEncodeBegin(FacesContext context, Window component)
			throws IOException {
		super.afterEncodeBegin(context, component);
		Message msgComp = (Message) component;
		// 当显示详细信息的时候使用window来显示。
		String script = ScriptManager.MESSAGE_WIN_VAR;
		JSUtils.getScriptReository().putGlobalVar(ScriptManager.MESSAGE_WIN_VAR);
		if (msgComp.isShowDetail()) {
			script += " = " + msgComp.getVar() + ";";
		} else {
			script += " = "	+ JSUtils.FENCE_BASE_INSTANCE + ";";
		}
		super.appendScriptAfter(msgComp, script);
	}

	@Override
	public void beforeEncodeEnd(FacesContext context, Window component)
			throws IOException {
		if (!RequestUtils.isAjaxRequest()) {
			ResponseWriter writer = context.getResponseWriter();
			assert (writer != null);

			Message msgComp = (Message) component;
			boolean showSummary = msgComp.isShowSummary();
			boolean showDetail = msgComp.isShowDetail();
			// String clientId = ((UIMessages) component).getFor();
			String clientId = null; // PENDING - "for" is actually gone now
			// if no clientId was included
			if (clientId == null) {
				// and the author explicitly only wants global messages
				if (msgComp.isGlobalOnly()) {
					// make it so only global messages get displayed.
					clientId = "";
				}
			}

			// "for" attribute optional for Messages
			Iterator<?> messageIter = getMessageIter(context, clientId,	component);

			assert (messageIter != null);

			if (!messageIter.hasNext()) {
				msgComp.setAutoShow(Boolean.FALSE);
				return;
			}
			if (showSummary && showDetail) {
				writer.startElement("dl", component);
				while (messageIter.hasNext()) {
					FacesMessage curMessage = (FacesMessage) messageIter.next();
					String summary = curMessage.getSummary();
					String detail = curMessage.getDetail();
					detail = StringUtil.ifEmpty(detail, summary);

					writer.startElement("dt", component);
					writer.write(summary);
					writer.startElement("dd", component);
					writer.write(detail);
					writer.endElement("dd");
					writer.endElement("dt");
				}
				writer.endElement("dl");
			} else if (showSummary) {
				FacesMessage curMessage = (FacesMessage) messageIter.next();
				ExtMessage.show(curMessage,false);
				msgComp.setAutoShow(Boolean.FALSE);
			}
		}
	}
}
