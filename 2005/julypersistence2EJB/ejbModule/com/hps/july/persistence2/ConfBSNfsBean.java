package com.hps.july.persistence2;
/**
 * Bean implementation class for Enterprise Bean: ConfBSNfs
 */
public class ConfBSNfsBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: id
	 */
	public int id;
	/**
	 * Implementation field for persistent attribute: codenri
	 */
	public int codenri; 
	/**
	 * Implementation field for persistent attribute: nfsitem_id
	 */
	public java.lang.String nfsitem_id;
	/**
	 * Implementation field for persistent attribute: conftype
	 */
	public java.lang.String conftype;
	/**
	 * Implementation field for persistent attribute: voltage
	 */
	public java.math.BigDecimal voltage;
	/**
	 * Implementation field for persistent attribute: sect_a
	 */
	public int sect_a;
	/**
	 * Implementation field for persistent attribute: sect_b
	 */
	public int sect_b;
	/**
	 * Implementation field for persistent attribute: sect_c
	 */
	public int sect_c;
	/**
	 * Implementation field for persistent attribute: sect_d
	 */
	public int sect_d;
	/**
	 * Implementation field for persistent attribute: sect_e
	 */
	public int sect_e;
	/**
	 * Implementation field for persistent attribute: sect_f
	 */
	public int sect_f;
	/**
	 * Implementation field for persistent attribute: sect_g
	 */
	public int sect_g;
	/**
	 * Implementation field for persistent attribute: sect_h
	 */
	public int sect_h;
	/**
	 * Implementation field for persistent attribute: sect_o900
	 */
	public int sect_o900;
	/**
	 * Implementation field for persistent attribute: sect_o1800
	 */
	public int sect_o1800;
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
	public com.hps.july.persistence2.ConfBSNfsKey ejbCreate(int argId,
			int argCodeNri, int argSectorA, int argSectorB,
			int argSectorC, int argSectorD, int argSectorE,
			int argSectorF, int argSectorG, int argSectorH,
			String argNfsItemId, String argConfType,
			int argSect_o900, int argSect_o1800)
		throws javax.ejb.CreateException {
		_initLinks();
		id = argId;
		codenri = argCodeNri;
		sect_a = argSectorA;
		sect_b = argSectorB;
		sect_c = argSectorC;
		sect_d = argSectorD;
		sect_e = argSectorE;
		sect_f = argSectorF;
		sect_g = argSectorG;
		sect_h = argSectorH;
		nfsitem_id = argNfsItemId;
		conftype = argConfType;
		voltage = null;
		sect_o900 = argSect_o900;
		sect_o1800 = argSect_o1800;		
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int id) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: codenri
	 */
	public int getCodenri() {
		return codenri;
	}
	/**
	 * Set accessor for persistent attribute: codenri
	 */
	public void setCodenri(int newCodenri) {
		codenri = newCodenri;
	}
	/**
	 * Get accessor for persistent attribute: nfsitem_id
	 */
	public java.lang.String getNfsitem_id() {
		return nfsitem_id;
	}
	/**
	 * Set accessor for persistent attribute: nfsitem_id
	 */
	public void setNfsitem_id(java.lang.String newNfsitem_id) {
		nfsitem_id = newNfsitem_id;
	}
	/**
	 * Get accessor for persistent attribute: conftype
	 */
	public java.lang.String getConftype() {
		return conftype;
	}
	/**
	 * Set accessor for persistent attribute: conftype
	 */
	public void setConftype(java.lang.String newConftype) {
		conftype = newConftype;
	}
	/**
	 * Get accessor for persistent attribute: voltage
	 */
	public java.math.BigDecimal getVoltage() {
		return voltage;
	}
	/**
	 * Set accessor for persistent attribute: voltage
	 */
	public void setVoltage(java.math.BigDecimal newVoltage) {
		voltage = newVoltage;
	}
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 */
	public int getSect_a() {
		return sect_a;
	}

	/**
	 * @return
	 */
	public int getSect_b() {
		return sect_b;
	}

	/**
	 * @return
	 */
	public int getSect_c() {
		return sect_c;
	}

	/**
	 * @return
	 */
	public int getSect_d() {
		return sect_d;
	}

	/**
	 * @return
	 */
	public int getSect_e() {
		return sect_e;
	}

	/**
	 * @return
	 */
	public int getSect_f() {
		return sect_f;
	}

	/**
	 * @return
	 */
	public int getSect_g() {
		return sect_g;
	}

	/**
	 * @return
	 */
	public int getSect_h() {
		return sect_h;
	}

	/**
	 * @param i
	 */
	public void setSect_a(int i) {
		sect_a = i;
	}

	/**
	 * @param i
	 */
	public void setSect_b(int i) {
		sect_b = i;
	}

	/**
	 * @param i
	 */
	public void setSect_c(int i) {
		sect_c = i;
	}

	/**
	 * @param i
	 */
	public void setSect_d(int i) {
		sect_d = i;
	}

	/**
	 * @param i
	 */
	public void setSect_e(int i) {
		sect_e = i;
	}

	/**
	 * @param i
	 */
	public void setSect_f(int i) {
		sect_f = i;
	}

	/**
	 * @param i
	 */
	public void setSect_g(int i) {
		sect_g = i;
	}

	/**
	 * @param i
	 */
	public void setSect_h(int i) {
		sect_h = i;
	}

	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("id", new Integer(getId()));
		h.put("sect_h", new Integer(getSect_h()));
		h.put("sect_g", new Integer(getSect_g()));
		h.put("voltage", getVoltage());
		h.put("sect_f", new Integer(getSect_f()));
		h.put("sect_e", new Integer(getSect_e()));
		h.put("codenri", new Integer(getCodenri()));
		h.put("sect_d", new Integer(getSect_d()));
		h.put("sect_c", new Integer(getSect_c()));
		h.put("sect_b", new Integer(getSect_b()));
		h.put("sect_a", new Integer(getSect_a()));
		h.put("nfsitem_id", getNfsitem_id());
		h.put("conftype", getConftype());
		h.put("sect_o900", new Integer(getSect_o900()));
		h.put("sect_o1800", new Integer(getSect_o1800()));
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		Integer localSect_h = (Integer) h.get("sect_h");
		Integer localSect_g = (Integer) h.get("sect_g");
		java.math.BigDecimal localVoltage =
			(java.math.BigDecimal) h.get("voltage");
		Integer localSect_f = (Integer) h.get("sect_f");
		Integer localSect_e = (Integer) h.get("sect_e");
		Integer localCodenri = (Integer) h.get("codenri");
		Integer localSect_d = (Integer) h.get("sect_d");
		Integer localSect_c = (Integer) h.get("sect_c");
		Integer localSect_b = (Integer) h.get("sect_b");
		Integer localSect_a = (Integer) h.get("sect_a");
		java.lang.String localNfsitem_id =
			(java.lang.String) h.get("nfsitem_id");
		java.lang.String localConftype = (java.lang.String) h.get("conftype");
		Integer localSect_o900 = (Integer) h.get("sect_o900");
		Integer localSect_o1800 = (Integer) h.get("sect_o1800");

		if (h.containsKey("sect_h"))
			setSect_h((localSect_h).intValue());
		if (h.containsKey("sect_g"))
			setSect_g((localSect_g).intValue());
		if (h.containsKey("voltage"))
			setVoltage((localVoltage));
		if (h.containsKey("sect_f"))
			setSect_f((localSect_f).intValue());
		if (h.containsKey("sect_e"))
			setSect_e((localSect_e).intValue());
		if (h.containsKey("codenri"))
			setCodenri((localCodenri).intValue());
		if (h.containsKey("sect_d"))
			setSect_d((localSect_d).intValue());
		if (h.containsKey("sect_c"))
			setSect_c((localSect_c).intValue());
		if (h.containsKey("sect_b"))
			setSect_b((localSect_b).intValue());
		if (h.containsKey("sect_a"))
			setSect_a((localSect_a).intValue());
		if (h.containsKey("nfsitem_id"))
			setNfsitem_id((localNfsitem_id));
		if (h.containsKey("conftype"))
			setConftype((localConftype));
		if (h.containsKey("sect_o900"))
			setSect_o900((localSect_o900).intValue());
		if (h.containsKey("sect_o1800"))
			setSect_o1800((localSect_o1800).intValue());
	}
	/**
	 * Get accessor for persistent attribute: sect_o900
	 */
	public int getSect_o900() {
		return sect_o900;
	}
	/**
	 * Set accessor for persistent attribute: sect_o900
	 */
	public void setSect_o900(int newSect_o900) {
		sect_o900 = newSect_o900;
	}
	/**
	 * Get accessor for persistent attribute: sect_o1800
	 */
	public int getSect_o1800() {
		return sect_o1800;
	}
	/**
	 * Set accessor for persistent attribute: sect_o1800
	 */
	public void setSect_o1800(int newSect_o1800) {
		sect_o1800 = newSect_o1800;
	}
}
