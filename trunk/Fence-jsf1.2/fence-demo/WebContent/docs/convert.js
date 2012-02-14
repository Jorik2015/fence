Ext.ns("abner");
String.prototype.endWith = function(oString) {
	var reg = new RegExp(oString + "$");
	return reg.test(this);
};

abner.Convert = function() {
	var attdata;
	return {
		schema : function(ns) {
			var div = Ext.get(ns);
			var xtype = "";
			var comment = div.query("div[class=description]")[0];
			if (comment)
				comment = comment.innerHTML;
			var parent = div.query("table:first")[0];
			var parenttrs = Ext.get(parent).query("tr");
			for ( var i = 0; i < parenttrs.length; i++) {
				var td1 = Ext.get(parenttrs[i]).query("td");
				if (td1[0].innerHTML.indexOf("Extends:") >= 0) {
					parent = Ext.get(td1[1]).query("a:first")[0];
					parent = parent ? parent.innerHTML : "ExtOutput";
				} else if (td1[0].innerHTML.indexOf("xtype:") >= 0) {
					xtype = td1[1].innerHTML;
				}
			}
			if (parent && parent.indexOf(".") > 0)
				parent = parent.substr(parent.indexOf(".") + 1);
			if (xtype.length > 0)
				xtype = "\n@XType(\"" + xtype + "\")\n";
	
			var tables = div.query('table[class=member-table]');
			var trs = new Array();
			for ( var t = 0; t < tables.length; t++) {
				var tts = Ext.get(tables[t]).query("tr[class^=config-row]");
				if (tts) {
					trs = tts;
					break;
				}
			}
			var atts = this.buildAttributeXml(trs);
			var names = ns.split(".");
			var name = names[names.length - 1].toLowerCase();
			
			var tagJson = {
				comment : comment,
				name : name,
				attributes : atts 
			};
			var xml = tagTemp.apply(tagJson);
			
			
			
			Ext.Ajax.request( {
				url : '/fence-demo/ParseToJavaServlet/',
				success : function() {},
			failure : function() {
				alert("failed");
			},
			params : {
				clazzName : ns,
				xml : xml
			}
			});
		},
		convert : function(ns) {
			var div = Ext.get(ns);
			var xtype = "";
			var comment = div.query("div[class=description]")[0];
			if (comment)
				comment = comment.innerHTML;
			var parent = div.query("table:first")[0];
			var parenttrs = Ext.get(parent).query("tr");
			for ( var i = 0; i < parenttrs.length; i++) {
				var td1 = Ext.get(parenttrs[i]).query("td");
				if (td1[0].innerHTML.indexOf("Extends:") >= 0) {
					parent = Ext.get(td1[1]).query("a:first")[0];
					parent = parent ? parent.innerHTML : "ExtOutput";
				} else if (td1[0].innerHTML.indexOf("xtype:") >= 0) {
					xtype = td1[1].innerHTML;
				}
			}
			if (parent && parent.indexOf(".") > 0)
				parent = parent.substr(parent.indexOf(".") + 1);
			if (xtype.length > 0)
				xtype = "\n@XType(\"" + xtype + "\")\n";

			var tables = div.query('table[class=member-table]');
			var trs = new Array();
			for ( var t = 0; t < tables.length; t++) {
				var tts = Ext.get(tables[t]).query("tr[class^=config-row]");
				if (tts) {
					trs = tts;
					break;
				}
			}
			var atts = this.buildAttribute(trs);
			var state = this.buildState();
			var java = this.buildClazz(xtype, ns, parent, comment, atts, state);

			if (!java || java == null)
				return;

			Ext.Ajax.request( {
				url : '/fence-demo/ParseToJavaServlet/',
				success : function() {
					// alert('ok');
			},
			failure : function() {
				alert("failed");
			},
			params : {
				clazzName : ns,
				java : java
			}
			});
		},
		buildParseMode : function(ns) {
			var temp = "@ParseConfigMode({0}pmode=PersistenceMode.{1},rmode=ReferenceMode.{2})";
			if (ns.endWith("Layout"))
				return String.format(temp, "ui = false,", "Custom", "Config");
			else if (ns.endWith("Axis"))
				return String.format(temp, "ui = false,", "Custom", "Var");
			else if (ns.endWith("Series"))
				return String.format(temp, "ui = false,name=\"series\",",
						"ParentProperty", "Var");
			else if (ns.endWith("Store"))
				return String.format(temp, "ui = false,name=\"store\",",
						"ParentProperty", "Var");
			else if (ns.endWith("Reader"))
				return String.format(temp, "ui = false,name=\"reader\",",
						"ParentProperty", "Var");
			else if (ns.endWith("Proxy"))
				return String.format(temp, "ui = false,name=\"proxy\",",
						"ParentProperty", "Var");
			else if (ns.endWith("Writer"))
				return String.format(temp, "ui = false,name=\"writer\",",
						"ParentProperty", "Var");
			else if (ns.endWith("data.Field"))
				return String.format(temp, "ui = false,", "Custom", "Config");
			else if (ns.endWith("SelectionModel"))
				return String.format(temp, "name=\"selModel\",",
						"ParentProperty", "Var");
			else if (ns.endWith("ColumnModel"))
				return String.format(temp, "ui = false,name=\"cm\",",
						"ParentProperty", "Var");
			else if (ns.endWith("Column"))
				return String.format(temp, "ui = false,name=\"columns\",",
						"ParentProperty", "Config");
			else if (ns.endWith("View"))// note
				return String.format(temp, "ui = false,name=\"view\",",
						"ParentProperty", "Var");
			else if (ns.substr(0, 8) == "Ext.menu" && ns.endWith("Item"))
				return String.format(temp, "name=\"items\",", "ParentProperty",
						"Config");
			else if (ns.substr(0, 8) == "Ext.menu" && ns.endWith("Menu"))
				return String.format(temp, "name=\"menu\",", "ParentProperty",
						"Var");
			else if (ns.substr(0, 12) == "Ext.Toolbar.")
				return String.format(temp, "name=\"items\",", "ParentProperty",
						"Config");

			return "";
		},
		buildClazz : function(xtype, ns, parent, comment, attrs, state) {
			var clazzName = ns, _package = ns, layout = "";
			if (ns.indexOf(".") > 0) {
				var sp = ns.split(".");
				clazzName = sp[sp.length - 1];
				_package = "package " + ns.substr(0, ns.lastIndexOf("."))
						+ ";\n";
			} else {
				return null;
			}
			if (clazzName.indexOf("Layout") > 0) {
				layout = clazzName.replace("Layout", "").toLowerCase();
				layout = "\n@Layout(LayoutType." + layout + ")\n";
			}
			_package = _package.toLowerCase();
			var instance = "@InstanceOf(\"" + ns + "\")";
			var parseMode = this.buildParseMode(ns);
			var clazzJson = {
				_package : _package,
				xtype : xtype,
				ns : ns,
				className : clazzName,
				parent : parent,
				comment : comment,
				attributes : attrs,
				state : state,
				layout : layout,
				instance : instance,
				parseMode : parseMode
			};
			return clazz.apply(clazzJson);
		},
		buildAttributeXml : function(trs){
			if (!trs)
				return "";
			var data = new Ext.util.MixedCollection();
			for ( var t = 0; t < trs.length; t++) {
				var ad = this.parseTrToJson(trs[t],true);
				if (ad == null)
					continue;

				data.add(ad);
			}
			attdata = data.getRange();
			var attri = {
				data : attdata
			};
			return xmlAttTemp.apply(attri);
		},
		buildAttribute : function(trs) {
			if (!trs)
				return "";
			var data = new Ext.util.MixedCollection();
			for ( var t = 0; t < trs.length; t++) {
				var ad = this.parseTrToJson(trs[t],false);
				if (ad == null)
					continue;

				data.add(ad);
			}
			attdata = data.getRange();
			var attri = {
				data : attdata
			};
			return attTemp.apply(attri);
		},
		buildState : function() {
			var saveState = "";
			var restoreState = "";
			var length = "";
			for ( var i = 0; i < attdata.length; i++) {
				saveState += oneStateTemp.apply( {
					num : i + 1,
					name : attdata[i].name
				});
			}
			for ( var i = 0; i < attdata.length; i++) {
				restoreState += oneRStateTemp.apply( {
					num : i + 1,
					name : attdata[i].name,
					type : attdata[i].type
				});
			}
			var stateJson = {
				saveState : saveState,
				restoreState : restoreState,
				length : attdata.length + 1
			};
			return stateTemp.apply(stateJson);
		},
		parseTrToJson : function(tr,extend) {
			var type, name, Nname, comment, clientConfig, parent;
			var td1 = Ext.get(tr).query("td[class=sig]")[0];
			var desc = Ext.get(td1).query("div[class=mdesc]")[0];
			var source = Ext.get(tr).query("td[class=msource]")[0];

			var dlong = desc ? Ext.get(desc).query("div[class=long]")[0]
					: false;
			comment = dlong ? dlong.innerHTML : (desc ? desc.innerHTML : "");
			comment = comment.replace("\n", "");

			var aparent = Ext.get(source).query("a:first")[0];
			if (!extend && aparent)
				return null;

			name = Ext.get(td1).query("a:first")[0].id.split("-")[1];
			name = name.replace(".", "");
			Nname = name.substr(0, 1).toUpperCase() + name.substr(1);
			type = td1.childNodes[2].nodeValue;
			type = type.replace(":", "").trim();

			if (type.indexOf("/") > 0) {
				if (type.indexOf("Array") > 0)
					type = "Array";
				else
					type = type.split("/")[0];
			}

			clientConfig = "";
			if (type == "Mixed") {
				type = "Object";
				clientConfig = "@ClientConfig(JsonMode.Object)\n";
			} else if (type == "Object") {
				clientConfig = "@ClientConfig(JsonMode.Object)\n";
			} else if ("Array" == type) {
				type = "Object";
				clientConfig = "@ClientConfig(JsonMode.Array)\n";
			} else if ("Function" == type) {
				type = "Object";
				clientConfig = "@ClientConfig(JsonMode.Function)\n";
			} else if ("XTemplate" == type || "Template" == type) {
				type = "Object";
				clientConfig = "@ClientConfig(JsonMode.Object)\n";
			} else if (type.indexOf(".") > 0) {
				type = "Object";
				clientConfig = "@ClientConfig(JsonMode.Object)\n";
			} else if ("Number" == type) {
				type = "Integer";
			} else if ("boolean" == type) {
				type = "Boolean";
			} else if ("RegExp" == type) {
				type = "String";
				clientConfig = "@ClientConfig(JsonMode.Object)\n";
			}

			return {
				type : type,
				name : name,
				Nname : Nname,
				comment : comment,
				clientConfig : clientConfig
			};
		}
	};
}();

