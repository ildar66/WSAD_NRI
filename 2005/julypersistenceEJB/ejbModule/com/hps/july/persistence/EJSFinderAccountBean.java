package com.hps.july.persistence;

/**
 * EJSFinderAccountBean
 */
public interface EJSFinderAccountBean {
	/**
	 * findAccountinbankByBank
	 */
	public com.ibm.ejs.persistence.EJSFinder findAccountinbankByBank(java.lang.Integer inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAccountByOrganization
	 */
	public com.ibm.ejs.persistence.EJSFinder findAccountByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
