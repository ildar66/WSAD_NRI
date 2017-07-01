package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Позиция опорной сети
 */
public class PositionBean extends StoragePlaceBean {
	public String dampsname;
	public String details;
	public java.math.BigDecimal latitude;
	public java.math.BigDecimal longitude;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.sql.Date accesslistexp;
	public java.lang.Integer netZone_netzone;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink netZoneLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink comlinefromLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink photoLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink equipmentSetLink = null;
	public java.lang.Integer renter_organization;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink renterLink = null;
	public String rentervolume;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink positionResponsibleWorkersLink = null;
	public Integer dampsid;
	public Integer gsmid;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseOnPositionLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink internalWayBillLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink internalOutBillLink = null;
	public Boolean inAction;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink requestLink = null;
	public Integer dcsid;
	public java.lang.Integer region_regionid;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink regionLink = null;
	public String planstate;
	public String linktogosnetlat;
	public String linktogosnetlon;
	public java.sql.Date datebeginbuild;
	public String dognumber;
	public java.sql.Date dogdate;
	public java.math.BigDecimal paya;
	public java.math.BigDecimal sqqty;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink projectsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseArendaAgreementNewsLink = null;
	public java.sql.Date date_endbuild;
	public java.sql.Date date_posclose;
	public Integer antplaceid;
	public Integer oporplaceid;
	public java.math.BigDecimal oporaheight;
	public java.sql.Date oporadate;
	public Boolean oporaour;
	public Integer aptypeid;
	public Integer applacetypeid;
	public Integer applaceid;
	public String posstate;
	public String haveplan;
	public String docaddress;
	public String grchaddress;
	public String grchlat;
	public String grchlong;
	public String orderno;
	public java.math.BigDecimal avg_h_set;
	public String comment_doc;
	public boolean inmetro;
	public int datasource;
	/**
	 * Implementation field for persistent attribute: latitude_WGS84
	 */
	public java.math.BigDecimal latitude_WGS84;
	/**
	 * Implementation field for persistent attribute: longitude_WGS84
	 */
	public java.math.BigDecimal longitude_WGS84;
	/**
	 * Implementation field for persistent attribute: geosystem
	 */
	public int geosystem;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("inAction", getInAction());
		h.put("oporplaceid", getOporplaceid());
		h.put("latitude_WGS84", getLatitude_WGS84());
		h.put("gsmid", getGsmid());
		h.put("dampsname", getDampsname());
		h.put("accesslistexp", getAccesslistexp());
		h.put("planstate", getPlanstate());
		h.put("antplaceid", getAntplaceid());
		h.put("latitude", getLatitude());
		h.put("applaceid", getApplaceid());
		h.put("paya", getPaya());
		h.put("oporaheight", getOporaheight());
		h.put("dogdate", getDogdate());
		h.put("haveplan", getHaveplan());
		h.put("linktogosnetlat", getLinktogosnetlat());
		h.put("grchlat", getGrchlat());
		h.put("posstate", getPosstate());
		h.put("longitude_WGS84", getLongitude_WGS84());
		h.put("grchlong", getGrchlong());
		h.put("oporadate", getOporadate());
		h.put("dognumber", getDognumber());
		h.put("aptypeid", getAptypeid());
		h.put("oporaour", getOporaour());
		h.put("dcsid", getDcsid());
		h.put("rentervolume", getRentervolume());
		h.put("docaddress", getDocaddress());
		h.put("date_posclose", getDate_posclose());
		h.put("comment_doc", getComment_doc());
		h.put("sqqty", getSqqty());
		h.put("applacetypeid", getApplacetypeid());
		h.put("datebeginbuild", getDatebeginbuild());
		h.put("longitude", getLongitude());
		h.put("regionKey", getRegionKey());
		h.put("grchaddress", getGrchaddress());
		h.put("linktogosnetlon", getLinktogosnetlon());
		h.put("dampsid", getDampsid());
		h.put("details", getDetails());
		h.put("inmetro", new Boolean(getInmetro()));
		h.put("datasource", new Integer(getDatasource()));
		h.put("renterKey", getRenterKey());
		h.put("netZoneKey", getNetZoneKey());
		h.put("avg_h_set", getAvg_h_set());
		h.put("orderno", getOrderno());
		h.put("geosystem", new Integer(getGeosystem()));
		h.put("date_endbuild", getDate_endbuild());
		h.put("storageplace", new Integer(getStorageplace()));
		h.put("address", getAddress());
		h.put("closedate", getClosedate());
		h.put("created", getCreated());
		h.put("modified", getModified());
		h.put("operator", getOperator());
		h.put("divisionKey", getDivisionKey());
		h.put("modifiedby", getModifiedby());
		h.put("createdby", getCreatedby());
		h.put("name", getName());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.Boolean localInAction = (java.lang.Boolean) h.get("inAction");
		java.lang.Integer localOporplaceid =
			(java.lang.Integer) h.get("oporplaceid");
		java.math.BigDecimal localLatitude_WGS84 =
			(java.math.BigDecimal) h.get("latitude_WGS84");
		java.lang.Integer localGsmid = (java.lang.Integer) h.get("gsmid");
		java.lang.String localDampsname = (java.lang.String) h.get("dampsname");
		java.sql.Date localAccesslistexp =
			(java.sql.Date) h.get("accesslistexp");
		java.lang.String localPlanstate = (java.lang.String) h.get("planstate");
		java.lang.Integer localAntplaceid =
			(java.lang.Integer) h.get("antplaceid");
		java.math.BigDecimal localLatitude =
			(java.math.BigDecimal) h.get("latitude");
		java.lang.Integer localApplaceid =
			(java.lang.Integer) h.get("applaceid");
		java.math.BigDecimal localPaya = (java.math.BigDecimal) h.get("paya");
		java.math.BigDecimal localOporaheight =
			(java.math.BigDecimal) h.get("oporaheight");
		java.sql.Date localDogdate = (java.sql.Date) h.get("dogdate");
		java.lang.String localHaveplan = (java.lang.String) h.get("haveplan");
		java.lang.String localLinktogosnetlat =
			(java.lang.String) h.get("linktogosnetlat");
		java.lang.String localGrchlat = (java.lang.String) h.get("grchlat");
		java.lang.String localPosstate = (java.lang.String) h.get("posstate");
		java.math.BigDecimal localLongitude_WGS84 =
			(java.math.BigDecimal) h.get("longitude_WGS84");
		java.lang.String localGrchlong = (java.lang.String) h.get("grchlong");
		java.sql.Date localOporadate = (java.sql.Date) h.get("oporadate");
		java.lang.String localDognumber = (java.lang.String) h.get("dognumber");
		java.lang.Integer localAptypeid = (java.lang.Integer) h.get("aptypeid");
		java.lang.Boolean localOporaour = (java.lang.Boolean) h.get("oporaour");
		java.lang.Integer localDcsid = (java.lang.Integer) h.get("dcsid");
		java.lang.String localRentervolume =
			(java.lang.String) h.get("rentervolume");
		java.lang.String localDocaddress =
			(java.lang.String) h.get("docaddress");
		java.sql.Date localDate_posclose =
			(java.sql.Date) h.get("date_posclose");
		java.lang.String localComment_doc =
			(java.lang.String) h.get("comment_doc");
		java.math.BigDecimal localSqqty = (java.math.BigDecimal) h.get("sqqty");
		java.lang.Integer localApplacetypeid =
			(java.lang.Integer) h.get("applacetypeid");
		java.sql.Date localDatebeginbuild =
			(java.sql.Date) h.get("datebeginbuild");
		java.math.BigDecimal localLongitude =
			(java.math.BigDecimal) h.get("longitude");
		java.lang.String localGrchaddress =
			(java.lang.String) h.get("grchaddress");
		java.lang.String localLinktogosnetlon =
			(java.lang.String) h.get("linktogosnetlon");
		java.lang.Integer localDampsid = (java.lang.Integer) h.get("dampsid");
		java.lang.String localDetails = (java.lang.String) h.get("details");
		Boolean localInmetro = (Boolean) h.get("inmetro");
		Integer localDatasource = (Integer) h.get("datasource");
		java.math.BigDecimal localAvg_h_set =
			(java.math.BigDecimal) h.get("avg_h_set");
		java.lang.String localOrderno = (java.lang.String) h.get("orderno");
		Integer localGeosystem = (Integer) h.get("geosystem");
		java.sql.Date localDate_endbuild =
			(java.sql.Date) h.get("date_endbuild");
		Integer localStorageplace = (Integer) h.get("storageplace");
		java.lang.String localAddress = (java.lang.String) h.get("address");
		java.sql.Date localClosedate = (java.sql.Date) h.get("closedate");
		java.sql.Timestamp localCreated = (java.sql.Timestamp) h.get("created");
		java.sql.Timestamp localModified =
			(java.sql.Timestamp) h.get("modified");
		java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
		java.lang.Integer localModifiedby =
			(java.lang.Integer) h.get("modifiedby");
		java.lang.Integer localCreatedby =
			(java.lang.Integer) h.get("createdby");
		java.lang.String localName = (java.lang.String) h.get("name");

