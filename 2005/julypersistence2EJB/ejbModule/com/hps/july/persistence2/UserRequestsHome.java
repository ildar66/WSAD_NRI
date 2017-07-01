package com.hps.july.persistence2;
/**
 * Home interface for Enterprise Bean: UserRequests
 */
public interface UserRequestsHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: UserRequests
	 */
	public com.hps.july.persistence2.UserRequests findByPrimaryKey(
		com.hps.july.persistence2.UserRequestsKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.persistence2.UserRequests create(
		int argRequest,
		java.sql.Date argDatetimein,
		int argRequesttype,
		int argFilialtype,
		int argWorker,
		int argModule,
		String argDescr,
		String argStatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
