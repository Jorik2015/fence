package ext.base;

import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import ext.util.AttributeValue;

public interface IExt {
	void handleConfig(String key, Object value);

	AttributeValue getConfigValue(String key);

	Map<String, AttributeValue> getAllConfig();

	StringBuilder getBeforeScript();

	StringBuilder getAfterScript();
	
	String getVar();

	String getRefer();

	String getId();

	String getClientId(FacesContext context);

	String getFamily();

	UIComponent getParent();
	
	String getNs();
	
	void setNs(String ns);

	int getChildCount();

	List<UIComponent> getChildren();

	Map<String, Object> getAttributes();
}
