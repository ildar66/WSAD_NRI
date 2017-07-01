<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessMassdoc.do">

<% String gColSpan = "3"; %>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		MassdocParamsForm[itemname].className = 'editkoddisabled';
		MassdocParamsForm[itemname].disabled = true;
		MassdocParamsForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		MassdocParamsForm[itemname].className = 'editkod';
		MassdocParamsForm[itemname].disabled = false;
		MassdocParamsForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchItem(itemname,state) {
	if(state) {
		MassdocParamsForm[itemname].disabled = true;
		MassdocParamsForm[itemname].className = 'editdisabled';
	} else {
		MassdocParamsForm[itemname].disabled = false;
		MassdocParamsForm[itemname].className = 'edit';
	}
}

function switchFilter() {
	if(MassdocParamsForm.storagetype[1].checked) {
		switchLookup('positionFrm','pos',false);
		switchItem('storageFrm',true);
		switchLookup('workerFrm','work',true);
		switchLookup('organizationFrm','org',true);
	} else if(MassdocParamsForm.storagetype[2].checked) {
		switchLookup('positionFrm','pos',true);
		switchItem('storageFrm',false);
		switchLookup('workerFrm','work',true);
		switchLookup('organizationFrm','org',true);
	} else if(MassdocParamsForm.storagetype[3].checked) {
		switchLookup('positionFrm','pos',true);
		switchItem('storageFrm',true);
		switchLookup('workerFrm','work',false);
		switchLookup('organizationFrm','org',true);
	} else if(MassdocParamsForm.storagetype[4].checked) {
		switchLookup('positionFrm','pos',true);
		switchItem('storageFrm',true);
		switchLookup('workerFrm','work',true);
		switchLookup('organizationFrm','org',false);
	} else {
		switchLookup('positionFrm','pos',true);
		switchItem('storageFrm',true);
		switchLookup('workerFrm','work',true);
		switchLookup('organizationFrm','org',true);
	}
}

function switchOwner() {
	switchItem('ownerFrm',MassdocParamsForm.isowner[0].checked);
}

function switchAll() {
	var che = MassdocParamsForm.incAll[0].checked;
	var ches = MassdocParamsForm.incSAll[0].checked;
	var chep = MassdocParamsForm.incPAll[0].checked;
	switchStorageDocs(che || ches);
	switchPositionDocs(che || chep);
	MassdocParamsForm.incSAll[0].disabled = che;
	MassdocParamsForm.incPAll[0].disabled = che;
}

function switchStorageDocs(che) {
	MassdocParamsForm.incSExternal[0].disabled = che;
	MassdocParamsForm.incSInternal[0].disabled = che;
	MassdocParamsForm.incSInternalr[0].disabled = che;
	MassdocParamsForm.incSExternalr[0].disabled = che;
	MassdocParamsForm.incSInvact[0].disabled = che;
	MassdocParamsForm.incSAssactb[0].disabled = che;
	MassdocParamsForm.incSDassactb[0].disabled = che;
	MassdocParamsForm.incSPayoff[0].disabled = che;
	MassdocParamsForm.incSChange[0].disabled = che;
}

function switchPositionDocs(che) {
	MassdocParamsForm.incPAssact[0].disabled = che;
	MassdocParamsForm.incPDassact[0].disabled = che;
	MassdocParamsForm.incPAssactb[0].disabled = che;
	MassdocParamsForm.incPDassactb[0].disabled = che;
	MassdocParamsForm.incPInvact[0].disabled = che;
	MassdocParamsForm.incPChange[0].disabled = che;
}

</script>

<table class="main">
    
<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" rowspan="1"><bean:message key="label.masscalc.period"/></td>
	<td class="text" colspan="2">
		<bean:message key="label.datefrom"/> &nbsp;&nbsp;&nbsp; <july:date property="datefromFrm" size="25" insertable="true" updatable="true"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<bean:message key="label.dateto"/> &nbsp;&nbsp;&nbsp; <july:date property="datetoFrm" size="25" insertable="true" updatable="true"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title"><bean:message key="label.masscalc.owner"/></td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/>&nbsp;<bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   		<july:select collection="owners" property="ownerFrm" insertable="true" updatable="true">
			<html:options collection="owners" property="organization" labelProperty="name"/>
		</july:select>
		<script language="javascript">switchOwner();</script>
	</td>
