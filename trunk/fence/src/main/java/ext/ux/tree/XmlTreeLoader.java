package ext.ux.tree;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.application.ResourceDependency;
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
 * 
    A TreeLoader that can convert an XML document into a
    hierarchy of 
    Ext.tree.TreeNodes. Any text
    value included as a text node in the XML will be added to the
    parent node as an attribute called 
    innerText. Also, the tag name of each XML node will be
    added to the tree node as an attribute called 
    tagName.
    By default, this class expects that your source XML will
    provide the necessary attributes on each node as expected by
    the 
    Ext.tree.TreePanel to display
    and load properly. However, you can provide your own custom
    processing of node attributes by overriding the 
    processNode method and
    modifying the attributes as needed before they are used to
    create the associated TreeNode.
  
 */

@InstanceOf("Ext.ux.tree.XmlTreeLoader")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "XmlTreeLoader.js")
@FacesComponent(value = "Ext.ux.tree.XmlTreeLoader")
public class XmlTreeLoader extends TreeLoader {
	public static final String COMPONENT_FAMILY = "Ext.ux.tree.XmlTreeLoader";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.tree.XmlTreeLoader} instance with default property values.
	 * </p>
	 */
	public XmlTreeLoader() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
	
	    
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				return superEvent;
	}
}