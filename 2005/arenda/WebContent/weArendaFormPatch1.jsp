<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<tr>
	<td class="text"><bean:message key="label.actions"/>:</td>
	<td>
		<july:canedit rolesProperty="editRoles">
			<%--<logic:equal name="WeArendaForm" property="contractState" value="A">--%>
				<july:editlink page="/EditWeArenda.do" action="Edit" paramId="leaseDocument" 
						paramName="WeArendaForm" paramProperty="leaseDocument" styleClass="button">
					<bean:message key="label.mainparams"/>
				</july:editlink>
			<%--</logic:equal>--%>
		</july:canedit>
<%--		
		<html:link page="/ShowChargeRulesList.do" paramId="leaseDocument" 
			paramName="WeArendaForm" paramProperty="leaseDocument"
			styleClass="button">
			<bean:message key="label.table.chargerules"/>
		</html:link>
		<html:link page="/ShowPayRulesList.do" paramId="leaseDocument" paramName="WeArendaForm" 
			paramProperty="leaseDocument"
			styleClass="button">
			<bean:message key="label.table.payrules"/>
		</html:link>
--%>
		<%-- DD  Link removed, but can be restored
		<html:link page="/ShowChargesList.do" paramId="leaseContract" paramName="WeArendaForm" paramProperty="leaseDocument">
			<bean:message key="label.table.charges"/>
		</html:link>
		--%>

		<%-- DD  Link removed, but can be restored
		<html:link page="/ShowPaymentsList.do" paramId="leaseContract" paramName="WeArendaForm" paramProperty="leaseDocument">
			<bean:message key="label.table.payments"/>
		</html:link>
		--%>
<%--
		<html:link page="/ShowArendaPositionsList.do" paramId="leaseDocument" paramName="WeArendaForm" 
				paramProperty="leaseDocument"
				styleClass="button">
			<bean:message key="label.table.positions"/>
		</html:link>
--%>
		<html:link page="/ShowArendaToNfsZpList.do" paramId="leaseDocument" paramName="WeArendaForm" 
				paramProperty="leaseDocument"
				styleClass="button">
			<bean:message key="navtitle.ShowArendaToNfsZpList"/>
		</html:link>

		<%-- DD  Link removed, but can be restored
		<html:link page="/ShowFromContractMutualReglamentsList.do" name="WeArendaForm" property="paramsForReglament">
			<bean:message key="label.mutualreglmnts.short"/>
		</html:link>
		--%>

		<%-- DD  Link removed, but can be restored
		<html:link page="/ShowSaldoList.do" paramId="leaseContract" paramName="WeArendaForm" paramProperty="leaseDocument">
			<bean:message key="label.saldo"/>
		</html:link>
		--%>

		<%-- DD  Link removed, but can be restored
		<html:link page="/ShowCalcHistory.do" paramId="leaseDocument" paramName="WeArendaForm" paramProperty="leaseDocument" onclick="window.open(this.href, 'ab', 'top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes'); return false;">
			<bean:message key="label.contractcalc"/>
		</html:link>
		--%>
		
		<%-- DD  Link removed, but can be restored
			<logic:equal name="WeArendaForm" property="contractState" value="A">
				<july:canedit rolesProperty="editRoles">
					<% String actionPlatinum = "/EditPlatinumDogovorForm.do?action=Add"; %>
					<logic:present name="WeArendaForm" property="isPlatinumrecord">
						<% actionPlatinum = "/EditPlatinumDogovorForm.do?action=Edit"; %>
					</logic:present>
					<html:link page="<%= actionPlatinum %>" paramId="leasedocument" paramName="WeArendaForm" 
						paramProperty="leaseDocument"
						styleClass="button"><bean:message key="label.platinum.parms"/></html:link>
				</july:canedit>
				<july:cannotedit rolesProperty="editRoles">
					<logic:present name="WeArendaForm" property="isPlatinumrecord">
						<html:link page="/EditPlatinumDogovorForm.do?action=View" paramId="leasedocument" 
							paramName="WeArendaForm" paramProperty="leaseDocument" styleClass="button">
							<bean:message key="label.platinum.parms"/>
						</html:link>
					</logic:present>
				</july:cannotedit>
			</logic:equal>
			
			<logic:notEqual name="WeArendaForm" property="contractState" value="A">
					<html:link page="/EditPlatinumDogovorForm.do?action=View" paramId="leasedocument" paramName="WeArendaForm" 
						paramProperty="leaseDocument" styleClass="button">
						<bean:message key="label.platinum.parms"/>
					</html:link>
			</logic:notEqual>  --%>
			<a href="#" onclick="showTerrabyteWin('&ss=1&dv=0');" class="button">Документы аренды</a>
	</td> 
</tr>

<july:separator/>