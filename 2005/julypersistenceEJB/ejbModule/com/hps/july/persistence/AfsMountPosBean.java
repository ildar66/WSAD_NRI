package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Позиции документа "Акт монтажа АФС"
 */
public class AfsMountPosBean extends InternalWayBillPositionBean {
	public java.math.BigDecimal az_ant;
	public String az_variation;
	public Boolean ddk;
	public String docpostype;//
	public Integer groundcnt;
	public java.math.BigDecimal h_set1;
	public Boolean has_buster;
	public Boolean has_flt;
	public Boolean has_lna;
	public java.math.BigDecimal input_power;
	public String kind_ant;//
	public java.math.BigDecimal kswn;
	public java.math.BigDecimal len_cable;
	public java.math.BigDecimal nakl;
	public String nakl_variation;
	public String num_ant;
	public Integer parentdocpos;
	public Boolean sectorA;
	public Boolean sectorB;
	public Boolean sectorC;
	public Boolean sectorD;
	public Boolean sectorE;
	public Boolean sectorF;
	public Boolean sectorG;
	public Boolean sectorH;
	public Boolean sectorO;
	public Boolean sectorO1800;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer groundresource_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink groundresourceLink = null;
	public java.math.BigDecimal ksvn1800;
	public java.math.BigDecimal ksvn900;
	public java.math.BigDecimal ksvn800;
	public java.math.BigDecimal ksvn2000;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("ddk", getDdk());
		h.put("kind_ant", getKind_ant());
		h.put("nakl", getNakl());
		h.put("az_variation", getAz_variation());
		h.put("nakl_variation", getNakl_variation());
		h.put("ksvn2000", getKsvn2000());
		h.put("ksvn900", getKsvn900());
		h.put("docpostype", getDocpostype());
		h.put("num_ant", getNum_ant());
		h.put("sectorO", getSectorO());
		h.put("parentdocpos", getParentdocpos());
		h.put("has_buster", getHas_buster());
		h.put("has_flt", getHas_flt());
		h.put("sectorH", getSectorH());
		h.put("input_power", getInput_power());
		h.put("sectorG", getSectorG());
		h.put("ksvn1800", getKsvn1800());
		h.put("sectorF", getSectorF());
		h.put("sectorE", getSectorE());
		h.put("sectorO1800", getSectorO1800());
		h.put("sectorD", getSectorD());
		h.put("sectorC", getSectorC());
		h.put("groundresourceKey", getGroundresourceKey());
		h.put("sectorB", getSectorB());
		h.put("sectorA", getSectorA());
		h.put("groundcnt", getGroundcnt());
		h.put("kswn", getKswn());
		h.put("ksvn800", getKsvn800());
		h.put("len_cable", getLen_cable());
		h.put("h_set1", getH_set1());
		h.put("has_lna", getHas_lna());
		h.put("az_ant", getAz_ant());
		h.put("docQty", getDocQty());
		h.put("resourceKey", getResourceKey());
		h.put("documentKey", getDocumentKey());
		h.put("realserial", getRealserial());
		h.put("sourceBroken", getSourceBroken());
		h.put("cardFromKey", getCardFromKey());
		h.put("resultClosed", getResultClosed());
		h.put("visualtagid", getVisualtagid());
		h.put("isfictserial", new Boolean(getIsfictserial()));
		h.put("cardToKey", getCardToKey());
		h.put("serialnumber", getSerialnumber());
		h.put("isReadOnly", new Boolean(getIsReadOnly()));
		h.put("agregateKey", getAgregateKey());
		h.put("sum", getSum());
		h.put("newplace", getNewplace());
		h.put("sourceClosed", getSourceClosed());
		h.put("agregateSerial", getAgregateSerial());
		h.put("manufserial", getManufserial());
		h.put("price", getPrice());
		h.put("resultBoxed", getResultBoxed());
		h.put("comment", getComment());
		h.put("docposition", new Integer(getDocposition()));
		h.put("oldplace", getOldplace());
		h.put("oldAgregateSerial", getOldAgregateSerial());
		h.put("order", new Integer(getOrder()));
		h.put("agregateresource", getAgregateresource());
		h.put("qty", getQty());
		h.put("party", getParty());
		h.put("configuration", getConfiguration());
		h.put("notes", getNotes());
		h.put("resultBroken", getResultBroken());
		h.put("oldagregateresource", getOldagregateresource());
		h.put("ownerKey", getOwnerKey());
		h.put("sourceBoxed", getSourceBoxed());
		h.put("oldagrlocserial", getOldagrlocserial());
		h.put("oldagrmanufserial", getOldagrmanufserial());
		h.put("agrlocserial", getAgrlocserial());
		h.put("localserial", getLocalserial());
		h.put("agrmanufserial", getAgrmanufserial());
		h.put("parentbtsdocpos", getParentbtsdocpos());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.Boolean localDdk = (java.lang.Boolean) h.get("ddk");
		java.lang.String localKind_ant = (java.lang.String) h.get("kind_ant");
		java.math.BigDecimal localNakl = (java.math.BigDecimal) h.get("nakl");
		java.lang.String localAz_variation =
			(java.lang.String) h.get("az_variation");
		java.lang.String localNakl_variation =
			(java.lang.String) h.get("nakl_variation");
		java.math.BigDecimal localKsvn2000 =
			(java.math.BigDecimal) h.get("ksvn2000");
		java.math.BigDecimal localKsvn900 =
			(java.math.BigDecimal) h.get("ksvn900");
		java.lang.String localDocpostype =
			(java.lang.String) h.get("docpostype");
		java.lang.String localNum_ant = (java.lang.String) h.get("num_ant");
		java.lang.Boolean localSectorO = (java.lang.Boolean) h.get("sectorO");
		java.lang.Integer localParentdocpos =
			(java.lang.Integer) h.get("parentdocpos");
		java.lang.Boolean localHas_buster =
			(java.lang.Boolean) h.get("has_buster");
		java.lang.Boolean localHas_flt = (java.lang.Boolean) h.get("has_flt");
		java.lang.Boolean localSectorH = (java.lang.Boolean) h.get("sectorH");
		java.math.BigDecimal localInput_power =
			(java.math.BigDecimal) h.get("input_power");
		java.lang.Boolean localSectorG = (java.lang.Boolean) h.get("sectorG");
		java.math.BigDecimal localKsvn1800 =
			(java.math.BigDecimal) h.get("ksvn1800");
		java.lang.Boolean localSectorF = (java.lang.Boolean) h.get("sectorF");
		java.lang.Boolean localSectorE = (java.lang.Boolean) h.get("sectorE");
		java.lang.Boolean localSectorO1800 =
			(java.lang.Boolean) h.get("sectorO1800");
		java.lang.Boolean localSectorD = (java.lang.Boolean) h.get("sectorD");
		java.lang.Boolean localSectorC = (java.lang.Boolean) h.get("sectorC");
		java.lang.Boolean localSectorB = (java.lang.Boolean) h.get("sectorB");
		java.lang.Boolean localSectorA = (java.lang.Boolean) h.get("sectorA");
		java.lang.Integer localGroundcnt =
			(java.lang.Integer) h.get("groundcnt");
		java.math.BigDecimal localKswn = (java.math.BigDecimal) h.get("kswn");
		java.math.BigDecimal localKsvn800 =
			(java.math.BigDecimal) h.get("ksvn800");
		java.math.BigDecimal localLen_cable =
			(java.math.BigDecimal) h.get("len_cable");
		java.math.BigDecimal localH_set1 =
			(java.math.BigDecimal) h.get("h_set1");
		java.lang.Boolean localHas_lna = (java.lang.Boolean) h.get("has_lna");
		java.math.BigDecimal localAz_ant =
			(java.math.BigDecimal) h.get("az_ant");
		java.math.BigDecimal localDocQty =
			(java.math.BigDecimal) h.get("docQty");
		java.lang.String localRealserial =
			(java.lang.String) h.get("realserial");
		java.lang.Boolean localSourceBroken =
			(java.lang.Boolean) h.get("sourceBroken");
		java.lang.Boolean localResultClosed =
			(java.lang.Boolean) h.get("resultClosed");
		java.lang.Integer localVisualtagid =
			(java.lang.Integer) h.get("visualtagid");
		Boolean localIsfictserial = (Boolean) h.get("isfictserial");
		java.lang.String localSerialnumber =
			(java.lang.String) h.get("serialnumber");
		java.lang.String localNewplace = (java.lang.String) h.get("newplace");
		java.lang.Boolean localSourceClosed =
			(java.lang.Boolean) h.get("sourceClosed");
		java.lang.String localAgregateSerial =
			(java.lang.String) h.get("agregateSerial");
		java.lang.String localManufserial =
			(java.lang.String) h.get("manufserial");
		java.math.BigDecimal localPrice = (java.math.BigDecimal) h.get("price");
		java.lang.Boolean localResultBoxed =
			(java.lang.Boolean) h.get("resultBoxed");
		java.lang.String localComment = (java.lang.String) h.get("comment");
		Integer localDocposition = (Integer) h.get("docposition");
		java.lang.String localOldplace = (java.lang.String) h.get("oldplace");
		java.lang.String localOldAgregateSerial =
			(java.lang.String) h.get("oldAgregateSerial");
		Integer localOrder = (Integer) h.get("order");
		java.lang.Integer localAgregateresource =
			(java.lang.Integer) h.get("agregateresource");
		java.math.BigDecimal localQty = (java.math.BigDecimal) h.get("qty");
		java.lang.String localParty = (java.lang.String) h.get("party");
		java.lang.String localConfiguration =
			(java.lang.String) h.get("configuration");
		java.lang.String localNotes = (java.lang.String) h.get("notes");
		java.lang.Boolean localResultBroken =
			(java.lang.Boolean) h.get("resultBroken");
		java.lang.Integer localOldagregateresource =
			(java.lang.Integer) h.get("oldagregateresource");
		java.lang.Boolean localSourceBoxed =
			(java.lang.Boolean) h.get("sourceBoxed");
		java.lang.String localOldagrlocserial =
			(java.lang.String) h.get("oldagrlocserial");
		java.lang.String localOldagrmanufserial =
			(java.lang.String) h.get("oldagrmanufserial");
		java.lang.String localAgrlocserial =
			(java.lang.String) h.get("agrlocserial");
		java.lang.String localLocalserial =
			(java.lang.String) h.get("localserial");
		java.lang.String localAgrmanufserial =
			(java.lang.String) h.get("agrmanufserial");
		java.lang.Integer localParentbtsdocpos =
			(java.lang.Integer) h.get("parentbtsdocpos");

