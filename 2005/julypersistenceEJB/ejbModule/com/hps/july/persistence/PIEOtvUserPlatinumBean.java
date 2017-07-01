package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������ PIE - ������������� �� Platinum
 */
public class PIEOtvUserPlatinumBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public String name;
	public String otvuserplatinum;
	public String pstatus;
	private final static long serialVersionUID = 3206093459760846163L;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink pIEOtvUserLinksLink = null;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("pstatus", getPstatus());
        h.put("otvuserplatinum", getOtvuserplatinum());
        h.put("name", getName());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.String localPstatus = (java.lang.String) h.get("pstatus");
        java.lang.String localName = (java.lang.String) h.get("name");

        if ( h.containsKey("pstatus") )
            setPstatus((localPstatus));
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
	links.addElement(getPIEOtvUserLinksLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	pIEOtvUserLinksLink = null;
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
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addPIEOtvUserLinks(com.hps.july.persistence.PIEOtvUserLink aPIEOtvUserLinks) throws java.rmi.RemoteException {
	this.getPIEOtvUserLinksLink().addElement(aPIEOtvUserLinks);
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
 * @param argOtvuserplatinum java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(java.lang.String argOtvuserplatinum, String argPStatus, String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	otvuserplatinum = argOtvuserplatinum;
	pstatus = argPStatus;
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
 * @param argOtvuserplatinum java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(java.lang.String argOtvuserplatinum) throws java.rmi.RemoteException {}
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
 * Creation date: (09.01.2003 14:28:50)
 * @return java.lang.String
 */
public java.lang.String getOtvuserplatinum() {
	return otvuserplatinum;
}
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEOtvUserLinks() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPIEOtvUserLinksLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPIEOtvUserLinksLink() {
	if (pIEOtvUserLinksLink == null)
		pIEOtvUserLinksLink = new PIEOtvUserPlatinumToPIEOtvUserLinksLink(this);
	return pIEOtvUserLinksLink;
}
/**
 * Getter method for pstatus
 * @return java.lang.String
 */
public java.lang.String getPstatus() {
	return pstatus;
}
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEOtvUserLinks(com.hps.july.persistence.PIEOtvUserLink aPIEOtvUserLinks) {
	this.getPIEOtvUserLinksLink().secondaryAddElement(aPIEOtvUserLinks);
}
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEOtvUserLinks(com.hps.july.persistence.PIEOtvUserLink aPIEOtvUserLinks) {
	this.getPIEOtvUserLinksLink().secondaryRemoveElement(aPIEOtvUserLinks);
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
 * Setter method for pstatus
 * @param newValue java.lang.String
 */
public void setPstatus(java.lang.String newValue) {
	this.pstatus = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}