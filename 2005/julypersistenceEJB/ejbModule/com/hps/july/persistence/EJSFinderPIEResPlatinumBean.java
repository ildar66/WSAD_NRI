package com.hps.july.persistence;

/**
 * EJSFinderPIEResPlatinumBean
 */
public interface EJSFinderPIEResPlatinumBean {
	/**
	 * findByIdresplatinNameOwner
	 */
	public com.ibm.ejs.persistence.EJSFinder findByIdresplatinNameOwner(java.lang.Boolean isIdresplatin, java.lang.String idresplatin, java.lang.Boolean isNameRes, java.lang.String nameRes, java.lang.Integer owner, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
