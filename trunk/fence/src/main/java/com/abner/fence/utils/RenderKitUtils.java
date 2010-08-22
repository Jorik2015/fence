package com.abner.fence.utils;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.component.UIViewRoot;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.component.behavior.ClientBehaviorContext.Parameter;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.abner.fence.ajax.ExtAjaxBehavior;
import com.abner.fence.commons.ExtComponentMetaData;
import com.abner.fence.commons.Enums.ButtonType;
import com.abner.fence.commons.Enums.ReferenceMode;
import com.abner.fence.component.ExtCommand;
import com.abner.fence.component.ExtComponent;
import com.abner.fence.component.ScriptManager;
import com.abner.fence.web.RequestContext;
import com.abner.fence.web.ScriptReository;

import ext.Action;
import ext.form.FormPanel;
import ext.form.Hidden;

public final class RenderKitUtils {

	public static void writePageScript(ResponseWriter writer) throws IOException {
		ScriptReository sr = JSUtils.getScriptReository();
		if (sr == null || sr.isEmpty())
			return;

		StringBuilder builder = getAjaxHeaderScript(sr.getGlobalVar());

		List<String> scripts = sr.getScriptGlobalClientInitBag();
		for (String s : scripts) {
			builder.append(s.trim() + "\n");
		}

		StringBuffer initScript = new StringBuffer(265);

		scripts = sr.getScriptBeforeClientInitBag();
		for (String s : scripts) {
			initScript.append(s.trim() + "\n");
		}

		scripts = sr.getScriptClientInitBag();
		for (String s : scripts) {
			initScript.append(s.trim() + "\n");
		}

		scripts = sr.getScriptAfterClientInitBag();
		for (String s : scripts) {
			initScript.append(s.trim() + "\n");
		}

		builder.append(initScript);
		writer.write(builder.toString());
	}

	private static StringBuilder getAjaxHeaderScript(String globarVar) {
		StringBuilder builder = new StringBuilder(265);

		builder.append("var ajax_vars = new Ext.util.MixedCollection();");
		builder.append("ajax_vars.addAll('");
		builder.append(globarVar);
		builder.append("'.split(','));");
		builder.append("ajax_vars.each(function(item){");
		builder.append("	if(typeof eval(item) == 'undefined'){eval('var ' + item);}");
		builder.append("});\n");

		return builder;
	}

	public static void renderBehaviors(FacesContext context, ExtComponent component) throws IOException {
		if (!(component instanceof ClientBehaviorHolder))
			return;
		
		renderJsfJs_(context);
		
		if (component instanceof ExtCommand)
			renderBehaviorHandler(context, component, "click");

		ClientBehaviorHolder bHolder = (ClientBehaviorHolder) component;
		Map<String, List<ClientBehavior>> behaviors = bHolder.getClientBehaviors();
		if (behaviors != null && !behaviors.isEmpty()) {
			for (Map.Entry<String, List<ClientBehavior>> bs : behaviors.entrySet()) {
				if ("click".equals(bs.getKey()) && component instanceof ExtCommand)
					continue;

				renderBehaviorHandler(context, component, bs.getKey());
			}
		}
	}

	private static void renderBehaviorHandler(FacesContext context, ExtComponent component, String behaviorEventName)
			throws IOException {

		List<ExtAjaxBehavior> behaviors = getClientBehaviors(component, behaviorEventName);

		if ((null != behaviors) && (behaviors.size() > 0) && Utils.componentIsDisabled(component)) {
			behaviors = null;
		}

		Collection<ClientBehaviorContext.Parameter> params = getBehaviorParameters(component);
		Collection<ClientBehaviorContext.Parameter> hiddens = getBehaviorHiddens(component);
		if (params == null) {
			params = Collections.emptyList();
		}
		if (hiddens == null) {
			hiddens = Collections.emptyList();
		}
		StringBuilder handler = null;
		if ("click".equals(behaviorEventName) && component instanceof ExtCommand) {
			handler = getClickRequestHandler(context, component, behaviors, params, hiddens, behaviorEventName);
			if (Strings.isEmpty(handler))
				return;

			if (component.getClass().equals(Action.class)) {
				component.handleConfig("handler", handler);
			} else {
				String var = getEventVar(component);
				var = MessageFormat.format(ScriptManager.ADDLISTENER_TEMP, var, behaviorEventName, handler);
				JSUtils.RegisterAfterClientInitScript(var);
			}
		} else {
			handler = getBehaviorRequestHandler(context, component, behaviors, params, hiddens, behaviorEventName);
			String var = getEventVar(component);
			var = MessageFormat.format(ScriptManager.ADDLISTENER_TEMP, var, behaviorEventName, handler);
			JSUtils.RegisterAfterClientInitScript(var);
		}
	}

