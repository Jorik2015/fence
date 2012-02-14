Ext.ns("Fence", "fence", "ExtFaces");
Ext.MessageBox.minWidth = 300;
ExtFaces.ViewState = "javax.faces.ViewState";
ExtFaces.ViewRoot = "EXT_VIEWROOT";
ExtFaces.FaceletsViewState = "~facelets.VIEW_STATE~";

if (typeof (uxjss) == 'undefined')
	var uxjss = new Object();

fence.Abner = function(config) {
	this.Query = Ext.DomQuery;
};

fence.Abner.prototype = {
	// error,info,question,waring
	info : function(msg) {
		this._show("提示", msg, Ext.Msg.INFO);
	},
	warn : function(msg) {
		this._show("警告", msg, Ext.Msg.WARNING);
	},

	question : function(msg) {
		this._show("询问", msg, Ext.Msg.QUESTION);
	},

	error : function(msg) {
		this._show("错误", msg, Ext.Msg.ERROR);
	},

	confirm : function(msg, callBack) {
		Ext.Msg.confirm("确认", msg, callBack);
	},

	show : function(title, msg, content) {

	},
	// private
	_show : function(title, msg, icon) {
		if (Ext.isEmpty(msg))
			return;

		Ext.MessageBox.show( {
			title : title,
			msg : msg,
			buttons : Ext.MessageBox.OK,
			icon : icon
		});
	},
	// ============================================================
	includeJS : function(jsFile) {
		if (uxjss[jsFile] != null)
			return;
		var scriptElt = document.createElement('script');
		scriptElt.type = 'text/javascript';
		scriptElt.src = jsFile;
		this.Query.select("head")[0].appendChild(scriptElt);
		uxjss[jsFile] = jsFile;
	},

	includeCss : function(cssFile) {
		if (uxjss[cssFile] != null)
			return;
		var cssEl = document.createElement('link');
		cssEl.setAttribute('type', 'text/css');
		cssEl.setAttribute('rel', 'stylesheet');
		cssEl.setAttribute('href', cssFile);
		this.Query.select("head")[0].appendChild(cssEl);
		uxjss[cssFile] = cssFile;
	},

	createIframe : function(id) {
		var iframe = Ext.getDom(id);
		if (iframe)
			return iframe;

		iframe = document.createElement('iframe');
		iframe.frameborder = '0';
		iframe.id = id;
		iframe.src = "";
		Ext.getBody().dom.appendChild(iframe);
		return iframe;
	},
	// private
	isResponseXml : function(response) {
		if (!response)
			return false;
		var xml = response.responseXML;
		if (!xml)
			return false;
		return true;
	},
	isResponseText : function(response) {
		if (!response)
			return false;
		var text = response.responseText;
		if (!text)
			return false;
		return true;
	},
	// process the response
	renderException : function(result) {
		if (this.isResponseXml(result)) {
			var xml = result.responseXML;
			var error = xml.getElementsByTagName('exception')[0];
			var severity = "";
			if (!error || Ext.isEmpty(error.getAttribute("severity"))) {
				severity = "error";
			}
			error = error ? error.firstChild : null;
			error = error ? (error.textContext || error.data) : "";
			if (severity == "error")
				Fence.error(error);
			else if (severity == "warn") {
				Fence.warn(error);
			} else {
				Fence.info(error);
			}
		} else if (this.isResponseText(result)) {
			Fence.error(result.responseText);
		}
		this.evalScripts(result);
	},

	evalScripts : function(result) {
		if (Ext.isEmpty(result))
			return;
		var xml = result.responseXML;
		if (!xml)
			return;
		var script = xml.getElementsByTagName('scripts')[0];
		if (!script)
			return;
		script = script.firstChild;
		script = script.textContext || script.data;
		eval(script);
	},

	renderView : function(result) {
		if (!this.isResponseXml(result))
			return;

		var xml = result.responseXML;
		var redirect = xml.getElementsByTagName('redirect');
		if (redirect && redirect.length == 1) {
			Ext.getDoc().dom.location.href = redirect[0].firstChild.textContext
					|| redirect[0].firstChild.data;
			return;
		}

		var id, content, markup, html;
		var components = xml.getElementsByTagName('components')[0];
		if (!components)
			return;

		var renders = components.getElementsByTagName('render');
		if (!renders)
			return;

		for ( var i = 0; i < renders.length; i++) {
			id = renders[i].getAttribute('id');
			html = '';
			markup = renders[i].firstChild;
			for ( var j = 0; j < markup.childNodes.length; j++) {
				content = markup.childNodes[j];
				html += content.textContext || content.data;
				html = html.replace(ExtFaces.FaceletsViewState, "");
			}
			this.replace(id, html.trim());
		}
		// change the viewState
		var stateNode = xml.getElementsByTagName('state');
		var state = stateNode.length > 0 ? stateNode[0].firstChild : false;
		if (state) {
			var viewStates = this.Query.select("input[id=" + ExtFaces.ViewState	+ "]");
			for ( var vs in viewStates) {
				viewStates[vs].value = state.textContent || state.data;
			}
		}
	},

	replace : function replace(dest, src) {
		if (-1 != dest.indexOf(ExtFaces.ViewRoot)) {
			var htmlStartEx = new RegExp("< *html.*>", "gi");
			var htmlEndEx = new RegExp("< */ *html.*>", "gi");
			var headStartEx = new RegExp("< *head.*>", "gi");
			var headEndEx = new RegExp("< */ *head.*>", "gi");
			var bodyStartEx = new RegExp("< *body.*>", "gi");
			var bodyEndEx = new RegExp("< */ *body.*>", "gi");
			var htmlStart, htmlEnd, headStart, headEnd, bodyStart, bodyEnd;
			var srcHead = null, srcBody = null;
			var docBody = document.getElementsByTagName("body")[0];
			if (null != (htmlStart = htmlStartEx.exec(src))) {
				if (null != (htmlEnd = htmlEndEx.exec(src))) {
					src = src.substring(htmlStartEx.lastIndex, htmlEnd.index);
				} else {
					src = src.substring(htmlStartEx.lastIndex);
				}
			}

			if (null != (headStart = headStartEx.exec(src))) {
				if (null != (headEnd = headEndEx.exec(src))) {
					srcHead = src.substring(headStartEx.lastIndex,
							headEnd.index);
				} else {
					srcHead = src.substring(headStartEx.lastIndex);
				}
				var docHead = document.getElementsByTagName("head")[0];
				if (docHead) {
					this.elementReplace(docHead, "head", srcHead);
				}
			}
			// if src contains <body>
			if (null != (bodyStart = bodyStartEx.exec(src))) {
				if (null != (bodyEnd = bodyEndEx.exec(src))) {
					srcBody = src.substring(bodyStartEx.lastIndex,
							bodyEnd.index);
				} else {
					srcBody = src.substring(bodyStartEx.lastIndex);
				}
				result = this.elementReplace(docBody, "body", srcBody);
			}
			if (!srcBody) {
				result = this.elementReplace(docBody, "body", src);
			}

		} else {
			var d = Ext.getDom(dest);
			if (!d) {
				Fence.warn(dest + " 节点不存在，如果一直出现此错误，尝试重新刷新页面。");
				return;
			}
			var temp = document.createElement('div');
			temp.id = d.id;
			temp.innerHTML = src;
			d.parentNode.replaceChild(temp.firstChild, d);
		}
	},

	// private
	elementReplace : function elementReplace(d, tempTagName, src) {
		var parent = d.parentNode;
		var temp = document.createElement(tempTagName);
		var result = null;
		temp.id = d.id;

		// If we are creating a head element...
		if (-1 != d.tagName.toLowerCase().indexOf("head")
				&& d.tagName.length == 4) {
			// head replacement only appears to work on firefox.
			if (!Ext.isGecko3 && !Ext.isGecko2 && !Ext.isGecko) {
				return;
			}

			// Strip link elements from src.
			if (-1 != src.indexOf("link")) {
				var linkStartEx = new RegExp("< *link.*>", "gi");
				var linkStart;
				while (null != (linkStart = linkStartEx.exec(src))) {
					src = src.substring(0, linkStart.index)
							+ src.substring(linkStartEx.lastIndex);
					linkStartEx.lastIndex = 0;
				}
			}

			// Strip style elements from src
			if (-1 != src.indexOf("style")) {
				var styleStartEx = new RegExp("< *style.*>", "gi"), styleEndEx = new RegExp(
						"< */ *style.*>", "gi");
				var styleStart, styleEnd;
				while (null != (styleStart = styleStartEx.exec(src))) {
					styleEnd = styleEndEx.exec(src);
					src = src.substring(0, styleStart.index)
							+ src.substring(styleStartEx.lastIndex);
					styleStartEx.lastIndex = 0;
				}
			}

			temp.innerHTML = src;

			// clone all the link elements...
			var i, links, styles;
			links = d.getElementsByTagName("link");
			if (links) {
				for (i = 0; i < links.length; i++) {
					temp.appendChild(links[i].cloneNode(true));
				}
			}
			// then clone all the style elements.
			styles = d.getElementsByTagName("style");
			if (styles) {
				for (i = 0; i < styles.length; i++) {
					temp.appendChild(styles[i].cloneNode(true));
				}
			}
		} else {
			temp.innerHTML = src;
		}
		result = temp;
		parent.replaceChild(temp, d);
		return result;
	},
	// used in fence core
	getViewState : function() {
		Ext_ViewState = Ext.getDom('javax.faces.ViewState');
		return Ext_ViewState ? Ext_ViewState.value : '';
	},
	/* Call server action method */
	call : function(action, callback, src, params, url) {
		var pars = {
			EXT_HANDLER : 'actionHandler',
			EXT_AJAX : true,
			action : action
		};
		if (params)
			Ext.apply(pars, params);

		var ops = {
			params : pars,
			successFn : callback,
			src : src
		};

		ops = url ? Ext.apply(ops, {
			url : url
		}) : ops;
		this.Actions.request(ops);
	},
	request : function(obj) {
		this.Actions.request(obj);
	},
	/* Call server action method */
	Actions : {
		formErrorReader : new Ext.data.XmlReader( {
			record : 'field',
			successProperty : '@success'
		}, [ 'id', 'msg' ]),
		formSuccess : function(form, action) {
		},
		formFailure : function(form, action) {
		},
		actionSuccess : function(form, action) {
			var successFn = action.options.successFn;
			if (typeof successFn == 'function') {
				Ext.callback(successFn, null, [ form, action ]);
			}
			var res = action.response.responseText;
			if (Ext.isEmpty(res))
				return;

			Fence.renderView(action.response);
			Fence.evalScripts(action.response);
		},
		actionFailure : function(form, action) {
			if (action.failureType === Ext.form.Action.CLIENT_INVALID) {
				Fence.error("Form fields may not be submitted with invalid values");
			}
			if (action.failureType === Ext.form.Action.CONNECT_FAILURE) {
				Fence.renderException(action.response);
			}

			if (action.failureType === Ext.form.Action.LOAD_FAILURE) {
				Fence.renderException(action.response);
			}

			if (action.failureType === Ext.form.Action.SERVER_INVALID) {
				Fence.renderException(action.response);
				if (action.response && action.response.responseXML) {
					var xml = action.response.responseXML;
					var field = xml.getElementsByTagName("field");
					var bufError = "";
					for ( var i = 0; i < field.length; i++) {
						bufError += "<br/>" + field[i].lastChild.textContent;
					}
					Fence.error(bufError);
				}
			}
		},
		ajaxCallBack : function(options, success, response) {
			if (success) {
				if (typeof options.successFn == 'function') {
					if (options.params && options.params.EXT_HANDLER == 'actionHandler') { 
						if (Ext.isEmpty(response.responseText)) {
							Ext.callback(options.successFn, null, [ null,
									options ]);
						} else {
							try {
								var res = Ext.decode(response.responseText);
								Ext.callback(options.successFn, null, [ res,
										options ]);
							} catch (e) {
								Fence.error(e.message);
							}
						}
					} else {
						Ext.callback(options.successFn, null, [ response,
								options ]);
					}
				}
			} else {
				if (!options.failure) {
					Fence.renderException(response);
				}
			}
		},
		ajaxSuccess : function(response, options) {
			Fence.renderView(response);
			Fence.evalScripts(response);
		},
		ajaxFailure : function(response, options) {
			Fence.renderException(response);
		},
		updaterCallBack : function(el, success, res, options) {

		},
		storeException : function(proxy, type, action, options, response, arg) {
			if ("response" == type && !Ext.isEmpty(arg)) {
				var error = "name:" + arg.name;
				error += "<br/>message:" + arg.message;
				error += "<br/>line number:" + arg.lineNumber;
				error += "<br/>file name:" + arg.fileName;
				Fence.error(error);
			} else {
				Fence.renderException(response);
			}
		},
		request : function(obj) {
			var rqtObj = {
				url : Fence.ActionPath,
				success : Fence.Actions.ajaxSuccess,
				failure : Fence.Actions.ajaxFailure,
				callback : Fence.Actions.ajaxCallBack
			};

			Ext.apply(rqtObj, obj);
			Ext.Ajax.request(rqtObj);
		},
		beforeRequest : function(conn, options) {
			Fence.Actions.disableOrEnableSrc(options, false);
		},
		requestComplete : function(conn, res, options) {
			Fence.Actions.disableOrEnableSrc(options, true);
		},
		requestException : function(conn, res, options) {
			Fence.Actions.disableOrEnableSrc(options, true);
			Fence.renderException(res);
		},
		// private
		disableOrEnableSrc : function(options, isEnable) {
			var src = options.src;
			try {
				if (!src && options.scope && options.scope.options)
					src = options.scope.options.src;
				if (!src)
					return;
				if (isEnable) {
					src.setText(src.origText);
					src.enable();
				} else {
					src.origText = src.getText();
					src.setText('Loading');
					src.disable();
				}
			} catch (e) {
			}
		}
	}
};
var Fence = new fence.Abner();
Ext.Ajax.on('beforerequest', Fence.Actions.beforeRequest, this);
Ext.Ajax.on('requestcomplete', Fence.Actions.requestComplete, this);
Ext.Ajax.on('requestexception', Fence.Actions.requestException, this);

// ===========================================================================
Ext.override(Ext.form.BasicForm, {
	errorReader : Fence.Actions.formErrorReader
});