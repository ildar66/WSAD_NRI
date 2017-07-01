package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ����� (����� �������� ������������)
 */
public class StorageBean extends StoragePlaceBean {
	public String internalphone;
	public String pstnphone;
	private final static long serialVersionUID = 3206093459760846163L;
	public int regionid;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("createdby", getCreatedby());
        h.put("storageplace", new Integer(getStorageplace()));
        h.put("address", getAddress());
        h.put("closedate", getClosedate());
        h.put("created", getCreated());
        h.put("internalphone", getInternalphone());
        h.put("modifiedby", getModifiedby());
        h.put("operator", getOperator());
        h.put("divisionKey", getDivisionKey());
        h.put("regionid", new Integer(getRegionid()));
        h.put("modified", getModified());
        h.put("name", getName());
        h.put("pstnphone", getPstnphone());
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
        java.lang.String localInternalphone = (java.lang.String) h.get("internalphone");
        java.lang.Integer localModifiedby = (java.lang.Integer) h.get("modifiedby");
        java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
        Integer localRegionid = (Integer) h.get("regionid");
        java.sql.Timestamp localModified = (java.sql.Timestamp) h.get("modified");
        java.lang.String localName = (java.lang.String) h.get("name");
        java.lang.String localPstnphone = (java.lang.String) h.get("pstnphone");

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
        if ( h.containsKey("internalphone") )
            setInternalphone((localInternalphone));
        if ( h.containsKey("modifiedby") )
            setModifiedby((localModifiedby));
        if ( h.containsKey("operator") )
            setOperator((localOperator));
        if ( h.containsKey("regionid") )
            setRegionid((localRegionid).intValue());
        if ( h.containsKey("modified") )
            setModified((localModified));
        if ( h.containsKey("name") )
            setName((localName));
        if ( h.containsKey("pstnphone") )
            setPstnphone((localPstnphone));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argStorageplace, Integer argDivision, String argName, String argAddress ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	address = null; 
	closedate = null;
	name = null;
	division_division = null;

	storageplace = argStorageplace;
	division_division = argDivision;
	name = argName;
	address = argAddress;
	internalphone = null;
	pstnphone = null;
	regionid = 1;
	
	operator = null;
	setOperator();
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argStorageplace, Integer argDivision, String argName, String argAddress, int argRegionId ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	address = null; 
	closedate = null;
	name = null;
	division_division = null;

	storageplace = argStorageplace;
	division_division = argDivision;
	name = argName;
	address = argAddress;
	internalphone = null;
	pstnphone = null;
	regionid = argRegionId;
	
	operator = null;
	setOperator();
}
/**
 * Getter method for internalphone
 * @return java.lang.String
 */
public java.lang.String getInternalphone() {
	return internalphone;
}
/**
 * Getter method for pstnphone
 * @return java.lang.String
 */
public java.lang.String getPstnphone() {
	return pstnphone;
}
/**
 * Getter method for regionid
 */
public int getRegionid() {
	return regionid;
}
/**
 * Setter method for internalphone
 * @param newValue java.lang.String
 */
public void setInternalphone(java.lang.String newValue) {
	this.internalphone = newValue;
}
/**
 * Setter method for pstnphone
 * @param newValue java.lang.String
 */
public void setPstnphone(java.lang.String newValue) {
	this.pstnphone = newValue;
}
/**
 * Setter method for regionid
 */
public void setRegionid(int newValue) {
	this.regionid = newValue;
}
}