	private static StringBuilder getClickRequestHandler(FacesContext context, ExtComponent component,
			List<ExtAjaxBehavior> behaviors, Collection<ClientBehaviorContext.Parameter> params,
			Collection<ClientBehaviorContext.Parameter> hiddens, String behaviorEventName) {

		ButtonType type = getButtonType(component);

		if (ButtonType.RESET == type)
			return getResetHandler(context, component, behaviors, params, hiddens, behaviorEventName);

		String args = getArgs(component, behaviors);

		StringBuilder handler = new StringBuilder(256);
		HandlerType handlerType = getHandlerType(context, component, behaviors, params, hiddens, behaviorEventName,
				type);
		switch (handlerType) {
		case SUBMIT_ONLY:
			handler = getSubmitHandler(context, component, behaviors, params, hiddens, behaviorEventName, type, args);
			break;
		case CLICK_CHAIN:
			handler = getClickChainedHandler(context, component, behaviors, params, hiddens, behaviorEventName, type);
			break;
		case CLICK_ONLY:
			handler = getClickOnlyHandler(context, component, behaviors, params, hiddens, behaviorEventName, type, args);
			break;
		case NONE:
			break;
		default:
			assert (false);
		}

		return handler;
	}

	private static StringBuilder getBehaviorRequestHandler(FacesContext context, ExtComponent component,
			List<ExtAjaxBehavior> behaviors, Collection<Parameter> params, Collection<Parameter> hiddens,
			String behaviorEventName) {
		String args = getArgs(component, behaviors);
		StringBuilder handler = new StringBuilder(100);
		HandlerType handlerType = getHandlerType(context, component, behaviors, params, hiddens, behaviorEventName,
				ButtonType.NONE);
		switch (handlerType) {
		case BEHAVIOR_HANDLER_ONLY:
			handler = getBehaviorHandlerOnly(context, component, behaviors, params, hiddens, behaviorEventName, args);
			break;
		case SINGLE_BEHAVIOR_ONLY:
			handler = getSingleBehaviorHandler(context, component, behaviors, params, hiddens, behaviorEventName, args);
			break;
		case HANDLER_BEHAVIOR:
			handler = getHandlerBehaviorRequestHandler(context, component, behaviors, params, hiddens,
					behaviorEventName, args);
			break;
		case NONE:
			break;
		default:
			assert (false);
		}

		return handler;
	}

	private static StringBuilder getSingleBehaviorHandler(FacesContext context, ExtComponent component,
			List<ExtAjaxBehavior> behaviors, Collection<Parameter> params, Collection<Parameter> hiddens,
			String behaviorEventName, String args) {
		String sourceId = component.getClientId(context);

		ExtAjaxBehavior behavior = null;
		for (ExtAjaxBehavior bh : behaviors) {
			if (bh.isSubmitting()) {
				behavior = bh;
				break;
			}
		}

		assert behavior != null;

		ClientBehaviorContext bContext = createClientBehaviorContext(context, component, behaviorEventName, sourceId,
				params);

		StringBuilder builder = new StringBuilder(256);
		builder.append(behavior.getScript(bContext));
		return builder;
	}

	private static StringBuilder getBehaviorHandlerOnly(FacesContext context, ExtComponent component,
			List<ExtAjaxBehavior> behaviors, Collection<Parameter> params, Collection<Parameter> hiddens,
			String behaviorEventName, String args) {
		if (behaviors == null || behaviors.isEmpty())
			return null;

		ExtAjaxBehavior behavior = behaviors.get(0);
		String handler = behavior.getHandler();
		if (!JSUtils.isFunction(handler)) {
			handler = MessageFormat.format(ScriptManager.FunctionTemplateWithParams, args, handler);
		}

		return new StringBuilder(handler);
	}

