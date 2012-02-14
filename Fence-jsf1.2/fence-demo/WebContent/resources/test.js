function do_js_beautify() {
	var js_source = Ext.getDom('sourceDiv').innderHTML.replace(/^\s+/, '');
	var tabsize = 4;
	var tabchar = ' ';
	if (js_source && js_source.charAt(0) === '<') {
		Ext.getDom('sourceDiv').innderHTML = style_html(js_source,	tabsize, tabchar, 80);
	} else {
		Ext.getDom('sourceDiv').innderHTML = js_beautify(js_source,	tabsize, tabchar);
	}
}