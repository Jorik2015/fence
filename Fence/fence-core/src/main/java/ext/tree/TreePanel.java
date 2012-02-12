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
<div class="description">
    <p>The TreePanel provides tree-structured UI representation of
    tree-structured data.</p>
    <p>
    <a ext:cls="Ext.tree.TreeNode" href="output/Ext.tree.TreeNode.html">TreeNode</a>s added to the
    TreePanel may each contain metadata used by your application in
    their 
    <a ext:cls="Ext.tree.TreeNode" ext:member="attributes" href="output/Ext.tree.TreeNode.html#Ext.tree.TreeNode-attributes">attributes</a> property.</p>
    <p>
    <b>A TreePanel must have a 
    <a ext:cls="Ext.tree.TreePanel" ext:member="root" href="output/Ext.tree.TreePanel.html#Ext.tree.TreePanel-root">root</a> node
    before it is rendered.</b> This may either be specified using
    the 
    <a ext:cls="Ext.tree.TreePanel" ext:member="root" href="output/Ext.tree.TreePanel.html#Ext.tree.TreePanel-root">root</a> config
    option, or using the 
    <a ext:cls="Ext.tree.TreePanel" ext:member="setRootNode" href="output/Ext.tree.TreePanel.html#Ext.tree.TreePanel-setRootNode">setRootNode</a> method.</p>
    <p>An example of tree rendered to an existing div:</p>
<pre>
<code>
<b>var</b> tree = 
<b>new</b> Ext.tree.TreePanel({
    renderTo: 
<em>'tree-div'</em>,
    useArrows: true,
    autoScroll: true,
    animate: true,
    enableDD: true,
    containerScroll: true,
    border: false,
    
<i>// auto create TreeLoader</i>
    dataUrl: 
<em>'get-nodes.php'</em>,

    root: {
        nodeType: 
<em>'async'</em>,
        text: 
<em>'Ext JS'</em>,
        draggable: false,
        id: 
<em>'source'</em>
    }
});

tree.getRootNode().expand();</code>
    </pre>
    <p>The example above would work with a data packet similar to
    this:</p>
<pre>
<code>[{
    
<em>"text"</em>: 
<em>"adapter"</em>,
    
<em>"id"</em>: 
<em>"source\/adapter"</em>,
    
<em>"cls"</em>: 
<em>"folder"</em>
}, {
    
<em>"text"</em>: 
<em>"dd"</em>,
    
<em>"id"</em>: 
<em>"source\/dd"</em>,
    
<em>"cls"</em>: 
<em>"folder"</em>
}, {
    
<em>"text"</em>: 
<em>"debug.js"</em>,
    
<em>"id"</em>: 
<em>"source\/debug.js"</em>,
    
<em>"leaf"</em>: true,
    
<em>"cls"</em>: 
<em>"file"</em>
}]</code>
    </pre>
    <p>An example of tree within a Viewport:</p>
<pre>
<code>
<b>new</b> Ext.Viewport({
    layout: 
<em>'border'</em>,
    items: [{
        region: 
<em>'west'</em>,
        collapsible: true,
        title: 
<em>'Navigation'</em>,
        xtype: 
<em>'treepanel'</em>,
        width: 200,
        autoScroll: true,
        split: true,
        loader: 
<b>new</b> Ext.tree.TreeLoader(),
        root: 
<b>new</b> Ext.tree.AsyncTreeNode({
            expanded: true,
            children: [{
                text: 
<em>'Menu Option 1'</em>,
                leaf: true
            }, {
                text: 
<em>'Menu Option 2'</em>,
                leaf: true
            }, {
                text: 
<em>'Menu Option 3'</em>,
                leaf: true
            }]
        }),
        rootVisible: false,
        listeners: {
            click: 
<b>function</b>(n) {
                Ext.Msg.alert(
<em>'Navigation Tree Click'</em>, 
<em>'You clicked:</em> "'</code> + n.attributes.text + 
<em>'"</em>');
            }
        }
    }, {
        region: 
<em>'center'</em>,
        xtype: 
<em>'tabpanel'</em>,
        
<i>// remaining code not shown ...</i>
    }]
});
    </pre>
  </div>

 */
@XType("treepanel")
@InstanceOf("Ext.tree.TreePanel")

@FacesComponent(value = "Ext.tree.TreePanel")
public class TreePanel extends Panel {
	public static final String COMPONENT_FAMILY = "Ext.tree.TreePanel";