	private static StringBuilder getHandlerBehaviorRequestHandler(FacesContext context, ExtComponent component,
			List<ExtAjaxBehavior> behaviors, Collection<Parameter> params, Collection<Parameter> hiddens,
			String behaviorEventName, String args) {
		FormPanel form = RenderKitUtils.getFormPanel(component);
		if (form == null) {
			form = getContextFormPanel(context.getViewRoot());
		}

		StringBuilder handler = new StringBuilder(256);
		appendUserHandlerToChain(handler, component, behaviors, behaviorEventName);
		String sourceId = component.getClientId(context);
		appendBehaviorsToChain(handler, context, component, behaviors, behaviorEventName, sourceId, params);

		// need ?
		if (form == null)
			throw new IllegalArgumentException("the formpanel is must exist in this page." + component);

		StringBuilder builder = new StringBuilder(256);
		if (handler.length() > 0) {
			builder.append("function(" + args + "){");
			builder.append("Fence.chain(");
			builder.append(Strings.ifEmpty(args, "''") + ",");
			builder.append(handler);
			builder.append(");}");
		}
		return builder;
	}

	private static StringBuilder getClickChainedHandler(FacesContext context, ExtComponent component,
			List<ExtAjaxBehavior> behaviors, Collection<Parameter> params, Collection<Parameter> hiddens,
			String behaviorEventName, ButtonType type) {
		FormPanel form = RenderKitUtils.getFormPanel(component);
		if (form == null) {
			form = getContextFormPanel(context.getViewRoot());
		}

		StringBuilder handler = new StringBuilder(256);

		String args = getArgs(component, behaviors);

		appendUserHandlerToChain(handler, component, behaviors, behaviorEventName);

		String sourceId = component.getClientId(context);

		boolean submitting = appendBehaviorsToChain(handler, context, component, behaviors, behaviorEventName,
				sourceId, params);

		boolean needForm = submitting;

		boolean needSubmit = isSubmittingCommand(component, behaviors, type);

		if (!submitting && needSubmit) {
			needForm = true;
			appendFunctionToChain(handler, getSubmitHandler(context, component, behaviors, params, hiddens,
					behaviorEventName, type, args).toString());
		}

		// need ?
		if (form == null && needForm)
			throw new IllegalArgumentException("the formpanel is must exist in this page." + component);

		StringBuilder builder = new StringBuilder(256);
		if (handler.length() > 0) {
			builder.append("function(" + args + "){");
			builder.append("Fence.chain(");
			builder.append(Strings.ifEmpty(args, "''") + ",");
			builder.append(handler);
			builder.append(");}");
		}
		return builder;
	}

	private static StringBuilder getSubmitHandler(FacesContext context, ExtComponent component,
			List<ExtAjaxBehavior> behaviors, Collection<Parameter> params, Collection<Parameter> hiddens,
			String behaviorEventName, ButtonType type, String args) {

		FormPanel form = RenderKitUtils.getFormPanel(component);
		if (form == null) {
			form = getContextFormPanel(context.getViewRoot());
		}

		StringBuilder builder = new StringBuilder(256);
		if (isSubmittingCommand(component, behaviors, type)) {
			ExtAjaxBehavior behavior = null;
			if (behaviors != null)
				behavior = behaviors.get(0);
			String onevent = null, onerror = null;
			if (behavior != null) {
				onevent = behavior.getOnevent();
				onerror = behavior.getOnerror();
			}

			builder.append("function(" + args + "){");
			builder.append("Fence.request({");
			appendProperty(builder, "source", getEventVar(component), false);
			appendProperty(builder, "formpanel", form == null ? null : form.getVar(), false);
			appendProperty(builder, "eventType", behaviorEventName);

			if (onevent != null)
				appendProperty(builder, "onevent", onevent, false);

			if (onerror != null)
				appendProperty(builder, "onerror", onerror, false);

			appendParamsToOptions(builder, behavior, component, params, hiddens);
			builder.append("})}");
		}
		return builder;
	}

