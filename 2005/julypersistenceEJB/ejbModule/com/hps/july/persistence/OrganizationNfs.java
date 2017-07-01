package com.hps.july.persistence;
/**
 * Remote interface for Enterprise Bean: OrganizationNfs
 */
public interface OrganizationNfs extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {

	/**
	 * Get accessor for persistent attribute: inn
	 */
	public java.lang.String getInn() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: inn
	 */
	public void setInn(java.lang.String newInn) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: kpp
	 */
	public java.lang.String getKpp() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: kpp
	 */
	public void setKpp(java.lang.String newKpp) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: legaladdress
	 */
	public java.lang.String getLegaladdress() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: legaladdress
	 */
	public void setLegaladdress(java.lang.String newLegaladdress) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: name
	 */
	public java.lang.String getName() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: name
	 */
	public void setName(java.lang.String newName) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named leaseContractExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondaryAddLeaseContractExecutor(com.hps.july.persistence.LeaseContract aLeaseContractExecutor) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named leaseContractExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondaryRemoveLeaseContractExecutor(com.hps.july.persistence.LeaseContract aLeaseContractExecutor) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named leaseContractExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Enumeration getLeaseContractExecutor() throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * This method was generated for supporting the relationship role named leaseContractExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void addLeaseContractExecutor(com.hps.july.persistence.LeaseContract aLeaseContractExecutor) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named leaseContractCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondaryAddLeaseContractCustomer(com.hps.july.persistence.LeaseContract aLeaseContractCustomer) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named leaseContractCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondaryRemoveLeaseContractCustomer(com.hps.july.persistence.LeaseContract aLeaseContractCustomer) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named leaseContractCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Enumeration getLeaseContractCustomer() throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * This method was generated for supporting the relationship role named leaseContractCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void addLeaseContractCustomer(com.hps.july.persistence.LeaseContract aLeaseContractCustomer) throws java.rmi.RemoteException;
	/**
	 * @return int
	 */
	public int getOrganization() throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: directorinfo
	 */
	public java.lang.String getDirectorinfo() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: directorinfo
	 */
	public void setDirectorinfo(java.lang.String newDirectorinfo) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: accauntmanagerinfo
	 */
	public java.lang.String getAccauntmanagerinfo() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: accauntmanagerinfo
	 */
	public void setAccauntmanagerinfo(java.lang.String newAccauntmanagerinfo) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: shortname
	 */
	public java.lang.String getShortname() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: shortname
	 */
	public void setShortname(java.lang.String newShortname) throws java.rmi.RemoteException;
}
