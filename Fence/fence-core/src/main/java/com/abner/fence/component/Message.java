package com.abner.fence.component;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import com.abner.fence.annotation.InstanceOf;

import ext.Window;

@InstanceOf("Ext.Window")
@FacesComponent("Ext.Message")
public class Message extends Window {
	public static final String COMPONENT_TYPE = "Ext.Message";
	public static final String COMPONENT_FAMILY = "Ext.Message";

	/**
	 * <p>
	 * Create a new {@link Window} instance with default property values.
	 * </p>
	 */
	public Message() {
		super();
		this.setNs("");
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private String forVal = null;
	private Boolean globalOnly;
	private boolean showDetail = false;
	private boolean showDetailSet = false;
	private boolean showSummary = true;
	private boolean showSummarySet = false;

	/**
	 * <p>
	 * Return the client identifier of the component for which this component represents associated message(s) (if any).
	 * </p>
	 */
	public String getFor() {

		if (this.forVal != null) {
			return (this.forVal);
		}
		ValueExpression ve = getValueExpression("for");
		if (ve != null) {
			try {
				return ((String) ve.getValue(getFacesContext().getELContext()));
			} catch (ELException e) {
				throw new FacesException(e);
			}
		} else {
			return (null);
		}

	}

	/**
	 * <p>
	 * Set the client identifier of the component for which this component represents associated message(s) (if any).
	 * This property must be set before the message is displayed.
	 * </p>
	 * 
	 * @param newFor
	 *            The new client id
	 */
	public void setFor(String newFor) {

		forVal = newFor;

	}

	/**
	 * <p>
	 * Return the flag indicating whether only global messages (that is, messages with no associated client identifier)
	 * should be rendered. Defaults to false.
	 * </p>
	 */
	public boolean isGlobalOnly() {

		if (this.globalOnly != null) {
			return (this.globalOnly);
		}
		ValueExpression ve = getValueExpression("globalOnly");
		if (ve != null) {
			try {
				return (Boolean.TRUE.equals(ve.getValue(getFacesContext().getELContext())));
			} catch (ELException e) {
				throw new FacesException(e);
			}
		} else {
			return (false);
		}

	}

	/**
	 * <p>
	 * Set the flag indicating whether only global messages (that is, messages with no associated client identifier)
	 * should be rendered.
	 * </p>
	 * 
	 * @param globalOnly
	 *            The new flag value
	 */
	public void setGlobalOnly(boolean globalOnly) {

		this.globalOnly = globalOnly;

	}

	/**
	 * <p>
	 * Return the flag indicating whether the <code>detail</code> property of the associated message(s) should be
	 * displayed. Defaults to <code>true</code>.
	 * </p>
	 */
	public boolean isShowDetail() {

		if (this.showDetailSet) {
			return (this.showDetail);
		}
		ValueExpression ve = getValueExpression("showDetail");
		if (ve != null) {
			try {
				return (Boolean.TRUE.equals(ve.getValue(getFacesContext().getELContext())));
			} catch (ELException e) {
				throw new FacesException(e);
			}
		} else {
			return (this.showDetail);
		}

	}

	/**
	 * <p>
	 * Set the flag indicating whether the <code>detail</code> property of the associated message(s) should be
	 * displayed.
	 * </p>
	 * 
	 * @param showDetail
	 *            The new flag
	 */
	public void setShowDetail(boolean showDetail) {
		this.showDetail = showDetail;
		this.showDetailSet = true;
	}

	/**
	 * <p>
	 * Return the flag indicating whether the <code>summary</code> property of the associated message(s) should be
	 * displayed. Defaults to <code>false</code>.
	 * </p>
	 */
	public boolean isShowSummary() {

		if (this.showSummarySet) {
			return (this.showSummary);
		}
		ValueExpression ve = getValueExpression("showSummary");
		if (ve != null) {
			try {
				return (!Boolean.FALSE.equals(ve.getValue(getFacesContext().getELContext())));
			} catch (ELException e) {
				throw new FacesException(e);
			}
		} else {
			return (this.showSummary);
		}

	}

	/**
	 * <p>
	 * Set the flag indicating whether the <code>summary</code> property of the associated message(s) should be
	 * displayed.
	 * </p>
	 * 
	 * @param showSummary
	 *            The new flag value
	 */
	public void setShowSummary(boolean showSummary) {

		this.showSummary = showSummary;
		this.showSummarySet = true;

	}

	// ----------------------------------------------------- StateHolder Methods

	private Object[] values;

	public Object saveState(FacesContext context) {

		if (values == null) {
			values = new Object[7];
		}

		values[0] = super.saveState(context);
		values[1] = this.forVal;
		values[2] = this.globalOnly;
		values[3] = this.showDetail;
		values[4] = this.showDetailSet;
		values[5] = this.showSummary;
		values[6] = this.showSummarySet;
		return (values);

	}

	public void restoreState(FacesContext context, Object state) {

		values = (Object[]) state;
		super.restoreState(context, values[0]);
		forVal = (String) values[1];
		globalOnly = (Boolean) values[2];
		showDetail = (Boolean) values[3];
		showDetailSet = (Boolean) values[4];
		showSummary = (Boolean) values[5];
		showSummarySet = (Boolean) values[6];

	}

}
