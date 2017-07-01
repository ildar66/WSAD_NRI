<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.formbean.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = null; %>


<%	String action = null;
	String form = null;
	String message = null;
	String actionEdit = null;
	String actionJournal = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.START_PROLONGATIONS_LIST:
        	action = "/ShowStartProlongationsList.do";
			form = "StartProlongationsListForm";
			message = "label.autoproc.prolongation";
			actionEdit = "/EditStartProlongation.do?action=Add";
			actionJournal = "/ShowJournalProlongationsList.do";
			gColSpan = "8";
        	break;
		case APPStates.START_CHARGES_LIST:
        	action = "/ShowStartChargesList.do";
			form = "StartChargesListForm";
			message = "label.autoproc.charges";
			actionEdit = "/EditStartCharge.do?action=Add";
			actionJournal = "/ShowJournalChargesList.do";
			gColSpan = "7";
        	break;
		case APPStates.START_PAYMENTS_LIST:
        	action = "/ShowStartPaymentsList.do";
			form = "StartPaymentsListForm";
			message = "label.autoproc.payments";
			actionEdit = "/EditStartPayment.do?action=Add";
			actionJournal = "/ShowJournalPaymentsList.do";
			gColSpan = "8";
        	break;
		case APPStates.ABONENT_BILL_START_LIST:
        	action = "/ShowStartBillList.do";
			form = "StartBillListForm";
			message = "label.bill.journal";
			actionJournal = "/ShowJournalBillList.do";
			gColSpan = "4";
        	break;
    } %>


<july:browseform action="<%= action %>" styleId="<%= form %>">


<script language="javascript">
function switchStartDate() {
	if (document.all.isStartDate[0].checked) {
		<%= form %>.beginStartDate_dt.enabled = false;
		<%= form %>.endStartDate_dt.enabled = false;
	} else {
		<%= form %>.beginStartDate_dt.enabled = true;
		<%= form %>.endStartDate_dt.enabled = true;
	}
}
function switchWorker() {
	if (document.all.isWorker[0].checked) {
		<%= form %>.workercode.className = 'editkoddisabled';
		<%= form %>.workercode.disabled = true;
		document.all['lookupimg_operlookup'].src='/images/lookup_disabled.gif';
	} else {
		<%= form %>.workercode.className = 'editkodsearch';
		<%= form %>.workercode.disabled = false;
		document.all['lookupimg_operlookup'].src='/images/lookup.gif';
	}
}
</script>


