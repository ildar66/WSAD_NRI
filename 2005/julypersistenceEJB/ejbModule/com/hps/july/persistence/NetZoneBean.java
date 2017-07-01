package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Зона сети
 */
public class NetZoneBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public String name;
	public int netzone;
	private final static long serialVersionUID = 3206093459760846163L;
	public String zonecode;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink positionLink = null;
	public int regionid;
	/**
	 * Implementation field for persistent attribute: tcode
	 */
	public java.math.BigDecimal tcode;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("zonecode", getZonecode());
		h.put("name", getName());
		h.put("netzone", new Integer(getNetzone()));
		h.put("regionid", new Integer(getRegionid()));
		h.put("tcode", getTcode());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localZonecode = (java.lang.String) h.get("zonecode");
		java.lang.String localName = (java.lang.String) h.get("name");
		Integer localNetzone = (Integer) h.get("netzone");
		Integer localRegionid = (Integer) h.get("regionid");
		java.math.BigDecimal localTcode = (java.math.BigDecimal) h.get("tcode");

		if (h.containsKey("zonecode"))
			setZonecode((localZonecode));
		if (h.containsKey("name"))
			setName((localName));
		if (h.containsKey("netzone"))
			setNetzone((localNetzone).intValue());
		if (h.containsKey("regionid"))
			setRegionid((localRegionid).intValue());
		if (h.containsKey("tcode"))
			setTcode((localTcode));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getPositionLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	positionLink = null;
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
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException {
	this.getPositionLink().addElement(aPosition);
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
 * @param argNetzone int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argNetzone) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	netzone = argNetzone;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argNetzone int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argNetzone, String argName, String argZonecode ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	name = null;
	netzone = 0;
	zonecode = null;

	netzone = argNetzone;
	name = argName;
	zonecode = argZonecode;
	regionid = 1;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argNetzone int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argNetzone, String argName, String argZonecode, int argRegionId ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	name = null;
	netzone = 0;
	zonecode = null;

	netzone = argNetzone;
	name = argName;
	zonecode = argZonecode;
	regionid = argRegionId;
	tcode = new java.math.BigDecimal(0);
}

public void ejbCreate(int argNetzone, String argName, String argZonecode, int argRegionId, java.math.BigDecimal argTCode ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	name = null;
	netzone = 0;
	zonecode = null;

	netzone = argNetzone;
	name = argName;
	zonecode = argZonecode;
	regionid = argRegionId;
	tcode = argTCode;
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
 * @param argNetzone int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argNetzone) throws java.rmi.RemoteException {}
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
 * Getter method for name
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2002 15:35:11)
 * @return int
 */
public int getNetzone() {
	return netzone;
}
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPositionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPositionLink() {
	if (positionLink == null)
		positionLink = new NetZoneToPositionLink(this);
	return positionLink;
}
/**
 * Getter method for regionid
 */
public int getRegionid() {
	return regionid;
}
/**
 * Getter method for zonecode
 * @return java.lang.String
 */
public java.lang.String getZonecode() {
	return zonecode;
}
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPosition(com.hps.july.persistence.Position aPosition) {
	this.getPositionLink().secondaryAddElement(aPosition);
}
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePosition(com.hps.july.persistence.Position aPosition) {
	this.getPositionLink().secondaryRemoveElement(aPosition);
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
 * Setter method for name
 * @param newValue java.lang.String
 */
public void setName(java.lang.String newValue) {
	this.name = newValue;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2002 15:35:11)
 * @param newNetzone int
 */
public void setNetzone(int newNetzone) {
	netzone = newNetzone;
}
/**
 * Setter method for regionid
 */
public void setRegionid(int newValue) {
	this.regionid = newValue;
}
/**
 * Setter method for zonecode
 * @param newValue java.lang.String
 */
public void setZonecode(java.lang.String newValue) {
	this.zonecode = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: tcode
	 */
	public java.math.BigDecimal getTcode() {
		return tcode;
	}
	/**
	 * Set accessor for persistent attribute: tcode
	 */
	public void setTcode(java.math.BigDecimal newTcode) {
		tcode = newTcode;
	}
}
