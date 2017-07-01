package com.hps.july.persistence;

/**
 * EJSFinderLeasePayOrderBean
 */
public interface EJSFinderLeasePayOrderBean {
	/**
	 * findLeasePayOrderByOrgAcc
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeasePayOrderByOrgAcc(com.hps.july.persistence.AccountKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
