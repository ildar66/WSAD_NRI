<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<% java.lang.String gColSpan = "2"; %>

<%
	String action = null;
	String form = null;
	String parent = null;
	String parentForm = null;
	String parent2 = null;
	String parentCaption = null;
	String temp = null;
	String parent2Form = null;
	int formState = ParamsParser.getState(pageContext);
	switch (formState) {
		case APPStates.ABONENT_PAYMENT_EDIT:
			action = "/ProcessAbonentPayment.do";
			form = "AbonentPaymentForm";
			parent2 = "/ShowAbonentPaymentsList.do";
			parent2Form = "AbonentPaymentsListForm";
			break;
	}
	if(form != null) {
		request.setAttribute("paymentFormName",form); 
	} else {
		request.setAttribute("paymentFormName","PaymentForm");
	}
%>
<july:editform action="<%= action %>" styleId="<%= form %>">

<% String isCertain = "true"; %>

<logic:equal name="<%= form %>" property="action" value="Add">
	<% isCertain = "false"; %>
</logic:equal>

<html:hidden property="leaseContractcode"/>
<html:hidden property="leaseDocPosition"/>
<html:hidden property="costcurrency2"/>
<html:hidden property="paymentType"/>
<html:hidden property="paymentstate"/>
<html:hidden property="calctype" value="-"/>
<html:hidden property="rur"/>
<html:hidden property="fromcalc"/>
<html:hidden property="usedinactcode"/>
<html:hidden property="stateOfContract"/>
<html:hidden property="calcNdsRate"/>

<html:hidden property="documentDateFrm"/>
<html:hidden property="positionName"/>

<%	String valueForEdit = "true", valueForEditOpenPeriod = "true", valueForEditFlagOplNds = "true"; %>

<logic:equal name="<%= form %>" property="action" value="Edit">
<%
	if (formState == APPStates.ABONENT_PAYMENT_EDIT) {
%>
	<logic:notEqual name="<%= form %>" property="paymentstate" value="G"><% valueForEdit = "false"; %></logic:notEqual>
	<logic:equal name="<%= form %>" property="stateOfContract" value="C"><% valueForEdit = "false"; valueForEditOpenPeriod = "false"; %></logic:equal>
	<logic:present name="<%= form %>" property="usedinactcode"><% valueForEdit = "false"; valueForEditOpenPeriod = "false"; valueForEditFlagOplNds = "false"; %></logic:present>
<%
	}
%>
</logic:equal>

<%
	request.setAttribute("valueForEdit", valueForEdit);
%>

<script language="javascript">
function fix(fixNumber, decimalPlaces) {
	var div = Math.pow(10, decimalPlaces);
	return fixNumber = Math.round(fixNumber * div) / div;
}

function calcSumRub() {
	<%= form %>.sumRubFrm.value = fix(<%= form %>.summFrm.value * <%= form %>.payrateFrm.value, 2);
}

function changeCalcRate() {
	if (document.all.currcb.value == document.all.rur.value) {
		if(document.all.trratecr)
			document.all.trratecr.style.display = "none";
	} else {
		if (<%= form %>.sumRubFrm.value == "") {
			if(document.all.trratecr)
				document.all.trratecr.style.display = "block";
		} else {
			if(document.all.trratecr)
				document.all.trratecr.style.display = "none";
		}
	}
}

function changeRur() {
	if (document.all.currcb.value == document.all.rur.value) {
		if (document.all.payrateFrm) {
			document.all.payrateFrm.className = 'editsmalldisabled';
			document.all.payrateFrm.disabled = true;
		}
		if (document.all.sumRubFrm) {
			document.all.sumRubFrm.className = 'editsmalldisabled';
			document.all.sumRubFrm.disabled = true;
		}
		if (document.all.ndsRubFrm) {
			document.all.ndsRubFrm.className = 'editsmalldisabled';
			document.all.ndsRubFrm.disabled = true;
		}
		if (document.all.ndsrubSubmit) {
			document.all.ndsrubSubmit.disabled = true;
		}
		if(document.all.ratedatecalcFrm_dt) {
			document.all.ratedatecalcFrm_dt.enabled = 'false';
		}
		if(document.all.payratedateSubmit) {
			document.all.payratedateSubmit.disabled = true;
		}
	} else {
		if (document.all.payrateFrm) {
			document.all.payrateFrm.className = 'editsmall';
			document.all.payrateFrm.disabled = false;
		}
		if (document.all.sumRubFrm) {
			document.all.sumRubFrm.className = 'editsmall';
			document.all.sumRubFrm.disabled = false;
		}
		if (document.all.ndsRubFrm) {
			document.all.ndsRubFrm.className = 'editsmall';
			document.all.ndsRubFrm.disabled = false;
		}
		if (document.all.ndsrubSubmit) {
			document.all.ndsrubSubmit.disabled  = false;
		}
		if(document.all.ratedatecalcFrm_dt) {
			document.all.ratedatecalcFrm_dt.enabled = 'true';
		}
		if(document.all.payratedateSubmit) {
			document.all.payratedateSubmit.disabled = false;
		}
	}
	changeCalcRate();
}

