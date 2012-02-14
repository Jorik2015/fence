package com.abner.fence.util;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.Predicate;

/**
 * @author Administrator the value and bean value null;
 */
public class StringPredicate implements Predicate {
	private String property;
	private String value;

	public StringPredicate(String property, String value) {
		this.property = property;
		this.value = value;
	}

	public boolean evaluate(Object object) {
		try {
			Object beanPropValue;
			if (property.indexOf(".") > 0) {
				beanPropValue = PropertyUtils.getNestedProperty(object,	property);
			} else {
				beanPropValue = PropertyUtils.getProperty(object, property);
			}

			return compare(beanPropValue, value);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
	}

	private boolean compare(Object beanValue, Object value) {
		if (beanValue == null)
			return value == null;

		if (value == null)
			return beanValue == null;

		return value.toString().equals(beanValue.toString());
	}
}
