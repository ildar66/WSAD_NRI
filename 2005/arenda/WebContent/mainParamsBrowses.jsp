<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = "2"; %>


<%
    String action = null;
	String form = null;
	String parent = null;
	String edit = null;
	String parent2 = null;
	String phones = null;
	String contracts = null;
	String rules = null;
	String priority = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.MAINPARAMS_MUTREGLMNT_EDIT:
        	action = "/ProcessMainParamsMutReglmnt.do";
			form = "MainParamsMutReglmntForm";
			edit = "/EditMainParamsMutReglmnt.do"; /*может ViewMainParamsMutReglmnt??? */
			parent2 = "/ShowMutualReglamentsList.do";
			phones = "/ShowPhonesMutReglmntList.do";
			contracts = "/ShowContractsMutReglmntList.do";
			rules = "/ShowMutualRulesList.do";
			priority = "/ShowMRCntPriorsList.do";
        	break;
		case APPStates.FROMCONTRACT_MAINPARAMS_MUTREGLMNT_EDIT:
        	action = "/ProcessFromContractMainParamsMutReglmnt.do";
			form = "FromContractMainParamsMutReglmntForm";
			parent = "/ViewWeArenda.do";
			edit = "/EditFromContractMainParamsMutReglmnt.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			phones = "/ShowFromContractPhonesMutReglmntList.do";
			contracts = "/ShowFromContractContractsMutReglmntList.do";
			rules = "/ShowFromContractMutualRulesList.do";
			priority = "/ShowFromContractMRCntPriorsList.do";
        	break;
		case APPStates.FROMHISTORY_MAINPARAMS_MUTREGLMNT_EDIT:
        	action = "/ProcessFromHistoryMainParamsMutReglmnt.do";
			form = "FromHistoryMainParamsMutReglmntForm";
			parent = "/ViewHistory.do";
			edit = "/EditFromHistoryMainParamsMutReglmnt.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			phones = "/ShowFromHistoryPhonesMutReglmntList.do";
			contracts = "/ShowFromHistoryContractsMutReglmntList.do";
			rules = "/ShowFromHistoryMutualRulesList.do";
			priority = "/ShowFromHistoryMRCntPriorsList.do";
        	break;
    }
%>


	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<july:link page="<%= contracts %>" paramId="mainLeaseDocument" paramName="<%= form %>" paramProperty="leaseDocument">
				<bean:message key="label.mutualreglmnts.contracts"/>
			</july:link>
			
<logic:present name="contractsList">


		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr><td colspan="<%= gColSpan %>">
	<table class="main" style="font-size: 8pt">
		<!-- Table header -->
		<tr class="title" style="background-color: 'D6EBFF'">
			<july:headercolumn key="label.mutualreglmnts.date" colType="date"/>
			<july:headercolumn key="label.mutualreglmnts.number" colType="string"/>
			<july:headercolumn key="label.mutualreglmnts.orgcustomer" colType="string"/>
			<july:headercolumn key="label.mutualreglmnts.orgexecutor" colType="string"/>
			<july:headercolumn key="label.contracttype" colType="string"/>
			<july:headercolumn key="label.mutualreglmnts.resource" colType="string"/>
		</tr>


		<july:separator colspan="6"/>


		<!-- Table body -->
		<logic:iterate id="contractsList" name="contractsList">
			<logic:present name="contractsList">
				<tr>
					<td class="date">
						<july:datewrite name="contractsList" property="contract.documentDate"/>
					</td>
					<td class="text">
						<bean:write name="contractsList" property="contract.documentNumber" filter="true"/>
					</td>
					<td class="text">
						<bean:write name="contractsList" property="contract.orgCustomer.name" filter="true"/>
					</td>
					<td class="text">
						<bean:write name="contractsList" property="contract.orgExecutor.name" filter="true"/>
					</td>
					<td class="text">
						<logic:equal name="contractsList" property="contract.contractType" value="A"><bean:message key="label.contracttype.arenda"/></logic:equal>
						<logic:equal name="contractsList" property="contract.contractType" value="B"><bean:message key="label.contracttype.arendaus"/></logic:equal>
						<logic:equal name="contractsList" property="contract.contractType" value="C"><bean:message key="label.contracttype.user"/></logic:equal>
						<logic:equal name="contractsList" property="contract.contractType" value="D"><bean:message key="label.contracttype.channel"/></logic:equal>
					</td>
					<td class="text">
						<bean:write name="contractsList" property="resource.name" filter="true"/>
					</td>
					<july:separator colspan="6"/>
				</tr>
			</logic:present>
		</logic:iterate>


	</table>
	</td></tr>
	
