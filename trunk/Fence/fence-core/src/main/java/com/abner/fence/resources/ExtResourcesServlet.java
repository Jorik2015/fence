package com.abner.fence.resources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abner.fence.component.ScriptManager;
import com.abner.fence.utils.JSUtils;
import com.abner.fence.utils.Strings;
import com.abner.fence.web.RequestContext;
import com.abner.fence.web.ScriptReository;

public class ExtResourcesServlet extends HttpServlet {

	private static final long serialVersionUID = 8929609448333006629L;
	private long jarFileLastModified;
	private final Map<String, String> contentTypeMap = new HashMap<String, String>();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String prefix = request.getContextPath() + request.getServletPath() + "/";
		if (!request.getRequestURI().startsWith(prefix)) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		String path = request.getRequestURI().replaceFirst(prefix, "");
		int pos = path.indexOf('?');
		if (pos >= 0)
			path = path.substring(0, pos);

		String contentType = getContentType(path);
		if (contentType != null)
			response.setContentType(contentType);

		if (path.indexOf(ScriptManager.ScriptManager) >= 0) {
			response.reset();
			writePageScript(request, response);
			return;
		}else{
			path = "META-INF/" + path;
		}
		long modifiedSince = request.getDateHeader("If-Modified-Since");
		if (modifiedSince != -1) {
			// eg: Mon, 30 Mar 2009 02:28:58 GMT
			// "EEE, d MMMM yyyy HH:mm:ss z"
			if (Math.abs(jarFileLastModified - modifiedSince) < 1000) {
				response.sendError(HttpServletResponse.SC_NOT_MODIFIED);
				return;
			}
		}

