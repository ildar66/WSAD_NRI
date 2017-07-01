<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*" %>
<%@ page import="com.hps.july.arenda.*" %>
<%@ page import="com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	java.lang.String gColSpan = "2";

	String action = "/ProcessPayment.do";
	String form = "PaymentForm";
	int formState = ParamsParser.getState(pageContext);
	request.setAttribute("paymentFormName",form);
	PaymentForm formb = ((PaymentForm)pageContext.findAttribute(form));

	System.out.println("STATE:"+formState);
	System.out.println("PAYMENT FORM:"+formb);
	System.out.println("PAYMENT STATE:"+formb.getPaymentstate());
	System.out.println("NDSRATE EDIT:"+formb.isEditable("ndsRate"));
%>

<july:editform action="<%= action %>" styleId="<%= form %>">
<%
	String isCertain = "true";
	if("Add".equals(formb.getAction())) {
		isCertain = "false";
	}
%>
<html:hidden property="SYNCNRIPLATINARENDA"/>

<html:hidden property="leaseContractcode"/>
<html:hidden property="leaseDocPosition"/>
<html:hidden property="costcurrency2"/>
<html:hidden property="paymentType"/>
<html:hidden property="paymentstate"/>
<html:hidden property="calctype" value="-"/>
<html:hidden property="rur"/>
<html:hidden property="rurName"/>
<html:hidden property="fromcalc"/>
<html:hidden property="usedinactcode"/>
<html:hidden property="stateOfContract"/>
<html:hidden property="calcNdsRate"/>

<html:hidden property="documentDateFrm"/>
<html:hidden property="positionName"/>

<%
	String valueForEdit = "true";
	String valueForEditOpenPeriod = "true";
	String valueForEditFlagOplNds = "true";

	if("Edit".equals(formb.getAction())) {
		if(!"G".equals(formb.getPaymentstate())) {
			valueForEdit = "false";
		}
		if("C".equals(formb.getStateOfContract())) {
			valueForEdit = "false";
		}
		if(formb.getUsedinactcode() != null) {
			valueForEdit = "false";
			valueForEditOpenPeriod = "false";
			valueForEditFlagOplNds = "false";
		}
	}

	request.setAttribute("valueForEdit", valueForEdit);
%>

<%
	String docnumberValueUpdatable = valueForEdit;
	String dateValueUpdatable = valueForEditOpenPeriod;
	String requiredValue = isCertain;
	String docnumberValueInsertable = "true";
	String dateValueInsertable = "true";

	if(formb.getSYNCNRIPLATINARENDA() != null && "ok".equals(formb.getSYNCNRIPLATINARENDA())) {
		docnumberValueUpdatable = dateValueUpdatable = docnumberValueInsertable = dateValueInsertable = "false";
		requiredValue = "true";
	}
%>

<table class="main">
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text" nowrap><bean:message key="label.mainPosition"/></td>
	<td class="text">
		<bean:write name="<%=form%>" property="mainPosition" filter="true"/>
		<html:hidden property="mainPosition"/>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="label.filter.docnumber"/>:</td>
	<td class="text">
		<bean:write name="<%=form%>" property="documentNumber" filter="true"/>
		<html:hidden property="documentNumber"/>
	</td>
</tr>
<tr>
	<td class="text" nowrap><bean:message key="label.filter.docperiod"/>:</td>
	<td class="text">
		<july:datewrite name="<%=form%>" property="startDate"/>&nbsp;<bean:message key="label.filter.stop"/>&nbsp;<july:datewrite name="<%=form%>" property="endDate" />
		<html:hidden property="startDateFrm"/>
		<html:hidden property="endDateFrm"/>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="label.filter.customer"/>:</td>
	<td class="text">
		<bean:write name="<%=form%>" property="orgCustomerContract" filter="true"/>
		<html:hidden property="orgCustomerContract"/>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="label.filter.executor"/>:</td>
	<td class="text">
		<bean:write name="<%=form%>" property="orgExecutorContract" filter="true"/>
		<html:hidden property="orgExecutorContract"/>
	</td>
