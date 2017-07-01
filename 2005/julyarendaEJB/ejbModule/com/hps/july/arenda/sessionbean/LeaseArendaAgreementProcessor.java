package com.hps.july.arenda.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseArendaAgreementProcessor extends javax.ejb.EJBObject {

/**
 * 
 * @return void
 * @param mainDocument java.lang.Integer
 * @exception String The exception description.
 */
void changeActiveDocument(java.lang.Integer mainDocument) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param leasedocpositionCode int
 * @exception String The exception description.
 */
boolean checkOpenPeriod(int leasedocpositionCode) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param contract int
 * @exception String The exception description.
 * @exception String The exception description.
 */
int getBaseContract(int contract) throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @param contract int
 * @exception String The exception description.
 * @exception String The exception description.
 */
java.sql.Date getEndDateOfContract(int contract) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param documentcode int
 * @exception String The exception description.
 */
boolean isChangeState(int documentcode) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param leaseDocument int
 * @param isExistDocument boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
boolean isChangeStateToEdit(int leaseDocument, boolean isExistDocument) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param leaseContractcode int
 * @param resourcecode int
 * @param salDate java.sql.Date
 * @exception String The exception description.
 */
boolean isInitialSaldo(int leaseContractcode, int resourcecode, java.sql.Date salDate) throws java.rmi.RemoteException;
}
