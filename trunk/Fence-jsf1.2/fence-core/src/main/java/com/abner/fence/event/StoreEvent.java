package com.abner.fence.event;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

public class StoreEvent extends ActionEvent {
	private static final long serialVersionUID = 5525812462414989316L;
	private String data;
	private String xaction;
	private List<?> removed;
	private List<?> changed;
	private List<?> created;

	public StoreEvent(UIComponent component) {
		super(component);
	}

	public List<?> getRemoved() {
		return removed;
	}

	public void setRemoved(List<?> removed) {
		this.removed = removed;
	}

	public List<?> getChanged() {
		return changed;
	}

	public void setChanged(List<?> changed) {
		this.changed = changed;
	}

	public List<?> getCreated() {
		return created;
	}

	public void setCreated(List<?> created) {
		this.created = created;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getXaction() {
		return xaction;
	}

	public void setXaction(String xaction) {
		this.xaction = xaction;
	}
}
