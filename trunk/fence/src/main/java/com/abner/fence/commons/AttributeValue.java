package com.abner.fence.commons;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import com.abner.fence.utils.Strings;

public class AttributeValue {
	private Object obj;

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public boolean isBooleanValue() {
		if (obj == null)
			return false;

		return "true".equals(obj.toString().toLowerCase()) || "false".equals(obj.toString().toLowerCase());
	}

	public boolean isNull() {
		return obj == null;
	}

	public boolean isNotNull() {
		return obj != null;
	}

	@SuppressWarnings("unchecked")
	public boolean isEmpty() {
		if (obj == null)
			return true;

		if (obj.toString() == null)
			return true;

		if (obj.toString().length() == 0)
			return true;

		if (obj instanceof Collection) {
			return ((Collection) obj).isEmpty();
		} else if (obj instanceof Map) {
			return ((Map) obj).isEmpty();
		}

		return false;
	}

	public AttributeValue(Object obj) {
		this.obj = obj;
	}

	public Object getRawValue() {
		return obj;
	}

	public String getStringValue() {
		return Strings.isEmpty(obj) ? "" : obj.toString();
	}

	public int getIntValue() {
		return Strings.isEmpty(obj) ? 0 : Integer.parseInt(obj.toString());
	}

	public long getLongValue() {
		return Strings.isEmpty(obj) ? 0 : Long.parseLong(obj.toString());
	}

	public short getShortValue() {
		return Strings.isEmpty(obj) ? 0 : Short.parseShort(obj.toString());
	}

	public double getDoubleValue() {
		return Strings.isEmpty(obj) ? 0 : Double.parseDouble(obj.toString());
	}

	public float getFloatValue() {
		return Strings.isEmpty(obj) ? 0 : Float.parseFloat(obj.toString());
	}

	public boolean getBooleanValue() {
		return Strings.isEmpty(obj) ? false : Boolean.parseBoolean(obj.toString());
	}

	// FIXME date pattern should be configurable
	public Date getDateValue() {
		DateFormat dateFormat = new SimpleDateFormat();
		try {
			return Strings.isEmpty(obj) ? dateFormat.parse("1900-1-1") : dateFormat.parse(obj.toString());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String toString() {
		return obj.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return this.obj == null;
		if (obj instanceof AttributeValue)
			return this.obj.equals(((AttributeValue) obj).toString());
		return this.obj.equals(obj);
	}
}
