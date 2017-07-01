package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.Enumeration;
import java.util.Calendar;
import java.util.Vector;

/**
 * ‘орма ввода и редактировани€ шапки документа "¬нешн€€ расходна€ накладна€"
 */
public class ExternalRForm extends DocumentForm {
	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	
	
	private StringAndSqlDateProperty blankdate;
	
	private StringAndIntegerProperty req;
	private StringAndIntegerProperty currency; // -> Currency
	private String currencyname;
	private String reqnum;
	private String reqdate;
	
	private StringAndIntegerProperty owner;
	private String ownername;
	
	private StringAndIntegerProperty storage;
	private String storagename;

	private StringAndIntegerProperty recipient;
	private String recipientname;

	private String insuranseMan;

	private String insuranceact;

	private StringAndSqlDateProperty insurancedate;
	
	private String dState;

	private StringAndIntegerProperty storageman; 
	private String storagemanname;
	private String storagemantitle;

	private StringAndIntegerProperty document;
	private StringAndIntegerProperty expedition;

	private Boolean fixing;
public ExternalRForm() {
	blanknumber = "";
	blankindex = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	document = new StringAndIntegerProperty();
	dState = "1";
	expedition = new StringAndIntegerProperty();
	insuranceact = "";
	insurancedate = new StringAndSqlDateProperty();
	insuranseMan = "";
	owner = new StringAndIntegerProperty();
	ownername = "";
	recipient = new StringAndIntegerProperty();
	recipientname = "";	
	req = new StringAndIntegerProperty();
	reqnum = "";
	reqdate = "";
	storage = new StringAndIntegerProperty();
	storagename = "";
	storageman = new StringAndIntegerProperty();
	storagemanname = "";
	storagemantitle = "";
	fixing = Boolean.FALSE;
	currency = new StringAndIntegerProperty();
	currencyname = "";
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	super.afterUpdate(bean,request); // Support for document calculation
	if("Add".equals(getAction())) {
		setAction("Edit");
	}
}
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	OutWayBillAccessBean ab = (OutWayBillAccessBean)bean;
	ExpeditionAccessBean exp = null;

