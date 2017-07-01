<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "12"; %>

<%

    String action = null;
	String labelCaption = null;
	String edit = null;
	String form = null;
	String actionState = null;
	String temp = null;
	String payments = null;
	String charges = null;
	String saldo = null;

	switch (ParamsParser.getState(pageContext)) {

		case APPStates.US_ARENDA_LIST:

        	action = "/ShowUsArendaList.do";

			labelCaption = "label.us";

			edit = "EditUsArenda";

			form = "UsArendaListForm";

			actionState = "/EditUsState.do?action=";

			payments = "/ShowUsPaymentsList.do";

			charges = "/ShowUsChargesList.do";

			saldo = "/ShowUsSaldoList.do";

			break;

		case APPStates.CHANNEL_ARENDA_LIST:

			action = "/ShowChannelArendaList.do";

			labelCaption = "label.channel";

			edit = "EditChannelArenda";

			form = "ChannelArendaListForm";

			actionState = "/EditChannelState.do?action=";

			payments = "/ShowChannelPaymentsList.do";

			charges = "/ShowChannelChargesList.do";

			saldo = "/ShowChannelSaldoList.do";

			break;

	}

%>



<july:browseform action="<%= action %>" styleId="<%= form %>">

<script language="javascript">

function switchCustomer() {

	if (document.all.isCustomer[0].checked) { // use not [0] -> styleId in checkBox

		<%= form %>.customercode.className = 'editkoddisabled';

		<%= form %>.customercode.disabled = true;

		document.all['lookupimg_custl'].src='/images/lookup_disabled.gif';

	} else {

		<%= form %>.customercode.className = 'editkodsearch';

		<%= form %>.customercode.disabled = false;

		document.all['lookupimg_custl'].src='/images/lookup.gif';

	}

}

function switchExecutor() {

	if (document.all.isExecutor[0].checked) {

		<%= form %>.executor.className = 'editdisabled';

		<%= form %>.executor.disabled = true;

	} else {

		<%= form %>.executor.className = 'editsearch';

		<%= form %>.executor.disabled = false;

	}

}

function switchEconomist() {

	if (document.all.isEconomist[0].checked) {

		<%= form %>.economistcode.className = 'editkoddisabled';

		<%= form %>.economistcode.disabled = true;

		document.all['lookupimg_economistl'].src='/images/lookup_disabled.gif';

	} else {

		<%= form %>.economistcode.className = 'editkodsearch';

		<%= form %>.economistcode.disabled = false;

		document.all['lookupimg_economistl'].src='/images/lookup.gif';

	}

}

function switchDocnumber() {

	if (document.all.isDocnumber[0].checked) {

		<%= form %>.docnumber.className = 'editdisabled';

		<%= form %>.docnumber.disabled = true;

	} else {

		<%= form %>.docnumber.className = 'editsearch';

		<%= form %>.docnumber.disabled = false;

	}

}

</script>



<table class="main">

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>"><july:currmark><bean:message key="<%= labelCaption %>"/></july:currmark></td>

	</tr>

--%>


	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr class="normal">

		<td colspan="<%= gColSpan %>">

			<table class="find">

				<tr>

					<td class="text"><bean:message key="label.filter.executor"/></td>

					<td class="text" nowrap>

						<july:checkbox property="isExecutor" insertable="true" updatable="true" onclick="switchExecutor()"/>

						<bean:message key="label.filter.all"/>

						<july:select styleId="executor" style="width: 300;" collection="executors" property="executorcode" insertable="true" updatable="true">

							<html:options collection="executors" property="organization" labelProperty="name"/>

						</july:select>

						<july:searchbutton/>

					</td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.filter.customer"/></td>

					<td class="text" nowrap>

						<july:checkbox property="isCustomer" insertable="true" updatable="true" onclick="switchCustomer()"/>

						<bean:message key="label.filter.all"/>

						<july:string property="customercode" styleId="customercode" size="5" insertable="true" updatable="true"/>

						<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="custl" fieldNames="customercode;customername" insertable="true" updatable="true" onclick="if (document.all.isCustomer[0].checked) { return false; }"/>

						<july:string size="50" property="customername" styleId="customername" insertable="false" updatable="false"/>

					</td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.filter.responsible"/></td>

					<td class="text" nowrap>

						<july:checkbox property="isEconomist" insertable="true" updatable="true" onclick="switchEconomist()"/>

						<bean:message key="label.filter.all"/>

						<july:string property="economistcode" styleId="economistcode" size="5" insertable="true" updatable="true"/>

						<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="economistl" fieldNames="economistcode;economistname" insertable="true" updatable="true" onclick="if (document.all.isEconomist[0].checked) { return false; }"/>

						<july:string size="50" property="economistname" styleId="economistname" insertable="false" updatable="false"/>

					</td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.filter.docnumber"/></td>

					<td class="text">

						<july:checkbox property="isDocnumber" insertable="true" updatable="true" onclick="switchDocnumber()"/>

						<bean:message key="label.filter.all"/>

						<july:string size="50" property="docnumber" styleId="docnumber" insertable="true" updatable="true"/>

					</td>

				</tr>

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

							<% temp = "/" + edit + ".do?action=Add"; %>

							<july:addbutton page="<%= temp %>"/>

						</july:canedit>

						<july:backbutton page="/main.do"/>

					</td>

					<td class="navigator"><july:navigator/></td>

				</tr>

			</table>

		</td>

	</tr>



