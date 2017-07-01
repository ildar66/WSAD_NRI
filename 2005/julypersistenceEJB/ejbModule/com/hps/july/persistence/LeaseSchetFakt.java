package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseSchetFakt extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeasePosSchetFakts(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakts) throws java.rmi.RemoteException;
/**
 * Getter method for baseDocDate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getBaseDocDate() throws java.rmi.RemoteException;
/**
 * Getter method for baseDocNumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBaseDocNumber() throws java.rmi.RemoteException;
/**
 * Getter method for dateSchetFakt
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDateSchetFakt() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getDocfilename() throws java.rmi.RemoteException;
/**
 * 
 * @return byte []
 * @exception String The exception description.
 */
byte [] getDoctext() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseMutualActNew getIdAct() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseDocumentKey getIdActKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseContract getIdContract() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseDocumentKey getIdContractKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Currency getIdCurrency() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CurrencyKey getIdCurrencyKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdSchetFakt() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeasePosSchetFakts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for numberSchetFakt
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNumberSchetFakt() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetIdActKey(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetIdContractKey(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetIdCurrencyKey(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeasePosSchetFakts(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeasePosSchetFakts(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetIdAct(com.hps.july.persistence.LeaseMutualActNew anIdAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetIdContract(com.hps.july.persistence.LeaseContract anIdContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetIdCurrency(com.hps.july.persistence.Currency anIdCurrency) throws java.rmi.RemoteException;
/**
 * Setter method for baseDocDate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setBaseDocDate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for baseDocNumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBaseDocNumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dateSchetFakt
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDateSchetFakt(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setDocfilename(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue byte []
 * @exception String The exception description.
 */
void setDoctext(byte [] newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setIdAct(com.hps.july.persistence.LeaseMutualActNew anIdAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setIdContract(com.hps.july.persistence.LeaseContract anIdContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setIdCurrency(com.hps.july.persistence.Currency anIdCurrency) throws java.rmi.RemoteException;
/**
 * Setter method for numberSchetFakt
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNumberSchetFakt(java.lang.String newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: dateStartSf
	 */
	public java.sql.Date getDateStartSf() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: dateStartSf
	 */
	public void setDateStartSf(java.sql.Date newDateStartSf)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: dateEndSf
	 */
	public java.sql.Date getDateEndSf() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: dateEndSf
	 */
	public void setDateEndSf(java.sql.Date newDateEndSf)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: created
	 */
	public java.sql.Timestamp getCreated() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: created
	 */
	public void setCreated(java.sql.Timestamp newCreated)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: createdBy
	 */
	public java.lang.Integer getCreatedBy() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: createdBy
	 */
	public void setCreatedBy(java.lang.Integer newCreatedBy)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: modified
	 */
	public java.sql.Timestamp getModified() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: modified
	 */
	public void setModified(java.sql.Timestamp newModified)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: modifiedBy
	 */
	public java.lang.Integer getModifiedBy() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: modifiedBy
	 */
	public void setModifiedBy(java.lang.Integer newModifiedBy)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: state
	 */
	public java.lang.String getState() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: state
	 */
	public void setState(java.lang.String newState)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: idRegistryDoc
	 */
	public java.lang.Integer getIdRegistryDoc()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: idRegistryDoc
	 */
	public void setIdRegistryDoc(java.lang.Integer newIdRegistryDoc)
		throws java.rmi.RemoteException;
}
