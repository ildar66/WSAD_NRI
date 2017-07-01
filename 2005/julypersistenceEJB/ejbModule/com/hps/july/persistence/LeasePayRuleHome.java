package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface LeasePayRuleHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeasePayRule
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeasePayRule create() throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeasePayRule
 * @param argLeaseRule int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeasePayRule create(int argLeaseRule) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeasePayRule
 * @param argLeaseRule java.lang.Integer
 * @param argLeaseDocument java.lang.Integer
 * @param argCurrency java.lang.Integer
 * @param argSum java.math.BigDecimal
 * @param argPayType java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeasePayRule create(java.lang.Integer argLeaseRule, java.lang.Integer argLeaseDocument, java.lang.Integer argCurrency, java.math.BigDecimal argSum, java.lang.String argPayType) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseRule2LeaseDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByLeaseDocument(Integer leaseDocument, Boolean isPpType, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseRule2LeaseDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByLeasedocumentResourcePaytype(Integer leaseDocument, Integer resource, String paytype) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.LeasePayRule
 * @param key com.hps.july.persistence.LeaseRuleKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeasePayRule findByPrimaryKey(LeaseRuleKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeasePayRule4OrgAccByOrgAcc(com.hps.july.persistence.AccountKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeasePayRule4orgtopayByOrgToPay(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeasePayRuleByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeasePayRuleByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
