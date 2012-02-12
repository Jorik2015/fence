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
    <p>Small helper class to create an 
    <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a> configured with an 
    <a ext:cls="Ext.data.DirectProxy" href="output/Ext.data.DirectProxy.html">Ext.data.DirectProxy</a> and 
    <a ext:cls="Ext.data.JsonReader" href="output/Ext.data.JsonReader.html">Ext.data.JsonReader</a> to make
    interacting with an 
    <a ext:cls="Ext.Direct" href="output/Ext.Direct.html">Ext.Direct</a> Server-side 
    <a ext:cls="Ext.direct.Provider" href="output/Ext.direct.Provider.html">Provider</a> easier. To create a
    different proxy/reader combination create a basic 
    <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a> configured as
    needed.</p>
    <p>
    <b>*Note:</b> Although they are not listed, this class inherits
    all of the config options of:</p>
    <div>
      <ul class="mdetail-params">
        <li>
          <b>
            <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Store</a>
          </b>
        </li>
        <li>
          <b>
            <a ext:cls="Ext.data.JsonReader" href="output/Ext.data.JsonReader.html">JsonReader</a>
          </b>
        </li>
        <li style="list-style: none">
          <div class="sub-desc">
            <ul class="mdetail-params">
              <li>
                <tt>
                  <b>
                    <a ext:cls="Ext.data.JsonReader" ext:member="root" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-root">root</a>
                  </b>
                </tt>
              </li>
              <li>
                <tt>
                  <b>
                    <a ext:cls="Ext.data.JsonReader" ext:member="idProperty" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-idProperty">idProperty</a>
                  </b>
                </tt>
              </li>
              <li>
                <tt>
                  <b>
                    <a ext:cls="Ext.data.JsonReader" ext:member="totalProperty" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-totalProperty">totalProperty</a>
                  </b>
                </tt>
              </li>
            </ul>
          </div>
        </li>
        <li>
          <b>
            <a ext:cls="Ext.data.DirectProxy" href="output/Ext.data.DirectProxy.html">DirectProxy</a>
          </b>
        </li>
        <li style="list-style: none">
          <div class="sub-desc">
            <ul class="mdetail-params">
              <li>
                <tt>
                  <b>
                    <a ext:cls="Ext.data.DirectProxy" ext:member="directFn" href="output/Ext.data.DirectProxy.html#Ext.data.DirectProxy-directFn">directFn</a>
                  </b>
                </tt>
              </li>
              <li>
                <tt>
                  <b>
                    <a ext:cls="Ext.data.DirectProxy" ext:member="paramOrder" href="output/Ext.data.DirectProxy.html#Ext.data.DirectProxy-paramOrder">paramOrder</a>
                  </b>
                </tt>
              </li>
              <li>
                <tt>
                  <b>
                    <a ext:cls="Ext.data.DirectProxy" ext:member="paramsAsHash" href="output/Ext.data.DirectProxy.html#Ext.data.DirectProxy-paramsAsHash">paramsAsHash</a>
                  </b>
                </tt>
              </li>
            </ul>
          </div>
        </li>
      </ul>
    </div>
  </div>

 */
@XType("directstore")
@InstanceOf("Ext.data.DirectStore")
@ParseConfigMode(ui = false,name="store",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
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