		if (h.containsKey("inAction"))
			setInAction((localInAction));
		if (h.containsKey("oporplaceid"))
			setOporplaceid((localOporplaceid));
		if (h.containsKey("latitude_WGS84"))
			setLatitude_WGS84((localLatitude_WGS84));
		if (h.containsKey("gsmid"))
			setGsmid((localGsmid));
		if (h.containsKey("dampsname"))
			setDampsname((localDampsname));
		if (h.containsKey("accesslistexp"))
			setAccesslistexp((localAccesslistexp));
		if (h.containsKey("planstate"))
			setPlanstate((localPlanstate));
		if (h.containsKey("antplaceid"))
			setAntplaceid((localAntplaceid));
		if (h.containsKey("latitude"))
			setLatitude((localLatitude));
		if (h.containsKey("applaceid"))
			setApplaceid((localApplaceid));
		if (h.containsKey("paya"))
			setPaya((localPaya));
		if (h.containsKey("oporaheight"))
			setOporaheight((localOporaheight));
		if (h.containsKey("dogdate"))
			setDogdate((localDogdate));
		if (h.containsKey("haveplan"))
			setHaveplan((localHaveplan));
		if (h.containsKey("linktogosnetlat"))
			setLinktogosnetlat((localLinktogosnetlat));
		if (h.containsKey("grchlat"))
			setGrchlat((localGrchlat));
		if (h.containsKey("posstate"))
			setPosstate((localPosstate));
		if (h.containsKey("longitude_WGS84"))
			setLongitude_WGS84((localLongitude_WGS84));
		if (h.containsKey("grchlong"))
			setGrchlong((localGrchlong));
		if (h.containsKey("oporadate"))
			setOporadate((localOporadate));
		if (h.containsKey("dognumber"))
			setDognumber((localDognumber));
		if (h.containsKey("aptypeid"))
			setAptypeid((localAptypeid));
		if (h.containsKey("oporaour"))
			setOporaour((localOporaour));
		if (h.containsKey("dcsid"))
			setDcsid((localDcsid));
		if (h.containsKey("rentervolume"))
			setRentervolume((localRentervolume));
		if (h.containsKey("docaddress"))
			setDocaddress((localDocaddress));
		if (h.containsKey("date_posclose"))
			setDate_posclose((localDate_posclose));
		if (h.containsKey("comment_doc"))
			setComment_doc((localComment_doc));
		if (h.containsKey("sqqty"))
			setSqqty((localSqqty));
		if (h.containsKey("applacetypeid"))
			setApplacetypeid((localApplacetypeid));
		if (h.containsKey("datebeginbuild"))
			setDatebeginbuild((localDatebeginbuild));
		if (h.containsKey("longitude"))
			setLongitude((localLongitude));
		if (h.containsKey("grchaddress"))
			setGrchaddress((localGrchaddress));
		if (h.containsKey("linktogosnetlon"))
			setLinktogosnetlon((localLinktogosnetlon));
		if (h.containsKey("dampsid"))
			setDampsid((localDampsid));
		if (h.containsKey("details"))
			setDetails((localDetails));
		if (h.containsKey("inmetro"))
			setInmetro((localInmetro).booleanValue());
		if (h.containsKey("datasource"))
			setDatasource((localDatasource).intValue());
		if (h.containsKey("avg_h_set"))
			setAvg_h_set((localAvg_h_set));
		if (h.containsKey("orderno"))
			setOrderno((localOrderno));
		if (h.containsKey("geosystem"))
			setGeosystem((localGeosystem).intValue());
		if (h.containsKey("date_endbuild"))
			setDate_endbuild((localDate_endbuild));
		if (h.containsKey("storageplace"))
			setStorageplace((localStorageplace).intValue());
		if (h.containsKey("address"))
			setAddress((localAddress));
		if (h.containsKey("closedate"))
			setClosedate((localClosedate));
		if (h.containsKey("created"))
			setCreated((localCreated));
		if (h.containsKey("modified"))
			setModified((localModified));
		if (h.containsKey("operator"))
			setOperator((localOperator));
		if (h.containsKey("modifiedby"))
			setModifiedby((localModifiedby));
		if (h.containsKey("createdby"))
			setCreatedby((localCreatedby));
		if (h.containsKey("name"))
			setName((localName));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getRequestLink());
	links.addElement(getRegionLink());
	links.addElement(getNetZoneLink());
	links.addElement(getPhotoLink());
	links.addElement(getPositionResponsibleWorkersLink());
	links.addElement(getLeaseOnPositionLink());
	links.addElement(getRenterLink());
	links.addElement(getProjectsLink());
	links.addElement(getInternalOutBillLink());
	links.addElement(getInternalWayBillLink());
	links.addElement(getEquipmentSetLink());
	links.addElement(getLeaseArendaAgreementNewsLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	requestLink = null;
	regionLink = null;
	netZoneLink = null;
	photoLink = null;
	positionResponsibleWorkersLink = null;
	leaseOnPositionLink = null;
	renterLink = null;
	projectsLink = null;
	internalOutBillLink = null;
	internalWayBillLink = null;
	equipmentSetLink = null;
	leaseArendaAgreementNewsLink = null;
}
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addEquipmentSet(com.hps.july.persistence.EquipmentSet anEquipmentSet) throws java.rmi.RemoteException {
	this.getEquipmentSetLink().addElement(anEquipmentSet);
}
/**
 * This method was generated for supporting the association named InternalOutBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addInternalOutBill(com.hps.july.persistence.InternalOutBill anInternalOutBill) throws java.rmi.RemoteException {
	this.getInternalOutBillLink().addElement(anInternalOutBill);
}
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addInternalWayBill(com.hps.july.persistence.InternalWayBill anInternalWayBill) throws java.rmi.RemoteException {
	this.getInternalWayBillLink().addElement(anInternalWayBill);
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseArendaAgreementNews(com.hps.july.persistence.LeaseArendaAgreementNew aLeaseArendaAgreementNews) throws java.rmi.RemoteException {
	this.getLeaseArendaAgreementNewsLink().addElement(aLeaseArendaAgreementNews);
}
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addPhoto(com.hps.july.persistence.Photo aPhoto) throws java.rmi.RemoteException {
	this.getPhotoLink().addElement(aPhoto);
}
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addProjects(com.hps.july.persistence.Project aProjects) throws java.rmi.RemoteException {
	this.getProjectsLink().addElement(aProjects);
}
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addRequest(com.hps.july.persistence.Request aRequest) throws java.rmi.RemoteException {
	this.getRequestLink().addElement(aRequest);
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argStorageplace, String argName, String argAddress, Integer argNetZone, 
	java.math.BigDecimal argLatitude, java.math.BigDecimal argLongitude ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	super.ejbCreate( argStorageplace, argName, argAddress );
	_initLinks();
	// All CMP fields should be initialized here.
	dampsname = null;
	details = null;
	latitude = null;
	longitude = null;
	accesslistexp = null;
	netZone_netzone = null;
	renter_organization = null;
	rentervolume = null;
	dampsid = null;
	dcsid = null;
	gsmid = null;

	netZone_netzone = argNetZone;
	latitude = PersistenceUtil.dec(argLatitude,6);
	longitude = PersistenceUtil.dec(argLongitude,6);
	planstate = "2";
	region_regionid = new Integer(1);
	
	linktogosnetlat = null;
	linktogosnetlon = null;
	datebeginbuild = null;
	dognumber = null;
	dogdate = null;
	paya = null;
	sqqty = null;

	date_endbuild = null;
	date_posclose = null;

	antplaceid = null;
	oporplaceid = null;
	oporaheight = null;
	oporadate = null;
	oporaour = null;
	aptypeid = null;
	applacetypeid = null;
	applaceid = null;
	posstate = "E";
	haveplan = null;
	docaddress = null;
	grchaddress = null;
	grchlat = null;
	grchlong = null;
	orderno = null;
	avg_h_set = null;
	comment_doc = null;
	inmetro = false;
	datasource = 0;
	latitude_WGS84 = latitude;
	longitude_WGS84 = longitude;
	geosystem = 1;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argStorageplace, String argName, String argAddress, Integer argNetZone, 
	java.math.BigDecimal argLatitude, java.math.BigDecimal argLongitude, int argRegionId, String argPlanState ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	super.ejbCreate( argStorageplace, argName, argAddress );
	_initLinks();
	// All CMP fields should be initialized here.
	dampsname = null;
	details = null;
	latitude = null;
	longitude = null;
	accesslistexp = null;
	netZone_netzone = null;
	renter_organization = null;
	rentervolume = null;
	dampsid = null;
	dcsid = null;
	gsmid = null;

	netZone_netzone = argNetZone;
	latitude = PersistenceUtil.dec(argLatitude,6);
	longitude = PersistenceUtil.dec(argLongitude,6);
	region_regionid = new Integer(argRegionId);
	planstate = argPlanState;

	linktogosnetlat = null;
	linktogosnetlon = null;
	datebeginbuild = null;
	dognumber = null;
	dogdate = null;
	paya = null;
	sqqty = null;

	date_endbuild = null;
	date_posclose = null;

	antplaceid = null;
	oporplaceid = null;
	oporaheight = null;
	oporadate = null;
	oporaour = null;
	aptypeid = null;
	applacetypeid = null;
	applaceid = null;
	posstate = "E";
	haveplan = null;
	docaddress = null;
	grchaddress = null;
	grchlat = null;
	grchlong = null;
	orderno = null;
	avg_h_set = null;
	comment_doc = null;
	inmetro = false;
	datasource = 0;
	latitude_WGS84 = latitude;
	longitude_WGS84 = longitude;
	geosystem = 1;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argStorageplace, String argName, String argAddress, Integer argNetZone, 
	java.math.BigDecimal argLatitude, java.math.BigDecimal argLongitude, String argPlanState ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	super.ejbCreate( argStorageplace, argName, argAddress );
	_initLinks();
	// All CMP fields should be initialized here.
	dampsname = null;
	details = null;
	latitude = null;
	longitude = null;
	accesslistexp = null;
	netZone_netzone = null;
	renter_organization = null;
	rentervolume = null;
	dampsid = null;
	dcsid = null;
	gsmid = null;

	netZone_netzone = argNetZone;
	latitude = PersistenceUtil.dec(argLatitude,6);
	longitude = PersistenceUtil.dec(argLongitude,6);
	planstate = argPlanState;
	region_regionid = new Integer(1);

	linktogosnetlat = null;
	linktogosnetlon = null;
	datebeginbuild = null;
	dognumber = null;
	dogdate = null;
	paya = null;
	sqqty = null;
	
	date_endbuild = null;
	date_posclose = null;

	antplaceid = null;
	oporplaceid = null;
	oporaheight = null;
	oporadate = null;
	oporaour = null;
	aptypeid = null;
	applacetypeid = null;
	applaceid = null;
	posstate = "E";
	haveplan = null;
	docaddress = null;
	grchaddress = null;
	grchlat = null;
	grchlong = null;
	orderno = null;
	avg_h_set = null;
	comment_doc = null;
	inmetro = false;
	datasource = 0;
	latitude_WGS84 = latitude;
	longitude_WGS84 = longitude;
	geosystem = 1;
}
/**
 * Getter method for accesslistexp
 */
