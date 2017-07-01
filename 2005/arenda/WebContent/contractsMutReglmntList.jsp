<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %> 
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "8"; %>

<%

    String action = null;
	String form = null;
	String parent = null;
	String edit = null;
	String temp = null;
	String parent2 = null;
	String parent3 = null;

	switch (ParamsParser.getState(pageContext)) {

		case APPStates.CONTRACTS_MUTREGLMNT_LIST:

			action = "/ShowContractsMutReglmntList.do";

			form = "ContractsMutReglmntListForm";

			edit = "/EditContractMutReglmnt.do";

			parent2 = "/ShowMutualReglamentsList.do";

			parent3 = "/ViewMainParamsMutReglmnt.do";

			break;

		case APPStates.FROMCONTRACT_CONTRACTS_MUTREGLMNT_LIST:

			action = "/ShowFromContractContractsMutReglmntList.do";

			form = "FromContractContractsMutReglmntListForm";

			parent = "/ViewWeArenda.do";

			edit = "/EditFromContractContractMutReglmnt.do";

			parent2 = "/ShowFromContractMutualReglamentsList.do";

			parent3 = "/ViewFromContractMainParamsMutReglmnt.do";

        	break;

		case APPStates.FROMHISTORY_CONTRACTS_MUTREGLMNT_LIST:

        	action = "/ShowFromHistoryContractsMutReglmntList.do";

			form = "FromHistoryContractsMutReglmntListForm";

			parent = "/ViewHistory.do";

			edit = "/EditFromHistoryContractMutReglmnt.do";

			parent2 = "/ShowFromHistoryMutualReglamentsList.do";

			parent3 = "/ViewFromHistoryMainParamsMutReglmnt.do";

        	break;

    }

%>

<july:browseform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="mainLeaseDocument"/>

