package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������ PIE - ������� � Platinum
 */
public class PIEQueryBean implements EntityBean {
	public java.sql.Timestamp datebeg;
	public java.sql.Timestamp dateend;
	private javax.ejb.EntityContext entityContext = null;
	public Integer idobjnriint;
	public String idobjnristr;
	public String idobjplat;
	public Integer idplatinumqry;
	public int idquery;
	public String operation;
	public Integer owner;
	private final static long serialVersionUID = 3206093459760846163L;
	public String status;
	public String statusop;
	public String typeobjnri;
	public String typequery;
	public java.sql.Timestamp vdat;
	public Integer voper;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink pIEQueryListsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink pIEQueryLogsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink pIEDocNrisLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink pIEDogovorNRIsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink pIEPayNRIsLink = null;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("owner", getOwner());
        h.put("vdat", getVdat());
        h.put("idquery", new Integer(getIdquery()));
        h.put("typequery", getTypequery());
        h.put("idplatinumqry", getIdplatinumqry());
        h.put("voper", getVoper());
        h.put("operation", getOperation());
        h.put("idobjplat", getIdobjplat());
        h.put("status", getStatus());
        h.put("statusop", getStatusop());
        h.put("dateend", getDateend());
        h.put("typeobjnri", getTypeobjnri());
        h.put("idobjnriint", getIdobjnriint());
        h.put("idobjnristr", getIdobjnristr());
        h.put("datebeg", getDatebeg());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.Integer localOwner = (java.lang.Integer) h.get("owner");
        java.sql.Timestamp localVdat = (java.sql.Timestamp) h.get("vdat");
        java.lang.String localTypequery = (java.lang.String) h.get("typequery");
        java.lang.Integer localIdplatinumqry = (java.lang.Integer) h.get("idplatinumqry");
        java.lang.Integer localVoper = (java.lang.Integer) h.get("voper");
        java.lang.String localOperation = (java.lang.String) h.get("operation");
        java.lang.String localIdobjplat = (java.lang.String) h.get("idobjplat");
        java.lang.String localStatus = (java.lang.String) h.get("status");
        java.lang.String localStatusop = (java.lang.String) h.get("statusop");
        java.sql.Timestamp localDateend = (java.sql.Timestamp) h.get("dateend");
        java.lang.String localTypeobjnri = (java.lang.String) h.get("typeobjnri");
        java.lang.Integer localIdobjnriint = (java.lang.Integer) h.get("idobjnriint");
        java.lang.String localIdobjnristr = (java.lang.String) h.get("idobjnristr");
        java.sql.Timestamp localDatebeg = (java.sql.Timestamp) h.get("datebeg");

        if ( h.containsKey("owner") )
            setOwner((localOwner));
        if ( h.containsKey("vdat") )
            setVdat((localVdat));
        if ( h.containsKey("typequery") )
            setTypequery((localTypequery));
        if ( h.containsKey("idplatinumqry") )
            setIdplatinumqry((localIdplatinumqry));
        if ( h.containsKey("voper") )
            setVoper((localVoper));
        if ( h.containsKey("operation") )
            setOperation((localOperation));
        if ( h.containsKey("idobjplat") )
            setIdobjplat((localIdobjplat));
        if ( h.containsKey("status") )
            setStatus((localStatus));
        if ( h.containsKey("statusop") )
            setStatusop((localStatusop));
        if ( h.containsKey("dateend") )
            setDateend((localDateend));
        if ( h.containsKey("typeobjnri") )
            setTypeobjnri((localTypeobjnri));
        if ( h.containsKey("idobjnriint") )
            setIdobjnriint((localIdobjnriint));
        if ( h.containsKey("idobjnristr") )
            setIdobjnristr((localIdobjnristr));
        if ( h.containsKey("datebeg") )
            setDatebeg((localDatebeg));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getPIEQueryListsLink());
	links.addElement(getPIEQueryLogsLink());
	links.addElement(getPIEDocNrisLink());
	links.addElement(getPIEDogovorNRIsLink());
	links.addElement(getPIEPayNRIsLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	pIEQueryListsLink = null;
	pIEQueryLogsLink = null;
	pIEDocNrisLink = null;
	pIEDogovorNRIsLink = null;
	pIEPayNRIsLink = null;
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
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addPIEDocNris(com.hps.july.persistence.PIEDocNri aPIEDocNris) throws java.rmi.RemoteException {
	this.getPIEDocNrisLink().addElement(aPIEDocNris);
}
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addPIEDogovorNRIs(com.hps.july.persistence.PIEDogovorNRI aPIEDogovorNRIs) throws java.rmi.RemoteException {
	this.getPIEDogovorNRIsLink().addElement(aPIEDogovorNRIs);
}
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addPIEPayNRIs(com.hps.july.persistence.PIEPayNRI aPIEPayNRIs) throws java.rmi.RemoteException {
	this.getPIEPayNRIsLink().addElement(aPIEPayNRIs);
}
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addPIEQueryLists(com.hps.july.persistence.PIEQueryList aPIEQueryLists) throws java.rmi.RemoteException {
	this.getPIEQueryListsLink().addElement(aPIEQueryLists);
}
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addPIEQueryLogs(com.hps.july.persistence.PIEQueryLog aPIEQueryLogs) throws java.rmi.RemoteException {
	this.getPIEQueryLogsLink().addElement(aPIEQueryLogs);
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
 * @param argIdquery int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argIdquery, String argTypeQuery, String argOperation, String argStatus,
		String argStatusop, java.sql.Timestamp argVdat) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	idquery = argIdquery;
	typequery = argTypeQuery;
	operation = argOperation;
	status = argStatus;
	statusop = argStatusop;
	vdat = argVdat;
	idplatinumqry = null;
	typeobjnri = null;
	idobjnriint = null;
	idobjnristr = null;
	owner = null;
	datebeg = null;
	dateend = null;
	idobjplat = null;
	voper = null;
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
 * @param argIdquery int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argIdquery) throws java.rmi.RemoteException {}
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
 * Getter method for datebeg
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getDatebeg() {
	return datebeg;
}
/**
 * Getter method for dateend
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getDateend() {
	return dateend;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for idobjnriint
 * @return java.lang.Integer
 */
