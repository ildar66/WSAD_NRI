package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������ PIE - ������� NRI
 */
public class PIEPayNRIBean implements EntityBean {
	public java.sql.Date datebeforepay;
	public java.sql.Date datebuch;
	public java.sql.Date datecreate;
	private javax.ejb.EntityContext entityContext = null;
	public int id;
	public int idaccountnri;
	public Integer idbudjet;
	public int iddogovnri;
	public Integer idexpence;
	public Integer idpaymode;
	public Integer idpaytype;
	public Integer idtypeforbuch;
	public Integer idusernri;
	public java.math.BigDecimal ndspay;
	public String purposepay;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.math.BigDecimal sumpay;
	public Integer tiprasxodov;
	public String typedogovnri;
	public int valutepay;
	public java.lang.Integer query_idquery;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink queryLink = null;
	public Short isavans;
	public java.math.BigDecimal percentavans;
	public Integer typebasedoc;
	public Integer definerate;
	public String numberanddatebdoc;
	public String fl101;
	public String fl104;
	public String fl105;
	public String fl106;
	public String fl107;
	public String fl108;
	public String fl109;
	public String fl110;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("fl106", getFl106());
        h.put("typebasedoc", getTypebasedoc());
        h.put("fl105", getFl105());
        h.put("tiprasxodov", getTiprasxodov());
        h.put("fl104", getFl104());
        h.put("fl101", getFl101());
        h.put("idbudjet", getIdbudjet());
        h.put("idusernri", getIdusernri());
        h.put("valutepay", new Integer(getValutepay()));
        h.put("idtypeforbuch", getIdtypeforbuch());
        h.put("typedogovnri", getTypedogovnri());
        h.put("purposepay", getPurposepay());
        h.put("numberanddatebdoc", getNumberanddatebdoc());
        h.put("idpaymode", getIdpaymode());
        h.put("queryKey", getQueryKey());
        h.put("datebeforepay", getDatebeforepay());
        h.put("iddogovnri", new Integer(getIddogovnri()));
        h.put("datecreate", getDatecreate());
        h.put("sumpay", getSumpay());
        h.put("ndspay", getNdspay());
        h.put("idexpence", getIdexpence());
        h.put("datebuch", getDatebuch());
        h.put("fl110", getFl110());
        h.put("id", new Integer(getId()));
        h.put("idpaytype", getIdpaytype());
        h.put("definerate", getDefinerate());
        h.put("idaccountnri", new Integer(getIdaccountnri()));
        h.put("isavans", getIsavans());
        h.put("percentavans", getPercentavans());
        h.put("fl109", getFl109());
        h.put("fl108", getFl108());
        h.put("fl107", getFl107());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.String localFl106 = (java.lang.String) h.get("fl106");
        java.lang.Integer localTypebasedoc = (java.lang.Integer) h.get("typebasedoc");
        java.lang.String localFl105 = (java.lang.String) h.get("fl105");
        java.lang.Integer localTiprasxodov = (java.lang.Integer) h.get("tiprasxodov");
        java.lang.String localFl104 = (java.lang.String) h.get("fl104");
        java.lang.String localFl101 = (java.lang.String) h.get("fl101");
        java.lang.Integer localIdbudjet = (java.lang.Integer) h.get("idbudjet");
        java.lang.Integer localIdusernri = (java.lang.Integer) h.get("idusernri");
        Integer localValutepay = (Integer) h.get("valutepay");
        java.lang.Integer localIdtypeforbuch = (java.lang.Integer) h.get("idtypeforbuch");
        java.lang.String localTypedogovnri = (java.lang.String) h.get("typedogovnri");
        java.lang.String localPurposepay = (java.lang.String) h.get("purposepay");
        java.lang.String localNumberanddatebdoc = (java.lang.String) h.get("numberanddatebdoc");
        java.lang.Integer localIdpaymode = (java.lang.Integer) h.get("idpaymode");
        java.sql.Date localDatebeforepay = (java.sql.Date) h.get("datebeforepay");
        Integer localIddogovnri = (Integer) h.get("iddogovnri");
        java.sql.Date localDatecreate = (java.sql.Date) h.get("datecreate");
        java.math.BigDecimal localSumpay = (java.math.BigDecimal) h.get("sumpay");
        java.math.BigDecimal localNdspay = (java.math.BigDecimal) h.get("ndspay");
        java.lang.Integer localIdexpence = (java.lang.Integer) h.get("idexpence");
        java.sql.Date localDatebuch = (java.sql.Date) h.get("datebuch");
        java.lang.String localFl110 = (java.lang.String) h.get("fl110");
        java.lang.Integer localIdpaytype = (java.lang.Integer) h.get("idpaytype");
        java.lang.Integer localDefinerate = (java.lang.Integer) h.get("definerate");
        Integer localIdaccountnri = (Integer) h.get("idaccountnri");
        java.lang.Short localIsavans = (java.lang.Short) h.get("isavans");
        java.math.BigDecimal localPercentavans = (java.math.BigDecimal) h.get("percentavans");
        java.lang.String localFl109 = (java.lang.String) h.get("fl109");
        java.lang.String localFl108 = (java.lang.String) h.get("fl108");
        java.lang.String localFl107 = (java.lang.String) h.get("fl107");

