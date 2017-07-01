package com.hps.july.persistence;

/**
 * EJSFinderPIEQueryLogBean
 */
public interface EJSFinderPIEQueryLogBean {
	/**
	 * findByQueryTypeOrderByCodeAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQueryTypeOrderByCodeAsc(java.lang.Integer argQuery, java.lang.String argType) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPIEQueryLogsByQuery
	 */
	public com.ibm.ejs.persistence.EJSFinder findPIEQueryLogsByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
