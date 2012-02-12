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
<div class="description">DataWriter extension for writing an
  array or single 
  <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a> object(s) in
  preparation for executing a remote CRUD action via XML. XmlWriter
  uses an instance of 
  <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">Ext.XTemplate</a> for maximum flexibility
  in defining your own custom XML schema if the default schema is
  not appropriate for your needs. See the 
  <a ext:cls="Ext.data.XmlWriter" ext:member="tpl" href="output/Ext.data.XmlWriter.html#Ext.data.XmlWriter-tpl">tpl</a>
  configuration-property.</div>

 */

@InstanceOf("Ext.data.XmlWriter")
@ParseConfigMode(ui = false,name="writer",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.XmlWriter")
public class XmlWriter extends DataWriter {
	public static final String COMPONENT_FAMILY = "Ext.data.XmlWriter";

	/**
	 * <p>
	 * Create a new {@link Ext.data.XmlWriter} instance with default property values.
	 * </p>
	 */
	public XmlWriter() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			forceDocumentRoot
			,root
			,tpl
			,xmlVersion
			,xmlEncoding
			,documentRoot
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">[false] Set to 
          <tt>true</tt> to force XML documents having a root-node
          as defined by 
          <a ext:cls="Ext.data.XmlWriter" ext:member="documentRoot" href="output/Ext.data.XmlWriter.html#Ext.data.XmlWriter-documentRoot">documentRoot</a>, even with
          no baseParams defined.</div>

	 */
	
	public Boolean getForceDocumentRoot () {
		return (Boolean) getStateHelper().eval(PropertyKeys.forceDocumentRoot);
	}

	/**
	 * <p>
	 * Set the value of the <code>forceDocumentRoot</code> property.
	 * </p>
	 */
	public void setForceDocumentRoot ( Boolean   forceDocumentRoot ) {
		getStateHelper().put(PropertyKeys.forceDocumentRoot, forceDocumentRoot);
		handleAttribute("forceDocumentRoot", forceDocumentRoot);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">[records] The name of the containing
          element which will contain the nodes of an write-action
          involving 
          <b>multiple</b> records. Each xml-record written to the
          server will be wrapped in an element named after 
          <a ext:cls="Ext.data.XmlReader" ext:member="record" href="output/Ext.data.XmlReader.html#Ext.data.XmlReader-record">Ext.data.XmlReader.record</a>
          property. eg: 
<pre>
<code>&lt;?xml version=
<em>"1.0"</em> encoding=
<em>"UTF-8"</em>?&gt;
&lt;user&gt;&lt;first&gt;Barney&lt;/first&gt;&lt;/user&gt;</code>
          </pre>However, when 
          <b>multiple</b> records are written in a batch-operation,
          these records must be wrapped in a containing Element.
          eg: 
<pre>
<code>&lt;?xml version=
<em>"1.0"</em> encoding=
<em>"UTF-8"</em>?&gt;
    &lt;records&gt;
        &lt;first&gt;Barney&lt;/first&gt;&lt;/user&gt;
       
&lt;records&gt;&lt;first&gt;Barney&lt;/first&gt;&lt;/user&gt;
    &lt;/records&gt;</code>
          </pre>Defaults to 
          <tt>records</tt>. Do not confuse the nature of this
          property with that of 
          <a ext:cls="Ext.data.XmlWriter" ext:member="documentRoot" href="output/Ext.data.XmlWriter.html#Ext.data.XmlWriter-documentRoot">documentRoot</a>
</div>

	 */
	
	public String getRoot () {
		return (String) getStateHelper().eval(PropertyKeys.root);
	}

	/**
	 * <p>
	 * Set the value of the <code>root</code> property.
	 * </p>
	 */
	public void setRoot ( String   root ) {
		getStateHelper().put(PropertyKeys.root, root);
		handleAttribute("root", root);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The XML template used to render 
          <a ext:cls="Ext.data.Api" ext:member="actions" href="output/Ext.data.Api.html#Ext.data.Api-actions">write-actions</a> to your server. 
          <p>One can easily provide his/her own custom 
          <a ext:cls="Ext.XTemplate" ext:member="constructor" href="output/Ext.XTemplate.html#Ext.XTemplate-constructor">template-definition</a> if the
          default does not suffice.</p>
          <p>Defaults to:</p>
<pre>
<code>&lt;?xml version=
<em>"{version}"</em> encoding=
<em>"{encoding}"</em>?&gt;
    &lt;tpl 
<b>if</b>=
<em>"documentRoot"</em>&gt;&lt;{documentRoot}&gt;
    &lt;tpl 
<b>for</b>=
<em>"baseParams"</em>&gt;
        &lt;tpl 
<b>for</b>=
<em>"."</em>&gt;
            &lt;{name}&gt;{value}&lt;/{name}&gt;
        &lt;/tpl&gt;
    &lt;/tpl&gt;
    &lt;tpl 
<b>if</b>=
<em>"records.length &gt; 1"</em>&gt;&lt;{root}&gt;
<em>',
    &lt;tpl 
<b>for</b>=</em>"records"</code>&gt;
        &lt;{parent.record}&gt;
        &lt;tpl 
<b>for</b>=
<em>"."</em>&gt;
            &lt;{name}&gt;{value}&lt;/{name}&gt;
        &lt;/tpl&gt;
        &lt;/{parent.record}&gt;
    &lt;/tpl&gt;
    &lt;tpl 
<b>if</b>=
<em>"records.length &gt; 1"</em>&gt;&lt;/{root}&gt;&lt;/tpl&gt;
    &lt;tpl 
<b>if</b>=
<em>"documentRoot"</em>&gt;&lt;/{documentRoot}&gt;&lt;/tpl&gt;
          </pre>
          <p>Templates will be called with the following API</p>
          <ul>
            <li>{String} version [1.0] The xml version.</li>
            <li>{String} encoding [ISO-8859-15] The xml
            encoding.</li>
            <li>{String/false} documentRoot The XML document
            root-node name or 
            <tt>false</tt> if not required. See 
            <a ext:cls="Ext.data.XmlWriter" ext:member="documentRoot" href="output/Ext.data.XmlWriter.html#Ext.data.XmlWriter-documentRoot">documentRoot</a> and 
            <a ext:cls="Ext.data.XmlWriter" ext:member="forceDocumentRoot" href="output/Ext.data.XmlWriter.html#Ext.data.XmlWriter-forceDocumentRoot">forceDocumentRoot</a>.</li>
            <li>{String} record The meta-data parameter defined on
            your 
            <a ext:cls="Ext.data.XmlReader" ext:member="record" href="output/Ext.data.XmlReader.html#Ext.data.XmlReader-record">Ext.data.XmlReader.record</a>
            configuration represents the name of the xml-tag
            containing each record.</li>
            <li>{String} root The meta-data parameter defined by 
            <a ext:cls="Ext.data.XmlWriter" ext:member="root" href="output/Ext.data.XmlWriter.html#Ext.data.XmlWriter-root">Ext.data.XmlWriter.root</a>
            configuration-parameter. Represents the name of the xml
            root-tag when sending 
            <b>multiple</b> records to the server.</li>
            <li>{Array} records The records being sent to the
            server, ie: the subject of the write-action being
            performed. The records parameter will be always be an
            array, even when only a single record is being acted
            upon. Each item within the records array will contain
            an array of field objects having the following
            properties: 
            <ul>
              <li>{String} name The field-name of the record as
              defined by your 
              <a ext:cls="Ext.data.Record" ext:member="create" href="output/Ext.data.Record.html#Ext.data.Record-create">Ext.data.Record
              definition</a>. The "mapping" property will be used,
              otherwise it will match the "name" property. Use this
              parameter to define the XML tag-name of the
              property.</li>
              <li>{Mixed} value The record value of the field
              enclosed within XML tags specified by name property
              above.</li>
            </ul>
</li>
            <li>{Array} baseParams. The baseParams as defined upon 
            <a ext:cls="Ext.data.Store" ext:member="baseParams" href="output/Ext.data.Store.html#Ext.data.Store-baseParams">Ext.data.Store.baseParams</a>.
            Note that the baseParams have been converted into an
            array of [{name : "foo", value: "bar"}, ...] pairs in
            the same manner as the 
            <b>records</b> parameter above. See 
            <a ext:cls="Ext.data.XmlWriter" ext:member="documentRoot" href="output/Ext.data.XmlWriter.html#Ext.data.XmlWriter-documentRoot">documentRoot</a> and 
            <a ext:cls="Ext.data.XmlWriter" ext:member="forceDocumentRoot" href="output/Ext.data.XmlWriter.html#Ext.data.XmlWriter-forceDocumentRoot">forceDocumentRoot</a>.</li>
          </ul>
</div>

	 */
	
	public String getTpl () {
		return (String) getStateHelper().eval(PropertyKeys.tpl);
	}

	/**
	 * <p>
	 * Set the value of the <code>tpl</code> property.
	 * </p>
	 */
	public void setTpl ( String   tpl ) {
		getStateHelper().put(PropertyKeys.tpl, tpl);
		handleAttribute("tpl", tpl);
	}
    	/*
	 *
        
        
          xmlVersion
         : String
        [1.0] The 
        version written to header of xml documents. 

<?xml version=
"1.0" encoding=
"ISO-8859-15"?>
        
	 */
	
	public String getXmlVersion () {
		return (String) getStateHelper().eval(PropertyKeys.xmlVersion);
	}

	/**
	 * <p>
	 * Set the value of the <code>xmlVersion</code> property.
	 * </p>
	 */
	public void setXmlVersion ( String   xmlVersion ) {
		getStateHelper().put(PropertyKeys.xmlVersion, xmlVersion);
		handleAttribute("xmlVersion", xmlVersion);
	}
    	/*
	 *
        
        
          xmlEncoding
         : String
        [ISO-8859-15] The 
        encoding written to header of xml documents. 

<?xml version=
"1.0" encoding=
"ISO-8859-15"?>
        
	 */
	
	public String getXmlEncoding () {
		return (String) getStateHelper().eval(PropertyKeys.xmlEncoding);
	}

	/**
	 * <p>
	 * Set the value of the <code>xmlEncoding</code> property.
	 * </p>
	 */
	public void setXmlEncoding ( String   xmlEncoding ) {
		getStateHelper().put(PropertyKeys.xmlEncoding, xmlEncoding);
		handleAttribute("xmlEncoding", xmlEncoding);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">[xrequest] (Optional) The name of the
          XML document root-node. 
          <b>Note:</b> this parameter is required only when sending
          extra 
          <a ext:cls="Ext.data.Store" ext:member="baseParams" href="output/Ext.data.Store.html#Ext.data.Store-baseParams">baseParams</a> to the server
          during a write-request -- if no baseParams are set, the 
          <a ext:cls="Ext.data.XmlReader" ext:member="record" href="output/Ext.data.XmlReader.html#Ext.data.XmlReader-record">Ext.data.XmlReader.record</a>
          meta-property can suffice as the XML document root-node
          for write-actions involving just a 
          <b>single record</b>. For requests involving 
          <b>multiple</b> records and 
          <b>NO</b> baseParams, the 
          <a ext:cls="Ext.data.XmlWriter" ext:member="root" href="output/Ext.data.XmlWriter.html#Ext.data.XmlWriter-root">Ext.data.XmlWriter.root</a>
          property can act as the XML document root.</div>

	 */
	
	public String getDocumentRoot () {
		return (String) getStateHelper().eval(PropertyKeys.documentRoot);
	}

	/**
	 * <p>
	 * Set the value of the <code>documentRoot</code> property.
	 * </p>
	 */
	public void setDocumentRoot ( String   documentRoot ) {
		getStateHelper().put(PropertyKeys.documentRoot, documentRoot);
		handleAttribute("documentRoot", documentRoot);
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