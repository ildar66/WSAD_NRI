package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Шапка документа "Акт монтажа АФС"
 */
public class AfsMountActBean extends InternalWayBillBean {
	private final static long serialVersionUID = 3206093459760846163L;
	public String afstype;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("afstype", getAfstype());
		h.put("positionKey", getPositionKey());
		h.put("monterKey", getMonterKey());
		h.put("fixing", getFixing());
		h.put("blankindex", new Integer(getBlankindex()));
		h.put("parentdocument", getParentdocument());
		h.put("blanknumber", getBlanknumber());
		h.put("operator", getOperator());
		h.put("toKey", getToKey());
		h.put("processDestination", getProcessDestination());
		h.put("fromKey", getFromKey());
		h.put("projectid", getProjectid());
		h.put("showtouser", new Boolean(getShowtouser()));
		h.put("contragentKey", getContragentKey());
		h.put("storageManagerKey", getStorageManagerKey());
		h.put("document", new Integer(getDocument()));
		h.put("insuranceact", getInsuranceact());
		h.put("prjstatus", getPrjstatus());
		h.put("isautodoc", new Boolean(getIsautodoc()));
		h.put("blankdate", getBlankdate());
		h.put("documentState", getDocumentState());
		h.put("ownerKey", getOwnerKey());
		h.put("to2", getTo2());
		h.put("processSource", getProcessSource());
		h.put("insuranseMan", getInsuranseMan());
		h.put("insurancedate", getInsurancedate());
		h.put("needapprove", new Boolean(getNeedapprove()));
		h.put("visualtype", getVisualtype());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localAfstype = (java.lang.String) h.get("afstype");
		java.lang.Boolean localFixing = (java.lang.Boolean) h.get("fixing");
		Integer localBlankindex = (Integer) h.get("blankindex");
		java.lang.Integer localParentdocument =
			(java.lang.Integer) h.get("parentdocument");
		java.lang.String localBlanknumber =
			(java.lang.String) h.get("blanknumber");
		java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
		java.lang.Boolean localProcessDestination =
			(java.lang.Boolean) h.get("processDestination");
		java.lang.Integer localProjectid =
			(java.lang.Integer) h.get("projectid");
		Boolean localShowtouser = (Boolean) h.get("showtouser");
		Integer localDocument = (Integer) h.get("document");
		java.lang.String localInsuranceact =
			(java.lang.String) h.get("insuranceact");
		java.lang.String localPrjstatus = (java.lang.String) h.get("prjstatus");
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
		java.lang.Integer localVisualtype =
			(java.lang.Integer) h.get("visualtype");

		if (h.containsKey("afstype"))
			setAfstype((localAfstype));
		if (h.containsKey("fixing"))
			setFixing((localFixing));
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
		if (h.containsKey("projectid"))
			setProjectid((localProjectid));
		if (h.containsKey("showtouser"))
			setShowtouser((localShowtouser).booleanValue());
		if (h.containsKey("document"))
			setDocument((localDocument).intValue());
		if (h.containsKey("insuranceact"))
			setInsuranceact((localInsuranceact));
		if (h.containsKey("prjstatus"))
			setPrjstatus((localPrjstatus));
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
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, 
		int argBlankindex, String argBlankNumber, String argState, Boolean argProcessSource, Boolean argProcessDestination, Boolean argFixing ) throws javax.ejb.CreateException, java.rmi.RemoteException {
			
	super.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, 
		argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination, argFixing );
	
	afstype = "O";
}
/**
 * Getter method for afstype
 */
public java.lang.String getAfstype() {
	return afstype;
}
/**
 * Setter method for afstype
 */
public void setAfstype(java.lang.String newValue) {
	this.afstype = newValue;
}
}
