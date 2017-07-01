<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.valueobject.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import ="com.hps.july.jdbcpersistence.lib.*"%>

<% String gColSpan = "13"; %>
<%!private String isUp(String aSort, String name) {
	if (aSort.startsWith(name)) {
		if (aSort.endsWith("desc"))
			return ("<img src='/images/up.gif'  border='0' alt='по возрастанию'>");
		else
			return ("<img src='/images/down.gif'  border='0' alt='по убыванию'>");
	} else
		return ("");
}
%>

<%
	String action = null;
	String form = null;
	String parent = null;
	String edit = null;
	String parentCaption = "";
	String state = null;
	String rate = null;
	String temp = null;
	String getpay = null; 
	String getpays = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.PAYMENTS_LIST:
        	action = "/ShowPaymentsList.do";
			form = "PaymentsListForm";
			parent = "/ViewWeArenda.do";
			edit = "/EditPayment.do";
			state = "/EditPaymentState.do?action=";
			rate = "/ShowPaymentRatesList.do";
			gColSpan = "15";
			getpay = "/GetPayFromPlatinum.do";
			getpays = "/EditGetPaysByContract.do";
        	break;
		case APPStates.HISTORY_PAYMENTS_LIST:
        	action = "/ShowHistoryPaymentsList.do";
			form = "HistoryPaymentsListForm";
			parent = "/ViewHistory.do";
			edit = "/EditHistoryPayment.do";
			state = "/EditHistoryPaymentState.do?action=";
			rate = "/ShowHistoryPaymentRatesList.do";
			gColSpan = "15";
			getpay = "/HistoryGetPayFromPlatinum.do";
			getpays = "/EditHistoryGetPaysByContract.do";
        	break;
		case APPStates.US_PAYMENTS_LIST:
        	action = "/ShowUsPaymentsList.do";
			form = "UsPaymentsListForm";
			parent = "/ShowUsArendaList.do";
			edit = "/EditUsPayment.do";
			parentCaption = "label.us";
			state = "/EditUsPaymentState.do?action=";
			rate = "/ShowUsPaymentRatesList.do";
        	break;
		case APPStates.CHANNEL_PAYMENTS_LIST:
        	action = "/ShowChannelPaymentsList.do";
			form = "ChannelPaymentsListForm";
			parent = "/ShowChannelArendaList.do";
			edit = "/EditChannelPayment.do";
			parentCaption = "label.channel";
			state = "/EditChannelPaymentState.do?action=";
			rate = "/ShowChannelPaymentRatesList.do";
        	break;
		case APPStates.ABONENT_PAYMENTS_LIST:
        	action = "/ShowAbonentPaymentsList.do";
			form = "AbonentPaymentsListForm";
			parent = "/ViewAbonent.do";
			edit = "/EditAbonentPayment.do";
			state = "/EditAbonentPaymentState.do?action=";
			rate = "/ShowAbonentPaymentRatesList.do";
        	break;
    }
   //start counter:
   //TimeCounter counter = new TimeCounter("PERF.ARENDA.ShowPaymentsList");
   //counter.start();
%>


<july:browseform action="<%= action %>" styleId="<%= form %>">


