package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������ PIE - ������ �������� � Platinum
 */
public class PIEQueryLogBean implements EntityBean {
	public java.sql.Date date1;
	public java.sql.Date date2;
	public java.sql.Date date3;
	public java.math.BigDecimal dec1;
	public java.math.BigDecimal dec2;
	public java.math.BigDecimal dec3;
	private javax.ejb.EntityContext entityContext = null;
	public int errorcode;
	public int idnriquerylog;
	public Integer int1;
	public Integer int2;
	public Integer int3;
	private final static long serialVersionUID = 3206093459760846163L;
	public String textmsg;
	public String typemsg;
	public String typesystem;
	public java.sql.Timestamp vdat;
	public java.lang.Integer query_idquery;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink queryLink = null;
	public String string1;
	public String string2;
	public String string3;
	public String string4;
	public String string5;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("dec3", getDec3());
        h.put("dec2", getDec2());
        h.put("dec1", getDec1());
        h.put("errorcode", new Integer(getErrorcode()));
        h.put("vdat", getVdat());
        h.put("idnriquerylog", new Integer(getIdnriquerylog()));
        h.put("typemsg", getTypemsg());
        h.put("date3", getDate3());
        h.put("date2", getDate2());
        h.put("date1", getDate1());
        h.put("queryKey", getQueryKey());
        h.put("int3", getInt3());
        h.put("int2", getInt2());
        h.put("int1", getInt1());
        h.put("typesystem", getTypesystem());
        h.put("string5", getString5());
        h.put("string4", getString4());
        h.put("string3", getString3());
        h.put("string2", getString2());
        h.put("string1", getString1());
        h.put("textmsg", getTextmsg());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.math.BigDecimal localDec3 = (java.math.BigDecimal) h.get("dec3");
        java.math.BigDecimal localDec2 = (java.math.BigDecimal) h.get("dec2");
        java.math.BigDecimal localDec1 = (java.math.BigDecimal) h.get("dec1");
        Integer localErrorcode = (Integer) h.get("errorcode");
        java.sql.Timestamp localVdat = (java.sql.Timestamp) h.get("vdat");
        java.lang.String localTypemsg = (java.lang.String) h.get("typemsg");
        java.sql.Date localDate3 = (java.sql.Date) h.get("date3");
        java.sql.Date localDate2 = (java.sql.Date) h.get("date2");
        java.sql.Date localDate1 = (java.sql.Date) h.get("date1");
        java.lang.Integer localInt3 = (java.lang.Integer) h.get("int3");
        java.lang.Integer localInt2 = (java.lang.Integer) h.get("int2");
        java.lang.Integer localInt1 = (java.lang.Integer) h.get("int1");
        java.lang.String localTypesystem = (java.lang.String) h.get("typesystem");
        java.lang.String localString5 = (java.lang.String) h.get("string5");
        java.lang.String localString4 = (java.lang.String) h.get("string4");
        java.lang.String localString3 = (java.lang.String) h.get("string3");
        java.lang.String localString2 = (java.lang.String) h.get("string2");
        java.lang.String localString1 = (java.lang.String) h.get("string1");
        java.lang.String localTextmsg = (java.lang.String) h.get("textmsg");

        if ( h.containsKey("dec3") )
            setDec3((localDec3));
        if ( h.containsKey("dec2") )
            setDec2((localDec2));
        if ( h.containsKey("dec1") )
            setDec1((localDec1));
        if ( h.containsKey("errorcode") )
            setErrorcode((localErrorcode).intValue());
        if ( h.containsKey("vdat") )
            setVdat((localVdat));
        if ( h.containsKey("typemsg") )
            setTypemsg((localTypemsg));
        if ( h.containsKey("date3") )
            setDate3((localDate3));
        if ( h.containsKey("date2") )
            setDate2((localDate2));
        if ( h.containsKey("date1") )
            setDate1((localDate1));
        if ( h.containsKey("int3") )
            setInt3((localInt3));
        if ( h.containsKey("int2") )
            setInt2((localInt2));
        if ( h.containsKey("int1") )
            setInt1((localInt1));
        if ( h.containsKey("typesystem") )
            setTypesystem((localTypesystem));
        if ( h.containsKey("string5") )
            setString5((localString5));
        if ( h.containsKey("string4") )
            setString4((localString4));
        if ( h.containsKey("string3") )
            setString3((localString3));
        if ( h.containsKey("string2") )
            setString2((localString2));
        if ( h.containsKey("string1") )
            setString1((localString1));
        if ( h.containsKey("textmsg") )
            setTextmsg((localTextmsg));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getQueryLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	queryLink = null;
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
 * @param argIdnriquerylog int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argIdnriquerylog, int argQuery, String argTypeMsg, int argErrorcode,
		String argTextMsg, java.sql.Timestamp argVdat) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	idnriquerylog = argIdnriquerylog;
	query_idquery = new Integer(argQuery);
	typemsg = argTypeMsg;
	typesystem = "N";
	errorcode = argErrorcode;
	textmsg = argTextMsg;
	vdat = argVdat;
	int1 = null;
	int2 = null;
	int3 = null;
	date1 = null;
	date2 = null;
	date3 = null;
	dec1 = null;
	dec2 = null;
	dec3 = null;
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
 * @param argIdnriquerylog int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argIdnriquerylog) throws java.rmi.RemoteException {}
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
 * Getter method for date1
 * @return java.sql.Date
 */
public java.sql.Date getDate1() {
	return date1;
}
/**
 * Getter method for date2
 * @return java.sql.Date
 */
public java.sql.Date getDate2() {
	return date2;
}
/**
 * Getter method for date3
 * @return java.sql.Date
 */
