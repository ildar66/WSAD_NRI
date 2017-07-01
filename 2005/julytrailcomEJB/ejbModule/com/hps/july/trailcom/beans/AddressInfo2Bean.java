package com.hps.july.trailcom.beans;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������ TRAILCOM - ���������� ����������
 */
public class AddressInfo2Bean implements EntityBean {
	public String addressname;
	public int addressportid;
	private javax.ejb.EntityContext entityContext = null;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer addressinfo_resource;
	public java.lang.Short addressinfo_typeport;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink addressinfoLink = null;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("addressname", getAddressname());
        h.put("addressportid", new Integer(getAddressportid()));
        h.put("addressinfoKey", getAddressinfoKey());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.String localAddressname = (java.lang.String) h.get("addressname");

        if ( h.containsKey("addressname") )
            setAddressname((localAddressname));

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
 * @param argAddressportid int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argAddressportid, int argResource, short argTypeport) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	addressportid = argAddressportid;
	addressinfo_resource = new Integer(argResource);
	addressinfo_typeport = new Short(argTypeport);
	addressname = null;
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
 * @param argAddressportid int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argAddressportid) throws java.rmi.RemoteException {}
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
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.trailcom.beans.AddressInfo getAddressinfo() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.trailcom.beans.AddressInfo)this.getAddressinfoLink().value();
}
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
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
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getAddressinfoLink() {
	if (addressinfoLink == null)
		addressinfoLink = new AddressInfo2ToAddressinfoLink(this);
	return addressinfoLink;
}
/**
 * Getter method for addressname
 * @return java.lang.String
 */
public java.lang.String getAddressname() {
	return addressname;
}
/**
 * Insert the method's description here.
 * Creation date: (10.02.2003 16:41:28)
 * @return int
 */
public int getAddressportid() {
	return addressportid;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetAddressinfoKey(com.hps.july.trailcom.beans.AddressInfoKey inKey) {
	boolean addressinfo_NULLTEST = (inKey == null);
	if (addressinfo_NULLTEST) addressinfo_resource = null; else addressinfo_resource = (new Integer(inKey.resource));
	if (addressinfo_NULLTEST) addressinfo_typeport = null; else addressinfo_typeport = (new Short(inKey.typeport));
}
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetAddressinfo(com.hps.july.trailcom.beans.AddressInfo anAddressinfo) throws java.rmi.RemoteException {
	this.getAddressinfoLink().secondarySet(anAddressinfo);
}
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setAddressinfo(com.hps.july.trailcom.beans.AddressInfo anAddressinfo) throws java.rmi.RemoteException {
	this.getAddressinfoLink().set(anAddressinfo);
}
/**
 * Setter method for addressname
 * @param newValue java.lang.String
 */
public void setAddressname(java.lang.String newValue) {
	this.addressname = newValue;
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
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}