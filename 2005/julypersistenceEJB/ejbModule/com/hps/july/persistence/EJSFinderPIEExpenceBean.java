package com.hps.july.persistence;

/**
 * EJSFinderPIEExpenceBean
 */
public interface EJSFinderPIEExpenceBean {
	/**
	 * findByOwnerAndRecordstatusOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByOwnerAndRecordstatusOrderByNameAsc(java.lang.Integer owner, java.lang.String recordstatus) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
