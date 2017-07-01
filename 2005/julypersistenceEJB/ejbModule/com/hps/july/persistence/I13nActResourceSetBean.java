package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������ ���� ���������� ��������������
 */
public class I13nActResourceSetBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer resource_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink resourceLink = null;
	public java.lang.Integer i13nAct_document;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink i13nActLink = null;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("resourceKey", getResourceKey());
        h.put("i13nActKey", getI13nActKey());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {


}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getResourceLink());
	links.addElement(getI13nActLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	resourceLink = null;
	i13nActLink = null;
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
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	resource_resource = null;
	i13nAct_document = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate( Integer argDocument, Integer argResource) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	i13nAct_document = argDocument;
	resource_resource = argResource;
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
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate() throws java.rmi.RemoteException {}
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
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.I13nAct getI13nAct() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.I13nAct)this.getI13nActLink().value();
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getI13nActKey() {
	com.hps.july.persistence.DocumentKey temp = null;
	temp = new com.hps.july.persistence.DocumentKey();
	boolean i13nAct_NULLTEST = true;
	i13nAct_NULLTEST &= (i13nAct_document == null);
	temp.document = ((i13nAct_document == null) ? 0 : i13nAct_document.intValue());
	if (i13nAct_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getI13nActLink() {
	if (i13nActLink == null)
		i13nActLink = new I13nActResourceSetToI13nActLink(this);
	return i13nActLink;
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Resource)this.getResourceLink().value();
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
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
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getResourceLink() {
	if (resourceLink == null)
		resourceLink = new I13nActResourceSetToResourceLink(this);
	return resourceLink;
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetI13nActKey(com.hps.july.persistence.DocumentKey inKey) {
	boolean i13nAct_NULLTEST = (inKey == null);
	if (i13nAct_NULLTEST) i13nAct_document = null; else i13nAct_document = (new Integer(inKey.document));
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
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
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setI13nAct(com.hps.july.persistence.I13nAct anI13nAct) throws java.rmi.RemoteException {
	this.getI13nActLink().set(anI13nAct);
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException {
	this.getResourceLink().set(aResource);
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