	private static StringBuilder getClickOnlyHandler(FacesContext context, ExtComponent component,
			List<ExtAjaxBehavior> behaviors, Collection<Parameter> params, Collection<Parameter> hiddens,
			String behaviorEventName, ButtonType type, String args) {
		Object userHandler = null;
		userHandler = component.getAttributes().get("handler");
		userHandler = getNonEmptyUserHandler(userHandler);
		if (userHandler != null) {
			component.handleConfig("handler", null);
			if (!JSUtils.isFunction(userHandler.toString())) {
				userHandler = MessageFormat.format(ScriptManager.FunctionTemplateWithParams, "", userHandler);
			}
			return new StringBuilder(userHandler.toString());
		}

		if (behaviors != null) {
			for (ExtAjaxBehavior bh : behaviors) {
				String handler = getNonEmptyUserHandler(bh.getHandler());
				if (Strings.isEmpty(handler))
					continue;

				if (!JSUtils.isFunction(handler)) {
					handler = MessageFormat.format(ScriptManager.FunctionTemplateWithParams, "", handler);
				}
				return new StringBuilder(handler);
			}
		}
		return new StringBuilder();
	}

	private static StringBuilder getResetHandler(FacesContext context, ExtComponent component,
			List<ExtAjaxBehavior> behaviors, Collection<ClientBehaviorContext.Parameter> params,
			Collection<ClientBehaviorContext.Parameter> hiddens, String behaviorEventName) {
		StringBuilder builder = new StringBuilder(100);
		FormPanel form = RenderKitUtils.getFormPanel(component);
		builder.append("function(src,e){");
		if (form != null) {
			builder.append(form.getVar());
			builder.append(".getForm().reset();");
		}
		builder.append("}");
		return builder;
	}

	private static void appendUserHandlerToChain(StringBuilder builder, ExtComponent component,
			List<ExtAjaxBehavior> behaviors, String behaviorEventName) {
		Object userHandler = null;
		if ("click".equals(behaviorEventName)) {
			userHandler = component.getAttributes().get("handler");
			userHandler = getNonEmptyUserHandler(userHandler);
			if (userHandler != null) {
				component.handleConfig("handler", null);
				if (!JSUtils.isFunction(userHandler.toString())) {
					userHandler = MessageFormat.format(ScriptManager.FunctionTemplateWithParams, "", userHandler);
				}
				appendFunctionToChain(builder, userHandler.toString());
			}
		}

		if (behaviors == null)
			return;

		for (ExtAjaxBehavior bh : behaviors) {
			String handler = getNonEmptyUserHandler(bh.getHandler());
			if (Strings.isEmpty(handler))
				continue;

			if (!JSUtils.isFunction(handler)) {
				handler = MessageFormat.format(ScriptManager.FunctionTemplateWithParams, "", handler);
			}
			appendFunctionToChain(builder, handler);
		}
	}

	private static List<ExtAjaxBehavior> getClientBehaviors(ExtComponent component, String behaviorEventName) {
		if (component instanceof ClientBehaviorHolder) {
			ClientBehaviorHolder bHolder = (ClientBehaviorHolder) component;
			Map<String, List<ClientBehavior>> behaviors = bHolder.getClientBehaviors();
			List<ExtAjaxBehavior> result = null;
			if (null != behaviors && !behaviors.isEmpty()) {
				result = new ArrayList<ExtAjaxBehavior>();
				List<ClientBehavior> bs = behaviors.get(behaviorEventName);
				if (bs == null || bs.isEmpty())
					return null;

				for (ClientBehavior b : bs) {
					result.add((ExtAjaxBehavior) b);
				}
				return result;
			}
		}

		return null;
	}

	public static FormPanel getFormPanel(ExtComponent component) {
		UIComponent parent = component.getParent();
		while (parent != null) {
			if (parent instanceof FormPanel) {
				break;
			}
			parent = parent.getParent();
		}

		FormPanel form = (FormPanel) parent;
		if (form != null) {
			return form;
		}

		return null;
	}

