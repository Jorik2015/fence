package com.abner.fence.utils;

import java.util.Iterator;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.PhaseId;

public class Utils {

	public static boolean componentIsDisabled(UIComponent component) {

		return (Boolean.valueOf(String.valueOf(component.getAttributes().get("disabled"))));

	}

	public static void notNull(String varname, Object var) {
		if (var == null) {
			throw new NullPointerException(varname);
		}
	}

	public static boolean prefixViewTraversal(FacesContext context, UIComponent root, TreeTraversalCallback action)
			throws FacesException {
		boolean keepGoing = false;
		if (keepGoing = action.takeActionOnNode(context, root)) {
			Iterator<UIComponent> kids = root.getFacetsAndChildren();
			while (kids.hasNext() && keepGoing) {
				keepGoing = prefixViewTraversal(context, kids.next(), action);
			}
		}
		return keepGoing;
	}

	public static interface TreeTraversalCallback {
		public boolean takeActionOnNode(FacesContext context, UIComponent curNode) throws FacesException;
	}

	public static PhaseId getPhaseIdFromString(String phaseIdString) {
		PhaseId result = PhaseId.ANY_PHASE;
		List<PhaseId> phaseIds = PhaseId.VALUES;
		for (PhaseId curPhase : phaseIds) {
			if (-1 != curPhase.toString().toLowerCase().indexOf(phaseIdString.toLowerCase())) {
				return curPhase;
			}
		}
		return result;
	}

	public static boolean componentIsDisabledOrReadonly(UIComponent component) {
		return Boolean.valueOf(String.valueOf(component.getAttributes().get("disabled")))
				|| Boolean.valueOf(String.valueOf(component.getAttributes().get("readonly")));
	}

	public static Converter getConverterForClass(Class<?> converterClass, FacesContext context) {
		if (converterClass == null) {
			return null;
		}
		try {
			Application application = context.getApplication();
			return (application.createConverter(converterClass));
		} catch (Exception e) {
			return (null);
		}
	}

	public static Class<?> loadClass(String name, Object fallbackClass) throws ClassNotFoundException {
		ClassLoader loader = Utils.getCurrentLoader(fallbackClass);
		return Class.forName(name, false, loader);
	}

	public static ClassLoader getCurrentLoader(Object fallbackClass) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null) {
			loader = fallbackClass.getClass().getClassLoader();
		}
		return loader;
	}
	
	 /**
     * <p>
     * Convenience method for determining if the request associated
     * with the specified <code>FacesContext</code> is a PortletRequest
     * submitted by the JSR-301 bridge.
     * </p>
     * @param context the <code>FacesContext</code> associated with
     *  the request.
     */
    public static boolean isPortletRequest (FacesContext context) {
        return (context.getExternalContext().getRequestMap().get("javax.portlet.faces.phase") != null);
    }
    public static Class<?> getTypeFromString(String type) throws ClassNotFoundException {
        Class<?> result;
        if (type.equals("byte")) {
            result = Byte.TYPE;
        } else if (type.equals("short")) {
            result = Short.TYPE;
        } else if (type.equals("int")) {
            result = Integer.TYPE;
        } else if (type.equals("long")) {
            result = Long.TYPE;
        } else if (type.equals("float")) {
            result = Float.TYPE;
        } else if (type.equals("double")) {
            result = Double.TYPE;
        } else if (type.equals("boolean")) {
            result = Boolean.TYPE;
        } else if (type.equals("char")) {
            result = Character.TYPE;
        } else if (type.equals("void")) {
            result = Void.TYPE;
        } else {
            if (type.indexOf('.') == -1) {
                type = "java.lang." + type;
            }
            result = Utils.loadClass(type, Void.TYPE);
        }

        return result;
    }
    

    /**
     * <p>Returns the URL pattern of the
     * {@link javax.faces.webapp.FacesServlet} that
     * is executing the current request.  If there are multiple
     * URL patterns, the value returned by
     * <code>HttpServletRequest.getServletPath()</code> and
     * <code>HttpServletRequest.getPathInfo()</code> is
     * used to determine which mapping to return.</p>
     * If no mapping can be determined, it most likely means
     * that this particular request wasn't dispatched through
     * the {@link javax.faces.webapp.FacesServlet}.
     *
     * @param context the {@link FacesContext} of the current request
     *
     * @return the URL pattern of the {@link javax.faces.webapp.FacesServlet}
     *         or <code>null</code> if no mapping can be determined
     *
     * @throws NullPointerException if <code>context</code> is null
     */
    public static String getFacesMapping(FacesContext context) {
        // Check for a previously stored mapping   
        ExternalContext extContext = context.getExternalContext();
        String mapping =
              (String) RequestStateManager.get(context, RequestStateManager.INVOCATION_PATH);

        if (mapping == null) {
            // first check for javax.servlet.forward.servlet_path
            // and javax.servlet.forward.path_info for non-null
            // values.  if either is non-null, use this
            // information to generate determine the mapping.

            String servletPath = extContext.getRequestServletPath();
            String pathInfo = extContext.getRequestPathInfo();

            mapping = getMappingForRequest(servletPath, pathInfo);
        }
        
        // if the FacesServlet is mapped to /* throw an 
        // Exception in order to prevent an endless 
        // RequestDispatcher loop
        //if ("/*".equals(mapping)) {
        //    throw new FacesException(MessageUtils.getExceptionMessageString(
        //          MessageUtils.FACES_SERVLET_MAPPING_INCORRECT_ID));
        //}

        if (mapping != null) {
            RequestStateManager.set(context,
                                    RequestStateManager.INVOCATION_PATH,
                                    mapping);
        }
        return mapping;
    }

    /**
     * <p>Return the appropriate {@link javax.faces.webapp.FacesServlet} mapping
     * based on the servlet path of the current request.</p>
     *
     * @param servletPath the servlet path of the request
     * @param pathInfo    the path info of the request
     *
     * @return the appropriate mapping based on the current request
     *
     * @see javax.servlet.http.HttpServletRequest#getServletPath()
     */
    private static String getMappingForRequest(String servletPath, String pathInfo) {

        if (servletPath == null) {
            return null;
        }
        // If the path returned by HttpServletRequest.getServletPath()
        // returns a zero-length String, then the FacesServlet has
        // been mapped to '/*'.
        if (servletPath.length() == 0) {
            return "/*";
        }

        // presence of path info means we were invoked
        // using a prefix path mapping
        if (pathInfo != null) {
            return servletPath;
        } else if (servletPath.indexOf('.') < 0) {
            // if pathInfo is null and no '.' is present, assume the
            // FacesServlet was invoked using prefix path but without
            // any pathInfo - i.e. GET /contextroot/faces or
            // GET /contextroot/faces/
            return servletPath;
        } else {
            // Servlet invoked using extension mapping
            return servletPath.substring(servletPath.lastIndexOf('.'));
        }
    }
    
    
    /**
     * <p>Returns true if the provided <code>url-mapping</code> is
     * a prefix path mapping (starts with <code>/</code>).</p>
     *
     * @param mapping a <code>url-pattern</code>
     * @return true if the mapping starts with <code>/</code>
     */
    public static boolean isPrefixMapped(String mapping) {
        return (mapping.charAt(0) == '/');
    }

}
