package ext.list;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;

/**
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
    <p>A Column definition class which renders boolean data fields.
    See the 
    <a ext:cls="Ext.list.Column" ext:member="xtype" href="output/Ext.list.Column.html#Ext.list.Column-xtype">xtype</a> config
    option of 
    <a ext:cls="Ext.list.Column" href="output/Ext.list.Column.html">Ext.list.Column</a> for more
    details.</p>
  </div>

 */

@InstanceOf("Ext.list.BooleanColumn")
@ParseConfigMode(ui = false, name = "columns", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Config)
public class BooleanColumn extends Column {
	public static final String COMPONENT_FAMILY = "Ext.list.BooleanColumn";

	/**
	 * <p>
	 * Create a new {@link Ext.list.BooleanColumn} instance with default property values.
	 * </p>
	 */
	public BooleanColumn() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			undefinedText
			,falseText
			,trueText
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
	
		
	private String undefinedText;
	
	/*
	 *
        
        
          undefinedText
         : String
        The string returned by the renderer when
        the column value is undefined (defaults to 
        ' ').
	 */
	
	public String getUndefinedText () {
		if (null != this.undefinedText) {
			return this.undefinedText;
		}
		ValueExpression _ve = getValueExpression("undefinedText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>undefinedText</code> property.
	 * </p>
	 */
	public void setUndefinedText (String  undefinedText) {
		this.undefinedText = undefinedText;
		this.handleConfig("undefinedText", undefinedText);
	}
    	
	private String falseText;
	
	/*
	 *
        
        
          falseText
         : String
        The string returned by the renderer when
        the column value is falsey (but not undefined) (defaults to
        
        'false').
	 */
	
	public String getFalseText () {
		if (null != this.falseText) {
			return this.falseText;
		}
		ValueExpression _ve = getValueExpression("falseText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>falseText</code> property.
	 * </p>
	 */
	public void setFalseText (String  falseText) {
		this.falseText = falseText;
		this.handleConfig("falseText", falseText);
	}
    	
	private String trueText;
	
	/*
	 *
        
        
          trueText
         : String
        The string returned by the renderer when
        the column value is not falsey (defaults to 
        'true').
	 */
	
	public String getTrueText () {
		if (null != this.trueText) {
			return this.trueText;
		}
		ValueExpression _ve = getValueExpression("trueText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>trueText</code> property.
	 * </p>
	 */
	public void setTrueText (String  trueText) {
		this.trueText = trueText;
		this.handleConfig("trueText", trueText);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
				_values[1] = undefinedText;	
				_values[2] = falseText;	
				_values[3] = trueText;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.undefinedText = (String) _values[1];
		this.handleConfig("undefinedText", this.undefinedText);
				this.falseText = (String) _values[2];
		this.handleConfig("falseText", this.falseText);
				this.trueText = (String) _values[3];
		this.handleConfig("trueText", this.trueText);
			}
}