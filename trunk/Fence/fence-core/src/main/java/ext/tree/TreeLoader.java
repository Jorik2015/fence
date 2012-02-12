package ext.tree;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;
import ext.*;
import ext.dd.*;
import ext.util.*;
import ext.data.*;
import ext.grid.*;
import ext.form.*;
import ext.tree.*;
import ext.layout.*;
import ext.menu.*;
import java.util.*;
import ext.form.Action;
import java.util.Date;

/**
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">A TreeLoader provides for lazy loading
  of an 
  <a ext:cls="Ext.tree.TreeNode" href="output/Ext.tree.TreeNode.html">Ext.tree.TreeNode</a>'s child nodes
  from a specified URL. The response must be a JavaScript Array
  definition whose elements are node definition objects. e.g.: 
<pre>
<code>[{
        id: 1,
        text: 
<em>'A leaf Node'</em>,
        leaf: true
    },{
        id: 2,
        text: 
<em>'A folder Node'</em>,
        children: [{
            id: 3,
            text: 
<em>'A child Node'</em>,
            leaf: true
        }]
   }]</code>
  </pre>
  <br/>
  <br/>A server request is sent, and child nodes are loaded only
  when a node is expanded. The loading node's id is passed to the
  server under the parameter name "node" to enable the server to
  produce the correct child nodes.
  <br/>
  <br/>To pass extra parameters, an event handler may be attached
  to the "beforeload" event, and the parameters specified in the
  TreeLoader's baseParams property: 
<pre>
<code>myTreeLoader.on(
<em>"beforeload"</em>, 
<b>function</b>(treeLoader, node) {
        this.baseParams.category = node.attributes.category;
    }, this);</code>
  </pre>This would pass an HTTP parameter called "category" to the
  server containing the value of the Node's "category"
  attribute.</div>

 */

@InstanceOf("Ext.tree.TreeLoader")

