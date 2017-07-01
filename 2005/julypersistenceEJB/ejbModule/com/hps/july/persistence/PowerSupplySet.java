package com.hps.july.persistence;
/**
 * Remote interface for Enterprise Bean: PowerSupplySet
 */
public interface PowerSupplySet extends com.hps.july.persistence.ResourceSet, com.ibm.ivj.ejb.runtime.CopyHelper {











	/**
	 * Get accessor for persistent attribute: power
	 */
	public java.math.BigDecimal getPower() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: power
	 */
	public void setPower(java.math.BigDecimal newPower)
		throws java.rmi.RemoteException;
}
