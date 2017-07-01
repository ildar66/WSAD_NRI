<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%	String gColSpan = "2";
	String form = null;
	String action = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.WE_ARENDA_EDIT:
			form = "WeArendaForm";
			action = "/ShowPayRulesList.do";
			break;
		case APPStates.HISTORY_FORM:
			form = "HistoryForm";
			action = "/ShowHistoryPayRulesList.do";
			break;
	} %>

	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>"  style="font-size:8pt;">
			<logic:equal name="<%= form %>" property="contractState" value="B">
				<july:canedit rolesProperty="editRoles">
					<%--july:link page="<%= action %>" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument"--%>
						<bean:message key="label.payrules"/>
					<%--/july:link--%>
				</july:canedit>
			</logic:equal>
			
			<logic:notEqual name="<%= form %>" property="contractState" value="B">
				<%--july:link page="<%= action %>" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument"--%>
					<bean:message key="label.payrules"/>
				<%--/july:link--%>
			</logic:notEqual>

			<logic:equal name="<%= form %>" property="contractState" value="A">
				<july:canedit rolesProperty="editRoles">
					<A href='EditPayRuleDialog.do?action=Add&leaseDocumentcode=<bean:write name="<%= form %>" property="leaseDocument"/>&currencycode=<bean:write name="<%= form %>" property="currencycode1"/>&sumFrm=<bean:write name="<%= form %>" property="summ1Frm"/>&orgToPaycode=<bean:write name="<%= form %>" property="orgExecutorcode"/>&orgToPayName=<bean:write name="<%= form %>" property="orgExecutorname"/>' onclick='return openDialog(this.href, "EditPayRuleDialog", "top=100, left=100, width=600, height=600, scrollbars=yes, resizable=yes"); '>
						<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить правило оплаты'></A>
				</july:canedit>
			</logic:equal>
			
<logic:present name="payrulesList">

		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr><td colspan="<%= gColSpan %>">
	<table class="main" style="font-size:8pt;">

		<!-- Table header -->
		<tr class="title" style="background-color: 'D6EBFF'">
			<td class="title">&nbsp;</td>
			<july:headercolumn key="label.payrules.paytype" colType="string"/>
			<july:headercolumn key="label.payrules.ppaytype" colType="string"/>
			<july:headercolumn key="label.payrules.sum" colType="string"/>
			<july:headercolumn key="label.payrules.currency" colType="string"/>
			<july:headercolumn key="label.payrules.period" colType="string"/>
			<%--july:headercolumn key="label.payrules.payreceiver" colType="string"/--%>
			<td class="title">&nbsp;</td>
			<july:headercolumn key="label.payrules.paybeforedate" colType="string"/>
			<td class="title">&nbsp;</td>
		</tr>

		<july:separator colspan="10"/>

		<!-- Table body -->
		<logic:iterate id="pr" name="payrulesList">
			<logic:present name="pr">
				<tr>
					<td class="text">
			<logic:equal name="<%= form %>" property="contractState" value="A">
				<july:canedit rolesProperty="editRoles">
						<A href='EditPayRuleDialog.do?action=Edit&leaseRule=<bean:write name="pr" property="leaseRule"/>&leaseDocumentcode=<bean:write name="<%= form %>" property="leaseDocument"/>&orgToPaycode=<bean:write name="<%= form %>" property="orgExecutorcode"/>&orgToPayName=<bean:write name="<%= form %>" property="orgExecutorname"/>' onclick='return openDialog(this.href, "EditPayRuleDialog", "top=100, left=100, width=600, height=600, scrollbars=yes, resizable=yes"); '>
						<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить правило оплаты'>
					</A>
				</july:canedit>
			</logic:equal>
					</td>
					<td class="text">
						<logic:equal name="pr" property="payType" value="P"><bean:message key="label.payrules.paytype.payorder"/></logic:equal>
						<logic:equal name="pr" property="payType" value="M"><bean:message key="label.payrules.paytype.vz"/></logic:equal>
						<logic:equal name="pr" property="payType" value="B"><bean:message key="label.payrules.paytype.acseptNo"/></logic:equal>
					</td>
					<td class="text">
						<logic:present name="pr" property="ppType">
							<logic:equal name="pr" property="ppType" value="A"><bean:message key="label.payrules.ppaytype.advpay"/></logic:equal>
							<logic:equal name="pr" property="ppType" value="B"><bean:message key="label.payrules.ppaytype.account"/></logic:equal>
							<logic:equal name="pr" property="ppType" value="C"><bean:message key="label.payrules.ppaytype.endperiod"/></logic:equal>
						</logic:present>
					</td>
					<td class="number" align="right">
						<july:sumwrite name="pr" property="sum"/>
					</td>
					<td class="text">
						<bean:write name="pr" property="currency.shortname" filter="true"/>
					</td>
					<td class="text">
						<logic:present name="pr" property="payPeriod">
							<logic:equal name="pr" property="payPeriod" value="M"><bean:message key="label.payrules.payperiod.month"/></logic:equal>
							<logic:equal name="pr" property="payPeriod" value="Q"><bean:message key="label.payrules.payperiod.quarter"/></logic:equal>
							<logic:equal name="pr" property="payPeriod" value="Y"><bean:message key="label.payrules.payperiod.year"/></logic:equal>
						</logic:present>
    	            </td>
 					<%--td class="text">
						<logic:present name="pr" property="orgToPay">
							<bean:write name="pr" property="orgToPay.name" filter="true"/>
						</logic:present>
	                </td--%>
					<td class="text" align="right">
						<logic:present name="pr" property="payTerms">
							<img src='/images/doc.gif' border=0 alt='<bean:write name="pr" property="payTerms" filter="true"/>'>
						</logic:present>
					</td>
					<td class="text">
						<logic:present name="pr" property="payBeforeDate">
							<bean:write name="pr" property="payBeforeDate" filter="true"/>&nbsp;
						</logic:present>
						<logic:present name="pr" property="validdatepay">
							<logic:equal name="pr" property="validdatepay" value="A">
								до даты начала периода
							</logic:equal>
							<logic:equal name="pr" property="validdatepay" value="B">
								с даты начала периода
							</logic:equal>
							<logic:equal name="pr" property="validdatepay" value="D">
								до окончания периода
							</logic:equal>
							<logic:equal name="pr" property="validdatepay" value="C">
								после окончания периода
							</logic:equal>
							<logic:equal name="pr" property="validdatepay" value="E">
								с момента получения счета
							</logic:equal>
						</logic:present>
					</td>
					<td class="text">
			<logic:equal name="<%= form %>" property="contractState" value="A">
				<july:canedit rolesProperty="editRoles">
						<A href='EditPayRuleDialog.do?action=Delete&leaseRule=<bean:write name="pr" property="leaseRule"/>&leaseDocumentcode=<bean:write name="<%= form %>" property="leaseDocument"/>&orgToPaycode=<bean:write name="<%= form %>" property="orgExecutorcode"/>&orgToPayName=<bean:write name="<%= form %>" property="orgExecutorname"/>' onclick='return openDialog(this.href, "EditPayRuleDialog", "top=100, left=100, width=600, height=500, scrollbars=yes, resizable=yes"); '>
							<IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить правило оплаты'>
						</A>					
				</july:canedit>
			</logic:equal>
					</td>
    	        </tr>
				<july:separator colspan="10"/>
			</logic:present>
		</logic:iterate>	
		
	</table>
	</td></tr>
	
</logic:present>
<logic:notPresent name="payrulesList">
		&nbsp;-&nbsp;<bean:message key="label.nodata"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
</logic:notPresent>