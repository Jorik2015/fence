package com.abner.fence.web;

import java.io.Serializable;

import javax.faces.application.ProjectStage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.abner.fence.utils.ExtUtils;
import com.abner.fence.utils.FacesUtils;

@ManagedBean
@SessionScoped
public class Ext implements Serializable {
	/**
	 */
	private static final long serialVersionUID = 3789767031124785501L;

	public String getVersion() {
		return ExtUtils.VERSION;
	}

	public boolean isDebug() {
		FacesContext context = FacesUtils.context();
		return context.isProjectStage(ProjectStage.Development);
	}

	public String getDebugSuffix() {
		if (this.isDebug())
			return "-debug";

		return "";
	}

	public String getAdapter() {
		return "ext";
	}
}
