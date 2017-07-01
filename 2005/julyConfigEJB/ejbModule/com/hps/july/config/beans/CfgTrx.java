package com.hps.july.config.beans;
/**
 * Remote interface for Enterprise Bean: CfgTrx
 */
public interface CfgTrx extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {

	/**
	 * Get accessor for persistent attribute: resource
	 */
	public int getResource() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: resource
	 */
	public void setResource(int newResource) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: standid
	 */
	public int getStandid() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: standid
	 */
	public void setStandid(int newStandid) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: storagecard
	 */
	public java.lang.Integer getStoragecard() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: storagecard
	 */
	public void setStoragecard(java.lang.Integer newStoragecard)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: qty
	 */
	public java.math.BigDecimal getQty() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: qty
	 */
	public void setQty(java.math.BigDecimal newQty)
		throws java.rmi.RemoteException;
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
	public int getSavconfigid() throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getTrxid() throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: equipment
	 */
	public int getEquipment() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: equipment
	 */
	public void setEquipment(int newEquipment) throws java.rmi.RemoteException;
}
