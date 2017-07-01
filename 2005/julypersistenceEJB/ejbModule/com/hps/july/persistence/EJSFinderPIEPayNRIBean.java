package com.hps.july.persistence;

/**
 * EJSFinderPIEPayNRIBean
 */
public interface EJSFinderPIEPayNRIBean {
	/**
	 * findPIEPayNRIsByQuery
	 */
	public com.ibm.ejs.persistence.EJSFinder findPIEPayNRIsByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