		if (h.containsKey("ddk"))
			setDdk((localDdk));
		if (h.containsKey("kind_ant"))
			setKind_ant((localKind_ant));
		if (h.containsKey("nakl"))
			setNakl((localNakl));
		if (h.containsKey("az_variation"))
			setAz_variation((localAz_variation));
		if (h.containsKey("nakl_variation"))
			setNakl_variation((localNakl_variation));
		if (h.containsKey("ksvn2000"))
			setKsvn2000((localKsvn2000));
		if (h.containsKey("ksvn900"))
			setKsvn900((localKsvn900));
		if (h.containsKey("docpostype"))
			setDocpostype((localDocpostype));
		if (h.containsKey("num_ant"))
			setNum_ant((localNum_ant));
		if (h.containsKey("sectorO"))
			setSectorO((localSectorO));
		if (h.containsKey("parentdocpos"))
			setParentdocpos((localParentdocpos));
		if (h.containsKey("has_buster"))
			setHas_buster((localHas_buster));
		if (h.containsKey("has_flt"))
			setHas_flt((localHas_flt));
		if (h.containsKey("sectorH"))
			setSectorH((localSectorH));
		if (h.containsKey("input_power"))
			setInput_power((localInput_power));
		if (h.containsKey("sectorG"))
			setSectorG((localSectorG));
		if (h.containsKey("ksvn1800"))
			setKsvn1800((localKsvn1800));
		if (h.containsKey("sectorF"))
			setSectorF((localSectorF));
		if (h.containsKey("sectorE"))
			setSectorE((localSectorE));
		if (h.containsKey("sectorO1800"))
			setSectorO1800((localSectorO1800));
		if (h.containsKey("sectorD"))
			setSectorD((localSectorD));
		if (h.containsKey("sectorC"))
			setSectorC((localSectorC));
		if (h.containsKey("sectorB"))
			setSectorB((localSectorB));
		if (h.containsKey("sectorA"))
			setSectorA((localSectorA));
		if (h.containsKey("groundcnt"))
			setGroundcnt((localGroundcnt));
		if (h.containsKey("kswn"))
			setKswn((localKswn));
		if (h.containsKey("ksvn800"))
			setKsvn800((localKsvn800));
		if (h.containsKey("len_cable"))
			setLen_cable((localLen_cable));
		if (h.containsKey("h_set1"))
			setH_set1((localH_set1));
		if (h.containsKey("has_lna"))
			setHas_lna((localHas_lna));
		if (h.containsKey("az_ant"))
			setAz_ant((localAz_ant));
		if (h.containsKey("docQty"))
			setDocQty((localDocQty));
		if (h.containsKey("realserial"))
			setRealserial((localRealserial));
		if (h.containsKey("sourceBroken"))
			setSourceBroken((localSourceBroken));
		if (h.containsKey("resultClosed"))
			setResultClosed((localResultClosed));
		if (h.containsKey("visualtagid"))
			setVisualtagid((localVisualtagid));
		if (h.containsKey("isfictserial"))
			setIsfictserial((localIsfictserial).booleanValue());
		if (h.containsKey("serialnumber"))
			setSerialnumber((localSerialnumber));
		if (h.containsKey("newplace"))
			setNewplace((localNewplace));
		if (h.containsKey("sourceClosed"))
			setSourceClosed((localSourceClosed));
		if (h.containsKey("agregateSerial"))
			setAgregateSerial((localAgregateSerial));
		if (h.containsKey("manufserial"))
			setManufserial((localManufserial));
		if (h.containsKey("price"))
			setPrice((localPrice));
		if (h.containsKey("resultBoxed"))
			setResultBoxed((localResultBoxed));
		if (h.containsKey("comment"))
			setComment((localComment));
		if (h.containsKey("docposition"))
			setDocposition((localDocposition).intValue());
		if (h.containsKey("oldplace"))
			setOldplace((localOldplace));
		if (h.containsKey("oldAgregateSerial"))
			setOldAgregateSerial((localOldAgregateSerial));
		if (h.containsKey("order"))
			setOrder((localOrder).intValue());
		if (h.containsKey("agregateresource"))
			setAgregateresource((localAgregateresource));
		if (h.containsKey("qty"))
			setQty((localQty));
		if (h.containsKey("party"))
			setParty((localParty));
		if (h.containsKey("configuration"))
			setConfiguration((localConfiguration));
		if (h.containsKey("notes"))
			setNotes((localNotes));
		if (h.containsKey("resultBroken"))
			setResultBroken((localResultBroken));
		if (h.containsKey("oldagregateresource"))
			setOldagregateresource((localOldagregateresource));
		if (h.containsKey("sourceBoxed"))
			setSourceBoxed((localSourceBoxed));
		if (h.containsKey("oldagrlocserial"))
			setOldagrlocserial((localOldagrlocserial));
		if (h.containsKey("oldagrmanufserial"))
			setOldagrmanufserial((localOldagrmanufserial));
		if (h.containsKey("agrlocserial"))
			setAgrlocserial((localAgrlocserial));
		if (h.containsKey("localserial"))
			setLocalserial((localLocalserial));
		if (h.containsKey("agrmanufserial"))
			setAgrmanufserial((localAgrmanufserial));
		if (h.containsKey("parentbtsdocpos"))
			setParentbtsdocpos((localParentbtsdocpos));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getGroundresourceLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	groundresourceLink = null;
}
public void ejbCreate(int argDocposition, Integer argResource, Integer argOwner, Integer argDocument, 
	int argOrder, java.math.BigDecimal argQty, java.math.BigDecimal argPrice, 
	Boolean argSourceBoxed, Boolean argResultBoxed, Boolean argSourceBroken , Boolean argResultBroken, 
	Boolean argSourceClosed, Boolean argResultClosed ) throws javax.ejb.CreateException, java.rmi.RemoteException {

		super.ejbCreate(argDocposition, argResource, argOwner, argDocument, argOrder, argQty, argPrice, 
			argSourceBoxed, argResultBoxed, argSourceBroken , argResultBroken, argSourceClosed, argResultClosed );

	az_ant = null;
	az_variation = null;
	ddk = null;
	docpostype = null;
	groundcnt = null;
	h_set1 = null;
	has_buster = null;
	has_flt = null;
	has_lna = null;
	input_power = null;
	kind_ant = null;
	kswn = null;
	len_cable = null;
	nakl = null;
	nakl_variation = null;
	num_ant = null;
	parentdocpos = null;
	sectorA = null;
	sectorB = null;
	sectorC = null;
	sectorD = null;
	sectorE = null;
	sectorF = null;
	sectorG = null;
	sectorH = null;
	sectorO = null;
	sectorO1800 = null;
	groundresource_resource = null;
	ksvn1800 = null;
	ksvn900 = null;	
	ksvn800 = null;	
	ksvn2000 = null;	
}
/**
 * Getter method for az_ant
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAz_ant() {
	return az_ant;
}
/**
 * Getter method for az_variation
 * @return java.lang.String
 */
