package com.hps.july.persistence;
/**
 * Remote interface for Enterprise Bean: CfgDocument
 */
public interface CfgDocument extends com.hps.july.persistence.Document, com.ibm.ivj.ejb.runtime.CopyHelper {



	/**
	 * Get accessor for persistent attribute: savconfigidold
	 */
	public int getSavconfigidold() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: savconfigidold
	 */
	public void setSavconfigidold(int newSavconfigidold)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: savconfigidnew
	 */
	public int getSavconfigidnew() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: savconfigidnew
	 */
	public void setSavconfigidnew(int newSavconfigidnew)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: storedem
	 */
	public java.lang.Integer getStoredem() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: storedem
	 */
	public void setStoredem(java.lang.Integer newStoredem)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: storebad
	 */
	public java.lang.Integer getStorebad() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: storebad
	 */
	public void setStorebad(java.lang.Integer newStorebad)
		throws java.rmi.RemoteException;
}
