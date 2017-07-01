<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%--
<% String gColSpan = null; %>

<%
	String action = null;
	String form = null;
	String parent = null;
	String parent2 = null;
	String parent3 = null;
	String edit = null;
	String parentCaption = null;
	String state = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.CALC_CONTRACT_LIST:
			action = "/ShowCalcContractList.do";
			form = "CalcContractListForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/EditCalcContractStep1.do";
			parent3 = "/EditCalcContractStep2.do";
			//edit = "/EditPayment.do";
			//state = "/EditPaymentState.do?action=Edit";
			break;
		/*case APPStates.HISTORY_PAYMENTS_LIST:
			action = "/ShowHistoryPaymentsList.do";
			form = "HistoryPaymentsListForm";
			parent = "/ViewHistory.do";
			edit = "/EditHistoryPayment.do";
			state = "/EditHistoryPaymentState.do?action=Edit";
			break;
		case APPStates.US_PAYMENTS_LIST:
			action = "/ShowUsPaymentsList.do";
			form = "UsPaymentsListForm";
			parent = "/ShowUsArendaList.do";
			edit = "/EditUsPayment.do";
			parentCaption = "label.us";
			state = "/EditUsPaymentState.do?action=Edit";
			break;
		case APPStates.CHANNEL_PAYMENTS_LIST:
			action = "/ShowChannelPaymentsList.do";
			form = "ChannelPaymentsListForm";
			parent = "/ShowChannelArendaList.do";
			edit = "/EditChannelPayment.do";
			parentCaption = "label.channel";
			state = "/EditChannelPaymentState.do?action=Edit";
			break;*/
	}

%>

<july:browseform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="leaseContract"/>

<logic:equal name="<%= form %>" property="actionForm" value="A">
	<% gColSpan = "19"; %>
</logic:equal>

<logic:equal name="<%= form %>" property="actionForm" value="B">
	<% gColSpan = "27"; %>
</logic:equal>

