package com.hps.july.persistence;

/**
 * EJSFinderSearchesBean
 */
public interface EJSFinderSearchesBean {
	/**
	 * findSearchesByOrganization
	 */
	public com.ibm.ejs.persistence.EJSFinder findSearchesByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findSearchesByGroupping
	 */
	public com.ibm.ejs.persistence.EJSFinder findSearchesByGroupping(com.hps.july.persistence.SearchGrouppingKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findSearchesByGroup
	 */
	public com.ibm.ejs.persistence.EJSFinder findSearchesByGroup(com.hps.july.persistence.SearchGroupKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
