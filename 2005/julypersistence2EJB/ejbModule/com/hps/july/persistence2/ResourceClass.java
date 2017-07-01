package com.hps.july.persistence2;
/**
 * Remote interface for Enterprise Bean: ResourceClass
 */
public interface ResourceClass extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {

	/**
	 * Get accessor for persistent attribute: classname
	 */
	public java.lang.String getClassname() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: classname
	 */
	public void setClassname(java.lang.String newClassname)
		throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getClassid() throws java.rmi.RemoteException;
	/**
	 * @param i
	 */
	public void setClassid(int i) throws java.rmi.RemoteException;
}
