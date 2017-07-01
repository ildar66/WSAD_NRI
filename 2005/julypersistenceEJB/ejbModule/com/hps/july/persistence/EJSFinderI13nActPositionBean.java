package com.hps.july.persistence;

/**
 * EJSFinderI13nActPositionBean
 */
public interface EJSFinderI13nActPositionBean {
	/**
	 * findI13nActPositionByContract
	 */
	public com.ibm.ejs.persistence.EJSFinder findI13nActPositionByContract(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
