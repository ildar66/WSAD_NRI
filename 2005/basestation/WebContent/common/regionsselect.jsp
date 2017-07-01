<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.siteinfo.valueobject.Regions"%>
<%@ page import="com.hps.july.siteinfo.valueobject.RegionsSelector"%>

<%
	String regionsSelectorProperty = "regionsSelector";
	Object o = pageContext.findAttribute("regionsSelectorProperty");
	if(o != null) {
		regionsSelectorProperty = String.valueOf(o);
	} 
	RegionsSelector rs = RegionsSelector.findRegionsSelector(pageContext);
%>
<script language="javascript">
function toggleSelect(sel,toggle) {
	try {
	if(sel.length > 0) {
		if(toggle) {
			for(var i = sel.length-1; i >= 0; i--) {
				sel.options[i].selected = true;
			}
			sel.disabled = true;
		} else {
			sel.disabled = false;
			sel.options[0].selected = true;
			for(var i = 1; i < sel.length; i++) {
				sel.options[i].selected = false;
			}
		}
	}
	} catch(e) {}
}
function onAllSuperregionsClick() {
	if(document.all.superregioncodes) {
		toggleSelect(document.all.superregioncodes,document.all.allSuperregions.checked);
		onSrChange();
		onRgChange();
	}
}
function onAllRegionsClick() {
	if(document.all.regioncodes) {
		toggleSelect(document.all.regioncodes,document.all.allRegions.checked);
		onRgChange();
	}
}
function onAllNetzonesClick() {
	if(document.all.netzonecodes) {
		toggleSelect(document.all.netzonecodes,document.all.allNetzones.checked);
	}
}
function getSelectedItems(selectobject) {
	var res = '';
	var i = 0;
	var l = 0;
	try {
		if(selectobject.options) { l = selectobject.options.length; }
		for(i = 0; i < l; i++) {
			if(selectobject.options[i].selected) {
				res += selectobject.options[i].value + '-';
			}
		}
	} catch(e) {
	}
	return res;
}
function copyOptions(ssrc,sdest) {
	try {
	sdest.innerHTML = '';
	for(i = 0; i < ssrc.options.length; i++) {
		var oOpt = document.createElement("OPTION");
		oOpt.value = ssrc.options[i].value;
		oOpt.text = ssrc.options[i].text;
		oOpt.selected = ssrc.options[i].selected;
		sdest.add(oOpt);
	}
	} catch(e) {
	}
}
function updateSCRegion() {
	var frm = document.frames("downloadServiceFrameR");
	if(frm.document.all.content) {
		copyOptions(frm.document.all.content,document.all.regioncodes);
		toggleSelect(document.all.regioncodes,document.all.allRegions.checked);
	}
	onRgChange();
}
function updateSCNetzone() {
	var frm = document.frames("downloadServiceFrameN");
	if(frm.document.all.content) {
		copyOptions(frm.document.all.content,document.all.netzonecodes);
		toggleSelect(document.all.netzonecodes,document.all.allNetzones.checked);
	}
}
function onSrChange() {
	var frm = document.frames("downloadServiceFrameR");
	if(frm) {
		if(!frm.document.forms[0]) {
			frm.document.write('<form name="params" method="POST" action="/siteinfo/regionsDataProviderHTML.jsp">');
			frm.document.write('<input type="text" name="lt" value="R">');
			frm.document.write('<input type="text" name="sr" value="">');
			frm.document.write('<input type="text" name="rg" value="">');
			frm.document.write('<input type="text" name="nz" value="">');
			frm.document.write('</form>');
		}
		frm.document.forms[0].lt.value='R';
		frm.document.forms[0].sr.value=getSelectedItems(document.all.superregioncodes);
		frm.document.forms[0].rg.value=getSelectedItems(document.all.regioncodes);
		frm.document.forms[0].submit();
	}
}
function onRgChange() {
	var frm = document.frames("downloadServiceFrameN");
	if(frm) {
		if(!frm.document.forms[0]) {
			frm.document.write('<form name="params" method="POST" action="/siteinfo/regionsDataProviderHTML.jsp">');
			frm.document.write('<input type="text" name="lt" value="N">');
			frm.document.write('<input type="text" name="sr" value="">');
			frm.document.write('<input type="text" name="rg" value="">');
			frm.document.write('<input type="text" name="nz" value="">');
			frm.document.write('</form>');
		}
		frm.document.forms[0].lt.value='N';
		frm.document.forms[0].rg.value=getSelectedItems(document.all.regioncodes);
		frm.document.forms[0].nz.value=getSelectedItems(document.all.netzonecodes);
		frm.document.forms[0].submit();
	}
}
function initRegionsSelector() {
	onSrChange();
}
</script>
<iframe id="downloadServiceFrameR" onload="updateSCRegion();" style="display:none;visibility:hidden;" width=200 height=100></iframe>
<iframe id="downloadServiceFrameN" onload="updateSCNetzone();" style="display:none;visibility:hidden;" width=200 height=100></iframe>
<table class='find' style="font-size: 8pt;">
<tr>
	<td class="title">
		<bean:message key="label.position.search.supregs"/>
		<july:checkbox styleId='allSuperregions' property='<%=regionsSelectorProperty+".allSuperregions"%>' insertable="true" updatable="true" onclick="onAllSuperregionsClick();"/>
		<bean:message key="label.search.all"/>
	</td>
	<td class="title">
		<bean:message key="label.position.search.regions"/>
		<july:checkbox styleId='allRegions' property='<%=regionsSelectorProperty+".allRegions"%>' insertable="true" updatable="true" onclick="onAllRegionsClick();" />
		<bean:message key="label.search.all"/>
	</td>
	<td class="title">
		<bean:message key="label.position.netzonename"/>
		<july:checkbox styleId='allNetzones' property='<%=regionsSelectorProperty+".allNetzones"%>' insertable="true" updatable="true" onclick="onAllNetzonesClick();" />
		<bean:message key="label.search.all"/>
	</td>
</tr>
<tr>
	<td class="title">
		<select name='<%=regionsSelectorProperty+".superregioncodes"%>'  style="font-size: 8pt;"
			id="superregioncodes" onchange="onSrChange();" multiple="multiple" size="3" class="editsearch" <%=(rs.isAllSuperregions()?"disabled":"")%>>
<%=Regions.getOptionsList("S",rs,request.getRemoteUser(),request.isUserInRole("administrator"))%>
		</select>
	</td>
	<td class="title">
		<select name='<%=regionsSelectorProperty+".regioncodes"%>' style="font-size: 8pt;"
			id="regioncodes" onchange="onRgChange();" multiple="multiple" size="3" class="editsearch" <%=(rs.isAllRegions()?"disabled":"")%>>
<%=Regions.getOptionsList("R",rs,request.getRemoteUser(),request.isUserInRole("administrator"))%>
		</select>
	</td>
	<td class="title">
		<select name='<%=regionsSelectorProperty+".netzonecodes"%>' style="font-size: 8pt;"
		id="netzonecodes" multiple="multiple" size="3" class="editsearch" <%=(rs.isAllNetzones()?"disabled":"")%>>
<%=Regions.getOptionsList("N",rs,request.getRemoteUser(),request.isUserInRole("administrator"))%>
		</select>
	</td>
</tr>
</table>
<script language="javascript">initRegionsSelector();</script>
