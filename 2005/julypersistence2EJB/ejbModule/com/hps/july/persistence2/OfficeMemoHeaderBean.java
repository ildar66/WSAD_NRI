package com.hps.july.persistence2;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * Заголовки служебных записок
 * This is an Entity Bean class with CMP fields
 */
public class OfficeMemoHeaderBean implements EntityBean {
	public int abonentContract;
	public Integer arendaContract;
	public java.sql.Date date;
	private javax.ejb.EntityContext entityContext = null;
	public String filename;
	public String from;
	public int idheader;
	public Integer leasebill;
	public int man;
	public String number;
	private final static long serialVersionUID = 3206093459760846163L;
	public String state;
	public int target;
	public String to;
	public String type;
	public String usetype;

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
 * @param argIdheader int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argIdheader, int argAbonentContract, String argNumber, java.sql.Date argDate,
		int argMan, String argType, int argTarget) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	idheader = argIdheader;
	abonentContract = argAbonentContract;
	number = argNumber;
	date = argDate;
	man = argMan;
	type = argType;
	target = argTarget;
	usetype = null;
	from = null;
	to = null;
	leasebill = null;
	filename = null;
	state = null;
	arendaContract = null;
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
 * @param argIdheader int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argIdheader) throws java.rmi.RemoteException {}
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
 * Getter method for abonentContract
 * @return int
 */
public int getAbonentContract() {
	return abonentContract;
}
/**
 * Getter method for arendaContract
 * @return java.lang.Integer
 */
public java.lang.Integer getArendaContract() {
	return arendaContract;
}
/**
 * Getter method for date
 * @return java.sql.Date
 */
public java.sql.Date getDate() {
	return date;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for filename
 * @return java.lang.String
 */
public java.lang.String getFilename() {
	return filename;
}
/**
 * Getter method for from
 * @return java.lang.String
 */
public java.lang.String getFrom() {
	return from;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2004 15:52:44)
 * @return int
 */
public int getIdheader() {
	return idheader;
}
/**
 * Getter method for leasebill
 * @return java.lang.Integer
 */
public java.lang.Integer getLeasebill() {
	return leasebill;
}
/**
 * Getter method for man
 * @return int
 */
public int getMan() {
	return man;
}
/**
 * Getter method for number
 * @return java.lang.String
 */
public java.lang.String getNumber() {
	return number;
}
/**
 * Getter method for state
 * @return java.lang.String
 */
public java.lang.String getState() {
	return state;
}
/**
 * Getter method for target
 * @return int
 */
public int getTarget() {
	return target;
}
/**
 * Getter method for to
 * @return java.lang.String
 */
public java.lang.String getTo() {
	return to;
}
/**
 * Getter method for type
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Getter method for usetype
 * @return java.lang.String
 */
public java.lang.String getUsetype() {
	return usetype;
}
/**
 * Setter method for abonentContract
 * @param newValue int
 */
public void setAbonentContract(int newValue) {
	this.abonentContract = newValue;
}
/**
 * Setter method for arendaContract
 * @param newValue java.lang.Integer
 */
public void setArendaContract(java.lang.Integer newValue) {
	this.arendaContract = newValue;
}
/**
 * Setter method for date
 * @param newValue java.sql.Date
 */
public void setDate(java.sql.Date newValue) {
	this.date = newValue;
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
 * Setter method for filename
 * @param newValue java.lang.String
 */
public void setFilename(java.lang.String newValue) {
	this.filename = newValue;
}
/**
 * Setter method for from
 * @param newValue java.lang.String
 */
public void setFrom(java.lang.String newValue) {
	this.from = newValue;
}
/**
 * Setter method for leasebill
 * @param newValue java.lang.Integer
 */
public void setLeasebill(java.lang.Integer newValue) {
	this.leasebill = newValue;
}
/**
 * Setter method for man
 * @param newValue int
 */
public void setMan(int newValue) {
	this.man = newValue;
}
/**
 * Setter method for number
 * @param newValue java.lang.String
 */
public void setNumber(java.lang.String newValue) {
	this.number = newValue;
}
/**
 * Setter method for state
 * @param newValue java.lang.String
 */
public void setState(java.lang.String newValue) {
	this.state = newValue;
}
/**
 * Setter method for target
 * @param newValue int
 */
public void setTarget(int newValue) {
	this.target = newValue;
}
/**
 * Setter method for to
 * @param newValue java.lang.String
 */
public void setTo(java.lang.String newValue) {
	this.to = newValue;
}
/**
 * Setter method for type
 * @param newValue java.lang.String
 */
public void setType(java.lang.String newValue) {
	this.type = newValue;
}
/**
 * Setter method for usetype
 * @param newValue java.lang.String
 */
public void setUsetype(java.lang.String newValue) {
	this.usetype = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("filename", getFilename());
		h.put("state", getState());
		h.put("man", new Integer(getMan()));
		h.put("date", getDate());
		h.put("number", getNumber());
		h.put("usetype", getUsetype());
		h.put("target", new Integer(getTarget()));
		h.put("abonentContract", new Integer(getAbonentContract()));
		h.put("leasebill", getLeasebill());
		h.put("type", getType());
		h.put("idheader", new Integer(getIdheader()));
		h.put("arendaContract", getArendaContract());
		h.put("to", getTo());
		h.put("from", getFrom());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localFilename = (java.lang.String) h.get("filename");
		java.lang.String localState = (java.lang.String) h.get("state");
		Integer localMan = (Integer) h.get("man");
		java.sql.Date localDate = (java.sql.Date) h.get("date");
		java.lang.String localNumber = (java.lang.String) h.get("number");
		java.lang.String localUsetype = (java.lang.String) h.get("usetype");
		Integer localTarget = (Integer) h.get("target");
		Integer localAbonentContract = (Integer) h.get("abonentContract");
		java.lang.Integer localLeasebill =
			(java.lang.Integer) h.get("leasebill");
		java.lang.String localType = (java.lang.String) h.get("type");
		java.lang.Integer localArendaContract =
			(java.lang.Integer) h.get("arendaContract");
		java.lang.String localTo = (java.lang.String) h.get("to");
		java.lang.String localFrom = (java.lang.String) h.get("from");

		if (h.containsKey("filename"))
			setFilename((localFilename));
		if (h.containsKey("state"))
			setState((localState));
		if (h.containsKey("man"))
			setMan((localMan).intValue());
		if (h.containsKey("date"))
			setDate((localDate));
		if (h.containsKey("number"))
			setNumber((localNumber));
		if (h.containsKey("usetype"))
			setUsetype((localUsetype));
		if (h.containsKey("target"))
			setTarget((localTarget).intValue());
		if (h.containsKey("abonentContract"))
			setAbonentContract((localAbonentContract).intValue());
		if (h.containsKey("leasebill"))
			setLeasebill((localLeasebill));
		if (h.containsKey("type"))
			setType((localType));
		if (h.containsKey("arendaContract"))
			setArendaContract((localArendaContract));
		if (h.containsKey("to"))
			setTo((localTo));
		if (h.containsKey("from"))
			setFrom((localFrom));
	}
}
