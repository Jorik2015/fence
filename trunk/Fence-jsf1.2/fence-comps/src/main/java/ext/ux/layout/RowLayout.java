package ext.ux.layout;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.Layout;
import ext.annotation.LayoutType;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.layout.ContainerLayout;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * This is the layout style of choice for creating structural layouts in a
 * multi-row format where the height of each row can be specified as a
 * percentage or fixed height. Row widths can also be fixed, percentage or auto.
 * This class is intended to be extended or created via the layout:'ux.row' <a
 * href="output/Ext.Container.html#Ext.Container-layout" ext:member="layout"
 * ext:cls="Ext.Container">Ext.Container.layout</a> config, and should generally
 * not need to be created directly via the new keyword.
 * </p>
 * 
 * <p>
 * RowLayout does not have any direct config options (other than inherited
 * ones), but it does support a specific config property of <b>
 * <tt>rowHeight</tt></b> that can be included in the config of any panel added
 * to it. The layout will use the rowHeight (if present) or height of each panel
 * during layout to determine how to size each panel. If height or rowHeight is
 * not specified for a given panel, its height will default to the panel's
 * height (or auto).
 * </p>
 * 
 * <p>
 * The height property is always evaluated as pixels, and must be a number
 * greater than or equal to 1. The rowHeight property is always evaluated as a
 * percentage, and must be a decimal value greater than 0 and less than 1 (e.g.,
 * .25).
 * </p>
 * 
 * <p>
 * The basic rules for specifying row heights are pretty simple. The logic makes
 * two passes through the set of contained panels. During the first layout pass,
 * all panels that either have a fixed height or none specified (auto) are
 * skipped, but their heights are subtracted from the overall container height.
 * During the second pass, all panels with rowHeights are assigned pixel heights
 * in proportion to their percentages based on the total <b>remaining</b>
 * container height. In other words, percentage height panels are designed to
 * fill the space left over by all the fixed-height and/or auto-height panels.
 * Because of this, while you can specify any number of rows with different
 * percentages, the rowHeights must always add up to 1 (or 100%) when added
 * together, otherwise your layout may not render as expected. Example usage:
 * </p>
 * 
 * <pre>
 * <code><i>// All rows are percentages -- they must add up to 1</i>
 * <b>var</b> p = <b>new</b> Ext.Panel({
 *     title: <em>'Row Layout - Percentage Only'</em>,
 *     layout:<em>'ux.row'</em>,
 *     items: [{
 *         title: <em>'Row 1'</em>,
 *         rowHeight: .25
 *     },{
 *         title: <em>'Row 2'</em>,
 *         rowHeight: .6
 *     },{
 *         title: <em>'Row 3'</em>,
 *         rowHeight: .15
 *     }]
 * });
 * 
 * <i>// Mix of height and rowHeight -- all rowHeight values must add</i>
 * <i>// up to 1. The first row will take up exactly 120px, and the last two</i>
 * <i>// rows will fill the remaining container height.</i>
 * <b>var</b> p = <b>new</b> Ext.Panel({
 *     title: <em>'Row Layout - Mixed'</em>,
 *     layout:<em>'ux.row'</em>,
 *     items: [{
 *         title: <em>'Row 1'</em>,
 *         height: 120,
 *         <i>// standard panel widths are still supported too:</i>
 *         width: <em>'50%'</em> <i>// or 200</i>
 *     },{
 *         title: <em>'Row 2'</em>,
 *         rowHeight: .8,
 *         width: 300
 *     },{
 *         title: <em>'Row 3'</em>,
 *         rowHeight: .2
 *     }]
 * });</code>
 * </pre>
 */
@Layout(LayoutType.row)
@InstanceOf("Ext.ux.layout.RowLayout")
@ParseConfigMode(ui = false, pmode = PersistenceMode.InnerProperty, rmode = ReferenceMode.Config)
public class RowLayout extends ContainerLayout {
	public static final String COMPONENT_TYPE = "Ext.ux.layout.RowLayout";
	public static final String COMPONENT_FAMILY = "Ext.ux.layout.RowLayout";

	/**
	 * <p>
	 * Create a new {@link RowLayout} instance with default property values.
	 * </p>
	 */
	public RowLayout() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean enableTabbing;

	/**
	 * <tt>true</tt> to enable tabbing. Default is<tt>false</tt>.
	 */
	public Boolean getEnableTabbing() {
		if (null != this.enableTabbing) {
			return this.enableTabbing;
		}
		ValueExpression _ve = getValueExpression("enableTabbing");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableTabbing</code> property.
	 * </p>
	 */
	public void setEnableTabbing(Boolean enableTabbing) {
		this.enableTabbing = enableTabbing;
		this.handleConfig("enableTabbing", enableTabbing);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[2];
		}
		_values[0] = super.saveState(_context);
		_values[1] = enableTabbing;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.enableTabbing = (Boolean) _values[1];
		this.handleConfig("enableTabbing", this.enableTabbing);

	}
}