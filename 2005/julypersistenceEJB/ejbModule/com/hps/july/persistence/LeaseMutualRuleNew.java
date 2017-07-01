package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseMutualRuleNew extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for chargedaterule
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getChargedaterule() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getDopchargdatrul() throws java.rmi.RemoteException;
/**
 * Getter method for paydaterule
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPaydaterule() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseMutualReglament getReglament() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getReglamentKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * Setter method for chargedaterule
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setChargedaterule(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setDopchargdatrul(boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for paydaterule
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPaydaterule(java.lang.String newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: rateType
	 */
	public java.lang.Integer getRateType() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: rateType
	 */
	public void setRateType(java.lang.Integer newRateType) throws java.rmi.RemoteException;
}
