package com.hps.july.config.beans;
/**
 * Bean implementation class for Enterprise Bean: CfgBasestation
 */
public class CfgBasestationBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: equipment
	 */
	public int equipment;
	/**
	 * Implementation field for persistent attribute: controller
	 */
	public java.lang.Integer controller;
	/**
	 * Implementation field for persistent attribute: type
	 */
	public java.lang.String type;
	/**
	 * Implementation field for persistent attribute: repeater
	 */
	public boolean repeater;
	/**
	 * Implementation field for persistent attribute: number
	 */
	public int number;
	/**
	 * Implementation field for persistent attribute: name
	 */
	public java.lang.String name;
	/**
	 * Implementation field for persistent attribute: n_stoek
	 */
	public java.lang.Short n_stoek;
	/**
	 * Implementation field for persistent attribute: st_transp
	 */
	public java.lang.String st_transp;
	/**
	 * Implementation field for persistent attribute: time_backup
	 */
	public java.lang.String time_backup;
	/**
	 * Implementation field for persistent attribute: date_assemb_afs
	 */
	public java.sql.Date date_assemb_afs;
	/**
	 * Implementation field for persistent attribute: date_assemb_afs2
	 */
	public java.sql.Date date_assemb_afs2;
	/**
	 * Implementation field for persistent attribute: date_connect
	 */
	public java.sql.Date date_connect;
	/**
	 * Implementation field for persistent attribute: date_connect2
	 */
	public java.sql.Date date_connect2;
	/**
	 * Implementation field for persistent attribute: date_onair
	 */
	public java.sql.Date date_onair;
	/**
	 * Implementation field for persistent attribute: date_onair2
	 */
	public java.sql.Date date_onair2;
	/**
	 * Implementation field for persistent attribute: net_stage
	 */
	public java.lang.Short net_stage;
	/**
	 * Implementation field for persistent attribute: con_type
	 */
	public java.lang.String con_type;
	/**
	 * Implementation field for persistent attribute: e1_qty
	 */
	public java.lang.Short e1_qty;
	/**
	 * Implementation field for persistent attribute: on_air
	 */
	public java.lang.Boolean on_air;
	/**
	 * Implementation field for persistent attribute: date_bldbeg2
	 */
	public java.sql.Date date_bldbeg2;
	/**
	 * Implementation field for persistent attribute: date_assemb2
	 */
	public java.sql.Date date_assemb2;
	/**
	 * Implementation field for persistent attribute: date_test2
	 */
	public java.sql.Date date_test2;
	/**
	 * Implementation field for persistent attribute: date_pr2
	 */
	public java.sql.Date date_pr2;
	/**
	 * Implementation field for persistent attribute: prefixcellid
	 */
	public java.lang.Integer prefixcellid;
	/**
	 * Implementation field for persistent attribute: softversion
	 */
	public java.lang.String softversion;
	/**
	 * Implementation field for persistent attribute: stand_resource
	 */
	public java.lang.Integer stand_resource;
	/**
	 * Implementation field for persistent attribute: isarendats
	 */
	public java.lang.Boolean isarendats;
	/**
	 * Implementation field for persistent attribute: state900
	 */
	public java.lang.String state900;
	/**
	 * Implementation field for persistent attribute: state1800
	 */
	public java.lang.String state1800;
	/**
	 * Implementation field for persistent attribute: h_obj_ant
	 */
	public java.math.BigDecimal h_obj_ant;
	/**
	 * Implementation field for persistent attribute: antplaceid
	 */
	public java.lang.Integer antplaceid;
	/**
	 * Implementation field for persistent attribute: numdcspermit
	 */
	public java.lang.String numdcspermit;
	/**
	 * Implementation field for persistent attribute: numgsmpermit
	 */
	public java.lang.String numgsmpermit;
	/**
	 * Implementation field for persistent attribute: pwr_val
	 */
	public java.math.BigDecimal pwr_val;
	/**
	 * Implementation field for persistent attribute: pwr_cat
	 */
	public java.lang.String pwr_cat;
	/**
	 * Implementation field for persistent attribute: pwr_reserve
	 */
	public java.lang.String pwr_reserve;
	/**
	 * Implementation field for persistent attribute: pwr_res_cat
	 */
	public java.lang.String pwr_res_cat;
	/**
	 * Implementation field for persistent attribute: date_bldbeg
	 */
	public java.sql.Date date_bldbeg;
	/**
	 * Implementation field for persistent attribute: date_assemb
	 */
	public java.sql.Date date_assemb;
	/**
	 * Implementation field for persistent attribute: date_test
	 */
	public java.sql.Date date_test;
	/**
	 * Implementation field for persistent attribute: date_pr
	 */
	public java.sql.Date date_pr;
	/**
	 * Implementation field for persistent attribute: equipcomment
	 */
	public java.lang.String equipcomment;
	/**
	 * Implementation field for persistent attribute: logictypeid
	 */
	public java.lang.Integer logictypeid;
	/**
	 * Implementation field for persistent attribute: manufid
	 */
	public java.lang.Integer manufid;
	/**
	 * Implementation field for persistent attribute: ObjectStatus
	 */
	public java.lang.String ObjectStatus;
	/**
	 * Implementation field for persistent attribute: apartmentid
	 */
	public java.lang.Integer apartmentid;
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
	public com.hps.july.config.beans.CfgBasestationKey ejbCreate(
		int argSavconfigid, int argEquipment, String argType, 
		boolean argRepeater, int argNumber, String argName,
		String argObjectStatus)
		throws javax.ejb.CreateException {
		_initLinks();
		this.savconfigid = argSavconfigid;
		this.equipment = argEquipment;
		this.type = argType;
		this.repeater = argRepeater;
		this.number = argNumber;
		this.name = argName;
		this.ObjectStatus = argObjectStatus;
		controller = null;
		n_stoek = null;
		st_transp = null;
		time_backup = null;
		date_assemb_afs = null;
		date_assemb_afs2 = null;
		date_connect = null;
		date_connect2 = null;
		date_onair = null;
		date_onair2 = null;
		net_stage = null;
		con_type = null;
		e1_qty = null;
		on_air = null;
		date_bldbeg = null;
		date_bldbeg2 = null;
		date_assemb = null;
		date_assemb2 = null;
		date_test = null;
		date_test2 = null;
		date_pr = null;
		date_pr2 = null;
		prefixcellid = null;
		softversion = null;
		stand_resource = null;
		isarendats = null;
		state900 = null;
		state1800 = null;
		h_obj_ant = null;
		antplaceid = null;
		numdcspermit = null;
		numgsmpermit = null;
		pwr_val = null;
		pwr_cat = null;
		pwr_reserve = null;
		pwr_res_cat = null;
		equipcomment = null;
		logictypeid = null;
		manufid = null;
		apartmentid = null;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int savconfigid, int equipment)
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
	 * Get accessor for persistent attribute: controller
	 */
	public java.lang.Integer getController() {
		return controller;
	}
	/**
	 * Set accessor for persistent attribute: controller
	 */
	public void setController(java.lang.Integer newController) {
		controller = newController;
	}
	/**
	 * Get accessor for persistent attribute: type
	 */
	public java.lang.String getType() {
		return type;
	}
	/**
	 * Set accessor for persistent attribute: type
	 */
	public void setType(java.lang.String newType) {
		type = newType;
	}
	/**
	 * Get accessor for persistent attribute: repeater
	 */
	public boolean isRepeater() {
		return repeater;
	}
	/**
	 * Set accessor for persistent attribute: repeater
	 */
	public void setRepeater(boolean newRepeater) {
		repeater = newRepeater;
	}
	/**
	 * Get accessor for persistent attribute: number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * Set accessor for persistent attribute: number
	 */
	public void setNumber(int newNumber) {
		number = newNumber;
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
	 * Get accessor for persistent attribute: n_stoek
	 */
	public java.lang.Short getN_stoek() {
		return n_stoek;
	}
	/**
	 * Set accessor for persistent attribute: n_stoek
	 */
	public void setN_stoek(java.lang.Short newN_stoek) {
		n_stoek = newN_stoek;
	}
	/**
	 * Get accessor for persistent attribute: st_transp
	 */
	public java.lang.String getSt_transp() {
		return st_transp;
	}
	/**
	 * Set accessor for persistent attribute: st_transp
	 */
	public void setSt_transp(java.lang.String newSt_transp) {
		st_transp = newSt_transp;
	}
	/**
	 * Get accessor for persistent attribute: time_backup
	 */
	public java.lang.String getTime_backup() {
		return time_backup;
	}
	/**
	 * Set accessor for persistent attribute: time_backup
	 */
	public void setTime_backup(java.lang.String newTime_backup) {
		time_backup = newTime_backup;
	}
	/**
	 * Get accessor for persistent attribute: date_assemb_afs
	 */
	public java.sql.Date getDate_assemb_afs() {
		return date_assemb_afs;
	}
	/**
	 * Set accessor for persistent attribute: date_assemb_afs
	 */
	public void setDate_assemb_afs(java.sql.Date newDate_assemb_afs) {
		date_assemb_afs = newDate_assemb_afs;
	}
	/**
	 * Get accessor for persistent attribute: date_assemb_afs2
	 */
	public java.sql.Date getDate_assemb_afs2() {
		return date_assemb_afs2;
	}
	/**
	 * Set accessor for persistent attribute: date_assemb_afs2
	 */
	public void setDate_assemb_afs2(java.sql.Date newDate_assemb_afs2) {
		date_assemb_afs2 = newDate_assemb_afs2;
	}
	/**
	 * Get accessor for persistent attribute: date_connect
	 */
	public java.sql.Date getDate_connect() {
		return date_connect;
	}
	/**
	 * Set accessor for persistent attribute: date_connect
	 */
	public void setDate_connect(java.sql.Date newDate_connect) {
		date_connect = newDate_connect;
	}
	/**
	 * Get accessor for persistent attribute: date_connect2
	 */
	public java.sql.Date getDate_connect2() {
		return date_connect2;
	}
	/**
	 * Set accessor for persistent attribute: date_connect2
	 */
	public void setDate_connect2(java.sql.Date newDate_connect2) {
		date_connect2 = newDate_connect2;
	}
	/**
	 * Get accessor for persistent attribute: date_onair
	 */
	public java.sql.Date getDate_onair() {
		return date_onair;
	}
	/**
	 * Set accessor for persistent attribute: date_onair
	 */
	public void setDate_onair(java.sql.Date newDate_onair) {
		date_onair = newDate_onair;
	}
	/**
	 * Get accessor for persistent attribute: date_onair2
	 */
	public java.sql.Date getDate_onair2() {
		return date_onair2;
	}
	/**
	 * Set accessor for persistent attribute: date_onair2
	 */
	public void setDate_onair2(java.sql.Date newDate_onair2) {
		date_onair2 = newDate_onair2;
	}
	/**
	 * Get accessor for persistent attribute: net_stage
	 */
	public java.lang.Short getNet_stage() {
		return net_stage;
	}
	/**
	 * Set accessor for persistent attribute: net_stage
	 */
	public void setNet_stage(java.lang.Short newNet_stage) {
		net_stage = newNet_stage;
	}
	/**
	 * Get accessor for persistent attribute: con_type
	 */
	public java.lang.String getCon_type() {
		return con_type;
	}
	/**
	 * Set accessor for persistent attribute: con_type
	 */
	public void setCon_type(java.lang.String newCon_type) {
		con_type = newCon_type;
	}
	/**
	 * Get accessor for persistent attribute: e1_qty
	 */
	public java.lang.Short getE1_qty() {
		return e1_qty;
	}
	/**
	 * Set accessor for persistent attribute: e1_qty
	 */
	public void setE1_qty(java.lang.Short newE1_qty) {
		e1_qty = newE1_qty;
	}
	/**
	 * Get accessor for persistent attribute: on_air
	 */
	public java.lang.Boolean getOn_air() {
		return on_air;
	}
	/**
	 * Set accessor for persistent attribute: on_air
	 */
	public void setOn_air(java.lang.Boolean newOn_air) {
		on_air = newOn_air;
	}
	/**
	 * Get accessor for persistent attribute: date_bldbeg2
	 */
	public java.sql.Date getDate_bldbeg2() {
		return date_bldbeg2;
	}
	/**
	 * Set accessor for persistent attribute: date_bldbeg2
	 */
	public void setDate_bldbeg2(java.sql.Date newDate_bldbeg2) {
		date_bldbeg2 = newDate_bldbeg2;
	}
	/**
	 * Get accessor for persistent attribute: date_assemb2
	 */
	public java.sql.Date getDate_assemb2() {
		return date_assemb2;
	}
	/**
	 * Set accessor for persistent attribute: date_assemb2
	 */
	public void setDate_assemb2(java.sql.Date newDate_assemb2) {
		date_assemb2 = newDate_assemb2;
	}
	/**
	 * Get accessor for persistent attribute: date_test2
	 */
	public java.sql.Date getDate_test2() {
		return date_test2;
	}
	/**
	 * Set accessor for persistent attribute: date_test2
	 */
	public void setDate_test2(java.sql.Date newDate_test2) {
		date_test2 = newDate_test2;
	}
	/**
	 * Get accessor for persistent attribute: date_pr2
	 */
	public java.sql.Date getDate_pr2() {
		return date_pr2;
	}
	/**
	 * Set accessor for persistent attribute: date_pr2
	 */
	public void setDate_pr2(java.sql.Date newDate_pr2) {
		date_pr2 = newDate_pr2;
	}
	/**
	 * Get accessor for persistent attribute: prefixcellid
	 */
	public java.lang.Integer getPrefixcellid() {
		return prefixcellid;
	}
	/**
	 * Set accessor for persistent attribute: prefixcellid
	 */
	public void setPrefixcellid(java.lang.Integer newPrefixcellid) {
		prefixcellid = newPrefixcellid;
	}
	/**
	 * Get accessor for persistent attribute: softversion
	 */
	public java.lang.String getSoftversion() {
		return softversion;
	}
	/**
	 * Set accessor for persistent attribute: softversion
	 */
	public void setSoftversion(java.lang.String newSoftversion) {
		softversion = newSoftversion;
	}
	/**
	 * Get accessor for persistent attribute: stand_resource
	 */
	public java.lang.Integer getStand_resource() {
		return stand_resource;
	}
	/**
	 * Set accessor for persistent attribute: stand_resource
	 */
	public void setStand_resource(java.lang.Integer newStand_resource) {
		stand_resource = newStand_resource;
	}
	/**
	 * Get accessor for persistent attribute: isarendats
	 */
	public java.lang.Boolean getIsarendats() {
		return isarendats;
	}
	/**
	 * Set accessor for persistent attribute: isarendats
	 */
	public void setIsarendats(java.lang.Boolean newIsarendats) {
		isarendats = newIsarendats;
	}
	/**
	 * Get accessor for persistent attribute: state900
	 */
	public java.lang.String getState900() {
		return state900;
	}
	/**
	 * Set accessor for persistent attribute: state900
	 */
	public void setState900(java.lang.String newState900) {
		state900 = newState900;
	}
	/**
	 * Get accessor for persistent attribute: state1800
	 */
	public java.lang.String getState1800() {
		return state1800;
	}
	/**
	 * Set accessor for persistent attribute: state1800
	 */
	public void setState1800(java.lang.String newState1800) {
		state1800 = newState1800;
	}
	/**
	 * Get accessor for persistent attribute: h_obj_ant
	 */
	public java.math.BigDecimal getH_obj_ant() {
		return h_obj_ant;
	}
	/**
	 * Set accessor for persistent attribute: h_obj_ant
	 */
	public void setH_obj_ant(java.math.BigDecimal newH_obj_ant) {
		h_obj_ant = newH_obj_ant;
	}
	/**
	 * Get accessor for persistent attribute: antplaceid
	 */
	public java.lang.Integer getAntplaceid() {
		return antplaceid;
	}
	/**
	 * Set accessor for persistent attribute: antplaceid
	 */
	public void setAntplaceid(java.lang.Integer newAntplaceid) {
		antplaceid = newAntplaceid;
	}
	/**
	 * Get accessor for persistent attribute: numdcspermit
	 */
	public java.lang.String getNumdcspermit() {
		return numdcspermit;
	}
	/**
	 * Set accessor for persistent attribute: numdcspermit
	 */
	public void setNumdcspermit(java.lang.String newNumdcspermit) {
		numdcspermit = newNumdcspermit;
	}
	/**
	 * Get accessor for persistent attribute: numgsmpermit
	 */
	public java.lang.String getNumgsmpermit() {
		return numgsmpermit;
	}
	/**
	 * Set accessor for persistent attribute: numgsmpermit
	 */
	public void setNumgsmpermit(java.lang.String newNumgsmpermit) {
		numgsmpermit = newNumgsmpermit;
	}
	/**
	 * Get accessor for persistent attribute: pwr_val
	 */
	public java.math.BigDecimal getPwr_val() {
		return pwr_val;
	}
	/**
	 * Set accessor for persistent attribute: pwr_val
	 */
	public void setPwr_val(java.math.BigDecimal newPwr_val) {
		pwr_val = newPwr_val;
	}
	/**
	 * Get accessor for persistent attribute: pwr_cat
	 */
	public java.lang.String getPwr_cat() {
		return pwr_cat;
	}
	/**
	 * Set accessor for persistent attribute: pwr_cat
	 */
	public void setPwr_cat(java.lang.String newPwr_cat) {
		pwr_cat = newPwr_cat;
	}
	/**
	 * Get accessor for persistent attribute: pwr_reserve
	 */
	public java.lang.String getPwr_reserve() {
		return pwr_reserve;
	}
	/**
	 * Set accessor for persistent attribute: pwr_reserve
	 */
	public void setPwr_reserve(java.lang.String newPwr_reserve) {
		pwr_reserve = newPwr_reserve;
	}
	/**
	 * Get accessor for persistent attribute: pwr_res_cat
	 */
	public java.lang.String getPwr_res_cat() {
		return pwr_res_cat;
	}
	/**
	 * Set accessor for persistent attribute: pwr_res_cat
	 */
	public void setPwr_res_cat(java.lang.String newPwr_res_cat) {
		pwr_res_cat = newPwr_res_cat;
	}
	/**
	 * Get accessor for persistent attribute: date_bldbeg
	 */
	public java.sql.Date getDate_bldbeg() {
		return date_bldbeg;
	}
	/**
	 * Set accessor for persistent attribute: date_bldbeg
	 */
	public void setDate_bldbeg(java.sql.Date newDate_bldbeg) {
		date_bldbeg = newDate_bldbeg;
	}
	/**
	 * Get accessor for persistent attribute: date_assemb
	 */
	public java.sql.Date getDate_assemb() {
		return date_assemb;
	}
	/**
	 * Set accessor for persistent attribute: date_assemb
	 */
	public void setDate_assemb(java.sql.Date newDate_assemb) {
		date_assemb = newDate_assemb;
	}
	/**
	 * Get accessor for persistent attribute: date_test
	 */
	public java.sql.Date getDate_test() {
		return date_test;
	}
	/**
	 * Set accessor for persistent attribute: date_test
	 */
	public void setDate_test(java.sql.Date newDate_test) {
		date_test = newDate_test;
	}
	/**
	 * Get accessor for persistent attribute: date_pr
	 */
	public java.sql.Date getDate_pr() {
		return date_pr;
	}
	/**
	 * Set accessor for persistent attribute: date_pr
	 */
	public void setDate_pr(java.sql.Date newDate_pr) {
		date_pr = newDate_pr;
	}
	/**
	 * Get accessor for persistent attribute: equipcomment
	 */
	public java.lang.String getEquipcomment() {
		return equipcomment;
	}
	/**
	 * Set accessor for persistent attribute: equipcomment
	 */
	public void setEquipcomment(java.lang.String newEquipcomment) {
		equipcomment = newEquipcomment;
	}
	/**
	 * Get accessor for persistent attribute: logictypeid
	 */
	public java.lang.Integer getLogictypeid() {
		return logictypeid;
	}
	/**
	 * Set accessor for persistent attribute: logictypeid
	 */
	public void setLogictypeid(java.lang.Integer newLogictypeid) {
		logictypeid = newLogictypeid;
	}
	/**
	 * Get accessor for persistent attribute: manufid
	 */
	public java.lang.Integer getManufid() {
		return manufid;
	}
	/**
	 * Set accessor for persistent attribute: manufid
	 */
	public void setManufid(java.lang.Integer newManufid) {
		manufid = newManufid;
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
	public int getEquipment() {
		return equipment;
	}

	/**
	 * @return
	 */
	public int getSavconfigid() {
		return savconfigid;
	}

	/**
	 * Get accessor for persistent attribute: apartmentid
	 */
	public java.lang.Integer getApartmentid() {
		return apartmentid;
	}
	/**
	 * Set accessor for persistent attribute: apartmentid
	 */
	public void setApartmentid(java.lang.Integer newApartmentid) {
		apartmentid = newApartmentid;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("state1800", getState1800());
		h.put("pwr_val", getPwr_val());
		h.put("prefixcellid", getPrefixcellid());
		h.put("date_bldbeg", getDate_bldbeg());
		h.put("manufid", getManufid());
		h.put("date_connect", getDate_connect());
		h.put("pwr_cat", getPwr_cat());
		h.put("apartmentid", getApartmentid());
		h.put("equipcomment", getEquipcomment());
		h.put("antplaceid", getAntplaceid());
		h.put("date_assemb_afs", getDate_assemb_afs());
		h.put("date_assemb2", getDate_assemb2());
		h.put("h_obj_ant", getH_obj_ant());
		h.put("pwr_res_cat", getPwr_res_cat());
		h.put("date_pr", getDate_pr());
		h.put("pwr_reserve", getPwr_reserve());
		h.put("logictypeid", getLogictypeid());
		h.put("name", getName());
		h.put("state900", getState900());
		h.put("net_stage", getNet_stage());
		h.put("stand_resource", getStand_resource());
		h.put("st_transp", getSt_transp());
		h.put("savconfigid", new Integer(getSavconfigid()));
		h.put("isarendats", getIsarendats());
		h.put("date_test2", getDate_test2());
		h.put("numdcspermit", getNumdcspermit());
		h.put("on_air", getOn_air());
		h.put("date_onair2", getDate_onair2());
		h.put("n_stoek", getN_stoek());
		h.put("e1_qty", getE1_qty());
		h.put("date_onair", getDate_onair());
		h.put("repeater", new Boolean(isRepeater()));
		h.put("date_pr2", getDate_pr2());
		h.put("equipment", new Integer(getEquipment()));
		h.put("softversion", getSoftversion());
		h.put("objectStatus", getObjectStatus());
		h.put("date_connect2", getDate_connect2());
		h.put("date_test", getDate_test());
		h.put("con_type", getCon_type());
		h.put("date_bldbeg2", getDate_bldbeg2());
		h.put("date_assemb", getDate_assemb());
		h.put("controller", getController());
		h.put("date_assemb_afs2", getDate_assemb_afs2());
		h.put("time_backup", getTime_backup());
		h.put("numgsmpermit", getNumgsmpermit());
		h.put("number", new Integer(getNumber()));
		h.put("type", getType());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localState1800 = (java.lang.String) h.get("state1800");
		java.math.BigDecimal localPwr_val =
			(java.math.BigDecimal) h.get("pwr_val");
		java.lang.Integer localPrefixcellid =
			(java.lang.Integer) h.get("prefixcellid");
		java.sql.Date localDate_bldbeg = (java.sql.Date) h.get("date_bldbeg");
		java.lang.Integer localManufid = (java.lang.Integer) h.get("manufid");
		java.sql.Date localDate_connect = (java.sql.Date) h.get("date_connect");
		java.lang.String localPwr_cat = (java.lang.String) h.get("pwr_cat");
		java.lang.Integer localApartmentid =
			(java.lang.Integer) h.get("apartmentid");
		java.lang.String localEquipcomment =
			(java.lang.String) h.get("equipcomment");
		java.lang.Integer localAntplaceid =
			(java.lang.Integer) h.get("antplaceid");
		java.sql.Date localDate_assemb_afs =
			(java.sql.Date) h.get("date_assemb_afs");
		java.sql.Date localDate_assemb2 = (java.sql.Date) h.get("date_assemb2");
		java.math.BigDecimal localH_obj_ant =
			(java.math.BigDecimal) h.get("h_obj_ant");
		java.lang.String localPwr_res_cat =
			(java.lang.String) h.get("pwr_res_cat");
		java.sql.Date localDate_pr = (java.sql.Date) h.get("date_pr");
		java.lang.String localPwr_reserve =
			(java.lang.String) h.get("pwr_reserve");
		java.lang.Integer localLogictypeid =
			(java.lang.Integer) h.get("logictypeid");
		java.lang.String localName = (java.lang.String) h.get("name");
		java.lang.String localState900 = (java.lang.String) h.get("state900");
		java.lang.Short localNet_stage = (java.lang.Short) h.get("net_stage");
		java.lang.Integer localStand_resource =
			(java.lang.Integer) h.get("stand_resource");
		java.lang.String localSt_transp = (java.lang.String) h.get("st_transp");
		java.lang.Boolean localIsarendats =
			(java.lang.Boolean) h.get("isarendats");
		java.sql.Date localDate_test2 = (java.sql.Date) h.get("date_test2");
		java.lang.String localNumdcspermit =
			(java.lang.String) h.get("numdcspermit");
		java.lang.Boolean localOn_air = (java.lang.Boolean) h.get("on_air");
		java.sql.Date localDate_onair2 = (java.sql.Date) h.get("date_onair2");
		java.lang.Short localN_stoek = (java.lang.Short) h.get("n_stoek");
		java.lang.Short localE1_qty = (java.lang.Short) h.get("e1_qty");
		java.sql.Date localDate_onair = (java.sql.Date) h.get("date_onair");
		Boolean localRepeater = (Boolean) h.get("repeater");
		java.sql.Date localDate_pr2 = (java.sql.Date) h.get("date_pr2");
		java.lang.String localSoftversion =
			(java.lang.String) h.get("softversion");
		java.lang.String localObjectStatus =
			(java.lang.String) h.get("objectStatus");
		java.sql.Date localDate_connect2 =
			(java.sql.Date) h.get("date_connect2");
		java.sql.Date localDate_test = (java.sql.Date) h.get("date_test");
		java.lang.String localCon_type = (java.lang.String) h.get("con_type");
		java.sql.Date localDate_bldbeg2 = (java.sql.Date) h.get("date_bldbeg2");
		java.sql.Date localDate_assemb = (java.sql.Date) h.get("date_assemb");
		java.lang.Integer localController =
			(java.lang.Integer) h.get("controller");
		java.sql.Date localDate_assemb_afs2 =
			(java.sql.Date) h.get("date_assemb_afs2");
		java.lang.String localTime_backup =
			(java.lang.String) h.get("time_backup");
		java.lang.String localNumgsmpermit =
			(java.lang.String) h.get("numgsmpermit");
		Integer localNumber = (Integer) h.get("number");
		java.lang.String localType = (java.lang.String) h.get("type");

		if (h.containsKey("state1800"))
			setState1800((localState1800));
		if (h.containsKey("pwr_val"))
			setPwr_val((localPwr_val));
		if (h.containsKey("prefixcellid"))
			setPrefixcellid((localPrefixcellid));
		if (h.containsKey("date_bldbeg"))
			setDate_bldbeg((localDate_bldbeg));
		if (h.containsKey("manufid"))
			setManufid((localManufid));
		if (h.containsKey("date_connect"))
			setDate_connect((localDate_connect));
		if (h.containsKey("pwr_cat"))
			setPwr_cat((localPwr_cat));
		if (h.containsKey("apartmentid"))
			setApartmentid((localApartmentid));
		if (h.containsKey("equipcomment"))
			setEquipcomment((localEquipcomment));
		if (h.containsKey("antplaceid"))
			setAntplaceid((localAntplaceid));
		if (h.containsKey("date_assemb_afs"))
			setDate_assemb_afs((localDate_assemb_afs));
		if (h.containsKey("date_assemb2"))
			setDate_assemb2((localDate_assemb2));
		if (h.containsKey("h_obj_ant"))
			setH_obj_ant((localH_obj_ant));
		if (h.containsKey("pwr_res_cat"))
			setPwr_res_cat((localPwr_res_cat));
		if (h.containsKey("date_pr"))
			setDate_pr((localDate_pr));
		if (h.containsKey("pwr_reserve"))
			setPwr_reserve((localPwr_reserve));
		if (h.containsKey("logictypeid"))
			setLogictypeid((localLogictypeid));
		if (h.containsKey("name"))
			setName((localName));
		if (h.containsKey("state900"))
			setState900((localState900));
		if (h.containsKey("net_stage"))
			setNet_stage((localNet_stage));
		if (h.containsKey("stand_resource"))
			setStand_resource((localStand_resource));
		if (h.containsKey("st_transp"))
			setSt_transp((localSt_transp));
		if (h.containsKey("isarendats"))
			setIsarendats((localIsarendats));
		if (h.containsKey("date_test2"))
			setDate_test2((localDate_test2));
		if (h.containsKey("numdcspermit"))
			setNumdcspermit((localNumdcspermit));
		if (h.containsKey("on_air"))
			setOn_air((localOn_air));
		if (h.containsKey("date_onair2"))
			setDate_onair2((localDate_onair2));
		if (h.containsKey("n_stoek"))
			setN_stoek((localN_stoek));
		if (h.containsKey("e1_qty"))
			setE1_qty((localE1_qty));
		if (h.containsKey("date_onair"))
			setDate_onair((localDate_onair));
		if (h.containsKey("repeater"))
			setRepeater((localRepeater).booleanValue());
		if (h.containsKey("date_pr2"))
			setDate_pr2((localDate_pr2));
		if (h.containsKey("softversion"))
			setSoftversion((localSoftversion));
		if (h.containsKey("objectStatus"))
			setObjectStatus((localObjectStatus));
		if (h.containsKey("date_connect2"))
			setDate_connect2((localDate_connect2));
		if (h.containsKey("date_test"))
			setDate_test((localDate_test));
		if (h.containsKey("con_type"))
			setCon_type((localCon_type));
		if (h.containsKey("date_bldbeg2"))
			setDate_bldbeg2((localDate_bldbeg2));
		if (h.containsKey("date_assemb"))
			setDate_assemb((localDate_assemb));
		if (h.containsKey("controller"))
			setController((localController));
		if (h.containsKey("date_assemb_afs2"))
			setDate_assemb_afs2((localDate_assemb_afs2));
		if (h.containsKey("time_backup"))
			setTime_backup((localTime_backup));
		if (h.containsKey("numgsmpermit"))
			setNumgsmpermit((localNumgsmpermit));
		if (h.containsKey("number"))
			setNumber((localNumber).intValue());
		if (h.containsKey("type"))
			setType((localType));
	}
}
