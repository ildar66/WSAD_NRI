package com.hps.july.persistence;
/**
 * Remote interface for Enterprise Bean: TRXResource
 */
public interface TRXResource extends com.hps.july.persistence.Resource, com.ibm.ivj.ejb.runtime.CopyHelper {











	/**
	 * Get accessor for persistent attribute: band
	 */
	public java.lang.Short getBand() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: band
	 */
	public void setBand(java.lang.Short newBand)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: doubletrx
	 */
	public java.lang.Boolean getDoubletrx() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: doubletrx
	 */
	public void setDoubletrx(java.lang.Boolean newDoubletrx)
		throws java.rmi.RemoteException;
}
