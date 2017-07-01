package com.hps.july.platinum.sessionbean.arenda;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;

import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.platinum.sessionbean.*;
//import com.hps.july.platinum.sessionbean.arenda.*;

/**
 * This is a Session Bean Class
 */
public class MoveDogovorNriToPlatinumImpl extends SessionBeanContent {

    private KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    private Integer paramIdDogovor;
    private String paramStateFrom;
    private String paramStateTo;
    private PIEQueryAccessBean query;
    //private java.sql.Date startDate;
    private int countDogovor;
    private LeaseArendaAgreementNewAccessBean currentDogovor;
    private LeaseArendaAgreementNewAccessBean mainDogovor;
    private OperatorAccessBean operator;
    private LeaseContractBLOBAccessBean currentDogovorBlob;
    private LogWriter logWriter = new LogWriter();
    
/**
 * Insert the method's description here.
 * Creation date: (06.02.2003 18:24:04)
 */
public MoveDogovorNriToPlatinumImpl() {}
/**
 * Insert the method's description here.
 * Creation date: (06.02.2003 18:24:04)
 */
public MoveDogovorNriToPlatinumImpl(SessionContext context) {
   super(context);
}
private void calculateDogovors() throws Exception {

    LeaseArendaAgreementNewAccessBeanTable table =
        new LeaseArendaAgreementNewAccessBeanTable();
    table
        .setLeaseArendaAgreementNewAccessBean(
            new LeaseArendaAgreementNewAccessBean()
            .findByQBE2(
    /*Integer mainLeaseDocument*/ new Integer(mainDogovor.getLeaseDocument()),
    /*Boolean isIsActive*/ Boolean.FALSE,
    /*Boolean isActive*/ Boolean.FALSE,
    /*Boolean isContractState*/ Boolean.TRUE,
    /*String contractState*/ ContractState.RUN_B,
    /*Integer order*/ new Integer(2)));

    countDogovor = table.numberOfRows();

    if (countDogovor == 0) {
        currentDogovor = mainDogovor;
        countDogovor++;
    } else {
        currentDogovor = table.getLeaseArendaAgreementNewAccessBean(0);
        if (mainDogovor.getContractState().equals(ContractState.RUN_B)) {
            countDogovor++;
            if (currentDogovor.getStartDate().before(mainDogovor.getStartDate())) {
                currentDogovor = mainDogovor;
            }
        }

    }

    //startDate = table.getLeaseArendaAgreementNewAccessBean(1).getStartDate();

    currentDogovorBlob = new LeaseContractBLOBAccessBean();
    currentDogovorBlob.setInitKey_leaseDocument(currentDogovor.getLeaseDocument());
    currentDogovorBlob.refreshCopyHelper();
}
    /**
     * Insert the method's description here.
     * Creation date: (16.01.2003 17:02:19)
     */
    private void createDogovorsNri() throws Exception {

        int idAccount = receiveAccountId();
        PIEDopInfoContrAccessBean info = new PIEDopInfoContrAccessBean();
        info.setInitKey_leasedocument(mainDogovor.getLeaseDocument());
        info.refreshCopyHelper();

        PIEDogovorNRIAccessBean pieDogovor =
            new PIEDogovorNRIAccessBean(
                keygen.getNextKey(TablesRef.PIE_DOGOVORS_NRI),
                query.getIdquery(),
        /*int argOrgOwner*/ currentDogovor.getOrgCustomerKey().organization,
        /*int argPartnerNri*/ mainDogovor.getOrgExecutorKey().organization,
        /*int argAccountNri*/ idAccount,
        /*String argDogovorPlatinum,*/ info.getVendor(),
        /*int argIdBudjet,*/ info.getIdbudjet().intValue(),
        /*int argIdExperience,*/ info.getIdexpense().intValue(),
        /*java.sql.Date argDogDate,*/ mainDogovor.getDocumentDate(),
        /*java.sql.Date argDogStartDate,*/ mainDogovor.getStartDate(),
        /*java.sql.Date argDogEndDate,*/ currentDogovor.getEndDate(),
        /*String argDogBlankCode,*/ mainDogovor.getDocumentNumber(),
        /*java.math.BigDecimal argSumDog,*/ currentDogovor.getSumm1(),
        /*int argValute*/ currentDogovor.getCurrency1Key().currency);
        

        pieDogovor.setIdheaduser(new Integer(operator.getManKey().man));
        pieDogovor.setOverprice(currentDogovor.getRatedelta());
        pieDogovor.setPurpose(currentDogovorBlob.getSubject());
        pieDogovor.setDescription(currentDogovorBlob.getComment());
        pieDogovor.commitCopyHelper();
    }
    /**
     * Insert the method's description here.
     * Creation date: (16.01.2003 10:08:14)
     */
    private void initNriQuery() throws Exception {

        try {

            int idPieQuery = keygen.getNextKey(TablesRef.PIE_QUERY);
            PIEQueryAccessBean bean =
                new PIEQueryAccessBean(
                    idPieQuery,
                    REQUESTTYPES.A_DOGOVOR,
                    OPERATIONTYPES.INF,
                    STATUSTYPES.PREPARE,
                    "1",
                    new java.sql.Timestamp(System.currentTimeMillis()));
            //bean.commitCopyHelper();

            bean.setTypeobjnri(NRIOBJECTTYPES.LEASEDOGOV);

            bean.setVoper(new Integer(operator.getOperator()));

            bean.commitCopyHelper();
            query = bean;
            logWriter.setIdQuery(query.getIdquery());

        } catch (Exception e) {
            Util_Alex.pr(e, "makeQueryGetPaymentsFromPlatinum", this);
            throw e;
        }

    }
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 10:47:44)
 */
