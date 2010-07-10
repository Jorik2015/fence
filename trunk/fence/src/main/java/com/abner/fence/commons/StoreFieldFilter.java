package com.abner.fence.commons;

import net.sf.json.util.PropertyFilter;
import ext.data.Store;

public class StoreFieldFilter implements PropertyFilter {
	// private Store store;
	private JsonCommonFilter commonFilter = new JsonCommonFilter();

	public StoreFieldFilter(Store store) {
		// this.store = store;
	}

	public boolean apply(Object source, String name, Object value) {
		if (commonFilter.apply(source, name, value))
			return true;

		return false;
		/*
		 * List<Field> fields = this.guessFields(); if (fields.isEmpty()) return false;
		 * 
		 * for (Field field : fields) { String mapping = field.getMapping(); if (mapping == null) { if
		 * (name.equals(field.getName())) return false; } else { if (mapping.indexOf(".") > 0) { List<String> strs =
		 * Arrays.asList(mapping.split("\\.")); if (strs.contains(name)) return false; } else { if
		 * (mapping.equals(name)) return false; } } }
		 * 
		 * return true;
		 */
	}

	/*
	 * private List<Field> guessFields() { List<Field> fields = new ArrayList<Field>(); fields =
	 * ComponentUtil.findComponents(this.store, Field.class); if (fields.isEmpty()) { DataReader reader =
	 * ComponentUtil.getFirstExtChild(this.store, DataReader.class); if (reader != null) fields =
	 * ComponentUtil.findComponents(reader, Field.class); } return fields; }
	 */
}
