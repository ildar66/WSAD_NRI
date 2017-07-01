package com.hps.july.config.beans;
/**
 * Bean implementation class for Enterprise Bean: CfgStoragecard
 */
public class CfgStoragecardBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: storagecard
	 */
	public int storagecard;
	/**
	 * Implementation field for persistent attribute: resource
	 */
	public int resource;
	/**
	 * Implementation field for persistent attribute: dateopened
	 */
	public java.sql.Date dateopened;
	/**
	 * Implementation field for persistent attribute: owner
	 */
	public int owner;
	/**
	 * Implementation field for persistent attribute: policy
	 */
	public java.lang.String policy;
	/**
	 * Implementation field for persistent attribute: closed
	 */
	public java.lang.String closed;
	/**
	 * Implementation field for persistent attribute: qty
	 */
	public java.math.BigDecimal qty;
	/**
	 * Implementation field for persistent attribute: price
	 */
	public java.math.BigDecimal price;
	/**
	 * Implementation field for persistent attribute: boxed
	 */
	public java.lang.Boolean boxed;
	/**
	 * Implementation field for persistent attribute: document
	 */
	public java.lang.Integer document;
	/**
	 * Implementation field for persistent attribute: broken
	 */
	public java.lang.Boolean broken;
	/**
	 * Implementation field for persistent attribute: storageplace
	 */
	public java.lang.Integer storageplace;
	/**
	 * Implementation field for persistent attribute: contract
	 */
	public java.lang.Integer contract;
	/**
	 * Implementation field for persistent attribute: dateclosed
	 */
	public java.sql.Date dateclosed;
	/**
	 * Implementation field for persistent attribute: i13ndate
	 */
	public java.sql.Date i13ndate;
	/**
	 * Implementation field for persistent attribute: serialnumber
	 */
	public java.lang.String serialnumber;
	/**
	 * Implementation field for persistent attribute: party
	 */
	public java.lang.String party;
	/**
	 * Implementation field for persistent attribute: qty_broken
	 */
	public java.math.BigDecimal qty_broken;
	/**
	 * Implementation field for persistent attribute: notes
	 */
	public java.lang.String notes;
	/**
	 * Implementation field for persistent attribute: configuration
	 */
	public java.lang.String configuration;
	/**
	 * Implementation field for persistent attribute: place
	 */
	public java.lang.String place;
	/**
	 * Implementation field for persistent attribute: inventserial
	 */
	public java.lang.String inventserial;
	/**
	 * Implementation field for persistent attribute: comment
	 */
	public java.lang.String comment;
	/**
	 * Implementation field for persistent attribute: isfictserial
	 */
	public boolean isfictserial;
	/**
	 * Implementation field for persistent attribute: isapproved
	 */
	public boolean isapproved;
	/**
	 * Implementation field for persistent attribute: localserial
	 */
	public java.lang.String localserial;
	/**
	 * Implementation field for persistent attribute: ObjectStatus
	 */
	public java.lang.String ObjectStatus;
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
	public com.hps.july.config.beans.CfgStoragecardKey ejbCreate(
		int savconfigid,
		int storagecard, int resource, java.sql.Date dateopened,
		int owner, String policy, String closed, 
		java.math.BigDecimal qty, java.math.BigDecimal price,
		boolean isfictserial, boolean isapproved,
		String objectstatus)
		throws javax.ejb.CreateException {
		_initLinks();
		this.savconfigid = savconfigid;
		this.storagecard = storagecard;
		this.resource = resource;
		this.dateopened = dateopened;
		this.owner = owner;
		this.policy = policy;
		this.closed = closed;
		this.qty = qty;
		this.price = price;
		this.isfictserial = isfictserial;
		this.isapproved = isapproved;
		ObjectStatus = objectstatus;
		boxed = null;
		document = null;
		broken = null;
		storageplace = null;
		contract = null;
		dateclosed = null;
		i13ndate = null;
		serialnumber = null;
		party = null;
		qty_broken = null;
		notes = null;
		configuration = null;
		place = null;
		inventserial = null;
		comment = null;
		localserial = null;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int savconfigid, int storagecard)
		throws javax.ejb.CreateException {
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
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected java.util.Vector _getLinks() {
		java.util.Vector links = new java.util.Vector();
		return links;
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected void _removeLinks()
		throws java.rmi.RemoteException, javax.ejb.RemoveException {
		java.util.List links = _getLinks();
		for (int i = 0; i < links.size(); i++) {
			try {
				((com.ibm.ivj.ejb.associations.interfaces.Link) links.get(i))
					.remove();
			} catch (javax.ejb.FinderException e) {
			} //Consume Finder error since I am going away
		}
	}
	/**
	 * Get accessor for persistent attribute: resource
	 */
	public int getResource() {
		return resource;
	}
	/**
	 * Set accessor for persistent attribute: resource
	 */
	public void setResource(int newResource) {
		resource = newResource;
	}
	/**
	 * Get accessor for persistent attribute: dateopened
	 */
	public java.sql.Date getDateopened() {
		return dateopened;
	}
	/**
	 * Set accessor for persistent attribute: dateopened
	 */
	public void setDateopened(java.sql.Date newDateopened) {
		dateopened = newDateopened;
	}
	/**
	 * Get accessor for persistent attribute: owner
	 */
	public int getOwner() {
		return owner;
	}
	/**
	 * Set accessor for persistent attribute: owner
	 */
	public void setOwner(int newOwner) {
		owner = newOwner;
	}
	/**
	 * Get accessor for persistent attribute: policy
	 */
	public java.lang.String getPolicy() {
		return policy;
	}
	/**
	 * Set accessor for persistent attribute: policy
	 */
	public void setPolicy(java.lang.String newPolicy) {
		policy = newPolicy;
	}
	/**
	 * Get accessor for persistent attribute: closed
	 */
	public java.lang.String getClosed() {
		return closed;
	}
	/**
	 * Set accessor for persistent attribute: closed
	 */
	public void setClosed(java.lang.String newClosed) {
		closed = newClosed;
	}
	/**
	 * Get accessor for persistent attribute: qty
	 */
	public java.math.BigDecimal getQty() {
		return qty;
	}
	/**
	 * Set accessor for persistent attribute: qty
	 */
	public void setQty(java.math.BigDecimal newQty) {
		qty = newQty;
	}
	/**
	 * Get accessor for persistent attribute: price
	 */
	public java.math.BigDecimal getPrice() {
		return price;
	}
	/**
	 * Set accessor for persistent attribute: price
	 */
	public void setPrice(java.math.BigDecimal newPrice) {
		price = newPrice;
	}
	/**
	 * Get accessor for persistent attribute: boxed
	 */
	public java.lang.Boolean getBoxed() {
		return boxed;
	}
	/**
	 * Set accessor for persistent attribute: boxed
	 */
	public void setBoxed(java.lang.Boolean newBoxed) {
		boxed = newBoxed;
	}
	/**
	 * Get accessor for persistent attribute: document
	 */
	public java.lang.Integer getDocument() {
		return document;
	}
	/**
	 * Set accessor for persistent attribute: document
	 */
	public void setDocument(java.lang.Integer newDocument) {
		document = newDocument;
	}
	/**
	 * Get accessor for persistent attribute: broken
	 */
	public java.lang.Boolean getBroken() {
		return broken;
	}
	/**
	 * Set accessor for persistent attribute: broken
	 */
	public void setBroken(java.lang.Boolean newBroken) {
		broken = newBroken;
	}
	/**
	 * Get accessor for persistent attribute: storageplace
	 */
	public java.lang.Integer getStorageplace() {
		return storageplace;
	}
	/**
	 * Set accessor for persistent attribute: storageplace
	 */
	public void setStorageplace(java.lang.Integer newStorageplace) {
		storageplace = newStorageplace;
	}
	/**
	 * Get accessor for persistent attribute: contract
	 */
	public java.lang.Integer getContract() {
		return contract;
	}
	/**
	 * Set accessor for persistent attribute: contract
	 */
	public void setContract(java.lang.Integer newContract) {
		contract = newContract;
	}
	/**
	 * Get accessor for persistent attribute: dateclosed
	 */
	public java.sql.Date getDateclosed() {
		return dateclosed;
	}
	/**
	 * Set accessor for persistent attribute: dateclosed
	 */
	public void setDateclosed(java.sql.Date newDateclosed) {
		dateclosed = newDateclosed;
	}
	/**
	 * Get accessor for persistent attribute: i13ndate
	 */
	public java.sql.Date getI13ndate() {
		return i13ndate;
	}
	/**
	 * Set accessor for persistent attribute: i13ndate
	 */
	public void setI13ndate(java.sql.Date newI13ndate) {
		i13ndate = newI13ndate;
	}
	/**
	 * Get accessor for persistent attribute: serialnumber
	 */
	public java.lang.String getSerialnumber() {
		return serialnumber;
	}
	/**
	 * Set accessor for persistent attribute: serialnumber
	 */
	public void setSerialnumber(java.lang.String newSerialnumber) {
		serialnumber = newSerialnumber;
	}
	/**
	 * Get accessor for persistent attribute: party
	 */
	public java.lang.String getParty() {
		return party;
	}
	/**
	 * Set accessor for persistent attribute: party
	 */
	public void setParty(java.lang.String newParty) {
		party = newParty;
	}
	/**
	 * Get accessor for persistent attribute: qty_broken
	 */
	public java.math.BigDecimal getQty_broken() {
		return qty_broken;
	}
	/**
	 * Set accessor for persistent attribute: qty_broken
	 */
	public void setQty_broken(java.math.BigDecimal newQty_broken) {
		qty_broken = newQty_broken;
	}
	/**
	 * Get accessor for persistent attribute: notes
	 */
	public java.lang.String getNotes() {
		return notes;
	}
	/**
	 * Set accessor for persistent attribute: notes
	 */
	public void setNotes(java.lang.String newNotes) {
		notes = newNotes;
	}
	/**
	 * Get accessor for persistent attribute: configuration
	 */
	public java.lang.String getConfiguration() {
		return configuration;
	}
	/**
	 * Set accessor for persistent attribute: configuration
	 */
	public void setConfiguration(java.lang.String newConfiguration) {
		configuration = newConfiguration;
	}
	/**
	 * Get accessor for persistent attribute: place
	 */
	public java.lang.String getPlace() {
		return place;
	}
	/**
	 * Set accessor for persistent attribute: place
	 */
	public void setPlace(java.lang.String newPlace) {
		place = newPlace;
	}
	/**
	 * Get accessor for persistent attribute: inventserial
	 */
	public java.lang.String getInventserial() {
		return inventserial;
	}
	/**
	 * Set accessor for persistent attribute: inventserial
	 */
	public void setInventserial(java.lang.String newInventserial) {
		inventserial = newInventserial;
	}
	/**
	 * Get accessor for persistent attribute: comment
	 */
	public java.lang.String getComment() {
		return comment;
	}
	/**
	 * Set accessor for persistent attribute: comment
	 */
	public void setComment(java.lang.String newComment) {
		comment = newComment;
	}
	/**
	 * Get accessor for persistent attribute: isfictserial
	 */
	public boolean isIsfictserial() {
		return isfictserial;
	}
	/**
	 * Set accessor for persistent attribute: isfictserial
	 */
	public void setIsfictserial(boolean newIsfictserial) {
		isfictserial = newIsfictserial;
	}
	/**
	 * Get accessor for persistent attribute: isapproved
	 */
	public boolean isIsapproved() {
		return isapproved;
	}
	/**
	 * Set accessor for persistent attribute: isapproved
	 */
	public void setIsapproved(boolean newIsapproved) {
		isapproved = newIsapproved;
	}
	/**
	 * Get accessor for persistent attribute: localserial
	 */
	public java.lang.String getLocalserial() {
		return localserial;
	}
	/**
	 * Set accessor for persistent attribute: localserial
	 */
	public void setLocalserial(java.lang.String newLocalserial) {
		localserial = newLocalserial;
	}
	/**
	 * Get accessor for persistent attribute: ObjectStatus
	 */
	public java.lang.String getObjectStatus() {
		return ObjectStatus;
	}
	/**
	 * Set accessor for persistent attribute: ObjectStatus
	 */
	public void setObjectStatus(java.lang.String newObjectStatus) {
		ObjectStatus = newObjectStatus;
	}
	/**
	 * @return
	 */
	public int getSavconfigid() {
		return savconfigid;
	}

	/**
	 * @return
	 */
	public int getStoragecard() {
		return storagecard;
	}

	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("owner", new Integer(getOwner()));
		h.put("i13ndate", getI13ndate());
		h.put("comment", getComment());
		h.put("broken", getBroken());
		h.put("resource", new Integer(getResource()));
		h.put("isapproved", new Boolean(isIsapproved()));
		h.put("dateclosed", getDateclosed());
		h.put("closed", getClosed());
		h.put("storageplace", getStorageplace());
		h.put("serialnumber", getSerialnumber());
		h.put("place", getPlace());
		h.put("qty_broken", getQty_broken());
		h.put("qty", getQty());
		h.put("localserial", getLocalserial());
		h.put("configuration", getConfiguration());
		h.put("notes", getNotes());
		h.put("policy", getPolicy());
		h.put("party", getParty());
		h.put("document", getDocument());
		h.put("boxed", getBoxed());
		h.put("inventserial", getInventserial());
		h.put("contract", getContract());
		h.put("price", getPrice());
		h.put("dateopened", getDateopened());
		h.put("isfictserial", new Boolean(isIsfictserial()));
		h.put("objectStatus", getObjectStatus());
		h.put("savconfigid", new Integer(getSavconfigid()));
		h.put("storagecard", new Integer(getStoragecard()));
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		Integer localOwner = (Integer) h.get("owner");
		java.sql.Date localI13ndate = (java.sql.Date) h.get("i13ndate");
		java.lang.String localComment = (java.lang.String) h.get("comment");
		java.lang.Boolean localBroken = (java.lang.Boolean) h.get("broken");
		Integer localResource = (Integer) h.get("resource");
		Boolean localIsapproved = (Boolean) h.get("isapproved");
		java.sql.Date localDateclosed = (java.sql.Date) h.get("dateclosed");
		java.lang.String localClosed = (java.lang.String) h.get("closed");
		java.lang.Integer localStorageplace =
			(java.lang.Integer) h.get("storageplace");
		java.lang.String localSerialnumber =
			(java.lang.String) h.get("serialnumber");
		java.lang.String localPlace = (java.lang.String) h.get("place");
		java.math.BigDecimal localQty_broken =
			(java.math.BigDecimal) h.get("qty_broken");
		java.math.BigDecimal localQty = (java.math.BigDecimal) h.get("qty");
		java.lang.String localLocalserial =
			(java.lang.String) h.get("localserial");
		java.lang.String localConfiguration =
			(java.lang.String) h.get("configuration");
		java.lang.String localNotes = (java.lang.String) h.get("notes");
		java.lang.String localPolicy = (java.lang.String) h.get("policy");
		java.lang.String localParty = (java.lang.String) h.get("party");
		java.lang.Integer localDocument = (java.lang.Integer) h.get("document");
		java.lang.Boolean localBoxed = (java.lang.Boolean) h.get("boxed");
		java.lang.String localInventserial =
			(java.lang.String) h.get("inventserial");
		java.lang.Integer localContract = (java.lang.Integer) h.get("contract");
		java.math.BigDecimal localPrice = (java.math.BigDecimal) h.get("price");
		java.sql.Date localDateopened = (java.sql.Date) h.get("dateopened");
		Boolean localIsfictserial = (Boolean) h.get("isfictserial");
		java.lang.String localObjectStatus =
			(java.lang.String) h.get("objectStatus");

		if (h.containsKey("owner"))
			setOwner((localOwner).intValue());
		if (h.containsKey("i13ndate"))
			setI13ndate((localI13ndate));
		if (h.containsKey("comment"))
			setComment((localComment));
		if (h.containsKey("broken"))
			setBroken((localBroken));
		if (h.containsKey("resource"))
			setResource((localResource).intValue());
		if (h.containsKey("isapproved"))
			setIsapproved((localIsapproved).booleanValue());
		if (h.containsKey("dateclosed"))
			setDateclosed((localDateclosed));
		if (h.containsKey("closed"))
			setClosed((localClosed));
		if (h.containsKey("storageplace"))
			setStorageplace((localStorageplace));
		if (h.containsKey("serialnumber"))
			setSerialnumber((localSerialnumber));
		if (h.containsKey("place"))
			setPlace((localPlace));
		if (h.containsKey("qty_broken"))
			setQty_broken((localQty_broken));
		if (h.containsKey("qty"))
			setQty((localQty));
		if (h.containsKey("localserial"))
			setLocalserial((localLocalserial));
		if (h.containsKey("configuration"))
			setConfiguration((localConfiguration));
		if (h.containsKey("notes"))
			setNotes((localNotes));
		if (h.containsKey("policy"))
			setPolicy((localPolicy));
		if (h.containsKey("party"))
			setParty((localParty));
		if (h.containsKey("document"))
			setDocument((localDocument));
		if (h.containsKey("boxed"))
			setBoxed((localBoxed));
		if (h.containsKey("inventserial"))
			setInventserial((localInventserial));
		if (h.containsKey("contract"))
			setContract((localContract));
		if (h.containsKey("price"))
			setPrice((localPrice));
		if (h.containsKey("dateopened"))
			setDateopened((localDateopened));
		if (h.containsKey("isfictserial"))
			setIsfictserial((localIsfictserial).booleanValue());
		if (h.containsKey("objectStatus"))
			setObjectStatus((localObjectStatus));
	}
}
