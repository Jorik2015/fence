package ext.layout;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.Layout;
import ext.annotation.LayoutType;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;

/**
 *Note:This java code is auto generated by abner,do not edit it. A layout that
 * arranges items horizontally
 */
@Layout(LayoutType.hbox)
@InstanceOf("Ext.layout.HBoxLayout")
@ParseConfigMode(ui = false, pmode = PersistenceMode.InnerProperty, rmode = ReferenceMode.Config)
public class HBoxLayout extends BoxLayout {
	public static final String COMPONENT_TYPE = "Ext.layout.HBoxLayout";
	public static final String COMPONENT_FAMILY = "Ext.layout.HBoxLayout";

	/**
	 * <p>
	 * Create a new {@link HBoxLayout} instance with default property values.
	 * </p>
	 */
	public HBoxLayout() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private String align;

	/**
	 * Controls how the child items of the container arealigned. Acceptable
	 * configuration values for this property are:
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li><b><tt>top</tt></b> : <b>Default</b> <div class="sub-desc">child
	 * items are aligned vertically at the <b>left</b> side of the
	 * container</div></li>
	 * 
	 * <li><b><tt>middle</tt></b> :
	 * 
	 * <div class="sub-desc">child items are aligned vertically at the
	 * <b>mid-height</b> of the container</div></li>
	 * 
	 * <li><b><tt>stretch</tt></b> :
	 * 
	 * <div class="sub-desc">child items are stretched vertically to fill the
	 * height of the container</div></li>
	 * 
	 * <li><b><tt>stretchmax</tt></b> :
	 * 
	 * <div class="sub-desc">child items are stretched vertically to the size of
	 * the largest item.</div></li>
	 * </ul>
	 * </div>
	 */
	public String getAlign() {
		if (null != this.align) {
			return this.align;
		}
		ValueExpression _ve = getValueExpression("align");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>align</code> property.
	 * </p>
	 */
	public void setAlign(String align) {
		this.align = align;
		this.handleConfig("align", align);
	}

	private Integer flex;

	/**
	 * This configuation option is to be applied to<b>child <tt>items</tt></b>
	 * of the container managed by this layout. Each child item with a
	 * <tt>flex</tt> property will be flexed <b>horizontally</b> according to
	 * each item's <b>relative</b> <tt>flex</tt> value compared to the sum of
	 * all items with a <tt>flex</tt> value specified. Any child items that have
	 * either a <tt>flex = 0</tt> or <tt>flex = undefined</tt> will not be
	 * 'flexed' (the initial size will not be changed).
	 */
	public Integer getFlex() {
		if (null != this.flex) {
			return this.flex;
		}
		ValueExpression _ve = getValueExpression("flex");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>flex</code> property.
	 * </p>
	 */
	public void setFlex(Integer flex) {
		this.flex = flex;
		this.handleConfig("flex", flex);
	}

	private String pack;

	/**
	 * Controls how the child items of the container arepacked together.
	 * Acceptable configuration values for this property are:
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li><b><tt>start</tt></b> : <b>Default</b> <div class="sub-desc">child
	 * items are packed together at <b>left</b> side of container</div></li>
	 * 
	 * <li><b><tt>center</tt></b> :
	 * 
	 * <div class="sub-desc">child items are packed together at <b>mid-width</b>
	 * of container</div></li>
	 * 
	 * <li><b><tt>end</tt></b> :
	 * 
	 * <div class="sub-desc">child items are packed together at <b>right</b>
	 * side of container</div></li>
	 * </ul>
	 * </div>
	 */
	public String getPack() {
		if (null != this.pack) {
			return this.pack;
		}
		ValueExpression _ve = getValueExpression("pack");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>pack</code> property.
	 * </p>
	 */
	public void setPack(String pack) {
		this.pack = pack;
		this.handleConfig("pack", pack);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
		_values[1] = align;
		_values[2] = flex;
		_values[3] = pack;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.align = (String) _values[1];
		this.handleConfig("align", this.align);
		this.flex = (Integer) _values[2];
		this.handleConfig("flex", this.flex);
		this.pack = (String) _values[3];
		this.handleConfig("pack", this.pack);

	}
}