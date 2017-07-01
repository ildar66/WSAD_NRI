<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<TABLE class=includer border="0" cellpadding="0" cellspacing="0">
	<TR>
		<TD vAlign=top width="100%">

		  <TABLE class="main" border="0" cellpadding="0" cellspacing="0" vAlign=top height="100%">
			<TR class="title" style="height:15"><TD class="title"><july:statenavigator/></TD></TR>
			<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>
			<july:errors property="org.apache.struts.action.GLOBAL_WARNING" color = "blue" headerKey="warning.header" footerKey="warning.footer"/>
			<TR><TD vAlign=top width="100%">

<%
	int state = ParamsParser.getState(pageContext);
	switch (state) {
	case APPStates.MAIN:
		%>
	<jsp:include page="/arendaMain.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.LOGIN:
		%>
	<jsp:include page="/loginForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.LOGOUT:
		%>
	<jsp:include page="/logoutForm.jsp" flush="true"></jsp:include>
		<%
		break;

	case APPStates.PLATINUM_DOGOVOR_FORM:
		%>
	<jsp:include page="/platinumDogovorForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.WE_ARENDA_LIST:
		%>
	<jsp:include page="/weArendaList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.WE_ARENDA_EDIT:
		%>
	<jsp:include page="/weArendaForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.DOG_HIST_CHRG_LIST:
		%>
		<jsp:include page="/doghistoryChargesList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.DOG_HIST_PAY_LIST:
		%>
		<jsp:include page="/doghistoryPayList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.DOG_ABONENTS_LIST:
		%>
		<jsp:include page="/dogAbonentsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_POS_LIST:
		%>
	<jsp:include page="/arendaPositionsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_POS_EDIT:
		%>
	<jsp:include page="/arendaPositionForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.US_ARENDA_LIST:
		%>
	<jsp:include page="/commonArendaList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.US_ARENDA_EDIT:
		%>
	<jsp:include page="/commonArendaForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHANNEL_ARENDA_LIST:
		%>
	<jsp:include page="/commonArendaList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHANNEL_ARENDA_EDIT:
		%>
	<jsp:include page="/commonArendaForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHARGE_RULES_LIST:
		%>
	<jsp:include page="/chargeRulesList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHARGE_RULE_EDIT:
		%>
	<jsp:include page="/chargeRuleForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.PAY_RULES_LIST:
		%>
	<jsp:include page="/payRulesList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.PAY_RULE_EDIT:
		%>
	<jsp:include page="/payRuleForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.MUTUAL_REGLMNTS_LIST:
		%>
	<jsp:include page="/mutualReglamentsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.MAINPARAMS_MUTREGLMNT_EDIT:
		%>
	<jsp:include page="/mainParamsMutReglmntForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.PHONES_MUTREGLMNT_LIST:
		%>
	<jsp:include page="/phonesMutReglmntList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.PHONE_MUTREGLMNT_EDIT:
		%>
	<jsp:include page="/phoneMutReglmntForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CONTRACTS_MUTREGLMNT_LIST:
		%>
	<jsp:include page="/contractsMutReglmntList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CONTRACT_MUTREGLMNT_EDIT:
		%>
	<jsp:include page="/contractMutReglmntForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.MUTUAL_RULES_LIST:
		%>
	<jsp:include page="/mutualRulesListForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.MUTUAL_RULE_EDIT:
		%>
	<jsp:include page="/mutualRuleForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHARGES_LIST:
		%>
	<jsp:include page="/chargesList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHARGE_EDIT:
		%>
	<jsp:include page="/chargeForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.PAYMENTS_LIST:
		%>
	<jsp:include page="/paymentsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.US_PAYMENT_EDIT:
	case APPStates.CHANNEL_PAYMENT_EDIT:
	case APPStates.HISTORY_PAYMENT_EDIT:
	case APPStates.PAYMENT_EDIT:
		%>
	<jsp:include page="/paymentForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.MUTACTS_LIST:
		%>
	<jsp:include page="/mutualActsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.MUTACT_EDIT:
		%>
	<jsp:include page="/mutualActForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.STATE_WEARENDA_EDIT:
		%>
	<jsp:include page="/stateForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.STATE_USARENDA_EDIT:
		%>
	<jsp:include page="/stateForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.STATE_CHANNELARENDA_EDIT:
		%>
	<jsp:include page="/stateForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_LIST:
		%>
	<jsp:include page="/historyList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_FORM:
		%>
	<jsp:include page="/historyForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_STATE_WEARENDA_EDIT:
		%>
	<jsp:include page="/stateForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_PAYMENTS_LIST:
		%>
	<jsp:include page="/paymentsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_CHARGES_LIST:
		%>
	<jsp:include page="/chargesList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_CHARGE_EDIT:
		%>
	<jsp:include page="/chargeForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_CHARGE_RULES_LIST:
		%>
	<jsp:include page="/chargeRulesList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_CHARGE_RULE_EDIT:
		%>
	<jsp:include page="/chargeRuleForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_PAY_RULES_LIST:
		%>
	<jsp:include page="/payRulesList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_PAY_RULE_EDIT:
		%>
	<jsp:include page="/payRuleForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_ARENDA_POS_LIST:
		%>
	<jsp:include page="/arendaPositionsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_ARENDA_POS_EDIT:
		%>
	<jsp:include page="/arendaPositionForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.US_PAYMENTS_LIST:
		%>
	<jsp:include page="/paymentsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.US_CHARGES_LIST:
		%>
	<jsp:include page="/chargesList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.US_CHARGE_EDIT:
		%>
	<jsp:include page="/chargeForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHANNEL_PAYMENTS_LIST:
		%>
	<jsp:include page="/paymentsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHANNEL_CHARGES_LIST:
		%>
	<jsp:include page="/chargesList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHANNEL_CHARGE_EDIT:
		%>
	<jsp:include page="/chargeForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.START_PROLONGATIONS_LIST:
		%>
	<jsp:include page="/startsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.START_PROLONGATION_FORM:
		%>
	<jsp:include page="/startProlongationForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.EXEC_PROLONGATION_FORM:
		%>
	<jsp:include page="/execProlongation.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.JOURNAL_PROLONGATIONS_LIST:
		%>
	<jsp:include page="/journalList.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.START_CHARGES_LIST:
		%>
	<jsp:include page="/startsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.START_CHARGE_FORM:
		%>
	<jsp:include page="/startProlongationForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.EXEC_CHARGE_FORM:
		%>
	<jsp:include page="/execCharge.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.JOURNAL_CHARGES_LIST:
		%>
	<jsp:include page="/journalList.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.START_PAYMENTS_LIST:
		%>
	<jsp:include page="/startsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.START_PAYMENT_FORM:
		%>
	<jsp:include page="/startProlongationForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.EXEC_PAYMENT_FORM:
		%>
	<jsp:include page="/execPayment.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.JOURNAL_PAYMENTS_LIST:
		%>
	<jsp:include page="/journalList.jsp" flush="true"></jsp:include>
		<%
		break;
		
     case APPStates.POS_MULTI:
        %>
    <jsp:include page="/positionMultiList.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.HISTORY_POS_MULTI:
        %>
    <jsp:include page="/positionMultiList.jsp" flush="true"></jsp:include>
        <%
        break;

// Abonent Contracts Part Begin
// @ANT

     case APPStates.BENS_LIST:
        %>
    <jsp:include page="/bensList.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.BEN_EDIT:
        %>
    <jsp:include page="/benForm.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENTS_LIST:
        %>
    <jsp:include page="/abonentsList.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENT_EDIT:
        %>
    <jsp:include page="/abonentForm.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENT_STATE:
        %>
    <jsp:include page="/abonentStateForm.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENTBAN_EDIT:
        %>
    <jsp:include page="/abonentBanForm.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENT_PAYMENTS_LIST:
        %>
    <jsp:include page="/paymentsList.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENT_CHARGES_LIST:
        %>
    <jsp:include page="/chargesList.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENT_CHARGE_EDIT:
        %>
    <jsp:include page="/chargeForm.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENT_BILLS_LIST:
        %>
    <jsp:include page="/abonentBillsList.jsp" flush="true"></jsp:include>
        <%
	break;
     case APPStates.ABONENT_BILL_EDIT:
        %>
    <jsp:include page="/abonentBill.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENT_BILLED_LIST:
        %>
    <jsp:include page="/abonentBilledList.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENT_BILL_POSES_LIST:
        %>
    <jsp:include page="/abonentBillPosesList.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENT_BILL_POS_EDIT:
        %>
    <jsp:include page="/abonentBillPos.jsp" flush="true"></jsp:include>
        <%
	break;
     case APPStates.ABONENT_PAYS_LIST:
        %>
    <jsp:include page="/abonentPaysList.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENT_PAYED_LIST:
        %>
    <jsp:include page="/abonentPayedList.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENT_PAY_EDIT:
        %>
    <jsp:include page="/abonentPay.jsp" flush="true"></jsp:include>
        <%
        break;
		
     case APPStates.ABONENT_BILL_QUERY:
        %>
    <jsp:include page="/abonentBillQuery.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENT_BILL_QUERY_TO_RESULT:
        %>
    <jsp:include page="/resultForm.jsp" flush="true"></jsp:include>
        <%
        break;
     case APPStates.ABONENT_BILL_QUERY_FROM_RESULT:
        %>
    <jsp:include page="/resultForm.jsp" flush="true"></jsp:include>
        <%
        break;

// Abonent Contracts Part End

		
	case APPStates.FROMCONTRACT_MUTUAL_REGLMNTS_LIST:
		%>
	<jsp:include page="/mutualReglamentsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_MAINPARAMS_MUTREGLMNT_EDIT:
		%>
	<jsp:include page="/mainParamsMutReglmntForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_PHONES_MUTREGLMNT_LIST:
		%>
	<jsp:include page="/phonesMutReglmntList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_PHONE_MUTREGLMNT_EDIT:
		%>
	<jsp:include page="/phoneMutReglmntForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_CONTRACTS_MUTREGLMNT_LIST:
		%>
	<jsp:include page="/contractsMutReglmntList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_CONTRACT_MUTREGLMNT_EDIT:
		%>
	<jsp:include page="/contractMutReglmntForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_MUTUAL_RULES_LIST:
		%>
	<jsp:include page="/mutualRulesListForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_MUTUAL_RULE_EDIT:
		%>
	<jsp:include page="/mutualRuleForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_MUTACTS_LIST:
		%>
	<jsp:include page="/mutualActsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_MUTACT_EDIT:
		%>
	<jsp:include page="/mutualActForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
		
	case APPStates.FROMHISTORY_MUTUAL_REGLMNTS_LIST:
		%>
	<jsp:include page="/mutualReglamentsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_MAINPARAMS_MUTREGLMNT_EDIT:
		%>
	<jsp:include page="/mainParamsMutReglmntForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_PHONES_MUTREGLMNT_LIST:
		%>
	<jsp:include page="/phonesMutReglmntList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_PHONE_MUTREGLMNT_EDIT:
		%>
	<jsp:include page="/phoneMutReglmntForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_CONTRACTS_MUTREGLMNT_LIST:
		%>
	<jsp:include page="/contractsMutReglmntList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_CONTRACT_MUTREGLMNT_EDIT:
		%>
	<jsp:include page="/contractMutReglmntForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_MUTUAL_RULES_LIST:
		%>
	<jsp:include page="/mutualRulesListForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_MUTUAL_RULE_EDIT:
		%>
	<jsp:include page="/mutualRuleForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_MUTACTS_LIST:
		%>
	<jsp:include page="/mutualActsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_MUTACT_EDIT:
		%>
	<jsp:include page="/mutualActForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
		
	case APPStates.STATE_MUTREGLMNT_EDIT:
		%>
	<jsp:include page="/stateReglamentForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_STATE_MUTREGLMNT_EDIT:
		%>
	<jsp:include page="/stateReglamentForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_STATE_MUTREGLMNT_EDIT:
		%>
	<jsp:include page="/stateReglamentForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.COPY_REGLAMENT:
		%>
	<jsp:include page="/copyReglamentForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_COPY_REGLAMENT:
		%>
	<jsp:include page="/copyReglamentForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_COPY_REGLAMENT:
		%>
	<jsp:include page="/copyReglamentForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.STATE_MUTACT_EDIT:
		%>
	<jsp:include page="/stateActForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_STATE_MUTACT_EDIT:
		%>
	<jsp:include page="/stateActForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_STATE_MUTACT_EDIT:
		%>
	<jsp:include page="/stateActForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.STATE_PAYMENT_EDIT:
		%>
	<jsp:include page="/statePaymentForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_STATE_PAYMENT_EDIT:
		%>
	<jsp:include page="/statePaymentForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.US_STATE_PAYMENT_EDIT:
		%>
	<jsp:include page="/statePaymentForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHANNEL_STATE_PAYMENT_EDIT:
		%>
	<jsp:include page="/statePaymentForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ABONENT_STATE_PAYMENT_EDIT:
		%>
	<jsp:include page="/statePaymentForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.REGLAMENT_CONTRACT_PRIORS_LIST:
		%>
	<jsp:include page="/MRCntPriorsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.REGLAMENT_CONTRACT_PRIOR_EDIT:
		%>
	<jsp:include page="/MRCntPriorForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_REGLAMENT_CONTRACT_PRIORS_LIST:
		%>
	<jsp:include page="/MRCntPriorsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_REGLAMENT_CONTRACT_PRIOR_EDIT:
		%>
	<jsp:include page="/MRCntPriorForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_REGLAMENT_CONTRACT_PRIORS_LIST:
		%>
	<jsp:include page="/MRCntPriorsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_REGLAMENT_CONTRACT_PRIOR_EDIT:
		%>
	<jsp:include page="/MRCntPriorForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.SALDO_LIST:
		%>
	<jsp:include page="/saldoList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.SALDO_EDIT:
		%>
	<jsp:include page="/saldoForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_SALDO_LIST:
		%>
	<jsp:include page="/saldoList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_SALDO_EDIT:
		%>
	<jsp:include page="/saldoForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.US_SALDO_LIST:
		%>
	<jsp:include page="/saldoList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.US_SALDO_EDIT:
		%>
	<jsp:include page="/saldoForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHANNEL_SALDO_LIST:
		%>
	<jsp:include page="/saldoList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHANNEL_SALDO_EDIT:
		%>
	<jsp:include page="/saldoForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.CALC_CONTRACT_STEP1:
		%>
	<jsp:include page="/calcContractStep1Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CALC_CONTRACT_STEP2:
		%>
	<jsp:include page="/calcContractStep2Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CALC_CONTRACT_STEP3:
		%>
	<jsp:include page="/calcContractStep3Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_CALC_CONTRACT_STEP1:
		%>
	<jsp:include page="/calcContractStep1Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_CALC_CONTRACT_STEP2:
		%>
	<jsp:include page="/calcContractStep2Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_CALC_CONTRACT_STEP3:
		%>
	<jsp:include page="/calcContractStep3Form.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.PAYMENT_RATES_LIST:
	case APPStates.HISTORY_PAYMENT_RATES_LIST:
	case APPStates.US_PAYMENT_RATES_LIST:
	case APPStates.CHANNEL_PAYMENT_RATES_LIST:
	case APPStates.ABONENT_PAYMENT_RATES_LIST:
		%>
	<jsp:include page="/paymentRatesList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.PAYMENT_RATE_EDIT:
	case APPStates.HISTORY_PAYMENT_RATE_EDIT:
	case APPStates.US_PAYMENT_RATE_EDIT:
	case APPStates.CHANNEL_PAYMENT_RATE_EDIT:
	case APPStates.ABONENT_PAYMENT_RATE_EDIT:
		%>
	<jsp:include page="/paymentRateForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.START_ACT_LIST:
		%>
	<jsp:include page="/startActList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.JOURNAL_ACT_LIST:
		%>
	<jsp:include page="/journalActList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_START_ACT_LIST:
		%>
	<jsp:include page="/startActList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMCONTRACT_JOURNAL_ACT_LIST:
		%>
	<jsp:include page="/journalActList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_START_ACT_LIST:
		%>
	<jsp:include page="/startActList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.FROMHISTORY_JOURNAL_ACT_LIST:
		%>
	<jsp:include page="/journalActList.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.CHARGE_RATES_LIST:
	case APPStates.HISTORY_CHARGE_RATES_LIST:
	case APPStates.US_CHARGE_RATES_LIST:
	case APPStates.CHANNEL_CHARGE_RATES_LIST:
	case APPStates.ABONENT_CHARGE_RATES_LIST:
		%>
	<jsp:include page="/chargeRatesList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHARGE_RATE_EDIT:
	case APPStates.HISTORY_CHARGE_RATE_EDIT:
	case APPStates.US_CHARGE_RATE_EDIT:
	case APPStates.CHANNEL_CHARGE_RATE_EDIT:
	case APPStates.ABONENT_CHARGE_RATE_EDIT:
		%>
	<jsp:include page="/chargeRateForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHARGE_DNOP_LIST:
	case APPStates.HISTORY_CHARGE_DNOP_LIST:
	case APPStates.US_CHARGE_DNOP_LIST:
	case APPStates.CHANNEL_CHARGE_DNOP_LIST:
	case APPStates.ABONENT_CHARGE_DNOP_LIST:
		%>
	<jsp:include page="/chargeDnopList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.CHARGE_DNOP_EDIT:
	case APPStates.HISTORY_CHARGE_DNOP_EDIT:
	case APPStates.US_CHARGE_DNOP_EDIT:
	case APPStates.CHANNEL_CHARGE_DNOP_EDIT:
	case APPStates.ABONENT_CHARGE_DNOP_EDIT:
		%>
	<jsp:include page="/chargeDnopForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT1_PARAMS:
		%>
	<jsp:include page="/arendaReport1ParamsForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT1:
		%>
	<jsp:include page="/arendaReport1Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT2_PARAMS:
		%>
	<jsp:include page="/arendaReport2ParamsForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT2:
		%>
	<jsp:include page="/arendaReport2Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT3_PARAMS:
		%>
	<jsp:include page="/arendaReport3ParamsForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT3:
		%>
	<jsp:include page="/arendaReport3Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT4_PARAMS:
		%>
	<jsp:include page="/arendaReport4ParamsForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT4:
		%>
	<jsp:include page="/arendaReport4Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT5_PARAMS:
		%>
	<jsp:include page="/arendaReport5ParamsForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT5:
		%>
	<jsp:include page="/arendaReport5Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT7_PARAMS:
		%>
	<jsp:include page="/arendaReport7ParamsForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT7:
		%>
	<jsp:include page="/arendaReport7Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT8_PARAMS:
		%>
	<jsp:include page="/arendaReport8ParamsForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT8:
		%>
	<jsp:include page="/arendaReport8Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT9_PARAMS:
		%>
	<jsp:include page="/arendaReport9ParamsForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT9:
		%>
	<jsp:include page="/arendaReport9Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT10_PARAMS:
		%>
	<jsp:include page="/arendaReport10ParamsForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT10:
		%>
	<jsp:include page="/arendaReport10Form.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT11_PARAMS:
		%>
	<jsp:include page="/arendaReport11ParamsForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ARENDA_REPORT11:
		%>
	<jsp:include page="/arendaReport11Form.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.PLATINUM_ERROR_MOVECONTRACTTOPIE:
		%>
	<jsp:include page="/errorMoveToPie.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.PLATINUM_ERROR_HISTORY_MOVECONTRACTTOPIE:
		%>
	<jsp:include page="/errorMoveToPie.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.PLATINUM_ERROR_MOVEPAYTOPIE:
		%>
	<jsp:include page="/errorMoveToPie.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.PLATINUM_ERROR_HISTORY_MOVEPAYTOPIE:
		%>
	<jsp:include page="/errorMoveToPie.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.PLATINUM_GETPAYFROMPLATINUM:
		%>
	<jsp:include page="/getPayFromPlatinumForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.PLATINUM_HISTORY_GETPAYFROMPLATINUM:
		%>
	<jsp:include page="/getPayFromPlatinumForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.ABONENT_SALDO_LIST:
		%>
	<jsp:include page="/saldoList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ABONENT_SALDO_EDIT:
		%>
	<jsp:include page="/saldoForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.ABONENT_BILL_START_LIST:
		%>
	<jsp:include page="/startsList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ABONENT_BILL_JOURNAL_LIST:
		%>
	<jsp:include page="/journalList.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.ABONENT_BILL_HANDLE_INNRI:
		%>
	<jsp:include page="/handleInNriForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ABONENT_PAY_HANDLE_INNRI:
		%>
	<jsp:include page="/handleInNriForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.ABONENT_PAYMENT_EDIT:
		%>
	<jsp:include page="/abonentPayment.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.ABONENT_FROMBILLHANDLEINNRI_BILL_JOURNAL_LIST:
		%>
	<jsp:include page="/journalList.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.ABONENT_FROMPAYHANDLEINNRI_BILL_JOURNAL_LIST:
		%>
	<jsp:include page="/journalList.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.GET_SPR_ARENDA:
		%>
	<jsp:include page="/getSprArenda.jsp" flush="true"></jsp:include>        
		<%
		break;
	case APPStates.GET_SPR_ARENDA_RESULT:
		%>
	<jsp:include page="/getSprArendaResult.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.GET_BANKS:
		%>
	<jsp:include page="/getBanks.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.GET_BANKS_RESULT:
		%>
	<jsp:include page="/getSprArendaResult.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.GET_PAYS:
		%>
	<jsp:include page="/getPays.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.GET_PAYS_RESULT:
		%>
	<jsp:include page="/getSprArendaResult.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.FACTURA_EDIT:
		%>
	<jsp:include page="/facturaForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_FACTURA_EDIT:
		%>
	<jsp:include page="/facturaForm.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.PRINT_FACTURA:
		%>
	<jsp:include page="/printFactura.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.HISTORY_PRINT_FACTURA:
		%>
	<jsp:include page="/printFactura.jsp" flush="true"></jsp:include>
		<%
		break;
		
		
	case APPStates.FACTURA_MUTACT_LIST:
	case APPStates.FROMCONTRACT_FACTURA_MUTACT_LIST:
	case APPStates.FROMHISTORY_FACTURA_MUTACT_LIST:
		%>
	<jsp:include page="/facturaMutactList.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.FACTURA_MUTACT_EDIT:
	case APPStates.FROMCONTRACT_FACTURA_MUTACT_EDIT:
	case APPStates.FROMHISTORY_FACTURA_MUTACT_EDIT:
		%>
	<jsp:include page="/facturaMutactForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.FACTURA_POS_MUTACT_LIST:
	case APPStates.FROMCONTRACT_FACTURA_POS_MUTACT_LIST:
	case APPStates.FROMHISTORY_FACTURA_POS_MUTACT_LIST:
		%>
	<jsp:include page="/facturaPosMutactList.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.FACTURA_POS_MUTACT_EDIT:
	case APPStates.FROMCONTRACT_FACTURA_POS_MUTACT_EDIT:
	case APPStates.FROMHISTORY_FACTURA_POS_MUTACT_EDIT:
		%>
	<jsp:include page="/facturaPosMutactForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.ABONENT_BILL_LINKS_LIST:
		%>
	<jsp:include page="/abonentBillLinksList.jsp" flush="true"></jsp:include>
		<%
		break;

	case APPStates.ABONENT_BILL_LINK_EDIT:
		%>
	<jsp:include page="/abonentBillLinkForm.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.GETPAYS_BYCONTRACT:
	case APPStates.HISTORY_GETPAYS_BYCONTRACT:
		%>
	<jsp:include page="/getPaysByContract.jsp" flush="true"></jsp:include>
		<%
		break;
		
	case APPStates.UNDER_CONSTRACTION_REP1:
	case APPStates.UNDER_CONSTRACTION_REP2:
		%>
	<jsp:include page="/underConstraction.jsp" flush="true"></jsp:include>
		<%
		break;

	case APPStates.ACT_CONTENTS_LIST:
		%>
	<jsp:include page="/actContentsList.jsp" flush="true"></jsp:include>
		<%
		break;

	case APPStates.ARENDA_TO_NFS_ZP_LIST:
		%>
	<jsp:include page="/arendaToNfsZpList.jsp" flush="true"></jsp:include>
		<%
		break;

	case APPStates.MEMO_LIST:
		%>
	<jsp:include page="/memoList.jsp" flush="true"></jsp:include>
		<%
		break;

	case APPStates.MEMO_EDIT:
		%>
	<jsp:include page="/memoForm.jsp" flush="true"></jsp:include>
		<%
		break;

	case APPStates.MEMO_POS_LIST:
		%>
	<jsp:include page="/memoPosList.jsp" flush="true"></jsp:include>
		<%
		break;

	case APPStates.MEMO_POS_EDIT:
		%>
	<jsp:include page="/memoPosForm.jsp" flush="true"></jsp:include>
		<%
		break;

	case APPStates.COMPLET_WORK_AKT_EDIT:
		%>
	<jsp:include page="/completWorkAktForm.jsp" flush="true"></jsp:include>
		<%
		break;

	default:
		%>
      <jsp:include page="/error.jsp" flush="true"></jsp:include>
		<%
		break;
	}
%>

						</TD>
					</TR>
					<tr class="title" style="height:15"><td class="title" valign="top"><july:statenavigator/></td></tr>
					</TABLE>


		</TD>
	</TR>

	<tr>
		<td class="probel" colspan="3" style="height:2px;background-image:/images/points.gif" ><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
	</tr>

</TABLE>