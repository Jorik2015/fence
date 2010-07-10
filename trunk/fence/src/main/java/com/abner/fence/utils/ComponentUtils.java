package com.abner.fence.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponent;

import org.apache.commons.lang.math.NumberUtils;

import com.abner.fence.annotation.InstanceOf;
import com.abner.fence.annotation.ParseConfigMode;
import com.abner.fence.annotation.XType;
import com.abner.fence.commons.ExtComponentMetaData;
import com.abner.fence.component.ExtComponent;

import ext.BoxComponent;
import ext.Container;
import ext.Panel;
import ext.TabPanel;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 * 
 */
public class ComponentUtils {
	private static Map<Class<? extends ExtComponent>, ExtComponentMetaData> metadatas = new HashMap<Class<? extends ExtComponent>, ExtComponentMetaData>();

	public static ExtComponentMetaData getMetadata(ExtComponent comp) {
		Class<? extends ExtComponent> clazz = comp.getClass();
		if (metadatas.containsKey(clazz))
			return metadatas.get(clazz);

		com.abner.fence.annotation.ParseConfigMode ps = clazz.getAnnotation(ParseConfigMode.class);
		XType xtype = clazz.getAnnotation(XType.class);
		InstanceOf instanceOf = clazz.getAnnotation(InstanceOf.class);
		if (ps == null && instanceOf == null && xtype == null)
			return null;

		ExtComponentMetaData metadata = new ExtComponentMetaData();

		if (ps != null) {
			metadata.setRefName(ps.name());
			metadata.setPmode(ps.pmode());
			metadata.setRmode(ps.rmode());
			metadata.setUi(ps.ui());
			metadata.setId(ps.id());
		}
		if (instanceOf != null)
			metadata.setInstanceOf(instanceOf.value());

		if (xtype != null)
			metadata.setXtype(xtype.value());

		metadatas.put(clazz, metadata);

		return metadata;
	}

	public static UIComponent getRootComponent(UIComponent component) {
		UIComponent parent;
		for (;;) {
			parent = component.getParent();
			if (parent == null)
				return component;
			component = parent;
		}
	}

