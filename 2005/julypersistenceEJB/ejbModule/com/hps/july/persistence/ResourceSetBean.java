package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ����� ��������
 */
public class ResourceSetBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public java.math.BigDecimal mainpartqty;
	public String name;
	public int resourceset;
	private final static long serialVersionUID = 3206093459760846163L;
	public String type;
	public java.lang.Integer mainpart_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink mainpartLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink setPartsLink = null;
	/**
	 * Implementation field for persistent attribute: resourcesetclass
	 */
	public java.lang.Integer resourcesetclass;
	/**
	 * Implementation field for persistent attribute: nfsitemid
	 */
	public java.lang.String nfsitemid;
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getMainpartLink());
	links.addElement(getSetPartsLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	mainpartLink = null;
	setPartsLink = null;
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
 * @param argResourceset int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argResourceset) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	resourceset = argResourceset;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argResourceset int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argResourceset, String argName, Integer argMainPart, java.math.BigDecimal argMainPartQty, 
	String argType ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	mainpartqty = null;
	name = null;
	resourceset = 0;
	type = null;
	mainpart_resource = null;

	resourceset = argResourceset;
	name = argName;
	mainpart_resource = argMainPart;
	mainpartqty = argMainPartQty;
	type = argType;
	//resourcesetclass = new Integer(0);
	nfsitemid = null;
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
 * @param argResourceset int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argResourceset) throws java.rmi.RemoteException {}
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
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getMainpart() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Resource)this.getMainpartLink().value();
}
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getMainpartKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean mainpart_NULLTEST = true;
	mainpart_NULLTEST &= (mainpart_resource == null);
	temp.resource = ((mainpart_resource == null) ? 0 : mainpart_resource.intValue());
	if (mainpart_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getMainpartLink() {
	if (mainpartLink == null)
		mainpartLink = new ResourceSetToMainpartLink(this);
	return mainpartLink;
}
/**
 * Getter method for mainpartqty
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getMainpartqty() {
	return mainpartqty;
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
 * Creation date: (18.04.2002 9:44:19)
 * @return int
 */
public int getResourceset() {
	return resourceset;
}
/**
 * This method was generated for supporting the association named ResourceSetParts2ResourceSet.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSetParts() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getSetPartsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named ResourceSetParts2ResourceSet.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getSetPartsLink() {
	if (setPartsLink == null)
		setPartsLink = new ResourceSetToSetPartsLink(this);
	return setPartsLink;
}
/**
 * Getter method for type
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetMainpartKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean mainpart_NULLTEST = (inKey == null);
	if (mainpart_NULLTEST) mainpart_resource = null; else mainpart_resource = (new Integer(inKey.resource));
}
/**
 * This method was generated for supporting the association named ResourceSetParts2ResourceSet.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSetParts(com.hps.july.persistence.ResourceSetPart aSetParts) {
	this.getSetPartsLink().secondaryAddElement(aSetParts);
}
/**
 * This method was generated for supporting the association named ResourceSetParts2ResourceSet.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSetParts(com.hps.july.persistence.ResourceSetPart aSetParts) {
	this.getSetPartsLink().secondaryRemoveElement(aSetParts);
}
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetMainpart(com.hps.july.persistence.Resource aMainpart) throws java.rmi.RemoteException {
	this.getMainpartLink().secondarySet(aMainpart);
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
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setMainpart(com.hps.july.persistence.Resource aMainpart) throws java.rmi.RemoteException {
	this.getMainpartLink().set(aMainpart);
}
/**
 * Setter method for mainpartqty
 * @param newValue java.math.BigDecimal
 */
public void setMainpartqty(java.math.BigDecimal newValue) {
	this.mainpartqty = newValue.setScale( 3 );
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
 * Creation date: (18.04.2002 9:44:19)
 * @param newResourceset int
 */
public void setResourceset(int newResourceset) {
	resourceset = newResourceset;
}
/**
 * Setter method for type
 * @param newValue java.lang.String
 */
public void setType(java.lang.String newValue) {
	this.type = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: resourcesetclass
	 */
	public java.lang.Integer getResourcesetclass() {
		return resourcesetclass;
	}
	/**
	 * Set accessor for persistent attribute: resourcesetclass
	 */
	public void setResourcesetclass(java.lang.Integer newResourcesetclass) {
		resourcesetclass = newResourcesetclass;
	}
	/**
	 * Get accessor for persistent attribute: nfsitemid
	 */
	public java.lang.String getNfsitemid() {
		return nfsitemid;
	}
	/**
	 * Set accessor for persistent attribute: nfsitemid
	 */
	public void setNfsitemid(java.lang.String newNfsitemid) {
		nfsitemid = newNfsitemid;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("name", getName());
		h.put("mainpartKey", getMainpartKey());
		h.put("mainpartqty", getMainpartqty());
		h.put("nfsitemid", getNfsitemid());
		h.put("type", getType());
		h.put("resourceset", new Integer(getResourceset()));
		h.put("resourcesetclass", getResourcesetclass());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localName = (java.lang.String) h.get("name");
		java.math.BigDecimal localMainpartqty =
			(java.math.BigDecimal) h.get("mainpartqty");
		java.lang.String localNfsitemid = (java.lang.String) h.get("nfsitemid");
		java.lang.String localType = (java.lang.String) h.get("type");
		Integer localResourceset = (Integer) h.get("resourceset");
		java.lang.Integer localResourcesetclass =
			(java.lang.Integer) h.get("resourcesetclass");

		if (h.containsKey("name"))
			setName((localName));
		if (h.containsKey("mainpartqty"))
			setMainpartqty((localMainpartqty));
		if (h.containsKey("nfsitemid"))
			setNfsitemid((localNfsitemid));
		if (h.containsKey("type"))
			setType((localType));
		if (h.containsKey("resourceset"))
			setResourceset((localResourceset).intValue());
		if (h.containsKey("resourcesetclass"))
			setResourcesetclass((localResourcesetclass));
	}
}
