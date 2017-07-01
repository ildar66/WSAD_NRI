package com.hps.july.persistence;

/**
 * EJSFinderAgregateContentBean
 */
public interface EJSFinderAgregateContentBean {
	/**
	 * findAgregateAndPart
	 */
	public com.hps.july.persistence.AgregateContent findAgregateAndPart(java.lang.Integer argAgregate, java.lang.Integer argPart) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAgregateByParts
	 */
	public com.ibm.ejs.persistence.EJSFinder findAgregateByParts(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAgregateContentByAgregate
	 */
	public com.ibm.ejs.persistence.EJSFinder findAgregateContentByAgregate(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