public java.lang.Integer getIdobjnriint() {
	return idobjnriint;
}
/**
 * Getter method for idobjnristr
 * @return java.lang.String
 */
public java.lang.String getIdobjnristr() {
	return idobjnristr;
}
/**
 * Getter method for idobjplat
 * @return java.lang.String
 */
public java.lang.String getIdobjplat() {
	return idobjplat;
}
/**
 * Getter method for idplatinumqry
 * @return java.lang.Integer
 */
public java.lang.Integer getIdplatinumqry() {
	return idplatinumqry;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 12:13:40)
 * @return int
 */
public int getIdquery() {
	return idquery;
}
/**
 * Getter method for operation
 * @return java.lang.String
 */
public java.lang.String getOperation() {
	return operation;
}
/**
 * Getter method for owner
 * @return java.lang.Integer
 */
public java.lang.Integer getOwner() {
	return owner;
}
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEDocNris() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPIEDocNrisLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPIEDocNrisLink() {
	if (pIEDocNrisLink == null)
		pIEDocNrisLink = new PIEQueryToPIEDocNrisLink(this);
	return pIEDocNrisLink;
}
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEDogovorNRIs() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPIEDogovorNRIsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPIEDogovorNRIsLink() {
	if (pIEDogovorNRIsLink == null)
		pIEDogovorNRIsLink = new PIEQueryToPIEDogovorNRIsLink(this);
	return pIEDogovorNRIsLink;
}
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEPayNRIs() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPIEPayNRIsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPIEPayNRIsLink() {
	if (pIEPayNRIsLink == null)
		pIEPayNRIsLink = new PIEQueryToPIEPayNRIsLink(this);
	return pIEPayNRIsLink;
}
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEQueryLists() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPIEQueryListsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPIEQueryListsLink() {
	if (pIEQueryListsLink == null)
		pIEQueryListsLink = new PIEQueryToPIEQueryListsLink(this);
	return pIEQueryListsLink;
}
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEQueryLogs() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPIEQueryLogsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPIEQueryLogsLink() {
	if (pIEQueryLogsLink == null)
		pIEQueryLogsLink = new PIEQueryToPIEQueryLogsLink(this);
	return pIEQueryLogsLink;
}
/**
 * Getter method for status
 * @return java.lang.String
 */
public java.lang.String getStatus() {
	return status;
}
/**
 * Getter method for statusop
 * @return java.lang.String
 */
public java.lang.String getStatusop() {
	return statusop;
}
/**
 * Getter method for typeobjnri
 * @return java.lang.String
 */
public java.lang.String getTypeobjnri() {
	return typeobjnri;
}
/**
 * Getter method for typequery
 * @return java.lang.String
 */
public java.lang.String getTypequery() {
	return typequery;
}
/**
 * Getter method for vdat
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getVdat() {
	return vdat;
}
/**
 * Getter method for voper
 * @return java.lang.Integer
 */