	public static FormPanel getContextFormPanel(UIComponent root) {
		if (root instanceof FormPanel) {
			return (FormPanel) root;
		}
		int count = root.getChildCount();
		if (count > 0) {
			List<UIComponent> childs = root.getChildren();
			for (UIComponent child : childs) {
				if (child instanceof FormPanel) {
					return (FormPanel) child;
				} else {
					UIComponent comp = getContextFormPanel(child);
					if (comp instanceof FormPanel) {
						return (FormPanel) comp;
					}
				}
			}
		}
		return null;
	}

	private static String getNonEmptyUserHandler(Object handlerObject) {
		String handler = null;
		if (null != handlerObject) {
			handler = handlerObject.toString();
			handler = handler.trim();

			if (handler.length() == 0)
				handler = null;
		}

		return handler;
	}

	public static boolean isPartialOrBehaviorAction(FacesContext context, String clientId) {
		if ((clientId == null) || (clientId.length() == 0)) {
			return false;
		}

		ExternalContext external = context.getExternalContext();
		Map<String, String> params = external.getRequestParameterMap();

		String source = params.get("javax.faces.source");
		if (!clientId.equals(source)) {
			return false;
		}

		String behaviorEvent = params.get("javax.faces.behavior.event");
		if (null != behaviorEvent) {
			return ("click".equals(behaviorEvent));
		}

		String partialEvent = params.get("javax.faces.partial.event");

		return ("click".equals(partialEvent));
	}

	public static void renderJsfJs_(FacesContext context) throws IOException {

		if (hasScriptBeenRendered(context)) {
			return;
		}

		final String name = "jsf.js";
		final String library = "javax.faces";

		if (hasResourceBeenInstalled(context, name, library)) {
			setScriptAsRendered(context);
			return;
		}
		ResourceHandler handler = context.getApplication().getResourceHandler();
		Resource resource = handler.createResource(name, library);
		ResponseWriter writer = context.getResponseWriter();
		writer.write('\n');
		writer.startElement("script", null);
		writer.writeAttribute("type", "text/javascript", null);
		writer.writeAttribute("src", ((resource != null) ? resource.getRequestPath() : ""), null);
		writer.endElement("script");
		writer.append('\r');
		writer.append('\n');

		// Set the context to record script as included
		setScriptAsRendered(context);
	}

	public static boolean hasScriptBeenRendered(FacesContext context) {
		return RequestContext.instance(context).get(JSUtils.JSF_SCRIPT_STATE) != null;
	}

	public static void setScriptAsRendered(FacesContext context) {
		RequestContext.instance(context).put(JSUtils.JSF_SCRIPT_STATE, Boolean.TRUE);
	}

	public static boolean hasResourceBeenInstalled(FacesContext ctx, String name, String library) {
		UIViewRoot viewRoot = ctx.getViewRoot();
		ListIterator<UIComponent> iter = (viewRoot.getComponentResources(ctx, "head")).listIterator();
		while (iter.hasNext()) {
			UIComponent resource = (UIComponent) iter.next();
			String rname = (String) resource.getAttributes().get("name");
			String rlibrary = (String) resource.getAttributes().get("library");
			if (name.equals(rname) && library.equals(rlibrary)) {
				// Set the context to record script as included
				return true;
			}
		}
		iter = (viewRoot.getComponentResources(ctx, "body")).listIterator();
		while (iter.hasNext()) {
			UIComponent resource = (UIComponent) iter.next();
			String rname = (String) resource.getAttributes().get("name");
			String rlibrary = (String) resource.getAttributes().get("library");
			if (name.equals(rname) && library.equals(rlibrary)) {
				// Set the context to record script as included
				return true;
			}
		}
		iter = (viewRoot.getComponentResources(ctx, "form")).listIterator();
		while (iter.hasNext()) {
			UIComponent resource = (UIComponent) iter.next();
			String rname = (String) resource.getAttributes().get("name");
			String rlibrary = (String) resource.getAttributes().get("library");
			if (name.equals(rname) && library.equals(rlibrary)) {
				// Set the context to record script as included
				return true;
			}
		}

		return false;

	}