public java.sql.Date getAccesslistexp() {
	return accesslistexp;
}
/**
 * Getter method for antplaceid
 */
public java.lang.Integer getAntplaceid() {
	return antplaceid;
}
/**
 * Getter method for applaceid
 */
public java.lang.Integer getApplaceid() {
	return applaceid;
}
/**
 * Getter method for applacetypeid
 */
public java.lang.Integer getApplacetypeid() {
	return applacetypeid;
}
/**
 * Getter method for aptypeid
 */
public java.lang.Integer getAptypeid() {
	return aptypeid;
}
/**
 * Getter method for avg_h_set
 */
public java.math.BigDecimal getAvg_h_set() {
	return avg_h_set;
}
/**
 * Getter method for comment_doc
 */
public java.lang.String getComment_doc() {
	return comment_doc;
}
/**
 * Getter method for dampsid
 */
public java.lang.Integer getDampsid() {
	return dampsid;
}
/**
 * Getter method for dampsname
 * @return java.lang.String
 */
public java.lang.String getDampsname() {
	return dampsname;
}
/**
 * Getter method for datasource
 */
public int getDatasource() {
	return datasource;
}
/**
 * Getter method for date_endbuild
 */
public java.sql.Date getDate_endbuild() {
	return date_endbuild;
}
/**
 * Getter method for date_posclose
 */
