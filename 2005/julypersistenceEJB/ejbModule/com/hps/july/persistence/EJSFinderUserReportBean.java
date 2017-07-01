package com.hps.july.persistence;

/**
 * EJSFinderUserReportBean
 */
public interface EJSFinderUserReportBean {
	/**
	 * findByGroupOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByGroupOrderByNameAsc(java.lang.Integer argGroupId) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findUserReportsByUserRepGroup
	 */
	public com.ibm.ejs.persistence.EJSFinder findUserReportsByUserRepGroup(com.hps.july.persistence.UserRepGroupKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