<table class="main">
--%>
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
			<july:sepmark/>
			<july:editlink page="<%= parent %>" action="View" styleClass="navigator">
				<bean:message key="label.view"/>
			</july:editlink>
			<july:sepmark/>
			<july:editlink page="<%= parent2 %>" action="Add" styleClass="navigator">
				<bean:message key="label.contractcalc.step1"/>
			</july:editlink>
			<july:sepmark/>
			<july:editlink page="<%= parent3 %>" action="Add" styleClass="navigator">
				<bean:message key="label.contractcalc.step2"/>
			</july:editlink>
			<july:sepmark/>
			<july:currmark><bean:message key="label.contractcalc"/></july:currmark>
			
			<%--	if (ParamsParser.getState(pageContext) == APPStates.PAYMENTS_LIST ||
				ParamsParser.getState(pageContext) == APPStates.HISTORY_PAYMENTS_LIST) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.HISTORY_PAYMENTS_LIST) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
				<%	} %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator">
					<bean:message key="label.view"/>
				</july:editlink>
			<%	} else {%>
				<html:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentCaption %>"/></html:link>
			<%	} %>
			<july:sepmark/>
			<july:currmark><bean:message key="label.payments"/></july:currmark>
		</td>
	</tr>
 
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
					<td class="text" nowrap><bean:write name="<%= form %>" property="orgCustomer" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.executor"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="orgExecutor" filter="true"/></td>
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
				<tr>
					<td class="text"><bean:message key="label.contractcalc.resource"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="resourcename" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.contractcalc.userdates"/>:</td>
					<td class="text">
						<july:datewrite name="<%= form %>" property="userbegindate"/>&nbsp;
						<bean:message key="label.filter.stop"/>&nbsp;
						<july:datewrite name="<%= form %>" property="userenddate"/>
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
						<% temp = parent3 + "?action=Add"; %>
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
		<td rowspan="3" align="center"><b><bean:message key="label.contractcalc.table.date"/></b></td>
		<td colspan="6" align="center"><b><bean:message key="label.contractcalc.table.contract"/></b></td>
		<logic:equal name="<%= form %>" property="actionForm" value="B">
			<td colspan="8" align="center"><b><bean:message key="label.contractcalc.table.dogs"/></b></td>
		</logic:equal>
		<td colspan="2" rowspan="2" align="center"><b><bean:message key="label.contractcalc.table.saldo"/></b></td>
	</tr>
	<tr class="title">
		<td colspan="2" align="center"><b><bean:message key="label.contractcalc.table.charges"/></b></td>
		<td colspan="4" align="center"><b><bean:message key="label.contractcalc.table.payments"/></b></td>
		<logic:equal name="<%= form %>" property="actionForm" value="B">
			<td rowspan="2" align="center"><b><bean:message key="label.contractcalc.table.contract"/></b></td>
			<td colspan="3" align="center"><b><bean:message key="label.contractcalc.table.charges"/></b></td>
			<td colspan="4" align="center"><b><bean:message key="label.contractcalc.table.payments"/></b></td>
		</logic:equal>
	</tr>
	<tr class="title">
		<july:headercolumn key="label.contractcalc.table.sum" colType="string"/>
		<july:headercolumn key="label.contractcalc.table.rate" colType="string"/>
		<july:headercolumn key="label.contractcalc.table.numberpp" colType="string"/>
		<july:headercolumn key="label.contractcalc.table.sumrub" colType="string"/>
		<july:headercolumn key="label.contractcalc.table.rate" colType="string"/>
		<july:headercolumn key="label.contractcalc.table.sumact" colType="string"/>
		<logic:equal name="<%= form %>" property="actionForm" value="B">
			<july:headercolumn key="label.contractcalc.table.resource" colType="string"/>
			<july:headercolumn key="label.contractcalc.table.sum" colType="string"/>
			<july:headercolumn key="label.contractcalc.table.rate" colType="string"/>
			<july:headercolumn key="label.contractcalc.table.numberpp" colType="string"/>
			<july:headercolumn key="label.contractcalc.table.sumrub" colType="string"/>
			<july:headercolumn key="label.contractcalc.table.rate" colType="string"/>
			<july:headercolumn key="label.contractcalc.table.sumact" colType="string"/>
		</logic:equal>
		<july:headercolumn key="label.contractcalc.table.summainact" colType="string"/>
		<july:headercolumn key="label.contractcalc.table.sumaddact" colType="string"/>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="link">
					<logic:notEqual name="<%= form %>" property="stateOfContract" value="C">
						<logic:equal name="it" property="o.paymentstate" value="G"><% temp = "Edit"; %></logic:equal>
						<logic:notEqual name="it" property="o.paymentstate" value="G"><% temp = "View"; %></logic:notEqual>
					</logic:notEqual>
					<logic:equal name="<%= form %>" property="stateOfContract" value="C"><% temp = "View"; %></logic:equal>
					<july:editbutton page="<%= edit %>" action="<%= temp %>" paramId="leaseDocPosition" paramName="it" paramProperty="o.leaseDocPosition" paramScope="page"/>
				</td>
				<td class="link">
					<july:link page="<%= state %>" paramId="leaseDocPosition" paramName="it" paramProperty="o.leaseDocPosition" paramScope="page">
						<logic:equal name="it" property="o.paymentstate" value="G"><bean:message key="label.payments.state.edit"/></logic:equal>
						<logic:equal name="it" property="o.paymentstate" value="P"><bean:message key="label.payments.state.p"/></logic:equal>
						<logic:equal name="it" property="o.paymentstate" value="N"><bean:message key="label.payments.state.n"/></logic:equal>
						<logic:equal name="it" property="o.paymentstate" value="K"><bean:message key="label.payments.state.k"/></logic:equal>
						<logic:equal name="it" property="o.paymentstate" value="M"><bean:message key="label.payments.state.m"/></logic:equal>
					</july:link>
				</td>
				<td class="text">
					<bean:write name="it" property="o.docNumber" filter="true"/>
				</td>
				<td class="text">
					<july:datewrite name="it" property="o.date"/>
				</td>
				<td class="text">
					<logic:present name="it" property="orgExecutor">
						<bean:write name="it" property="orgExecutor.name" filter="true"/>
					</logic:present>
				</td>
				<td class="text">
					<logic:present name="it" property="orgAcc">
						<bean:write name="it" property="orgAcc.accountvalue" filter="true"/>
					</logic:present>
				</td>
				<td class="text">
					<bean:write name="it" property="payPurpose" filter="true"/>
				</td>
				<td class="text">
					<logic:present name="it" property="billDate">
						<july:datewrite name="it" property="billDate"/>
					</logic:present>
				</td>
				<td class="text">
					<bean:write name="it" property="billNumber" filter="true"/>
				</td>
				<td class="number">
					<july:sumwrite name="it" property="o.sumRub"/>
				</td>
				<td class="number">
					<july:sumwrite name="it" property="o.payrate"/>
				</td>
				<td class="number">
					<july:sumwrite name="it" property="o.summ"/>
				</td>
				<td class="text">
					<july:datewrite name="it" property="o.begindate"/>
				</td>
				<td class="text">
					<july:datewrite name="it" property="o.enddate"/>
				</td>
				<td class="text">
					<bean:write name="it" property="o.resource.name" filter="true"/>
				</td>
				<td class="number">
					<july:sumwrite name="it" property="o.rurremainder"/>
				</td>
				<td class="text">
					<logic:equal name="it" property="o.source" value="A"><bean:message key="label.docpositions.source.auto"/></logic:equal>
					<logic:equal name="it" property="o.source" value="B"><bean:message key="label.docpositions.source.bill"/></logic:equal>
					<logic:equal name="it" property="o.source" value="P"><bean:message key="label.docpositions.source.platinum"/></logic:equal>
					<logic:equal name="it" property="o.source" value="M"><bean:message key="label.docpositions.source.manual"/></logic:equal>
				</td>
				<td class="text">
					<logic:equal name="it" property="o.docposvid" value="Q"><bean:message key="label.docpositions.docposvid.q"/></logic:equal>
					<logic:equal name="it" property="o.docposvid" value="K"><bean:message key="label.docpositions.docposvid.k"/></logic:equal>
					<logic:equal name="it" property="o.docposvid" value="Z"><bean:message key="label.docpositions.docposvid.z"/></logic:equal>
					<logic:equal name="it" property="o.docposvid" value="N"><bean:message key="label.docpositions.docposvid.n"/></logic:equal>
					<logic:equal name="it" property="o.docposvid" value="C"><bean:message key="label.docpositions.docposvid.c"/></logic:equal>
				</td>
				<td class="link">
					<logic:notEqual name="<%= form %>" property="stateOfContract" value="C">
						<logic:equal name="it" property="o.paymentstate" value="G">
							<% temp = edit + "?action=Delete"; %>
							<july:delbutton page="<%= temp %>" paramId="leaseDocPosition" paramName="it" paramProperty="o.leaseDocPosition" paramScope="page"/>
						</logic:equal>
					</logic:notEqual>
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
						<% temp = parent3 + "?action=Add"; %>
						<july:backbutton page="<%= temp %>"/>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
