package ext.form.action;

import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;

/**
 *Note:This java code is auto generated by abner,do not edit it. Provides
 * Ext.direct support for loading form data. This example illustrates usage of
 * Ext.Direct to load a submit a form through Ext.Direct.
 * 
 * <pre>
 * &lt;code&gt;&lt;b&gt;var&lt;/b&gt; myFormPanel = &lt;b&gt;new&lt;/b&gt; Ext.form.FormPanel({
 *     &lt;i&gt;// configs &lt;b&gt;for&lt;/b&gt; FormPanel&lt;/i&gt;
 *     title: &lt;em&gt;'Basic Information'&lt;/em&gt;,
 *     border: false,
 *     padding: 10,
 *     buttons:[{
 *         text: &lt;em&gt;'Submit'&lt;/em&gt;,
 *         handler: &lt;b&gt;function&lt;/b&gt;(){
 *             basicInfo.getForm().submit({
 *                 params: {
 *                     uid: 5
 *                 }
 *             });
 *         }
 *     }],
 *     
 *     &lt;i&gt;// configs apply to child items&lt;/i&gt;
 *     defaults: {anchor: &lt;em&gt;'100%'&lt;/em&gt;},
 *     defaultType: &lt;em&gt;'textfield'&lt;/em&gt;,
 *     items: [
 *         &lt;i&gt;// form fields go here&lt;/i&gt;
 *     ],
 *     
 *     &lt;i&gt;// configs &lt;b&gt;for&lt;/b&gt; BasicForm&lt;/i&gt;
 *     api: {
 *         load: Profile.getBasicInfo,
 *         &lt;i&gt;// The server-side must mark the submit handler as a &lt;em&gt;'formHandler'&lt;/em&gt;&lt;/i&gt;
 *         submit: Profile.updateBasicInfo
 *     },    
 *     paramOrder: [&lt;em&gt;'uid'&lt;/em&gt;]
 * });
 * 
 * &lt;i&gt;// load the form&lt;/i&gt;
 * myFormPanel.getForm().load({
 *     params: {
 *         uid: 5
 *     }
 * });&lt;/code&gt;
 * </pre>
 */
@InstanceOf("Ext.form.Action.DirectLoad")
public class DirectLoad extends Load {
	public static final String COMPONENT_TYPE = "Ext.form.Action.DirectLoad";
	public static final String COMPONENT_FAMILY = "Ext.form.Action.DirectLoad";

	/**
	 * <p>
	 * Create a new {@link DirectLoad} instance with default property values.
	 * </p>
	 */
	public DirectLoad() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[1];
		}
		_values[0] = super.saveState(_context);

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);

	}
}