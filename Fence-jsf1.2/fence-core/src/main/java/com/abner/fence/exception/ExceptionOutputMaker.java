package com.abner.fence.exception;

import java.io.IOException;
import java.io.Writer;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abner.fence.lifecycle.AsyncResponse;
import com.abner.fence.util.WriterUtils;

public class ExceptionOutputMaker {
	private static boolean debug = false;

	public void writeErrorMessage(FacesContext context, Throwable e,
			String phase) throws FacesException, IOException {
		if (null == context) {
			throw new FacesException("FacesContext is null", e);
		}
		ExternalContext externalContext = context.getExternalContext();
		if (null == externalContext) {
			throw new FacesException("ExternalContext is null", e);
		}
		HttpServletResponse response;
		HttpServletRequest request;
		try {
			response = (HttpServletResponse) externalContext.getResponse();
			request = (HttpServletRequest) externalContext.getRequest();
			request.setCharacterEncoding("UTF-8");
			response.reset();
			response.setContentType("text/xml;charset=UTF-8");
			response.setStatus(500);
		} catch (Exception er) {
			throw new FacesException("", e);
		}
		Writer writer = response.getWriter();
		if (writer == null) {
			AsyncResponse async = AsyncResponse.getInstance();
			writer = async.getResponseWriter();
		}

		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		writer.write("<" + WriterUtils.PARTIAL_TAG + " success=\"false\">");
		writer.write("<exception severity=\"");

		String message = e.getMessage();
		Throwable ec = e.getCause();
		Throwable lastestException = null;
		while (null != ec) {
			message = ec.getMessage();
			if(message == null){
				if(lastestException == null){
					message = "Unknow error! source:" + ec.toString();
					break;
				}
				message = lastestException.getMessage();
				break;
			}
			lastestException = ec;
			ec = ec.getCause();
		}

		if (lastestException instanceof ExtMessageException) {
			ExtMessageException baseExce = (ExtMessageException) lastestException;
			FacesMessage facemsg = baseExce.getFacesMessage();
			if (facemsg != null) {
				Severity severity = facemsg.getSeverity();
				if (FacesMessage.SEVERITY_ERROR.equals(severity)) {
					writer.write("error");
				} else if (FacesMessage.SEVERITY_WARN.equals(severity)) {
					writer.write("warn");
				} else if (FacesMessage.SEVERITY_FATAL.equals(severity)) {
					writer.write("error");
				} else {
					writer.write("info");
				}
			}
		}else{
			writer.write("error");
		}

		writer.write("\">");
		writer.write(message);

		if (debug)
			writeExceptionStack(e, writer);

		writer.write("</exception>");
		writer.write("<success>false</success>");
		writer.write("</" + WriterUtils.PARTIAL_TAG + ">");

		writer.flush();
		writer.close();
	}

	public void writeExceptionStack(Throwable e, Writer writer)
			throws IOException {
		writer.write("Exceptions:\n");
		Throwable error = e;
		while (null != error) {
			writer.write("\n" + error.getMessage());
			writer.write("\nException stack :");
			StackTraceElement[] stackTrace = error.getStackTrace();
			for (int i = 0; i < stackTrace.length; i++) {
				writer.write("\n at " + stackTrace[i].getClassName());
				writer.write("." + stackTrace[i].getMethodName());
				writer.write("in " + stackTrace[i].getFileName() + " line "
						+ stackTrace[i].getLineNumber());
			}
			error = error.getCause();
		}
	}
}
