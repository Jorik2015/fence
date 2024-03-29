package ext.state;

import java.util.Date;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

/**
 *Note:This java code is auto generated by abner,do not edit it. The default
 * Provider implementation which saves state via cookies.<br>
 * Usage:
 * 
 * <pre>
 * &lt;code&gt;&lt;b&gt;var&lt;/b&gt; cp = &lt;b&gt;new&lt;/b&gt; Ext.state.CookieProvider({
 *        path: &lt;em&gt;&quot;/cgi-bin/&quot;&lt;/em&gt;,
 *        expires: &lt;b&gt;new&lt;/b&gt; Date(&lt;b&gt;new&lt;/b&gt; Date().getTime()+(1000*60*60*24*30)), &lt;i&gt;//30 days
 * &lt;/i&gt;
 *        domain: &lt;em&gt;&quot;extjs.com&quot;&lt;/em&gt;
 *    });
 *    Ext.state.Manager.setProvider(cp);&lt;/code&gt;
 * </pre>
 */
public class CookieProvider extends Provider {
	public static final String COMPONENT_TYPE = "Ext.state.CookieProvider";

	/**
	 * <p>
	 * Create a new {@link CookieProvider} instance with default property
	 * values.
	 * </p>
	 */
	public CookieProvider() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private String domain;

	/**
	 * The domain to save the cookie for. Note that youcannot specify a
	 * different domain than your page is on, but you can specify a sub-domain,
	 * or simply the domain itself like 'extjs.com' to include all sub-domains
	 * if you need to access cookies across different sub-domains (defaults to
	 * null which uses the same domain the page is running on including the
	 * 'www' like 'www.extjs.com')
	 */
	public String getDomain() {
		if (null != this.domain) {
			return this.domain;
		}
		ValueExpression _ve = getValueExpression("domain");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>domain</code> property.
	 * </p>
	 */
	public void setDomain(String domain) {
		this.domain = domain;
		handleConfig("domain", domain);
	}

	private Date expires;

	/**
	 * The cookie expiration date (defaults to 7 daysfrom now)
	 */
	public Date getExpires() {
		if (null != this.expires) {
			return this.expires;
		}
		ValueExpression _ve = getValueExpression("expires");
		if (_ve != null) {
			return (Date) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>expires</code> property.
	 * </p>
	 */
	public void setExpires(Date expires) {
		this.expires = expires;
		handleConfig("expires", expires);
	}

	private String path;

	/**
	 * The path for which the cookie is active(defaults to root '/' which makes
	 * it active for all pages in the site)
	 */
	public String getPath() {
		if (null != this.path) {
			return this.path;
		}
		ValueExpression _ve = getValueExpression("path");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>path</code> property.
	 * </p>
	 */
	public void setPath(String path) {
		this.path = path;
		handleConfig("path", path);
	}

	private Boolean secure;

	/**
	 * True if the site is using SSL (defaults tofalse)
	 */
	public Boolean getSecure() {
		if (null != this.secure) {
			return this.secure;
		}
		ValueExpression _ve = getValueExpression("secure");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>secure</code> property.
	 * </p>
	 */
	public void setSecure(Boolean secure) {
		this.secure = secure;
		handleConfig("secure", secure);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[5];
		}
		_values[0] = super.saveState(_context);
		_values[1] = domain;
		_values[2] = expires;
		_values[3] = path;
		_values[4] = secure;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.domain = (String) _values[1];
		this.handleConfig("domain", this.domain);
		this.expires = (Date) _values[2];
		this.handleConfig("expires", this.expires);
		this.path = (String) _values[3];
		this.handleConfig("path", this.path);
		this.secure = (Boolean) _values[4];
		this.handleConfig("secure", this.secure);

	}
}