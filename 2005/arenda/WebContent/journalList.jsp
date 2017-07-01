<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.formbean.*,com.hps.july.arenda.*,com.hps.july.persistence.*,org.apache.struts.action.*,org.apache.struts.util.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = "2"; %>


<%	String action = null;
	String form = null;
	String message = null;
	String actionParent = null;
	String messageParent = null;
	String parent4Bill = null;
	String parent4BillMsg = null;
	String paramId4Bill = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.JOURNAL_PROLONGATIONS_LIST:
        	action = "/ShowJournalProlongationsList.do";
			form = "JournalProlongationsListForm";
			message = "label.journal.prolongation";
			actionParent = "/ShowStartProlongationsList.do";
			messageParent = "label.autoproc.prolongation";
        	break;
		case APPStates.JOURNAL_CHARGES_LIST:
        	action = "/ShowJournalChargesList.do";
			form = "JournalChargesListForm";
			message = "label.journal.charges";
			actionParent = "/ShowStartChargesList.do";
			messageParent = "label.autoproc.charges";
        	break;
		case APPStates.JOURNAL_PAYMENTS_LIST:
        	action = "/ShowJournalPaymentsList.do";
			form = "JournalPaymentsListForm";
			message = "label.journal.payments";
			actionParent = "/ShowStartPaymentsList.do";
			messageParent = "label.autoproc.payments";
        	break;
		case APPStates.ABONENT_BILL_JOURNAL_LIST:
        	action = "/ShowJournalBillList.do";
			form = "JournalBillListForm";
			message = "label.bill.journal";
			actionParent = "/ShowStartBillList.do";
			messageParent = "label.bill.journal";
        	break;
		case APPStates.ABONENT_FROMBILLHANDLEINNRI_BILL_JOURNAL_LIST:
        	action = "/ShowFromBillHandleInNRIJournalBillList.do";
			form = "FromBillHandleInNRIJournalBillListForm";
			message = "label.bill.journal";
			actionParent = "/EditBillHandleInNRI.do";
			parent4Bill = "/ShowAbonentBillsList.do";
			parent4BillMsg = "label.abonents.paybill";
			paramId4Bill = "leaseBill";
        	break;
		case APPStates.ABONENT_FROMPAYHANDLEINNRI_BILL_JOURNAL_LIST:
        	action = "/ShowFromPayHandleInNRIJournalBillList.do";
			form = "FromPayHandleInNRIJournalBillListForm";
			message = "label.bill.journal";
			actionParent = "/EditPayHandleInNRI.do";
			parent4Bill = "/ShowAbonentPaysList.do";
			parent4BillMsg = "label.abonent.pays";
			paramId4Bill = "paypos";
        	break;
    } %>


<july:browseform action="<%= action %>" styleId="<%= form %>">


<%	JournalProlongationsListForm listForm = ((JournalProlongationsListForm) request.getSession().getAttribute(form)); %>


