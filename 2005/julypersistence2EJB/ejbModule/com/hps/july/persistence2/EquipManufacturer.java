package com.hps.july.persistence2;
/**
 * Remote interface for Enterprise Bean: EquipManufacturer
 */
public interface EquipManufacturer extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {



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
	 * Get accessor for persistent attribute: shortname
	 */
	public java.lang.String getShortname() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: shortname
	 */
	public void setShortname(java.lang.String newShortname)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: equipcatalog
	 */
	public java.lang.String getEquipcatalog() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: equipcatalog
	 */
	public void setEquipcatalog(java.lang.String newEquipcatalog)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: officialsite
	 */
	public java.lang.String getOfficialsite() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: officialsite
	 */
	public void setOfficialsite(java.lang.String newOfficialsite)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: comment
	 */
	public java.lang.String getComment() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: comment
	 */
	public void setComment(java.lang.String newComment)
		throws java.rmi.RemoteException;
}
