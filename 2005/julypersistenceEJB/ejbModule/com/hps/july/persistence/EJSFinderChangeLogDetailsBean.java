package com.hps.july.persistence;

/**
 * EJSFinderChangeLogDetailsBean
 */
public interface EJSFinderChangeLogDetailsBean {
	/**
	 * findChangeLogDetailsesByChangelog
	 */
	public com.ibm.ejs.persistence.EJSFinder findChangeLogDetailsesByChangelog(com.hps.july.persistence.ChangeLogKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByChangelogOrderByCodeAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByChangelogOrderByCodeAsc(java.lang.Integer argLog) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
