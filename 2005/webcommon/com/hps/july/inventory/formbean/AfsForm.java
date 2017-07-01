package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCComProjectsObject;
import com.hps.july.cdbc.objects.CDBCRegionsObject;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.Enumeration;
import java.util.Calendar;
import java.util.ListIterator;
import java.util.Vector;

/**
 * Форма редактирования шапки акта монтажа АФС
 */
public class AfsForm
	extends DocumentForm
{
	private StringAndIntegerProperty owner;
	private String ownername;
	
	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	
	private StringAndSqlDateProperty blankdate;
	
	private StringAndIntegerProperty position;
	private String positionid;
	private String positionname;

	private StringAndIntegerProperty complect;
	private String complectmodel;
	private String complectname;

	private String type;
	
	private StringAndIntegerProperty provider;
	private String providername;

	private String insuranseMan;

	private StringAndIntegerProperty worker;
	private String workername;
	private String workertitle;

	private StringAndIntegerProperty worker2;
	private String worker2name;
	private String worker2title;

	private StringAndIntegerProperty storageman; 
	private String storagemanname;
	private String storagemantitle;

	private String dState;

	private StringAndIntegerProperty doc;
	private StringAndIntegerProperty expedition;

	private String afstype = "O";
	
	private java.lang.Integer projectid;
	private java.lang.String projectname;
	private boolean needapprove;
	private java.lang.String readprjstatus;
	
	
public AfsForm() {
	owner = new StringAndIntegerProperty();
	ownername = "";

	blanknumber = "";
	blankindex = new StringAndIntegerProperty();

	blankdate = new StringAndSqlDateProperty();

	position = new StringAndIntegerProperty();
	positionid = "";
	positionname = "";

	complect = new StringAndIntegerProperty();
	complectmodel = "";
	complectname = "";

	type = "P";

	provider = new StringAndIntegerProperty();
	providername = "";	
	insuranseMan = "";

	worker = new StringAndIntegerProperty();
	workername = "";
	workertitle = "";

	worker2 = new StringAndIntegerProperty();
	worker2name = "";
	worker2title = "";

	storageman = new StringAndIntegerProperty();
	storagemanname = "";
	storagemantitle = "";

	dState = "1";

	doc = new StringAndIntegerProperty();
	expedition = new StringAndIntegerProperty();
}


/**
 * Проверим нужно ли требовать согласование документа и есть ли проект.
 * Creation date: (15.12.2005 17:04:14)
 * @return boolean
 */

protected void checkProject(ActionErrors errors) {
	CDBCComProjectsObject cpob = new CDBCComProjectsObject();
	if (cpob.checkProject(getComplectProperty().getInteger())) {
		setProjectid(cpob.getProjectid());
		setProjectname(cpob.getProjectname());
		setNeedapprove(cpob.isNeedapprove());
	} else {
		setProjectid(cpob.getProjectid());
		setProjectname(cpob.getProjectname());
		setNeedapprove(cpob.isNeedapprove());
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mountact2.invalid.project"));
	}
}

/**
 * ID проекта на строительство БС.
 * Creation date: (15.12.2005 16:54:28)
 * @return java.lang.Integer
 */
public java.lang.Integer getProjectid() {
	return projectid;
}

/**
 * Наименование проекта на строительство БС.
 * Creation date: (15.12.2005 16:54:54)
 * @return java.lang.String
 */
public java.lang.String getProjectname() {
	return projectname;
}

/**
 * Статус проекта на строительство БС (только чтение из БД)
 * Creation date: (15.12.2005 17:00:15)
 * @param newReadprjstatus java.lang.String
 */
public void setPrjstatus(java.lang.String newReadprjstatus) {
	readprjstatus = newReadprjstatus;
}

/**
 * Статус проекта на строительство БС (только чтение из БД)
 * @return
 */
public java.lang.String getReadprjstatus() {
	return readprjstatus;
}

/**
 * ID проекта на строительство БС
 * Creation date: (15.12.2005 16:54:28)
 * @param newProjectid java.lang.Integer
 */
public void setProjectid(java.lang.Integer newProjectid) {
	projectid = newProjectid;
}

/**
 * Наименование проекта на строительство БС
 * Creation date: (15.12.2005 16:54:54)
 * @param newProjectname java.lang.String
 */
public void setProjectname(java.lang.String newProjectname) {
	projectname = newProjectname;
}

/**
 * Документ требует согласования
 * Creation date: (15.12.2005 16:56:04)
 * @return boolean
 */
public boolean isNeedapprove() {
	return needapprove;
}

public boolean getNeedapprove() {
	return needapprove;
}

/**
 * Документ требует согласования
 * Creation date: (15.12.2005 16:56:04)
 * @param newNeedapprove boolean
 */
public void setNeedapprove(boolean newNeedapprove) {
	needapprove = newNeedapprove;
}

/**
 * Наименование статуса от проектировщиков
 * Creation date: (15.12.2005 16:56:04)
 * @param newNeedapprove boolean
 */
public String getPrjstatusname() {
	return CDBCComProjectsObject.formatProjectState(getReadprjstatus());
}

public void _setFrom(StoragePlaceAccessBean s) {
	if(s == null) return;
	try {
		ExpeditionAccessBean exp = new ExpeditionAccessBean();
		exp.setInitKey_storageplace(s.getStorageplace());
		exp.refreshCopyHelper();
		expedition.setInteger(new Integer(s.getStorageplace()));
		if(exp.getExpeditor() != null) {
			worker.setInteger(new Integer(exp.getExpeditor().getWorker()));
			workername = exp.getExpeditor().getMan().getFullName();
			workertitle = exp.getExpeditor().getPosition().getName();
			type = "W";
			setProvidercode("");
			setProvidername("");
		} else
		if(exp.getOrganization() != null) {
			provider.setInteger(new Integer(exp.getOrganization().getOrganization()));
			providername = exp.getOrganization().getName();
			type = "P";
			setWorkercode("");
			setWorkername("");
			setWorkertitle("");
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}

public void _setTo(StoragePlaceAccessBean s) {
	if(s == null) return;
	try {
		EquipmentSetAccessBean equ = new EquipmentSetAccessBean();
		equ.setInitKey_storageplace(s.getStorageplace());
		equ.refreshCopyHelper();
		setComplect(equ);
		PositionAccessBean pos = equ.getPosition();
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
		e.printStackTrace(System.out);
	}
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
}

public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setDoc(keyGen.getNextKey("tables.documents"));

	AfsMountActAccessBean bean = new AfsMountActAccessBean(
		getDoc(),
		owner.getInteger(),
		null, // expedition added in beforeUpdate() method
		complect.getInteger(),
		blankdate.getSqlDate(),
		getBlankindex(),
		blanknumber,
		"1",
		Boolean.TRUE,
		Boolean.TRUE,
		Boolean.FALSE
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
		o.setInitKey_organization(provider.getInteger().intValue());
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
	positionname = bean.getName();
	positionid = "";
	if(bean.getGsmid() != null) {
		positionid = positionid + "D" + bean.getGsmid();
	}
	positionid = positionid + " ";
	if(bean.getDampsid() != null) {
		positionid = positionid + "A" + bean.getDampsid();
	}
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

public WorkerAccessBean constructWorker2() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(worker2.getInteger().intValue());
	bean.refreshCopyHelper();
	setWorker2name(bean.getMan().getFullName());
	setWorker2title(bean.getPosition().getName());
	return bean;
}

public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	AfsMountActAccessBean b = (AfsMountActAccessBean)bean;
	/*try {
		docState = b.getDocumentState();
	} catch(Exception e) {
		docState = "";
	}*/
	try { _setFrom(b.getFrom()); } catch(Exception e) {	e.printStackTrace(System.out); }
	try { _setTo(b.getTo()); } catch(Exception e) { e.printStackTrace(); }
}

public ExpeditionAccessBean findExpedition() throws java.lang.Exception {
	ExpeditionAccessBean fexp = new ExpeditionAccessBean();
	Enumeration en;
	ExpeditionAccessBean exp;
	if("P".equals(type)) {
		en = fexp.findExpeditionByOrganization(new OrganizationKey(provider.getInteger().intValue()));
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
//	if(en.hasMoreElements()) {
//		throw new Exception("error.update.internal.expedition");
//	}
	return exp;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAfstype() {
	return afstype;
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
public String getComplectcode() {
	return complect.getString();
}
public String getComplectmodel() {
	return complectmodel;
}
public String getComplectname() {
	return complectname;
}
public StringAndIntegerProperty getComplectProperty() {
	return complect;
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
	AfsMountActAccessBean bean = new AfsMountActAccessBean();
	bean.setInitKey_document(getDoc());
	return bean;
}
public int getDoc() {
	if(doc.getInteger() != null)
		return doc.getInteger().intValue();
	else
		return 0;
}

public String getDocstr() {
	return doc.getString();
}

public Integer getDocumentId() {
	return doc.getInteger();
}

public Enumeration getDocumentPositions()
	throws Exception
{
	return super.getDocumentPositions();
//	InternalWayBillPositionAccessBean fb = new InternalWayBillPositionAccessBean();
//	return fb.findDocPositionsByDocOrderByOrderAsc(getDocumentId());
}

public java.lang.String getdState() {
	try{
		AfsMountActAccessBean bean = new AfsMountActAccessBean();
		bean.setInitKey_document(getDoc());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		//e.printStackTrace(System.out);
		return "1";
	}
}
public java.lang.String getDState() {
	try{
		AfsMountActAccessBean bean = new AfsMountActAccessBean();
		bean.setInitKey_document(getDoc());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		// Ignore
		//e.printStackTrace(System.out);
		return "1";
	}
}
public Integer getExpedition() {
	return expedition.getInteger();
}

public String getExpeditionstr() {
	return expedition.getString();
}

public StoragePlace getFrom() {
	ExpeditionAccessBean exp = null;
	try {
		exp = findExpedition();
	} catch(Exception e) {
		try {
			exp = constructExpedition();
		} catch(Exception ee) {
			ee.printStackTrace(System.out);
		}
	}
	try {
		return ((Expedition)exp.getEJBRef());
	} catch(Exception e) {
		return null;
	}
}

public java.lang.String getInsuranseMan() {
	return insuranseMan;
}

public java.util.Iterator getItems()
	throws Exception
{
	com.hps.july.cdbc.objects.CDBCDocuments cd = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = cd.listAfsMountItems(getDocumentId());
	return rs.listIterator();
}

public Worker getMonter() {
	try {
		return (Worker)constructWorker2().getEJBRef();
	} catch(Exception e) {
		return null;
	}
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
	return ownername;
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

public StringAndIntegerProperty getPositionProperty() {
	return position;
}

public String getProvidercode() {
	return provider.getString();
}

public java.lang.String getProvidername() {
	return providername;
}

public Boolean getReadonly() {
	return new Boolean(!("1".equals(getDState()) && !getIsautodoc()));
}

public int getState() {
	return com.hps.july.inventory.APPStates.EDITAFS;
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

public StoragePlace getTo() {
	if(!complect.isEmpty() && complect.isOk()) {
		try {
			EquipmentSetAccessBean bean = new EquipmentSetAccessBean();
			bean.setInitKey_storageplace(complect.getInteger().intValue());
			bean.refreshCopyHelper();
			return (StoragePlace)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}

public java.lang.String getType() {
	return type;
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
	afstype = "O";
	
	owner = new StringAndIntegerProperty();
	ownername = "";

	blanknumber = "";
	blankindex = new StringAndIntegerProperty();

	blankdate = new StringAndSqlDateProperty();

	position = new StringAndIntegerProperty();
	positionid = "";
	positionname = "";

	complect = new StringAndIntegerProperty();
	complectmodel = "";
	complectname = "";

	type = "P";

	provider = new StringAndIntegerProperty();
	providername = "";	
	insuranseMan = "";

	worker = new StringAndIntegerProperty();
	workername = "";
	workertitle = "";

	worker2 = new StringAndIntegerProperty();
	worker2name = "";
	worker2title = "";

	storageman = new StringAndIntegerProperty();
	storagemanname = "";
	storagemantitle = "";

	dState = "1";

	doc = new StringAndIntegerProperty();
	expedition = new StringAndIntegerProperty();
	
	super.initRecord(request);
	doc.setInteger(null);
	AfsListForm aform = (AfsListForm)request.getSession().getAttribute("AfsListForm");

	if(aform.getDateto() != null) {
		setBlankdate(aform.getDateto());
	} else {
		setBlankdate(new java.sql.Date(System.currentTimeMillis()));
	}
	
	if(Boolean.FALSE.equals(aform.getIsowner())) {
		setOwnercode(aform.getOwnercode());
		setOwnername(aform.getOwnername());
	}

	if(Boolean.FALSE.equals(aform.getIsposition())) {
		setPositioncode(aform.getPositioncode());
		positionid = aform.getPositionid();
		positionname = aform.getPositionname();
	}

	if("P".equals(aform.getType())) {
		setProvidercode(aform.getProvidercode());
		setProvidername(aform.getProvidername());
		setWorkercode("");
		setWorkername("");
		setWorkertitle("");
		setType("P");
	} else
	if("W".equals(aform.getType())) {
		setProvidercode("");
		setProvidername("");
		setWorkercode(aform.getWorkercode());
		setWorkername(aform.getWorkername());
		setWorkertitle(aform.getWorkertitle());
		setType("W");
	}

	dState = "1";
	setNeedapprove(false);
	setProjectid(null);
	setProjectname(null);
}

public java.util.Iterator listCableItems(Integer parentpos)
{
	com.hps.july.cdbc.objects.CDBCDocuments d = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = d.listAfsMountCableItems(parentpos);
	return rs.listIterator();
}

/**
 * 
 * @param newAfstype java.lang.String
 */
public void setAfstype(java.lang.String newAfstype) {
	afstype = newAfstype;
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

public void setComplect(EquipmentSetAccessBean bean) {
	try {
		complect.setInteger(new Integer(bean.getStorageplace()));
		complectname = com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(bean);
		complectmodel = "";
	} catch(Exception e) {
		complectname = "";
		complectmodel = "";
	}
}

public void setComplectcode(String newNumber) {
	complect.setString(newNumber);
}

public void setDoc(int newDocument) {
	doc.setInteger(new Integer(newDocument));
}

public void setDocstr(String newDocument) {
	doc.setString(newDocument);
}

public void setExpeditionstr(String newDocument) {
	expedition.setString(newDocument);
}

public void setInsuranseMan(java.lang.String newInsuranseMan) {
	insuranseMan = newInsuranseMan;
}

public void setMonter(WorkerAccessBean bean) {
	try {
		worker2.setInteger(new Integer(bean.getWorker()));
		worker2name = bean.getMan().getFullName();
		worker2title = bean.getPosition().getName();
	} catch(Exception e) {
		worker2name = "";
		worker2title = "";
	}
}

public void setOwner(OrganizationAccessBean bean) {
	try {
		owner.setInteger(new Integer(bean.getOrganization()));
		ownername = bean.getName();
	} catch(Exception e) {
		ownername = "";
	}
}

public void setOwnercode(String newNumber) {
	owner.setString(newNumber);
}

public void setOwnername(String newName) {
	ownername = newName;
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

public void setProvider(OrganizationAccessBean bean) {
	try {
		provider.setInteger(new Integer(bean.getOrganization()));
		providername = bean.getName();
	} catch(Exception e) {
		providername = "";
	}
}

public void setProvidercode(String newProvider) {
	provider.setString(newProvider);
}

public void setProvidername(java.lang.String newProvidername) {
	providername = newProvidername;
}

public void setStorageManager(WorkerAccessBean bean) {
	try {
		storageman.setInteger(new Integer(bean.getWorker()));
		storagemanname = bean.getMan().getFullName();
		storagemantitle = bean.getPosition().getName();
	} catch(Exception e) {
		storagemanname = "";
		storagemantitle = "";
	}
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

public void setWorker2code(java.lang.String newWorkercode) {
	worker2.setString(newWorkercode);
}
public void setWorker2name(java.lang.String newWorkername) {
	worker2name = newWorkername;
}
public void setWorker2title(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
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
		if(doc.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afs.document"));
		}
		else if(!doc.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afs.document"));
		}
	}

	// Required fields check
	if(owner.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afs.owner"));
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
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afs.blankdate"));
	}

	if(position.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afs.position"));
	} else {
		if(!position.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afs.position"));
		} else {
			try {
				PositionAccessBean bean = constructPosition();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.afs.position"));
			}
		}
	}
	
	if(complect.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afs.complect"));
	} else {
		if(!complect.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afs.complect"));
		}
		else {
			try {
				EquipmentSetAccessBean bean = new EquipmentSetAccessBean();
				bean.setInitKey_storageplace(complect.getInteger().intValue());
				bean.refreshCopyHelper();
				setComplect(bean);
				boolean isBS = false;
				boolean isRepeater = false;
				try {
					BaseStationAccessBean bs = new BaseStationAccessBean();
					bs.setInitKey_storageplace(complect.getInteger().intValue());
					bs.refreshCopyHelper();
					isBS = true;
				} catch(Exception ee) {
					// Ignore
				}
				try {
					RepiterAccessBean rp = new RepiterAccessBean();
					rp.setInitKey_storageplace(complect.getInteger().intValue());
					rp.refreshCopyHelper();
					isRepeater = true;
				} catch(Exception ee) {
					// Ignore
				}
				if (!isBS && !isRepeater)
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.afs.complectisnotbs"));
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.afs.complect"));
			}
		}
	}
	
	if (!getComplectcode().equalsIgnoreCase(""))
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(new Integer(getComplectcode())))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.alertgsm"));
	
	checkProject(errors);

	if("P".equals(type)) {
		if(provider.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afs.provider"));
		}
		if((insuranseMan == null) || ("".equals(insuranseMan))) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afs.insuranceman"));
		}
	} else if("W".equals(type)) {
		if(worker.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afs.worker"));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afs.type"));
	}
		
	if (!errors.empty()) 
		throw new ValidationException();

	// Consistence check
	
	if(!owner.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afs.owner"));
	} else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(owner.getInteger().intValue());
			bean.refreshCopyHelper();
			setOwner(bean);
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.afs.owner"));
		}
	}

	if(blanknumber.length() > 40) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afs.blanknumber"));
	}

	if(blanknumber.trim().length() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.empty"));
	} 

	if(!blankdate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afs.blankdate"));
	}

	if("P".equals(type)) {
		if(!provider.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afs.provider"));
		}
		else {
			try {
				OrganizationAccessBean bean = new OrganizationAccessBean();
				bean.setInitKey_organization(provider.getInteger().intValue());
				bean.refreshCopyHelper();
				if(Boolean.FALSE.equals(bean.getIsprovider())) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afs.notprovider"));
				}
				setProvider(bean);
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.afs.provider"));
			}
		}
	} else if("W".equals(type)) {
		if(!worker.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afs.worker"));
		}
		else {
			try {
				constructWorker();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.afs.worker"));
			}
		}
	}

	if(!worker2.isEmpty()) {
		if(!worker2.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afs.worker2"));
		} else {
			try {
				constructWorker2();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.afs.worker2"));
			}
		}
	}
	
	if(!storageman.isEmpty()) {
//		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afs.storageman"));
		if(!storageman.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afs.storageman"));
		}
		else {
			try {
				constructStorageManager();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.afs.storageman"));
			}
		}
	}

	if(!"1".equals(getDState()) && !"2".equals(getDState())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afs.state"));
	}

	if (!errors.empty())
		throw new ValidationException();
}

}
