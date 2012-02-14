package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

import org.apache.commons.lang.StringEscapeUtils;

import net.sf.json.JSONFunction;

import com.abner.fence.util.AjaxJSUtils;
import com.abner.fence.util.Ext;
import com.abner.fence.util.JSUtils;

import ext.base.IExt;
import ext.event.ExtEvent;
import ext.event.ExtFunction;
import ext.util.StringUtil;

public class ExtEventRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component)
			throws IOException {
		super.encodeBegin(context, component);
		if (component instanceof ExtEvent) {
			UIComponent parent = component.getParent();
			if (parent == null || !(parent instanceof IExt))
				return;

			ExtEvent event = (ExtEvent) component;
			String name = event.getName();
			String handler = event.getHandler();
			String args = event.getArgs();
			boolean isFun = JSUtils.isFunction(handler);
			if (!isFun) {
				if (!StringUtil.isEmpty(args)) {
					handler = new JSONFunction(args.split(","), handler).toString();
				} else {
					handler = new JSONFunction(handler).toString();
				}
			}
			AjaxJSUtils.handleEvent((IExt) event.getParent(), name, handler);
		}else if(component instanceof ExtFunction){
			this.encodeFunction(context, (ExtFunction) component);
		}
	}

	private void encodeFunction(FacesContext context, ExtFunction fun) {
		String ns = fun.getNs();
		String name = fun.getName();
		String handler = fun.getHandler();
		String args = fun.getArgs();
		String var = fun.getVar();
		if(var.startsWith("j_"))
			var = "";
		
		var = StringUtil.ifEmpty(var,name);
		
		if(StringUtil.isEmpty(var))
			throw new IllegalArgumentException("the function name can not be empty.");
		
		if(!StringUtil.isEmpty(ns)){
			Ext.ns(ns);
			var = ns + "." + var;
		}
		StringBuilder sb = new StringBuilder(256);
		sb.append("var " + var + " = ");
		
		//first use the attribute
		if(StringUtil.isEmpty(handler)){
			//second use the children text;
			handler = "";
			List<UIComponent> childs = fun.getChildren();
			for(UIComponent child : childs){
				if(StringUtil.isEmpty(child))
					continue;
				
				handler += child.toString().trim();
			}
		}
		
		if(StringUtil.isEmpty(handler))
			return;
		
		boolean isFun = JSUtils.isFunction(handler);
		if (!isFun) {
			if (!StringUtil.isEmpty(args)) {
				handler = new JSONFunction(args.split(","), handler).toString();
			} else {
				handler = new JSONFunction(handler).toString();
			}
		}
		//handler = StringEscapeUtils.escapeJavaScript(handler);
		
			
		sb.append(handler);
		if(!handler.endsWith(";"))
			sb.append(";");
		JSUtils.RegisterGlobalClientScript(sb.toString());
	}

	
	@Override
	public void encodeChildren(FacesContext context, UIComponent component)
			throws IOException {
		if(component instanceof ExtFunction){
			// nothing
		}else{
			super.encodeChildren(context, component);
		}
	}

	@Override
	public boolean getRendersChildren() {
		return true;
	}
}
