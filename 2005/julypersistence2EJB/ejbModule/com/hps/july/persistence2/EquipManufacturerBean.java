package com.hps.july.persistence2;
/**
 * Bean implementation class for Enterprise Bean: EquipManufacturer
 */
public class EquipManufacturerBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: manufid
	 */
	public java.lang.Integer manufid;
	/**
	 * Implementation field for persistent attribute: name
	 */
	public java.lang.String name;
	/**
	 * Implementation field for persistent attribute: shortname
	 */
	public java.lang.String shortname;
	/**
	 * Implementation field for persistent attribute: equipcatalog
	 */
	public java.lang.String equipcatalog;
	/**
	 * Implementation field for persistent attribute: officialsite
	 */
	public java.lang.String officialsite;
	/**
	 * Implementation field for persistent attribute: comment
	 */
	public java.lang.String comment;
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
	public java.lang.Integer ejbCreate(
		java.lang.Integer manufid,
		String name,
		String shortname
	)throws javax.ejb.CreateException {
		_initLinks();
		this.manufid = manufid;
		this.name = name;
		this.shortname = shortname;
		this.equipcatalog = null;
		this.officialsite = null;
		this.comment = null;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer manufid)
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
	/**
	 * Get accessor for persistent attribute: equipcatalog
	 */
	public java.lang.String getEquipcatalog() {
		return equipcatalog;
	}
	/**
	 * Set accessor for persistent attribute: equipcatalog
	 */
	public void setEquipcatalog(java.lang.String newEquipcatalog) {
		equipcatalog = newEquipcatalog;
	}
	/**
	 * Get accessor for persistent attribute: officialsite
	 */
	public java.lang.String getOfficialsite() {
		return officialsite;
	}
	/**
	 * Set accessor for persistent attribute: officialsite
	 */
	public void setOfficialsite(java.lang.String newOfficialsite) {
		officialsite = newOfficialsite;
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
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("shortname", getShortname());
		h.put("name", getName());
		h.put("equipcatalog", getEquipcatalog());
		h.put("officialsite", getOfficialsite());
		h.put("comment", getComment());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localShortname = (java.lang.String) h.get("shortname");
		java.lang.String localName = (java.lang.String) h.get("name");
		java.lang.String localEquipcatalog =
			(java.lang.String) h.get("equipcatalog");
		java.lang.String localOfficialsite =
			(java.lang.String) h.get("officialsite");
		java.lang.String localComment = (java.lang.String) h.get("comment");

		if (h.containsKey("shortname"))
			setShortname((localShortname));
		if (h.containsKey("name"))
			setName((localName));
		if (h.containsKey("equipcatalog"))
			setEquipcatalog((localEquipcatalog));
		if (h.containsKey("officialsite"))
			setOfficialsite((localOfficialsite));
		if (h.containsKey("comment"))
			setComment((localComment));
	}
}
