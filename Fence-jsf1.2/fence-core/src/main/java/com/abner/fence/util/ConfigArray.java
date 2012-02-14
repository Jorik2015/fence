package com.abner.fence.util;

import java.util.ArrayList;
import java.util.List;

import ext.util.StringUtil;

public class ConfigArray {
	private List<Object> configs = new ArrayList<Object>();
	
	private ConfigArray(Object obj){
		if(!StringUtil.isEmpty(obj))
			configs.add(obj);
	}
	
	public static ConfigArray getArray(Object obj){
		return new ConfigArray(obj);
	}
	
	public void addConfig(Object obj){
		if(StringUtil.isEmpty(obj) || configs.contains(obj))
			return;
		
		configs.add(obj);
	}
	
	public String getConfig(){
		StringBuffer sb = new StringBuffer(64);
		sb.append("[");
		for(Object obj : configs){
			if(sb.length() > 1)
				sb.append(",");
			
			sb.append(obj.toString());
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public String toString() {
		return getConfig();
	}
}