	@SuppressWarnings("unchecked")
	public static List<UIComponent> findComponents(UIComponent base, String id) {
		List<UIComponent> result = new ArrayList<UIComponent>();
		if (id == null)
			return result;

		for (Iterator i = base.getFacetsAndChildren(); i.hasNext();) {
			UIComponent kid = (UIComponent) i.next();
			if (!(kid instanceof NamingContainer)) {
				if (id.equals(kid.getId())) {
					result.add(kid);
				}
				result.addAll(findComponents(kid, id));
			} else if (id.equals(kid.getId())) {
				result.add(kid);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> findComponents(UIComponent base, Class<T> clazz) {
		List<T> result = new ArrayList<T>();
		for (Iterator i = base.getFacetsAndChildren(); i.hasNext();) {
			UIComponent kid = (UIComponent) i.next();
			if (!(kid instanceof NamingContainer)) {
				if (kid.getClass().isAssignableFrom(clazz)) {
					result.add((T) kid);
				}
				result.addAll(findComponents(kid, clazz));
			} else if (kid.getClass().isAssignableFrom(clazz)) {
				result.add((T) kid);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static UIComponent findComponent(UIComponent base, String id, boolean checkId) {
		if (checkId && id.equals(base.getId())) {
			return base;
		}
		// Search through our facets and children
		UIComponent result = null;
		for (Iterator i = base.getFacetsAndChildren(); i.hasNext();) {
			UIComponent kid = (UIComponent) i.next();
			if (!(kid instanceof NamingContainer)) {
				if (checkId && id.equals(kid.getId())) {
					result = kid;
					break;
				}
				result = findComponent(kid, id, true);
				if (result != null) {
					break;
				}
			} else if (id.equals(kid.getId())) {
				result = kid;
				break;
			}
		}
		return (result);
	}

	public static String getInnerText(UIComponent comp) {
		if (comp == null)
			return null;
		List<UIComponent> childs = comp.getChildren();

		if (childs.size() == 0)
			return null;

		return childs.get(0).toString();
	}

	public static ExtComponent getFirstExtChild(ExtComponent comp) {
		if (comp == null)
			return null;
		List<UIComponent> childs = comp.getChildren();

		if (childs.size() == 0)
			return null;

		for (UIComponent child : childs) {
			if (child instanceof ExtComponent)
				return (ExtComponent) child;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getFirstExtChild(ExtComponent comp, Class<T> type) {
		if (comp == null)
			return null;
		List<UIComponent> childs = comp.getChildren();

		if (childs.size() == 0)
			return null;

		for (UIComponent child : childs) {
			if (type.isAssignableFrom(child.getClass()))
				return (T) child;
		}

		return null;
	}

	public static boolean hasNotExtComponetChild(ExtComponent comp) {
		if (comp == null)
			return false;

		List<UIComponent> childs = comp.getChildren();

		if (childs.size() == 0)
			return false;

		for (UIComponent child : childs) {
			if (!(child instanceof ExtComponent))
				return true;
		}

		return false;
	}

	/*
	 * 判断组件是否是父组件的“直接”子元素
	 */
	public static boolean isHaeresNatus(ExtComponent component) {
		UIComponent parent = component.getParent();
		if (parent == null)
			return false;

		if (!(parent instanceof ExtComponent))
			return false;

		List<UIComponent> childs = parent.getChildren();
		if (childs.size() < 2)
			return true;

		boolean preHas = false, nextHas = false;
		int index = 0;
		for (int i = 0; i < childs.size(); i++) {
			UIComponent child = childs.get(i);
			if (child.equals(component)) {
				index = i;
			}

			if (!preHas && !(child instanceof ExtComponent) && index == 0)
				preHas = true;

			if (!nextHas && !(child instanceof ExtComponent) && index > 0)
				nextHas = true;

			if (component instanceof Container) {
				if (preHas || nextHas)
					return false;
			} else {
				if (preHas && nextHas)
					return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public static <T> T inNested(Class<T> clazz, ExtComponent child, boolean isAssign) {
		if (child == null)
			return null;

		UIComponent parent = child.getParent();
		while (parent != null) {
			if (isAssign) {
				if (clazz.isAssignableFrom(parent.getClass()))
					return (T) parent;
			} else if (parent.getClass().equals(clazz))
				return (T) parent;

			parent = parent.getParent();
		}
		return null;
	}

	public static <T> T inNested(Class<T> clazz, ExtComponent child) {
		return inNested(clazz, child, false);
	}

	public static boolean isActiveItem(BoxComponent component) {
		if (!(component instanceof Panel))
			return true;

		Panel panel = (Panel) component;
		UIComponent parent = panel.getParent();
		if (parent instanceof TabPanel) {
			TabPanel tab = (TabPanel) parent;
			String activeTab = tab.getActiveTab();

			List<UIComponent> childs = parent.getChildren();
			int index = -1;
			for (Iterator<UIComponent> iter = childs.iterator(); iter.hasNext();) {
				index++;
				UIComponent child = iter.next();
				if (child != panel)
					continue;

				if (NumberUtils.isNumber(activeTab)) {
					return activeTab.equals(String.valueOf(index));
				} else {
					return panel.getId().equals(activeTab);
				}
			}
		}
		// TODO card layout
		return true;
	}

	public static void flaseRenderAllChild(BoxComponent component) {
		List<UIComponent> childs = component.getChildren();
		for (UIComponent child : childs) {
			child.setRendered(false);
		}
	}

	// Returns the resolved (client id) for a particular id.
	public static String getResolvedId(UIComponent component, String id) {

		UIComponent resolvedComponent = component.findComponent(id);
		if (resolvedComponent == null) {
			// RELEASE_PENDING i18n
			throw new FacesException("<s:event> contains an unknown id '" + id
					+ "' - cannot locate it in the context of the component " + component.getId());
		}

		return resolvedComponent.getClientId();
	}
}
