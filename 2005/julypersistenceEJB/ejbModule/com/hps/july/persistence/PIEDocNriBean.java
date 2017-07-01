package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������ PIE - ��������� �� Platinum
 */
public class PIEDocNriBean implements EntityBean {
	public Integer contragent;
	public java.sql.Date datedoc;
	private javax.ejb.EntityContext entityContext = null;
	public String gtdnumber;
	public Integer headuser;
	public Integer iddogovnri;
	public int idrecdoc;
	public Integer idvaluta;
	public int owner;
	public Integer placefrom;
	public Integer placeto;
	public String prim;
	private final static long serialVersionUID = 3206093459760846163L;
	public String soprnumber;
	public java.math.BigDecimal sumdoc;
	public String tempinbill;
	public short typedocnri;
	public String typedogovnri;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink pIEDocPosNrisLink = null;
	public java.lang.Integer query_idquery;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink queryLink = null;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("typedogovnri", getTypedogovnri());
        h.put("soprnumber", getSoprnumber());
        h.put("owner", new Integer(getOwner()));
        h.put("placefrom", getPlacefrom());
        h.put("gtdnumber", getGtdnumber());
        h.put("idvaluta", getIdvaluta());
        h.put("queryKey", getQueryKey());
        h.put("prim", getPrim());
        h.put("iddogovnri", getIddogovnri());
        h.put("sumdoc", getSumdoc());
        h.put("tempinbill", getTempinbill());
        h.put("placeto", getPlaceto());
        h.put("contragent", getContragent());
        h.put("typedocnri", new Short(getTypedocnri()));
        h.put("idrecdoc", new Integer(getIdrecdoc()));
        h.put("datedoc", getDatedoc());
        h.put("headuser", getHeaduser());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.String localTypedogovnri = (java.lang.String) h.get("typedogovnri");
        java.lang.String localSoprnumber = (java.lang.String) h.get("soprnumber");
        Integer localOwner = (Integer) h.get("owner");
        java.lang.Integer localPlacefrom = (java.lang.Integer) h.get("placefrom");
        java.lang.String localGtdnumber = (java.lang.String) h.get("gtdnumber");
        java.lang.Integer localIdvaluta = (java.lang.Integer) h.get("idvaluta");
        java.lang.String localPrim = (java.lang.String) h.get("prim");
        java.lang.Integer localIddogovnri = (java.lang.Integer) h.get("iddogovnri");
        java.math.BigDecimal localSumdoc = (java.math.BigDecimal) h.get("sumdoc");
        java.lang.String localTempinbill = (java.lang.String) h.get("tempinbill");
        java.lang.Integer localPlaceto = (java.lang.Integer) h.get("placeto");
        java.lang.Integer localContragent = (java.lang.Integer) h.get("contragent");
        Short localTypedocnri = (Short) h.get("typedocnri");
        java.sql.Date localDatedoc = (java.sql.Date) h.get("datedoc");
        java.lang.Integer localHeaduser = (java.lang.Integer) h.get("headuser");

        if ( h.containsKey("typedogovnri") )
            setTypedogovnri((localTypedogovnri));
        if ( h.containsKey("soprnumber") )
            setSoprnumber((localSoprnumber));
        if ( h.containsKey("owner") )
            setOwner((localOwner).intValue());
        if ( h.containsKey("placefrom") )
            setPlacefrom((localPlacefrom));
        if ( h.containsKey("gtdnumber") )
            setGtdnumber((localGtdnumber));
        if ( h.containsKey("idvaluta") )
            setIdvaluta((localIdvaluta));
        if ( h.containsKey("prim") )
            setPrim((localPrim));
        if ( h.containsKey("iddogovnri") )
            setIddogovnri((localIddogovnri));
        if ( h.containsKey("sumdoc") )
            setSumdoc((localSumdoc));
        if ( h.containsKey("tempinbill") )
            setTempinbill((localTempinbill));
        if ( h.containsKey("placeto") )
            setPlaceto((localPlaceto));
        if ( h.containsKey("contragent") )
            setContragent((localContragent));
        if ( h.containsKey("typedocnri") )
            setTypedocnri((localTypedocnri).shortValue());
        if ( h.containsKey("datedoc") )
            setDatedoc((localDatedoc));
        if ( h.containsKey("headuser") )
            setHeaduser((localHeaduser));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getPIEDocPosNrisLink());
	links.addElement(getQueryLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	pIEDocPosNrisLink = null;
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
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addPIEDocPosNris(com.hps.july.persistence.PIEDocPosNri aPIEDocPosNris) throws java.rmi.RemoteException {
	this.getPIEDocPosNrisLink().addElement(aPIEDocPosNris);
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
 * @param argIdrecdoc int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argIdrecdoc, int argQuery, short argTypeDocNri, int argOwner) 
		throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	idrecdoc = argIdrecdoc;
	query_idquery = new Integer(argQuery);
	typedocnri = argTypeDocNri;
	owner = argOwner;
	iddogovnri = null;
	typedogovnri = null;
	datedoc = null;
	soprnumber = null;
	gtdnumber = null;
	headuser = null;
	contragent = null;
	placefrom = null;
	placeto = null;
	idvaluta = null;
	sumdoc = null;
	tempinbill = null;
	prim = null;
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
 * @param argIdrecdoc int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argIdrecdoc) throws java.rmi.RemoteException {}
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
 * Getter method for contragent
 * @return java.lang.Integer
 */
public java.lang.Integer getContragent() {
	return contragent;
}
/**
 * Getter method for datedoc
 * @return java.sql.Date
 */
