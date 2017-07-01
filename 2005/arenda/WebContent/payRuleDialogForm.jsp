<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/ProcessPayRuleDialog.do";
	String form = "PayRuleDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить правило оплаты";
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
	<script language="javascript">
		<% src = "/images/delconf.gif"; alt = "Удалить правило оплаты"; %>
	</script>
</logic:equal>

<july:editform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="leaseDocumentcode"/>
<html:hidden property="leaseRule"/>

<script language="javascript">
function switchPayType() {
	if (document.all.payOrder.checked) {
		<%= form %>.orgToPayCode.className = 'editkod';
		<%= form %>.orgToPayCode.disabled = false;
		document.all['lookupimg_execl'].src='/images/lookup.gif';
		<%= form %>.orgAcccode.className = 'editkod';
		<%= form %>.orgAcccode.disabled = false;
		document.all['lookupimg_accl'].src='/images/lookup.gif';
		document.all.ppType.disabled = false;
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
		document.all.ppType.disabled = true;
		document.all.validdatepay_A.value = "";
		document.all.validdatepay_B.value = "";
		document.all.validdatepay_C.value = "";
		document.all.validdatepay_A.disabled = true;
		document.all.validdatepay_B.disabled = true;
		document.all.validdatepay_C.disabled = true;
		<%= form %>.paybeforedate.className = 'editdisabled';
		<%= form %>.paybeforedate.disabled = true;
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
	<%= form %>.paybeforedate.className = 'edit';
	<%= form %>.paybeforedate.disabled = false;
	if (document.all.ppType.value == "A") {
		<%= form %>.validdatepay_A.style.setAttribute("display", "inline");
		<%= form %>.validdatepay_B.style.setAttribute("display", "none");
		<%= form %>.validdatepay_C.style.setAttribute("display", "none");
		<%= form %>.validdatepay_A.disabled = false;//
		<%= form %>.validdatepay_B.disabled = true;//
		<%= form %>.validdatepay_C.disabled = true;//
	}
	if (document.all.ppType.value == "B") {
		<%= form %>.validdatepay_A.style.setAttribute("display", "none");
		<%= form %>.validdatepay_B.style.setAttribute("display", "inline");
		<%= form %>.validdatepay_C.style.setAttribute("display", "none");
		<%= form %>.validdatepay_A.disabled = true;//
		<%= form %>.validdatepay_B.disabled = false;//
		<%= form %>.validdatepay_C.disabled = true;//
	}
	if (document.all.ppType.value == "C") {
		<%= form %>.validdatepay_A.style.setAttribute("display", "none");
		<%= form %>.validdatepay_B.style.setAttribute("display", "none");
		<%= form %>.validdatepay_C.style.setAttribute("display", "inline");
		<%= form %>.validdatepay_A.disabled = true;//
		<%= form %>.validdatepay_B.disabled = true;//
		<%= form %>.validdatepay_C.disabled = false;//
	}
	if (isInitial) {
		showCertain();
	}
}
function showCertain() {
	//deprecated
}
function Close()
	{
		if(window.opener) {
			opener.location.reload(true);
			window.opener.focus();
		}
		window.close();
	}
</script>

<table class="main"  style="font-size:8pt;">

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="6">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.payrules.resource"/>:</td>
		<td class="text">
		    <july:select style="width: 420;" styleId="resources" collection="resources" property="resourcecode" insertable="true" updatable="true">
				<html:options collection="resources" property="resource" labelProperty="name"/>
		   	</july:select>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.payrules.paytype"/>:</july:reqmark></td>
		<td class="text">
			<july:radio property="payType" insertable="true" updatable="true" value="P" styleId="payOrder" onclick="switchPayType();"/><bean:message key="label.payrules.paytype.payorder"/>
			&nbsp;Тип:&nbsp;
			<july:select style="width: 150;" property="ppType" insertable="true" updatable="true" onclick="switchPpType(false);">
				<html:option value="A"><bean:message key="label.payrules.ppaytype.advpay"/></html:option>
				<html:option value="B"><bean:message key="label.payrules.ppaytype.account"/></html:option>
				<html:option value="C"><bean:message key="label.payrules.ppaytype.endperiod"/></html:option>
			</july:select><br>
			<july:radio property="payType" insertable="true" updatable="true" value="M" styleId="vz" onclick="switchPayType();"/><bean:message key="label.payrules.paytype.vz"/><br>
			<july:radio property="payType" insertable="true" updatable="true" value="B" onclick="switchPayType();"/><bean:message key="label.payrules.paytype.acseptNo"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
        <td class="text" colspan="2"><bean:message key="label.payrules.payperiod"/>:&nbsp;
			<july:radio property="payPeriod" styleId="month" insertable="true" updatable="true" value="M"/><bean:message key="label.payrules.payperiod.month"/>&nbsp;
			<july:radio property="payPeriod" styleId="quarter" insertable="true" updatable="true" value="Q"/><bean:message key="label.payrules.payperiod.quarter"/>&nbsp;
			<july:radio property="payPeriod" styleId="year" insertable="true" updatable="true" value="Y"/><bean:message key="label.payrules.payperiod.year"/>
        </td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text" colspan="2">
			<bean:message key="label.payrules.separateNdsPay"/>, Оплата на лицевой счет:&nbsp;
			<july:checkbox property="separateNdsPay" styleId="separateNdsPay" insertable="true" updatable="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.payrules.orgtopay"/>:</td>
		<td class="text">
			<%--html:hidden property="orgToPaycodeFrm" styleId="orgToPayCode"/--%>
			<html:hidden property="orgExecutorcode" styleId="orgToPayCode"/>

			<%--july:string size="40"  style="width: 400;"  property="orgToPayName" styleId="orgToPayName" insertable="false" updatable="false"/--%>
			<july:string size="40" style="width: 400;" property="orgExecutorname" styleId="orgToPayName" insertable="false" updatable="false"/>			
			
			<%--july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="execl" fieldNames="orgToPayCode;orgToPayName;orgAcccode;orgAccname;bank;coraccount;bik" insertable="true" updatable="true" newWindowName="Organization" onclick="if (!document.all.payOrder.checked) { return false; }"/--%>
			<html:link page="/../dict/VendorSiteLookupList.do?formname=PayRuleDialogForm&fieldnames=orgToPayCode||orgToPayName||||orgAcccode|orgAccname|bank|coraccount|bik" onclick="if (!document.all.payOrder.checked) { return false; } else {return openDialog(this.href, 'VendorSitesLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes');}" title="справочник отделений">		
				<img name="lookupimg_execl" src='/images/lookup.gif' border='0' alt='Справочник отделений'></html:link>		
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.payrules.account"/>:</td>
		<td class="text">
			<html:hidden property="orgAcccodeFrm" styleId="orgAcccode"/>

			<july:string size="40" style="width: 400;"   property="orgAccname" styleId="orgAccname" insertable="false" updatable="false"/>
			<%--july:lookupbutton action="/ShowAccountLookupList.do" styleId="accl" fieldNames="orgAcccode;orgAccname;bank;bik;coraccount" onclick="if (!document.all.payOrder.checked) { return false; } else { set_opt_params_accl('?organization='+document.all.orgToPayCode.value); }" insertable="true" updatable="true" newWindowName="Account"/--%>
			<html:link page="/../dict/AccountsLookupList.do?formname=PayRuleDialogForm&fieldnames=orgAcccode|orgAccname|bank|bik|coraccount" onclick="if (!document.all.payOrder.checked) { return false; } else {return openDialog(this.href + '&idVendorSite='+document.all.orgToPayCode.value , 'AccountsLookupList', 'top=40, left=100, width=600, height=300, scrollbars=yes, resizable=yes');}" title="справочник счетов">		
				<img name="lookupimg_accl" src='/images/lookup.gif' border='0' alt='Справочник счетов'></html:link>		
		</td> 
	</tr>

	<tr>
		<td class="text">
			<bean:message key="label.payments.executor.bank"/>:<BR>
			<bean:message key="label.payments.executor.coraccount"/>:<BR>
			<bean:message key="label.payments.executor.bik"/>:
		</td>
		<td class="text">
			<july:string size="40" style="width: 400;" property="bank" insertable="false" updatable="false"/><BR>
			<july:string size="40" style="width: 400;" property="coraccount" insertable="false" updatable="false"/><BR>
			<july:string size="40" style="width: 400;" property="bik" insertable="false" updatable="false"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.payrules.sum"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="10" property="sumFrm" insertable="true" updatable="true"/>&nbsp;
			<july:select style="width: 150;" collection="currencies" property="currencycode" insertable="true" updatable="true">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
		</td>
    </tr>
	
<%--
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.payrules.ppaytype"/>:</td>
		<td class="text">
			<july:radio property="ppType" styleId="advpay" insertable="true" updatable="true" value="A" onclick="switchPpType(false);"/><bean:message key="label.payrules.ppaytype.advpay"/><br>
			<july:radio property="ppType" styleId="account" insertable="true" updatable="true" value="B" onclick="switchPpType(false);"/><bean:message key="label.payrules.ppaytype.account"/><br>
			<july:radio property="ppType" styleId="endperiod" insertable="true" updatable="true" value="C" onclick="switchPpType(false);"/><bean:message key="label.payrules.ppaytype.endperiod"/>
		</td>
	</tr>
--%>
 
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.payrules.paybeforedate.zero"/>:</td>
		<td class="text">
				<july:string property="payBeforeDateFrm" styleId="paybeforedate" size="5" style="width: 50;"insertable="true" updatable="true"/>  дней 
				<july:select style="width: 350; display: inline;" property="validdatepay" insertable="true" updatable="true" styleId="validdatepay_A">
					<html:option value=""></html:option>
					<html:option value="A">до даты начала оплачиваемого периода </html:option>
					<html:option value="B">с даты начала оплачиваемого периода</html:option>
					<html:option value="D">до окончания оплачиваемого периода</html:option>
				</july:select>
				<july:select style="width: 350; display: none;" property="validdatepay" insertable="true" updatable="true" styleId="validdatepay_B">
					<html:option value=""></html:option>
					<html:option value="E">с момента получения счета</html:option>
				</july:select>
				<july:select style="width: 350; display: none;" property="validdatepay" insertable="true" updatable="true" styleId="validdatepay_C">
					<html:option value=""></html:option>
					<html:option value="C">после окончания оплачиваемого периода </html:option>
				</july:select>
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
    <tr class="title">
    	<td class="title" colspan="6">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" styleID="submitID" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
			
</table>

<logic:equal name="PayRuleDialogForm" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

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
