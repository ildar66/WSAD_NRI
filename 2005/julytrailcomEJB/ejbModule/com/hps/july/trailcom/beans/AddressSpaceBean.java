package com.hps.july.trailcom.beans;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Данные TRAILCOM - адресное пространство
 */
public class AddressSpaceBean implements EntityBean {
	public Short activestate;
	public String address;
	public java.sql.Timestamp disabletime;
	private javax.ejb.EntityContext entityContext = null;
	public Short existstate;
	public Short insegment;
	public int portid;
	public Integer realconnect;
	private final static long serialVersionUID = 3206093459760846163L;
	public Integer storagecard;
	public java.lang.Integer addressinfo_resource;
	public java.lang.Short addressinfo_typeport;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink addressinfoLink = null;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("address", getAddress());
        h.put("insegment", getInsegment());
        h.put("activestate", getActivestate());
        h.put("realconnect", getRealconnect());
        h.put("existstate", getExiststate());
        h.put("disabletime", getDisabletime());
        h.put("portid", new Integer(getPortid()));
        h.put("storagecard", getStoragecard());
        h.put("addressinfoKey", getAddressinfoKey());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.String localAddress = (java.lang.String) h.get("address");
        java.lang.Short localInsegment = (java.lang.Short) h.get("insegment");
        java.lang.Short localActivestate = (java.lang.Short) h.get("activestate");
        java.lang.Integer localRealconnect = (java.lang.Integer) h.get("realconnect");
        java.lang.Short localExiststate = (java.lang.Short) h.get("existstate");
        java.sql.Timestamp localDisabletime = (java.sql.Timestamp) h.get("disabletime");
        java.lang.Integer localStoragecard = (java.lang.Integer) h.get("storagecard");

        if ( h.containsKey("address") )
            setAddress((localAddress));
        if ( h.containsKey("insegment") )
            setInsegment((localInsegment));
        if ( h.containsKey("activestate") )
            setActivestate((localActivestate));
        if ( h.containsKey("realconnect") )
            setRealconnect((localRealconnect));
        if ( h.containsKey("existstate") )
            setExiststate((localExiststate));
        if ( h.containsKey("disabletime") )
            setDisabletime((localDisabletime));
        if ( h.containsKey("storagecard") )
            setStoragecard((localStoragecard));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getAddressinfoLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	addressinfoLink = null;
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
 * @param argPortid int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argPortid) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	portid = argPortid;
	storagecard = null;
	addressinfo_resource = null;
	addressinfo_typeport = null;
	address = null;
	existstate = null;
	disabletime = null;
	activestate = null;
	insegment = null;
	realconnect = null;
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
 * @param argPortid int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argPortid) throws java.rmi.RemoteException {}
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
 * Getter method for activestate
 * @return java.lang.Short
 */
public java.lang.Short getActivestate() {
	return activestate;
}
/**
 * Getter method for address
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.trailcom.beans.AddressInfo getAddressinfo() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.trailcom.beans.AddressInfo)this.getAddressinfoLink().value();
}
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.trailcom.beans.AddressInfoKey getAddressinfoKey() {
	com.hps.july.trailcom.beans.AddressInfoKey temp = null;
	temp = new com.hps.july.trailcom.beans.AddressInfoKey();
	boolean addressinfo_NULLTEST = true;
	addressinfo_NULLTEST &= (addressinfo_resource == null);
	temp.resource = ((addressinfo_resource == null) ? 0 : addressinfo_resource.intValue());
	addressinfo_NULLTEST &= (addressinfo_typeport == null);
	temp.typeport = ((addressinfo_typeport == null) ? 0 : addressinfo_typeport.shortValue());
	if (addressinfo_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getAddressinfoLink() {
	if (addressinfoLink == null)
		addressinfoLink = new AddressSpaceToAddressinfoLink(this);
	return addressinfoLink;
}
/**
 * Getter method for disabletime
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getDisabletime() {
	return disabletime;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for existstate
 * @return java.lang.Short
 */
public java.lang.Short getExiststate() {
	return existstate;
}
/**
 * Getter method for insegment
 * @return java.lang.Short
 */
public java.lang.Short getInsegment() {
	return insegment;
}
/**
 * Insert the method's description here.
 * Creation date: (10.02.2003 16:53:09)
 * @return int
 */
public int getPortid() {
	return portid;
}
/**
 * Getter method for realconnect
 * @return java.lang.Integer
 */
public java.lang.Integer getRealconnect() {
	return realconnect;
}
/**
 * Getter method for storagecard
 * @return java.lang.Integer
 */
public java.lang.Integer getStoragecard() {
	return storagecard;
}
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetAddressinfoKey(com.hps.july.trailcom.beans.AddressInfoKey inKey) {
	boolean addressinfo_NULLTEST = (inKey == null);
	if (addressinfo_NULLTEST) addressinfo_resource = null; else addressinfo_resource = (new Integer(inKey.resource));
	if (addressinfo_NULLTEST) addressinfo_typeport = null; else addressinfo_typeport = (new Short(inKey.typeport));
}
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetAddressinfo(com.hps.july.trailcom.beans.AddressInfo anAddressinfo) throws java.rmi.RemoteException {
	this.getAddressinfoLink().secondarySet(anAddressinfo);
}
/**
 * Setter method for activestate
 * @param newValue java.lang.Short
 */
public void setActivestate(java.lang.Short newValue) {
	this.activestate = newValue;
}
/**
 * Setter method for address
 * @param newValue java.lang.String
 */
public void setAddress(java.lang.String newValue) {
	this.address = newValue;
}
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setAddressinfo(com.hps.july.trailcom.beans.AddressInfo anAddressinfo) throws java.rmi.RemoteException {
	this.getAddressinfoLink().set(anAddressinfo);
}
/**
 * Setter method for disabletime
 * @param newValue java.sql.Timestamp
 */
public void setDisabletime(java.sql.Timestamp newValue) {
	this.disabletime = newValue;
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
 * Setter method for existstate
 * @param newValue java.lang.Short
 */
public void setExiststate(java.lang.Short newValue) {
	this.existstate = newValue;
}
/**
 * Setter method for insegment
 * @param newValue java.lang.Short
 */
public void setInsegment(java.lang.Short newValue) {
	this.insegment = newValue;
}
/**
 * Setter method for realconnect
 * @param newValue java.lang.Integer
 */
public void setRealconnect(java.lang.Integer newValue) {
	this.realconnect = newValue;
}
/**
 * Setter method for storagecard
 * @param newValue java.lang.Integer
 */
public void setStoragecard(java.lang.Integer newValue) {
	this.storagecard = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
