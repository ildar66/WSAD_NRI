package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * �������� ������� �� ������
 */
public class ResourceTaxeBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public java.math.BigDecimal nds;
	public java.math.BigDecimal nsp;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer resource_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink resourceLink = null;
	public java.sql.Date date;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("date", getDate());
        h.put("nds", getNds());
        h.put("resourceKey", getResourceKey());
        h.put("resource_resource", getResource_resource());
        h.put("nsp", getNsp());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.sql.Date localDate = (java.sql.Date) h.get("date");
        java.math.BigDecimal localNds = (java.math.BigDecimal) h.get("nds");
        java.lang.Integer localResource_resource = (java.lang.Integer) h.get("resource_resource");
        java.math.BigDecimal localNsp = (java.math.BigDecimal) h.get("nsp");

        if ( h.containsKey("date") )
            setDate((localDate));
        if ( h.containsKey("nds") )
            setNds((localNds));
        if ( h.containsKey("resource_resource") )
            setResource_resource((localResource_resource));
        if ( h.containsKey("nsp") )
            setNsp((localNsp));

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
 * @param argResource com.hps.july.persistence.ResourceKey
 * @param argDate java.sql.Date
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(ResourceKey argResource, java.sql.Date argDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	boolean resource_NULLTEST = (argResource == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(argResource.resource));
	date = argDate;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDate java.util.Date
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(java.sql.Date argDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	date = argDate;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDate java.util.Date
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(java.sql.Date argDate, Integer argResource, java.math.BigDecimal argNds, java.math.BigDecimal argNsp ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	nds = null;
	nsp = null;
	resource_resource = null;
	date = null;

	date = argDate;
	resource_resource = argResource;
	nds = PersistenceUtil.dec(argNds, 2);
	nsp = PersistenceUtil.dec(argNsp, 2);
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
 * @param argResource com.hps.july.persistence.ResourceKey
 * @param argDate java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(ResourceKey argResource, java.sql.Date argDate) throws java.rmi.RemoteException {}
/**
 * ejbPostCreate method for a CMP entity bean
 * @param argDate java.util.Date
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(java.util.Date argDate) throws java.rmi.RemoteException {}
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
 * Getter method for date
 */
public java.sql.Date getDate() {
	return date;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for nds
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNds() {
	return nds;
}
/**
 * Getter method for nsp
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNsp() {
	return nsp;
}
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Resource)this.getResourceLink().value();
}
/**
 * Insert the method's description here.
 * Creation date: (18.04.2002 9:32:49)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource_resource() {
	return resource_resource;
}
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
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
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getResourceLink() {
	if (resourceLink == null)
		resourceLink = new ResourceTaxeToResourceLink(this);
	return resourceLink;
}
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
/**
 * Setter method for date
 */
public void setDate(java.sql.Date newValue) {
	this.date = newValue;
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
 * Setter method for nds
 * @param newValue java.math.BigDecimal
 */
public void setNds(java.math.BigDecimal newValue) {
	this.nds = PersistenceUtil.dec(newValue, 2);
}
/**
 * Setter method for nsp
 * @param newValue java.math.BigDecimal
 */
public void setNsp(java.math.BigDecimal newValue) {
	this.nsp = PersistenceUtil.dec(newValue, 2);
}
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException {
	this.getResourceLink().set(aResource);
}
/**
 * Insert the method's description here.
 * Creation date: (18.04.2002 9:32:49)
 * @param newResource_resource java.lang.Integer
 */
public void setResource_resource(java.lang.Integer newResource_resource) {
	resource_resource = newResource_resource;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
