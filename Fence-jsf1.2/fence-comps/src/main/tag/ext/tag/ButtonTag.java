package ext.tag;

import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

public class ButtonTag extends UIComponentELTag {
	public static final String COMPONENT_TYPE = "Ext.Button";

	@Override
	public String getComponentType() {
		return (COMPONENT_TYPE);
	}

	@Override
	public String getRendererType() {
		return (COMPONENT_TYPE);
	}

	// PROPERTY: text
    private javax.el.ValueExpression text;
    public void setText(javax.el.ValueExpression text) {
        this.text = text;
    }
    
    protected void setProperties(UIComponent component) {
        super.setProperties(component);
        javax.faces.component.UIInput input = null;
        try {
            input = (javax.faces.component.UIInput) component;
        } catch (ClassCastException cce) {
            throw new IllegalStateException("Component " + component.toString() + " not expected type.  Expected: javax.faces.component.UIInput.  Perhaps you're missing a tag?");
        }

        if (text != null) {
            input.setValueExpression("text", text);
        }
    }
}