var oneStateTemp = new Ext.Template("_values[{num}] = {name};\n");
var oneRStateTemp = new Ext.Template(
		"this.{name} = ({type}) _values[{num}];\n this.handleConfig(\"{name}\",this.{name});\n");

var stateTemp = new Ext.XTemplate("private Object[] _values;\n", "\n",
		"public Object saveState(FacesContext _context) {\n",
		"  if (_values == null) {\n",
		"      _values = new Object[{length}];\n", "  }\n",
		"  _values[0] = super.saveState(_context);\n", "  {saveState}\n",
		"return _values;\n", "}\n", "\n",
		"public void restoreState(FacesContext _context, Object _state) {\n",
		"      _values = (Object[]) _state;\n",
		"      super.restoreState(_context, _values[0]);\n",
		"      {restoreState}\n", "}");

var xmlAttTemp = new Ext.XTemplate(
		'<tpl for="data">',
		"<attribute>",
		"	<description>",
        "        <![CDATA[{comment}]]>",
        "    </description>",
		"	<name>{name}</name>",
		"	<required>false</required>",
		"</attribute>",
		"</tpl>");

var tagTemp = new Ext.XTemplate(
		"<tag>",
		"<description>",
        "    <![CDATA[{comment}]]>",
        "</description>",
		"<name>{name}</name>",
		"<tag-class></tag-class>",
		"<body-content>JSP</body-content>",
		"{attributes}",
		"</tag>");
