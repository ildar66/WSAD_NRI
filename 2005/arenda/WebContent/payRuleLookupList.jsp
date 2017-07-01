<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "10"; %>

<%
    String action = "/PayRuleLookupList.do";
	String form = "PayRuleLookupListForm";
	//String temp = null;
%>

<july:browseform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="leaseDocument"/>
<html:hidden property="formname"/>
<html:hidden property="fieldnames"/>

<script language="javascript">
function Go(strval) {
	var thisform = document.forms[0];
	var outform = window.opener.document.forms[thisform.formname.value];
	
	if(outform != null)
	{
		var names = thisform.fieldnames.value.split('|'), values = strval.split('|');
		for(var i in names) {
			if(names[i].length > 0)
				outform[names[i]].value = unescape(values[i]);
		}
	}
	Close();
}
function Close()
{
	var thisform = document.forms[0];
	var outform = window.opener.document.forms[thisform.formname.value];
	if(outform != null) {
		document.body.style.cursor="wait";
		outform.operation.value = "leaseRule";
		outform.submit();
		window.opener.focus();
	}
	window.close();
}
</script>

<table class="main">
<%--
	<july:separator colspan="<%= gColSpan %>"/>
	
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.filter.docnumber"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="documentNumber" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.docperiod"/>:</td>
					<td class="text" nowrap>
						<july:datewrite name="<%= form %>" property="startDate"/>&nbsp;
						<bean:message key="label.filter.stop"/>&nbsp;
						<july:datewrite name="<%= form %>" property="endDate"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.customer"/>:</td>
					<td class="text"><bean:write name="<%= form %>" property="orgCustomer" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.executor"/>:</td>
					<td class="text"><bean:write name="<%= form %>" property="orgExecutor" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.costcurrency"/>:</td>
					<td class="text" nowrap>
						<july:sumwrite name="<%= form %>" property="currency1"/>&nbsp;
						<bean:write name="<%= form %>" property="curr1" filter="true"/>
						<logic:present name="<%= form %>" property="currency2">
							;&nbsp;<july:sumwrite name="<%= form %>" property="currency2"/>
							&nbsp;<bean:write name="<%= form %>" property="curr2" filter="true"/>
						</logic:present>
					</td>
				</tr>
				
				<logic:present name="<%= form %>" property="rateCalcRule">
					<tr>
						<td class="text"><bean:message key="label.payrules.paydaterule"/>:</td>
						<td class="text">
							<logic:equal name="<%= form %>" property="rateCalcRule" value="A"><bean:message key="label.filter.ratecalcrule.a"/></logic:equal>
							<logic:equal name="<%= form %>" property="rateCalcRule" value="B"><bean:message key="label.filter.ratecalcrule.b"/></logic:equal>
							<logic:equal name="<%= form %>" property="rateCalcRule" value="C"><bean:message key="label.filter.ratecalcrule.c"/></logic:equal>
							<logic:equal name="<%= form %>" property="rateCalcRule" value="D"><bean:message key="label.filter.ratecalcrule.d"/></logic:equal>
							<logic:equal name="<%= form %>" property="rateCalcRule" value="E"><bean:message key="label.filter.ratecalcrule.e"/></logic:equal>
							
							<%	PayRuleLookupListForm formBean = ((PayRuleLookupListForm) request.getSession().getAttribute(form)); %>
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
					<tr>
						<td class="text"><bean:message key="label.filter.ratedelta"/>:</td>
						<td class="text"><bean:write name="<%= form %>" property="rateDelta" filter="true"/></td>
					</tr>
				</logic:present>
				
			</table>
		</TD>
	</TR>
--%>
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
<%--					
						<july:canedit rolesProperty="editRoles">
							<logic:equal name="<%= form %>" property="stateOfContract" value="A">
								<% temp = edit + "?action=Add"; %>
								<july:addbutton page="<%= temp %>"/>
							</logic:equal>
						</july:canedit>
						<% temp = parent + "?action=View"; %>
						<july:backbutton page="<%= temp %>" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument"/>
