package com.hps.july.persistence;

/**
 * EJSFinderPIEBankPlatinumBean
 */
public interface EJSFinderPIEBankPlatinumBean {
	/**
	 * findNotWorkedByOwner
	 */
	public com.ibm.ejs.persistence.EJSFinder findNotWorkedByOwner(java.lang.Integer argOwner) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
