package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: LeaseArendaAgreementNew
 */
public interface LeaseArendaAgreementNew extends com.hps.july.persistence.LeaseContract, com.ibm.ivj.ejb.runtime.CopyHelper {











/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getActivecontract() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getBaseenddate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getBasestartdate() throws java.rmi.RemoteException;
/**
 * Getter method for calcElectroType
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getCalcElectroType() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getCustomerold() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getDogelectonum() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDogelectrodate() throws java.rmi.RemoteException;
/**
 * Getter method for isActive
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getIsActive() throws java.rmi.RemoteException;
/**
 * Getter method for isDogElectro
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getIsDogElectro() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2LeaseOnPositions.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseonpositions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for mainDocument
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getMainDocument() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Position getMainposition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StoragePlaceKey getMainpositionKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getMainresource() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getNeedofficialdoc() throws java.rmi.RemoteException;
/**
 * Getter method for numberOfPhones
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getNumberOfPhones() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getNumberofphonestemp() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getOfficialdoc() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSumaccept() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSumpay() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSumtrafic() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetMainpositionKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2LeaseOnPositions.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseonpositions(com.hps.july.persistence.LeaseOnPosition aLeaseonpositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2LeaseOnPositions.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseonpositions(com.hps.july.persistence.LeaseOnPosition aLeaseonpositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetMainposition(com.hps.july.persistence.Position aMainposition) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setActivecontract(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setBaseenddate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setBasestartdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for calcElectroType
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setCalcElectroType(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setCustomerold(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setDogelectonum(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDogelectrodate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for isActive
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setIsActive(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for isDogElectro
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setIsDogElectro(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for mainDocument
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setMainDocument(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setMainposition(com.hps.july.persistence.Position aMainposition) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setMainresource(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setNeedofficialdoc(boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for numberOfPhones
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setNumberOfPhones(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setNumberofphonestemp(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setOfficialdoc(boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setSumaccept(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setSumpay(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setSumtrafic(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: haveioact
	 */
	public boolean getHaveioact() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: haveioact
	 */
	public void setHaveioact(boolean newHaveioact)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: ioactnumber
	 */
	public java.lang.String getIoactnumber() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: ioactnumber
	 */
	public void setIoactnumber(java.lang.String newIoactnumber)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: ioactdate
	 */
	public java.sql.Date getIoactdate() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: ioactdate
	 */
	public void setIoactdate(java.sql.Date newIoactdate)
		throws java.rmi.RemoteException;
}
