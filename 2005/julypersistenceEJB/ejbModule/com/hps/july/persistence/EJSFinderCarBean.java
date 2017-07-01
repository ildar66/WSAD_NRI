package com.hps.july.persistence;

/**
 * EJSFinderCarBean
 */
public interface EJSFinderCarBean {
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isOrganization, java.lang.Integer organization, java.lang.Boolean isDivision, java.lang.Integer division, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findCarsByOrganization
	 */
	public com.ibm.ejs.persistence.EJSFinder findCarsByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByOrganizationIsour
	 */
	public com.ibm.ejs.persistence.EJSFinder findByOrganizationIsour(java.lang.Integer organization, java.lang.String isour) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findCarsByDivision
	 */
	public com.ibm.ejs.persistence.EJSFinder findCarsByDivision(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
