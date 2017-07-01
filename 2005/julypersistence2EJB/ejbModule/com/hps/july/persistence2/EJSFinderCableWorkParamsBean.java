package com.hps.july.persistence2;

/**
 * EJSFinderCableWorkParamsBean
 */
public interface EJSFinderCableWorkParamsBean {
	/**
	 * findByCable
	 */
	public com.ibm.ejs.persistence.EJSFinder findByCable(java.lang.Integer argCableId) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
