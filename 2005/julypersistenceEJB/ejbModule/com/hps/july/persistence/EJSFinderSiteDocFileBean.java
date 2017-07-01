package com.hps.july.persistence;

/**
 * EJSFinderSiteDocFileBean
 */
public interface EJSFinderSiteDocFileBean {
	/**
	 * findBySitedocOrderBySitedocAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findBySitedocOrderBySitedocAsc(java.lang.Integer siteDoc) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBySitedocOrderBySitedocDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findBySitedocOrderBySitedocDesc(java.lang.Integer siteDoc) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findSiteDocFilesBySiteDoc
	 */
	public com.ibm.ejs.persistence.EJSFinder findSiteDocFilesBySiteDoc(com.hps.july.persistence.SiteDocKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBySitedocsOrderByPKAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findBySitedocsOrderByPKAsc(java.lang.Integer siteDoc) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBySitedocsOrderByPKDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findBySitedocsOrderByPKDesc(java.lang.Integer siteDoc) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
