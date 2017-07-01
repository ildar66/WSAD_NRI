package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Позиция документа "Акт замены"
 */
public class ChangeActPositionBean implements EntityBean {
	public int code;
	private javax.ejb.EntityContext entityContext = null;
	public String newSerial;
	public String oldSerial;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer changeAct_document;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink changeActLink = null;
	public java.lang.Integer newresource_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink newresourceLink = null;
	public String manufserial;
	public Integer oldresource;
	public String oldmanufserial;
	/**
	 * Implementation field for persistent attribute: localserial
	 */
	public java.lang.String localserial;
	/**
	 * Implementation field for persistent attribute: oldlocalserial
	 */
	public java.lang.String oldlocalserial;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("changeActKey", getChangeActKey());
		h.put("oldSerial", getOldSerial());
		h.put("code", new Integer(getCode()));
		h.put("newSerial", getNewSerial());
		h.put("newresourceKey", getNewresourceKey());
		h.put("manufserial", getManufserial());
		h.put("localserial", getLocalserial());
		h.put("oldresource", getOldresource());
		h.put("oldmanufserial", getOldmanufserial());
		h.put("oldlocalserial", getOldlocalserial());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localOldSerial = (java.lang.String) h.get("oldSerial");
		Integer localCode = (Integer) h.get("code");
		java.lang.String localNewSerial = (java.lang.String) h.get("newSerial");
		java.lang.String localManufserial =
			(java.lang.String) h.get("manufserial");
		java.lang.String localLocalserial =
			(java.lang.String) h.get("localserial");
		java.lang.Integer localOldresource =
			(java.lang.Integer) h.get("oldresource");
		java.lang.String localOldmanufserial =
			(java.lang.String) h.get("oldmanufserial");
		java.lang.String localOldlocalserial =
			(java.lang.String) h.get("oldlocalserial");

		if (h.containsKey("oldSerial"))
			setOldSerial((localOldSerial));
		if (h.containsKey("code"))
			setCode((localCode).intValue());
		if (h.containsKey("newSerial"))
			setNewSerial((localNewSerial));
		if (h.containsKey("manufserial"))
			setManufserial((localManufserial));
		if (h.containsKey("localserial"))
			setLocalserial((localLocalserial));
		if (h.containsKey("oldresource"))
			setOldresource((localOldresource));
		if (h.containsKey("oldmanufserial"))
			setOldmanufserial((localOldmanufserial));
		if (h.containsKey("oldlocalserial"))
			setOldlocalserial((localOldlocalserial));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getChangeActLink());
	links.addElement(getNewresourceLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	changeActLink = null;
	newresourceLink = null;
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
 * @param argCode int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argCode) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	code = argCode;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argCode int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argCode, String argOldSerial, String argNewSerial, Integer argChangeAct ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	code = argCode;
	oldSerial = argOldSerial;
	newSerial = argNewSerial;
	changeAct_document = argChangeAct;
	newresource_resource = null;
	manufserial = null;
	oldresource = null;
	oldmanufserial = null;
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
 * @param argCode int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argCode) throws java.rmi.RemoteException {}
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
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ChangeAct getChangeAct() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.ChangeAct)this.getChangeActLink().value();
}
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getChangeActKey() {
	com.hps.july.persistence.DocumentKey temp = null;
	temp = new com.hps.july.persistence.DocumentKey();
	boolean changeAct_NULLTEST = true;
	changeAct_NULLTEST &= (changeAct_document == null);
	temp.document = ((changeAct_document == null) ? 0 : changeAct_document.intValue());
	if (changeAct_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getChangeActLink() {
	if (changeActLink == null)
		changeActLink = new ChangeActPositionToChangeActLink(this);
	return changeActLink;
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2002 14:49:17)
 * @return int
 */
public int getCode() {
	return code;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for manufserial
 */
public java.lang.String getManufserial() {
	return manufserial;
}
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getNewresource() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Resource)this.getNewresourceLink().value();
}
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getNewresourceKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean newresource_NULLTEST = true;
	newresource_NULLTEST &= (newresource_resource == null);
	temp.resource = ((newresource_resource == null) ? 0 : newresource_resource.intValue());
	if (newresource_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getNewresourceLink() {
	if (newresourceLink == null)
		newresourceLink = new ChangeActPositionToNewresourceLink(this);
	return newresourceLink;
}
/**
 * Getter method for newSerial
 * @return java.lang.String
 */
public java.lang.String getNewSerial() {
	return newSerial;
}
/**
 * Getter method for oldmanufserial
 */
public java.lang.String getOldmanufserial() {
	return oldmanufserial;
}
/**
 * Getter method for oldresource
 */
public java.lang.Integer getOldresource() {
	return oldresource;
}
/**
 * Getter method for oldSerial
 * @return java.lang.String
 */
public java.lang.String getOldSerial() {
	return oldSerial;
}
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetChangeActKey(com.hps.july.persistence.DocumentKey inKey) {
	boolean changeAct_NULLTEST = (inKey == null);
	if (changeAct_NULLTEST) changeAct_document = null; else changeAct_document = (new Integer(inKey.document));
}
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetNewresourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean newresource_NULLTEST = (inKey == null);
	if (newresource_NULLTEST) newresource_resource = null; else newresource_resource = (new Integer(inKey.resource));
}
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetChangeAct(com.hps.july.persistence.ChangeAct aChangeAct) throws java.rmi.RemoteException {
	this.getChangeActLink().secondarySet(aChangeAct);
}
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetNewresource(com.hps.july.persistence.Resource aNewresource) throws java.rmi.RemoteException {
	this.getNewresourceLink().secondarySet(aNewresource);
}
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setChangeAct(com.hps.july.persistence.ChangeAct aChangeAct) throws java.rmi.RemoteException {
	this.getChangeActLink().set(aChangeAct);
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2002 14:49:17)
 * @param newCode int
 */
public void setCode(int newCode) {
	code = newCode;
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
 * Setter method for manufserial
 */
public void setManufserial(java.lang.String newValue) {
	this.manufserial = newValue;
}
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setNewresource(com.hps.july.persistence.Resource aNewresource) throws java.rmi.RemoteException {
	this.getNewresourceLink().set(aNewresource);
}
/**
 * Setter method for newSerial
 * @param newValue java.lang.String
 */
public void setNewSerial(java.lang.String newValue) {
	this.newSerial = newValue;
}
/**
 * Setter method for oldmanufserial
 */
public void setOldmanufserial(java.lang.String newValue) {
	this.oldmanufserial = newValue;
}
/**
 * Setter method for oldresource
 */
public void setOldresource(java.lang.Integer newValue) {
	this.oldresource = newValue;
}
/**
 * Setter method for oldSerial
 * @param newValue java.lang.String
 */
public void setOldSerial(java.lang.String newValue) {
	this.oldSerial = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: localserial
	 */
	public java.lang.String getLocalserial() {
		return localserial;
	}
	/**
	 * Set accessor for persistent attribute: localserial
	 */
	public void setLocalserial(java.lang.String newLocalserial) {
		localserial = newLocalserial;
	}
	/**
	 * Get accessor for persistent attribute: oldlocalserial
	 */
	public java.lang.String getOldlocalserial() {
		return oldlocalserial;
	}
	/**
	 * Set accessor for persistent attribute: oldlocalserial
	 */
	public void setOldlocalserial(java.lang.String newOldlocalserial) {
		oldlocalserial = newOldlocalserial;
	}
}
