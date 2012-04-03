package ext.ux;

import javax.el.ValueExpression;
import ext.annotation.*;

import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
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
 */
@XType("uploaddialog")
@InstanceOf("Ext.ux.UploadDialog.Dialog")
public class UploadDialog extends Window {
	public static final String COMPONENT_FAMILY = "Ext.ux.UploadDialog";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.UploadDialog.Dialog} instance with default property values.
	 * </p>
	 */
	public UploadDialog() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			url
			,permitted_extensions
			,reset_on_hide
			,allow_close_on_upload
			,upload_autostart
			,post_var_name
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
	
		
	private String url;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getUrl () {
		if (null != this.url) {
			return this.url;
		}
		ValueExpression _ve = getValueExpression("url");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>url</code> property.
	 * </p>
	 */
	public void setUrl (String  url) {
		this.url = url;
		this.handleConfig("url", url);
	}
    	
	private Object permitted_extensions;
	
	/*
	 *$cfg.commonts
	 */
	@ClientConfig(JsonMode.Array)
	public Object getPermitted_extensions () {
		if (null != this.permitted_extensions) {
			return this.permitted_extensions;
		}
		ValueExpression _ve = getValueExpression("permitted_extensions");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>permitted_extensions</code> property.
	 * </p>
	 */
	public void setPermitted_extensions (Object  permitted_extensions) {
		this.permitted_extensions = permitted_extensions;
		this.handleConfig("permitted_extensions", permitted_extensions);
	}
    	
	private Boolean reset_on_hide;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getReset_on_hide () {
		if (null != this.reset_on_hide) {
			return this.reset_on_hide;
		}
		ValueExpression _ve = getValueExpression("reset_on_hide");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>reset_on_hide</code> property.
	 * </p>
	 */
	public void setReset_on_hide (Boolean  reset_on_hide) {
		this.reset_on_hide = reset_on_hide;
		this.handleConfig("reset_on_hide", reset_on_hide);
	}
    	
	private Boolean allow_close_on_upload;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getAllow_close_on_upload () {
		if (null != this.allow_close_on_upload) {
			return this.allow_close_on_upload;
		}
		ValueExpression _ve = getValueExpression("allow_close_on_upload");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>allow_close_on_upload</code> property.
	 * </p>
	 */
	public void setAllow_close_on_upload (Boolean  allow_close_on_upload) {
		this.allow_close_on_upload = allow_close_on_upload;
		this.handleConfig("allow_close_on_upload", allow_close_on_upload);
	}
    	
	private Boolean upload_autostart;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getUpload_autostart () {
		if (null != this.upload_autostart) {
			return this.upload_autostart;
		}
		ValueExpression _ve = getValueExpression("upload_autostart");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>upload_autostart</code> property.
	 * </p>
	 */
	public void setUpload_autostart (Boolean  upload_autostart) {
		this.upload_autostart = upload_autostart;
		this.handleConfig("upload_autostart", upload_autostart);
	}
    	
	private String post_var_name;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getPost_var_name () {
		if (null != this.post_var_name) {
			return this.post_var_name;
		}
		ValueExpression _ve = getValueExpression("post_var_name");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>post_var_name</code> property.
	 * </p>
	 */
	public void setPost_var_name (String  post_var_name) {
		this.post_var_name = post_var_name;
		this.handleConfig("post_var_name", post_var_name);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[7];
		}
		_values[0] = super.saveState(_context);
				_values[1] = url;	
				_values[2] = permitted_extensions;	
				_values[3] = reset_on_hide;	
				_values[4] = allow_close_on_upload;	
				_values[5] = upload_autostart;	
				_values[6] = post_var_name;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.url = (String) _values[1];
		this.handleConfig("url", this.url);
				this.permitted_extensions = (Object) _values[2];
		this.handleConfig("permitted_extensions", this.permitted_extensions);
				this.reset_on_hide = (Boolean) _values[3];
		this.handleConfig("reset_on_hide", this.reset_on_hide);
				this.allow_close_on_upload = (Boolean) _values[4];
		this.handleConfig("allow_close_on_upload", this.allow_close_on_upload);
				this.upload_autostart = (Boolean) _values[5];
		this.handleConfig("upload_autostart", this.upload_autostart);
				this.post_var_name = (String) _values[6];
		this.handleConfig("post_var_name", this.post_var_name);
			}
}