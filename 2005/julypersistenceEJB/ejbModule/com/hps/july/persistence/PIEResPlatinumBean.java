package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������ PIE - ������� �� Platinum
 */
public class PIEResPlatinumBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public String idresplatinum;
	public String nameres;
	public int owner;
	private final static long serialVersionUID = 3206093459760846163L;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink pIEResLinksLink = null;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("owner", new Integer(getOwner()));
        h.put("idresplatinum", getIdresplatinum());
        h.put("nameres", getNameres());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.String localNameres = (java.lang.String) h.get("nameres");

        if ( h.containsKey("nameres") )
            setNameres((localNameres));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getPIEResLinksLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	pIEResLinksLink = null;
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
 * @param argIdresplatinum java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(java.lang.String argIdresplatinum, int argOwner, String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	idresplatinum = argIdresplatinum;
	owner = argOwner;
	nameres = argName;
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
 * @param argIdresplatinum java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(java.lang.String argIdresplatinum) throws java.rmi.RemoteException {}
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
 * Insert the method's description here.
 * Creation date: (09.01.2003 14:31:31)
 * @return java.lang.String
 */
public java.lang.String getIdresplatinum() {
	return idresplatinum;
}
/**
 * Getter method for nameres
 * @return java.lang.String
 */
public java.lang.String getNameres() {
	return nameres;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 14:31:31)
 * @return int
 */
public int getOwner() {
	return owner;
}
/**
 * This method was generated for supporting the association named PIEResLink2resplat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEResLinks() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPIEResLinksLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named PIEResLink2resplat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPIEResLinksLink() {
	if (pIEResLinksLink == null)
		pIEResLinksLink = new PIEResPlatinumToPIEResLinksLink(this);
	return pIEResLinksLink;
}
/**
 * This method was generated for supporting the association named PIEResLink2resplat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEResLinks(com.hps.july.persistence.PIEResLink aPIEResLinks) {
	this.getPIEResLinksLink().secondaryAddElement(aPIEResLinks);
}
/**
 * This method was generated for supporting the association named PIEResLink2resplat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEResLinks(com.hps.july.persistence.PIEResLink aPIEResLinks) {
	this.getPIEResLinksLink().secondaryRemoveElement(aPIEResLinks);
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
 * Setter method for nameres
 * @param newValue java.lang.String
 */
public void setNameres(java.lang.String newValue) {
	this.nameres = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
