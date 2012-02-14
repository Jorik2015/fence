package com.abner.fence.docprocess;

public class Template {

	public static String classTemp(){
		return 
		"\n" + 
		"public class {0} a\n" + 
		"      {1}\n" + 
		"a";
	}
	
	public static String attributeTemp(){
		return
		"private {0} {1};\n" +
		" /**\n" + 
		"  * {1}\n" + 
		"  */\n" + 
		" public {0} get{2}() {\n" + 
		"     if (null != this.{1}) {\n" + 
		"         return this.{1};\n" + 
		"     }\n" + 
		"     ValueExpression _ve = getValueExpression(\"{1}\");\n" + 
		"     if (_ve != null) {\n" + 
		"         return ({0}) _ve.getValue(getFacesContext().getELContext());\n" + 
		"     } else {\n" + 
		"         return null;\n" + 
		"     }\n" + 
		" }\n" + 
		"\n" + 
		" /**\n" + 
		"  * <p>Set the value of the <code>{1}</code> property.</p>\n" + 
		"  */\n" + 
		" public void set{2}({0} {1}) {\n" + 
		"     this.{1} = {1};\n" + 
		"     handleAttribute(\"{1}\", {1});\n" + 
		" }";
	}
}