</tr>
<tr>
	<td class="text" nowrap><bean:message key="label.filter.costcurrency"/>:</td>
	<td class="text">
		<bean:write name="<%= form %>" property="costcurrency1" filter="true"/>&nbsp;<bean:write name="<%= form %>" property="curr1" filter="true"/>.
		<html:hidden property="costcurrency1"/><html:hidden property="curr1"/>
		<logic:present name="<%= form %>" property="costcurrency2">
		<logic:notEqual name="<%= form %>" property="costcurrency2" value='<%= "" %>'>
			<bean:write name="<%= form %>" property="costcurrency2" filter="true"/>&nbsp;<bean:write name="<%= form %>" property="curr2" filter="true"/>
			<html:hidden property="costcurrency2"/><html:hidden property="curr2"/>
		</logic:notEqual>
		</logic:present>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><bean:message key="label.payments.state"/>:</td>
	<td class="text">
		<logic:equal name="<%= form %>" property="paymentstate" value="G"><bean:message key="label.payments.state.edit"/></logic:equal>
		<logic:equal name="<%= form %>" property="paymentstate" value="P"><bean:message key="label.payments.state.p"/></logic:equal>
		<logic:equal name="<%= form %>" property="paymentstate" value="N"><bean:message key="label.payments.state.n"/></logic:equal>
		<logic:equal name="<%= form %>" property="paymentstate" value="K"><bean:message key="label.payments.state.k"/></logic:equal>
		<logic:equal name="<%= form %>" property="paymentstate" value="M"><bean:message key="label.payments.state.m"/></logic:equal>
		<logic:equal name="<%= form %>" property="paymentstate" value="V"><bean:message key="label.payments.state.v"/></logic:equal>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><bean:message key="label.payments.number"/>:</td>
	<td class="text" nowrap>
		<july:string size="25" property="docNumber" insertable='<%= docnumberValueInsertable %>' updatable='<%=formb.isEditableStr("docNumber")%>'/>&nbsp;
		<bean:message key="label.payments.date"/>:&nbsp;
		<july:date property="dateFrm" size="25" insertable="<%= dateValueInsertable %>" updatable='<%=formb.isEditableStr("date")%>' required="<%= requiredValue %>"/>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><bean:message key="label.payments.officememonumber"/>:</td>
	<td class="text">
		<july:string size="50" property="officememonumber" styleId="officememonumber" insertable="true" updatable="true"/>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payments.executor"/></july:reqmark>:</td>
	<td class="text">
		<html:hidden property="orgExecutorcodeFrm" styleId="orgExecutor"/>
		<july:string size="50" property="orgExecutorname" styleId="orgExecutorname" insertable="false" updatable="false"/>
		<%--july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="execl" fieldNames="orgExecutor;orgExecutorname;orgAcccode;orgAccname;bank;coraccount;bik" newWindowName="execlookup" insertable="true" updatable='<%=formb.isEditableStr("orgExecutor")%>'/--%>
		<% if(formb.isEditable("orgExecutor")) { %>
			<html:link page="/../dict/VendorSiteLookupList.do?formname=PaymentForm&fieldnames=orgExecutor||orgExecutorname||||orgAcccode|orgAccname|bank|coraccount|bik" onclick="window.open(this.href, 'VendorSitesLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник отделений">		
				<img src='/images/lookup.gif' border='0' alt='Справочник отделений'></html:link>		
			<input type="image" name="clearcontract" src="/images/clear.gif" alt="Очистить" onclick="document.all.orgExecutor.value='-1';document.all.orgExecutorname.value='';return false;">
		<% } %>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payments.executor.account"/></july:reqmark>:</td>
	<td class="text">
		<html:hidden property="orgAcccodeFrm" styleId="orgAcccode"/>
		<july:string size="50" property="orgAccname" styleId="orgAccname" insertable="false" updatable="false"/>
		<%--july:lookupbutton action="/ShowAccountLookupList.do" styleId="accl" fieldNames="orgAcccode;orgAccname;bank;bik;coraccount" onclick="set_opt_params_accl('?organization='+document.all.orgExecutor.value)" insertable="true" updatable='<%=formb.isEditableStr("orgAccount")%>' newWindowName="Account"/--%>
		<% if(formb.isEditable("orgAccount")) { %>
			<html:link page="/../dict/AccountsLookupList.do?formname=PaymentForm&fieldnames=orgAcccode|orgAccname|bank|bik|coraccount" onclick="window.open(this.href + '&idVendorSite='+document.all.orgExecutor.value , 'AccountsLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник счетов">		
				<img src='/images/lookup.gif' border='0' alt='Справочник счетов'></html:link>		
		<% } %>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="label.payments.executor.bank"/>:</td>
	<td class="text">
		<july:string size="50" property="bank" insertable="false" updatable="false"/>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="label.payments.executor.coraccount"/>:</td>
	<td class="text">
		<july:string size="50" property="coraccount" insertable="false" updatable="false"/>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="label.payments.executor.bik"/>:</td>
	<td class="text">
		<july:string size="50" property="bik" insertable="false" updatable="false"/>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payments.pptype.advpay"/>:</july:reqmark></td>
	<td class="text">
		<july:checkbox property="ppType" insertable="true" updatable='<%=formb.isEditableStr("ppType")%>' value="A" styleId="billType"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Платеж НДС: <july:checkbox property="flagOplNds" insertable="true" updatable='<%=valueForEditFlagOplNds%>' styleId="flagOplNds"/>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><bean:message key="label.payments.bill"/>:</td>
	<td class="text" nowrap>
		<july:string size="25" property="billNumber" insertable="true" updatable='<%=formb.isEditableStr("billNumber")%>' styleId="billnumber"/>&nbsp;<bean:message key="label.ot"/>:&nbsp;<july:date size="25" property="billDateFrm" insertable="true" updatable='<%=formb.isEditableStr("billDate")%>' styleId="billdate" required="false"/>
	</td>
