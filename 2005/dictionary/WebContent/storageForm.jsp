<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.dictionary.formbean.*"%>
<%@ page import="com.hps.july.siteinfo.valueobject.*"%>

<july:editform action="/ProcessStorage.do">
<%
	StorageForm frm = (StorageForm)request.getAttribute("StorageForm");
%>

<html:hidden property="storageplace"/>

<script language="javascript">
function companyOnSelect() {
	document.all['directioncode'].value = '';
	document.all['directionname'].value = '';
	directionOnSelect();
}
function directionOnSelect() {
	document.all['servicecode'].value = '';
	document.all['servicename'].value = '';
	serviceOnSelect();
}
function serviceOnSelect() {
	document.all['departmentcode'].value = '';
	document.all['departmentname'].value = '';
	departmentOnSelect();
}
function departmentOnSelect() {
	document.all['groupcode'].value = '';
	document.all['groupname'].value = '';
}

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
	if(frm.document.all.content && document.all.action.value != 'Delete') {
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
	<td class="text"><july:reqmark><bean:message key="label.position.search.supregs"/>:</july:reqmark></td>
	<td>
		<july:select property="superregionid" onchange="onSrChange();" insertable="true" updatable="true" style="width:450;">
<%=Regions.getOptionsList("S",new Integer(frm.getSuperregionid()),new Integer(frm.getRegionid()),null,request.getRemoteUser(),request.isUserInRole("administrator"))%>
		</july:select>
	</td>
</tr>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.position.search.regions"/>:</july:reqmark></td>
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
		<july:string property="name" size="25" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.storage.addr"/>:</july:reqmark></td>
	<td>
		<july:string property="address" size="25" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.company.name"/>:</july:reqmark></td>
	<td>
		<july:string property="companycode" styleId="cmp" size="5" insertable="true" updatable="true" onkeypress="companyOnSelect();" />
		<july:lookupbutton action="/ShowCompanyLookupList.do" styleId="cmpl" fieldNames="cmp;cmpname" insertable="true" updatable="true" onselect="companyOnSelect();"/>
		<july:string size="30" property="companyname" styleId="cmpname" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.direction.name"/>:</july:reqmark></td>
	<td>
		<july:string property="directioncode" styleId="dir" size="5" insertable="true" updatable="true" onkeypress="directionOnSelect();" />
		<july:lookupbutton action="/ShowDirectionLookupList.do" styleId="dirl" fieldNames="dir;dirname" onclick="set_opt_params_dirl('?company='+document.all.cmp.value)" insertable="true" updatable="true"  onselect="directionOnSelect();"/>
		<july:string size="30" property="directionname" styleId="dirname" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.service.name"/>:</td>
	<td>
		<july:string property="servicecode" styleId="srv" size="5" insertable="true" updatable="true" onkeypress="serviceOnSelect();" />
		<july:lookupbutton action="/ShowServiceLookupList.do" styleId="srvl" fieldNames="srv;srvname" onclick="set_opt_params_srvl('?direction='+document.all.dir.value)" insertable="true" updatable="true"  onselect="serviceOnSelect();"/>
		<july:string size="30" property="servicename" styleId="srvname" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.department.name"/>:</td>
	<td>
		<july:string property="departmentcode" styleId="dep" size="5" insertable="true" updatable="true" onkeypress="departmentOnSelect();" />
		<july:lookupbutton action="/ShowDepartmentLookupList.do" styleId="depl" fieldNames="dep;depname" onclick="set_opt_params_depl('?service='+document.all.srv.value)" insertable="true" updatable="true" onselect="departmentOnSelect();"/>
		<july:string size="30" property="departmentname" styleId="depname" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.dgroup.name"/>:</td>
	<td>
		<july:string property="groupcode" styleId="grp" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowDGroupLookupList.do" styleId="grpl" fieldNames="grp;grpname" onclick="set_opt_params_grpl('?department='+document.all.dep.value)" insertable="true" updatable="true"/>
		<july:string size="30" property="groupname" styleId="grpname" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.storage.pstnphone"/>:</td>
	<td>
		<july:string property="pstnphone" size="25" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.storage.internalphone"/>:</td>
	<td>
		<july:string property="internalphone" size="25" insertable="true" updatable="true" />
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

