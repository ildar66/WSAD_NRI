package com.hps.july.platinum.sessionbean.arenda;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.*;
import javax.ejb.*;
import com.hps.july.platinum.sessionbean.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.platinum.sessionbean.arenda.*;
/**
 * This is a Session Bean Class
 */
public class MoveAllPaymentsPlatinum2NriImpl extends SessionBeanContent  {

    private KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    private OperatorAccessBean operator;
    private LogWriter logWriter;
    private PIEQueryAccessBean query;
    private Integer locDocPositionNri;
    
/**
 * Insert the method's description here.
 * Creation date: (06.02.2003 18:19:32)
 */
public MoveAllPaymentsPlatinum2NriImpl() {}
/**
 * Insert the method's description here.
 * Creation date: (06.02.2003 18:19:32)
 */
public MoveAllPaymentsPlatinum2NriImpl(SessionContext context) {
	
	super(context);
	}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2003 15:49:55)
 */
private void changeCharge(
    LeaseCharges charge,
    String paramPosVid,
    Integer paramResource,
    SummBean summBean)
    throws Exception {

    //javax.transaction.UserTransaction tr = getSessionContext().getUserTransaction();

    try {
        CurrencyAccessBean currency = new CurrencyAccessBean();
        currency.setInitKey_currency(summBean.valuta);
        currency.refreshCopyHelper();

        charge.setSumm(summBean.summ);
        charge.setCurrency((Currency) currency.getEJBRef());
        charge.setSumnds(summBean.summNds);

        charge.setRemaindersum(summBean.summ);
        charge.setRemainderrate2rur(
            summBean.summRub.divide(summBean.summ, 2, java.math.BigDecimal.ROUND_HALF_UP));
        charge.setByhandraterur(Boolean.FALSE);

    } catch (Exception e) {
        logWriter.addMessage(
            new LogMessage(LogMessages.MES_ChargeNotChanged, charge.getLeaseDocPosition()));
        throw e;

    }
}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2003 15:49:55)
 */
private void changePayment(
    LeasePayment payment,
    String paramPosVid,
    Integer paramResource,
    SummBean summBean)
    throws Exception {

    try {
        CurrencyAccessBean currency = new CurrencyAccessBean();
        currency.setInitKey_currency(summBean.valuta);
        currency.refreshCopyHelper();

        payment.setDate(payment.getDate());
        payment.setSumm(summBean.summ);
        payment.setCurrency((Currency) currency.getEJBRef());
        payment.setSumnds(summBean.summNds);

        payment.setSumRub(summBean.summRub);
        payment.setNdsRub(summBean.summNdsRub);
        payment.setRurremainder(summBean.summRub);
        payment.setPayrate(
            summBean.summRub.divide(summBean.summ, 2, java.math.BigDecimal.ROUND_HALF_UP));
        //payment.setPaymentstate("N"); //if?????

    } catch (Exception e) {
        logWriter.addMessage(
            new LogMessage(
                LogMessages.MES_PaymentNotChanged,
                payment.getLeaseDocPosition()));
        throw e;

    }
}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2003 15:49:55)
 */
private void createCharge(
    PIEPayPlatinumAccessBean piePay,
    String paramPosVid,
    Integer paramResource,
    SummBean summBean)
    throws Exception {



    try {
        

        LeaseChargesAccessBean charge = new LeaseChargesAccessBean(
        /*int argLeaseDocPosition*/ keygen.getNextKey(TablesRef.LEASEDOCPOSITION),
        /*java.sql.Date argDate*/ piePay.getDate(),
        /*Integer argLeaseContract*/ new Integer(piePay.getIddogovornri()),
        /*String argSource*/ "P",
        /*String argVid*/ paramPosVid,
        /*java.sql.Date argSDate*/ piePay.getDate(),
        /*java.sql.Date argEDate*/ piePay.getDate(),
        /*Integer argResource*/ paramResource,
        /*java.math.BigDecimal argSumm*/ summBean.summ,
        /*Integer argCurrency*/ new Integer(piePay.getValute()),
        /*java.math.BigDecimal argSumNds*/ summBean.summNds,
        /*java.math.BigDecimal argRemainderSum*/ summBean.summ,
        /*Boolean argByHandRateRur*/ Boolean.FALSE);

        charge.setRemainderrate2rur(
            summBean.summRub.divide(summBean.summ, 2, java.math.BigDecimal.ROUND_HALF_UP));
        charge.commitCopyHelper();

        PIEPayLinkAccessBean link =
            new PIEPayLinkAccessBean(
                ((PIEPayPlatinumKey) piePay.__getKey()).idpayplatinum,
                charge.getLeaseDocPosition(),
                "Y");
        link.commitCopyHelper();
        
    } catch (Exception e) {
        
        logWriter.addMessage(
            new LogMessage(
                LogMessages.MES_PaymentNotCreated,
                ((PIEPayPlatinumKey) piePay.__getKey()).idpayplatinum));
        throw e;

    }
}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2003 15:49:55)
 */
