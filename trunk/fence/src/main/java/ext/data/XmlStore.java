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
 * 
  Small helper class to make creating 
  Ext.data.Stores from XML data
  easier. A XmlStore will be automatically configured with a 
  Ext.data.XmlReader.
  A store configuration would be something like:


var store = 
new Ext.data.XmlStore({
    
// store configs
    autoDestroy: true,
    storeId: 
'myStore',
    url: 
'sheldon.xml', 
// automatically configures a HttpProxy
    
// reader configs
    record: 
'Item', 
// records will have an 
"Item" tag
    idPath: 
'ASIN',
    totalRecords: 
'@TotalResults'
    fields: [
        
// set up the fields mapping into the xml doc
        
// The first needs mapping, the others are very basic
        {name: 
'Author', mapping: 
'ItemAttributes > Author'},
        
'Title', 
'Manufacturer', 
'ProductGroup'
    ]
});
  
  
   
  This store is configured to consume a returned object of the
  form:

<?xml version=
"1.0" encoding=
"UTF-8"?>
&#60ItemSearchResponse xmlns=
"http:
//webservices.amazon.com/AWSECommerceService/2009-05-15">
    &#60Items>
        &#60Request>
            &#60IsValid>True</IsValid>
            &#60ItemSearchRequest>
                &#60Author>Sidney Sheldon</Author>
                &#60SearchIndex>Books</SearchIndex>
            </ItemSearchRequest>
        </Request>
        &#60TotalResults>203</TotalResults>
        &#60TotalPages>21</TotalPages>
        &#60Item>
            &#60ASIN>0446355453</ASIN>
            &#60DetailPageURL>
                http:
//www.amazon.com/
            </DetailPageURL>
            &#60ItemAttributes>
                &#60Author>Sidney Sheldon</Author>
                &#60Manufacturer>Warner
Books</Manufacturer>
                &#60ProductGroup>Book</ProductGroup>
                &#60Title>Master of the Game</Title>
            </ItemAttributes>
        </Item>
    </Items>
</ItemSearchResponse>
  An object literal of this form could also be used as the 
  data config
  option.
  
   
  
  Note: Although not listed here, this class accepts all of
  the configuration options of 
  
    XmlReader
  .
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