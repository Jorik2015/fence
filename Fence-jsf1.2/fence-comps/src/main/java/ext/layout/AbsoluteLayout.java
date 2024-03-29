package ext.layout;

import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.Layout;
import ext.annotation.LayoutType;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * This is a layout that inherits the anchoring of <b><a
 * href="output/Ext.layout.AnchorLayout.html"
 * ext:cls="Ext.layout.AnchorLayout">Ext.layout.AnchorLayout</a></b> and adds
 * the ability for x/y positioning using the standard x and y component config
 * options.
 * </p>
 * 
 * <p>
 * This class is intended to be extended or created via the
 * <tt><b><a href="output/Ext.Container.html#Ext.Container-layout" ext:member="layout" ext:cls="Ext.Container">layout</a></b></tt>
 * configuration property. See
 * 
 * <tt><b><a href="output/Ext.Container.html#Ext.Container-layout" ext:member="layout" ext:cls="Ext.Container">Ext.Container.layout</a></b></tt>
 * for additional details.
 * </p>
 * 
 * <p>
 * Example usage:
 * </p>
 * 
 * <pre>
 * &lt;code&gt;&lt;b&gt;var&lt;/b&gt; form = &lt;b&gt;new&lt;/b&gt; Ext.form.FormPanel({
 *     title: &lt;em&gt;'Absolute Layout'&lt;/em&gt;,
 *     layout:&lt;em&gt;'absolute'&lt;/em&gt;,
 *     layoutConfig: {
 *         &lt;i&gt;// layout-specific configs go here
 * &lt;/i&gt;
 *         extraCls: &lt;em&gt;'x-abs-layout-item'&lt;/em&gt;,
 *     },
 *     baseCls: &lt;em&gt;'x-plain'&lt;/em&gt;,
 *     url:&lt;em&gt;'save-form.php'&lt;/em&gt;,
 *     defaultType: &lt;em&gt;'textfield'&lt;/em&gt;,
 *     items: [{
 *         x: 0,
 *         y: 5,
 *         xtype:&lt;em&gt;'&lt;b&gt;label&lt;/b&gt;'&lt;/em&gt;,
 *         text: &lt;em&gt;'Send To:'&lt;/em&gt;
 *     },{
 *         x: 60,
 *         y: 0,
 *         name: &lt;em&gt;'to'&lt;/em&gt;,
 *         anchor:&lt;em&gt;'100%'&lt;/em&gt;  &lt;i&gt;// anchor width by percentage
 * &lt;/i&gt;
 *     },{
 *         x: 0,
 *         y: 35,
 *         xtype:&lt;em&gt;'&lt;b&gt;label&lt;/b&gt;'&lt;/em&gt;,
 *         text: &lt;em&gt;'Subject:'&lt;/em&gt;
 *     },{
 *         x: 60,
 *         y: 30,
 *         name: &lt;em&gt;'subject'&lt;/em&gt;,
 *         anchor: &lt;em&gt;'100%'&lt;/em&gt;  &lt;i&gt;// anchor width by percentage
 * &lt;/i&gt;
 *     },{
 *         x:0,
 *         y: 60,
 *         xtype: &lt;em&gt;'textarea'&lt;/em&gt;,
 *         name: &lt;em&gt;'msg'&lt;/em&gt;,
 *         anchor: &lt;em&gt;'100% 100%'&lt;/em&gt;  &lt;i&gt;// anchor width and height
 * &lt;/i&gt;
 *     }]
 * });&lt;/code&gt;
 * </pre>
 */
@Layout(LayoutType.absolute)
@InstanceOf("Ext.layout.AbsoluteLayout")
@ParseConfigMode(ui = false, pmode = PersistenceMode.InnerProperty, rmode = ReferenceMode.Config)
public class AbsoluteLayout extends AnchorLayout {
	public static final String COMPONENT_TYPE = "Ext.layout.AbsoluteLayout";
	public static final String COMPONENT_FAMILY = "Ext.layout.AbsoluteLayout";

	/**
	 * <p>
	 * Create a new {@link AbsoluteLayout} instance with default property
	 * values.
	 * </p>
	 */
	public AbsoluteLayout() {
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