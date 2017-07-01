<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*, com.hps.july.constants.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	int appHome = ParamsParser.getRootApp( pageContext );
	int app = ParamsParser.getApplication( pageContext );
	String labelRoot = (app==Applications.DICTIONARY)?"label.menu.rootArenda":"label.menu.root";
	//роли:
	boolean isAdministrator = request.isUserInRole("administrator");//isVisibleResources
	boolean isArendaDirector =request.isUserInRole("ArendaDirector");//isVisibleResources
	boolean isArendaMainManager = request.isUserInRole("ArendaMainManager");
	boolean isArendaManager = request.isUserInRole("ArendaManager");
	boolean isArendaMainEconomist = request.isUserInRole("ArendaMainEconomist");//isVisibleResources
	boolean isArendaEconomist = request.isUserInRole("ArendaEconomist");//isVisibleResources
	boolean isViewerPays = request.isUserInRole("viewerPays");
	boolean isLcs = request.isUserInRole("lcsEditAllLicence") || request.isUserInRole("lcsEditFAS") || request.isUserInRole("lcsEditGPS")|| request.isUserInRole("lcsEditGASN") || request.isUserInRole("lcsEditSES")|| request.isUserInRole("lcsEditElectro") || request.isUserInRole("lcsEditLand") || request.isUserInRole("lcsEditProperty") ;
	//группы:
	boolean isVisibleResources = isAdministrator || isArendaMainEconomist || isArendaEconomist || isArendaDirector;
%>

