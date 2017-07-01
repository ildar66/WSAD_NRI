package com.hps.july.config.beans;
/**
 * Bean implementation class for Enterprise Bean: CfgAntennaCable
 */
public class CfgAntennaCableBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: idCable
	 */
	public int idCable;
	/**
	 * Implementation field for persistent attribute: id_anten
	 */
	public int id_anten;
	/**
	 * Implementation field for persistent attribute: lenCable
	 */
	public java.math.BigDecimal lenCable;
	/**
	 * Implementation field for persistent attribute: cableres
	 */
	public int cableres;
	/**
	 * Implementation field for persistent attribute: groundresource
	 */
	public java.lang.Integer groundresource;
	/**
	 * Implementation field for persistent attribute: groundcnt
	 */
	public java.lang.Integer groundcnt;
	/**
	 * Implementation field for persistent attribute: storagecard
	 */
	public java.lang.Integer storagecard;
	/**
	 * Implementation field for persistent attribute: qty
	 */
	public java.math.BigDecimal qty;
	/**
	 * Implementation field for persistent attribute: datasource
	 */
	public int datasource;
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
	public com.hps.july.config.beans.CfgAntennaCableKey ejbCreate(
		int argSavconfigid, int argIdCable, int argIdAnten, 
		int argCableres, java.math.BigDecimal argCableLen, int argDataSource, String argObjectStatus)
		throws javax.ejb.CreateException {
		_initLinks();
		this.savconfigid = argSavconfigid;
		this.idCable = argIdCable;
		id_anten = argIdAnten;
		cableres = argCableres;
		lenCable = argCableLen;
		datasource = argDataSource;
		objectstatus = argObjectStatus;
		groundresource = null;
		groundcnt = null;
		storagecard = null;
		qty = null;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int savconfigid, int idCable)
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
	 * Get accessor for persistent attribute: id_anten
	 */
	public int getId_anten() {
		return id_anten;
	}
	/**
	 * Set accessor for persistent attribute: id_anten
	 */
	public void setId_anten(int newId_anten) {
		id_anten = newId_anten;
	}
	/**
	 * Get accessor for persistent attribute: lenCable
	 */
	public java.math.BigDecimal getLenCable() {
		return lenCable;
	}
	/**
	 * Set accessor for persistent attribute: lenCable
	 */
	public void setLenCable(java.math.BigDecimal newLenCable) {
		lenCable = newLenCable;
	}
	/**
	 * Get accessor for persistent attribute: cableres
	 */
	public int getCableres() {
		return cableres;
	}
	/**
	 * Set accessor for persistent attribute: cableres
	 */
	public void setCableres(int newCableres) {
		cableres = newCableres;
	}
	/**
	 * Get accessor for persistent attribute: groundresource
	 */
	public java.lang.Integer getGroundresource() {
		return groundresource;
	}
	/**
	 * Set accessor for persistent attribute: groundresource
	 */
	public void setGroundresource(java.lang.Integer newGroundresource) {
		groundresource = newGroundresource;
	}
	/**
	 * Get accessor for persistent attribute: groundcnt
	 */
	public java.lang.Integer getGroundcnt() {
		return groundcnt;
	}
	/**
	 * Set accessor for persistent attribute: groundcnt
	 */
	public void setGroundcnt(java.lang.Integer newGroundcnt) {
		groundcnt = newGroundcnt;
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
	 * Get accessor for persistent attribute: datasource
	 */
	public int getDatasource() {
		return datasource;
	}
	/**
	 * Set accessor for persistent attribute: datasource
	 */
	public void setDatasource(int newDatasource) {
		datasource = newDatasource;
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

		h.put("datasource", new Integer(getDatasource()));
		h.put("groundresource", getGroundresource());
		h.put("lenCable", getLenCable());
		h.put("objectstatus", getObjectstatus());
		h.put("id_anten", new Integer(getId_anten()));
		h.put("storagecard", getStoragecard());
		h.put("cableres", new Integer(getCableres()));
		h.put("groundcnt", getGroundcnt());
		h.put("qty", getQty());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		Integer localDatasource = (Integer) h.get("datasource");
		java.lang.Integer localGroundresource =
			(java.lang.Integer) h.get("groundresource");
		java.math.BigDecimal localLenCable =
			(java.math.BigDecimal) h.get("lenCable");
		java.lang.String localObjectstatus =
			(java.lang.String) h.get("objectstatus");
		Integer localId_anten = (Integer) h.get("id_anten");
		java.lang.Integer localStoragecard =
			(java.lang.Integer) h.get("storagecard");
		Integer localCableres = (Integer) h.get("cableres");
		java.lang.Integer localGroundcnt =
			(java.lang.Integer) h.get("groundcnt");
		java.math.BigDecimal localQty = (java.math.BigDecimal) h.get("qty");

		if (h.containsKey("datasource"))
			setDatasource((localDatasource).intValue());
		if (h.containsKey("groundresource"))
			setGroundresource((localGroundresource));
		if (h.containsKey("lenCable"))
			setLenCable((localLenCable));
		if (h.containsKey("objectstatus"))
			setObjectstatus((localObjectstatus));
		if (h.containsKey("id_anten"))
			setId_anten((localId_anten).intValue());
		if (h.containsKey("storagecard"))
			setStoragecard((localStoragecard));
		if (h.containsKey("cableres"))
			setCableres((localCableres).intValue());
		if (h.containsKey("groundcnt"))
			setGroundcnt((localGroundcnt));
		if (h.containsKey("qty"))
			setQty((localQty));
	}
}
