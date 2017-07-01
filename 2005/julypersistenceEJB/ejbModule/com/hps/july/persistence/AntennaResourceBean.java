package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Ресурс типа "Антенна"
 */
public class AntennaResourceBean extends ResourceBean {
	public String anttype;
	public String connector;
	public java.math.BigDecimal electricangle;
	public String freqrange;
	public Integer height;
	public java.math.BigDecimal ksvn;
	public Integer length;
	public String polarization;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.math.BigDecimal weight;
	public Integer width;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink antennesLink = null;
	public Boolean isomni;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink antennaResourceBandsLink = null;
	/**
	 * Implementation field for persistent attribute: entriescount
	 */
	public java.lang.Integer entriescount;
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getAntennesLink());
	links.addElement(getAntennaResourceBandsLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	antennesLink = null;
	antennaResourceBandsLink = null;
}
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException {
	this.getAntennesLink().addElement(anAntennes);
}
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAntennaResourceBands() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAntennaResourceBandsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAntennaResourceBandsLink() {
	if (antennaResourceBandsLink == null)
		antennaResourceBandsLink = new AntennaResourceToAntennaResourceBandsLink(this);
	return antennaResourceBandsLink;
}
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAntennes() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAntennesLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAntennesLink() {
	if (antennesLink == null)
		antennesLink = new AntennaResourceToAntennesLink(this);
	return antennesLink;
}
/**
 * Getter method for anttype
 * @return java.lang.String
 */
public java.lang.String getAnttype() {
	return anttype;
}
/**
 * Getter method for connector
 * @return java.lang.String
 */
public java.lang.String getConnector() {
	return connector;
}
/**
 * Getter method for electricangle
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getElectricangle() {
	return electricangle;
}
/**
 * Getter method for freqrange
 * @return java.lang.String
 */
public java.lang.String getFreqrange() {
	return freqrange;
}
/**
 * Getter method for height
 * @return java.lang.Integer
 */
public java.lang.Integer getHeight() {
	return height;
}
/**
 * Getter method for isomni
 */
public java.lang.Boolean getIsomni() {
	return isomni;
}
/**
 * Getter method for ksvn
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getKsvn() {
	return ksvn;
}
/**
 * Getter method for length
 * @return java.lang.Integer
 */
public java.lang.Integer getLength() {
	return length;
}
/**
 * Getter method for polarization
 * @return java.lang.String
 */
public java.lang.String getPolarization() {
	return polarization;
}
/**
 * Getter method for weight
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getWeight() {
	return weight;
}
/**
 * Getter method for width
 * @return java.lang.Integer
 */
public java.lang.Integer getWidth() {
	return width;
}
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAntennaResourceBands(com.hps.july.persistence.AntennaResourceBand anAntennaResourceBands) {
	this.getAntennaResourceBandsLink().secondaryAddElement(anAntennaResourceBands);
}
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAntennes(com.hps.july.persistence.Antenna anAntennes) {
	this.getAntennesLink().secondaryAddElement(anAntennes);
}
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAntennaResourceBands(com.hps.july.persistence.AntennaResourceBand anAntennaResourceBands) {
	this.getAntennaResourceBandsLink().secondaryRemoveElement(anAntennaResourceBands);
}
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAntennes(com.hps.july.persistence.Antenna anAntennes) {
	this.getAntennesLink().secondaryRemoveElement(anAntennes);
}
/**
 * Setter method for anttype
 * @param newValue java.lang.String
 */
public void setAnttype(java.lang.String newValue) {
	this.anttype = newValue;
}
/**
 * Setter method for connector
 * @param newValue java.lang.String
 */
public void setConnector(java.lang.String newValue) {
	this.connector = newValue;
}
/**
 * Setter method for electricangle
 * @param newValue java.math.BigDecimal
 */
public void setElectricangle(java.math.BigDecimal newValue) {
	this.electricangle = newValue;
}
/**
 * Setter method for freqrange
 * @param newValue java.lang.String
 */
public void setFreqrange(java.lang.String newValue) {
	this.freqrange = newValue;
}
/**
 * Setter method for height
 * @param newValue java.lang.Integer
 */
