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
 * Форма ввода и редактирования шапки документа "Внутренний приходный ордер"
 */
public class InternalForm
	extends DocumentForm
{
	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	
	private StringAndSqlDateProperty blankdate;
	
	private String cordoctype;

	private StringAndIntegerProperty owner;
	private String ownername;
	
	private StringAndIntegerProperty storage;
	private String storagename;

	private String type;
	
	private StringAndIntegerProperty renter;
	private String rentername;

	private String insuranseMan;

	private String insuranceact;

	private StringAndSqlDateProperty insurancedate;
	
	private StringAndIntegerProperty worker;
	private String workername;
	private String workertitle;

	private String dState;

	private StringAndIntegerProperty position;
	private String positionname;
	private String positionid;
	
	private StringAndIntegerProperty storageman; 
	private String storagemanname;
	private String storagemantitle;

	private StringAndIntegerProperty document;
	private StringAndIntegerProperty expedition;

	private Boolean fixing;
	private int brokentype;
public InternalForm() {
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
	position = new StringAndIntegerProperty();
	positionname = "";
	renter = new StringAndIntegerProperty();
	rentername = "";	
	storage = new StringAndIntegerProperty();
	storagename = "";
	storageman = new StringAndIntegerProperty();
	storagemanname = "";
	storagemantitle = "";
	type = "P";
	worker = new StringAndIntegerProperty();
	workername = "";
	workertitle = "";
	cordoctype = "D";
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
	InternalWayBillAccessBean ab = (InternalWayBillAccessBean)bean;
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	ExpeditionAccessBean exp = null;

	try {
		exp = findExpedition();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		exp = constructExpedition();
	}
	
	ab.setFrom((Expedition)exp.getEJBRef());
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setDocument(keyGen.getNextKey("tables.documents"));

	InternalWayBillAccessBean bean = new InternalWayBillAccessBean(
		getDocument(),
		owner.getInteger(),
		null,
		storage.getInteger(),
		blankdate.getSqlDate(),
		getBlankindex(),
		(blanknumber != null)?blanknumber:"",
		"1",
		Boolean.TRUE,
		Boolean.TRUE,
		fixing
	);
	return bean;
}
public ExpeditionAccessBean constructExpedition() throws Exception {
	if(!"P".equals(type) && !"W".equals(type)) {
		throw new UpdateValidationException("error.invalid.internal.type");
	}
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	ExpeditionAccessBean exp = new ExpeditionAccessBean(
		keyGen.getNextKey("tables.storageplaces"), null, "", ""
	);
	if("P".equals(type)) {
		OrganizationAccessBean o = new OrganizationAccessBean();
		o.setInitKey_organization(renter.getInteger().intValue());
		o.refreshCopyHelper();
		exp.setOrganization((Organization)o.getEJBRef());
		exp.setExpeditor(null);
		exp.setName(o.getName());
	} else if("W".equals(type)) {
		WorkerAccessBean w = new WorkerAccessBean();
		w.setInitKey_worker(worker.getInteger().intValue());
		w.refreshCopyHelper();
		exp.setOrganization(null);
		exp.setExpeditor((Worker)w.getEJBRef());
		exp.setName(w.getMan().getLastname());
	}
	exp.commitCopyHelper();
	return exp;
}
public PositionAccessBean constructPosition() throws java.lang.Exception {
	PositionAccessBean bean = new PositionAccessBean();
	bean.setInitKey_storageplace(position.getInteger().intValue());
	bean.refreshCopyHelper();
	setPosition(bean);
	return bean;
}
public WorkerAccessBean constructStorageManager() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(storageman.getInteger().intValue());
	bean.refreshCopyHelper();
	setStoragemanname(bean.getMan().getFullName());
	setStoragemantitle(bean.getPosition().getName());
	return bean;
}
public WorkerAccessBean constructWorker() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(worker.getInteger().intValue());
	bean.refreshCopyHelper();
	setWorkername(bean.getMan().getFullName());
	setWorkertitle(bean.getPosition().getName());
	return bean;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	InternalWayBillAccessBean ab = (InternalWayBillAccessBean)bean;
	try {
		if(ab.getFixing() != null && ab.getFixing().booleanValue()) {
			setBrokentype(0);
		} else {
			setBrokentype(1);
		}
		OrganizationAccessBean o = ab.getOwner();
		if(o != null) {
			owner.setInteger(new Integer(o.getOrganization()));
			ownername = o.getName();
		}
		StoragePlaceAccessBean s = ab.getTo();
		if(s != null) {
			storage.setInteger(new Integer(s.getStorageplace()));
			storagename = s.getName();
		}
		// Expedition
		s = ab.getFrom();
		expedition.setInteger(new Integer(s.getStorageplace()));
		if(s != null) {
			try {
				ExpeditionAccessBean exp = new ExpeditionAccessBean();
				exp.setInitKey_storageplace(s.getStorageplace());
				exp.refreshCopyHelper();
				if(exp.getExpeditor() != null) {
					worker.setInteger(new Integer(exp.getExpeditor().getWorker()));
					workername = exp.getExpeditor().getMan().getFullName();
					workertitle = exp.getExpeditor().getPosition().getName();
					type = "W";
					setRentercode("");
					setRentername("");
				} else
				if(exp.getOrganization() != null) {
					renter.setInteger(new Integer(exp.getOrganization().getOrganization()));
					rentername = exp.getOrganization().getName();
					type = "P";
					setWorkercode("");
					setWorkername("");
					setWorkertitle("");
				}
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
		}
		WorkerAccessBean w = ab.getStorageManager();
		if(w != null) {
			storageman.setInteger(new Integer(w.getWorker()));
			storagemanname = w.getMan().getFullName();
			storagemantitle = w.getPosition().getName();
		}
		PositionAccessBean p = ab.getPosition();
		if(p != null) {
			setPosition(p);
		}

	} catch(Exception e) {
	}
}
public ExpeditionAccessBean findExpedition() throws java.lang.Exception {
	ExpeditionAccessBean fexp = new ExpeditionAccessBean();
	Enumeration en;
	ExpeditionAccessBean exp;
	if("P".equals(type)) {
		en = fexp.findExpeditionByOrganization(new OrganizationKey(renter.getInteger().intValue()));
		if(en.hasMoreElements()) {
			ExpeditionAccessBean e = (ExpeditionAccessBean)en.nextElement();
			exp = new ExpeditionAccessBean();
			exp.setInitKey_storageplace(e.getStorageplace());
			exp.refreshCopyHelper();
		} else {
			throw new Exception();
		}
	} else if("W".equals(type)) {
		en = fexp.findExpeditionByExpeditor(new WorkerKey(worker.getInteger().intValue()));
		if(en.hasMoreElements()) {
			ExpeditionAccessBean e = (ExpeditionAccessBean)en.nextElement();
			exp = new ExpeditionAccessBean();
			exp.setInitKey_storageplace(e.getStorageplace());
			exp.refreshCopyHelper();
		} else {
			throw new Exception();
		}
	} else {
		throw new UpdateValidationException("error.invalid.internal.type");
	}
	if(en.hasMoreElements()) {
		throw new Exception("error.update.internal.expedition");
	}
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
public int getBrokentype() {
	return brokentype;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 11:54:36)
 * @return java.lang.String
 */
public java.lang.String getCordoctype() {
	return cordoctype;
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
	InternalWayBillAccessBean bean = new InternalWayBillAccessBean();
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
//	InternalWayBillPositionAccessBean fb = new InternalWayBillPositionAccessBean();
//	return fb.findDocPositionsByDocOrderByOrderAsc(getDocumentId());
	return super.getDocumentPositions();
}
public String getDocumentstr() {
	return document.getString();
}
public java.lang.String getdState() {
	try{
		InternalWayBillAccessBean bean = new InternalWayBillAccessBean();
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
		InternalWayBillAccessBean bean = new InternalWayBillAccessBean();
		bean.setInitKey_document(getDocument());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return "1";
	}
}
public Integer getExpeditionId() {
	return expedition.getInteger();
}
public String getExpeditionstr() {
	return expedition.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 11:29:13)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getFixing() {
	return fixing;
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
	com.hps.july.cdbc.lib.CDBCResultSet rs = c.listInternalStorageInItems(getDocumentId(),new Integer(1));
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
public Position getPosition() {
	try {
		return (Position)constructPosition().getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
public String getPositioncode() {
	return position.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 11:14:23)
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
public String getRentercode() {
	return renter.getString();
}
public java.lang.String getRentername() {
	return rentername;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITIO;
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
public StoragePlace getTo() {
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
public java.lang.String getType() {
	return type;
}
public java.lang.String getWorkercode() {
	return worker.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @return java.lang.String
 */
public java.lang.String getWorkertitle() {
	return workertitle;
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
	position = new StringAndIntegerProperty();
	positionname = "";
	renter = new StringAndIntegerProperty();
	rentername = "";	
	storage = new StringAndIntegerProperty();
	storagename = "";
	storageman = new StringAndIntegerProperty();
	storagemanname = "";
	storagemantitle = "";
	type = "P";
	worker = new StringAndIntegerProperty();
	workername = "";
	workertitle = "";
	cordoctype = "D";

	InternalListForm aform = (InternalListForm)request.getSession().getAttribute("InternalListForm");
	
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

	if("P".equals(aform.getType())) {
		setRentercode(aform.getRentercode());
		setRentername(aform.getRentername());
		setWorkercode("");
		setWorkername("");
		setWorkertitle("");
		setType("P");
	} else
	if("W".equals(aform.getType())) {
		setRentercode("");
		setRentername("");
		setWorkercode(aform.getWorkercode());
		setWorkername(aform.getWorkername());
		setWorkertitle(aform.getWorkertitle());
		setType("W");
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
public void setBrokentype(int newBrokentype) {
	brokentype = newBrokentype;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 11:54:36)
 * @param newCordoctype java.lang.String
 */
public void setCordoctype(java.lang.String newCordoctype) {
	cordoctype = newCordoctype;
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
 * Creation date: (23.07.2002 11:29:13)
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
public void setPosition(PositionAccessBean pos) {
	try {
		position.setInteger(new Integer(pos.getStorageplace()));
		positionname = pos.getName();
		positionid = "";
		if(pos.getGsmid() != null) {
			positionid = positionid + "D" + pos.getGsmid();
		}
		positionid = positionid + " ";
		if(pos.getDampsid() != null) {
			positionid = positionid + "A" + pos.getDampsid();
		}
	} catch(Exception e) {
		positionname = "";
		positionid = "";
	}
}
public void setPositioncode(String newPosition) {
	position.setString(newPosition);
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 11:14:23)
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
public void setRentercode(String newRenter) {
	renter.setString(newRenter);
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 12:22:39)
 * @param newRentername java.lang.String
 */
public void setRentername(java.lang.String newRentername) {
	rentername = newRentername;
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
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 12:21:05)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
public void setWorkercode(java.lang.String newWorkercode) {
	worker.setString(newWorkercode);
}
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @param newWorkertitle java.lang.String
 */
public void setWorkertitle(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if("Edit".equals(getAction()) || "Delete".equals(getAction())) {
		if(document.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internal.document"));
		}
		else if(!document.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internal.document"));
		}
	}

	if(blankdate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internal.blankdate"));
	}
	else if(!blankdate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internal.blankdate"));
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
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internal.owner"));
	}
	else if(!owner.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internal.owner"));
	}
	else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(owner.getInteger().intValue());
			bean.refreshCopyHelper();
			setOwnername(bean.getName());
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.internal.owner"));
		}
	}

	if(storage.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internal.storage"));
	}
	else if(!storage.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internal.storage"));
	}
	else {
		try {
			StorageAccessBean bean = new StorageAccessBean();
			bean.setInitKey_storageplace(storage.getInteger().intValue());
			bean.refreshCopyHelper();
			storagename = bean.getName();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.internal.storage"));
		}
	}

	if("P".equals(type)) {
		if(renter.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internal.renter"));
		}
		else if(!renter.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internal.renter"));
		}
		else {
			try {
				OrganizationAccessBean bean = new OrganizationAccessBean();
				bean.setInitKey_organization(renter.getInteger().intValue());
				bean.refreshCopyHelper();
				setRentername(bean.getName());
				if(Boolean.FALSE.equals(bean.getIsprovider())) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internal.notrenter"));
				}
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.internal.renter"));
			}
		}
		if((insuranseMan == null) || ("".equals(insuranseMan))) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internal.insuranceman"));
		}
	} else if("W".equals(type)) {
		if(worker.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internal.worker"));
		}
		else if(!worker.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internal.worker"));
		}
		else {
			try {
				constructWorker();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.internal.worker"));
			}
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internal.type"));
	}
	
	if(!position.isEmpty()) {
		if(!position.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internal.position"));
		} else {
			try {
				PositionAccessBean bean = constructPosition();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.internal.position"));
			}
		}
	}

	if(storageman.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internal.storageman"));
	}
	else if(!storageman.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internal.storageman"));
	}
	else {
		try {
			constructStorageManager();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.internal.storageman"));
		}
	}

	if(!"1".equals(dState) && !"2".equals(dState)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internal.state"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