        if ( h.containsKey("fl106") )
            setFl106((localFl106));
        if ( h.containsKey("typebasedoc") )
            setTypebasedoc((localTypebasedoc));
        if ( h.containsKey("fl105") )
            setFl105((localFl105));
        if ( h.containsKey("tiprasxodov") )
            setTiprasxodov((localTiprasxodov));
        if ( h.containsKey("fl104") )
            setFl104((localFl104));
        if ( h.containsKey("fl101") )
            setFl101((localFl101));
        if ( h.containsKey("idbudjet") )
            setIdbudjet((localIdbudjet));
        if ( h.containsKey("idusernri") )
            setIdusernri((localIdusernri));
        if ( h.containsKey("valutepay") )
            setValutepay((localValutepay).intValue());
        if ( h.containsKey("idtypeforbuch") )
            setIdtypeforbuch((localIdtypeforbuch));
        if ( h.containsKey("typedogovnri") )
            setTypedogovnri((localTypedogovnri));
        if ( h.containsKey("purposepay") )
            setPurposepay((localPurposepay));
        if ( h.containsKey("numberanddatebdoc") )
            setNumberanddatebdoc((localNumberanddatebdoc));
        if ( h.containsKey("idpaymode") )
            setIdpaymode((localIdpaymode));
        if ( h.containsKey("datebeforepay") )
            setDatebeforepay((localDatebeforepay));
        if ( h.containsKey("iddogovnri") )
            setIddogovnri((localIddogovnri).intValue());
        if ( h.containsKey("datecreate") )
            setDatecreate((localDatecreate));
        if ( h.containsKey("sumpay") )
            setSumpay((localSumpay));
        if ( h.containsKey("ndspay") )
            setNdspay((localNdspay));
        if ( h.containsKey("idexpence") )
            setIdexpence((localIdexpence));
        if ( h.containsKey("datebuch") )
            setDatebuch((localDatebuch));
        if ( h.containsKey("fl110") )
            setFl110((localFl110));
        if ( h.containsKey("idpaytype") )
            setIdpaytype((localIdpaytype));
        if ( h.containsKey("definerate") )
            setDefinerate((localDefinerate));
        if ( h.containsKey("idaccountnri") )
            setIdaccountnri((localIdaccountnri).intValue());
        if ( h.containsKey("isavans") )
            setIsavans((localIsavans));
        if ( h.containsKey("percentavans") )
            setPercentavans((localPercentavans));
        if ( h.containsKey("fl109") )
            setFl109((localFl109));
        if ( h.containsKey("fl108") )
            setFl108((localFl108));
        if ( h.containsKey("fl107") )
            setFl107((localFl107));

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
 * @param argId int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argId, int argQuery, String argTypeDogov, int argIdDogovNri, 
		int argIdAccount, java.sql.Date argDateCreate, java.math.BigDecimal argSumPay, 
		java.math.BigDecimal argNdsPay, int argValute) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	id = argId;
	query_idquery = new Integer(argQuery);
	typedogovnri = argTypeDogov;
	iddogovnri = argIdDogovNri;
	idaccountnri = argIdAccount;
	datecreate = argDateCreate;
	sumpay = argSumPay;
	ndspay = argNdsPay;
	valutepay = argValute;
	typebasedoc = null;
	numberanddatebdoc = null;
	purposepay = null;
	datebuch = null;
	datebeforepay = null;
	idusernri = null;
	idbudjet = null;
	idexpence = null;
	idpaymode = null;
	definerate = null;
	idpaytype = null;
	idtypeforbuch = null;
	tiprasxodov = null;
	isavans = null;
	percentavans = null;
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
 * @param argId int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argId) throws java.rmi.RemoteException {}
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
 * Getter method for datebeforepay
 * @return java.sql.Date
 */
public java.sql.Date getDatebeforepay() {
	return datebeforepay;
}
/**
 * Getter method for datebuch
 * @return java.sql.Date
 */
