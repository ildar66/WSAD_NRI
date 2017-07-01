package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.Enumeration;
import java.util.Calendar;
import java.util.Vector;
import java.util.Iterator;

/**
 * Форма ввода и редактировани шапки документа "Акт демонтажа на позиции"
 */
public class Demount
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

	private boolean transferToStorage;
	private StringAndIntegerProperty storage;
	private String storagename;

	private Boolean unmountblocks;
	
	// BEE00001159
	private Boolean moveToComplect;
	
	private StringAndIntegerProperty moveToPositionCode;
	private String moveToPositionid;
	private String moveToPositionname;

	private StringAndIntegerProperty moveToComplectCode;
	private String moveToComplectmodel;
	private String moveToComplectname;
	
public Demount() {
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

	moveToComplect = new Boolean(false);
	
	moveToPositionCode = new StringAndIntegerProperty();
	moveToPositionCode.setString("");
	moveToPositionid = "";
	moveToPositionname = "";

	moveToComplectCode = new StringAndIntegerProperty();
	moveToComplectCode.setString("");
	moveToComplectmodel = "";
	moveToComplectname = "";

	dState = "1";

	doc = new StringAndIntegerProperty();
	expedition = new StringAndIntegerProperty();

	storage = new StringAndIntegerProperty();
	transferToStorage = false;
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	super.afterUpdate(bean,request);
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

	InternalOutBillAccessBean bean = new InternalOutBillAccessBean(
		getDoc(),
		owner.getInteger(),
		complect.getInteger(), // from complect
		null, // to expedition added in beforeUpdate() method
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
//	setPosition(bean);
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
	InternalOutBillAccessBean b = (InternalOutBillAccessBean)bean;
	/*try {
		docState = b.getDocumentState();
	} catch(Exception e) {
		docState = "";
	}*/
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
public Integer getComplect() {
	return complect.getInteger();
}
public String getComplectcode() {
	return complect.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComplectmodel() {
	return complectmodel;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
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
	try {
		InternalOutBillAccessBean bean = new InternalOutBillAccessBean();
		bean.setInitKey_document(getDoc());
		if("View".equals(getAction()) || "Edit".equals(getAction())) {
			if("2".equals(bean.getDocumentState())) {
				setAction("View");
			} else if("1".equals(bean.getDocumentState())) {
				setAction("Edit");
			}
		}
		return bean;
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
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
/**
 * Возвращает список позиций текущего документа
 */
public Iterator getDocumentItems() {
	com.hps.july.cdbc.objects.CDBCDocuments docCatalog = new com.hps.july.cdbc.objects.CDBCDocuments();
	return docCatalog.listDemountItems(new Integer(getDoc()),new Integer(1)).listIterator();
}
public java.lang.String getdState() {	
	try{
		InternalOutBillAccessBean bean = new InternalOutBillAccessBean();
		bean.setInitKey_document(getDoc());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return "1";
	}
}
public java.lang.String getDState() {	
	try{
		InternalOutBillAccessBean bean = new InternalOutBillAccessBean();
		bean.setInitKey_document(getDoc());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		//e.printStackTrace(System.out);
		return "1";
	}
}
public String getExpeditionstr() {
	return expedition.getString();
}
public StoragePlace getFrom() {
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
public java.lang.String getInsuranseMan() {
	return insuranseMan;
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
public Integer getPosition() {
	return position.getInteger();
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
public String getProvidercode() {
	return provider.getString();
}
public java.lang.String getProvidername() {
	return providername;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITDIP;
}
public Integer getStorage() {
	return storage.getInteger();
}
public String getStoragecode() {
	return storage.getString();
}
public String getStorageFrm() {
	return storage.getString();
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
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStoragename() {
	return storagename;
}
public StoragePlace getTo() {
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
public Integer getTo2() {
	if(transferToStorage) {
		return storage.getInteger();
	} else {
		return null;
	}
}
public String getTransfer() {
	return String.valueOf(transferToStorage);
}
public java.lang.String getType() {
	return type;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getUnmountblocks() {
	return unmountblocks;
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
	super.initRecord(request);
	doc.setInteger(null);

	DemountList aform = (DemountList)request.getSession().getAttribute("DemountList");
	
	setBlankdate(aform.getDateto());
	
	if(Boolean.FALSE.equals(aform.getIsowner())) {
		setOwnercode(aform.getOwnercode());
		try {
			OrganizationAccessBean org = new OrganizationAccessBean();
			org.setInitKey_organization(aform.getOwnerKey());
			org.refreshCopyHelper();
			setOwnername(org.getName());
		} catch(Exception e) {
			setOwnername("");
		}
	} else {
		setOwnercode("");
		setOwnername("");
	}

	setBlankindexFrm("");
	setBlanknumber("");

	if(Boolean.FALSE.equals(aform.getIsposition())) {
		setPositioncode(aform.getPositioncode());
		positionid = aform.getPositionid();
		positionname = aform.getPositionname();
	} else {
		setPositioncode("");
		setPositionid("");
		setPositionname("");
	}

	setComplectcode("");
	complectmodel = "";
	complectname = "";

	if("P".equals(aform.getType())) {
		setProvidercode(aform.getProvidercode());
		setProvidername(aform.getProvidername());
		setWorkercode("");
		setWorkername("");
		setWorkertitle("");
		setType("P");
	} else if("W".equals(aform.getType())) {
		setProvidercode("");
		setProvidername("");
		setWorkercode(aform.getWorkercode());
		setWorkername(aform.getWorkername());
		setWorkertitle(aform.getWorkertitle());
		setType("W");
	} else {
		setProvidercode("");
		setProvidername("");
		setWorkercode("");
		setWorkername("");
		setWorkertitle("");
		setType("P");
	}
	setInsuranseMan("");
	setStoragemancode("");
	setStoragemanname("");
	setStoragemantitle("");

	dState = "1";
	storage.setInteger(null);
	setWorkercode("");
	setWorkername("");
	setWorkertitle("");
	setWorker2code("");
	setWorker2name("");
	setWorker2title("");

	try {
		setTo2(null);
	} catch(Exception e) {}
	unmountblocks = Boolean.TRUE;
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
/**
 * 
 * @param newComplectmodel java.lang.String
 */
public void setComplectmodel(java.lang.String newComplectmodel) {
	complectmodel = newComplectmodel;
}
/**
 * 
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
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
public void setFrom(StoragePlaceAccessBean s) {
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
public void setStorage(Integer newStorage) {
	storage.setInteger(newStorage);
}
public void setStoragecode(String newStorage) {
	storage.setString(newStorage);
}
public void setStorageFrm(String newStorage) {
	storage.setString(newStorage);
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
 * 
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
public void setTo(StoragePlaceAccessBean s) {
	if(s == null) return;
	try {
		ExpeditionAccessBean exp = new ExpeditionAccessBean();
		exp.setInitKey_storageplace(s.getStorageplace());
		exp.refreshCopyHelper();
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
public void setTo2(Integer to2)
	throws Exception
{
	storage.setInteger(to2);
	if(to2 != null) {
		setTransfer("true");
		try {
			StorageAccessBean s = new StorageAccessBean();
			s.setInitKey_storageplace(to2.intValue());
			s.refreshCopyHelper();
			storagename = s.getName();
		} catch(Exception e) {
		}
	} else {
		setTransfer("false");
		storagename = "";
	}
}
public void setTransfer(String newTransfer) {
	transferToStorage = newTransfer != null && "true".equals(newTransfer);
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 12:21:05)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
public void setUnmountblocks(java.lang.Boolean newUnmountblocks) {
	unmountblocks = newUnmountblocks;
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
	if(storage.getInteger() != null) {
		try {
			StorageAccessBean s = new StorageAccessBean();
			s.setInitKey_storageplace(storage.getInteger().intValue());
			s.refreshCopyHelper();
			storagename = s.getName();
		} catch(Exception e) {
		}
	}
	
	if("Edit".equals(getAction()) || "Delete".equals(getAction())) {
		if(doc.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingp.document"));
		}
		else if(!doc.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.document"));
		}
	}

	// Required fields check
	if(owner.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingp.owner"));
	}

	if(blanknumber != null && !"".equals(blanknumber)) {
		if(blanknumber.length() > 40) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.blanknumber"));
		}
	} else {
		blanknumber = "";
	}
	
	if(blanknumber.trim().length() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.empty"));
	} 
	
	if(blankindex.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.empty"));
	} else if(!blankindex.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.invalid"));
	}
	
	if(blankdate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingp.blankdate"));
	}

	if(position.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingp.position"));
	}

	if (!getComplectcode().equalsIgnoreCase(""))
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(new Integer(getComplectcode())))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.alertgsm"));
	
	if(complect.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingp.complect"));
	} else {
		if(!complect.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.complect"));
		}
		else {
			try {
				EquipmentSetAccessBean bean = new EquipmentSetAccessBean();
				bean.setInitKey_storageplace(complect.getInteger().intValue());
				bean.refreshCopyHelper();
				setComplect(bean);
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.dismantlingp.complect"));
			}
		}
	}

	if("P".equals(type)) {
		if(provider.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingp.provider"));
		}
		if((insuranseMan == null) || ("".equals(insuranseMan))) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingp.insuranceman"));
		}
	} else if("W".equals(type)) {
		if(worker.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingp.worker"));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.type"));
	}
		
	if (!errors.empty()) 
		throw new ValidationException();

	// Consistence check
	
	if(!owner.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.owner"));
	} else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(owner.getInteger().intValue());
			bean.refreshCopyHelper();
			setOwner(bean);
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.dismantlingp.owner"));
		}
	}

	if(blanknumber.length() > 40) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.blanknumber"));
	}

	if(!blankdate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.blankdate"));
	}

	if(!position.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.position"));
	} else {
		try {
			PositionAccessBean bean = constructPosition();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.dismantlingp.position"));
		}
	}

	if(!complect.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.complect"));
	}
	else {
		try {
			EquipmentSetAccessBean bean = new EquipmentSetAccessBean();
			bean.setInitKey_storageplace(complect.getInteger().intValue());
			bean.refreshCopyHelper();
			setComplect(bean);
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.dismantlingp.complect"));
		}
	}

	if("P".equals(type)) {
		if(!provider.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.provider"));
		}
		else {
			try {
				OrganizationAccessBean bean = new OrganizationAccessBean();
				bean.setInitKey_organization(provider.getInteger().intValue());
				bean.refreshCopyHelper();
				if(Boolean.FALSE.equals(bean.getIsprovider())) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.notprovider"));
				}
				setProvider(bean);
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.dismantlingp.provider"));
			}
		}
	} else if("W".equals(type)) {
		if(!worker.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.worker"));
		}
		else {
			try {
				constructWorker();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.dismantlingp.worker"));
			}
		}
	}
	
	if(com.hps.july.util.AppUtils.isNewInventory() && transferToStorage) {
		if(storage.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingp.storage2"));
		} else if(!storage.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.storage2"));
		} else {
			try {
				StorageAccessBean st = new StorageAccessBean();
				st.setInitKey_storageplace(storage.getInteger().intValue());
				st.refreshCopyHelper();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.storage2"));
			}
		}
	}

	if(!worker2.isEmpty()) {
		if(!worker2.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.worker2"));
		} else {
			try {
				constructWorker2();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.dismantlingp.worker2"));
			}
		}
	}

	if(!storageman.isEmpty()) {
//		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingp.storageman"));
		if(!storageman.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.storageman"));
		}
		else {
			try {
				constructStorageManager();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.dismantlingp.storageman"));
			}
		}
	}

	if(!"1".equals(getDState()) && !"2".equals(getDState())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingp.state"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
	/**
	 * @return
	 */
	public Boolean getMoveToComplect() {
		return moveToComplect;
	}

	/**
	 * @param boolean1
	 */
	public void setMoveToComplect(Boolean boolean1) {
		moveToComplect = boolean1;
	}

	/**
	 * @return
	 */
	public Integer getMoveToPositionCode() {
		return moveToPositionCode.getInteger();
	}

	/**
	 * @return
	 */
	public String getMoveToPositionid() {
		return moveToPositionid;
	}

	/**
	 * @return
	 */
	public String getMoveToPositionname() {
		return moveToPositionname;
	}

	/**
	 * @param property
	 */
	public void setMoveToPositionCode(Integer property) {
		moveToPositionCode.setInteger(property);
	}

	/**
	 * @param string
	 */
	public void setMoveToPositionid(String string) {
		moveToPositionid = string;
	}

	/**
	 * @param string
	 */
	public void setMoveToPositionname(String string) {
		moveToPositionname = string;
	}

	/**
	 * @return
	 */
	public Integer getMoveToComplectCode() {
		return moveToComplectCode.getInteger();
	}

	/**
	 * @return
	 */
	public String getMoveToComplectmodel() {
		return moveToComplectmodel;
	}

	/**
	 * @return
	 */
	public String getMoveToComplectname() {
		return moveToComplectname;
	}

	/**
	 * @param property
	 */
	public void setMoveToComplectCode(Integer property) {
		moveToComplectCode.setInteger(property);
	}

	/**
	 * @param string
	 */
	public void setMoveToComplectmodel(String string) {
		moveToComplectmodel = string;
	}

	/**
	 * @param string
	 */
	public void setMoveToComplectname(String string) {
		moveToComplectname = string;
	}

}
