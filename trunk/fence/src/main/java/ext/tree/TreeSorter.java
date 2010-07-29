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
 * Provides sorting of nodes in a 
  Ext.tree.TreePanel. The
  TreeSorter automatically monitors events on the associated
  TreePanel that might affect the tree's sort order
  (beforechildrenrendered, append, insert and textchange). Example
  usage:
  


new Ext.tree.TreeSorter(myTree, {
    folderSort: true,
    dir: 
"desc",
    sortType: 
function(node) {
        
// sort by a custom, typed attribute:
        
return parseInt(node.id, 10);
    }
});
  
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
			caseSensitive
			,folderSort
			,property
			,leafAttr
			,sortType
			,dir
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
	 *The named attribute on the node to sort
          by (defaults to "text"). Note that this property is only
          used if no 
          sortType function is
          specified, otherwise it is ignored.
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
	 *A custom "casting" function used to
          convert node values before sorting. The function will be
          called with a single parameter (the 
          Ext.tree.TreeNode being
          evaluated) and is expected to return the node's sort
          value cast to the specific data type required for
          sorting. This could be used, for example, when a node's
          text (or other attribute) should be sorted as a date or
          numeric value. See the class description for example
          usage. Note that if a sortType is specified, any 
          property config will be
          ignored.
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