<script language="javascript">

	switchCustomer();

	switchExecutor();

	switchEconomist();

	switchDocnumber();

</script>

	

	<july:separator colspan="<%= gColSpan %>"/>



	<!-- Table header -->

	<tr class="title">

		<td class="title">&nbsp;</td>

		<july:headercolumn key="label.table.docnumber" colType="string"/>

		<july:headercolumn key="label.table.startdate" colType="string"/>

		<july:headercolumn key="label.table.finishdate" colType="string"/>

		<td colspan="2" align="center"><b><bean:message key="label.table.sumofcontract"/></b></td>

		<july:headercolumn key="label.table.forview" colType="string"/>

		<july:headercolumn key="label.table.state" colType="string"/>

		<july:headercolumn key="label.table.charges" colType="string"/>

		<july:headercolumn key="label.table.payments" colType="string"/>

		<july:headercolumn key="label.saldo.short" colType="string"/>

		<td class="title">&nbsp;</td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>



	<!-- Table body -->

	<logic:iterate id="it" name="browseList">

		<logic:present name="it">

			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

				<td class="link">

					<% temp = "/" + edit + ".do"; String actionTmp = "View"; %>

					<july:canedit rolesProperty="editRoles"><% actionTmp = "Edit"; %></july:canedit>

					<july:editbutton page="<%= temp %>" action="<%= actionTmp %>" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" paramScope="page"/>

				</td>

				<td class="text">

					<bean:write name="it" property="documentNumber"/>

				</td>

 				<td class="date">

					<july:datewrite name="it" property="startDate"/>

                </td>

 				<td class="date">

                    <july:datewrite name="it" property="endDate"/>

                </td>

 				<td class="text">

					<july:sumwrite name="it" property="summ1"/>

					<logic:present name="it" property="summ1">

						&nbsp;<bean:write name="it" property="currency1.shortname" filter="true"/>

					</logic:present>

                </td>

 				<td class="text">

					<july:sumwrite name="it" property="summ2"/>

					<logic:present name="it" property="summ2">

						&nbsp;<bean:write name="it" property="currency2.shortname" filter="true"/>

					</logic:present>

                </td>

				<td class="link" align="center">

				</td>



				<td class="link" align="center">

					<% temp = actionState + "View"; %>

					<july:canedit rolesProperty="editRoles"><% temp = actionState + "Edit"; %></july:canedit>

					<july:link page="<%= temp %>" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" paramScope="page">

                		<logic:equal name="it" property="contractState" value="A"><bean:message key="label.state.prepared"/></logic:equal>

						<logic:equal name="it" property="contractState" value="B"><bean:message key="label.state.continued"/></logic:equal>

						<logic:equal name="it" property="contractState" value="C"><bean:message key="label.state.stoped"/></logic:equal>

					</july:link>

				</td>



				<td class="link" align="center">

					<july:link page="<%= charges %>" paramId="leaseContract" paramName="it" paramProperty="leaseDocument" paramScope="page">

						<bean:message key="label.table.charges"/>

					</july:link>

                </td>

				<td class="link">

					<july:link page="<%= payments %>" paramId="leaseContract" paramName="it" paramProperty="leaseDocument" paramScope="page">

						<bean:message key="label.table.payments"/>

					</july:link>

				</td>

				<td class="link">

					<july:link page="<%= saldo %>" paramId="leaseContract" paramName="it" paramProperty="leaseDocument" paramScope="page">

						<bean:message key="label.saldo.short"/>

					</july:link>

				</td>

				<td class="link">

					<july:canedit rolesProperty="editRoles">

						<% temp = "/" + edit + ".do?action=Delete"; %>

						<july:delbutton page="<%= temp %>" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" paramScope="page"/>

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

							<% temp = "/" + edit + ".do?action=Add"; %>

							<july:addbutton page="<%= temp %>"/>

						</july:canedit>

						<july:backbutton page="/main.do"/>

					</td>

					<td class="navigator"><july:navigator/></td>

				</tr>

			</table>

		</td>

	</tr>

		

	<july:separator colspan="<%= gColSpan %>"/>

	

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>"><july:currmark><bean:message key="<%= labelCaption %>" /></july:currmark></td>

	</tr>
--%>

	

</table>



</july:browseform>

