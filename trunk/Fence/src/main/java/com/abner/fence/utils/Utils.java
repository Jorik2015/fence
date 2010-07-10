package com.abner.fence.utils;

import java.util.Iterator;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
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
}
