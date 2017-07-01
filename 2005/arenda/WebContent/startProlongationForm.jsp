<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.formbean.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "2"; %>

<%
	String action = null;
	String form = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.START_PROLONGATION_FORM:
        	action = "/ProcessStartProlongation.do";
			form = "StartProlongationForm";
//			parent = "/ShowStartProlongationsList.do";
        	break;
		case APPStates.START_CHARGE_FORM:
        	action = "/ProcessStartCharge.do";
			form = "StartChargeForm";
//			parent = "/ShowStartChargesList.do";
        	break;
		case APPStates.START_PAYMENT_FORM:
        	action = "/ProcessStartPayment.do";
			form = "StartPaymentForm";
//			parent = "/ShowStartPaymentsList.do";
        	break;
    }
%>

<july:editform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="isEconomistRole"/>
<html:hidden property="operator"/>

<script language='javascript'>
function switchCondition() {
	if (document.all.condition1.checked) {
		<%= form %>.leaseDocumentcode.className = 'editkoddisabled';
		<%= form %>.leaseDocumentcode.disabled = true;
		<%= form %>.economist.className = 'editkoddisabled';
		<%= form %>.economist.disabled = true;
		document.all['lookupimg_economistl'].src='/images/lookup_disabled.gif';
		document.all['lookupimg_conl'].src='/images/lookup_disabled.gif';
	} else if (document.all.condition2.checked) {
		<%= form %>.leaseDocumentcode.className = 'editkoddisabled';
		<%= form %>.leaseDocumentcode.disabled = true;
		<%= form %>.economist.className = 'editkod';
		<%= form %>.economist.disabled = false;
		document.all['lookupimg_economistl'].src='/images/lookup.gif';
		document.all['lookupimg_conl'].src='/images/lookup_disabled.gif';
	} else if (document.all.condition3.checked) {
		<%= form %>.leaseDocumentcode.className = 'editkod';
		<%= form %>.leaseDocumentcode.disabled = false;
		<%= form %>.economist.className = 'editkoddisabled';
		<%= form %>.economist.disabled = true;
		document.all['lookupimg_economistl'].src='/images/lookup_disabled.gif';
		document.all['lookupimg_conl'].src='/images/lookup.gif';
	}
}
</script>

<table class="main">

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text" wrap>
		<july:reqmark>
			<%	if (ParamsParser.getState(pageContext) == APPStates.START_PROLONGATION_FORM) { %>
					<bean:message key="label.autoproc.prolongation.date"/>:
				<%	} if (ParamsParser.getState(pageContext) == APPStates.START_CHARGE_FORM) { %>
					<bean:message key="label.autoproc.charges.date"/>:
				<%	} if (ParamsParser.getState(pageContext) == APPStates.START_PAYMENT_FORM) { %>
					<bean:message key="label.autoproc.payments.date"/>:
				<%	} %>
			</july:reqmark>
		</td>
		<td class="text">
			<table border=0 class="main">
				<tr>
<%--
					<%	if (ParamsParser.getState(pageContext) == APPStates.START_PROLONGATION_FORM ||
						ParamsParser.getState(pageContext) == APPStates.START_PAYMENT_FORM) { %>
						<td><july:date property="date1Frm" size="25" insertable="true" updatable="true"/></td>
					<% } %>
					<td><bean:message key="label.filter.stop"/></td>
--%>
					<td><july:date property="date2Frm" size="25" insertable="true" updatable="true"/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.autoproc.prolongation.condition"/>:</july:reqmark></td>
		<td class="text">
			<% String temp = "false"; %>
			<july:canedit rolesProperty="editRoles"><% temp = "true"; %></july:canedit>
			<july:radio styleId="condition1" property="condition" insertable="<%= temp %>" updatable="<%= temp %>" value="A" onclick="switchCondition()"/>
			<bean:message key="label.autoproc.prolongation.condition.all"/><br>
			<july:radio styleId="condition2" property="condition" insertable="true" updatable="true" value="E" onclick="switchCondition()"/>
			<bean:message key="label.autoproc.prolongation.condition.economist"/><br>
			<july:radio styleId="condition3" property="condition" insertable="true" updatable="true" value="C" onclick="switchCondition()"/>
			<bean:message key="label.autoproc.prolongation.condition.contract"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.filter.economist"/>:</td>
		<td class="text" nowrap>
			<july:string property="economistcodeFrm" styleId="economist" size="5" insertable="true" updatable="true"/>
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="economistl" fieldNames="economist;economistname" newWindowName="economistlookup" insertable="true" updatable="true" onclick="if (!document.all.condition2.checked) { return false; }"/>
			<july:string size="50" property="economistname" styleId="economistname" insertable="false" updatable="false"/>
		</td>
	</tr>	
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.autoproc.prolongation.dogovor"/>:</td>
		<td class="text" nowrap>
			<july:string property="leaseDocumentcodeFrm" styleId="leaseDocumentcode" size="5" insertable="true" updatable="true"/>
			<july:lookupbutton action="/ShowContractLookupList.do?isOnlyWe=true" styleId="conl" fieldNames="leaseDocumentcode;documentNumber;documentDateFrm" insertable="true" updatable="true" onclick="if (!document.all.condition3.checked) { return false; }"/>
		</td>
	</tr>
	
	<tr>
		<td class="text"><bean:message key="label.filter.docnumber"/>:</td>
		<td class="text"><july:string size="50" property="documentNumber" styleId="documentNumber" insertable="false" updatable="false"/></td>
	</tr>
	
	<tr>
		<td class="text"><bean:message key="label.filter.docdate"/>:</td>
		<td class="text"><july:date property="documentDateFrm" size="25" insertable="false" updatable="false"/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

<script language='javascript'>
	if (document.all.condition1.disabled && document.all.condition1.checked) document.all.condition2.checked = true;
	switchCondition();
</script>
	
</july:editform>
