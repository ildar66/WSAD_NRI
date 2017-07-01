package com.hps.july.persistence;

/**
 * EJSFinderDocumentsLinkBean
 */
public interface EJSFinderDocumentsLinkBean {
	/**
	 * findByTypeAndDocFrom
	 */
	public com.ibm.ejs.persistence.EJSFinder findByTypeAndDocFrom(java.lang.String argType, java.lang.Integer argDoc) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocumentsLinkToByDocumentTo
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocumentsLinkToByDocumentTo(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocumentsLinkFromByDocumentfrom
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocumentsLinkFromByDocumentfrom(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByTypeAndDocTo
	 */
	public com.ibm.ejs.persistence.EJSFinder findByTypeAndDocTo(java.lang.String argType, java.lang.Integer argDoc) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
