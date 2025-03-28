package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ����� ������� �� �����������
 */
public class SuperRegionAccBean implements EntityBean {
	public int accessid;
	public boolean editfact;
	public boolean editplan;
	private javax.ejb.EntityContext entityContext = null;
	private final static long serialVersionUID = 3206093459760846163L;
	public boolean viewfact;
	public boolean viewplan;
	public java.lang.Integer operator_operator;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink operatorLink = null;
	public java.lang.Integer superregion_supregid;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink superregionLink = null;
	/**
	 * Implementation field for persistent attribute: viewarenda
	 */
	public java.lang.Boolean viewarenda;
	/**
	 * Implementation field for persistent attribute: editarenda
	 */
	public java.lang.Boolean editarenda;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("operatorKey", getOperatorKey());
		h.put("superregionKey", getSuperregionKey());
		h.put("viewplan", new Boolean(getViewplan()));
		h.put("accessid", new Integer(getAccessid()));
		h.put("editfact", new Boolean(getEditfact()));
		h.put("viewfact", new Boolean(getViewfact()));
		h.put("editplan", new Boolean(getEditplan()));
		h.put("editarenda", getEditarenda());
		h.put("viewarenda", getViewarenda());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		Boolean localViewplan = (Boolean) h.get("viewplan");
		Boolean localEditfact = (Boolean) h.get("editfact");
		Boolean localViewfact = (Boolean) h.get("viewfact");
		Boolean localEditplan = (Boolean) h.get("editplan");
		java.lang.Boolean localEditarenda =
			(java.lang.Boolean) h.get("editarenda");
		java.lang.Boolean localViewarenda =
			(java.lang.Boolean) h.get("viewarenda");

		if (h.containsKey("viewplan"))
			setViewplan((localViewplan).booleanValue());
		if (h.containsKey("editfact"))
			setEditfact((localEditfact).booleanValue());
		if (h.containsKey("viewfact"))
			setViewfact((localViewfact).booleanValue());
		if (h.containsKey("editplan"))
			setEditplan((localEditplan).booleanValue());
		if (h.containsKey("editarenda"))
			setEditarenda((localEditarenda));
		if (h.containsKey("viewarenda"))
			setViewarenda((localViewarenda));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getOperatorLink());
	links.addElement(getSuperregionLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	operatorLink = null;
	superregionLink = null;
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
 * @param argAccessid int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argAccessid, int argOperatorId, int argSupregionId, 
		boolean argViewPlan, boolean argViewFact,
		boolean argEditPlan, boolean argEditFact) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	accessid = argAccessid;
	operator_operator = new Integer(argOperatorId);
	superregion_supregid = new Integer(argSupregionId);
	viewplan = argViewPlan;
	viewfact = argViewFact;
	editplan = argEditPlan;
	editfact = argEditFact;
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
 * @param argAccessid int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argAccessid) throws java.rmi.RemoteException {}
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
 * Insert the method's description here.
 * Creation date: (24.03.2003 12:27:59)
 * @return int
 */
public int getAccessid() {
	return accessid;
}
/**
 * Getter method for editfact
 * @return boolean
 */
public boolean getEditfact() {
	return editfact;
}
/**
 * Getter method for editplan
 * @return boolean
 */
public boolean getEditplan() {
	return editplan;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Operator getOperator() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Operator)this.getOperatorLink().value();
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OperatorKey getOperatorKey() {
	com.hps.july.persistence.OperatorKey temp = null;
	temp = new com.hps.july.persistence.OperatorKey();
	boolean operator_NULLTEST = true;
	operator_NULLTEST &= (operator_operator == null);
	temp.operator = ((operator_operator == null) ? 0 : operator_operator.intValue());
	if (operator_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOperatorLink() {
	if (operatorLink == null)
		operatorLink = new SuperRegionAccToOperatorLink(this);
	return operatorLink;
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SuperRegion getSuperregion() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.SuperRegion)this.getSuperregionLink().value();
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SuperRegionKey getSuperregionKey() {
	com.hps.july.persistence.SuperRegionKey temp = null;
	temp = new com.hps.july.persistence.SuperRegionKey();
	boolean superregion_NULLTEST = true;
	superregion_NULLTEST &= (superregion_supregid == null);
	temp.supregid = ((superregion_supregid == null) ? 0 : superregion_supregid.intValue());
	if (superregion_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getSuperregionLink() {
	if (superregionLink == null)
		superregionLink = new SuperRegionAccToSuperregionLink(this);
	return superregionLink;
}
/**
 * Getter method for viewfact
 * @return boolean
 */
public boolean getViewfact() {
	return viewfact;
}
/**
 * Getter method for viewplan
 * @return boolean
 */
public boolean getViewplan() {
	return viewplan;
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOperatorKey(com.hps.july.persistence.OperatorKey inKey) {
	boolean operator_NULLTEST = (inKey == null);
	if (operator_NULLTEST) operator_operator = null; else operator_operator = (new Integer(inKey.operator));
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetSuperregionKey(com.hps.july.persistence.SuperRegionKey inKey) {
	boolean superregion_NULLTEST = (inKey == null);
	if (superregion_NULLTEST) superregion_supregid = null; else superregion_supregid = (new Integer(inKey.supregid));
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException {
	this.getOperatorLink().secondarySet(anOperator);
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetSuperregion(com.hps.july.persistence.SuperRegion aSuperregion) throws java.rmi.RemoteException {
	this.getSuperregionLink().secondarySet(aSuperregion);
}
/**
 * Setter method for editfact
 * @param newValue boolean
 */
public void setEditfact(boolean newValue) {
	this.editfact = newValue;
}
/**
 * Setter method for editplan
 * @param newValue boolean
 */
public void setEditplan(boolean newValue) {
	this.editplan = newValue;
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
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException {
	this.getOperatorLink().set(anOperator);
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setSuperregion(com.hps.july.persistence.SuperRegion aSuperregion) throws java.rmi.RemoteException {
	this.getSuperregionLink().set(aSuperregion);
}
/**
 * Setter method for viewfact
 * @param newValue boolean
 */
public void setViewfact(boolean newValue) {
	this.viewfact = newValue;
}
/**
 * Setter method for viewplan
 * @param newValue boolean
 */
public void setViewplan(boolean newValue) {
	this.viewplan = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: viewarenda
	 */
	public java.lang.Boolean getViewarenda() {
		return viewarenda;
	}
	/**
	 * Set accessor for persistent attribute: viewarenda
	 */
	public void setViewarenda(java.lang.Boolean newViewarenda) {
		viewarenda = newViewarenda;
	}
	/**
	 * Get accessor for persistent attribute: editarenda
	 */
	public java.lang.Boolean getEditarenda() {
		return editarenda;
	}
	/**
	 * Set accessor for persistent attribute: editarenda
	 */
	public void setEditarenda(java.lang.Boolean newEditarenda) {
		editarenda = newEditarenda;
	}
}