--%>	
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
			<july:sepmark/>
			<july:editlink page="<%= parent %>" action="View" styleClass="navigator">
				<bean:message key="label.view"/>
			</july:editlink>
			<july:sepmark/>
			<july:editlink page="<%= parent2 %>" action="Add" styleClass="navigator">
				<bean:message key="label.contractcalc.step1"/>
			</july:editlink>
			<july:sepmark/>
			<july:editlink page="<%= parent3 %>" action="Add" styleClass="navigator">
				<bean:message key="label.contractcalc.step2"/>
			</july:editlink>
			<july:sepmark/>
			<july:currmark><bean:message key="label.contractcalc"/></july:currmark>
			
			<%--	if (ParamsParser.getState(pageContext) == APPStates.PAYMENTS_LIST ||
				ParamsParser.getState(pageContext) == APPStates.HISTORY_PAYMENTS_LIST) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.HISTORY_PAYMENTS_LIST) { %>
						<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
						<july:sepmark/>
				<%	} %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator">
					<bean:message key="label.view"/>
				</july:editlink>
			<%	} else {%>
				<html:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentCaption %>"/></html:link>
			<%	} %>
			<july:sepmark/>
			<july:currmark><bean:message key="label.payments"/></july:currmark>
		</td>
	</tr>

</table>
</july:browseform>
--%>