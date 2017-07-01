package com.hps.july.persistence2;
/**
 * Remote interface for Enterprise Bean: ResourceGroup
 */
public interface ResourceGroup extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {



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
	 * Get accessor for persistent attribute: classid
	 */
	public int getClassid() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: classid
	 */
	public void setClassid(int newClassid) throws java.rmi.RemoteException;
}
