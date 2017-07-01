package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: LeasePayment
 */
public interface LeasePayment extends com.hps.july.persistence.LeaseDocPosition, com.ibm.ivj.ejb.runtime.CopyHelper {

/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getByautorur() throws java.rmi.RemoteException;
/**
 * Getter method for docNumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDocNumber() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getIsSchetFakt() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDNOP2LeasePayment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseDNOPPay() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeasePayRule getLeaseRule() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseRuleKey getLeaseRuleKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getNdsRub() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getOfficememonumber() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getOtvworker() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPaymentstate() throws java.rmi.RemoteException;
/**
 * Getter method for paymentType
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPaymentType() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getPayrate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getRurremainder() throws java.rmi.RemoteException;
/**
 * Getter method for sumRub
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumRub() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetLeaseRuleKey(com.hps.july.persistence.LeaseRuleKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDNOP2LeasePayment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseDNOPPay(com.hps.july.persistence.LeaseDNOP aLeaseDNOPPay) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDNOP2LeasePayment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseDNOPPay(com.hps.july.persistence.LeaseDNOP aLeaseDNOPPay) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetLeaseRule(com.hps.july.persistence.LeasePayRule aLeaseRule) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setByautorur(boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for docNumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDocNumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setIsSchetFakt(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setLeaseRule(com.hps.july.persistence.LeasePayRule aLeaseRule) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setNdsRub(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setOfficememonumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setOtvworker(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setPaymentstate(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for paymentType
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPaymentType(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setPayrate(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setRurremainder(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sumRub
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumRub(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: flagOplNds
	 */
	public java.lang.Boolean getFlagOplNds() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: flagOplNds
	 */
	public void setFlagOplNds(java.lang.Boolean newFlagOplNds) throws java.rmi.RemoteException;
}