private void createPayment(
    PIEPayPlatinumAccessBean piePay,
    String paramPosVid,
    Integer paramResource,
    SummBean summBean)
    throws Exception {

    String piePayId = ((PIEPayPlatinumKey) piePay.__getKey()).idpayplatinum;


    try {



        LeasePaymentAccessBean payment = new LeasePaymentAccessBean(
        /*int argLeaseDocPosition,*/ keygen.getNextKey(TablesRef.LEASEDOCPOSITION),
        /*java.sql.Date argDate,*/ piePay.getDate(),
        /*Integer argLeaseContract,*/ new Integer(piePay.getIddogovornri()),
        /*String argSource,*/ "P",
        /*String argVid,*/ paramPosVid,
        /*java.sql.Date argSDate,*/ piePay.getDate(),
        /*java.sql.Date argEDate,*/ piePay.getDate(),
        /*Integer argResource,*/ paramResource,
        /*java.math.BigDecimal argSumm,*/ summBean.summ,
        /*Integer argCurrency,*/ new Integer(piePay.getValute()),
        /*java.math.BigDecimal argSumNds*/ summBean.summNds,
        /*String argPaymentType*/ "P",
        /*String argPaymentState*/ STATUSTYPES.PREPARE);

        payment.commitCopyHelper();

        payment.setDocNumber(piePay.getDocnumber());
        payment.setSumRub(summBean.summRub);
        payment.setNdsRub(summBean.summNdsRub);
        payment.setPayrate(
            summBean.summRub.divide(summBean.summ, 2, java.math.BigDecimal.ROUND_HALF_UP));

        payment.commitCopyHelper();

        DopInfoLPaymentAccessBean dopInfo =
            new DopInfoLPaymentAccessBean(keygen.getNextKey(TablesRef.DOPINFOLPAYMENTS));
        dopInfo.commitCopyHelper();
        //dopInfo.setPaystateplatinum(piePay.getPaystateplatinum()); ??? 
        dopInfo.setNumpayplatinum(piePay.getDocnumber());
        dopInfo.commitCopyHelper();

        PIEPayLinkAccessBean link =
            new PIEPayLinkAccessBean(piePayId, payment.getLeaseDocPosition(), "Y");
        link.commitCopyHelper();



    } catch (Exception e) {

        logWriter.addMessage(
            new LogMessage(LogMessages.MES_PaymentNotCreated, piePayId));
        throw e;

        
    }
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 20:19:06)
 */
private void deleteDocPositionsByDate(
    PIEPayPlatinumAccessBean piePay,
    java.sql.Date dateSaldo)
    throws Exception {

    PIEPayPlatinumKey piePayKey =
        (PIEPayPlatinumKey) piePay.getEJBRef().getPrimaryKey();
    PIEPayLinkAccessBeanTable table = new PIEPayLinkAccessBeanTable();
    PIEPayLinkKey payLinkKey = null;

    table.setPIEPayLinkAccessBean(
        new PIEPayLinkAccessBean().findPIEPayLinksByPiepayplatinum(
            (PIEPayPlatinumKey) piePay.getEJBRef().getPrimaryKey()));

    for (int i = 0; i < table.numberOfRows(); i++) {

        payLinkKey = (PIEPayLinkKey) table.getPIEPayLinkAccessBean(i).__getKey();

        LeaseDocPositionAccessBean docPosition = new LeaseDocPositionAccessBean();
        docPosition.setInitKey_leaseDocPosition(payLinkKey.docposition);
        docPosition.refreshCopyHelper();

        if (docPosition.getDate().after(dateSaldo)) {
            try {
                if (!hasLinkInDnop(docPosition.getLeaseDocPosition())) {
                    findLeaseDocPosition(payLinkKey.docposition).remove();
                    table.getPIEPayLinkAccessBean(i).getEJBRef().remove(); //???????
                } else {
                    logWriter.addMessage(
                        new LogMessage(
                            LogMessages.MES_ExistRecordsInDnopError,
                            piePayKey.idpayplatinum));
                    throw new Exception();

                }
            } catch (Exception e) {
                logWriter.addMessage(
                    new LogMessage(
                        LogMessages.MES_DocpositionNotDeleted,
                        new Object[] { new Integer(payLinkKey.docposition), piePayKey.idpayplatinum }));
                throw e;

                
            }

        }

    }

}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 20:19:06)
 */
