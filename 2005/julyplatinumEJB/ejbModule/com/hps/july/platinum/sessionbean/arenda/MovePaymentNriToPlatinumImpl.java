package com.hps.july.platinum.sessionbean.arenda;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;

import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.platinum.sessionbean.*;
//import com.hps.july.platinum.sessionbean.arenda.*;
import javax.ejb.*;
/**
 * This is a Session Bean Class
 */
public class MovePaymentNriToPlatinumImpl extends SessionBeanContent {

    private KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    private Integer paramIdPaiment;
    private String paramStateFrom;
    private String paramStateTo;
    private String paramTypeAction;
    private PIEQueryAccessBean query;
    private OperatorAccessBean operator;
    private LogWriter logWriter;

/**
 * Insert the method's description here.
 * Creation date: (06.02.2003 19:40:56)
 */
public MovePaymentNriToPlatinumImpl() {}
/**
 * Insert the method's description here.
 * Creation date: (06.02.2003 19:40:56)
 */
public MovePaymentNriToPlatinumImpl(SessionContext context) {
    super(context);
}
private void initNriQuery() throws Exception {

    try {

        LeasePaymentAccessBean payment = new LeasePaymentAccessBean();
        payment.setInitKey_leaseDocPosition(paramIdPaiment.intValue());
        payment.refreshCopyHelper();

        int idPieQuery = keygen.getNextKey(TablesRef.PIE_QUERY);
        PIEQueryAccessBean bean =
            new PIEQueryAccessBean(
                idPieQuery,
                REQUESTTYPES.A_PAY,
                paramTypeAction,
                STATUSTYPES.PREPARE,
                "1",
                new java.sql.Timestamp(System.currentTimeMillis()));
        bean.commitCopyHelper();

        bean.setTypeobjnri(NRIOBJECTTYPES.PAYMENT);

        bean.setVoper(new Integer(operator.getOperator()));

        bean.setIdobjnriint(paramIdPaiment);
        bean.setOwner(
            new Integer(payment.getLeaseContract().getOrgCustomerKey().organization));
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
 * Creation date: (21.01.2003 12:39:56)
 */
private void insertPIEPay() throws Exception {

    Object[] objs = { paramStateFrom, paramStateTo, paramTypeAction };

    LeasePayOrderAccessBean payOrder = new LeasePayOrderAccessBean();
    payOrder.setInitKey_leaseDocPosition(paramIdPaiment.intValue());
    payOrder.refreshCopyHelper();

    DopInfoLPaymentAccessBean dopInfo = new DopInfoLPaymentAccessBean();
    dopInfo.setInitKey_leasedocposition(paramIdPaiment.intValue());
    dopInfo.refreshCopyHelper();

    int currency = 0;
    if (payOrder.getSumRub() == null) {
	    //test2
        currency = payOrder.getCurrencyKey().currency;
    } else {
	    //test1
        try {
            currency = Util_Alex.receiveIntConstant(SystemConstants.RUR);
        } catch (Exception e) {
            logWriter.addMessage(
                new LogMessage(LogMessages.MES_MovePaimentNriToPlatinum_RUR_Error, objs));

            throw new Exception();
        }

    }

    PIEPayNRIAccessBean piePay =
        new PIEPayNRIAccessBean(keygen.getNextKey(TablesRef.PIE_PAYS_NRI),
    /*int argQuery*/ query.getIdquery(),
    /*String argTypeDogov*/ "A",
    /*int argIdDogovNri*/ payOrder.getLeaseContractKey().leaseDocument,
    /*int argIdAccount*/ payOrder.getOrgAccKey().account,
    /*java.sql.Date argDateCreate*/ payOrder.getDate(),
    /*java.math.BigDecimal argSumPay*/ payOrder.getSumRub() != null
    ? payOrder.getSumRub()
    : payOrder.getSumm(),
    /*java.math.BigDecimal argNdsPay*/ payOrder.getNdsRub() != null
    ? payOrder.getNdsRub()
    : payOrder.getSumnds(),
    /*int argValute*/ currency);

    piePay.commitCopyHelper();

    piePay.setNumberanddatebdoc(dopInfo.getNumberanddatebasedoc());
    piePay.setTypebasedoc(dopInfo.getTypebasedoc());
    piePay.setPurposepay(payOrder.getPayPurpose());
    piePay.setDatebuch(dopInfo.getDatebuch());
    piePay.setDatebeforepay(dopInfo.getDatebeforepay());
    piePay.setIdbudjet(dopInfo.getIdbudjet());
    piePay.setIdexpence(dopInfo.getIdexpence());
    piePay.setIdpaymode(dopInfo.getIdpaymode());
    piePay.setDefinerate(dopInfo.getDefinerate());
    piePay.setIdpaytype(dopInfo.getIdpaytype());
    piePay.setIdtypeforbuch(dopInfo.getIsact().booleanValue()?new Integer(1): new Integer(0));
    piePay.setTiprasxodov(dopInfo.getTyperashod());
    piePay.setIdusernri(new Integer(operator.getManKey().man));

    piePay.commitCopyHelper();

}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 10:47:44)
 */
public void process(
    int operatorId,
    String typeAction,
    Integer idPaiment,
    String stateFrom,
    String stateTo)
    throws Exception {

    Object[] objs = { paramStateFrom, paramStateTo, paramTypeAction };
    LogMessage logMessage = null;
    this.paramIdPaiment = idPaiment;
    this.paramStateFrom = stateFrom;
    this.paramStateTo = stateTo;

    this.paramTypeAction = typeAction;

    if (typeAction == null
        && stateFrom.equals(PaymentState.EDIT_G)
        && stateTo.equals(PaymentState.READY_M)) {

        this.paramTypeAction = OPERATIONTYPES.INSERT;

    } else {
        this.paramTypeAction = typeAction;
    }
    try {
        operator = new OperatorAccessBean();
        operator.setInitKey_operator(operatorId);
        operator.refreshCopyHelper();

        logWriter = new LogWriter();

        //javax.transaction.UserTransaction tr = receiveUserTransaction();

        initNriQuery();

        //tr.begin();

        if (paramTypeAction == OPERATIONTYPES.INSERT
            && paramStateFrom.equals(PaymentState.EDIT_G)
            && paramStateTo.equals(PaymentState.READY_M)) {

            insertPIEPay();
            query.setOperation(OPERATIONTYPES.INSERT);

        } else
            if (paramTypeAction.equals(OPERATIONTYPES.UPDATE)
                && paramStateFrom.equals(PaymentState.READY_M)
                && paramStateTo.equals(PaymentState.READY_M)) {

                insertPIEPay();
                query.setOperation(OPERATIONTYPES.UPDATE);

            } else
                if (paramTypeAction.equals(OPERATIONTYPES.DELETE)
                    && paramStateFrom.equals(PaymentState.READY_M)
                    && paramStateTo.equals(PaymentState.READY_M)) {

                    query.setOperation(OPERATIONTYPES.DELETE);

                } else {
                    logMessage = new LogMessage(LogMessages.MES_PaysNotTransfered, objs);
                    logWriter.addMessage(logMessage);
                    throw new Exception(logMessage.getMessage());
                }

        query.commitCopyHelper();

        //tr.commit();
        logWriter.addMessage(
            new LogMessage(LogMessages.MES_MovePaimentNriToPlatinumSuccess, objs));

    } catch (Exception e) {
        //tr.rollback();
        if (logWriter.getMessages().isEmpty()) {
            logMessage =
                new LogMessage(LogMessages.MES_MovePaimentNriToPlatinumError, objs);
            logWriter.addMessage(logMessage);
            throw new Exception(logMessage.getMessage());
        } else
            throw e;

    } finally {
	    /*
        if (logWriter.getMessages().isEmpty()) {

            logWriter.addMessage(
                new LogMessage(LogMessages.MES_MovePaimentNriToPlatinumSuccess, objs));
        }
        */
        logWriter.log();
    }
}
}