public java.sql.Date getDate_posclose() {
	return date_posclose;
}
/**
 * Getter method for datebeginbuild
 */
public java.sql.Date getDatebeginbuild() {
	return datebeginbuild;
}
/**
 * Getter method for dcsid
 */
public java.lang.Integer getDcsid() {
	return dcsid;
}
/**
 * Getter method for details
 * @return java.lang.String
 */
public java.lang.String getDetails() {
	return details;
}
/**
 * Getter method for docaddress
 */
public java.lang.String getDocaddress() {
	return docaddress;
}
/**
 * Getter method for dogdate
 */
public java.sql.Date getDogdate() {
	return dogdate;
}
/**
 * Getter method for dognumber
 */
public java.lang.String getDognumber() {
	return dognumber;
}
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getEquipmentSet() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getEquipmentSetLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getEquipmentSetLink() {
	if (equipmentSetLink == null)
		equipmentSetLink = new PositionToEquipmentSetLink(this);
	return equipmentSetLink;
}
/**
 * Getter method for grchaddress
 */
public java.lang.String getGrchaddress() {
	return grchaddress;
}
/**
 * Getter method for grchlat
 */
public java.lang.String getGrchlat() {
	return grchlat;
}
/**
 * Getter method for grchlong
 */
public java.lang.String getGrchlong() {
	return grchlong;
}
/**
 * Getter method for gsmid
 */
