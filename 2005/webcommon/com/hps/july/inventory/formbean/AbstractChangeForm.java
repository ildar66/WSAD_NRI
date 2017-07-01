package com.hps.july.inventory.formbean;

import javax.servlet.http.HttpServletRequest;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.Enumeration;
import java.util.Calendar;
import java.util.Vector;

/**
 * Базовый класс для форм ввода и редактирования шапки документа "Акт замены"
 * Содержит базовые свойства общие для документов на позициях, складе и замене при ремонте.
 */
public abstract class AbstractChangeForm extends DocumentForm {
	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	private StringAndSqlDateProperty blankdate;
	private StringAndIntegerProperty owner;
	private String ownername;
	private String dState;

	private String acttype;

	private StringAndIntegerProperty document;
public AbstractChangeForm() {
	blanknumber = "";
	blankindex = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	document = new StringAndIntegerProperty();
	dState = "1";
	owner = new StringAndIntegerProperty();
	ownername = "";
	try {
		Enumeration en = getOwners();
		if(en.hasMoreElements()) {
			OrganizationAccessBean org = (OrganizationAccessBean)en.nextElement();
			owner.setInteger(new Integer(org.getOrganization()));
		}
	} catch(Exception e) {
	}
	acttype = "C";
}
public void beforeDelete(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception 
{
	super.beforeDelete(bean,request);
	try {
		ChangeActPositionAccessBean cap = new ChangeActPositionAccessBean();
		Enumeration en = cap.findChangeActPositionByChangeAct(new DocumentKey(getDocumentId().intValue()));
		while(en.hasMoreElements()) {
			ChangeActPositionAccessBean _c = (ChangeActPositionAccessBean)en.nextElement();
			_c.refreshCopyHelper();
			_c.getEJBRef().remove();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setDocument(keyGen.getNextKey("tables.documents"));

	ChangeActAccessBean bean = new ChangeActAccessBean(
		getDocument(),
		owner.getInteger(),
		getFromKey(),
		getToKey(),
		blankdate.getSqlDate(), 
		getBlankindex(),
		blanknumber,
		"1",
		Boolean.TRUE,
		Boolean.TRUE,
		acttype
	);
	
	return bean;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	ChangeActAccessBean ab = (ChangeActAccessBean)bean;
	try {
		dState = ab.getDocumentState();
		OrganizationAccessBean o = ab.getOwner();
		if(o != null) {
			owner.setInteger(new Integer(o.getOrganization()));
			ownername = o.getName();
		}
	} catch(Exception e) {
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getActtype() {
	return acttype;
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
public Enumeration getCurrencies() {
	try {
		CurrencyAccessBean bean = new CurrencyAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ChangeActAccessBean bean = new ChangeActAccessBean();
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
public Enumeration getDocumentPositions()
	throws Exception
{
	ChangeActPositionAccessBean fb = new ChangeActPositionAccessBean();
	return fb.findChangeActPositionByChangeAct(new DocumentKey(getDocumentId().intValue()));
}
public String getDocumentstr() {
	return document.getString();
}
public java.lang.String getdState() {
	try{
		ChangeActAccessBean bean = new ChangeActAccessBean();
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
		ChangeActAccessBean bean = new ChangeActAccessBean();
		bean.setInitKey_document(getDocument());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return "1";
	}
}
protected abstract String getFormName();
public StoragePlace getFrom() {
	Integer from = getFromKey();
	if(from != null) {
		try {
			StoragePlaceAccessBean bean = new StoragePlaceAccessBean();
			bean.setInitKey_storageplace(from.intValue());
			bean.refreshCopyHelper();
			return (StoragePlace)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
protected abstract Integer getFromKey();
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
public StoragePlace getTo() {
	Integer to = getToKey();
	if(to != null) {
		try {
			StoragePlaceAccessBean bean = new StoragePlaceAccessBean();
			bean.setInitKey_storageplace(to.intValue());
			bean.refreshCopyHelper();
			return (StoragePlace)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
protected abstract Integer getToKey();
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception 
{
	super.initRecord(request);
	document.setInteger(null);
	AbstractChangeListForm aform = (AbstractChangeListForm)request.getSession().getAttribute(getFormName());
	
	if(aform.getDateto() != null) {
		setBlankdate(aform.getDateto());
	}

	if(Boolean.FALSE.equals(aform.getIsowner())) {
		setOwnercode(aform.getOwnercode());
		setOwnername(aform.getOwnername());
	}
	acttype = "C";
	dState = "1";
}
/**
 * 
 * @param newActtype java.lang.String
 */
public void setActtype(java.lang.String newActtype) {
	acttype = newActtype;
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
protected abstract void specialValidate(ActionErrors errors);
public void validateValues(ActionErrors errors) throws Exception 
{
	if(("View".equals(getAction()) || "Edit".equals(getAction())) && getProcessState() != null && !"".equals(getProcessState()))
	{
		return;
	}
	
	if(!"1".equals(dState)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.action"));
		throw new ValidationException();
	}

	if("Edit".equals(getAction()) || "Delete".equals(getAction())) {
		if(document.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.change.document"));
		}
		else if(!document.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.change.document"));
		}
	}

	if(!"1".equals(dState) && !"2".equals(dState)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.change.state"));
	}

	if(owner.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.change.owner"));
	}
	else if(!owner.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.change.owner"));
	}
	else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(owner.getInteger().intValue());
			bean.refreshCopyHelper();
			setOwnername(bean.getName());
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.change.owner"));
		}
	}

	if(blankdate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.change.blankdate"));
	}
	else if(!blankdate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.change.blankdate"));
	}

	if(blankindex.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.empty"));
	} else if(!blankindex.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.invalid"));
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

	specialValidate(errors);

	if (!errors.empty())
		throw new ValidationException();
}
}