<script language="javascript">
function switchDate() {
	if (document.all.isDate[0].checked) {
		<%= form %>.fromDate_dt.enabled = false;
		<%= form %>.toDate_dt.enabled = false;
	} else {
		<%= form %>.fromDate_dt.enabled = true;
		<%= form %>.toDate_dt.enabled = true;
	}
}
function onMouseOutRow(selectedID){
	if(document.all.selectedID.value==selectedID) {
		document.all.tableID.rows(selectedID,0).className="selected";
	}
	else {
		document.all.tableID.rows(selectedID,0).className="normal";
	}
}
function onClickRow(selectedID) {
	if(document.all.tableID.rows(document.all.selectedID.value) != null){
		document.all.tableID.rows(document.all.selectedID.value,0).className="normal";
	}
	document.all.selectedID.value=selectedID;
	document.all.tableID.rows(selectedID,0).className="selected";
	storeSelectedRow(selectedID);
}
function storeSelectedRow(selectedID) {
	document.cookie = <%= form %>.name+"=" + selectedID;
}
function loadSelectedRow() {
	var cookies = document.cookie;
	//считываем selectedID:
	var startLoc = cookies.indexOf(<%= form %>.name+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
	//подчеркиваем строку в таблице:
	if( document.all.tableID.rows(document.all.selectedID.value) != null ) {
 		document.all.tableID.rows(document.all.selectedID.value,0).className="selected";
	}
}
</script>


<html:hidden property="leaseContract"/>
<html:hidden property="sourceContract"/>
<html:hidden property="selectedID" value="0" />


<table class="main" id="tableID" style="font-size: 8pt;">


	<july:separator colspan="<%= gColSpan %>"/>


	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.mainPosition"/></td>
					<td class="text"><bean:write name="<%= form %>" property="mainPosition" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.docnumber"/>:</td>
					<td class="text" nowrap>
						<bean:write name="<%= form %>" property="documentNumber" filter="true"/>&nbsp;
						<bean:message key="label.filter.ot"/>&nbsp;
						<july:datewrite name="<%= form %>" property="documentDate"/>
					</td>
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
				<tr>
					<td class="text"><bean:message key="label.filter.start"/>:</td>
					<td class="text">
						<table class="main" border="0" cellpading="0" cellspacing="0">
							<tr>
								<td class="text">
									<july:checkbox property="isDate" insertable="true" updatable="true" onclick="switchDate()"/>
									<bean:message key="label.filter.all"/>
								</td>
								<td class="text"><july:date property="fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate"/></td>
								<td class="text"><bean:message key="label.filter.stop"/>:</td>
								<td class="text"><july:date property="toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate"/></td>
								<td><july:searchbutton/></td>
							</tr>
						</table>
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
							<%	if (ParamsParser.getState(pageContext) == APPStates.ABONENT_PAYMENTS_LIST) { %>
								<%-- <logic:equal name="AbonentForm" property="flagworkpie" value="false"> --%>
									<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
								<%-- </logic:equal> --%>
							<%	} else { %>
								<logic:notEqual name="<%= form %>" property="stateOfContract" value="A">
									<logic:notEqual name="<%= form %>" property="stateOfContract" value="C">
										<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
									</logic:notEqual>
								</logic:notEqual>
							<%	} %>
						</july:canedit>

							<july:backbutton/>
						
						<% if (ParamsParser.getState(pageContext) == APPStates.PAYMENTS_LIST || ParamsParser.getState(pageContext) == APPStates.HISTORY_PAYMENTS_LIST) { %>
							<%--july:canedit rolesProperty="editRoles">&nbsp;
								<html:link page="<%= getpays %>" paramId="leaseContract" paramName="<%= form %>" paramProperty="leaseContract" paramScope="session"><img src="/images/getpays.gif" border=0 alt="<bean:message key="label.payments.getpayfromplatinums"/>"></html:link>
							</july:canedit--%>
					</td>
					<TD>
							<%--html:link page="/EditStartPayment.do?action=Add&condition=C" paramId="leaseDocumentcodeFrm" paramName="<%= form %>" paramProperty="leaseContract">
								<bean:message key="label.dhist.lnkmakepay"/>
							</html:link--%>
						<% } %>
					</TD>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Table header -->
	<tr class="title">
		<td class="title">&nbsp;</td>
		<july:headercolumn key="label.payments.resource" colType="string"/>
<%--
		<td class="title">&nbsp;</td>
		<%	switch (ParamsParser.getState(pageContext)) {
				case APPStates.PAYMENTS_LIST:
				case APPStates.HISTORY_PAYMENTS_LIST: %>
				<td class="title">&nbsp;</td>
		<%	} %>
--%>
		<july:headercolumn key="label.payments.s_state" colType="string"/>
		<%	switch (ParamsParser.getState(pageContext)) {
				case APPStates.PAYMENTS_LIST:
				case APPStates.HISTORY_PAYMENTS_LIST: %>
				<td class="title">&nbsp;</td>
				<td class="title">&nbsp;</td>
		<%	} %>
		<july:headercolumn key="label.payments.sz" colType="string"/>
		<july:headercolumn key="label.payments.number" colType="string"/>
		<july:sortcolumn key="label.payments.date" colType="string" ascFinder="1" descFinder="2"/>
		<july:headercolumn key="label.payments.sumrub" colType="string"/>
		<td class="title">Платеж<br>НДС</td>
<%--		<july:headercolumn key="label.payments.payrate" colType="string"/>--%>
		<july:headercolumn key="label.payments.sum" colType="string"/>
		<td class="title">&nbsp;</td>
		<%--july:headercolumn key="label.payments.billnumber" colType="string"/--%>
		<%--july:headercolumn key="label.payments.billdate" colType="string"/--%>
		<%--july:headercolumn key="label.payments.begindate" colType="string"/--%>
		<%--july:headercolumn key="label.payments.enddate" colType="string"/--%>
		<%--july:headercolumn key="label.payments.rurremainder" colType="string"/--%>
		<%--july:headercolumn key="label.payments.executor" colType="string"/--%>
		<%--july:headercolumn key="label.payments.executor.account" colType="string"/--%>
		<td class="title">&nbsp;</td>
		<%--july:headercolumn key="label.payments.source" colType="string"/--%>
		<%--july:headercolumn key="label.payments.docposvid" colType="string"/--%>
		<td class="title">&nbsp;</td>
		<td class="title">&nbsp;</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<!-- Table body -->
	<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
		<logic:present name="it">
			<%
				String docPos = it.getColumn("leasedocposition").asString();
				String paymentState = it.getColumn("paymentstate").asString();
				pageContext.setAttribute("paymentstate", paymentState);
				String isSchetFakt = it.getColumn("isschetfakt").asString();
				pageContext.setAttribute("isschetfakt", isSchetFakt);
				String flagOplNds = it.getColumn("flagOplNds").asString();
				pageContext.setAttribute("flagOplNds", flagOplNds);
			%>		
			<tr id='<%= docPos%>' class="normal" onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);"  onclick="onClickRow(this.id);">
				<td class="link">
					<% temp = "View"; %>
					<july:canedit rolesProperty="editRoles">
