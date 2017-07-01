package com.hps.july.platinum.sessionbean.arenda;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.*;
import javax.ejb.*;
/**
 * This is a Session Bean Class
 */

import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.platinum.sessionbean.*;
//import com.hps.july.platinum.sessionbean.arenda.*;

public class MoveBanksPlatinumToNriImpl extends SessionBeanContent {

    private KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();

    private PIEQueryAccessBean query;

    private OperatorAccessBean operator;

    private LogWriter logWriter;
    private String requestStatus = STATUSTYPES.ERROR;
/**
 * Insert the method's description here.
 * Creation date: (08.02.2003 20:37:09)
 */
public MoveBanksPlatinumToNriImpl() {}
/**
 * Insert the method's description here.
 * Creation date: (08.02.2003 20:37:09)
 */
public MoveBanksPlatinumToNriImpl(SessionContext context) {
    super(context);
}
    private void initNriQuery() throws Exception {

        try {

            int idPieQuery = keygen.getNextKey(TablesRef.PIE_QUERY);
            PIEQueryAccessBean bean =
                new PIEQueryAccessBean(
                    idPieQuery,
                    REQUESTTYPES.MOVEBANKS,
                    OPERATIONTYPES.INF,
                    STATUSTYPES.PREPAREERR,
                    "1",
                    new java.sql.Timestamp(System.currentTimeMillis()));
            bean.commitCopyHelper();

            //bean.setTypeobjnri(NRIOBJECTTYPES.LEASEDOGOV);

            bean.setVoper(new Integer(operator.getOperator()));

            bean.commitCopyHelper();
            query = bean;
            logWriter.setIdQuery(query.getIdquery());

        } catch (Exception e) {
            Util_Alex.pr(e, "makeBankPlatinumToNri", this);
            throw e;
        }

    }
    /**
     * Insert the method's description here.
     * Creation date: (20.01.2003 13:31:50)
     */
    private void insertOrg(PIEBankPlatinumAccessBean pieBank) throws Exception {
        OrganizationAccessBean org =
            new OrganizationAccessBean(keygen.getNextKey(TablesRef.ORGANIZATION),
        /*String argName*/ pieBank.getName(),
        /*Boolean argIsSupplier*/ Boolean.FALSE,
        /*Boolean argIsProvider*/ Boolean.FALSE,
        /*Boolean argIsRenter*/ Boolean.FALSE,
        /*Boolean argBank*/ Boolean.TRUE);

        org.setName(pieBank.getName());
        org.setSwift(pieBank.getSwift());
        org.setKoraccount(pieBank.getKorschet());
        org.setLegaladdress(pieBank.getAddress());

        org.commitCopyHelper();

    }
/**
 * Insert the method's description here.
 * Creation date: (20.01.2003 12:32:24)
 * @param org com.hps.july.persistence.OrganizationAccessBean
 */
private void orgHandler(OrganizationAccessBean paramOrg) throws Exception {

    //Object[] objs = { pieBank.getIdbankplatinum(), new Integer(pieBank.getOwner())};
    try {
        PIEBankPlatinumAccessBeanTable table = new PIEBankPlatinumAccessBeanTable();
        PIEBankPlatinumAccessBean pieBank = new PIEBankPlatinumAccessBean();
        OrganizationAccessBean org = new OrganizationAccessBean();
        String bik = "";

        table.setPIEBankPlatinumAccessBean(
            pieBank.findNotWorkedByOwner(new Integer(paramOrg.getOrganization())));

        for (int i = 0; i < table.numberOfRows(); i++) {

            pieBank = table.getPIEBankPlatinumAccessBean(i);

            javax.transaction.UserTransaction tr = receiveUserTransaction();
            try {
                tr.begin(); ///
                pieBankHandler(paramOrg, pieBank);
                tr.commit(); ///
                logWriter.addMessage(
                    new LogMessage(
                        LogMessages.MES_PlatinumBankProcessedOk,
                        paramOrg.getOrganization(),
                        pieBank.getIdbankplatinum()));
            } catch (Exception eb) {
                tr.rollback(); ///
                logWriter.addMessage(
                    new LogMessage(
                        LogMessages.MES_PlatinumBankNotProcessed,
                        paramOrg.getOrganization(),
                        pieBank.getIdbankplatinum()));

            }
        }
    } catch (Exception e) {

        logWriter.addMessage(
            new LogMessage(
                LogMessages.MES_OwnerPlatinumBanksProcessedError,
                paramOrg.getOrganization()));

    }
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2003 12:32:24)
 * @param org com.hps.july.persistence.OrganizationAccessBean
 */
private void pieBankHandler(
    OrganizationAccessBean paramOrg,
    PIEBankPlatinumAccessBean pieBank)
    throws Exception {
    int messageNum = 0;

    LogMessage logMessage = null;
    Object[] objs = { pieBank.getIdbankplatinum(), new Integer(pieBank.getOwner())};

    if (pieBank.getIdbanknri() != null) {
        updateOrg(pieBank, paramOrg);

    } else {

        if (pieBank.getBik() == null) {

            logMessage = new LogMessage(LogMessages.MES_PlatinumBanksHasNoBik, objs);
            logWriter.addMessage(logMessage);
            throw new Exception(); //

        }
        OrganizationAccessBeanTable table = new OrganizationAccessBeanTable();
        table.setOrganizationAccessBean(
            paramOrg.findBanksByQBE(
                Boolean.FALSE,
                null,
                Boolean.TRUE,
                pieBank.getBik(),
                new Integer(1)));

        if (table.numberOfRows() > 1) {
            logMessage =
                new LogMessage(LogMessages.MES_PlatinumBanksWithDuplicatedBik, objs);
            logWriter.addMessage(logMessage);
            throw new Exception(); //
        }
        if (table.numberOfRows() == 1) {
            for (int j = 0; j < table.numberOfRows(); j++) {
                updateOrg(pieBank, table.getOrganizationAccessBean(j));

            }
        } else {

            insertOrg(pieBank);

        }
    }

    pieBank.setFlagworknri("Y");
    pieBank.commitCopyHelper();

    return;

}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 10:47:44)
 */