--%>						
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<!-- Table header -->
	<tr class="title">
		<td class="title">&nbsp;</td>
		<july:headercolumn key="label.payrules.paytype" colType="string"/>
		<july:headercolumn key="label.payrules.ppaytype" colType="string"/>
		<july:headercolumn key="label.payrules.sum" colType="string"/>
		<july:headercolumn key="label.payrules.currency" colType="string"/>
		<july:headercolumn key="label.payrules.period" colType="string"/>
		<%--july:headercolumn key="label.payrules.payreceiver" colType="string"/--%>
		<july:headercolumn key="label.payrules.paybeforedate" colType="string"/>
		<td class="title">&nbsp;</td>
		<%--td class="title">&nbsp;</td--%>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="link">
<%--				
					<% temp = "View"; %>
					<july:canedit rolesProperty="editRoles">
						<logic:equal name="<%= form %>" property="stateOfContract" value="A">
							<% temp = "Edit"; %>
						</logic:equal>
					</july:canedit>
					<july:editbutton page="<%= edit %>" action="<%= temp %>" paramId="leaseRule" paramName="it" paramProperty="leaseRule" paramScope="page"/>
--%>
           			<A href="javascript:Go('<bean:write name="it" property="leaseRule" filter="true"/>')" title="Выберите правило оплаты">выбрать</A>					
				</td>
				<td class="text">
					<logic:equal name="it" property="payType" value="P"><bean:message key="label.payrules.paytype.payorder"/></logic:equal>
					<logic:equal name="it" property="payType" value="M"><bean:message key="label.payrules.paytype.vz"/></logic:equal>
					<logic:equal name="it" property="payType" value="B"><bean:message key="label.payrules.paytype.acseptNo"/></logic:equal>
				</td>
				<td class="text">
					<logic:present name="it" property="ppType">
						<logic:equal name="it" property="ppType" value="A"><bean:message key="label.payrules.ppaytype.advpay"/></logic:equal>
						<logic:equal name="it" property="ppType" value="B"><bean:message key="label.payrules.ppaytype.account"/></logic:equal>
						<logic:equal name="it" property="ppType" value="C"><bean:message key="label.payrules.ppaytype.endperiod"/></logic:equal>
					</logic:present>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="sum"/>
				</td>
				<td class="text">
					<bean:write name="it" property="currency.shortname" filter="true"/>
				</td>
				<td class="text">
					<logic:present name="it" property="payPeriod">
						<logic:equal name="it" property="payPeriod" value="M"><bean:message key="label.payrules.payperiod.month"/></logic:equal>
						<logic:equal name="it" property="payPeriod" value="Q"><bean:message key="label.payrules.payperiod.quarter"/></logic:equal>
						<logic:equal name="it" property="payPeriod" value="Y"><bean:message key="label.payrules.payperiod.year"/></logic:equal>
					</logic:present>
                </td>
 				<%--td class="text">
					<logic:present name="it" property="orgToPay">
						<bean:write name="it" property="orgToPay.name" filter="true"/>
					</logic:present>
                </td--%>
				<td class="text" align="right">
					<logic:present name="it" property="payBeforeDate">
						<bean:write name="it" property="payBeforeDate" filter="true"/>
					</logic:present>
				</td>
				<td class="text" align="right">
					<logic:present name="it" property="payTerms">
						<img src='/images/doc.gif' border=0 alt='<bean:write name="it" property="payTerms" filter="true"/>'>
					</logic:present>
				</td>
<%--				
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<logic:equal name="<%= form %>" property="stateOfContract" value="A">
							<% temp = edit + "?action=Delete"; %>
							<july:delbutton page="<%= temp %>" paramId="leaseRule" paramName="it" paramProperty="leaseRule" paramScope="page"/>
						</logic:equal>
					</july:canedit>
				</td>
--%>				
            </tr>
			<july:separator colspan="<%= gColSpan %>"/>
	      </logic:present>
        </logic:iterate>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
<%--					
						<july:canedit rolesProperty="editRoles">
							<logic:equal name="<%= form %>" property="stateOfContract" value="A">
								<% temp = edit + "?action=Add"; %>
								<july:addbutton page="<%= temp %>"/>
							</logic:equal>
						</july:canedit>
						<% temp = parent + "?action=View"; %>
						<july:backbutton page="<%= temp %>" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument"/>
--%>						
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>


</table>

</july:browseform>