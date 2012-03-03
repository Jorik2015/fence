Ext.form.MultiTextField = Ext.extend(Ext.form.ComboBox,{
	
	 allowAddNewData				: true
    ,backspaceDeletesLastItem		: true
    ,displayFieldTpl				: null
    ,fixFocusOnTabSelect			: true
    ,preventDuplicates				: true
    ,renderFieldBtns				: true
    ,stackItems						: false
    ,supressClearValueRemoveEvents	: false
    ,mode							: 'local'
    ,validationEvent				: 'blur'
    ,valueField						: 'value'
    ,displayField					: 'text'
    ,valueDelimiter					: ','
    ,clearBtnCls					: ''
    ,extraItemCls					: ''
    ,extraItemStyle					: ''
    ,expandBtnCls					: ''
    ,styleField						: ''
    ,classField						: ''
    ,itemDelimiterKey				: Ext.EventObject.SPACE
	
	,constructor : function(cfg)
	{
		Ext.form.MultiTextField.superclass.constructor.call(this, cfg);
		
		this.addEvents(
	         'beforeadditem'
	        ,'additem'
	        ,'beforeremoveitem'
	        ,'removeitem'
	        ,'clear'
	    );
	}
	
    ,initComponent : function()
	{
       Ext.apply(this,{
             hideTrigger		: true
            ,grow				: false
            ,resizable			: false
            ,multiSelectMode	: false
            ,preRenderValue		: null
            ,store : new Ext.data.SimpleStore({
            	 id		: 0
            	,fields	: ['value','text']
            })
        });
        
        Ext.form.MultiTextField.superclass.initComponent.call(this);
    }
	
    ,onRender : function(ct, position)
	{
		var h = this.name;
		
    	this.name = null;
		
        Ext.form.MultiTextField.superclass.onRender.call(this, ct, position);
        
        this.name = h;
        
        var extraClass = (this.stackItems === true) ? 'x-multitextfield-stacked' : '';
		
        if(this.renderFieldBtns)
		{
            extraClass += ' x-multitextfield-display-btns';
        }
		
        this.el.removeClass('x-form-text').addClass('x-multitextfield-input-field');
		
        this.wrapEl = this.el.wrap({
			tag : 'ul'
        });
		
        this.outerWrapEl = this.wrapEl.wrap({
             tag: 'div'
            ,cls: 'x-form-text x-multitextfield ' + extraClass
        });
		
        this.inputEl = this.el.wrap({
             tag: 'li'
            ,cls: 'x-multitextfield-input'
        });
        
        if(this.renderFieldBtns)
		{
            this.setupFieldButtons().manageClearBtn();
        }
        
		if(!Ext.isEmpty(this.height))
		{
			this.getEl().dom.parentNode.parentNode.style.overflowY	= 'scroll';
			this.getEl().dom.parentNode.parentNode.style.height		= this.height + 'px';
		}
		
        this.setupFormInterception();
    }
    
    ,setupFieldButtons : function()
	{
		this.buttonWrap = this.outerWrapEl.createChild({
            cls : 'x-multitextfield-btns'
        });
	    
        this.buttonClear = this.buttonWrap.createChild({
             tag : 'div'
            ,cls : 'x-multitextfield-btn-clear ' + this.clearBtnCls
        });
		
        this.initButtonEvents();
        
        return this;
    }
	
    ,initButtonEvents : function()
	{
		this.removeButtonEvents();
		
		this.mon(this.buttonClear, 'click', function(e)
		{
			e.stopEvent();
			
            if(this.disabled)
			{
                return;
            }
			
			this.removeAllItems(true);
			this.resetStore();
            this.clearValue();
            this.el.focus();
			
		}, this, {preventDefault:true});
		
		this.buttonClear.addClassOnOver('x-multitextfield-btn-over');
    }
    
    ,removeButtonEvents : function()
	{
        this.buttonClear.removeAllListeners();
        return this;
    }
	
    ,clearCurrentFocus : function()
	{
        if(this.currentFocus)
		{
            this.currentFocus.onLnkBlur();
            this.currentFocus = null;
        }
		  
        return this;        
    }
	
    ,initEvents : function()
	{
        var el = this.el;
		
        el.on({
             click	: this.onClick
            ,focus	: this.clearCurrentFocus
            ,blur	: this.onBlur
            ,keydown: this.onKeyDownHandler
            ,keyup	: this.onKeyUpBuffered
            ,scope	: this
        });
		
        this.wrapEl.on('click', this.onWrapClick, this);
        this.outerWrapEl.on('click', this.onWrapClick, this);
        
        this.inputEl.focus = function()
		{
            el.focus();
        };
		
        Ext.form.MultiTextField.superclass.initEvents.call(this);
        
		if(this.dqTask)
		{
            this.dqTask.cancel();
            this.dqTask = null;
        }
		
        Ext.apply(this.keyNav,{
            tab : function(e)
			{
                if(this.fixFocusOnTabSelect && this.isExpanded())
				{
                    e.stopEvent();
                    el.blur();
                    this.onViewClick(false);
                    this.focus(false, 10);
                    return true;
                }
				
                this.onViewClick(false);
				
                if(el.dom.value !== '')
				{
                    this.setRawValue('');
                }
				
                return true;
            }
            ,up		: function(){}
            ,down	: function(){}
            ,enter	: function(){}
            ,esc	: function(){}
        });
    }
	
    ,onClick : function()
	{
        this.clearCurrentFocus();
        this.autoSize();
   	}
	
    ,onFocus : function()
	{
        this.outerWrapEl.addClass(this.focusClass);
		
        Ext.form.MultiTextField.superclass.onFocus.call(this);
    }
	
    ,onBlur : function()
	{
        this.outerWrapEl.removeClass(this.focusClass);
        this.clearCurrentFocus();
		
        if(this.el.dom.value !== '')
		{
            this.applyEmptyText();
            this.autoSize();
        }
		
        Ext.form.MultiTextField.superclass.onBlur.call(this);
    }
	
    ,onCollapse : function()
	{
    	this.view.clearSelections();
        this.multiSelectMode = false;
    }
	
    ,onWrapClick : function(e)
	{
        e.stopEvent();
        this.el.focus();
        this.clearCurrentFocus();
    }
	
    ,markInvalid : function(msg)
	{
        var elp, t;
		
        if(!this.rendered || this.preventMark)
		{
            return;
        }
		
        this.outerWrapEl.addClass(this.invalidClass);
		
        msg = msg || this.invalidText;
		
        switch(this.msgTarget)
		{
            case 'qtip':
                Ext.apply(this.el.dom,{
                     qtip    : msg
                    ,qclass  : 'x-form-invalid-tip'
                });
				
                Ext.apply(this.wrapEl.dom,{
                     qtip    : msg
                    ,qclass  : 'x-form-invalid-tip'
                });
				
                if(Ext.QuickTips)
                {
                    Ext.QuickTips.enable();
                }
                break;
            
            case 'title':
                this.el.dom.title			= msg;
                this.wrapEl.dom.title		= msg;
                this.outerWrapEl.dom.title	= msg;
                break;
            
            case 'under':
                if(!this.errorEl)
				{
                    elp = this.getErrorCt();
					
                    if(!elp)
					{
                        this.el.dom.title = msg;
                        break;
                    }
					
                    this.errorEl = elp.createChild({cls:'x-form-invalid-msg'});
                    this.errorEl.setWidth(elp.getWidth(true) - 20);
                }
				
                this.errorEl.update(msg);
                Ext.form.Field.msgFx[this.msgFx].show(this.errorEl, this);
                break;
            
            case 'side':
                if(!this.errorIcon)
				{
                    elp = this.getErrorCt();
					
                    if(!elp)
					{
                        this.el.dom.title = msg;
                        break;
                    }
					
                    this.errorIcon = elp.createChild({cls:'x-form-invalid-icon'});
                }
				
                this.alignErrorIcon();
				
                Ext.apply(this.errorIcon.dom,{
                    qtip    : msg,
                    qclass  : 'x-form-invalid-tip'
                });
				
                this.errorIcon.show();
                this.on('resize', this.alignErrorIcon, this);
                break;
            
            default:
                t = Ext.getDom(this.msgTarget);
                t.innerHTML = msg;
                t.style.display = this.msgDisplay;
                break;
        }
		
        this.fireEvent('invalid', this, msg);
    }
	
    ,clearInvalid : function()
	{
        if(!this.rendered || this.preventMark)
		{
            return;
        }
		
        this.outerWrapEl.removeClass(this.invalidClass);
		
        switch(this.msgTarget)
		{
            case 'qtip':
                this.el.dom.qtip			= '';
                this.wrapEl.dom.qtip		= '';
                break;
            
            case 'title':
                this.el.dom.title			= '';
                this.wrapEl.dom.title		= '';
                this.outerWrapEl.dom.title	= '';
                break;
            
            case 'under':
                if(this.errorEl)
				{
                    Ext.form.Field.msgFx[this.msgFx].hide(this.errorEl, this);
                }
                break;
            
            case 'side':
                if(this.errorIcon)
				{
                    this.errorIcon.dom.qtip = '';
                    this.errorIcon.hide();
                    this.un('resize', this.alignErrorIcon, this);
                }
                break;
            
            default:
                var t = Ext.getDom(this.msgTarget);
                t.innerHTML		= '';
                t.style.display	= 'none';
                break;
        }
		
        this.fireEvent('valid', this);
    }
	
    ,alignErrorIcon : function()
	{
        if(this.wrap)
		{
            this.errorIcon.alignTo(this.wrap, 'tl-tr', [Ext.isIE ? 5 : 2, 3]);
        }
    }
	
    ,expand : function()
	{
		return false;
    }
	
    ,restrictHeight : function()
	{
        var	 inner	= this.innerList.dom
            ,st		= inner.scrollTop
            ,list	= this.list;
        
        inner.style.height = '';
        
        var	 pad	= list.getFrameWidth('tb')+(this.resizable?this.handleHeight:0)+this.assetHeight
            ,h		= Math.max(inner.clientHeight, inner.offsetHeight, inner.scrollHeight)
            ,ha		= this.getPosition()[1]-Ext.getBody().getScroll().top
            ,hb		= Ext.lib.Dom.getViewHeight()-ha-this.getSize().height
            ,space	= Math.max(ha, hb, this.minHeight || 0)-list.shadowOffset-pad-5;
        
        h = Math.min(h, space, this.maxHeight);
        this.innerList.setHeight(h);
        
        list.beginUpdate();
        list.setHeight(h+pad);
        list.alignTo(this.outerWrapEl, this.listAlign);
        list.endUpdate();
        
        if(this.multiSelectMode)
        {
            inner.scrollTop = st;
        }
    }
	
    ,validateValue : function(val)
	{
        if(this.store.getCount() === 0)
		{
             if(this.allowBlank)
			 {
                 this.clearInvalid();
                 return true;
             }
			 else
			 {
                 this.markInvalid(this.blankText);
                 return false;
             }
        }
        
        this.clearInvalid();
        return true;
    }
	
    ,setupFormInterception : function()
	{
        var form;
        
        this.findParentBy(function(p)
		{ 
            if(p.getForm)
			{
                form = p.getForm();
            }
        });
		
        if(form)
		{
        	var formGet = form.getValues;
        	
            form.getValues = function(asString)
			{
                this.el.dom.disabled = true;
                var oldVal = this.el.dom.value;
                
                var vals = formGet.call(form);
                this.el.dom.disabled = false;
                
                if(this.store.getCount() === 0)
				{
                	vals[this.name] = '';
                }
                else
                {
                	vals[this.name] = vals[this.name].join(this.valueDelimiter);
                }
				
                return asString ? Ext.urlEncode(vals) : vals ;
            }.createDelegate(this);
        }
    }
	
    ,onResize : function(w, h, rw, rh)
	{
        var reduce = Ext.isIE6 ? 4 : Ext.isIE7 ? 1 : Ext.isIE8 ? 1 : 0;
		
        if(this.wrapEl)
		{
            this._width = w;
            this.outerWrapEl.setWidth(w - reduce);
			
            if(this.renderFieldBtns)
			{
                reduce += (this.buttonWrap.getWidth() + 20);
                this.wrapEl.setWidth(w - reduce);
        	}
        }
		
        Ext.form.MultiTextField.superclass.onResize.call(this, w, h, rw, rh);
		
        this.autoSize();
    }
	
    ,onEnable : function()
	{
        Ext.form.MultiTextField.superclass.onEnable.call(this);
		
		this.store.each(function(item)
		{
			item = Ext.getCmp(item.get(this.valueField));
			
			if(item)
			{
				item.enable();
			}
		},this);
		
		if(this.renderFieldBtns)
		{
            this.initButtonEvents();
        }
    }
    
    ,onDisable : function()
	{
        Ext.form.MultiTextField.superclass.onDisable.call(this);
		
		this.store.each(function(item)
		{
			item = Ext.getCmp(item.get(this.valueField));
			
			if(item)
			{
				item.disable();
			}
		},this);
		
        if(this.renderFieldBtns)
		{
            this.removeButtonEvents();
        }
    }
    
    ,clearValue : function(supressRemoveEvent)
	{
        Ext.form.MultiTextField.superclass.clearValue.call(this);
        
        this.preventMultipleRemoveEvents = supressRemoveEvent || this.supressClearValueRemoveEvents || false;
    	this.preventMultipleRemoveEvents = false;
        this.fireEvent('clear', this);
        
        return this;
    }
	
    ,onKeyUp : function(e)
	{
        if(this.editable !== false && (!e.isSpecialKey() || e.getKey() === e.BACKSPACE) && e.getKey() !== this.itemDelimiterKey && (!e.hasModifier() || e.shiftKey))
		{
            this.lastKey = e.getKey();
        }        
    }
	
    ,onKeyDownHandler : function(e,t)
	{
        var toDestroy, nextFocus, idx;
        var val = this.el.dom.value, it, ctrl = e.ctrlKey;
        
        val = val.replace(/ /g,'');
		
        if(e.getKey() === this.itemDelimiterKey)
		{
            e.stopEvent();
			
            if(val !== '')
			{
				this.addItem({value:Ext.id(),text:val});
            }
			else
			{
				return false;
            }
            
            return true;
        }
        
        if(val !== '')
		{
            this.autoSize();
            return;
        }
        
        if(e.getKey() === e.HOME)
		{
            e.stopEvent();
            
            if(this.store.getCount() > 0)
			{
				var r = this.store.data.get(0);
				
				if(r)
				{
					it = Ext.getCmp(r.get(this.valueField));
					
					if(it)
					{
						it.focus();
					}
				}
            }
            
            return true;
        }
        
        if(e.getKey() === e.BACKSPACE)
		{
            e.stopEvent();
			
            if(this.currentFocus)
			{
                toDestroy = this.currentFocus;
                idx = this.store.find(this.valueField, toDestroy[this.valueField]);
                
                this.clearCurrentFocus();
				
                if(idx < (this.store.getCount() -1))
				{
                    nextFocus = this.store.getAt(idx+1);
                }
                
                toDestroy.preDestroy(true);
                
                if(nextFocus)
				{
                    (function()
					{
                        nextFocus.onLnkFocus();
                        this.currentFocus = nextFocus;
                    }).defer(200,this);
                }
                
                return;
            }
			else
			{
                it = this.store.data.get((this.store.getCount()-1));
                
                if(it)
                {
                	it = Ext.getCmp(it.get(this.valueField));
                }
                else
                {
                	return false;
                }
				
                if(it && this.backspaceDeletesLastItem)
				{
					it.preDestroy(true);
                }
                
                return true;
            }
        }
        
        if(!e.isNavKeyPress())
		{
            this.multiSelectMode = false;
            this.clearCurrentFocus();
            return;
        }
        
        if(e.getKey() === e.LEFT || (e.getKey() === e.UP))
		{
            e.stopEvent();
            
            it = this.store.data.get((this.store.getCount()-1));
            
            if(it)
            {
            	it = Ext.getCmp(it.get(this.valueField));
            }
            
            if(it)
			{
                it.focus();
            }
            
            return true;
        }
		
        if(e.getKey() === e.DOWN)
		{
            if(this.currentFocus)
			{
                e.stopEvent();
                idx = this.store.find(this.valueField, this.currentFocus[this.valueField]);
				
                if(idx == (this.store.getCount() -1))
				{
                    this.clearCurrentFocus.defer(10,this);
                }
				else
				{
                    this.clearCurrentFocus();
                    this.currentFocus = this.store.getAt(idx+1);
                    if(this.currentFocus)
					{
                        this.currentFocus.onLnkFocus();
                    }
                }
                return true;
            }
        }
		
        if(e.getKey() === e.RIGHT)
		{
            it = this.store.getAt(0);
            it = it ? Ext.getCmp(it.get(this.valueField)) : undefined;
            
            if(it)
            {
                it.focus(); 
            }
        }
    }
	
    ,onKeyUpBuffered : function(e)
	{
        if(!e.isNavKeyPress())
		{
            this.autoSize();
        }
    }
	
    ,reset : function()
	{
    	this.killItems();
    	
        Ext.form.MultiTextField.superclass.reset.call(this);
        
        this.autoSize().setRawValue('');
    }
	
    ,applyEmptyText : function()
	{
		this.setRawValue('');
		
        if(this.store.getCount() > 0)
		{
            this.el.removeClass(this.emptyClass);
            this.setRawValue('');
            return this;
        }
        if(this.rendered && this.emptyText && this.getRawValue().length < 1)
		{
            this.setRawValue(this.emptyText);
            this.el.addClass(this.emptyClass);
        }
		
        return this;
    }
    
    ,removeAllItems : function(removeEffect)
	{
		this.store.each(function(item)
		{
			item = Ext.getCmp(item.get(this.valueField));
			
			if(item)
			{
				item.preDestroy(removeEffect);
			}
		},this);
		
		this.store.removeAll();
        this.manageClearBtn();
        
        return this;
    }
	
    ,killItems : function()
	{
		this.store.each(function(item)
		{
			item = Ext.getCmp(item.get(this.valueField));
			
			if(item)
			{
				item.kill();
			}
		},this);
		
        this.resetStore();
        this.manageClearBtn();
		
        return this;
    }
	
    ,resetStore : function()
	{
		this.store.removeAll();
        this.store.clearFilter();
        this.sortStore();
		
        return this;
    }
	
    ,sortStore : function()
	{
        var ss = this.store.getSortState();
        if(ss && ss.field)
		{
            this.store.sort(ss.field, ss.direction);
        }
		
        return this;
    }
	
    ,getCaption : function(dataObject)
	{
        if(typeof this.displayFieldTpl === 'string')
		{
            this.displayFieldTpl = new Ext.XTemplate(this.displayFieldTpl);
        }
        var display, recordData = dataObject instanceof Ext.data.Record ? dataObject.data : dataObject;
      
        if(this.displayFieldTpl)
		{
            display = this.displayFieldTpl.apply(recordData);
        }
		else if(this.displayField)
		{
            display = recordData[this.displayField];
        }
        
        return display;
    }
	
    ,addRecord : function(record, prevent)
	{
        var	 display	= record.data[this.displayField]
            ,caption	= record.data[this.displayField]
            ,val		= record.data[this.valueField]
        
        this.addItemBox(val, display);
        
        if(prevent !== true)
        {
        	this.fireEvent('additem', this, val, record);
        }
    }
	
    ,createRecord : function(recordData)
	{
		return new this.store.recordType(recordData);
    }
    
    ,addItems : function(newItemObjects)
	{
    	if(Ext.isArray(newItemObjects))
		{
			Ext.each(newItemObjects, function(item)
			{
				this.addItem(item);
			}, this);
		}
		else
		{
			this.addItem(newItemObjects);
		}
    }
    
    ,addNewItem : function(newItemObject)
	{
    	this.addItem(newItemObject, true);
    }
    
    ,addItem : function(newItemObject)
	{
        var val = newItemObject[this.valueField];
        
        if(this.disabled)
		{
            return false;
        }
        
        if(this.preventDuplicates && this.hasValue(newItemObject[this.displayField]))
		{
            return;
        }
        
        this.fireEvent('beforeadditem', this);
        
        var record = this.findRecord(this.valueField, val);
        
        if(record)
		{
            this.addRecord(record, false);
            return;
        }
		else if(!this.allowAddNewData)
		{
            return;
        }
        
        var rec = this.createRecord(newItemObject);
        
        this.store.add(rec);
        this.store.commitChanges();
        this.addRecord(rec, false);
        
        return true;
    }
    
    ,addItemBox : function(itemVal, itemDisplay)
	{
        var hConfig, parseStyle = function(s)
        {
            var ret = '';
            
            if(typeof s == 'function')
			{
                ret = s.call();
            }
			else if(typeof s == 'object')
			{
                for(var p in s)
				{
                    ret+= p +':'+s[p]+';';
                }
            }
			else if(typeof s == 'string')
			{
                ret = s + ';';
            }
			
            return ret;
			
        },
		
		itemKey = Ext.id(null,'sbx-item'), box = new Ext.form.MultiTextFieldItem({
             owner		: this
            ,disabled	: this.disabled
            ,renderTo	: this.wrapEl
            ,cls		: this.extraItemCls + ' ' + this.classField
            ,style		: parseStyle(this.extraItemStyle) + ' ' + this.styleField
            ,display	: itemDisplay
            ,value		: itemVal
            ,id			: itemVal
            ,listeners : {
                'remove' : function(item)
				{
                    if(this.fireEvent('beforeremoveitem', this, item.display) === false)
					{
                        return;
                    }
                    
					this.store.remove(this.findInStore(item.value));
					this.sortStore();
					
					if(this.view)
					{
						this.view.render();
                    }
                    
                    if(!this.preventMultipleRemoveEvents)
					{
                    	this.fireEvent.defer(250, this, ['removeitem', this, itemDisplay, this.findInStore(item.value)]);
                    }
                }
                ,destroy : function()
				{
                    this.autoSize().manageClearBtn().validateValue();
                }
                ,scope : this
            }
        });
		
        box.render();
        
        hConfig = {
             tag	: 'input' 
            ,type	: 'hidden' 
            ,value	: itemDisplay
            ,name	: this.name
        };
        
        if(this.disabled)
		{
        	Ext.apply(hConfig,{
        	   disabled : 'disabled'
        	})
        }
        
        box.hidden = this.el.insertSibling(hConfig, 'before');
        
        this.applyEmptyText().autoSize().manageClearBtn().validateValue();
    }
	
    ,manageClearBtn : function()
	{
        if(!this.renderFieldBtns || !this.rendered)
		{
            return this;
        }
        
        var cls = 'x-multitextfield-btn-hide';
        
        if(this.store.getCount() === 0)
		{
            this.buttonClear.addClass(cls);
        }
        else
		{
            this.buttonClear.removeClass(cls);
        }
		
        return this;
    }
	
    ,findInStore : function(val)
	{
        var index = this.store.find(this.valueField, val);
        
        if(index > -1)
		{
            return this.store.getAt(index);
        }
		
        return false;
    }
    
    ,getValue : function()
	{
        var ret = [];
        
        this.store.each(function(item)
        {
            ret.push(item.get(this.displayField));
        },this);
		
        return ret.join(this.valueDelimiter);
    }
    
    ,setValue : function(value)
	{
        if(!this.rendered)
		{
            this.value = value;
            return;
        }
		
        if(Ext.isEmpty(value))
		{
        	return;
        }
        
        this.removeAllItems(false);
        this.resetStore();
        
        var values = value;
        
        if(!Ext.isArray(value))
		{
            value = '' + value;
            values = value.split(this.valueDelimiter); 
        }
        
        Ext.each(values, function(val)
		{
            var record = this.findRecord(this.valueField, val);
            
            if(!record)
            {
            	this.addItem({value:Ext.id(),text:val});
            }
            else
            {
            	this.addRecord(record, true);
            }
        },this);
    }
    
    ,hasValue : function(val)
	{
		if(this.findRecord(this.displayField, val))
		{
			return true;
		}
		
		return false;
    }
    
    ,onDestroy : function()
	{
        this.killItems();
        
        if (this.renderFieldBtns)
		{
            Ext.destroy(
                this.buttonClear,
                this.buttonWrap
            );
        }

        Ext.destroy(
            this.inputEl,
            this.wrapEl,
            this.outerWrapEl
        );

        Ext.form.MultiTextField.superclass.onDestroy.call(this);
    }
	
    ,autoSize : function()
	{
        if(!this.rendered)
		{
            return this;
        }
		
        if(!this.metrics)
		{
            this.metrics = Ext.util.TextMetrics.createInstance(this.el);
        }
		
        var el = this.el,
            v = el.dom.value,
            d = document.createElement('div');
		
        if(v === '' && this.emptyText && this.store.getCount() < 1)
		{
            v = this.emptyText;
        }
		
        d.appendChild(document.createTextNode(v));
        v = d.innerHTML;
        d = null;
        v += "&#160;";
		
        var w = Math.max(this.metrics.getWidth(v) +  24, 24);
		
        if(typeof this._width != 'undefined')
		{
            w = Math.min(this._width, w);
        }
		
        this.el.setWidth(w);
		
        if(Ext.isIE)
		{
            this.el.dom.style.top = '0';
        }
		
        return this;
    }
});

