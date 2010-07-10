Ext.ns("Fence", "fence", "ExtFaces");
Ext.MessageBox.minWidth = 300;
Fence.ViewState = "javax.faces.ViewState";
Fence.FaceletsViewState = "~facelets.VIEW_STATE~";

if (typeof (uxjss) == 'undefined')
	var uxjss = new Object();

Fence = function() {
	var _show = function _show(title, msg, icon) {
		if (Ext.isEmpty(msg))
			return;

		Ext.MessageBox.show( {
			title : title,
			msg : msg,
			buttons : Ext.MessageBox.OK,
			icon : icon
		});
	};

	var disableOrEnableSrc = function disableOrEnableSrc(options, isEnable) {
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
	};

	var defaultonerror = function onerror(data) {
		Fence.error("serverError: " + data.errorName + " " + data.errorMessage
				+ " \n" + data.description);
	};

	var onhandlererror = function(data) {
		// nothing;
	};

	return {
		info : function(msg) {
			_show("Info", msg, Ext.Msg.INFO);
		},
		warn : function(msg) {
			_show("Warning", msg, Ext.Msg.WARNING);
		},

		question : function(msg) {
			_show("Question", msg, Ext.Msg.QUESTION);
		},

		error : function(msg) {
			_show("Error", msg, Ext.Msg.ERROR);
		},

		confirm : function(msg, callBack) {
			Ext.Msg.confirm("Confirm", msg, callBack);
		},

		show : function(title, msg, content) {

		},

		getViewState : function() {
			var viewState = Ext.getDom('javax.faces.ViewState');
			if (!viewState) {
				Fence.error("a form must exist in this page.");
				return;
			}
			return viewState ? viewState.value : '';
		},

		chain : function() {
			var args = new Array();
			var length = arguments.length;
			var startFun = false;
			for ( var i = 0; i < length; i++) {
				var f = arguments[i];
				if (startFun && typeof f != 'function') {
					Fence.error('the ' + f + " is not a function.");
					return false;
				}
				if (typeof f === 'function') {
					startFun = true;
					var fun = "f.call(this";
					for ( var n = 0; n < args.length; n++) {
						fun += ",args[" + n + "]";
					}
					fun += ")";

					var returnValue = eval(fun);
					if (returnValue === false) {
						return false;
					}
				} else {
					if (!startFun) {
						args.push(arguments[i]);
					}
				}
			}
			return true;
		},
		
		call : function(el, callback) {
			var params = {};
			params["javax.faces.partial.handler"] = "actionHandler";
			params["javax.faces.ViewState"] = Fence.getViewState();
			params["javax.faces.source"] = '@none';
			params["javax.faces.partial.ajax"] = "true";
			params["javax.faces.partial.event"] = "action";
			params["javax.faces.partial.action"] = el;
			var options = {
				params : params
			};
			Ext.applyIf(options, {
				url : Fence.ActionPath,
				waitMsg : "Loading...",
				success : Fence.Actions.ajaxSuccess,
				failure : Fence.Actions.ajaxFailure,
				callback:callback
			});
			
			Ext.Ajax.request(options);
		},

		request : function(options) {
			var element, sourceid, formid, form, type;
			var all, none;

			if (Ext.isEmpty(options))
				options = {};

			if (Ext.isEmpty(options.params))
				options.params = {};

			if (Ext.isEmpty(options.source))
				throw new Error("Fence.request: source not set");

			if (typeof options.source === 'string') {
				element = Ext.getCmp(source);
			} else if (typeof options.source === 'object') {
				element = options.source;
			} else {
				Fence.error("Fence.request: source must be object or string");
				return false;
			}

			type = element.type;
			if (!type)
				type = "button";

			form = options.formpanel;
			if (Ext.isEmpty(form) && ("submit" == type || "load" == type)) {
				Fence.error("Fence.request: must be called in FormPanel");
				return false;
			}

			if (Ext.isEmpty(form)) {
				form = document.forms[0];
				if (Ext.isEmpty(form)) {
					Fence.error("Fence.request: must be called in FormPanel or h:form");
					return false;
				}
				formid = form.id;
			} else {
				formid = form.getId();
			}

			sourceid = element.getId();
			if (element.baseAction && element.baseAction.isAction)
				sourceid = element.itemId;

			if (!element.name) {
				element.name = element.getId();
			}

			var args = {};

			if (options.params.execute) {
				none = options.params.execute.search(/@none/);
				if (none < 0) {
					all = options.params.execute.search(/@all/);
					if (all < 0) {
						options.params.execute = options.params.execute
								.replace("@this", sourceid);
						options.params.execute = options.params.execute
								.replace("@form", formid);
						var temp = options.params.execute.split(' ');
						if (temp.indexOf(element.name) < 0) {
							options.params.execute = element.name + " "
									+ options.params.execute;
						}
					} else {
						options.params.execute = "@all";
					}
					args["javax.faces.partial.execute"] = options.params.execute;
				}
			} else {
				options.params.execute = element.name + " " + sourceid;
				args["javax.faces.partial.execute"] = options.params.execute;
			}

			if (options.params.render) {
				none = options.params.render.search(/@none/);
				if (none < 0) {
					all = options.params.render.search(/@all/);
					if (all < 0) {
						options.params.render = options.params.render.replace(
								"@this", sourceid);
						options.params.render = options.params.render.replace(
								"@form", formid);
					} else {
						options.params.render = "@all";
					}
					args["javax.faces.partial.render"] = options.params.render;
				}
			}

			delete options.params.execute;
			delete options.params.render;

			args["javax.faces.ViewState"] = Fence.getViewState();
			args[formid] = formid;
			args["javax.faces.source"] = sourceid;
			args["javax.faces.partial.ajax"] = "true";
			args["javax.faces.partial.event"] = options.eventType;

			if (type == "load") {
				args["javax.faces.partial.handler"] = "formHandler";
			}

			Ext.applyIf(options.params, args);

			var onerror = false;

			if (options.onerror && typeof options.onerror === 'function') {
				onerror = options.onerror;
			} else if (options.onerror && typeof options.onerror !== 'function') {
				Fence.error("Fence.request: the onerror callback that was not a function");
				return false;
			}
			if (!onerror)
				onerror = defaultonerror;

			if (type == "load") {
				onerror = onhandlererror;
			}

			var onevent = false;

			if (options.onevent && typeof options.onevent === 'function') {
				onevent = options.onevent;
			} else if (options.onevent && typeof options.onevent !== 'function') {
				Fence.error("Fence.request: the onevent callback that was not a function");
				return false;
			}

			options.context = {};
			options.context.sourceid = sourceid;
			options.context.formid = formid;
			options.context.render = args["javax.faces.partial.render"];
			options.context.onevent = onevent;
			options.context.onerror = onerror;

			if ("submit" == type) {
				Ext.applyIf(options, {
					url : Fence.ActionPath,
					waitMsg : "Loading...",
					success : Fence.Actions.actionSuccess,
					failure : Fence.Actions.actionFailure
				});
				form.getForm().submit(options);
			} else if ("load" == type) {
				Ext.applyIf(options, {
					url : Fence.ActionPath,
					waitMsg : "Loading...",
					success : Fence.Actions.actionSuccess,
					failure : Fence.Actions.actionFailure
				});
				form.getForm().load(options);
			} else if ("button" == type) {
				Ext.applyIf(options, {
					url : Fence.ActionPath,
					success : Fence.Actions.ajaxSuccess,
					failure : Fence.Actions.ajaxFailure,
					callback : Fence.Actions.ajaxCallBack
				});
				Ext.Ajax.request(options);
			}
		},

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
				jsf.ajax.response(action.response, action.options.context);
			},
			actionFailure : function(form, action) {
				 switch (action.failureType) {
		            case Ext.form.Action.CLIENT_INVALID:
		            	Fence.error('Form fields may not be submitted with invalid values');
		                break;
		            case Ext.form.Action.CONNECT_FAILURE:
		            	Fence.error('Ajax communication failed');
		                break;
		            case Ext.form.Action.SERVER_INVALID:
		            	Fence.error(action.result.msg);
		            	break;
		            case Ext.form.Action.LOAD_FAILURE:
		            	Fence.error(action.result.msg);
		            	break;
				 }
			},
			ajaxCallBack : function(options, success, response) {
				jsf.ajax.response(response, options.context);
			},
			ajaxSuccess : function(response, options) {

			},
			ajaxFailure : function(response, options) {

			},
			updaterCallBack : function(el, success, res, options) {

			},
			storeException : function(proxy, type, action, options, response,
					arg) {
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

			beforeRequest : function(conn, options) {
				disableOrEnableSrc(options, false);
			},
			requestComplete : function(conn, res, options) {
				disableOrEnableSrc(options, true);
			},
			requestException : function(conn, res, options) {
				disableOrEnableSrc(options, true);
			}
		},

		includeJS : function(jsFile) {
			if (uxjss[jsFile] != null)
				return;
			var scriptElt = document.createElement('script');
			scriptElt.type = 'text/javascript';
			scriptElt.src = jsFile;
			Ext.DomQuery.select("head")[0].appendChild(scriptElt);
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
		}
	}
}();

Ext.Ajax.on('beforerequest', Fence.Actions.beforeRequest, this);
Ext.Ajax.on('requestcomplete', Fence.Actions.requestComplete, this);
Ext.Ajax.on('requestexception', Fence.Actions.requestException, this);

Ext.override(Ext.form.BasicForm, {
	errorReader : Fence.Actions.formErrorReader
});