function updateSumnds() {
	var ndsRate;
    ndsRate = new Number(document.all.ndsRateFrm.value);
	document.all.sumndsFrm.value = 
		Math.round(	(document.all.summFrm.value * ndsRate) / (100.0 + ndsRate) * 100.0) / 100.0;
}
function updateRubNds() {
	var ndsRate;
    ndsRate = new Number(document.all.ndsRateFrm.value);
	if(document.all.sumRubFrm.value == '') {
		document.all.ndsRubFrm.value = '';
	} else {
		document.all.ndsRubFrm.value = 
			Math.round(	(document.all.sumRubFrm.value * ndsRate) / (100.0 + ndsRate) * 100.0) / 100.0;
	}
}
function updateRateNds() {
    updateSumnds();
	updateRubNds();
}

function ds(n) {
	n = n % 100;
	if(n < 10) {
		return ("0"+n);
	} else {
		return n;
	}
}
function shortDateString(dt) {
	var d = new Date((dt-25569)*86400000);
	return "" + ds(d.getDate()) + "." + ds(d.getMonth()+1) + "." + ds(d.getYear());
}
function createPayPurpose() {
	var da = document.all;

	document.all.payPurpose.value = '<bean:message key="label.paypurpose.payby"/>' + da.documentNumber.value + ' <bean:message key="label.paypurpose.ot"/> <july:datewrite name="<%=form%>" property="documentDate" shortformat="true"/>';
	if(da.billNumber.value != '') {
		document.all.payPurpose.value += ' по счёту №' + da.billNumber.value + ' от ' + shortDateString(getDate_billdate());
	}
	document.all.payPurpose.value += ' <bean:message key="label.paypurpose.za"/> ' + da.resourcecode.options[da.resourcecode.selectedIndex].text;
	document.all.payPurpose.value += ' <bean:message key="label.paypurpose.zaperiod"/> ' + shortDateString(getDate_bgdatefrm()) + ' <bean:message key="label.paypurpose.po"/> ' + shortDateString(getDate_eddatefrm());
	document.all.payPurpose.value += ' (<bean:message key="label.paypurpose.bs"/> ' + da.positionName.value + ')';
}
</script>

<table class="main">
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text">
		<july:reqmark><bean:message key="label.filter.docnumber"/>:</july:reqmark>
	</td>
	<td class="text"><july:string size="50" property="documentNumber" insertable="false" updatable="false"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.filter.docperiod"/>:</july:reqmark></td>
	<td class="text">
		<july:date property="startDateFrm" size="25" insertable="false" updatable="false"/>&nbsp;
		<bean:message key="label.filter.stop"/>&nbsp;
		<july:date property="endDateFrm" size="25" insertable="false" updatable="false"/>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text">
		<july:reqmark>
			<bean:message key="label.payments.customer"/>:
		</july:reqmark>
	</td>
	<td class="text"><july:string size="50" property="orgCustomerContract" insertable="false" updatable="false"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text">
		<july:reqmark>
			<bean:message key="label.payments.executor"/>:
		</july:reqmark>
	</td>
	<td class="text"><july:string size="50" property="orgExecutorContract" insertable="false" updatable="false"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.filter.costcurrency"/>:</july:reqmark></td>
	<td class="text">
		<july:string size="10" property="costcurrency1" insertable="false" updatable="false"/>&nbsp;
		<bean:write name="<%= form %>" property="curr1" filter="true"/>
		<% temp = ""; %>
		<logic:notEqual name="<%= form %>" property="costcurrency2" value="<%= temp %>">
			&nbsp;<july:string size="10" property="costcurrency2" insertable="false" updatable="false"/>
			&nbsp;<bean:write name="<%= form %>" property="curr2" filter="true"/>
		</logic:notEqual>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payments.state"/>:</july:reqmark></td>
	<td class="text">
		<logic:equal name="<%= form %>" property="paymentstate" value="G"><bean:message key="label.payments.state.edit"/></logic:equal>
		<logic:equal name="<%= form %>" property="paymentstate" value="P"><bean:message key="label.payments.state.p"/></logic:equal>
		<logic:equal name="<%= form %>" property="paymentstate" value="N"><bean:message key="label.payments.state.n"/></logic:equal>
		<logic:equal name="<%= form %>" property="paymentstate" value="K"><bean:message key="label.payments.state.k"/></logic:equal>
		<logic:equal name="<%= form %>" property="paymentstate" value="M"><bean:message key="label.payments.state.m"/></logic:equal>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><bean:message key="label.payments.number"/>:</td>
	<td class="text" nowrap>
		<% String docnumberValueUpdatable = valueForEdit, dateValueUpdatable = valueForEditOpenPeriod, requiredValue = isCertain, docnumberValueInsertable = "true", dateValueInsertable = "true"; %>
		<july:string size="25" property="docNumber" insertable="<%= docnumberValueInsertable %>" updatable="<%= docnumberValueUpdatable %>"/>&nbsp;
		<bean:message key="label.payments.date"/>:&nbsp;
		<july:date property="dateFrm" size="25" insertable="<%= dateValueInsertable %>" updatable="<%= dateValueUpdatable %>" required="<%= requiredValue %>"/>
	</td>