public java.lang.Integer getGsmid() {
	return gsmid;
}
/**
 * Getter method for haveplan
 */
public java.lang.String getHaveplan() {
	return haveplan;
}
/**
 * Getter method for inAction
 */
public java.lang.Boolean getInAction() {
	return inAction;
}
/**
 * Getter method for inmetro
 */
public boolean getInmetro() {
	return inmetro;
}
/**
 * This method was generated for supporting the association named InternalOutBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getInternalOutBill() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getInternalOutBillLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named InternalOutBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getInternalOutBillLink() {
	if (internalOutBillLink == null)
		internalOutBillLink = new PositionToInternalOutBillLink(this);
	return internalOutBillLink;
}
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getInternalWayBill() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getInternalWayBillLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getInternalWayBillLink() {
	if (internalWayBillLink == null)
		internalWayBillLink = new PositionToInternalWayBillLink(this);
	return internalWayBillLink;
}
/**
 * Getter method for latitude
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getLatitude() {
	return latitude;
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseArendaAgreementNews() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseArendaAgreementNewsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseArendaAgreementNewsLink() {
	if (leaseArendaAgreementNewsLink == null)
		leaseArendaAgreementNewsLink = new PositionToLeaseArendaAgreementNewsLink(this);
	return leaseArendaAgreementNewsLink;
}
/**
 * This method was generated for supporting the association named LeaseOnPosition2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseOnPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseOnPositionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseOnPosition2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseOnPositionLink() {
	if (leaseOnPositionLink == null)
		leaseOnPositionLink = new PositionToLeaseOnPositionLink(this);
	return leaseOnPositionLink;
}
/**
 * Getter method for linktogosnetlat
 */
public java.lang.String getLinktogosnetlat() {
	return linktogosnetlat;
}
/**
 * Getter method for linktogosnetlon
 */
public java.lang.String getLinktogosnetlon() {
	return linktogosnetlon;
}
/**
 * Getter method for longitude
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getLongitude() {
	return longitude;
}
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.NetZone getNetZone() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.NetZone)this.getNetZoneLink().value();
}
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.NetZoneKey getNetZoneKey() {
	com.hps.july.persistence.NetZoneKey temp = null;
	temp = new com.hps.july.persistence.NetZoneKey();
	boolean netZone_NULLTEST = true;
	netZone_NULLTEST &= (netZone_netzone == null);
	temp.netzone = ((netZone_netzone == null) ? 0 : netZone_netzone.intValue());
	if (netZone_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getNetZoneLink() {
	if (netZoneLink == null)
		netZoneLink = new PositionToNetZoneLink(this);
	return netZoneLink;
}
/**
 * Getter method for oporadate
 */
