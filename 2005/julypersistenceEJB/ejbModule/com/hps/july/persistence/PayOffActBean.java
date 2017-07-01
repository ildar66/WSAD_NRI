package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Шапка документа "Акт списания"
 */
public class PayOffActBean extends DocumentBean {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer chairMan_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink chairManLink = null;
	public java.lang.Integer member1_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink member1Link = null;
	public java.lang.Integer member2_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink member2Link = null;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("member1Key", getMember1Key());
		h.put("chairManKey", getChairManKey());
		h.put("member2Key", getMember2Key());
		h.put("blankindex", new Integer(getBlankindex()));
		h.put("parentdocument", getParentdocument());
		h.put("blanknumber", getBlanknumber());
		h.put("operator", getOperator());
		h.put("toKey", getToKey());
		h.put("processDestination", getProcessDestination());
		h.put("fromKey", getFromKey());
		h.put("showtouser", new Boolean(getShowtouser()));
		h.put("contragentKey", getContragentKey());
		h.put("storageManagerKey", getStorageManagerKey());
		h.put("document", new Integer(getDocument()));
		h.put("insuranceact", getInsuranceact());
		h.put("isautodoc", new Boolean(getIsautodoc()));
		h.put("blankdate", getBlankdate());
		h.put("documentState", getDocumentState());
		h.put("ownerKey", getOwnerKey());
		h.put("to2", getTo2());
		h.put("processSource", getProcessSource());
		h.put("insuranseMan", getInsuranseMan());
		h.put("insurancedate", getInsurancedate());
		h.put("needapprove", new Boolean(getNeedapprove()));
		h.put("projectid", getProjectid());
		h.put("prjstatus", getPrjstatus());
		h.put("visualtype", getVisualtype());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		Integer localBlankindex = (Integer) h.get("blankindex");
		java.lang.Integer localParentdocument =
			(java.lang.Integer) h.get("parentdocument");
		java.lang.String localBlanknumber =
			(java.lang.String) h.get("blanknumber");
		java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
		java.lang.Boolean localProcessDestination =
			(java.lang.Boolean) h.get("processDestination");
		Boolean localShowtouser = (Boolean) h.get("showtouser");
		Integer localDocument = (Integer) h.get("document");
		java.lang.String localInsuranceact =
			(java.lang.String) h.get("insuranceact");
		Boolean localIsautodoc = (Boolean) h.get("isautodoc");
		java.sql.Date localBlankdate = (java.sql.Date) h.get("blankdate");
		java.lang.String localDocumentState =
			(java.lang.String) h.get("documentState");
		java.lang.Integer localTo2 = (java.lang.Integer) h.get("to2");
		java.lang.Boolean localProcessSource =
			(java.lang.Boolean) h.get("processSource");
		java.lang.String localInsuranseMan =
			(java.lang.String) h.get("insuranseMan");
		java.sql.Date localInsurancedate =
			(java.sql.Date) h.get("insurancedate");
		Boolean localNeedapprove = (Boolean) h.get("needapprove");
		java.lang.Integer localProjectid =
			(java.lang.Integer) h.get("projectid");
		java.lang.String localPrjstatus = (java.lang.String) h.get("prjstatus");
		java.lang.Integer localVisualtype =
			(java.lang.Integer) h.get("visualtype");

