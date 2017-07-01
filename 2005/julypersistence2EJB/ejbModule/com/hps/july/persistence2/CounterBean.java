package com.hps.july.persistence2;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
import com.hps.july.persistence.*;

/**
 * Показания электросчетчиков
 * This is an Entity Bean class with CMP fields
 */
public class CounterBean implements EntityBean {
	public int counterid;
	public int counterinfo_id;
	public Integer cstate;
	private javax.ejb.EntityContext entityContext = null;
	public Integer initial_settings;
	public java.sql.Date installation_date;
	public java.sql.Date last_verification;
	public java.sql.Timestamp modified_date;
	public int modifiedby;
	public java.sql.Date next_verification;
	public Integer nextid;
	public String place_info;
	public int positionid;
	public String production_year;
	public java.sql.Date replace_date;
	public String replace_reason;
	public Integer replace_settings;
	private final static long serialVersionUID = 3206093459760846163L;
	public String vendor_number;
	private Integer tempOperator;
	public java.sql.Date dismantling_date;
	public String dismantling_reason;
	public Integer dismantling_set;
	/**
	 * Implementation field for persistent attribute: isVendorPowerSupply
	 */
	public java.lang.Boolean isVendorPowerSupply;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("next_verification", getNext_verification());
		h.put("installation_date", getInstallation_date());
		h.put("vendor_number", getVendor_number());
		h.put("place_info", getPlace_info());
		h.put("production_year", getProduction_year());
		h.put("cstate", getCstate());
		h.put("counterinfo_id", new Integer(getCounterinfo_id()));
		h.put("positionid", new Integer(getPositionid()));
		h.put("nextid", getNextid());
		h.put("replace_reason", getReplace_reason());
		h.put("dismantling_set", getDismantling_set());
		h.put("modifiedby", new Integer(getModifiedby()));
		h.put("replace_date", getReplace_date());
		h.put("last_verification", getLast_verification());
		h.put("counterid", new Integer(getCounterid()));
		h.put("replace_settings", getReplace_settings());
		h.put("initial_settings", getInitial_settings());
		h.put("modified_date", getModified_date());
		h.put("isVendorPowerSupply", getIsVendorPowerSupply());
		h.put("dismantling_date", getDismantling_date());
		h.put("dismantling_reason", getDismantling_reason());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.sql.Date localNext_verification = (java.sql.Date) h.get("next_verification");
		java.sql.Date localInstallation_date = (java.sql.Date) h.get("installation_date");
		java.lang.String localVendor_number = (java.lang.String) h.get("vendor_number");
		java.lang.String localPlace_info = (java.lang.String) h.get("place_info");
		java.lang.String localProduction_year = (java.lang.String) h.get("production_year");
		java.lang.Integer localCstate = (java.lang.Integer) h.get("cstate");
		Integer localCounterinfo_id = (Integer) h.get("counterinfo_id");
		Integer localPositionid = (Integer) h.get("positionid");
		java.lang.Integer localNextid = (java.lang.Integer) h.get("nextid");
		java.lang.String localReplace_reason = (java.lang.String) h.get("replace_reason");
		java.lang.Integer localDismantling_set = (java.lang.Integer) h.get("dismantling_set");
		Integer localModifiedby = (Integer) h.get("modifiedby");
		java.sql.Date localReplace_date = (java.sql.Date) h.get("replace_date");
		java.sql.Date localLast_verification = (java.sql.Date) h.get("last_verification");
		java.lang.Integer localReplace_settings = (java.lang.Integer) h.get("replace_settings");
		java.lang.Integer localInitial_settings = (java.lang.Integer) h.get("initial_settings");
		java.sql.Timestamp localModified_date = (java.sql.Timestamp) h.get("modified_date");
		java.lang.Boolean localIsVendorPowerSupply = (java.lang.Boolean) h.get("isVendorPowerSupply");
		java.sql.Date localDismantling_date = (java.sql.Date) h.get("dismantling_date");
		java.lang.String localDismantling_reason = (java.lang.String) h.get("dismantling_reason");

