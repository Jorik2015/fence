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
<div class="description">Provides sorting of nodes in a 
  <a ext:cls="Ext.tree.TreePanel" href="output/Ext.tree.TreePanel.html">Ext.tree.TreePanel</a>. The
  TreeSorter automatically monitors events on the associated
  TreePanel that might affect the tree's sort order
  (beforechildrenrendered, append, insert and textchange). Example
  usage:
  <br/>
<pre>
<code>
<b>new</b> Ext.tree.TreeSorter(myTree, {
    folderSort: true,
    dir: 
<em>"desc"</em>,
    sortType: 
<b>function</b>(node) {
        
<i>// sort by a custom, typed attribute:</i>
        
<b>return</b> parseInt(node.id, 10);
    }
});</code>
  </pre>
</div>

 */

@InstanceOf("Ext.tree.TreeSorter")

@FacesComponent(value = "Ext.tree.TreeSorter")
public class TreeSorter extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.tree.TreeSorter";

	/**
	 * <p>
	 * Create a new {@link Ext.tree.TreeSorter} instance with default property values.
	 * </p>
	 */
	public TreeSorter() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			folderSort
			,dir
			,leafAttr
			,sortType
			,caseSensitive
			,property
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
        
        
          folderSort
         : Boolean
        True to sort leaf nodes under non-leaf
        nodes (defaults to false)
	 */
	
	public Boolean getFolderSort () {
		return (Boolean) getStateHelper().eval(PropertyKeys.folderSort);
	}

	/**
	 * <p>
	 * Set the value of the <code>folderSort</code> property.
	 * </p>
	 */
	public void setFolderSort ( Boolean   folderSort ) {
		getStateHelper().put(PropertyKeys.folderSort, folderSort);
		handleAttribute("folderSort", folderSort);
	}
    	/*
	 *
        
        
          dir
         : String
        The direction to sort ("asc" or "desc,"
        case-insensitive, defaults to "asc")
	 */
	
	public String getDir () {
		return (String) getStateHelper().eval(PropertyKeys.dir);
	}

	/**
	 * <p>
	 * Set the value of the <code>dir</code> property.
	 * </p>
	 */
	public void setDir ( String   dir ) {
		getStateHelper().put(PropertyKeys.dir, dir);
		handleAttribute("dir", dir);
	}
    	/*
	 *
        
        
          leafAttr
         : String
        The attribute used to determine leaf
        nodes when 
        folderSort = true
        (defaults to "leaf")
	 */
	
	public String getLeafAttr () {
		return (String) getStateHelper().eval(PropertyKeys.leafAttr);
	}

	/**
	 * <p>
	 * Set the value of the <code>leafAttr</code> property.
	 * </p>
	 */
	public void setLeafAttr ( String   leafAttr ) {
		getStateHelper().put(PropertyKeys.leafAttr, leafAttr);
		handleAttribute("leafAttr", leafAttr);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A custom "casting" function used to
          convert node values before sorting. The function will be
          called with a single parameter (the 
          <a ext:cls="Ext.tree.TreeNode" href="output/Ext.tree.TreeNode.html">Ext.tree.TreeNode</a> being
          evaluated) and is expected to return the node's sort
          value cast to the specific data type required for
          sorting. This could be used, for example, when a node's
          text (or other attribute) should be sorted as a date or
          numeric value. See the class description for example
          usage. Note that if a sortType is specified, any 
          <a ext:cls="Ext.tree.TreeSorter" ext:member="property" href="output/Ext.tree.TreeSorter.html#Ext.tree.TreeSorter-property">property</a> config will be
          ignored.</div>

	 */
	@ClientConfig(JsonMode.Function)

	public Object getSortType () {
		return (Object) getStateHelper().eval(PropertyKeys.sortType);
	}

	/**
	 * <p>
	 * Set the value of the <code>sortType</code> property.
	 * </p>
	 */
	public void setSortType ( Object   sortType ) {
		getStateHelper().put(PropertyKeys.sortType, sortType);
		handleAttribute("sortType", sortType);
	}
    	/*
	 *
        
        
          caseSensitive
         : Boolean
        true for case-sensitive sort (defaults
        to false)
	 */
	
	public Boolean getCaseSensitive () {
		return (Boolean) getStateHelper().eval(PropertyKeys.caseSensitive);
	}

	/**
	 * <p>
	 * Set the value of the <code>caseSensitive</code> property.
	 * </p>
	 */
	public void setCaseSensitive ( Boolean   caseSensitive ) {
		getStateHelper().put(PropertyKeys.caseSensitive, caseSensitive);
		handleAttribute("caseSensitive", caseSensitive);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The named attribute on the node to sort
          by (defaults to "text"). Note that this property is only
          used if no 
          <a ext:cls="Ext.tree.TreeSorter" ext:member="sortType" href="output/Ext.tree.TreeSorter.html#Ext.tree.TreeSorter-sortType">sortType</a> function is
          specified, otherwise it is ignored.</div>

	 */
	
	public String getProperty () {
		return (String) getStateHelper().eval(PropertyKeys.property);
	}

	/**
	 * <p>
	 * Set the value of the <code>property</code> property.
	 * </p>
	 */
	public void setProperty ( String   property ) {
		getStateHelper().put(PropertyKeys.property, property);
		handleAttribute("property", property);
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