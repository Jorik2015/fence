package ext;

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
import java.util.Date;

/**
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">Creates draggable splitter bar
  functionality from two elements (element to be dragged and
  element to be resized).
  <br/>
  <br/>Usage: 
<pre>
<code>
<b>var</b> split = 
<b>new</b> Ext.SplitBar(
<em>"elementToDrag"</em>, 
<em>"elementToSize"</em>,
                   Ext.SplitBar.HORIZONTAL, Ext.SplitBar.LEFT);
split.setAdapter(
<b>new</b> Ext.SplitBar.AbsoluteLayoutAdapter(
<em>"container"</em>));
split.minSize = 100;
split.maxSize = 600;
split.animate = true;
split.on(
<em>'moved'</em>, splitterMoved);</code>
  </pre>
</div>

 */

@InstanceOf("Ext.SplitBar")

@FacesComponent(value = "Ext.SplitBar")
public class SplitBar extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.SplitBar";

	/**
	 * <p>
	 * Create a new {@link Ext.SplitBar} instance with default property values.
	 * </p>
	 */
	public SplitBar() {
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
				superEvent.addAll(Arrays.asList(
					 "beforeresize"
					, "moved"
					, "resize"
				));
				return superEvent;
	}
}