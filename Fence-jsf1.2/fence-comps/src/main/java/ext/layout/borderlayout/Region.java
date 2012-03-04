package ext.layout.borderlayout;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.layout.BorderLayout;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * This is a region of a <a href="output/Ext.layout.BorderLayout.html"
 * ext:cls="Ext.layout.BorderLayout">BorderLayout</a> that acts as a
 * subcontainer within the layout. Each region has its own <a
 * href="output/Ext.layout.ContainerLayout.html"
 * ext:cls="Ext.layout.ContainerLayout">layout</a> that is independent of other
 * regions and the containing BorderLayout, and can be any of the <a
 * href="output/Ext.layout.ContainerLayout.html"
 * ext:cls="Ext.layout.ContainerLayout">valid Ext layout types</a>.
 * </p>
 * 
 * <p>
 * Region size is managed automatically and cannot be changed by the user -- for
 * <a href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-split"
 * ext:member="split" ext:cls="Ext.layout.BorderLayout.Region">resizable
 * regions</a>, see <a href="output/Ext.layout.BorderLayout.SplitRegion.html"
 * ext:cls="Ext.layout.BorderLayout.SplitRegion">Ext.layout.BorderLayout.
 * SplitRegion</a>.
 * </p>
 */
@InstanceOf("Ext.layout.BorderLayout.Region")
@ParseConfigMode(ui = false, pmode = PersistenceMode.InnerProperty, rmode = ReferenceMode.Config)
public class Region extends BorderLayout {
	public static final String COMPONENT_TYPE = "Ext.layout.BorderLayout.Region";
	public static final String COMPONENT_FAMILY = "Ext.layout.BorderLayout.Region";

	/**
	 * <p>
	 * Create a new {@link Region} instance with default property values.
	 * </p>
	 */
	public Region() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean animFloat;