public java.sql.Date getDatedoc() {
	return datedoc;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for gtdnumber
 * @return java.lang.String
 */
public java.lang.String getGtdnumber() {
	return gtdnumber;
}
/**
 * Getter method for headuser
 * @return java.lang.Integer
 */
public java.lang.Integer getHeaduser() {
	return headuser;
}
/**
 * Getter method for iddogovnri
 * @return java.lang.Integer
 */
public java.lang.Integer getIddogovnri() {
	return iddogovnri;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 12:44:20)
 * @return int
 */
public int getIdrecdoc() {
	return idrecdoc;
}
/**
 * Getter method for idvaluta
 * @return java.lang.Integer
 */
public java.lang.Integer getIdvaluta() {
	return idvaluta;
}
/**
 * Getter method for owner
 * @return int
 */
public int getOwner() {
	return owner;
}
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEDocPosNris() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPIEDocPosNrisLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPIEDocPosNrisLink() {
	if (pIEDocPosNrisLink == null)
		pIEDocPosNrisLink = new PIEDocNriToPIEDocPosNrisLink(this);
	return pIEDocPosNrisLink;
}
/**
 * Getter method for placefrom
 * @return java.lang.Integer
 */
public java.lang.Integer getPlacefrom() {
	return placefrom;
}
/**
 * Getter method for placeto
 * @return java.lang.Integer
 */
public java.lang.Integer getPlaceto() {
	return placeto;
}
/**
 * Getter method for prim
 * @return java.lang.String
 */
public java.lang.String getPrim() {
	return prim;
}
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.PIEQuery getQuery() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.PIEQuery)this.getQueryLink().value();
}
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
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
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getQueryLink() {
	if (queryLink == null)
		queryLink = new PIEDocNriToQueryLink(this);
	return queryLink;
}
/**
 * Getter method for soprnumber
 * @return java.lang.String
 */
public java.lang.String getSoprnumber() {
	return soprnumber;
}
/**
 * Getter method for sumdoc
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumdoc() {
	return sumdoc;
}
/**
 * Getter method for tempinbill
 * @return java.lang.String
 */
public java.lang.String getTempinbill() {
	return tempinbill;
}
/**
 * Getter method for typedocnri
 * @return short
 */
public short getTypedocnri() {
	return typedocnri;
}
/**
 * Getter method for typedogovnri
 * @return java.lang.String
 */
public java.lang.String getTypedogovnri() {
	return typedogovnri;
}
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetQueryKey(com.hps.july.persistence.PIEQueryKey inKey) {
	boolean query_NULLTEST = (inKey == null);
	if (query_NULLTEST) query_idquery = null; else query_idquery = (new Integer(inKey.idquery));
}
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEDocPosNris(com.hps.july.persistence.PIEDocPosNri aPIEDocPosNris) {
	this.getPIEDocPosNrisLink().secondaryAddElement(aPIEDocPosNris);
}
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEDocPosNris(com.hps.july.persistence.PIEDocPosNri aPIEDocPosNris) {
	this.getPIEDocPosNrisLink().secondaryRemoveElement(aPIEDocPosNris);
}
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException {
	this.getQueryLink().secondarySet(aQuery);
}
/**
 * Setter method for contragent
 * @param newValue java.lang.Integer
 */
public void setContragent(java.lang.Integer newValue) {
	this.contragent = newValue;
}
/**
 * Setter method for datedoc
 * @param newValue java.sql.Date
 */
public void setDatedoc(java.sql.Date newValue) {
	this.datedoc = newValue;
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
 * Setter method for gtdnumber
 * @param newValue java.lang.String
 */
public void setGtdnumber(java.lang.String newValue) {
	this.gtdnumber = newValue;
}
/**
 * Setter method for headuser
 * @param newValue java.lang.Integer
 */
public void setHeaduser(java.lang.Integer newValue) {
	this.headuser = newValue;
}
/**
 * Setter method for iddogovnri
 * @param newValue java.lang.Integer
 */
public void setIddogovnri(java.lang.Integer newValue) {
	this.iddogovnri = newValue;
}
/**
 * Setter method for idvaluta
 * @param newValue java.lang.Integer
 */
public void setIdvaluta(java.lang.Integer newValue) {
	this.idvaluta = newValue;
}
/**
 * Setter method for owner
 * @param newValue int
 */
public void setOwner(int newValue) {
	this.owner = newValue;
}
/**
 * Setter method for placefrom
 * @param newValue java.lang.Integer
 */
public void setPlacefrom(java.lang.Integer newValue) {
	this.placefrom = newValue;
}
/**
 * Setter method for placeto
 * @param newValue java.lang.Integer
 */
public void setPlaceto(java.lang.Integer newValue) {
	this.placeto = newValue;
}
/**
 * Setter method for prim
 * @param newValue java.lang.String
 */
public void setPrim(java.lang.String newValue) {
	this.prim = newValue;
}
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException {
	this.getQueryLink().set(aQuery);
}
/**
 * Setter method for soprnumber
 * @param newValue java.lang.String
 */
public void setSoprnumber(java.lang.String newValue) {
	this.soprnumber = newValue;
}
/**
 * Setter method for sumdoc
 * @param newValue java.math.BigDecimal
 */
public void setSumdoc(java.math.BigDecimal newValue) {
	this.sumdoc = newValue;
}
/**
 * Setter method for tempinbill
 * @param newValue java.lang.String
 */
public void setTempinbill(java.lang.String newValue) {
	this.tempinbill = newValue;
}
/**
 * Setter method for typedocnri
 * @param newValue short
 */
public void setTypedocnri(short newValue) {
	this.typedocnri = newValue;
}
/**
 * Setter method for typedogovnri
 * @param newValue java.lang.String
 */
public void setTypedogovnri(java.lang.String newValue) {
	this.typedogovnri = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}