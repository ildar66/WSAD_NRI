package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ���������� ������� ������
 */
public class LeaseRuleBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	private final static long serialVersionUID = 3206093459760846163L;
	public int leaseRule;
	public java.lang.Integer leaseDocument_leaseDocument;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink leaseDocumentLink = null;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("leaseRule", new Integer(getLeaseRule()));
        h.put("leaseDocumentKey", getLeaseDocumentKey());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        Integer localLeaseRule = (Integer) h.get("leaseRule");

        if ( h.containsKey("leaseRule") )
            setLeaseRule((localLeaseRule).intValue());

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getLeaseDocumentLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	leaseDocumentLink = null;
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
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argLeaseRule int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argLeaseRule) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	leaseRule = argLeaseRule;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argLeaseRule int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(Integer argLeaseRule, Integer argLeaseDocument ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	leaseRule = argLeaseRule.intValue();
	leaseDocument_leaseDocument = argLeaseDocument;
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
 * ejbPostCreate method for a CMP entity bean
 * @param argLeaseRule int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argLeaseRule) throws java.rmi.RemoteException {}
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
 * This method was generated for supporting the association named LeaseRule2leasedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocument getLeaseDocument() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.LeaseDocument)this.getLeaseDocumentLink().value();
}
/**
 * This method was generated for supporting the association named LeaseRule2leasedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getLeaseDocumentKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean leaseDocument_NULLTEST = true;
	leaseDocument_NULLTEST &= (leaseDocument_leaseDocument == null);
	temp.leaseDocument = ((leaseDocument_leaseDocument == null) ? 0 : leaseDocument_leaseDocument.intValue());
	if (leaseDocument_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseRule2leasedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getLeaseDocumentLink() {
	if (leaseDocumentLink == null)
		leaseDocumentLink = new LeaseRuleToLeaseDocumentLink(this);
	return leaseDocumentLink;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 17:55:58)
 * @return int
 */
public int getLeaseRule() {
	return leaseRule;
}
/**
 * This method was generated for supporting the association named LeaseRule2leasedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetLeaseDocumentKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean leaseDocument_NULLTEST = (inKey == null);
	if (leaseDocument_NULLTEST) leaseDocument_leaseDocument = null; else leaseDocument_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseRule2leasedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetLeaseDocument(com.hps.july.persistence.LeaseDocument aLeaseDocument) throws java.rmi.RemoteException {
	this.getLeaseDocumentLink().secondarySet(aLeaseDocument);
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
 * This method was generated for supporting the association named LeaseRule2leasedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setLeaseDocument(com.hps.july.persistence.LeaseDocument aLeaseDocument) throws java.rmi.RemoteException {
	this.getLeaseDocumentLink().set(aLeaseDocument);
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 17:55:58)
 * @param newLeaseRule int
 */
public void setLeaseRule(int newLeaseRule) {
	leaseRule = newLeaseRule;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
