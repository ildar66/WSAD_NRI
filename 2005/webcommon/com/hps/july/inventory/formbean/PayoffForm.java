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
 * Форма ввода и редактирования шапки документа "Акт списания"
 */
public class PayoffForm
	extends DocumentForm
{
	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	
	private StringAndSqlDateProperty blankdate;
	
	private StringAndIntegerProperty owner;
	private String ownername;
	
	private StringAndIntegerProperty storage;
	private String storagename;

	private StringAndIntegerProperty worker1;
	private String worker1name;
	private String worker1title;

	private StringAndIntegerProperty worker2;
	private String worker2name;
	private String worker2title;

	private StringAndIntegerProperty worker3;
	private String worker3name;
	private String worker3title;

	private StringAndIntegerProperty worker4;
	private String worker4name;
	private String worker4title;

	private String dState;

	private StringAndIntegerProperty document;
public PayoffForm() {
	blanknumber = "";
	blankindex = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	document = new StringAndIntegerProperty();
	dState = "1";
	owner = new StringAndIntegerProperty();
	ownername = "";
	storage = new StringAndIntegerProperty();
	storagename = "";
	worker1 = new StringAndIntegerProperty();
	worker1name = "";
	worker1title = "";
	worker2 = new StringAndIntegerProperty();
	worker2name = "";
	worker2title = "";
	worker3 = new StringAndIntegerProperty();
	worker3name = "";
	worker3title = "";
	worker4 = new StringAndIntegerProperty();
	worker4name = "";
	worker4title = "";
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
	super.beforeUpdate(bean, request);
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setDocument(keyGen.getNextKey("tables.documents"));

	PayOffActAccessBean bean = new PayOffActAccessBean(
		getDocument(),
		owner.getInteger(),
		storage.getInteger(),
		null,
		blankdate.getSqlDate(),
		getBlankindex(),
		blanknumber,
		"1",
		Boolean.TRUE,
		Boolean.FALSE
	);
	return bean;
}
public WorkerAccessBean constructWorker1() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(worker1.getInteger().intValue());
	bean.refreshCopyHelper();
	setWorker1name(bean.getMan().getFullName());
	setWorker1title(bean.getPosition().getName());
	return bean;
}
public WorkerAccessBean constructWorker2() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(worker2.getInteger().intValue());
	bean.refreshCopyHelper();
	setWorker2name(bean.getMan().getFullName());
	setWorker2title(bean.getPosition().getName());
	return bean;
}
public WorkerAccessBean constructWorker3() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(worker3.getInteger().intValue());
	bean.refreshCopyHelper();
	setWorker3name(bean.getMan().getFullName());
	setWorker3title(bean.getPosition().getName());
	return bean;
}
public WorkerAccessBean constructWorker4() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(worker4.getInteger().intValue());
	bean.refreshCopyHelper();
	setWorker4name(bean.getMan().getFullName());
	setWorker4title(bean.getPosition().getName());
	return bean;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	PayOffActAccessBean ab = (PayOffActAccessBean)bean;
	try {
		OrganizationAccessBean o = ab.getOwner();
		if(o != null) {
			owner.setInteger(new Integer(o.getOrganization()));
			ownername = o.getName();
		}
		StoragePlaceAccessBean s = ab.getFrom();
		if(s != null) {
			storage.setInteger(new Integer(s.getStorageplace()));
			storagename = s.getName();
		}
		WorkerAccessBean w = ab.getChairMan();
		if(w != null) {
			worker1.setInteger(new Integer(w.getWorker()));
			worker1name = w.getMan().getFullName();
			worker1title = w.getPosition().getName();
		}
		w = ab.getMember1();
		if(w != null) {
			worker2.setInteger(new Integer(w.getWorker()));
			worker2name = w.getMan().getFullName();
			worker2title = w.getPosition().getName();
		}
		w = ab.getMember2();
		if(w != null) {
			worker3.setInteger(new Integer(w.getWorker()));
			worker3name = w.getMan().getFullName();
			worker3title = w.getPosition().getName();
		}
		w = ab.getStorageManager();
		if(w != null) {
			worker4.setInteger(new Integer(w.getWorker()));
			worker4name = w.getMan().getFullName();
			worker4title = w.getPosition().getName();
		}
	} catch(Exception e) {
	}
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
public Worker getChairMan() {
	if(!owner.isEmpty() && owner.isOk()) {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(worker1.getInteger().intValue());
			bean.refreshCopyHelper();
			return (Worker)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	PayOffActAccessBean bean = new PayOffActAccessBean();
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
		PayOffActAccessBean bean = new PayOffActAccessBean();
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
		PayOffActAccessBean bean = new PayOffActAccessBean();
		bean.setInitKey_document(getDocument());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return "1";
	}
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
public java.util.ListIterator getListItems() {
	com.hps.july.cdbc.objects.CDBCDocuments c = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = c.listPayoffItems(new Integer(getDocument()),new Integer(1));
	return rs.listIterator();
}
public Worker getMember1() {
	if(!owner.isEmpty() && owner.isOk()) {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(worker2.getInteger().intValue());
			bean.refreshCopyHelper();
			return (Worker)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
public Worker getMember2() {
	if(!owner.isEmpty() && owner.isOk()) {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(worker3.getInteger().intValue());
			bean.refreshCopyHelper();
			return (Worker)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
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
public Integer getOwnerKey() {
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
public int getState() {
	return com.hps.july.inventory.APPStates.EDITPO;
}
public String getStoragecode() {
	return storage.getString();
}
public Integer getStorageKey() {
	return storage.getInteger();
}
public Worker getStorageManager() {
	if(!owner.isEmpty() && owner.isOk()) {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(worker4.getInteger().intValue());
			bean.refreshCopyHelper();
			return (Worker)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
public String getStoragename() {
	return storagename;
}
public StoragePlace getTo_() {
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
public java.lang.String getWorker1code() {
	return worker1.getString();
}
public java.lang.String getWorker1name() {
	return worker1name;
}
public java.lang.String getWorker1title() {
	return worker1title;
}
public java.lang.String getWorker2code() {
	return worker2.getString();
}
public java.lang.String getWorker2name() {
	return worker2name;
}
public java.lang.String getWorker2title() {
	return worker2title;
}
public java.lang.String getWorker3code() {
	return worker3.getString();
}
public java.lang.String getWorker3name() {
	return worker3name;
}
public java.lang.String getWorker3title() {
	return worker3title;
}
public java.lang.String getWorker4code() {
	return worker4.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 12:39:17)
 * @return java.lang.String
 */
public java.lang.String getWorker4name() {
	return worker4name;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 12:39:17)
 * @return java.lang.String
 */
public java.lang.String getWorker4title() {
	return worker4title;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.initRecord(request);
	setDocument(0);
	PayoffListForm aform = (PayoffListForm)request.getSession().getAttribute("PayoffListForm");
	
	if(aform.getDateto() != null) {
		setBlankdate(aform.getDateto());
	}

	if(Boolean.FALSE.equals(aform.getIsowner())) {
		setOwnercode(aform.getOwnercode());
		setOwnername(aform.getOwnername());
	}

	if(Boolean.FALSE.equals(aform.getIsstorage())) {
		setStoragecode(aform.getStoragecode());
	}

	storagename = aform.getStoragename();
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
public void setDocument(int newDocument) {
	document.setInteger(new Integer(newDocument));
}
public void setDocumentstr(String newDocument) {
	document.setString(newDocument);
}
public void setOwnercode(String newNumber) {
	owner.setString(newNumber);
}
public void setOwnername(String newName) {
	ownername = newName;
}
public void setStoragecode(String newNumber) {
	storage.setString(newNumber);
}
public void setWorker1code(java.lang.String newWorkercode) {
	worker1.setString(newWorkercode);
}
public void setWorker1name(java.lang.String newWorkername) {
	worker1name = newWorkername;
}
public void setWorker1title(java.lang.String newWorkertitle) {
	worker1title = newWorkertitle;
}
public void setWorker2code(java.lang.String newWorkercode) {
	worker2.setString(newWorkercode);
}
public void setWorker2name(java.lang.String newWorkername) {
	worker2name = newWorkername;
}
public void setWorker2title(java.lang.String newWorkertitle) {
	worker2title = newWorkertitle;
}
public void setWorker3code(java.lang.String newWorkercode) {
	worker3.setString(newWorkercode);
}
public void setWorker3name(java.lang.String newWorkername) {
	worker3name = newWorkername;
}
public void setWorker3title(java.lang.String newWorkertitle) {
	worker3title = newWorkertitle;
}
public void setWorker4code(java.lang.String newWorkercode) {
	worker4.setString(newWorkercode);
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 12:39:17)
 * @param newWorker4name java.lang.String
 */
public void setWorker4name(java.lang.String newWorker4name) {
	worker4name = newWorker4name;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 12:39:17)
 * @param newWorker4title java.lang.String
 */
public void setWorker4title(java.lang.String newWorker4title) {
	worker4title = newWorker4title;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if("Edit".equals(getAction()) || "Delete".equals(getAction())) {
		if(document.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payoff.document"));
		}
		else if(!document.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoff.document"));
		}
	}

	if(owner.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payoff.owner"));
	}
	else if(!owner.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoff.owner"));
	}
	else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(owner.getInteger().intValue());
			bean.refreshCopyHelper();
			setOwnername(bean.getName());
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.payoff.owner"));
		}
	}

	if(storage.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payoff.storage"));
	}
	else if(!storage.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoff.storage"));
	}
	else {
		try {
			StorageAccessBean bean = new StorageAccessBean();
			bean.setInitKey_storageplace(storage.getInteger().intValue());
			bean.refreshCopyHelper();
			storagename = bean.getName();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.payoff.storage"));
		}
	}

	if(blanknumber.trim().length() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.empty"));
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

	if(blankdate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payoff.blankdate"));
	}
	else if(!blankdate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoff.blankdate"));
	}

	if(worker1.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payoff.worker1"));
	} else if(!worker1.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoff.worker1"));
	} else {
		try {
			constructWorker1();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.payoff.worker1"));
		}
	}

	if(!worker2.isEmpty()) {
		if(!worker2.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoff.worker2"));
		} else {
			try {
				constructWorker2();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.payoff.worker2"));
			}
		}
	}

	if(!worker3.isEmpty()) {
		if(!worker3.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoff.worker3"));
		} else {
			try {
				constructWorker3();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.payoff.worker3"));
			}
		}
	}

	if(worker4.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payoff.worker4"));
	} else if(!worker4.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoff.worker4"));
	} else {
		try {
			constructWorker4();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.payoff.worker4"));
		}
	}

	if(!"1".equals(dState) && !"2".equals(dState)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoff.state"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
