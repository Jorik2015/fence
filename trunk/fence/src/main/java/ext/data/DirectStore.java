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
    Small helper class to create an 
    Ext.data.Store configured with an 
    Ext.data.DirectProxy and 
    Ext.data.JsonReader to make
    interacting with an 
    Ext.Direct Server-side 
    Provider easier. To create a
    different proxy/reader combination create a basic 
    Ext.data.Store configured as
    needed.
    
    *Note: Although they are not listed, this class inherits
    all of the config options of:
    
      
        
          
            Store
          
        
        
          
            JsonReader
          
        
        
          
            
              
                
                  
                    root
                  
                
              
              
                
                  
                    idProperty
                  
                
              
              
                
                  
                    totalProperty
                  
                
              
            
          
        
        
          
            DirectProxy
          
        
        
          
            
              
                
                  
                    directFn
                  
                
              
              
                
                  
                    paramOrder
                  
                
              
              
                
                  
                    paramsAsHash
                  
                
              
            
          
        
      
    
  
 */
@XType("directstore")
@InstanceOf("Ext.data.DirectStore")
@ParseConfigMode(id=false,ui = false,name="store",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.DirectStore")
public class DirectStore extends Store {
	public static final String COMPONENT_FAMILY = "Ext.data.DirectStore";

	/**
	 * <p>
	 * Create a new {@link Ext.data.DirectStore} instance with default property values.
	 * </p>
	 */
	public DirectStore() {
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