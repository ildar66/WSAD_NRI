package com.hps.july.config.beans;
/**
 * Bean implementation class for Enterprise Bean: CfgEquipObjCfg2Sector
 */
public class CfgEquipObjCfg2SectorBean implements javax.ejb.EntityBean {
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
	 * Implementation field for persistent attribute: id_sect
	 */
	public int id_sect;
	/**
	 * Implementation field for persistent attribute: objectstatus
	 */
	public java.lang.String objectstatus;
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
	public com.hps.july.config.beans.CfgEquipObjCfg2SectorKey ejbCreate(
		int savconfigid,
		int objcfgid,
		int id_sect,
		String objectStatus)
		throws javax.ejb.CreateException {
		_initLinks();
		this.savconfigid = savconfigid;
		this.objcfgid = objcfgid;
		this.id_sect = id_sect;
		this.objectstatus = objectStatus;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int savconfigid, int objcfgid, int id_sect)
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
	 * @return
	 */
	public int getId_sect() {
		return id_sect;
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
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("id_sect", new Integer(getId_sect()));
		h.put("objectstatus", getObjectstatus());
		h.put("savconfigid", new Integer(getSavconfigid()));
		h.put("objcfgid", new Integer(getObjcfgid()));
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localObjectstatus =
			(java.lang.String) h.get("objectstatus");

		if (h.containsKey("objectstatus"))
			setObjectstatus((localObjectstatus));
	}
}
