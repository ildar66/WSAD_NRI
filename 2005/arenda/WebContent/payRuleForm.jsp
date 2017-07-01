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
	String parent2 = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext))
	{
	case APPStates.PAY_RULE_EDIT:
		action = "/ProcessPayRule.do";
		form = "PayRuleForm";
		parent = "/ViewWeArenda.do";
		parent2 = "/ShowPayRulesList.do";
		break;
	case APPStates.HISTORY_PAY_RULE_EDIT:
		action = "/ProcessHistoryPayRule.do";
		form = "HistoryPayRuleForm";
		parent = "/ViewHistory.do";
		parent2 = "/ShowHistoryPayRulesList.do";
		break;
	}
%>

<july:editform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="leaseDocumentcode"/>
<html:hidden property="leaseRule"/>
<html:hidden property="rateCalcRule"/>
<html:hidden property="rateCalcRuleDay"/>

<script language="javascript">
function switchPayType() {
	if (document.all.payOrder.checked) {
		<%= form %>.orgToPayCode.className = 'editkod';
		<%= form %>.orgToPayCode.disabled = false;
		document.all['lookupimg_execl'].src='/images/lookup.gif';
		<%= form %>.orgAcccode.className = 'editkod';
		<%= form %>.orgAcccode.disabled = false;
		document.all['lookupimg_accl'].src='/images/lookup.gif';
		<%= form %>.advpay.disabled = false;
		<%= form %>.account.disabled = false;
		<%= form %>.endperiod.disabled = false;
		//<%= form %>.month.disabled = false;
		//<%= form %>.quarter.disabled = false;
		//<%= form %>.year.disabled = false;
		<%= form %>.payPurpose.className = 'editbigest';
		<%= form %>.payPurpose.disabled = false;
		switchPpType(true);
	} else {
		<%= form %>.orgToPayCode.className = 'editkoddisabled';
		<%= form %>.orgToPayCode.disabled = true;
		document.all['lookupimg_execl'].src='/images/lookup_disabled.gif';
		<%= form %>.orgAcccode.className = 'editkoddisabled';
		<%= form %>.orgAcccode.disabled = true;
		document.all['lookupimg_accl'].src='/images/lookup_disabled.gif';
		<%= form %>.advpay.disabled = true;
		<%= form %>.account.disabled = true;
		<%= form %>.endperiod.disabled = true;
		//<%= form %>.month.disabled = true;
		//<%= form %>.quarter.disabled = true;
		//<%= form %>.year.disabled = true;
		<%= form %>.paybeforedate_a.className = 'editdisabled';
		<%= form %>.paybeforedate_a.disabled = true;
		<%= form %>.paybeforedate_b.className = 'editdisabled';
		<%= form %>.paybeforedate_b.disabled = true;
		<%= form %>.paybeforedate_c.className = 'editdisabled';
		<%= form %>.paybeforedate_c.disabled = true;
		<%= form %>.payPurpose.className = 'editbigestdisabled';
		<%= form %>.payPurpose.disabled = true;
	}
	if(document.all.vz.checked) {
		<%= form %>.separateNdsPay[0].disabled = true;
		<%= form %>.separateNdsPay[0].enabled = true;
	}
	else {
		<%= form %>.separateNdsPay[0].disabled = false;
		<%= form %>.separateNdsPay[0].enabled = false;
	}
}
function switchPpType(isInitial) {
	if (document.all.advpay.checked) {
		<%= form %>.paybeforedate_a.className = 'edit';
		<%= form %>.paybeforedate_a.disabled = false;
		<%= form %>.paybeforedate_b.className = 'editdisabled';
		<%= form %>.paybeforedate_b.disabled = true;
		<%= form %>.paybeforedate_c.className = 'editdisabled';
		<%= form %>.paybeforedate_c.disabled = true;
	} else if (document.all.account.checked) {
		<%= form %>.paybeforedate_a.className = 'editdisabled';
		<%= form %>.paybeforedate_a.disabled = true;
		<%= form %>.paybeforedate_b.className = 'edit';
		<%= form %>.paybeforedate_b.disabled = false;
		<%= form %>.paybeforedate_c.className = 'editdisabled';
		<%= form %>.paybeforedate_c.disabled = true;
	} else if (document.all.endperiod.checked) {
		<%= form %>.paybeforedate_a.className = 'editdisabled';
		<%= form %>.paybeforedate_a.disabled = true;
		<%= form %>.paybeforedate_b.className = 'editdisabled';
		<%= form %>.paybeforedate_b.disabled = true;
		<%= form %>.paybeforedate_c.className = 'edit';
		<%= form %>.paybeforedate_c.disabled = false;
	}
	if (isInitial) {
		showCertain();
	}
}
function showCertain() {
	if (document.all.advpay.checked) {
		<%= form %>.paybeforedate_b.value = '';
		<%= form %>.paybeforedate_c.value = '';
 	} else if (document.all.account.checked) {
		<%= form %>.paybeforedate_a.value = '';
		<%= form %>.paybeforedate_c.value = '';
	} else if (document.all.endperiod.checked) {
		<%= form %>.paybeforedate_a.value = '';
		<%= form %>.paybeforedate_b.value = '';
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
		<td class="text"><july:reqmark><bean:message key="label.filter.docnumber"/>:</july:reqmark></td>
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
		<td class="text"><july:reqmark><bean:message key="label.filter.customer"/>:</july:reqmark></td>
		<td class="text"><july:string size="50" property="orgCustomer" insertable="false" updatable="false"/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.filter.executor"/>:</july:reqmark></td>
		<td class="text"><july:string size="50" property="orgExecutor" insertable="false" updatable="false"/></td>
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
	
	<logic:present name="<%= form %>" property="rateCalcRule">
	
		<tr>
			<td class="text"><july:reqmark><bean:message key="label.payrules.paydaterule"/>:</july:reqmark></td>
			<td class="text">
				<logic:equal name="<%= form %>" property="rateCalcRule" value="A"><bean:message key="label.filter.ratecalcrule.a"/></logic:equal>
				<logic:equal name="<%= form %>" property="rateCalcRule" value="B"><bean:message key="label.filter.ratecalcrule.b"/></logic:equal>
				<logic:equal name="<%= form %>" property="rateCalcRule" value="C"><bean:message key="label.filter.ratecalcrule.c"/></logic:equal>
				<logic:equal name="<%= form %>" property="rateCalcRule" value="D"><bean:message key="label.filter.ratecalcrule.d"/></logic:equal>
				<logic:equal name="<%= form %>" property="rateCalcRule" value="E"><bean:message key="label.filter.ratecalcrule.e"/></logic:equal>
				
				<%	PayRuleForm formBean = ((PayRuleForm) request.getAttribute(form)); %>
				<logic:equal name="<%= form %>" property="rateCalcRule" value="F">
					<bean:message key="label.filter.ratecalcrule.f" arg0="<%= formBean.getRateCalcRuleDay().toString() %>"/>
				</logic:equal>
				<logic:equal name="<%= form %>" property="rateCalcRule" value="G">
					<bean:message key="label.filter.ratecalcrule.g" arg0="<%= formBean.getRateCalcRuleDay().toString() %>"/>
				</logic:equal>
				
				<logic:equal name="<%= form %>" property="rateCalcRule" value="H"><bean:message key="label.filter.ratecalcrule.h"/></logic:equal>
				<logic:equal name="<%= form %>" property="rateCalcRule" value="I"><bean:message key="label.filter.ratecalcrule.i"/></logic:equal>
			</td>
		</tr>
		
		<july:separator colspan="<%= gColSpan %>"/>
		
		<tr>
			<td class="text"><july:reqmark><bean:message key="label.filter.ratedelta"/>:</july:reqmark></td>
			<td class="text"><july:string size="25" property="rateDeltaFrm" insertable="false" updatable="false"/></td>
		</tr>
		
		<july:separator colspan="<%= gColSpan %>"/>
		
	</logic:present>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.payrules.paytype"/>:</july:reqmark></td>
		<td class="text">
			<july:radio property="payType" insertable="true" updatable="true" value="P" styleId="payOrder" onclick="switchPayType();"/><bean:message key="label.payrules.paytype.payorder"/><br>
			<july:radio property="payType" insertable="true" updatable="true" value="M" styleId="vz" onclick="switchPayType();"/><bean:message key="label.payrules.paytype.vz"/><br>
			<july:radio property="payType" insertable="true" updatable="true" value="B" onclick="switchPayType();"/><bean:message key="label.payrules.paytype.acseptNo"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><bean:message key="label.payrules.separateNdsPay"/>:</td>
		<td class="text"><july:checkbox property="separateNdsPay" styleId="separateNdsPay" insertable="true" updatable="true"/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.payrules.orgtopay"/>:</td>
		<td class="text">
			<html:hidden property="orgToPaycodeFrm" styleId="orgToPayCode"/>
<%--			<july:string property="orgToPaycodeFrm" styleId="orgToPayCode" size="5" insertable="true" updatable="true"/> --%>
			<july:string size="50" property="orgToPayName" styleId="orgToPayName" insertable="false" updatable="false"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="execl" fieldNames="orgToPayCode;orgToPayName;orgAcccode;orgAccname;bank;coraccount;bik" insertable="true" updatable="true" newWindowName="Organization" onclick="if (!document.all.payOrder.checked) { return false; }"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.payrules.account"/>:</td>
		<td class="text">
			<html:hidden property="orgAcccodeFrm" styleId="orgAcccode"/>
<%--			<july:string property="orgAcccodeFrm" styleId="orgAcccode" size="5" insertable="true" updatable="true"/> --%>
			<july:string size="50" property="orgAccname" styleId="orgAccname" insertable="false" updatable="false"/>
			<july:lookupbutton action="/ShowAccountLookupList.do" styleId="accl" fieldNames="orgAcccode;orgAccname;bank;bik;coraccount" onclick="if (!document.all.payOrder.checked) { return false; } else { set_opt_params_accl('?organization='+document.all.orgToPayCode.value); }" insertable="true" updatable="true" newWindowName="Account"/>
		</td> 
	</tr>

	<tr>
		<td class="text"><bean:message key="label.payments.executor.bank"/>:</td>
		<td class="text"><july:string size="50" property="bank" insertable="false" updatable="false"/></td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.payments.executor.coraccount"/>:</td>
		<td class="text"><july:string size="50" property="coraccount" insertable="false" updatable="false"/></td>
	</tr>
	
	<tr>
		<td class="text"><bean:message key="label.payments.executor.bik"/>:</td>
		<td class="text"><july:string size="50" property="bik" insertable="false" updatable="false"/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.payrules.sum"/>:</july:reqmark></td>
		<td class="text"><july:string size="50" property="sumFrm" insertable="true" updatable="true"/></td>
    </tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
        <td class="text"><july:reqmark><bean:message key="label.payrules.currency"/>:</july:reqmark></td>
        <td class="text">
		    <july:select style="width: 300;" collection="currencies" property="currencycode" insertable="true" updatable="true">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
        </td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.payrules.ppaytype"/>:</td>
		<td class="text">
			<july:radio property="ppType" styleId="advpay" insertable="true" updatable="true" value="A" onclick="switchPpType(false);"/><bean:message key="label.payrules.ppaytype.advpay"/><br>
			<july:radio property="ppType" styleId="account" insertable="true" updatable="true" value="B" onclick="switchPpType(false);"/><bean:message key="label.payrules.ppaytype.account"/><br>
			<july:radio property="ppType" styleId="endperiod" insertable="true" updatable="true" value="C" onclick="switchPpType(false);"/><bean:message key="label.payrules.ppaytype.endperiod"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
        <td class="text"><bean:message key="label.payrules.payperiod"/>:</td>
        <td class="text">
			<july:radio property="payPeriod" styleId="month" insertable="true" updatable="true" value="M"/><bean:message key="label.payrules.payperiod.month"/><br>
			<july:radio property="payPeriod" styleId="quarter" insertable="true" updatable="true" value="Q"/><bean:message key="label.payrules.payperiod.quarter"/><br>
			<july:radio property="payPeriod" styleId="year" insertable="true" updatable="true" value="Y"/><bean:message key="label.payrules.payperiod.year"/>
        </td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.payrules.resource"/>:</td>
		<td class="text">
		    <july:select style="width: 450;" styleId="resources" collection="resources" property="resourcecode" insertable="true" updatable="true">
				<html:options collection="resources" property="resource" labelProperty="name"/>
		   	</july:select>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.payrules.paybeforedate.zero"/>:</td>
		<td class="text">
			<july:string property="payBeforeDateFrm" styleId="paybeforedate_a" size="15" insertable="true" updatable="true"/>&nbsp;
			<bean:message key="label.payrules.paybeforedate.a"/>
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.payrules.paybeforedate.zero"/>:</td>
		<td class="text">
			<july:string property="payBeforeDateFrm" styleId="paybeforedate_b" size="15" insertable="true" updatable="true"/>&nbsp;
			<bean:message key="label.payrules.paybeforedate.b"/>
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.payrules.paybeforedate.zero"/>:</td>
		<td class="text">
			<july:string property="payBeforeDateFrm" styleId="paybeforedate_c" size="15" insertable="true" updatable="true"/>&nbsp;
			<bean:message key="label.payrules.paybeforedate.c"/>
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.payrules.paypurpose"/>:</july:reqmark></td>
		<td class="text"><july:textarea cols="50" rows="3" property="payPurpose" insertable="true" updatable="true" styleId="payPurpose"/></td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.payrules.payterms"/>:</td>
		<td class="text"><july:textarea cols="50" rows="3" property="payTerms" insertable="true" updatable="true" styleId="payTerms"/></td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
	
    <july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>
			
</table>

<logic:equal name="<%= form %>" property="action" value="Add">
	<script language="javascript">
		switchPayType();
	</script>
</logic:equal>
<logic:equal name="<%= form %>" property="action" value="Edit">
	<script language="javascript">
		switchPayType();
	</script>
</logic:equal>

<logic:equal name="<%= form %>" property="action" value="View">
	<script language="javascript">
		showCertain();
	</script>
</logic:equal>
<logic:equal name="<%= form %>" property="action" value="Delete">
	<script language="javascript">
		showCertain();
	</script>
</logic:equal>

</july:editform>
