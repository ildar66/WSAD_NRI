package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseAbonentDNOP extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AbonentBill getAbonentbill() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AbonentBillKey getAbonentbillKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AbonentPayment getAbonentpayment() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AbonentPaymentKey getAbonentpaymentKey() throws java.rmi.RemoteException;
/**
 * Getter method for flagworknri
 * @return boolean
 * @exception java.rmi.RemoteException The exception description.
 */
boolean getFlagworknri() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdabonentdnop() throws java.rmi.RemoteException;
/**
 * Getter method for recordstatus
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRecordstatus() throws java.rmi.RemoteException;
/**
 * Getter method for sumlinkusd
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumlinkusd() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetAbonentbillKey(com.hps.july.persistence.AbonentBillKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetAbonentpaymentKey(com.hps.july.persistence.AbonentPaymentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetAbonentbill(com.hps.july.persistence.AbonentBill anAbonentbill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetAbonentpayment(com.hps.july.persistence.AbonentPayment anAbonentpayment) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setAbonentbill(com.hps.july.persistence.AbonentBill anAbonentbill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setAbonentpayment(com.hps.july.persistence.AbonentPayment anAbonentpayment) throws java.rmi.RemoteException;
/**
 * Setter method for flagworknri
 * @param newValue boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setFlagworknri(boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for recordstatus
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRecordstatus(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sumlinkusd
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumlinkusd(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