</logic:present>
<logic:notPresent name="contractsList">
		&nbsp;-&nbsp;<bean:message key="label.nodata"/>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
</logic:notPresent>




<%--logic:notEqual name="<%= form %>" property="actType" value="S">
	<logic:equal name="<%= form %>" property="isExistPriority" value="true">
	
			<tr class="title">
				<td class="title" colspan="<%= gColSpan %>">
					<july:link page="<%= priority %>" paramId="reglamentcode" paramName="<%= form %>" paramProperty="leaseDocument">
						<bean:message key="label.mrcntprior"/>
					</july:link>
					
		<logic:present name="priorityList">
		
				</td>
			</tr>
			
			<july:separator colspan="<%= gColSpan %>"/>
		
			<tr><td colspan="<%= gColSpan %>">
			<table class="main" style="font-size: 8pt">
				<!-- Table header -->
				<tr class="title" style="background-color: 'D6EBFF'">
					<july:headercolumn key="label.mrcntprior.priority" colType="string"/>
					<july:headercolumn key="label.mrcntprior.table.contract" colType="string"/>
					<july:headercolumn key="label.mrcntprior.table.contract" colType="string"/>
				</tr>
			
				<july:separator colspan="3"/>
		
				<!-- Table body -->
				<logic:iterate id="pl" name="priorityList">
					<logic:present name="pl">
						<tr>
							<td class="text">
								<bean:write name="pl" property="priority" filter="true"/>
							</td>
							<td class="text">
								<logic:equal name="pl" property="contract1.contractType" value="A"><bean:message key="label.contracttype.arenda"/></logic:equal>
								<logic:equal name="pl" property="contract1.contractType" value="B"><bean:message key="label.contracttype.arendaus"/></logic:equal>
								<logic:equal name="pl" property="contract1.contractType" value="C"><bean:message key="label.contracttype.user"/></logic:equal>
								<logic:equal name="pl" property="contract1.contractType" value="D"><bean:message key="label.contracttype.channel"/></logic:equal>&nbsp;
								<bean:write name="pl" property="contract1.documentNumber" filter="true"/>&nbsp;
								<july:datewrite name="pl" property="contract1.documentDate"/>
							</td>
							<td class="text">
								<logic:equal name="pl" property="contract2.contractType" value="A"><bean:message key="label.contracttype.arenda"/></logic:equal>
								<logic:equal name="pl" property="contract2.contractType" value="B"><bean:message key="label.contracttype.arendaus"/></logic:equal>
								<logic:equal name="pl" property="contract2.contractType" value="C"><bean:message key="label.contracttype.user"/></logic:equal>
								<logic:equal name="pl" property="contract2.contractType" value="D"><bean:message key="label.contracttype.channel"/></logic:equal>&nbsp;
								<bean:write name="pl" property="contract2.documentNumber" filter="true"/>&nbsp;
								<july:datewrite name="pl" property="contract2.documentDate"/>
							</td>
						</tr>
						<july:separator colspan="3"/>
					</logic:present>
				</logic:iterate>
			</table>
			</td></tr>
			
		</logic:present>
		<logic:notPresent name="priorityList">
				&nbsp;-&nbsp;<bean:message key="label.nodata"/>
				</td>
			</tr>
			<july:separator colspan="<%= gColSpan %>"/>
		</logic:notPresent>
	</logic:equal>
</logic:notEqual--%>
	
	<logic:equal name="<%= form %>" property="commonRate" value="false">
	
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<july:link page="<%= rules %>" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument">
				<bean:message key="label.mutualreglmnts.rules"/>
			</july:link>
			
