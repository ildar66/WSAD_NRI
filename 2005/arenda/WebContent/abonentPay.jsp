<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<july:editform action="/ProcessAbonentPay.do" styleId="AbonentPayForm">

<html:hidden property="paypos"/>
<html:hidden property="recordstatus"/>
<html:hidden property="changeneedpay"/>
<html:hidden property="initialNeedpay"/>

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
		<july:sepmark/>
		<july:editlink page="/ViewAbonent.do" action="View" paramId="leaseDocument" paramName="AbonentPaysListForm" paramProperty="leaseDocument" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
		<july:sepmark/>
		<html:link page="/ShowAbonentPaysList.do" styleClass="navigator"><bean:message key="label.abonent.pays"/></html:link>
		<july:sepmark/>
		<july:actionname/>
	</td>
</tr>
--%>

<july:separator colspan="<%= gColSpan %>"/>
    
<tr>
	<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text" width="30%"><bean:message key="label.bans.ban"/>:</td>
	<td class="text">
		<bean:write name="AbonentForm" property="banFrm" filter="true"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><bean:message key="label.bens.list"/>:</td>
	<td class="text">
		<logic:equal name="AbonentForm" property="useallben" value="true"><bean:message key="label.bans.allben"/></logic:equal>
		<logic:equal name="AbonentForm" property="useallben" value="false"><bean:write name="AbonentForm" property="bensList" filter="true"/></logic:equal>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><bean:message key="label.bans.nri.orginn"/>:</td>
	<td class="text">
		<bean:write name="AbonentForm" property="orgCustomerInn" filter="true"/>&nbsp;
		<bean:message key="label.bans.nri.orgname"/>:&nbsp;
		<bean:write name="AbonentForm" property="orgCustomername" filter="true"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><bean:message key="label.bans.billing.orginn"/>:</td>
	<td class="text">
		<bean:write name="AbonentForm" property="bil_inn" filter="true"/>&nbsp;
		<bean:message key="label.bans.billing.orgname"/>:&nbsp;
		<bean:write name="AbonentForm" property="bil_name" filter="true"/>
	</td>
</tr>

<%-- Pay parameters --%>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><bean:message key="label.bans.pay.number"/>:</td>
	<td class="text">
		<july:string size="25" property="number" insertable="false" updatable="false"/>&nbsp;
		<bean:message key="label.bans.pay.date"/>&nbsp;
		<july:string size="10" property="dateFrm" insertable="false" updatable="false"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text">&nbsp;</td>
	<td class="text">
		<table class="main"><tr>
			<td><bean:message key="label.bans.pay.billusesum"/></td>
			<td><bean:message key="label.bans.pay.nriusesum"/></td>
			<td><bean:message key="label.bans.pay.unusesum"/></td>
		</tr></table>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.bans.pay.rursum"/>:</td>
	<td class="text">
		<july:string size="10" property="rursumFrm" insertable="false" updatable="false"/>&nbsp;
		<july:string size="10" property="nrirursumFrm" insertable="true" updatable="true" onkeyup="calculateSumms();"/>&nbsp;
		<july:string size="10" property="nriunrursumFrm" insertable="false" updatable="false"/>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.bans.pay.usdsum"/>:</td>
	<td class="text">
		<july:string size="10" property="usdsumFrm" insertable="false" updatable="false"/>&nbsp;
		<july:string size="10" property="nriusdsumFrm" insertable="true" updatable="true" onkeyup="calculatePieceSumms();"/>&nbsp;
		<july:string size="10" property="nriunusdsumFrm" insertable="false" updatable="false"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><bean:message key="label.abonent.pays.rate"/>:</td>
	<td class="text">
		<july:string size="25" property="rateFrm" insertable="false" updatable="false"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><bean:message key="label.bans.pay.resource"/>:</td>
	<td class="text">
   		<july:select collection="resources" property="resource" insertable="true" updatable="true">
			<html:option value="">&nbsp;</html:option>
			<html:options collection="resources" property="resource" labelProperty="name"/>
		</july:select>
	</td>
</tr>

