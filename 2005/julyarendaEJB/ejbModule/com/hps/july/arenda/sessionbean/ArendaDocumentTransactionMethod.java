package com.hps.july.arenda.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ArendaDocumentTransactionMethod extends javax.ejb.EJBObject {

/**
 * 
 * @return java.math.BigDecimal
 * @param resource java.lang.Integer
 * @param localDate java.sql.Date
 * @param localSum java.math.BigDecimal
 * @param typeCalc java.lang.String
 * @exception String The exception description.
 */
java.math.BigDecimal calcNds(java.lang.Integer resource, java.sql.Date localDate, java.math.BigDecimal localSum, java.lang.String typeCalc) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param dateFinish java.sql.Date
 * @param baseContract java.lang.Integer
 * @param codeTask int
 * @exception String The exception description.
 * @exception String The exception description.
 */
void makeAutoChargeOneContract(java.sql.Date dateFinish, java.lang.Integer baseContract, int codeTask) throws java.rmi.RemoteException, java.lang.Exception;
/**
 * 
 * @return void
 * @param dateStart java.sql.Date
 * @param dateFinish java.sql.Date
 * @param baseContract java.lang.Integer
 * @param codeTask int
 * @exception String The exception description.
 * @exception String The exception description.
 */
void makeAutoPaymentOneContract(java.sql.Date dateStart, java.sql.Date dateFinish, java.lang.Integer baseContract, int codeTask) throws java.rmi.RemoteException, java.lang.Exception;
/**
 * 
 * @return void
 * @param docHandle javax.ejb.Handle
 * @param codeTask int
 * @exception String The exception description.
 */
void makeProlongationOneContract(javax.ejb.Handle docHandle, int codeTask) throws java.rmi.RemoteException;
}
