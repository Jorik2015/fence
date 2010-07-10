package ext.form;

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
 * Provides a lightweight HTML Editor
  component. Some toolbar features are not supported by Safari and
  will be automatically hidden when needed. These are noted in the
  config options where appropriate.
  
  The editor's toolbar buttons have tooltips defined in the 
  buttonTips property, but they
  are not enabled by default unless the global 
  Ext.QuickTips singleton is 
  initialized.
  
  
  Note: The focus/blur and validation marking functionality
  inherited from Ext.form.Field is NOT supported by this
  editor.
  
  An Editor is a sensitive component that can't be used in
  all spots standard fields can be used. Putting an Editor within
  any element that has display set to 'none' can cause problems in
  Safari and Firefox due to their default iframe reloading bugs.
  
  Example usage: 


// Simple example rendered 
with 
default options:
Ext.QuickTips.init();  
// enable tooltips
new Ext.form.HtmlEditor({
    renderTo: Ext.getBody(),
    width: 800,
    height: 300
});

// Passed via xtype into a container and 
with custom options:
Ext.QuickTips.init();  
// enable tooltips
new Ext.Panel({
    title: 
'HTML Editor',
    renderTo: Ext.getBody(),
    width: 600,
    height: 300,
    frame: true,
    layout: 
'fit',
    items: {
        xtype: 
'htmleditor',
        enableColors: false,
        enableAlignments: false
    }
});
  
 */
@XType("htmleditor")
@InstanceOf("Ext.form.HtmlEditor")

@FacesComponent(value = "Ext.form.HtmlEditor")
public class HtmlEditor extends Field {
	public static final String COMPONENT_FAMILY = "Ext.form.HtmlEditor";

	/**
	 * <p>
	 * Create a new {@link Ext.form.HtmlEditor} instance with default property values.
	 * </p>
	 */
	public HtmlEditor() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			enableFontSize
			,enableSourceEdit
			,defaultValue
			,defaultLinkValue
			,enableLinks
			,enableLists
			,enableFormat
			,enableColors
			,enableAlignments
			,fontFamilies
			,enableFont
			,createLinkText
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
        
        
          enableFontSize
         : Boolean
        Enable the increase/decrease font size
        buttons (defaults to true)
	 */
	