public void process(int operatorId) throws Exception {

    logWriter = new LogWriter();
    LogMessage logMessage = null;
    operator = new OperatorAccessBean();
    operator.setInitKey_operator(operatorId);
    operator.refreshCopyHelper();
    initNriQuery();

    try {
        //requestStatus = STATUSTYPES.PREPAREOK;

        NamedValueAccessBean nv = new NamedValueAccessBean();
        nv.setInitKey_id(SystemConstants.MAINOWNERBANK);
        nv.refreshCopyHelper();

        OrganizationAccessBeanTable table = new OrganizationAccessBeanTable();
        OrganizationAccessBean organization = new OrganizationAccessBean();
        table.setOrganizationAccessBean(
            new OrganizationAccessBean().findOurOrganizations());

        for (int i = 0; i < table.numberOfRows(); i++) {
            organization = table.getOrganizationAccessBean(i);
            if (organization.getOrganization() != nv.getIntvalue()) {

                orgHandler(organization);

            }
        }

        OrganizationAccessBean mainOwnerBank = new OrganizationAccessBean();
        mainOwnerBank.setInitKey_organization(nv.getIntvalue());
        mainOwnerBank.refreshCopyHelper();
        orgHandler(mainOwnerBank);
    } catch (Exception e) {

        logMessage = new LogMessage(LogMessages.MES_PlatinumBanksProccessedError);
        logWriter.addMessage(logMessage);
        throw new Exception(logMessage.getMessage() + e);

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
    /**
     * Insert the method's description here.
     * Creation date: (20.01.2003 13:31:50)
     */
    private void updateOrg(
        PIEBankPlatinumAccessBean pieBank,
        OrganizationAccessBean org)
        throws Exception {

        org.setName(pieBank.getName());
        org.setSwift(pieBank.getSwift());
        org.setKoraccount(pieBank.getKorschet());
        org.setLegaladdress(pieBank.getAddress());

        org.commitCopyHelper();
    }
}
