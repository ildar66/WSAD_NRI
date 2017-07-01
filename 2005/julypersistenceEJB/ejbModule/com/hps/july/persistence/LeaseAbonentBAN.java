package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: LeaseAbonentBAN
 */
public interface LeaseAbonentBAN extends com.hps.july.persistence.LeaseContract, com.ibm.ivj.ejb.runtime.CopyHelper {





/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAbonentBills(com.hps.july.persistence.AbonentBill anAbonentBills) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAbonentPayments(com.hps.july.persistence.AbonentPayment anAbonentPayments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getAbonentBills() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getAbonentPayments() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for accounttype
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getAccounttype() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getBalans() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getBan() throws java.rmi.RemoteException;
/**
 * Getter method for bil_acctypename
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBil_acctypename() throws java.rmi.RemoteException;
/**
 * Getter method for bil_billaddress
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBil_billaddress() throws java.rmi.RemoteException;
/**
 * Getter method for bil_contrstatus
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBil_contrstatus() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getBil_contrstdate() throws java.rmi.RemoteException;
/**
 * Getter method for bil_contrstname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBil_contrstname() throws java.rmi.RemoteException;
/**
 * Getter method for bil_inn
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBil_inn() throws java.rmi.RemoteException;
/**
 * Getter method for bil_name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBil_name() throws java.rmi.RemoteException;
/**
 * Getter method for bil_startservdate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getBil_startservdate() throws java.rmi.RemoteException;
/**
 * Getter method for bil_suspdate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getBil_suspdate() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getFlagworkpie() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentBEN2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseAbonentBENs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseAbonentPhone2BAN.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseAbonentPhones() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getMainposition() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getProctype() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getTechcontract() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getUseallben() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getUseinacts() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddAbonentBills(com.hps.july.persistence.AbonentBill anAbonentBills) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddAbonentPayments(com.hps.july.persistence.AbonentPayment anAbonentPayments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentBEN2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseAbonentBENs(com.hps.july.persistence.LeaseAbonentBEN aLeaseAbonentBENs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentPhone2BAN.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseAbonentPhones(com.hps.july.persistence.LeaseAbonentPhone aLeaseAbonentPhones) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveAbonentBills(com.hps.july.persistence.AbonentBill anAbonentBills) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveAbonentPayments(com.hps.july.persistence.AbonentPayment anAbonentPayments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentBEN2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseAbonentBENs(com.hps.july.persistence.LeaseAbonentBEN aLeaseAbonentBENs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentPhone2BAN.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseAbonentPhones(com.hps.july.persistence.LeaseAbonentPhone aLeaseAbonentPhones) throws java.rmi.RemoteException;
/**
 * Setter method for accounttype
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setAccounttype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setBalans(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setBan(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for bil_acctypename
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBil_acctypename(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for bil_billaddress
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBil_billaddress(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for bil_contrstatus
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBil_contrstatus(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setBil_contrstdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for bil_contrstname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBil_contrstname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for bil_inn
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBil_inn(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for bil_name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBil_name(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for bil_startservdate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setBil_startservdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for bil_suspdate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setBil_suspdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setFlagworkpie(boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setMainposition(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setProctype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setTechcontract(boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setUseallben(boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setUseinacts(boolean newValue) throws java.rmi.RemoteException;
}
