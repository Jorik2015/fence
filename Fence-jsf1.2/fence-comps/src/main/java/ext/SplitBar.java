package ext;

import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.util.Observable;

/**
 *Note:This java code is auto generated by abner,do not edit it. Creates
 * draggable splitter bar functionality from two elements (element to be dragged
 * and element to be resized).<br>
 * <br>
 * Usage:
 * 
 * <pre>
 * &lt;code&gt;&lt;b&gt;var&lt;/b&gt; split = &lt;b&gt;new&lt;/b&gt; Ext.SplitBar(&lt;em&gt;&quot;elementToDrag&quot;&lt;/em&gt;, &lt;em&gt;&quot;elementToSize&quot;&lt;/em&gt;,
 *                    Ext.SplitBar.HORIZONTAL, Ext.SplitBar.LEFT);
 * split.setAdapter(&lt;b&gt;new&lt;/b&gt; Ext.SplitBar.AbsoluteLayoutAdapter(&lt;em&gt;&quot;container&quot;&lt;/em&gt;));
 * split.minSize = 100;
 * split.maxSize = 600;
 * split.animate = true;
 * split.on(&lt;em&gt;'moved'&lt;/em&gt;, splitterMoved);&lt;/code&gt;
 * </pre>
 */
@InstanceOf("Ext.SplitBar")
public class SplitBar extends Observable {
	public static final String COMPONENT_TYPE = "Ext.SplitBar";
	public static final String COMPONENT_FAMILY = "Ext.SplitBar";

	/**
	 * <p>
	 * Create a new {@link SplitBar} instance with default property values.
	 * </p>
	 */
	public SplitBar() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[1];
		}
		_values[0] = super.saveState(_context);

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);

	}
}