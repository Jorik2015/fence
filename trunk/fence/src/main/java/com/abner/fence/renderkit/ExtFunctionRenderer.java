package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

import net.sf.json.JSONFunction;

import com.abner.fence.ajax.ExtFunction;
import com.abner.fence.component.ExtComponent;
import com.abner.fence.utils.ComponentUtils;
import com.abner.fence.utils.ExtUtils;
import com.abner.fence.utils.JSUtils;
import com.abner.fence.utils.Strings;

public class ExtFunctionRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		encodeFunction(context, (ExtFunction) component);
	}

	private void encodeFunction(FacesContext context, ExtFunction fun) {
		String ns = fun.getNs();
		String name = fun.getName();
		String handler = fun.getHandler();
		String args = fun.getArgs();
		String var = fun.getVar();
		if (var.startsWith("j_"))
			var = "";

		var = Strings.ifEmpty(var, name);

		if (Strings.isEmpty(var))
			throw new IllegalArgumentException("the function name can not be empty.");

		if (!Strings.isEmpty(ns)) {
			ExtUtils.ns(ns);
			var = ns + "." + var;
		}
		StringBuilder sb = new StringBuilder(256);
		sb.append(" = ");

		// first use the attribute
		if (Strings.isEmpty(handler)) {
			// second use the children text;
			handler = "";
			List<UIComponent> childs = fun.getChildren();
			for (UIComponent child : childs) {
				if (Strings.isEmpty(child))
					continue;

				handler += child.toString().trim();
			}
		}

		if (Strings.isEmpty(handler))
			return;

		boolean isFun = JSUtils.isFunction(handler);
		if (!isFun) {
			if (!Strings.isEmpty(args)) {
				handler = new JSONFunction(args.split(","), handler).toString();
			} else {
				handler = new JSONFunction(handler).toString();
			}
		}
		// handler = StringEscapeUtils.escapeJavaScript(handler);

		sb.append(handler);
		if (!handler.endsWith(";"))
			sb.append(";");

		UIComponent parent = fun.getParent();
		if (ComponentUtils.isHaeresNatus(fun)) {
			ExtComponent p = (ExtComponent) parent;
			p.getAfterScript().append(p.getVar() + "." + name + sb);
		} else {
			sb.insert(0, "var " + var);
			JSUtils.RegisterGlobalClientScript(sb.toString());
		}
	}

	@Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		if (component instanceof ExtFunction) {
			// nothing
		} else {
			super.encodeChildren(context, component);
		}
	}

	@Override
	public boolean getRendersChildren() {
		return true;
	}
}
