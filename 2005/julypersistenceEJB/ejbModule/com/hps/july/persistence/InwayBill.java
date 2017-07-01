package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: InwayBill
 */
public interface InwayBill extends com.hps.july.persistence.Document, com.ibm.ivj.ejb.runtime.CopyHelper {

/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) throws java.rmi.RemoteException;
/**
 * Getter method for cordocdate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getCordocdate() throws java.rmi.RemoteException;
/**
 * Getter method for cordocnum
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getCordocnum() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Currency getCurrency() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.CurrencyKey getCurrencyKey() throws java.rmi.RemoteException;
/**
 * Getter method for dActDate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDActDate() throws java.rmi.RemoteException;
/**
 * Getter method for dActNumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDActNumber() throws java.rmi.RemoteException;
/**
 * Getter method for dActRepresentative
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDActRepresentative() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getDActStorManager() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getDActStorManagerKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getDActTechStuf() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getDActTechStufKey() throws java.rmi.RemoteException;
/**
 * Getter method for gtddate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getGtddate() throws java.rmi.RemoteException;
/**
 * Getter method for gtdnumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getGtdnumber() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getOuterDocPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getRepresentative() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getRepresentativeKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getRepresenttype() throws java.rmi.RemoteException;
/**
 * Getter method for supplyCondition
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSupplyCondition() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCurrencyKey(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetDActStorManagerKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetDActTechStufKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetRepresentativeKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetDActStorManager(com.hps.july.persistence.Worker aDActStorManager) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetDActTechStuf(com.hps.july.persistence.Worker aDActTechStuf) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetRepresentative(com.hps.july.persistence.Worker aRepresentative) throws java.rmi.RemoteException;
/**
 * Setter method for cordocdate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setCordocdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for cordocnum
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setCordocnum(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException;
/**
 * Setter method for dActDate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDActDate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dActNumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDActNumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dActRepresentative
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDActRepresentative(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setDActStorManager(com.hps.july.persistence.Worker aDActStorManager) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setDActTechStuf(com.hps.july.persistence.Worker aDActTechStuf) throws java.rmi.RemoteException;
/**
 * Setter method for gtddate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setGtddate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for gtdnumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setGtdnumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setRepresentative(com.hps.july.persistence.Worker aRepresentative) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setRepresenttype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for supplyCondition
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSupplyCondition(java.lang.String newValue) throws java.rmi.RemoteException;
}
