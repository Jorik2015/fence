package ext.event;


public class ExtEvent extends ExtFunction {
	private static String COMPONENT_TYPE = "Ext.ExtEvent";
	
	public ExtEvent(){
		super();
		this.setRendererType(COMPONENT_TYPE);
	}
	
	@Override
	public String getFamily() {
		return (COMPONENT_TYPE);
	}
}
