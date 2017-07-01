package com.hps.july.config.beans;
/**
 * Bean implementation class for Enterprise Bean: CfgAntennaWorkBand
 */
public class CfgAntennaWorkBandBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: idanten
	 */
	public int idanten;
	/**
	 * Implementation field for persistent attribute: band
	 */
	public short band;
	/**
	 * Implementation field for persistent attribute: electricangle
	 */
	public java.math.BigDecimal electricangle;
	/**
	 * Implementation field for persistent attribute: kind_ant
	 */
	public java.lang.String kind_ant;
	/**
	 * Implementation field for persistent attribute: kswn
	 */
	public java.math.BigDecimal kswn;
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
	public com.hps.july.config.beans.CfgAntennaWorkBandKey ejbCreate(
		int savconfigid,
		int idanten,
		short band,
		String objectStatus)
		throws javax.ejb.CreateException {
		_initLinks();
		this.savconfigid = savconfigid;
		this.idanten = idanten;
		this.band = band;
		this.objectstatus = objectStatus;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int savconfigid, int idanten, short band)
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
	 * Get accessor for persistent attribute: electricangle
	 */
	public java.math.BigDecimal getElectricangle() {
		return electricangle;
	}
	/**
	 * Set accessor for persistent attribute: electricangle
	 */
	public void setElectricangle(java.math.BigDecimal newElectricangle) {
		electricangle = newElectricangle;
	}
	/**
	 * Get accessor for persistent attribute: kind_ant
	 */
	public java.lang.String getKind_ant() {
		return kind_ant;
	}
	/**
	 * Set accessor for persistent attribute: kind_ant
	 */
	public void setKind_ant(java.lang.String newKind_ant) {
		kind_ant = newKind_ant;
	}
	/**
	 * Get accessor for persistent attribute: kswn
	 */
	public java.math.BigDecimal getKswn() {
		return kswn;
	}
	/**
	 * Set accessor for persistent attribute: kswn
	 */
	public void setKswn(java.math.BigDecimal newKswn) {
		kswn = newKswn;
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

		h.put("kind_ant", getKind_ant());
		h.put("objectstatus", getObjectstatus());
		h.put("kswn", getKswn());
		h.put("electricangle", getElectricangle());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localKind_ant = (java.lang.String) h.get("kind_ant");
		java.lang.String localObjectstatus =
			(java.lang.String) h.get("objectstatus");
		java.math.BigDecimal localKswn = (java.math.BigDecimal) h.get("kswn");
		java.math.BigDecimal localElectricangle =
			(java.math.BigDecimal) h.get("electricangle");

		if (h.containsKey("kind_ant"))
			setKind_ant((localKind_ant));
		if (h.containsKey("objectstatus"))
			setObjectstatus((localObjectstatus));
		if (h.containsKey("kswn"))
			setKswn((localKswn));
		if (h.containsKey("electricangle"))
			setElectricangle((localElectricangle));
	}
}
