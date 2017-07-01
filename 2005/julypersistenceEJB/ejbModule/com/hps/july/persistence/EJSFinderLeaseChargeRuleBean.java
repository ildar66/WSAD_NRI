package com.hps.july.persistence;

/**
 * EJSFinderLeaseChargeRuleBean
 */
public interface EJSFinderLeaseChargeRuleBean {
	/**
	 * findLeaseChargeRuleByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseChargeRuleByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseChargeRuleByCurency
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseChargeRuleByCurency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByLeaseDocumentAndResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeaseDocumentAndResource(java.lang.Integer leaseDocument, java.lang.Integer argResource, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByLeaseDocument
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeaseDocument(java.lang.Integer leaseDocument, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
