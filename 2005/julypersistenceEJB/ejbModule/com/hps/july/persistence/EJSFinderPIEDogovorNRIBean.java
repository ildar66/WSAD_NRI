package com.hps.july.persistence;

/**
 * EJSFinderPIEDogovorNRIBean
 */
public interface EJSFinderPIEDogovorNRIBean {
	/**
	 * findPIEDogovorNRIsByPiequery
	 */
	public com.ibm.ejs.persistence.EJSFinder findPIEDogovorNRIsByPiequery(com.hps.july.persistence.PIEQueryKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
