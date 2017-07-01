package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ����� ������������ ����� � �������
 */
public class LeaseAbonentDNOPBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public boolean flagworknri;
	public int idabonentdnop;
	public String recordstatus;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.math.BigDecimal sumlinkusd;
	public java.lang.Integer abonentbill_leasebill;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink abonentbillLink = null;
	public java.lang.Integer abonentpayment_paypos;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink abonentpaymentLink = null;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("idabonentdnop", new Integer(getIdabonentdnop()));
        h.put("abonentbillKey", getAbonentbillKey());
        h.put("recordstatus", getRecordstatus());
        h.put("flagworknri", new Boolean(getFlagworknri()));
        h.put("abonentpaymentKey", getAbonentpaymentKey());
        h.put("sumlinkusd", getSumlinkusd());
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        java.lang.String localRecordstatus = (java.lang.String) h.get("recordstatus");
        Boolean localFlagworknri = (Boolean) h.get("flagworknri");
        java.math.BigDecimal localSumlinkusd = (java.math.BigDecimal) h.get("sumlinkusd");

        if ( h.containsKey("recordstatus") )
            setRecordstatus((localRecordstatus));
        if ( h.containsKey("flagworknri") )
            setFlagworknri((localFlagworknri).booleanValue());
        if ( h.containsKey("sumlinkusd") )
            setSumlinkusd((localSumlinkusd));

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getAbonentbillLink());
	links.addElement(getAbonentpaymentLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	abonentbillLink = null;
	abonentpaymentLink = null;
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
 * @param argIdabonentdnop int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argIdabonentdnop, int argLeaseBill, int argPayPos, 
		java.math.BigDecimal argSumLinkUSD, boolean argFlagWorkNRI, String argRecordStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	idabonentdnop = argIdabonentdnop;
	abonentbill_leasebill = new Integer(argLeaseBill);
	abonentpayment_paypos = new Integer(argPayPos);
	sumlinkusd = argSumLinkUSD;
	flagworknri = argFlagWorkNRI;
	recordstatus = argRecordStatus;
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
 * @param argIdabonentdnop int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argIdabonentdnop) throws java.rmi.RemoteException {}
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
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.AbonentBill getAbonentbill() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.AbonentBill)this.getAbonentbillLink().value();
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.AbonentBillKey getAbonentbillKey() {
	com.hps.july.persistence.AbonentBillKey temp = null;
	temp = new com.hps.july.persistence.AbonentBillKey();
	boolean abonentbill_NULLTEST = true;
	abonentbill_NULLTEST &= (abonentbill_leasebill == null);
	temp.leasebill = ((abonentbill_leasebill == null) ? 0 : abonentbill_leasebill.intValue());
	if (abonentbill_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getAbonentbillLink() {
	if (abonentbillLink == null)
		abonentbillLink = new LeaseAbonentDNOPToAbonentbillLink(this);
	return abonentbillLink;
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.AbonentPayment getAbonentpayment() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.AbonentPayment)this.getAbonentpaymentLink().value();
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.AbonentPaymentKey getAbonentpaymentKey() {
	com.hps.july.persistence.AbonentPaymentKey temp = null;
	temp = new com.hps.july.persistence.AbonentPaymentKey();
	boolean abonentpayment_NULLTEST = true;
	abonentpayment_NULLTEST &= (abonentpayment_paypos == null);
	temp.paypos = ((abonentpayment_paypos == null) ? 0 : abonentpayment_paypos.intValue());
	if (abonentpayment_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getAbonentpaymentLink() {
	if (abonentpaymentLink == null)
		abonentpaymentLink = new LeaseAbonentDNOPToAbonentpaymentLink(this);
	return abonentpaymentLink;
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
 * Insert the method's description here.
 * Creation date: (31.01.2003 9:40:46)
 * @return int
 */
public int getIdabonentdnop() {
	return idabonentdnop;
}
/**
 * Getter method for recordstatus
 * @return java.lang.String
 */
public java.lang.String getRecordstatus() {
	return recordstatus;
}
/**
 * Getter method for sumlinkusd
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumlinkusd() {
	return sumlinkusd;
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetAbonentbillKey(com.hps.july.persistence.AbonentBillKey inKey) {
	boolean abonentbill_NULLTEST = (inKey == null);
	if (abonentbill_NULLTEST) abonentbill_leasebill = null; else abonentbill_leasebill = (new Integer(inKey.leasebill));
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetAbonentpaymentKey(com.hps.july.persistence.AbonentPaymentKey inKey) {
	boolean abonentpayment_NULLTEST = (inKey == null);
	if (abonentpayment_NULLTEST) abonentpayment_paypos = null; else abonentpayment_paypos = (new Integer(inKey.paypos));
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetAbonentbill(com.hps.july.persistence.AbonentBill anAbonentbill) throws java.rmi.RemoteException {
	this.getAbonentbillLink().secondarySet(anAbonentbill);
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetAbonentpayment(com.hps.july.persistence.AbonentPayment anAbonentpayment) throws java.rmi.RemoteException {
	this.getAbonentpaymentLink().secondarySet(anAbonentpayment);
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setAbonentbill(com.hps.july.persistence.AbonentBill anAbonentbill) throws java.rmi.RemoteException {
	this.getAbonentbillLink().set(anAbonentbill);
}
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setAbonentpayment(com.hps.july.persistence.AbonentPayment anAbonentpayment) throws java.rmi.RemoteException {
	this.getAbonentpaymentLink().set(anAbonentpayment);
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
 * Setter method for recordstatus
 * @param newValue java.lang.String
 */
public void setRecordstatus(java.lang.String newValue) {
	this.recordstatus = newValue;
}
/**
 * Setter method for sumlinkusd
 * @param newValue java.math.BigDecimal
 */
public void setSumlinkusd(java.math.BigDecimal newValue) {
	this.sumlinkusd = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
