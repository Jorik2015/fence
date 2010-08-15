package com.abner.fence.utils;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

/**
 * <p>
 * This helper class is used a central location for per-request state
 * that is needed by Mojarra.  This class leverages FacesContext.getAttributes()
 * which as added in 2.0 instead of the request scope to prevent the unecessary
 * triggering of ServletREquestAttributeListeners.
 * </p>
 */
public class RequestStateManager {

	 /**
     * Attribute to store the {@link javax.faces.webapp.FacesServlet} path of
     * the original request.
     */
    public static final String INVOCATION_PATH =
          RIConstants.FACES_PREFIX + "INVOCATION_PATH";
    
    /**
     * Leveraged by the RequestStateManager to allow deprecated ResponseStateManager
     * methods to continue to work if called.
     */
    public static final String FACES_VIEW_STATE =
          "com.sun.faces.FACES_VIEW_STATE";


    /**
     * Leveraged by ResourceHandlerImpl to denote whether or not a request
     * is a resource request.  A <code>Boolean</code> value will be assoicated
     * with this key.
     */
    public static final String RESOURCE_REQUEST =
          "com.sun.faces.RESOURCE_REQUEST";

    /**
     * Used to store the FaceletFactory as other components may need to
     * use it during their processing. 
     */
    public static final String FACELET_FACTORY =
          "com.sun.faces.FACELET_FACTORY";

    /**
     * Used to indicate whether or not jsf.js has already be rendered.
     */
    public static final String SCRIPT_STATE =
          "com.sun.faces.SCRIPT_STATE";


    /**
     * Used to communicate which validators have been disabled for a particular
     * nesting level within a view.
     */
    public static final String DISABLED_VALIDATORS =
          "com.sun.faces.DISABLED_VALIDATORS";


    /**
     * Used to store the Set of ResourceDependency annotations that have
     * been processed.
     */
    public static final String PROCESSED_RESOURCE_DEPENDENCIES =
          "com.sun.faces.PROCESSED_RESOURCE_DEPENDENCIES";


    private static final String[] RENDER_RESPONSE = {
          SCRIPT_STATE,
          PROCESSED_RESOURCE_DEPENDENCIES
    };

    private static final Map<PhaseId,String[]> PHASE_ATTRIBUTES =
        new HashMap<PhaseId,String[]>(2, 1.0f);

    static {
        PHASE_ATTRIBUTES.put(PhaseId.RENDER_RESPONSE, RENDER_RESPONSE);
    }


    // ---------------------------------------------------------- Public Methods


    /**
     * @param ctx the <code>FacesContext</code> for the current request
     * @param key the key for the value
     * @return the value associated with the specified key.
     */
    public static Object get(FacesContext ctx, String key) {
        if (ctx == null || key == null) {
            return null;
        }
        return ctx.getAttributes().get(key);
    }


    /**
     * <p>
     * Adds the specified key and value to the Map stored in the request.
     * If <code>value</code> is <code>null</code>, that key/value pair will
     * be removed from the Map.
     * </p>
     *
     * @param ctx the <code>FacesContext</code> for the current request
     * @param key the key for the value
     * @param value the value to store
     */
    public static void set(FacesContext ctx, String key, Object value) {
        if (ctx == null || key == null) {
            return;
        }
        if (value == null) {
            remove(ctx, key);
        }
        ctx.getAttributes().put(key, value);

    }


    /**
     * <p>
     * Remove the value associated with the specified key.
     * </p>
     *
     * @param ctx the <code>FacesContext</code> for the current request
     * @param key the key for the value
     * @return the value previous associated with the specified key, if any
     */
    public static Object remove(FacesContext ctx, String key) {

        if (ctx == null || key == null) {
            return null;
        }

        return ctx.getAttributes().remove(key);

    }


    /**
     * <p>
     * Remove all request state attributes associated that need to be cleared
     * before the execution of a particular lifecycle phase.
     * </p>
     * @param ctx the <code>FacesContext</code> for the current request
     * @param phaseId the phase used to obtain the associated attributes
     */
    public static void clearAttributesForPhase(FacesContext ctx,
                                               PhaseId phaseId) {

        if (ctx == null || phaseId == null) {
            return;
        }
        String[] phaseAttributes = PHASE_ATTRIBUTES.get(phaseId);
        if (phaseAttributes != null) {
            Map<Object,Object> attrs = ctx.getAttributes();
            for (String key : phaseAttributes) {
                attrs.remove(key);
            }
        }

    }


    /**
     * @param ctx the <code>FacesContext</code> for the current request
     * @param key the key for the value
     * @return true if the specified key exists in the Map
     */
    public static boolean containsKey(FacesContext ctx, String key) {

        return !(ctx == null || key == null) && ctx.getAttributes()
              .containsKey(key);

    }

}