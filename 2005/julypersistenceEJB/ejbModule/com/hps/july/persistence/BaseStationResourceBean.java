package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Ресурс типа "Базовая станция"
 */
public class BaseStationResourceBean extends ResourceBean {
	public String generation;
	public Integer height;
	public Integer length;
	public String modification;
	public String productline;
	private final static long serialVersionUID = 3206093459760846163L;
	public String standard;
	public Integer width;
	public Short makeyear;
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
}
/**
 * Getter method for generation
 * @return java.lang.String
 */
public java.lang.String getGeneration() {
	return generation;
}
/**
 * Getter method for height
 * @return java.lang.Integer
 */
public java.lang.Integer getHeight() {
	return height;
}
/**
 * Getter method for length
 * @return java.lang.Integer
 */
public java.lang.Integer getLength() {
	return length;
}
/**
 * Getter method for makeyear
 */
public java.lang.Short getMakeyear() {
	return makeyear;
}
/**
 * Getter method for modification
 * @return java.lang.String
 */
public java.lang.String getModification() {
	return modification;
}
/**
 * Getter method for productline
 * @return java.lang.String
 */
public java.lang.String getProductline() {
	return productline;
}
/**
 * Getter method for standard
 * @return java.lang.String
 */
public java.lang.String getStandard() {
	return standard;
}
/**
 * Getter method for width
 * @return java.lang.Integer
 */
public java.lang.Integer getWidth() {
	return width;
}
/**
 * Setter method for generation
 * @param newValue java.lang.String
 */
public void setGeneration(java.lang.String newValue) {
	this.generation = newValue;
}
/**
 * Setter method for height
 * @param newValue java.lang.Integer
 */
public void setHeight(java.lang.Integer newValue) {
	this.height = newValue;
}
/**
 * Setter method for length
 * @param newValue java.lang.Integer
 */
public void setLength(java.lang.Integer newValue) {
	this.length = newValue;
}
/**
 * Setter method for makeyear
 */
public void setMakeyear(java.lang.Short newValue) {
	this.makeyear = newValue;
}
/**
 * Setter method for modification
 * @param newValue java.lang.String
 */
public void setModification(java.lang.String newValue) {
	this.modification = newValue;
}
/**
 * Setter method for productline
 * @param newValue java.lang.String
 */
public void setProductline(java.lang.String newValue) {
	this.productline = newValue;
}
/**
 * Setter method for standard
 * @param newValue java.lang.String
 */
public void setStandard(java.lang.String newValue) {
	this.standard = newValue;
}
/**
 * Setter method for width
 * @param newValue java.lang.Integer
 */
public void setWidth(java.lang.Integer newValue) {
	this.width = newValue;
}
public final static int RESOURCECLASS2 = 1;

	/**
	 * Implementation field for persistent attribute: maxtrxcount
	 */
	public java.lang.Integer maxtrxcount;
	/**
	 * Implementation field for persistent attribute: maxsectorscount
	 */
	public java.lang.Integer maxsectorscount;
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
	productline = null;
	generation = null;
	modification = null;
	standard = null;
	length = null;
	width = null;
	height = null;
	makeyear = null;
	maxsectorscount = null;
	maxtrxcount = null;
}

	/**
	 * Get accessor for persistent attribute: maxtrxcount
	 */
	public java.lang.Integer getMaxtrxcount() {
		return maxtrxcount;
	}
	/**
	 * Set accessor for persistent attribute: maxtrxcount
	 */
	public void setMaxtrxcount(java.lang.Integer newMaxtrxcount) {
		maxtrxcount = newMaxtrxcount;
	}
	/**
	 * Get accessor for persistent attribute: maxsectorscount
	 */
	public java.lang.Integer getMaxsectorscount() {
		return maxsectorscount;
	}
	/**
	 * Set accessor for persistent attribute: maxsectorscount
	 */
	public void setMaxsectorscount(java.lang.Integer newMaxsectorscount) {
		maxsectorscount = newMaxsectorscount;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("width", getWidth());
		h.put("length", getLength());
		h.put("productline", getProductline());
		h.put("standard", getStandard());
		h.put("maxtrxcount", getMaxtrxcount());
		h.put("modification", getModification());
		h.put("generation", getGeneration());
		h.put("maxsectorscount", getMaxsectorscount());
		h.put("makeyear", getMakeyear());
		h.put("height", getHeight());
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
		java.lang.Integer localLength = (java.lang.Integer) h.get("length");
		java.lang.String localProductline =
			(java.lang.String) h.get("productline");
		java.lang.String localStandard = (java.lang.String) h.get("standard");
		java.lang.Integer localMaxtrxcount =
			(java.lang.Integer) h.get("maxtrxcount");
		java.lang.String localModification =
			(java.lang.String) h.get("modification");
		java.lang.String localGeneration =
			(java.lang.String) h.get("generation");
		java.lang.Integer localMaxsectorscount =
			(java.lang.Integer) h.get("maxsectorscount");
		java.lang.Short localMakeyear = (java.lang.Short) h.get("makeyear");
		java.lang.Integer localHeight = (java.lang.Integer) h.get("height");
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
		if (h.containsKey("length"))
			setLength((localLength));
		if (h.containsKey("productline"))
			setProductline((localProductline));
		if (h.containsKey("standard"))
			setStandard((localStandard));
		if (h.containsKey("maxtrxcount"))
			setMaxtrxcount((localMaxtrxcount));
		if (h.containsKey("modification"))
			setModification((localModification));
		if (h.containsKey("generation"))
			setGeneration((localGeneration));
		if (h.containsKey("maxsectorscount"))
			setMaxsectorscount((localMaxsectorscount));
		if (h.containsKey("makeyear"))
			setMakeyear((localMakeyear));
		if (h.containsKey("height"))
			setHeight((localHeight));
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
