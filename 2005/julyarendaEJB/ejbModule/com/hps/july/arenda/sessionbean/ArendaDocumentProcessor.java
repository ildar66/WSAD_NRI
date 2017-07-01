package com.hps.july.arenda.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ArendaDocumentProcessor extends javax.ejb.EJBObject {

/**
 * 
 * @return java.lang.Object []
 * @param type int
 * @param actcode int
 * @exception String The exception description.
 */
java.lang.Object [] delShfOnAkt(int type, int actcode) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @param reglamentcode int
 * @exception String The exception description.
 */
java.lang.String getActNumber(int reglamentcode) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param organization int
 * @exception String The exception description.
 */
int getDefaultBudjet(int organization) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param organization int
 * @exception String The exception description.
 */
int getDefaultExpence(int organization) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param dateFinish java.sql.Date
 * @param economist java.lang.Integer
 * @param contract java.lang.Integer
 * @param operator java.lang.Integer
 * @exception String The exception description.
 */
int makeAutomaticCharges(java.sql.Date dateFinish, java.lang.Integer economist, java.lang.Integer contract, java.lang.Integer operator) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param dateStart java.sql.Date
 * @param dateFinish java.sql.Date
 * @param economist java.lang.Integer
 * @param contract java.lang.Integer
 * @param operator java.lang.Integer
 * @exception String The exception description.
 */
int makeAutomaticPayments(java.sql.Date dateStart, java.sql.Date dateFinish, java.lang.Integer economist, java.lang.Integer contract, java.lang.Integer operator) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param actCode int
 * @param operator int
 * @exception String The exception description.
 */
int makeCalcForReport(int actCode, int operator) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param operator int
 * @param contract java.lang.Integer
 * @param payment java.lang.Integer
 * @param dstart java.sql.Date
 * @param dfinish java.sql.Date
 * @exception String The exception description.
 */
int makeQryGetPays(int operator, java.lang.Integer contract, java.lang.Integer payment, java.sql.Date dstart, java.sql.Date dfinish) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Object []
 * @param type int
 * @param actcode int
 * @param rule int
 * @exception String The exception description.
 */
java.lang.Object [] makeSchfOnAkt(int type, int actcode, int rule) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param contractcode int
 * @exception String The exception description.
 */
int moveBanToBilling(int contractcode) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Object []
 * @param leaseDocument int
 * @param stateFrom java.lang.String
 * @param stateTo java.lang.String
 * @exception String The exception description.
 */
java.lang.Object [] moveContractToPie(int leaseDocument, java.lang.String stateFrom, java.lang.String stateTo) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Object []
 * @param leaseDocPosition int
 * @param stateFrom java.lang.String
 * @param stateTo java.lang.String
 * @exception String The exception description.
 */
java.lang.Object [] movePayToPie(int leaseDocPosition, java.lang.String stateFrom, java.lang.String stateTo) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Object []
 * @param chargecode int
 * @exception String The exception description.
 */
java.lang.Object [] prepareShetFact(int chargecode) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Object []
 * @param chargecode int
 * @param argCurrency java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Object [] prepareShetFact(int chargecode, java.lang.Integer argCurrency) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param dateStart java.sql.Date
 * @param dateFinish java.sql.Date
 * @param economist java.lang.Integer
 * @param contract java.lang.Integer
 * @param operator java.lang.Integer
 * @exception String The exception description.
 */
int prolongLeaseArendaAgreement(java.sql.Date dateStart, java.sql.Date dateFinish, java.lang.Integer economist, java.lang.Integer contract, java.lang.Integer operator) throws java.rmi.RemoteException;
}
