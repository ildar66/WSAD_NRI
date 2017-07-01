package com.hps.july.config.beans;
/**
 * Bean implementation class for Enterprise Bean: CfgSector
 */
public class CfgSectorBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: id_sect
	 */
	public int id_sect;
	/**
	 * Implementation field for persistent attribute: equipment
	 */
	public int equipment;
	/**
	 * Implementation field for persistent attribute: name_sect
	 */
	public java.lang.String name_sect;
	/**
	 * Implementation field for persistent attribute: band
	 */
	public java.lang.Short band;
	/**
	 * Implementation field for persistent attribute: num_sect
	 */
	public java.lang.String num_sect;
	/**
	 * Implementation field for persistent attribute: azimut
	 */
	public java.math.BigDecimal azimut;
	/**
	 * Implementation field for persistent attribute: power
	 */
	public java.math.BigDecimal power;
	/**
	 * Implementation field for persistent attribute: bts_number
	 */
	public java.lang.String bts_number;
	/**
	 * Implementation field for persistent attribute: con_abis
	 */
	public java.lang.String con_abis;
	/**
	 * Implementation field for persistent attribute: port_abis
	 */
	public java.lang.Integer port_abis;
	/**
	 * Implementation field for persistent attribute: num_po
	 */
	public java.lang.String num_po;
	/**
	 * Implementation field for persistent attribute: ddk
	 */
	public java.lang.Boolean ddk;
	/**
	 * Implementation field for persistent attribute: trx_num
	 */
	public java.lang.Integer trx_num;
	/**
	 * Implementation field for persistent attribute: tx_pwr
	 */
	public java.math.BigDecimal tx_pwr;
	/**
	 * Implementation field for persistent attribute: trx_num2
	 */
	public java.lang.Integer trx_num2;
	/**
	 * Implementation field for persistent attribute: tx_pwr2
	 */
	public java.math.BigDecimal tx_pwr2;
	/**
	 * Implementation field for persistent attribute: tx_set_pwr
	 */
	public java.math.BigDecimal tx_set_pwr;
	/**
	 * Implementation field for persistent attribute: trx_ovr_num
	 */
	public java.lang.Integer trx_ovr_num;
	/**
	 * Implementation field for persistent attribute: tx_ovr_set_pwr
	 */
	public java.math.BigDecimal tx_ovr_set_pwr;
	/**
	 * Implementation field for persistent attribute: has_flt
	 */
	public java.lang.Boolean has_flt;
	/**
	 * Implementation field for persistent attribute: has_lna
	 */
	public java.lang.Boolean has_lna;
	/**
	 * Implementation field for persistent attribute: has_buster
	 */
	public java.lang.Boolean has_buster;
	/**
	 * Implementation field for persistent attribute: conf
	 */
	public java.lang.String conf;
	/**
	 * Implementation field for persistent attribute: is_hr
	 */
	public java.lang.Boolean is_hr;
	/**
	 * Implementation field for persistent attribute: cap_gprs
	 */
	public java.lang.Boolean cap_gprs;
	/**
	 * Implementation field for persistent attribute: operator
	 */
	public java.lang.Integer operator;
	/**
	 * Implementation field for persistent attribute: byhand
	 */
	public java.lang.Boolean byhand;
	/**
	 * Implementation field for persistent attribute: lac
	 */
	public java.lang.Integer lac;
	/**
	 * Implementation field for persistent attribute: rac
	 */
	public java.lang.Integer rac;
	/**
	 * Implementation field for persistent attribute: cellname
	 */
	public java.lang.Integer cellname;
	/**
	 * Implementation field for persistent attribute: ncc
	 */
	public java.lang.Short ncc;
	/**
	 * Implementation field for persistent attribute: bcc
	 */
	public java.lang.Short bcc;
	/**
	 * Implementation field for persistent attribute: standid
	 */
	public java.lang.Integer standid;
	/**
	 * Implementation field for persistent attribute: cellinfo
	 */
	public java.lang.String cellinfo;
	/**
	 * Implementation field for persistent attribute: datasource
	 */
	public int datasource;
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
	public com.hps.july.config.beans.CfgSectorKey ejbCreate(
		int savconfigid,
		int id_sect, int equipment, String name_sect,
		short band, String num_sect, int datasource,
		String objectstatus)
		throws javax.ejb.CreateException {
		_initLinks();
		this.savconfigid = savconfigid;
		this.id_sect = id_sect;
		this.equipment = equipment;
		this.name_sect = name_sect;
		this.band = new Short(band);
		this.num_sect = num_sect;
		this.datasource = datasource;
		this.ObjectStatus = objectstatus;
		azimut = null;
		power = null;
		bts_number = null;
		con_abis = null;
		port_abis = null;
		num_po = null;
		ddk = null;
		trx_num = null;
		tx_pwr = null;
		trx_num2 = null;
		tx_pwr2 = null;
		tx_set_pwr = null;
		trx_ovr_num = null;
		tx_ovr_set_pwr = null;
		has_flt = null;
		has_lna = null;
		has_buster = null;
		conf = null;
		is_hr = null;
		cap_gprs = null;
		byhand = new Boolean(true);
		operator = null;
		lac = null;
		rac = null;
		cellname = null;
		ncc = null;
		bcc = null;
		standid = null;
		cellinfo = null;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int savconfigid, int id_sect)
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
	 * Get accessor for persistent attribute: name_sect
	 */
	public java.lang.String getName_sect() {
		return name_sect;
	}
	/**
	 * Set accessor for persistent attribute: name_sect
	 */
	public void setName_sect(java.lang.String newName_sect) {
		name_sect = newName_sect;
	}
	/**
	 * Get accessor for persistent attribute: band
	 */
	public java.lang.Short getBand() {
		return band;
	}
	/**
	 * Set accessor for persistent attribute: band
	 */
	public void setBand(java.lang.Short newBand) {
		band = newBand;
	}
	/**
	 * Get accessor for persistent attribute: num_sect
	 */
	public java.lang.String getNum_sect() {
		return num_sect;
	}
	/**
	 * Set accessor for persistent attribute: num_sect
	 */
	public void setNum_sect(java.lang.String newNum_sect) {
		num_sect = newNum_sect;
	}
	/**
	 * Get accessor for persistent attribute: azimut
	 */
	public java.math.BigDecimal getAzimut() {
		return azimut;
	}
	/**
	 * Set accessor for persistent attribute: azimut
	 */
	public void setAzimut(java.math.BigDecimal newAzimut) {
		azimut = newAzimut;
	}
	/**
	 * Get accessor for persistent attribute: power
	 */
	public java.math.BigDecimal getPower() {
		return power;
	}
	/**
	 * Set accessor for persistent attribute: power
	 */
	public void setPower(java.math.BigDecimal newPower) {
		power = newPower;
	}
	/**
	 * Get accessor for persistent attribute: bts_number
	 */
	public java.lang.String getBts_number() {
		return bts_number;
	}
	/**
	 * Set accessor for persistent attribute: bts_number
	 */
	public void setBts_number(java.lang.String newBts_number) {
		bts_number = newBts_number;
	}
	/**
	 * Get accessor for persistent attribute: con_abis
	 */
	public java.lang.String getCon_abis() {
		return con_abis;
	}
	/**
	 * Set accessor for persistent attribute: con_abis
	 */
	public void setCon_abis(java.lang.String newCon_abis) {
		con_abis = newCon_abis;
	}
	/**
	 * Get accessor for persistent attribute: port_abis
	 */
	public java.lang.Integer getPort_abis() {
		return port_abis;
	}
	/**
	 * Set accessor for persistent attribute: port_abis
	 */
	public void setPort_abis(java.lang.Integer newPort_abis) {
		port_abis = newPort_abis;
	}
	/**
	 * Get accessor for persistent attribute: num_po
	 */
	public java.lang.String getNum_po() {
		return num_po;
	}
	/**
	 * Set accessor for persistent attribute: num_po
	 */
	public void setNum_po(java.lang.String newNum_po) {
		num_po = newNum_po;
	}
	/**
	 * Get accessor for persistent attribute: ddk
	 */
	public java.lang.Boolean getDdk() {
		return ddk;
	}
	/**
	 * Set accessor for persistent attribute: ddk
	 */
	public void setDdk(java.lang.Boolean newDdk) {
		ddk = newDdk;
	}
	/**
	 * Get accessor for persistent attribute: trx_num
	 */
	public java.lang.Integer getTrx_num() {
		return trx_num;
	}
	/**
	 * Set accessor for persistent attribute: trx_num
	 */
	public void setTrx_num(java.lang.Integer newTrx_num) {
		trx_num = newTrx_num;
	}
	/**
	 * Get accessor for persistent attribute: tx_pwr
	 */
	public java.math.BigDecimal getTx_pwr() {
		return tx_pwr;
	}
	/**
	 * Set accessor for persistent attribute: tx_pwr
	 */
	public void setTx_pwr(java.math.BigDecimal newTx_pwr) {
		tx_pwr = newTx_pwr;
	}
	/**
	 * Get accessor for persistent attribute: trx_num2
	 */
	public java.lang.Integer getTrx_num2() {
		return trx_num2;
	}
	/**
	 * Set accessor for persistent attribute: trx_num2
	 */
	public void setTrx_num2(java.lang.Integer newTrx_num2) {
		trx_num2 = newTrx_num2;
	}
	/**
	 * Get accessor for persistent attribute: tx_pwr2
	 */
	public java.math.BigDecimal getTx_pwr2() {
		return tx_pwr2;
	}
	/**
	 * Set accessor for persistent attribute: tx_pwr2
	 */
	public void setTx_pwr2(java.math.BigDecimal newTx_pwr2) {
		tx_pwr2 = newTx_pwr2;
	}
	/**
	 * Get accessor for persistent attribute: tx_set_pwr
	 */
	public java.math.BigDecimal getTx_set_pwr() {
		return tx_set_pwr;
	}
	/**
	 * Set accessor for persistent attribute: tx_set_pwr
	 */
	public void setTx_set_pwr(java.math.BigDecimal newTx_set_pwr) {
		tx_set_pwr = newTx_set_pwr;
	}
	/**
	 * Get accessor for persistent attribute: trx_ovr_num
	 */
	public java.lang.Integer getTrx_ovr_num() {
		return trx_ovr_num;
	}
	/**
	 * Set accessor for persistent attribute: trx_ovr_num
	 */
	public void setTrx_ovr_num(java.lang.Integer newTrx_ovr_num) {
		trx_ovr_num = newTrx_ovr_num;
	}
	/**
	 * Get accessor for persistent attribute: tx_ovr_set_pwr
	 */
	public java.math.BigDecimal getTx_ovr_set_pwr() {
		return tx_ovr_set_pwr;
	}
	/**
	 * Set accessor for persistent attribute: tx_ovr_set_pwr
	 */
	public void setTx_ovr_set_pwr(java.math.BigDecimal newTx_ovr_set_pwr) {
		tx_ovr_set_pwr = newTx_ovr_set_pwr;
	}
	/**
	 * Get accessor for persistent attribute: has_flt
	 */
	public java.lang.Boolean getHas_flt() {
		return has_flt;
	}
	/**
	 * Set accessor for persistent attribute: has_flt
	 */
	public void setHas_flt(java.lang.Boolean newHas_flt) {
		has_flt = newHas_flt;
	}
	/**
	 * Get accessor for persistent attribute: has_lna
	 */
	public java.lang.Boolean getHas_lna() {
		return has_lna;
	}
	/**
	 * Set accessor for persistent attribute: has_lna
	 */
	public void setHas_lna(java.lang.Boolean newHas_lna) {
		has_lna = newHas_lna;
	}
	/**
	 * Get accessor for persistent attribute: has_buster
	 */
	public java.lang.Boolean getHas_buster() {
		return has_buster;
	}
	/**
	 * Set accessor for persistent attribute: has_buster
	 */
	public void setHas_buster(java.lang.Boolean newHas_buster) {
		has_buster = newHas_buster;
	}
	/**
	 * Get accessor for persistent attribute: conf
	 */
	public java.lang.String getConf() {
		return conf;
	}
	/**
	 * Set accessor for persistent attribute: conf
	 */
	public void setConf(java.lang.String newConf) {
		conf = newConf;
	}
	/**
	 * Get accessor for persistent attribute: is_hr
	 */
	public java.lang.Boolean getIs_hr() {
		return is_hr;
	}
	/**
	 * Set accessor for persistent attribute: is_hr
	 */
	public void setIs_hr(java.lang.Boolean newIs_hr) {
		is_hr = newIs_hr;
	}
	/**
	 * Get accessor for persistent attribute: cap_gprs
	 */
	public java.lang.Boolean getCap_gprs() {
		return cap_gprs;
	}
	/**
	 * Set accessor for persistent attribute: cap_gprs
	 */
	public void setCap_gprs(java.lang.Boolean newCap_gprs) {
		cap_gprs = newCap_gprs;
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
	 * Get accessor for persistent attribute: lac
	 */
	public java.lang.Integer getLac() {
		return lac;
	}
	/**
	 * Set accessor for persistent attribute: lac
	 */
	public void setLac(java.lang.Integer newLac) {
		lac = newLac;
	}
	/**
	 * Get accessor for persistent attribute: rac
	 */
	public java.lang.Integer getRac() {
		return rac;
	}
	/**
	 * Set accessor for persistent attribute: rac
	 */
	public void setRac(java.lang.Integer newRac) {
		rac = newRac;
	}
	/**
	 * Get accessor for persistent attribute: cellname
	 */
	public java.lang.Integer getCellname() {
		return cellname;
	}
	/**
	 * Set accessor for persistent attribute: cellname
	 */
	public void setCellname(java.lang.Integer newCellname) {
		cellname = newCellname;
	}
	/**
	 * Get accessor for persistent attribute: ncc
	 */
	public java.lang.Short getNcc() {
		return ncc;
	}
	/**
	 * Set accessor for persistent attribute: ncc
	 */
	public void setNcc(java.lang.Short newNcc) {
		ncc = newNcc;
	}
	/**
	 * Get accessor for persistent attribute: bcc
	 */
	public java.lang.Short getBcc() {
		return bcc;
	}
	/**
	 * Set accessor for persistent attribute: bcc
	 */
	public void setBcc(java.lang.Short newBcc) {
		bcc = newBcc;
	}
	/**
	 * Get accessor for persistent attribute: standid
	 */
	public java.lang.Integer getStandid() {
		return standid;
	}
	/**
	 * Set accessor for persistent attribute: standid
	 */
	public void setStandid(java.lang.Integer newStandid) {
		standid = newStandid;
	}
	/**
	 * Get accessor for persistent attribute: cellinfo
	 */
	public java.lang.String getCellinfo() {
		return cellinfo;
	}
	/**
	 * Set accessor for persistent attribute: cellinfo
	 */
	public void setCellinfo(java.lang.String newCellinfo) {
		cellinfo = newCellinfo;
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

		h.put("tx_pwr", getTx_pwr());
		h.put("band", getBand());
		h.put("cellinfo", getCellinfo());
		h.put("rac", getRac());
		h.put("num_sect", getNum_sect());
		h.put("trx_num", getTrx_num());
		h.put("bcc", getBcc());
		h.put("tx_set_pwr", getTx_set_pwr());
		h.put("has_buster", getHas_buster());
		h.put("is_hr", getIs_hr());
		h.put("savconfigid", new Integer(getSavconfigid()));
		h.put("has_lna", getHas_lna());
		h.put("cellname", getCellname());
		h.put("port_abis", getPort_abis());
		h.put("tx_ovr_set_pwr", getTx_ovr_set_pwr());
		h.put("has_flt", getHas_flt());
		h.put("equipment", new Integer(getEquipment()));
		h.put("ddk", getDdk());
		h.put("cap_gprs", getCap_gprs());
		h.put("tx_pwr2", getTx_pwr2());
		h.put("azimut", getAzimut());
		h.put("objectStatus", getObjectStatus());
		h.put("num_po", getNum_po());
		h.put("con_abis", getCon_abis());
		h.put("lac", getLac());
		h.put("trx_num2", getTrx_num2());
		h.put("conf", getConf());
		h.put("trx_ovr_num", getTrx_ovr_num());
		h.put("name_sect", getName_sect());
		h.put("id_sect", new Integer(getId_sect()));
		h.put("operator", getOperator());
		h.put("datasource", new Integer(getDatasource()));
		h.put("standid", getStandid());
		h.put("ncc", getNcc());
		h.put("power", getPower());
		h.put("byhand", getByhand());
		h.put("bts_number", getBts_number());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.math.BigDecimal localTx_pwr =
			(java.math.BigDecimal) h.get("tx_pwr");
		java.lang.Short localBand = (java.lang.Short) h.get("band");
		java.lang.String localCellinfo = (java.lang.String) h.get("cellinfo");
		java.lang.Integer localRac = (java.lang.Integer) h.get("rac");
		java.lang.String localNum_sect = (java.lang.String) h.get("num_sect");
		java.lang.Integer localTrx_num = (java.lang.Integer) h.get("trx_num");
		java.lang.Short localBcc = (java.lang.Short) h.get("bcc");
		java.math.BigDecimal localTx_set_pwr =
			(java.math.BigDecimal) h.get("tx_set_pwr");
		java.lang.Boolean localHas_buster =
			(java.lang.Boolean) h.get("has_buster");
		java.lang.Boolean localIs_hr = (java.lang.Boolean) h.get("is_hr");
		java.lang.Boolean localHas_lna = (java.lang.Boolean) h.get("has_lna");
		java.lang.Integer localCellname = (java.lang.Integer) h.get("cellname");
		java.lang.Integer localPort_abis =
			(java.lang.Integer) h.get("port_abis");
		java.math.BigDecimal localTx_ovr_set_pwr =
			(java.math.BigDecimal) h.get("tx_ovr_set_pwr");
		java.lang.Boolean localHas_flt = (java.lang.Boolean) h.get("has_flt");
		Integer localEquipment = (Integer) h.get("equipment");
		java.lang.Boolean localDdk = (java.lang.Boolean) h.get("ddk");
		java.lang.Boolean localCap_gprs = (java.lang.Boolean) h.get("cap_gprs");
		java.math.BigDecimal localTx_pwr2 =
			(java.math.BigDecimal) h.get("tx_pwr2");
		java.math.BigDecimal localAzimut =
			(java.math.BigDecimal) h.get("azimut");
		java.lang.String localObjectStatus =
			(java.lang.String) h.get("objectStatus");
		java.lang.String localNum_po = (java.lang.String) h.get("num_po");
		java.lang.String localCon_abis = (java.lang.String) h.get("con_abis");
		java.lang.Integer localLac = (java.lang.Integer) h.get("lac");
		java.lang.Integer localTrx_num2 = (java.lang.Integer) h.get("trx_num2");
		java.lang.String localConf = (java.lang.String) h.get("conf");
		java.lang.Integer localTrx_ovr_num =
			(java.lang.Integer) h.get("trx_ovr_num");
		java.lang.String localName_sect = (java.lang.String) h.get("name_sect");
		java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
		Integer localDatasource = (Integer) h.get("datasource");
		java.lang.Integer localStandid = (java.lang.Integer) h.get("standid");
		java.lang.Short localNcc = (java.lang.Short) h.get("ncc");
		java.math.BigDecimal localPower = (java.math.BigDecimal) h.get("power");
		java.lang.Boolean localByhand = (java.lang.Boolean) h.get("byhand");
		java.lang.String localBts_number =
			(java.lang.String) h.get("bts_number");

		if (h.containsKey("tx_pwr"))
			setTx_pwr((localTx_pwr));
		if (h.containsKey("band"))
			setBand((localBand));
		if (h.containsKey("cellinfo"))
			setCellinfo((localCellinfo));
		if (h.containsKey("rac"))
			setRac((localRac));
		if (h.containsKey("num_sect"))
			setNum_sect((localNum_sect));
		if (h.containsKey("trx_num"))
			setTrx_num((localTrx_num));
		if (h.containsKey("bcc"))
			setBcc((localBcc));
		if (h.containsKey("tx_set_pwr"))
			setTx_set_pwr((localTx_set_pwr));
		if (h.containsKey("has_buster"))
			setHas_buster((localHas_buster));
		if (h.containsKey("is_hr"))
			setIs_hr((localIs_hr));
		if (h.containsKey("has_lna"))
			setHas_lna((localHas_lna));
		if (h.containsKey("cellname"))
			setCellname((localCellname));
		if (h.containsKey("port_abis"))
			setPort_abis((localPort_abis));
		if (h.containsKey("tx_ovr_set_pwr"))
			setTx_ovr_set_pwr((localTx_ovr_set_pwr));
		if (h.containsKey("has_flt"))
			setHas_flt((localHas_flt));
		if (h.containsKey("equipment"))
			setEquipment((localEquipment).intValue());
		if (h.containsKey("ddk"))
			setDdk((localDdk));
		if (h.containsKey("cap_gprs"))
			setCap_gprs((localCap_gprs));
		if (h.containsKey("tx_pwr2"))
			setTx_pwr2((localTx_pwr2));
		if (h.containsKey("azimut"))
			setAzimut((localAzimut));
		if (h.containsKey("objectStatus"))
			setObjectStatus((localObjectStatus));
		if (h.containsKey("num_po"))
			setNum_po((localNum_po));
		if (h.containsKey("con_abis"))
			setCon_abis((localCon_abis));
		if (h.containsKey("lac"))
			setLac((localLac));
		if (h.containsKey("trx_num2"))
			setTrx_num2((localTrx_num2));
		if (h.containsKey("conf"))
			setConf((localConf));
		if (h.containsKey("trx_ovr_num"))
			setTrx_ovr_num((localTrx_ovr_num));
		if (h.containsKey("name_sect"))
			setName_sect((localName_sect));
		if (h.containsKey("operator"))
			setOperator((localOperator));
		if (h.containsKey("datasource"))
			setDatasource((localDatasource).intValue());
		if (h.containsKey("standid"))
			setStandid((localStandid));
		if (h.containsKey("ncc"))
			setNcc((localNcc));
		if (h.containsKey("power"))
			setPower((localPower));
		if (h.containsKey("byhand"))
			setByhand((localByhand));
		if (h.containsKey("bts_number"))
			setBts_number((localBts_number));
	}
}
