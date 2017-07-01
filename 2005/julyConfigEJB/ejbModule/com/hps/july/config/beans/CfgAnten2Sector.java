package com.hps.july.config.beans;
/**
 * Remote interface for Enterprise Bean: CfgAnten2Sector
 */
public interface CfgAnten2Sector extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {

	/**
	 * Get accessor for persistent attribute: datasource
	 */
	public java.lang.Integer getDatasource() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: datasource
	 */
	public void setDatasource(java.lang.Integer newDatasource)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: ObjectStatus
	 */
	public java.lang.String getObjectStatus() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: ObjectStatus
	 */
	public void setObjectStatus(java.lang.String newObjectStatus)
		throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getId_anten() throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getId_sect() throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getSavconfigid() throws java.rmi.RemoteException;
}