	/**
	 * When a collapsed region's bar is clicked, theregion's panel will be
	 * displayed as a floated panel that will close again once the user mouses
	 * out of that panel (or clicks out if
	 * 
	 * <tt><a href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-autoHide" ext:member="autoHide" ext:cls="Ext.layout.BorderLayout.Region">autoHide</a> =
false</tt>). Setting
	 * 
	 * <tt><a href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-animFloat" ext:member="animFloat" ext:cls="Ext.layout.BorderLayout.Region">animFloat</a> = false</tt>
	 * will prevent the open and close of these floated panels from being
	 * animated (defaults to <tt>true</tt>).
	 */
	public Boolean getAnimFloat() {
		if (null != this.animFloat) {
			return this.animFloat;
		}
		ValueExpression _ve = getValueExpression("animFloat");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>animFloat</code> property.
	 * </p>
	 */
	public void setAnimFloat(Boolean animFloat) {
		this.animFloat = animFloat;
		this.handleConfig("animFloat", animFloat);
	}

	private Boolean autoHide;

	/**
	 * When a collapsed region's bar is clicked, theregion's panel will be
	 * displayed as a floated panel. If <tt>autoHide = true</tt>, the panel will
	 * automatically hide after the user mouses out of the panel. If
	 * <tt>autoHide = false</tt>, the panel will continue to display until the
	 * user clicks outside of the panel (defaults to <tt>true</tt>).
	 */
	public Boolean getAutoHide() {
		if (null != this.autoHide) {
			return this.autoHide;
		}
		ValueExpression _ve = getValueExpression("autoHide");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>autoHide</code> property.
	 * </p>
	 */
	public void setAutoHide(Boolean autoHide) {
		this.autoHide = autoHide;
		this.handleConfig("autoHide", autoHide);
	}

	private Object cmargins;

	/**
	 * An object containing margins to apply to theregion when in the collapsed
	 * state in the format:
	 * 
	 * <pre>
	 * &lt;code&gt;{
	 *     top: (top margin),
	 *     right: (right margin),
	 *     bottom: (bottom margin),
	 *     left: (left margin)
	 * }&lt;/code&gt;
	 * </pre>
	 * 
	 * <p>
	 * May also be a string containing space-separated, numeric margin values.
	 * The order of the sides associated with each value matches the way CSS
	 * processes margin values.
	 * </p>
	 * 
	 * <ul>
	 * <li>If there is only one value, it applies to all sides.</li>
	 * 
	 * <li>If there are two values, the top and bottom borders are set to the
	 * first value and the right and left are set to the second.</li>
	 * 
	 * <li>If there are three values, the top is set to the first value, the
	 * left and right are set to the second, and the bottom is set to the third.
	 * </li>
	 * 
	 * <li>If there are four values, they apply to the top, right, bottom, and
	 * left, respectively.</li>
	 * </ul>
	 * 
	 * <br>
	 * <br>
	 */
	@ClientConfig(JsonMode.Object)
	public Object getCmargins() {
		if (null != this.cmargins) {
			return this.cmargins;
		}
		ValueExpression _ve = getValueExpression("cmargins");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>cmargins</code> property.
	 * </p>
	 */
	public void setCmargins(Object cmargins) {
		this.cmargins = cmargins;
		this.handleConfig("cmargins", cmargins);
	}

	private String collapseMode;

	/**
	 * <tt>collapseMode</tt> supports two configurationvalues:
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li><b><tt>undefined</tt></b> (default)
	 * 
	 * <div class="sub-desc">By default, <a href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-collapsible"
	 * ext:member="collapsible"
	 * ext:cls="Ext.layout.BorderLayout.Region">collapsible</a> regions are
	 * collapsed by clicking the expand/collapse tool button that renders into
	 * the region's title bar.</div></li>
	 * 
	 * <li><b><tt>'mini'</tt></b> <div class="sub-desc">Optionally, when
	 * <tt>collapseMode</tt> is set to <tt>'mini'</tt> the region's split bar will also
	 * display a small collapse button in the center of the bar. In <tt>'mini'</tt> mode
	 * the region will collapse to a thinner bar than in normal mode.</div></li>
	 * </ul>
	 * </div>
	 * 
	 * <br>
	 * <br>
	 * 
	 * 
	 * <p>
	 * <b>Note</b>: if a collapsible region does not have a title bar, then set
	 * <tt>collapseMode = 'mini'</tt> and
	 * 
	 * <tt><a href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-split" ext:member="split" ext:cls="Ext.layout.BorderLayout.Region">split</a> = true</tt>
	 * in order for the region to be <a href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-collapsible"
	 * ext:member="collapsible"
	 * ext:cls="Ext.layout.BorderLayout.Region">collapsible</a> by the user as
	 * the expand/collapse tool button (that would go in the title bar) will not
	 * be rendered.
	 * </p>
	 * 
	 * <p>
	 * See also
	 * 
	 * <tt><a href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-cmargins" ext:member="cmargins" ext:cls="Ext.layout.BorderLayout.Region">cmargins</a></tt>
	 * .
	 * </p>
	 */
	public String getCollapseMode() {
		if (null != this.collapseMode) {
			return this.collapseMode;
		}
		ValueExpression _ve = getValueExpression("collapseMode");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>collapseMode</code> property.
	 * </p>
	 */
	public void setCollapseMode(String collapseMode) {
		this.collapseMode = collapseMode;
		this.handleConfig("collapseMode", collapseMode);
	}

	private Boolean collapsible;

	/**
	 * <p>
	 * <tt>true</tt> to allow the user to collapse this region (defaults to
	 * <tt>false</tt>). If <tt>true</tt>, an expand/collapse tool button will
	 * automatically be rendered into the title bar of the region, otherwise the
	 * button will not be shown.
	 * </p>
	 * 
	 * <p>
	 * <b>Note</b>: that a title bar is required to display the collapse/expand
	 * toggle button -- if no <tt>title</tt> is specified for the region's
	 * panel, the region will only be collapsible if
	 * 
	 * <tt><a href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-collapseMode" ext:member="collapseMode" ext:cls="Ext.layout.BorderLayout.Region">collapseMode</a> =
'mini'</tt> and
	 * 
	 * <tt><a href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-split" ext:member="split" ext:cls="Ext.layout.BorderLayout.Region">split</a> = true</tt>
	 * .
	 * </p>
	 */
	public Boolean getCollapsible() {
		if (null != this.collapsible) {
			return this.collapsible;
		}
		ValueExpression _ve = getValueExpression("collapsible");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>collapsible</code> property.
	 * </p>
	 */
	public void setCollapsible(Boolean collapsible) {
		this.collapsible = collapsible;
		this.handleConfig("collapsible", collapsible);
	}

	private Boolean floatable;

	/**
	 * <tt>true</tt> to allow clicking a collapsedregion's bar to display the
	 * region's panel floated above the layout, <tt>false</tt> to force the user
	 * to fully expand a collapsed region by clicking the expand button to see
	 * it again (defaults to <tt>true</tt>).
	 */
	public Boolean getFloatable() {
		if (null != this.floatable) {
			return this.floatable;
		}
		ValueExpression _ve = getValueExpression("floatable");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>floatable</code> property.
	 * </p>
	 */
	public void setFloatable(Boolean floatable) {
		this.floatable = floatable;
		this.handleConfig("floatable", floatable);
	}

	private Object margins;

	/**
	 * An object containing margins to apply to theregion when in the expanded
	 * state in the format:
	 * 
	 * <pre>
	 * &lt;code&gt;{
	 *     top: (top margin),
	 *     right: (right margin),
	 *     bottom: (bottom margin),
	 *     left: (left margin)
	 * }&lt;/code&gt;
	 * </pre>
	 * 
	 * <p>
	 * May also be a string containing space-separated, numeric margin values.
	 * The order of the sides associated with each value matches the way CSS
	 * processes margin values:
	 * </p>
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li>If there is only one value, it applies to all sides.</li>
	 * 
	 * <li>If there are two values, the top and bottom borders are set to the
	 * first value and the right and left are set to the second.</li>
	 * 
	 * <li>If there are three values, the top is set to the first value, the
	 * left and right are set to the second, and the bottom is set to the third.
	 * </li>
	 * 
	 * <li>If there are four values, they apply to the top, right, bottom, and
	 * left, respectively.</li>
	 * </ul>
	 * </div>
	 * 
	 * <br>
	 * <br>
	 * 
	 * 
	 * <p>
	 * Defaults to:
	 * </p>
	 * 
	 * <pre>
	 * &lt;code&gt;{top:0, right:0, bottom:0, left:0}&lt;/code&gt;
	 * </pre>
	 */
	@ClientConfig(JsonMode.Object)
	public Object getMargins() {
		if (null != this.margins) {
			return this.margins;
		}
		ValueExpression _ve = getValueExpression("margins");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>margins</code> property.
	 * </p>
	 */
	public void setMargins(Object margins) {
		this.margins = margins;
		this.handleConfig("margins", margins);
	}

	private Integer minHeight;

	/**
	 * The minimum allowable height in pixels for thisregion (defaults to
	 * <tt>50</tt>) <tt>maxHeight</tt> may also be specified.<br>
	 * <br>
	 * <br>
	 * <p>
	 * <b>Note</b>: setting the
	 * <tt><a href="output/Ext.SplitBar.html#Ext.SplitBar-minSize" ext:member="minSize" ext:cls="Ext.SplitBar">minSize</a></tt>
	 * /
	 * <tt><a href="output/Ext.SplitBar.html#Ext.SplitBar-maxSize" ext:member="maxSize" ext:cls="Ext.SplitBar">maxSize</a></tt>
	 * supersedes any specified <tt>minHeight</tt> / <tt>maxHeight</tt>.
	 * </p>
	 */
	public Integer getMinHeight() {
		if (null != this.minHeight) {
			return this.minHeight;
		}
		ValueExpression _ve = getValueExpression("minHeight");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>minHeight</code> property.
	 * </p>
	 */
	public void setMinHeight(Integer minHeight) {
		this.minHeight = minHeight;
		this.handleConfig("minHeight", minHeight);
	}

	private Integer minWidth;

	/**
	 * <p>
	 * The minimum allowable width in pixels for this region (defaults to
	 * <tt>50</tt>). <tt>maxWidth</tt> may also be specified.
	 * </p>
	 * 
	 * <br>
	 * <p>
	 * <b>Note</b>: setting the
	 * <tt><a href="output/Ext.SplitBar.html#Ext.SplitBar-minSize" ext:member="minSize" ext:cls="Ext.SplitBar">minSize</a></tt>
	 * /
	 * <tt><a href="output/Ext.SplitBar.html#Ext.SplitBar-maxSize" ext:member="maxSize" ext:cls="Ext.SplitBar">maxSize</a></tt>
	 * supersedes any specified <tt>minWidth</tt> / <tt>maxWidth</tt>.
	 * </p>
	 */
	public Integer getMinWidth() {
		if (null != this.minWidth) {
			return this.minWidth;
		}
		ValueExpression _ve = getValueExpression("minWidth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>minWidth</code> property.
	 * </p>
	 */
	public void setMinWidth(Integer minWidth) {
		this.minWidth = minWidth;
		this.handleConfig("minWidth", minWidth);
	}

	private Boolean split;

	/**
	 * <p>
	 * <tt>true</tt> to create a <a
	 * href="output/Ext.layout.BorderLayout.SplitRegion.html"
	 * ext:cls="Ext.layout.BorderLayout.SplitRegion">SplitRegion</a> and display
	 * a 5px wide <a href="output/Ext.SplitBar.html"
	 * ext:cls="Ext.SplitBar">Ext.SplitBar</a> between this region and its
	 * neighbor, allowing the user to resize the regions dynamically. Defaults
	 * to <tt>false</tt> creating a <a
	 * href="output/Ext.layout.BorderLayout.Region.html"
	 * ext:cls="Ext.layout.BorderLayout.Region">Region</a>.
	 * </p>
	 * 
	 * <br>
	 * <p>
	 * <b>Notes</b>:
	 * </p>
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li>this configuration option is ignored if <tt>region='center'</tt></li>
	 * 
	 * <li>when <tt>split == true</tt>, it is common to specify a
	 * <tt><a href="output/Ext.SplitBar.html#Ext.SplitBar-minSize" ext:member="minSize" ext:cls="Ext.SplitBar">minSize</a></tt>
	 * and
	 * <tt><a href="output/Ext.SplitBar.html#Ext.SplitBar-maxSize" ext:member="maxSize" ext:cls="Ext.SplitBar">maxSize</a></tt>
	 * for the <a href="output/Ext.BoxComponent.html"
	 * ext:cls="Ext.BoxComponent">BoxComponent</a> representing the region.
	 * These are not native configs of <a href="output/Ext.BoxComponent.html"
	 * ext:cls="Ext.BoxComponent">BoxComponent</a>, and are used only by this
	 * class.</li>
	 * 
	 * <li>if
	 * 
	 * <tt><a href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-collapseMode" ext:member="collapseMode" ext:cls="Ext.layout.BorderLayout.Region">collapseMode</a> =
'mini'</tt> requires <tt>split = true</tt> to reserve space for the collapse
	 * tool</li>
	 * </ul>
	 * </div>
	 */
	public Boolean getSplit() {
		if (null != this.split) {
			return this.split;
		}
		ValueExpression _ve = getValueExpression("split");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>split</code> property.
	 * </p>
	 */
	public void setSplit(Boolean split) {
		this.split = split;
		this.handleConfig("split", split);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[11];
		}
		_values[0] = super.saveState(_context);
		_values[1] = animFloat;
		_values[2] = autoHide;
		_values[3] = cmargins;
		_values[4] = collapseMode;
		_values[5] = collapsible;
		_values[6] = floatable;
		_values[7] = margins;
		_values[8] = minHeight;
		_values[9] = minWidth;
		_values[10] = split;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.animFloat = (Boolean) _values[1];
		this.handleConfig("animFloat", this.animFloat);
		this.autoHide = (Boolean) _values[2];
		this.handleConfig("autoHide", this.autoHide);
		this.cmargins = (Object) _values[3];
		this.handleConfig("cmargins", this.cmargins);
		this.collapseMode = (String) _values[4];
		this.handleConfig("collapseMode", this.collapseMode);
		this.collapsible = (Boolean) _values[5];
		this.handleConfig("collapsible", this.collapsible);
		this.floatable = (Boolean) _values[6];
		this.handleConfig("floatable", this.floatable);
		this.margins = (Object) _values[7];
		this.handleConfig("margins", this.margins);
		this.minHeight = (Integer) _values[8];
		this.handleConfig("minHeight", this.minHeight);
		this.minWidth = (Integer) _values[9];
		this.handleConfig("minWidth", this.minWidth);
		this.split = (Boolean) _values[10];
		this.handleConfig("split", this.split);

	}
}