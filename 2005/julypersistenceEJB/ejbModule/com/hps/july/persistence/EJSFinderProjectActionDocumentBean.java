package com.hps.july.persistence;

/**
 * EJSFinderProjectActionDocumentBean
 */
public interface EJSFinderProjectActionDocumentBean {
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Integer argProject, java.lang.Boolean isProjectAction, java.lang.Integer argProjectaction, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findProjectActionDocumentsByProjectaction
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectActionDocumentsByProjectaction(com.hps.july.persistence.ProjectActionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
