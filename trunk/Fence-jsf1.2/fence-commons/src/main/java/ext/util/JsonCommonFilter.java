package ext.util;

import net.sf.json.util.PropertyFilter;

public class JsonCommonFilter implements PropertyFilter {
	private PropertyFilter filter;

	public JsonCommonFilter() {
	}

	public JsonCommonFilter(PropertyFilter filter) {
		this.filter = filter;
	}

	public boolean apply(Object source, String name, Object value) {
		if(source == null)
			return true;
		
		if(source.getClass().getName().startsWith("org.hibernate"))
			return true;
		
		if("delegate".equals(name))
			return true;
		
		if(filter != null && filter.apply(source, name, value))
			return true;
			
		return false;
	}
}