<logic:present name="mutualrulesList">


		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr><td colspan="<%= gColSpan %>">
	<table class="main" style="font-size: 8pt">
		<!-- Table header -->
		<tr class="title" style="background-color: 'D6EBFF'">
			<july:headercolumn key="label.mutualreglmnts.resource" colType="date"/>
			<july:headercolumn key="label.mutualrules.chargedaterule" colType="string"/>
			<july:headercolumn key="label.mutualrules.paydaterule" colType="string"/>
			<td class="title" title="<bean:message key="label.mutualrules.dopchargdatrul"/>">!</td>
			<td class="title">Тип курса</td>
		</tr>


		<july:separator colspan="5"/>


		<!-- Table body -->
		<logic:iterate id="mr" name="mutualrulesList">
			<logic:present name="mr">
				<tr>
					<td class="text">
						<bean:write name="mr" property="resource.name" filter="true"/>
					</td>
					<td class="link">
						<logic:equal name="mr" property="chargedaterule" value="A"><bean:message key="label.mutualrules.chargedaterule.date"/></logic:equal>
						<logic:equal name="mr" property="chargedaterule" value="B"><bean:message key="label.mutualrules.chargedaterule.begin"/></logic:equal>
						<logic:equal name="mr" property="chargedaterule" value="C"><bean:message key="label.mutualrules.chargedaterule.end"/></logic:equal>
						<logic:equal name="mr" property="chargedaterule" value="D"><bean:message key="label.mutualrules.chargedaterule.d"/></logic:equal>
						<logic:equal name="mr" property="chargedaterule" value="E"><bean:message key="label.mutualrules.chargedaterule.e"/></logic:equal>
						<logic:equal name="mr" property="chargedaterule" value="F"><bean:message key="label.mutualrules.chargedaterule.f"/></logic:equal>
						<logic:equal name="mr" property="chargedaterule" value="H"><bean:message key="label.mutualrules.chargedaterule.h"/></logic:equal>
						<logic:equal name="mr" property="chargedaterule" value="J"><bean:message key="label.mutualrules.chargedaterule.j"/></logic:equal>
					</td>
					<td class="text">
						<logic:equal name="mr" property="paydaterule" value="A"><bean:message key="label.mutualrules.paydaterule.date"/></logic:equal>
						<logic:equal name="mr" property="paydaterule" value="B"><bean:message key="label.mutualrules.paydaterule.begin"/></logic:equal>
						<logic:equal name="mr" property="paydaterule" value="C"><bean:message key="label.mutualrules.paydaterule.end"/></logic:equal>
					</td>
					<td class="text" align="center">
						<logic:equal name="mr" property="dopchargdatrul" value="true">+</logic:equal>
					</td>
					<td class="text">
						<logic:equal name="mr" property="rateType" value="1">Курс ЦБ РФ</logic:equal>
						<logic:equal name="mr" property="rateType" value="3">Внутренний курс Вымпелкома</logic:equal>
					</td>					
				</tr>
				<july:separator colspan="5"/>
			</logic:present>
		</logic:iterate>
	</table>
	</td></tr>
	
</logic:present>
<logic:notPresent name="mutualrulesList">
		&nbsp;-&nbsp;<bean:message key="label.nodata"/>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
</logic:notPresent>


	</logic:equal>
	
<%--	
<logic:notEqual name="<%= form %>" property="actType" value="S">
		<tr class="title">
			<td class="title" colspan="<%= gColSpan %>">
				<july:link page="<%= phones %>" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument">
					<bean:message key="label.mutualreglmnts.phones"/>
				</july:link>
				
	<logic:present name="phonesList">
	
			</td>
		</tr>
		
		<july:separator colspan="<%= gColSpan %>"/>
		
		<tr><td colspan="<%= gColSpan %>">
		<table class="main">
	
			<!-- Table header -->
			<tr class="title" style="background-color: 'D6EBFF'">
				<july:headercolumn key="label.phonemutreglmnt" colType="string"/>
			</tr>
	
			<july:separator colspan="1"/>
	
			<!-- Table body -->
			<logic:iterate id="pl" name="phonesList">
				<logic:present name="pl">
					<tr>
						<td class="link">
							<bean:write name="pl" property="phone" filter="true"/>
						</td>
	    	        </tr>
					<july:separator colspan="1"/>
				</logic:present>
			</logic:iterate>	
			
		</table>
		</td></tr>
		
	</logic:present>
	<logic:notPresent name="phonesList">
			&nbsp;-&nbsp;<bean:message key="label.nodata"/>
			</td>
		</tr>
		<july:separator colspan="<%= gColSpan %>"/>
	</logic:notPresent>
</logic:notEqual>
--%>
