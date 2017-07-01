<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.formbean.*,com.hps.july.arenda.*,com.hps.july.persistence.*,org.apache.struts.action.*,org.apache.struts.util.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = "5"; %>


<%	String action = null;
	String form = null;
	String parent = null;
	String parent2 = null;
	String parent3 = null;
	String parent4 = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.JOURNAL_ACT_LIST:
        	action = "/ShowJournalActList.do";
			form = "JournalActListForm";
			parent2 = "/ShowMutualReglamentsList.do";
			parent3 = "/ShowMutualActsList.do";
			parent4 = "/ShowStartActList.do";
        	break;
		case APPStates.FROMCONTRACT_JOURNAL_ACT_LIST:
        	action = "/ShowFromContractJournalActList.do";
			form = "FromContractJournalActListForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			parent3 = "/ShowFromContractMutualActsList.do";
			parent4 = "/ShowFromContractStartActList.do";
        	break;
		case APPStates.FROMHISTORY_JOURNAL_ACT_LIST:
        	action = "/ShowFromHistoryJournalActList.do";
			form = "FromHistoryJournalActListForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			parent3 = "/ShowFromHistoryMutualActsList.do";
			parent4 = "/ShowFromHistoryStartActList.do";
        	break;
    } %>


<july:browseform action="<%= action %>" styleId="<%= form %>">


<script language="javascript">
function switchJrnType() {
	if (document.all.isJrnType[0].checked) {
		<%= form %>.jrnTypeE.disabled = true;
		<%= form %>.jrnTypeW.disabled = true;
		<%= form %>.jrnTypeS.disabled = true;
	} else {
		<%= form %>.jrnTypeE.disabled = false;
		<%= form %>.jrnTypeW.disabled = false;
		<%= form %>.jrnTypeS.disabled = false;
	}
}
</script>


<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.FROMCONTRACT_JOURNAL_ACT_LIST ||
				ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_JOURNAL_ACT_LIST) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_JOURNAL_ACT_LIST) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
	        	<% } %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
				<july:sepmark/>
			<%	} %>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.mutualreglmnts"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent3 %>" styleClass="navigator"><bean:message key="label.mutualacts"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent4 %>" styleClass="navigator"><bean:message key="label.startact"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.startact.journal"/></july:currmark>
		</td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.startact.actcode"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="actCode" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.startact.actnumber"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="actNumber" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.startact.actdate"/>:</td>
					<td class="text" nowrap><july:datewrite name="<%= form %>" property="actDate"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.startact.actperiod"/>:</td>
					<td class="text" nowrap>
						<july:datewrite name="<%= form %>" property="actStartDate"/>&nbsp;
						<bean:message key="label.filter.stop"/>&nbsp;
						<july:datewrite name="<%= form %>" property="actEndDate"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.journal.message.type"/>:</td>
					<td class="text" nowrap>
						<logic:equal name="<%= form %>" property="taskType" value="4"><bean:message key="label.taskstart.tasktype.d"/></logic:equal>
						<logic:equal name="<%= form %>" property="taskType" value="5"><bean:message key="label.taskstart.tasktype.e"/></logic:equal>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.startact.journal.operator"/>:</td>
					<td class="text" nowrap>
						<bean:write name="<%= form %>" property="operatorname" filter="true"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.journal.times"/>:</td>
					<td class="text" nowrap>
						<july:datewrite name="<%= form %>" property="startDate" showtime="true"/>&nbsp;
						<bean:message key="label.filter.stop"/>&nbsp;
						<july:datewrite name="<%= form %>" property="endDate" showtime="true"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.journal.messagetype"/>:</td>
					<td class="text" nowrap>
						<july:checkbox property="isJrnType" insertable="true" updatable="true" onclick="switchJrnType()"/>&nbsp;
						<bean:message key="label.filter.all"/>&nbsp;
						<july:radio styleId="jrnTypeE" property="jrnType" insertable="true" updatable="true" value="E"/><bean:message key="label.journal.message.type.error"/>
						<july:radio styleId="jrnTypeW" property="jrnType" insertable="true" updatable="true" value="W"/><bean:message key="label.journal.message.type.warning"/>
						<july:radio styleId="jrnTypeS" property="jrnType" insertable="true" updatable="true" value="S"/><bean:message key="label.journal.message.type.success"/>
						<july:searchbutton/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
<script language="javascript">
	switchJrnType();
