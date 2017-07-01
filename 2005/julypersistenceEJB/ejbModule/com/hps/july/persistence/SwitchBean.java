package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Комплект оборудования типа "Коммутатор"
 */
public class SwitchBean extends EquipmentSetBean {
	public int number;
	private final static long serialVersionUID = 3206093459760846163L;
	public String switchType;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink controllerLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink baseStationLink = null;
	public Integer qtyconhlr;
	public Integer qtyshell;
	public Integer maxvlr;
	public Integer ss7bss;
	public Integer ss7nss;
	public Integer qty_tkgroute_nss;
	public Integer e1_qty_total;
	public java.math.BigDecimal e1_use_percent;
	public Integer e1_bss;
	public Integer e1_nss;
	public Integer e1_hlr;
	public Integer ss7_hlrin;
	public java.lang.Integer resource_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink resourceLink = null;
	public String comment;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink switchAddInfosLink = null;
	public Integer mscid;
	/**
	 * Implementation field for persistent attribute: capacityused
	 */
	public java.lang.Integer capacityused;
	/**
	 * Implementation field for persistent attribute: capacityplan
	 */
	public java.lang.Integer capacityplan;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("comment", getComment());
		h.put("number", new Integer(getNumber()));
		h.put("qtyshell", getQtyshell());
		h.put("ss7bss", getSs7bss());
		h.put("e1_qty_total", getE1_qty_total());
		h.put("e1_nss", getE1_nss());
		h.put("resourceKey", getResourceKey());
		h.put("qtyconhlr", getQtyconhlr());
		h.put("capacityplan", getCapacityplan());
		h.put("qty_tkgroute_nss", getQty_tkgroute_nss());
		h.put("capacityused", getCapacityused());
		h.put("e1_hlr", getE1_hlr());
		h.put("e1_bss", getE1_bss());
		h.put("maxvlr", getMaxvlr());
		h.put("e1_use_percent", getE1_use_percent());
		h.put("mscid", getMscid());
		h.put("ss7nss", getSs7nss());
		h.put("switchType", getSwitchType());
		h.put("ss7_hlrin", getSs7_hlrin());
		h.put("datepr", getDatepr());
		h.put("datasource", new Integer(getDatasource()));
		h.put("datetest", getDatetest());
		h.put("datebldbeg", getDatebldbeg());
		h.put("pwrval", getPwrval());
		h.put("dateassemb", getDateassemb());
		h.put("equipcomment", getEquipcomment());
		h.put("pwrrescat", getPwrrescat());
		h.put("positionKey", getPositionKey());
		h.put("pwrreserve", getPwrreserve());
		h.put("pwrcat", getPwrcat());
		h.put("equipmentState", getEquipmentState());
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
		java.lang.String localComment = (java.lang.String) h.get("comment");
		Integer localNumber = (Integer) h.get("number");
		java.lang.Integer localQtyshell = (java.lang.Integer) h.get("qtyshell");
		java.lang.Integer localSs7bss = (java.lang.Integer) h.get("ss7bss");
		java.lang.Integer localE1_qty_total =
			(java.lang.Integer) h.get("e1_qty_total");
		java.lang.Integer localE1_nss = (java.lang.Integer) h.get("e1_nss");
		java.lang.Integer localQtyconhlr =
			(java.lang.Integer) h.get("qtyconhlr");
		java.lang.Integer localCapacityplan =
			(java.lang.Integer) h.get("capacityplan");
		java.lang.Integer localQty_tkgroute_nss =
			(java.lang.Integer) h.get("qty_tkgroute_nss");
		java.lang.Integer localCapacityused =
			(java.lang.Integer) h.get("capacityused");
		java.lang.Integer localE1_hlr = (java.lang.Integer) h.get("e1_hlr");
		java.lang.Integer localE1_bss = (java.lang.Integer) h.get("e1_bss");
		java.lang.Integer localMaxvlr = (java.lang.Integer) h.get("maxvlr");
		java.math.BigDecimal localE1_use_percent =
			(java.math.BigDecimal) h.get("e1_use_percent");
		java.lang.Integer localMscid = (java.lang.Integer) h.get("mscid");
		java.lang.Integer localSs7nss = (java.lang.Integer) h.get("ss7nss");
		java.lang.String localSwitchType =
			(java.lang.String) h.get("switchType");
		java.lang.Integer localSs7_hlrin =
			(java.lang.Integer) h.get("ss7_hlrin");
		java.sql.Date localDatepr = (java.sql.Date) h.get("datepr");
		Integer localDatasource = (Integer) h.get("datasource");
		java.sql.Date localDatetest = (java.sql.Date) h.get("datetest");
		java.sql.Date localDatebldbeg = (java.sql.Date) h.get("datebldbeg");
		java.math.BigDecimal localPwrval =
			(java.math.BigDecimal) h.get("pwrval");
		java.sql.Date localDateassemb = (java.sql.Date) h.get("dateassemb");
		java.lang.String localEquipcomment =
			(java.lang.String) h.get("equipcomment");
		java.lang.String localPwrrescat = (java.lang.String) h.get("pwrrescat");
		java.lang.Boolean localPwrreserve =
			(java.lang.Boolean) h.get("pwrreserve");
		java.lang.String localPwrcat = (java.lang.String) h.get("pwrcat");
		java.lang.String localEquipmentState =
			(java.lang.String) h.get("equipmentState");
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