<%	if (ParamsParser.getState(pageContext) == APPStates.PAYMENTS_LIST || ParamsParser.getState(pageContext) == APPStates.HISTORY_PAYMENTS_LIST || ParamsParser.getState(pageContext) == APPStates.ABONENT_PAYMENTS_LIST)
	{
		try {
			if(it.getColumn("usedinact").asObject() == null) { temp = "Edit"; }
		} catch(Exception e) {
			System.out.println("\n\nException in paymentList.jsp line 259\n\n");
		}
	} else {
%>
		<logic:notEqual name="<%= form %>" property="stateOfContract" value="C">
			<logic:equal name="paymentstate" value="G"><% temp = "Edit"; %></logic:equal>
		</logic:notEqual>
<%	} %>
					</july:canedit>
					<july:editbutton page='<%= edit + "?leaseDocPosition=" + docPos %>' action="<%= temp %>"/>
				</td>
				
				<td class="text">
					<july:stringwrite name="it" property="resname" wrapat="3"/>
				</td>
<%--				
				<td class="link" align="center">
					<html:link page='<%= "/../crystalclear/SlujebnZap.rpt?dll=pdssluzhzap.dll&prompt0=" + docPos %>' onclick="window.open(this.href, 'aa', 'top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes'); return false;">
						<img src="/images/print.gif" border=0 alt="<bean:message key="label.payments.sz.print"/>">
					</html:link>
				</td>
				
				<%	switch (ParamsParser.getState(pageContext)) {
						case APPStates.PAYMENTS_LIST:
						case APPStates.HISTORY_PAYMENTS_LIST: %>
					<td class="link" align="center">
						<july:canedit rolesProperty="editRoles">
							<html:link page='<%= getpay + "?leaseDocPosition=" + docPos %>'>
								<img src="/images/getpays.gif" border=0 alt="<bean:message key="label.payments.getpayfromplatinum"/>">
							</html:link>
						</july:canedit>
					</td>
				<%	} %>
