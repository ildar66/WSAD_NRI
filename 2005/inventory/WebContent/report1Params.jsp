<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessReport1.do">

<% String gColSpan = "3"; %>


<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		Report1ParamsForm[itemname].className = 'editkoddisabled';
		Report1ParamsForm[itemname].disabled = true;
		Report1ParamsForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		Report1ParamsForm[itemname].className = 'editkod';
		Report1ParamsForm[itemname].disabled = false;
		Report1ParamsForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchItem(itemname,state) {
	if(state) {
		Report1ParamsForm[itemname].disabled = true;
		Report1ParamsForm[itemname].className = 'editdisabled';
	} else {
		Report1ParamsForm[itemname].disabled = false;
		Report1ParamsForm[itemname].className = 'edit';
	}
}

function switchFilter() {
	if(Report1ParamsForm.storagetype[0].checked) {
		switchLookup('positionFrm','pos',false);
		switchItem('storageFrm',true);
		switchLookup('workerFrm','work',true);
		switchLookup('organizationFrm','org',true);
		switchIncsWithAll(false);
		switchGroups(false);
	} else if(Report1ParamsForm.storagetype[1].checked) {
		switchLookup('positionFrm','pos',true);
		switchItem('storageFrm',false);
		switchLookup('workerFrm','work',true);
		switchLookup('organizationFrm','org',true);
		switchIncsWithAll(true);
		switchGroups(true);
	} else if(Report1ParamsForm.storagetype[2].checked) {
		switchLookup('positionFrm','pos',true);
		switchItem('storageFrm',true);
		switchLookup('workerFrm','work',false);
		switchLookup('organizationFrm','org',true);
		switchIncsWithAll(true);
		switchGroups(true);
	} else if(Report1ParamsForm.storagetype[3].checked) {
		switchLookup('positionFrm','pos',true);
		switchItem('storageFrm',true);
		switchLookup('workerFrm','work',true);
		switchLookup('organizationFrm','org',false);
		switchIncsWithAll(true);
		switchGroups(true);
	} else {
		switchLookup('positionFrm','pos',true);
		switchItem('storageFrm',true);
		switchLookup('workerFrm','work',true);
		switchLookup('organizationFrm','org',true);
		switchIncsWithAll(true);
		switchGroups(true);
	}
}

function switchGroups(state) {
	if(state) {
		Report1ParamsForm['reporttype'][0].checked = true;
	}
	Report1ParamsForm['reporttype'][0].disabled=state;
	Report1ParamsForm['reporttype'][1].disabled=state;
}

function switchIncsWithAll(state) {
	Report1ParamsForm['incDamps'][0].disabled=state;
	Report1ParamsForm['incGsm'][0].disabled=state;
	Report1ParamsForm['incDcs'][0].disabled=state;
	Report1ParamsForm['incControllers'][0].disabled=state;
	Report1ParamsForm['incSwitches'][0].disabled=state;
	Report1ParamsForm['incRepeaters'][0].disabled=state;
	Report1ParamsForm['incComs'][0].disabled=state;
	Report1ParamsForm['incOthers'][0].disabled=state;
	Report1ParamsForm['incWlans'][0].disabled=state;
	Report1ParamsForm['incAll'][0].disabled=state;
	switchIncs();
}

function switchIncs() {
	if(Report1ParamsForm['incAll'][0].disabled == false) {
		Report1ParamsForm['incDamps'][0].disabled=Report1ParamsForm['incAll'][0].checked;
		Report1ParamsForm['incGsm'][0].disabled=Report1ParamsForm['incAll'][0].checked;
		Report1ParamsForm['incDcs'][0].disabled=Report1ParamsForm['incAll'][0].checked;
		Report1ParamsForm['incControllers'][0].disabled=Report1ParamsForm['incAll'][0].checked;
		Report1ParamsForm['incSwitches'][0].disabled=Report1ParamsForm['incAll'][0].checked;
		Report1ParamsForm['incRepeaters'][0].disabled=Report1ParamsForm['incAll'][0].checked;
		Report1ParamsForm['incComs'][0].disabled=Report1ParamsForm['incAll'][0].checked;
		Report1ParamsForm['incOthers'][0].disabled=Report1ParamsForm['incAll'][0].checked;
		Report1ParamsForm['incWlans'][0].disabled=Report1ParamsForm['incAll'][0].checked;
	} else {
		Report1ParamsForm['incDamps'][0].disabled=true;
		Report1ParamsForm['incGsm'][0].disabled=true;
		Report1ParamsForm['incDcs'][0].disabled=true;
		Report1ParamsForm['incControllers'][0].disabled=true;
		Report1ParamsForm['incSwitches'][0].disabled=true;
		Report1ParamsForm['incRepeaters'][0].disabled=true;
		Report1ParamsForm['incComs'][0].disabled=true;
		Report1ParamsForm['incOthers'][0].disabled=true;
		Report1ParamsForm['incWlans'][0].disabled=true;
	}
}

