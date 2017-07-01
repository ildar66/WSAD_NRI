package com.hps.july.inventory.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface InWayBillProcessor extends javax.ejb.EJBObject {

/**
 * 
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param argDocument java.lang.Integer
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.DocumentProcessingException applyDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.inventory.sessionbean.CurrencySumProcessingError
 * @param argDocPosition java.lang.Integer
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.CurrencySumProcessingError calcPrice(java.lang.Integer argDocPosition) throws java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param argDocument java.lang.Integer
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.DocumentProcessingException cancelDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argOuterDocPosition java.lang.Integer
 * @param argNewPrice java.math.BigDecimal
 * @exception String The exception description.
 */
void changeOuterDocPositionPrice(java.lang.Integer argOuterDocPosition, java.math.BigDecimal argNewPrice) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argOuterDocPosition java.lang.Integer
 * @exception String The exception description.
 */
void dropOuterDocPosition(java.lang.Integer argOuterDocPosition) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argDocPosition java.lang.Integer
 * @param newSerial java.lang.String
 * @param newManucode java.lang.String
 * @exception String The exception description.
 */
void setSerial(java.lang.Integer argDocPosition, java.lang.String newSerial, java.lang.String newManucode) throws java.rmi.RemoteException;
}
