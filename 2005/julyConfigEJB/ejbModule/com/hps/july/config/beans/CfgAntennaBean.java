package com.hps.july.config.beans;
/**
 * Bean implementation class for Enterprise Bean: CfgAntenna
 */
public class CfgAntennaBean implements javax.ejb.EntityBean {
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
	 * Implementation field for persistent attribute: resource
	 */
	public int resource;
	/**
	 * Implementation field for persistent attribute: num_ant
	 */
	public java.lang.String num_ant;
	/**
	 * Implementation field for persistent attribute: kind_ant
	 */
	public java.lang.String kind_ant;
	/**
	 * Implementation field for persistent attribute: nakl
	 */
	public java.math.BigDecimal nakl;
	/**
	 * Implementation field for persistent attribute: az_ant
	 */
	public java.math.BigDecimal az_ant;
	/**
	 * Implementation field for persistent attribute: kswn
	 */
	public java.math.BigDecimal kswn;
	/**
	 * Implementation field for persistent attribute: h_set1
	 */
	public java.math.BigDecimal h_set1;
	/**
	 * Implementation field for persistent attribute: len_cable
	 */
	public java.math.BigDecimal len_cable;
	/**
	 * Implementation field for persistent attribute: cableres
	 */
	public java.lang.Integer cableres;
	/**
	 * Implementation field for persistent attribute: equipment
	 */
	public int equipment;
	/**
	 * Implementation field for persistent attribute: az_variation
	 */
	public java.lang.String az_variation;
	/**
	 * Implementation field for persistent attribute: nakl_variation
	 */
	public java.lang.String nakl_variation;
	/**
	 * Implementation field for persistent attribute: input_power
	 */
	public java.math.BigDecimal input_power;
	/**
	 * Implementation field for persistent attribute: operator
	 */
	public java.lang.Integer operator;
	/**
	 * Implementation field for persistent attribute: byhand
	 */
	public java.lang.Boolean byhand;
	/**
	 * Implementation field for persistent attribute: groundresource
	 */
	public java.lang.Integer groundresource;
	/**
	 * Implementation field for persistent attribute: groundcnt
	 */
	public java.lang.Integer groundcnt;
	/**
	 * Implementation field for persistent attribute: locationtype
	 */
	public java.lang.String locationtype;
	/**
	 * Implementation field for persistent attribute: electricaltilt
	 */
	public java.math.BigDecimal electricaltilt;
	/**
	 * Implementation field for persistent attribute: StorageCard
	 */
	public java.lang.Integer StorageCard;
	/**
	 * Implementation field for persistent attribute: qty
	 */
	public java.math.BigDecimal qty;
	/**
	 * Implementation field for persistent attribute: datasource
	 */
	public int datasource;
	/**
	 * Implementation field for persistent attribute: ObjectStatus
	 */
	public java.lang.String ObjectStatus;
	/**
	 * Implementation field for persistent attribute: commcable
	 */
	public java.lang.Boolean commcable;
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
	public com.hps.july.config.beans.CfgAntennaKey ejbCreate(
		int savconfigid,
		int id_anten,
		int resource, String num_ant, String kind_ant,
		java.math.BigDecimal nakl, java.math.BigDecimal az_ant,
		java.math.BigDecimal h_set1, java.math.BigDecimal len_cable,
		int equipment, boolean byhand, String locationtype,
		int datasource, String objectstatus)
		throws javax.ejb.CreateException {
		_initLinks();
		this.savconfigid = savconfigid;
		this.id_anten = id_anten;
		this.resource = resource;
		this.num_ant = num_ant;
		this.kind_ant = kind_ant;
		this.nakl = nakl;
		this.az_ant = az_ant;
		this.h_set1 = h_set1;
		this.len_cable = len_cable;
		this.equipment = equipment;
		this.byhand = new Boolean(byhand);
		this.locationtype = locationtype;
		this.datasource = datasource;
		ObjectStatus = objectstatus;
		kswn = null;
		cableres = null;
		az_variation = null;
		nakl_variation = null;
		input_power = null;
		operator = null;
		groundresource = null;
		groundcnt = null;
		electricaltilt = null;
		StorageCard = null;
		qty = null;
		commcable = new Boolean(false);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int savconfigid, int id_anten)
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
	 * Get accessor for persistent attribute: num_ant
	 */
	public java.lang.String getNum_ant() {
		return num_ant;
	}
	/**
	 * Set accessor for persistent attribute: num_ant
	 */
	public void setNum_ant(java.lang.String newNum_ant) {
		num_ant = newNum_ant;
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
	 * Get accessor for persistent attribute: nakl
	 */
	public java.math.BigDecimal getNakl() {
		return nakl;
	}
	/**
	 * Set accessor for persistent attribute: nakl
	 */
	public void setNakl(java.math.BigDecimal newNakl) {
		nakl = newNakl;
	}
	/**
	 * Get accessor for persistent attribute: az_ant
	 */
	public java.math.BigDecimal getAz_ant() {
		return az_ant;
	}
	/**
	 * Set accessor for persistent attribute: az_ant
	 */
	public void setAz_ant(java.math.BigDecimal newAz_ant) {
		az_ant = newAz_ant;
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
	 * Get accessor for persistent attribute: h_set1
	 */
	public java.math.BigDecimal getH_set1() {
		return h_set1;
	}
	/**
	 * Set accessor for persistent attribute: h_set1
	 */
	public void setH_set1(java.math.BigDecimal newH_set1) {
		h_set1 = newH_set1;
	}
	/**
	 * Get accessor for persistent attribute: len_cable
	 */
	public java.math.BigDecimal getLen_cable() {
		return len_cable;
	}
	/**
	 * Set accessor for persistent attribute: len_cable
	 */
	public void setLen_cable(java.math.BigDecimal newLen_cable) {
		len_cable = newLen_cable;
	}
	/**
	 * Get accessor for persistent attribute: cableres
	 */
	public java.lang.Integer getCableres() {
		return cableres;
	}
	/**
	 * Set accessor for persistent attribute: cableres
	 */
	public void setCableres(java.lang.Integer newCableres) {
		cableres = newCableres;
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
	 * Get accessor for persistent attribute: az_variation
	 */
	public java.lang.String getAz_variation() {
		return az_variation;
	}
	/**
	 * Set accessor for persistent attribute: az_variation
	 */
	public void setAz_variation(java.lang.String newAz_variation) {
		az_variation = newAz_variation;
	}
	/**
	 * Get accessor for persistent attribute: nakl_variation
	 */
	public java.lang.String getNakl_variation() {
		return nakl_variation;
	}
	/**
	 * Set accessor for persistent attribute: nakl_variation
	 */
	public void setNakl_variation(java.lang.String newNakl_variation) {
		nakl_variation = newNakl_variation;
	}
	/**
	 * Get accessor for persistent attribute: input_power
	 */
	public java.math.BigDecimal getInput_power() {
		return input_power;
	}
	/**
	 * Set accessor for persistent attribute: input_power
	 */
	public void setInput_power(java.math.BigDecimal newInput_power) {
		input_power = newInput_power;
	}
	/**
	 * Get accessor for persistent attribute: operator
	 */
	public java.lang.Integer getOperator() {
		return operator;
	}
	/**
	 * Set accessor for persistent attribute: operator
	 */
	public void setOperator(java.lang.Integer newOperator) {
		operator = newOperator;
	}
	/**
	 * Get accessor for persistent attribute: byhand
	 */
	public java.lang.Boolean getByhand() {
		return byhand;
	}
	/**
	 * Set accessor for persistent attribute: byhand
	 */
	public void setByhand(java.lang.Boolean newByhand) {
		byhand = newByhand;
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
	 * Get accessor for persistent attribute: locationtype
	 */
	public java.lang.String getLocationtype() {
		return locationtype;
	}
	/**
	 * Set accessor for persistent attribute: locationtype
	 */
	public void setLocationtype(java.lang.String newLocationtype) {
		locationtype = newLocationtype;
	}
	/**
	 * Get accessor for persistent attribute: electricaltilt
	 */
	public java.math.BigDecimal getElectricaltilt() {
		return electricaltilt;
	}
	/**
	 * Set accessor for persistent attribute: electricaltilt
	 */
	public void setElectricaltilt(java.math.BigDecimal newElectricaltilt) {
		electricaltilt = newElectricaltilt;
	}
	/**
	 * Get accessor for persistent attribute: StorageCard
	 */
	public java.lang.Integer getStorageCard() {
		return StorageCard;
	}
	/**
	 * Set accessor for persistent attribute: StorageCard
	 */
	public void setStorageCard(java.lang.Integer newStorageCard) {
		StorageCard = newStorageCard;
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
	public int getSavconfigid() {
		return savconfigid;
	}

	/**
	 * Get accessor for persistent attribute: commcable
	 */
	public java.lang.Boolean getCommcable() {
		return commcable;
	}
	/**
	 * Set accessor for persistent attribute: commcable
	 */
	public void setCommcable(java.lang.Boolean newCommcable) {
		commcable = newCommcable;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("groundresource", getGroundresource());
		h.put("byhand", getByhand());
		h.put("resource", new Integer(getResource()));
		h.put("kind_ant", getKind_ant());
		h.put("nakl", getNakl());
		h.put("az_variation", getAz_variation());
		h.put("nakl_variation", getNakl_variation());
		h.put("electricaltilt", getElectricaltilt());
		h.put("num_ant", getNum_ant());
		h.put("locationtype", getLocationtype());
		h.put("cableres", getCableres());
		h.put("datasource", new Integer(getDatasource()));
		h.put("savconfigid", new Integer(getSavconfigid()));
		h.put("operator", getOperator());
		h.put("qty", getQty());
		h.put("input_power", getInput_power());
		h.put("id_anten", new Integer(getId_anten()));
		h.put("groundcnt", getGroundcnt());
		h.put("commcable", getCommcable());
		h.put("kswn", getKswn());
		h.put("len_cable", getLen_cable());
		h.put("storageCard", getStorageCard());
		h.put("h_set1", getH_set1());
		h.put("az_ant", getAz_ant());
		h.put("objectStatus", getObjectStatus());
		h.put("equipment", new Integer(getEquipment()));
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.Integer localGroundresource =
			(java.lang.Integer) h.get("groundresource");
		java.lang.Boolean localByhand = (java.lang.Boolean) h.get("byhand");
		Integer localResource = (Integer) h.get("resource");
		java.lang.String localKind_ant = (java.lang.String) h.get("kind_ant");
		java.math.BigDecimal localNakl = (java.math.BigDecimal) h.get("nakl");
		java.lang.String localAz_variation =
			(java.lang.String) h.get("az_variation");
		java.lang.String localNakl_variation =
			(java.lang.String) h.get("nakl_variation");
		java.math.BigDecimal localElectricaltilt =
			(java.math.BigDecimal) h.get("electricaltilt");
		java.lang.String localNum_ant = (java.lang.String) h.get("num_ant");
		java.lang.String localLocationtype =
			(java.lang.String) h.get("locationtype");
		java.lang.Integer localCableres = (java.lang.Integer) h.get("cableres");
		Integer localDatasource = (Integer) h.get("datasource");
		java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
		java.math.BigDecimal localQty = (java.math.BigDecimal) h.get("qty");
		java.math.BigDecimal localInput_power =
			(java.math.BigDecimal) h.get("input_power");
		java.lang.Integer localGroundcnt =
			(java.lang.Integer) h.get("groundcnt");
		java.lang.Boolean localCommcable =
			(java.lang.Boolean) h.get("commcable");
		java.math.BigDecimal localKswn = (java.math.BigDecimal) h.get("kswn");
		java.math.BigDecimal localLen_cable =
			(java.math.BigDecimal) h.get("len_cable");
		java.lang.Integer localStorageCard =
			(java.lang.Integer) h.get("storageCard");
		java.math.BigDecimal localH_set1 =
			(java.math.BigDecimal) h.get("h_set1");
		java.math.BigDecimal localAz_ant =
			(java.math.BigDecimal) h.get("az_ant");
		java.lang.String localObjectStatus =
			(java.lang.String) h.get("objectStatus");
		Integer localEquipment = (Integer) h.get("equipment");

		if (h.containsKey("groundresource"))
			setGroundresource((localGroundresource));
		if (h.containsKey("byhand"))
			setByhand((localByhand));
		if (h.containsKey("resource"))
			setResource((localResource).intValue());
		if (h.containsKey("kind_ant"))
			setKind_ant((localKind_ant));
		if (h.containsKey("nakl"))
			setNakl((localNakl));
		if (h.containsKey("az_variation"))
			setAz_variation((localAz_variation));
		if (h.containsKey("nakl_variation"))
			setNakl_variation((localNakl_variation));
		if (h.containsKey("electricaltilt"))
			setElectricaltilt((localElectricaltilt));
		if (h.containsKey("num_ant"))
			setNum_ant((localNum_ant));
		if (h.containsKey("locationtype"))
			setLocationtype((localLocationtype));
		if (h.containsKey("cableres"))
			setCableres((localCableres));
		if (h.containsKey("datasource"))
			setDatasource((localDatasource).intValue());
		if (h.containsKey("operator"))
			setOperator((localOperator));
		if (h.containsKey("qty"))
			setQty((localQty));
		if (h.containsKey("input_power"))
			setInput_power((localInput_power));
		if (h.containsKey("groundcnt"))
			setGroundcnt((localGroundcnt));
		if (h.containsKey("commcable"))
			setCommcable((localCommcable));
		if (h.containsKey("kswn"))
			setKswn((localKswn));
		if (h.containsKey("len_cable"))
			setLen_cable((localLen_cable));
		if (h.containsKey("storageCard"))
			setStorageCard((localStorageCard));
		if (h.containsKey("h_set1"))
			setH_set1((localH_set1));
		if (h.containsKey("az_ant"))
			setAz_ant((localAz_ant));
		if (h.containsKey("objectStatus"))
			setObjectStatus((localObjectStatus));
		if (h.containsKey("equipment"))
			setEquipment((localEquipment).intValue());
	}
}
