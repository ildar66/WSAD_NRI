package com.hps.july.persistence2;
/**
 * Remote interface for Enterprise Bean: Country
 */
public interface Country extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {

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
	 * Get accessor for persistent attribute: ccode
	 */
	public java.math.BigDecimal getCcode() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: ccode
	 */
	public void setCcode(java.math.BigDecimal newCcode)
		throws java.rmi.RemoteException;
}