	public Boolean getEnableFontSize () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableFontSize);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableFontSize</code> property.
	 * </p>
	 */
	public void setEnableFontSize ( Boolean   enableFontSize ) {
		getStateHelper().put(PropertyKeys.enableFontSize, enableFontSize);
		handleAttribute("enableFontSize", enableFontSize);
	}
    	/*
	 *
        
        
          enableSourceEdit
         : Boolean
        Enable the switch to source edit button.
        Not available in Safari. (defaults to true)
	 */
	
	public Boolean getEnableSourceEdit () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableSourceEdit);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableSourceEdit</code> property.
	 * </p>
	 */
	public void setEnableSourceEdit ( Boolean   enableSourceEdit ) {
		getStateHelper().put(PropertyKeys.enableSourceEdit, enableSourceEdit);
		handleAttribute("enableSourceEdit", enableSourceEdit);
	}
    	/*
	 *A default value to be put into the
          editor to resolve focus issues (defaults to  
          (Non-breaking space) in Opera and IE6, ​
          (Zero-width space) in all other browsers).
	 */
	
	public String getDefaultValue () {
		return (String) getStateHelper().eval(PropertyKeys.defaultValue);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultValue</code> property.
	 * </p>
	 */
	public void setDefaultValue ( String   defaultValue ) {
		getStateHelper().put(PropertyKeys.defaultValue, defaultValue);
		handleAttribute("defaultValue", defaultValue);
	}
    	/*
	 *
        
        
          defaultLinkValue
         : String
        The default value for the create link
        prompt (defaults to http:/ /)
	 */
	
	public String getDefaultLinkValue () {
		return (String) getStateHelper().eval(PropertyKeys.defaultLinkValue);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultLinkValue</code> property.
	 * </p>
	 */
	public void setDefaultLinkValue ( String   defaultLinkValue ) {
		getStateHelper().put(PropertyKeys.defaultLinkValue, defaultLinkValue);
		handleAttribute("defaultLinkValue", defaultLinkValue);
	}
    	/*
	 *
        
        
          enableLinks
         : Boolean
        Enable the create link button. Not
        available in Safari. (defaults to true)
	 */
	
	public Boolean getEnableLinks () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableLinks);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableLinks</code> property.
	 * </p>
	 */
	public void setEnableLinks ( Boolean   enableLinks ) {
		getStateHelper().put(PropertyKeys.enableLinks, enableLinks);
		handleAttribute("enableLinks", enableLinks);
	}
    	/*
	 *
        
        
          enableLists
         : Boolean
        Enable the bullet and numbered list
        buttons. Not available in Safari. (defaults to
        true)
	 */
	
	public Boolean getEnableLists () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableLists);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableLists</code> property.
	 * </p>
	 */
	public void setEnableLists ( Boolean   enableLists ) {
		getStateHelper().put(PropertyKeys.enableLists, enableLists);
		handleAttribute("enableLists", enableLists);
	}
    	/*
	 *
        
        
          enableFormat
         : Boolean
        Enable the bold, italic and underline
        buttons (defaults to true)
	 */
	
	public Boolean getEnableFormat () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableFormat);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableFormat</code> property.
	 * </p>
	 */
	public void setEnableFormat ( Boolean   enableFormat ) {
		getStateHelper().put(PropertyKeys.enableFormat, enableFormat);
		handleAttribute("enableFormat", enableFormat);
	}
    	/*
	 *
        
        
          enableColors
         : Boolean
        Enable the fore/highlight color buttons
        (defaults to true)
	 */
	
	public Boolean getEnableColors () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableColors);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableColors</code> property.
	 * </p>
	 */
	public void setEnableColors ( Boolean   enableColors ) {
		getStateHelper().put(PropertyKeys.enableColors, enableColors);
		handleAttribute("enableColors", enableColors);
	}
    	/*
	 *
        
        
          enableAlignments
         : Boolean
        Enable the left, center, right alignment
        buttons (defaults to true)
	 */
	
	public Boolean getEnableAlignments () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableAlignments);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableAlignments</code> property.
	 * </p>
	 */
	public void setEnableAlignments ( Boolean   enableAlignments ) {
		getStateHelper().put(PropertyKeys.enableAlignments, enableAlignments);
		handleAttribute("enableAlignments", enableAlignments);
	}
    	/*
	 *
        
        
          fontFamilies
         : Array
        An array of available font
        families
	 */
	@ClientConfig(JsonMode.Array)

	public Object getFontFamilies () {
		return (Object) getStateHelper().eval(PropertyKeys.fontFamilies);
	}

	/**
	 * <p>
	 * Set the value of the <code>fontFamilies</code> property.
	 * </p>
	 */
	public void setFontFamilies ( Object   fontFamilies ) {
		getStateHelper().put(PropertyKeys.fontFamilies, fontFamilies);
		handleAttribute("fontFamilies", fontFamilies);
	}
    	/*
	 *
        
        
          enableFont
         : Boolean
        Enable font selection. Not available in
        Safari. (defaults to true)
	 */
	
	public Boolean getEnableFont () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableFont);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableFont</code> property.
	 * </p>
	 */
	public void setEnableFont ( Boolean   enableFont ) {
		getStateHelper().put(PropertyKeys.enableFont, enableFont);
		handleAttribute("enableFont", enableFont);
	}
    	/*
	 *
        
        
          createLinkText
         : String
        The default text for the create link
        prompt
	 */
	
	public String getCreateLinkText () {
		return (String) getStateHelper().eval(PropertyKeys.createLinkText);
	}

	/**
	 * <p>
	 * Set the value of the <code>createLinkText</code> property.
	 * </p>
	 */
	public void setCreateLinkText ( String   createLinkText ) {
		getStateHelper().put(PropertyKeys.createLinkText, createLinkText);
		handleAttribute("createLinkText", createLinkText);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "activate"
					, "beforepush"
					, "beforesync"
					, "editmodechange"
					, "initialize"
					, "push"
					, "sync"
				));
				return superEvent;
	}
}