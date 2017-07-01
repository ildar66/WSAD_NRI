package com.hps.july.config.beans;
/**
 * Remote interface for Enterprise Bean: CfgTrx2Sector
 */
public interface CfgTrx2Sector extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {

	/**
	 * Get accessor for persistent attribute: objectstatus
	 */
	public java.lang.String getObjectstatus() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: objectstatus
	 */
	public void setObjectstatus(java.lang.String newObjectstatus)
		throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getId_sect() throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getSavconfigid() throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getTrxid() throws java.rmi.RemoteException;
}