// {0} -----type
// {1} -----name
// {2} -----Name
// {3} -----comment
// {4} -----clientConfig
var attTemp = new Ext.XTemplate(
		'<tpl for="data">',
		"\n private {type} {name};\n",
		" /**\n",
		"  * {comment}\n",
		"  */\n",
		" {clientConfig}",
		" public {type} get{Nname}() {\n",
		"     if (null != this.{name}) {\n",
		"         return this.{name};\n",
		"     }\n",
		"     ValueExpression _ve = getValueExpression(\"{name}\");\n",
		"     if (_ve != null) {\n",
		"         return ({type}) _ve.getValue(getFacesContext().getELContext());\n",
		"     } else {\n", "         return null;\n", "     }\n", " }\n", "\n",
		" /**\n",
		"  * <p>Set the value of the <code>{name}</code> property.</p>\n",
		"  */\n", " public void set{Nname}({type} {name}) {\n",
		"     this.{name} = {name};\n",
		"     this.handleConfig(\"{name}\", {name});\n", " }\n", "</tpl>");

var clazz = new Ext.Template(
		"{_package}\n",

		"import javax.el.ValueExpression;\n",
		"import javax.faces.context.FacesContext;\n",

		"import ext.*;\n",
		"import ext.chart.*;\n",
		"import ext.data.*;\n",
		"import ext.dd.*;\n",
		"import ext.direct.*;\n",
		"import ext.form.*;\n",
		"import ext.grid.*;\n",
		"import ext.menu.*;\n",
		"import ext.tree.*;\n",
		"import ext.util.*;\n",
		"import ext.annotation.*;\n",
		"import ext.base.*;\n",
		"import java.util.Date;\n",
		"\n/**",
		"\n*Note:This java code is auto generated by abner,do not edit it.",
		"\n* {comment}",
		"\n*/",
		"{xtype}",
		"{layout}",
		"\n{instance}",
		"\n{parseMode}",
		'\npublic class {className} extends {parent}{',

		"\npublic static final String COMPONENT_TYPE = \"{ns}\";",
		"\npublic static final String COMPONENT_FAMILY = \"{ns}\";",

		"/**\n",
		" * <p>Create a new {@link {className}} instance with default property\n",
		" * values.</p>\n", " */\n", "public {className}() {\n",
		"    super();\n", "    setRendererType(COMPONENT_FAMILY);\n", "}\n",

		"public String getFamily() {\n", "    return (COMPONENT_FAMILY);\n",
		"}\n",

		'{attributes}', '{state}\n', '}');
