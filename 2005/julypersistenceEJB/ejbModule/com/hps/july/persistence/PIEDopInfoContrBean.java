package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������ PIE - ������� ���������� � Platinum
 */
public class PIEDopInfoContrBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public Integer idbudjet;
	public Integer idexpense;
	public int leasedocument;
	private final static long serialVersionUID = 3206093459760846163L;
	public String vendor;
	public java.sql.Timestamp datenritoplatinum;
	public java.sql.Timestamp dateplatinum;
	public String flagsync;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("vendor", getVendor());
        h.put("idbudjet", getIdbudjet());
        h.put("leasedocument", new Integer(getLeasedocument()));
        h.put("idexpense", getIdexpense());
        h.put("flagsync", getFlagsync());
        h.put("dateplatinum", getDateplatinum());
        h.put("datenritoplatinum", getDatenritoplatinum());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.String localVendor = (java.lang.String) h.get("vendor");
        java.lang.Integer localIdbudjet = (java.lang.Integer) h.get("idbudjet");
        java.lang.Integer localIdexpense = (java.lang.Integer) h.get("idexpense");
        java.lang.String localFlagsync = (java.lang.String) h.get("flagsync");
        java.sql.Timestamp localDateplatinum = (java.sql.Timestamp) h.get("dateplatinum");
        java.sql.Timestamp localDatenritoplatinum = (java.sql.Timestamp) h.get("datenritoplatinum");

        if ( h.containsKey("vendor") )
            setVendor((localVendor));
        if ( h.containsKey("idbudjet") )
            setIdbudjet((localIdbudjet));
        if ( h.containsKey("idexpense") )
            setIdexpense((localIdexpense));
        if ( h.containsKey("flagsync") )
            setFlagsync((localFlagsync));
        if ( h.containsKey("dateplatinum") )
            setDateplatinum((localDateplatinum));
        if ( h.containsKey("datenritoplatinum") )
            setDatenritoplatinum((localDatenritoplatinum));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {}
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
 * @param argLeasedocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argLeasedocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	leasedocument = argLeasedocument;
	vendor = null;
	idbudjet = null;
	idexpense = null;
	datenritoplatinum = null;
	dateplatinum = null;
	flagsync = "0";
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
 * @param argLeasedocument int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argLeasedocument) throws java.rmi.RemoteException {}
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
 * Getter method for datenritoplatinum
 */
public java.sql.Timestamp getDatenritoplatinum() {
	return datenritoplatinum;
}
/**
 * Getter method for dateplatinum
 */
public java.sql.Timestamp getDateplatinum() {
	return dateplatinum;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for flagsync
 */
public java.lang.String getFlagsync() {
	return flagsync;
}
/**
 * Getter method for idbudjet
 * @return java.lang.Integer
 */
public java.lang.Integer getIdbudjet() {
	return idbudjet;
}
/**
 * Getter method for idexpense
 * @return java.lang.Integer
 */
public java.lang.Integer getIdexpense() {
	return idexpense;
}
/**
 * Insert the method's description here.
 * Creation date: (15.01.2003 18:47:08)
 * @return int
 */
public int getLeasedocument() {
	return leasedocument;
}
/**
 * Getter method for vendor
 * @return java.lang.String
 */
public java.lang.String getVendor() {
	return vendor;
}
/**
 * Setter method for datenritoplatinum
 */
public void setDatenritoplatinum(java.sql.Timestamp newValue) {
	this.datenritoplatinum = newValue;
}
/**
 * Setter method for dateplatinum
 */
public void setDateplatinum(java.sql.Timestamp newValue) {
	this.dateplatinum = newValue;
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
 * Setter method for flagsync
 */
public void setFlagsync(java.lang.String newValue) {
	this.flagsync = newValue;
}
/**
 * Setter method for idbudjet
 * @param newValue java.lang.Integer
 */
public void setIdbudjet(java.lang.Integer newValue) {
	this.idbudjet = newValue;
}
/**
 * Setter method for idexpense
 * @param newValue java.lang.Integer
 */
public void setIdexpense(java.lang.Integer newValue) {
	this.idexpense = newValue;
}
/**
 * Setter method for vendor
 * @param newValue java.lang.String
 */
public void setVendor(java.lang.String newValue) {
	this.vendor = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
