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
	private String version = ExtUtils.VERSION;
	private String  adapter = "ext";
	
	/**
	 */
	private static final long serialVersionUID = 3789767031124785501L;


	public boolean isDebug() {
		FacesContext context = FacesUtils.context();
		return context.isProjectStage(ProjectStage.Development);
	}

	public String getDebugSuffix() {
		if (this.isDebug())
			return "-debug";

		return "";
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAdapter() {
		return adapter;
	}

	public void setAdapter(String adapter) {
		this.adapter = adapter;
	}
}
