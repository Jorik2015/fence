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
@XType("superboxselect")
@InstanceOf("Ext.ux.form.SuperBoxSelect")
public class SuperBoxSelect extends ComboBox {
	public static final String COMPONENT_FAMILY = "Ext.ux.form.SuperBoxSelect";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.form.SuperBoxSelect} instance with default property values.
	 * </p>
	 */
	public SuperBoxSelect() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			allowAddNewData
			,backspaceDeletesLastItem
			,classField
			,clearBtnCls
			,displayFieldTpl
			,extraItemCls
			,extraItemStyle
			,expandBtnCls
			,fixFocusOnTabSelect
			,forceFormValue
			,itemDelimiterKey
			,navigateItemsWithTab
			,pinList
			,preventDuplicates
			,queryValuesDelimiter
			,queryValuesIndicator
			,removeValuesFromStore
			,renderFieldBtns 
			,stackItems
			,styleField
			,supressClearValueRemoveEvents
			,validationEvent
			,valueDelimiter
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
	
		
	private Boolean allowAddNewData;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getAllowAddNewData () {
		if (null != this.allowAddNewData) {
			return this.allowAddNewData;
		}
		ValueExpression _ve = getValueExpression("allowAddNewData");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>allowAddNewData</code> property.
	 * </p>
	 */
	public void setAllowAddNewData (Boolean  allowAddNewData) {
		this.allowAddNewData = allowAddNewData;
		this.handleConfig("allowAddNewData", allowAddNewData);
	}
    	
	private Boolean backspaceDeletesLastItem;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getBackspaceDeletesLastItem () {
		if (null != this.backspaceDeletesLastItem) {
			return this.backspaceDeletesLastItem;
		}
		ValueExpression _ve = getValueExpression("backspaceDeletesLastItem");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>backspaceDeletesLastItem</code> property.
	 * </p>
	 */
	public void setBackspaceDeletesLastItem (Boolean  backspaceDeletesLastItem) {
		this.backspaceDeletesLastItem = backspaceDeletesLastItem;
		this.handleConfig("backspaceDeletesLastItem", backspaceDeletesLastItem);
	}
    	
	private String classField;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getClassField () {
		if (null != this.classField) {
			return this.classField;
		}
		ValueExpression _ve = getValueExpression("classField");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>classField</code> property.
	 * </p>
	 */
	public void setClassField (String  classField) {
		this.classField = classField;
		this.handleConfig("classField", classField);
	}
    	
	private String clearBtnCls;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getClearBtnCls () {
		if (null != this.clearBtnCls) {
			return this.clearBtnCls;
		}
		ValueExpression _ve = getValueExpression("clearBtnCls");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>clearBtnCls</code> property.
	 * </p>
	 */
	public void setClearBtnCls (String  clearBtnCls) {
		this.clearBtnCls = clearBtnCls;
		this.handleConfig("clearBtnCls", clearBtnCls);
	}
    	
	private String displayFieldTpl;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getDisplayFieldTpl () {
		if (null != this.displayFieldTpl) {
			return this.displayFieldTpl;
		}
		ValueExpression _ve = getValueExpression("displayFieldTpl");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>displayFieldTpl</code> property.
	 * </p>
	 */
	public void setDisplayFieldTpl (String  displayFieldTpl) {
		this.displayFieldTpl = displayFieldTpl;
		this.handleConfig("displayFieldTpl", displayFieldTpl);
	}
    	
	private String extraItemCls;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getExtraItemCls () {
		if (null != this.extraItemCls) {
			return this.extraItemCls;
		}
		ValueExpression _ve = getValueExpression("extraItemCls");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>extraItemCls</code> property.
	 * </p>
	 */
	public void setExtraItemCls (String  extraItemCls) {
		this.extraItemCls = extraItemCls;
		this.handleConfig("extraItemCls", extraItemCls);
	}
    	
	private String extraItemStyle;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getExtraItemStyle () {
		if (null != this.extraItemStyle) {
			return this.extraItemStyle;
		}
		ValueExpression _ve = getValueExpression("extraItemStyle");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>extraItemStyle</code> property.
	 * </p>
	 */
	public void setExtraItemStyle (String  extraItemStyle) {
		this.extraItemStyle = extraItemStyle;
		this.handleConfig("extraItemStyle", extraItemStyle);
	}
    	
	private String expandBtnCls;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getExpandBtnCls () {
		if (null != this.expandBtnCls) {
			return this.expandBtnCls;
		}
		ValueExpression _ve = getValueExpression("expandBtnCls");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>expandBtnCls</code> property.
	 * </p>
	 */
	public void setExpandBtnCls (String  expandBtnCls) {
		this.expandBtnCls = expandBtnCls;
		this.handleConfig("expandBtnCls", expandBtnCls);
	}
    	
	private Boolean fixFocusOnTabSelect;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getFixFocusOnTabSelect () {
		if (null != this.fixFocusOnTabSelect) {
			return this.fixFocusOnTabSelect;
		}
		ValueExpression _ve = getValueExpression("fixFocusOnTabSelect");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>fixFocusOnTabSelect</code> property.
	 * </p>
	 */
	public void setFixFocusOnTabSelect (Boolean  fixFocusOnTabSelect) {
		this.fixFocusOnTabSelect = fixFocusOnTabSelect;
		this.handleConfig("fixFocusOnTabSelect", fixFocusOnTabSelect);
	}
    	
	private Boolean forceFormValue;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getForceFormValue () {
		if (null != this.forceFormValue) {
			return this.forceFormValue;
		}
		ValueExpression _ve = getValueExpression("forceFormValue");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>forceFormValue</code> property.
	 * </p>
	 */
	public void setForceFormValue (Boolean  forceFormValue) {
		this.forceFormValue = forceFormValue;
		this.handleConfig("forceFormValue", forceFormValue);
	}
    	
	private Number itemDelimiterKey;
	
	/*
	 *$cfg.commonts
	 */
	
	public Number getItemDelimiterKey () {
		if (null != this.itemDelimiterKey) {
			return this.itemDelimiterKey;
		}
		ValueExpression _ve = getValueExpression("itemDelimiterKey");
		if (_ve != null) {
			return (Number) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>itemDelimiterKey</code> property.
	 * </p>
	 */
	public void setItemDelimiterKey (Number  itemDelimiterKey) {
		this.itemDelimiterKey = itemDelimiterKey;
		this.handleConfig("itemDelimiterKey", itemDelimiterKey);
	}
    	
	private Boolean navigateItemsWithTab;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getNavigateItemsWithTab () {
		if (null != this.navigateItemsWithTab) {
			return this.navigateItemsWithTab;
		}
		ValueExpression _ve = getValueExpression("navigateItemsWithTab");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>navigateItemsWithTab</code> property.
	 * </p>
	 */
	public void setNavigateItemsWithTab (Boolean  navigateItemsWithTab) {
		this.navigateItemsWithTab = navigateItemsWithTab;
		this.handleConfig("navigateItemsWithTab", navigateItemsWithTab);
	}
    	
	private Boolean pinList;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getPinList () {
		if (null != this.pinList) {
			return this.pinList;
		}
		ValueExpression _ve = getValueExpression("pinList");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>pinList</code> property.
	 * </p>
	 */
	public void setPinList (Boolean  pinList) {
		this.pinList = pinList;
		this.handleConfig("pinList", pinList);
	}
    	
	private Boolean preventDuplicates;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getPreventDuplicates () {
		if (null != this.preventDuplicates) {
			return this.preventDuplicates;
		}
		ValueExpression _ve = getValueExpression("preventDuplicates");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>preventDuplicates</code> property.
	 * </p>
	 */
	public void setPreventDuplicates (Boolean  preventDuplicates) {
		this.preventDuplicates = preventDuplicates;
		this.handleConfig("preventDuplicates", preventDuplicates);
	}
    	
	private String queryValuesDelimiter;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getQueryValuesDelimiter () {
		if (null != this.queryValuesDelimiter) {
			return this.queryValuesDelimiter;
		}
		ValueExpression _ve = getValueExpression("queryValuesDelimiter");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>queryValuesDelimiter</code> property.
	 * </p>
	 */
	public void setQueryValuesDelimiter (String  queryValuesDelimiter) {
		this.queryValuesDelimiter = queryValuesDelimiter;
		this.handleConfig("queryValuesDelimiter", queryValuesDelimiter);
	}
    	
	private String queryValuesIndicator;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getQueryValuesIndicator () {
		if (null != this.queryValuesIndicator) {
			return this.queryValuesIndicator;
		}
		ValueExpression _ve = getValueExpression("queryValuesIndicator");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>queryValuesIndicator</code> property.
	 * </p>
	 */
	public void setQueryValuesIndicator (String  queryValuesIndicator) {
		this.queryValuesIndicator = queryValuesIndicator;
		this.handleConfig("queryValuesIndicator", queryValuesIndicator);
	}
    	
	private Boolean removeValuesFromStore;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getRemoveValuesFromStore () {
		if (null != this.removeValuesFromStore) {
			return this.removeValuesFromStore;
		}
		ValueExpression _ve = getValueExpression("removeValuesFromStore");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>removeValuesFromStore</code> property.
	 * </p>
	 */
	public void setRemoveValuesFromStore (Boolean  removeValuesFromStore) {
		this.removeValuesFromStore = removeValuesFromStore;
		this.handleConfig("removeValuesFromStore", removeValuesFromStore);
	}
    	
	private Boolean renderFieldBtns ;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getRenderFieldBtns  () {
		if (null != this.renderFieldBtns ) {
			return this.renderFieldBtns ;
		}
		ValueExpression _ve = getValueExpression("renderFieldBtns ");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>renderFieldBtns </code> property.
	 * </p>
	 */
	public void setRenderFieldBtns  (Boolean  renderFieldBtns ) {
		this.renderFieldBtns  = renderFieldBtns ;
		this.handleConfig("renderFieldBtns ", renderFieldBtns );
	}
    	
	private Boolean stackItems;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getStackItems () {
		if (null != this.stackItems) {
			return this.stackItems;
		}
		ValueExpression _ve = getValueExpression("stackItems");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>stackItems</code> property.
	 * </p>
	 */
	public void setStackItems (Boolean  stackItems) {
		this.stackItems = stackItems;
		this.handleConfig("stackItems", stackItems);
	}
    	
	private String styleField;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getStyleField () {
		if (null != this.styleField) {
			return this.styleField;
		}
		ValueExpression _ve = getValueExpression("styleField");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>styleField</code> property.
	 * </p>
	 */
	public void setStyleField (String  styleField) {
		this.styleField = styleField;
		this.handleConfig("styleField", styleField);
	}
    	
	private Boolean supressClearValueRemoveEvents;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getSupressClearValueRemoveEvents () {
		if (null != this.supressClearValueRemoveEvents) {
			return this.supressClearValueRemoveEvents;
		}
		ValueExpression _ve = getValueExpression("supressClearValueRemoveEvents");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>supressClearValueRemoveEvents</code> property.
	 * </p>
	 */
	public void setSupressClearValueRemoveEvents (Boolean  supressClearValueRemoveEvents) {
		this.supressClearValueRemoveEvents = supressClearValueRemoveEvents;
		this.handleConfig("supressClearValueRemoveEvents", supressClearValueRemoveEvents);
	}
    	
	private String validationEvent;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getValidationEvent () {
		if (null != this.validationEvent) {
			return this.validationEvent;
		}
		ValueExpression _ve = getValueExpression("validationEvent");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>validationEvent</code> property.
	 * </p>
	 */
	public void setValidationEvent (String  validationEvent) {
		this.validationEvent = validationEvent;
		this.handleConfig("validationEvent", validationEvent);
	}
    	
	private String valueDelimiter;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getValueDelimiter () {
		if (null != this.valueDelimiter) {
			return this.valueDelimiter;
		}
		ValueExpression _ve = getValueExpression("valueDelimiter");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>valueDelimiter</code> property.
	 * </p>
	 */
	public void setValueDelimiter (String  valueDelimiter) {
		this.valueDelimiter = valueDelimiter;
		this.handleConfig("valueDelimiter", valueDelimiter);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[24];
		}
		_values[0] = super.saveState(_context);
				_values[1] = allowAddNewData;	
				_values[2] = backspaceDeletesLastItem;	
				_values[3] = classField;	
				_values[4] = clearBtnCls;	
				_values[5] = displayFieldTpl;	
				_values[6] = extraItemCls;	
				_values[7] = extraItemStyle;	
				_values[8] = expandBtnCls;	
				_values[9] = fixFocusOnTabSelect;	
				_values[10] = forceFormValue;	
				_values[11] = itemDelimiterKey;	
				_values[12] = navigateItemsWithTab;	
				_values[13] = pinList;	
				_values[14] = preventDuplicates;	
				_values[15] = queryValuesDelimiter;	
				_values[16] = queryValuesIndicator;	
				_values[17] = removeValuesFromStore;	
				_values[18] = renderFieldBtns ;	
				_values[19] = stackItems;	
				_values[20] = styleField;	
				_values[21] = supressClearValueRemoveEvents;	
				_values[22] = validationEvent;	
				_values[23] = valueDelimiter;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.allowAddNewData = (Boolean) _values[1];
		this.handleConfig("allowAddNewData", this.allowAddNewData);
				this.backspaceDeletesLastItem = (Boolean) _values[2];
		this.handleConfig("backspaceDeletesLastItem", this.backspaceDeletesLastItem);
				this.classField = (String) _values[3];
		this.handleConfig("classField", this.classField);
				this.clearBtnCls = (String) _values[4];
		this.handleConfig("clearBtnCls", this.clearBtnCls);
				this.displayFieldTpl = (String) _values[5];
		this.handleConfig("displayFieldTpl", this.displayFieldTpl);
				this.extraItemCls = (String) _values[6];
		this.handleConfig("extraItemCls", this.extraItemCls);
				this.extraItemStyle = (String) _values[7];
		this.handleConfig("extraItemStyle", this.extraItemStyle);
				this.expandBtnCls = (String) _values[8];
		this.handleConfig("expandBtnCls", this.expandBtnCls);
				this.fixFocusOnTabSelect = (Boolean) _values[9];
		this.handleConfig("fixFocusOnTabSelect", this.fixFocusOnTabSelect);
				this.forceFormValue = (Boolean) _values[10];
		this.handleConfig("forceFormValue", this.forceFormValue);
				this.itemDelimiterKey = (Number) _values[11];
		this.handleConfig("itemDelimiterKey", this.itemDelimiterKey);
				this.navigateItemsWithTab = (Boolean) _values[12];
		this.handleConfig("navigateItemsWithTab", this.navigateItemsWithTab);
				this.pinList = (Boolean) _values[13];
		this.handleConfig("pinList", this.pinList);
				this.preventDuplicates = (Boolean) _values[14];
		this.handleConfig("preventDuplicates", this.preventDuplicates);
				this.queryValuesDelimiter = (String) _values[15];
		this.handleConfig("queryValuesDelimiter", this.queryValuesDelimiter);
				this.queryValuesIndicator = (String) _values[16];
		this.handleConfig("queryValuesIndicator", this.queryValuesIndicator);
				this.removeValuesFromStore = (Boolean) _values[17];
		this.handleConfig("removeValuesFromStore", this.removeValuesFromStore);
				this.renderFieldBtns  = (Boolean) _values[18];
		this.handleConfig("renderFieldBtns ", this.renderFieldBtns );
				this.stackItems = (Boolean) _values[19];
		this.handleConfig("stackItems", this.stackItems);
				this.styleField = (String) _values[20];
		this.handleConfig("styleField", this.styleField);
				this.supressClearValueRemoveEvents = (Boolean) _values[21];
		this.handleConfig("supressClearValueRemoveEvents", this.supressClearValueRemoveEvents);
				this.validationEvent = (String) _values[22];
		this.handleConfig("validationEvent", this.validationEvent);
				this.valueDelimiter = (String) _values[23];
		this.handleConfig("valueDelimiter", this.valueDelimiter);
			}
}