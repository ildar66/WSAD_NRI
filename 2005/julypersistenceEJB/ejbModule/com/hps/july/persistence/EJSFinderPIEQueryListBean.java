package com.hps.july.persistence;

/**
 * EJSFinderPIEQueryListBean
 */
public interface EJSFinderPIEQueryListBean {
	/**
	 * findPIEQueryListsByQuery
	 */
	public com.ibm.ejs.persistence.EJSFinder findPIEQueryListsByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
