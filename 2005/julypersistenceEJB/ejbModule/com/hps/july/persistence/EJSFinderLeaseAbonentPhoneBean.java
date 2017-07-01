package com.hps.july.persistence;

/**
 * EJSFinderLeaseAbonentPhoneBean
 */
public interface EJSFinderLeaseAbonentPhoneBean {
	/**
	 * findByLeaseDocumentOrderByPhoneNumberAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeaseDocumentOrderByPhoneNumberAsc(java.lang.Integer leaseDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseAbonentPhonesByPhone2ban
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseAbonentPhonesByPhone2ban(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
