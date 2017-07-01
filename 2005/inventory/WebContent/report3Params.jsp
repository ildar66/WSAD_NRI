<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessReport3.do">

<% String gColSpan = "3"; %>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		Report3ParamsForm[itemname].className = 'editkoddisabled';
		Report3ParamsForm[itemname].disabled = true;
		Report3ParamsForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		Report3ParamsForm[itemname].className = 'editkod';
		Report3ParamsForm[itemname].disabled = false;
		Report3ParamsForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchItem(itemname,state) {
	if(state) {
		Report3ParamsForm[itemname].disabled = true;
		Report3ParamsForm[itemname].className = 'editdisabled';
	} else {
		Report3ParamsForm[itemname].disabled = false;
		Report3ParamsForm[itemname].className = 'edit';
	}
}

function switchRestype() {
	switchLookup('restypecode','rt',Report3ParamsForm.alltype[0].checked);
}

function switchRessbtype() {
	switchLookup('ressbtypecode','rst',Report3ParamsForm.allsbtype[0].checked);
}

function clearSupplyact() {
	Report3ParamsForm.supplyact.value='';
	Report3ParamsForm.supplynum.value='';
	Report3ParamsForm.supplyname.value='';

	return false;
}
</script>

<table class="main">
    
<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title"><bean:message key="label.report3.restype"/></td>
	<td class="text" nowrap colspan="2">
		<july:checkbox styleClass="text" property="alltype" insertable="true" updatable="true" value="true" onclick="switchRestype();"/><html:hidden property="alltype" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;
		<july:string property="restypecode" styleId="restypecode" size="5" insertable="true" updatable="true"  styleClass="editkod"/>
		<july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl" fieldNames="restypecode;restypename" newWindowName="restypelookup" insertable="true" updatable="true"/>
		<july:string size="25" property="restypename" styleId="restypename" insertable="false" updatable="false" />
	</td>
</tr>        

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title"><bean:message key="label.report3.ressbtype"/></td>
	<td class="text" nowrap colspan="2">
		<july:checkbox styleClass="text" property="allsbtype" insertable="true" updatable="true" value="true" onclick="switchRessbtype();"/><html:hidden property="allsbtype" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;
		<july:string property="ressbtypecode" styleId="ressbtypecode" size="5" insertable="true" updatable="true" styleClass="editkod" />
		<july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="rstl" fieldNames="ressbtypecode;ressbtypename" newWindowName="ressbtypelookup" onclick="set_opt_params_rstl('?resourcetype='+document.all.restypecode.value)" insertable="true" updatable="true"/>
		<july:string size="25" property="ressbtypename" styleId="ressbtypename" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" rowspan="3"><july:reqmark><bean:message key="label.report3.supply"/></july:reqmark></td>
	<td class="text"><bean:message key="label.report3.baseagreement"/></td>
	<td class="text">
   		<july:select collection="baseagreements" property="baseagreement" insertable="true" updatable="true">
			<option value="0">-- Не важно --</option>
			<html:options collection="baseagreements" property="baseagreement" labelProperty="name"/>
		</july:select>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="label.report3.supplyact"/></td>
	<td class="text">
		<july:string property="supplyact" style="display:none;visibility:hidden;" styleId="supplyact" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowContractLookupList.do" styleId="ctl" fieldNames="supplyact;supplynum;supplyname" insertable="true" updatable="true" newWindowName="contractLookup" onclick="set_opt_params_ctl('?allcontragent=true&owner=&allowner=true');"/>
		<july:string property="supplynum" styleId="supplynum" size="5" insertable="false" updatable="false" /> 
		<july:string size="25" property="supplyname" styleId="supplyname" insertable="false" updatable="false" />
		<input type="image" name="clearcontract" src="/images/clear.gif" alt="Очистить" onclick="return clearSupplyact();">
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="label.report3.account"/></td>
	<td class="text">
		<july:string size="25" property="account" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" rowspan="2"><bean:message key="label.report3.state"/></td>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="statetype" value="C"/><bean:message key="label.report3.currenttime"/>
	</td>
</tr>
<tr>
<%--
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="statetype" value="D"/><bean:message key="label.report3.givendate"/>&nbsp;&nbsp;&nbsp;<july:date property="stateDateFrm" size="25" insertable="true" updatable="true"/>
	</td>
--%>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" rowspan="3"><bean:message key="label.report3.searchon"/></td>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="searchon" value="1"/><bean:message key="label.report3.anywhere"/>
	</td>
</tr>
<tr>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="searchon" value="2"/><bean:message key="label.report3.onpositions"/>
	</td>
</tr>
<tr>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="searchon" value="3"/><bean:message key="label.report3.onstorages"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title">&nbsp;</td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="group"/>&nbsp;<bean:message key="label.report3.group"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title">&nbsp;</td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="showAgregated"/>&nbsp;<bean:message key="label.report3.showagregated"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title">&nbsp;</td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="showContract"/>&nbsp;<bean:message key="label.report3.showcontract"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title">&nbsp;</td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="showOnmap"/>&nbsp;<bean:message key="label.report3.showonmap"/>
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
switchRestype();
switchRessbtype();
Report3ParamsForm.showOnmap[0].disabled = true;
</script>

</table>

</july:editform>

