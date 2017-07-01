package com.hps.july.persistence;

/**
 * EJSFinderI13nDateSavingBean
 */
public interface EJSFinderI13nDateSavingBean {
	/**
	 * findI13nDateSavingByI13nAct
	 */
	public com.ibm.ejs.persistence.EJSFinder findI13nDateSavingByI13nAct(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findI13nDateSavingByStorageCard
	 */
	public com.ibm.ejs.persistence.EJSFinder findI13nDateSavingByStorageCard(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
