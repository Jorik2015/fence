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
 * DataWriter extension for writing an
  array or single 
  Ext.data.Record object(s) in
  preparation for executing a remote CRUD action via XML. XmlWriter
  uses an instance of 
  Ext.XTemplate for maximum flexibility
  in defining your own custom XML schema if the default schema is
  not appropriate for your needs. See the 
  tpl
  configuration-property.
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
			documentRoot
			,xmlVersion
			,forceDocumentRoot
			,xmlEncoding
			,root
			,tpl
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
	 *[xrequest] (Optional) The name of the
          XML document root-node. 
          Note: this parameter is required only when sending
          extra 
          baseParams to the server
          during a write-request -- if no baseParams are set, the 
          Ext.data.XmlReader.record
          meta-property can suffice as the XML document root-node
          for write-actions involving just a 
          single record. For requests involving 
          multiple records and 
          NO baseParams, the 
          Ext.data.XmlWriter.root
          property can act as the XML document root.
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
	 *[false] Set to 
          true to force XML documents having a root-node
          as defined by 
          documentRoot, even with
          no baseParams defined.
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
	 *[records] The name of the containing
          element which will contain the nodes of an write-action
          involving 
          multiple records. Each xml-record written to the
          server will be wrapped in an element named after 
          Ext.data.XmlReader.record
          property. eg: 

<?xml version=
"1.0" encoding=
"UTF-8"?>
<user><first>Barney</first></user>
          However, when 
          multiple records are written in a batch-operation,
          these records must be wrapped in a containing Element.
          eg: 

<?xml version=
"1.0" encoding=
"UTF-8"?>
    <records>
        <first>Barney</first></user>
       
<records><first>Barney</first></user>
    </records>
          Defaults to 
          records. Do not confuse the nature of this
          property with that of 
          documentRoot
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
	 *The XML template used to render 
          write-actions to your server. 
          One can easily provide his/her own custom 
          template-definition if the
          default does not suffice.
          Defaults to:

<?xml version=
"{version}" encoding=
"{encoding}"?>
    <tpl 
if=
"documentRoot"><{documentRoot}>
    <tpl 
for=
"baseParams">
        <tpl 
for=
".">
            <{name}>{value}</{name}>
        </tpl>
    </tpl>
    <tpl 
if=
"records.length > 1"><{root}>
',
    <tpl 
for="records">
        <{parent.record}>
        <tpl 
for=
".">
            <{name}>{value}</{name}>
        </tpl>
        </{parent.record}>
    </tpl>
    <tpl 
if=
"records.length > 1"></{root}></tpl>
    <tpl 
if=
"documentRoot"></{documentRoot}></tpl>
          
          Templates will be called with the following API
          
            {String} version [1.0] The xml version.
            {String} encoding [ISO-8859-15] The xml
            encoding.
            {String/false} documentRoot The XML document
            root-node name or 
            false if not required. See 
            documentRoot and 
            forceDocumentRoot.
            {String} record The meta-data parameter defined on
            your 
            Ext.data.XmlReader.record
            configuration represents the name of the xml-tag
            containing each record.
            {String} root The meta-data parameter defined by 
            Ext.data.XmlWriter.root
            configuration-parameter. Represents the name of the xml
            root-tag when sending 
            multiple records to the server.
            {Array} records The records being sent to the
            server, ie: the subject of the write-action being
            performed. The records parameter will be always be an
            array, even when only a single record is being acted
            upon. Each item within the records array will contain
            an array of field objects having the following
            properties: 
            
              {String} name The field-name of the record as
              defined by your 
              Ext.data.Record
              definition. The "mapping" property will be used,
              otherwise it will match the "name" property. Use this
              parameter to define the XML tag-name of the
              property.
              {Mixed} value The record value of the field
              enclosed within XML tags specified by name property
              above.
            
            {Array} baseParams. The baseParams as defined upon 
            Ext.data.Store.baseParams.
            Note that the baseParams have been converted into an
            array of [{name : "foo", value: "bar"}, ...] pairs in
            the same manner as the 
            records parameter above. See 
            documentRoot and 
            forceDocumentRoot.
          
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