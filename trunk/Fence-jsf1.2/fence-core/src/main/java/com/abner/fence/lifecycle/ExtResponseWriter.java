package com.abner.fence.lifecycle;

import java.io.IOException;

import javax.faces.context.ResponseWriter;
import javax.faces.context.ResponseWriterWrapper;

public class ExtResponseWriter extends ResponseWriterWrapper {
	private ResponseWriter origWriter;

	public ExtResponseWriter(ResponseWriter origWriter) {
		super();
		this.origWriter = origWriter;
	}
	
	@Override
	public void endElement(String name) throws IOException {
		origWriter.endElement(name);
	}

	@Override
	protected ResponseWriter getWrapped() {
		return origWriter;
	}
}