public java.sql.Date getDatebuch() {
	return datebuch;
}
/**
 * Getter method for datecreate
 * @return java.sql.Date
 */
public java.sql.Date getDatecreate() {
	return datecreate;
}
/**
 * Getter method for definerate
 */
public java.lang.Integer getDefinerate() {
	return definerate;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for fl101
 */
public java.lang.String getFl101() {
	return fl101;
}
/**
 * Getter method for fl104
 */
public java.lang.String getFl104() {
	return fl104;
}
/**
 * Getter method for fl105
 */
public java.lang.String getFl105() {
	return fl105;
}
/**
 * Getter method for fl106
 */
public java.lang.String getFl106() {
	return fl106;
}
/**
 * Getter method for fl107
 */
public java.lang.String getFl107() {
	return fl107;
}
/**
 * Getter method for fl108
 */
public java.lang.String getFl108() {
	return fl108;
}
/**
 * Getter method for fl109
 */
public java.lang.String getFl109() {
	return fl109;
}
/**
 * Getter method for fl110
 */
public java.lang.String getFl110() {
	return fl110;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2003 14:50:19)
 * @return int
 */
public int getId() {
	return id;
}
/**
 * Getter method for idaccountnri
 * @return int
 */
public int getIdaccountnri() {
	return idaccountnri;
}
/**
 * Getter method for idbudjet
 * @return java.lang.Integer
 */
public java.lang.Integer getIdbudjet() {
	return idbudjet;
}
/**
 * Getter method for iddogovnri
 * @return int
 */
public int getIddogovnri() {
	return iddogovnri;
}
/**
 * Getter method for idexpence
 * @return java.lang.Integer
 */
public java.lang.Integer getIdexpence() {
	return idexpence;
}
/**
 * Getter method for idpaymode
 * @return java.lang.Integer
 */
public java.lang.Integer getIdpaymode() {
	return idpaymode;
}
/**
 * Getter method for idpaytype
 * @return java.lang.Integer
 */
public java.lang.Integer getIdpaytype() {
	return idpaytype;
}
/**
 * Getter method for idtypeforbuch
 * @return java.lang.Integer
 */
public java.lang.Integer getIdtypeforbuch() {
	return idtypeforbuch;
}
/**
 * Getter method for idusernri
 * @return java.lang.Integer
 */
public java.lang.Integer getIdusernri() {
	return idusernri;
}
/**
 * Getter method for isavans
 */
public java.lang.Short getIsavans() {
	return isavans;
}
/**
 * Getter method for ndspay
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNdspay() {
	return ndspay;
}
/**
 * Getter method for numberanddatebdoc
 */
public java.lang.String getNumberanddatebdoc() {
	return numberanddatebdoc;
}
/**
 * Getter method for percentavans
 */
public java.math.BigDecimal getPercentavans() {
	return percentavans;
}
/**
 * Getter method for purposepay
 * @return java.lang.String
 */
public java.lang.String getPurposepay() {
	return purposepay;
}
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.PIEQuery getQuery() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.PIEQuery)this.getQueryLink().value();
}
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
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
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getQueryLink() {
	if (queryLink == null)
		queryLink = new PIEPayNRIToQueryLink(this);
	return queryLink;
}
/**
 * Getter method for sumpay
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumpay() {
	return sumpay;
}
/**
 * Getter method for tiprasxodov
 * @return java.lang.Integer
 */
public java.lang.Integer getTiprasxodov() {
	return tiprasxodov;
}
/**
 * Getter method for typebasedoc
 */
public java.lang.Integer getTypebasedoc() {
	return typebasedoc;
}
/**
 * Getter method for typedogovnri
 * @return java.lang.String
 */
public java.lang.String getTypedogovnri() {
	return typedogovnri;
}
/**
 * Getter method for valutepay
 * @return int
 */
public int getValutepay() {
	return valutepay;
}
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetQueryKey(com.hps.july.persistence.PIEQueryKey inKey) {
	boolean query_NULLTEST = (inKey == null);
	if (query_NULLTEST) query_idquery = null; else query_idquery = (new Integer(inKey.idquery));
}
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException {
	this.getQueryLink().secondarySet(aQuery);
}
/**
 * Setter method for datebeforepay
 * @param newValue java.sql.Date
 */
public void setDatebeforepay(java.sql.Date newValue) {
	this.datebeforepay = newValue;
}
/**
 * Setter method for datebuch
 * @param newValue java.sql.Date
 */
