package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseChargeRule extends com.hps.july.persistence.LeaseRule {
/**
 * This method was generated for supporting the association named LeaseCharges2LeaseChargeRules.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseCharges(com.hps.july.persistence.LeaseCharges aLeaseCharges) throws java.rmi.RemoteException;
/**
 * Getter method for chargeDateRule
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getChargeDateRule() throws java.rmi.RemoteException;
/**
 * Getter method for chargePeriod
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getChargePeriod() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Currency getCurency() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.CurrencyKey getCurencyKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCharges2LeaseChargeRules.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseCharges() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * Getter method for sum
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSum() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCurencyKey(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCharges2LeaseChargeRules.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseCharges(com.hps.july.persistence.LeaseCharges aLeaseCharges) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCharges2LeaseChargeRules.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseCharges(com.hps.july.persistence.LeaseCharges aLeaseCharges) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetCurency(com.hps.july.persistence.Currency aCurency) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * Setter method for chargeDateRule
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setChargeDateRule(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for chargePeriod
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setChargePeriod(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setCurency(com.hps.july.persistence.Currency aCurency) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * Setter method for sum
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSum(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
