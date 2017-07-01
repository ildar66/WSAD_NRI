package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseMutualReglament extends com.hps.july.persistence.LeaseDocument {
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseMutualActNew(com.hps.july.persistence.LeaseMutualActNew aLeaseMutualActNew) throws java.rmi.RemoteException;
/**
 * Getter method for actType
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getActType() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Currency getAdditionalCurrency() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.CurrencyKey getAdditionalCurrencyKey() throws java.rmi.RemoteException;
/**
 * Getter method for calcRateType
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getCalcRateType() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getCommonRate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getDutyraterule() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getEnddate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseMRCntPriors() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseMutualActNew() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualContracts2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseMutualContracts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualPhone2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseMutualPhone() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseMutualRules() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Currency getMaincurrency() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.CurrencyKey getMaincurrencyKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getMutState() throws java.rmi.RemoteException;
/**
 * Getter method for mutualPeriod
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getMutualPeriod() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getStartdate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetAdditionalCurrencyKey(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetMaincurrencyKey(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseMRCntPriors(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseMutualActNew(com.hps.july.persistence.LeaseMutualActNew aLeaseMutualActNew) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualContracts2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualPhone2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseMutualPhone(com.hps.july.persistence.LeaseMutualPhone aLeaseMutualPhone) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseMutualRules(com.hps.july.persistence.LeaseMutualRuleNew aLeaseMutualRules) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseMRCntPriors(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseMutualActNew(com.hps.july.persistence.LeaseMutualActNew aLeaseMutualActNew) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualContracts2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualPhone2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseMutualPhone(com.hps.july.persistence.LeaseMutualPhone aLeaseMutualPhone) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseMutualRules(com.hps.july.persistence.LeaseMutualRuleNew aLeaseMutualRules) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetAdditionalCurrency(com.hps.july.persistence.Currency anAdditionalCurrency) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetMaincurrency(com.hps.july.persistence.Currency aMaincurrency) throws java.rmi.RemoteException;
/**
 * Setter method for actType
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setActType(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setAdditionalCurrency(com.hps.july.persistence.Currency anAdditionalCurrency) throws java.rmi.RemoteException;
/**
 * Setter method for calcRateType
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setCalcRateType(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setCommonRate(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setDutyraterule(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setEnddate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setMaincurrency(com.hps.july.persistence.Currency aMaincurrency) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setMutState(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for mutualPeriod
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setMutualPeriod(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setStartdate(java.sql.Date newValue) throws java.rmi.RemoteException;
}
