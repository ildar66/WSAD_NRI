package com.hps.july.persistence;

/**
 * EJSFinderOperatorBean
 */
public interface EJSFinderOperatorBean {
	/**
	 * findOperatorsByMan
	 */
	public com.ibm.ejs.persistence.EJSFinder findOperatorsByMan(com.hps.july.persistence.PeopleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOperatorByLastNameOrderByLoginAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findOperatorByLastNameOrderByLoginAsc(java.lang.String lastName) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByLogin
	 */
	public com.hps.july.persistence.Operator findByLogin(java.lang.String login) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOperatorsWithImportSessions
	 */
	public com.ibm.ejs.persistence.EJSFinder findOperatorsWithImportSessions() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