public java.sql.Date getDate3() {
	return date3;
}
/**
 * Getter method for dec1
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDec1() {
	return dec1;
}
/**
 * Getter method for dec2
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDec2() {
	return dec2;
}
/**
 * Getter method for dec3
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDec3() {
	return dec3;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for errorcode
 * @return int
 */
public int getErrorcode() {
	return errorcode;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 12:23:07)
 * @return int
 */
public int getIdnriquerylog() {
	return idnriquerylog;
}
/**
 * Getter method for int1
 * @return java.lang.Integer
 */
public java.lang.Integer getInt1() {
	return int1;
}
/**
 * Getter method for int2
 * @return java.lang.Integer
 */
public java.lang.Integer getInt2() {
	return int2;
}
/**
 * Getter method for int3
 * @return java.lang.Integer
 */
public java.lang.Integer getInt3() {
	return int3;
}
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.PIEQuery getQuery() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.PIEQuery)this.getQueryLink().value();
}
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.PIEQueryKey getQueryKey() {
	com.hps.july.persistence.PIEQueryKey temp = null;
	temp = new com.hps.july.persistence.PIEQueryKey();
	boolean query_NULLTEST = true;
	query_NULLTEST &= (query_idquery == null);
	temp.idquery = ((query_idquery == null) ? 0 : query_idquery.intValue());
	if (query_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getQueryLink() {
	if (queryLink == null)
		queryLink = new PIEQueryLogToQueryLink(this);
	return queryLink;
}
/**
 * Getter method for string1
 */
public java.lang.String getString1() {
	return string1;
}
/**
 * Getter method for string2
 */
public java.lang.String getString2() {
	return string2;
}
/**
 * Getter method for string3
 */
public java.lang.String getString3() {
	return string3;
}
/**
 * Getter method for string4
 */
public java.lang.String getString4() {
	return string4;
}
/**
 * Getter method for string5
 */
public java.lang.String getString5() {
	return string5;
}
/**
 * Getter method for textmsg
 * @return java.lang.String
 */
public java.lang.String getTextmsg() {
	return textmsg;
}
/**
 * Getter method for typemsg
 * @return java.lang.String
 */
public java.lang.String getTypemsg() {
	return typemsg;
}
/**
 * Getter method for typesystem
 * @return java.lang.String
 */
public java.lang.String getTypesystem() {
	return typesystem;
}
/**
 * Getter method for vdat
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getVdat() {
	return vdat;
}
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetQueryKey(com.hps.july.persistence.PIEQueryKey inKey) {
	boolean query_NULLTEST = (inKey == null);
	if (query_NULLTEST) query_idquery = null; else query_idquery = (new Integer(inKey.idquery));
}
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException {
	this.getQueryLink().secondarySet(aQuery);
}
/**
 * Setter method for date1
 * @param newValue java.sql.Date
 */
public void setDate1(java.sql.Date newValue) {
	this.date1 = newValue;
}
/**
 * Setter method for date2
 * @param newValue java.sql.Date
 */
public void setDate2(java.sql.Date newValue) {
	this.date2 = newValue;
}
/**
 * Setter method for date3
 * @param newValue java.sql.Date
 */
public void setDate3(java.sql.Date newValue) {
	this.date3 = newValue;
}
/**
 * Setter method for dec1
 * @param newValue java.math.BigDecimal
 */
public void setDec1(java.math.BigDecimal newValue) {
	this.dec1 = newValue;
}
/**
 * Setter method for dec2
 * @param newValue java.math.BigDecimal
 */
public void setDec2(java.math.BigDecimal newValue) {
	this.dec2 = newValue;
}
/**
 * Setter method for dec3
 * @param newValue java.math.BigDecimal
 */
public void setDec3(java.math.BigDecimal newValue) {
	this.dec3 = newValue;
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
 * Setter method for errorcode
 * @param newValue int
 */
public void setErrorcode(int newValue) {
	this.errorcode = newValue;
}
/**
 * Setter method for int1
 * @param newValue java.lang.Integer
 */
public void setInt1(java.lang.Integer newValue) {
	this.int1 = newValue;
}
/**
 * Setter method for int2
 * @param newValue java.lang.Integer
 */
public void setInt2(java.lang.Integer newValue) {
	this.int2 = newValue;
}
/**
 * Setter method for int3
 * @param newValue java.lang.Integer
 */
public void setInt3(java.lang.Integer newValue) {
	this.int3 = newValue;
}
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException {
	this.getQueryLink().set(aQuery);
}
/**
 * Setter method for string1
 */
public void setString1(java.lang.String newValue) {
	this.string1 = newValue;
}
/**
 * Setter method for string2
 */
public void setString2(java.lang.String newValue) {
	this.string2 = newValue;
}
/**
 * Setter method for string3
 */
public void setString3(java.lang.String newValue) {
	this.string3 = newValue;
}
/**
 * Setter method for string4
 */
public void setString4(java.lang.String newValue) {
	this.string4 = newValue;
}
/**
 * Setter method for string5
 */
public void setString5(java.lang.String newValue) {
	this.string5 = newValue;
}
/**
 * Setter method for textmsg
 * @param newValue java.lang.String
 */
public void setTextmsg(java.lang.String newValue) {
	this.textmsg = newValue;
}
/**
 * Setter method for typemsg
 * @param newValue java.lang.String
 */
public void setTypemsg(java.lang.String newValue) {
	this.typemsg = newValue;
}
/**
 * Setter method for typesystem
 * @param newValue java.lang.String
 */
public void setTypesystem(java.lang.String newValue) {
	this.typesystem = newValue;
}
/**
 * Setter method for vdat
 * @param newValue java.sql.Timestamp
 */
public void setVdat(java.sql.Timestamp newValue) {
	this.vdat = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}