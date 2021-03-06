package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������ PIE - ������� �� Platinum
 */
public class PIEPayPlatinumBean implements EntityBean {
	public java.sql.Date date;
	public String docnumber;
	private javax.ejb.EntityContext entityContext = null;
	public String flagworknri;
	public int iddogovornri;
	public String idpayplatinum;
	public String purposepay;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.math.BigDecimal summ;
	public java.math.BigDecimal summnds;
	public java.math.BigDecimal summndsrub;
	public java.math.BigDecimal summrub;
	public int valute;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink pIEPayLinksLink = null;
	public Integer docposition;
	public String recordstatus;
	public Integer paystateplatinum;
	public int owner;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("owner", new Integer(getOwner()));
        h.put("purposepay", getPurposepay());
        h.put("docposition", getDocposition());
        h.put("date", getDate());
        h.put("summndsrub", getSummndsrub());
        h.put("paystateplatinum", getPaystateplatinum());
        h.put("recordstatus", getRecordstatus());
        h.put("flagworknri", getFlagworknri());
        h.put("idpayplatinum", getIdpayplatinum());
        h.put("summ", getSumm());
        h.put("summrub", getSummrub());
        h.put("valute", new Integer(getValute()));
        h.put("summnds", getSummnds());
        h.put("docnumber", getDocnumber());
        h.put("iddogovornri", new Integer(getIddogovornri()));
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.String localPurposepay = (java.lang.String) h.get("purposepay");
        java.lang.Integer localDocposition = (java.lang.Integer) h.get("docposition");
        java.sql.Date localDate = (java.sql.Date) h.get("date");
        java.math.BigDecimal localSummndsrub = (java.math.BigDecimal) h.get("summndsrub");
        java.lang.Integer localPaystateplatinum = (java.lang.Integer) h.get("paystateplatinum");
        java.lang.String localRecordstatus = (java.lang.String) h.get("recordstatus");
        java.lang.String localFlagworknri = (java.lang.String) h.get("flagworknri");
        java.math.BigDecimal localSumm = (java.math.BigDecimal) h.get("summ");
        java.math.BigDecimal localSummrub = (java.math.BigDecimal) h.get("summrub");
        Integer localValute = (Integer) h.get("valute");
        java.math.BigDecimal localSummnds = (java.math.BigDecimal) h.get("summnds");
        java.lang.String localDocnumber = (java.lang.String) h.get("docnumber");
        Integer localIddogovornri = (Integer) h.get("iddogovornri");