	// Creates a ClientBehaviorContext with the specified properties.
	private static ClientBehaviorContext createClientBehaviorContext(FacesContext context, UIComponent component,
			String behaviorEventName, String sourceId, Collection<ClientBehaviorContext.Parameter> params) {

		return ClientBehaviorContext.createClientBehaviorContext(context, component, behaviorEventName, sourceId,
				params);
	}

	public static void appendParamsToOptions(StringBuilder builder, ExtAjaxBehavior behavior, ExtComponent component,
			Collection<ClientBehaviorContext.Parameter> params, Collection<ClientBehaviorContext.Parameter> hiddens) {
		String render = null ,execute = null;
		if (component instanceof ExtCommand) {
			ExtCommand command = (ExtCommand) component;
			render = command.getRender();
		}
		Collection<String> renders = new ArrayList<String>();
		if (behavior != null) {
			Collection<String> bRender = behavior.getRender();
			for (String br : bRender) {
				renders.add(br);
			}
		}

		if (render != null) {
			String[] rs = render.split(" ");
			for (String r : rs) {
				renders.add(r);
			}
		}

		Collection<String> executes = new ArrayList<String>();
		if (behavior != null) {
			Collection<String> bexe = behavior.getExecute();
			for (String be : bexe) {
				executes.add(be);
			}
		}
		
		if (execute != null) {
			String[] rs = execute.split(" ");
			for (String r : rs) {
				executes.add(r);
			}
		}

		StringBuilder script = new StringBuilder(256);
		if (!params.isEmpty() || !hiddens.isEmpty() || !renders.isEmpty() || !executes.isEmpty()) {
			script.append("{");
			if (!params.isEmpty()) {
				for (ClientBehaviorContext.Parameter param : params) {
					appendProperty(script, param.getName(), param.getValue());
				}
			}
			if (!hiddens.isEmpty()) {
				for (ClientBehaviorContext.Parameter hidden : hiddens) {
					appendProperty(script, hidden.getName(), hidden.getValue(), false);
				}
			}

			if (!renders.isEmpty()) {
				String[] rs = new String[renders.size()];
				int i = 0;
				for (Iterator<String> iter = renders.iterator(); iter.hasNext();) {
					String id = iter.next();
					if (id.equals("@all") || id.equals("@none") || id.equals("@form") || id.equals("@this")) {
						rs[i] = id;
					} else {
						rs[i] = ComponentUtils.getResolvedId(component, id);
					}
					i++;
				}
				appendProperty(script, "render", Strings.join(" ", rs));
			}

			if (!executes.isEmpty()) {
				String[] es = new String[executes.size()];
				int i = 0;
				for (Iterator<String> iter = executes.iterator(); iter.hasNext();) {
					String id = iter.next();
					if (id.equals("@all") || id.equals("@none") || id.equals("@form") || id.equals("@this")) {
						es[i] = id;
					} else {
						es[i] = ComponentUtils.getResolvedId(component, id);
					}
					i++;
				}
				appendProperty(script, "execute", Strings.join(" ", es));
			}

			script.append("}");

			appendProperty(builder, "params", script, false);
		}
	}

	private static void appendFunctionToChain(StringBuilder builder, String script) {

		if ((script == null) || (script.length() == 0)) {
			return;
		}

		if (builder.length() > 0 && builder.charAt(builder.length() - 1) != ',')
			builder.append(',');

		builder.append(script);
	}

	public static void appendProperty(StringBuilder builder, String name, Object value) {
		appendProperty(builder, name, value, true);
	}

	public static void appendProperty(StringBuilder builder, String name, Object value, boolean quoteValue) {

		if ((null == name) || (name.length() == 0))
			throw new IllegalArgumentException();

		char lastChar = builder.charAt(builder.length() - 1);
		if ((lastChar != ',') && (lastChar != '{'))
			builder.append(',');

		RenderKitUtils.appendQuotedValue(builder, name);
		builder.append(":");

		if (value == null) {
			builder.append("''");
		} else if (quoteValue) {
			RenderKitUtils.appendQuotedValue(builder, value.toString());
		} else {
			builder.append(value.toString());
		}
	}

