package com.abner.fence.commons;

import com.abner.fence.commons.Enums.PersistenceMode;
import com.abner.fence.commons.Enums.ReferenceMode;

public class ExtComponentMetaData {
	private PersistenceMode pmode = PersistenceMode.Component;
	private ReferenceMode rmode = ReferenceMode.Var;
	private String refName;
	private String instanceOf;
	private String xtype;
	private boolean ui = true;
	private boolean id = true;

	public PersistenceMode getPmode() {
		return pmode;
	}

	public void setPmode(PersistenceMode pmode) {
		this.pmode = pmode;
	}

	public ReferenceMode getRmode() {
		return rmode;
	}

	public void setRmode(ReferenceMode rmode) {
		this.rmode = rmode;
	}

	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
	}

	public String getInstanceOf() {
		return instanceOf;
	}

	public void setInstanceOf(String instanceOf) {
		this.instanceOf = instanceOf;
	}

	public String getXtype() {
		return xtype;
	}

	public void setXtype(String xtype) {
		this.xtype = xtype;
	}

	public boolean isUi() {
		return ui;
	}

	public void setUi(boolean ui) {
		this.ui = ui;
	}

	public boolean isId() {
		return id;
	}

	public void setId(boolean id) {
		this.id = id;
	}
}
