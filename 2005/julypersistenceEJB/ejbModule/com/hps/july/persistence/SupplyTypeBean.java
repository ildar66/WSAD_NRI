package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Тип поставки оборудования (по контракту на поставку)
 */
public class SupplyTypeBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public String name;
	private final static long serialVersionUID = 3206093459760846163L;
	public int supplyType;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink contractLink = null;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("supplyType", new Integer(getSupplyType()));
		h.put("name", getName());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		Integer localSupplyType = (Integer) h.get("supplyType");
		java.lang.String localName = (java.lang.String) h.get("name");

		if (h.containsKey("supplyType"))
			setSupplyType((localSupplyType).intValue());
		if (h.containsKey("name"))
			setName((localName));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getContractLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	contractLink = null;
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
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException {
	this.getContractLink().addElement(aContract);
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
 * @param argSupplyType int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argSupplyType) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	supplyType = argSupplyType;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argSupplyType int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argSupplyType, String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	supplyType = argSupplyType;
	name = argName;
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
 * @param argSupplyType int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argSupplyType) throws java.rmi.RemoteException {}
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
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getContract() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getContractLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getContractLink() {
	if (contractLink == null)
		contractLink = new SupplyTypeToContractLink(this);
	return contractLink;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for name
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2002 19:57:34)
 * @return int
 */
public int getSupplyType() {
	return supplyType;
}
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddContract(com.hps.july.persistence.Contract aContract) {
	this.getContractLink().secondaryAddElement(aContract);
}
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveContract(com.hps.july.persistence.Contract aContract) {
	this.getContractLink().secondaryRemoveElement(aContract);
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
 * Setter method for name
 * @param newValue java.lang.String
 */
public void setName(java.lang.String newValue) {
	this.name = newValue;
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2002 19:57:34)
 * @param newSupplyType int
 */
public void setSupplyType(int newSupplyType) {
	supplyType = newSupplyType;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
