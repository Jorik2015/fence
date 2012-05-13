/**
 * 将FCKeditor 作为Ext的Form表单元素整合进来 需要导入: ext-all.js fckeditor.js
 * 仅支持常规表单处理，暂时未经充分测试 操作示例： var editor = new Ext.form.EFCKEditor({ id:'hello',
 * name:'hello', fieldLabel: '内 容', xtype:'efckeidtor', height:300,
 * allowBlank:false, blankText:'内容是必填项' });
 * 
 * @author: lh83mail@126.com
 * @date 2008-12-11
 */

Ext.ux.form.EFCKEditor = Ext.extend(Ext.form.TextArea,{
					// FCKEditor reference
					// read only
					editor : null,
					height : 300,
					width : 600,
					autoWidth : true,
					msgTarget : 'under',
					// private
					maskEl : null,
					// overwrite
					setValue : function(v) {
						if (this.notInstanced()) {
							Ext.form.HtmlEditor.superclass.setValue.call(this,
									v);
						} else {
							FCKeditorAPI.GetInstance(this.name).SetHTML(v);
						}
						this.value = v;
					},
					// getHTMLValue
					// overwrite
					getValue : function() {
						var v;
						if (this.notInstanced()) {
							Ext.form.HtmlEditor.superclass.getValue(this);
						} else {
							v = FCKeditorAPI.GetInstance(this.name).GetHTML();
						}
						return v;
					},
					validate : function() {
						if (this.notInstanced()) {
							return true;
						}
						if (this.disabled || this.validateValue(this.processValue(this.getRawValue()))) {
							this.clearInvalid();
							return true;
						}
						return false;
					},
					getRawValue : function() {
						return this.getValue();
					},
					disable : function() {
						var elp = this.getParentContainer();
						this.maskEl = elp.mask();
						elp.applyStyles({
							paddingLeft : "0px"
						});
						this.disabled = true;
					},
					enable : function() {
						//var elp = this.getParentContainer();
						if (this.maskEl) {
							this.maskEl.remove();
							this.maskEl = null;
							this.disabled = false;
						}
					},
					// private
					// overwrite
					onRender : function(ct, position) {
						if (!this.el) {
							this.defaultAutoCreate = {
								tag : "textarea",
								style : "width:100px;height:60px;",
								autocomplete : "off"
							};
						}
						Ext.form.HtmlEditor.superclass.onRender.call(this, ct,position);
						this.setValue(this.value);
						this.editor = new FCKeditor(this.name);
						this.editor.Height = this.height;
						if(this.basePath){
							this.editor.BasePath = this.basePath;
						}else{
							this.editor.BasePath = "/resources/ext340/uux/fckeditor/";
						}

						if (!this.autoWidth) {
							this.editor.Width = this.width;
						}
						this.editor.ReplaceTextarea();
					},
					markInvalid : function(msg) {
						if (!this.rendered || this.preventMark) { // not
							// rendered
							return;
						}
						msg = msg || this.invalidText;

						// 由于qtip方式实现显示不正常，仅使用under形式
						if (!this.errorEl) {
							var elp = this.getParentContainer();
							this.errorEl = elp.createChild({
								cls : 'x-form-invalid-msg'
							});
							this.errorEl.setWidth(elp.getWidth(true) - 20);
						}
						this.errorEl.update(msg);
						Ext.form.Field.msgFx[this.msgFx].show(this.errorEl,
								this);
					},
					// private
					notInstanced : function() {
						return (window.FCKeditorAPI == undefined || window.FCKeditorAPI == null);
					},
					// private
					getParentContainer : function() {
						var pl = Ext.get(this.id + "___Frame");
						return pl.findParent('.x-form-element', 5, true);
					}
				});
Ext.reg("efckeidtor", Ext.ux.form.EFCKEditor);