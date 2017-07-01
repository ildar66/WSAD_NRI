package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Account extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeasePayOrder(com.hps.july.persistence.LeasePayOrder aLeasePayOrder) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeasePayRule4OrgAcc(com.hps.july.persistence.LeasePayRule aLeasePayRule4OrgAcc) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getAccount() throws java.rmi.RemoteException;
/**
 * Getter method for accountvalue
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getAccountvalue() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getActive() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeasePayOrder() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeasePayRule4OrgAcc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getOrganization() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OrganizationKey getOrganizationKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOrganizationKey(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeLeasePayOrder(com.hps.july.persistence.LeasePayOrder aLeasePayOrder) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeasePayOrder(com.hps.july.persistence.LeasePayOrder aLeasePayOrder) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeasePayRule4OrgAcc(com.hps.july.persistence.LeasePayRule aLeasePayRule4OrgAcc) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeasePayOrder(com.hps.july.persistence.LeasePayOrder aLeasePayOrder) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeasePayRule4OrgAcc(com.hps.july.persistence.LeasePayRule aLeasePayRule4OrgAcc) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newAccount int
 * @exception String The exception description.
 */
void setAccount(int newAccount) throws java.rmi.RemoteException;
/**
 * Setter method for accountvalue
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setAccountvalue(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setActive(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named bank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondarySetBank(com.hps.july.persistence.Bank aBank) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named bank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setBank(com.hps.july.persistence.Bank aBank) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named bank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.lang.Integer getBankKey() throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named bank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetBankKey(java.lang.Integer inKey) throws java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named bank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.hps.july.persistence.Bank getBank() throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * Get accessor for persistent attribute: idVendorSite
	 */
	public java.lang.Integer getIdVendorSite() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: idVendorSite
	 */
	public void setIdVendorSite(java.lang.Integer newIdVendorSite) throws java.rmi.RemoteException;
}
