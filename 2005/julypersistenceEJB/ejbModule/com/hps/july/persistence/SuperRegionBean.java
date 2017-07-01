package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Суперрегион
 */
public class SuperRegionBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	private final static long serialVersionUID = 3206093459760846163L;
	public int supregid;
	public String supregname;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink regionLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink superRegionAccsLink = null;
	public int supregcode;
	/**
	 * Implementation field for persistent attribute: country
	 */
	public int country;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("supregname", getSupregname());
		h.put("supregid", new Integer(getSupregid()));
		h.put("supregcode", new Integer(getSupregcode()));
		h.put("country", new Integer(getCountry()));
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localSupregname =
			(java.lang.String) h.get("supregname");
		Integer localSupregcode = (Integer) h.get("supregcode");
		Integer localCountry = (Integer) h.get("country");

		if (h.containsKey("supregname"))
			setSupregname((localSupregname));
		if (h.containsKey("supregcode"))
			setSupregcode((localSupregcode).intValue());
		if (h.containsKey("country"))
			setCountry((localCountry).intValue());
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getRegionLink());
	links.addElement(getSuperRegionAccsLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	regionLink = null;
	superRegionAccsLink = null;
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
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addRegion(com.hps.july.persistence.Region aRegion) throws java.rmi.RemoteException {
	this.getRegionLink().addElement(aRegion);
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addSuperRegionAccs(com.hps.july.persistence.SuperRegionAcc aSuperRegionAccs) throws java.rmi.RemoteException {
	this.getSuperRegionAccsLink().addElement(aSuperRegionAccs);
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
 * @param argSupregid int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argSupregid, String argSupregname) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	supregid = argSupregid;
	supregname = argSupregname;
	supregcode = 0;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argSupregid int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argSupregid, String argSupregname, int argSupregcode) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	supregid = argSupregid;
	supregname = argSupregname;
	supregcode = argSupregcode;
	country = 1;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argSupregid int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argSupregid, String argSupregname, 
		int argSupregcode, int argCountry) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	supregid = argSupregid;
	supregname = argSupregname;
	supregcode = argSupregcode;
	country = argCountry;
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
 * @param argSupregid int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argSupregid) throws java.rmi.RemoteException {}
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
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getRegion() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getRegionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getRegionLink() {
	if (regionLink == null)
		regionLink = new SuperRegionToRegionLink(this);
	return regionLink;
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSuperRegionAccs() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getSuperRegionAccsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getSuperRegionAccsLink() {
	if (superRegionAccsLink == null)
		superRegionAccsLink = new SuperRegionToSuperRegionAccsLink(this);
	return superRegionAccsLink;
}
/**
 * Getter method for supregcode
 */
public int getSupregcode() {
	return supregcode;
}
/**
 * Insert the method's description here.
 * Creation date: (10.02.2003 13:09:13)
 * @return int
 */
public int getSupregid() {
	return supregid;
}
/**
 * Getter method for supregname
 * @return java.lang.String
 */
public java.lang.String getSupregname() {
	return supregname;
}
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddRegion(com.hps.july.persistence.Region aRegion) {
	this.getRegionLink().secondaryAddElement(aRegion);
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSuperRegionAccs(com.hps.july.persistence.SuperRegionAcc aSuperRegionAccs) {
	this.getSuperRegionAccsLink().secondaryAddElement(aSuperRegionAccs);
}
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveRegion(com.hps.july.persistence.Region aRegion) {
	this.getRegionLink().secondaryRemoveElement(aRegion);
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSuperRegionAccs(com.hps.july.persistence.SuperRegionAcc aSuperRegionAccs) {
	this.getSuperRegionAccsLink().secondaryRemoveElement(aSuperRegionAccs);
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
 * Setter method for supregcode
 */
public void setSupregcode(int newValue) {
	this.supregcode = newValue;
}
/**
 * Setter method for supregname
 * @param newValue java.lang.String
 */
public void setSupregname(java.lang.String newValue) {
	this.supregname = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: country
	 */
	public int getCountry() {
		return country;
	}
	/**
	 * Set accessor for persistent attribute: country
	 */
	public void setCountry(int newCountry) {
		country = newCountry;
	}
}
