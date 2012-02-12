package ext.data;

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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
  <p>Small helper class to make creating 
  <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a>s from XML data
  easier. A XmlStore will be automatically configured with a 
  <a ext:cls="Ext.data.XmlReader" href="output/Ext.data.XmlReader.html">Ext.data.XmlReader</a>.</p>
  <p>A store configuration would be something like:</p>
<pre>
<code>
<b>var</b> store = 
<b>new</b> Ext.data.XmlStore({
    
<i>// store configs</i>
    autoDestroy: true,
    storeId: 
<em>'myStore'</em>,
    url: 
<em>'sheldon.xml'</em>, 
<i>// automatically configures a HttpProxy</i>
    
<i>// reader configs</i>
    record: 
<em>'Item'</em>, 
<i>// records will have an 
<em>"Item"</em> tag</i>
    idPath: 
<em>'ASIN'</em>,
    totalRecords: 
<em>'@TotalResults'</em>
    fields: [
        
<i>// set up the fields mapping into the xml doc</i>
        
<i>// The first needs mapping, the others are very basic</i>
        {name: 
<em>'Author'</em>, mapping: 
<em>'ItemAttributes &gt; Author'</em>},
        
<em>'Title'</em>, 
<em>'Manufacturer'</em>, 
<em>'ProductGroup'</em>
    ]
});</code>
  </pre>
  <br/>
  <br/> 
  <p>This store is configured to consume a returned object of the
  form:</p>
<pre>
<code>&lt;?xml version=
<em>"1.0"</em> encoding=
<em>"UTF-8"</em>?&gt;
&amp;#60ItemSearchResponse xmlns=
<em>"http:
<i>//webservices.amazon.com/AWSECommerceService/2009-05-15"</i>&gt;</em>
    &amp;#60Items&gt;
        &amp;#60Request&gt;
            &amp;#60IsValid&gt;True&lt;/IsValid&gt;
            &amp;#60ItemSearchRequest&gt;
                &amp;#60Author&gt;Sidney Sheldon&lt;/Author&gt;
                &amp;#60SearchIndex&gt;Books&lt;/SearchIndex&gt;
            &lt;/ItemSearchRequest&gt;
        &lt;/Request&gt;
        &amp;#60TotalResults&gt;203&lt;/TotalResults&gt;
        &amp;#60TotalPages&gt;21&lt;/TotalPages&gt;
        &amp;#60Item&gt;
            &amp;#60ASIN&gt;0446355453&lt;/ASIN&gt;
            &amp;#60DetailPageURL&gt;
                http:
<i>//www.amazon.com/</i>
            &lt;/DetailPageURL&gt;
            &amp;#60ItemAttributes&gt;
                &amp;#60Author&gt;Sidney Sheldon&lt;/Author&gt;
                &amp;#60Manufacturer&gt;Warner
Books&lt;/Manufacturer&gt;
                &amp;#60ProductGroup&gt;Book&lt;/ProductGroup&gt;
                &amp;#60Title&gt;Master of the Game&lt;/Title&gt;
            &lt;/ItemAttributes&gt;
        &lt;/Item&gt;
    &lt;/Items&gt;
&lt;/ItemSearchResponse&gt;</code>
  </pre>An object literal of this form could also be used as the 
  <a ext:cls="Ext.data.XmlStore" ext:member="data" href="output/Ext.data.XmlStore.html#Ext.data.XmlStore-data">data</a> config
  option.
  <br/>
  <br/> 
  <p>
  <b>Note:</b> Although not listed here, this class accepts all of
  the configuration options of 
  <b>
    <a ext:cls="Ext.data.XmlReader" href="output/Ext.data.XmlReader.html">XmlReader</a>
  </b>.</p>
</div>

 */
@XType("xmlstore")
@InstanceOf("Ext.data.XmlStore")
@ParseConfigMode(ui = false,name="store",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.XmlStore")
public class XmlStore extends Store {
	public static final String COMPONENT_FAMILY = "Ext.data.XmlStore";

	/**
	 * <p>
	 * Create a new {@link Ext.data.XmlStore} instance with default property values.
	 * </p>
	 */
	public XmlStore() {
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