</tr>
<%--
<logic:notEqual name='<%=form%>' property="action" value="Add">
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payments.isschetfact"/>:</july:reqmark></td>
	<td class="text">
		<july:checkbox property="isSchetFaktFrm" insertable="true" updatable='<%=formb.isEditableStr("isSchetFakt")%>'/>
	</td>
</tr>
</logic:notEqual>
<logic:equal name='<%=form%>' property="action" value="Add">
	<html:hidden property="isSchetFaktFrm" value="false"/>
</logic:equal>
--%>
<tr><td><a name="fromcalclabel"></td></tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payments.period"/>:</july:reqmark></td>
	<td class="text">
		<july:date property="begindateFrm" styleId="bgdatefrm" size="25" insertable="true" updatable='<%=formb.isEditableStr("begindate")%>' required="<%= isCertain %>"/>&nbsp;
		<bean:message key="label.filter.stop"/>&nbsp;
		<july:date property="enddateFrm" styleId="eddatefrm" size="25" insertable="true" updatable='<%=formb.isEditableStr("enddate")%>' required="<%= isCertain %>"/>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payments.resource"/>:</july:reqmark></td>
	<td class="text">
		<july:select style="width: 450;" collection="resources" property="resourcecode" insertable="true" updatable='<%=formb.isEditableStr("resource")%>'>
			<html:options collection="resources" property="resource" labelProperty="name"/>
		</july:select>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payments.sum"/>:</july:reqmark></td>
	<td class="text" nowrap>
		<july:string size="10" property="summFrm" insertable="true" updatable='<%=formb.isEditableStr("summ")%>' styleId="summFrm" onkeyup="updateSumnds();"/>&nbsp;
		<%-- кнопка расчёт суммы --%>
		<% if(!"Delete".equals(formb.getAction()) && !"View".equals(formb.getAction()) && formb.isEditable("summ")) { %>
			<input type='image' name='submit' value='1' src='/images/obchet1.gif' alt='<bean:message key="label.payments.calsSumm"/>' onclick='calctype.value = "CalcSumm";'>
		<% } %>
		<july:reqmark><bean:message key="label.payments.ndssum"/>:</july:reqmark>&nbsp;
		<july:string size="10" property="sumndsFrm" insertable="true" updatable='<%=formb.isEditableStr("sumnds")%>'/>&nbsp;
		<july:select style="width: 150;" collection="currencies" property="currencycode" insertable="true" updatable='<%=formb.isEditableStr("currencycode")%>' onchange="changeRur()" styleId="currcb">
			<html:option value="0">&nbsp;</html:option>
			<html:options collection="currencies" property="currency" labelProperty="name"/>
	   	</july:select>
		<br>
	</td>
