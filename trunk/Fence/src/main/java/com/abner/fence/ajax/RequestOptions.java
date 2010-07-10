package com.abner.fence.ajax;

import javax.el.ValueExpression;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import com.abner.fence.annotation.ClientConfig;
import com.abner.fence.annotation.ParseConfigMode;
import com.abner.fence.commons.Enums.JsonMode;
import com.abner.fence.commons.Enums.PersistenceMode;
import com.abner.fence.commons.Enums.ReferenceMode;

import ext.form.Action;

@FacesComponent("Ext.ajax.RequestOptions")
@ParseConfigMode(id = false, ui = false, pmode = PersistenceMode.Custom, rmode = ReferenceMode.Config)
public class RequestOptions extends Action {
	public static final String COMPONENT_TYPE = "Ext.ajax.RequestOptions";

	/**
	 * <p>
	 * Create a new {@link RequestOptions} instance with default property values.
	 * </p>
	 */
	public RequestOptions() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	enum PropertyKeys {
		callback, disableCaching, form, headers, isUpload, jsonData, xmlData;

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

	private Object callback;

	/**
	 * The function to be called upon receipt of the HTTP response. The callback is called regardless of success or
	 * failure and is passed the following parameters: options : Object The parameter to the request call. success :
	 * Boolean True if the request succeeded. response : Object The XMLHttpRequest object containing the response data.
	 * See http://www.w3.org/TR/XMLHttpRequest/ for details about accessing elements of the response.
	 * */
	@ClientConfig(JsonMode.Function)
	public Object getCallback() {
		if (null != this.callback) {
			return this.callback;
		}
		ValueExpression _ve = getValueExpression("callback");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>callback</code> property.
	 * </p>
	 */
	public void setCallback(Object callback) {
		this.callback = callback;
		handleConfig("callback", callback);
	}

	private String form;

	/**
	 * The <form> Element or the id of the <form> to pull parameters from.
	 */
	public String getForm() {
		if (null != this.form) {
			return this.form;
		}
		ValueExpression _ve = getValueExpression("form");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>form</code> property.
	 * </p>
	 */
	public void setForm(String form) {
		this.form = form;
		handleConfig("form", form);
	}

	private Boolean isUpload;

	/**
	 * Only meaningful when used with the form option. True if the form object is a file upload (will be set
	 * automatically if the form was configured with enctype "multipart/form-data"). File uploads are not performed
	 * using normal "Ajax" techniques, that is they are not performed using XMLHttpRequests. Instead the form is
	 * submitted in the standard manner with the DOM <form> element temporarily modified to have its target set to refer
	 * to a dynamically generated, hidden <iframe> which is inserted into the document but removed after the return data
	 * has been gathered. The server response is parsed by the browser to create the document for the IFRAME. If the
	 * server is using JSON to send the return object, then the Content-Type header must be set to "text/html" in order
	 * to tell the browser to insert the text unchanged into the document body. The response text is retrieved from the
	 * document, and a fake XMLHttpRequest object is created containing a responseText property in order to conform to
	 * the requirements of event handlers and callbacks. Be aware that file upload packets are sent with the content
	 * type multipart/form and some server technologies (notably JEE) may require some custom processing in order to
	 * retrieve parameter names and parameter values from the packet content.
	 */
	public Boolean getIsUpload() {
		if (null != this.isUpload) {
			return this.isUpload;
		}
		ValueExpression _ve = getValueExpression("isUpload");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>isUpload</code> property.
	 * </p>
	 */
	public void setIsUpload(Boolean isUpload) {
		this.isUpload = isUpload;
		handleConfig("isUpload", isUpload);
	}

	private Boolean disableCaching;

	/**
	 * True to add a unique cache-buster param to GET requests.
	 */
	public Boolean getDisableCaching() {
		if (null != this.disableCaching) {
			return this.disableCaching;
		}
		ValueExpression _ve = getValueExpression("disableCaching");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>disableCaching</code> property.
	 * </p>
	 */
	public void setDisableCaching(Boolean disableCaching) {
		this.disableCaching = disableCaching;
		handleConfig("disableCaching", disableCaching);
	}

	private Object headers;

	/**
	 * Request headers to set for the request.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getHeaders() {
		if (null != this.headers) {
			return this.headers;
		}
		ValueExpression _ve = getValueExpression("headers");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setHeaders(Object headers) {
		this.headers = headers;
		handleConfig("headers", headers);
	}

	private Object xmlData;

	/**
	 * XML document to use for the post. Note: This will be used instead of params for the post data. Any params will be
	 * appended to the URL.
	 * 
	 */
	@ClientConfig(JsonMode.Object)
	public Object getXmlData() {
		if (null != this.xmlData) {
			return this.xmlData;
		}
		ValueExpression _ve = getValueExpression("xmlData");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setXmlData(Object xmlData) {
		this.xmlData = xmlData;
		handleConfig("xmlData", xmlData);
	}

	private Object jsonData;

	/**
	 * JSON data to use as the post. Note: This will be used instead of params for the post data. Any params will be
	 * appended to the URL.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getJsonData() {
		if (null != this.jsonData) {
			return this.jsonData;
		}
		ValueExpression _ve = getValueExpression("jsonData");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setJsonData(Object jsonData) {
		this.jsonData = jsonData;
		handleConfig("jsonData", jsonData);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[8];
		}
		_values[0] = super.saveState(_context);
		_values[1] = callback;
		_values[2] = disableCaching;
		_values[3] = form;
		_values[4] = headers;
		_values[5] = isUpload;
		_values[6] = jsonData;
		_values[7] = xmlData;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.callback = (Object) _values[1];
		this.handleConfig("callback", this.callback);
		this.disableCaching = (Boolean) _values[2];
		this.handleConfig("disableCaching", this.disableCaching);
		this.form = (String) _values[3];
		this.handleConfig("form", this.form);
		this.headers = _values[4];
		this.handleConfig("headers", this.headers);
		this.isUpload = (Boolean) _values[5];
		this.handleConfig("isUpload", this.isUpload);
		this.jsonData = _values[6];
		this.handleConfig("jsonData", this.jsonData);
		this.xmlData = _values[7];
		this.handleConfig("xmlData", this.xmlData);
	}
}
