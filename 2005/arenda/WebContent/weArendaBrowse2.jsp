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
			action = "/ShowChargeRulesList.do";
			break;
		case APPStates.HISTORY_FORM:
			form = "HistoryForm";
			action = "/ShowHistoryChargeRulesList.do";
			break;
	} %>


	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>"  style="font-size:8pt;">
			<logic:equal name="<%= form %>" property="contractState" value="B">
				<july:canedit rolesProperty="editRoles">
					<%--july:link page="<%= action %>" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument"--%>
						<bean:message key="label.chargerules"/>
					<%--/july:link--%>
				</july:canedit>
			</logic:equal>
			
			<logic:notEqual name="<%= form %>" property="contractState" value="B">
				<%--july:link page="<%= action %>" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument"--%>
					<bean:message key="label.chargerules"/>
				<%--/july:link--%>
			</logic:notEqual>

			<logic:equal name="<%= form %>" property="contractState" value="A">
				<july:canedit rolesProperty="editRoles">
					<A href='EditChargeRuleDialog.do?action=Add&leaseDocumentcode=<bean:write name="<%= form %>" property="leaseDocument"/>&currencycode=<bean:write name="<%= form %>" property="currencycode1"/>&sumFrm=<bean:write name="<%= form %>" property="summ1Frm"/>' onclick='return openDialog(this.href, "EditChargeRuleDialog", "top=100, left=100, width=600, height=250, scrollbars=yes, resizable=yes");'>
						<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить правило начислений'></A>
				</july:canedit>
			</logic:equal>
			
<logic:present name="chargerulesList">


		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr><td colspan="<%= gColSpan %>">
	<table class="main"  style="font-size:8pt;">
		<!-- Table header -->
		<tr class="title" style="background-color: 'D6EBFF'">
			<td class="title">&nbsp;</td>
			<july:headercolumn key="label.chargerules.service" colType="string"/>
			<july:headercolumn key="label.chargerules.sum" colType="string"/>
			<july:headercolumn key="label.chargerules.currency" colType="string"/>
			<july:headercolumn key="label.chargerules.period" colType="string"/>
			<july:headercolumn key="label.chargerules.ruledate" colType="string"/>
			<td class="title">&nbsp;</td>
		</tr>


		<july:separator colspan="7"/>


		<!-- Table body -->
		<logic:iterate id="cr" name="chargerulesList">
			<logic:present name="cr">
				<tr>
					<td class="text">
			<logic:equal name="<%= form %>" property="contractState" value="A">
				<july:canedit rolesProperty="editRoles">
						<A href='EditChargeRuleDialog.do?action=Edit&leaseRule=<bean:write name="cr" property="leaseRule"/>&leaseDocumentcode=<bean:write name="<%= form %>" property="leaseDocument"/>' onclick='return openDialog(this.href, "EditChargeRuleDialog", "top=100, left=100, width=600, height=250, scrollbars=yes, resizable=yes");'>
						<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить правило начислений'>
					</A>
				</july:canedit>
			</logic:equal>
					</td>
					<td class="text">
						<bean:write name="cr" property="resource.name" filter="true"/>
					</td>
					<td class="number" align="right">
						<july:sumwrite name="cr" property="sum"/>
					</td>
					<td class="text">
						<bean:write name="cr" property="curency.shortname" filter="true"/>
					</td>
					<td class="text">
						<logic:equal name="cr" property="chargePeriod" value="M"><bean:message key="label.chargerules.period.month"/></logic:equal>
						<logic:equal name="cr" property="chargePeriod" value="Q"><bean:message key="label.chargerules.period.quarter"/></logic:equal>
						<logic:equal name="cr" property="chargePeriod" value="Y"><bean:message key="label.chargerules.period.year"/></logic:equal>
					</td>
					<td class="text" wrap>
						<logic:equal name="cr" property="chargeDateRule" value="S"><bean:message key="label.chargerules.daterule.startperiod"/></logic:equal>
						<logic:equal name="cr" property="chargeDateRule" value="E"><bean:message key="label.chargerules.daterule.endperiod"/></logic:equal>
	                </td>
					<td class="text">
			<logic:equal name="<%= form %>" property="contractState" value="A">
				<july:canedit rolesProperty="editRoles">
						<A href='EditChargeRuleDialog.do?action=Delete&leaseRule=<bean:write name="cr" property="leaseRule"/>&leaseDocumentcode=<bean:write name="<%= form %>" property="leaseDocument"/>' onclick='return openDialog(this.href, "EditChargeRuleDialog", "top=100, left=100, width=600, height=250, scrollbars=yes, resizable=yes");'>
						<IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить правило начислений'>
					</A>
				</july:canedit>
			</logic:equal>
					</td>
				</tr>
				<july:separator colspan="7"/>
			</logic:present>
		</logic:iterate>
	</table>
	</td></tr>
	
</logic:present>
<logic:notPresent name="chargerulesList">
		&nbsp;-&nbsp;<bean:message key="label.nodata"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
</logic:notPresent>