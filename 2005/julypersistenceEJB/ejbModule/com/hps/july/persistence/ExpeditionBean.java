package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Экспедитор
 */
public class ExpeditionBean extends StoragePlaceBean {
	private final static long serialVersionUID = 3206093459760846163L;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink expeditorLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink organizationLink = null;
	public java.lang.Integer organization_organization;
	public java.lang.Integer expeditor_worker;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("createdby", getCreatedby());
        h.put("storageplace", new Integer(getStorageplace()));
        h.put("expeditorKey", getExpeditorKey());
        h.put("organizationKey", getOrganizationKey());
        h.put("address", getAddress());
        h.put("closedate", getClosedate());
        h.put("created", getCreated());
        h.put("modifiedby", getModifiedby());
        h.put("operator", getOperator());
        h.put("divisionKey", getDivisionKey());
        h.put("modified", getModified());
        h.put("name", getName());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.Integer localCreatedby = (java.lang.Integer) h.get("createdby");
        Integer localStorageplace = (Integer) h.get("storageplace");
        java.lang.String localAddress = (java.lang.String) h.get("address");
        java.sql.Date localClosedate = (java.sql.Date) h.get("closedate");
        java.sql.Timestamp localCreated = (java.sql.Timestamp) h.get("created");
        java.lang.Integer localModifiedby = (java.lang.Integer) h.get("modifiedby");
        java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
        java.sql.Timestamp localModified = (java.sql.Timestamp) h.get("modified");
        java.lang.String localName = (java.lang.String) h.get("name");

        if ( h.containsKey("createdby") )
            setCreatedby((localCreatedby));
        if ( h.containsKey("storageplace") )
            setStorageplace((localStorageplace).intValue());
        if ( h.containsKey("address") )
            setAddress((localAddress));
        if ( h.containsKey("closedate") )
            setClosedate((localClosedate));
        if ( h.containsKey("created") )
            setCreated((localCreated));
        if ( h.containsKey("modifiedby") )
            setModifiedby((localModifiedby));
        if ( h.containsKey("operator") )
            setOperator((localOperator));
        if ( h.containsKey("modified") )
            setModified((localModified));
        if ( h.containsKey("name") )
            setName((localName));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getOrganizationLink());
	links.addElement(getExpeditorLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	organizationLink = null;
	expeditorLink = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argStorageplace, Integer argDivision, String argName, String argAddress ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	super.ejbCreate( argStorageplace, argDivision, argName, argAddress );
	_initLinks();
	// All CMP fields should be initialized here.
	organization_organization = null;
	expeditor_worker = null;
}
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getExpeditor() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getExpeditorLink().value();
}
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getExpeditorKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean expeditor_NULLTEST = true;
	expeditor_NULLTEST &= (expeditor_worker == null);
	temp.worker = ((expeditor_worker == null) ? 0 : expeditor_worker.intValue());
	if (expeditor_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getExpeditorLink() {
	if (expeditorLink == null)
		expeditorLink = new ExpeditionToExpeditorLink(this);
	return expeditorLink;
}
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getOrganization() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Organization)this.getOrganizationLink().value();
}
/**
 * This method was generated for supporting the association named Expedition2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OrganizationKey getOrganizationKey() {
	com.hps.july.persistence.OrganizationKey temp = null;
	temp = new com.hps.july.persistence.OrganizationKey();
	boolean organization_NULLTEST = true;
	organization_NULLTEST &= (organization_organization == null);
	temp.organization = ((organization_organization == null) ? 0 : organization_organization.intValue());
	if (organization_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOrganizationLink() {
	if (organizationLink == null)
		organizationLink = new ExpeditionToOrganizationLink(this);
	return organizationLink;
}
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetExpeditorKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean expeditor_NULLTEST = (inKey == null);
	if (expeditor_NULLTEST) expeditor_worker = null; else expeditor_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named Expedition2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOrganizationKey(com.hps.july.persistence.OrganizationKey inKey) {
	boolean organization_NULLTEST = (inKey == null);
	if (organization_NULLTEST) organization_organization = null; else organization_organization = (new Integer(inKey.organization));
}
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetExpeditor(com.hps.july.persistence.Worker anExpeditor) throws java.rmi.RemoteException {
	this.getExpeditorLink().secondarySet(anExpeditor);
}
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException {
	this.getOrganizationLink().secondarySet(anOrganization);
}
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setExpeditor(com.hps.july.persistence.Worker anExpeditor) throws java.rmi.RemoteException {
	this.getExpeditorLink().set(anExpeditor);
}
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException {
	this.getOrganizationLink().set(anOrganization);
}
}
