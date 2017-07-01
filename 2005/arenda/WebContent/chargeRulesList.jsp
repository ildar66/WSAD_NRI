<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "7"; %>

<%

    String action = null;
	String form = null;
	String parent = null;
	String edit = null;
	String temp = null;

	switch (ParamsParser.getState(pageContext)) {

		case APPStates.CHARGE_RULES_LIST:

        	action = "/ShowChargeRulesList.do";

			form = "ChargeRulesListForm";

			parent = "/ViewWeArenda.do";

			edit = "/EditChargeRule.do";

        	break;

		case APPStates.HISTORY_CHARGE_RULES_LIST:

        	action = "/ShowHistoryChargeRulesList.do";

			form = "HistoryChargeRulesListForm";

			parent = "/ViewHistory.do";

			edit = "/EditHistoryChargeRule.do";

        	break;

    }

%>



<july:browseform action="<%= action %>" styleId="<%= form %>">



<html:hidden property="leaseDocument"/>



<table class="main">

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>

			<july:sepmark/>

			<%	if (ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_RULES_LIST) { %>

				<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>

				<july:sepmark/>

        	<% } %>

			<july:editlink page="<%= parent %>" action="View" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument" styleClass="navigator">

				<bean:message key="label.view"/>

			</july:editlink>

			<july:sepmark/>

			<july:currmark><bean:message key="label.chargerules"/></july:currmark>

		</td>

	</tr>
--%>



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

			</table>

		</TD>

	</TR>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr class="title">

		<td colspan="<%= gColSpan %>">

			<table class="buttons">

				<tr class="title">

					<td class="buttons">

						<july:canedit rolesProperty="editRoles">

							<logic:equal name="<%= form %>" property="stateOfContract" value="A">

								<% temp = edit + "?action=Add"; %>

								<july:addbutton page="<%= temp %>"/>

							</logic:equal>

						</july:canedit>

						<% temp = parent + "?action=View"; %>

						<july:backbutton page="<%= temp %>" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument"/>

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

		<july:headercolumn key="label.chargerules.service" colType="string"/>

		<july:headercolumn key="label.chargerules.sum" colType="string"/>

		<july:headercolumn key="label.chargerules.currency" colType="string"/>

		<july:headercolumn key="label.chargerules.period" colType="string"/>

		<july:headercolumn key="label.chargerules.ruledate" colType="string"/>

		<td class="title">&nbsp;</td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>



	<!-- Table body -->

	<logic:iterate id="it" name="browseList">

		<logic:present name="it">

			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

				<td class="link">

					<% temp = "View"; %>

					<july:canedit rolesProperty="editRoles">

						<logic:equal name="<%= form %>" property="stateOfContract" value="A">

							<% temp = "Edit"; %>

						</logic:equal>

					</july:canedit>

					<july:editbutton page="<%= edit %>" action="<%= temp %>" paramId="leaseRule" paramName="it" paramProperty="leaseRule" paramScope="page"/>

				</td>

				<td class="text">

					<bean:write name="it" property="resource.name" filter="true"/>

				</td>

				<td class="number" align="right">

					<july:sumwrite name="it" property="sum"/>

				</td>

				<td class="text">

					<bean:write name="it" property="curency.shortname" filter="true"/>

				</td>

				<td class="text">

					<logic:equal name="it" property="chargePeriod" value="M"><bean:message key="label.chargerules.period.month"/></logic:equal>

					<logic:equal name="it" property="chargePeriod" value="Q"><bean:message key="label.chargerules.period.quarter"/></logic:equal>

					<logic:equal name="it" property="chargePeriod" value="Y"><bean:message key="label.chargerules.period.year"/></logic:equal>

				</td>

				<td class="text" wrap>

					<logic:equal name="it" property="chargeDateRule" value="S"><bean:message key="label.chargerules.daterule.startperiod"/></logic:equal>

					<logic:equal name="it" property="chargeDateRule" value="E"><bean:message key="label.chargerules.daterule.endperiod"/></logic:equal>

                </td>

				<td class="link">

					<july:canedit rolesProperty="editRoles">

						<logic:equal name="<%= form %>" property="stateOfContract" value="A">

							<% temp = edit + "?action=Delete"; %>

							<july:delbutton page="<%= temp %>" paramId="leaseRule" paramName="it" paramProperty="leaseRule" paramScope="page"/>

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

							<logic:equal name="<%= form %>" property="stateOfContract" value="A">

								<% temp = edit + "?action=Add"; %>

								<july:addbutton page="<%= temp %>"/>

							</logic:equal>

						</july:canedit>

						<% temp = parent + "?action=View"; %>

						<july:backbutton page="<%= temp %>" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument"/>

					</td>

					<td class="navigator"><july:navigator/></td>

				</tr>

			</table>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>



<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>

			<july:sepmark/>

			<%	if (ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_RULES_LIST) { %>

				<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>

				<july:sepmark/>

        	<% } %>

			<july:editlink page="<%= parent %>" action="View" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument" styleClass="navigator">

				<bean:message key="label.view"/>

			</july:editlink>

			<july:sepmark/>

			<july:currmark><bean:message key="label.chargerules"/></july:currmark>

		</td>

	</tr>
--%>



</table>



</july:browseform>