private void deleteLinkDocPositionsWithoutMainFlag(PIEPayPlatinumAccessBean piePay)
    throws Exception {
    LogMessage logMessage = null;
    PIEPayPlatinumKey piePayKey =
        (PIEPayPlatinumKey) piePay.getEJBRef().getPrimaryKey();
    PIEPayLinkAccessBeanTable table = new PIEPayLinkAccessBeanTable();
    PIEPayLinkKey payLinkKey = null;

    table.setPIEPayLinkAccessBean(
        new PIEPayLinkAccessBean().findPIEPayLinksByPiepayplatinum(piePayKey));

    for (int i = 0; i < table.numberOfRows(); i++) {
        //if (table.getPIEPayLinkAccessBean(i).getFlagmain().equals("N")) {
            payLinkKey = (PIEPayLinkKey) table.getPIEPayLinkAccessBean(i).__getKey();
            if (!hasLinkInDnop(payLinkKey.docposition)) {
                try {
                    findLeaseDocPosition(payLinkKey.docposition).remove();
                    table.getPIEPayLinkAccessBean(i).getEJBRef().remove(); //???????
                } catch (Exception e) {
                    logWriter.addMessage(
                        new LogMessage(
                            LogMessages.MES_DocpositionNotDeleted,
                            new Object[] { new Integer(payLinkKey.docposition), piePayKey.idpayplatinum }));
                    throw e;

                }
            } else {
                logMessage =
                    new LogMessage(
                        LogMessages.MES_ExistRecordsInDnopError,
                        piePayKey.idpayplatinum);
                logWriter.addMessage(logMessage);
                throw new Exception(logMessage.getMessage());

            }

        //}
    }

}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 20:19:06)
 */
private LeaseDocPosition findLeaseDocPosition(int idDocPosition)
    throws Exception {

    LeasePaymentAccessBean payment = null;
    LeaseChargesAccessBean charge = null;

    try {
        payment = new LeasePaymentAccessBean();
        payment.setInitKey_leaseDocPosition(idDocPosition);
        payment.refreshCopyHelper();
        return (LeaseDocPosition)payment.getEJBRef();
    } catch (Exception e) {
        charge = new LeaseChargesAccessBean();
        charge.setInitKey_leaseDocPosition(idDocPosition);
        charge.refreshCopyHelper();
        return (LeaseDocPosition)charge.getEJBRef();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 14:08:40)
 * @return boolean
 * @param idDocPosition int
 */
private boolean hasLinkInDnop(int idDocPosition) throws Exception {
  // true -  exist records in dnop
    LeaseDocPositionKey key = new LeaseDocPositionKey(idDocPosition);

    return !(!new LeaseDNOPAccessBean()
        .findLeaseDNOPByLeaseCharge(key)
        .hasMoreElements()
        && !new LeaseDNOPAccessBean()
            .findLeaseDNOPPayByLeasePayment(key)
            .hasMoreElements());
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
                    REQUESTTYPES.GETPAYS,
                    OPERATIONTYPES.INF,
                    STATUSTYPES.PREPARE,
                    "1",
                    new java.sql.Timestamp(System.currentTimeMillis()));
            bean.commitCopyHelper();

            bean.setTypeobjnri(NRIOBJECTTYPES.PAYMENT);//??

            bean.setVoper(new Integer(operator.getOperator()));

            bean.commitCopyHelper();
            query = bean;
            logWriter.setIdQuery(query.getIdquery());

        } catch (Exception e) {
            Util_Alex.pr(e, "initNriQuery", this);
            throw e;
        }

    }
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 12:13:37)
 * @param piePay com.hps.july.persistence.PIEPayPlatinumAccessBean
 */