--%>				
				<td class="link"
						<logic:equal name="paymentstate" value="G">TITLE='<bean:message key="label.payments.state.edit"/>'</logic:equal>
						<logic:equal name="paymentstate" value="P">TITLE='<bean:message key="label.payments.state.p"/>'</logic:equal>
						<logic:equal name="paymentstate" value="N">TITLE='<bean:message key="label.payments.state.n"/>'</logic:equal>
						<logic:equal name="paymentstate" value="K">TITLE='<bean:message key="label.payments.state.k"/>'</logic:equal>
						<logic:equal name="paymentstate" value="M">TITLE='<bean:message key="label.payments.state.m"/>'</logic:equal>
						<logic:equal name="paymentstate" value="V">TITLE='<bean:message key="label.payments.state.v"/>'</logic:equal>
				>
					<% temp = state + "View"; %>
					<july:canedit rolesProperty="editRoles"><% temp = state + "Edit"; %></july:canedit>
					<july:link page='<%= temp + "&leaseDocPosition=" + docPos %>'>
						<logic:equal name="paymentstate" value="G"><bean:message key="label.payments.s_state.edit"/></logic:equal>
						<logic:equal name="paymentstate" value="P"><bean:message key="label.payments.s_state.p"/></logic:equal>
						<logic:equal name="paymentstate" value="N"><bean:message key="label.payments.s_state.n"/></logic:equal>
						<logic:equal name="paymentstate" value="K"><bean:message key="label.payments.s_state.k"/></logic:equal>
						<logic:equal name="paymentstate" value="M"><bean:message key="label.payments.s_state.m"/></logic:equal>
						<logic:equal name="paymentstate" value="V"><bean:message key="label.payments.s_state.v"/></logic:equal>
					</july:link>
				</td>
				
				<%	switch (ParamsParser.getState(pageContext)) {
						case APPStates.PAYMENTS_LIST:
						case APPStates.HISTORY_PAYMENTS_LIST: %>
					<td class="text" align="center">
						<img src='/images/infohint.gif' border=0 alt='<bean:message key="label.payments.executor"/>:&nbsp;<july:stringwrite name="it" property="orgname"/>&#10;<bean:message key="label.payments.executor.account"/>:&nbsp;<july:stringwrite name="it" property="account"/>&#10;<bean:message key="label.payments.executor.bik"/>:&nbsp;<july:stringwrite name="it" property="bik"/>&#10;<bean:message key="label.payments.executor.bank"/>:&nbsp;<july:stringwrite name="it" property="bankname"/>'>
					</td>
					
					<td class='text' align='center'>
						<july:canedit rolesProperty="editRoles">
							<july:link page='<%= action + "?document=" + docPos %>'>
								<logic:equal name="isschetfakt" value="Y">
									<img src='/images/check_on.gif' border=0 alt='<bean:message key="label.payments.isschetfact.yes"/>'>
								</logic:equal>
								<logic:equal name="isschetfakt" value="N">
									<img src='/images/check_off.gif' border=0 alt='<bean:message key="label.payments.isschetfact.no"/>'>
								</logic:equal>
							</july:link>
						</july:canedit>
						<july:cannotedit rolesProperty="editRoles">
							<logic:equal name="isschetfakt" value="Y">
								<img src='/images/check_on.gif' border=0 alt='<bean:message key="label.payments.isschetfact.yes"/>'>
							</logic:equal>
							<logic:equal name="isschetfakt" value="N">
								<img src='/images/check_off.gif' border=0 alt='<bean:message key="label.payments.isschetfact.no"/>'>
							</logic:equal>
						</july:cannotedit>
					</td>
				<%	} %>
				<td class="text">
					<july:stringwrite name="it" property="officememonumber"/>
				</td>
				<td class="text">
					<%--	if (ParamsParser.getState(pageContext) == APPStates.PAYMENTS_LIST || ParamsParser.getState(pageContext) == APPStates.HISTORY_PAYMENTS_LIST) { %>
						<logic:notEqual name="paymentstate" value="M">
						<logic:notEqual name="paymentstate" value="N">
						<logic:notEqual name="paymentstate" value="G">
							<july:stringwrite name="it" property="docnumber"/>
						</logic:notEqual>
						</logic:notEqual>
						</logic:notEqual>
					<%	} else { --%>
							<july:stringwrite name="it" property="docnumber"/>
					<%--	} --%>
				</td>
				<td class="text">
					<%--	if (ParamsParser.getState(pageContext) == APPStates.PAYMENTS_LIST || ParamsParser.getState(pageContext) == APPStates.HISTORY_PAYMENTS_LIST) { %>
						<logic:notEqual name="paymentstate" value="M">
						<logic:notEqual name="paymentstate" value="N">
						<logic:notEqual name="paymentstate" value="G">
							<july:datewrite name="it" property="date"/>
						</logic:notEqual>
						</logic:notEqual>
						</logic:notEqual>
					<%	} else { --%>
							<july:datewrite name="it" property="date"/>
					<%--	} --%>
				</td>
				<td class="number" align="right" NOWRAP>
					<july:sumwrite name="it" property="summrub"/>
				</td>
				
				<td class="text" align="center">
					<logic:equal name="flagOplNds" value="Y">Да</logic:equal>
					<logic:equal name="flagOplNds" value="N">Нет</logic:equal>				
				</td>				

				<td class="number" align="right" NOWRAP>
					<july:sumwrite name="it" property="summ"/> <july:stringwrite name="it" property="shortname"/>
				</td>				

				<td class="text">
					<!-- Вызов списка начислений(Какие начисления закрывает платеж.?)-->
					<A href='DnopForPaymentList.do?leasePayment=<%= docPos%>'>
						<img src='/images/dochist.gif' border=0 alt='Какие начисления закрывает платеж?'></A>
				</td>

				<td class="text" align="center">
					<img src='/images/infohint.gif' border=0 alt='<bean:message key="label.payments.paypurpose"/>:&#10;<july:stringwrite name="it" property="paypurpose"/>'>
				</td>

				<td class="link" align="center">
