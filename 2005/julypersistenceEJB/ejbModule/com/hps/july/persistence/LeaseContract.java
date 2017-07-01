package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: LeaseContract
 */
public interface LeaseContract extends com.hps.july.persistence.LeaseDocument, com.ibm.ivj.ejb.runtime.CopyHelper {








/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseDocPosition(com.hps.july.persistence.LeaseDocPosition aLeaseDocPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getChangeenddate() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getChargeNds() throws java.rmi.RemoteException;
/**
 * Getter method for contractState
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getContractState() throws java.rmi.RemoteException;
/**
 * Getter method for contractType
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getContractType() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Currency getCurrency1() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CurrencyKey getCurrency1Key() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Currency getCurrency2() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CurrencyKey getCurrency2Key() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getCustname() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDateclose() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getDocFileName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getEconomist() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getEconomistKey() throws java.rmi.RemoteException;
/**
 * Getter method for endDate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getEndDate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getExecname() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Short
 * @exception String The exception description.
 */
java.lang.Short getExtenddays() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Short
 * @exception String The exception description.
 */
java.lang.Short getExtendmonthes() throws java.rmi.RemoteException;
/**
 * Getter method for extendPeriod
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getExtendPeriod() throws java.rmi.RemoteException;
/**
 * Getter method for extendType
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getExtendType() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Short
 * @exception String The exception description.
 */
java.lang.Short getExtendyears() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseDocPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseMRCntPriors1() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseMRCntPriors2() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualContracts2contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseMutualContracts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseSchetFakts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseVPayment2creditcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseVPaymentCs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseVPayment2debetcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseVPaymentDs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getManager() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getManagerKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getOrgowner() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getRatecalcrule() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Short
 * @exception String The exception description.
 */
java.lang.Short getRatecalcruleday() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getRatedelta() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getReportPeriod() throws java.rmi.RemoteException;
/**
 * Getter method for startDate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getStartDate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSumm1() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSumm2() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCurrency1Key(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCurrency2Key(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetEconomistKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetManagerKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseDocPosition(com.hps.july.persistence.LeaseDocPosition aLeaseDocPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseMRCntPriors1(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors1) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseMRCntPriors2(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualContracts2contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseVPayment2creditcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseVPaymentCs(com.hps.july.persistence.LeaseVPayment aLeaseVPaymentCs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseVPayment2debetcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseVPaymentDs(com.hps.july.persistence.LeaseVPayment aLeaseVPaymentDs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseDocPosition(com.hps.july.persistence.LeaseDocPosition aLeaseDocPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseMRCntPriors1(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors1) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseMRCntPriors2(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualContracts2contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseVPayment2creditcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseVPaymentCs(com.hps.july.persistence.LeaseVPayment aLeaseVPaymentCs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseVPayment2debetcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseVPaymentDs(com.hps.july.persistence.LeaseVPayment aLeaseVPaymentDs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCurrency1(com.hps.july.persistence.Currency aCurrency1) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCurrency2(com.hps.july.persistence.Currency aCurrency2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetEconomist(com.hps.july.persistence.Worker anEconomist) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetManager(com.hps.july.persistence.Worker aManager) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setChangeenddate(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setChargeNds(boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for contractState
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setContractState(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for contractType
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setContractType(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCurrency1(com.hps.july.persistence.Currency aCurrency1) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCurrency2(com.hps.july.persistence.Currency aCurrency2) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setCustname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDateclose(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setDocFileName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setEconomist(com.hps.july.persistence.Worker anEconomist) throws java.rmi.RemoteException;
/**
 * Setter method for endDate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setEndDate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setExecname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Short
 * @exception String The exception description.
 */
void setExtenddays(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Short
 * @exception String The exception description.
 */
void setExtendmonthes(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * Setter method for extendPeriod
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setExtendPeriod(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for extendType
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setExtendType(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Short
 * @exception String The exception description.
 */
void setExtendyears(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setManager(com.hps.july.persistence.Worker aManager) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setOrgowner(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setRatecalcrule(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Short
 * @exception String The exception description.
 */
void setRatecalcruleday(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setRatedelta(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setReportPeriod(java.lang.String newValue) throws java.rmi.RemoteException;
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
void setSumm1(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setSumm2(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: RateNDS
	 */
	public java.math.BigDecimal getRateNDS() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: RateNDS
	 */
	public void setRateNDS(java.math.BigDecimal newRateNDS)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: NalogAgent
	 */
	public boolean getNalogAgent() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: NalogAgent
	 */
	public void setNalogAgent(boolean newNalogAgent)
		throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named orgExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondarySetOrgExecutor(com.hps.july.persistence.OrganizationNfs anOrgExecutor) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named orgExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setOrgExecutor(com.hps.july.persistence.OrganizationNfs anOrgExecutor) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named orgExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.hps.july.persistence.OrganizationNfsKey getOrgExecutorKey() throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named orgExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetOrgExecutorKey(com.hps.july.persistence.OrganizationNfsKey inKey) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named orgExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.hps.july.persistence.OrganizationNfs getOrgExecutor() throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * This method was generated for supporting the relationship role named orgCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondarySetOrgCustomer(com.hps.july.persistence.OrganizationNfs anOrgCustomer) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named orgCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setOrgCustomer(com.hps.july.persistence.OrganizationNfs anOrgCustomer) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named orgCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.hps.july.persistence.OrganizationNfsKey getOrgCustomerKey() throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named orgCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetOrgCustomerKey(com.hps.july.persistence.OrganizationNfsKey inKey) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named orgCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.hps.july.persistence.OrganizationNfs getOrgCustomer() throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * Get accessor for persistent attribute: isRateLimit
	 */
	public boolean getIsRateLimit() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: isRateLimit
	 */
	public void setIsRateLimit(boolean newIsRateLimit) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: rateLimitMin
	 */
	public java.math.BigDecimal getRateLimitMin() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: rateLimitMin
	 */
	public void setRateLimitMin(java.math.BigDecimal newRateLimitMin) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: rateLimitMax
	 */
	public java.math.BigDecimal getRateLimitMax() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: rateLimitMax
	 */
	public void setRateLimitMax(java.math.BigDecimal newRateLimitMax) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: buchdocnumber
	 */
	public java.lang.String getBuchdocnumber() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: buchdocnumber
	 */
	public void setBuchdocnumber(java.lang.String newBuchdocnumber)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: havedocsigned
	 */
	public java.lang.Boolean getHavedocsigned()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: havedocsigned
	 */
	public void setHavedocsigned(java.lang.Boolean newHavedocsigned)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: havedocsignedcustomer
	 */
	public java.lang.Boolean getHavedocsignedcustomer()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: havedocsignedcustomer
	 */
	public void setHavedocsignedcustomer(
		java.lang.Boolean newHavedocsignedcustomer)
		throws java.rmi.RemoteException;
}
