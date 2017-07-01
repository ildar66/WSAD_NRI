package com.hps.july.persistence2;
/**
 * Remote interface for Enterprise Bean: Group2Resource
 */
public interface Group2Resource extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {

	/**
	 * Get accessor for persistent attribute: qty
	 */
	public java.math.BigDecimal getQty() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: qty
	 */
	public void setQty(java.math.BigDecimal newQty)
		throws java.rmi.RemoteException;
}