public void setHeight(java.lang.Integer newValue) {
	this.height = newValue;
}
/**
 * Setter method for isomni
 */
public void setIsomni(java.lang.Boolean newValue) {
	this.isomni = newValue;
}
/**
 * Setter method for ksvn
 * @param newValue java.math.BigDecimal
 */
public void setKsvn(java.math.BigDecimal newValue) {
	this.ksvn = newValue;
}
/**
 * Setter method for length
 * @param newValue java.lang.Integer
 */
public void setLength(java.lang.Integer newValue) {
	this.length = newValue;
}
/**
 * Setter method for polarization
 * @param newValue java.lang.String
 */
public void setPolarization(java.lang.String newValue) {
	this.polarization = newValue;
}
/**
 * Setter method for weight
 * @param newValue java.math.BigDecimal
 */
public void setWeight(java.math.BigDecimal newValue) {
	this.weight = newValue;
}
/**
 * Setter method for width
 * @param newValue java.lang.Integer
 */
public void setWidth(java.lang.Integer newValue) {
	this.width = newValue;
}
	/**
	 * Get accessor for persistent attribute: entriescount
	 */
	public java.lang.Integer getEntriescount() {
		return entriescount;
	}
	/**
	 * Set accessor for persistent attribute: entriescount
	 */
	public void setEntriescount(java.lang.Integer newEntriescount) {
		entriescount = newEntriescount;
	}
	public final static int RESOURCECLASS2 = 3;
	
	/**
	 * ejbCreate method for a CMP entity bean
	 * @param argResource int
	 * @exception javax.ejb.CreateException The exception description.
	 * @exception java.rmi.RemoteException The exception description.
	 */
	public void ejbCreate(int argResource, String argName, String argModel, String argNotes, Boolean argComplect, 
		String argCountpolicy, Boolean argBoxable, Boolean argPriceable, Boolean argComplectpart, 
		Boolean argActive, int argSubType ) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.ejbCreate(argResource, argName, argModel, argNotes, argComplect, 
			argCountpolicy, argBoxable, argPriceable, argComplectpart, 
			argActive, argSubType, RESOURCECLASS2);
		_initLinks();
		// All CMP fields should be initialized here.
		anttype = null;
		isomni = null;
		freqrange = null;
		polarization = null;
		electricangle = null;
		connector = null;
		length = null;
		width = null;
		height = null;
		weight = null;
		ksvn = null;
		entriescount = null;
	}
	
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("width", getWidth());
		h.put("isomni", getIsomni());
		h.put("length", getLength());
		h.put("entriescount", getEntriescount());
		h.put("ksvn", getKsvn());
		h.put("connector", getConnector());
		h.put("weight", getWeight());
		h.put("freqrange", getFreqrange());
		h.put("electricangle", getElectricangle());
		h.put("height", getHeight());
		h.put("anttype", getAnttype());
		h.put("polarization", getPolarization());
		h.put("unitKey", getUnitKey());
		h.put("subtypeKey", getSubtypeKey());
		h.put("countpolicy", getCountpolicy());
		h.put("model", getModel());
		h.put("manufid", getManufid());
		h.put("resourceclass2", getResourceclass2());
		h.put("actualcode", new Integer(getActualcode()));
		h.put("name", getName());
		h.put("groupid", getGroupid());
		h.put("priceable", getPriceable());
		h.put("complectpart", getComplectpart());
		h.put("resource", new Integer(getResource()));
		h.put("manucode", getManucode());
		h.put("complect", getComplect());
		h.put("disablenfscodes", getDisablenfscodes());
		h.put("subtype_resourcesubtype", getSubtype_resourcesubtype());
		h.put("notes", getNotes());
		h.put("active", getActive());
		h.put("boxable", getBoxable());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.Integer localWidth = (java.lang.Integer) h.get("width");
		java.lang.Boolean localIsomni = (java.lang.Boolean) h.get("isomni");
		java.lang.Integer localLength = (java.lang.Integer) h.get("length");
		java.lang.Integer localEntriescount =
			(java.lang.Integer) h.get("entriescount");
		java.math.BigDecimal localKsvn = (java.math.BigDecimal) h.get("ksvn");
		java.lang.String localConnector = (java.lang.String) h.get("connector");
		java.math.BigDecimal localWeight =
			(java.math.BigDecimal) h.get("weight");
		java.lang.String localFreqrange = (java.lang.String) h.get("freqrange");
		java.math.BigDecimal localElectricangle =
			(java.math.BigDecimal) h.get("electricangle");
		java.lang.Integer localHeight = (java.lang.Integer) h.get("height");
		java.lang.String localAnttype = (java.lang.String) h.get("anttype");
		java.lang.String localPolarization =
			(java.lang.String) h.get("polarization");
		java.lang.String localCountpolicy =
			(java.lang.String) h.get("countpolicy");
		java.lang.String localModel = (java.lang.String) h.get("model");
		java.lang.Integer localManufid = (java.lang.Integer) h.get("manufid");
		java.lang.Integer localResourceclass2 =
			(java.lang.Integer) h.get("resourceclass2");
		Integer localActualcode = (Integer) h.get("actualcode");
		java.lang.String localName = (java.lang.String) h.get("name");
		java.lang.Integer localGroupid = (java.lang.Integer) h.get("groupid");
		java.lang.Boolean localPriceable =
			(java.lang.Boolean) h.get("priceable");
		java.lang.Boolean localComplectpart =
			(java.lang.Boolean) h.get("complectpart");
		Integer localResource = (Integer) h.get("resource");
		java.lang.String localManucode = (java.lang.String) h.get("manucode");
		java.lang.Boolean localComplect = (java.lang.Boolean) h.get("complect");
		java.lang.Boolean localDisablenfscodes =
			(java.lang.Boolean) h.get("disablenfscodes");
		java.lang.Integer localSubtype_resourcesubtype =
			(java.lang.Integer) h.get("subtype_resourcesubtype");
		java.lang.String localNotes = (java.lang.String) h.get("notes");
		java.lang.Boolean localActive = (java.lang.Boolean) h.get("active");
		java.lang.Boolean localBoxable = (java.lang.Boolean) h.get("boxable");

		if (h.containsKey("width"))
			setWidth((localWidth));
		if (h.containsKey("isomni"))
			setIsomni((localIsomni));
		if (h.containsKey("length"))
			setLength((localLength));
		if (h.containsKey("entriescount"))
			setEntriescount((localEntriescount));
		if (h.containsKey("ksvn"))
			setKsvn((localKsvn));
		if (h.containsKey("connector"))
			setConnector((localConnector));
		if (h.containsKey("weight"))
			setWeight((localWeight));
		if (h.containsKey("freqrange"))
			setFreqrange((localFreqrange));
		if (h.containsKey("electricangle"))
			setElectricangle((localElectricangle));
		if (h.containsKey("height"))
			setHeight((localHeight));
		if (h.containsKey("anttype"))
			setAnttype((localAnttype));
		if (h.containsKey("polarization"))
			setPolarization((localPolarization));
		if (h.containsKey("countpolicy"))
			setCountpolicy((localCountpolicy));
		if (h.containsKey("model"))
			setModel((localModel));
		if (h.containsKey("manufid"))
			setManufid((localManufid));
		if (h.containsKey("resourceclass2"))
			setResourceclass2((localResourceclass2));
		if (h.containsKey("actualcode"))
			setActualcode((localActualcode).intValue());
		if (h.containsKey("name"))
			setName((localName));
		if (h.containsKey("groupid"))
			setGroupid((localGroupid));
		if (h.containsKey("priceable"))
			setPriceable((localPriceable));
		if (h.containsKey("complectpart"))
			setComplectpart((localComplectpart));
		if (h.containsKey("resource"))
			setResource((localResource).intValue());
		if (h.containsKey("manucode"))
			setManucode((localManucode));
		if (h.containsKey("complect"))
			setComplect((localComplect));
		if (h.containsKey("disablenfscodes"))
			setDisablenfscodes((localDisablenfscodes));
		if (h.containsKey("subtype_resourcesubtype"))
			setSubtype_resourcesubtype((localSubtype_resourcesubtype));
		if (h.containsKey("notes"))
			setNotes((localNotes));
		if (h.containsKey("active"))
			setActive((localActive));
		if (h.containsKey("boxable"))
			setBoxable((localBoxable));
	}
}
