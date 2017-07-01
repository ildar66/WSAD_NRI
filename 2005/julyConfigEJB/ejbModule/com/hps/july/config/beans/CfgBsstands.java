package com.hps.july.config.beans;
/**
 * Remote interface for Enterprise Bean: CfgBsstands
 */
public interface CfgBsstands extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {

	/**
	 * Get accessor for persistent attribute: equipment
	 */
	public int getEquipment() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: equipment
	 */
	public void setEquipment(int newEquipment) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: resource
	 */
	public java.lang.Integer getResource() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: resource
	 */
	public void setResource(java.lang.Integer newResource)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: stnomer
	 */
	public java.lang.String getStnomer() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: stnomer
	 */
	public void setStnomer(java.lang.String newStnomer)
		throws java.rmi.RemoteException;
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
	public int getSavconfigid() throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getStandid() throws java.rmi.RemoteException;
}