</script>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons"><july:backbutton page="<%= parent4 %>"/></td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>


	<!-- Table header -->
	<tr class="title">
		<july:sortcolumn key="label.startact.journal.code" colType="string" ascFinder="3" descFinder="4"/>
		<july:headercolumn key="label.journal.message.type" colType="string"/>
		<july:headercolumn key="label.startact.journal.datetime" colType="string"/>
		<july:headercolumn key="label.startact.journal.codemsg" colType="string"/>
		<july:headercolumn key="label.startact.journal.text" colType="string"/>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="number">
					<bean:write name="it" property="taskjournal" filter="true"/>
				</td>
				
				<td class="text">
					<logic:equal name="it" property="jrntype" value="S"><bean:message key="label.journal.message.type.success"/></logic:equal>
					<logic:equal name="it" property="jrntype" value="W"><bean:message key="label.journal.message.type.warning"/></logic:equal>
					<logic:equal name="it" property="jrntype" value="E"><bean:message key="label.journal.message.type.error"/></logic:equal>
				</td>
				
				<td class="date">
					<july:datewrite name="it" property="jrndate" showtime="true"/>
                </td>
				
				<td class="number">
					<bean:write name="it" property="jrnaction" filter="true"/>
				</td>
				
 				<td class="text">
					<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_STRMESSAGE) %>">
						<bean:write name="it" property="jrnmessage" filter="true"/>
					</logic:equal>
					
					<logic:notEqual name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_STRMESSAGE) %>">
				
						<%	LeaseTaskJournalAccessBean beanJournal = (LeaseTaskJournalAccessBean) it;
							ActionMapping actionMapping = (ActionMapping) request.getAttribute("org.apache.struts.action.mapping.instance");
							MessageResources messageResources = new PropertyMessageResourcesFactory().createResources(
								actionMapping.getMappings().getServlet().getInitParameter("application")); %>
						
						<%	if (beanJournal.getJournal2start().getTasktype().equals("4")) { %>
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_REGINSERT) %>"><%--101--%>
								<%	LeaseMutualReglamentAccessBean lmrBean = new LeaseMutualReglamentAccessBean();
									lmrBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmrBean.refreshCopyHelper();
									StringAndSqlDateProperty s = new StringAndSqlDateProperty();
									s.setSqlDate(lmrBean.getDocumentDate());
								%>
								<bean:message key="journal.calcact.error.reginsert" arg0="<%= Integer.toString(lmrBean.getLeaseDocument()) %>" 
									arg1="<%= lmrBean.getDocumentNumber() %>"
									arg2="<%= s.getString() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_REGCLOSE) %>"><%--102--%>
								<%	LeaseMutualReglamentAccessBean lmrBean = new LeaseMutualReglamentAccessBean();
									lmrBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmrBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s = new StringAndSqlDateProperty();
									s.setSqlDate(lmrBean.getDocumentDate());
								%>
								<bean:message key="journal.calcact.error.regclose" arg0="<%= Integer.toString(lmrBean.getLeaseDocument()) %>" 
									arg1="<%= lmrBean.getDocumentNumber() %>"
									arg2="<%= s.getString() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_FINDSALDO) %>"><%--103--%>
								<%	LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
									lcBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lcBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s1 = new StringAndSqlDateProperty();
									s1.setSqlDate(lcBean.getDocumentDate());
									
									String message = null;
									if (lcBean.getContractType().equals("A")) {
										message = messageResources.getMessage("label.contracttype.arenda");
									} else if (lcBean.getContractType().equals("B")) {
										message = messageResources.getMessage("label.contracttype.arendaus");
									} else if (lcBean.getContractType().equals("C")) {
										message = messageResources.getMessage("label.contracttype.user");
									} else if (lcBean.getContractType().equals("D")) {
										message = messageResources.getMessage("label.contracttype.channel");
									}
									message = new String(ResponseUtils.filter(message).getBytes("Cp1251"));
									
									StringAndSqlDateProperty s2 = new StringAndSqlDateProperty();
									s2.setSqlDate(beanJournal.getDate1());
									
									ResourceAccessBean rBean = new ResourceAccessBean();
									rBean.setInitKey_resource(beanJournal.getResource1().intValue());
									rBean.refreshCopyHelper();
								%>
								<bean:message key="journal.calcact.error.findsaldo.a" arg0="<%= Integer.toString(lcBean.getLeaseDocument()) %>"
									arg1="<%= lcBean.getDocumentNumber() %>"
									arg2="<%= s1.getString() %>"
									arg3="<%= message %>"
									arg4="<%= s2.getString() %>"/>&nbsp;
								<bean:message key="journal.calcact.error.findsaldo.b" arg0="<%= Integer.toString(rBean.getResource()) %>"
									arg1="<%= rBean.getName() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_RESOURCE) %>"><%--104--%>
								<%	LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
									lmanBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmanBean.refreshCopyHelper();
									
									LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
									lpBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition().intValue());
									lpBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s1 = new StringAndSqlDateProperty();
									s1.setSqlDate(lpBean.getDate());
									
									LeaseChargesAccessBean lcBean = new LeaseChargesAccessBean();
									lcBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition2().intValue());
									lcBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s2 = new StringAndSqlDateProperty();
									s2.setSqlDate(lcBean.getDate());
									StringAndSqlDateProperty s3 = new StringAndSqlDateProperty();
									s3.setSqlDate(lcBean.getLeaseContract().getDocumentDate());
									
									String message = null;
									if (lcBean.getLeaseContract().getContractType().equals("A")) {
										message = messageResources.getMessage("label.contracttype.arenda");
									} else if (lcBean.getLeaseContract().getContractType().equals("B")) {
										message = messageResources.getMessage("label.contracttype.arendaus");
									} else if (lcBean.getLeaseContract().getContractType().equals("C")) {
										message = messageResources.getMessage("label.contracttype.user");
									} else if (lcBean.getLeaseContract().getContractType().equals("D")) {
										message = messageResources.getMessage("label.contracttype.channel");
									}
									message = new String(ResponseUtils.filter(message).getBytes("Cp1251"));
								%>
								<bean:message key="journal.calcact.error.resource.a" arg0="<%= lmanBean.getDocumentNumber() %>"
									arg1="<%= Integer.toString(lpBean.getLeaseDocPosition()) %>"
									arg2="<%= s1.getString() %>"
									arg3="<%= lpBean.getDocNumber() %>"
									arg4="<%= lpBean.getSumRub().toString() %>"/>&nbsp;
								<bean:message key="journal.calcact.error.resource.b" arg0="<%= Integer.toString(lcBean.getLeaseDocPosition()) %>"
									arg1="<%= s2.getString() %>"
									arg2="<%= lcBean.getResource().getName() %>"
									arg3="<%= lcBean.getLeaseContract().getDocumentNumber() %>"
									arg4="<%= s3.getString() %>"/>&nbsp;
								<bean:message key="journal.calcact.error.resource.c" arg0="<%= message %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_RESOURCE2) %>"><%--105--%>
								<%	LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
									lmanBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmanBean.refreshCopyHelper();
									
									LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
									lpBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition().intValue());
									lpBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s1 = new StringAndSqlDateProperty();
									s1.setSqlDate(lpBean.getDate());
									
									LeaseChargesAccessBean lcBean = new LeaseChargesAccessBean();
									lcBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition2().intValue());
									lcBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s2 = new StringAndSqlDateProperty();
									s2.setSqlDate(lcBean.getDate());
									StringAndSqlDateProperty s3 = new StringAndSqlDateProperty();
									s3.setSqlDate(lcBean.getLeaseContract().getDocumentDate());
									
									String message = null;
									if (lcBean.getLeaseContract().getContractType().equals("A")) {
										message = messageResources.getMessage("label.contracttype.arenda");
									} else if (lcBean.getLeaseContract().getContractType().equals("B")) {
										message = messageResources.getMessage("label.contracttype.arendaus");
									} else if (lcBean.getLeaseContract().getContractType().equals("C")) {
										message = messageResources.getMessage("label.contracttype.user");
									} else if (lcBean.getLeaseContract().getContractType().equals("D")) {
										message = messageResources.getMessage("label.contracttype.channel");
									}
									message = new String(ResponseUtils.filter(message).getBytes("Cp1251"));
								%>
								<bean:message key="journal.calcact.error.resource2.a" arg0="<%= lmanBean.getDocumentNumber() %>"
									arg1="<%= Integer.toString(lpBean.getLeaseDocPosition()) %>"
									arg2="<%= s1.getString() %>"
									arg3="<%= lpBean.getDocNumber() %>"
									arg4="<%= lpBean.getSumRub().toString() %>"/>&nbsp;
								<bean:message key="journal.calcact.error.resource2.b" arg0="<%= Integer.toString(lcBean.getLeaseDocPosition()) %>"
									arg1="<%= s2.getString() %>"
									arg2="<%= lcBean.getResource().getName() %>"
									arg3="<%= lcBean.getLeaseContract().getDocumentNumber() %>"
									arg4="<%= s3.getString() %>"/>&nbsp;
								<bean:message key="journal.calcact.error.resource2.c" arg0="<%= message %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_CHARGEDATE) %>"><%--106--%>
								<%	LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
									lmanBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmanBean.refreshCopyHelper();
									
									LeaseChargesAccessBean lcBean = new LeaseChargesAccessBean();
									lcBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition2().intValue());
									lcBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s1 = new StringAndSqlDateProperty();
									s1.setSqlDate(lcBean.getDate());
									StringAndSqlDateProperty s2 = new StringAndSqlDateProperty();
									s2.setSqlDate(lcBean.getLeaseContract().getDocumentDate());
									
									String message = null;
									if (lcBean.getLeaseContract().getContractType().equals("A")) {
										message = messageResources.getMessage("label.contracttype.arenda");
									} else if (lcBean.getLeaseContract().getContractType().equals("B")) {
										message = messageResources.getMessage("label.contracttype.arendaus");
									} else if (lcBean.getLeaseContract().getContractType().equals("C")) {
										message = messageResources.getMessage("label.contracttype.user");
									} else if (lcBean.getLeaseContract().getContractType().equals("D")) {
										message = messageResources.getMessage("label.contracttype.channel");
									}
									message = new String(ResponseUtils.filter(message).getBytes("Cp1251"));
									
									StringAndSqlDateProperty s3 = new StringAndSqlDateProperty();
									s3.setSqlDate(beanJournal.getDate1());
									StringAndSqlDateProperty s4 = new StringAndSqlDateProperty();
									s4.setSqlDate(beanJournal.getDate2());
								%>
								<bean:message key="journal.calcact.error.chargedate.a" arg0="<%= lmanBean.getDocumentNumber() %>"
									arg1="<%= Integer.toString(lcBean.getLeaseDocPosition()) %>"
									arg2="<%= s1.getString() %>"
									arg3="<%= lcBean.getResource().getName() %>"
									arg4="<%= lcBean.getLeaseContract().getDocumentNumber() %>"/>&nbsp;
								<bean:message key="journal.calcact.error.chargedate.b" arg0="<%= s2.getString() %>"
									arg1="<%= message %>"
									arg2="<%= s3.getString() %>"
									arg3="<%= s4.getString() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_PAYDATE) %>"><%--107--%>
								<%	LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
									lmanBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmanBean.refreshCopyHelper();
									
									LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
									lpBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition2().intValue());
									lpBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s1 = new StringAndSqlDateProperty();
									s1.setSqlDate(lpBean.getDate());
									StringAndSqlDateProperty s2 = new StringAndSqlDateProperty();
									s2.setSqlDate(beanJournal.getDate1());
									StringAndSqlDateProperty s3 = new StringAndSqlDateProperty();
									s3.setSqlDate(beanJournal.getDate2());
								%>
								<bean:message key="journal.calcact.error.paydate.a" arg0="<%= lmanBean.getDocumentNumber() %>"
									arg1="<%= Integer.toString(lpBean.getLeaseDocPosition()) %>"
									arg2="<%= s1.getString() %>"
									arg3="<%= lpBean.getDocNumber() %>"
									arg4="<%= lpBean.getSumRub().toString() %>"/>&nbsp;
								<bean:message key="journal.calcact.error.paydate.b" arg0="<%= s2.getString() %>"
									arg1="<%= s3.getString() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_CALCRATE) %>"><%--108--%>
								<%	LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
									lmanBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmanBean.refreshCopyHelper();
									
									LeaseChargesAccessBean lcBean = new LeaseChargesAccessBean(); 
									lcBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition().intValue());
									lcBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s1 = new StringAndSqlDateProperty();
									s1.setSqlDate(lcBean.getDate());
									StringAndSqlDateProperty s2 = new StringAndSqlDateProperty();
									s2.setSqlDate(lcBean.getLeaseContract().getDocumentDate());
									
									CurrencyAccessBean currencyBean = new CurrencyAccessBean();
									currencyBean.setInitKey_currency(beanJournal.getCurrency1().intValue());
									currencyBean.refreshCopyHelper();
									
									String message = null;
									if (lcBean.getLeaseContract().getContractType().equals("A")) {
										message = messageResources.getMessage("label.contracttype.arenda");
									} else if (lcBean.getLeaseContract().getContractType().equals("B")) {
										message = messageResources.getMessage("label.contracttype.arendaus");
									} else if (lcBean.getLeaseContract().getContractType().equals("C")) {
										message = messageResources.getMessage("label.contracttype.user");
									} else if (lcBean.getLeaseContract().getContractType().equals("D")) {
										message = messageResources.getMessage("label.contracttype.channel");
									}
									message = new String(ResponseUtils.filter(message).getBytes("Cp1251"));
								%>
								<bean:message key="journal.calcact.error.calcrate.a" arg0="<%= lmanBean.getDocumentNumber() %>" 
									arg1="<%= Integer.toString(lcBean.getLeaseDocPosition()) %>"
									arg2="<%= s1.getString() %>"
									arg3="<%= lcBean.getResource().getName() %>"
									arg4="<%= lcBean.getLeaseContract().getDocumentNumber() %>"/>&nbsp;
								<bean:message key="journal.calcact.error.calcrate.b" arg0="<%= s2.getString() %>"
									arg1="<%= message %>"
									arg2="<%= currencyBean.getName() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_SYSTEMRES1) %>"><%--109--%>
								<bean:message key="journal.calcact.error.systemres1"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_SYSTEMRES2) %>"><%--110--%>
								<bean:message key="journal.calcact.error.systemres2"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_FINDRUR) %>"><%--111--%>
								<bean:message key="journal.calcact.error.findrur"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_CHARGERATEDATE) %>"><%--112--%>
								<%	LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
									lmanBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmanBean.refreshCopyHelper();
									
									LeaseChargesAccessBean lcBean = new LeaseChargesAccessBean();
									lcBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition().intValue());
									lcBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s1 = new StringAndSqlDateProperty();
									s1.setSqlDate(lcBean.getDate());
									StringAndSqlDateProperty s2 = new StringAndSqlDateProperty();
									s2.setSqlDate(lcBean.getLeaseContract().getDocumentDate());
									
									CurrencyAccessBean currencyBean = new CurrencyAccessBean();
									currencyBean.setInitKey_currency(beanJournal.getCurrency1().intValue());
									currencyBean.refreshCopyHelper();
									
									String message = null;
									if (lcBean.getLeaseContract().getContractType().equals("A")) {
										message = messageResources.getMessage("label.contracttype.arenda");
									} else if (lcBean.getLeaseContract().getContractType().equals("B")) {
										message = messageResources.getMessage("label.contracttype.arendaus");
									} else if (lcBean.getLeaseContract().getContractType().equals("C")) {
										message = messageResources.getMessage("label.contracttype.user");
									} else if (lcBean.getLeaseContract().getContractType().equals("D")) {
										message = messageResources.getMessage("label.contracttype.channel");
									}
									message = new String(ResponseUtils.filter(message).getBytes("Cp1251"));
								%>
								<bean:message key="journal.calcact.error.chargeratedate.a" arg0="<%= lmanBean.getDocumentNumber() %>"
									arg1="<%= Integer.toString(lcBean.getLeaseDocPosition()) %>"
									arg2="<%= s1.getString() %>"
									arg3="<%= lcBean.getResource().getName() %>"
									arg4="<%= lcBean.getLeaseContract().getDocumentNumber() %>"/>&nbsp;
								<bean:message key="journal.calcact.error.chargeratedate.b" arg0="<%= s2.getString() %>"
									arg1="<%= message %>"
									arg2="<%= currencyBean.getName() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_DEFINERATE) %>"><%--113--%>
								<%	LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
									lmanBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmanBean.refreshCopyHelper();
									
									LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
									lpBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition().intValue());
									lpBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s1 = new StringAndSqlDateProperty();
									s1.setSqlDate(lpBean.getDate());
									StringAndSqlDateProperty s2 = new StringAndSqlDateProperty();
									s2.setSqlDate(beanJournal.getDate1());
									
									CurrencyAccessBean currencyBean = new CurrencyAccessBean();
									currencyBean.setInitKey_currency(beanJournal.getCurrency1().intValue());
									currencyBean.refreshCopyHelper();
								%>
								<bean:message key="journal.calcact.error.definerate.a" arg0="<%= lmanBean.getDocumentNumber() %>"
									arg1="<%= Integer.toString(lpBean.getLeaseDocPosition()) %>"
									arg2="<%= s1.getString() %>"
									arg3="<%= lpBean.getDocNumber() %>"
									arg4="<%= lpBean.getSumRub().toString() %>"/>&nbsp;
								<bean:message key="journal.calcact.error.definerate.b" arg0="<%= s2.getString() %>"
									arg1="<%= currencyBean.getName() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_NORATE) %>"><%--114--%>
								<%	LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
									lmanBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmanBean.refreshCopyHelper();
									
									LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
									lpBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition().intValue());
									lpBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s = new StringAndSqlDateProperty();
									s.setSqlDate(lpBean.getDate());
									
									CurrencyAccessBean currencyBean = new CurrencyAccessBean();
									currencyBean.setInitKey_currency(beanJournal.getCurrency1().intValue());
									currencyBean.refreshCopyHelper();
								%>
								<bean:message key="journal.calcact.error.norate.a" arg0="<%= lmanBean.getDocumentNumber() %>"
									arg1="<%= Integer.toString(lpBean.getLeaseDocPosition()) %>"
									arg2="<%= s.getString() %>"
									arg3="<%= lpBean.getDocNumber() %>"
									arg4="<%= lpBean.getSumRub().toString() %>"/>&nbsp;
								<bean:message key="journal.calcact.error.norate.b" arg0="<%= currencyBean.getName() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_CALCACT) %>"><%--116--%>
								<%	LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
									lmanBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmanBean.refreshCopyHelper();
								%>
								<bean:message key="journal.calcact.error.calcact" arg0="<%= lmanBean.getDocumentNumber() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_MUTUALCHARGES) %>"><%--117--%>
								<%	LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
									lcBean.setInitKey_leaseDocument(beanJournal.getLeasedocposition().intValue());
									lcBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s = new StringAndSqlDateProperty();
									s.setSqlDate(lcBean.getDocumentDate());
									
									String message = null;
									if (lcBean.getContractType().equals("A")) {
										message = messageResources.getMessage("label.contracttype.arenda");
									} else if (lcBean.getContractType().equals("B")) {
										message = messageResources.getMessage("label.contracttype.arendaus");
									} else if (lcBean.getContractType().equals("C")) {
										message = messageResources.getMessage("label.contracttype.user");
									} else if (lcBean.getContractType().equals("D")) {
										message = messageResources.getMessage("label.contracttype.channel");
									}
									message = new String(ResponseUtils.filter(message).getBytes("Cp1251"));
								%>
								<bean:message key="journal.calcact.error.mutualcharges" arg0="<%= Integer.toString(lcBean.getLeaseDocument()) %>"
									arg1="<%= lcBean.getDocumentNumber() %>"
									arg2="<%= s.getString() %>"
									arg3="<%= message %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_MUTUALCHARGES2) %>"><%--118--%>
								<%	LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
									lcBean.setInitKey_leaseDocument(beanJournal.getLeasedocposition().intValue());
									lcBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s = new StringAndSqlDateProperty();
									s.setSqlDate(lcBean.getDocumentDate());
									
									String message = null;
									if (lcBean.getContractType().equals("A")) {
										message = messageResources.getMessage("label.contracttype.arenda");
									} else if (lcBean.getContractType().equals("B")) {
										message = messageResources.getMessage("label.contracttype.arendaus");
									} else if (lcBean.getContractType().equals("C")) {
										message = messageResources.getMessage("label.contracttype.user");
									} else if (lcBean.getContractType().equals("D")) {
										message = messageResources.getMessage("label.contracttype.channel");
									}
									message = new String(ResponseUtils.filter(message).getBytes("Cp1251"));
								%>
								<bean:message key="journal.calcact.error.mutualcharges2" arg0="<%= Integer.toString(lcBean.getLeaseDocument()) %>"
									arg1="<%= lcBean.getDocumentNumber() %>"
									arg2="<%= s.getString() %>"
									arg3="<%= message %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_MAKEBALANSINGCHARGE) %>"><%--119--%>
								<bean:message key="journal.calcact.error.makebalansingcharge" arg0="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_MAKEBALANSINGCHARGE) %>"
									arg1="<%= beanJournal.getLeasedocposition().toString() %>"
									arg2="<%= beanJournal.getLeasedocposition2().toString() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_MAKEBALANSINGCHARGE2) %>"><%--120--%>
								<bean:message key="journal.calcact.error.makebalansingcharge2" arg0="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_MAKEBALANSINGCHARGE2) %>"
									arg1="<%= beanJournal.getLeasedocposition().toString() %>"
									arg2="<%= beanJournal.getLeasedocposition2().toString() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_ADDSALDO) %>"><%--121--%>
								<%	LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
									lcBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lcBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s1 = new StringAndSqlDateProperty();
									s1.setSqlDate(lcBean.getDocumentDate());
									
									String message = null;
									if (lcBean.getContractType().equals("A")) {
										message = messageResources.getMessage("label.contracttype.arenda");
									} else if (lcBean.getContractType().equals("B")) {
										message = messageResources.getMessage("label.contracttype.arendaus");
									} else if (lcBean.getContractType().equals("C")) {
										message = messageResources.getMessage("label.contracttype.user");
									} else if (lcBean.getContractType().equals("D")) {
										message = messageResources.getMessage("label.contracttype.channel");
									}
									message = new String(ResponseUtils.filter(message).getBytes("Cp1251"));
									
									ResourceAccessBean rBean = new ResourceAccessBean();
									rBean.setInitKey_resource(beanJournal.getResource1().intValue());
									rBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s2 = new StringAndSqlDateProperty();
									s2.setSqlDate(beanJournal.getDate1());
								%>
								<bean:message key="journal.calcact.error.addsaldo.a" arg0="<%= Integer.toString(lcBean.getLeaseDocument()) %>"
									arg1="<%= lcBean.getDocumentNumber() %>"
									arg2="<%= s1.getString() %>"
									arg3="<%= message %>"
									arg4="<%= Integer.toString(rBean.getResource()) %>"/>&nbsp;
								<bean:message key="journal.calcact.error.addsaldo.b" arg0="<%= rBean.getName() %>"
									arg1="<%= s2.toString() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_NOTRATECHARGE) %>"><%--122--%>
								<%	LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
									lcBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lcBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s1 = new StringAndSqlDateProperty();
									s1.setSqlDate(lcBean.getDocumentDate());
									
									String message = null;
									if (lcBean.getContractType().equals("A")) {
										message = messageResources.getMessage("label.contracttype.arenda");
									} else if (lcBean.getContractType().equals("B")) {
										message = messageResources.getMessage("label.contracttype.arendaus");
									} else if (lcBean.getContractType().equals("C")) {
										message = messageResources.getMessage("label.contracttype.user");
									} else if (lcBean.getContractType().equals("D")) {
										message = messageResources.getMessage("label.contracttype.channel");
									}
									message = new String(ResponseUtils.filter(message).getBytes("Cp1251"));
									
									LeaseChargesAccessBean lchBean = new LeaseChargesAccessBean();
									lchBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition().intValue());
									lchBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s2 = new StringAndSqlDateProperty();
									s2.setSqlDate(lchBean.getDate());
									StringAndSqlDateProperty s3 = new StringAndSqlDateProperty();
									s3.setSqlDate(lchBean.getLeaseContract().getDocumentDate());
									
									String message2 = null;
									if (lchBean.getLeaseContract().getContractType().equals("A")) {
										message2 = messageResources.getMessage("label.contracttype.arenda");
									} else if (lchBean.getLeaseContract().getContractType().equals("B")) {
										message2 = messageResources.getMessage("label.contracttype.arendaus");
									} else if (lchBean.getLeaseContract().getContractType().equals("C")) {
										message2 = messageResources.getMessage("label.contracttype.user");
									} else if (lchBean.getLeaseContract().getContractType().equals("D")) {
										message2 = messageResources.getMessage("label.contracttype.channel");
									}
									message2 = new String(ResponseUtils.filter(message2).getBytes("Cp1251"));
								%>
								<bean:message key="journal.calcact.error.notratecharge.a" arg0="<%= Integer.toString(lcBean.getLeaseDocument()) %>"
									arg1="<%= lcBean.getDocumentNumber() %>"
									arg2="<%= s1.getString() %>"
									arg3="<%= message %>"
									arg4="<%= Integer.toString(lchBean.getLeaseDocPosition()) %>"/>&nbsp;
								<bean:message key="journal.calcact.error.notratecharge.b" arg0="<%= s2.getString() %>"
									arg1="<%= lchBean.getResource().getName() %>"
									arg2="<%= lchBean.getLeaseContract().getDocumentNumber() %>"
									arg3="<%= s3.getString() %>"
									arg4="<%= message2 %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_CLOSECHARGE) %>"><%--123--%>
								<%	LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
									lmanBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmanBean.refreshCopyHelper();
									
									LeaseChargesAccessBean lchBean = new LeaseChargesAccessBean();
									lchBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition().intValue());
									lchBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s1 = new StringAndSqlDateProperty();
									s1.setSqlDate(lchBean.getDate());
									StringAndSqlDateProperty s2 = new StringAndSqlDateProperty();
									s2.setSqlDate(lchBean.getLeaseContract().getDocumentDate());
									
									String message = null;
									if (lchBean.getLeaseContract().getContractType().equals("A")) {
										message = messageResources.getMessage("label.contracttype.arenda");
									} else if (lchBean.getLeaseContract().getContractType().equals("B")) {
										message = messageResources.getMessage("label.contracttype.arendaus");
									} else if (lchBean.getLeaseContract().getContractType().equals("C")) {
										message = messageResources.getMessage("label.contracttype.user");
									} else if (lchBean.getLeaseContract().getContractType().equals("D")) {
										message = messageResources.getMessage("label.contracttype.channel");
									}
									message = new String(ResponseUtils.filter(message).getBytes("Cp1251"));
								%>
								<bean:message key="journal.calcact.error.closecharge.a" arg0="<%= lmanBean.getDocumentNumber() %>"
									arg1="<%= Integer.toString(lchBean.getLeaseDocPosition()) %>"
									arg2="<%= s1.getString() %>"
									arg3="<%= lchBean.getResource().getName() %>"
									arg4="<%= lchBean.getLeaseContract().getDocumentNumber() %>"/>&nbsp;
								<bean:message key="journal.calcact.error.closecharge.b" arg0="<%= s2.getString() %>"
									arg1="<%= message %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_CLOSECHARGE2) %>"><%--124--%>
								<%	LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
									lmanBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmanBean.refreshCopyHelper();
									
									LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
									lpBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition().intValue());
									lpBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s = new StringAndSqlDateProperty();
									s.setSqlDate(lpBean.getDate());
								%>
								<bean:message key="journal.calcact.error.closecharge2" arg0="<%= lmanBean.getDocumentNumber() %>"
									arg1="<%= Integer.toString(lpBean.getLeaseDocPosition()) %>"
									arg2="<%= s.getString() %>"
									arg3="<%= lpBean.getDocNumber() %>"
									arg4="<%= lpBean.getSumRub().toString() %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_RATEPAY) %>"><%--127--%>
								<%	LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
									lpBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition().intValue());
									lpBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s1 = new StringAndSqlDateProperty();
									s1.setSqlDate(lpBean.getDate());
									
									LeaseChargesAccessBean lchBean = new LeaseChargesAccessBean();
									lchBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition2().intValue());
									lchBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s2 = new StringAndSqlDateProperty();
									s2.setSqlDate(lchBean.getDate());
									StringAndSqlDateProperty s3 = new StringAndSqlDateProperty();
									s3.setSqlDate(lchBean.getLeaseContract().getDocumentDate());
									
									String message = null;
									if (lchBean.getLeaseContract().getContractType().equals("A")) {
										message = messageResources.getMessage("label.contracttype.arenda");
									} else if (lchBean.getLeaseContract().getContractType().equals("B")) {
										message = messageResources.getMessage("label.contracttype.arendaus");
									} else if (lchBean.getLeaseContract().getContractType().equals("C")) {
										message = messageResources.getMessage("label.contracttype.user");
									} else if (lchBean.getLeaseContract().getContractType().equals("D")) {
										message = messageResources.getMessage("label.contracttype.channel");
									}
									message = new String(ResponseUtils.filter(message).getBytes("Cp1251"));
								%>
								<bean:message key="journal.calcact.error.ratepay.a" arg0="<%= Integer.toString(lpBean.getLeaseDocPosition()) %>"
									arg1="<%= s1.getString() %>"
									arg2="<%= lpBean.getDocNumber() %>"
									arg3="<%= lpBean.getSumRub().toString() %>"
									arg4="<%= Integer.toString(lchBean.getLeaseDocPosition()) %>"/>&nbsp;
								<bean:message key="journal.calcact.error.ratepay.b" arg0="<%= s2.getString() %>"
									arg1="<%= lchBean.getResource().getName() %>"
									arg2="<%= lchBean.getLeaseContract().getDocumentNumber() %>"
									arg3="<%= s3.getString() %>"
									arg4="<%= message %>"/>
							</logic:equal>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_CONTRACTSUNIC) %>"><%--128--%>
								<%	LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
									lmanBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmanBean.refreshCopyHelper();
								%>
								<bean:message key="journal.calcact.error.contractsunic" arg0="<%= lmanBean.getDocumentNumber() %>"/>
							</logic:equal>
						
						<%	} else if (beanJournal.getJournal2start().getTasktype().equals("5")) { %>
							
							<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CALCACT_ERROR_ROLLBACK) %>"><%--100--%>
								<%	LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
									lmanBean.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									lmanBean.refreshCopyHelper();
									
									StringAndSqlDateProperty s1 = new StringAndSqlDateProperty();
									s1.setSqlDate(beanJournal.getDate1());
									StringAndSqlDateProperty s2 = new StringAndSqlDateProperty();
									s2.setSqlDate(beanJournal.getDate2());
								%>
								<bean:message key="journal.calcact.error.rollback" arg0="<%= lmanBean.getDocumentNumber() %>"
									arg1="<%= s1.getString() %>"
									arg2="<%= s2.getString() %>"/>
							</logic:equal>
							
						<% } %>
					
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
					<td class="buttons"><july:backbutton page="<%= parent4 %>"/></td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
		
	<july:separator colspan="<%= gColSpan %>"/>
	
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.FROMCONTRACT_JOURNAL_ACT_LIST ||
				ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_JOURNAL_ACT_LIST) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_JOURNAL_ACT_LIST) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
	        	<% } %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
				<july:sepmark/>
			<%	} %>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.mutualreglmnts"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent3 %>" styleClass="navigator"><bean:message key="label.mutualacts"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent4 %>" styleClass="navigator"><bean:message key="label.startact"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.startact.journal"/></july:currmark>
		</td>
	</tr>
--%>


</table>


</july:browseform>

