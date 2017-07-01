<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessReport5.do">

<% String gColSpan = "3"; %>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		Report5ParamsForm[itemname].className = 'editkoddisabled';
		Report5ParamsForm[itemname].disabled = true;
		Report5ParamsForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		Report5ParamsForm[itemname].className = 'editkod';
		Report5ParamsForm[itemname].disabled = false;
		Report5ParamsForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchItem(itemname,state) {
	if(state) {
		Report5ParamsForm[itemname].disabled = true;
		Report5ParamsForm[itemname].className = 'editdisabled';
	} else {
		Report5ParamsForm[itemname].disabled = false;
		Report5ParamsForm[itemname].className = 'edit';
	}
}

function switchFilter() {
	if(Report5ParamsForm.storagetype[1].checked) {
		switchLookup('positionFrm','pos',false);
		switchItem('storageFrm',true);
		switchLookup('equipmentFrm','equ',true);
	} else if(Report5ParamsForm.storagetype[0].checked) {
		switchLookup('positionFrm','pos',true);
		switchItem('storageFrm',false);
		switchLookup('equipmentFrm','equ',true);
	} else if(Report5ParamsForm.storagetype[2].checked) {
		switchLookup('positionFrm','pos',false);
		switchItem('storageFrm',true);
		switchLookup('equipmentFrm','equ',false);
	} else {
		switchLookup('positionFrm','pos',true);
		switchItem('storageFrm',true);
		switchLookup('equipmentFrm','equ',true);
	}
}

function switchIncs() {
	Report5ParamsForm['docExtincome'][0].disabled=Report5ParamsForm['docAll'][0].checked;
	Report5ParamsForm['docIntincome'][0].disabled=Report5ParamsForm['docAll'][0].checked;
	Report5ParamsForm['docAssact'][0].disabled=Report5ParamsForm['docAll'][0].checked;
	Report5ParamsForm['docAssactb'][0].disabled=Report5ParamsForm['docAll'][0].checked;
	Report5ParamsForm['docInvextra'][0].disabled=Report5ParamsForm['docAll'][0].checked;
}
</script>

<table class="main">
    
<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title"><bean:message key="label.report5.place"/>:</td>
	<td class="text" colspan="<%= gColSpan %>">
		<july:radio styleClass="text" insertable="true" updatable="true" property="storagetype" value="2" onclick="switchFilter();"/><bean:message key="label.report4.storage"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<july:radio styleClass="text" insertable="true" updatable="true" property="storagetype" value="1" onclick="switchFilter();"/><bean:message key="label.report4.position"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<july:radio styleClass="text" insertable="true" updatable="true" property="storagetype" value="3" onclick="switchFilter();"/><bean:message key="label.report4.equipment"/>&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
</tr>

<tr>
	<td class="title">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.report5.storage"/>:</td>
	<td class="text" colspan="<%= gColSpan %>">
   		<july:select collection="storages" property="storageFrm" insertable="true" updatable="true" styleClass="search" style="width:400;">
			<html:options collection="storages" property="storageplace" labelProperty="name"/>
		</july:select>
	</td>
</tr>

<tr>
	<td class="title">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.report5.position"/>:</td>
	<td class="text" colspan="<%= gColSpan %>">
		<july:string property="positionFrm" styleId="positionFrm" size="5" insertable="true" updatable="true" styleId="editkod"/>
		<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positionFrm;positionid;positionname;equipmentFrm;equipmentname" newWindowName="poslookup" insertable="true" updatable="true" />
		<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
		<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
	</td>
</tr>

<tr>
	<td class="title">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.report5.equipment"/>:</td>
	<td class="text" colspan="<%= gColSpan %>">
		<html:hidden property="equipmentFrm"/>
<!--		<july:string property="equipmentFrm" styleId="equipmentFrm" size="5" insertable="true" updatable="true" /> -->
		<july:string size="35" property="equipmentname" styleId="equipmentname" insertable="false" updatable="false" />
		<july:lookupbutton action="/ShowComplectLookupList.do" styleId="equl" fieldNames="equipmentFrm;equipmentname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_equl('?position='+document.all.positionFrm.value)"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" rowspan="1"><bean:message key="label.report5.period"/></td>
	<td class="text" colspan="2">
		<bean:message key="label.datefrom"/> &nbsp;&nbsp;&nbsp; <july:date property="datefromFrm" size="25" insertable="true" updatable="true"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<bean:message key="label.dateto"/> &nbsp;&nbsp;&nbsp; <july:date property="datetoFrm" size="25" insertable="true" updatable="true"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title"><bean:message key="label.report5.resource"/>:</td>
	<td class="text" colspan="2" nowrap>
		<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true"/>
		<july:string size="25" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
		<july:string size="25" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" rowspan="3"><bean:message key="label.report5.doctypes"/></td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="docAll" onclick="switchIncs();"/><bean:message key="label.report5.docall"/>
	</td>
</tr>
<tr>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="docExtincome"/><bean:message key="label.report5.docextincome"/>
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="docIntincome"/><bean:message key="label.report5.docintincome"/>
	</td>
</tr>
<tr>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="docAssact"/><bean:message key="label.report5.docassact"/>
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="docAssactb"/><bean:message key="label.report5.docassactb"/>
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="docInvextra"/><bean:message key="label.report5.docinvextra"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title">&nbsp;</td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="showContract"/>&nbsp;<bean:message key="label.report5.showcontract"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/refresh.gif" ALT="<bean:message key="label.report.refresh"/>">
	</td>
</tr>
    
<july:separator colspan="<%= gColSpan %>" />

<script language="javascript">
switchFilter();
switchIncs();
</script>

</table>

</july:editform>