</tr>
<tr>
	<td class="text"></td>
	<td class="text">
		<bean:message key="label.payments.stavkaNds"/> <july:string size="5" property="ndsRateFrm" insertable="true" updatable='<%=formb.isEditableStr("ndsRate")%>' onkeyup="updateRateNds();"/>
	</td>
</tr>
<logic:present name="<%= form %>" property="ratecalcrule">
	<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><bean:message key="label.filter.ratecalcrule"/>:</td>
	<td class="text" nowrap >
		<logic:equal name="<%= form %>" property="ratecalcrule" value="A"><bean:message key="label.filter.ratecalcrule.a"/></logic:equal>
		<logic:equal name="<%= form %>" property="ratecalcrule" value="B"><bean:message key="label.filter.ratecalcrule.b"/></logic:equal>
		<logic:equal name="<%= form %>" property="ratecalcrule" value="C"><bean:message key="label.filter.ratecalcrule.c"/></logic:equal>
		<logic:equal name="<%= form %>" property="ratecalcrule" value="D"><bean:message key="label.filter.ratecalcrule.d"/></logic:equal>
		<logic:equal name="<%= form %>" property="ratecalcrule" value="E"><bean:message key="label.filter.ratecalcrule.e"/></logic:equal>
		<logic:equal name="<%= form %>" property="ratecalcrule" value="F"><bean:message key="label.filter.ratecalcrule.f" arg0="<%= formb.getRatecalcruleday().toString() %>"/></logic:equal>
		<logic:equal name="<%= form %>" property="ratecalcrule" value="G"><bean:message key="label.filter.ratecalcrule.g" arg0="<%= formb.getRatecalcruleday().toString() %>"/></logic:equal>
		<logic:equal name="<%= form %>" property="ratecalcrule" value="H"><bean:message key="label.filter.ratecalcrule.h"/></logic:equal>
		<logic:equal name="<%= form %>" property="ratecalcrule" value="I"><bean:message key="label.filter.ratecalcrule.i"/></logic:equal>
<%	if(formb.getRatedelta() != null && formb.getRatedelta().doubleValue() != 0.0d) { %>
		&nbsp;<bean:message key="label.filter.ratedelta"/>: &nbsp; <bean:write name="<%= form %>" property="ratedelta" filter="true"/>
<%	} %>
	</td>
</tr>
	</logic:present>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text">Курс <bean:write name="<%=form%>" property="rurName"/> к валюте служебной записки:</td>
	<td class="text" nowrap>
		<july:string size="25" property="payrateFrm" insertable="true" onkeyup="changePayrate();" updatable='<%=formb.isEditableStr("payrate")%>' styleId="payrateFrm"/>
		<% if(!"Delete".equals(formb.getAction()) && !"View".equals(formb.getAction()) && formb.isEditable("payrate")) { %>
			&nbsp;<input type='image' name='payrateSubmit' value='3' src='/images/obchet1.gif' alt='<bean:message key="label.filter.calcrate"/>' onclick='calctype.value = "R";'>
			&nbsp;<july:date size="25" property="ratedatecalcFrm" styleId="ratedatecalcFrm" insertable="true" updatable="true"/>
			&nbsp;<input type='image' name='payratedateSubmit' value='4' src='/images/obchet1.gif' alt='<bean:message key="label.filter.calcrateondate"/>' onclick='calctype.value = "CD";'>
		<% } %>
