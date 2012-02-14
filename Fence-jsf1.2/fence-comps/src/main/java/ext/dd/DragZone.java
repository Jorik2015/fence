package ext.dd;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * This class provides a container DD instance that allows dragging of multiple
 * child source nodes.
 * </p>
 * 
 * <p>
 * This class does not move the drag target nodes, but a proxy element which may
 * contain any DOM structure you wish. The DOM element to show in the proxy is
 * provided by either a provided implementation of <a
 * href="output/Ext.dd.DragZone.html#Ext.dd.DragZone-getDragData"
 * ext:member="getDragData" ext:cls="Ext.dd.DragZone">getDragData</a>, or by
 * registered draggables registered with <a href="output/Ext.dd.Registry.html"
 * ext:cls="Ext.dd.Registry">Ext.dd.Registry</a>
 * </p>
 * 
 * <p>
 * If you wish to provide draggability for an arbitrary number of DOM nodes,
 * each of which represent some application object (For example nodes in a <a
 * href="output/Ext.DataView.html" ext:cls="Ext.DataView">DataView</a>) then use
 * of this class is the most efficient way to "activate" those nodes.
 * </p>
 * 
 * <p>
 * By default, this class requires that draggable child nodes are registered
 * with <a href="output/Ext.dd.Registry.html"
 * ext:cls="Ext.dd.Registry">Ext.dd.Registry</a>. However a simpler way to allow
 * a DragZone to manage any number of draggable elements is to configure the
 * DragZone with an implementation of the <a
 * href="output/Ext.dd.DragZone.html#Ext.dd.DragZone-getDragData"
 * ext:member="getDragData" ext:cls="Ext.dd.DragZone">getDragData</a> method
 * which interrogates the passed mouse event to see if it has taken place within
 * an element, or class of elements. This is easily done by using the event's <a
 * href="output/Ext.EventObject.html#Ext.EventObject-getTarget"
 * ext:member="getTarget" ext:cls="Ext.EventObject">getTarget</a> method to
 * identify a node based on a <a href="output/Ext.DomQuery.html"
 * ext:cls="Ext.DomQuery">Ext.DomQuery</a> selector. For example, to make the
 * nodes of a DataView draggable, use the following technique. Knowledge of the
 * use of the DataView is required:
 * </p>
 * 
 * <pre>
 * &lt;code&gt;myDataView.on(&lt;em&gt;'render'&lt;/em&gt;, &lt;b&gt;function&lt;/b&gt;() {
 *     myDataView.dragZone = &lt;b&gt;new&lt;/b&gt; Ext.dd.DragZone(myDataView.getEl(), {
 * 
 * &lt;i&gt;//      On receipt of a mousedown event, see &lt;b&gt;if&lt;/b&gt; it is within a DataView node.
 * &lt;/i&gt;
 * &lt;i&gt;//      Return a drag data object &lt;b&gt;if&lt;/b&gt; so.
 * &lt;/i&gt;
 *         getDragData: &lt;b&gt;function&lt;/b&gt;(e) {
 * 
 * &lt;i&gt;//          Use the DataView&lt;em&gt;'s own itemSelector (a mandatory property) to
 * &lt;/em&gt;
 * &lt;/i&gt;//          test &lt;b&gt;if&lt;/b&gt; the mousedown is within one of the DataView'&lt;/code&gt;s nodes.
 * 
 *             &lt;b&gt;var&lt;/b&gt; sourceEl = e.getTarget(myDataView.itemSelector, 10);
 * 
 * &lt;i&gt;//          If the mousedown is within a DataView node, clone the node to produce
 * &lt;/i&gt;
 * &lt;i&gt;//          a ddel element &lt;b&gt;for&lt;/b&gt; use by the drag proxy. Also add application data
 * &lt;/i&gt;
 * &lt;i&gt;//          to the returned data object.
 * &lt;/i&gt;
 *             &lt;b&gt;if&lt;/b&gt; (sourceEl) {
 *                 d = sourceEl.cloneNode(true);
 *                 d.id = Ext.id();
 *                 &lt;b&gt;return&lt;/b&gt; {
 *                     ddel: d,
 *                     sourceEl: sourceEl,
 *                     repairXY: Ext.fly(sourceEl).getXY(),
 *                     sourceStore: myDataView.store,
 *                     draggedRecord: v.getRecord(sourceEl)
 *                 }
 *             }
 *         },
 * 
 * &lt;i&gt;//      Provide coordinates &lt;b&gt;for&lt;/b&gt; the proxy to slide back to on failed drag.
 * &lt;/i&gt;
 * &lt;i&gt;//      This is the original XY coordinates of the draggable element captured
 * &lt;/i&gt;
 * &lt;i&gt;//      &lt;b&gt;in&lt;/b&gt; the getDragData method.
 * &lt;/i&gt;
 *         getRepairXY: &lt;b&gt;function&lt;/b&gt;() {
 *             &lt;b&gt;return&lt;/b&gt; this.dragData.repairXY;
 *         }
 *     });
 * });
 * </pre>
 * 
 * See the <a href="output/Ext.dd.DropZone.html"
 * ext:cls="Ext.dd.DropZone">DropZone</a> documentation for details about
 * building a DropZone which cooperates with this DragZone.
 */
public class DragZone extends DragSource {
	public static final String COMPONENT_TYPE = "Ext.dd.DragZone";

	/**
	 * <p>
	 * Create a new {@link DragZone} instance with default property values.
	 * </p>
	 */
	public DragZone() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private Boolean containerScroll;

	/**
	 * True to register this container with theScrollmanager for auto scrolling
	 * during drag operations.
	 */
	public Boolean getContainerScroll() {
		if (null != this.containerScroll) {
			return this.containerScroll;
		}
		ValueExpression _ve = getValueExpression("containerScroll");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>containerScroll</code> property.
	 * </p>
	 */
	public void setContainerScroll(Boolean containerScroll) {
		this.containerScroll = containerScroll;
		handleConfig("containerScroll", containerScroll);
	}

	private String hlColor;

	/**
	 * The color to use when visually highlighting thedrag source in the
	 * afterRepair method after a failed drop (defaults to "c3daf9" - light
	 * blue)
	 */
	public String getHlColor() {
		if (null != this.hlColor) {
			return this.hlColor;
		}
		ValueExpression _ve = getValueExpression("hlColor");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>hlColor</code> property.
	 * </p>
	 */
	public void setHlColor(String hlColor) {
		this.hlColor = hlColor;
		handleConfig("hlColor", hlColor);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[3];
		}
		_values[0] = super.saveState(_context);
		_values[1] = containerScroll;
		_values[2] = hlColor;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.containerScroll = (Boolean) _values[1];
		this.handleConfig("containerScroll", this.containerScroll);
		this.hlColor = (String) _values[2];
		this.handleConfig("hlColor", this.hlColor);

	}
}