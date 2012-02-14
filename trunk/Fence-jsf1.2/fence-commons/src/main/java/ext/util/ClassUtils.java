package ext.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class ClassUtils {
	private final static String[] types = new String[] { "java.lang.Boolean",
			"java.lang.Character", "java.lang.Byte", "java.lang.Short",
			"java.lang.Integer", "java.lang.Long", "java.lang.Float",
			"java.lang.Double", "java.lang.Void", };

	/**
	 * <p>
	 * Cache
	 * </p>
	 */
	private static final Map<ClassLoader, ConcurrentMap<String, MetaData>> REFLECTION_CACHE = new WeakHashMap<ClassLoader, ConcurrentMap<String, MetaData>>();

	// ------------------------------------------------------------ Constructors

	private ClassUtils() {
	}

	// ---------------------------------------------------------- Public Methods

	/**
	 * <p>
	 * Clears the cache for the specified <code>ClassLoader</code>.
	 * </p>
	 * <p>
	 * This method <em>MUST</em> be called when <code>ConfigureListener
	 * .contextDestroyed()</code> is called.
	 * </p>
	 * 
	 * @param loader
	 *            the <code>ClassLoader</code> whose associated cache should be
	 *            cleared
	 */
	public static synchronized void clearCache(ClassLoader loader) {
		REFLECTION_CACHE.remove(loader);
	}

	public static synchronized void initCache(ClassLoader loader) {
		if (REFLECTION_CACHE.get(loader) == null) {
			REFLECTION_CACHE.put(loader,new ConcurrentHashMap<String, MetaData>());
		}
	}

	/**
	 * <p>
	 * Returns the <code>Constructor</code> appropriate to the specified Class
	 * and parameters.
	 * </p>
	 * 
	 * @param clazz
	 *            the Class of interest
	 * @param params
	 *            the parameters for the constructor of the provided Class
	 * @return a Constructor that can be invoked with the specified parameters
	 */
	public static Constructor<?> lookupConstructor(Class<?> clazz,
			Class<?>... params) {

		ClassLoader loader = Utils.getCurrentLoader(clazz);
		if (loader == null) {
			return null;
		}

		return getMetaData(loader, clazz).lookupConstructor(params);

	}

	/**
	 * <p>
	 * Returns the <code>Method</code> appropriate to the specified Class,
	 * method name, and parameters.
	 * </p>
	 * 
	 * @param clazz
	 *            the Class of interest
	 * @param methodName
	 *            the name of the method
	 * @param params
	 *            the parameters for the specified method
	 * @return a Method that can be invoked with the specified parameters
	 */
	public static Method lookupMethod(Class<?> clazz, String methodName,
			Class<?>... params) {

		ClassLoader loader = Utils.getCurrentLoader(clazz);
		if (loader == null) {
			return null;
		}

		return getMetaData(loader, clazz).lookupMethod(methodName, params);

	}
	
	public static <T extends Annotation> T lookupAnno(Class<?> clazz, String methodName,Class<T> annoClazz,Class<?>... params){
		Method m  = lookupMethod(clazz,methodName,params);
		if(m == null)
			return null;
		
		return m.getAnnotation(annoClazz);
	}

	/**
	 * <p>
	 * Constructs a new object instance based off the provided class name.
	 * </p>
	 * 
	 * @param className
	 *            the class of the object to instantiate
	 * @return a new instances of said class
	 * @throws InstantiationException
	 *             if the class cannot be instantiated
	 * @throws IllegalAccessException
	 *             if there is a security violation
	 */
	public static Object newInstance(String className)
			throws InstantiationException, IllegalAccessException {

		ClassLoader loader = Utils.getCurrentLoader(null);
		if (loader == null) {
			return null;
		}

		return getMetaData(loader, className).lookupClass().newInstance();

	}

	/**
	 * <p>
	 * Obtain a <code>Class</code> instance based on the provided String name.
	 * </p>
	 * 
	 * @param className
	 *            the class to look up
	 * @return the <code>Class</code> corresponding to <code>className</code>
	 */
	public static Class<?> lookupClass(String className) {

		ClassLoader loader = Utils.getCurrentLoader(null);
		if (loader == null) {
			return null;
		}

		return getMetaData(loader, className).lookupClass();

	}

	// --------------------------------------------------------- Private Methods

	/**
	 * <p>
	 * Return the <code>MetaData</code> for the specified Class.
	 * </p>
	 * 
	 * <p>
	 * This will check the cache associated with the specified
	 * <code>ClassLoader</code>. If there is no cache hit, then a new
	 * <code>MetaData</code> instance will be created and stored.
	 * 
	 * @param loader
	 *            <code>ClassLoader</code>
	 * @param clazz
	 *            the Class of interest
	 * @return a <code>MetaData</code> object for the specified Class
	 */
	private static MetaData getMetaData(ClassLoader loader, Class<?> clazz) {

		ConcurrentMap<String, MetaData> cache = REFLECTION_CACHE.get(loader);

		if (cache == null) {
			initCache(loader);
			cache = REFLECTION_CACHE.get(loader);
		}

		MetaData meta = cache.get(clazz.getName());
		if (meta == null) {
			meta = new MetaData(clazz);
			cache.put(clazz.getName(), meta);
		}

		return meta;

	}

	/**
	 * <p>
	 * Return the <code>MetaData</code> for the specified className.
	 * </p>
	 * 
	 * <p>
	 * This will check the cache associated with the specified
	 * <code>ClassLoader</code>. If there is no cache hit, then a new
	 * <code>MetaData</code> instance will be created and stored.
	 * 
	 * @param loader
	 *            <code>ClassLoader</code>
	 * @param className
	 *            the class of interest
	 * @return a <code>MetaData</code> object for the specified Class
	 */
	private static MetaData getMetaData(ClassLoader loader, String className) {

		ConcurrentMap<String, MetaData> cache = REFLECTION_CACHE.get(loader);

		if (cache == null) {
			initCache(loader);
			cache = REFLECTION_CACHE.get(loader);
		}

		MetaData meta = cache.get(className);
		if (meta == null) {
			try {
				Class<?> clazz = Utils.loadClass(className, cache);
				meta = new MetaData(clazz);
				cache.put(className, meta);
			} catch (ClassNotFoundException cnfe) {
				return null;
			}
		}

		return meta;
	}

	/**
	 * <p>
	 * MetaData contains lookup methods for <code>Constructor</code>s and
	 * <code>Method</code>s of a particular Class.
	 */
	private static final class MetaData {
		Map<Integer, Constructor<?>> constructors;
		Map<String, HashMap<Integer, Method>> methods;
		Map<String, HashMap<Integer, Method>> declaredMethods;
		Class<?> clazz;

		// ------------------------------------------------------------
		// Constructors

		/**
		 * <p>
		 * Constructs a new <code>MetaData</code> instance for the specified
		 * class.
		 * </p>
		 * 
		 * @param clazz
		 *            class to construct a new MetaData instance from.
		 */
		public MetaData(Class<?> clazz) {

			String name = null;
			this.clazz = clazz;
			Constructor<?>[] ctors = clazz.getConstructors();
			constructors = new HashMap<Integer, Constructor<?>>(ctors.length,
					1.0f);
			for (int i = 0, len = ctors.length; i < len; i++) {
				constructors
						.put(getKey(ctors[i].getParameterTypes()), ctors[i]);
			}
			Method[] meths = clazz.getMethods();
			methods = new HashMap<String, HashMap<Integer, Method>>(
					meths.length, 1.0f);
			for (int i = 0, len = meths.length; i < len; i++) {
				name = meths[i].getName();
				HashMap<Integer, Method> methodsMap = methods.get(name);
				if (methodsMap == null) {
					methodsMap = new HashMap<Integer, Method>(4, 1.0f);
					methods.put(name, methodsMap);
				}
				methodsMap.put(getKey(meths[i].getParameterTypes()), meths[i]);
			}

			meths = clazz.getDeclaredMethods();
			declaredMethods = new HashMap<String, HashMap<Integer, Method>>(
					meths.length, 1.0f);
			for (int i = 0, len = meths.length; i < len; i++) {
				name = meths[i].getName();
				HashMap<Integer, Method> declaredMethodsMap = declaredMethods
						.get(name);
				if (declaredMethodsMap == null) {
					declaredMethodsMap = new HashMap<Integer, Method>(4, 1.0f);
					declaredMethods.put(name, declaredMethodsMap);
				}
				declaredMethodsMap.put(getKey(meths[i].getParameterTypes()),
						meths[i]);
			}

		}

		// ---------------------------------------------------------- Public
		// Methods

		/**
		 * <p>
		 * Looks up a <code>Constructor</code> based off the specified
		 * <code>params</code>.
		 * </p>
		 * 
		 * @param params
		 *            constructor parameters
		 * @return the <code>Constructor</code> appropriate to the specified
		 *         parameters or <code>null</code>
		 */
		public Constructor<?> lookupConstructor(Class<?>... params) {
			return constructors.get(getKey(params));
		}

		/**
		 * <p>
		 * Looks up a <code>Method</code> based off the specified method name
		 * and <code>params</code>.
		 * </p>
		 * 
		 * @param name
		 *            the name of the <cod>Method</code>
		 * @param params
		 *            the <code>Method</code> parameters
		 * @return the <code>Method</code> appropriate to the specified name and
		 *         parameters or <code>null</code>
		 */
		public Method lookupMethod(String name, Class<?>... params) {

			Map<Integer, Method> map = methods.get(name);
			Integer key = getKey(params);
			Method result = null;
			if ((null == map) || null == (result = map.get(key))) {
				map = declaredMethods.get(name);
				if (null != map) {
					result = map.get(key);
				}
			}
			return result;

		}

		/**
		 * <p>
		 * Looks up the class for this MetaData instance.
		 * </p>
		 * 
		 * @return the <code>Class</code> for this MetaData instance
		 */
		public Class<?> lookupClass() {

			return clazz;

		}

		// --------------------------------------------------------- Private
		// Methods

		/**
		 * Return a hashcode of all the class parameters.
		 * 
		 * @param params
		 *            the parameters to a <code>Constructor</code> or a
		 *            <code>Method</code> instance
		 * @return the result of <code>Arrays.deepHashCode</code>
		 */
		private static Integer getKey(Class<?>... params) {

			return Arrays.deepHashCode(params);

		}

	}

	public static boolean isRepresentsPrimitive(Class<?> clazz) {
		String name = clazz.getName();
		for (String type : types) {
			if (name.equals(type)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isDate(Class<?> clazz) {
		if(java.sql.Date.class.isAssignableFrom(clazz))
			return true;
		
		if(java.util.Date.class.isAssignableFrom(clazz))
			return true;
		
		return false;
	}
}
