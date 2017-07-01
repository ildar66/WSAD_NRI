<%@ page language = "java" %> 
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessPlatinumDogovorForm.do">

<html:hidden property="leasedocument"/>
<html:hidden property="flagsync"/>
<html:hidden property="vendor_length"/>

<% java.lang.String gColSpan = "2"; %>

<script language="javascript">
function switchBudjet() {
	document.all.direct.value = document.all.budjet.value;
	document.all.project.value = document.all.budjet.value;
}
function switchItem() {
	document.all.expense.value = document.all.zatrata.value;
	document.all.subexpense.value = document.all.zatrata.value;
}
function checkVendorCode() {
	if(document.all.vendor.value.length > document.all.vendor_length.value) {
		alert("Длина кода договора в Platinum не может превышать "+document.all.vendor_length.value+" символов!\nИсправьте значение.");
		return false;
	} else {
		return true;
	}
}
</script>

<table class="main">

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text" colspan="<%= gColSpan %>"><bean:message key="label.platinum.parmbasedogovor"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.filter.docnumber"/>:</td>
	<td class="text"><july:string size="50" property="documentNumber" insertable="false" updatable="false"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.filter.docdate"/>:</td>
	<td class="text"><july:date property="documentDateFrm" size="25" insertable="false" updatable="false"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.filter.customer"/>:</td>
	<td class="text"><july:string size="50" property="orgCustomername" insertable="false" updatable="false"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.filter.executor.arenda"/>:</td>
	<td class="text"><july:string size="50" property="orgExecutorname" styleId="orgExecutorname" insertable="false" updatable="false"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.filter.costcurrency1"/>:</td>
	<td class="text">
		<july:string size="25" property="summ1Frm" insertable="false" updatable="false"/>&nbsp;
		<july:string size="25" property="currencyname1" insertable="false" updatable="false"/>		 
	</td>
</tr>

<logic:present name="PlatinumDogovorForm" property="summ2">
<tr>
	<td class="text"><bean:message key="label.filter.costcurrency2"/>:</td>
	<td class="text">
		<july:string size="25" property="summ2Frm" insertable="false" updatable="false" styleId="summ2"/>&nbsp;
		<july:string size="25" property="currencyname2" insertable="false" updatable="false"/>		 
	</td>
</tr>
</logic:present>

<tr>
	<td class="text"><bean:message key="label.filter.docperiod"/>:</td>
	<td>
		<table border=0 class="main">
			<tr>
				<td><july:date property="startDateFrm" size="25" insertable="false" updatable="false"/></td>
				<td><bean:message key="label.filter.stop"/></td>
				<td><july:date property="endDateFrm" size="25" insertable="false" updatable="false"/></td>
			</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.platinum.dogovorcode"/></july:reqmark>:</td>
	<td class="text"><july:string property="vendor" size="40" insertable="true" updatable="true"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.platinum.budjetcode"/>:</td>
	<td class="text">
		<july:select styleId="budjet" styleClass="editbig" collection="ourBudjets" property="idbudjet" insertable="true" updatable="true" onchange="switchBudjet()">
			<html:option value="">&nbsp;</html:option>
			<html:options collection="ourBudjets" property="idbudjetnri" labelProperty="namebudjet"/>
		</july:select>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.platinum.directcode"/>:</td>
	<td class="text">
		<july:select styleId="direct" styleClass="editbig" collection="ourBudjets" property="iddirect" insertable="false" updatable="false">
			<html:options collection="ourBudjets" property="idbudjetnri" labelProperty="namedirect"/>
		</july:select>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.platinum.projectcode"/>:</td>
	<td class="text">
		<july:select styleId="project" styleClass="editbig" collection="ourBudjets" property="idproject" insertable="false" updatable="false">
			<html:options collection="ourBudjets" property="idbudjetnri" labelProperty="nameproject"/>
		</july:select>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.platinum.zatrata"/>:</td>
	<td class="text">
		<july:select styleId="zatrata" styleClass="editbig" collection="ourExpences" property="idexpense" insertable="true" updatable="true" onchange="switchItem()">
			<html:option value="">&nbsp;</html:option>
			<html:options collection="ourExpences" property="idexpencenri" labelProperty="nameitem"/>
		</july:select>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.platinum.expensecode"/>:</td>
	<td class="text">
		<july:select styleId="expense" styleClass="editbig" collection="ourExpences" property="iditem" insertable="false" updatable="false">
			<html:options collection="ourExpences" property="idexpencenri" labelProperty="nameexpence"/>
		</july:select>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.platinum.subexpensecode"/>:</td>
	<td class="text">
		<july:select styleId="subexpense" styleClass="editbig" collection="ourExpences" property="idsubexpence" insertable="false" updatable="false">
			<html:options collection="ourExpences" property="idexpencenri" labelProperty="namegrpexpence"/>
		</july:select>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.platinum.datenritoplatinum"/>:</td>
	<td class="text"><july:string size="25" property="datenritoplatinumFrm" insertable="false" updatable="false"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.platinum.dateplatinum"/>:</td>
	<td class="text"><july:string size="25" property="dateplatinumFrm" insertable="false" updatable="false"/></td>
</tr>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.platinum.flagsync"/>:</july:reqmark></td>
	<td class="text">
		<logic:present name="PlatinumDogovorForm" property="flagsync">
			<logic:equal name="PlatinumDogovorForm" property="flagsync" value="0"><bean:message key="label.platinum.flagsync.document.a"/></logic:equal>
			<logic:equal name="PlatinumDogovorForm" property="flagsync" value="1"><bean:message key="label.platinum.flagsync.b"/></logic:equal>
			<logic:equal name="PlatinumDogovorForm" property="flagsync" value="2"><bean:message key="label.platinum.flagsync.c"/></logic:equal>
			<logic:equal name="PlatinumDogovorForm" property="flagsync" value="3"><bean:message key="label.platinum.flagsync.d"/></logic:equal>
		</logic:present>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="title">
	<td colspan="2">
		<input TYPE="IMAGE" NAME="submit" SRC="/images/save.gif"  ALT="Сохранить" onclick="if(!checkVendorCode()) { return false; } document.body.style.cursor='wait';if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; } else { document.forms(0).elements('wasposted').value=1; } ">&nbsp;<A ID="ResetButton" HREF='#'><IMG SRC="/images/restore.gif" onclick="document.forms(0).reset()" ALT="Отменить правку" border=0></A>&nbsp;<july:backbutton/>
	</td>
</tr>

<%--july:formbuttons/--%>

<july:separator colspan="<%= gColSpan %>"/>

</table>

<script language='javascript'>
	switchBudjet();
	switchItem();
</script>

</july:editform>
