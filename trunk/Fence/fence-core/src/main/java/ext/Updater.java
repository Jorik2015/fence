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
<div class="description">Provides AJAX-style update capabilities
  for Element objects. Updater can be used to 
  <a ext:cls="Ext.Updater" ext:member="update" href="output/Ext.Updater.html#Ext.Updater-update">update</a> an 
  <a ext:cls="Ext.Element" href="output/Ext.Element.html">Ext.Element</a> once, or you can use 
  <a ext:cls="Ext.Updater" ext:member="startAutoRefresh" href="output/Ext.Updater.html#Ext.Updater-startAutoRefresh">startAutoRefresh</a> to set up an
  auto-updating 
  <a ext:cls="Ext.Element" href="output/Ext.Element.html">Element</a> on a specific interval.
  <br/>
  <br/>Usage:
  <br/>
<pre>
<code>
<b>var</b> el = Ext.get(
<em>"foo"</em>); 
<i>// Get Ext.Element object</i>
<b>var</b> mgr = el.getUpdater();
mgr.update({
        url: 
<em>"http:
<i>//myserver.com/index.php"</i>,</em>
        params: {
            param1: 
<em>"foo"</em>,
            param2: 
<em>"bar"</em>
        }
});
...
mgr.formUpdate(
<em>"myFormId"</em>, 
<em>"http:
<i>//myserver.com/index.php"</i>);</em>
<br/>
<i>// or directly (returns the same Updater instance)</i>
<b>var</b> mgr = 
<b>new</b> Ext.Updater(
<em>"myElementId"</em>);
mgr.startAutoRefresh(60, 
<em>"http:
<i>//myserver.com/index.php"</i>);</em>
mgr.on(
<em>"update"</em>, myFcnNeedsToKnow);
<br/>
<i>// short handed call directly from the element object</i>
Ext.get(
<em>"foo"</em>).load({
        url: 
<em>"bar.php"</em>,
        scripts: true,
        params: 
<em>"param1=foo&amp;param2=bar"</em>,
        text: 
<em>"Loading Foo..."</em>
});</code>
  </pre>
</div>

 */

@InstanceOf("Ext.Updater")

@FacesComponent(value = "Ext.Updater")
public class Updater extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.Updater";

	/**
	 * <p>
	 * Create a new {@link Ext.Updater} instance with default property values.
	 * </p>
	 */
	public Updater() {
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
					 "beforeupdate"
					, "failure"
					, "update"
				));
				return superEvent;
	}
}