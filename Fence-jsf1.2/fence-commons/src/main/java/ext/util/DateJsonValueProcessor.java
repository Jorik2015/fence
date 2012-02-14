package ext.util;

import java.text.SimpleDateFormat;

import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import ext.util.StringUtil;

public class DateJsonValueProcessor implements JsonValueProcessor {
	public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private String pattern;
	
	public DateJsonValueProcessor(){
		this.pattern = DEFAULT_PATTERN;
	}
	
	public DateJsonValueProcessor(String pattern){
		if(StringUtil.isEmpty(pattern))
			pattern = DEFAULT_PATTERN;
		
		this.pattern = pattern;
	}

	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		return processObjectValue(null,value,jsonConfig);
	}

	public Object processObjectValue(String key, Object value,
			JsonConfig jsonConfig) {
		if(StringUtil.isEmpty(value))
			return null;
		SimpleDateFormat df= new SimpleDateFormat(pattern);
		return df.format(value);
	}

	public static Morpher getDateMorpher(){
		String[] dateFormats = new String[] {DEFAULT_PATTERN};
		return new DateMorpher(dateFormats); 
	}
}