public void setDatebuch(java.sql.Date newValue) {
	this.datebuch = newValue;
}
/**
 * Setter method for datecreate
 * @param newValue java.sql.Date
 */
public void setDatecreate(java.sql.Date newValue) {
	this.datecreate = newValue;
}
/**
 * Setter method for definerate
 */
public void setDefinerate(java.lang.Integer newValue) {
	this.definerate = newValue;
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
 * Setter method for fl101
 */
public void setFl101(java.lang.String newValue) {
	this.fl101 = newValue;
}
/**
 * Setter method for fl104
 */
public void setFl104(java.lang.String newValue) {
	this.fl104 = newValue;
}
/**
 * Setter method for fl105
 */
public void setFl105(java.lang.String newValue) {
	this.fl105 = newValue;
}
/**
 * Setter method for fl106
 */
public void setFl106(java.lang.String newValue) {
	this.fl106 = newValue;
}
/**
 * Setter method for fl107
 */
public void setFl107(java.lang.String newValue) {
	this.fl107 = newValue;
}
/**
 * Setter method for fl108
 */
public void setFl108(java.lang.String newValue) {
	this.fl108 = newValue;
}
/**
 * Setter method for fl109
 */
public void setFl109(java.lang.String newValue) {
	this.fl109 = newValue;
}
/**
 * Setter method for fl110
 */
public void setFl110(java.lang.String newValue) {
	this.fl110 = newValue;
}
/**
 * Setter method for idaccountnri
 * @param newValue int
 */
public void setIdaccountnri(int newValue) {
	this.idaccountnri = newValue;
}
/**
 * Setter method for idbudjet
 * @param newValue java.lang.Integer
 */
public void setIdbudjet(java.lang.Integer newValue) {
	this.idbudjet = newValue;
}
/**
 * Setter method for iddogovnri
 * @param newValue int
 */
public void setIddogovnri(int newValue) {
	this.iddogovnri = newValue;
}
/**
 * Setter method for idexpence
 * @param newValue java.lang.Integer
 */
public void setIdexpence(java.lang.Integer newValue) {
	this.idexpence = newValue;
}
/**
 * Setter method for idpaymode
 * @param newValue java.lang.Integer
 */
public void setIdpaymode(java.lang.Integer newValue) {
	this.idpaymode = newValue;
}
/**
 * Setter method for idpaytype
 * @param newValue java.lang.Integer
 */
public void setIdpaytype(java.lang.Integer newValue) {
	this.idpaytype = newValue;
}
/**
 * Setter method for idtypeforbuch
 * @param newValue java.lang.Integer
 */
public void setIdtypeforbuch(java.lang.Integer newValue) {
	this.idtypeforbuch = newValue;
}
/**
 * Setter method for idusernri
 * @param newValue java.lang.Integer
 */
public void setIdusernri(java.lang.Integer newValue) {
	this.idusernri = newValue;
}
/**
 * Setter method for isavans
 */
public void setIsavans(java.lang.Short newValue) {
	this.isavans = newValue;
}
/**
 * Setter method for ndspay
 * @param newValue java.math.BigDecimal
 */
public void setNdspay(java.math.BigDecimal newValue) {
	this.ndspay = newValue;
}
/**
 * Setter method for numberanddatebdoc
 */
public void setNumberanddatebdoc(java.lang.String newValue) {
	this.numberanddatebdoc = newValue;
}
/**
 * Setter method for percentavans
 */
public void setPercentavans(java.math.BigDecimal newValue) {
	this.percentavans = newValue;
}
/**
 * Setter method for purposepay
 * @param newValue java.lang.String
 */
public void setPurposepay(java.lang.String newValue) {
	this.purposepay = newValue;
}
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException {
	this.getQueryLink().set(aQuery);
}
/**
 * Setter method for sumpay
 * @param newValue java.math.BigDecimal
 */
public void setSumpay(java.math.BigDecimal newValue) {
	this.sumpay = newValue;
}
/**
 * Setter method for tiprasxodov
 * @param newValue java.lang.Integer
 */
public void setTiprasxodov(java.lang.Integer newValue) {
	this.tiprasxodov = newValue;
}
/**
 * Setter method for typebasedoc
 */
public void setTypebasedoc(java.lang.Integer newValue) {
	this.typebasedoc = newValue;
}
/**
 * Setter method for typedogovnri
 * @param newValue java.lang.String
 */
public void setTypedogovnri(java.lang.String newValue) {
	this.typedogovnri = newValue;
}
/**
 * Setter method for valutepay
 * @param newValue int
 */
public void setValutepay(int newValue) {
	this.valutepay = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