public java.sql.Date getOporadate() {
	return oporadate;
}
/**
 * Getter method for oporaheight
 */
public java.math.BigDecimal getOporaheight() {
	return oporaheight;
}
/**
 * Getter method for oporaour
 */
public java.lang.Boolean getOporaour() {
	return oporaour;
}
/**
 * Getter method for oporplaceid
 */
public java.lang.Integer getOporplaceid() {
	return oporplaceid;
}
/**
 * Getter method for orderno
 */
public java.lang.String getOrderno() {
	return orderno;
}
/**
 * Getter method for paya
 */
public java.math.BigDecimal getPaya() {
	return paya;
}
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPhoto() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPhotoLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPhotoLink() {
	if (photoLink == null)
		photoLink = new PositionToPhotoLink(this);
	return photoLink;
}
/**
 * Getter method for planstate
 */
public java.lang.String getPlanstate() {
	return planstate;
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPositionResponsibleWorkers() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPositionResponsibleWorkersLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPositionResponsibleWorkersLink() {
	if (positionResponsibleWorkersLink == null)
		positionResponsibleWorkersLink = new PositionToPositionResponsibleWorkersLink(this);
	return positionResponsibleWorkersLink;
}
/**
 * Getter method for posstate
 */
public java.lang.String getPosstate() {
	return posstate;
}
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getProjects() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getProjectsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getProjectsLink() {
	if (projectsLink == null)
		projectsLink = new PositionToProjectsLink(this);
	return projectsLink;
}
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Region getRegion() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Region)this.getRegionLink().value();
}
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.RegionKey getRegionKey() {
	com.hps.july.persistence.RegionKey temp = null;
	temp = new com.hps.july.persistence.RegionKey();
	boolean region_NULLTEST = true;
	region_NULLTEST &= (region_regionid == null);
	temp.regionid = ((region_regionid == null) ? 0 : region_regionid.intValue());
	if (region_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getRegionLink() {
	if (regionLink == null)
		regionLink = new PositionToRegionLink(this);
	return regionLink;
}
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getRenter() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Organization)this.getRenterLink().value();
}
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OrganizationKey getRenterKey() {
	com.hps.july.persistence.OrganizationKey temp = null;
	temp = new com.hps.july.persistence.OrganizationKey();
	boolean renter_NULLTEST = true;
	renter_NULLTEST &= (renter_organization == null);
	temp.organization = ((renter_organization == null) ? 0 : renter_organization.intValue());
	if (renter_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getRenterLink() {
	if (renterLink == null)
		renterLink = new PositionToRenterLink(this);
	return renterLink;
}
/**
 * Getter method for rentervolume
 */
public java.lang.String getRentervolume() {
	return rentervolume;
}
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getRequest() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getRequestLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getRequestLink() {
	if (requestLink == null)
		requestLink = new PositionToRequestLink(this);
	return requestLink;
}
/**
 * Getter method for sqqty
 */
public java.math.BigDecimal getSqqty() {
	return sqqty;
}
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetNetZoneKey(com.hps.july.persistence.NetZoneKey inKey) {
	boolean netZone_NULLTEST = (inKey == null);
	if (netZone_NULLTEST) netZone_netzone = null; else netZone_netzone = (new Integer(inKey.netzone));
}
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetRegionKey(com.hps.july.persistence.RegionKey inKey) {
	boolean region_NULLTEST = (inKey == null);
	if (region_NULLTEST) region_regionid = null; else region_regionid = (new Integer(inKey.regionid));
}
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetRenterKey(com.hps.july.persistence.OrganizationKey inKey) {
	boolean renter_NULLTEST = (inKey == null);
	if (renter_NULLTEST) renter_organization = null; else renter_organization = (new Integer(inKey.organization));
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeLeaseArendaAgreementNews(com.hps.july.persistence.LeaseArendaAgreementNew aLeaseArendaAgreementNews) throws java.rmi.RemoteException {
	this.getLeaseArendaAgreementNewsLink().removeElement(aLeaseArendaAgreementNews);
}
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddEquipmentSet(com.hps.july.persistence.EquipmentSet anEquipmentSet) {
	this.getEquipmentSetLink().secondaryAddElement(anEquipmentSet);
}
/**
 * This method was generated for supporting the association named InternalOutBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddInternalOutBill(com.hps.july.persistence.InternalOutBill anInternalOutBill) {
	this.getInternalOutBillLink().secondaryAddElement(anInternalOutBill);
}
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddInternalWayBill(com.hps.july.persistence.InternalWayBill anInternalWayBill) {
	this.getInternalWayBillLink().secondaryAddElement(anInternalWayBill);
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseArendaAgreementNews(com.hps.july.persistence.LeaseArendaAgreementNew aLeaseArendaAgreementNews) {
	this.getLeaseArendaAgreementNewsLink().secondaryAddElement(aLeaseArendaAgreementNews);
}
/**
 * This method was generated for supporting the association named LeaseOnPosition2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseOnPosition(com.hps.july.persistence.LeaseOnPosition aLeaseOnPosition) {
	this.getLeaseOnPositionLink().secondaryAddElement(aLeaseOnPosition);
}
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPhoto(com.hps.july.persistence.Photo aPhoto) {
	this.getPhotoLink().secondaryAddElement(aPhoto);
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPositionResponsibleWorkers(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorkers) {
	this.getPositionResponsibleWorkersLink().secondaryAddElement(aPositionResponsibleWorkers);
}
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddProjects(com.hps.july.persistence.Project aProjects) {
	this.getProjectsLink().secondaryAddElement(aProjects);
}
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddRequest(com.hps.july.persistence.Request aRequest) {
	this.getRequestLink().secondaryAddElement(aRequest);
}
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveEquipmentSet(com.hps.july.persistence.EquipmentSet anEquipmentSet) {
	this.getEquipmentSetLink().secondaryRemoveElement(anEquipmentSet);
}
/**
 * This method was generated for supporting the association named InternalOutBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveInternalOutBill(com.hps.july.persistence.InternalOutBill anInternalOutBill) {
	this.getInternalOutBillLink().secondaryRemoveElement(anInternalOutBill);
}
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveInternalWayBill(com.hps.july.persistence.InternalWayBill anInternalWayBill) {
	this.getInternalWayBillLink().secondaryRemoveElement(anInternalWayBill);
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseArendaAgreementNews(com.hps.july.persistence.LeaseArendaAgreementNew aLeaseArendaAgreementNews) {
	this.getLeaseArendaAgreementNewsLink().secondaryRemoveElement(aLeaseArendaAgreementNews);
}
/**
 * This method was generated for supporting the association named LeaseOnPosition2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseOnPosition(com.hps.july.persistence.LeaseOnPosition aLeaseOnPosition) {
	this.getLeaseOnPositionLink().secondaryRemoveElement(aLeaseOnPosition);
}
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePhoto(com.hps.july.persistence.Photo aPhoto) {
	this.getPhotoLink().secondaryRemoveElement(aPhoto);
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePositionResponsibleWorkers(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorkers) {
	this.getPositionResponsibleWorkersLink().secondaryRemoveElement(aPositionResponsibleWorkers);
}
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveProjects(com.hps.july.persistence.Project aProjects) {
	this.getProjectsLink().secondaryRemoveElement(aProjects);
}
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveRequest(com.hps.july.persistence.Request aRequest) {
	this.getRequestLink().secondaryRemoveElement(aRequest);
}
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetNetZone(com.hps.july.persistence.NetZone aNetZone) throws java.rmi.RemoteException {
	this.getNetZoneLink().secondarySet(aNetZone);
}
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetRegion(com.hps.july.persistence.Region aRegion) throws java.rmi.RemoteException {
	this.getRegionLink().secondarySet(aRegion);
}
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetRenter(com.hps.july.persistence.Organization aRenter) throws java.rmi.RemoteException {
	this.getRenterLink().secondarySet(aRenter);
}
/**
 * Setter method for accesslistexp
 */
public void setAccesslistexp(java.sql.Date newValue) {
	this.accesslistexp = newValue;
}
/**
 * Setter method for antplaceid
 */
public void setAntplaceid(java.lang.Integer newValue) {
	this.antplaceid = newValue;
}
/**
 * Setter method for applaceid
 */
public void setApplaceid(java.lang.Integer newValue) {
	this.applaceid = newValue;
}
/**
 * Setter method for applacetypeid
 */
public void setApplacetypeid(java.lang.Integer newValue) {
	this.applacetypeid = newValue;
}
/**
 * Setter method for aptypeid
 */
public void setAptypeid(java.lang.Integer newValue) {
	this.aptypeid = newValue;
}
/**
 * Setter method for avg_h_set
 */
public void setAvg_h_set(java.math.BigDecimal newValue) {
	this.avg_h_set = newValue;
}
/**
 * Setter method for comment_doc
 */
public void setComment_doc(java.lang.String newValue) {
	this.comment_doc = newValue;
}
/**
 * Setter method for dampsid
 */
public void setDampsid(java.lang.Integer newValue) {
	this.dampsid = newValue;
}
/**
 * Setter method for dampsname
 * @param newValue java.lang.String
 */
public void setDampsname(java.lang.String newValue) {
	this.dampsname = newValue;
}
/**
 * Setter method for datasource
 */
public void setDatasource(int newValue) {
	this.datasource = newValue;
}
/**
 * Setter method for date_endbuild
 */
public void setDate_endbuild(java.sql.Date newValue) {
	this.date_endbuild = newValue;
}
/**
 * Setter method for date_posclose
 */
public void setDate_posclose(java.sql.Date newValue) {
	this.date_posclose = newValue;
}
/**
 * Setter method for datebeginbuild
 */
public void setDatebeginbuild(java.sql.Date newValue) {
	this.datebeginbuild = newValue;
}
/**
 * Setter method for dcsid
 */
public void setDcsid(java.lang.Integer newValue) {
	this.dcsid = newValue;
}
/**
 * Setter method for details
 * @param newValue java.lang.String
 */
public void setDetails(java.lang.String newValue) {
	this.details = newValue;
}
/**
 * Setter method for docaddress
 */
public void setDocaddress(java.lang.String newValue) {
	this.docaddress = newValue;
}
/**
 * Setter method for dogdate
 */
public void setDogdate(java.sql.Date newValue) {
	this.dogdate = newValue;
}
/**
 * Setter method for dognumber
 */
public void setDognumber(java.lang.String newValue) {
	this.dognumber = newValue;
}
/**
 * Setter method for grchaddress
 */
public void setGrchaddress(java.lang.String newValue) {
	this.grchaddress = newValue;
}
/**
 * Setter method for grchlat
 */
public void setGrchlat(java.lang.String newValue) {
	this.grchlat = newValue;
}
/**
 * Setter method for grchlong
 */
public void setGrchlong(java.lang.String newValue) {
	this.grchlong = newValue;
}
/**
 * Setter method for gsmid
 */
public void setGsmid(java.lang.Integer newValue) {
	this.gsmid = newValue;
}
/**
 * Setter method for haveplan
 */
public void setHaveplan(java.lang.String newValue) {
	this.haveplan = newValue;
}
/**
 * Setter method for inAction
 */
public void setInAction(java.lang.Boolean newValue) {
	this.inAction = newValue;
}
/**
 * Setter method for inmetro
 */
public void setInmetro(boolean newValue) {
	this.inmetro = newValue;
}
/**
 * Setter method for latitude
 * @param newValue java.math.BigDecimal
 */
public void setLatitude(java.math.BigDecimal newValue) {
	this.latitude = PersistenceUtil.dec(newValue,6);
}
/**
 * Setter method for linktogosnetlat
 */
public void setLinktogosnetlat(java.lang.String newValue) {
	this.linktogosnetlat = newValue;
}
/**
 * Setter method for linktogosnetlon
 */
public void setLinktogosnetlon(java.lang.String newValue) {
	this.linktogosnetlon = newValue;
}
/**
 * Setter method for longitude
 * @param newValue java.math.BigDecimal
 */
public void setLongitude(java.math.BigDecimal newValue) {
	this.longitude = PersistenceUtil.dec(newValue,6);
}
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setNetZone(com.hps.july.persistence.NetZone aNetZone) throws java.rmi.RemoteException {
	this.getNetZoneLink().set(aNetZone);
}
/**
 * Setter method for oporadate
 */
public void setOporadate(java.sql.Date newValue) {
	this.oporadate = newValue;
}
/**
 * Setter method for oporaheight
 */
public void setOporaheight(java.math.BigDecimal newValue) {
	this.oporaheight = newValue;
}
/**
 * Setter method for oporaour
 */
public void setOporaour(java.lang.Boolean newValue) {
	this.oporaour = newValue;
}
/**
 * Setter method for oporplaceid
 */
public void setOporplaceid(java.lang.Integer newValue) {
	this.oporplaceid = newValue;
}
/**
 * Setter method for orderno
 */
public void setOrderno(java.lang.String newValue) {
	this.orderno = newValue;
}
/**
 * Setter method for paya
 */
public void setPaya(java.math.BigDecimal newValue) {
	this.paya = newValue;
}
/**
 * Setter method for planstate
 */
public void setPlanstate(java.lang.String newValue) {
	this.planstate = newValue;
}
/**
 * Setter method for posstate
 */
public void setPosstate(java.lang.String newValue) {
	this.posstate = newValue;
}
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setRegion(com.hps.july.persistence.Region aRegion) throws java.rmi.RemoteException {
	this.getRegionLink().set(aRegion);
}
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setRenter(com.hps.july.persistence.Organization aRenter) throws java.rmi.RemoteException {
	this.getRenterLink().set(aRenter);
}
/**
 * Setter method for rentervolume
 */
public void setRentervolume(java.lang.String newValue) {
	this.rentervolume = newValue;
}
/**
 * Setter method for sqqty
 */
public void setSqqty(java.math.BigDecimal newValue) {
	this.sqqty = newValue;
}
	/**
	 * Get accessor for persistent attribute: latitude_WGS84
	 */
	public java.math.BigDecimal getLatitude_WGS84() {
		return latitude_WGS84;
	}
	/**
	 * Set accessor for persistent attribute: latitude_WGS84
	 */
	public void setLatitude_WGS84(java.math.BigDecimal newLatitude_WGS84) {
		latitude_WGS84 = newLatitude_WGS84;
	}
	/**
	 * Get accessor for persistent attribute: longitude_WGS84
	 */
	public java.math.BigDecimal getLongitude_WGS84() {
		return longitude_WGS84;
	}
	/**
	 * Set accessor for persistent attribute: longitude_WGS84
	 */
	public void setLongitude_WGS84(java.math.BigDecimal newLongitude_WGS84) {
		longitude_WGS84 = newLongitude_WGS84;
	}
	/**
	 * Get accessor for persistent attribute: geosystem
	 */
	public int getGeosystem() {
		return geosystem;
	}
	/**
	 * Set accessor for persistent attribute: geosystem
	 */
	public void setGeosystem(int newGeosystem) {
		geosystem = newGeosystem;
	}
}