public java.lang.Integer getVoper() {
	return voper;
}
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEDocNris(com.hps.july.persistence.PIEDocNri aPIEDocNris) {
	this.getPIEDocNrisLink().secondaryAddElement(aPIEDocNris);
}
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEDogovorNRIs(com.hps.july.persistence.PIEDogovorNRI aPIEDogovorNRIs) {
	this.getPIEDogovorNRIsLink().secondaryAddElement(aPIEDogovorNRIs);
}
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEPayNRIs(com.hps.july.persistence.PIEPayNRI aPIEPayNRIs) {
	this.getPIEPayNRIsLink().secondaryAddElement(aPIEPayNRIs);
}
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEQueryLists(com.hps.july.persistence.PIEQueryList aPIEQueryLists) {
	this.getPIEQueryListsLink().secondaryAddElement(aPIEQueryLists);
}
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEQueryLogs(com.hps.july.persistence.PIEQueryLog aPIEQueryLogs) {
	this.getPIEQueryLogsLink().secondaryAddElement(aPIEQueryLogs);
}
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEDocNris(com.hps.july.persistence.PIEDocNri aPIEDocNris) {
	this.getPIEDocNrisLink().secondaryRemoveElement(aPIEDocNris);
}
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEDogovorNRIs(com.hps.july.persistence.PIEDogovorNRI aPIEDogovorNRIs) {
	this.getPIEDogovorNRIsLink().secondaryRemoveElement(aPIEDogovorNRIs);
}
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEPayNRIs(com.hps.july.persistence.PIEPayNRI aPIEPayNRIs) {
	this.getPIEPayNRIsLink().secondaryRemoveElement(aPIEPayNRIs);
}
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEQueryLists(com.hps.july.persistence.PIEQueryList aPIEQueryLists) {
	this.getPIEQueryListsLink().secondaryRemoveElement(aPIEQueryLists);
}
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEQueryLogs(com.hps.july.persistence.PIEQueryLog aPIEQueryLogs) {
	this.getPIEQueryLogsLink().secondaryRemoveElement(aPIEQueryLogs);
}
/**
 * Setter method for datebeg
 * @param newValue java.sql.Timestamp
 */
public void setDatebeg(java.sql.Timestamp newValue) {
	this.datebeg = newValue;
}
/**
 * Setter method for dateend
 * @param newValue java.sql.Timestamp
 */
public void setDateend(java.sql.Timestamp newValue) {
	this.dateend = newValue;
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
 * Setter method for idobjnriint
 * @param newValue java.lang.Integer
 */
public void setIdobjnriint(java.lang.Integer newValue) {
	this.idobjnriint = newValue;
}
/**
 * Setter method for idobjnristr
 * @param newValue java.lang.String
 */
public void setIdobjnristr(java.lang.String newValue) {
	this.idobjnristr = newValue;
}
/**
 * Setter method for idobjplat
 * @param newValue java.lang.String
 */
public void setIdobjplat(java.lang.String newValue) {
	this.idobjplat = newValue;
}
/**
 * Setter method for idplatinumqry
 * @param newValue java.lang.Integer
 */
public void setIdplatinumqry(java.lang.Integer newValue) {
	this.idplatinumqry = newValue;
}
/**
 * Setter method for operation
 * @param newValue java.lang.String
 */
public void setOperation(java.lang.String newValue) {
	this.operation = newValue;
}
/**
 * Setter method for owner
 * @param newValue java.lang.Integer
 */
public void setOwner(java.lang.Integer newValue) {
	this.owner = newValue;
}
/**
 * Setter method for status
 * @param newValue java.lang.String
 */
public void setStatus(java.lang.String newValue) {
	this.status = newValue;
}
/**
 * Setter method for statusop
 * @param newValue java.lang.String
 */
public void setStatusop(java.lang.String newValue) {
	this.statusop = newValue;
}
/**
 * Setter method for typeobjnri
 * @param newValue java.lang.String
 */
public void setTypeobjnri(java.lang.String newValue) {
	this.typeobjnri = newValue;
}
/**
 * Setter method for typequery
 * @param newValue java.lang.String
 */
public void setTypequery(java.lang.String newValue) {
	this.typequery = newValue;
}
/**
 * Setter method for vdat
 * @param newValue java.sql.Timestamp
 */
public void setVdat(java.sql.Timestamp newValue) {
	this.vdat = newValue;
}
/**
 * Setter method for voper
 * @param newValue java.lang.Integer
 */
public void setVoper(java.lang.Integer newValue) {
	this.voper = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