private void moveOnePaymentsPlatinum2Nri(PIEPayPlatinumAccessBean piePay)
    throws Exception {

    PIEPayPlatinumKey piePayKey =
        (PIEPayPlatinumKey) piePay.getEJBRef().getPrimaryKey();
    try {
        LeaseDocPosition linkDocPosition = receiveLinkDocPosition(piePay);
        boolean hasMainNriPayment = linkDocPosition != null;
        Integer resource = null;

        if (!hasMainNriPayment) {
            resource = receiveResource(piePay);
        } else
            resource = new Integer(linkDocPosition.getResourceKey().resource);

        java.sql.Date dateSaldo = receiveDateSaldo(piePay, resource);
        ////////
        if (piePay.getDate().after(dateSaldo)) {

            if (!hasMainNriPayment) {

                if (piePay.getSumm().intValue() > 0) {
                    createPayment(piePay, "N", resource, SummBean.getInstance(piePay));

                } else
                    if (piePay.getSumm().intValue() < 0) {
                        createCharge(piePay, "N", resource, SummBean.getInstance(piePay));
                    } else {
                        logWriter.addMessage(
                            new LogMessage(LogMessages.MES_PaymentSumZero, piePayKey.idpayplatinum));

                        return;
                    }

            } else {

                deleteLinkDocPositionsWithoutMainFlag(piePay);

                if (linkDocPosition instanceof LeasePayment) {
                    changePayment(
                        (LeasePayment) linkDocPosition,
                        "N",
                        resource,
                        SummBean.getInstance(piePay));
                } else {
                    changeCharge(
                        (LeaseCharges) linkDocPosition,
                        "N",
                        resource,
                        SummBean.getInstance(piePay));
                }
            }
        } else {

            if (!hasMainNriPayment) {

                deleteDocPositionsByDate(piePay, dateSaldo);
                SummBean sumAsIs = receiveLinkDocPositionSumm(piePay);
                SummBean sumToBe = SummBean.getInstance(piePay);
                SummBean delta = sumToBe.min(sumAsIs);

                if (sumToBe.summ.compareTo(sumAsIs.summ) < 0) {
                    createCharge(piePay, "C", resource, delta.negate());
                } else
                    if (sumToBe.summ.compareTo(sumAsIs.summ) > 0) {
                        createPayment(piePay, "C", resource, delta);
                    } else
                        return;
            } else {

                if (piePay
                    .getSumm()
                    .compareTo(new java.math.BigDecimal(java.math.BigInteger.valueOf(0), 2))
                    > 0)
                    createPayment(piePay, "C", resource, SummBean.getInstance(piePay));
                else
                    if (piePay
                        .getSumm()
                        .compareTo(new java.math.BigDecimal(java.math.BigInteger.valueOf(0), 2))
                        < 0)
                        createCharge(piePay, "C", resource, SummBean.getInstance(piePay));
                    else
                        return;
            }
        }

    } catch (Exception e) {
        //logWriter.log(LogMessages.MES_UnknownPayPlatinumProcessingError,piePayKey.idpayplatinum);
        logWriter.addMessage(
            new LogMessage(
                LogMessages.MES_UnknownPayPlatinumProcessingError,
                piePayKey.idpayplatinum));
        throw e;

    }
}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 11:41:45)
 */