        if ( h.containsKey("purposepay") )
            setPurposepay((localPurposepay));
        if ( h.containsKey("docposition") )
            setDocposition((localDocposition));
        if ( h.containsKey("date") )
            setDate((localDate));
        if ( h.containsKey("summndsrub") )
            setSummndsrub((localSummndsrub));
        if ( h.containsKey("paystateplatinum") )
            setPaystateplatinum((localPaystateplatinum));
        if ( h.containsKey("recordstatus") )
            setRecordstatus((localRecordstatus));
        if ( h.containsKey("flagworknri") )
            setFlagworknri((localFlagworknri));
        if ( h.containsKey("summ") )
            setSumm((localSumm));
        if ( h.containsKey("summrub") )
            setSummrub((localSummrub));
        if ( h.containsKey("valute") )
            setValute((localValute).intValue());
        if ( h.containsKey("summnds") )
            setSummnds((localSummnds));
        if ( h.containsKey("docnumber") )
            setDocnumber((localDocnumber));
        if ( h.containsKey("iddogovornri") )
            setIddogovornri((localIddogovornri).intValue());

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getPIEPayLinksLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	pIEPayLinksLink = null;
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
 * @param argIdpayplatinum java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(java.lang.String argIdpayplatinum, int argOwner, int argIdDogovorNri, java.math.BigDecimal argSumm,
		java.math.BigDecimal argSummNds, int argValute, java.math.BigDecimal argSummRub, 
		java.math.BigDecimal argSummNdsRub, java.sql.Date argDate, String argFlagWorkNri,
		String argPurpose, int argPayStatePlatinum, String argDocNumber) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	idpayplatinum = argIdpayplatinum;
	owner = argOwner;
	iddogovornri = argIdDogovorNri;
	summ = argSumm;
	summnds = argSummNds;
	valute = argValute;
	summrub = argSummRub;
	summndsrub = argSummNdsRub;
	date = argDate;
	flagworknri = argFlagWorkNri;
	purposepay = argPurpose;
	paystateplatinum = new Integer(argPayStatePlatinum);
	docnumber = argDocNumber;
	docposition = null;
	recordstatus = "A";
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argIdpayplatinum java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(java.lang.String argIdpayplatinum, int argIdDogovorNri, java.math.BigDecimal argSumm,
		java.math.BigDecimal argSummNds, int argValute, java.math.BigDecimal argSummRub, 
		java.math.BigDecimal argSummNdsRub, java.sql.Date argDate, String argFlagWorkNri,
		String argPurpose, int argPayStatePlatinum, String argDocNumber) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	idpayplatinum = argIdpayplatinum;
	owner = 1;
	iddogovornri = argIdDogovorNri;
	summ = argSumm;
	summnds = argSummNds;
	valute = argValute;
	summrub = argSummRub;
	summndsrub = argSummNdsRub;
	date = argDate;
	flagworknri = argFlagWorkNri;
	purposepay = argPurpose;
	paystateplatinum = new Integer(argPayStatePlatinum);
	docnumber = argDocNumber;
	docposition = null;
	recordstatus = "A";
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
 * @param argIdpayplatinum java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(java.lang.String argIdpayplatinum) throws java.rmi.RemoteException {}
/**
 * ejbPostCreate method for a CMP entity bean
 * @param argIdpayplatinum java.lang.String
 * @param argOwner int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(java.lang.String argIdpayplatinum, int argOwner) throws java.rmi.RemoteException {}
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
 * Getter method for date
 * @return java.sql.Date
 */
public java.sql.Date getDate() {
	return date;
}
/**
 * Getter method for docnumber
 * @return java.lang.String
 */
public java.lang.String getDocnumber() {
	return docnumber;
}
/**
 * Getter method for docposition
 */
public java.lang.Integer getDocposition() {
	return docposition;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for flagworknri
 * @return java.lang.String
 */
public java.lang.String getFlagworknri() {
	return flagworknri;
}
/**
 * Getter method for iddogovornri
 * @return int
 */
public int getIddogovornri() {
	return iddogovornri;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2003 11:46:37)
 * @return java.lang.String
 */
public java.lang.String getIdpayplatinum() {
	return idpayplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2003 11:45:49)
 * @return int
 */
public int getOwner() {
	return owner;
}
/**
 * Getter method for paystateplatinum
 */
public java.lang.Integer getPaystateplatinum() {
	return paystateplatinum;
}
/**
 * This method was generated for supporting the association named PIEPayLink2pay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEPayLinks() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPIEPayLinksLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named PIEPayLink2pay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPIEPayLinksLink() {
	if (pIEPayLinksLink == null)
		pIEPayLinksLink = new PIEPayPlatinumToPIEPayLinksLink(this);
	return pIEPayLinksLink;
}
/**
 * Getter method for purposepay
 * @return java.lang.String
 */
public java.lang.String getPurposepay() {
	return purposepay;
}
/**
 * Getter method for recordstatus
 */
public java.lang.String getRecordstatus() {
	return recordstatus;
}
/**
 * Getter method for summ
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumm() {
	return summ;
}
/**
 * Getter method for summnds
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSummnds() {
	return summnds;
}
/**
 * Getter method for summndsrub
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSummndsrub() {
	return summndsrub;
}
/**
 * Getter method for summrub
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSummrub() {
	return summrub;
}
/**
 * Getter method for valute
 * @return int
 */
public int getValute() {
	return valute;
}
/**
 * This method was generated for supporting the association named PIEPayLink2pay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEPayLinks(com.hps.july.persistence.PIEPayLink aPIEPayLinks) {
	this.getPIEPayLinksLink().secondaryAddElement(aPIEPayLinks);
}
/**
 * This method was generated for supporting the association named PIEPayLink2pay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEPayLinks(com.hps.july.persistence.PIEPayLink aPIEPayLinks) {
	this.getPIEPayLinksLink().secondaryRemoveElement(aPIEPayLinks);
}
/**
 * Setter method for date
 * @param newValue java.sql.Date
 */
public void setDate(java.sql.Date newValue) {
	this.date = newValue;
}
/**
 * Setter method for docnumber
 * @param newValue java.lang.String
 */
public void setDocnumber(java.lang.String newValue) {
	this.docnumber = newValue;
}
/**
 * Setter method for docposition
 */
public void setDocposition(java.lang.Integer newValue) {
	this.docposition = newValue;
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
 * Setter method for flagworknri
 * @param newValue java.lang.String
 */
public void setFlagworknri(java.lang.String newValue) {
	this.flagworknri = newValue;
}
/**
 * Setter method for iddogovornri
 * @param newValue int
 */
public void setIddogovornri(int newValue) {
	this.iddogovornri = newValue;
}
/**
 * Setter method for paystateplatinum
 */
public void setPaystateplatinum(java.lang.Integer newValue) {
	this.paystateplatinum = newValue;
}
/**
 * Setter method for purposepay
 * @param newValue java.lang.String
 */
public void setPurposepay(java.lang.String newValue) {
	this.purposepay = newValue;
}
/**
 * Setter method for recordstatus
 */
public void setRecordstatus(java.lang.String newValue) {
	this.recordstatus = newValue;
}
/**
 * Setter method for summ
 * @param newValue java.math.BigDecimal
 */
public void setSumm(java.math.BigDecimal newValue) {
	this.summ = newValue;
}
/**
 * Setter method for summnds
 * @param newValue java.math.BigDecimal
 */
public void setSummnds(java.math.BigDecimal newValue) {
	this.summnds = newValue;
}
/**
 * Setter method for summndsrub
 * @param newValue java.math.BigDecimal
 */
public void setSummndsrub(java.math.BigDecimal newValue) {
	this.summndsrub = newValue;
}
/**
 * Setter method for summrub
 * @param newValue java.math.BigDecimal
 */
public void setSummrub(java.math.BigDecimal newValue) {
	this.summrub = newValue;
}
/**
 * Setter method for valute
 * @param newValue int
 */
public void setValute(int newValue) {
	this.valute = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
