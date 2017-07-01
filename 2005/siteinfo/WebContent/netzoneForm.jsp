<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.siteinfo.formbean.*"%>
<%@ page import="com.hps.july.siteinfo.valueobject.*"%>
<july:editform action="/ProcessNetzone.do">
<%
	NetzoneForm frm = (NetzoneForm)request.getAttribute("NetzoneForm");
%>
<html:hidden property="netzone"/>
<script language="javascript">
function copyOptions(ssrc,sdest) {
	sdest.innerHTML = '';
	for(i = 0; i < ssrc.options.length; i++) {
		var oOpt = document.createElement("OPTION");
		oOpt.value = ssrc.options[i].value;
		oOpt.text = ssrc.options[i].text;
		oOpt.selected = ssrc.options[i].selected;
		sdest.add(oOpt);
	}
}
function updateSCRegion() {
	var frm = document.frames("downloadServiceFrameR");
	if(frm.document.all.content) {
		copyOptions(frm.document.all.content,document.all.regionid);
	}
}
function onSrChange() {
	var frm = document.frames("downloadServiceFrameR");
	if(!frm.document.forms[0]) {
		frm.document.write('<form name="params" method="POST" action="/siteinfo/regionsDataProviderHTML.jsp">');
		frm.document.write('<input type="text" name="lt" value="R">');
		frm.document.write('<input type="text" name="sr" value="">');
		frm.document.write('<input type="text" name="rg" value="">');
		frm.document.write('<input type="text" name="nz" value="">');
		frm.document.write('</form>');
	}
	frm.document.forms[0].lt.value='R';
	frm.document.forms[0].sr.value=document.all.superregionid.value;
	frm.document.forms[0].rg.value=document.all.regionid.value;
	frm.document.forms[0].submit();
}
</script>
<table class="main">
<july:separator/>
<july:formbuttons/>
<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.regionList.superRegion"/>:</july:reqmark></td>
	<td>
		<july:select property="superregionid" onchange="onSrChange();" insertable="true" updatable="true" style="width:450;">
<%=Regions.getOptionsList("S",new Integer(frm.getSuperregionid()),new Integer(frm.getRegionid()),null,request.getRemoteUser(),request.isUserInRole("administrator"))%>
		</july:select>
	</td>
</tr>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.position.region"/>:</july:reqmark></td>
	<td>
		<july:select property="regionid" insertable="true" updatable="true" style="width:450;">
<%=Regions.getOptionsList("R",new Integer(frm.getSuperregionid()),new Integer(frm.getRegionid()),null,request.getRemoteUser(),request.isUserInRole("administrator"))%>
		</july:select>
		<iframe id="downloadServiceFrameR" onload="updateSCRegion();" style="display:none;visibility:hidden;" width=1 height=1></iframe>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.name"/>:</july:reqmark></td>
	<td>
		<july:string property="name" size="50" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.netzone.zonecode"/>:</july:reqmark></td>
	<td>
		<july:string property="zonecode" size="10" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>
<script language="javascript">
	onSrChange();
</script>
</july:editform>

