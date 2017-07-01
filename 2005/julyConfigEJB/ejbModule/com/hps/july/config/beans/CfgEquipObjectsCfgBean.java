package com.hps.july.config.beans;
/**
 * Bean implementation class for Enterprise Bean: CfgEquipObjectsCfg
 */
public class CfgEquipObjectsCfgBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: objcfgid
	 */
	public int objcfgid;
	/**
	 * Implementation field for persistent attribute: equipment
	 */
	public int equipment;
	/**
	 * Implementation field for persistent attribute: storagecard
	 */
	public java.lang.Integer storagecard;
	/**
	 * Implementation field for persistent attribute: qty
	 */
	public java.math.BigDecimal qty;
	/**
	 * Implementation field for persistent attribute: ObjectStatus
	 */
	public java.lang.String ObjectStatus;
	/**
	 * Implementation field for persistent attribute: parentobjcfgid
	 */
	public java.lang.Integer parentobjcfgid;
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
	public com.hps.july.config.beans.CfgEquipObjectsCfgKey ejbCreate(
		int savconfigid,
		int objcfgid,
		int equipment,
		String objectstatus)
		throws javax.ejb.CreateException {
		_initLinks();
		this.savconfigid = savconfigid;
		this.objcfgid = objcfgid;
		this.equipment = equipment;
		ObjectStatus = objectstatus;
		this.storagecard = null;
		qty = null;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int savconfigid, int objcfgid)
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
	 * Get accessor for persistent attribute: equipment
	 */
	public int getEquipment() {
		return equipment;
	}
	/**
	 * Set accessor for persistent attribute: equipment
	 */
	public void setEquipment(int newEquipment) {
		equipment = newEquipment;
	}
	/**
	 * Get accessor for persistent attribute: storagecard
	 */
	public java.lang.Integer getStoragecard() {
		return storagecard;
	}
	/**
	 * Set accessor for persistent attribute: storagecard
	 */
	public void setStoragecard(java.lang.Integer newStoragecard) {
		storagecard = newStoragecard;
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
	public int getObjcfgid() {
		return objcfgid;
	}

	/**
	 * @return
	 */
	public int getSavconfigid() {
		return savconfigid;
	}

	/**
	 * Get accessor for persistent attribute: parentobjcfgid
	 */
	public java.lang.Integer getParentobjcfgid() {
		return parentobjcfgid;
	}
	/**
	 * Set accessor for persistent attribute: parentobjcfgid
	 */
	public void setParentobjcfgid(java.lang.Integer newParentobjcfgid) {
		parentobjcfgid = newParentobjcfgid;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("objectStatus", getObjectStatus());
		h.put("parentobjcfgid", getParentobjcfgid());
		h.put("savconfigid", new Integer(getSavconfigid()));
		h.put("equipment", new Integer(getEquipment()));
		h.put("objcfgid", new Integer(getObjcfgid()));
		h.put("storagecard", getStoragecard());
		h.put("qty", getQty());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localObjectStatus =
			(java.lang.String) h.get("objectStatus");
		java.lang.Integer localParentobjcfgid =
			(java.lang.Integer) h.get("parentobjcfgid");
		Integer localEquipment = (Integer) h.get("equipment");
		java.lang.Integer localStoragecard =
			(java.lang.Integer) h.get("storagecard");
		java.math.BigDecimal localQty = (java.math.BigDecimal) h.get("qty");

		if (h.containsKey("objectStatus"))
			setObjectStatus((localObjectStatus));
		if (h.containsKey("parentobjcfgid"))
			setParentobjcfgid((localParentobjcfgid));
		if (h.containsKey("equipment"))
			setEquipment((localEquipment).intValue());
		if (h.containsKey("storagecard"))
			setStoragecard((localStoragecard));
		if (h.containsKey("qty"))
			setQty((localQty));
	}
}
