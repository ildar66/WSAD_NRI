package com.hps.july.persistence;

/**
 * EJSFinderResourceTaxeBean
 */
public interface EJSFinderResourceTaxeBean {
	/**
	 * findResourceTaxesByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findResourceTaxesByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBySubtypeDateOrderByResourceAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findBySubtypeDateOrderByResourceAsc(java.lang.Integer ressubtype, java.sql.Date date) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByResourceOrderByDateDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByResourceOrderByDateDesc(java.lang.Integer resource) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
