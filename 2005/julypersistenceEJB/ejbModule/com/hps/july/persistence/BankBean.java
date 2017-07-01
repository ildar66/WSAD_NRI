package com.hps.july.persistence;
/**
 * Bean implementation class for Enterprise Bean: Bank
 * 
 */
public class BankBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: idBank
	 */
	public java.lang.Integer idBank;
	/**
	 * Implementation field for persistent attribute: name
	 */
	public java.lang.String name;
	/**
	 * Implementation field for persistent attribute: bik
	 */
	public java.lang.String bik;
	/**
	 * Implementation field for persistent attribute: koraccount
	 */
	public java.lang.String koraccount;
	/**
	 * Implementation field for persistent attribute: legaladdress
	 */
	public java.lang.String legaladdress;
	/**
	 * Implementation field for persistent attribute: swift
	 */
	public java.lang.String swift;
	/**
	 * Implementation field for persistent attribute: source
	 */
	public java.lang.Integer source;
	/**
	 * Implementation field for persistent attribute: createdBy
	 */
	public java.lang.Integer createdBy;
	/**
	 * Implementation field for persistent attribute: created
	 */
	public java.sql.Timestamp created;
	/**
	 * Implementation field for persistent attribute: modifiedBy
	 */
	public java.lang.Integer modifiedBy;
	/**
	 * Implementation field for persistent attribute: modified
	 */
	public java.sql.Timestamp modified;
	/**
	 * Implementation field for persistent attribute: recordStatus
	 */
	public java.lang.String recordStatus;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink accountinbankLink;
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
	public java.lang.Integer ejbCreate(java.lang.Integer idBank) throws javax.ejb.CreateException {
		_initLinks();
		this.idBank = idBank;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer idBank) throws javax.ejb.CreateException {
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
		accountinbankLink = null;
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected java.util.Vector _getLinks() {
		java.util.Vector links = new java.util.Vector();
		links.add(getAccountinbankLink());
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
	 * Get accessor for persistent attribute: bik
	 */
	public java.lang.String getBik() {
		return bik;
	}
	/**
	 * Set accessor for persistent attribute: bik
	 */
	public void setBik(java.lang.String newBik) {
		bik = newBik;
	}
	/**
	 * Get accessor for persistent attribute: koraccount
	 */
	public java.lang.String getKoraccount() {
		return koraccount;
	}
	/**
	 * Set accessor for persistent attribute: koraccount
	 */
	public void setKoraccount(java.lang.String newKoraccount) {
		koraccount = newKoraccount;
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
	 * Get accessor for persistent attribute: swift
	 */
	public java.lang.String getSwift() {
		return swift;
	}
	/**
	 * Set accessor for persistent attribute: swift
	 */
	public void setSwift(java.lang.String newSwift) {
		swift = newSwift;
	}
	/**
	 * Get accessor for persistent attribute: source
	 */
	public java.lang.Integer getSource() {
		return source;
	}
	/**
	 * Set accessor for persistent attribute: source
	 */
	public void setSource(java.lang.Integer newSource) {
		source = newSource;
	}
	/**
	 * Get accessor for persistent attribute: createdBy
	 */
	public java.lang.Integer getCreatedBy() {
		return createdBy;
	}
	/**
	 * Set accessor for persistent attribute: createdBy
	 */
	public void setCreatedBy(java.lang.Integer newCreatedBy) {
		createdBy = newCreatedBy;
	}
	/**
	 * Get accessor for persistent attribute: created
	 */
	public java.sql.Timestamp getCreated() {
		return created;
	}
	/**
	 * Set accessor for persistent attribute: created
	 */
	public void setCreated(java.sql.Timestamp newCreated) {
		created = newCreated;
	}
	/**
	 * Get accessor for persistent attribute: modifiedBy
	 */
	public java.lang.Integer getModifiedBy() {
		return modifiedBy;
	}
	/**
	 * Set accessor for persistent attribute: modifiedBy
	 */
	public void setModifiedBy(java.lang.Integer newModifiedBy) {
		modifiedBy = newModifiedBy;
	}
	/**
	 * Get accessor for persistent attribute: modified
	 */
	public java.sql.Timestamp getModified() {
		return modified;
	}
	/**
	 * Set accessor for persistent attribute: modified
	 */
	public void setModified(java.sql.Timestamp newModified) {
		modified = newModified;
	}
	/**
	 * Get accessor for persistent attribute: recordStatus
	 */
	public java.lang.String getRecordStatus() {
		return recordStatus;
	}
	/**
	 * Set accessor for persistent attribute: recordStatus
	 */
	public void setRecordStatus(java.lang.String newRecordStatus) {
		recordStatus = newRecordStatus;
	}
	/**
	 * This method was generated for supporting the relationship role named accountinbank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondaryAddAccountinbank(com.hps.july.persistence.Account anAccountinbank) throws java.rmi.RemoteException {
		this.getAccountinbankLink().secondaryAddElement(anAccountinbank);
	}
	/**
	 * This method was generated for supporting the relationship role named accountinbank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondaryRemoveAccountinbank(com.hps.july.persistence.Account anAccountinbank) throws java.rmi.RemoteException {
		this.getAccountinbankLink().secondaryRemoveElement(anAccountinbank);
	}
	/**
	 * This method was generated for supporting the relationship role named accountinbank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAccountinbankLink() {
		if (accountinbankLink == null)
			accountinbankLink = new BankToAccountinbankLink(this);
		return accountinbankLink;
	}
	/**
	 * This method was generated for supporting the relationship role named accountinbank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Enumeration getAccountinbank() throws java.rmi.RemoteException, javax.ejb.FinderException {
		return this.getAccountinbankLink().enumerationValue();
	}
	/**
	 * This method was generated for supporting the relationship role named accountinbank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void addAccountinbank(com.hps.july.persistence.Account anAccountinbank) throws java.rmi.RemoteException {
		this.getAccountinbankLink().addElement(anAccountinbank);
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("source", getSource());
		h.put("createdBy", getCreatedBy());
		h.put("name", getName());
		h.put("modifiedBy", getModifiedBy());
		h.put("bik", getBik());
		h.put("swift", getSwift());
		h.put("created", getCreated());
		h.put("recordStatus", getRecordStatus());
		h.put("modified", getModified());
		h.put("koraccount", getKoraccount());
		h.put("legaladdress", getLegaladdress());
		h.put("idBank", getIdBank());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.Integer localSource = (java.lang.Integer) h.get("source");
		java.lang.Integer localCreatedBy =
			(java.lang.Integer) h.get("createdBy");
		java.lang.String localName = (java.lang.String) h.get("name");
		java.lang.Integer localModifiedBy =
			(java.lang.Integer) h.get("modifiedBy");
		java.lang.String localBik = (java.lang.String) h.get("bik");
		java.lang.String localSwift = (java.lang.String) h.get("swift");
		java.sql.Timestamp localCreated = (java.sql.Timestamp) h.get("created");
		java.lang.String localRecordStatus =
			(java.lang.String) h.get("recordStatus");
		java.sql.Timestamp localModified =
			(java.sql.Timestamp) h.get("modified");
		java.lang.String localKoraccount =
			(java.lang.String) h.get("koraccount");
		java.lang.String localLegaladdress =
			(java.lang.String) h.get("legaladdress");

		if (h.containsKey("source"))
			setSource((localSource));
		if (h.containsKey("createdBy"))
			setCreatedBy((localCreatedBy));
		if (h.containsKey("name"))
			setName((localName));
		if (h.containsKey("modifiedBy"))
			setModifiedBy((localModifiedBy));
		if (h.containsKey("bik"))
			setBik((localBik));
		if (h.containsKey("swift"))
			setSwift((localSwift));
		if (h.containsKey("created"))
			setCreated((localCreated));
		if (h.containsKey("recordStatus"))
			setRecordStatus((localRecordStatus));
		if (h.containsKey("modified"))
			setModified((localModified));
		if (h.containsKey("koraccount"))
			setKoraccount((localKoraccount));
		if (h.containsKey("legaladdress"))
			setLegaladdress((localLegaladdress));
	}
	/**
	 * @return
	 */
	public java.lang.Integer getIdBank() {
		return idBank;
	}

}
