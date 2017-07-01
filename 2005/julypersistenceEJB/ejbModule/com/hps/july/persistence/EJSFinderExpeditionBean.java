package com.hps.july.persistence;

/**
 * EJSFinderExpeditionBean
 */
public interface EJSFinderExpeditionBean {
	/**
	 * findExpeditionByExpeditor
	 */
	public com.ibm.ejs.persistence.EJSFinder findExpeditionByExpeditor(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findExpeditionByOrganization
	 */
	public com.ibm.ejs.persistence.EJSFinder findExpeditionByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
