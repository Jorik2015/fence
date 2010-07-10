package com.abner.fence.web;

import java.util.Map;

import com.abner.fence.commons.AttributeValue;
import com.abner.fence.utils.FacesUtils;

public final class Params {
	public static AttributeValue getParam(String key) {
		Map<String, String> params = FacesUtils.extContext().getRequestParameterMap();
		return new AttributeValue(params.get(key));
	}
}