		if (h.containsKey("next_verification"))
			setNext_verification((localNext_verification));
		if (h.containsKey("installation_date"))
			setInstallation_date((localInstallation_date));
		if (h.containsKey("vendor_number"))
			setVendor_number((localVendor_number));
		if (h.containsKey("place_info"))
			setPlace_info((localPlace_info));
		if (h.containsKey("production_year"))
			setProduction_year((localProduction_year));
		if (h.containsKey("cstate"))
			setCstate((localCstate));
		if (h.containsKey("counterinfo_id"))
			setCounterinfo_id((localCounterinfo_id).intValue());
		if (h.containsKey("positionid"))
			setPositionid((localPositionid).intValue());
		if (h.containsKey("nextid"))
			setNextid((localNextid));
		if (h.containsKey("replace_reason"))
			setReplace_reason((localReplace_reason));
		if (h.containsKey("dismantling_set"))
			setDismantling_set((localDismantling_set));
		if (h.containsKey("modifiedby"))
			setModifiedby((localModifiedby).intValue());
		if (h.containsKey("replace_date"))
			setReplace_date((localReplace_date));
		if (h.containsKey("last_verification"))
			setLast_verification((localLast_verification));
		if (h.containsKey("replace_settings"))
			setReplace_settings((localReplace_settings));
		if (h.containsKey("initial_settings"))
			setInitial_settings((localInitial_settings));
		if (h.containsKey("modified_date"))
			setModified_date((localModified_date));
		if (h.containsKey("isVendorPowerSupply"))
			setIsVendorPowerSupply((localIsVendorPowerSupply));
		if (h.containsKey("dismantling_date"))
			setDismantling_date((localDismantling_date));
		if (h.containsKey("dismantling_reason"))
			setDismantling_reason((localDismantling_reason));
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
 * @param argCounterid int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argCounterid, int argCounterInfoId, int argPositionId) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	counterid = argCounterid;
	counterinfo_id = argCounterInfoId;
	positionid = argPositionId;
	nextid = null;
	place_info = null;
	vendor_number = null;
	production_year = null;
	installation_date = null;
	initial_settings = null;
	last_verification = null;
	next_verification = null;
	cstate = null;
	replace_date = null;
	replace_reason = null;
	replace_settings = null;
	modified_date = new java.sql.Timestamp(new java.util.Date().getTime());
	modifiedby = 0;
	String operatorName = entityContext.getCallerIdentity().getName();
	Integer oper = OperatorObject.getOperatorCode(operatorName);
	if (oper != null)
		modifiedby = oper.intValue();
	dismantling_date = null;
	dismantling_reason = null;
	dismantling_set = null;
	isVendorPowerSupply = Boolean.TRUE;
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
 * @param argCounterid int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argCounterid) throws java.rmi.RemoteException {}
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
	setModifiedby(tempOperator.intValue());
	setModified_date(new java.sql.Timestamp(new java.util.Date().getTime()));
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2004 17:25:40)
 * @return int
 */
public int getCounterid() {
	return counterid;
}
/**
 * Getter method for counterinfo_id
 * @return int
 */
public int getCounterinfo_id() {
	return counterinfo_id;
}
/**
 * Getter method for cstate
 * @return java.lang.Integer
 */
public java.lang.Integer getCstate() {
	return cstate;
}
/**
 * Getter method for dismantling_date
 */
public java.sql.Date getDismantling_date() {
	return dismantling_date;
}
/**
 * Getter method for dismantling_reason
 */
public java.lang.String getDismantling_reason() {
	return dismantling_reason;
}
/**
 * Getter method for dismantling_set
 */
