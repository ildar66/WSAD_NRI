package com.hps.july.persistence;

/**
 * EJSFinderPIEReferenceBean
 */
public interface EJSFinderPIEReferenceBean {
	/**
	 * findBySpravOrderByCodeAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findBySpravOrderByCodeAsc(java.lang.String argSprav) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByOwnerAndSpravOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByOwnerAndSpravOrderByNameAsc(java.lang.Integer argOwner, java.lang.String argSprav) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
