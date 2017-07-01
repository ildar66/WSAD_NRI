package com.hps.july.persistence;
/**
 * Remote interface for Enterprise Bean: AccumBatteryResource
 */
public interface AccumBatteryResource extends com.hps.july.persistence.Resource, com.ibm.ivj.ejb.runtime.CopyHelper {









	/**
	 * Get accessor for persistent attribute: voltage
	 */
	public java.math.BigDecimal getVoltage() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: voltage
	 */
	public void setVoltage(java.math.BigDecimal newVoltage)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: capacity
	 */
	public java.math.BigDecimal getCapacity() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: capacity
	 */
	public void setCapacity(java.math.BigDecimal newCapacity)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: accutype
	 */
	public java.lang.String getAccutype() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: accutype
	 */
	public void setAccutype(java.lang.String newAccutype)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: accucount
	 */
	public java.lang.Integer getAccucount() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: accucount
	 */
	public void setAccucount(java.lang.Integer newAccucount)
		throws java.rmi.RemoteException;
}
