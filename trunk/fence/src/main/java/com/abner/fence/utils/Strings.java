package com.abner.fence.utils;

import java.util.Properties;

public class Strings {
	public static String ifNull(Object o, String s) {
		return o == null ? s : o.toString();
	}

	public static String ifEmpty(Object o, String s) {
		return isEmpty(o) ? s : o.toString();
	}

	public static String dotString(String str) {
		if (isEmpty(str))
			return "\"\"";

		return "\"" + str + "\"";
	}

	public static String emptyIfNull(Object o) {
		return o == null ? "" : o.toString();
	}

	public static String nullIfEmpty(Object o) {
		if (o == null || o.toString().trim().length() == 0)
			return null;
		return o.toString();
	}

	public static boolean isEmpty(Object o) {
		return o == null || o.toString().trim().length() == 0;
	}

	public static boolean isNotEmpty(Object o) {
		return !isEmpty(o);
	}

	public static String fillString(char c, int count) {
		char[] chars = new char[count];
		for (int i = 0; i < count; i++)
			chars[i] = c;
		return new String(chars);
	}

	public static String join(String separator, String[] parts) {
		if (parts == null)
			return "";
		StringBuffer sb = new StringBuffer(256);
		for (int i = 0; i < parts.length; i++) {
			if (i > 0)
				sb.append(separator);
			sb.append(parts[i]);
		}
		return sb.toString();
	}

	public static Properties toProperties(String params) {
		Properties properties = new Properties();
		if (!isEmpty(params)) {
			for (String s : params.split(",")) {
				int pos = s.indexOf(':');
				if (pos < 0)
					continue;
				properties.put(s.substring(0, pos).trim(), s.substring(pos + 1).trim());
			}
		}
		return properties;
	}

	public static boolean toBoolean(String s, boolean defaultValue) {
		if (isEmpty(s))
			return defaultValue;
		return Boolean.parseBoolean(s);
	}

	public static String upperFirstChar(String str) {
		if (isEmpty(str))
			return "";

		String result = str.substring(0, 1).toUpperCase();
		if (str.length() > 1)
			result += str.substring(1);

		return result;
	}

	public static int toInt(String s, int defaultValue) {
		if (isEmpty(s))
			return defaultValue;
		return Integer.parseInt(s);
	}

}
