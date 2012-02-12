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
<div class="description">
    <p>
      <b>
        <u>Overview</u>
      </b>
    </p>
    <p>Ext.Direct aims to streamline communication between the
    client and server by providing a single interface that reduces
    the amount of common code typically required to validate data
    and handle returned data packets (reading data, error
    conditions, etc).</p>
    <p>The Ext.direct namespace includes several classes for a
    closer integration with the server-side. The Ext.data namespace
    also includes classes for working with Ext.data.Stores which
    are backed by data from an Ext.Direct method.</p>
    <p>
      <b>
        <u>Specification</u>
      </b>
    </p>
    <p>For additional information consult the 
    <a href="http://extjs.com/products/extjs/direct.php">Ext.Direct
    Specification</a>.</p>
    <p>
      <b>
        <u>Providers</u>
      </b>
    </p>
    <p>Ext.Direct uses a provider architecture, where one or more
    providers are used to transport data to and from the server.
    There are several providers that exist in the core at the
    moment:</p>
    <div class="mdetail-params">
      <ul>
        <li>
        <a ext:cls="Ext.direct.JsonProvider" href="output/Ext.direct.JsonProvider.html">JsonProvider</a> for
        simple JSON operations</li>
        <li>
        <a ext:cls="Ext.direct.PollingProvider" href="output/Ext.direct.PollingProvider.html">PollingProvider</a>
        for repeated requests</li>
        <li>
        <a ext:cls="Ext.direct.RemotingProvider" href="output/Ext.direct.RemotingProvider.html">RemotingProvider</a>
        exposes server side on the client.</li>
      </ul>
    </div>
    <p>A provider does not need to be invoked directly, providers
    are added via 
    <a ext:cls="Ext.Direct" href="output/Ext.Direct.html">Ext.Direct</a>.
    <a ext:cls="Ext.Direct" ext:member="add" href="output/Ext.Direct.html#Ext.Direct-add">add</a>.</p>
    <p>
      <b>
        <u>Router</u>
      </b>
    </p>
    <p>Ext.Direct utilizes a "router" on the server to direct
    requests from the client to the appropriate server-side method.
    Because the Ext.Direct API is completely platform-agnostic, you
    could completely swap out a Java based server solution and
    replace it with one that uses C# without changing the client
    side JavaScript at all.</p>
    <p>
      <b>
        <u>Server side events</u>
      </b>
    </p>
    <p>Custom events from the server may be handled by the client
    by adding listeners, for example:</p>
<pre>
<code>{
<em>"type"</em>:
<em>"event"</em>,
<em>"name"</em>:
<em>"message"</em>,
<em>"data"</em>:
<em>"Successfully polled at: 11:19:30 am"</em>}

<i>// add a handler 
<b>for</b> a 
<em>'message'</em> event sent by the server</i>
Ext.Direct.on(
<em>'message'</em>, 
<b>function</b>(e){
    out.append(String.format(
<em>'&lt;p&gt;&lt;i&gt;{0}&lt;/i&gt;&lt;/p&gt;'</em>, e.data));
            out.el.scrollTo(
<em>'t'</em>, 100000, true);
});</code>
    </pre>
    <br/>
    <br/>
    <i>This class is a singleton and cannot be created
    directly.</i>
  </div>

 */

@InstanceOf("Ext.Direct")

@FacesComponent(value = "Ext.Direct")
public class Direct extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.Direct";

	/**
	 * <p>
	 * Create a new {@link Ext.Direct} instance with default property values.
	 * </p>
	 */
	public Direct() {
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
					 "event"
					, "exception"
				));
				return superEvent;
	}
}