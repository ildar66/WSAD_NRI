package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ��� ������� (����������)
 */
public class ResourceTypeBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public String name;
	public int resourcetype;
	private final static long serialVersionUID = 3206093459760846163L;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink resourceSubTypeLink = null;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("resourcetype", new Integer(getResourcetype()));
        h.put("name", getName());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        Integer localResourcetype = (Integer) h.get("resourcetype");
        java.lang.String localName = (java.lang.String) h.get("name");

        if ( h.containsKey("resourcetype") )
            setResourcetype((localResourcetype).intValue());
        if ( h.containsKey("name") )
            setName((localName));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getResourceSubTypeLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	resourceSubTypeLink = null;
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
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addResourceSubType(com.hps.july.persistence.ResourceSubType aResourceSubType) throws java.rmi.RemoteException {
	this.getResourceSubTypeLink().addElement(aResourceSubType);
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
 * @param argResourcetype int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argResourcetype) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	resourcetype = argResourcetype;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argResourcetype int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argResourcetype, String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	name = null;
	resourcetype = 0;

	resourcetype = argResourcetype;
	name = argName;
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
 * @param argResourcetype int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argResourcetype) throws java.rmi.RemoteException {}
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
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getResourceSubType() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getResourceSubTypeLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getResourceSubTypeLink() {
	if (resourceSubTypeLink == null)
		resourceSubTypeLink = new ResourceTypeToResourceSubTypeLink(this);
	return resourceSubTypeLink;
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2002 16:39:14)
 * @return int
 */
public int getResourcetype() {
	return resourcetype;
}
/**
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddResourceSubType(com.hps.july.persistence.ResourceSubType aResourceSubType) {
	this.getResourceSubTypeLink().secondaryAddElement(aResourceSubType);
}
/**
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveResourceSubType(com.hps.july.persistence.ResourceSubType aResourceSubType) {
	this.getResourceSubTypeLink().secondaryRemoveElement(aResourceSubType);
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
 * Creation date: (16.04.2002 16:39:14)
 * @param newResourcetype int
 */
public void setResourcetype(int newResourcetype) {
	resourcetype = newResourcetype;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}