		if (h.containsKey("comment"))
			setComment((localComment));
		if (h.containsKey("number"))
			setNumber((localNumber).intValue());
		if (h.containsKey("qtyshell"))
			setQtyshell((localQtyshell));
		if (h.containsKey("ss7bss"))
			setSs7bss((localSs7bss));
		if (h.containsKey("e1_qty_total"))
			setE1_qty_total((localE1_qty_total));
		if (h.containsKey("e1_nss"))
			setE1_nss((localE1_nss));
		if (h.containsKey("qtyconhlr"))
			setQtyconhlr((localQtyconhlr));
		if (h.containsKey("capacityplan"))
			setCapacityplan((localCapacityplan));
		if (h.containsKey("qty_tkgroute_nss"))
			setQty_tkgroute_nss((localQty_tkgroute_nss));
		if (h.containsKey("capacityused"))
			setCapacityused((localCapacityused));
		if (h.containsKey("e1_hlr"))
			setE1_hlr((localE1_hlr));
		if (h.containsKey("e1_bss"))
			setE1_bss((localE1_bss));
		if (h.containsKey("maxvlr"))
			setMaxvlr((localMaxvlr));
		if (h.containsKey("e1_use_percent"))
			setE1_use_percent((localE1_use_percent));
		if (h.containsKey("mscid"))
			setMscid((localMscid));
		if (h.containsKey("ss7nss"))
			setSs7nss((localSs7nss));
		if (h.containsKey("switchType"))
			setSwitchType((localSwitchType));
		if (h.containsKey("ss7_hlrin"))
			setSs7_hlrin((localSs7_hlrin));
		if (h.containsKey("datepr"))
			setDatepr((localDatepr));
		if (h.containsKey("datasource"))
			setDatasource((localDatasource).intValue());
		if (h.containsKey("datetest"))
			setDatetest((localDatetest));
		if (h.containsKey("datebldbeg"))
			setDatebldbeg((localDatebldbeg));
		if (h.containsKey("pwrval"))
			setPwrval((localPwrval));
		if (h.containsKey("dateassemb"))
			setDateassemb((localDateassemb));
		if (h.containsKey("equipcomment"))
			setEquipcomment((localEquipcomment));
		if (h.containsKey("pwrrescat"))
			setPwrrescat((localPwrrescat));
		if (h.containsKey("pwrreserve"))
			setPwrreserve((localPwrreserve));
		if (h.containsKey("pwrcat"))
			setPwrcat((localPwrcat));
		if (h.containsKey("equipmentState"))
			setEquipmentState((localEquipmentState));
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
	links.addElement(getControllerLink());
	links.addElement(getBaseStationLink());
	links.addElement(getResourceLink());
	links.addElement(getSwitchAddInfosLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	controllerLink = null;
	baseStationLink = null;
	resourceLink = null;
	switchAddInfosLink = null;
}
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addBaseStation(com.hps.july.persistence.BaseStation aBaseStation) throws java.rmi.RemoteException {
	this.getBaseStationLink().addElement(aBaseStation);
}
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addController(com.hps.july.persistence.Controller aController) throws java.rmi.RemoteException {
	this.getControllerLink().addElement(aController);
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argStorageplace, Integer argDivision, String argName, 
	String argAddress, Integer argPosition, String argType, Integer argNumber ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	super.ejbCreate( argStorageplace, argDivision, argName, argAddress, argPosition );
	_initLinks();
	// All CMP fields should be initialized here.
	switchType = argType;
	number = argNumber.intValue();
	qtyconhlr = null;
	qtyshell = null;
	maxvlr = null;
	ss7bss = null;
	ss7nss = null;
	ss7_hlrin = null;
	qty_tkgroute_nss = null;
	e1_qty_total = null;
	e1_use_percent = null;
	e1_bss = null;
	e1_nss = null;
	e1_hlr = null;
	resource_resource = null;
	comment = null;
	mscid = null;
}
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getBaseStation() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getBaseStationLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getBaseStationLink() {
	if (baseStationLink == null)
		baseStationLink = new SwitchToBaseStationLink(this);
	return baseStationLink;
}
/**
 * Getter method for comment
 */
public java.lang.String getComment() {
	return comment;
}
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getController() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getControllerLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getControllerLink() {
	if (controllerLink == null)
		controllerLink = new SwitchToControllerLink(this);
	return controllerLink;
}
/**
 * Getter method for e1_bss
 */
public java.lang.Integer getE1_bss() {
	return e1_bss;
}
/**
 * Getter method for e1_hlr
 */
public java.lang.Integer getE1_hlr() {
	return e1_hlr;
}
/**
 * Getter method for e1_nss
 */
public java.lang.Integer getE1_nss() {
	return e1_nss;
}
/**
 * Getter method for e1_qty_total
 */
public java.lang.Integer getE1_qty_total() {
	return e1_qty_total;
}
/**
 * Getter method for e1_use_percent
 */
public java.math.BigDecimal getE1_use_percent() {
	return e1_use_percent;
}
/**
 * Getter method for maxvlr
 */
public java.lang.Integer getMaxvlr() {
	return maxvlr;
}
/**
 * Getter method for mscid
 */
public java.lang.Integer getMscid() {
	return mscid;
}
/**
 * Getter method for number
 * @return int
 */
public int getNumber() {
	return number;
}
/**
 * Getter method for qty_tkgroute_nss
 */
public java.lang.Integer getQty_tkgroute_nss() {
	return qty_tkgroute_nss;
}
/**
 * Getter method for qtyconhlr
 */
public java.lang.Integer getQtyconhlr() {
	return qtyconhlr;
}
/**
 * Getter method for qtyshell
 */
public java.lang.Integer getQtyshell() {
	return qtyshell;
}
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Resource)this.getResourceLink().value();
}
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getResourceKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean resource_NULLTEST = true;
	resource_NULLTEST &= (resource_resource == null);
	temp.resource = ((resource_resource == null) ? 0 : resource_resource.intValue());
	if (resource_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getResourceLink() {
	if (resourceLink == null)
		resourceLink = new SwitchToResourceLink(this);
	return resourceLink;
}
/**
 * Getter method for ss7_hlrin
 */
public java.lang.Integer getSs7_hlrin() {
	return ss7_hlrin;
}
/**
 * Getter method for ss7bss
 */
public java.lang.Integer getSs7bss() {
	return ss7bss;
}
/**
 * Getter method for ss7nss
 */
public java.lang.Integer getSs7nss() {
	return ss7nss;
}
/**
 * This method was generated for supporting the association named SwitchAddInfo2switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSwitchAddInfos() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getSwitchAddInfosLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named SwitchAddInfo2switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getSwitchAddInfosLink() {
	if (switchAddInfosLink == null)
		switchAddInfosLink = new SwitchToSwitchAddInfosLink(this);
	return switchAddInfosLink;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 18:36:39)
 * @return java.lang.String
 */
public java.lang.String getSwitchType() {
	return switchType;
}
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddBaseStation(com.hps.july.persistence.BaseStation aBaseStation) {
	this.getBaseStationLink().secondaryAddElement(aBaseStation);
}
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddController(com.hps.july.persistence.Controller aController) {
	this.getControllerLink().secondaryAddElement(aController);
}
/**
 * This method was generated for supporting the association named SwitchAddInfo2switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSwitchAddInfos(com.hps.july.persistence.SwitchAddInfo aSwitchAddInfos) {
	this.getSwitchAddInfosLink().secondaryAddElement(aSwitchAddInfos);
}
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveBaseStation(com.hps.july.persistence.BaseStation aBaseStation) {
	this.getBaseStationLink().secondaryRemoveElement(aBaseStation);
}
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveController(com.hps.july.persistence.Controller aController) {
	this.getControllerLink().secondaryRemoveElement(aController);
}
/**
 * This method was generated for supporting the association named SwitchAddInfo2switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSwitchAddInfos(com.hps.july.persistence.SwitchAddInfo aSwitchAddInfos) {
	this.getSwitchAddInfosLink().secondaryRemoveElement(aSwitchAddInfos);
}
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException {
	this.getResourceLink().secondarySet(aResource);
}
/**
 * Setter method for comment
 */
public void setComment(java.lang.String newValue) {
	this.comment = newValue;
}
/**
 * Setter method for e1_bss
 */
public void setE1_bss(java.lang.Integer newValue) {
	this.e1_bss = newValue;
}
/**
 * Setter method for e1_hlr
 */
public void setE1_hlr(java.lang.Integer newValue) {
	this.e1_hlr = newValue;
}
/**
 * Setter method for e1_nss
 */
public void setE1_nss(java.lang.Integer newValue) {
	this.e1_nss = newValue;
}
/**
 * Setter method for e1_qty_total
 */
public void setE1_qty_total(java.lang.Integer newValue) {
	this.e1_qty_total = newValue;
}
/**
 * Setter method for e1_use_percent
 */
public void setE1_use_percent(java.math.BigDecimal newValue) {
	this.e1_use_percent = newValue;
}
/**
 * Setter method for maxvlr
 */
public void setMaxvlr(java.lang.Integer newValue) {
	this.maxvlr = newValue;
}
/**
 * Setter method for mscid
 */
public void setMscid(java.lang.Integer newValue) {
	this.mscid = newValue;
}
/**
 * Setter method for number
 * @param newValue int
 */
public void setNumber(int newValue) {
	this.number = newValue;
}
/**
 * Setter method for qty_tkgroute_nss
 */
public void setQty_tkgroute_nss(java.lang.Integer newValue) {
	this.qty_tkgroute_nss = newValue;
}
/**
 * Setter method for qtyconhlr
 */
public void setQtyconhlr(java.lang.Integer newValue) {
	this.qtyconhlr = newValue;
}
/**
 * Setter method for qtyshell
 */
public void setQtyshell(java.lang.Integer newValue) {
	this.qtyshell = newValue;
}
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException {
	this.getResourceLink().set(aResource);
}
/**
 * Setter method for ss7_hlrin
 */
public void setSs7_hlrin(java.lang.Integer newValue) {
	this.ss7_hlrin = newValue;
}
/**
 * Setter method for ss7bss
 */
public void setSs7bss(java.lang.Integer newValue) {
	this.ss7bss = newValue;
}
/**
 * Setter method for ss7nss
 */
public void setSs7nss(java.lang.Integer newValue) {
	this.ss7nss = newValue;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 18:36:39)
 * @param newSwitchType java.lang.String
 */
public void setSwitchType(java.lang.String newSwitchType) {
	switchType = newSwitchType;
}
	/**
	 * Get accessor for persistent attribute: capacityused
	 */
	public java.lang.Integer getCapacityused() {
		return capacityused;
	}
	/**
	 * Set accessor for persistent attribute: capacityused
	 */
	public void setCapacityused(java.lang.Integer newCapacityused) {
		capacityused = newCapacityused;
	}
	/**
	 * Get accessor for persistent attribute: capacityplan
	 */
	public java.lang.Integer getCapacityplan() {
		return capacityplan;
	}
	/**
	 * Set accessor for persistent attribute: capacityplan
	 */
	public void setCapacityplan(java.lang.Integer newCapacityplan) {
		capacityplan = newCapacityplan;
	}
}
