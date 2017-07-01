package com.hps.july.platinum.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ArendaPlatinumProcessor extends javax.ejb.EJBObject {

/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean isProcessingEnabled() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param operator int
 * @param bank java.lang.Integer
 * @exception String The exception description.
 */
int makeQryGetBanks(int operator, java.lang.Integer bank) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param operator int
 * @param contract java.lang.Integer
 * @param payment java.lang.Integer
 * @param payDateStart java.sql.Date
 * @param payDateFinish java.sql.Date
 * @exception String The exception description.
 */
int makeQryGetPays(int operator, java.lang.Integer contract, java.lang.Integer payment, java.sql.Date payDateStart, java.sql.Date payDateFinish) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param operator int
 * @exception String The exception description.
 */
int makeQryGetSprArenda(int operator) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param paramIdBank java.lang.Integer
 * @param operator java.lang.Integer
 * @exception String The exception description.
 */
void makeQueryGetBanks(java.lang.Integer paramIdBank, java.lang.Integer operator) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param paramDateStart java.sql.Timestamp
 * @param paramIdDogovor java.lang.Integer
 * @param operator java.lang.Integer
 * @exception String The exception description.
 */
void makeQueryGetPaymentsFromPlatinum(java.sql.Timestamp paramDateStart, java.lang.Integer paramIdDogovor, java.lang.Integer operator) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param operator java.lang.Integer
 * @exception String The exception description.
 */
void makeQueryGetSimpleSprav(java.lang.Integer operator) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param paramTypeAction java.lang.String
 * @param paramAccount java.lang.Integer
 * @param operator java.lang.Integer
 * @exception String The exception description.
 */
void makeQueryMoveAccountInPlatinum(java.lang.String paramTypeAction, java.lang.Integer paramAccount, java.lang.Integer operator) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param paramTypeAction java.lang.String
 * @param paramPartner java.lang.Integer
 * @param operator java.lang.Integer
 * @exception String The exception description.
 */
void makeQueryMovePartnerInPlatinum(java.lang.String paramTypeAction, java.lang.Integer paramPartner, java.lang.Integer operator) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param paramOperator int
 * @exception String The exception description.
 * @exception String The exception description.
 */
void moveAllPaymentsPlatinum2Nri(int paramOperator) throws java.rmi.RemoteException, java.lang.Exception;
/**
 * 
 * @return void
 * @param operatorId int
 * @exception String The exception description.
 * @exception String The exception description.
 */
void moveBanksPlatinumToNri(int operatorId) throws java.rmi.RemoteException, java.lang.Exception;
/**
 * 
 * @return void
 * @param paramOperator int
 * @param idDogovor java.lang.Integer
 * @param stateFrom java.lang.String
 * @param stateTo java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 */
void moveDogovorNriToPlatinum(int paramOperator, java.lang.Integer idDogovor, java.lang.String stateFrom, java.lang.String stateTo) throws javax.naming.NamingException, javax.ejb.CreateException, java.rmi.RemoteException, java.lang.Exception;
/**
 * 
 * @return void
 * @param operatorId int
 * @param typeAction java.lang.String
 * @param idPaiment java.lang.Integer
 * @param stateFrom java.lang.String
 * @param stateTo java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
void movePaymentNriToPlatinum(int operatorId, java.lang.String typeAction, java.lang.Integer idPaiment, java.lang.String stateFrom, java.lang.String stateTo) throws java.rmi.RemoteException, java.lang.Exception;
/**
 * 
 * @return void
 * @param i int
 * @exception String The exception description.
 */
void test(int i) throws java.rmi.RemoteException;
}
