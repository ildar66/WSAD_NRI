package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Ресурс типа "Кабель"
 */
public class CableResourceBean extends ResourceBean {
	private final static long serialVersionUID = 3206093459760846163L;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink antennesLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink cableResourceBandsLink = null;
	/**
	 * Implementation field for persistent attribute: cablediamid
	 */
	public int cablediamid;
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getCableResourceBandsLink());
	links.addElement(getAntennesLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	cableResourceBandsLink = null;
	antennesLink = null;
}
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException {
	this.getAntennesLink().addElement(anAntennes);
}
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAntennes() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAntennesLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAntennesLink() {
	if (antennesLink == null)
		antennesLink = new CableResourceToAntennesLink(this);
	return antennesLink;
}
/**
 * This method was generated for supporting the association named CableResourceBand2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getCableResourceBands() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getCableResourceBandsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named CableResourceBand2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getCableResourceBandsLink() {
	if (cableResourceBandsLink == null)
		cableResourceBandsLink = new CableResourceToCableResourceBandsLink(this);
	return cableResourceBandsLink;
}
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException {
	this.getAntennesLink().removeElement(anAntennes);
}
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAntennes(com.hps.july.persistence.Antenna anAntennes) {
	this.getAntennesLink().secondaryAddElement(anAntennes);
}
/**
 * This method was generated for supporting the association named CableResourceBand2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddCableResourceBands(com.hps.july.persistence.CableResourceBand aCableResourceBands) {
	this.getCableResourceBandsLink().secondaryAddElement(aCableResourceBands);
}
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAntennes(com.hps.july.persistence.Antenna anAntennes) {
	this.getAntennesLink().secondaryRemoveElement(anAntennes);
}
/**
 * This method was generated for supporting the association named CableResourceBand2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveCableResourceBands(com.hps.july.persistence.CableResourceBand aCableResourceBands) {
	this.getCableResourceBandsLink().secondaryRemoveElement(aCableResourceBands);
}
	/**
	 * Get accessor for persistent attribute: cablediamid
	 */
	public int getCablediamid() {
		return cablediamid;
	}
	/**
	 * Set accessor for persistent attribute: cablediamid
	 */
	public void setCablediamid(int newCablediamid) {
		cablediamid = newCablediamid;
	}
	public final static int RESOURCECLASS2 = 2;
	
	/**
	 * ejbCreate method for a CMP entity bean
	 * @param argResource int
	 * @exception javax.ejb.CreateException The exception description.
	 * @exception java.rmi.RemoteException The exception description.
	 */
	public void ejbCreate(int argResource, String argName, String argModel, String argNotes, Boolean argComplect, 
		String argCountpolicy, Boolean argBoxable, Boolean argPriceable, Boolean argComplectpart, 
		Boolean argActive, int argSubType, int argCableDiamId ) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.ejbCreate(argResource, argName, argModel, argNotes, argComplect, 
			argCountpolicy, argBoxable, argPriceable, argComplectpart, 
			argActive, argSubType, RESOURCECLASS2);
		_initLinks();
		// All CMP fields should be initialized here.
		cablediamid = argCableDiamId;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("cablediamid", new Integer(getCablediamid()));
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
		Integer localCablediamid = (Integer) h.get("cablediamid");
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

		if (h.containsKey("cablediamid"))
			setCablediamid((localCablediamid).intValue());
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
