package com.hps.july.persistence;

/**
 * EJSFinderPIEDocNriBean
 */
public interface EJSFinderPIEDocNriBean {
	/**
	 * findPIEDocNrisByQuery
	 */
	public com.ibm.ejs.persistence.EJSFinder findPIEDocNrisByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
