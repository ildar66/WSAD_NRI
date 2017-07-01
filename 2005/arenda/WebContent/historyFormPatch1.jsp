<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<tr>
	<td class="text"><bean:message key="label.actions"/>:</td>
	<td>
		<july:canedit rolesProperty="editRoles">
			<%--<logic:equal name="HistoryForm" property="contractState" value="A">--%>
				<july:editlink page="/EditHistory.do" action="Edit" paramId="leaseDocument" paramName="HistoryForm" paramProperty="leaseDocument" 
				styleClass="button">
					<bean:message key="label.mainparams"/>
				</july:editlink>
			<%--</logic:equal>--%>
			
		</july:canedit>
<%--		
		<july:link page="/ShowHistoryChargeRulesList.do" paramId="leaseDocument" paramName="HistoryForm" paramProperty="leaseDocument"   styleClass="button">
			<bean:message key="label.table.chargerules"/>
		</july:link>
		<july:link page="/ShowHistoryPayRulesList.do" paramId="leaseDocument" paramName="HistoryForm" paramProperty="leaseDocument" styleClass="button">
			<bean:message key="label.table.payrules"/>
		</july:link>
<%--		
<%-- SI  Link removed, but can be restored
		<july:link page="/ShowHistoryChargesList.do" paramId="leaseContract" paramName="HistoryForm" paramProperty="leaseDocument">
			<bean:message key="label.table.charges"/>
		</july:link>
		<july:link page="/ShowHistoryPaymentsList.do" paramId="leaseContract" paramName="HistoryForm" paramProperty="leaseDocument">
			<bean:message key="label.table.payments"/>
		</july:link>
--%>
<%--
		<july:link page="/ShowHistoryArendaPositionsList.do" paramId="leaseDocument" paramName="HistoryForm" paramProperty="leaseDocument" styleClass="button">
			<bean:message key="label.table.positions"/>
		</july:link>
--%>		
<%-- SI  Link removed, but can be restored
		<july:link page="/ShowFromHistoryMutualReglamentsList.do" name="HistoryForm" property="paramsForReglament">
			<bean:message key="label.mutualreglmnts.short"/>
		</july:link>
		<july:link page="/ShowHistorySaldoList.do" paramId="leaseContract" paramName="HistoryForm" paramProperty="leaseDocument">
			<bean:message key="label.saldo"/>
		</july:link>
--%>
<%--
		<logic:equal name="HistoryForm" property="contractState" value="A">
			<% String actionPlatinum = "/EditPlatinumDogovorForm.do?action=Add"; %>
			<logic:present name="HistoryForm" property="isPlatinumrecord">
				<% actionPlatinum = "/EditPlatinumDogovorForm.do?action=Edit"; %>
			</logic:present>
			<html:link page="<%= actionPlatinum %>" paramId="leasedocument" paramName="HistoryForm" 
				paramProperty="leaseDocument"
				styleClass="button"><bean:message key="label.platinum.parms"/></html:link>
		</logic:equal>
		<logic:notEqual name="HistoryForm" property="contractState" value="A">
				<html:link page="/EditPlatinumDogovorForm.do?action=View" paramId="leaseDocument" 
					paramName="HistoryForm" paramProperty="leaseDocument" styleClass="button">
					<bean:message key="label.platinum.parms"/>
				</html:link>
		</logic:notEqual>
--%>		

		<html:link page="/ShowArendaToNfsZpList.do" paramId="leaseDocument" paramName="HistoryForm" 
				paramProperty="leaseDocument" styleClass="button">
			<bean:message key="navtitle.ShowArendaToNfsZpList"/>
		</html:link>
		<a href="#" onclick="showTerrabyteWin('&ss=1&dv=0');" class="button">Документы аренды</a>
	</td>
</tr>


<july:separator/>