public void process(int paramOperator) throws Exception {
    javax.transaction.UserTransaction tr = receiveUserTransaction();

    logWriter = new LogWriter();

    operator = new OperatorAccessBean();
    operator.setInitKey_operator(paramOperator);
    operator.refreshCopyHelper();

    initNriQuery();
    String status = STATUSTYPES.PREPARE;

    PIEPayPlatinumAccessBeanTable table = new PIEPayPlatinumAccessBeanTable();
    table.setPIEPayPlatinumAccessBean(
        new PIEPayPlatinumAccessBean().findByQBE(
            Boolean.FALSE,
            null,
            Boolean.FALSE,
            null,
            Boolean.FALSE,
            null,
            Boolean.TRUE,
            "N",
            new Integer(1)));

    for (int i = 0; i < table.numberOfRows(); i++) {

        try {
            tr.begin(); //
            moveOnePaymentsPlatinum2Nri(table.getPIEPayPlatinumAccessBean(i));
            tr.commit(); //
        } catch (Exception e) {
            tr.rollback(); //
            status = STATUSTYPES.PREPAREERR;
        }
    }
    if (!status.equals(STATUSTYPES.PREPAREERR))
        status = STATUSTYPES.PREPAREOK;

    query.setStatus(status);
    query.commitCopyHelper();
}
private LeaseArendaAgreementNewAccessBean receiveCurrentDogovor(PIEPayPlatinumAccessBean piePay)
    throws Exception {
    LeaseArendaAgreementNewAccessBean document = null;
    LeaseArendaAgreementNewAccessBeanTable table =
        new LeaseArendaAgreementNewAccessBeanTable();
    table.setLeaseArendaAgreementNewAccessBean(
        document.findByQBE2(
            new Integer(piePay.getIddogovornri()),
            Boolean.FALSE,
            null,
            Boolean.TRUE,
            ContractState.RUN_B,
            new Integer(2)));
    
	     return table.getLeaseArendaAgreementNewAccessBean(1);   
       

    

}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:43:35)
 * @return com.hps.july.persistence.LeaseSaldoAccessBean
 */
private java.sql.Date receiveDateSaldo(
    PIEPayPlatinumAccessBean piePay,
    Integer resource)
    throws Exception {

    LeaseSaldoAccessBeanTable table = new LeaseSaldoAccessBeanTable();
    table.setLeaseSaldoAccessBean(
        new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(
            new Integer(piePay.getIddogovornri()),
            resource));

    for (int i = 0; i < table.numberOfRows(); i++) {
        if (!table.getLeaseSaldoAccessBean(i).getIstemp().booleanValue()) {
            return table.getLeaseSaldoAccessBean(i).getSalDate();
        }
    }

    try {
        return new java.sql.Date(
            Util_Alex
                .receiveTimeDateConstant(SystemConstants.Arenda_Min_Date /*??*/)
                .getTime());
    } catch (Exception e) {
        logWriter.addMessage(
            new LogMessage(
                LogMessages.MES_ConstantNotFoundError,
                SystemConstants.ArendaResSubArenda));
        throw e;

    }

}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 12:22:39)
 */
private LeaseDocPosition receiveLinkDocPosition(PIEPayPlatinumAccessBean piePay)
    throws Exception {
    LogMessage logMessage = null;
    LeaseDocPosition docPosition = null;
    Object[] args=null;
    PIEPayPlatinumKey piePayKey =
        (PIEPayPlatinumKey) piePay.getEJBRef().getPrimaryKey();

    PIEPayLinkAccessBeanTable table = new PIEPayLinkAccessBeanTable();
    boolean isError = false;
    PIEPayLinkKey payLinkKey = null;

    table.setPIEPayLinkAccessBean(
        new PIEPayLinkAccessBean().findPIEPayLinksByPiepayplatinum(piePayKey));
    for (int i = 0; i < table.numberOfRows(); i++) {

        payLinkKey =
            (PIEPayLinkKey) table.getPIEPayLinkAccessBean(i).getEJBRef().getPrimaryKey();

        args =
            new Object[] {
                payLinkKey.piepayplatinum_idpayplatinum,
                new Integer(payLinkKey.docposition)};

        /*   Need to be rewrited - flagmain removed
        
        if (table.getPIEPayLinkAccessBean(i).getFlagmain().equals("Y")) {
            if (docPosition != null) {
                logMessage = new LogMessage(LogMessages.MES_PaysLinksWithFewFlagMain, args);
                logWriter.addMessage(logMessage);

                throw new Exception(logMessage.getMessage());
            }
            docPosition = findLeaseDocPosition(payLinkKey.docposition);

        }

        */ 
    }
    if (docPosition == null && table.numberOfRows() > 0) {

        logMessage = new LogMessage(LogMessages.MES_PaysLinkWithoutFlagMain, args);
        logWriter.addMessage(logMessage);

        throw new Exception(logMessage.getMessage());

    }
    return docPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 20:19:06)
 */