<script language="javascript">
function switchHandsumm() {
	AbonentPayForm.nriusdsumFrm.disabled = true;
	AbonentPayForm.nriusdsumFrm.className = 'editsmalldisabled';
	if (AbonentPayForm.usenri[0].checked) {
		AbonentPayForm.nrirursumFrm.disabled = false;
		AbonentPayForm.nrirursumFrm.className = 'editsmall';
		if (AbonentPayForm.rursumFrm.value == "" || AbonentPayForm.usdsumFrm.value == "") {
			AbonentPayForm.nriusdsumFrm.disabled = false;
			AbonentPayForm.nriusdsumFrm.className = 'editsmall';
		}
	} else {
		AbonentPayForm.nrirursumFrm.disabled = true;
		AbonentPayForm.nrirursumFrm.className = 'editsmalldisabled';
		if (AbonentPayForm.rursumFrm.value == "" || AbonentPayForm.usdsumFrm.value == "") {
			AbonentPayForm.nriusdsumFrm.disabled = true;
			AbonentPayForm.nriusdsumFrm.className = 'editsmalldisabled';
		}
	}
}
/*function fix(fixNumber) {
	var ff = parseFloat(fixNumber);
	return ""+(Math.round(ff * 100.000000) / 100);
}*/
function fix(fixNumber, decimalPlaces) {
	var div = Math.pow(10, decimalPlaces);
	return fixNumber = Math.round(fixNumber * div) / div;
}
function calculateSumms() {
	if (AbonentPayForm.nrirursumFrm.value == "") {
		AbonentPayForm.nriusdsumFrm.value = "";
		AbonentPayForm.nriunusdsumFrm.value = "";
		AbonentPayForm.nriunrursumFrm.value = "";
		return;
	}
	AbonentPayForm.nriunrursumFrm.value = AbonentPayForm.rursumFrm.value - AbonentPayForm.nrirursumFrm.value;
	AbonentPayForm.nriunrursumFrm.value = fix(AbonentPayForm.nriunrursumFrm.value, 2);
	
	calculatePieceSumms();
}
function calculatePieceSumms() {
	if (parseFloat(AbonentPayForm.nrirursumFrm.value) > parseFloat(AbonentPayForm.rursumFrm.value)) {
		AbonentPayForm.nrirursumFrm.value = AbonentPayForm.rursumFrm.value;
		AbonentPayForm.nriusdsumFrm.value = AbonentPayForm.usdsumFrm.value;
	} else if (AbonentPayForm.nriusdsumFrm.disabled) {
		AbonentPayForm.nriusdsumFrm.value = AbonentPayForm.nrirursumFrm.value / AbonentPayForm.rateFrm.value;
		AbonentPayForm.nriusdsumFrm.value = fix(AbonentPayForm.nriusdsumFrm.value, 2);
	}
	if (AbonentPayForm.nriusdsumFrm.value != "") {
		
	}
	
	AbonentPayForm.nriunusdsumFrm.value = AbonentPayForm.usdsumFrm.value - AbonentPayForm.nriusdsumFrm.value;
	AbonentPayForm.nriunusdsumFrm.value = fix(AbonentPayForm.nriunusdsumFrm.value, 2);
}
</script>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><bean:message key="label.bans.pay.handsumm"/>:</td>
	<td class="text">
		<july:checkbox property="usenri" insertable="true" updatable="true" value="true" onclick="switchHandsumm();"/><html:hidden property="usenri" value="false"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><bean:message key="label.bans.pay.needpay"/>:</td>
	<td class="text">
		<july:checkbox property="needpay" insertable="true" updatable="true"/>&nbsp;
		<logic:equal name="AbonentPayForm" property="changeneedpay" value="A"><bean:message key="label.bans.pay.changeneedpay.auto"/></logic:equal>
		<logic:equal name="AbonentPayForm" property="changeneedpay" value="H"><bean:message key="label.bans.pay.changeneedpay.hand"/></logic:equal>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><bean:message key="label.bans.pay.recordstatus"/>:</td>
	<td class="text">
		<logic:equal name="AbonentPayForm" property="recordstatus" value="A"><bean:message key="label.bans.pay.recordstatus.active"/></logic:equal>
		<logic:equal name="AbonentPayForm" property="recordstatus" value="D"><bean:message key="label.bans.pay.recordstatus.deleted"/></logic:equal>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text">Назначение платежа:</td>
	<td class="text">
		<july:textarea property="payPurpose" insertable="false" updatable="false" />	
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<july:formbuttons/>

<july:separator colspan="<%= gColSpan %>"/>

</table>

<logic:notEqual name="AbonentPayForm" property="action" value="View">
	<logic:notEqual name="AbonentPayForm" property="action" value="Delete">
		<script language="javascript">
			switchHandsumm();
		</script>
	</logic:notEqual>
</logic:notEqual>

</july:editform>