<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.ABONENT_FROMBILLHANDLEINNRI_BILL_JOURNAL_LIST ||
					ParamsParser.getState(pageContext) == APPStates.ABONENT_FROMPAYHANDLEINNRI_BILL_JOURNAL_LIST) { %>
				<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
				<july:sepmark/>
				<july:editlink page="/ViewAbonent.do" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
				<july:sepmark/>
				<html:link page="<%= parent4Bill %>" styleClass="navigator"><bean:message key="<%= parent4BillMsg %>"/></html:link>
				<july:sepmark/>
				<html:link page="<%= actionParent %>" paramId="<%= paramId4Bill %>" paramName="<%= form %>" paramProperty="<%= paramId4Bill %>" styleClass="navigator" scope="session">
					<bean:message key="label.change"/>
				</html:link>
				<july:sepmark/>
				<july:currmark><bean:message key="<%= message %>"/></july:currmark>
			<%	} else { %>
				<html:link page="<%= actionParent %>" styleClass="navigator"><bean:message key="<%= messageParent %>"/></html:link>
				<july:sepmark/>
				<july:currmark><bean:message key="<%= message %>"/></july:currmark>
			<%	} %>
		</td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text">
						<%	if (ParamsParser.getState(pageContext) == APPStates.JOURNAL_PROLONGATIONS_LIST) { %>
							<bean:message key="label.autoproc.prolongation.date"/>:
						<%	} else { %>
							<bean:message key="label.autoproc.date"/>:
						<%	} %>
					</td>
					<td class="text" nowrap>
						<%	if (ParamsParser.getState(pageContext) == APPStates.JOURNAL_PROLONGATIONS_LIST) { %>
							<july:datewrite name="<%= form %>" property="firstDate"/>&nbsp;
						<%	} %>
						<bean:message key="label.filter.stop"/>&nbsp;
						<july:datewrite name="<%= form %>" property="secondDate"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.autoproc.prolongation.operator"/>:</td>
					<td class="text" nowrap>
						<bean:write name="<%= form %>" property="operatorname" filter="true"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.autoproc.prolongation.timeperiod"/>:</td>
					<td class="text" nowrap>
						<july:datewrite name="<%= form %>" property="startDate" showtime="true"/>&nbsp;
						<bean:message key="label.filter.stop"/>&nbsp;
						<july:datewrite name="<%= form %>" property="endDate" showtime="true"/>
					</td>
				</tr>
				
				<tr>
					<td class="text"><bean:message key="label.journal.message.type"/>:</td>
					<td class="text">
						<july:checkbox property="isSuccess" insertable="true" updatable="true"/><bean:message key="label.journal.message.type.success"/>
						<july:checkbox property="isWarning" insertable="true" updatable="true"/><bean:message key="label.journal.message.type.warning"/>
						<july:checkbox property="isError" insertable="true" updatable="true"/><bean:message key="label.journal.message.type.error"/>
						<july:searchbutton/>
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
						<%--
						<%	if (ParamsParser.getState(pageContext) == APPStates.ABONENT_FROMBILLHANDLEINNRI_BILL_JOURNAL_LIST ||
								ParamsParser.getState(pageContext) == APPStates.ABONENT_FROMPAYHANDLEINNRI_BILL_JOURNAL_LIST) { %>
							<july:backbutton page="<%= actionParent %>" paramId="<%= paramId4Bill %>" paramName="<%= form %>" paramProperty="<%= paramId4Bill %>" scope="session"/>
						<%	} else { %>
							<july:backbutton page="<%= actionParent %>"/>
						<%	} %>
						--%>
							<july:backbutton />
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<!-- Table header -->
	<tr class="title">
		<july:headercolumn key="label.journal.message.type" colType="string"/>
		<july:headercolumn key="label.journal.message" colType="string"/>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="text">
					<logic:equal name="it" property="jrntype" value="S"><bean:message key="label.journal.message.type.success"/></logic:equal>
					<logic:equal name="it" property="jrntype" value="W"><bean:message key="label.journal.message.type.warning"/></logic:equal>
					<logic:equal name="it" property="jrntype" value="E"><bean:message key="label.journal.message.type.error"/></logic:equal>
				</td>
				
 				<td class="text">
					<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_STRMESSAGE) %>">
						<bean:write name="it" property="jrnmessage" filter="true"/>
					</logic:equal>
					
					<logic:notEqual name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_STRMESSAGE) %>">
					
						<%	LeaseTaskJournalAccessBean beanJournal = (LeaseTaskJournalAccessBean) it;
							ActionMapping actionMapping = (ActionMapping) request.getAttribute("org.apache.struts.action.mapping.instance");
							MessageResources messageResources = new PropertyMessageResourcesFactory().createResources(
								actionMapping.getMappings().getServlet().getInitParameter("application"));
							
							try {
								LeaseArendaAgreementNewAccessBean beanAgreement = null;
								if (beanJournal.getLeasedocument() != null) {
									beanAgreement = new LeaseArendaAgreementNewAccessBean();
									beanAgreement.setInitKey_leaseDocument(beanJournal.getLeasedocument().intValue());
									beanAgreement.refreshCopyHelper();
								}
								
								String curr2 = "";
								if (beanJournal.getCurrency2() != null) {
									CurrencyAccessBean beanCurrency = new CurrencyAccessBean();
									beanCurrency.setInitKey_currency(beanJournal.getCurrency2().intValue());
									beanCurrency.refreshCopyHelper();
									curr2 = beanCurrency.getName();
								}
								
								ResourceAccessBean resourceBean1 = null;
								if (beanJournal.getResource1() != null) {
									resourceBean1 = new ResourceAccessBean();
									resourceBean1.setInitKey_resource(beanJournal.getResource1().intValue());
									resourceBean1.refreshCopyHelper();
								} %>
							
							<%-- prolongation --%>
							
							<%	if (beanJournal.getJournal2start().getTasktype().equals("1")) { %>
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PROLONGATION_SUCCESS) %>"><%--1--%>
									<bean:message key="journal.prolongation.success" arg0="<%= beanAgreement.getDocumentNumber() %>"
										arg1="<%= listForm.getCertainDate(beanJournal.getDate1()) %>"
										arg2="<%= listForm.getCertainDate(beanJournal.getDate2()) %>"/>&nbsp;
									<%	if (beanAgreement.getExtendPeriod().equals("Y")) { %>
										<bean:message key="label.extendperiod.year"/>
									<%	} else if (beanAgreement.getExtendPeriod().equals("M")) { %>
										<bean:message key="label.extendperiod.month"/>
									<%	} else if (beanAgreement.getExtendPeriod().equals("D")) { %>
										<bean:message key="label.extendperiod.day"/>
									<%	} %>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PROLONGATION_ERROR_ACTIVE) %>"><%--2--%>
									<bean:message key="journal.prolongation.error.active" arg0="<%= beanAgreement.getDocumentNumber() %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PROLONGATION_ERROR_STATE) %>"><%--3--%>
									<bean:message key="journal.prolongation.error.state" arg0="<%= beanAgreement.getDocumentNumber() %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PROLONGATION_ERROR_EXTENDTYPE) %>"><%--4--%>
									<bean:message key="journal.prolongation.error.extendtype" arg0="<%= beanAgreement.getDocumentNumber() %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PROLONGATION_ERROR_EXTENDPERIOD) %>"><%--5--%>
									<bean:message key="journal.prolongation.error.extendperiod" arg0="<%= beanAgreement.getDocumentNumber() %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PROLONGATION_ERROR_GENERAL) %>"><%--6--%>
									<bean:message key="journal.prolongation.error.general" arg0="<%= beanAgreement.getDocumentNumber() %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PROLONGATION_WARNING_CONTRACTSNOTEXIST) %>"><%--7--%>
									<bean:message key="journal.prolongation.warning.contractsnotexist"/>
								</logic:equal>
								
							<%-- charges --%>
								
							<%	} else if (beanJournal.getJournal2start().getTasktype().equals("2")) {
									LeaseChargeRuleAccessBean beanRule = null;
									if (beanJournal.getLeaserule() != null) {
										beanRule = new LeaseChargeRuleAccessBean();
										beanRule.setInitKey_leaseRule(beanJournal.getLeaserule().intValue());
										beanRule.refreshCopyHelper(); 
									}
									
									LeaseChargesAccessBean chargeBean = null;
									if (beanJournal.getLeasedocposition() != null) {
										chargeBean = new LeaseChargesAccessBean();
										chargeBean.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition().intValue());
									} %>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CHARGES_SUCCESS) %>"><%--20--%>
									<bean:message key="journal.charges.success" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CHARGES_WARNING_NOTCHANGE) %>"><%--21--%>
									<bean:message key="journal.charges.warning.notchange.a" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"
										arg4="<%= Integer.toString(beanRule.getLeaseRule()) %>"/>&nbsp;
									<bean:message key="journal.charges.warning.notchange.b" arg0="<%= listForm.getCertainDate(beanJournal.getDate1()) %>"
										arg1="<%= listForm.getCertainDate(beanJournal.getDate1()) %>"
										arg2="<%= beanJournal.getSumm2().toString() %>"
										arg3="<%= curr2 %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CHARGES_ERROR_RELATION) %>"><%--22--%>
									<bean:message key="journal.charges.error.relation.a" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"
										arg4="<%= Integer.toString(beanRule.getLeaseRule()) %>"/>&nbsp;
									<bean:message key="journal.charges.error.relation.b" arg0="<%= listForm.getCertainDate(beanJournal.getDate1()) %>"
										arg1="<%= listForm.getCertainDate(beanJournal.getDate1()) %>"
										arg2="<%= beanJournal.getSumm2().toString() %>"
										arg3="<%= curr2 %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CHARGES_ERROR_PERIOD) %>"><%--23--%>
									<bean:message key="journal.charges.error.period" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"
										arg4="<%= Integer.toString(beanRule.getLeaseRule()) %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CHARGES_ERROR_GENERAL) %>"><%--24--%>
									<bean:message key="journal.charges.error.general" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CHARGES_WARNING_CONTRACTSNOTEXIST) %>"><%--25--%>
									<bean:message key="journal.charges.warning.contractsnotexist"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CHARGES_WARNING_SALDONOTEXIST) %>"><%--26--%>
									<bean:message key="journal.charges.warning.saldonotexist.a" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"
										arg4="<%= Integer.toString(resourceBean1.getResource()) %>"/>&nbsp;
									<bean:message key="journal.charges.warning.saldonotexist.b" arg0="<%= resourceBean1.getName() %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CHARGES_WARNING_CLOSEPERIOD) %>"><%--27--%>
									<bean:message key="journal.charges.warning.closeperiod.a" arg0="<%= Integer.toString(chargeBean.getLeaseDocPosition()) %>"
										arg1="<%= listForm.getCertainDate(chargeBean.getDate()) %>"
										arg2="<%= chargeBean.getResource().getName() %>"
										arg3="<%= chargeBean.getLeaseContract().getDocumentNumber() %>"
										arg4="<%= listForm.getCertainDate(chargeBean.getLeaseContract().getDocumentDate()) %>"/>&nbsp;
									<bean:message key="journal.charges.warning.closeperiod.b" arg0="<%= listForm.getContractType(chargeBean.getLeaseContract().getContractType(), messageResources) %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CHARGES_WARNING_HANDCHARGE) %>"><%--28--%>
									<bean:message key="journal.charges.warning.handcharge.a" arg0="<%= Integer.toString(chargeBean.getLeaseDocPosition()) %>"
										arg1="<%= listForm.getCertainDate(chargeBean.getDate()) %>"
										arg2="<%= chargeBean.getResource().getName() %>"
										arg3="<%= chargeBean.getLeaseContract().getDocumentNumber() %>"
										arg4="<%= listForm.getCertainDate(chargeBean.getLeaseContract().getDocumentDate()) %>"/>&nbsp;
									<bean:message key="journal.charges.warning.handcharge.b" arg0="<%= listForm.getContractType(chargeBean.getLeaseContract().getContractType(), messageResources) %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CHARGES_WARNING_HASDNOP) %>"><%--29--%>
									<bean:message key="journal.charges.warning.hasdnop.a" arg0="<%= Integer.toString(chargeBean.getLeaseDocPosition()) %>"
										arg1="<%= listForm.getCertainDate(chargeBean.getDate()) %>"
										arg2="<%= chargeBean.getResource().getName() %>"
										arg3="<%= chargeBean.getLeaseContract().getDocumentNumber() %>"
										arg4="<%= listForm.getCertainDate(chargeBean.getLeaseContract().getDocumentDate()) %>"/>&nbsp;
									<bean:message key="journal.charges.warning.hasdnop.b" arg0="<%= listForm.getContractType(chargeBean.getLeaseContract().getContractType(), messageResources) %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CHARGES_ERROR_DATERULE) %>"><%--30--%>
									<bean:message key="journal.charges.error.daterule" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"
										arg4="<%= Integer.toString(beanRule.getLeaseRule()) %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_CHARGES_ERROR_NDS) %>"><%--31--%>
									<bean:message key="journal.charges.error.nds.a" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"
										arg4="<%= Integer.toString(resourceBean1.getResource()) %>"/>&nbsp;
									<bean:message key="journal.charges.error.nds.b" arg0="<%= resourceBean1.getName() %>"
										arg1="<%= listForm.getCertainDate(beanJournal.getDate1()) %>"/>
								</logic:equal>
								
							<%-- payments --%>
							
							<% } else if (beanJournal.getJournal2start().getTasktype().equals("3")) {
									LeasePayRuleAccessBean beanRule = null;
									if (beanJournal.getLeaserule() != null) {
										beanRule = new LeasePayRuleAccessBean();
										beanRule.setInitKey_leaseRule(beanJournal.getLeaserule().intValue());
										beanRule.refreshCopyHelper();
									}
									LeasePaymentAccessBean beanPay = null;
									if (beanJournal.getLeasedocposition() != null) {
										beanPay = new LeasePaymentAccessBean();
										beanPay.setInitKey_leaseDocPosition(beanJournal.getLeasedocposition().intValue());
										beanPay.refreshCopyHelper(); 
									} %>
							
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PAYMENTS_SUCCESS) %>"><%--60--%>
									<bean:message key="journal.payments.success" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PAYMENTS_ERROR_PERIOD) %>"><%--61--%>
									<bean:message key="journal.payments.error.period" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"
										arg4="<%= Integer.toString(beanRule.getLeaseRule()) %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PAYMENTS_WARNING_NOTCHANGE) %>"><%--62--%>
									<bean:message key="journal.payments.warning.notchange" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"
										arg4="<%= Integer.toString(beanRule.getLeaseRule()) %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PAYMENTS_ERROR_GENERAL) %>"><%--63--%>
									<bean:message key="journal.payments.error.general" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PAYMENTS_WARNING_CONTRACTSNOTEXIST) %>"><%--64--%>
									<bean:message key="journal.payments.warning.contractsnotexist"/>
								</logic:equal>
		
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PAYMENTS_WARNING_SALDONOTEXIST) %>"><%--65--%>
									<bean:message key="journal.payments.warning.saldonotexist.a" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"
										arg4="<%= Integer.toString(resourceBean1.getResource()) %>"/>&nbsp;
									<bean:message key="journal.payments.warning.saldonotexist.b" arg0="<%= resourceBean1.getName() %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PAYMENTS_WARNING_DATESALDO) %>"><%--66--%>
									<bean:message key="journal.payments.warning.datesaldo" arg0="<%= listForm.getCertainDate(beanJournal.getDate1()) %>"
										arg1="<%= listForm.getCertainDate(beanJournal.getDate2()) %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PAYMENTS_WARNING_NOTEDIT) %>"><%--67--%>
									<bean:message key="journal.payments.warning.notedit" arg0="<%= Integer.toString(beanPay.getLeaseDocPosition()) %>"
										arg1="<%= listForm.getCertainDate(beanPay.getDate()) %>"
										arg2="<%= beanPay.getDocNumber() %>"
										arg3="<%= beanPay.getSumRub().toString() %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PAYMENTS_ERROR_PPTYPE) %>"><%--68--%>
									<bean:message key="journal.payments.error.pptype" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"
										arg4="<%= Integer.toString(beanRule.getLeaseRule()) %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PAYMENTS_WARNING_ADDDAYTOPAYDATE) %>"><%--69--%>
									<bean:message key="journal.payments.warning.adddaytopaydate" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"
										arg4="<%= Integer.toString(beanRule.getLeaseRule()) %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PAYMENTS_ERROR_NDS) %>"><%--70--%>
									<bean:message key="journal.payments.error.nds.a" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"
										arg4="<%= Integer.toString(resourceBean1.getResource()) %>"/>&nbsp;
									<bean:message key="journal.payments.error.nds.b" arg0="<%= resourceBean1.getName() %>"
										arg1="<%= listForm.getCertainDate(beanJournal.getDate1()) %>"/>
								</logic:equal>
								
								<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_PAYMENTS_ERROR_RATE) %>"><%--71--%>
									<bean:message key="journal.payments.error.rate.a" arg0="<%= Integer.toString(beanAgreement.getLeaseDocument()) %>"
										arg1="<%= beanAgreement.getDocumentNumber() %>"
										arg2="<%= beanAgreement.getOrgCustomer().getName() %>"
										arg3="<%= beanAgreement.getOrgExecutor().getName() %>"
										arg4="<%= beanJournal.getCurrency2().toString() %>"/>&nbsp;
									<bean:message key="journal.payments.error.rate.b" arg0="<%= curr2 %>"
										arg1="<%= Integer.toString(beanPay.getLeaseDocPosition()) %>"
										arg2="<%= listForm.getCertainDate(beanPay.getDate()) %>"
										arg3="<%= beanPay.getDocNumber() %>"/>
								</logic:equal>
								
							<% } 
						} catch (javax.ejb.ObjectNotFoundException e) {
							e.printStackTrace(); %>
							
							<bean:message key="label.journal.notexistfk"/>
							
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
					<td class="buttons">
					<%--
						<%	if (ParamsParser.getState(pageContext) == APPStates.ABONENT_FROMBILLHANDLEINNRI_BILL_JOURNAL_LIST ||
								ParamsParser.getState(pageContext) == APPStates.ABONENT_FROMPAYHANDLEINNRI_BILL_JOURNAL_LIST) { %>
							<july:backbutton page="<%= actionParent %>" paramId="<%= paramId4Bill %>" paramName="<%= form %>" paramProperty="<%= paramId4Bill %>" scope="session"/>
						<%	} else { %>
							<july:backbutton page="<%= actionParent %>"/>
						<%	} %>
					--%>
							<july:backbutton />
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
			<%	if (ParamsParser.getState(pageContext) == APPStates.ABONENT_FROMBILLHANDLEINNRI_BILL_JOURNAL_LIST ||
					ParamsParser.getState(pageContext) == APPStates.ABONENT_FROMPAYHANDLEINNRI_BILL_JOURNAL_LIST) { %>
				<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
				<july:sepmark/>
				<july:editlink page="/ViewAbonent.do" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
				<july:sepmark/>
				<html:link page="<%= parent4Bill %>" styleClass="navigator"><bean:message key="<%= parent4BillMsg %>"/></html:link>
				<july:sepmark/>
				<html:link page="<%= actionParent %>" paramId="<%= paramId4Bill %>" paramName="<%= form %>" paramProperty="<%= paramId4Bill %>" styleClass="navigator">
					<bean:message key="label.change"/>
				</html:link>
				<july:sepmark/>
				<july:currmark><bean:message key="<%= message %>"/></july:currmark>
			<%	} else { %>
				<html:link page="<%= actionParent %>" styleClass="navigator"><bean:message key="<%= messageParent %>"/></html:link>
				<july:sepmark/>
				<july:currmark><bean:message key="<%= message %>"/></july:currmark>
			<%	} %>
		</td>
	</tr>
--%>


</table>


</july:browseform>

