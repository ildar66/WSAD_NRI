package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Contract extends Document, com.ibm.ivj.ejb.runtime.CopyHelper {
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addCards(com.hps.july.persistence.StorageCard aCards) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addI13nActPosition(com.hps.july.persistence.I13nActPosition anI13nActPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2BaseAgreement.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.BaseAgreement getBaseAgreement() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2BaseAgreement.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.BaseAgreementKey getBaseAgreementKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getCards() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getContractState() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getController() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getControllerKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Currency getCurrency() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.CurrencyKey getCurrencyKey() throws java.rmi.RemoteException;
/**
 * Getter method for finishDate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getFinishDate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getI13nActPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * Getter method for startDate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getStartDate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getStorageCard() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSum() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SupplyType getSupplyType() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2SupplyType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.SupplyTypeKey getSupplyTypeKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getTextFileName() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getTimelineFileName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getWorker() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getWorkerKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2BaseAgreement.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetBaseAgreementKey(com.hps.july.persistence.BaseAgreementKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetControllerKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCurrencyKey(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2SupplyType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetSupplyTypeKey(com.hps.july.persistence.SupplyTypeKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetWorkerKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddCards(com.hps.july.persistence.StorageCard aCards) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddI13nActPosition(com.hps.july.persistence.I13nActPosition anI13nActPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveCards(com.hps.july.persistence.StorageCard aCards) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveI13nActPosition(com.hps.july.persistence.I13nActPosition anI13nActPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2BaseAgreement.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetBaseAgreement(com.hps.july.persistence.BaseAgreement aBaseAgreement) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetController(com.hps.july.persistence.Worker aController) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetSupplyType(com.hps.july.persistence.SupplyType aSupplyType) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetWorker(com.hps.july.persistence.Worker aWorker) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2BaseAgreement.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setBaseAgreement(com.hps.july.persistence.BaseAgreement aBaseAgreement) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setContractState(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setController(com.hps.july.persistence.Worker aController) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException;
/**
 * Setter method for finishDate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setFinishDate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for startDate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setStartDate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setSum(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setSupplyType(com.hps.july.persistence.SupplyType aSupplyType) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setTextFileName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setTimelineFileName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setWorker(com.hps.july.persistence.Worker aWorker) throws java.rmi.RemoteException;
}