public java.lang.Integer getDismantling_set() {
	return dismantling_set;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for initial_settings
 * @return java.lang.Integer
 */
public java.lang.Integer getInitial_settings() {
	return initial_settings;
}
/**
 * Getter method for installation_date
 * @return java.sql.Date
 */
public java.sql.Date getInstallation_date() {
	return installation_date;
}
/**
 * Getter method for last_verification
 * @return java.sql.Date
 */
public java.sql.Date getLast_verification() {
	return last_verification;
}
/**
 * Getter method for modified_date
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getModified_date() {
	return modified_date;
}
/**
 * Getter method for modifiedby
 * @return int
 */
public int getModifiedby() {
	return modifiedby;
}
/**
 * Getter method for next_verification
 * @return java.sql.Date
 */
public java.sql.Date getNext_verification() {
	return next_verification;
}
/**
 * Getter method for nextid
 * @return java.lang.Integer
 */
public java.lang.Integer getNextid() {
	return nextid;
}
/**
 * Getter method for place_info
 * @return java.lang.String
 */
public java.lang.String getPlace_info() {
	return place_info;
}
/**
 * Getter method for positionid
 * @return int
 */
public int getPositionid() {
	return positionid;
}
/**
 * Getter method for production_year
 * @return java.lang.String
 */
public java.lang.String getProduction_year() {
	return production_year;
}
/**
 * Getter method for replace_date
 * @return java.sql.Date
 */
public java.sql.Date getReplace_date() {
	return replace_date;
}
/**
 * Getter method for replace_reason
 * @return java.lang.String
 */
public java.lang.String getReplace_reason() {
	return replace_reason;
}
/**
 * Getter method for replace_settings
 * @return java.lang.Integer
 */
public java.lang.Integer getReplace_settings() {
	return replace_settings;
}
/**
 * Getter method for vendor_number
 * @return java.lang.String
 */
public java.lang.String getVendor_number() {
	return vendor_number;
}
/**
 * Setter method for counterinfo_id
 * @param newValue int
 */
public void setCounterinfo_id(int newValue) {
	this.counterinfo_id = newValue;
}
/**
 * Setter method for cstate
 * @param newValue java.lang.Integer
 */
public void setCstate(java.lang.Integer newValue) {
	this.cstate = newValue;
}
/**
 * Setter method for dismantling_date
 */
public void setDismantling_date(java.sql.Date newValue) {
	this.dismantling_date = newValue;
}
/**
 * Setter method for dismantling_reason
 */
public void setDismantling_reason(java.lang.String newValue) {
	this.dismantling_reason = newValue;
}
/**
 * Setter method for dismantling_set
 */
public void setDismantling_set(java.lang.Integer newValue) {
	this.dismantling_set = newValue;
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
 * Setter method for initial_settings
 * @param newValue java.lang.Integer
 */
public void setInitial_settings(java.lang.Integer newValue) {
	this.initial_settings = newValue;
}
/**
 * Setter method for installation_date
 * @param newValue java.sql.Date
 */
public void setInstallation_date(java.sql.Date newValue) {
	this.installation_date = newValue;
}
/**
 * Setter method for last_verification
 * @param newValue java.sql.Date
 */
public void setLast_verification(java.sql.Date newValue) {
	this.last_verification = newValue;
}
/**
 * Setter method for modified_date
 * @param newValue java.sql.Timestamp
 */
public void setModified_date(java.sql.Timestamp newValue) {
	this.modified_date = newValue;
}
/**
 * Setter method for modifiedby
 * @param newValue int
 */
public void setModifiedby(int newValue) {
	this.modifiedby = newValue;
}
/**
 * Setter method for next_verification
 * @param newValue java.sql.Date
 */
public void setNext_verification(java.sql.Date newValue) {
	this.next_verification = newValue;
}
/**
 * Setter method for nextid
 * @param newValue java.lang.Integer
 */
public void setNextid(java.lang.Integer newValue) {
	this.nextid = newValue;
}
	private void setOperator() throws java.rmi.RemoteException{
		String operatorName = entityContext.getCallerIdentity().getName();
		tempOperator = OperatorObject.getOperatorCode(operatorName);
		if (tempOperator == null)
			tempOperator = new Integer(0);
		setModifiedby(tempOperator.intValue());
	}
/**
 * Setter method for place_info
 * @param newValue java.lang.String
 */
public void setPlace_info(java.lang.String newValue) {
	this.place_info = newValue;
}
/**
 * Setter method for positionid
 * @param newValue int
 */
public void setPositionid(int newValue) {
	this.positionid = newValue;
}
/**
 * Setter method for production_year
 * @param newValue java.lang.String
 */
public void setProduction_year(java.lang.String newValue) {
	this.production_year = newValue;
}
/**
 * Setter method for replace_date
 * @param newValue java.sql.Date
 */
public void setReplace_date(java.sql.Date newValue) {
	this.replace_date = newValue;
}
/**
 * Setter method for replace_reason
 * @param newValue java.lang.String
 */
public void setReplace_reason(java.lang.String newValue) {
	this.replace_reason = newValue;
}
/**
 * Setter method for replace_settings
 * @param newValue java.lang.Integer
 */
public void setReplace_settings(java.lang.Integer newValue) {
	this.replace_settings = newValue;
}
/**
 * Setter method for vendor_number
 * @param newValue java.lang.String
 */
public void setVendor_number(java.lang.String newValue) {
	this.vendor_number = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: isVendorPowerSupply
	 */
	public java.lang.Boolean getIsVendorPowerSupply() {
		return isVendorPowerSupply;
	}
	/**
	 * Set accessor for persistent attribute: isVendorPowerSupply
	 */
	public void setIsVendorPowerSupply(java.lang.Boolean newIsVendorPowerSupply) {
		isVendorPowerSupply = newIsVendorPowerSupply;
	}
}
