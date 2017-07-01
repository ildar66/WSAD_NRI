package com.hps.july.persistence2;
/**
 * Bean implementation class for Enterprise Bean: AfsScheme
 */
public class AfsSchemeBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: schemeid
	 */
	public java.lang.Integer schemeid;
	/**
	 * Implementation field for persistent attribute: numscheme
	 */
	public java.lang.String numscheme;
	/**
	 * Implementation field for persistent attribute: sectcount900
	 */
	public java.lang.Integer sectcount900;
	/**
	 * Implementation field for persistent attribute: sectcount1800
	 */
	public java.lang.Integer sectcount1800;
	/**
	 * Implementation field for persistent attribute: antX2
	 */
	public java.lang.Integer antX2;
	/**
	 * Implementation field for persistent attribute: antX4
	 */
	public java.lang.Integer antX4;
	/**
	 * Implementation field for persistent attribute: antV1
	 */
	public java.lang.Integer antV1;
	/**
	 * Implementation field for persistent attribute: antV2
	 */
	public java.lang.Integer antV2;
	/**
	 * Implementation field for persistent attribute: dbc1
	 */
	public java.lang.Integer dbc1;
	/**
	 * Implementation field for persistent attribute: dbc2
	 */
	public java.lang.Integer dbc2;
	/**
	 * Implementation field for persistent attribute: df1
	 */
	public java.lang.Integer df1;
	/**
	 * Implementation field for persistent attribute: df2
	 */
	public java.lang.Integer df2;
	/**
	 * Implementation field for persistent attribute: tma
	 */
	public java.lang.Integer tma;
	/**
	 * Implementation field for persistent attribute: jo
	 */
	public java.lang.Integer jo;
	/**
	 * Implementation field for persistent attribute: ji
	 */
	public java.lang.Integer ji;
	/**
	 * Implementation field for persistent attribute: conn
	 */
	public java.lang.Integer conn;
	/**
	 * Implementation field for persistent attribute: notes
	 */
	public java.lang.String notes;
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
	public com.hps.july.persistence2.AfsSchemeKey ejbCreate(
		java.lang.Integer schemeid)
		throws javax.ejb.CreateException {
		_initLinks();
		this.schemeid = schemeid;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer schemeid)
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
	 * Get accessor for persistent attribute: numscheme
	 */
	public java.lang.String getNumscheme() {
		return numscheme;
	}
	/**
	 * Set accessor for persistent attribute: numscheme
	 */
	public void setNumscheme(java.lang.String newNumscheme) {
		numscheme = newNumscheme;
	}
	/**
	 * Get accessor for persistent attribute: sectcount900
	 */
	public java.lang.Integer getSectcount900() {
		return sectcount900;
	}
	/**
	 * Set accessor for persistent attribute: sectcount900
	 */
	public void setSectcount900(java.lang.Integer newSectcount900) {
		sectcount900 = newSectcount900;
	}
	/**
	 * Get accessor for persistent attribute: sectcount1800
	 */
	public java.lang.Integer getSectcount1800() {
		return sectcount1800;
	}
	/**
	 * Set accessor for persistent attribute: sectcount1800
	 */
	public void setSectcount1800(java.lang.Integer newSectcount1800) {
		sectcount1800 = newSectcount1800;
	}
	/**
	 * Get accessor for persistent attribute: antX2
	 */
	public java.lang.Integer getAntX2() {
		return antX2;
	}
	/**
	 * Set accessor for persistent attribute: antX2
	 */
	public void setAntX2(java.lang.Integer newAntX2) {
		antX2 = newAntX2;
	}
	/**
	 * Get accessor for persistent attribute: antX4
	 */
	public java.lang.Integer getAntX4() {
		return antX4;
	}
	/**
	 * Set accessor for persistent attribute: antX4
	 */
	public void setAntX4(java.lang.Integer newAntX4) {
		antX4 = newAntX4;
	}
	/**
	 * Get accessor for persistent attribute: antV1
	 */
	public java.lang.Integer getAntV1() {
		return antV1;
	}
	/**
	 * Set accessor for persistent attribute: antV1
	 */
	public void setAntV1(java.lang.Integer newAntV1) {
		antV1 = newAntV1;
	}
	/**
	 * Get accessor for persistent attribute: antV2
	 */
	public java.lang.Integer getAntV2() {
		return antV2;
	}
	/**
	 * Set accessor for persistent attribute: antV2
	 */
	public void setAntV2(java.lang.Integer newAntV2) {
		antV2 = newAntV2;
	}
	/**
	 * Get accessor for persistent attribute: dbc1
	 */
	public java.lang.Integer getDbc1() {
		return dbc1;
	}
	/**
	 * Set accessor for persistent attribute: dbc1
	 */
	public void setDbc1(java.lang.Integer newDbc1) {
		dbc1 = newDbc1;
	}
	/**
	 * Get accessor for persistent attribute: dbc2
	 */
	public java.lang.Integer getDbc2() {
		return dbc2;
	}
	/**
	 * Set accessor for persistent attribute: dbc2
	 */
	public void setDbc2(java.lang.Integer newDbc2) {
		dbc2 = newDbc2;
	}
	/**
	 * Get accessor for persistent attribute: df1
	 */
	public java.lang.Integer getDf1() {
		return df1;
	}
	/**
	 * Set accessor for persistent attribute: df1
	 */
	public void setDf1(java.lang.Integer newDf1) {
		df1 = newDf1;
	}
	/**
	 * Get accessor for persistent attribute: df2
	 */
	public java.lang.Integer getDf2() {
		return df2;
	}
	/**
	 * Set accessor for persistent attribute: df2
	 */
	public void setDf2(java.lang.Integer newDf2) {
		df2 = newDf2;
	}
	/**
	 * Get accessor for persistent attribute: tma
	 */
	public java.lang.Integer getTma() {
		return tma;
	}
	/**
	 * Set accessor for persistent attribute: tma
	 */
	public void setTma(java.lang.Integer newTma) {
		tma = newTma;
	}
	/**
	 * Get accessor for persistent attribute: jo
	 */
	public java.lang.Integer getJo() {
		return jo;
	}
	/**
	 * Set accessor for persistent attribute: jo
	 */
	public void setJo(java.lang.Integer newJo) {
		jo = newJo;
	}
	/**
	 * Get accessor for persistent attribute: ji
	 */
	public java.lang.Integer getJi() {
		return ji;
	}
	/**
	 * Set accessor for persistent attribute: ji
	 */
	public void setJi(java.lang.Integer newJi) {
		ji = newJi;
	}
	/**
	 * Get accessor for persistent attribute: conn
	 */
	public java.lang.Integer getConn() {
		return conn;
	}
	/**
	 * Set accessor for persistent attribute: conn
	 */
	public void setConn(java.lang.Integer newConn) {
		conn = newConn;
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
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("antV1", getAntV1());
		h.put("tma", getTma());
		h.put("df2", getDf2());
		h.put("df1", getDf1());
		h.put("antX4", getAntX4());
		h.put("conn", getConn());
		h.put("jo", getJo());
		h.put("antX2", getAntX2());
		h.put("sectcount900", getSectcount900());
		h.put("notes", getNotes());
		h.put("ji", getJi());
		h.put("dbc2", getDbc2());
		h.put("dbc1", getDbc1());
		h.put("sectcount1800", getSectcount1800());
		h.put("numscheme", getNumscheme());
		h.put("antV2", getAntV2());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.Integer localAntV1 = (java.lang.Integer) h.get("antV1");
		java.lang.Integer localTma = (java.lang.Integer) h.get("tma");
		java.lang.Integer localDf2 = (java.lang.Integer) h.get("df2");
		java.lang.Integer localDf1 = (java.lang.Integer) h.get("df1");
		java.lang.Integer localAntX4 = (java.lang.Integer) h.get("antX4");
		java.lang.Integer localConn = (java.lang.Integer) h.get("conn");
		java.lang.Integer localJo = (java.lang.Integer) h.get("jo");
		java.lang.Integer localAntX2 = (java.lang.Integer) h.get("antX2");
		java.lang.Integer localSectcount900 =
			(java.lang.Integer) h.get("sectcount900");
		java.lang.String localNotes = (java.lang.String) h.get("notes");
		java.lang.Integer localJi = (java.lang.Integer) h.get("ji");
		java.lang.Integer localDbc2 = (java.lang.Integer) h.get("dbc2");
		java.lang.Integer localDbc1 = (java.lang.Integer) h.get("dbc1");
		java.lang.Integer localSectcount1800 =
			(java.lang.Integer) h.get("sectcount1800");
		java.lang.String localNumscheme = (java.lang.String) h.get("numscheme");
		java.lang.Integer localAntV2 = (java.lang.Integer) h.get("antV2");

		if (h.containsKey("antV1"))
			setAntV1((localAntV1));
		if (h.containsKey("tma"))
			setTma((localTma));
		if (h.containsKey("df2"))
			setDf2((localDf2));
		if (h.containsKey("df1"))
			setDf1((localDf1));
		if (h.containsKey("antX4"))
			setAntX4((localAntX4));
		if (h.containsKey("conn"))
			setConn((localConn));
		if (h.containsKey("jo"))
			setJo((localJo));
		if (h.containsKey("antX2"))
			setAntX2((localAntX2));
		if (h.containsKey("sectcount900"))
			setSectcount900((localSectcount900));
		if (h.containsKey("notes"))
			setNotes((localNotes));
		if (h.containsKey("ji"))
			setJi((localJi));
		if (h.containsKey("dbc2"))
			setDbc2((localDbc2));
		if (h.containsKey("dbc1"))
			setDbc1((localDbc1));
		if (h.containsKey("sectcount1800"))
			setSectcount1800((localSectcount1800));
		if (h.containsKey("numscheme"))
			setNumscheme((localNumscheme));
		if (h.containsKey("antV2"))
			setAntV2((localAntV2));
	}
}