<%--
					<july:link page='<%= rate + "?docpositioncode=" + docPos %>'>
						<img src='/images/rateicon.gif' border=0 alt='<bean:message key="label.leasecalcrate.short"/>'>
					</july:link>
--%>
<!-- Вызов списка курса (диалога)-->
						<A href='EditRateList.do?action=Edit&docpositioncode=<%=docPos %>' onclick='window.open(this.href, "rateListDialog", "top=100, left=100, width=600, height=250, scrollbars=yes, resizable=yes").focus(); return false;'>
							<img src='/images/rateicon.gif' border=0 alt='<bean:message key="label.leasecalcrate.short"/>'>
						</A>
				</td>
				
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<logic:notEqual name="<%= form %>" property="stateOfContract" value="C">
							<logic:equal name="paymentstate" value="G">
								<% temp = edit + "?action=Delete"; %>
								<july:delbutton page='<%= temp + "&leaseDocPosition=" + docPos %>'/>
							</logic:equal>
						</logic:notEqual>
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
							<%	if (ParamsParser.getState(pageContext) == APPStates.ABONENT_PAYMENTS_LIST) { %>
								<%-- <logic:equal name="AbonentForm" property="flagworkpie" value="false"> --%>
									<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
								<%-- </logic:equal> --%>
							<%	} else { %>
								<logic:notEqual name="<%= form %>" property="stateOfContract" value="A">
									<logic:notEqual name="<%= form %>" property="stateOfContract" value="C">
										<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
									</logic:notEqual>
								</logic:notEqual>
							<%	} %>
						</july:canedit>

							<july:backbutton/>
							
						<% if (ParamsParser.getState(pageContext) == APPStates.PAYMENTS_LIST || ParamsParser.getState(pageContext) == APPStates.HISTORY_PAYMENTS_LIST) { %>
							<%--july:canedit rolesProperty="editRoles">&nbsp;
								<html:link page="<%= getpays %>" paramId="leaseContract" paramName="<%= form %>" paramProperty="leaseContract" paramScope="session"><img src="/images/getpays.gif" border=0 alt="<bean:message key="label.payments.getpayfromplatinums"/>"></html:link>
							</july:canedit--%>
					</td>
					<TD>
							<%--html:link page="/EditStartPayment.do?action=Add&condition=C" paramId="leaseDocumentcodeFrm" paramName="<%= form %>" paramProperty="leaseContract">
								<bean:message key="label.dhist.lnkmakepay"/>
							</html:link--%>
						<% } %>
					</TD>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

</table>


<script language="javascript">
	switchDate();
</script>
<script language="javascript">
	loadSelectedRow();
	//window.location.hash=document.all.selectedID.value;
	//stat = 1;
</script>

</july:browseform>
<%
    //counter end
	//counter.finish("jsp");
%>
