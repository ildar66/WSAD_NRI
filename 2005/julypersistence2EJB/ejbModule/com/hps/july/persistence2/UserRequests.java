package com.hps.july.persistence2;
/**
 * Remote interface for Enterprise Bean: UserRequests
 */
public interface UserRequests extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {



	/**
	 * Get accessor for persistent attribute: datetimein
	 */
	public java.sql.Date getDatetimein() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: datetimein
	 */
	public void setDatetimein(java.sql.Date newDatetimein)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: requesttype
	 */
	public int getRequesttype() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: requesttype
	 */
	public void setRequesttype(int newRequesttype)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: filialtype
	 */
	public int getFilialtype() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: filialtype
	 */
	public void setFilialtype(int newFilialtype)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: module
	 */
	public int getModule() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: module
	 */
	public void setModule(int newModule) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: description
	 */
	public java.lang.String getDescription() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: description
	 */
	public void setDescription(java.lang.String newDescription)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: status
	 */
	public java.lang.String getStatus() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: status
	 */
	public void setStatus(java.lang.String newStatus)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: rfcnum
	 */
	public java.lang.String getRfcnum() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: rfcnum
	 */
	public void setRfcnum(java.lang.String newRfcnum)
		throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getRequest() throws java.rmi.RemoteException;
	/**
	 * @param i
	 */
	public void setRequest(int i) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: regionid
	 */
	public java.lang.Integer getRegionid() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: regionid
	 */
	public void setRegionid(java.lang.Integer newRegionid)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: supregid
	 */
	public java.lang.Integer getSupregid() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: supregid
	 */
	public void setSupregid(java.lang.Integer newSupregid)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: worker
	 */
	public int getWorker() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: worker
	 */
	public void setWorker(int newWorker) throws java.rmi.RemoteException;
}