public void process(
    int paramOperator,
    Integer idDogovor,
    String stateFrom,
    String stateTo)
    throws Exception {

    javax.transaction.UserTransaction tr = receiveUserTransaction();
    LogMessage logMessage = null;
    try {
        logWriter = new LogWriter();

        LeaseArendaAgreementNewAccessBean document = null;

        this.paramIdDogovor = idDogovor;
        this.paramStateFrom = stateFrom;
        this.paramStateTo = stateTo;
        operator = new OperatorAccessBean();
        operator.setInitKey_operator(paramOperator);
        operator.refreshCopyHelper();
        initNriQuery();
        try {
            document = new LeaseArendaAgreementNewAccessBean();
            document.setInitKey_leaseDocument(paramIdDogovor.intValue());
            document.refreshCopyHelper();
        } catch (Exception e) {

            logWriter.addMessage(
                new LogMessage(LogMessages.MES_LeaseArendaArgmntsNotFound));
            throw new Exception(
                new LogMessage(LogMessages.MES_LeaseArendaArgmntsNotFound).getMessage());
        }

        Integer idMainDogovor =
            document.getMainDocument() == null
                ? paramIdDogovor
                : document.getMainDocument();

        mainDogovor = new LeaseArendaAgreementNewAccessBean();
        mainDogovor.setInitKey_leaseDocument(idMainDogovor.intValue());
        mainDogovor.refreshCopyHelper();

        query.setIdobjnriint(idMainDogovor);
        query.commitCopyHelper();
        // bdv
        if (!((paramStateFrom.equals(ContractState.RUN_B)
            || paramStateFrom.equals(ContractState.INPUT_A))
            && (paramStateTo.equals(ContractState.RUN_B)
                || paramStateTo.equals(ContractState.INPUT_A)))) {

            logWriter.addMessage(new LogMessage(LogMessages.MES_NotNecessaryToTransfer));

            return;
        }

        if (Util_Alex.receiveIntConstant(SystemConstants.SYNCNRIPLATINARENDA) == 0) {
            logWriter.addMessage(
                new LogMessage(LogMessages.MES_SynchronizationSwitchedOff));

            //  bdv
            /*
            query.setOwner(new Integer(document.getOrgCustomerKey().organization));
            query.setStatus(REQUEST_STATUS.RESET);
            */

            return;
        }
        calculateDogovors();
        query.setOwner(new Integer(currentDogovor.getOrgCustomerKey().organization));

        query.commitCopyHelper();

        if (paramStateFrom.equals(ContractState.INPUT_A)
            && paramStateTo.equals(ContractState.RUN_B)
            && document.getStartDate().equals(currentDogovor.getStartDate())) {

            if (countDogovor == 1) {
                query.setOperation(OPERATIONTYPES.INSERT);
                query.commitCopyHelper();
            } else
                if (countDogovor > 1) {
                    query.setOperation(OPERATIONTYPES.UPDATE);
                    query.commitCopyHelper();
                }

        } else
            if (paramStateFrom.equals(ContractState.RUN_B)
                && paramStateTo.equals(
                    ContractState.INPUT_A)
                /*&& document.getStartDate().equals(currentDogovor.getStartDate())*/

                ) {

                if (countDogovor == 1) {
                    query.setOperation(OPERATIONTYPES.DELETE);
                    query.commitCopyHelper();
                    logWriter.addMessage(
                        new LogMessage(LogMessages.MES_MoveDogovorNriToPlatinumDelete));
                    return; //test2
                } else
                    if (countDogovor > 0) {
                        query.setOperation(OPERATIONTYPES.UPDATE);
                        query.commitCopyHelper();
                    }
            } else {
                logWriter.addMessage(new LogMessage(LogMessages.MES_OperationNotDefined));

                return;
            }

        try {

            //query.commitCopyHelper();
            //int key = query.getIdquery();
            System.out.println("before transaction begin");
            //tr.begin(); /////transaction
            System.out.println("transaction begin");
            //query=new PIEQueryAccessBean();
            //query.setInitKey_idquery(key);
            //query.refreshCopyHelper(); 
            createDogovorsNri();
            logWriter.addMessage(
                new LogMessage(LogMessages.MES_MoveDogovorNriToPlatinumSuccess));
            //query=new PIEQueryAccessBean(pq);
            //query.setStatus(STATUSTYPES.PREPAREOK);
            //query.commitCopyHelper();
            //pq.setStatus(STATUSTYPES.PREPAREOK);
            //tr.commit(); /////transaction
            System.out.println("transaction commit");
            return;
        } catch (Exception e) {
            e.printStackTrace();
/*
            if (tr.getStatus() != javax.transaction.Status.STATUS_NO_TRANSACTION) {
                tr.rollback(); ////transaction
            }
*/
            /*
            query.setStatus(STATUSTYPES.PREPAREERR);
            query.commitCopyHelper();
            */
            logWriter.addMessage(new LogMessage(LogMessages.MES_CreatePieDogovorsNriError));

            throw e;
        }
    } catch (Exception e) {
        if (logWriter.getMessages().isEmpty()) {
            logMessage = new LogMessage(LogMessages.MES_MoveDogovorNriToPlatinumError);
            logWriter.addMessage(logMessage);
            throw new Exception(logMessage.getMessage() + e.getMessage());
        } else
            throw e;
    } finally {
        if (logWriter.getMessages().isEmpty()) {

            logWriter.addMessage(
                new LogMessage(LogMessages.MES_MoveDogovorNriToPlatinumSuccess));
        }
        logWriter.log();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 10:03:52)
 * @return java.lang.Integer
 */
private int receiveAccountId() {
    int idAccount = 0;
    try {
        try {
            LeasePayRuleAccessBean payRule = new LeasePayRuleAccessBean();
            LeasePayRuleAccessBeanTable table = new LeasePayRuleAccessBeanTable();
            table.setLeasePayRuleAccessBean(
                payRule.findByLeaseDocument(
                    new Integer(currentDogovor.getLeaseDocument()),
                    Boolean.FALSE,
                    new Integer(2)));

            for (int i = 0; i < table.numberOfRows(); i++) {
                payRule = table.getLeasePayRuleAccessBean(i);
                if (payRule.getPayType().equals("P")
                    && payRule.getOrgToPayKey().organization
                        == currentDogovor.getOrgExecutorKey().organization
                    && payRule.getOrgAccKey() != null) {

                    idAccount = payRule.getOrgAccKey().account;
                    return idAccount;
                }

            }
        } catch (Exception e) {
            Util_Alex.pr(e, "createDogovorNri", this);
        }

        AccountAccessBean account = new AccountAccessBean();
        AccountAccessBeanTable table1 = new AccountAccessBeanTable();
        table1.setAccountAccessBean(
            account.findAccountByOrganization(new OrganizationKey(currentDogovor.getOrgExecutorKey().organization)));
        for (int i = 0; i < table1.numberOfRows(); i++) {
            account = table1.getAccountAccessBean(i);
            if (account.getActive().equals(Boolean.TRUE)) {

                idAccount = account.getAccount();
                return idAccount;
            }

        }
        throw new Exception("account not found");
    } catch (Exception e1) {
        try {
            logWriter.addMessage(new LogMessage(LogMessages.MES_AccountNotDefined));
            throw new Exception(
                new LogMessage(LogMessages.MES_AccountNotDefined).getMessage());
        } catch (Exception e2) {
        }
        return 0;
    }
    //return idAccount;
}
}
