package ext.list;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.base.ExtOutput;

/**
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
    <p>This class encapsulates column configuration data to be used
    in the initialization of a 
    <a ext:cls="Ext.list.ListView" href="output/Ext.list.ListView.html">ListView</a>.</p>
    <p>While subclasses are provided to render data in different
    ways, this class renders a passed data field unchanged and is
    usually used for textual columns.</p>
  </div>

 */

@InstanceOf("Ext.list.Column")
@ParseConfigMode(ui = false, name = "columns", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Config)
public class Column extends ExtOutput {
	public static final String COMPONENT_FAMILY = "Ext.list.Column";

	/**
	 * <p>
	 * Create a new {@link Ext.list.Column} instance with default property values.
	 * </p>
	 */
	public Column() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			cls
			,width
			,align
			,tpl
			,dataIndex
			,header
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
	
		
	private String cls;
	
	/*
	 *
        
        
          cls
         : String
        Optional. This option can be used to add
        a CSS class to the cell of each row for this
        column.
	 */
	
	public String getCls () {
		if (null != this.cls) {
			return this.cls;
		}
		ValueExpression _ve = getValueExpression("cls");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>cls</code> property.
	 * </p>
	 */
	public void setCls (String  cls) {
		this.cls = cls;
		this.handleConfig("cls", cls);
	}
    	
	private Integer width;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. Percentage of the container
          width this column should be allocated. Columns that have
          no width specified will be allocated with an equal
          percentage to fill 100% of the container width. To easily
          take advantage of the full container width, leave the
          width of at least one column undefined. Note that if you
          do not want to take up the full width of the container,
          the width of every column needs to be explicitly
          defined.</div>

	 */
	
	public Integer getWidth () {
		if (null != this.width) {
			return this.width;
		}
		ValueExpression _ve = getValueExpression("width");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>width</code> property.
	 * </p>
	 */
	public void setWidth (Integer  width) {
		this.width = width;
		this.handleConfig("width", width);
	}
    	
	private String align;
	
	/*
	 *
        
        
          align
         : String
        Set the CSS text-align property of the
        column. Defaults to 
        'left'.
	 */
	
	public String getAlign () {
		if (null != this.align) {
			return this.align;
		}
		ValueExpression _ve = getValueExpression("align");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>align</code> property.
	 * </p>
	 */
	public void setAlign (String  align) {
		this.align = align;
		this.handleConfig("align", align);
	}
    	
	private String tpl;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. Specify a string to pass as
          the configuration string for 
          <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">Ext.XTemplate</a>. By default an 
          <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">Ext.XTemplate</a> will be
          implicitly created using the 
          <tt>dataIndex</tt>.</div>

	 */
	
	public String getTpl () {
		if (null != this.tpl) {
			return this.tpl;
		}
		ValueExpression _ve = getValueExpression("tpl");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>tpl</code> property.
	 * </p>
	 */
	public void setTpl (String  tpl) {
		this.tpl = tpl;
		this.handleConfig("tpl", tpl);
	}
    	
	private String dataIndex;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>
            <b>Required</b>. The name of the field in the
            ListViews's 
            <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a>'s 
            <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a>
            definition from which to draw the column's value.</p>
          </div>

	 */
	
	public String getDataIndex () {
		if (null != this.dataIndex) {
			return this.dataIndex;
		}
		ValueExpression _ve = getValueExpression("dataIndex");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>dataIndex</code> property.
	 * </p>
	 */
	public void setDataIndex (String  dataIndex) {
		this.dataIndex = dataIndex;
		this.handleConfig("dataIndex", dataIndex);
	}
    	
	private String header;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. The header text to be used as
          innerHTML (html tags are accepted) to display in the
          ListView. 
          <b>Note</b>: to have a clickable header with no text
          displayed use 
          <tt>' '</tt>.</div>

	 */
	
	public String getHeader () {
		if (null != this.header) {
			return this.header;
		}
		ValueExpression _ve = getValueExpression("header");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>header</code> property.
	 * </p>
	 */
	public void setHeader (String  header) {
		this.header = header;
		this.handleConfig("header", header);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[7];
		}
		_values[0] = super.saveState(_context);
				_values[1] = cls;	
				_values[2] = width;	
				_values[3] = align;	
				_values[4] = tpl;	
				_values[5] = dataIndex;	
				_values[6] = header;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.cls = (String) _values[1];
		this.handleConfig("cls", this.cls);
				this.width = (Integer) _values[2];
		this.handleConfig("width", this.width);
				this.align = (String) _values[3];
		this.handleConfig("align", this.align);
				this.tpl = (String) _values[4];
		this.handleConfig("tpl", this.tpl);
				this.dataIndex = (String) _values[5];
		this.handleConfig("dataIndex", this.dataIndex);
				this.header = (String) _values[6];
		this.handleConfig("header", this.header);
			}
}