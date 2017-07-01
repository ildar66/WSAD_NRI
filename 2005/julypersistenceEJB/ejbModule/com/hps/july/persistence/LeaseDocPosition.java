package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseDocPosition extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2docpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AbonBillpos2docpos getAbonBillpos2docpos() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonPays2docpos2docpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AbonPays2docpos getAbonPays2docpos() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseMutualActNew getAct() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseDocumentKey getActKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getBegindate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getCreated() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getCreatedby() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Currency getCurrency() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.CurrencyKey getCurrencyKey() throws java.rmi.RemoteException;
/**
 * Getter method for date
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getDocposvid() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getEnddate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2docposition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseCalcRates() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseContract getLeaseContract() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseDocumentKey getLeaseContractKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getLeaseDocPosition() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getModified() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getModifiedby() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getOperator() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * Getter method for source
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSource() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSumm() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSumnds() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getUsedinact() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getWillbeinact() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetActKey(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCurrencyKey(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetLeaseContractKey(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2docposition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2docposition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2docpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetAbonBillpos2docpos(com.hps.july.persistence.AbonBillpos2docpos anAbonBillpos2docpos) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonPays2docpos2docpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetAbonPays2docpos(com.hps.july.persistence.AbonPays2docpos anAbonPays2docpos) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetAct(com.hps.july.persistence.LeaseMutualActNew anAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetLeaseContract(com.hps.july.persistence.LeaseContract aLeaseContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setAct(com.hps.july.persistence.LeaseMutualActNew anAct) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setBegindate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setCreated(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setCreatedby(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException;
/**
 * Setter method for date
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setDocposvid(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setEnddate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setLeaseContract(com.hps.july.persistence.LeaseContract aLeaseContract) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newLeaseDocPosition int
 * @exception String The exception description.
 */
void setLeaseDocPosition(int newLeaseDocPosition) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setModified(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setModifiedby(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setOperator(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * Setter method for source
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSource(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setSumm(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setSumnds(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setUsedinact(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setWillbeinact(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
