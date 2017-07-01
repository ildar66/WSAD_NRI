package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * �������� ����� � ����������� ��� ������ �����������
 */
public class SearchesBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public int order;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer group_searchgroup;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink groupLink = null;
	public java.lang.Integer groupping_searchGroupping;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink grouppingLink = null;
	public java.lang.Integer organization_organization;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink organizationLink = null;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("grouppingKey", getGrouppingKey());
        h.put("order", new Integer(getOrder()));
        h.put("organizationKey", getOrganizationKey());
        h.put("group_searchgroup", getGroup_searchgroup());
        h.put("groupKey", getGroupKey());
        h.put("organization_organization", getOrganization_organization());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        Integer localOrder = (Integer) h.get("order");
        java.lang.Integer localGroup_searchgroup = (java.lang.Integer) h.get("group_searchgroup");
        java.lang.Integer localOrganization_organization = (java.lang.Integer) h.get("organization_organization");

        if ( h.containsKey("order") )
            setOrder((localOrder).intValue());
        if ( h.containsKey("group_searchgroup") )
            setGroup_searchgroup((localGroup_searchgroup));
        if ( h.containsKey("organization_organization") )
            setOrganization_organization((localOrganization_organization));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getGroupLink());
	links.addElement(getGrouppingLink());
	links.addElement(getOrganizationLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	groupLink = null;
	grouppingLink = null;
	organizationLink = null;
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
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(Integer argGroup, Integer argGroupping, Integer argOrganization, Integer argOrder) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.

	group_searchgroup = argGroup;
	groupping_searchGroupping = argGroupping;
	organization_organization = argOrganization;
	order = argOrder.intValue();
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
 * This method was generated for supporting the association named Searches2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SearchGroup getGroup() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.SearchGroup)this.getGroupLink().value();
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 11:19:04)
 * @return java.lang.Integer
 */
public java.lang.Integer getGroup_searchgroup() {
	return group_searchgroup;
}
/**
 * This method was generated for supporting the association named Searches2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SearchGroupKey getGroupKey() {
	com.hps.july.persistence.SearchGroupKey temp = null;
	temp = new com.hps.july.persistence.SearchGroupKey();
	boolean group_NULLTEST = true;
	group_NULLTEST &= (group_searchgroup == null);
	temp.searchgroup = ((group_searchgroup == null) ? 0 : group_searchgroup.intValue());
	if (group_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Searches2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getGroupLink() {
	if (groupLink == null)
		groupLink = new SearchesToGroupLink(this);
	return groupLink;
}
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SearchGroupping getGroupping() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.SearchGroupping)this.getGrouppingLink().value();
}
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SearchGrouppingKey getGrouppingKey() {
	com.hps.july.persistence.SearchGrouppingKey temp = null;
	temp = new com.hps.july.persistence.SearchGrouppingKey();
	boolean groupping_NULLTEST = true;
	groupping_NULLTEST &= (groupping_searchGroupping == null);
	temp.searchGroupping = ((groupping_searchGroupping == null) ? 0 : groupping_searchGroupping.intValue());
	if (groupping_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getGrouppingLink() {
	if (grouppingLink == null)
		grouppingLink = new SearchesToGrouppingLink(this);
	return grouppingLink;
}
/**
 * Getter method for order
 * @return int
 */
public int getOrder() {
	return order;
}
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getOrganization() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Organization)this.getOrganizationLink().value();
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 11:19:04)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrganization_organization() {
	return organization_organization;
}
/**
 * This method was generated for supporting the association named Searches2Organization.  
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
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOrganizationLink() {
	if (organizationLink == null)
		organizationLink = new SearchesToOrganizationLink(this);
	return organizationLink;
}
/**
 * This method was generated for supporting the association named Searches2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetGroupKey(com.hps.july.persistence.SearchGroupKey inKey) {
	boolean group_NULLTEST = (inKey == null);
	if (group_NULLTEST) group_searchgroup = null; else group_searchgroup = (new Integer(inKey.searchgroup));
}
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetGrouppingKey(com.hps.july.persistence.SearchGrouppingKey inKey) {
	boolean groupping_NULLTEST = (inKey == null);
	if (groupping_NULLTEST) groupping_searchGroupping = null; else groupping_searchGroupping = (new Integer(inKey.searchGroupping));
}
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOrganizationKey(com.hps.july.persistence.OrganizationKey inKey) {
	boolean organization_NULLTEST = (inKey == null);
	if (organization_NULLTEST) organization_organization = null; else organization_organization = (new Integer(inKey.organization));
}
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetGroupping(com.hps.july.persistence.SearchGroupping aGroupping) throws java.rmi.RemoteException {
	this.getGrouppingLink().secondarySet(aGroupping);
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
 * This method was generated for supporting the association named Searches2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setGroup(com.hps.july.persistence.SearchGroup aGroup) throws java.rmi.RemoteException {
	this.getGroupLink().set(aGroup);
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 11:19:04)
 * @param newGroup_searchgroup java.lang.Integer
 */
public void setGroup_searchgroup(java.lang.Integer newGroup_searchgroup) {
	group_searchgroup = newGroup_searchgroup;
}
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setGroupping(com.hps.july.persistence.SearchGroupping aGroupping) throws java.rmi.RemoteException {
	this.getGrouppingLink().set(aGroupping);
}
/**
 * Setter method for order
 * @param newValue int
 */
public void setOrder(int newValue) {
	this.order = newValue;
}
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException {
	this.getOrganizationLink().set(anOrganization);
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 11:19:04)
 * @param newOrganization_organization java.lang.Integer
 */
public void setOrganization_organization(java.lang.Integer newOrganization_organization) {
	organization_organization = newOrganization_organization;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}