</tr>
    
<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" rowspan="5"><bean:message key="label.masscalc.place"/></td>
	<td class="text">
		<july:radio styleClass="text" insertable="true" updatable="true" property="storagetype" value="0" onclick="switchFilter();"/><bean:message key="label.all"/>
	</td>
	<td class="text">&nbsp;</td>
</tr>
<tr>
	<td class="text">
		<july:radio styleClass="text" insertable="true" updatable="true" property="storagetype" value="1" onclick="switchFilter();"/><bean:message key="label.masscalc.position"/>
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
		<july:radio styleClass="text" insertable="true" updatable="true" property="storagetype" value="2" onclick="switchFilter();"/><bean:message key="label.masscalc.storage"/>
	</td>
	<td class="text">
   		<july:select collection="storages" property="storageFrm" insertable="true" updatable="true" style="width:400;">
			<html:options collection="storages" property="storageplace" labelProperty="name"/>
		</july:select>
	</td>
</tr>
<tr>
	<td class="text">
		<july:radio styleClass="text" insertable="true" updatable="true" property="storagetype" value="3" onclick="switchFilter();"/><bean:message key="label.masscalc.worker"/>
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
		<july:radio styleClass="text" insertable="true" updatable="true" property="storagetype" value="4" onclick="switchFilter();"/><bean:message key="label.masscalc.organization"/>
	</td>
	<td class="text">
		<july:string property="organizationFrm" styleId="organizationFrm" size="5" insertable="true" updatable="true"/>
		<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="organizationFrm;organizationname" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_orgl('?selisprovider=true&selisrenter=false&selissupplier=false');" />
		<july:string size="35" property="organizationname" styleId="organizationname" insertable="false" updatable="false" />
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title"><bean:message key="label.masscalc.incdocs"/></td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="incAll" onclick="switchAll();" />&nbsp;<bean:message key="label.all"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incSAll" onclick="switchStorageDocs(MassdocParamsForm.incSAll[0].checked);" />&nbsp;<bean:message key="label.masscalc.s.all"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incSInternal"/>&nbsp;<bean:message key="label.masscalc.s.internal"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incSExternal"/>&nbsp;<bean:message key="label.masscalc.s.external"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incSInternalr"/>&nbsp;<bean:message key="label.masscalc.s.internalr"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incSExternalr"/>&nbsp;<bean:message key="label.masscalc.s.externalr"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incSInvact"/>&nbsp;<bean:message key="label.masscalc.s.invact"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incSAssactb"/>&nbsp;<bean:message key="label.masscalc.s.assactb"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incSDassactb"/>&nbsp;<bean:message key="label.masscalc.s.dassactb"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incSPayoff"/>&nbsp;<bean:message key="label.masscalc.s.payoff"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incSChange"/>&nbsp;<bean:message key="label.masscalc.s.change"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incPAll" onclick="switchPositionDocs(MassdocParamsForm.incPAll[0].checked);"/>&nbsp;<bean:message key="label.masscalc.p.all"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incPAssact"/>&nbsp;<bean:message key="label.masscalc.p.assact"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incPDassact"/>&nbsp;<bean:message key="label.masscalc.p.dassact"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incPAssactb"/>&nbsp;<bean:message key="label.masscalc.p.assactb"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incPDassactb"/>&nbsp;<bean:message key="label.masscalc.p.dassactb"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incPInvact"/>&nbsp;<bean:message key="label.masscalc.p.invact"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" insertable="true" updatable="true" property="incPChange"/>&nbsp;<bean:message key="label.masscalc.p.change"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title"><bean:message key="label.masscalc.sortby"/></td>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="sorttype" value="1"/>&nbsp;<bean:message key="label.masscalc.sortby.date"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="sorttype" value="2"/>&nbsp;<bean:message key="label.masscalc.sortby.number"/>
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="sorttype" value="3"/>&nbsp;<bean:message key="label.masscalc.sortby.doctype"/>
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
switchOwner();
switchAll();
</script>

</table>

<input type="hidden" name="startnew" value="true">

</july:editform>