<table class="main">
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="normal">

		<td colspan="<%= gColSpan %>">

			<table class="find">

				<tr>

					<td class="text"><bean:message key="label.mutualreglmnts.docnumber"/>:</td>

					<td class="text">

						<bean:write name="<%= form %>" property="documentNumber" filter="true"/>

					</td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.mutualreglmnts.docdate"/>:</td>

					<td class="text">

						<july:datewrite name="<%= form %>" property="documentDate"/>

					</td>

				</tr>			

				<tr>

					<td class="text"><bean:message key="label.mutualreglmnts.acttype"/>:</td>

					<td class="text">

						<logic:equal name="<%= form %>" property="actType" value="A"><bean:message key="label.mutualreglmnts.acttype.vz"/></logic:equal>

						<logic:equal name="<%= form %>" property="actType" value="M"><bean:message key="label.mutualreglmnts.acttype.vt"/></logic:equal>

					</td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.mutualreglmnts.mutualperiod"/>:</td>

					<td class="text">

						<logic:equal name="<%= form %>" property="mutualPeriod" value="M"><bean:message key="label.mutualreglmnts.mutualperiod.month"/></logic:equal>

						<logic:equal name="<%= form %>" property="mutualPeriod" value="Q"><bean:message key="label.mutualreglmnts.mutualperiod.quarter"/></logic:equal>

					</td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.mutualreglmnts.maincurrency"/>:</td>

					<td class="text">

						<bean:write name="<%= form %>" property="mainCurrency" filter="true"/>

					</td>

				</tr>

				

				<logic:present name="<%= form %>" property="additionalCurrency">

					<tr>

						<td class="text"><bean:message key="label.mutualreglmnts.additionalcurrency"/>:</td>

						<td class="text">

							<bean:write name="<%= form %>" property="additionalCurrency" filter="true"/>

						</td>

					</tr>

				</logic:present>

				

				<tr>

					<td class="text"><bean:message key="label.mutualreglmnts.commonrate"/>:</td>

					<td class="text">

						<july:checkbox property="commonRate" insertable="false" updatable="false"/>

					</td>

				</tr>

				

				<logic:equal name="<%= form %>" property="commonRate" value="true">

					<tr>

						<td class="text"><bean:message key="label.mutualreglmnts.calcratetype.all"/>:</td>

						<td class="text">

							<logic:present name="<%= form %>" property="calcRateType">

								<logic:equal name="<%= form %>" property="calcRateType" value="B"><bean:message key="label.mutualreglmnts.calcratetype.begin"/></logic:equal>

								<logic:equal name="<%= form %>" property="calcRateType" value="E"><bean:message key="label.mutualreglmnts.calcratetype.end"/></logic:equal>

							</logic:present>

						</td>

					</tr>

				</logic:equal>

				

				<logic:equal name="<%= form %>" property="commonRate" value="false">



					<tr>

						<td class="text" colspan="2"><bean:message key="label.mutualreglmnts.calcratetype.one"/></td>

					</tr>

				

				</logic:equal>

			</table>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr class="title">

		<td colspan="<%= gColSpan %>">

			<table class="buttons">

				<tr class="title">

					<td class="buttons">

						<july:canedit rolesProperty="editRoles">

							<logic:equal name="<%= form %>" property="state" value="A">

								<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>

							</logic:equal>

						</july:canedit>

						<% temp = parent3 + "?action=View&isShowMessage=0"; %>

						<july:backbutton page="<%= temp %>"/>

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

		<july:headercolumn key="label.mutualreglmnts.date" colType="date"/>

		<july:headercolumn key="label.mutualreglmnts.number" colType="string"/>

		<july:headercolumn key="label.mutualreglmnts.orgcustomer" colType="string"/>

		<july:headercolumn key="label.mutualreglmnts.orgexecutor" colType="string"/>

		<july:headercolumn key="label.contracttype" colType="string"/>

		<july:headercolumn key="label.mutualreglmnts.resource" colType="string"/>

		<td class="title">&nbsp;</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<!-- Table body -->

	<logic:iterate id="it" name="browseList">

		<logic:present name="it">

			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

				<td class="link">

					<july:editbutton page="<%= edit %>" action="View" name="it" property="params" scope="page"/>

				</td>

				<td class="date">

					<july:datewrite name="it" property="o.contract.documentDate"/>

				</td>

				<td class="text">

					<bean:write name="it" property="o.contract.documentNumber" filter="true"/>

				</td>

				<td class="text">

					<bean:write name="it" property="o.contract.orgCustomer.name" filter="true"/>

				</td>

				<td class="text">

					<bean:write name="it" property="o.contract.orgExecutor.name" filter="true"/>

				</td>

				<td class="text">

					<logic:equal name="it" property="o.contract.contractType" value="A"><bean:message key="label.contracttype.arenda"/></logic:equal>

					<logic:equal name="it" property="o.contract.contractType" value="B"><bean:message key="label.contracttype.arendaus"/></logic:equal>

					<logic:equal name="it" property="o.contract.contractType" value="C"><bean:message key="label.contracttype.user"/></logic:equal>

					<logic:equal name="it" property="o.contract.contractType" value="D"><bean:message key="label.contracttype.channel"/></logic:equal>

				</td>

				<td class="text">

					<bean:write name="it" property="o.resource.name" filter="true"/>

				</td>

				<td class="link">

					<july:canedit rolesProperty="editRoles">

						<logic:equal name="<%= form %>" property="state" value="A">

							<% temp = edit + "?action=Delete"; %>

							<july:delbutton page="<%= temp %>" name="it" property="params" scope="page"/>

						</logic:equal>

					</july:canedit>

				</td>

			</tr>

			<july:separator colspan="<%= gColSpan %>"/>

		</logic:present>

	</logic:iterate>

	

	<tr class="title">

		<td colspan="<%= gColSpan %>">

			<table class="buttons">

				<tr class="title">

					<td class="buttons">

						<july:canedit rolesProperty="editRoles">

							<logic:equal name="<%= form %>" property="state" value="A">

								<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>

							</logic:equal>

						</july:canedit>

						<% temp = parent3 + "?action=View&isShowMessage=0"; %>

						<july:backbutton page="<%= temp %>"/>

					</td>

					<td class="navigator"><july:navigator/></td>

				</tr>

			</table>

		</td>

	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

</table>
</july:browseform>