</tr>
<tr><td><a name="fromcalclabel"></td></tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payments.period"/>:</july:reqmark></td>
	<td class="text">
		<july:date property="begindateFrm" styleId="bgdatefrm" size="25" insertable="true" updatable="<%= valueForEditOpenPeriod %>" required="<%= isCertain %>"/>&nbsp;
		<bean:message key="label.filter.stop"/>&nbsp;
		<july:date property="enddateFrm" styleId="eddatefrm" size="25" insertable="true" updatable="<%= valueForEditOpenPeriod %>" required="<%= isCertain %>"/>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payments.resource"/>:</july:reqmark></td>
	<td class="text">
		<july:select style="width: 450;" collection="resources" property="resourcecode" insertable="true" updatable="<%= valueForEditOpenPeriod %>">
			<html:options collection="resources" property="resource" labelProperty="name"/>
		</july:select>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<!-- patch2 start -->
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payments.sum"/>:</july:reqmark></td>
	<td class="text" nowrap>
			<july:string size="10" property="summFrm" insertable="true" updatable="<%= valueForEdit %>" styleId="summFrm" onkeyup="updateSumnds();"/>&nbsp;
			<bean:message key="label.payments.stavkaNds"/>
			<july:string size="5" property="ndsRateFrm" insertable="true" updatable="<%= valueForEdit %>" onkeyup="updateRateNds();"/>&nbsp;
			<july:reqmark><bean:message key="label.payments.ndssum"/>:</july:reqmark>&nbsp;
			<july:string size="10" property="sumndsFrm" insertable="true" updatable="<%= valueForEdit %>"/>&nbsp;
			<july:select style="width: 150;" collection="currencies" property="currencycode" 
				insertable="true" updatable="<%= valueForEdit %>" onchange="changeRur()" styleId="currcb">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
	</td>
</tr>
<!-- patch2 continue -->
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><bean:message key="label.payments.payrate"/>:</td>
	<td class="text" nowrap>
		<july:string size="25" property="payrateFrm" insertable="true" updatable="<%= valueForEdit %>" styleId="payrateFrm"/>
		<html:hidden property="ratedateFrm"/>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><bean:message key="label.payments.sumrub"/>:</td>
	<td class="text" nowrap>
		<july:string size="25" property="sumRubFrm" insertable="true" onkeyup="changeCalcRate();updateRubNds();" updatable="<%= valueForEdit %>" styleId="sumRubFrm"/>
			<logic:notEqual name="<%= form %>" property="action" value="Delete">
				<logic:notEqual name="<%= form %>" property="action" value="View">
					<% if ("true".equals(valueForEdit)) { %>
						&nbsp;<img src="/images/obchet1.gif" name='sumrubButton' onclick='if (document.all.currcb.value != document.all.rur.value) { calcSumRub(); changeCalcRate(); updateRubNds(); }' border='0' alt='<bean:message key="label.filter.calcsumrub"/>'>
					<% } %>
				</logic:notEqual>
			</logic:notEqual>
			&nbsp;<bean:message key="label.payments.ndssumrub"/>
			&nbsp;<july:string size="25" property="ndsRubFrm" insertable="true" updatable="<%= valueForEdit %>" styleId="ndsRubFrm"/>
			&nbsp;Платеж НДС: <july:checkbox property="flagOplNds" insertable="true" updatable='<%=valueForEditFlagOplNds%>' styleId="flagOplNds"/>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>

<html:hidden property="actcode"/>

<july:formbuttons/>

<july:separator colspan="<%= gColSpan %>"/>

</table>

<logic:notEqual name="<%= form %>" property="action" value="View">
	<logic:notEqual name="<%= form %>" property="action" value="Delete">
		<script language="javascript">
			<%	if ("true".equals(valueForEdit)) { %>
				changeRur();
			<%	} %>
			if (document.all.fromcalc.value == 1) {
				document.all.fromcalc.value = 0;
				window.location.href = "#fromcalclabel";
			}
		</script>
	</logic:notEqual>
</logic:notEqual>

<html:hidden property="ratecalcrule" styleId="ratecalcrulesave"/>

</july:editform>