Ext.reg('x-multitext', Ext.form.MultiTextField);

Ext.form.MultiTextFieldItem = function(config)
{
    Ext.apply(this,config);
    Ext.form.MultiTextFieldItem.superclass.constructor.call(this); 
};

Ext.form.MultiTextFieldItem = Ext.extend(Ext.form.MultiTextFieldItem, Ext.Component, {
	
    initComponent : function()
	{
        Ext.form.MultiTextFieldItem.superclass.initComponent.call(this); 
    }
	
    ,onElClick : function(e)
	{
        this.focus();
    }
    
    ,onLnkClick : function(e)
	{
        if(e)
		{
            e.stopEvent();
        }
        
        this.preDestroy(true);
    }
	
    ,onLnkFocus : function()
	{
        this.el.addClass("x-multitextfield-item-focus");
        this.owner.outerWrapEl.addClass("x-form-focus");
    }
    
    ,onLnkBlur : function()
	{
        this.el.removeClass("x-multitextfield-item-focus");
        this.owner.outerWrapEl.removeClass("x-form-focus");
    }
    
    ,enableElListeners : function()
	{
        this.el.on('click', this.onElClick, this, {stopEvent:true});
        this.el.addClassOnOver('x-multitextfield-item x-multitextfield-item-hover');
    }

    ,enableLnkListeners : function()
	{
        this.lnk.on({
             click	: this.onLnkClick
            ,focus	: this.onLnkFocus
            ,blur	: this.onLnkBlur
            ,scope	: this
        });
    }
    
    ,enableAllListeners : function()
	{
        this.enableElListeners();
        this.enableLnkListeners();
    }
	
    ,disableAllListeners : function()
	{
        this.el.removeAllListeners();
        this.lnk.un('click', this.onLnkClick, this);
        this.lnk.un('focus', this.onLnkFocus, this);
        this.lnk.un('blur', this.onLnkBlur, this);
    }
	
    ,onRender : function(ct, position)
	{
        Ext.form.MultiTextFieldItem.superclass.onRender.call(this, ct, position);
        
        var el = this.el;
        
        if(el)
		{
            el.remove();
        }
        
        this.el = el = ct.createChild({tag:'li'}, ct.last());

        el.addClass('x-multitextfield-item');
        
        var btnEl = Ext.isSafari ? 'button' : 'a';
        
        Ext.apply(el,{
            focus : function()
			{
                var c = this.down(btnEl +'.x-multitextfield-item-close');
                
                if(c)
				{
                	c.focus();
                }
            },
			
            preDestroy : function(effect)
			{
                this.preDestroy(effect);
            }.createDelegate(this)
        });
        
        this.enableElListeners();

        el.update(this.display);

        var cfg = {
             tag		: btnEl
            ,'class'	: 'x-multitextfield-item-close'
            ,tabIndex	: '0'
        };
        
        if(btnEl === 'a')
        {
            cfg.href = '#';
        }
        
        this.lnk = el.createChild(cfg);
        
        if(!this.disabled)
		{
            this.enableLnkListeners();
        }
		else
		{
            this.disableAllListeners();
        }
        
        this.on({
             disable: this.disableAllListeners
            ,enable	: this.enableAllListeners
            ,scope	: this
        });
        
        this.setupKeyMap();
    }
	
    ,setupKeyMap : function()
	{
        this.keyMap = new Ext.KeyMap(this.lnk,[{
			 key : [
				 Ext.EventObject.BACKSPACE 
				,Ext.EventObject.DELETE 
				,Ext.EventObject.SPACE
			]
			,fn		: this.preDestroy
			,scope	: this
		},{
			key : [
				 Ext.EventObject.RIGHT
				,Ext.EventObject.DOWN
			]
			,fn : function()
			{
				this.moveFocus('right');
			}
			,scope : this
		},{
			 key : [Ext.EventObject.LEFT,Ext.EventObject.UP]
			,fn : function()
			{
				this.moveFocus('left');
			}
			,scope : this
		},{
			 key : [Ext.EventObject.HOME]
			,fn : function()
			{
				var l = this.owner.items.get(0).el.focus();
				if(l)
				{
					l.el.focus();
				}
			}
			,scope : this
		},{
			 key : [Ext.EventObject.END]
			,fn : function()
			{
				this.owner.el.focus();
			}
			,scope : this
		},{
			 key: Ext.EventObject.ENTER
			,fn	: function(){}
		}]);
		
        this.keyMap.stopEvent = true;
    }
	
    ,moveFocus : function(dir)
	{
        var el = this.el[dir == 'left' ? 'prev' : 'next']() || this.owner.el;
        el.focus.defer(100, el);
    }
	
    ,preDestroy : function(supressEffect)
	{
    	if(this.fireEvent('remove', this) === false)
		{
	    	return;
	    }
			
    	var actionDestroy = function()
		{
			this.moveFocus('right');
            this.hidden.remove();
            this.hidden = null;
            this.destroy();
        };
        
        if(supressEffect)
		{
			this.el.hide({
                 duration	: 0.2
                ,callback	: actionDestroy
                ,scope		: this
            });
        }
		else
		{
			actionDestroy.call(this);
        }
		
        return this;
    }
	
    ,kill : function()
	{
    	this.hidden.remove();
        this.hidden = null;
        this.purgeListeners();
        this.destroy();
    }
	
    ,onDisable : function()
	{
    	if(this.hidden)
		{
    	    this.hidden.dom.setAttribute('disabled', 'disabled');
    	}
		
    	this.keyMap.disable();
    	
    	Ext.form.MultiTextFieldItem.superclass.onDisable.call(this);
    }
	
    ,onEnable : function()
	{
    	if(this.hidden)
		{
    	    this.hidden.dom.removeAttribute('disabled');
    	}
		
    	this.keyMap.enable();
    	
    	Ext.form.MultiTextFieldItem.superclass.onEnable.call(this);
    }
	
    ,onDestroy : function()
	{
        Ext.destroy(
             this.lnk
            ,this.el
        );
        
        Ext.form.MultiTextFieldItem.superclass.onDestroy.call(this);
    }
});