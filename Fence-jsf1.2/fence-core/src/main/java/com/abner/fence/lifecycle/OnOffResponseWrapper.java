package com.abner.fence.lifecycle;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import ext.util.FacesUtils;

final class OnOffResponseWrapper extends HttpServletResponseWrapper {
	private ServletOutputStream noOpServletOutputStream = null;
	private PrintWriter noOpPrintWriter = null;
	private boolean enabled;
	
	public OnOffResponseWrapper(HttpServletResponse orig) {
		super(orig);
	}

	public ServletOutputStream getOutputStream() throws IOException {
		if (null == noOpServletOutputStream) {
			noOpServletOutputStream = new ServletOutputStream() {

				ServletOutputStream out = OnOffResponseWrapper.this
						.getResponse().getOutputStream();

				public void println(String s) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.println(s);
					}
				}

				public void print(String s) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.print(s);
					}
				}

				public void write(byte[] b, int off, int len)
						throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.write(b, off, len);
					}
				}

				public void write(byte[] b) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.write(b);
					}
				}

				public void write(int b) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.write(b);
					}
				}

				public void println(int i) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.println(i);
					}
				}

				public void print(int i) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.print(i);
					}
				}

				public void print(boolean b) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.print(b);
					}
				}

				public void println(boolean b) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.println(b);
					}
				}

				public void print(long b) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.print(b);
					}
				}

				public void println(long b) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.println(b);
					}
				}

				public void print(double b) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.print(b);
					}
				}

				public void println(double b) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.println(b);
					}
				}

				public void print(char b) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.print(b);
					}
				}

				public void println(char b) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.println(b);
					}
				}

				public void print(float b) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.print(b);
					}
				}

				public void println(float b) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.println(b);
					}
				}

				public void close() throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.close();
					}
				}

				public void flush() throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.flush();
					}
				}

				public void println() throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						out.println();
					}
				}
			};
		}
		return noOpServletOutputStream;
	}

	@Override
	public void sendRedirect(String location) throws IOException {
		if(this.isEnabled()){
			AsyncResponse.handleRedirect(FacesUtils.context(),location);
		}else{
			super.sendRedirect(location);
		}
		
		//super.sendRedirect(location);
	}

	public PrintWriter getWriter() throws IOException {
		if (null == noOpPrintWriter) {
			noOpPrintWriter = new PrintWriter(new Writer() {

				private PrintWriter writer = OnOffResponseWrapper.this.getResponse().getWriter();

				public void write(String str) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						writer.write(str);
					}
				}

				public void write(char[] cbuf) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						writer.write(cbuf);
					}
				}

				public Writer append(char c) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						writer.append(c);
					}
					return this;
				}

				public Writer append(CharSequence csq, int start, int end)
						throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						writer.append(csq, start, end);
					}
					return this;
				}

				public void write(char[] cbuf, int off, int len)
						throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						writer.write(cbuf, off, len);
					}
				}

				public Writer append(CharSequence csq) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						writer.append(csq);
					}
					return this;
				}

				public void write(String str, int off, int len)
						throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						writer.write(str, off, len);
					}
				}

				public void write(int c) throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						writer.write(c);
					}
				}

				public void close() throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						writer.close();
					}
				}

				public void flush() throws IOException {
					if (OnOffResponseWrapper.this.isEnabled()) {
						writer.flush();
					}

				}

			});
		}
		return noOpPrintWriter;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setResponse(ServletResponse response) {
		// No-op.
	}

	public int getBufferSize() {
		int result = 0;
		if (this.isEnabled()) {
			result = getResponse().getBufferSize();
		}
		return result;
	}

	public void flushBuffer() throws IOException {
		if (this.isEnabled()) {
			getResponse().flushBuffer();
		}
	}

	public boolean isCommitted() {
		boolean result = false;
		if (this.isEnabled()) {
			result = getResponse().isCommitted();
		}
		return result;
	}

	public void reset() {
		if (this.isEnabled()) {
			getResponse().reset();
		}
	}

	public void resetBuffer() {
		if (this.isEnabled()) {
			getResponse().resetBuffer();
		}
	}
}
