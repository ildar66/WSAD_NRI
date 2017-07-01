package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������������� �� �������
 */
public class PositionResponsibleWorkersBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer worker_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink workerLink = null;
	public java.lang.Integer type_responsibilityType;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink typeLink = null;
	public java.lang.Integer position_storageplace;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink positionLink = null;
	public String resptype;
	public java.lang.Integer organization_organization;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink organizationLink = null;
	public Integer operator;
	private Integer tempOperator;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("organizationKey", getOrganizationKey());
        h.put("resptype", getResptype());
        h.put("workerKey", getWorkerKey());
        h.put("positionKey", getPositionKey());
        h.put("operator", getOperator());
        h.put("typeKey", getTypeKey());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");

        if ( h.containsKey("operator") )
            setOperator((localOperator));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getWorkerLink());
	links.addElement(getPositionLink());
	links.addElement(getTypeLink());
	links.addElement(getOrganizationLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	workerLink = null;
	positionLink = null;
	typeLink = null;
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
	setOperator();
}
/**
 * ejbCreate method for a CMP entity bean
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(Integer argType, Integer argWorker, Integer argPosition) throws javax.ejb.CreateException, java.rmi.RemoteException {

	ejbCreate(argType, argPosition, "W");
	worker_worker = argWorker;
}
/**
 * ejbCreate method for a CMP entity bean
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(Integer argType, Integer argPosition, String argResptype) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	type_responsibilityType = argType;
	position_storageplace = argPosition;
	resptype = argResptype;
	worker_worker = null;
	organization_organization = null;
	operator = null;
	setOperator();
}
/**
 * ejbLoad method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbLoad() throws java.rmi.RemoteException {
	_initLinks();
	setOperator();
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
 * @param argType com.hps.july.persistence.ResponsibilityTypeKey
 * @param argPosition com.hps.july.persistence.StoragePlaceKey
 * @param argResptype java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(ResponsibilityTypeKey argType, StoragePlaceKey argPosition, java.lang.String argResptype) throws java.rmi.RemoteException {}
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
public void ejbStore() throws java.rmi.RemoteException {
	if(tempOperator == null) {
		System.out.println("PositionResponsibleWorkers_ejbStore �� ��������� �������� !!!");
		setOperator(null);
	}
	else
		setOperator(tempOperator);
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for operator
 */
public java.lang.Integer getOperator() {
	return operator;
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getOrganization() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Organization)this.getOrganizationLink().value();
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
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
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOrganizationLink() {
	if (organizationLink == null)
		organizationLink = new PositionResponsibleWorkersToOrganizationLink(this);
	return organizationLink;
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Position getPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Position)this.getPositionLink().value();
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getPositionKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean position_NULLTEST = true;
	position_NULLTEST &= (position_storageplace == null);
	temp.storageplace = ((position_storageplace == null) ? 0 : position_storageplace.intValue());
	if (position_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getPositionLink() {
	if (positionLink == null)
		positionLink = new PositionResponsibleWorkersToPositionLink(this);
	return positionLink;
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2003 12:01:55)
 * @return java.lang.String
 */
public java.lang.String getResptype() {
	return resptype;
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Types.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResponsibilityType getType() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.ResponsibilityType)this.getTypeLink().value();
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Types.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResponsibilityTypeKey getTypeKey() {
	com.hps.july.persistence.ResponsibilityTypeKey temp = null;
	temp = new com.hps.july.persistence.ResponsibilityTypeKey();
	boolean type_NULLTEST = true;
	type_NULLTEST &= (type_responsibilityType == null);
	temp.responsibilityType = ((type_responsibilityType == null) ? 0 : type_responsibilityType.intValue());
	if (type_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Types.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getTypeLink() {
	if (typeLink == null)
		typeLink = new PositionResponsibleWorkersToTypeLink(this);
	return typeLink;
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getWorker() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getWorkerLink().value();
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getWorkerKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean worker_NULLTEST = true;
	worker_NULLTEST &= (worker_worker == null);
	temp.worker = ((worker_worker == null) ? 0 : worker_worker.intValue());
	if (worker_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getWorkerLink() {
	if (workerLink == null)
		workerLink = new PositionResponsibleWorkersToWorkerLink(this);
	return workerLink;
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOrganizationKey(com.hps.july.persistence.OrganizationKey inKey) {
	boolean organization_NULLTEST = (inKey == null);
	if (organization_NULLTEST) organization_organization = null; else organization_organization = (new Integer(inKey.organization));
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetPositionKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean position_NULLTEST = (inKey == null);
	if (position_NULLTEST) position_storageplace = null; else position_storageplace = (new Integer(inKey.storageplace));
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Types.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetTypeKey(com.hps.july.persistence.ResponsibilityTypeKey inKey) {
	boolean type_NULLTEST = (inKey == null);
	if (type_NULLTEST) type_responsibilityType = null; else type_responsibilityType = (new Integer(inKey.responsibilityType));
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetWorkerKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean worker_NULLTEST = (inKey == null);
	if (worker_NULLTEST) worker_worker = null; else worker_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException {
	this.getOrganizationLink().secondarySet(anOrganization);
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetWorker(com.hps.july.persistence.Worker aWorker) throws java.rmi.RemoteException {
	this.getWorkerLink().secondarySet(aWorker);
}
/**
 * setEntityContext method comment
 * @param ctx javax.ejb.EntityContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setEntityContext(javax.ejb.EntityContext ctx) throws java.rmi.RemoteException {
	entityContext = ctx;
}
	private void setOperator() throws java.rmi.RemoteException{
		String operatorName = entityContext.getCallerIdentity().getName();
		tempOperator = OperatorObject.getOperatorCode(operatorName);
		setOperator(tempOperator);
	}
/**
 * Setter method for operator
 */
public void setOperator(java.lang.Integer newValue) {
	this.operator = newValue;
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException {
	this.getOrganizationLink().set(anOrganization);
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException {
	this.getPositionLink().set(aPosition);
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Types.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setType(com.hps.july.persistence.ResponsibilityType aType) throws java.rmi.RemoteException {
	this.getTypeLink().set(aType);
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setWorker(com.hps.july.persistence.Worker aWorker) throws java.rmi.RemoteException {
	this.getWorkerLink().set(aWorker);
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}