	// Append a script to the chain, escaping any single quotes, since
	// our script content is itself nested within single quotes.
	private static void appendQuotedValue(StringBuilder builder, String script) {

		builder.append("'");

		int length = script.length();

		for (int i = 0; i < length; i++) {
			char c = script.charAt(i);

			if (c == '\'' || c == '\\') {
				builder.append('\\');
			}

			builder.append(c);
		}

		builder.append("'");
	}

	// Appends one or more behavior scripts a jsf.util.chain() call
	private static boolean appendBehaviorsToChain(StringBuilder builder, FacesContext context, UIComponent component,
			List<ExtAjaxBehavior> behaviors, String behaviorEventName, String sourceId,
			Collection<ClientBehaviorContext.Parameter> params) {

		if ((behaviors == null) || (behaviors.isEmpty())) {
			return false;
		}

		ClientBehaviorContext bContext = createClientBehaviorContext(context, component, behaviorEventName, sourceId,
				params);

		boolean submitting = false;

		for (ExtAjaxBehavior behavior : behaviors) {
			String script = behavior.getScript(bContext);
			if ((script != null) && (script.length() > 0)) {
				appendFunctionToChain(builder, script);
				if (behavior.isSubmitting())
					submitting = true;
			}
		}

		return submitting;
	}

	public static Collection<ClientBehaviorContext.Parameter> getBehaviorParameters(UIComponent command) {
		ArrayList<ClientBehaviorContext.Parameter> params = null;
		int childCount = command.getChildCount();

		if (childCount > 0) {

			for (UIComponent kid : command.getChildren()) {
				if (kid instanceof UIParameter) {
					UIParameter uiParam = (UIParameter) kid;
					String name = uiParam.getName();
					Object value = uiParam.getValue();

					if ((name != null) && (name.length() > 0)) {

						if (params == null) {
							params = new ArrayList<ClientBehaviorContext.Parameter>(childCount);
						}

						params.add(new ClientBehaviorContext.Parameter(name, value));
					}
				}
			}
		}

		return (params == null) ? Collections.<ClientBehaviorContext.Parameter> emptyList() : params;
	}

	public static Collection<ClientBehaviorContext.Parameter> getBehaviorHiddens(UIComponent command) {
		ArrayList<ClientBehaviorContext.Parameter> params = null;
		int childCount = command.getChildCount();

		if (childCount > 0) {
			for (UIComponent kid : command.getChildren()) {
				if (kid instanceof Hidden) {
					Hidden hidden = (Hidden) kid;
					String name = hidden.getName();
					name = name == null ? hidden.getClientId(FacesUtils.context()) : name;
					if (params == null) {
						params = new ArrayList<ClientBehaviorContext.Parameter>(childCount);
					}
					String value = hidden.getVar() + ".getValue()";
					params.add(new ClientBehaviorContext.Parameter(name, value));
				}
				if (kid instanceof HtmlInputHidden) {
					HtmlInputHidden hidden = (HtmlInputHidden) kid;
					String name = (String) hidden.getAttributes().get("name");
					String id = hidden.getId();
					if (id == null)
						throw new IllegalArgumentException("you must set the id property when use as a param.");

					if (params == null) {
						params = new ArrayList<ClientBehaviorContext.Parameter>(childCount);
					}
					name = name == null ? id : name;
					String value = "Ext.getDom('" + id + "').value";
					params.add(new ClientBehaviorContext.Parameter(name, value));
				}
			}
		}

		return (params == null) ? Collections.<ClientBehaviorContext.Parameter> emptyList() : params;
	}

	public static String getEventVar(ExtComponent component) {
		ExtComponentMetaData metadata = ComponentUtils.getMetadata(component);
		String var = component.getVar();
		if (metadata != null && metadata.getRmode() == ReferenceMode.Config) {
			var = "Ext.getCmp('" + var + "')";
		}
		return var;
	}

	public static ButtonType getButtonType(UIComponent component) {
		if (!(component instanceof ExtCommand))
			return ButtonType.NONE;

		String type = (String) component.getAttributes().get("type");
		if (type == null
				|| (!"reset".equals(type) && !"submit".equals(type) && !"button".equals(type) && !"load".equals(type))) {
			type = "button";// for ext,default is button
			component.getAttributes().put("type", type);
		}
		if ("reset".equals(type))
			return ButtonType.RESET;
		else if ("submit".equals(type)) {
			return ButtonType.SUBMIT;
		} else if ("load".equals(type)) {
			return ButtonType.LOAD;
		} else {
			return ButtonType.BUTTON;
		}
	}

