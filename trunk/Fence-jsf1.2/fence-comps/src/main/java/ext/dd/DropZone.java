package ext.dd;

import javax.faces.context.FacesContext;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * This class provides a container DD instance that allows dropping on multiple
 * child target nodes.
 * </p>
 * 
 * <p>
 * By default, this class requires that child nodes accepting drop are
 * registered with <a href="output/Ext.dd.Registry.html"
 * ext:cls="Ext.dd.Registry">Ext.dd.Registry</a>. However a simpler way to allow
 * a DropZone to manage any number of target elements is to configure the
 * DropZone with an implementation of <a
 * href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-getTargetFromEvent"
 * ext:member="getTargetFromEvent"
 * ext:cls="Ext.dd.DropZone">getTargetFromEvent</a> which interrogates the
 * passed mouse event to see if it has taken place within an element, or class
 * of elements. This is easily done by using the event's <a
 * href="output/Ext.EventObject.html#Ext.EventObject-getTarget"
 * ext:member="getTarget" ext:cls="Ext.EventObject">getTarget</a> method to
 * identify a node based on a <a href="output/Ext.DomQuery.html"
 * ext:cls="Ext.DomQuery">Ext.DomQuery</a> selector.
 * </p>
 * 
 * <p>
 * Once the DropZone has detected through calling getTargetFromEvent, that the
 * mouse is over a drop target, that target is passed as the first parameter to
 * <a href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeEnter"
 * ext:member="onNodeEnter" ext:cls="Ext.dd.DropZone">onNodeEnter</a>, <a
 * href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeOver"
 * ext:member="onNodeOver" ext:cls="Ext.dd.DropZone">onNodeOver</a>, <a
 * href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeOut"
 * ext:member="onNodeOut" ext:cls="Ext.dd.DropZone">onNodeOut</a>, <a
 * href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeDrop"
 * ext:member="onNodeDrop" ext:cls="Ext.dd.DropZone">onNodeDrop</a>. You may
 * configure the instance of DropZone with implementations of these methods to
 * provide application-specific behaviour for these events to update both
 * application state, and UI state.
 * </p>
 * 
 * <p>
 * For example to make a GridPanel a cooperating target with the example
 * illustrated in <a href="output/Ext.dd.DragZone.html"
 * ext:cls="Ext.dd.DragZone">DragZone</a>, the following technique might be
 * used:
 * </p>
 * 
 * <pre>
 * &lt;code&gt;myGridPanel.on(&lt;em&gt;'render'&lt;/em&gt;, &lt;b&gt;function&lt;/b&gt;() {
 *     myGridPanel.dropZone = &lt;b&gt;new&lt;/b&gt; Ext.dd.DropZone(myGridPanel.getView().scroller, {
 * 
 * &lt;i&gt;//      If the mouse is over a grid row, &lt;b&gt;return&lt;/b&gt; that node. This is
 * &lt;/i&gt;
 * &lt;i&gt;//      provided as the &lt;em&gt;&quot;target&quot;&lt;/em&gt; parameter &lt;b&gt;in&lt;/b&gt; all &lt;em&gt;&quot;onNodeXXXX&quot;&lt;/em&gt; node event handling functions
 * &lt;/i&gt;
 *         getTargetFromEvent: &lt;b&gt;function&lt;/b&gt;(e) {
 *             &lt;b&gt;return&lt;/b&gt; e.getTarget(myGridPanel.getView().rowSelector);
 *         },
 * 
 * &lt;i&gt;//      On entry into a target node, highlight that node.
 * &lt;/i&gt;
 *         onNodeEnter : &lt;b&gt;function&lt;/b&gt;(target, dd, e, data){ 
 *             Ext.fly(target).addClass(&lt;em&gt;'my-row-highlight-class'&lt;/em&gt;);
 *         },
 * 
 * &lt;i&gt;//      On exit from a target node, unhighlight that node.
 * &lt;/i&gt;
 *         onNodeOut : &lt;b&gt;function&lt;/b&gt;(target, dd, e, data){ 
 *             Ext.fly(target).removeClass(&lt;em&gt;'my-row-highlight-class'&lt;/em&gt;);
 *         },
 * 
 * &lt;i&gt;//      While over a target node, &lt;b&gt;return&lt;/b&gt; the &lt;b&gt;default&lt;/b&gt; drop allowed class which
 * &lt;/i&gt;
 * &lt;i&gt;//      places a &lt;em&gt;&quot;tick&quot;&lt;/em&gt; icon into the drag proxy.
 * &lt;/i&gt;
 *         onNodeOver : &lt;b&gt;function&lt;/b&gt;(target, dd, e, data){ 
 *             &lt;b&gt;return&lt;/b&gt; Ext.dd.DropZone.prototype.dropAllowed;
 *         },
 * 
 * &lt;i&gt;//      On node drop we can interrogate the target to find the underlying
 * &lt;/i&gt;
 * &lt;i&gt;//      application object that is the real target of the dragged data.
 * &lt;/i&gt;
 * &lt;i&gt;//      In this &lt;b&gt;case&lt;/b&gt;, it is a Record &lt;b&gt;in&lt;/b&gt; the GridPanel&lt;em&gt;'s Store.
 * &lt;/em&gt;
 * &lt;/i&gt;//      We can use the data set up by the DragZone'&lt;/code&gt;s getDragData method to read
 * 
 * &lt;i&gt;//      any data we decided to attach &lt;b&gt;in&lt;/b&gt; the DragZone&lt;em&gt;'s getDragData method.
 * &lt;/em&gt;
 *         onNodeDrop : &lt;b&gt;function&lt;/b&gt;(target, dd, e, data){
 *             &lt;b&gt;var&lt;/b&gt; rowIndex = myGridPanel.getView().findRowIndex(target);
 *             &lt;b&gt;var&lt;/b&gt; r = myGridPanel.getStore().getAt(rowIndex);
 *             Ext.Msg.alert('&lt;/i&gt;Drop gesture&lt;em&gt;', '&lt;/em&gt;Dropped Record id &lt;em&gt;' + data.draggedRecord.id +
 *                 '&lt;/em&gt; on Record id &lt;em&gt;' + r.id);
 *             &lt;b&gt;return&lt;/b&gt; true;
 *         }
 *     });
 * }&lt;/em&gt;
 * </pre>
 * 
 * See the <a href="output/Ext.dd.DragZone.html"
 * ext:cls="Ext.dd.DragZone">DragZone</a> documentation for details about
 * building a DragZone which cooperates with this DropZone.
 */
public class DropZone extends DropTarget {
	public static final String COMPONENT_TYPE = "Ext.dd.DropZone";

	/**
	 * <p>
	 * Create a new {@link DropZone} instance with default property values.
	 * </p>
	 */
	public DropZone() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
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