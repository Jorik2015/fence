package com.abner.fence.component;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

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
 * ${ext.commonts}
 */

@InstanceOf("Ext.ExtLayout")

@FacesComponent(value = "Ext.ExtLayout")
public class ExtLayout extends BoxComponent {
	public static final String COMPONENT_FAMILY = "Ext.ExtLayout";

	/**
	 * <p>
	 * Create a new {@link Ext.ExtLayout} instance with default property values.
	 * </p>
	 */
	public ExtLayout() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			renderHidden
			,extraCls
			,defaultAnchor
			,anchor
			,animate
			,collapseFirst
			,hideCollapseTool
			,titleCollapse
			,activeOnTop
			,fill
			,sequence
			,autoWidth
			,defaultMargins
			,padding
			,deferredRender
			,layoutOnCardChange
			,fieldTpl
			,trackLabels
			,labelSeparator
			,pack
			,align
			,flex
			,tableAttrs
			,columns
			,collapsible
			,autoHide
			,cmargins
			,margins
			,animFloat
			,floatable
			,collapseMode
			,split
			,minWidth
			,minHeight
		;
		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {
		}

		public String toString() {
			return ((toString != null) ? toString : super.toString());
		}
	}
	
		/*
	 *
        
        
          renderHidden
         : Boolean
        True to hide each contained item on
        render (defaults to false).
	 */
	
	public Boolean getRenderHidden () {
		return (Boolean) getStateHelper().eval(PropertyKeys.renderHidden);
	}

	/**
	 * <p>
	 * Set the value of the <code>renderHidden</code> property.
	 * </p>
	 */
	public void setRenderHidden ( Boolean   renderHidden ) {
		getStateHelper().put(PropertyKeys.renderHidden, renderHidden);
		handleAttribute("renderHidden", renderHidden);
	}
    	/*
	 *
          An optional extra CSS class that will be added to the
          container. This can be useful for adding customized
          styles to the container or any of its children using
          standard CSS rules. See 
          Ext.Component.
          ctCls
          also.
          
          Note: 
          extraCls defaults to 
          '' except for the following classes which assign
          a value by default:
          
            
              
              Absolute
              Layout : 
              'x-abs-layout-item'
              
              Box Layout : 
              'x-box-item'
              
              Column Layout :
              
              'x-column'
            
          To configure the above Classes with an extra CSS
          class append to the default. For example, for
          ColumnLayout:

extraCls: 
'x-column custom-class'
          
          
          
	 */
	
	public String getExtraCls () {
		return (String) getStateHelper().eval(PropertyKeys.extraCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>extraCls</code> property.
	 * </p>
	 */
	public void setExtraCls ( String   extraCls ) {
		getStateHelper().put(PropertyKeys.extraCls, extraCls);
		handleAttribute("extraCls", extraCls);
	}
    	/*
	 *default anchor for all child container
          items applied if no anchor or specific width is set on
          the child item. Defaults to '100%'.
	 */
	
	public String getDefaultAnchor () {
		return (String) getStateHelper().eval(PropertyKeys.defaultAnchor);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultAnchor</code> property.
	 * </p>
	 */
	public void setDefaultAnchor ( String   defaultAnchor ) {
		getStateHelper().put(PropertyKeys.defaultAnchor, defaultAnchor);
		handleAttribute("defaultAnchor", defaultAnchor);
	}
    	/*
	 *
            This configuation option is to be applied to 
            child 
            items of a container managed by this
            layout (ie. configured with 
            layout:'anchor').
            
            This value is what tells the layout how an item
            should be anchored to the container. 
            items added to an AnchorLayout accept an
            anchoring-specific config property of 
            anchor which is a string containing two values:
            the horizontal anchor value and the vertical anchor
            value (for example, '100% 50%'). The following types of
            anchor values are supported:
            
              
                
                Percentage : Any value between 1 and 100,
                expressed as a percentage.
                The first anchor is the
                percentage width that the item should take up
                within the container, and the second is the
                percentage height. For example:


// two values specified
anchor: 
'100% 50%' 
// render item complete width of the container and
                   
// 1/2 height of the container
// one value specified
anchor: 
'100%'     
// the width value; the height will 
default to auto
                
                
                Offsets : Any positive or negative integer
                value.
                This is a raw adjustment
                where the first anchor is the offset from the right
                edge of the container, and the second is the offset
                from the bottom edge. For example:


// two values specified
anchor: 
'-50 -100' 
// render item the complete width of the container
                   
// minus 50 pixels and
                   
// the complete height minus 100 pixels.
// one value specified
anchor: 
'-50'      
// anchor value is assumed to be the right offset value
                   
// bottom offset will 
default to 0
                
                
                Sides : Valid values are 
                'right' (or 
                'r') and 
                'bottom' (or 
                'b').
                Either the container must
                have a fixed size or an anchorSize config value
                defined at render time in order for these to have
                any effect.
                
                Mixed : 
                Anchor values can also be
                mixed as needed. For example, to render the width
                offset from the container right edge by 50 pixels
                and 75% of the container's height use: 

anchor: 
'-50 75%'
                
              
            
          
	 */
	
	public String getAnchor () {
		return (String) getStateHelper().eval(PropertyKeys.anchor);
	}

	/**
	 * <p>
	 * Set the value of the <code>anchor</code> property.
	 * </p>
	 */
	public void setAnchor ( String   anchor ) {
		getStateHelper().put(PropertyKeys.anchor, anchor);
		handleAttribute("anchor", anchor);
	}
    	/*
	 *True to slide the contained panels open
          and closed during expand/collapse using animation, false
          to open and close directly with no animation (defaults to
          false). Note: to defer to the specific config setting of
          each contained panel for this property, set this to
          undefined at the layout level.
	 */
	
	public Boolean getAnimate () {
		return (Boolean) getStateHelper().eval(PropertyKeys.animate);
	}

	/**
	 * <p>
	 * Set the value of the <code>animate</code> property.
	 * </p>
	 */
	public void setAnimate ( Boolean   animate ) {
		getStateHelper().put(PropertyKeys.animate, animate);
		handleAttribute("animate", animate);
	}
    	/*
	 *True to make sure the collapse/expand
          toggle button always renders first (to the left of) any
          other tools in the contained panels' title bars, false to
          render it last (defaults to false).
	 */
	
	public Boolean getCollapseFirst () {
		return (Boolean) getStateHelper().eval(PropertyKeys.collapseFirst);
	}

	/**
	 * <p>
	 * Set the value of the <code>collapseFirst</code> property.
	 * </p>
	 */
	public void setCollapseFirst ( Boolean   collapseFirst ) {
		getStateHelper().put(PropertyKeys.collapseFirst, collapseFirst);
		handleAttribute("collapseFirst", collapseFirst);
	}
    	/*
	 *True to hide the contained panels'
          collapse/expand toggle buttons, false to display them
          (defaults to false). When set to true, 
          titleCollapse
          should be true also.
	 */
	
	public Boolean getHideCollapseTool () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hideCollapseTool);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideCollapseTool</code> property.
	 * </p>
	 */
	public void setHideCollapseTool ( Boolean   hideCollapseTool ) {
		getStateHelper().put(PropertyKeys.hideCollapseTool, hideCollapseTool);
		handleAttribute("hideCollapseTool", hideCollapseTool);
	}
    	/*
	 *True to allow expand/collapse of each
          contained panel by clicking anywhere on the title bar,
          false to allow expand/collapse only when the toggle tool
          button is clicked (defaults to true). When set to false, 
          hideCollapseTool
          should be false also.
	 */
	
	public Boolean getTitleCollapse () {
		return (Boolean) getStateHelper().eval(PropertyKeys.titleCollapse);
	}

	/**
	 * <p>
	 * Set the value of the <code>titleCollapse</code> property.
	 * </p>
	 */
	public void setTitleCollapse ( Boolean   titleCollapse ) {
		getStateHelper().put(PropertyKeys.titleCollapse, titleCollapse);
		handleAttribute("titleCollapse", titleCollapse);
	}
    	/*
	 *True to swap the position of each panel
          as it is expanded so that it becomes the first item in
          the container, false to keep the panels in the rendered
          order. 
          This is NOT compatible with "animate:true"
          (defaults to false).
	 */
	
	public Boolean getActiveOnTop () {
		return (Boolean) getStateHelper().eval(PropertyKeys.activeOnTop);
	}

	/**
	 * <p>
	 * Set the value of the <code>activeOnTop</code> property.
	 * </p>
	 */
	public void setActiveOnTop ( Boolean   activeOnTop ) {
		getStateHelper().put(PropertyKeys.activeOnTop, activeOnTop);
		handleAttribute("activeOnTop", activeOnTop);
	}
    	/*
	 *True to adjust the active item's height
          to fill the available space in the container, false to
          use the item's current height, or auto height if not
          explicitly set (defaults to true).
	 */
	
	public Boolean getFill () {
		return (Boolean) getStateHelper().eval(PropertyKeys.fill);
	}

	/**
	 * <p>
	 * Set the value of the <code>fill</code> property.
	 * </p>
	 */
	public void setFill ( Boolean   fill ) {
		getStateHelper().put(PropertyKeys.fill, fill);
		handleAttribute("fill", fill);
	}
    	/*
	 *
        
        
          sequence
         : Boolean
        
        Experimental. If animate is set to true, this will
        result in each animation running in sequence.
	 */
	
	public Boolean getSequence () {
		return (Boolean) getStateHelper().eval(PropertyKeys.sequence);
	}

	/**
	 * <p>
	 * Set the value of the <code>sequence</code> property.
	 * </p>
	 */
	public void setSequence ( Boolean   sequence ) {
		getStateHelper().put(PropertyKeys.sequence, sequence);
		handleAttribute("sequence", sequence);
	}
    	/*
	 *True to set each contained item's width
          to 'auto', false to use the item's current width
          (defaults to true). Note that some components, in
          particular the 
          grid, will not function
          properly within layouts if they have auto width, so in
          such cases this config should be set to false.
	 */
	
	public Boolean getAutoWidth () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoWidth</code> property.
	 * </p>
	 */
	public void setAutoWidth ( Boolean   autoWidth ) {
		getStateHelper().put(PropertyKeys.autoWidth, autoWidth);
		handleAttribute("autoWidth", autoWidth);
	}
    	/*
	 *
            If the individual contained items do not have a 
            margins property specified, the default
            margins from this property will be applied to each
            item.
            
            This property may be specified as an object
            containing margins to apply in the format:

{
    top: (top margin),
    right: (right margin),
    bottom: (bottom margin),
    left: (left margin)
}
            
            This property may also be specified as a string
            containing space-separated, numeric margin values. The
            order of the sides associated with each value matches
            the way CSS processes margin values:
            
              
                If there is only one value, it applies to all
                sides.
                If there are two values, the top and bottom
                borders are set to the first value and the right
                and left are set to the second.
                If there are three values, the top is set to
                the first value, the left and right are set to the
                second, and the bottom is set to the third.
                If there are four values, they apply to the
                top, right, bottom, and left, respectively.
              
            
            Defaults to:

{top:0, right:0, bottom:0, left:0}
            
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getDefaultMargins () {
		return (Object) getStateHelper().eval(PropertyKeys.defaultMargins);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultMargins</code> property.
	 * </p>
	 */
	public void setDefaultMargins ( Object   defaultMargins ) {
		getStateHelper().put(PropertyKeys.defaultMargins, defaultMargins);
		handleAttribute("defaultMargins", defaultMargins);
	}
    	/*
	 *
            Sets the padding to be applied to all child items
            managed by this layout.
            This property must be specified as a string
            containing space-separated, numeric padding values. The
            order of the sides associated with each value matches
            the way CSS processes padding values:
            
              
                If there is only one value, it applies to all
                sides.
                If there are two values, the top and bottom
                borders are set to the first value and the right
                and left are set to the second.
                If there are three values, the top is set to
                the first value, the left and right are set to the
                second, and the bottom is set to the third.
                If there are four values, they apply to the
                top, right, bottom, and left, respectively.
              
            
            Defaults to: 
            
              "0"
            
          
	 */
	
	public String getPadding () {
		return (String) getStateHelper().eval(PropertyKeys.padding);
	}

	/**
	 * <p>
	 * Set the value of the <code>padding</code> property.
	 * </p>
	 */
	public void setPadding ( String   padding ) {
		getStateHelper().put(PropertyKeys.padding, padding);
		handleAttribute("padding", padding);
	}
    	/*
	 *True to render each contained item at
          the time it becomes active, false to render all contained
          items as soon as the layout is rendered (defaults to
          false). If there is a significant amount of content or a
          lot of heavy controls being rendered into panels that are
          not displayed by default, setting this to true might
          improve performance.
	 */
	
	public Boolean getDeferredRender () {
		return (Boolean) getStateHelper().eval(PropertyKeys.deferredRender);
	}

	/**
	 * <p>
	 * Set the value of the <code>deferredRender</code> property.
	 * </p>
	 */
	public void setDeferredRender ( Boolean   deferredRender ) {
		getStateHelper().put(PropertyKeys.deferredRender, deferredRender);
		handleAttribute("deferredRender", deferredRender);
	}
    	/*
	 *
        
        
          layoutOnCardChange
         : Boolean
        True to force a layout of the active
        item when the active card is changed. Defaults to
        false.
	 */
	
	public Boolean getLayoutOnCardChange () {
		return (Boolean) getStateHelper().eval(PropertyKeys.layoutOnCardChange);
	}

	/**
	 * <p>
	 * Set the value of the <code>layoutOnCardChange</code> property.
	 * </p>
	 */
	public void setLayoutOnCardChange ( Boolean   layoutOnCardChange ) {
		getStateHelper().put(PropertyKeys.layoutOnCardChange, layoutOnCardChange);
		handleAttribute("layoutOnCardChange", layoutOnCardChange);
	}
    	/*
	 *A 
          compiled 
          Ext.Template for rendering the
          fully wrapped, labeled and styled form Field. Defaults
          to:
          
          


new Ext.Template(
    '<div class=
"x-form-item {itemCls}" tabIndex=
"-1">',
        '<label 
for=
"{id}" style=
"{labelStyle}" class=
"x-form-item-label">{label}{labelSeparator}</label>',
        '<div class=
"x-form-element" id=
"x-form-el-{id}" style=
"{elementStyle}">',
        '</div><div class=
"{clearCls}"></div>',
    
'</div>'
);
          
          This may be specified to produce a different DOM
          structure when rendering form Fields.
          A description of the properties within the template
          follows:
          
            
              
              
                itemCls
               : String
              The CSS class applied to the
              outermost div wrapper that contains this field label
              and field element (the default class is 
              'x-form-item' and 
              itemCls will be added to that). If supplied,
              
              itemCls at the field level will override the
              default 
              itemCls supplied at the container
              level.
              
              
                id
               : String
              The id of the Field
              
              
                
                  labelStyle
                
               : String
              A CSS style specification
              string to add to the field label for this field
              (defaults to 
              '' or the 
              layout's value for 
              labelStyle).
              
              
                label
               : String
              The text to display as the
              label for this field (defaults to 
              '')
              
              
                
                  labelSeparator
                
               : String
              The separator to display after
              the text of the label for this field (defaults to a
              colon 
              ':' or the 
              layout's value for
              labelSeparator). To hide the separator use empty
              string ''.
              
              
                elementStyle
               : String
              The styles text for the input
              element's wrapper.
              
              
                clearCls
               : String
              The CSS class to apply to the
              special clearing div rendered directly after each
              form field wrapper (defaults to 
              'x-form-clear-left')
            
          
          Also see 
          
            getTemplateArgs
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getFieldTpl () {
		return (Object) getStateHelper().eval(PropertyKeys.fieldTpl);
	}

	/**
	 * <p>
	 * Set the value of the <code>fieldTpl</code> property.
	 * </p>
	 */
	public void setFieldTpl ( Object   fieldTpl ) {
		getStateHelper().put(PropertyKeys.fieldTpl, fieldTpl);
		handleAttribute("fieldTpl", fieldTpl);
	}
    	/*
	 *
        
        
          trackLabels
         : Boolean
        True to show/hide the field label when
        the field is hidden. Defaults to 
        false.
	 */
	
	public Boolean getTrackLabels () {
		return (Boolean) getStateHelper().eval(PropertyKeys.trackLabels);
	}

	/**
	 * <p>
	 * Set the value of the <code>trackLabels</code> property.
	 * </p>
	 */
	public void setTrackLabels ( Boolean   trackLabels ) {
		getStateHelper().put(PropertyKeys.trackLabels, trackLabels);
		handleAttribute("trackLabels", trackLabels);
	}
    	/*
	 *
        
        
          labelSeparator
         : String
        See 
        Ext.form.FormPanel.
        labelSeparator.
        Configuration of this property at the 
        container level takes precedence.
	 */
	
	public String getLabelSeparator () {
		return (String) getStateHelper().eval(PropertyKeys.labelSeparator);
	}

	/**
	 * <p>
	 * Set the value of the <code>labelSeparator</code> property.
	 * </p>
	 */
	public void setLabelSeparator ( String   labelSeparator ) {
		getStateHelper().put(PropertyKeys.labelSeparator, labelSeparator);
		handleAttribute("labelSeparator", labelSeparator);
	}
    	/*
	 *Controls how the child items of the
          container are packed together. Acceptable configuration
          values for this property are: 
          
            
              
              
                start
               : 
              Default
              child items are packed together
              at 
              left side of container
              
              
                center
               : 
              child items are packed together
              at 
              mid-width of container
              
              
                end
               : 
              child items are packed together
              at 
              right side of container
            
          
	 */
	
	public String getPack () {
		return (String) getStateHelper().eval(PropertyKeys.pack);
	}

	/**
	 * <p>
	 * Set the value of the <code>pack</code> property.
	 * </p>
	 */
	public void setPack ( String   pack ) {
		getStateHelper().put(PropertyKeys.pack, pack);
		handleAttribute("pack", pack);
	}
    	/*
	 *Controls how the child items of the
          container are aligned. Acceptable configuration values
          for this property are: 
          
            
              
              
                top
               : 
              Default
              child items are aligned
              vertically at the 
              top of the container
              
              
                middle
               : 
              child items are aligned
              vertically in the 
              middle of the container
              
              
                stretch
               : 
              child items are stretched
              vertically to fill the height of the
              container
              
              
                stretchmax
               : 
              child items are stretched
              vertically to the height of the largest
              item.
            
          
	 */
	
	public String getAlign () {
		return (String) getStateHelper().eval(PropertyKeys.align);
	}

	/**
	 * <p>
	 * Set the value of the <code>align</code> property.
	 * </p>
	 */
	public void setAlign ( String   align ) {
		getStateHelper().put(PropertyKeys.align, align);
		handleAttribute("align", align);
	}
    	/*
	 *This configuation option is to be
          applied to 
          child 
          items of the container managed by this
          layout. Each child item with a 
          flex property will be flexed 
          horizontally according to each item's 
          relative 
          flex value compared to the sum of all items with
          a 
          flex value specified. Any child items that have
          either a 
          flex = 0 or 
          flex = undefined will not be 'flexed' (the
          initial size will not be changed).
	 */
	
	public Integer getFlex () {
		return (Integer) getStateHelper().eval(PropertyKeys.flex);
	}

	/**
	 * <p>
	 * Set the value of the <code>flex</code> property.
	 * </p>
	 */
	public void setFlex ( Integer   flex ) {
		getStateHelper().put(PropertyKeys.flex, flex);
		handleAttribute("flex", flex);
	}
    	/*
	 *
            An object containing properties which are added to
            the 
            DomHelper specification
            used to create the layout's 
            <table> element. Example:

{
    xtype: 
'panel',
    layout: 
'table',
    layoutConfig: {
        tableAttrs: {
            style: {
                width: 
'100%'
            }
        },
        columns: 3
    }
}
            
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getTableAttrs () {
		return (Object) getStateHelper().eval(PropertyKeys.tableAttrs);
	}

	/**
	 * <p>
	 * Set the value of the <code>tableAttrs</code> property.
	 * </p>
	 */
	public void setTableAttrs ( Object   tableAttrs ) {
		getStateHelper().put(PropertyKeys.tableAttrs, tableAttrs);
		handleAttribute("tableAttrs", tableAttrs);
	}
    	/*
	 *The total number of columns to create
          in the table for this layout. If not specified, all
          Components added to this layout will be rendered into a
          single row using one column per Component.
	 */
	@ClientConfig(value = JsonMode.Object)
	public Object getColumns () {
		return (Object) getStateHelper().eval(PropertyKeys.columns);
	}

	/**
	 * <p>
	 * Set the value of the <code>columns</code> property.
	 * </p>
	 */
	public void setColumns ( Object   columns ) {
		getStateHelper().put(PropertyKeys.columns, columns);
		handleAttribute("columns", columns);
	}
    	/*
	 *
            
            true to allow the user to collapse this region
            (defaults to 
            false). If 
            true, an expand/collapse tool button will
            automatically be rendered into the title bar of the
            region, otherwise the button will not be shown.
            
            Note: that a title bar is required to display
            the collapse/expand toggle button -- if no 
            title is specified for the region's panel, the
            region will only be collapsible if 
            
            collapseMode
            = 'mini' and 
            
            split =
            true.
          
	 */
	
	public Boolean getCollapsible () {
		return (Boolean) getStateHelper().eval(PropertyKeys.collapsible);
	}

	/**
	 * <p>
	 * Set the value of the <code>collapsible</code> property.
	 * </p>
	 */
	public void setCollapsible ( Boolean   collapsible ) {
		getStateHelper().put(PropertyKeys.collapsible, collapsible);
		handleAttribute("collapsible", collapsible);
	}
    	/*
	 *When a collapsed region's bar is
          clicked, the region's panel will be displayed as a
          floated panel. If 
          autoHide = true, the panel will automatically
          hide after the user mouses out of the panel. If 
          autoHide = false, the panel will continue to
          display until the user clicks outside of the panel
          (defaults to 
          true).
	 */
	
	public Boolean getAutoHide () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoHide);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoHide</code> property.
	 * </p>
	 */
	public void setAutoHide ( Boolean   autoHide ) {
		getStateHelper().put(PropertyKeys.autoHide, autoHide);
		handleAttribute("autoHide", autoHide);
	}
    	/*
	 *An object containing margins to apply
          to the region when in the collapsed state in the format:

{
    top: (top margin),
    right: (right margin),
    bottom: (bottom margin),
    left: (left margin)
}
          
          May also be a string containing space-separated,
          numeric margin values. The order of the sides associated
          with each value matches the way CSS processes margin
          values.
          
            If there is only one value, it applies to all
            sides.
            If there are two values, the top and bottom borders
            are set to the first value and the right and left are
            set to the second.
            If there are three values, the top is set to the
            first value, the left and right are set to the second,
            and the bottom is set to the third.
            If there are four values, they apply to the top,
            right, bottom, and left, respectively.
          
          
          
	 */
	
	public String getCmargins () {
		return (String) getStateHelper().eval(PropertyKeys.cmargins);
	}

	/**
	 * <p>
	 * Set the value of the <code>cmargins</code> property.
	 * </p>
	 */
	public void setCmargins ( String   cmargins ) {
		getStateHelper().put(PropertyKeys.cmargins, cmargins);
		handleAttribute("cmargins", cmargins);
	}
    	/*
	 *An object containing margins to apply
          to the region when in the expanded state in the format:

{
    top: (top margin),
    right: (right margin),
    bottom: (bottom margin),
    left: (left margin)
}
          
          May also be a string containing space-separated,
          numeric margin values. The order of the sides associated
          with each value matches the way CSS processes margin
          values:
          
            
              If there is only one value, it applies to all
              sides.
              If there are two values, the top and bottom
              borders are set to the first value and the right and
              left are set to the second.
              If there are three values, the top is set to the
              first value, the left and right are set to the
              second, and the bottom is set to the third.
              If there are four values, they apply to the top,
              right, bottom, and left, respectively.
            
          
          
           
          Defaults to:

{top:0, right:0, bottom:0, left:0}
          
	 */
	
	public String getMargins () {
		return (String) getStateHelper().eval(PropertyKeys.margins);
	}

	/**
	 * <p>
	 * Set the value of the <code>margins</code> property.
	 * </p>
	 */
	public void setMargins ( String   margins ) {
		getStateHelper().put(PropertyKeys.margins, margins);
		handleAttribute("margins", margins);
	}
    	/*
	 *When a collapsed region's bar is
          clicked, the region's panel will be displayed as a
          floated panel that will close again once the user mouses
          out of that panel (or clicks out if 
          
          autoHide =
          false). Setting 
          
          animFloat =
          false will prevent the open and close of these
          floated panels from being animated (defaults to 
          true).
	 */
	
	public Boolean getAnimFloat () {
		return (Boolean) getStateHelper().eval(PropertyKeys.animFloat);
	}

	/**
	 * <p>
	 * Set the value of the <code>animFloat</code> property.
	 * </p>
	 */
	public void setAnimFloat ( Boolean   animFloat ) {
		getStateHelper().put(PropertyKeys.animFloat, animFloat);
		handleAttribute("animFloat", animFloat);
	}
    	/*
	 *
          true to allow clicking a collapsed region's bar
          to display the region's panel floated above the layout, 
          false to force the user to fully expand a
          collapsed region by clicking the expand button to see it
          again (defaults to 
          true).
	 */
	
	public Boolean getFloatable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.floatable);
	}

	/**
	 * <p>
	 * Set the value of the <code>floatable</code> property.
	 * </p>
	 */
	public void setFloatable ( Boolean   floatable ) {
		getStateHelper().put(PropertyKeys.floatable, floatable);
		handleAttribute("floatable", floatable);
	}
    	/*
	 *
          collapseMode supports two configuration values:
          
            
              
              
                undefined
               (default)
              By default, 
              collapsible
              regions are collapsed by clicking the expand/collapse
              tool button that renders into the region's title
              bar.
              
                
                  'mini'
                
                Optionally, when 
                collapseMode is set to 
                'mini' the region's split bar will also
                display a small collapse button in the center of
                the bar. In 
                'mini' mode the region will collapse to a
                thinner bar than in normal mode.
              
            
          
          
           
          
          Note: if a collapsible region does not have a
          title bar, then set 
          collapseMode = 'mini' and 
          
          split =
          true in order for the region to be 
          collapsible
          by the user as the expand/collapse tool button (that
          would go in the title bar) will not be rendered.
          See also 
          
            cmargins
          .
	 */
	
	public String getCollapseMode () {
		return (String) getStateHelper().eval(PropertyKeys.collapseMode);
	}

	/**
	 * <p>
	 * Set the value of the <code>collapseMode</code> property.
	 * </p>
	 */
	public void setCollapseMode ( String   collapseMode ) {
		getStateHelper().put(PropertyKeys.collapseMode, collapseMode);
		handleAttribute("collapseMode", collapseMode);
	}
    	/*
	 *
            
            true to create a 
            SplitRegion
            and display a 5px wide 
            Ext.SplitBar between this
            region and its neighbor, allowing the user to resize
            the regions dynamically. Defaults to 
            false creating a 
            Region.
            
            
            Notes:
            
              
                this configuration option is ignored if 
                region='center'
                when 
                split == true, it is common to specify a 
                
                  minSize
                 and 
                
                  maxSize
                 for the 
                BoxComponent
                representing the region. These are not native
                configs of 
                BoxComponent, and
                are used only by this class.
                if 
                
                collapseMode
                = 'mini' requires 
                split = true to reserve space for the
                collapse tool
              
            
          
	 */
	
	public Boolean getSplit () {
		return (Boolean) getStateHelper().eval(PropertyKeys.split);
	}

	/**
	 * <p>
	 * Set the value of the <code>split</code> property.
	 * </p>
	 */
	public void setSplit ( Boolean   split ) {
		getStateHelper().put(PropertyKeys.split, split);
		handleAttribute("split", split);
	}
    	/*
	 *
            The minimum allowable width in pixels for this
            region (defaults to 
            50). 
            maxWidth may also be specified.
            
            
            Note: setting the 
            
              minSize
             / 
            
              maxSize
             supersedes any specified 
            minWidth / 
            maxWidth.
          
	 */
	
	public Integer getMinWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.minWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>minWidth</code> property.
	 * </p>
	 */
	public void setMinWidth ( Integer   minWidth ) {
		getStateHelper().put(PropertyKeys.minWidth, minWidth);
		handleAttribute("minWidth", minWidth);
	}
    	/*
	 *The minimum allowable height in pixels
          for this region (defaults to 
          50) 
          maxHeight may also be specified.
          
          
          
          
          Note: setting the 
          
            minSize
           / 
          
            maxSize
           supersedes any specified 
          minHeight / 
          maxHeight.
	 */
	
	public Integer getMinHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.minHeight);
	}

	/**
	 * <p>
	 * Set the value of the <code>minHeight</code> property.
	 * </p>
	 */
	public void setMinHeight ( Integer   minHeight ) {
		getStateHelper().put(PropertyKeys.minHeight, minHeight);
		handleAttribute("minHeight", minHeight);
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