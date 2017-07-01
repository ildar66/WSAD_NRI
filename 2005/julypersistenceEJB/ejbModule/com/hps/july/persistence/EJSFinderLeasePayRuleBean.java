package com.hps.july.persistence;

/**
 * EJSFinderLeasePayRuleBean
 */
public interface EJSFinderLeasePayRuleBean {
	/**
	 * findLeasePayRuleByCurrency
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeasePayRuleByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeasePayRuleByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeasePayRuleByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeasePayRule4orgtopayByOrgToPay
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeasePayRule4orgtopayByOrgToPay(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByLeasedocumentResourcePaytype
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeasedocumentResourcePaytype(java.lang.Integer leaseDocument, java.lang.Integer resource, java.lang.String paytype) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByLeaseDocument
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeaseDocument(java.lang.Integer leaseDocument, java.lang.Boolean isPpType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeasePayRule4OrgAccByOrgAcc
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeasePayRule4OrgAccByOrgAcc(com.hps.july.persistence.AccountKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
