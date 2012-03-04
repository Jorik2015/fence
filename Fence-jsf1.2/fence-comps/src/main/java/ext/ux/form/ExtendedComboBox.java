package ext.ux.form;

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
@XType("extendedComboBox")
@InstanceOf("Ext.ux.form.ExtendedComboBox")
public class ExtendedComboBox extends ComboBox {
	public static final String COMPONENT_FAMILY = "Ext.ux.form.ExtendedComboBox";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.form.ExtendedComboBox} instance with default property values.
	 * </p>
	 */
	public ExtendedComboBox() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			singleSelect
			,showSelectAll
			,allSelectionText
			,selectAllOnLoad
			,showSearch
			,limitSelection
			,checkField
			,separator
			,minItemCountForBbar
			,maxCharLength
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
	
		
	private Boolean singleSelect;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getSingleSelect () {
		if (null != this.singleSelect) {
			return this.singleSelect;
		}
		ValueExpression _ve = getValueExpression("singleSelect");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>singleSelect</code> property.
	 * </p>
	 */
	public void setSingleSelect (Boolean  singleSelect) {
		this.singleSelect = singleSelect;
		this.handleConfig("singleSelect", singleSelect);
	}
    	
	private Boolean showSelectAll;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getShowSelectAll () {
		if (null != this.showSelectAll) {
			return this.showSelectAll;
		}
		ValueExpression _ve = getValueExpression("showSelectAll");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>showSelectAll</code> property.
	 * </p>
	 */
	public void setShowSelectAll (Boolean  showSelectAll) {
		this.showSelectAll = showSelectAll;
		this.handleConfig("showSelectAll", showSelectAll);
	}
    	
	private String allSelectionText;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getAllSelectionText () {
		if (null != this.allSelectionText) {
			return this.allSelectionText;
		}
		ValueExpression _ve = getValueExpression("allSelectionText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>allSelectionText</code> property.
	 * </p>
	 */
	public void setAllSelectionText (String  allSelectionText) {
		this.allSelectionText = allSelectionText;
		this.handleConfig("allSelectionText", allSelectionText);
	}
    	
	private Boolean selectAllOnLoad;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getSelectAllOnLoad () {
		if (null != this.selectAllOnLoad) {
			return this.selectAllOnLoad;
		}
		ValueExpression _ve = getValueExpression("selectAllOnLoad");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>selectAllOnLoad</code> property.
	 * </p>
	 */
	public void setSelectAllOnLoad (Boolean  selectAllOnLoad) {
		this.selectAllOnLoad = selectAllOnLoad;
		this.handleConfig("selectAllOnLoad", selectAllOnLoad);
	}
    	
	private Boolean showSearch;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getShowSearch () {
		if (null != this.showSearch) {
			return this.showSearch;
		}
		ValueExpression _ve = getValueExpression("showSearch");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>showSearch</code> property.
	 * </p>
	 */
	public void setShowSearch (Boolean  showSearch) {
		this.showSearch = showSearch;
		this.handleConfig("showSearch", showSearch);
	}
    	
	private Integer limitSelection;
	
	/*
	 *$cfg.commonts
	 */
	
	public Integer getLimitSelection () {
		if (null != this.limitSelection) {
			return this.limitSelection;
		}
		ValueExpression _ve = getValueExpression("limitSelection");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>limitSelection</code> property.
	 * </p>
	 */
	public void setLimitSelection (Integer  limitSelection) {
		this.limitSelection = limitSelection;
		this.handleConfig("limitSelection", limitSelection);
	}
    	
	private String checkField;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getCheckField () {
		if (null != this.checkField) {
			return this.checkField;
		}
		ValueExpression _ve = getValueExpression("checkField");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>checkField</code> property.
	 * </p>
	 */
	public void setCheckField (String  checkField) {
		this.checkField = checkField;
		this.handleConfig("checkField", checkField);
	}
    	
	private String separator;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getSeparator () {
		if (null != this.separator) {
			return this.separator;
		}
		ValueExpression _ve = getValueExpression("separator");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>separator</code> property.
	 * </p>
	 */
	public void setSeparator (String  separator) {
		this.separator = separator;
		this.handleConfig("separator", separator);
	}
    	
	private Integer minItemCountForBbar;
	
	/*
	 *$cfg.commonts
	 */
	
	public Integer getMinItemCountForBbar () {
		if (null != this.minItemCountForBbar) {
			return this.minItemCountForBbar;
		}
		ValueExpression _ve = getValueExpression("minItemCountForBbar");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>minItemCountForBbar</code> property.
	 * </p>
	 */
	public void setMinItemCountForBbar (Integer  minItemCountForBbar) {
		this.minItemCountForBbar = minItemCountForBbar;
		this.handleConfig("minItemCountForBbar", minItemCountForBbar);
	}
    	
	private Integer maxCharLength;
	
	/*
	 *$cfg.commonts
	 */
	
	public Integer getMaxCharLength () {
		if (null != this.maxCharLength) {
			return this.maxCharLength;
		}
		ValueExpression _ve = getValueExpression("maxCharLength");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>maxCharLength</code> property.
	 * </p>
	 */
	public void setMaxCharLength (Integer  maxCharLength) {
		this.maxCharLength = maxCharLength;
		this.handleConfig("maxCharLength", maxCharLength);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[11];
		}
		_values[0] = super.saveState(_context);
				_values[1] = singleSelect;	
				_values[2] = showSelectAll;	
				_values[3] = allSelectionText;	
				_values[4] = selectAllOnLoad;	
				_values[5] = showSearch;	
				_values[6] = limitSelection;	
				_values[7] = checkField;	
				_values[8] = separator;	
				_values[9] = minItemCountForBbar;	
				_values[10] = maxCharLength;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.singleSelect = (Boolean) _values[1];
		this.handleConfig("singleSelect", this.singleSelect);
				this.showSelectAll = (Boolean) _values[2];
		this.handleConfig("showSelectAll", this.showSelectAll);
				this.allSelectionText = (String) _values[3];
		this.handleConfig("allSelectionText", this.allSelectionText);
				this.selectAllOnLoad = (Boolean) _values[4];
		this.handleConfig("selectAllOnLoad", this.selectAllOnLoad);
				this.showSearch = (Boolean) _values[5];
		this.handleConfig("showSearch", this.showSearch);
				this.limitSelection = (Integer) _values[6];
		this.handleConfig("limitSelection", this.limitSelection);
				this.checkField = (String) _values[7];
		this.handleConfig("checkField", this.checkField);
				this.separator = (String) _values[8];
		this.handleConfig("separator", this.separator);
				this.minItemCountForBbar = (Integer) _values[9];
		this.handleConfig("minItemCountForBbar", this.minItemCountForBbar);
				this.maxCharLength = (Integer) _values[10];
		this.handleConfig("maxCharLength", this.maxCharLength);
			}
}