		URL url = getClass().getClassLoader().getResource(path);
		if (url == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		Calendar expiresDate = Calendar.getInstance();
		expiresDate.add(Calendar.HOUR, 1);
		response.addDateHeader("Expires", expiresDate.getTimeInMillis());
		response.addHeader("Cache-Control", "max-age=1800");
		response.setDateHeader("Last-Modified", jarFileLastModified);
		URLConnection conn = null;
		InputStream inputStream = null;
		try {
			conn = url.openConnection();
			conn.setUseCaches(false);
			inputStream = conn.getInputStream();

			if (isGZipEncoding(request)) {
				response.setHeader("Content-Encoding", "gzip");
				GZipResponse zipResponse = new GZipResponse(response);
				int len;
				byte[] buffer = new byte[1024];
				while ((len = inputStream.read(buffer)) > 0) {
					zipResponse.getOutputStream().write(buffer, 0, len);
				}
				zipResponse.flush();
			} else {
				int len;
				byte[] buffer = new byte[1024];
				while ((len = inputStream.read(buffer)) > 0) {
					response.getOutputStream().write(buffer, 0, len);
				}
				response.flushBuffer();
			}
		} catch (Exception e) {
			try {
				if (inputStream != null)
					inputStream.close();
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void writePageScript(HttpServletRequest request, HttpServletResponse response) {
		String key = request.getParameter("key");
		ScriptReository sr = JSUtils.getScriptReository(key, request);
		boolean isDebug = "true".equals(request.getParameter("debug"));
		StringBuffer builder = new StringBuffer(265);
		String vars = sr.getGlobalVar();
		if (!Strings.isEmpty(vars)) {
			builder.append("var ");
			builder.append(sr.getGlobalVar());
			builder.append(";");
			if (isDebug)
				builder.append("\n");
		}

		List<String> scripts = sr.getScriptGlobalClientInitBag();
		for (String s : scripts) {
			if (s.trim().length() == 0)
				continue;
			builder.append(s.trim());
			if (isDebug)
				builder.append("\n");
		}

		StringBuffer initScript = new StringBuffer(265);

		initScript.append("{");
		if (isDebug)
			initScript.append("\n");
		scripts = sr.getScriptBeforeClientInitBag();
		for (String s : scripts) {
			if (s.trim().length() == 0)
				continue;
			initScript.append(s.trim());

			if (isDebug)
				initScript.append("\n");
		}

		scripts = sr.getScriptClientInitBag();
		for (String s : scripts) {
			if (s.trim().length() == 0)
				continue;

			initScript.append(s.trim());

			if (isDebug)
				initScript.append("\n");
		}

		scripts = sr.getScriptAfterClientInitBag();
		for (String s : scripts) {
			if (s.trim().length() == 0)
				continue;
			initScript.append(s.trim());
			if (isDebug)
				initScript.append("\n");
		}

		initScript.append("}");
		builder.append(MessageFormat.format(ScriptManager.OnReadyTemplate, initScript));

		try {
			response.setContentType("text/javascript");
			response.setStatus(200);
			response.setCharacterEncoding("UTF-8");
			if (isGZipEncoding(request)) {
				response.setHeader("Content-Encoding", "gzip");
				GZipResponse zipResponse = new GZipResponse(response);
				zipResponse.getWriter().write(builder.toString());
				zipResponse.flush();
			} else {
				OutputStreamWriter outWriter = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
				outWriter.write(builder.toString());
				outWriter.flush();
				outWriter.close();
			}
		} catch (Exception e) {
			String message = null;
			message = "Error when build runtime script.";

			try {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, message);
			} catch (IOException f) {
				f.printStackTrace();
			}
		} finally {
			sr.reset();
			RequestContext.instance(request).reset();
		}
	}

	@Override
	public void init() throws ServletException {
		try {
			String path = getClass().getClassLoader().getResource(getClass().getName().replace('.', '/') + ".class")
					.toURI().toString();
			int pos = path.lastIndexOf('!');
			if (pos < 0)
				pos = path.length();
			path = path.substring(path.indexOf('/') + 1, pos);
			path = URLDecoder.decode(path, "utf-8");
			path = path.replace('/', File.separatorChar);
			File file = new File(path);
			jarFileLastModified = file.lastModified();

		} catch (Exception e) {
		}

		contentTypeMap.put("ai", "application/postscript");
		contentTypeMap.put("aif", "audio/x-aiff");
		contentTypeMap.put("aifc", "audio/x-aiff");
		contentTypeMap.put("aiff", "audio/x-aiff");
		contentTypeMap.put("asc", "text/plain");
		contentTypeMap.put("au", "audio/basic");
		contentTypeMap.put("avi", "video/x-msvideo");
		contentTypeMap.put("bcpio", "application/x-bcpio");
		contentTypeMap.put("bin", "application/octet-stream");
		contentTypeMap.put("c", "text/plain");
		contentTypeMap.put("cc", "text/plain");
		contentTypeMap.put("ccad", "application/clariscad");
		contentTypeMap.put("cdf", "application/x-netcdf");
		contentTypeMap.put("class", "application/octet-stream");
		contentTypeMap.put("cpio", "application/x-cpio");
		contentTypeMap.put("cpt", "application/mac-compactpro");
		contentTypeMap.put("csh", "application/x-csh");
		contentTypeMap.put("css", "text/css");
		contentTypeMap.put("dcr", "application/x-director");
		contentTypeMap.put("dir", "application/x-director");
		contentTypeMap.put("dms", "application/octet-stream");
		contentTypeMap.put("doc", "application/msword");
		contentTypeMap.put("drw", "application/drafting");
		contentTypeMap.put("dvi", "application/x-dvi");
		contentTypeMap.put("dwg", "application/acad");
		contentTypeMap.put("dxf", "application/dxf");
		contentTypeMap.put("dxr", "application/x-director");
		contentTypeMap.put("eps", "application/postscript");
		contentTypeMap.put("etx", "text/x-setext");
		contentTypeMap.put("exe", "application/octet-stream");
		contentTypeMap.put("ez", "application/andrew-inset");
		contentTypeMap.put("f", "text/plain");
		contentTypeMap.put("f90", "text/plain");
		contentTypeMap.put("fli", "video/x-fli");
		contentTypeMap.put("gif", "image/gif");
		contentTypeMap.put("gtar", "application/x-gtar");
		contentTypeMap.put("gz", "application/x-gzip");
		contentTypeMap.put("h", "text/plain");
		contentTypeMap.put("hdf", "application/x-hdf");
		contentTypeMap.put("hh", "text/plain");
		contentTypeMap.put("hqx", "application/mac-binhex40");
		contentTypeMap.put("htm", "text/html");
		contentTypeMap.put("html", "text/html");
		contentTypeMap.put("ice", "x-conference/x-cooltalk");
		contentTypeMap.put("ief", "image/ief");
		contentTypeMap.put("iges", "model/iges");
		contentTypeMap.put("igs", "model/iges");
		contentTypeMap.put("ips", "application/x-ipscript");
		contentTypeMap.put("ipx", "application/x-ipix");
		contentTypeMap.put("jpe", "image/jpeg");
		contentTypeMap.put("jpeg", "image/jpeg");
		contentTypeMap.put("jpg", "image/jpeg");
		contentTypeMap.put("js", "application/x-javascript");
		contentTypeMap.put("kar", "audio/midi");
		contentTypeMap.put("latex", "application/x-latex");
		contentTypeMap.put("lha", "application/octet-stream");
		contentTypeMap.put("lsp", "application/x-lisp");
		contentTypeMap.put("lzh", "application/octet-stream");
		contentTypeMap.put("m", "text/plain");
		contentTypeMap.put("man", "application/x-troff-man");
		contentTypeMap.put("me", "application/x-troff-me");
		contentTypeMap.put("mesh", "model/mesh");
		contentTypeMap.put("mid", "audio/midi");
		contentTypeMap.put("midi", "audio/midi");
		contentTypeMap.put("mif", "application/vnd.mif");
		contentTypeMap.put("mime", "www/mime");
		contentTypeMap.put("mov", "video/quicktime");
		contentTypeMap.put("movie", "video/x-sgi-movie");
		contentTypeMap.put("mp2", "audio/mpeg");
		contentTypeMap.put("mp3", "audio/mpeg");
		contentTypeMap.put("mpe", "video/mpeg");
		contentTypeMap.put("mpeg", "video/mpeg");
		contentTypeMap.put("mpg", "video/mpeg");
		contentTypeMap.put("mpga", "audio/mpeg");
		contentTypeMap.put("ms", "application/x-troff-ms");
		contentTypeMap.put("msh", "model/mesh");
		contentTypeMap.put("nc", "application/x-netcdf");
		contentTypeMap.put("oda", "application/oda");
		contentTypeMap.put("pbm", "image/x-portable-bitmap");
		contentTypeMap.put("pdb", "chemical/x-pdb");
		contentTypeMap.put("pdf", "application/pdf");
		contentTypeMap.put("pgm", "image/x-portable-graymap");
		contentTypeMap.put("pgn", "application/x-chess-pgn");
		contentTypeMap.put("png", "image/png");
		contentTypeMap.put("pnm", "image/x-portable-anymap");
		contentTypeMap.put("pot", "application/mspowerpoint");
		contentTypeMap.put("ppm", "image/x-portable-pixmap");
		contentTypeMap.put("pps", "application/mspowerpoint");
		contentTypeMap.put("ppt", "application/mspowerpoint");
		contentTypeMap.put("ppz", "application/mspowerpoint");
		contentTypeMap.put("pre", "application/x-freelance");
		contentTypeMap.put("prt", "application/pro_eng");
		contentTypeMap.put("ps", "application/postscript");
		contentTypeMap.put("qt", "video/quicktime");
		contentTypeMap.put("ra", "audio/x-realaudio");
		contentTypeMap.put("ram", "audio/x-pn-realaudio");
		contentTypeMap.put("ras", "image/cmu-raster");
		contentTypeMap.put("rgb", "image/x-rgb");
		contentTypeMap.put("rm", "audio/x-pn-realaudio");
		contentTypeMap.put("roff", "application/x-troff");
		contentTypeMap.put("rpm", "audio/x-pn-realaudio-plugin");
		contentTypeMap.put("rtf", "text/rtf");
		contentTypeMap.put("rtx", "text/richtext");
		contentTypeMap.put("scm", "application/x-lotusscreencam");
		contentTypeMap.put("set", "application/set");
		contentTypeMap.put("sgm", "text/sgml");
		contentTypeMap.put("sgml", "text/sgml");
		contentTypeMap.put("sh", "application/x-sh");
		contentTypeMap.put("shar", "application/x-shar");
		contentTypeMap.put("silo", "model/mesh");
		contentTypeMap.put("sit", "application/x-stuffit");
		contentTypeMap.put("skd", "application/x-koan");
		contentTypeMap.put("skm", "application/x-koan");
		contentTypeMap.put("skp", "application/x-koan");
		contentTypeMap.put("skt", "application/x-koan");
		contentTypeMap.put("smi", "application/smil");
		contentTypeMap.put("smil", "application/smil");
		contentTypeMap.put("snd", "audio/basic");
		contentTypeMap.put("sol", "application/solids");
		contentTypeMap.put("spl", "application/x-futuresplash");
		contentTypeMap.put("src", "application/x-wais-source");
		contentTypeMap.put("step", "application/STEP");
		contentTypeMap.put("stl", "application/SLA");
		contentTypeMap.put("stp", "application/STEP");
		contentTypeMap.put("sv4cpio", "application/x-sv4cpio");
		contentTypeMap.put("sv4crc", "application/x-sv4crc");
		contentTypeMap.put("swf", "application/x-shockwave-flash");
		contentTypeMap.put("t", "application/x-troff");
		contentTypeMap.put("tar", "application/x-tar");
		contentTypeMap.put("tcl", "application/x-tcl");
		contentTypeMap.put("tex", "application/x-tex");
		contentTypeMap.put("texi", "application/x-texinfo");
		contentTypeMap.put("texinfo", "application/x-texinfo");
		contentTypeMap.put("tif", "image/tiff");
		contentTypeMap.put("tiff", "image/tiff");
		contentTypeMap.put("tr", "application/x-troff");
		contentTypeMap.put("tsi", "audio/TSP-audio");
		contentTypeMap.put("tsp", "application/dsptype");
		contentTypeMap.put("tsv", "text/tab-separated-values");
		contentTypeMap.put("txt", "text/plain");
		contentTypeMap.put("unv", "application/i-deas");
		contentTypeMap.put("ustar", "application/x-ustar");
		contentTypeMap.put("vcd", "application/x-cdlink");
		contentTypeMap.put("vda", "application/vda");
		contentTypeMap.put("viv", "video/vnd.vivo");
		contentTypeMap.put("vivo", "video/vnd.vivo");
		contentTypeMap.put("vrml", "model/vrml");
		contentTypeMap.put("wav", "audio/x-wav");
		contentTypeMap.put("wrl", "model/vrml");
		contentTypeMap.put("xbm", "image/x-xbitmap");
		contentTypeMap.put("xlc", "application/vnd.ms-excel");
		contentTypeMap.put("xll", "application/vnd.ms-excel");
		contentTypeMap.put("xlm", "application/vnd.ms-excel");
		contentTypeMap.put("xls", "application/vnd.ms-excel");
		contentTypeMap.put("xlw", "application/vnd.ms-excel");
		contentTypeMap.put("xml", "text/xml");
		contentTypeMap.put("xpm", "image/x-xpixmap");
		contentTypeMap.put("xwd", "image/x-xwindowdump");
		contentTypeMap.put("xyz", "chemical/x-pdb");
		contentTypeMap.put("zip", "application/zip");
	}

	/**
	 * 判断浏览器是否支持GZIP
	 * 
	 * @param request
	 * @return
	 */
	private boolean isGZipEncoding(HttpServletRequest request) {
		boolean flag = false;
		String encoding = request.getHeader("Accept-Encoding");
		if (encoding.indexOf("gzip") != -1) {
			flag = true;
		}
		return flag;
	}

	private String getContentType(String path) {
		int pos = path.lastIndexOf('.');
		if (pos < 0)
			return null;
		String suffix = path.substring(pos + 1);
		return contentTypeMap.get(suffix);
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
