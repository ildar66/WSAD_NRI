package com.hps.july.config.beans;
/**
 * Remote interface for Enterprise Bean: CfgAntennaWorkBand
 */
public interface CfgAntennaWorkBand extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {

	/**
	 * Get accessor for persistent attribute: electricangle
	 */
	public java.math.BigDecimal getElectricangle()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: electricangle
	 */
	public void setElectricangle(java.math.BigDecimal newElectricangle)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: kind_ant
	 */
	public java.lang.String getKind_ant() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: kind_ant
	 */
	public void setKind_ant(java.lang.String newKind_ant)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: kswn
	 */
	public java.math.BigDecimal getKswn() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: kswn
	 */
	public void setKswn(java.math.BigDecimal newKswn)
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
}
