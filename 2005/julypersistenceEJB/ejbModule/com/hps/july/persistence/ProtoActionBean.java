package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * �������� ������� �����-�������
 */
public class ProtoActionBean implements EntityBean {
	public int duration;
	private javax.ejb.EntityContext entityContext = null;
	public int order;
	public int projectaction;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer projectType_projecttype;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink projectTypeLink = null;
	public java.lang.Integer projectActionType_projectactiontype;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink projectActionTypeLink = null;
	public Integer stepbefore;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("order", new Integer(getOrder()));
        h.put("projectActionTypeKey", getProjectActionTypeKey());
        h.put("projectTypeKey", getProjectTypeKey());
        h.put("projectaction", new Integer(getProjectaction()));
        h.put("duration", new Integer(getDuration()));
        h.put("stepbefore", getStepbefore());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        Integer localOrder = (Integer) h.get("order");
        Integer localDuration = (Integer) h.get("duration");
        java.lang.Integer localStepbefore = (java.lang.Integer) h.get("stepbefore");

        if ( h.containsKey("order") )
            setOrder((localOrder).intValue());
        if ( h.containsKey("duration") )
            setDuration((localDuration).intValue());
        if ( h.containsKey("stepbefore") )
            setStepbefore((localStepbefore));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getProjectTypeLink());
	links.addElement(getProjectActionTypeLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	projectTypeLink = null;
	projectActionTypeLink = null;
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
 * @param argProjectaction int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argProjectaction, int argOrder, int argProjecttype, int argProjectactiontype,
	int argDuration) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	projectaction = argProjectaction;
	order = argOrder;
	projectType_projecttype = new Integer(argProjecttype);
	projectActionType_projectactiontype = new Integer(argProjectactiontype);
	duration = argDuration;
	stepbefore = null;
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
 * @param argProjectaction int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argProjectaction) throws java.rmi.RemoteException {}
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
 * Getter method for duration
 * @return int
 */
public int getDuration() {
	return duration;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for order
 * @return int
 */
public int getOrder() {
	return order;
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 14:58:32)
 * @return int
 */
public int getProjectaction() {
	return projectaction;
}
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectActionType getProjectActionType() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.ProjectActionType)this.getProjectActionTypeLink().value();
}
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectActionTypeKey getProjectActionTypeKey() {
	com.hps.july.persistence.ProjectActionTypeKey temp = null;
	temp = new com.hps.july.persistence.ProjectActionTypeKey();
	boolean projectActionType_NULLTEST = true;
	projectActionType_NULLTEST &= (projectActionType_projectactiontype == null);
	temp.projectactiontype = ((projectActionType_projectactiontype == null) ? 0 : projectActionType_projectactiontype.intValue());
	if (projectActionType_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getProjectActionTypeLink() {
	if (projectActionTypeLink == null)
		projectActionTypeLink = new ProtoActionToProjectActionTypeLink(this);
	return projectActionTypeLink;
}
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectType getProjectType() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.ProjectType)this.getProjectTypeLink().value();
}
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectTypeKey getProjectTypeKey() {
	com.hps.july.persistence.ProjectTypeKey temp = null;
	temp = new com.hps.july.persistence.ProjectTypeKey();
	boolean projectType_NULLTEST = true;
	projectType_NULLTEST &= (projectType_projecttype == null);
	temp.projecttype = ((projectType_projecttype == null) ? 0 : projectType_projecttype.intValue());
	if (projectType_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getProjectTypeLink() {
	if (projectTypeLink == null)
		projectTypeLink = new ProtoActionToProjectTypeLink(this);
	return projectTypeLink;
}
/**
 * Getter method for stepbefore
 */
public java.lang.Integer getStepbefore() {
	return stepbefore;
}
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetProjectActionTypeKey(com.hps.july.persistence.ProjectActionTypeKey inKey) {
	boolean projectActionType_NULLTEST = (inKey == null);
	if (projectActionType_NULLTEST) projectActionType_projectactiontype = null; else projectActionType_projectactiontype = (new Integer(inKey.projectactiontype));
}
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetProjectTypeKey(com.hps.july.persistence.ProjectTypeKey inKey) {
	boolean projectType_NULLTEST = (inKey == null);
	if (projectType_NULLTEST) projectType_projecttype = null; else projectType_projecttype = (new Integer(inKey.projecttype));
}
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetProjectActionType(com.hps.july.persistence.ProjectActionType aProjectActionType) throws java.rmi.RemoteException {
	this.getProjectActionTypeLink().secondarySet(aProjectActionType);
}
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetProjectType(com.hps.july.persistence.ProjectType aProjectType) throws java.rmi.RemoteException {
	this.getProjectTypeLink().secondarySet(aProjectType);
}
/**
 * Setter method for duration
 * @param newValue int
 */
public void setDuration(int newValue) {
	this.duration = newValue;
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
 * Setter method for order
 * @param newValue int
 */
public void setOrder(int newValue) {
	this.order = newValue;
}
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setProjectActionType(com.hps.july.persistence.ProjectActionType aProjectActionType) throws java.rmi.RemoteException {
	this.getProjectActionTypeLink().set(aProjectActionType);
}
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setProjectType(com.hps.july.persistence.ProjectType aProjectType) throws java.rmi.RemoteException {
	this.getProjectTypeLink().set(aProjectType);
}
/**
 * Setter method for stepbefore
 */
public void setStepbefore(java.lang.Integer newValue) {
	this.stepbefore = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
