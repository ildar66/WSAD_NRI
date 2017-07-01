package com.hps.july.persistence;
/**
 * Remote interface for Enterprise Bean: LeaseResource
 */
public interface LeaseResource extends com.hps.july.persistence.Resource, com.ibm.ivj.ejb.runtime.CopyHelper {









	/**
	 * Get accessor for persistent attribute: needCwAct
	 */
	public boolean isNeedCwAct() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: needCwAct
	 */
	public void setNeedCwAct(boolean newNeedCwAct)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: useInArendaContract
	 */
	public boolean isUseInArendaContract() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: useInArendaContract
	 */
	public void setUseInArendaContract(boolean newUseInArendaContract)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: useInAbonentContract
	 */
	public boolean isUseInAbonentContract() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: useInAbonentContract
	 */
	public void setUseInAbonentContract(boolean newUseInAbonentContract)
		throws java.rmi.RemoteException;
}
