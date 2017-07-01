package com.hps.july.config.beans;
/**
 * Bean implementation class for Enterprise Bean: CfgTrx
 */
public class CfgTrxBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: trxid
	 */
	public int trxid;
	/**
	 * Implementation field for persistent attribute: resource
	 */
	public int resource;
	/**
	 * Implementation field for persistent attribute: standid
	 */
	public int standid;
	/**
	 * Implementation field for persistent attribute: storagecard
	 */
	public java.lang.Integer storagecard;
	/**
	 * Implementation field for persistent attribute: qty
	 */
	public java.math.BigDecimal qty;
	/**
	 * Implementation field for persistent attribute: objectstatus
	 */
	public java.lang.String objectstatus;
	/**
	 * Implementation field for persistent attribute: equipment
	 */
	public int equipment;
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
	public com.hps.july.config.beans.CfgTrxKey ejbCreate(
		int argSavconfigid, int argEquipment, int argTrxid, 
		int argResource, int argStandid, String argObjectstatus)
			throws javax.ejb.CreateException {
		_initLinks();
		savconfigid = argSavconfigid;
		equipment = argEquipment;
		trxid = argTrxid;
		resource = argResource;
		standid = argStandid;
		objectstatus = argObjectstatus;
		storagecard = null;
		qty = null;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int savconfigid, int trxid)
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
	 * Get accessor for persistent attribute: standid
	 */
	public int getStandid() {
		return standid;
	}
	/**
	 * Set accessor for persistent attribute: standid
	 */
	public void setStandid(int newStandid) {
		standid = newStandid;
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
	 * Get accessor for persistent attribute: objectstatus
	 */
	public java.lang.String getObjectstatus() {
		return objectstatus;
	}
	/**
	 * Set accessor for persistent attribute: objectstatus
	 */
	public void setObjectstatus(java.lang.String newObjectstatus) {
		objectstatus = newObjectstatus;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("objectstatus", getObjectstatus());
		h.put("storagecard", getStoragecard());
		h.put("resource", new Integer(getResource()));
		h.put("standid", new Integer(getStandid()));
		h.put("qty", getQty());
		h.put("trxid", new Integer(getTrxid()));
		h.put("savconfigid", new Integer(getSavconfigid()));
		h.put("equipment", new Integer(getEquipment()));
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localObjectstatus =
			(java.lang.String) h.get("objectstatus");
		java.lang.Integer localStoragecard =
			(java.lang.Integer) h.get("storagecard");
		Integer localResource = (Integer) h.get("resource");
		Integer localStandid = (Integer) h.get("standid");
		java.math.BigDecimal localQty = (java.math.BigDecimal) h.get("qty");
		Integer localEquipment = (Integer) h.get("equipment");

		if (h.containsKey("objectstatus"))
			setObjectstatus((localObjectstatus));
		if (h.containsKey("storagecard"))
			setStoragecard((localStoragecard));
		if (h.containsKey("resource"))
			setResource((localResource).intValue());
		if (h.containsKey("standid"))
			setStandid((localStandid).intValue());
		if (h.containsKey("qty"))
			setQty((localQty));
		if (h.containsKey("equipment"))
			setEquipment((localEquipment).intValue());
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
	public int getTrxid() {
		return trxid;
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
}
