package com.hps.july.persistence;

/**
 * EJSFinderResourceSetBean
 */
public interface EJSFinderResourceSetBean {
	/**
	 * findResourceSetsBySubtype
	 */
	public com.ibm.ejs.persistence.EJSFinder findResourceSetsBySubtype(java.lang.Integer argSubtype) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findResourceSetsByMainpart
	 */
	public com.ibm.ejs.persistence.EJSFinder findResourceSetsByMainpart(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