private SummBean receiveLinkDocPositionSumm(PIEPayPlatinumAccessBean piePay)
    throws Exception {

    SummBean summBean = new SummBean();
    LeasePayment payment = null;
    LeaseCharges charge = null;
    LeaseDocPosition docPosition = null;

    PIEPayPlatinumKey piePayKey =
        (PIEPayPlatinumKey) piePay.getEJBRef().getPrimaryKey();

    try {

        PIEPayLinkAccessBeanTable table = new PIEPayLinkAccessBeanTable();
        PIEPayLinkKey payLinkKey = null;

        table.setPIEPayLinkAccessBean(
            new PIEPayLinkAccessBean().findPIEPayLinksByPiepayplatinum(piePayKey));

        for (int i = 0; i < table.numberOfRows(); i++) {
            payLinkKey =
                (PIEPayLinkKey) table.getPIEPayLinkAccessBean(i).getEJBRef().getPrimaryKey();
            docPosition = findLeaseDocPosition(payLinkKey.docposition);
            summBean.add(SummBean.getInstance(docPosition));

        }
        return summBean;
    } catch (Exception e) {
        if (e
            .getMessage()
            .equals(LogMessages.MES_CurrencyErrorInLinkDocPositions.getText())) {
            logWriter.addMessage(
                new LogMessage(
                    LogMessages.MES_CurrencyErrorInLinkDocPositions,
                    piePayKey.idpayplatinum));
        } else {
            logWriter.addMessage(
                new LogMessage(LogMessages.MES_CalculateSummError, piePayKey.idpayplatinum));
        }
        throw e;

    }
    
}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 12:22:39)
 */
private Integer receiveResource(PIEPayPlatinumAccessBean piePay)
    throws Exception {
    LogMessage logMessage = null;
        //Integer res=null;
    PIEPayLinkAccessBeanTable table = new PIEPayLinkAccessBeanTable();
    boolean isError = false;
    PIEPayLinkKey key = null;

    LeaseArendaAgreementNewAccessBean agr = new LeaseArendaAgreementNewAccessBean();
    agr.setInitKey_leaseDocument(piePay.getIddogovornri());
    agr.refreshCopyHelper();

    if (agr.getContractType().equals("A")) {

        LeaseArendaAgreementNewAccessBean currentDogovor =
            receiveCurrentDogovor(piePay);

        LeaseChargeRuleAccessBeanTable chargeRuleTable =
            new LeaseChargeRuleAccessBeanTable();
        chargeRuleTable.setLeaseChargeRuleAccessBean(
            new LeaseChargeRuleAccessBean().findByLeaseDocument(
                new Integer(currentDogovor.getLeaseDocument()),
                new Integer(1)));

        if (chargeRuleTable.numberOfRows() == 0)
            return new Integer(
                Util_Alex.receiveIntConstant(SystemConstants.ArendaResArenda /*???*/));
        else
            if (chargeRuleTable.numberOfRows() == 1)
                return new Integer(
                    chargeRuleTable.getLeaseChargeRuleAccessBean(1).getResourceKey().resource);
            else
                if (chargeRuleTable.numberOfRows() > 1) {
                    logWriter.addMessage(
                        new LogMessage(LogMessages.MES_FewPayRules, currentDogovor.getLeaseDocument()));

                    return new Integer(
                        chargeRuleTable.getLeaseChargeRuleAccessBean(1).getResourceKey().resource);
                }
    } else
        if (agr.getContractType().equals("B")) {
            try {
                return new Integer(
                    Util_Alex.receiveIntConstant(SystemConstants.ArendaResSubArenda /*??*/));
            } catch (Exception e) {
                logMessage =
                    new LogMessage(
                        LogMessages.MES_ConstantNotFoundError,
                        SystemConstants.ArendaResSubArenda);
                logWriter.addMessage(logMessage);
                throw new Exception(logMessage.getMessage()+e);

            }
        } else
            if (agr.getContractType().equals("D")) {
                try {
                    return new Integer(
                        Util_Alex.receiveIntConstant(SystemConstants.ArendaResChanel /*??*/));
                } catch (Exception e) {
                    logWriter.addMessage(
                        new LogMessage(
                            LogMessages.MES_ConstantNotFoundError,
                            SystemConstants.ArendaResChanel));
                    throw e;

                }
            } else {

                throw new Exception("illegal ContractType");

            }
    return null;
}
}
