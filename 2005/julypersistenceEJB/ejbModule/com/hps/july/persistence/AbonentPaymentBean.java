package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Абонентский платеж
 */
public class AbonentPaymentBean implements EntityBean {
	public boolean byhand;
	private javax.ejb.EntityContext entityContext = null;
	public boolean flagworknri;
	public boolean needpay;
	public int paypos;
	public String recordstatus;
	public Integer resource;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.math.BigDecimal sumfreerur;
	public java.math.BigDecimal sumfreeusd;
	public java.math.BigDecimal sumnrirur;
	public java.math.BigDecimal sumnriusd;
	public java.math.BigDecimal sumpayrur;
	public java.math.BigDecimal sumpayusd;
	public String typename;
	public java.lang.Integer leaseabonentban_leaseDocument;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink leaseabonentbanLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseAbonentDNOPsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink abonPays2docposesLink = null;
	public Short ben;
	public String pymtype;
	public java.sql.Date paydate;
	public String paynumber;
	public String changeneedpay;
	/**
	 * Implementation field for persistent attribute: payPurpose
	 */
	public java.lang.String payPurpose;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("changeneedpay", getChangeneedpay());
		h.put("payPurpose", getPayPurpose());
		h.put("byhand", new Boolean(getByhand()));
		h.put("resource", getResource());
		h.put("paynumber", getPaynumber());
		h.put("pymtype", getPymtype());
		h.put("sumnrirur", getSumnrirur());
		h.put("paydate", getPaydate());
		h.put("typename", getTypename());
		h.put("leaseabonentbanKey", getLeaseabonentbanKey());
		h.put("sumfreeusd", getSumfreeusd());
		h.put("ben", getBen());
		h.put("sumpayrur", getSumpayrur());
		h.put("needpay", new Boolean(getNeedpay()));
		h.put("sumnriusd", getSumnriusd());
		h.put("flagworknri", new Boolean(getFlagworknri()));
		h.put("recordstatus", getRecordstatus());
		h.put("sumpayusd", getSumpayusd());
		h.put("paypos", new Integer(getPaypos()));
		h.put("sumfreerur", getSumfreerur());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localChangeneedpay = (java.lang.String) h.get("changeneedpay");
		java.lang.String localPayPurpose = (java.lang.String) h.get("payPurpose");
		Boolean localByhand = (Boolean) h.get("byhand");
		java.lang.Integer localResource = (java.lang.Integer) h.get("resource");
		java.lang.String localPaynumber = (java.lang.String) h.get("paynumber");
		java.lang.String localPymtype = (java.lang.String) h.get("pymtype");
		java.math.BigDecimal localSumnrirur = (java.math.BigDecimal) h.get("sumnrirur");
		java.sql.Date localPaydate = (java.sql.Date) h.get("paydate");
		java.lang.String localTypename = (java.lang.String) h.get("typename");
		java.math.BigDecimal localSumfreeusd = (java.math.BigDecimal) h.get("sumfreeusd");
		java.lang.Short localBen = (java.lang.Short) h.get("ben");
		java.math.BigDecimal localSumpayrur = (java.math.BigDecimal) h.get("sumpayrur");
		Boolean localNeedpay = (Boolean) h.get("needpay");
		java.math.BigDecimal localSumnriusd = (java.math.BigDecimal) h.get("sumnriusd");
		Boolean localFlagworknri = (Boolean) h.get("flagworknri");
		java.lang.String localRecordstatus = (java.lang.String) h.get("recordstatus");
		java.math.BigDecimal localSumpayusd = (java.math.BigDecimal) h.get("sumpayusd");
		java.math.BigDecimal localSumfreerur = (java.math.BigDecimal) h.get("sumfreerur");

