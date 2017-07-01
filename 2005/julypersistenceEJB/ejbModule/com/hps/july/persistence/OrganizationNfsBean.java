package com.hps.july.persistence;
/**
 * Bean implementation class for Enterprise Bean: OrganizationNfs
 */
public class OrganizationNfsBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: organization
	 */
	public int organization;
	/**
	 * Implementation field for persistent attribute: inn
	 */
	public java.lang.String inn;
	/**
	 * Implementation field for persistent attribute: kpp
	 */
	public java.lang.String kpp;
	/**
	 * Implementation field for persistent attribute: legaladdress
	 */
	public java.lang.String legaladdress;
	/**
	 * Implementation field for persistent attribute: name
	 */
	public java.lang.String name;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseContractExecutorLink;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseContractCustomerLink;
	/**
	 * Implementation field for persistent attribute: directorinfo
	 */
	public java.lang.String directorinfo;
	/**
	 * Implementation field for persistent attribute: accauntmanagerinfo
	 */
	public java.lang.String accauntmanagerinfo;
	/**
	 * Implementation field for persistent attribute: shortname
	 */
	public java.lang.String shortname;
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.persistence.OrganizationNfsKey ejbCreate(int organization) throws javax.ejb.CreateException {
		_initLinks();
		this.organization = organization;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int organization) throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
		_initLinks();
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
		_initLinks();
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
		try {
			_removeLinks();
		} catch (java.rmi.RemoteException e) {
			throw new javax.ejb.RemoveException(e.getMessage());
		}
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected void _initLinks() {
		leaseContractExecutorLink = null;
		leaseContractCustomerLink = null;
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected java.util.Vector _getLinks() {
		java.util.Vector links = new java.util.Vector();
		links.add(getLeaseContractExecutorLink());
		links.add(getLeaseContractCustomerLink());
		return links;
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
	 * @return int
	 */
	public int getOrganization() {
		return organization;
	}	
	/**
	 * Get accessor for persistent attribute: inn
	 */
	public java.lang.String getInn() {
		return inn;
	}
	/**
	 * Set accessor for persistent attribute: inn
	 */
	public void setInn(java.lang.String newInn) {
		inn = newInn;
	}
	/**
	 * Get accessor for persistent attribute: kpp
	 */
	public java.lang.String getKpp() {
		return kpp;
	}
	/**
	 * Set accessor for persistent attribute: kpp
	 */
	public void setKpp(java.lang.String newKpp) {
		kpp = newKpp;
	}
	/**
	 * Get accessor for persistent attribute: legaladdress
	 */
	public java.lang.String getLegaladdress() {
		return legaladdress;
	}
	/**
	 * Set accessor for persistent attribute: legaladdress
	 */
	public void setLegaladdress(java.lang.String newLegaladdress) {
		legaladdress = newLegaladdress;
	}
	/**
	 * Get accessor for persistent attribute: name
	 */
	public java.lang.String getName() {
		return name;
	}
	/**
	 * Set accessor for persistent attribute: name
	 */
	public void setName(java.lang.String newName) {
		name = newName;
	}
	/**
	 * This method was generated for supporting the relationship role named leaseContractExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondaryAddLeaseContractExecutor(com.hps.july.persistence.LeaseContract aLeaseContractExecutor) throws java.rmi.RemoteException {
		this.getLeaseContractExecutorLink().secondaryAddElement(aLeaseContractExecutor);
	}
	/**
	 * This method was generated for supporting the relationship role named leaseContractExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondaryRemoveLeaseContractExecutor(com.hps.july.persistence.LeaseContract aLeaseContractExecutor) throws java.rmi.RemoteException {
		this.getLeaseContractExecutorLink().secondaryRemoveElement(aLeaseContractExecutor);
	}
	/**
	 * This method was generated for supporting the relationship role named leaseContractExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseContractExecutorLink() {
		if (leaseContractExecutorLink == null)
			leaseContractExecutorLink = new OrganizationNfsToLeaseContractExecutorLink(this);
		return leaseContractExecutorLink;
	}
	/**
	 * This method was generated for supporting the relationship role named leaseContractExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Enumeration getLeaseContractExecutor() throws java.rmi.RemoteException, javax.ejb.FinderException {
		return this.getLeaseContractExecutorLink().enumerationValue();
	}
	/**
	 * This method was generated for supporting the relationship role named leaseContractExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void addLeaseContractExecutor(com.hps.july.persistence.LeaseContract aLeaseContractExecutor) throws java.rmi.RemoteException {
		this.getLeaseContractExecutorLink().addElement(aLeaseContractExecutor);
	}
	/**
	 * This method was generated for supporting the relationship role named leaseContractCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondaryAddLeaseContractCustomer(com.hps.july.persistence.LeaseContract aLeaseContractCustomer) throws java.rmi.RemoteException {
		this.getLeaseContractCustomerLink().secondaryAddElement(aLeaseContractCustomer);
	}
	/**
	 * This method was generated for supporting the relationship role named leaseContractCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondaryRemoveLeaseContractCustomer(com.hps.july.persistence.LeaseContract aLeaseContractCustomer) throws java.rmi.RemoteException {
		this.getLeaseContractCustomerLink().secondaryRemoveElement(aLeaseContractCustomer);
	}
	/**
	 * This method was generated for supporting the relationship role named leaseContractCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseContractCustomerLink() {
		if (leaseContractCustomerLink == null)
			leaseContractCustomerLink = new OrganizationNfsToLeaseContractCustomerLink(this);
		return leaseContractCustomerLink;
	}
	/**
	 * This method was generated for supporting the relationship role named leaseContractCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Enumeration getLeaseContractCustomer() throws java.rmi.RemoteException, javax.ejb.FinderException {
		return this.getLeaseContractCustomerLink().enumerationValue();
	}
	/**
	 * This method was generated for supporting the relationship role named leaseContractCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void addLeaseContractCustomer(com.hps.july.persistence.LeaseContract aLeaseContractCustomer) throws java.rmi.RemoteException {
		this.getLeaseContractCustomerLink().addElement(aLeaseContractCustomer);
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("legaladdress", getLegaladdress());
		h.put("kpp", getKpp());
		h.put("name", getName());
		h.put("inn", getInn());
		h.put("organization", new Integer(getOrganization()));
		h.put("directorinfo", getDirectorinfo());
		h.put("shortname", getShortname());
		h.put("accauntmanagerinfo", getAccauntmanagerinfo());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localLegaladdress = (java.lang.String) h.get("legaladdress");
		java.lang.String localKpp = (java.lang.String) h.get("kpp");
		java.lang.String localName = (java.lang.String) h.get("name");
		java.lang.String localInn = (java.lang.String) h.get("inn");
		java.lang.String localDirectorinfo = (java.lang.String) h.get("directorinfo");
		java.lang.String localShortname = (java.lang.String) h.get("shortname");
		java.lang.String localAccauntmanagerinfo = (java.lang.String) h.get("accauntmanagerinfo");

		if (h.containsKey("legaladdress"))
			setLegaladdress((localLegaladdress));
		if (h.containsKey("kpp"))
			setKpp((localKpp));
		if (h.containsKey("name"))
			setName((localName));
		if (h.containsKey("inn"))
			setInn((localInn));
		if (h.containsKey("directorinfo"))
			setDirectorinfo((localDirectorinfo));
		if (h.containsKey("shortname"))
			setShortname((localShortname));
		if (h.containsKey("accauntmanagerinfo"))
			setAccauntmanagerinfo((localAccauntmanagerinfo));
	}
	/**
	 * Get accessor for persistent attribute: directorinfo
	 */
	public java.lang.String getDirectorinfo() {
		return directorinfo;
	}
	/**
	 * Set accessor for persistent attribute: directorinfo
	 */
	public void setDirectorinfo(java.lang.String newDirectorinfo) {
		directorinfo = newDirectorinfo;
	}
	/**
	 * Get accessor for persistent attribute: accauntmanagerinfo
	 */
	public java.lang.String getAccauntmanagerinfo() {
		return accauntmanagerinfo;
	}
	/**
	 * Set accessor for persistent attribute: accauntmanagerinfo
	 */
	public void setAccauntmanagerinfo(java.lang.String newAccauntmanagerinfo) {
		accauntmanagerinfo = newAccauntmanagerinfo;
	}
	/**
	 * Get accessor for persistent attribute: shortname
	 */
	public java.lang.String getShortname() {
		return shortname;
	}
	/**
	 * Set accessor for persistent attribute: shortname
	 */
	public void setShortname(java.lang.String newShortname) {
		shortname = newShortname;
	}
}
