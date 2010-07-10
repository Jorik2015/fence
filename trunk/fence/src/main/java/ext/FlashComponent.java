package ext;

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
import java.util.Date;

/**
 * ${ext.commonts}
 */
@XType("flash")
@InstanceOf("Ext.FlashComponent")

@FacesComponent(value = "Ext.FlashComponent")
public class FlashComponent extends BoxComponent {
	public static final String COMPONENT_FAMILY = "Ext.FlashComponent";

	/**
	 * <p>
	 * Create a new {@link Ext.FlashComponent} instance with default property values.
	 * </p>
	 */
	public FlashComponent() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			expressInstall
			,wmode
			,flashVars
			,url
			,flashVersion
			,backgroundColor
			,flashParams
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
	 *True to prompt the user to install
          flash if not installed. Note that this uses
          Ext.FlashComponent.EXPRESS_INSTALL_URL, which should be
          set to the local resource. Defaults to 
          false.
	 */
	
	public Boolean getExpressInstall () {
		return (Boolean) getStateHelper().eval(PropertyKeys.expressInstall);
	}

	/**
	 * <p>
	 * Set the value of the <code>expressInstall</code> property.
	 * </p>
	 */
	public void setExpressInstall ( Boolean   expressInstall ) {
		getStateHelper().put(PropertyKeys.expressInstall, expressInstall);
		handleAttribute("expressInstall", expressInstall);
	}
    	/*
	 *
        
        
          wmode
         : String
        The wmode of the flash object. This can
        be used to control layering. Defaults to 
        'opaque'.
	 */
	
	public String getWmode () {
		return (String) getStateHelper().eval(PropertyKeys.wmode);
	}

	/**
	 * <p>
	 * Set the value of the <code>wmode</code> property.
	 * </p>
	 */
	public void setWmode ( String   wmode ) {
		getStateHelper().put(PropertyKeys.wmode, wmode);
		handleAttribute("wmode", wmode);
	}
    	/*
	 *
        
        
          flashVars
         : Object
        A set of key value pairs to be passed to
        the flash object as flash variables. Defaults to 
        undefined.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getFlashVars () {
		return (Object) getStateHelper().eval(PropertyKeys.flashVars);
	}

	/**
	 * <p>
	 * Set the value of the <code>flashVars</code> property.
	 * </p>
	 */
	public void setFlashVars ( Object   flashVars ) {
		getStateHelper().put(PropertyKeys.flashVars, flashVars);
		handleAttribute("flashVars", flashVars);
	}
    	/*
	 *
        
        
          url
         : String
        The URL of the chart to include.
        Defaults to 
        undefined.
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
    	/*
	 *
        
        
          flashVersion
         : String
        Indicates the version the flash content
        was published for. Defaults to 
        '9.0.45'.
	 */
	
	public String getFlashVersion () {
		return (String) getStateHelper().eval(PropertyKeys.flashVersion);
	}

	/**
	 * <p>
	 * Set the value of the <code>flashVersion</code> property.
	 * </p>
	 */
	public void setFlashVersion ( String   flashVersion ) {
		getStateHelper().put(PropertyKeys.flashVersion, flashVersion);
		handleAttribute("flashVersion", flashVersion);
	}
    	/*
	 *
        
        
          backgroundColor
         : String
        The background color of the chart.
        Defaults to 
        '#ffffff'.
	 */
	
	public String getBackgroundColor () {
		return (String) getStateHelper().eval(PropertyKeys.backgroundColor);
	}

	/**
	 * <p>
	 * Set the value of the <code>backgroundColor</code> property.
	 * </p>
	 */
	public void setBackgroundColor ( String   backgroundColor ) {
		getStateHelper().put(PropertyKeys.backgroundColor, backgroundColor);
		handleAttribute("backgroundColor", backgroundColor);
	}
    	/*
	 *A set of key value pairs to be passed
          to the flash object as parameters. Possible parameters
          can be found here:
          http://kb2.adobe.com/cps/127/tn_12701.html Defaults to 
          undefined.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getFlashParams () {
		return (Object) getStateHelper().eval(PropertyKeys.flashParams);
	}

	/**
	 * <p>
	 * Set the value of the <code>flashParams</code> property.
	 * </p>
	 */
	public void setFlashParams ( Object   flashParams ) {
		getStateHelper().put(PropertyKeys.flashParams, flashParams);
		handleAttribute("flashParams", flashParams);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "initialize"
				));
				return superEvent;
	}
}