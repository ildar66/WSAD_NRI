package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: LeasePayOrder
 */
public interface LeasePayOrder extends com.hps.july.persistence.LeasePayment, com.ibm.ivj.ejb.runtime.CopyHelper {

/**
 * Getter method for billDate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getBillDate() throws java.rmi.RemoteException;
/**
 * Getter method for billNumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBillNumber() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Account getOrgAcc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.AccountKey getOrgAccKey() throws java.rmi.RemoteException;
/**
 * Getter method for payPurpose
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPayPurpose() throws java.rmi.RemoteException;
/**
 * Getter method for ppType
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPpType() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOrgAccKey(com.hps.july.persistence.AccountKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOrgAcc(com.hps.july.persistence.Account anOrgAcc) throws java.rmi.RemoteException;
/**
 * Setter method for billDate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setBillDate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for billNumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBillNumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOrgAcc(com.hps.july.persistence.Account anOrgAcc) throws java.rmi.RemoteException;
/**
 * Setter method for payPurpose
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPayPurpose(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for ppType
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPpType(java.lang.String newValue) throws java.rmi.RemoteException;
}
