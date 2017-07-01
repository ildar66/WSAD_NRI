<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%@include file ="initProfile.jspf"%>

<html>
<head>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
	<title><bean:message key="label.menu.root"/></title>
	<link rel="stylesheet" type="text/css" href="/main.css">
</head>


<body id="abody" onload="document.body.style.cursor='auto';">
<script language="JavaScript">
	document.body.style.cursor="wait";
</script>
<july:licence licence="/comctl2.lpk"/>
<%
	int app = ParamsParser.getApplication(pageContext);
	int state = ParamsParser.getState(pageContext);
	switch (app) {
	case Applications.ARENDA:
		switch (state) {
        case APPStates.ORG_LOOKUP:
          %>
          <jsp:include page="/orgLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.WORKER_LOOKUP:
          %>
          <jsp:include page="/workerLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.POS_LOOKUP:
          %>
          <jsp:include page="/positionLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.GROUP_LOOKUP:
          %>
          <jsp:include page="/groupLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.GROUPPING_LOOKUP:
          %>
          <jsp:include page="/grouppingLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
		case APPStates.RESOURCE_LOOKUP:
          %>
          <jsp:include page="/resourceLookupList.jsp" flush="true"></jsp:include>
          <%
		  break;
		case APPStates.RESTYPE_LOOKUP:
          %>
          <jsp:include page="/restypeLookupList.jsp" flush="true"></jsp:include>
          <%
		  break;
		case APPStates.RESSBTYPE_LOOKUP:
          %>
          <jsp:include page="/ressbtypeLookupList.jsp" flush="true"></jsp:include>
          <%
		  break;
		case APPStates.CONTRACT_LOOKUP:
          %>
          <jsp:include page="/contractLookupList.jsp" flush="true"></jsp:include>
          <%
		  break;
		case APPStates.ACCOUNT_LOOKUP:
          %>
          <jsp:include page="/accountLookupList.jsp" flush="true"></jsp:include>
          <%
		  break;
		case APPStates.OPERATOR_LOOKUP:
          %>
          <jsp:include page="/operatorLookupList.jsp" flush="true"></jsp:include>
          <%
		  break;
		case APPStates.RENTER_LOOKUP:
          %>
          <jsp:include page="/renterLookupList.jsp" flush="true"></jsp:include>
          <%
		  break;
		case APPStates.PAYMENT_LOOKUP:
          %>
          <jsp:include page="/paymentLookupList.jsp" flush="true"></jsp:include>
          <%
		  break;
		case APPStates.MUTACTS_EQUAL_REPORT:
          %>
          <jsp:include page="/mutactEqualReport.jsp" flush="true"></jsp:include>
          <%
		  break;
		case APPStates.MUTACTS_CALC_REPORT:
          %>
          <jsp:include page="/mutactCalcReport.jsp" flush="true"></jsp:include>
          <%
		  break;
  	case APPStates.ARENDA_REPORT3XLS:
  		%>
  	<jsp:include page="/arendaReport3xls.jsp" flush="true"></jsp:include>
  		<%
  		break;
		case APPStates.BANKLOOKUP :
          %>
          <jsp:include page="/bankLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
		case APPStates.CALC_HISTORY:
			%><jsp:include page="/calcHistoryForm.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.ERROR_CALC_HISTORY:
			%><jsp:include page="/errorCalcHistoryForm.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.ACT_PARAMS_PRINT:
			%><jsp:include page="/ActParamsPrint.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.AGREEMENT_INFO:
			%><jsp:include page="/agreementInfo.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.NFS_LIST:
			%><jsp:include page="/nfsList.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.NFS_PRINT:
			%><jsp:include page="/nfsPrint.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.NFS_ZP_LOOKUP_LIST:
			%><jsp:include page="/nfs_ZpLookupList.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.LEASE_RES_BIL_2NRI_LOOKUP_LIST:
			%><jsp:include page="/leaseResBil2nriLookupList.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.ABONENT_BILL_LOOKUP_LIST:
			%><jsp:include page="/abonentBillLookupList.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.TARIF_PLAN_LOOKUP_LIST:
			%><jsp:include page="/tarifPlanLookupList.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.BILLING_SERVISES_LOOKUP_LIST:
			%><jsp:include page="/billingServicesLookupList.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.CWA_CHARGES__PRINT:
			%><jsp:include page="/cwaChargesPrint.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.CHARGE_RULE_DIALOG_EDIT:
			%><jsp:include page="/chargeRuleDialogForm.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.PAY_RULE_DIALOG_EDIT:
			%><jsp:include page="/payRuleDialogForm.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.RATE_LIST:
			%><jsp:include page="/rateList.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.LAWYERS_NOTE_DIALOG:
			%><jsp:include page="/lawyearNoteDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.FLAGS_FROM_LEASE_CHARGES_DIALOG:
			%><jsp:include page="/flagsFromLeaseChargesDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.LICENCE_DIALOG:
			%><jsp:include page="/licenceDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.CONTRACT_COMMENT_DIALOG:
			%><jsp:include page="/contractCommentDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.LOAN_CONTRACT_DIALOG:
			%><jsp:include page="/loanContractDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.LOAN_CONTRACT_STATE:
			%><jsp:include page="/loanContractState.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.LOAN_AKT_GET_PUT_LIST:
			%><jsp:include page="/loanAktGetPutList.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.LOAN_AKT_GET_PUT_DIALOG:
			%><jsp:include page="/loanAktGetPutDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.SCHET_FACT_DIALOG:
			%><jsp:include page="/schetFactDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.CHARGE_DIALOG:
			%><jsp:include page="/chargeDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.CHARGE_AUTOMATIC_DIALOG_FORM:
			%><jsp:include page="/chargeAutomaticDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.JOURNAL_LIST:
			%><jsp:include page="/journalDialogList.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.CHARGE_LIST_LINK_TO_SCHET_FACT:
			%><jsp:include page="/chargeListLinkToSchetFact.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.REGISTRY_BUCH_DOCS_DIALOG:
			%><jsp:include page="/registryBuchDocsDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.PRIORITY_CONTRACT_FOR_ACT_LIST:
			%><jsp:include page="/priorityContractForActList.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.LEASE_PAY_OFFICE_MEMO_DIALOG:
			%><jsp:include page="/leasePayOfficeMemoDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.PAY_RULE_LOOKUP_LIST:
			%><jsp:include page="/payRuleLookupList.jsp" flush="true"></jsp:include><%
			break;																														
		case APPStates.LEASE_ZP_OFFICE_MEMO_DIALOG:
			%><jsp:include page="/leaseZPOfficeMemoDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.HISTORY_LOOKUP_LIST:
			%><jsp:include page="/historyLookupList.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.ARENDA_TO_NFS_ZP_LOOKUP_LIST:
			%><jsp:include page="/arendaToNfsZpLookupList.jsp" flush="true"></jsp:include><%
			break;			
		case APPStates.LEASE_CONTRACT_PROBLEM_DIALOG:
			%><jsp:include page="/leaseContractProblemDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.POSITIONS_DIALOG_LIST:
			%><jsp:include page="/positionsDialogList.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.COMPLET_WORK_AKT_DIALOG:
			%><jsp:include page="/completWorkAktDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.CHARGE_LIST_LINK_TO_COMPLET_WORK_AKT:
			%><jsp:include page="/chargeListLinkCompletWorkAkt.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.DNOP_DIALOG:
			%><jsp:include page="/dnopDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.SALDO_DETAIL_DIALOG:											
			%><jsp:include page="/saldoDetailDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.ABONENT_SALDO_DETAIL_DIALOG:											
			%><jsp:include page="/abonentSaldoDetailDialog.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.ABONENT_INFO:
			%><jsp:include page="/abonentInfo.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.REGISTRY_BUCH_DOCS_HISTORY:
			%><jsp:include page="/registryBuchDocsHistory.jsp" flush="true"></jsp:include><%
			break;
		case APPStates.CHARGE_LIST_LINK_TO_PAYMENT:
			%><jsp:include page="/chargeListLinkToPayment.jsp" flush="true"></jsp:include><%
			break;			
						
        default:
            %><jsp:include page="/arendaGraph.jsp" flush="true"></jsp:include><%
			break;
        }
		break;
	default:
	%>
	<jsp:include page="/error.jsp" flush="true"></jsp:include>
	<%
		break;
	}
%>
</body>
</html>

