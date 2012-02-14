package com.abner.fence.docprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.w3c.tidy.Tidy;

public class Converter {

	private static Map<String, File> files = new HashMap<String, File>();
	private static String tagPath = "E:\\stsws\\fence-demo\\tags";
	private static final String docPath = "E:\\lib\\ext-3.0.3\\docs";
	private static final String javaPath = "E:\\stsws\\fence-comps\\src\\main\\java";

	public static void main(String[] args) throws Exception {
		// parseHtmlToXhtml();
		// parseDocument();

		appendAllTag();
	}

	public static void appendAllTag() {
		String path = "E:\\stsws\\fence-core\\src\\main\\resources\\META-INF\\fence_.tld";
		try {
			File filePath = new File(tagPath);
			File[] files = filePath.listFiles();
			
			File outFile = new File(path);
			FileOutputStream out = new FileOutputStream(outFile);
			
			for(int i=0;i<files.length;i++){
				File file = files[i];
				
				FileInputStream in = new FileInputStream(file);
				byte[] bs = new byte[4069];
				while (in.read(bs) != -1) {
					out.write(bs);
					bs = new byte[4069];
				}
				in.close();
			}
			
			System.out.println("ok");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void parseToSchema() throws Exception {
		String path = "E:\\lib\\ext-3.0.3\\docs\\components";
		File dir = new File(path);
		StringBuilder comps = new StringBuilder(256);
		StringBuilder tags = new StringBuilder(256);
		StringBuilder render = new StringBuilder(256);

		String temp1 = "<component><component-type>{0}</component-type><component-class>{1}</component-class></component>";
		String temp2 = "<tag><tag-name>{0}</tag-name><component><component-type>{1}</component-type><renderer-type>{1}</renderer-type></component></tag>";
		String temp3 = "<renderer><component-family>{0}</component-family><renderer-type>{1}</renderer-type><renderer-class>{2}</renderer-class></renderer>";
		if (dir.isDirectory()) {
			File[] fs = dir.listFiles();
			for (File f : fs) {
				if (!f.getName().endsWith(".html"))
					continue;

				String name = f.getName().substring(0,
						f.getName().lastIndexOf("."));
				String ns = name.substring(0, name.lastIndexOf(".") + 1)
						.toLowerCase();
				String tag = name.substring(name.lastIndexOf(".") + 1);

				comps.append(MessageFormat.format(temp1, name, ns + tag));

				if (getTag(name) != null)
					tags.append(MessageFormat.format(temp2, tag.toLowerCase(),
							name));

				String renderer = getRenderer(name);
				if (renderer != null)
					render.append(MessageFormat.format(temp3, name, name,
							getRenderer(name)));
			}
		}

		System.out.println(comps);
		System.out.println(tags);
		System.out.println(render);
	}

	private static String getTag(String name) {
		if (name.endsWith("Region"))
			return "";

		return null;
	}

	private static String getRenderer(String name) {
		if (name.endsWith("Item"))
			return "com.abner.fence.renderkit.ExtCommandRenderer";

		return null;
	}

	public static String parseUxJson() throws Exception {
		String path = "E:\\lib\\ext-3.0.3\\docs\\xhtml";
		File dir = new File(path);
		StringBuilder sb = new StringBuilder(256);
		sb.append("[");

		String temp = "'{'" + "href : \"output/{0}\"," + "text : \"{1}\","
				+ "id: \"{2}\",isClass : true,iconCls : \"icon-static\","
				+ "cls : \"cls\",leaf : true '}'";
		if (dir.isDirectory()) {
			File[] fs = dir.listFiles();
			for (File f : fs) {
				if (!f.getName().endsWith(".html"))
					continue;

				if (f.getName().indexOf(".ux.") < 0)
					continue;

				if (sb.length() > 1)
					sb.append(",");

				String name = f.getName().substring(7,
						f.getName().lastIndexOf("."));
				sb.append(MessageFormat.format(temp, f.getName(), name, f
						.getName().substring(0, f.getName().lastIndexOf("."))));

			}
		}

		sb.append("]");
		return sb.toString();
	}

	// 第一步 转换为标准的xhtml
	public static void parseHtmlToXhtml() throws Exception {

		readSource(docPath + File.separator + "output");

		System.out.println("Parse start=========================");

		for (Map.Entry<String, File> entry : files.entrySet()) {
			InputStream input = null;
			FileOutputStream outputStream = null;
			try {
				input = new FileInputStream(entry.getValue());
				String ns = entry.getKey();

				File file = new File(docPath + File.separator + "xhtml"
						+ File.separator + ns + ".html");
				if (!file.exists())
					file.createNewFile();

				outputStream = new FileOutputStream(file);
				Tidy tidy = new Tidy();
				tidy.setXHTML(true);
				tidy.parse(input, outputStream);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				input.close();
				if (outputStream != null)
					outputStream.close();
			}
		}

		System.out.println("Parse end=========================");
	}

	// 第二步 加入按钮
	public static void parseDocument() throws Exception {

		readSource(docPath + File.separator + "xhtml");

		for (Map.Entry<String, File> entry : files.entrySet()) {
			String ns = entry.getKey();

			File outFile = new File(docPath + File.separator + "output"
					+ File.separator + ns + ".html");
			if (!outFile.exists())
				outFile.createNewFile();

			OutputStream out = new FileOutputStream(outFile);
			InputStream input = new FileInputStream(entry.getValue());

			copyStream(input, out, ns);

			input.close();
			out.close();
			System.out.println("Parse docuemnt:" + outFile);
		}
	}

	// 第三步 转换为 component 组件类文件
	public static void buildJava(String clazzName, String java)
			throws Exception {
		String rpath = javaPath;
		String ns = "", name = clazzName;
		if (clazzName.indexOf(".") > 0) {
			name = clazzName.substring(clazzName.lastIndexOf(".") + 1);
			ns = clazzName.substring(0, clazzName.lastIndexOf("."));
			if (ns.indexOf(".") > 0)
				ns = ns.replace('.', File.separatorChar);
		}
		rpath = rpath + File.separator + ns.toLowerCase();
		File dir = new File(rpath);
		dir.mkdirs();

		File outFile = new File(rpath + File.separator + name + ".java");
		FileOutputStream outputStream = new FileOutputStream(outFile);

		outputStream.write(java.getBytes());

		outputStream.flush();
		outputStream.close();
	}

	private static void readSource(String path) throws Exception {

		files.clear();

		File dir = new File(path);
		if (dir.isDirectory()) {
			File[] fs = dir.listFiles();
			for (File f : fs) {
				if (!f.getName().endsWith(".html"))
					continue;

				files.put(f.getName().replaceAll(".html", ""), f);
			}
		}
	}

	private static void copyStream(InputStream is, OutputStream os, String ns)
			throws IOException {
		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(os));
		line = reader.readLine();
		while (line != null) {
			if (line.startsWith("<body>")) {
				line += "<div id=\""
						+ ns
						+ "\"><input type=\"button\" onclick=\"abner.Convert.convert('"
						+ ns + "');\" height=\"40\" value=\"ParseToJava\"/>";

				line += "<input type=\"button\" onclick=\"abner.Convert.schema('"
						+ ns + "');\" height=\"40\" value=\"GeneralScheam\"/>";
			}
			if (line.startsWith("</body>")) {
				line = "</div>" + line;
			}
			writer.println(line);
			line = reader.readLine();
		}
		writer.flush();
		if (writer != null)
			writer.close();
	}

	public static void buildXml(String name, String xml) throws Exception {
		File outFile = new File(tagPath + File.separator + name + ".tld");
		FileOutputStream outputStream = new FileOutputStream(outFile);

		outputStream.write(xml.getBytes());

		outputStream.flush();
		outputStream.close();
	}
}