		if (h.containsKey("changeneedpay"))
			setChangeneedpay((localChangeneedpay));
		if (h.containsKey("payPurpose"))
			setPayPurpose((localPayPurpose));
		if (h.containsKey("byhand"))
			setByhand((localByhand).booleanValue());
		if (h.containsKey("resource"))
			setResource((localResource));
		if (h.containsKey("paynumber"))
			setPaynumber((localPaynumber));
		if (h.containsKey("pymtype"))
			setPymtype((localPymtype));
		if (h.containsKey("sumnrirur"))
			setSumnrirur((localSumnrirur));
		if (h.containsKey("paydate"))
			setPaydate((localPaydate));
		if (h.containsKey("typename"))
			setTypename((localTypename));
		if (h.containsKey("sumfreeusd"))
			setSumfreeusd((localSumfreeusd));
		if (h.containsKey("ben"))
			setBen((localBen));
		if (h.containsKey("sumpayrur"))
			setSumpayrur((localSumpayrur));
		if (h.containsKey("needpay"))
			setNeedpay((localNeedpay).booleanValue());
		if (h.containsKey("sumnriusd"))
			setSumnriusd((localSumnriusd));
		if (h.containsKey("flagworknri"))
			setFlagworknri((localFlagworknri).booleanValue());
		if (h.containsKey("recordstatus"))
			setRecordstatus((localRecordstatus));
		if (h.containsKey("sumpayusd"))
			setSumpayusd((localSumpayusd));
		if (h.containsKey("sumfreerur"))
			setSumfreerur((localSumfreerur));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getLeaseabonentbanLink());
	links.addElement(getLeaseAbonentDNOPsLink());
	links.addElement(getAbonPays2docposesLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	leaseabonentbanLink = null;
	leaseAbonentDNOPsLink = null;
	abonPays2docposesLink = null;
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
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAbonPays2docposes(com.hps.july.persistence.AbonPays2docpos anAbonPays2docposes) throws java.rmi.RemoteException {
	this.getAbonPays2docposesLink().addElement(anAbonPays2docposes);
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseAbonentDNOPs(com.hps.july.persistence.LeaseAbonentDNOP aLeaseAbonentDNOPs) throws java.rmi.RemoteException {
	this.getLeaseAbonentDNOPsLink().addElement(aLeaseAbonentDNOPs);
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
 * @param argPaypos int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argPaypos, int argLeaseDocument, boolean argNeedPay, 
		java.math.BigDecimal argSumPayUSD, boolean argByHand, boolean argFlagWorkNRI, 
		String argRecordStatus, java.sql.Date argPayDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	paypos = argPaypos;
	leaseabonentban_leaseDocument = new Integer(argLeaseDocument);
	needpay = argNeedPay;
	sumpayusd = argSumPayUSD;
	byhand = argByHand;
	flagworknri = argFlagWorkNRI;
	recordstatus = argRecordStatus;
	typename = null;
	sumpayrur = null;
	sumnrirur = null;
	sumnriusd = null;
	sumfreerur = null;
	sumfreeusd = null;
	resource = null;
	paydate = argPayDate;
	paynumber = null;
	changeneedpay = "A";
	setPayPurpose(null);
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
 * @param argPaypos int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argPaypos) throws java.rmi.RemoteException {}
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
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAbonPays2docposes() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAbonPays2docposesLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAbonPays2docposesLink() {
	if (abonPays2docposesLink == null)
		abonPays2docposesLink = new AbonentPaymentToAbonPays2docposesLink(this);
	return abonPays2docposesLink;
}
/**
 * Getter method for ben
 */
public java.lang.Short getBen() {
	return ben;
}
/**
 * Getter method for byhand
 * @return boolean
 */
public boolean getByhand() {
	return byhand;
}
/**
 * Getter method for changeneedpay
 */
public java.lang.String getChangeneedpay() {
	return changeneedpay;
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
 * @return boolean
 */
public boolean getFlagworknri() {
	return flagworknri;
}
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseAbonentBAN getLeaseabonentban() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.LeaseAbonentBAN)this.getLeaseabonentbanLink().value();
}
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getLeaseabonentbanKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean leaseabonentban_NULLTEST = true;
	leaseabonentban_NULLTEST &= (leaseabonentban_leaseDocument == null);
	temp.leaseDocument = ((leaseabonentban_leaseDocument == null) ? 0 : leaseabonentban_leaseDocument.intValue());
	if (leaseabonentban_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getLeaseabonentbanLink() {
	if (leaseabonentbanLink == null)
		leaseabonentbanLink = new AbonentPaymentToLeaseabonentbanLink(this);
	return leaseabonentbanLink;
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseAbonentDNOPs() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseAbonentDNOPsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseAbonentDNOPsLink() {
	if (leaseAbonentDNOPsLink == null)
		leaseAbonentDNOPsLink = new AbonentPaymentToLeaseAbonentDNOPsLink(this);
	return leaseAbonentDNOPsLink;
}
/**
 * Getter method for needpay
 * @return boolean
 */
public boolean getNeedpay() {
	return needpay;
}
/**
 * Getter method for paydate
 */
public java.sql.Date getPaydate() {
	return paydate;
}
/**
 * Getter method for paynumber
 */
public java.lang.String getPaynumber() {
	return paynumber;
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2003 16:25:25)
 * @return int
 */
public int getPaypos() {
	return paypos;
}
/**
 * Getter method for pymtype
 */
public java.lang.String getPymtype() {
	return pymtype;
}
/**
 * Getter method for recordstatus
 * @return java.lang.String
 */
public java.lang.String getRecordstatus() {
	return recordstatus;
}
/**
 * Getter method for resource
 * @return java.lang.Integer
 */
public java.lang.Integer getResource() {
	return resource;
}
/**
 * Getter method for sumfreerur
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumfreerur() {
	return sumfreerur;
}
/**
 * Getter method for sumfreeusd
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumfreeusd() {
	return sumfreeusd;
}
/**
 * Getter method for sumnrirur
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumnrirur() {
	return sumnrirur;
}
/**
 * Getter method for sumnriusd
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumnriusd() {
	return sumnriusd;
}
/**
 * Getter method for sumpayrur
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumpayrur() {
	return sumpayrur;
}
/**
 * Getter method for sumpayusd
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumpayusd() {
	return sumpayusd;
}
/**
 * Getter method for typename
 * @return java.lang.String
 */
public java.lang.String getTypename() {
	return typename;
}
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetLeaseabonentbanKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean leaseabonentban_NULLTEST = (inKey == null);
	if (leaseabonentban_NULLTEST) leaseabonentban_leaseDocument = null; else leaseabonentban_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAbonPays2docposes(com.hps.july.persistence.AbonPays2docpos anAbonPays2docposes) {
	this.getAbonPays2docposesLink().secondaryAddElement(anAbonPays2docposes);
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseAbonentDNOPs(com.hps.july.persistence.LeaseAbonentDNOP aLeaseAbonentDNOPs) {
	this.getLeaseAbonentDNOPsLink().secondaryAddElement(aLeaseAbonentDNOPs);
}
/**
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAbonPays2docposes(com.hps.july.persistence.AbonPays2docpos anAbonPays2docposes) {
	this.getAbonPays2docposesLink().secondaryRemoveElement(anAbonPays2docposes);
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseAbonentDNOPs(com.hps.july.persistence.LeaseAbonentDNOP aLeaseAbonentDNOPs) {
	this.getLeaseAbonentDNOPsLink().secondaryRemoveElement(aLeaseAbonentDNOPs);
}
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetLeaseabonentban(com.hps.july.persistence.LeaseAbonentBAN aLeaseabonentban) throws java.rmi.RemoteException {
	this.getLeaseabonentbanLink().secondarySet(aLeaseabonentban);
}
/**
 * Setter method for ben
 */
public void setBen(java.lang.Short newValue) {
	this.ben = newValue;
}
/**
 * Setter method for byhand
 * @param newValue boolean
 */
public void setByhand(boolean newValue) {
	this.byhand = newValue;
}
/**
 * Setter method for changeneedpay
 */
public void setChangeneedpay(java.lang.String newValue) {
	this.changeneedpay = newValue;
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
 * @param newValue boolean
 */
public void setFlagworknri(boolean newValue) {
	this.flagworknri = newValue;
}
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setLeaseabonentban(com.hps.july.persistence.LeaseAbonentBAN aLeaseabonentban) throws java.rmi.RemoteException {
	this.getLeaseabonentbanLink().set(aLeaseabonentban);
}
/**
 * Setter method for needpay
 * @param newValue boolean
 */
public void setNeedpay(boolean newValue) {
	this.needpay = newValue;
}
/**
 * Setter method for paydate
 */
public void setPaydate(java.sql.Date newValue) {
	this.paydate = newValue;
}
/**
 * Setter method for paynumber
 */
public void setPaynumber(java.lang.String newValue) {
	this.paynumber = newValue;
}
/**
 * Setter method for pymtype
 */
public void setPymtype(java.lang.String newValue) {
	this.pymtype = newValue;
}
/**
 * Setter method for recordstatus
 * @param newValue java.lang.String
 */
public void setRecordstatus(java.lang.String newValue) {
	this.recordstatus = newValue;
}
/**
 * Setter method for resource
 * @param newValue java.lang.Integer
 */
public void setResource(java.lang.Integer newValue) {
	this.resource = newValue;
}
/**
 * Setter method for sumfreerur
 * @param newValue java.math.BigDecimal
 */
public void setSumfreerur(java.math.BigDecimal newValue) {
	this.sumfreerur = newValue;
}
/**
 * Setter method for sumfreeusd
 * @param newValue java.math.BigDecimal
 */
public void setSumfreeusd(java.math.BigDecimal newValue) {
	this.sumfreeusd = newValue;
}
/**
 * Setter method for sumnrirur
 * @param newValue java.math.BigDecimal
 */
public void setSumnrirur(java.math.BigDecimal newValue) {
	this.sumnrirur = newValue;
}
/**
 * Setter method for sumnriusd
 * @param newValue java.math.BigDecimal
 */
public void setSumnriusd(java.math.BigDecimal newValue) {
	this.sumnriusd = newValue;
}
/**
 * Setter method for sumpayrur
 * @param newValue java.math.BigDecimal
 */
public void setSumpayrur(java.math.BigDecimal newValue) {
	this.sumpayrur = newValue;
}
/**
 * Setter method for sumpayusd
 * @param newValue java.math.BigDecimal
 */
public void setSumpayusd(java.math.BigDecimal newValue) {
	this.sumpayusd = newValue;
}
/**
 * Setter method for typename
 * @param newValue java.lang.String
 */
public void setTypename(java.lang.String newValue) {
	this.typename = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: payPurpose
	 */
	public java.lang.String getPayPurpose() {
		return payPurpose;
	}
	/**
	 * Set accessor for persistent attribute: payPurpose
	 */
	public void setPayPurpose(java.lang.String newPayPurpose) {
		payPurpose = newPayPurpose;
	}
}
