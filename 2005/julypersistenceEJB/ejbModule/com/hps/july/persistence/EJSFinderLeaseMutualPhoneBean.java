package com.hps.july.persistence;

/**
 * EJSFinderLeaseMutualPhoneBean
 */
public interface EJSFinderLeaseMutualPhoneBean {
	/**
	 * findLeaseMutualPhoneByLeaseDocument
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseMutualPhoneByLeaseDocument(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