	/**
	 * <p>
	 * Create a new {@link Ext.tree.TreePanel} instance with default property values.
	 * </p>
	 */
	public TreePanel() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			trackMouseOver
			,ddScroll
			,hlColor
			,animate
			,containerScroll
			,hlDrop
			,root
			,loader
			,ddAppendOnly
			,useArrows
			,pathSeparator
			,dragConfig
			,rootVisible
			,singleExpand
			,enableDrop
			,ddGroup
			,enableDrag
			,enableDD
			,selModel
			,lines
			,requestMethod
			,dropConfig
			,bubbleEvents
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
        
        
          trackMouseOver
         : Boolean
        
        false to disable mouse over
        highlighting
	 */
	
	public Boolean getTrackMouseOver () {
		return (Boolean) getStateHelper().eval(PropertyKeys.trackMouseOver);
	}

	/**
	 * <p>
	 * Set the value of the <code>trackMouseOver</code> property.
	 * </p>
	 */
	public void setTrackMouseOver ( Boolean   trackMouseOver ) {
		getStateHelper().put(PropertyKeys.trackMouseOver, trackMouseOver);
		handleAttribute("trackMouseOver", trackMouseOver);
	}
    	/*
	 *
        
        
          ddScroll
         : Boolean
        
        true to enable body scrolling
	 */
	
	public Boolean getDdScroll () {
		return (Boolean) getStateHelper().eval(PropertyKeys.ddScroll);
	}

	/**
	 * <p>
	 * Set the value of the <code>ddScroll</code> property.
	 * </p>
	 */
	public void setDdScroll ( Boolean   ddScroll ) {
		getStateHelper().put(PropertyKeys.ddScroll, ddScroll);
		handleAttribute("ddScroll", ddScroll);
	}
    	/*
	 *
        
        
          hlColor
         : String
        The color of the node highlight
        (defaults to 
        'C3DAF9')
	 */
	
	public String getHlColor () {
		return (String) getStateHelper().eval(PropertyKeys.hlColor);
	}

	/**
	 * <p>
	 * Set the value of the <code>hlColor</code> property.
	 * </p>
	 */
	public void setHlColor ( String   hlColor ) {
		getStateHelper().put(PropertyKeys.hlColor, hlColor);
		handleAttribute("hlColor", hlColor);
	}
    	/*
	 *
        
        
          animate
         : Boolean
        
        true to enable animated expand/collapse (defaults
        to the value of 
        Ext.enableFx)
	 */
	
	public Boolean getAnimate () {
		return (Boolean) getStateHelper().eval(PropertyKeys.animate);
	}

	/**
	 * <p>
	 * Set the value of the <code>animate</code> property.
	 * </p>
	 */
	public void setAnimate ( Boolean   animate ) {
		getStateHelper().put(PropertyKeys.animate, animate);
		handleAttribute("animate", animate);
	}
    	/*
	 *
        
        
          containerScroll
         : Boolean
        
        true to register this container with
        ScrollManager
	 */
	
	public Boolean getContainerScroll () {
		return (Boolean) getStateHelper().eval(PropertyKeys.containerScroll);
	}

	/**
	 * <p>
	 * Set the value of the <code>containerScroll</code> property.
	 * </p>
	 */
	public void setContainerScroll ( Boolean   containerScroll ) {
		getStateHelper().put(PropertyKeys.containerScroll, containerScroll);
		handleAttribute("containerScroll", containerScroll);
	}
    	/*
	 *
        
        
          hlDrop
         : Boolean
        
        false to disable node highlight on drop (defaults
        to the value of 
        Ext.enableFx)
	 */
	
