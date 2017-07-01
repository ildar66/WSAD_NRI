package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Оператор
 */
public class OperatorBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public String login;
	public int operator;
	public String password;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer man_man;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink manLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink operators2RolesLink = null;
	public Boolean enabled;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink documentActionLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseTaskStartsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink superRegionAccsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink regionAccsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink importSessionsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink antennesLink = null;
	public Integer msucode;
	/**
	 * Implementation field for persistent attribute: oldpwd
	 */
	public java.lang.String oldpwd;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("operator", new Integer(getOperator()));
		h.put("manKey", getManKey());
		h.put("msucode", getMsucode());
		h.put("enabled", getEnabled());
		h.put("login", getLogin());
		h.put("password", getPassword());
		h.put("oldpwd", getOldpwd());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		Integer localOperator = (Integer) h.get("operator");
		java.lang.Integer localMsucode = (java.lang.Integer) h.get("msucode");
		java.lang.Boolean localEnabled = (java.lang.Boolean) h.get("enabled");
		java.lang.String localLogin = (java.lang.String) h.get("login");
		java.lang.String localPassword = (java.lang.String) h.get("password");
		java.lang.String localOldpwd = (java.lang.String) h.get("oldpwd");

		if (h.containsKey("operator"))
			setOperator((localOperator).intValue());
		if (h.containsKey("msucode"))
			setMsucode((localMsucode));
		if (h.containsKey("enabled"))
			setEnabled((localEnabled));
		if (h.containsKey("login"))
			setLogin((localLogin));
		if (h.containsKey("password"))
			setPassword((localPassword));
		if (h.containsKey("oldpwd"))
			setOldpwd((localOldpwd));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getOperators2RolesLink());
	links.addElement(getManLink());
	links.addElement(getDocumentActionLink());
	links.addElement(getRegionAccsLink());
	links.addElement(getImportSessionsLink());
	links.addElement(getLeaseTaskStartsLink());
	links.addElement(getSuperRegionAccsLink());
	links.addElement(getAntennesLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	operators2RolesLink = null;
	manLink = null;
	documentActionLink = null;
	regionAccsLink = null;
	importSessionsLink = null;
	leaseTaskStartsLink = null;
	superRegionAccsLink = null;
	antennesLink = null;
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
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException {
	this.getAntennesLink().addElement(anAntennes);
}
/**
 * This method was generated for supporting the association named DocumentAction2Operators.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addDocumentAction(com.hps.july.persistence.DocumentAction aDocumentAction) throws java.rmi.RemoteException {
	this.getDocumentActionLink().addElement(aDocumentAction);
}
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addImportSessions(com.hps.july.persistence.ImportSession anImportSessions) throws java.rmi.RemoteException {
	this.getImportSessionsLink().addElement(anImportSessions);
}
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) throws java.rmi.RemoteException {
	this.getLeaseTaskStartsLink().addElement(aLeaseTaskStarts);
}
/**
 * This method was generated for supporting the association named RegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addRegionAccs(com.hps.july.persistence.RegionAcc aRegionAccs) throws java.rmi.RemoteException {
	this.getRegionAccsLink().addElement(aRegionAccs);
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addSuperRegionAccs(com.hps.july.persistence.SuperRegionAcc aSuperRegionAccs) throws java.rmi.RemoteException {
	this.getSuperRegionAccsLink().addElement(aSuperRegionAccs);
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
 * @param argOperator int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argOperator) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	operator = argOperator;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argOperator int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argOperator, Integer argMan, String argLogin, String argPassword, Boolean argEnabled) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	login = null;
	operator = 0;
	password = null;
	man_man = null;
	enabled = null;
	msucode = null;

	operator = argOperator;
	man_man = argMan;
	login = argLogin;
	password = argPassword;
	enabled = argEnabled;
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
 * @param argOperator int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argOperator) throws java.rmi.RemoteException {}
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
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAntennes() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAntennesLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAntennesLink() {
	if (antennesLink == null)
		antennesLink = new OperatorToAntennesLink(this);
	return antennesLink;
}
/**
 * This method was generated for supporting the association named DocumentAction2Operators.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getDocumentAction() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getDocumentActionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named DocumentAction2Operators.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getDocumentActionLink() {
	if (documentActionLink == null)
		documentActionLink = new OperatorToDocumentActionLink(this);
	return documentActionLink;
}
/**
 * Getter method for enabled
 */
public java.lang.Boolean getEnabled() {
	return enabled;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getImportSessions() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getImportSessionsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getImportSessionsLink() {
	if (importSessionsLink == null)
		importSessionsLink = new OperatorToImportSessionsLink(this);
	return importSessionsLink;
}
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseTaskStarts() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseTaskStartsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseTaskStartsLink() {
	if (leaseTaskStartsLink == null)
		leaseTaskStartsLink = new OperatorToLeaseTaskStartsLink(this);
	return leaseTaskStartsLink;
}
/**
 * Getter method for login
 * @return java.lang.String
 */
public java.lang.String getLogin() {
	return login;
}
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.People getMan() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.People)this.getManLink().value();
}
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.PeopleKey getManKey() {
	com.hps.july.persistence.PeopleKey temp = null;
	temp = new com.hps.july.persistence.PeopleKey();
	boolean man_NULLTEST = true;
	man_NULLTEST &= (man_man == null);
	temp.man = ((man_man == null) ? 0 : man_man.intValue());
	if (man_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getManLink() {
	if (manLink == null)
		manLink = new OperatorToManLink(this);
	return manLink;
}
/**
 * Getter method for msucode
 */
public java.lang.Integer getMsucode() {
	return msucode;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2002 19:34:45)
 * @return int
 */
public int getOperator() {
	return operator;
}
/**
 * This method was generated for supporting the association named operators2roles2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getOperators2Roles() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getOperators2RolesLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named operators2roles2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getOperators2RolesLink() {
	if (operators2RolesLink == null)
		operators2RolesLink = new OperatorToOperators2RolesLink(this);
	return operators2RolesLink;
}
/**
 * Getter method for password
 * @return java.lang.String
 */
public java.lang.String getPassword() {
	return password;
}
/**
 * This method was generated for supporting the association named RegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getRegionAccs() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getRegionAccsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named RegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getRegionAccsLink() {
	if (regionAccsLink == null)
		regionAccsLink = new OperatorToRegionAccsLink(this);
	return regionAccsLink;
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSuperRegionAccs() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getSuperRegionAccsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getSuperRegionAccsLink() {
	if (superRegionAccsLink == null)
		superRegionAccsLink = new OperatorToSuperRegionAccsLink(this);
	return superRegionAccsLink;
}
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetManKey(com.hps.july.persistence.PeopleKey inKey) {
	boolean man_NULLTEST = (inKey == null);
	if (man_NULLTEST) man_man = null; else man_man = (new Integer(inKey.man));
}
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException {
	this.getAntennesLink().removeElement(anAntennes);
}
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAntennes(com.hps.july.persistence.Antenna anAntennes) {
	this.getAntennesLink().secondaryAddElement(anAntennes);
}
/**
 * This method was generated for supporting the association named DocumentAction2Operators.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddDocumentAction(com.hps.july.persistence.DocumentAction aDocumentAction) {
	this.getDocumentActionLink().secondaryAddElement(aDocumentAction);
}
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddImportSessions(com.hps.july.persistence.ImportSession anImportSessions) {
	this.getImportSessionsLink().secondaryAddElement(anImportSessions);
}
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) {
	this.getLeaseTaskStartsLink().secondaryAddElement(aLeaseTaskStarts);
}
/**
 * This method was generated for supporting the association named operators2roles2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddOperators2Roles(com.hps.july.persistence.Operators2Roles anOperators2Roles) {
	this.getOperators2RolesLink().secondaryAddElement(anOperators2Roles);
}
/**
 * This method was generated for supporting the association named RegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddRegionAccs(com.hps.july.persistence.RegionAcc aRegionAccs) {
	this.getRegionAccsLink().secondaryAddElement(aRegionAccs);
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSuperRegionAccs(com.hps.july.persistence.SuperRegionAcc aSuperRegionAccs) {
	this.getSuperRegionAccsLink().secondaryAddElement(aSuperRegionAccs);
}
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAntennes(com.hps.july.persistence.Antenna anAntennes) {
	this.getAntennesLink().secondaryRemoveElement(anAntennes);
}
/**
 * This method was generated for supporting the association named DocumentAction2Operators.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveDocumentAction(com.hps.july.persistence.DocumentAction aDocumentAction) {
	this.getDocumentActionLink().secondaryRemoveElement(aDocumentAction);
}
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveImportSessions(com.hps.july.persistence.ImportSession anImportSessions) {
	this.getImportSessionsLink().secondaryRemoveElement(anImportSessions);
}
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) {
	this.getLeaseTaskStartsLink().secondaryRemoveElement(aLeaseTaskStarts);
}
/**
 * This method was generated for supporting the association named operators2roles2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveOperators2Roles(com.hps.july.persistence.Operators2Roles anOperators2Roles) {
	this.getOperators2RolesLink().secondaryRemoveElement(anOperators2Roles);
}
/**
 * This method was generated for supporting the association named RegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveRegionAccs(com.hps.july.persistence.RegionAcc aRegionAccs) {
	this.getRegionAccsLink().secondaryRemoveElement(aRegionAccs);
}
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSuperRegionAccs(com.hps.july.persistence.SuperRegionAcc aSuperRegionAccs) {
	this.getSuperRegionAccsLink().secondaryRemoveElement(aSuperRegionAccs);
}
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetMan(com.hps.july.persistence.People aMan) throws java.rmi.RemoteException {
	this.getManLink().secondarySet(aMan);
}
/**
 * Setter method for enabled
 */
public void setEnabled(java.lang.Boolean newValue) {
	this.enabled = newValue;
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
 * Setter method for login
 * @param newValue java.lang.String
 */
public void setLogin(java.lang.String newValue) {
	this.login = newValue;
}
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setMan(com.hps.july.persistence.People aMan) throws java.rmi.RemoteException {
	this.getManLink().set(aMan);
}
/**
 * Setter method for msucode
 */
public void setMsucode(java.lang.Integer newValue) {
	this.msucode = newValue;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2002 19:34:45)
 * @param newOperator int
 */
public void setOperator(int newOperator) {
	operator = newOperator;
}
/**
 * Setter method for password
 * @param newValue java.lang.String
 */
public void setPassword(java.lang.String newValue) {
	this.password = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: oldpwd
	 */
	public java.lang.String getOldpwd() {
		return oldpwd;
	}
	/**
	 * Set accessor for persistent attribute: oldpwd
	 */
	public void setOldpwd(java.lang.String newOldpwd) {
		oldpwd = newOldpwd;
	}
}
