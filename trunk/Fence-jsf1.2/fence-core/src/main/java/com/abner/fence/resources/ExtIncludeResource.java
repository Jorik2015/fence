/**
 * 
 */
package com.abner.fence.resources;

import javax.faces.context.FacesContext;

import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.base.ExtOutput;

/**
 * @author Administrator
 * 
 */
@ParseConfigMode(pmode = PersistenceMode.Component)
public class ExtIncludeResource extends ExtOutput {
	private static final String ComponentType = "Ext.ExtIncludeResource";

	@Override
	public String getFamily() {
		this.setRendererType(ComponentType);
		return (ComponentType);
	}

	private String library;

	private String src;

	public String getLibrary() {
		return library;
	}

	public void setLibrary(String library) {
		this.library = library;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	private Object[] _values;

	@Override
	public void restoreState(FacesContext context, Object state) {
		_values = (Object[]) state;
		super.restoreState(context, _values[0]);
		this.library = (String) _values[1];
		this.src = (String) _values[2];
	}

	@Override
	public Object saveState(FacesContext context) {
		if (_values == null)
			_values = new Object[3];

		_values[0] = super.saveState(context);
		_values[1] = library;
		_values[2] = src;
		return _values;
	}
}
