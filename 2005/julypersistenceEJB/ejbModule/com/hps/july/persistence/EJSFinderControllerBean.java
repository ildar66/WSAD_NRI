package com.hps.july.persistence;

/**
 * EJSFinderControllerBean
 */
public interface EJSFinderControllerBean {
	/**
	 * findControllerBySwitch
	 */
	public com.ibm.ejs.persistence.EJSFinder findControllerBySwitch(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findControllersByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findControllersByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isNumber, java.lang.Integer argNumber, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isSwitch, java.lang.Integer argSwitch, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
