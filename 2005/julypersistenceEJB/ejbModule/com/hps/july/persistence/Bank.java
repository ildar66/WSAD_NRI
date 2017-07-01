package com.hps.july.persistence;
/**
 * Remote interface for Enterprise Bean: Bank
 * 
 */
public interface Bank extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {

	/**
	 * Get accessor for persistent attribute: source
	 */
	public java.lang.Integer getIdBank() throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: name
	 */
	public  java.lang.String getName() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: name
	 */
	public void setName(java.lang.String newName) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: bik
	 */
	public java.lang.String getBik() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: bik
	 */
	public void setBik(java.lang.String newBik) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: koraccount
	 */
	public java.lang.String getKoraccount() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: koraccount
	 */
	public void setKoraccount(java.lang.String newKoraccount) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: legaladdress
	 */
	public java.lang.String getLegaladdress() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: legaladdress
	 */
	public void setLegaladdress(java.lang.String newLegaladdress) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: swift
	 */
	public java.lang.String getSwift() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: swift
	 */
	public void setSwift(java.lang.String newSwift) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: source
	 */
	public java.lang.Integer getSource() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: source
	 */
	public void setSource(java.lang.Integer newSource) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: createdBy
	 */
	public java.lang.Integer getCreatedBy() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: createdBy
	 */
	public void setCreatedBy(java.lang.Integer newCreatedBy) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: created
	 */
	public java.sql.Timestamp getCreated() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: created
	 */
	public void setCreated(java.sql.Timestamp newCreated) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: modifiedBy
	 */
	public java.lang.Integer getModifiedBy() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: modifiedBy
	 */
	public void setModifiedBy(java.lang.Integer newModifiedBy) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: modified
	 */
	public java.sql.Timestamp getModified() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: modified
	 */
	public void setModified(java.sql.Timestamp newModified) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: recordStatus
	 */
	public java.lang.String getRecordStatus() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: recordStatus
	 */
	public void setRecordStatus(java.lang.String newRecordStatus) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named accountinbank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondaryAddAccountinbank(com.hps.july.persistence.Account anAccountinbank) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named accountinbank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondaryRemoveAccountinbank(com.hps.july.persistence.Account anAccountinbank) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named accountinbank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Enumeration getAccountinbank() throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * This method was generated for supporting the relationship role named accountinbank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void addAccountinbank(com.hps.july.persistence.Account anAccountinbank) throws java.rmi.RemoteException;
}
