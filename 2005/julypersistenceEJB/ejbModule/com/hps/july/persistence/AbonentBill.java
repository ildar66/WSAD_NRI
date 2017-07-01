package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AbonentBill extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named AbonentBillPos2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseAbonentDNOPs(com.hps.july.persistence.LeaseAbonentDNOP aLeaseAbonentDNOPs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getAbonentBillPoses() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Short
 * @exception String The exception description.
 */
java.lang.Short getBen() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getBensource() throws java.rmi.RemoteException;
/**
 * Getter method for billdate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getBilldate() throws java.rmi.RemoteException;
/**
 * Getter method for billnumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBillnumber() throws java.rmi.RemoteException;
/**
 * Getter method for billperiodend
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getBillperiodend() throws java.rmi.RemoteException;
/**
 * Getter method for billperiodstart
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getBillperiodstart() throws java.rmi.RemoteException;
/**
 * Getter method for billstatus
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBillstatus() throws java.rmi.RemoteException;
/**
 * Getter method for billtype
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBilltype() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getChangeuseinnri() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getFlagworknri() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseAbonentBAN getLeaseabonentban() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseDocumentKey getLeaseabonentbanKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseAbonentDNOPs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getLeasebill() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getNotessummopl() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getRecordstatus() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getSumchangereason() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSummopl() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getUseinnri() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetLeaseabonentbanKey(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseAbonentDNOPs(com.hps.july.persistence.LeaseAbonentDNOP aLeaseAbonentDNOPs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseAbonentDNOPs(com.hps.july.persistence.LeaseAbonentDNOP aLeaseAbonentDNOPs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetLeaseabonentban(com.hps.july.persistence.LeaseAbonentBAN aLeaseabonentban) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Short
 * @exception String The exception description.
 */
void setBen(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setBensource(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for billdate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setBilldate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for billnumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBillnumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for billperiodend
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setBillperiodend(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for billperiodstart
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setBillperiodstart(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for billstatus
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBillstatus(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for billtype
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBilltype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setChangeuseinnri(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setFlagworknri(boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setLeaseabonentban(com.hps.july.persistence.LeaseAbonentBAN aLeaseabonentban) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setNotessummopl(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setRecordstatus(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setSumchangereason(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setSummopl(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setUseinnri(java.lang.Boolean newValue) throws java.rmi.RemoteException;
}