<%--
		&nbsp;<bean:message key="label.payments.datepayrate"/>
		&nbsp;<july:date size="25" property="ratedateFrm" insertable="false" updatable="false"/>
--%>
	</td>
</tr>
<%-- if(!"Delete".equals(formb.getAction()) && !"View".equals(formb.getAction()) && formb.isEditable("payrate")) { %>
<tr>
	<td class="text"></td>
	<td class="text" nowrap>
		<july:date size="25" property="ratedatecalcFrm" styleId="ratedatecalcFrm" insertable="true" updatable="true"/>
		&nbsp;<input type='image' name='payratedateSubmit' value='4' src='/images/obchet1.gif' alt='<bean:message key="label.filter.calcrateondate"/>' onclick='calctype.value = "CD";'>
	</td>
</tr>
<% } --%>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text">Сумма в <bean:write name="<%=form%>" property="rurName"/>:</td>
	<td class="text" nowrap>
		<july:string size="25" property="sumRubFrm" insertable="true" onkeyup="changeCalcRate();updateRubNds();" updatable='<%=formb.isEditableStr("sumRub")%>' styleId="sumRubFrm"/>
		<% if(!"Delete".equals(formb.getAction()) && !"View".equals(formb.getAction()) && formb.isEditable("sumRub")) { %>
			&nbsp;<img src='/images/obchet1.gif' name='sumrubButton' onclick='if (document.all.currcb.value != document.all.rur.value) { calcSumRub(); changeCalcRate(); updateRubNds(); }' border='0' alt='Рассчитать сумму в <bean:write name="<%=form%>" property="rurName"/>'>
		<% } %>
		&nbsp; в т.ч. НДС в <bean:write name="<%=form%>" property="rurName"/>  
		&nbsp;<july:string size="25" property="ndsRubFrm" insertable="true" updatable='<%=formb.isEditableStr("ndsRub")%>' styleId="ndsRubFrm"/>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payments.paypurpose"/>:</july:reqmark></td>
	<td class="text">
		<july:textarea cols="50" rows="3" property="payPurpose" insertable="true" updatable='<%=formb.isEditableStr("payPurpose")%>'/>
		<% if (formb.isEditable("payPurpose")) { %>
			&nbsp;<img src='/images/obchet1.gif' name='createPaypurpose' onclick='createPayPurpose();' border='0' alt='Сформировать текст назначения платежа'>
		<% } %>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>

<html:hidden property="actcode"/>

<%-- platinum --%>
<% if(formb.getSYNCNRIPLATINARENDA() != null && "ok".equals(formb.getSYNCNRIPLATINARENDA())) { %>
	<jsp:include page="/paymentFormPlatinum.jsp" flush="true"></jsp:include>
	<july:separator colspan="<%= gColSpan %>"/>
<% } %>

<july:formbuttons/>
<july:separator colspan="<%= gColSpan %>"/>
</table>

<html:hidden property="ratecalcrule" styleId="ratecalcrulesave"/>

<script language="javascript">
function fix(fixNumber, decimalPlaces) {
	var div = Math.pow(10, decimalPlaces);
	var roundTo = new Number(10000);
	var multi = Math.round(fixNumber * div * roundTo) / roundTo;
	//alert("multi="+multi);
	return fixNumber = Math.round(multi) / div;
}

