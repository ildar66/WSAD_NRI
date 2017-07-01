package com.hps.july.persistence;

/**
 * EJSFinderPIEQueryBean
 */
public interface EJSFinderPIEQueryBean {
	/**
	 * findByTypeStatusOrderByCodeAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByTypeStatusOrderByCodeAsc(java.lang.String argType, java.lang.String argStatus) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
