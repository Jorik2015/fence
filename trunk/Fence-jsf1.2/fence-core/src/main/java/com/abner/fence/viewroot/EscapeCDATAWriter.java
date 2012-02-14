package com.abner.fence.viewroot;

import java.io.IOException;

import javax.faces.context.ResponseWriter;
import javax.faces.context.ResponseWriterWrapper;

public class EscapeCDATAWriter extends ResponseWriterWrapper {
	private ResponseWriter toWrap = null;

	public EscapeCDATAWriter(ResponseWriter toWrap) {
		this.toWrap = toWrap;
	}

	protected ResponseWriter getWrapped() {
		return toWrap;
	}

	public void write(String string) throws IOException {
		if (-1 != string.indexOf("]]>")) {
			String replaced = string.replace("]]>", "]]]]><![CDATA[>");
			super.write(replaced);
		} else {
			super.write(string);
		}
	}

	public void write(char[] cbuf, int off, int len) throws IOException {
		String str = new String(cbuf, off, len);
		if (-1 != str.indexOf("]]>")) {
			str = str.replace("]]>", "]]]]><![CDATA[>");
			cbuf = str.toCharArray();
			super.write(cbuf, off, cbuf.length);
		} else {
			super.write(cbuf, off, len);
		}
	}

}
