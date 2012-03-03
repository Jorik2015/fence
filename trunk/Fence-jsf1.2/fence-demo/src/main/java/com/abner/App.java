package com.abner;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.abner.fence.web.Params;

import ext.util.FacesUtils;

@Component("app")
@Scope("globalSession")
public class App implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3758418073764761968L;

	public String getAppPath() {
		HttpServletRequest req = (HttpServletRequest) FacesUtils.extContext().getRequest();
		String url = req.getRequestURL().toString();
		int end = url.indexOf("/",8);
		url = url.substring(0,end);
		return url+FacesUtils.extContext().getRequestContextPath();
	}
	
	public String getTime(){
		String result = DateFormatUtils.format(Calendar.getInstance(),"yyyy-MM-dd HH:mm:ss");
		if(Params.getParam("customParam").isNotNull()){
			result += " Params:" + Params.getParam("customParam").getStringValue();
		}
		return result;
	}
		
	public static void main(String[] args){
		Calendar c = new GregorianCalendar(1900, Calendar.JANUARY, 0);
		c.setTimeZone(TimeZone.getDefault());
//		c.setTimeInMillis(0);
		c.add(Calendar.DATE, 60);
//		c.add(Calendar.YEAR, -70);
//		c.add(Calendar.DAY_OF_MONTH, -1);
		System.out.print(c.getTime());
	}
}
