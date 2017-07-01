package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Справочник рабочих диапазонов антенны
 */
public class AntennaResourceBandBean implements EntityBean {
	public java.math.BigDecimal amplification;
	public short band;
	private javax.ejb.EntityContext entityContext = null;
	public java.math.BigDecimal horzwidth;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.math.BigDecimal vertwidth;
	public java.lang.Integer resource_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink resourceLink = null;
	public java.math.BigDecimal electricangle;
	public java.math.BigDecimal ksvn;
	/**
	 * Implementation field for persistent attribute: hasMaxElectricAngle
	 */
	public boolean hasMaxElectricAngle;
	/**
	 * Implementation field for persistent attribute: maxelectricangle
	 */
	public java.math.BigDecimal maxelectricangle;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("ksvn", getKsvn());
		h.put("maxelectricangle", getMaxelectricangle());
		h.put("hasMaxElectricAngle", new Boolean(isHasMaxElectricAngle()));
		h.put("vertwidth", getVertwidth());
		h.put("horzwidth", getHorzwidth());
		h.put("amplification", getAmplification());
		h.put("electricangle", getElectricangle());
		h.put("resourceKey", getResourceKey());
		h.put("band", new Short(getBand()));
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.math.BigDecimal localKsvn = (java.math.BigDecimal) h.get("ksvn");
		java.math.BigDecimal localMaxelectricangle =
			(java.math.BigDecimal) h.get("maxelectricangle");
		Boolean localHasMaxElectricAngle =
			(Boolean) h.get("hasMaxElectricAngle");
		java.math.BigDecimal localVertwidth =
			(java.math.BigDecimal) h.get("vertwidth");
		java.math.BigDecimal localHorzwidth =
			(java.math.BigDecimal) h.get("horzwidth");
		java.math.BigDecimal localAmplification =
			(java.math.BigDecimal) h.get("amplification");
		java.math.BigDecimal localElectricangle =
			(java.math.BigDecimal) h.get("electricangle");

		if (h.containsKey("ksvn"))
			setKsvn((localKsvn));
		if (h.containsKey("maxelectricangle"))
			setMaxelectricangle((localMaxelectricangle));
		if (h.containsKey("hasMaxElectricAngle"))
			setHasMaxElectricAngle((localHasMaxElectricAngle).booleanValue());
		if (h.containsKey("vertwidth"))
			setVertwidth((localVertwidth));
		if (h.containsKey("horzwidth"))
			setHorzwidth((localHorzwidth));
		if (h.containsKey("amplification"))
			setAmplification((localAmplification));
		if (h.containsKey("electricangle"))
			setElectricangle((localElectricangle));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getResourceLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	resourceLink = null;
}
/**
 * This method was generated for supporting the associations.
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _removeLinks() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	java.util.Enumeration links = _getLinks().elements();
	while (links.hasMoreElements()) {
		try {
			((com.ibm.ivj.ejb.associations.interfaces.Link) (links.nextElement())).remove();
		}
		catch (javax.ejb.FinderException e) {} //Consume Finder error since I am going away
	}
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argBand short
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argResource, short argBand) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	resource_resource = new Integer(argResource);
	band = argBand;
	horzwidth = null;
	vertwidth = null;
	amplification = null;
	electricangle = null;
	ksvn = null;
	hasMaxElectricAngle = false;
	maxelectricangle = null;
}
/**
 * ejbLoad method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbLoad() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbPostCreate method for a CMP entity bean
 * @param argBand short
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(short argBand) throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	_removeLinks();
}
/**
 * ejbStore method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbStore() throws java.rmi.RemoteException {}
/**
 * Getter method for amplification
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAmplification() {
	return amplification;
}
/**
 * Insert the method's description here.
 * Creation date: (13.03.2003 12:34:19)
 * @return short
 */
public short getBand() {
	return band;
}
/**
 * Getter method for electricangle
 */
public java.math.BigDecimal getElectricangle() {
	return electricangle;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for horzwidth
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getHorzwidth() {
	return horzwidth;
}
/**
 * Getter method for ksvn
 */
public java.math.BigDecimal getKsvn() {
	return ksvn;
}
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.AntennaResource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.AntennaResource)this.getResourceLink().value();
}
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
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
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getResourceLink() {
	if (resourceLink == null)
		resourceLink = new AntennaResourceBandToResourceLink(this);
	return resourceLink;
}
/**
 * Getter method for vertwidth
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getVertwidth() {
	return vertwidth;
}
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
/**
 * Setter method for amplification
 * @param newValue java.math.BigDecimal
 */
public void setAmplification(java.math.BigDecimal newValue) {
	this.amplification = newValue;
}
/**
 * Setter method for electricangle
 */
public void setElectricangle(java.math.BigDecimal newValue) {
	this.electricangle = newValue;
}
/**
 * setEntityContext method comment
 * @param ctx javax.ejb.EntityContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setEntityContext(javax.ejb.EntityContext ctx) throws java.rmi.RemoteException {
	entityContext = ctx;
}
/**
 * Setter method for horzwidth
 * @param newValue java.math.BigDecimal
 */
public void setHorzwidth(java.math.BigDecimal newValue) {
	this.horzwidth = newValue;
}
/**
 * Setter method for ksvn
 */
public void setKsvn(java.math.BigDecimal newValue) {
	this.ksvn = newValue;
}
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setResource(com.hps.july.persistence.AntennaResource aResource) throws java.rmi.RemoteException {
	this.getResourceLink().set(aResource);
}
/**
 * Setter method for vertwidth
 * @param newValue java.math.BigDecimal
 */
public void setVertwidth(java.math.BigDecimal newValue) {
	this.vertwidth = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: hasMaxElectricAngle
	 */
	public boolean isHasMaxElectricAngle() {
		return hasMaxElectricAngle;
	}
	/**
	 * Set accessor for persistent attribute: hasMaxElectricAngle
	 */
	public void setHasMaxElectricAngle(boolean newHasMaxElectricAngle) {
		hasMaxElectricAngle = newHasMaxElectricAngle;
	}
	/**
	 * Get accessor for persistent attribute: maxelectricangle
	 */
	public java.math.BigDecimal getMaxelectricangle() {
		return maxelectricangle;
	}
	/**
	 * Set accessor for persistent attribute: maxelectricangle
	 */
	public void setMaxelectricangle(java.math.BigDecimal newMaxelectricangle) {
		maxelectricangle = newMaxelectricangle;
	}
}
