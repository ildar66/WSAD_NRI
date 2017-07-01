package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface LeaseChargeRuleHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseChargeRule
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseChargeRule create() throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeaseChargeRule
 * @param argLeaseRule int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseChargeRule create(int argLeaseRule) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeaseChargeRule
 * @param argLeaseRule java.lang.Integer
 * @param argLeaseDocument java.lang.Integer
 * @param argResource java.lang.Integer
 * @param argCurrency java.lang.Integer
 * @param argSum java.math.BigDecimal
 * @param argChargePeriod java.lang.String
 * @param argChargeDateRule java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseChargeRule create(java.lang.Integer argLeaseRule, java.lang.Integer argLeaseDocument, java.lang.Integer argResource, java.lang.Integer argCurrency, java.math.BigDecimal argSum, java.lang.String argChargePeriod, java.lang.String argChargeDateRule) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseRule2LeaseDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByLeaseDocument(Integer leaseDocument, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseRule2LeaseDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByLeaseDocumentAndResource(Integer leaseDocument, Integer argResource, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.LeaseChargeRule
 * @param key com.hps.july.persistence.LeaseRuleKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseChargeRule findByPrimaryKey(LeaseRuleKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseChargeRuleByCurency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseChargeRuleByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