<july:menu selectedId="<%= ParamsParser.getState(pageContext) %>">
	
	 <july:menuitem key="<%= labelRoot %>" action="/arenda/main.do?navclear=1" stateId="<%= APPStates.MAIN %>">
		<july:menuselection stateId="<%= APPStates.MAIN %>"/>
		 <% if (isVisibleResources) { %>
		<july:menuitem key="label.menu.we" action="/arenda/ShowWeArendaList.do?navclear=1" stateId="<%= APPStates.WE_ARENDA_LIST %>">
		<%if(app!=Applications.DICTIONARY) {%>
			<july:menuselection stateId="<%= APPStates.WE_ARENDA_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.WE_ARENDA_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.DOG_HISTORY_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.DOG_HIST_CHRG_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.DOG_HIST_PAY_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.DOG_ABONENTS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.ARENDA_POS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.POS_MULTI %>"/>
			<july:menuselection stateId="<%= APPStates.ARENDA_POS_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.CHARGE_RULES_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.CHARGE_RULE_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.PAY_RULES_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.PAY_RULE_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.CHARGES_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.CHARGE_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.PAYMENTS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.PAYMENT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.STATE_WEARENDA_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_FORM %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_PAYMENTS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_PAYMENT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_CHARGES_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_CHARGE_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_ARENDA_POS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_ARENDA_POS_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_CHARGE_RULES_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_CHARGE_RULE_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_PAY_RULES_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_PAY_RULE_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_STATE_WEARENDA_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_POS_MULTI %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_MUTUAL_REGLMNTS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_MAINPARAMS_MUTREGLMNT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_PHONES_MUTREGLMNT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_PHONE_MUTREGLMNT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_CONTRACTS_MUTREGLMNT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_CONTRACT_MUTREGLMNT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_MUTUAL_RULES_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_MUTUAL_RULE_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_MUTACTS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_MUTACT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_MUTUAL_REGLMNTS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_MAINPARAMS_MUTREGLMNT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_PHONES_MUTREGLMNT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_PHONE_MUTREGLMNT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_CONTRACTS_MUTREGLMNT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_CONTRACT_MUTREGLMNT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_MUTUAL_RULES_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_MUTUAL_RULE_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_MUTACTS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_MUTACT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_COPY_REGLAMENT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_COPY_REGLAMENT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_STATE_MUTREGLMNT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_STATE_MUTREGLMNT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_STATE_MUTACT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_STATE_MUTACT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.STATE_PAYMENT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_STATE_PAYMENT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_REGLAMENT_CONTRACT_PRIORS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_REGLAMENT_CONTRACT_PRIOR_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_REGLAMENT_CONTRACT_PRIORS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_REGLAMENT_CONTRACT_PRIOR_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.SALDO_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.SALDO_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_SALDO_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_SALDO_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.CALC_CONTRACT_STEP1 %>"/>
			<july:menuselection stateId="<%= APPStates.CALC_CONTRACT_STEP2 %>"/>
			<july:menuselection stateId="<%= APPStates.CALC_CONTRACT_STEP3 %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_CALC_CONTRACT_STEP1 %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_CALC_CONTRACT_STEP2 %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_CALC_CONTRACT_STEP3 %>"/>
			<july:menuselection stateId="<%= APPStates.PAYMENT_RATES_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.PAYMENT_RATE_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_PAYMENT_RATES_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_PAYMENT_RATE_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_START_ACT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_JOURNAL_ACT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_START_ACT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_JOURNAL_ACT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.CHARGE_RATES_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.CHARGE_RATE_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_CHARGE_RATES_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_CHARGE_RATE_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.CHARGE_DNOP_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.CHARGE_DNOP_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_CHARGE_DNOP_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_CHARGE_DNOP_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.PLATINUM_DOGOVOR_FORM %>"/>
			<july:menuselection stateId="<%= APPStates.PLATINUM_ERROR_MOVECONTRACTTOPIE %>"/>
			<july:menuselection stateId="<%= APPStates.PLATINUM_ERROR_HISTORY_MOVECONTRACTTOPIE %>"/>
			<july:menuselection stateId="<%= APPStates.PLATINUM_ERROR_MOVEPAYTOPIE %>"/>
			<july:menuselection stateId="<%= APPStates.PLATINUM_ERROR_HISTORY_MOVEPAYTOPIE %>"/>
			<july:menuselection stateId="<%= APPStates.FACTURA_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_FACTURA_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.PRINT_FACTURA %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_PRINT_FACTURA %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_FACTURA_MUTACT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_FACTURA_MUTACT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_FACTURA_POS_MUTACT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMCONTRACT_FACTURA_POS_MUTACT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_FACTURA_MUTACT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_FACTURA_MUTACT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_FACTURA_POS_MUTACT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMHISTORY_FACTURA_POS_MUTACT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.GETPAYS_BYCONTRACT %>"/>
			<july:menuselection stateId="<%= APPStates.HISTORY_GETPAYS_BYCONTRACT %>"/>
			<july:menuselection stateId="<%= APPStates.ACT_CONTENTS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.ARENDA_TO_NFS_ZP_LIST %>"/>
		<%}%>
		</july:menuitem>
		<%}%>

		<% if (isVisibleResources || isArendaManager || isArendaMainManager) { %>
		<july:menuitem key="label.menu.listFromPosition" action="/arenda/ListFromPosition.do?navclear=1" stateId="<%= APPStates.LIST_FROM_POSITION %>">
			<july:menuselection stateId="<%= APPStates.LIST_FROM_POSITION %>"/>
		</july:menuitem>
		<%}%>

		<% if (isVisibleResources) { %>
		<july:menuitem key="label.menu.loanContractList" action="/arenda/LoanContractList.do?navclear=1" stateId="<%= APPStates.LOAN_CONTRACT_LIST%>">
			<july:menuselection stateId="<%= APPStates.LOAN_CONTRACT_LIST%>"/>
			<july:menuselection stateId="<%= APPStates.LOAN_CONTRACT_MEMO_LIST%>"/>
			<july:menuselection stateId="<%= APPStates.LOAN_CONTRACT_MEMO%>"/>
		</july:menuitem>
		<%}%>

		<% if (isVisibleResources) { %>
		<july:menuitem key="navtitle.ShowRespPaysList" action="/arenda/ShowRespPaysList.do?navclear=1" stateId="<%= APPStates.RESP_PAYS_LIST%>">
			<july:menuselection stateId="<%= APPStates.RESP_PAYS_LIST %>"/>
		</july:menuitem>
		<%}%>

		<% if (isVisibleResources) { %>
		<july:menuitem key="label.menu.billing" stateId="-1">
			<july:menuitem key="label.menu.billing.abonents" action="/arenda/ShowAbonentsList.do?navclear=1" stateId="<%= APPStates.ABONENTS_LIST %>">
				<july:menuselection stateId="<%= APPStates.MEMO_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.MEMO_POS_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.MEMO_EDIT %>"/>
				<july:menuselection stateId="<%= APPStates.MEMO_POS_EDIT %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENTS_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_EDIT %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_PAYMENTS_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_PAYMENT_EDIT %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_CHARGES_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_CHARGE_EDIT %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_BILLS_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_BILL_POSES_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_BILL_POS_EDIT %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_BILLED_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENTBAN_EDIT %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_STATE %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_BILL_EDIT %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_PAYS_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_PAYED_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_PAY_EDIT %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_SALDO_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_SALDO_EDIT %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_BILL_HANDLE_INNRI %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_PAY_HANDLE_INNRI %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_FROMBILLHANDLEINNRI_BILL_JOURNAL_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_FROMPAYHANDLEINNRI_BILL_JOURNAL_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_CHARGE_RATES_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_CHARGE_RATE_EDIT %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_PAYMENT_RATES_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_PAYMENT_RATE_EDIT %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_CHARGE_DNOP_LIST %>"/>
				<july:menuselection stateId="<%= APPStates.ABONENT_CHARGE_DNOP_EDIT %>"/>
				<july:menuselection stateId="<%= APPStates.COURIER_DELIVERY_LIST%>"/>
			</july:menuitem>

			<july:menuitem key="label.menu.billing.memo" action="/arenda/ShowMemoListDetach.do?navclear=1" stateId="<%= APPStates.MEMO_LIST_DETACH%>">
				<july:menuselection stateId="<%= APPStates.MEMO_LIST_DETACH %>"/>
				<july:menuselection stateId="<%= APPStates.MEMO_DETACH_FORM %>"/>
			</july:menuitem>		

			<% if (isAdministrator) { %>
				<july:menuitem key="label.bill.query" action="/arenda/AbonentBillQuery.do?navclear=1" stateId="<%= APPStates.ABONENT_BILL_QUERY %>">
					<july:menuselection stateId="<%= APPStates.ABONENT_BILL_QUERY %>"/>
					<july:menuselection stateId="<%= APPStates.ABONENT_BILL_QUERY_TO_RESULT %>"/>
				</july:menuitem>

				<july:menuitem key="label.bill.journal" action="/arenda/ShowStartBillList.do?navclear=1" stateId="<%= APPStates.ABONENT_BILL_START_LIST %>">
					<july:menuselection stateId="<%= APPStates.ABONENT_BILL_START_LIST %>"/>
					<july:menuselection stateId="<%= APPStates.ABONENT_BILL_JOURNAL_LIST %>"/>
				</july:menuitem>
			<% } %>

				<july:menuitem key="label.bill.link" action="/arenda/ShowAbonentBillLinksList.do?navclear=1" stateId="<%= APPStates.ABONENT_BILL_LINKS_LIST %>">
					<july:menuselection stateId="<%= APPStates.ABONENT_BILL_LINKS_LIST %>"/>
					<july:menuselection stateId="<%= APPStates.ABONENT_BILL_LINK_EDIT %>"/>
				</july:menuitem>

		</july:menuitem>

		<july:menuitem key="label.menu.reglament" action="/arenda/ShowMutualReglamentsList.do?navclear=1" stateId="<%= APPStates.MUTUAL_REGLMNTS_LIST %>">
			<july:menuselection stateId="<%= APPStates.MUTUAL_REGLMNTS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.MAINPARAMS_MUTREGLMNT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.PHONES_MUTREGLMNT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.PHONE_MUTREGLMNT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.CONTRACTS_MUTREGLMNT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.CONTRACT_MUTREGLMNT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.MUTUAL_RULES_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.MUTUAL_RULE_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.MUTACTS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.MUTACT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.STATE_MUTREGLMNT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.COPY_REGLAMENT %>"/>
			<july:menuselection stateId="<%= APPStates.STATE_MUTACT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.REGLAMENT_CONTRACT_PRIORS_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.REGLAMENT_CONTRACT_PRIOR_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.START_ACT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.JOURNAL_ACT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FACTURA_MUTACT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FACTURA_MUTACT_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.FACTURA_POS_MUTACT_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FACTURA_POS_MUTACT_EDIT %>"/>
		</july:menuitem>
		<% } %>

		<% if (isArendaMainEconomist || isAdministrator) { %>
			<july:menuitem key="label.menu.autoproc" stateId="-2">
				<july:menuitem key="label.menu.autoproc.prolongation" action="/arenda/ShowStartProlongationsList.do?navclear=1" stateId="<%= APPStates.START_PROLONGATIONS_LIST %>">
					<july:menuselection stateId="<%= APPStates.START_PROLONGATIONS_LIST %>"/>
					<july:menuselection stateId="<%= APPStates.START_PROLONGATION_FORM %>"/>
					<july:menuselection stateId="<%= APPStates.EXEC_PROLONGATION_FORM %>"/>
					<july:menuselection stateId="<%= APPStates.JOURNAL_PROLONGATIONS_LIST %>"/>
				</july:menuitem>

				<july:menuitem key="label.menu.autoproc.charges" action="/arenda/ShowStartChargesList.do?navclear=1" stateId="<%= APPStates.START_CHARGES_LIST %>">
					<july:menuselection stateId="<%= APPStates.START_CHARGES_LIST %>"/>
					<july:menuselection stateId="<%= APPStates.START_CHARGE_FORM %>"/>
					<july:menuselection stateId="<%= APPStates.EXEC_CHARGE_FORM %>"/>
					<july:menuselection stateId="<%= APPStates.JOURNAL_CHARGES_LIST %>"/>
				</july:menuitem>

				<july:menuitem key="label.menu.autoproc.payments" action="/arenda/ShowStartPaymentsList.do?navclear=1" stateId="<%= APPStates.START_PAYMENTS_LIST %>">
					<july:menuselection stateId="<%= APPStates.START_PAYMENTS_LIST %>"/>
					<july:menuselection stateId="<%= APPStates.START_PAYMENT_FORM %>"/>
					<july:menuselection stateId="<%= APPStates.EXEC_PAYMENT_FORM %>"/>
					<july:menuselection stateId="<%= APPStates.JOURNAL_PAYMENTS_LIST %>"/>
				</july:menuitem>

			</july:menuitem>
		<% } %>

		
		<% if (isVisibleResources || isArendaManager || isArendaMainManager) { %>
		<july:menuitem key="label.menu.reports" stateId="-3">

			<july:menuitem key="label.report3" action="/arenda/ArendaReport3Params.do?navclear=1" stateId="<%= APPStates.ARENDA_REPORT3_PARAMS %>">
				<july:menuselection stateId="<%= APPStates.ARENDA_REPORT3_PARAMS %>"/>
				<july:menuselection stateId="<%= APPStates.ARENDA_REPORT3 %>"/>
			</july:menuitem>

 		</july:menuitem>
		<% } %>
		
		
		
    <%-- Работа с Platinum
		<% if (isAdministrator) { %>
			<july:menuitem key="label.platinum.interact" stateId="-4">
				<july:menuitem key="label.getsprarenda" action="/arenda/GetSprArenda.do?navclear=1" stateId="<%= APPStates.GET_SPR_ARENDA %>">
					<july:menuselection stateId="<%= APPStates.GET_SPR_ARENDA %>"/>
					<july:menuselection stateId="<%= APPStates.GET_SPR_ARENDA_RESULT %>"/>
				</july:menuitem>

				<july:menuitem key="label.getbanks" action="/arenda/GetBanks.do?navclear=1" stateId="<%= APPStates.GET_BANKS %>">
					<july:menuselection stateId="<%= APPStates.GET_BANKS %>"/>
					<july:menuselection stateId="<%= APPStates.GET_BANKS_RESULT %>"/>
				</july:menuitem>

				<july:menuitem key="label.getpays" action="/arenda/GetPays.do?navclear=1" stateId="<%= APPStates.GET_PAYS %>">
					<july:menuselection stateId="<%= APPStates.GET_PAYS %>"/>
					<july:menuselection stateId="<%= APPStates.GET_PAYS_RESULT %>"/>
				</july:menuitem>

			</july:menuitem>

		<% } %>
		--%>
		
		
		<% if (isVisibleResources) { %>
        <!-- Справочники -->
		<july:menuitem key="label.menu.dict" stateId="-5">

			<july:menuitem key="label.menu.dict.banks" action="/dict/ShowBankList.do?rootapp=7&navclear=1" 
			stateId="<%=com.hps.july.dictionary.APPStates.BANKLIST %>"> 
			    <july:menuselection stateId="<%=com.hps.july.dictionary.APPStates.BANKLIST %>"/>
				<july:menuselection stateId="<%=com.hps.july.dictionary.APPStates.EDITBANK %>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.dict.person" action="/dict/ShowPersonList.do?rootapp=7&navclear=1" 
			stateId="<%=com.hps.july.dictionary.APPStates.PERSON_LIST%>"> 
			    <july:menuselection stateId="<%=com.hps.july.dictionary.APPStates.PERSON_LIST%>"/>
			</july:menuitem>
    		<july:menuitem key="label.menu.dict.uf" action="/dict/ShowOrganizationListM.do?rootapp=7&navclear=1"  	stateId="<%=com.hps.july.dictionary.APPStates.ORGLISTM %>"> 
				<july:menuselection stateId="<%=com.hps.july.dictionary.APPStates.ORGLISTM %>"/>
				<july:menuselection stateId="<%=com.hps.july.dictionary.APPStates.EDITORGM %>"/>
				<july:menuselection stateId="<%=com.hps.july.dictionary.APPStates.ACCLIST %>"/>
				<july:menuselection stateId="<%=com.hps.july.dictionary.APPStates.EDITACC %>"/>
				<july:menuselection stateId="<%=com.hps.july.dictionary.APPStates.CARS_LIST %>"/>
				<july:menuselection stateId="<%=com.hps.july.dictionary.APPStates.CAR_EDIT %>"/>
				<july:menuselection stateId="<%=com.hps.july.dictionary.APPStates.ORGWLIST %>"/>
				<july:menuselection stateId="<%=com.hps.july.dictionary.APPStates.EDITORGW %>"/>
			</july:menuitem>

			<july:menuitem key="label.menu.dict.Cur" action="/dict/ShowCurrateList.do?rootapp=7&navclear=1" stateId="<%=com.hps.july.dictionary.APPStates.CRTLIST%>"> 
			    <july:menuselection stateId="<%=com.hps.july.dictionary.APPStates.CRTLIST %>"/>
				<july:menuselection stateId="<%=com.hps.july.dictionary.APPStates.EDITCRT %>"/>
			</july:menuitem>
		</july:menuitem>
		<% } %>

		<% if (isViewerPays || isAdministrator) { %>
		<july:menuitem key="navtitle.ShowNFS_ListDetach" action="/arenda/ShowNFS_ListDetach.do?navclear=1" stateId="<%= APPStates.NFS_LIST_DETACH %>">
			<july:menuselection stateId="<%=APPStates.NFS_LIST_DETACH %>"/>
		</july:menuitem>
		<% } %>

		<% if (isLcs || isAdministrator || isArendaDirector || isArendaManager) { %>
		<july:menuitem key="navtitle.ShowListLicence" action="/arenda/ShowListLicence.do?navclear=1" stateId="<%= APPStates.LIST_LICENCE %>">
			<july:menuselection stateId="<%=APPStates.LIST_LICENCE %>"/>
		</july:menuitem>
		<% } %>

            <%
                if(com.hps.july.util.AppUtils.isMicrostrategyAccess(request.getRemoteUser())) {
                String url = URLUtil.getMicrostrategyURL(request);
            %>
            <july:menuitem key="label.menu.microstrategy.report" action='<%=url%>' stateId="-801" target="1" windowName="Microstrategy">
                <july:menuselection stateId="-801"/>
            </july:menuitem>
            <%
                }
            %>
	</july:menuitem>
</july:menu>

