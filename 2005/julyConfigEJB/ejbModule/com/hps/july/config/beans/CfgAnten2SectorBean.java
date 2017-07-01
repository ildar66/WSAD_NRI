package com.hps.july.config.beans;
/**
 * Bean implementation class for Enterprise Bean: CfgAnten2Sector
 */
public class CfgAnten2SectorBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: id_anten
	 */
	public int id_anten;
	/**
	 * Implementation field for persistent attribute: id_sect
	 */
	public int id_sect;
	/**
	 * Implementation field for persistent attribute: datasource
	 */
	public java.lang.Integer datasource;
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
	public com.hps.july.config.beans.CfgAnten2SectorKey ejbCreate(
		int savconfigid,
		int id_anten,
		int id_sect, int datasource, String objectStatus)
		throws javax.ejb.CreateException {
		_initLinks();
		this.savconfigid = savconfigid;
		this.id_anten = id_anten;
		this.id_sect = id_sect;
		this.datasource = new Integer(datasource);
		this.ObjectStatus = objectStatus;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int savconfigid, int id_anten, int id_sect)
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
	 * Get accessor for persistent attribute: datasource
	 */
	public java.lang.Integer getDatasource() {
		return datasource;
	}
	/**
	 * Set accessor for persistent attribute: datasource
	 */
	public void setDatasource(java.lang.Integer newDatasource) {
		datasource = newDatasource;
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
	public int getId_anten() {
		return id_anten;
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
		h.put("datasource", getDatasource());
		h.put("objectStatus", getObjectStatus());
		h.put("savconfigid", new Integer(getSavconfigid()));
		h.put("id_anten", new Integer(getId_anten()));
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.Integer localDatasource =
			(java.lang.Integer) h.get("datasource");
		java.lang.String localObjectStatus =
			(java.lang.String) h.get("objectStatus");

		if (h.containsKey("datasource"))
			setDatasource((localDatasource));
		if (h.containsKey("objectStatus"))
			setObjectStatus((localObjectStatus));
	}
}
