package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * —чет в банке
 */
public class AccountBean implements EntityBean {
	public int account;
	public String accountvalue;
	private javax.ejb.EntityContext entityContext = null;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer organization_organization;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink organizationLink = null;
	public Boolean active = Boolean.TRUE;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leasePayRule4OrgAccLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leasePayOrderLink = null;
	/**
	 * Implementation field for persistent attribute: bank_idBank
	 */
	public java.lang.Integer bank_idBank;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink bankLink;
	/**
	 * Implementation field for persistent attribute: idVendorSite
	 */
	public java.lang.Integer idVendorSite;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("bankKey", getBankKey());
		h.put("active", getActive());
		h.put("account", new Integer(getAccount()));
		h.put("organizationKey", getOrganizationKey());
		h.put("accountvalue", getAccountvalue());
		h.put("idVendorSite", getIdVendorSite());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.Boolean localActive = (java.lang.Boolean) h.get("active");
		Integer localAccount = (Integer) h.get("account");
		java.lang.String localAccountvalue = (java.lang.String) h.get("accountvalue");
		java.lang.Integer localIdVendorSite = (java.lang.Integer) h.get("idVendorSite");

		if (h.containsKey("active"))
			setActive((localActive));
		if (h.containsKey("account"))
			setAccount((localAccount).intValue());
		if (h.containsKey("accountvalue"))
			setAccountvalue((localAccountvalue));
		if (h.containsKey("idVendorSite"))
			setIdVendorSite((localIdVendorSite));
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected java.util.Vector _getLinks() {
		java.util.Vector links = new java.util.Vector();
		links.add(getOrganizationLink());
		links.add(getLeasePayOrderLink());
		links.add(getLeasePayRule4OrgAccLink());
		links.add(getBankLink());
		return links;
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected void _initLinks() {
		organizationLink = null;
		leasePayOrderLink = null;
		leasePayRule4OrgAccLink = null;
		bankLink = null;
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected void _removeLinks() throws java.rmi.RemoteException, javax.ejb.RemoveException {
		java.util.List links = _getLinks();
		for (int i = 0; i < links.size(); i++) {
			try {
				((com.ibm.ivj.ejb.associations.interfaces.Link) links.get(i)).remove();
			} catch (javax.ejb.FinderException e) {
			} //Consume Finder error since I am going away
		}
	}
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeasePayOrder(com.hps.july.persistence.LeasePayOrder aLeasePayOrder) throws java.rmi.RemoteException {
	this.getLeasePayOrderLink().addElement(aLeasePayOrder);
}
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeasePayRule4OrgAcc(com.hps.july.persistence.LeasePayRule aLeasePayRule4OrgAcc) throws java.rmi.RemoteException {
	this.getLeasePayRule4OrgAccLink().addElement(aLeasePayRule4OrgAcc);
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argAccount int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argAccount) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	account = argAccount;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argAccount int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argAccount, Integer argBank, Integer argOrganization, String argName ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	account = argAccount;
	bank_idBank = argBank;
	organization_organization = argOrganization;
	accountvalue = argName;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argAccount int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argAccount, Integer argBank, Integer argOrganization, String argName, Boolean argActive ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	accountvalue = null;
	organization_organization = null;
	bank_idBank = null;
	active = Boolean.TRUE;
	
	account = argAccount;
	bank_idBank = argBank;
	organization_organization = argOrganization;
	accountvalue = argName;
	active = argActive;
}
/**
 * ejbLoad method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbLoad() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbPostCreate method for a CMP entity bean
 * @param argAccount int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argAccount) throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	_removeLinks();
}
/**
 * ejbStore method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbStore() throws java.rmi.RemoteException {}
/**
 * Insert the method's description here.
 * Creation date: (18.04.2002 14:39:38)
 * @return int
 */
public int getAccount() {
	return account;
}
/**
 * Getter method for accountvalue
 * @return java.lang.String
 */
public java.lang.String getAccountvalue() {
	return accountvalue;
}
/**
 * Getter method for active
 */
public java.lang.Boolean getActive() {
	return active;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeasePayOrder() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeasePayOrderLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeasePayOrderLink() {
	if (leasePayOrderLink == null)
		leasePayOrderLink = new AccountToLeasePayOrderLink(this);
	return leasePayOrderLink;
}
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeasePayRule4OrgAcc() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeasePayRule4OrgAccLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeasePayRule4OrgAccLink() {
	if (leasePayRule4OrgAccLink == null)
		leasePayRule4OrgAccLink = new AccountToLeasePayRule4OrgAccLink(this);
	return leasePayRule4OrgAccLink;
}
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getOrganization() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Organization)this.getOrganizationLink().value();
}
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OrganizationKey getOrganizationKey() {
	com.hps.july.persistence.OrganizationKey temp = null;
	temp = new com.hps.july.persistence.OrganizationKey();
	boolean organization_NULLTEST = true;
	organization_NULLTEST &= (organization_organization == null);
	temp.organization = ((organization_organization == null) ? 0 : organization_organization.intValue());
	if (organization_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOrganizationLink() {
	if (organizationLink == null)
		organizationLink = new AccountToOrganizationLink(this);
	return organizationLink;
}
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOrganizationKey(com.hps.july.persistence.OrganizationKey inKey) {
	boolean organization_NULLTEST = (inKey == null);
	if (organization_NULLTEST) organization_organization = null; else organization_organization = (new Integer(inKey.organization));
}
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeLeasePayOrder(com.hps.july.persistence.LeasePayOrder aLeasePayOrder) throws java.rmi.RemoteException {
	this.getLeasePayOrderLink().removeElement(aLeasePayOrder);
}
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeasePayOrder(com.hps.july.persistence.LeasePayOrder aLeasePayOrder) {
	this.getLeasePayOrderLink().secondaryAddElement(aLeasePayOrder);
}
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeasePayRule4OrgAcc(com.hps.july.persistence.LeasePayRule aLeasePayRule4OrgAcc) {
	this.getLeasePayRule4OrgAccLink().secondaryAddElement(aLeasePayRule4OrgAcc);
}
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeasePayOrder(com.hps.july.persistence.LeasePayOrder aLeasePayOrder) {
	this.getLeasePayOrderLink().secondaryRemoveElement(aLeasePayOrder);
}
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeasePayRule4OrgAcc(com.hps.july.persistence.LeasePayRule aLeasePayRule4OrgAcc) {
	this.getLeasePayRule4OrgAccLink().secondaryRemoveElement(aLeasePayRule4OrgAcc);
}
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException {
	this.getOrganizationLink().secondarySet(anOrganization);
}
/**
 * Insert the method's description here.
 * Creation date: (18.04.2002 14:39:38)
 * @param newAccount int
 */
public void setAccount(int newAccount) {
	account = newAccount;
}
/**
 * Setter method for accountvalue
 * @param newValue java.lang.String
 */
public void setAccountvalue(java.lang.String newValue) {
	this.accountvalue = newValue;
}
/**
 * Setter method for active
 */
public void setActive(java.lang.Boolean newValue) {
	this.active = newValue;
}
/**
 * setEntityContext method comment
 * @param ctx javax.ejb.EntityContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setEntityContext(javax.ejb.EntityContext ctx) throws java.rmi.RemoteException {
	entityContext = ctx;
}
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException {
	this.getOrganizationLink().set(anOrganization);
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.persistence.AccountKey ejbCreate(int account, com.hps.july.persistence.Organization argOrganization, com.hps.july.persistence.Bank argBank)
		throws javax.ejb.CreateException {
		_initLinks();
		this.account = account;
		try {
			setOrganization(argOrganization);
			setBank(argBank);
		} catch (java.rmi.RemoteException remoteEx) {
			throw new javax.ejb.CreateException(remoteEx.getMessage());
		}
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int account, com.hps.july.persistence.Organization argOrganization, com.hps.july.persistence.Bank argBank) throws javax.ejb.CreateException {
		try {
			setOrganization(argOrganization);
			setBank(argBank);
		} catch (java.rmi.RemoteException remoteEx) {
			throw new javax.ejb.CreateException(remoteEx.getMessage());
		}
	}
	/**
	 * This method was generated for supporting the relationship role named bank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setBank(com.hps.july.persistence.Bank aBank) throws java.rmi.RemoteException {
		this.getBankLink().set(aBank);
	}
	/**
	 * This method was generated for supporting the relationship role named bank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondarySetBank(com.hps.july.persistence.Bank aBank) throws java.rmi.RemoteException {
		this.getBankLink().secondarySet(aBank);
	}
	/**
	 * This method was generated for supporting the relationship role named bank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getBankLink() {
		if (bankLink == null)
			bankLink = new AccountToBankLink(this);
		return bankLink;
	}
	/**
	 * This method was generated for supporting the relationship role named bank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.lang.Integer getBankKey() {
		return bank_idBank;
	}
	/**
	 * This method was generated for supporting the relationship role named bank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetBankKey(java.lang.Integer inKey) {
		bank_idBank = inKey;
	}
	/**
	 * This method was generated for supporting the relationship role named bank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.hps.july.persistence.Bank getBank() throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.Bank) this.getBankLink().value();
	}
	/**
	 * Get accessor for persistent attribute: idVendorSite
	 */
	public java.lang.Integer getIdVendorSite() {
		return idVendorSite;
	}
	/**
	 * Set accessor for persistent attribute: idVendorSite
	 */
	public void setIdVendorSite(java.lang.Integer newIdVendorSite) {
		idVendorSite = newIdVendorSite;
	}
}
