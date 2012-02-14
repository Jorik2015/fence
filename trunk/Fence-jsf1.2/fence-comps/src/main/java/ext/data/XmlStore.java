package ext.data;

import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.XType;

/*
 * Small helper class to make creating Ext.data.Stores from XML data easier. A XmlStore will be automatically configured with a Ext.data.XmlReader.

 A store configuration would be something like:

 var store = new Ext.data.XmlStore({
 // store configs

 autoDestroy: true,
 storeId: 'myStore',
 url: 'sheldon.xml', // automatically configures a HttpProxy

 // reader configs

 record: 'Item', // records will have an "Item" tag

 idPath: 'ASIN',
 totalRecords: '@TotalResults'
 fields: [
 // set up the fields mapping into the xml doc

 // The first needs mapping, the others are very basic

 {name: 'Author', mapping: 'ItemAttributes > Author'},
 'Title', 'Manufacturer', 'ProductGroup'
 ]
 });
 This store is configured to consume a returned object of the form:

 <?xml version="1.0" encoding="UTF-8"?>
 <ItemSearchResponse xmlns="http://webservices.amazon.com/AWSECommerceService/2009-05-15">

 <Items>
 <Request>
 <IsValid>True</IsValid>
 <ItemSearchRequest>
 <Author>Sidney Sheldon</Author>
 <SearchIndex>Books</SearchIndex>
 </ItemSearchRequest>
 </Request>
 <TotalResults>203</TotalResults>
 <TotalPages>21</TotalPages>
 <Item>
 <ASIN>0446355453</ASIN>
 <DetailPageURL>
 http://www.amazon.com/

 </DetailPageURL>
 <ItemAttributes>
 <Author>Sidney Sheldon</Author>
 <Manufacturer>Warner Books</Manufacturer>
 <ProductGroup>Book</ProductGroup>
 <Title>Master of the Game</Title>
 </ItemAttributes>
 </Item>
 </Items>
 </ItemSearchResponse>
 An object literal of this form could also be used as the data config option.
 Note: Although not listed here, this class accepts all of the configuration options of XmlReader.
 * */
@XType("xmlstore")
@ParseConfigMode(ui = false, name = "store", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class XmlStore extends Store {
	private static final long serialVersionUID = 1L;

	/**
	 * <p>
	 * Create a new {@link XmlWriter} instance with default property values.
	 * </p>
	 */
	public XmlStore() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}
}