function showLookupWindow(name) {
	var myWindow = window.open(
		"Show"+name+"LookupList.do",
		name+"lookup",
		"top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes"
	);
	return false;
}
</script>

<table class="main">
    
<july:separator colspan="<%= gColSpan %>" />
    
<tr>
	<td class="title" rowspan="4"><bean:message key="label.report1.place"/></td>
	<td class="text">
		<july:radio styleClass="text" insertable="true" updatable="true" property="storagetype" value="P" onclick="switchFilter();"/><bean:message key="label.report1.position"/>
	</td>
	<td class="text">
		<july:string property="positionFrm" styleId="positionFrm" size="5" insertable="true" updatable="true" styleId="editkod"/>
		<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positionFrm;positionid;positionname" newWindowName="poslookup" insertable="true" updatable="true" />
		<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
		<july:string size="10" property="positionname" styleId="positionname" insertable="false" updatable="false" />
	</td>
</tr>
<tr>
	<td class="text">
		<july:radio styleClass="text" insertable="true" updatable="true" property="storagetype" value="S" onclick="switchFilter();"/><bean:message key="label.report1.storage"/>
	</td>
	<td class="text">
   		<july:select collection="storages" property="storageFrm" insertable="true" updatable="true" styleClass="search" style="width:400;">
			<html:options collection="storages" property="storageplace" labelProperty="name"/>
		</july:select>
	</td>
</tr>
<tr>
	<td class="text">
		<july:radio styleClass="text" insertable="true" updatable="true" property="storagetype" value="E" onclick="switchFilter();"/><bean:message key="label.report1.worker"/>
	</td>
	<td class="text">
		<july:string property="workerFrm" styleId="workerFrm" size="5" insertable="true" updatable="true"  styleClass="editkod" />
		<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="workerFrm;workername;workertitle" newWindowName="workerlookup" insertable="true" updatable="true" />
		<july:string size="10" property="workername" styleId="workername" insertable="false" updatable="false" />
		<july:string size="10" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
	</td>
</tr>
<tr>
	<td class="text">
		<july:radio styleClass="text" insertable="true" updatable="true" property="storagetype" value="O" onclick="switchFilter();"/><bean:message key="label.report1.organization"/>
	</td>
	<td class="text">
		<july:string property="organizationFrm" styleId="organizationFrm" size="5" insertable="true" updatable="true" styleClass="editkod"/>
		<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="organizationFrm;organizationname" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_orgl('?selisprovider=true&selisrenter=false&selissupplier=false');" />
		<july:string size="35" property="organizationname" styleId="organizationname" insertable="false" updatable="false" />
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
<tr>
	<td class="title" rowspan="4"><bean:message key="label.report1.inccomplects"/></td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="incAll" onclick="switchIncs();"/><bean:message key="label.report1.incall"/>
	</td>
</tr>
<tr>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="incDamps"/><bean:message key="label.report1.inc.bsdamps"/>
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="incGsm"/><bean:message key="label.report1.inc.bsgsm"/>
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="incDcs"/><bean:message key="label.report1.inc.bsdcs"/>
	</td>
</tr>
<tr>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="incControllers"/><bean:message key="label.report1.inc.controller"/>
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="incSwitches"/><bean:message key="label.report1.inc.switch"/>
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="incRepeaters"/><bean:message key="label.report1.inc.repeater"/>
	</td>
</tr>
<tr>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="incComs"/><bean:message key="label.report1.inc.comequipment"/>
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="incOthers"/><bean:message key="label.report1.inc.otherequipment"/>
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="incWlans"/><bean:message key="label.report1.inc.wlan"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
<tr>
	<td class="title" rowspan="2"><bean:message key="label.report1.group"/></td>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="reporttype" value="T"/><bean:message key="label.report1.group.together"/>
	</td>
</tr>
<tr>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="reporttype" value="E"/><bean:message key="label.report1.group.each"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
<tr>
	<td class="title" rowspan="1"><bean:message key="label.report1.incresources"/></td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="incvtypes"/><bean:message key="label.report1.incvtypes"/>&nbsp;<INPUT TYPE="BUTTON" NAME="choosevtypes" value="Выбрать" onclick="return showLookupWindow('Report1rt');">
	</td>
</tr>
<%--
<july:separator colspan="<%= gColSpan %>" />
<tr>
	<td class="title" rowspan="1"><bean:message key="label.report1.state"/></td>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="statetype" value="C"/><bean:message key="label.report1.currentdate"/>
	</td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />
<tr>
	<td class="title">&nbsp;</td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="showAgregateContent"/>&nbsp;<bean:message key="label.report1.showagregated"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
<tr>
	<td class="title">&nbsp;</td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="showWithContract"/>&nbsp;<bean:message key="label.report1.showwithcontracts"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/refresh.gif" ALT="<bean:message key="label.report.refresh"/>">
	</td>
</tr>
    
<july:separator colspan="<%= gColSpan %>" />

</table>

<script language="javascript">
switchFilter();
Report1ParamsForm['reporttype'].disabled = true;
switchIncs();
</script>

</july:editform>

