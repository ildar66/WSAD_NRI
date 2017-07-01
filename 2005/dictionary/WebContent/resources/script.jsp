<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		document.forms[0][itemname].className = 'editkodsearch';
		document.forms[0][itemname].disabled = false;
		document.forms[0][itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	} else {
		document.forms[0][itemname].className = 'editkoddisabled';
		document.forms[0][itemname].disabled = true;
		document.forms[0][itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	}
}
function switchItem(itemname,state) {
	if(state) {
		document.forms[0][itemname].disabled = false;
		document.forms[0][itemname].className = 'editsearch';
	} else {
		document.forms[0][itemname].disabled = true;
		document.forms[0][itemname].className = 'editdisabled';
	}
}

function switchResourcetype() {
	switchLookup('resourcetype','rt',document.forms[0].isResourcetype[0].checked);
}
function switchResourcesubtype() {
	switchLookup('resourcesubtype','rst',document.forms[0].isResourcesubtype[0].checked);
}
function switchModel() {
	switchItem('model',document.forms[0].isModel[0].checked);
}
function switchName() {
	switchItem('name',document.forms[0].isName[0].checked);
}
function switchManufid() {
	switchLookup('manufid','org',document.forms[0].isManufid[0].checked);
}
function switchManucode() {
	switchItem('manucode',document.forms[0].isManucode[0].checked);
}
function switchNfscode() {
	switchItem('nfscode',document.forms[0].isNfscode[0].checked);
}
function switchNricode() {
	switchItem('nricode',document.forms[0].isNricode[0].checked);
}
function rtlOnSelect() {
	document.all['rstype.string'].value = '';
	document.all['rstypename'].value = '';
}
</script>
