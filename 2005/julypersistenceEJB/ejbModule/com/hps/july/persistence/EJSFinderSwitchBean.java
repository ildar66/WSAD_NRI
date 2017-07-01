package com.hps.july.persistence;

/**
 * EJSFinderSwitchBean
 */
public interface EJSFinderSwitchBean {
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isNumber, java.lang.Integer argNumber, java.lang.Boolean isType, java.lang.String argType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Boolean isNumber, java.lang.Integer argNumber, java.lang.Boolean isType, java.lang.String argType, java.lang.Boolean isPlanState, java.lang.String argPlanState, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findSwitchesByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findSwitchesByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
