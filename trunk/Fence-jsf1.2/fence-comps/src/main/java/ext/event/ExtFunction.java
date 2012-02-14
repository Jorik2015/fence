package ext.event;

import javax.faces.context.FacesContext;

import ext.base.ExtOutput;

public class ExtFunction extends ExtOutput {
	private static String COMPONENT_TYPE = "Ext.ExtFunction";

	private String name;
	private String handler;
	private String args;

	public ExtFunction() {
		super();
		this.setRendererType(COMPONENT_TYPE);
	}

	@Override
	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	private Object[] values;

	@Override
	public void restoreState(FacesContext context, Object state) {
		this.values = (Object[]) state;
		super.restoreState(context, values[0]);
		this.name = (String) values[1];
		this.handler = (String) values[2];
		this.args = (String) values[3];
	}

	@Override
	public Object saveState(FacesContext context) {
		if (values == null)
			values = new Object[4];
		values[0] = super.saveState(context);
		values[1] = this.name;
		values[2] = this.handler;
		values[3] = this.args;
		return values;
	}
}