	private static HandlerType getHandlerType(FacesContext context, ExtComponent component,
			List<ExtAjaxBehavior> behaviors, Collection<ClientBehaviorContext.Parameter> params,
			Collection<ClientBehaviorContext.Parameter> hiddens, String behaviorEventName, ButtonType type) {

		List<String> handlers = new ArrayList<String>();
		if ("click".equals(behaviorEventName) && component instanceof ExtCommand) {
			Object userHandler = null;
			userHandler = component.getAttributes().get("handler");
			if (userHandler != null)
				handlers.add(userHandler.toString());

			if ((behaviors != null) && !(behaviors.isEmpty())) {
				for (ExtAjaxBehavior behavior : behaviors) {
					String bhHandler = behavior.getHandler();
					if (Strings.isNotEmpty(bhHandler))
						handlers.add(bhHandler);
				}
			}

			boolean isSubmit = isSubmittingCommand(component, behaviors, type);
			if (handlers.isEmpty() && isSubmit)
				return HandlerType.SUBMIT_ONLY;

			if (handlers.isEmpty() && !isSubmit)
				return HandlerType.NONE;

			if (!isSubmit && handlers.size() == 1)
				return HandlerType.CLICK_ONLY;

			return HandlerType.CLICK_CHAIN;
		} else {
			if (behaviors == null)
				return HandlerType.NONE;
			if (behaviors.size() > 1)
				throw new IllegalArgumentException("the same event only appear once in one extbehaviorholder.");

			ExtAjaxBehavior behavior = behaviors.get(0);

			if (Strings.isEmpty(behavior.getHandler()) && behavior.isSubmitting())
				return HandlerType.SINGLE_BEHAVIOR_ONLY;

			if (Strings.isEmpty(behavior.getHandler()) && !behavior.isSubmitting())
				return HandlerType.NONE;

			if (Strings.isNotEmpty(behavior.getHandler()) && !behavior.isSubmitting())
				return HandlerType.BEHAVIOR_HANDLER_ONLY;

			return HandlerType.HANDLER_BEHAVIOR;
		}

	}

	private static boolean isSubmittingCommand(ExtComponent component, List<ExtAjaxBehavior> behaviors, ButtonType type) {
		if (!(component instanceof ExtCommand)) {
			return false;
		}
		boolean needSubmit = (type == ButtonType.SUBMIT) || type == ButtonType.LOAD;

		if (!needSubmit) {
			ExtCommand command = (ExtCommand) component;
			needSubmit = command.getRender() != null || command.getActionExpression() != null
					|| command.getActionListeners().length != 0;
			if (!needSubmit && behaviors != null) {
				for (ExtAjaxBehavior bh : behaviors) {
					if (bh.isSubmitting()) {
						needSubmit = true;
						break;
					}
				}
			}
		}

		return needSubmit;
	}

	public static String getArgs(ExtComponent component, List<ExtAjaxBehavior> behaviors) {
		String args = "";
		if (behaviors == null || behaviors.isEmpty())
			return "";

		for (ExtAjaxBehavior bh : behaviors) {
			if (Strings.isNotEmpty(args) && Strings.isNotEmpty(bh.getArgs()) && !args.equals(bh.getArgs()))
				throw new IllegalArgumentException("The args is not consistent .");

			if (bh.getArgs() == null)
				continue;

			args = bh.getArgs();
		}
		return args.trim();
	}

	// Little utility enum that we use to identify the type of
	// handler that we are going to render.
	private static enum HandlerType {
		// Indicates that we only render the mojarra.jsfcljs() script
		SUBMIT_ONLY,
		// Indicates that we've got a chain
		CLICK_CHAIN,

		CLICK_ONLY,

		BEHAVIOR_HANDLER_ONLY,
		// Indicates that we only have a single behavior - no chaining
		SINGLE_BEHAVIOR_ONLY,

		HANDLER_BEHAVIOR,

		NONE,
	}
}
