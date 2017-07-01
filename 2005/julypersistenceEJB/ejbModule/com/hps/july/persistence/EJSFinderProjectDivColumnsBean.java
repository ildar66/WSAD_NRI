package com.hps.july.persistence;

/**
 * EJSFinderProjectDivColumnsBean
 */
public interface EJSFinderProjectDivColumnsBean {
	/**
	 * findProjectDivColumnsByDivision
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectDivColumnsByDivision(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByColDivisionActtypeOrderByAfterColAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByColDivisionActtypeOrderByAfterColAsc(java.lang.Integer argAfterCol, java.lang.Integer argDivision, java.lang.Integer argProjectType) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findProjectDivColumnsByProjectType
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectDivColumnsByProjectType(com.hps.july.persistence.ProjectTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