public java.lang.String getAz_variation() {
	return az_variation;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDdk() {
	return ddk;
}
/**
 * Getter method for docpostype
 * @return java.lang.String
 */
public java.lang.String getDocpostype() {
	return docpostype;
}
/**
 * Getter method for groundcnt
 * @return java.lang.Integer
 */
public java.lang.Integer getGroundcnt() {
	return groundcnt;
}
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getGroundresource() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Resource)this.getGroundresourceLink().value();
}
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getGroundresourceKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean groundresource_NULLTEST = true;
	groundresource_NULLTEST &= (groundresource_resource == null);
	temp.resource = ((groundresource_resource == null) ? 0 : groundresource_resource.intValue());
	if (groundresource_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getGroundresourceLink() {
	if (groundresourceLink == null)
		groundresourceLink = new AfsMountPosToGroundresourceLink(this);
	return groundresourceLink;
}
/**
 * Getter method for h_set1
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getH_set1() {
	return h_set1;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getHas_buster() {
	return has_buster;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getHas_flt() {
	return has_flt;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getHas_lna() {
	return has_lna;
}
/**
 * Getter method for input_power
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getInput_power() {
	return input_power;
}
/**
 * Getter method for kind_ant
 * @return java.lang.String
 */
public java.lang.String getKind_ant() {
	return kind_ant;
}
/**
 * Getter method for ksvn1800
 */
public java.math.BigDecimal getKsvn1800() {
	return ksvn1800;
}
/**
 * Getter method for ksvn2000
 */
public java.math.BigDecimal getKsvn2000() {
	return ksvn2000;
}
/**
 * Getter method for ksvn800
 */
public java.math.BigDecimal getKsvn800() {
	return ksvn800;
}
/**
 * Getter method for ksvn900
 */
public java.math.BigDecimal getKsvn900() {
	return ksvn900;
}
/**
 * Getter method for kswn
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getKswn() {
	return kswn;
}
/**
 * Getter method for len_cable
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getLen_cable() {
	return len_cable;
}
/**
 * Getter method for nakl
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNakl() {
	return nakl;
}
/**
 * Getter method for nakl_variation
 * @return java.lang.String
 */
public java.lang.String getNakl_variation() {
	return nakl_variation;
}
/**
 * Getter method for num_ant
 * @return java.lang.String
 */
public java.lang.String getNum_ant() {
	return num_ant;
}
/**
 * Getter method for parentdocpos
 * @return java.lang.Integer
 */
public java.lang.Integer getParentdocpos() {
	return parentdocpos;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorA() {
	return sectorA;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorB() {
	return sectorB;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorC() {
	return sectorC;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorD() {
	return sectorD;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorE() {
	return sectorE;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorF() {
	return sectorF;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorG() {
	return sectorG;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorH() {
	return sectorH;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorO() {
	return sectorO;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorO1800() {
	return sectorO1800;
}
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetGroundresourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean groundresource_NULLTEST = (inKey == null);
	if (groundresource_NULLTEST) groundresource_resource = null; else groundresource_resource = (new Integer(inKey.resource));
}
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetGroundresource(com.hps.july.persistence.Resource aGroundresource) throws java.rmi.RemoteException {
	this.getGroundresourceLink().secondarySet(aGroundresource);
}
/**
 * Setter method for az_ant
 * @param newValue java.math.BigDecimal
 */
public void setAz_ant(java.math.BigDecimal newValue) {
	this.az_ant = newValue;
}
/**
 * Setter method for az_variation
 * @param newValue java.lang.String
 */
public void setAz_variation(java.lang.String newValue) {
	this.az_variation = newValue;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newDdk java.lang.Boolean
 */
public void setDdk(java.lang.Boolean newDdk) {
	ddk = newDdk;
}
/**
 * Setter method for docpostype
 * @param newValue java.lang.String
 */
public void setDocpostype(java.lang.String newValue) {
	this.docpostype = newValue;
}
/**
 * Setter method for groundcnt
 * @param newValue java.lang.Integer
 */
public void setGroundcnt(java.lang.Integer newValue) {
	this.groundcnt = newValue;
}
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setGroundresource(com.hps.july.persistence.Resource aGroundresource) throws java.rmi.RemoteException {
	this.getGroundresourceLink().set(aGroundresource);
}
/**
 * Setter method for h_set1
 * @param newValue java.math.BigDecimal
 */
public void setH_set1(java.math.BigDecimal newValue) {
	this.h_set1 = newValue;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newHas_buster java.lang.Boolean
 */
public void setHas_buster(java.lang.Boolean newHas_buster) {
	has_buster = newHas_buster;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newHas_flt java.lang.Boolean
 */
public void setHas_flt(java.lang.Boolean newHas_flt) {
	has_flt = newHas_flt;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newHas_lna java.lang.Boolean
 */
public void setHas_lna(java.lang.Boolean newHas_lna) {
	has_lna = newHas_lna;
}
/**
 * Setter method for input_power
 * @param newValue java.math.BigDecimal
 */
public void setInput_power(java.math.BigDecimal newValue) {
	this.input_power = newValue;
}
/**
 * Setter method for kind_ant
 * @param newValue java.lang.String
 */
public void setKind_ant(java.lang.String newValue) {
	this.kind_ant = newValue;
}
/**
 * Setter method for ksvn1800
 */
public void setKsvn1800(java.math.BigDecimal newValue) {
	this.ksvn1800 = newValue;
}
/**
 * Setter method for ksvn2000
 */
public void setKsvn2000(java.math.BigDecimal newValue) {
	this.ksvn2000 = newValue;
}
/**
 * Setter method for ksvn800
 */
public void setKsvn800(java.math.BigDecimal newValue) {
	this.ksvn800 = newValue;
}
/**
 * Setter method for ksvn900
 */
public void setKsvn900(java.math.BigDecimal newValue) {
	this.ksvn900 = newValue;
}
/**
 * Setter method for kswn
 * @param newValue java.math.BigDecimal
 */
public void setKswn(java.math.BigDecimal newValue) {
	this.kswn = newValue;
}
/**
 * Setter method for len_cable
 * @param newValue java.math.BigDecimal
 */
public void setLen_cable(java.math.BigDecimal newValue) {
	this.len_cable = newValue;
}
/**
 * Setter method for nakl
 * @param newValue java.math.BigDecimal
 */
public void setNakl(java.math.BigDecimal newValue) {
	this.nakl = newValue;
}
/**
 * Setter method for nakl_variation
 * @param newValue java.lang.String
 */
public void setNakl_variation(java.lang.String newValue) {
	this.nakl_variation = newValue;
}
/**
 * Setter method for num_ant
 * @param newValue java.lang.String
 */
public void setNum_ant(java.lang.String newValue) {
	this.num_ant = newValue;
}
/**
 * Setter method for parentdocpos
 * @param newValue java.lang.Integer
 */
public void setParentdocpos(java.lang.Integer newValue) {
	this.parentdocpos = newValue;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newSectorA java.lang.Boolean
 */
public void setSectorA(java.lang.Boolean newSectorA) {
	sectorA = newSectorA;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newSectorB java.lang.Boolean
 */
public void setSectorB(java.lang.Boolean newSectorB) {
	sectorB = newSectorB;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newSectorC java.lang.Boolean
 */
public void setSectorC(java.lang.Boolean newSectorC) {
	sectorC = newSectorC;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newSectorD java.lang.Boolean
 */
public void setSectorD(java.lang.Boolean newSectorD) {
	sectorD = newSectorD;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newSectorE java.lang.Boolean
 */
public void setSectorE(java.lang.Boolean newSectorE) {
	sectorE = newSectorE;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newSectorF java.lang.Boolean
 */
public void setSectorF(java.lang.Boolean newSectorF) {
	sectorF = newSectorF;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newSectorG java.lang.Boolean
 */
public void setSectorG(java.lang.Boolean newSectorG) {
	sectorG = newSectorG;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newSectorH java.lang.Boolean
 */
public void setSectorH(java.lang.Boolean newSectorH) {
	sectorH = newSectorH;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newSectorO java.lang.Boolean
 */
public void setSectorO(java.lang.Boolean newSectorO) {
	sectorO = newSectorO;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2003 16:48:45)
 * @param newSectorO1800 java.lang.Boolean
 */
public void setSectorO1800(java.lang.Boolean newSectorO1800) {
	sectorO1800 = newSectorO1800;
}
}