	public Boolean getHlDrop () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hlDrop);
	}

	/**
	 * <p>
	 * Set the value of the <code>hlDrop</code> property.
	 * </p>
	 */
	public void setHlDrop ( Boolean   hlDrop ) {
		getStateHelper().put(PropertyKeys.hlDrop, hlDrop);
		handleAttribute("hlDrop", hlDrop);
	}
    	/*
	 *
        
        
          root
         : Ext.tree.TreeNode
        The root node for the tree.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getRoot () {
		return (Object) getStateHelper().eval(PropertyKeys.root);
	}

	/**
	 * <p>
	 * Set the value of the <code>root</code> property.
	 * </p>
	 */
	public void setRoot ( Object   root ) {
		getStateHelper().put(PropertyKeys.root, root);
		handleAttribute("root", root);
	}
    	/*
	 *
        
        
          loader
         : Ext.tree.TreeLoader
        A 
        Ext.tree.TreeLoader for
        use with this TreePanel
	 */
	@ClientConfig(JsonMode.Object)

	public Object getLoader () {
		return (Object) getStateHelper().eval(PropertyKeys.loader);
	}

	/**
	 * <p>
	 * Set the value of the <code>loader</code> property.
	 * </p>
	 */
	public void setLoader ( Object   loader ) {
		getStateHelper().put(PropertyKeys.loader, loader);
		handleAttribute("loader", loader);
	}
    	/*
	 *
        
        
          ddAppendOnly
         : Boolean
        
        true if the tree should only allow append drops
        (use for trees which are sorted)
	 */
	
	public Boolean getDdAppendOnly () {
		return (Boolean) getStateHelper().eval(PropertyKeys.ddAppendOnly);
	}

	/**
	 * <p>
	 * Set the value of the <code>ddAppendOnly</code> property.
	 * </p>
	 */
	public void setDdAppendOnly ( Boolean   ddAppendOnly ) {
		getStateHelper().put(PropertyKeys.ddAppendOnly, ddAppendOnly);
		handleAttribute("ddAppendOnly", ddAppendOnly);
	}
    	/*
	 *
        
        
          useArrows
         : Boolean
        
        true to use Vista-style arrows in the tree
        (defaults to 
        false)
	 */
	
	public Boolean getUseArrows () {
		return (Boolean) getStateHelper().eval(PropertyKeys.useArrows);
	}

	/**
	 * <p>
	 * Set the value of the <code>useArrows</code> property.
	 * </p>
	 */
	public void setUseArrows ( Boolean   useArrows ) {
		getStateHelper().put(PropertyKeys.useArrows, useArrows);
		handleAttribute("useArrows", useArrows);
	}
    	/*
	 *
        
        
          pathSeparator
         : String
        The token used to separate sub-paths in
        path strings (defaults to 
        '/')
	 */
	
	public String getPathSeparator () {
		return (String) getStateHelper().eval(PropertyKeys.pathSeparator);
	}

	/**
	 * <p>
	 * Set the value of the <code>pathSeparator</code> property.
	 * </p>
	 */
	public void setPathSeparator ( String   pathSeparator ) {
		getStateHelper().put(PropertyKeys.pathSeparator, pathSeparator);
		handleAttribute("pathSeparator", pathSeparator);
	}
    	/*
	 *
        
        
          dragConfig
         : Object
        Custom config to pass to the 
        Ext.tree.TreeDragZone
        instance
	 */
	@ClientConfig(JsonMode.Object)

	public Object getDragConfig () {
		return (Object) getStateHelper().eval(PropertyKeys.dragConfig);
	}

	/**
	 * <p>
	 * Set the value of the <code>dragConfig</code> property.
	 * </p>
	 */
	public void setDragConfig ( Object   dragConfig ) {
		getStateHelper().put(PropertyKeys.dragConfig, dragConfig);
		handleAttribute("dragConfig", dragConfig);
	}
    	/*
	 *
        
        
          rootVisible
         : Boolean
        
        false to hide the root node (defaults to 
        true)
	 */
	
	public Boolean getRootVisible () {
		return (Boolean) getStateHelper().eval(PropertyKeys.rootVisible);
	}

	/**
	 * <p>
	 * Set the value of the <code>rootVisible</code> property.
	 * </p>
	 */
	public void setRootVisible ( Boolean   rootVisible ) {
		getStateHelper().put(PropertyKeys.rootVisible, rootVisible);
		handleAttribute("rootVisible", rootVisible);
	}
    	/*
	 *
        
        
          singleExpand
         : Boolean
        
        true if only 1 node per branch may be
        expanded
	 */
	
	public Boolean getSingleExpand () {
		return (Boolean) getStateHelper().eval(PropertyKeys.singleExpand);
	}

	/**
	 * <p>
	 * Set the value of the <code>singleExpand</code> property.
	 * </p>
	 */
	public void setSingleExpand ( Boolean   singleExpand ) {
		getStateHelper().put(PropertyKeys.singleExpand, singleExpand);
		handleAttribute("singleExpand", singleExpand);
	}
    	/*
	 *
        
        
          enableDrop
         : Boolean
        
        true to enable just drop
	 */
	
	public Boolean getEnableDrop () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableDrop);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableDrop</code> property.
	 * </p>
	 */
	public void setEnableDrop ( Boolean   enableDrop ) {
		getStateHelper().put(PropertyKeys.enableDrop, enableDrop);
		handleAttribute("enableDrop", enableDrop);
	}
    	/*
	 *
        
        
          ddGroup
         : String
        The DD group this TreePanel belongs
        to
	 */
	
	public String getDdGroup () {
		return (String) getStateHelper().eval(PropertyKeys.ddGroup);
	}

	/**
	 * <p>
	 * Set the value of the <code>ddGroup</code> property.
	 * </p>
	 */
	public void setDdGroup ( String   ddGroup ) {
		getStateHelper().put(PropertyKeys.ddGroup, ddGroup);
		handleAttribute("ddGroup", ddGroup);
	}
    	/*
	 *
        
        
          enableDrag
         : Boolean
        
        true to enable just drag
	 */
	
	public Boolean getEnableDrag () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableDrag);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableDrag</code> property.
	 * </p>
	 */
	public void setEnableDrag ( Boolean   enableDrag ) {
		getStateHelper().put(PropertyKeys.enableDrag, enableDrag);
		handleAttribute("enableDrag", enableDrag);
	}
    	/*
	 *
        
        
          enableDD
         : Boolean
        
        true to enable drag and drop
	 */
	
	public Boolean getEnableDD () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableDD);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableDD</code> property.
	 * </p>
	 */
	public void setEnableDD ( Boolean   enableDD ) {
		getStateHelper().put(PropertyKeys.enableDD, enableDD);
		handleAttribute("enableDD", enableDD);
	}
    	/*
	 *
        
        
          selModel
         : Object
        A tree selection model to use with this
        TreePanel (defaults to an 
        Ext.tree.DefaultSelectionModel)
	 */
	@ClientConfig(JsonMode.Object)

	public Object getSelModel () {
		return (Object) getStateHelper().eval(PropertyKeys.selModel);
	}

	/**
	 * <p>
	 * Set the value of the <code>selModel</code> property.
	 * </p>
	 */
	public void setSelModel ( Object   selModel ) {
		getStateHelper().put(PropertyKeys.selModel, selModel);
		handleAttribute("selModel", selModel);
	}
    	/*
	 *
        
        
          lines
         : Boolean
        
        false to disable tree lines (defaults to 
        true)
	 */
	
	public Boolean getLines () {
		return (Boolean) getStateHelper().eval(PropertyKeys.lines);
	}

	/**
	 * <p>
	 * Set the value of the <code>lines</code> property.
	 * </p>
	 */
	public void setLines ( Boolean   lines ) {
		getStateHelper().put(PropertyKeys.lines, lines);
		handleAttribute("lines", lines);
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
        
        
          dropConfig
         : Object
        Custom config to pass to the 
        Ext.tree.TreeDropZone
        instance
	 */
	@ClientConfig(JsonMode.Object)

	public Object getDropConfig () {
		return (Object) getStateHelper().eval(PropertyKeys.dropConfig);
	}

	/**
	 * <p>
	 * Set the value of the <code>dropConfig</code> property.
	 * </p>
	 */
	public void setDropConfig ( Object   dropConfig ) {
		getStateHelper().put(PropertyKeys.dropConfig, dropConfig);
		handleAttribute("dropConfig", dropConfig);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>An array of events that, when fired, should be
            bubbled to any parent container. See 
            <a ext:cls="Ext.util.Observable" ext:member="enableBubble" href="output/Ext.util.Observable.html#Ext.util.Observable-enableBubble">Ext.util.Observable.enableBubble</a>.
            Defaults to 
            <tt>[]</tt>.</p>
          </div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getBubbleEvents () {
		return (Object) getStateHelper().eval(PropertyKeys.bubbleEvents);
	}

	/**
	 * <p>
	 * Set the value of the <code>bubbleEvents</code> property.
	 * </p>
	 */
	public void setBubbleEvents ( Object   bubbleEvents ) {
		getStateHelper().put(PropertyKeys.bubbleEvents, bubbleEvents);
		handleAttribute("bubbleEvents", bubbleEvents);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "append"
					, "beforeappend"
					, "beforechildrenrendered"
					, "beforeclick"
					, "beforecollapsenode"
					, "beforedblclick"
					, "beforeexpandnode"
					, "beforeinsert"
					, "beforeload"
					, "beforemovenode"
					, "beforenodedrop"
					, "beforeremove"
					, "checkchange"
					, "click"
					, "collapsenode"
					, "containerclick"
					, "containercontextmenu"
					, "containerdblclick"
					, "contextmenu"
					, "dblclick"
					, "disabledchange"
					, "dragdrop"
					, "enddrag"
					, "expandnode"
					, "insert"
					, "load"
					, "movenode"
					, "nodedragover"
					, "nodedrop"
					, "remove"
					, "startdrag"
					, "textchange"
				));
				return superEvent;
	}
}