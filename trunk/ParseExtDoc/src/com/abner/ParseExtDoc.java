package com.abner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.lobobrowser.html.UserAgentContext;
import org.lobobrowser.html.parser.HtmlParser;
import org.lobobrowser.html.test.SimpleUserAgentContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;

import com.abner.model.Config;
import com.abner.model.ExtClass;

public class ParseExtDoc {
	private static String docPath = "E:\\Fence\\ext-3.2.1\\docs";
	private static String sourcePath = docPath + File.separator + "output";
	private static String xhtmlpPath = docPath + File.separator + "xhtml";
	private static String outPath = "E:\\Fence\\fence\\src\\main\\java\\";
	private static String tempPath = "src/com/abner/templates";
	private static DocumentBuilder builder = null;

	public static void main(String[] args) throws Exception {
		Velocity.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, tempPath);
		Velocity.init();
		Template t = Velocity.getTemplate("clazz.vm");

		//parseHtmlToXhtml(sourcePath);
		buildJavaFiles(t, xhtmlpPath);
		genCustomComponent(t);
		collectLayout(t);
	}

	// 转换为标准的xhtml
	private static void parseHtmlToXhtml(String path) throws Exception {
		File fileDir = new File(path);
		File[] files = fileDir.listFiles(new XhtmlFileFilter());
		for (File file : files) {
			InputStream input = null;
			FileOutputStream outputStream = null;
			try {
				input = new FileInputStream(file);

				File outFile = new File(xhtmlpPath + File.separator + file.getName());
				if (!file.exists())
					file.createNewFile();

				outputStream = new FileOutputStream(outFile);
				Tidy tidy = new Tidy();
				tidy.setPrintBodyOnly(true);
				tidy.setXHTML(true);
				tidy.setForceOutput(true);
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

	private static void buildJavaFiles(Template t, String dir) throws Exception {
		File fileDir = new File(dir);
		File[] files = fileDir.listFiles();
		for (File file : files) {
			if (file.isDirectory())
				buildJavaFiles(t, file.getPath());
			if (!file.getName().startsWith("Ext"))
				continue;

			ExtClass ext = parseFileToExtClass(file, false);
			writeToJavaFile(t, ext);
		}
		System.out.println("build end=========================");
	}

	private static void collectLayout(Template t) throws Exception {
		ExtClass ext = new ExtClass();
		ext.setMode("");
		ext.setPk("com.abner.fence.component");
		ext.setInstanceOf("Ext.ExtLayout");
		ext.setClazz("ExtLayout");
		ext.setExtend("BoxComponent");
		ext.setXtype("");

		String mergeName = ExtClassHelper.getMerge(ext);
		if (mergeName != null) {
			ExtClass mergeExt = parseFileToExtClass(mergeName);
			ext.getConfigs().addAll(mergeExt.getConfigs());
		}
		
		for (Config config : ext.getConfigs()) {
			if(config.getName().equalsIgnoreCase("columns")){
				config.setType("Object");
				config.setClientConfig("@ClientConfig(value = JsonMode.Object)");
			}
		}

		writeToJavaFile(t, ext);
	}

	private static void genCustomComponent(Template t) throws Exception {
		ExtClass ext = new ExtClass();
		ext.setMode("");
		ext.setPk("com.abner.fence.component.ux");
		ext.setInstanceOf("Ext.ux.ManagedIFrame.Component");
		ext.setClazz("MifComponentAdapter");
		ext.setExtend("Panel");
		ext.setXtype("@XType(\"mif\")");
		Config cfg = new Config("autoScroll", "Boolean");
		cfg.setUpname("AutoScroll");
		cfg.setClientConfig("");
		ext.getConfigs().add(cfg);
		cfg = new Config("defaultSrc", "String");
		cfg.setClientConfig("");
		cfg.setUpname("DefaultSrc");
		ext.getConfigs().add(cfg);
		cfg = new Config("focusOnLoad", "Boolean");
		cfg.setClientConfig("");
		cfg.setUpname("FocusOnLoad");
		ext.getConfigs().add(cfg);
		cfg = new Config("frameConfig", "Object");
		cfg.setClientConfig("@ClientConfig(JsonMode.Object)");
		cfg.setUpname("FrameConfig");
		ext.getConfigs().add(cfg);
		cfg = new Config("unsupportedText", "String");
		cfg.setClientConfig("");
		cfg.setUpname("UnsupportedText");
		ext.getConfigs().add(cfg);
		cfg = new Config("useShim", "Boolean");
		cfg.setClientConfig("");
		cfg.setUpname("UseShim");
		ext.getConfigs().add(cfg);
		writeToJavaFile(t, ext);
	}

	private static void writeToJavaFile(Template t, ExtClass ext) throws Exception {
		ext.setExtend(ExtClassHelper.getExtends(ext));

		VelocityContext context = new VelocityContext();
		context.put("ext", ext);

		String path = ext.getPk().toLowerCase().replace(".", File.separator);
		if (ext.getClazz().indexOf(".") > 0) {
			String subpath = ext.getClazz().substring(0, ext.getClazz().lastIndexOf("."));
			path = path + File.separator + subpath.toLowerCase();
			ext.setPk(ext.getPk() + "." + subpath.toLowerCase());
			ext.setClazz(ext.getClazz().substring(ext.getClazz().lastIndexOf(".") + 1));
		}

		File file = new File(outPath + path);
		if (!file.exists())
			file.mkdirs();

		file = new File(outPath + path + File.separator + ext.getClazz() + ".java");

		FileWriter writer = new FileWriter(file);
		t.merge(context, writer);
		writer.close();

		System.out.println("build class " + file.getName() + " successfully.  to: " + outPath);
	}

	private static ExtClass parseFileToExtClass(String fileName) throws Exception {
		File file = new File(xhtmlpPath + File.separator + fileName + ".html");
		return parseFileToExtClass(file, true);
	}

	private static ExtClass parseFileToExtClass(File file, boolean includeParent) throws Exception {
		ExtClass ext = new ExtClass();
		Document document = getDoc(file);
		XPath xpath = XPathFactory.newInstance().newXPath();

		NodeList nodeList = getNodes(xpath, "div/div", document);
		int length = nodeList.getLength();
		for (int i = 0; i < length; i++) {
			Element element = (Element) nodeList.item(i);
			if ("description".equals(element.getAttribute("class"))) {
				StringWriter writer = new StringWriter();
				writeNode(element, writer);
				ext.setCommonts(writer.toString());
			}
		}
		// property
		nodeList = getNodes(xpath, "div/table/tr", document);
		length = nodeList.getLength();
		for (int i = 0; i < length; i++) {
			Element element = (Element) nodeList.item(i);
			NodeList tds = element.getElementsByTagName("td");
			String name = tds.item(0).getTextContent().trim();
			if (name.startsWith("Package")) {
				ext.setPk(tds.item(1).getTextContent().trim());
			} else if (name.startsWith("Class")) {
				ext.setClazz(tds.item(1).getTextContent().trim());
			} else if (name.startsWith("Extends")) {
				ext.setExtend(tds.item(1).getTextContent().trim());
			}
		}
		ext.setInstanceOf(ext.getPk() + "." + ext.getClazz());
		ext.setXtype(XtypeMap.getXtype(ext.getInstanceOf()));
		ext.setMode(BuildParseMode.getMode(ext.getInstanceOf()));
		ext.setPk(ext.getPk().toLowerCase());
		// config
		nodeList = getNodes(xpath, "div/table/tbody/tr", document);
		length = nodeList.getLength();
		Map<String, Config> cfgs = new HashMap<String, Config>();
		for (int i = 0; i < length; i++) {
			Element element = (Element) nodeList.item(i);
			String cls = element.getAttribute("class");
			NodeList tds = element.getElementsByTagName("td");
			if (tds.getLength() != 3)
				continue;

			Element td = (Element) tds.item(1);
			Element as = (Element) td.getElementsByTagName("a").item(1);
			String href = as.getAttribute("href");
			if (cls.indexOf("inherited") < 0 && href.indexOf("html#event-") > 0) {
				ext.getEvents().add(as.getTextContent().trim());
			}

			if (!element.getAttribute("class").startsWith("config-row"))
				continue;

			Config cfg = getConfig(tds);
			if (cfg == null)
				continue;
			if ("id".equalsIgnoreCase(cfg.getName()))
				continue;

			cfg.setName(cfg.getName().replaceAll("\\.", ""));

			String alias = ExtClassHelper.getAlias(ext.getPk() + "." + ext.getClazz() + "." + cfg.getName());
			if (alias != null) {
				cfg.setName(alias);
			}
			cfg.setUpname(cfg.getName());
			cfg.setUpname(cfg.getUpname().substring(0, 1).toUpperCase() + cfg.getUpname().substring(1));

			if (!cfg.getMsource().equalsIgnoreCase(ext.getClazz())) {
				if (!includeParent)
					continue;
			}

			cfgs.put(cfg.getName(), cfg);
		}
		ext.setConfigs(new ArrayList<Config>(cfgs.values()));
		String mergeName = ExtClassHelper.getMerge(ext);
		if (mergeName != null) {
			ExtClass mergeExt = parseFileToExtClass(mergeName);
			for (Config config : mergeExt.getConfigs()) {
				boolean exist = false;
				for (Config c : ext.getConfigs()) {
					if (c.getName().equals(config.getName())) {
						exist = true;
						break;
					}
				}
				if (!exist) {
					ext.getConfigs().add(config);
				}
			}
		}

		if (ext.getClazz().endsWith("Layout")) {
			String layout = ext.getClazz().replaceAll("Layout", "").toLowerCase();
			ext.setLayout("@Layout(LayoutType." + layout + ")");
		}

		// events

		return ext;
	}

	private static Config getConfig(NodeList tds) {
		Config config = new Config();
		String sig = tds.item(1).getTextContent().trim();
		String msource = tds.item(2).getTextContent();

		String[] sigs = sig.split("\n");
		String name = sigs[0];
		String type = sigs[1];

		name = name.replace("<p>The", "");

		type = type.replaceAll(":", "").trim();

		if (type.indexOf("/") > 0) {
			if (type.indexOf("Array") >= 0)
				type = "Array";
			else
				type = type.split("/")[0];
		}

		if (type.indexOf("|") > 0) {
			type = type.split("\\|")[0];
		}

		config.setName(name.trim());
		config.setMsource(msource);

		String clientConfig = "";
		if (name.trim().equals("renderTo")) {
			type = "String";
			clientConfig = "";
		} else if (name.trim().equals("bbar") || name.trim().equals("tbar")) {
			type = "Object";
			clientConfig = "@ClientConfig(JsonMode.Object)\n";
		} else if ("Mixed".equalsIgnoreCase(type)) {
			type = "Object";
			clientConfig = "@ClientConfig(JsonMode.Object)\n";
		} else if ("Object".equalsIgnoreCase(type)) {
			clientConfig = "@ClientConfig(JsonMode.Object)\n";
		} else if ("Array".equalsIgnoreCase(type)) {
			type = "Object";
			clientConfig = "@ClientConfig(JsonMode.Array)\n";
		} else if ("Function".equalsIgnoreCase(type)) {
			type = "Object";
			clientConfig = "@ClientConfig(JsonMode.Function)\n";
		} else if ("XTemplate".equalsIgnoreCase(type) || "Template".equalsIgnoreCase(type)) {
			type = "Object";
			clientConfig = "@ClientConfig(JsonMode.Object)\n";
		} else if (type.indexOf(".") > 0) {
			type = "Object";
			clientConfig = "@ClientConfig(JsonMode.Object)\n";
		} else if ("Number".equalsIgnoreCase(type)) {
			type = "Integer";
		} else if ("boolean".equalsIgnoreCase(type)) {
			type = "Boolean";
		} else if ("RegExp".equalsIgnoreCase(type)) {
			type = "String";
			clientConfig = "@ClientConfig(JsonMode.Object)\n";
		}
		if (name.equals("margins") || name.equals("cmargins")) {
			type = "String";
			clientConfig = "";
		}

		config.setClientConfig(clientConfig);
		config.setType(type);

		Element commontsEl = (Element) tds.item(1);
		NodeList msec = commontsEl.getElementsByTagName("div");
		int l = msec.getLength();
		if (l < 3)
			config.setCommonts(commontsEl.getTextContent());
		else {
			config.setCommonts(msec.item(2).getTextContent());
		}

		return config;
	}

	private static NodeList getNodes(XPath xpath, String exp, Document doc) throws Exception {
		return (NodeList) xpath.evaluate(exp, doc, XPathConstants.NODESET);
	}

	private static Document getDoc(File file) throws Exception {
		UserAgentContext uacontext = new SimpleUserAgentContext();
		Reader reader = new InputStreamReader(new FileInputStream(file));
		Document document = getBuilder().newDocument();
		HtmlParser parser = new HtmlParser(uacontext, document);
		parser.parse(reader);
		return document;
	}

	private static void writeNode(Element el, Writer writer) throws Exception {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer tformer = tf.newTransformer();
		tformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tformer.setOutputProperty(OutputKeys.INDENT, "no");
		tformer.setOutputProperty(OutputKeys.METHOD, "text");
		tformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		DOMSource source = new DOMSource(el);
		Result d = new StreamResult(writer);
		tformer.transform(source, d);
	}

	private static DocumentBuilder getBuilder() throws Exception {
		if (builder != null)
			return builder;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(false);
		builder = factory.newDocumentBuilder();
		return builder;
	}
}