<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<july:currmark><bean:message key="<%= message %>"/></july:currmark>
		</td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.autoproc.prolongation.startperiod"/>:</td>
					<td class="text" nowrap>
						<table class="main" border="0" cellpading="0" cellspacing="0">
							<tr>
								<td class="text">
									<july:checkbox property="isStartDate" insertable="true" updatable="true" onclick="switchStartDate()"/>&nbsp;
									<bean:message key="label.filter.all"/>
								</td>
								<td class="text">
									<july:date property="beginStartDateFrm" size="25" insertable="true" updatable="true" styleId="beginStartDate"/>&nbsp;
									<bean:message key="label.filter.stop"/>&nbsp;
									<july:date property="endStartDateFrm" size="25" insertable="true" updatable="true" styleId="endStartDate"/><july:searchbutton/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.autoproc.prolongation.operator"/>:</td>
					<td class="text" nowrap>
						<table class="main" border="0" cellpading="0" cellspacing="0">
							<tr class="normal">
								<td class="text">
									<july:checkbox property="isWorker" insertable="true" updatable="true" onclick="switchWorker()"/>&nbsp;
									<bean:message key="label.filter.all"/>
								</td>
								<td class="text">
									<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true"/>
									<july:lookupbutton action="/ShowOperatorLookupList.do" styleId="operlookup" fieldNames="workercode;workername" insertable="true" updatable="true"/>
									<july:string size="50" property="workername" styleId="workername" insertable="false" updatable="false"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<% if (ParamsParser.getState(pageContext) == APPStates.ABONENT_BILL_START_LIST) { %>
					
					<tr>
						<td class="text"><bean:message key="label.journal.querytype"/>:</td>
						<td class="text">
						    <july:select style="width: 400;" property="querytype" insertable="true" updatable="true">
								<html:option key="label.taskstart.tasktype.f" value="6"/>
								<html:option key="label.taskstart.tasktype.g" value="7"/>
						   	</july:select>
						</td>
					</tr>
				
				<% } %>
				
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<% if (ParamsParser.getState(pageContext) != APPStates.ABONENT_BILL_START_LIST) { %>
							<july:addbutton page="<%= actionEdit %>"/>
						<% } %>
						<july:backbutton page="/main.do"/>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>


	<!-- Table header -->
	<tr class="title">
		<july:headercolumn key="label.autoproc.prolongation.beginstartdate" colType="string"/>
		<july:headercolumn key="label.autoproc.prolongation.endstartdate" colType="string"/>
		<%	if (ParamsParser.getState(pageContext) != APPStates.ABONENT_BILL_START_LIST) { %>
			<july:headercolumn key="label.autoproc.prolongation.economist" colType="string"/>
			<%	if (ParamsParser.getState(pageContext) == APPStates.START_PROLONGATIONS_LIST ||
					ParamsParser.getState(pageContext) == APPStates.START_PAYMENTS_LIST) { %>
				<td colspan="2" align="center"><b><bean:message key="label.autoproc.payments.interval"/></b></td>
			<%	} else { %>
				<july:headercolumn key="label.autoproc.date" colType="string"/>
			<%	} %>
			<july:headercolumn key="label.autoproc.prolongation.dogovor" colType="string"/>
		<%	} %>
		<july:headercolumn key="label.autoproc.prolongation.operator" colType="string"/>
		<td class="title">&nbsp;</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
 				<td class="date">
					<july:datewrite name="it" property="startdate" showtime="true"/>
                </td>
				
 				<td class="date">
                    <july:datewrite name="it" property="enddate" showtime="true"/>
                </td>
				
				<%	if (ParamsParser.getState(pageContext) != APPStates.ABONENT_BILL_START_LIST) { %>
				
	 				<td class="text">
						<logic:present name="it" property="economistWorker">
							<bean:write name="it" property="economistWorker.man.fullName" filter="true"/>
						</logic:present>
	                </td>
	
					<%	if (ParamsParser.getState(pageContext) == APPStates.START_PROLONGATIONS_LIST ||
							ParamsParser.getState(pageContext) == APPStates.START_PAYMENTS_LIST) { %>
		 				<td class="date">
							<july:datewrite name="it" property="date1"/>
	        	        </td>
					<%	} %>
					
					<td class="date">
						<%	if (ParamsParser.getState(pageContext) == APPStates.START_CHARGES_LIST) { %>
							<july:datewrite name="it" property="date1"/>
						<%	} else { %>
							<july:datewrite name="it" property="date2"/>
						<%	} %>
	                </td>
					
	 				<td class="text">
						<logic:present name="it" property="leasedocument">
							<bean:write name="it" property="leasedocument.documentNumber" filter="true"/>
						</logic:present>
	                </td>		
					
				<%	} %>
				
 				<td class="text">
					<bean:write name="it" property="startOperator.man.fullName" filter="true"/>
                </td>


				<td class="link">
					<july:link page="<%= actionJournal %>" paramId="taskStartcode" paramName="it" paramProperty="taskstart" paramScope="page">
						<bean:message key="label.journal.short"/>
					</july:link>
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
						<% if (ParamsParser.getState(pageContext) != APPStates.ABONENT_BILL_START_LIST) { %>
							<july:addbutton page="<%= actionEdit %>"/>
						<% } %>
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
		<td class="title" colspan="<%= gColSpan %>">
			<july:currmark><bean:message key="<%= message %>"/></july:currmark>
		</td>
	</tr>
--%>


</table>


<script language="javascript">
	switchStartDate();
	switchWorker();
</script>


</july:browseform>