function calcSumRub() {
	var payrate = coma_replace(document.all.payrateFrm.value, '.');
	var summ = coma_replace(document.all.summFrm.value, '.');
	if((payrate != '')&&(summ != '')) 
		<%= form %>.sumRubFrm.value = fix(summ * payrate, 2);
	else
		<%= form %>.sumRubFrm.value = '';
	//alert("payrate: "+payrate);
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
		<%= form %>.payrateFrm.className = 'editsmalldisabled';
		<%= form %>.payrateFrm.disabled = true;
		<% if (formState == APPStates.PAYMENT_EDIT || formState == APPStates.HISTORY_PAYMENT_EDIT) { %>
			if (document.all.payrateSubmit)
				document.all.payrateSubmit.disabled = true;
		<% } %>
		<%= form %>.sumRubFrm.className = 'editsmalldisabled';
		<%= form %>.sumRubFrm.disabled = true;
		<%= form %>.ndsRubFrm.className = 'editsmalldisabled';
		<%= form %>.ndsRubFrm.disabled = true;
		if (document.all.ndsrubSubmit)
			document.all.ndsrubSubmit.disabled = true;
		if(document.all.ratedatecalcFrm_dt)
			document.all.ratedatecalcFrm_dt.enabled = 'false';
		if(document.all.payratedateSubmit)
                   document.all.payratedateSubmit.disabled = true;
	} else {
		<%= form %>.payrateFrm.className = 'editsmall';
		<%= form %>.payrateFrm.disabled = false;
		<% if (formState == APPStates.PAYMENT_EDIT || formState == APPStates.HISTORY_PAYMENT_EDIT) { %>
			if (document.all.payrateSubmit)
				document.all.payrateSubmit.disabled  = false;
		<% } %>
		<%= form %>.sumRubFrm.className = 'editsmall';
		<%= form %>.sumRubFrm.disabled = false;
		<%= form %>.ndsRubFrm.className = 'editsmall';
		<%= form %>.ndsRubFrm.disabled = false;
		if (document.all.ndsrubSubmit)
			document.all.ndsrubSubmit.disabled  = false;
		if(document.all.ratedatecalcFrm_dt)
			document.all.ratedatecalcFrm_dt.enabled = 'true';
		if(document.all.payratedateSubmit)
            document.all.payratedateSubmit.disabled = false;
	}
	changeCalcRate();
}

function updateSumnds() {
	var ndsRate = new Number(coma_replace(document.all.ndsRateFrm.value, '.'));
    var sum = coma_replace(document.all.summFrm.value, '.');
	document.all.sumndsFrm.value = Math.round((sum * ndsRate) / (100.0 + ndsRate) * 100.0) / 100.0;
	changePayrate();
}
function updateRubNds() {
	var ndsRate = new Number(coma_replace(document.all.ndsRateFrm.value, '.'));
    var sumRub = coma_replace(document.all.sumRubFrm.value, '.');
	if(document.all.sumRubFrm.value == '') {
		document.all.ndsRubFrm.value = '';
	} else {
		document.all.ndsRubFrm.value = 
			Math.round(	(sumRub * ndsRate) / (100.0 + ndsRate) * 100.0) / 100.0;
	}
}
function updateRateNds() {
    updateSumnds();
	updateRubNds();
}
function ds(n) { n = n % 100; return (n > 9)?n:"0"+n; }
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
	document.all.payPurpose.value += ' (<bean:message key="label.paypurpose.bs"/> ' + da.mainPosition.value + ')';
}
function coma_replace(n, dd)
{
	var a = n.toString().split(',');
	if(a[1] == null)
		return a[0]; 
	else 
		return (a[0] + dd + a[1]);
}
function changePayrate(){
	if (document.all.currcb.value != document.all.rur.value) {
		calcSumRub();
		changeCalcRate();
		updateRubNds();
	}
}
</script>

<logic:notEqual name="<%= form %>" property="action" value="View">
<logic:notEqual name="<%= form %>" property="action" value="Delete">
<script language="javascript">
	<%	if (formb.isEditable("currencycode")) { %>
		changeRur();
	<%	} %>
	if (document.all.fromcalc.value == 1) {
		document.all.fromcalc.value = 0;
		window.location.href = "#fromcalclabel";
	}
</script>
</logic:notEqual>
</logic:notEqual>

</july:editform>