@FacesComponent(value = "Ext.tree.TreeLoader")
public class TreeLoader extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.tree.TreeLoader";

	/**
	 * <p>
	 * Create a new {@link Ext.tree.TreeLoader} instance with default property values.
	 * </p>
	 */
	public TreeLoader() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			nodeParameter
			,baseAttrs
			,paramOrder
			,baseParams
			,dataUrl
			,paramsAsHash
			,uiProviders
			,directFn
			,clearOnLoad
			,requestMethod
			,preloadChildren
			,url
		;
		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {
		}

		public String toString() {
			return ((toString != null) ? toString : super.toString());
		}
	}
	
		/*
	 *
        
        
          nodeParameter
         : String
        The name of the parameter sent to the
        server which contains the identifier of the node. Defaults
        to 
        'node'.
	 */
	
	public String getNodeParameter () {
		return (String) getStateHelper().eval(PropertyKeys.nodeParameter);
	}

	/**
	 * <p>
	 * Set the value of the <code>nodeParameter</code> property.
	 * </p>
	 */
	public void setNodeParameter ( String   nodeParameter ) {
		getStateHelper().put(PropertyKeys.nodeParameter, nodeParameter);
		handleAttribute("nodeParameter", nodeParameter);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An object containing attributes to be
          added to all nodes created by this loader. If the
          attributes sent by the server have an attribute in this
          object, they take priority.</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getBaseAttrs () {
		return (Object) getStateHelper().eval(PropertyKeys.baseAttrs);
	}

	/**
	 * <p>
	 * Set the value of the <code>baseAttrs</code> property.
	 * </p>
	 */
	public void setBaseAttrs ( Object   baseAttrs ) {
		getStateHelper().put(PropertyKeys.baseAttrs, baseAttrs);
		handleAttribute("baseAttrs", baseAttrs);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Defaults to 
          <tt>undefined</tt>. Only used when using directFn.
          Specifies the params in the order in which they must be
          passed to the server-side Direct method as either (1) an
          Array of String values, or (2) a String of params
          delimited by either whitespace, comma, or pipe. For
          example, any of the following would be acceptable:
<pre>
<code>nodeParameter: 
<em>'node'</em>,
paramOrder: [
<em>'param1'</em>,
<em>'param2'</em>,
<em>'param3'</em>]
paramOrder: 
<em>'node param1 param2 param3'</em>
paramOrder: 
<em>'param1,node,param2,param3'</em>
paramOrder: 
<em>'param1|param2|param|node'</em>
</code>
          </pre>
</div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getParamOrder () {
		return (Object) getStateHelper().eval(PropertyKeys.paramOrder);
	}

	/**
	 * <p>
	 * Set the value of the <code>paramOrder</code> property.
	 * </p>
	 */
	public void setParamOrder ( Object   paramOrder ) {
		getStateHelper().put(PropertyKeys.paramOrder, paramOrder);
		handleAttribute("paramOrder", paramOrder);
	}
    	/*
	 *
        
        
          baseParams
         : Object
        An object containing properties which
        specify HTTP parameters to be passed to each request for
        child nodes.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getBaseParams () {
		return (Object) getStateHelper().eval(PropertyKeys.baseParams);
	}

	/**
	 * <p>
	 * Set the value of the <code>baseParams</code> property.
	 * </p>
	 */
	public void setBaseParams ( Object   baseParams ) {
		getStateHelper().put(PropertyKeys.baseParams, baseParams);
		handleAttribute("baseParams", baseParams);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The URL from which to request a Json
          string which specifies an array of node definition
          objects representing the child nodes to be loaded.</div>

	 */
	
	public String getDataUrl () {
		return (String) getStateHelper().eval(PropertyKeys.dataUrl);
	}

	/**
	 * <p>
	 * Set the value of the <code>dataUrl</code> property.
	 * </p>
	 */
	public void setDataUrl ( String   dataUrl ) {
		getStateHelper().put(PropertyKeys.dataUrl, dataUrl);
		handleAttribute("dataUrl", dataUrl);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Only used when using directFn. Send
          parameters as a collection of named arguments (defaults
          to 
          <tt>false</tt>). Providing a 
          <tt>
            <a ext:cls="Ext.tree.TreeLoader" ext:member="paramOrder" href="output/Ext.tree.TreeLoader.html#Ext.tree.TreeLoader-paramOrder">paramOrder</a>
          </tt> nullifies this configuration.</div>

	 */
	
	public Boolean getParamsAsHash () {
		return (Boolean) getStateHelper().eval(PropertyKeys.paramsAsHash);
	}

	/**
	 * <p>
	 * Set the value of the <code>paramsAsHash</code> property.
	 * </p>
	 */
	public void setParamsAsHash ( Boolean   paramsAsHash ) {
		getStateHelper().put(PropertyKeys.paramsAsHash, paramsAsHash);
		handleAttribute("paramsAsHash", paramsAsHash);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An object containing properties which
          specify custom 
          <a ext:cls="Ext.tree.TreeNodeUI" href="output/Ext.tree.TreeNodeUI.html">Ext.tree.TreeNodeUI</a>
          implementations. If the optional 
          <i>uiProvider</i> attribute of a returned child node is a
          string rather than a reference to a TreeNodeUI
          implementation, then that string value is used as a
          property name in the uiProviders object.</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getUiProviders () {
		return (Object) getStateHelper().eval(PropertyKeys.uiProviders);
	}

	/**
	 * <p>
	 * Set the value of the <code>uiProviders</code> property.
	 * </p>
	 */
	public void setUiProviders ( Object   uiProviders ) {
		getStateHelper().put(PropertyKeys.uiProviders, uiProviders);
		handleAttribute("uiProviders", uiProviders);
	}
    	/*
	 *
        
        
          directFn
         : Function
        Function to call when executing a
        request.
	 */
	@ClientConfig(JsonMode.Function)

	public Object getDirectFn () {
		return (Object) getStateHelper().eval(PropertyKeys.directFn);
	}

	/**
	 * <p>
	 * Set the value of the <code>directFn</code> property.
	 * </p>
	 */
	public void setDirectFn ( Object   directFn ) {
		getStateHelper().put(PropertyKeys.directFn, directFn);
		handleAttribute("directFn", directFn);
	}
    	/*
	 *
        
        
          clearOnLoad
         : Boolean
        Default to true. Remove previously
        existing child nodes before loading.
	 */
	
	public Boolean getClearOnLoad () {
		return (Boolean) getStateHelper().eval(PropertyKeys.clearOnLoad);
	}

	/**
	 * <p>
	 * Set the value of the <code>clearOnLoad</code> property.
	 * </p>
	 */
	public void setClearOnLoad ( Boolean   clearOnLoad ) {
		getStateHelper().put(PropertyKeys.clearOnLoad, clearOnLoad);
		handleAttribute("clearOnLoad", clearOnLoad);
	}
    	/*
	 *
        
        
          requestMethod
         : String
        The HTTP request method for loading data
        (defaults to the value of 
        Ext.Ajax.method).
	 */
	
	public String getRequestMethod () {
		return (String) getStateHelper().eval(PropertyKeys.requestMethod);
	}

	/**
	 * <p>
	 * Set the value of the <code>requestMethod</code> property.
	 * </p>
	 */
	public void setRequestMethod ( String   requestMethod ) {
		getStateHelper().put(PropertyKeys.requestMethod, requestMethod);
		handleAttribute("requestMethod", requestMethod);
	}
    	/*
	 *
        
        
          preloadChildren
         : Boolean
        If set to true, the loader recursively
        loads "children" attributes when doing the first load on
        nodes.
	 */
	
	public Boolean getPreloadChildren () {
		return (Boolean) getStateHelper().eval(PropertyKeys.preloadChildren);
	}

	/**
	 * <p>
	 * Set the value of the <code>preloadChildren</code> property.
	 * </p>
	 */
	public void setPreloadChildren ( Boolean   preloadChildren ) {
		getStateHelper().put(PropertyKeys.preloadChildren, preloadChildren);
		handleAttribute("preloadChildren", preloadChildren);
	}
    	/*
	 *
        
        
          url
         : String
        Equivalent to 
        dataUrl.
	 */
	
	public String getUrl () {
		return (String) getStateHelper().eval(PropertyKeys.url);
	}

	/**
	 * <p>
	 * Set the value of the <code>url</code> property.
	 * </p>
	 */
	public void setUrl ( String   url ) {
		getStateHelper().put(PropertyKeys.url, url);
		handleAttribute("url", url);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforeload"
					, "load"
					, "loadexception"
				));
				return superEvent;
	}
}