	try {
		exp = findExpedition();
	} catch(Exception e) {
		exp = constructExpedition();
	}
	ab.setTo((Expedition)exp.getEJBRef());
	ab.setProcessDestination(Boolean.FALSE);
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setDocument(keyGen.getNextKey("tables.documents"));
	OutWayBillAccessBean bean = new OutWayBillAccessBean(
		getDocument(),
		owner.getInteger(),
		storage.getInteger(), // from
		null, // to
		blankdate.getSqlDate(),
		getBlankindex(), 
		blanknumber,
		"1",
		currency.getInteger().intValue(),
		Boolean.TRUE,
		Boolean.FALSE
	);
	return bean;
}
public ExpeditionAccessBean constructExpedition() throws Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	ExpeditionAccessBean exp = new ExpeditionAccessBean(
		keyGen.getNextKey("tables.storageplaces"), null, "", ""
	);
	OrganizationAccessBean o = new OrganizationAccessBean();
	o.setInitKey_organization(recipient.getInteger().intValue());
	o.refreshCopyHelper();
	exp.setOrganization((Organization)o.getEJBRef());
	exp.setExpeditor(null);
	exp.setName(o.getName());
	exp.commitCopyHelper();
	return exp;
}
public WorkerAccessBean constructStorageManager() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(storageman.getInteger().intValue());
	bean.refreshCopyHelper();
	setStoragemanname(bean.getMan().getFullName());
	setStoragemantitle(bean.getPosition().getName());
	return bean;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	OutWayBillAccessBean ab = (OutWayBillAccessBean)bean;
	try {
		OrganizationAccessBean o = ab.getOwner();
		if(o != null) {
			owner.setInteger(new Integer(o.getOrganization()));
			ownername = o.getName();
		}
		o = ab.getContragent();
		if(o != null) {
			recipient.setInteger(new Integer(o.getOrganization()));
			recipientname = o.getName();
		}
		StoragePlaceAccessBean s = ab.getFrom();
		if(s != null) {
			storage.setInteger(new Integer(s.getStorageplace()));
			storagename = s.getName();
		}
		WorkerAccessBean w = ab.getStorageManager();
		if(w != null) {
			storageman.setInteger(new Integer(w.getWorker()));
			storagemanname = w.getMan().getFullName();
			storagemantitle = w.getPosition().getName();
		}
		CurrencyAccessBean c = ab.getCurrency();
		if(c != null) {
			currency.setInteger(new Integer(c.getCurrency()));
			currencyname = c.getName();
		}
	} catch(Exception e) {
	}
}
public ExpeditionAccessBean findExpedition() throws java.lang.Exception {
	ExpeditionAccessBean fexp = new ExpeditionAccessBean();
	Enumeration en;
	ExpeditionAccessBean exp;
	en = fexp.findExpeditionByOrganization(new OrganizationKey(recipient.getInteger().intValue()));
	if(en.hasMoreElements()) {
		ExpeditionAccessBean e = (ExpeditionAccessBean)en.nextElement();
		e.refreshCopyHelper();
		exp = new ExpeditionAccessBean();
		exp.setInitKey_storageplace(e.getStorageplace());
		exp.refreshCopyHelper();
	} else {
		throw new Exception();
	}
	/*
	if(en.hasMoreElements()) {
		throw new Exception("error.update.externalr.expedition");
	}
	*/
	return exp;
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public java.sql.Date getBlankdate() {
	return blankdate.getSqlDate();
}
public String getBlankdatestr() {
	return blankdate.getString();
}
public int getBlankindex() {
	if(!blankindex.isEmpty() && blankindex.isOk())
		return blankindex.getInteger().intValue();
	else
		return 0;
}
public String getBlankindexFrm() {
	return blankindex.getString();
}
public String getBlanknumber() {
	return blanknumber;
}
public Organization getContragent() {
	if(!recipient.isEmpty() && recipient.isOk()) {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(recipient.getInteger().intValue());
			bean.refreshCopyHelper();
			return (Organization)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
public Enumeration getCurrencies() {
	try {
		CurrencyAccessBean bean = new CurrencyAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
public Currency getCurrency() {
	if(!currency.isEmpty() && currency.isOk()) {
		try {
			CurrencyAccessBean bean = new CurrencyAccessBean();
			bean.setInitKey_currency(currency.getInteger().intValue());
			bean.refreshCopyHelper();
			return (Currency)bean.getEJBRef();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	return null;
}
public String getCurrencycode() {
	return currency.getString();
}
public String getCurrencyname() {
	return currencyname;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	OutWayBillAccessBean bean = new OutWayBillAccessBean();
	bean.setInitKey_document(getDocument());
	return bean;
}
public int getDocument() {
	if(document.getInteger() != null)
		return document.getInteger().intValue();
	else
		return 0;
}
public Integer getDocumentId() {
	return document.getInteger();
}
public String getDocumentstr() {
	return document.getString();
}
public java.lang.String getdState() {
	try{
		OutWayBillAccessBean bean = new OutWayBillAccessBean();
		bean.setInitKey_document(getDocument());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return "1";
	}
}
public java.lang.String getDState() {
	try{
		OutWayBillAccessBean bean = new OutWayBillAccessBean();
		bean.setInitKey_document(getDocument());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return "1";
	}
}
public String getExpeditionstr() {
	return expedition.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:44:20)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getFixing() {
	return fixing;
}
public StoragePlace getFrom() {
	if(!storage.isEmpty() && storage.isOk()) {
		try {
			StorageAccessBean bean = new StorageAccessBean();
			bean.setInitKey_storageplace(storage.getInteger().intValue());
			bean.refreshCopyHelper();
			return (StoragePlace)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @return java.lang.String
 */
public java.lang.String getInsuranceact() {
	return insuranceact;
}
public java.sql.Date getInsurancedate() {
	return insurancedate.getSqlDate();
}
public String getInsurancedatestr() {
	return insurancedate.getString();
}
public java.lang.String getInsuranseMan() {
	return insuranseMan;
}
public java.util.ListIterator getListItems() {
	com.hps.july.cdbc.objects.CDBCDocuments c = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = c.listExternalStorageOutItems(getDocumentId(),new Integer(1));
	return rs.listIterator();
}
public Organization getOwner() {
	if(!owner.isEmpty() && owner.isOk()) {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(owner.getInteger().intValue());
			bean.refreshCopyHelper();
			return (Organization)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
public String getOwnercode() {
	return owner.getString();
}
public Integer getOwnerId() {
	return owner.getInteger();
}
public String getOwnername() {
	return owner.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 11:40:25)
 * @return java.util.Enumeration
 */
public Enumeration getOwners() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new Vector()).elements();
	}
}
public String getRecipientcode() {
	return recipient.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 15:54:35)
 * @return java.lang.String
 */
public java.lang.String getRecipientname() {
	return recipientname;
}
public String getReqcode() {
	return req.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 12:05:12)
 * @return java.lang.String
 */
public java.lang.String getReqdate() {
	return reqdate;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 12:05:12)
 * @return java.lang.String
 */
public java.lang.String getReqnum() {
	return reqnum;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITEOR;
}
public String getStoragecode() {
	return storage.getString();
}
public Integer getStorageId() {
	return storage.getInteger();
}
public Worker getStorageManager() {
	try {
		return (Worker)constructStorageManager().getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
public String getStoragemancode() {
	return storageman.getString();
}
public String getStoragemanname() {
	return storagemanname;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 17:17:14)
 * @return java.lang.String
 */
public java.lang.String getStoragemantitle() {
	return storagemantitle;
}
public String getStoragename() {
	return storagename;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.initRecord(request);
	blanknumber = "";
	blankindex = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	document = new StringAndIntegerProperty();
	dState = "1";
	expedition = new StringAndIntegerProperty();
	insuranceact = "";
	insurancedate = new StringAndSqlDateProperty();
	insuranseMan = "";
	owner = new StringAndIntegerProperty();
	ownername = "";
	recipient = new StringAndIntegerProperty();
	recipientname = "";	
	req = new StringAndIntegerProperty();
	reqnum = "";
	reqdate = "";
	storage = new StringAndIntegerProperty();
	storagename = "";
	storageman = new StringAndIntegerProperty();
	storagemanname = "";
	storagemantitle = "";
	fixing = Boolean.FALSE;
	currency = new StringAndIntegerProperty();
	currencyname = "";

	ExternalRListForm aform = (ExternalRListForm)request.getSession().getAttribute("ExternalRListForm");

	setBlankindexFrm("");
	
	if(aform.getDateto() != null) {
		setBlankdate(aform.getDateto());
	}

	if(Boolean.FALSE.equals(aform.getIsowner())) {
		setOwnercode(aform.getOwnercode());
		setOwnername(aform.getOwnername());
	}

	if(Boolean.FALSE.equals(aform.getIsstorage())) {
		setStoragecode(aform.getStoragecode());
		storagename = aform.getStoragename();
	}

	if(Boolean.FALSE.equals(aform.getIsrecipient())) {
		setRecipientcode(aform.getRecipientcode());
		setRecipientname(aform.getRecipientname());
	}
}
public void setBlankdate(java.sql.Date newDate) {
	blankdate.setSqlDate(newDate);
}
public void setBlankdatestr(String newBlankdate) {
	blankdate.setString(newBlankdate);
}
public void setBlankindex(int newBlankindex) {
	blankindex.setInteger(new Integer(newBlankindex));
}
public void setBlankindexFrm(String newBlankindex) {
	blankindex.setString(newBlankindex);
}
public void setBlanknumber(String newNumber) {
	blanknumber = newNumber;
}
public void setCurrencycode(String newNumber) {
	currency.setString(newNumber);
}
public void setCurrencyname(String newName) {
	currencyname = newName;
}
public void setDocument(int newDocument) {
	document.setInteger(new Integer(newDocument));
}
public void setDocumentstr(String newDocument) {
	document.setString(newDocument);
}
public void setExpeditionstr(String newDocument) {
	expedition.setString(newDocument);
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:44:20)
 * @param newFixing java.lang.Boolean
 */
public void setFixing(java.lang.Boolean newFixing) {
	fixing = newFixing;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @param newInsuranceact java.lang.String
 */
public void setInsuranceact(java.lang.String newInsuranceact) {
	insuranceact = newInsuranceact;
}
public void setInsurancedate(java.sql.Date newDate) {
	insurancedate.setSqlDate(newDate);
}
public void setInsurancedatestr(String newDate) {
	insurancedate.setString(newDate);
}
public void setInsuranseMan(java.lang.String newInsuranseMan) {
	insuranseMan = newInsuranseMan;
}
public void setOwnercode(String newNumber) {
	owner.setString(newNumber);
}
public void setOwnername(String newName) {
	ownername = newName;
}
public void setRecipientcode(java.lang.String newRecipient) {
	recipient.setString(newRecipient);
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 15:54:35)
 * @param newRecipientname java.lang.String
 */
public void setRecipientname(java.lang.String newRecipientname) {
	recipientname = newRecipientname;
}
public void setReqcode(String newReq) {
	req.setString(newReq);
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 12:05:12)
 * @param newReqdate java.lang.String
 */
public void setReqdate(java.lang.String newReqdate) {
	reqdate = newReqdate;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 12:05:12)
 * @param newReqnum java.lang.String
 */
public void setReqnum(java.lang.String newReqnum) {
	reqnum = newReqnum;
}
public void setStoragecode(String newNumber) {
	storage.setString(newNumber);
}
public void setStoragemancode(String newNumber) {
	storageman.setString(newNumber);
}
public void setStoragemanname(String newName) {
	storagemanname = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 17:17:14)
 * @param newStoragemantitle java.lang.String
 */
public void setStoragemantitle(java.lang.String newStoragemantitle) {
	storagemantitle = newStoragemantitle;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if("Edit".equals(getAction()) || "Delete".equals(getAction())) {
		if(document.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalr.document"));
		}
		else if(!document.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalr.document"));
		}
	}

	if(blankdate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalr.blankdate"));
	}
	else if(!blankdate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalr.blankdate"));
	}

	if(blanknumber != null && !"".equals(blanknumber)) {
		if(blanknumber.length() > 40) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.blanknumber"));
		}
	} else {
		blanknumber = "";
	}
	if(blankindex.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.empty"));
	} else if(!blankindex.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.invalid"));
	}

	if(blanknumber.trim().length() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.empty"));
	} 

	if(owner.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalr.owner"));
	}
	else if(!owner.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalr.owner"));
	}
	else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(owner.getInteger().intValue());
			bean.refreshCopyHelper();
			setOwnername(bean.getName());
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.externalr.owner"));
		}
	}

	if(storage.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalr.storage"));
	}
	else if(!storage.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalr.storage"));
	}
	else {
		try {
			StorageAccessBean bean = new StorageAccessBean();
			bean.setInitKey_storageplace(storage.getInteger().intValue());
			bean.refreshCopyHelper();
			storagename = bean.getName();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.externalr.storage"));
		}
	}

	if(recipient.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalr.recipient"));
	}
	else if(!recipient.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalr.recipient"));
	}
	else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(recipient.getInteger().intValue());
			bean.refreshCopyHelper();
			setRecipientname(bean.getName());
			/*
			if(Boolean.FALSE.equals(bean.getIs Isrenter())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalr.notrecipient"));
			}
			*/
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.externalr.renter"));
		}
	}

	if((insuranseMan == null) || ("".equals(insuranseMan))) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalr.insuranceman"));
	}
	if((insuranceact == null) || ("".equals(insuranceact))) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalr.insuranceact"));
	}

	if(insurancedate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalr.insurancedate"));
	} else if(!insurancedate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalr.insurancedate"));
	} else if(insurancedate.getSqlDate().after(blankdate.getSqlDate())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalr.insurancedateafter"));
	}
	
	if(!"1".equals(dState) && !"2".equals(dState)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalr.state"));
	}

	if(currency.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalr.currency"));
	}
	else if(!currency.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalr.currency"));
	}
	else {
		try {
			CurrencyAccessBean bean = new CurrencyAccessBean();
			bean.setInitKey_currency(currency.getInteger().intValue());
			bean.refreshCopyHelper();
			setCurrencyname(bean.getName());
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.externalr.currency"));
		}
	}

	if(storageman.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalr.storageman"));
	}
	else if(!storageman.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalr.storageman"));
	}
	else {
		try {
			constructStorageManager();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.externalr.storageman"));
		}
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