		if (h.containsKey("blankindex"))
			setBlankindex((localBlankindex).intValue());
		if (h.containsKey("parentdocument"))
			setParentdocument((localParentdocument));
		if (h.containsKey("blanknumber"))
			setBlanknumber((localBlanknumber));
		if (h.containsKey("operator"))
			setOperator((localOperator));
		if (h.containsKey("processDestination"))
			setProcessDestination((localProcessDestination));
		if (h.containsKey("showtouser"))
			setShowtouser((localShowtouser).booleanValue());
		if (h.containsKey("document"))
			setDocument((localDocument).intValue());
		if (h.containsKey("insuranceact"))
			setInsuranceact((localInsuranceact));
		if (h.containsKey("isautodoc"))
			setIsautodoc((localIsautodoc).booleanValue());
		if (h.containsKey("blankdate"))
			setBlankdate((localBlankdate));
		if (h.containsKey("documentState"))
			setDocumentState((localDocumentState));
		if (h.containsKey("to2"))
			setTo2((localTo2));
		if (h.containsKey("processSource"))
			setProcessSource((localProcessSource));
		if (h.containsKey("insuranseMan"))
			setInsuranseMan((localInsuranseMan));
		if (h.containsKey("insurancedate"))
			setInsurancedate((localInsurancedate));
		if (h.containsKey("needapprove"))
			setNeedapprove((localNeedapprove).booleanValue());
		if (h.containsKey("projectid"))
			setProjectid((localProjectid));
		if (h.containsKey("prjstatus"))
			setPrjstatus((localPrjstatus));
		if (h.containsKey("visualtype"))
			setVisualtype((localVisualtype));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getChairManLink());
	links.addElement(getMember1Link());
	links.addElement(getMember2Link());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	chairManLink = null;
	member1Link = null;
	member2Link = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, 
		int argBlankindex, String argBlankNumber, String argState, Boolean argProcessSource, 
		Boolean argProcessDestination ) throws javax.ejb.CreateException, java.rmi.RemoteException {
			
	super.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, 
		argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination );
	
	_initLinks();
	// All CMP fields should be initialized here.
}
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getChairMan() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getChairManLink().value();
}
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getChairManKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean chairMan_NULLTEST = true;
	chairMan_NULLTEST &= (chairMan_worker == null);
	temp.worker = ((chairMan_worker == null) ? 0 : chairMan_worker.intValue());
	if (chairMan_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getChairManLink() {
	if (chairManLink == null)
		chairManLink = new PayOffActToChairManLink(this);
	return chairManLink;
}
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getMember1() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getMember1Link().value();
}
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getMember1Key() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean member1_NULLTEST = true;
	member1_NULLTEST &= (member1_worker == null);
	temp.worker = ((member1_worker == null) ? 0 : member1_worker.intValue());
	if (member1_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getMember1Link() {
	if (member1Link == null)
		member1Link = new PayOffActToMember1Link(this);
	return member1Link;
}
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getMember2() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getMember2Link().value();
}
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getMember2Key() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean member2_NULLTEST = true;
	member2_NULLTEST &= (member2_worker == null);
	temp.worker = ((member2_worker == null) ? 0 : member2_worker.intValue());
	if (member2_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getMember2Link() {
	if (member2Link == null)
		member2Link = new PayOffActToMember2Link(this);
	return member2Link;
}
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetChairManKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean chairMan_NULLTEST = (inKey == null);
	if (chairMan_NULLTEST) chairMan_worker = null; else chairMan_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetMember1Key(com.hps.july.persistence.WorkerKey inKey) {
	boolean member1_NULLTEST = (inKey == null);
	if (member1_NULLTEST) member1_worker = null; else member1_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetMember2Key(com.hps.july.persistence.WorkerKey inKey) {
	boolean member2_NULLTEST = (inKey == null);
	if (member2_NULLTEST) member2_worker = null; else member2_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetChairMan(com.hps.july.persistence.Worker aChairMan) throws java.rmi.RemoteException {
	this.getChairManLink().secondarySet(aChairMan);
}
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetMember1(com.hps.july.persistence.Worker aMember1) throws java.rmi.RemoteException {
	this.getMember1Link().secondarySet(aMember1);
}
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetMember2(com.hps.july.persistence.Worker aMember2) throws java.rmi.RemoteException {
	this.getMember2Link().secondarySet(aMember2);
}
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setChairMan(com.hps.july.persistence.Worker aChairMan) throws java.rmi.RemoteException {
	this.getChairManLink().set(aChairMan);
}
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setMember1(com.hps.july.persistence.Worker aMember1) throws java.rmi.RemoteException {
	this.getMember1Link().set(aMember1);
}
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setMember2(com.hps.july.persistence.Worker aMember2) throws java.rmi.RemoteException {
	this.getMember2Link().set(aMember2);
}
}
