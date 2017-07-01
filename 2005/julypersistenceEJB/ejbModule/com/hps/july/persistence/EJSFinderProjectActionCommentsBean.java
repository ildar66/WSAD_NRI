package com.hps.july.persistence;

/**
 * EJSFinderProjectActionCommentsBean
 */
public interface EJSFinderProjectActionCommentsBean {
	/**
	 * findProjectActionCommentsByProjectaction
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectActionCommentsByProjectaction(com.hps.july.persistence.ProjectActionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findProjectActionCommentsByDivision
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectActionCommentsByDivision(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
