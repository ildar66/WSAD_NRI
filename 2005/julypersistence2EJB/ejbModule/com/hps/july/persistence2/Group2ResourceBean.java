package com.hps.july.persistence2;
/**
 * Bean implementation class for Enterprise Bean: Group2Resource
 */
public class Group2ResourceBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: groupid
	 */
	public int groupid;
	/**
	 * Implementation field for persistent attribute: resource
	 */
	public int resource;
	/**
	 * Implementation field for persistent attribute: qty
	 */
	public java.math.BigDecimal qty;
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
	public com.hps.july.persistence2.Group2ResourceKey ejbCreate(
		int groupid,
		int resource,
		java.math.BigDecimal qty)
		throws javax.ejb.CreateException {
		_initLinks();
		this.groupid = groupid;
		this.resource = resource;
		this.qty = qty; 
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int groupid, int resource)
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
	 * @return
	 */
	public int getGroupid() {
		return groupid;
	}

	/**
	 * @return
	 */
	public int getResource() {
		return resource;
	}

	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("groupid", new Integer(getGroupid()));
		h.put("resource", new Integer(getResource()));
		h.put("qty", getQty());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.math.BigDecimal localQty = (java.math.BigDecimal) h.get("qty");

		if (h.containsKey("qty"))
			setQty((localQty));
	}
}
