package com.hps.july.persistence;

/**
 * EJSFinderLeaseRuleBean
 */
public interface EJSFinderLeaseRuleBean {
	/**
	 * findLeaseRulesByLeaseDocument
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseRulesByLeaseDocument(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByLeaseDocument
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeaseDocument(java.lang.Integer leaseDocument, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
