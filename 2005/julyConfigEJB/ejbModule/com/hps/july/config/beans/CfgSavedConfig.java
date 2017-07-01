package com.hps.july.config.beans;
/**
 * Remote interface for Enterprise Bean: CfgSavedConfig
 */
public interface CfgSavedConfig extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {

	/**
	 * Get accessor for persistent attribute: name
	 */
	public java.lang.String getName() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: name
	 */
	public void setName(java.lang.String newName)
		throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getSavconfigid() throws java.rmi.RemoteException;
}
