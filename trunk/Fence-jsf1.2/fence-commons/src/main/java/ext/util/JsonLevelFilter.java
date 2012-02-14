package ext.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.json.util.PropertyFilter;

public class JsonLevelFilter implements PropertyFilter {
	private Integer level = 3;
	private Map<Integer, Set<Object>> cache = new HashMap<Integer, Set<Object>>();
	private Map<Integer, Set<String>> cacheKey = new HashMap<Integer, Set<String>>();

	public JsonLevelFilter() {
	}

	public JsonLevelFilter(Integer level) {
		this.level = level;
		if (this.level < 1)
			throw new IllegalArgumentException("The fileter level must be more than 1.");
	}

	public boolean apply(Object source, String name, Object value) {
		if (value == null)
			return false;

		assert null != source;

		int sourceLevel = this.getCache(source);

		String methodName = "get" + StringUtil.upperFirstChar(name);
		Method m = ClassUtils.lookupMethod(source.getClass(), methodName);
		if (m == null) {
			methodName = "is" + StringUtil.upperFirstChar(name);
			m = ClassUtils.lookupMethod(source.getClass(), methodName);
		}
		Class<?> clazz = m.getReturnType();

		// 第一次进入
		if (sourceLevel < 0) {
			Set<Object> sourceCache = cache.get(1);
			if (sourceCache == null)
				sourceCache = new HashSet<Object>();
			sourceCache.add(source);
			cache.put(1, sourceCache);
			
			sourceCache = cache.get(2);
			if (sourceCache == null)
				sourceCache = new HashSet<Object>();
			sourceCache.add(value);
			cache.put(2, sourceCache);

			if (level < 2) {
				// 如果是基本类型等，则不缓存,
				if (!clazz.isPrimitive()
						&& !clazz.getName().equals("java.lang.String")
						&& !ClassUtils.isRepresentsPrimitive(clazz)
						&& !ClassUtils.isDate(clazz)) {
					// 否则缓存，将在下一步中不处理。
					Set<String> levelKey = cacheKey.get(1);
					if (levelKey == null)
						levelKey = new HashSet<String>();
					levelKey.add(name);
					cacheKey.put(1, levelKey);
				}
			}
		} else if (sourceLevel < level) {
			int keyLevel = this.getCacheKey(name);
			if (keyLevel > 0) {
				return true;
			}
			if (clazz.isPrimitive()
					|| clazz.getName().equals("java.lang.String")
					|| ClassUtils.isRepresentsPrimitive(clazz)
					|| ClassUtils.isDate(clazz)) {
				return false;
			} else {
				Set<Object> sourceCache = cache.get(sourceLevel + 1);
				if (sourceCache == null)
					sourceCache = new HashSet<Object>();
				sourceCache.add(value);
				cache.put(sourceLevel + 1, sourceCache);
			}

			return false;
		} else if (sourceLevel == level) {
			return !isSimple(clazz);
		} else if (sourceLevel > level) {
			return true;
		}

		return false;
	}

	private boolean isSimple(Class<?> clazz) {
		return clazz.isPrimitive()
				|| clazz.getName().equals("java.lang.String")
				|| ClassUtils.isRepresentsPrimitive(clazz)
				|| ClassUtils.isDate(clazz);
	}

	private int getCacheKey(String name) {
		int result = -1;
		for (int i = 1; i < level + 1; i++) {
			Set<String> objs = cacheKey.get(i);
			if (objs == null)
				return -1;

			for (Iterator<String> iter = objs.iterator(); iter.hasNext();) {
				if (name.equals(iter.next())) {
					return i;
				}
			}
		}
		return result;
	}

	private int getCache(Object source) {
		int result = -1;
		for (int i = 1; i < level + 2; i++) {
			Set<Object> objs = cache.get(i);
			if (objs == null)
				return -1;

			for (Iterator<Object> iter = objs.iterator(); iter.hasNext();) {
				if (source.equals(iter.next())) {
					return i;
				}
			}
		}
		return result;
	}
}
