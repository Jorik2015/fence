package ext.ux.layout;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;
import ext.*;
import ext.dd.*;
import ext.util.*;
import ext.data.*;
import ext.grid.*;
import ext.form.*;
import ext.tree.*;
import ext.layout.*;
import ext.menu.*;
import java.util.*;
import ext.form.Action;
import java.util.Date;

/**
 * 
    This is the layout style of choice for creating structural
    layouts in a multi-row format where the height of each row can
    be specified as a percentage or fixed height. Row widths can
    also be fixed, percentage or auto. This class is intended to be
    extended or created via the layout:'ux.row' 
    Ext.Container.layout config, and
    should generally not need to be created directly via the new
    keyword.
    RowLayout does not have any direct config options (other
    than inherited ones), but it does support a specific config
    property of 
    
      rowHeight
     that can be included in the config of any panel added to
    it. The layout will use the rowHeight (if present) or height of
    each panel during layout to determine how to size each panel.
    If height or rowHeight is not specified for a given panel, its
    height will default to the panel's height (or auto).
    The height property is always evaluated as pixels, and must
    be a number greater than or equal to 1. The rowHeight property
    is always evaluated as a percentage, and must be a decimal
    value greater than 0 and less than 1 (e.g., .25).
    The basic rules for specifying row heights are pretty
    simple. The logic makes two passes through the set of contained
    panels. During the first layout pass, all panels that either
    have a fixed height or none specified (auto) are skipped, but
    their heights are subtracted from the overall container height.
    During the second pass, all panels with rowHeights are assigned
    pixel heights in proportion to their percentages based on the
    total 
    remaining container height. In other words, percentage
    height panels are designed to fill the space left over by all
    the fixed-height and/or auto-height panels. Because of this,
    while you can specify any number of rows with different
    percentages, the rowHeights must always add up to 1 (or 100%)
    when added together, otherwise your layout may not render as
    expected. Example usage:


// All rows are percentages -- they must add up to 1
var p = 
new Ext.Panel({
    title: 
'Row Layout - Percentage Only',
    layout:
'ux.row',
    items: [{
        title: 
'Row 1',
        rowHeight: .25
    },{
        title: 
'Row 2',
        rowHeight: .6
    },{
        title: 
'Row 3',
        rowHeight: .15
    }]
});

// Mix of height and rowHeight -- all rowHeight values must
add
// up to 1. The first row will take up exactly 120px, and the
last two
// rows will fill the remaining container height.
var p = 
new Ext.Panel({
    title: 
'Row Layout - Mixed',
    layout:
'ux.row',
    items: [{
        title: 
'Row 1',
        height: 120,
        
// standard panel widths are still supported too:
        width: 
'50%' 
// or 200
    },{
        title: 
'Row 2',
        rowHeight: .8,
        width: 300
    },{
        title: 
'Row 3',
        rowHeight: .2
    }]
});
    
  
 */

@Layout(LayoutType.row)
@ResourceDependency(library = "ext#{ext.version}/ux", name = "RowLayout.js")
@InstanceOf("Ext.ux.layout.RowLayout")
@ParseConfigMode(ui = false,name="layoutConfig",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.ux.layout.RowLayout")
public class RowLayout extends ContainerLayout {
	public static final String COMPONENT_FAMILY = "Ext.ux.layout.RowLayout";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.layout.RowLayout} instance with default property values.
	 * </p>
	 */
	public RowLayout() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
	
	    
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				return superEvent;
	}
}