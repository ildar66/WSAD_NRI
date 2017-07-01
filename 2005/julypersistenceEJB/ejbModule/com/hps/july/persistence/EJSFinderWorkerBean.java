package com.hps.july.persistence;

/**
 * EJSFinderWorkerBean
 */
public interface EJSFinderWorkerBean {
	/**
	 * findWorkersByMan
	 */
	public com.ibm.ejs.persistence.EJSFinder findWorkersByMan(com.hps.july.persistence.PeopleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findWorkersByDivision
	 */
	public com.ibm.ejs.persistence.EJSFinder findWorkersByDivision(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByLastNameOrderByLastNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLastNameOrderByLastNameAsc(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAlienWorkers
	 */
	public com.ibm.ejs.persistence.EJSFinder findAlienWorkers(java.lang.Integer organization, java.lang.String family) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findWorkersByPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findWorkersByPosition(com.hps.july.persistence.WorkPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isDivision, java.lang.Integer argDivision, java.lang.Boolean isLastName, java.lang.String argLastName, java.lang.Boolean isActive, java.lang.Boolean argActive, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findWorkersByOrganization
	 */
	public com.ibm.ejs.persistence.EJSFinder findWorkersByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findWorkersByCompany
	 */
	public com.ibm.ejs.persistence.EJSFinder findWorkersByCompany(com.hps.july.persistence.CompanyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
