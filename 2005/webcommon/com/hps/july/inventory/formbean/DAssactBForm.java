package com.hps.july.inventory.formbean;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.Connection;
import java.util.Enumeration;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.cdbc.objects.*;

/**
 * Форма ввода и редактирования шапки документа "Акт демонтажа блоков на позиции"
 */
public class DAssactBForm
	extends DocumentForm
{
	private int document;
	private StringAndSqlDateProperty blankdate;
	private java.lang.String blanknumber;
	private StringAndIntegerProperty blankindex;
	private java.lang.Integer ownercode;
	private com.hps.july.persistence.OrganizationAccessBean orgs;
	private com.hps.july.persistence.StoragePlaceAccessBean storageplace;
	private com.hps.july.persistence.WorkerAccessBean workers;
	private com.hps.july.persistence.StorageCardAccessBean agrs;
	private com.hps.july.persistence.WorkerAccessBean monters;
	private Integer positioncode;
	private String positionid;
	private String positionname;
	private Integer complectcode;
	private String complectname;
	private StringAndIntegerProperty montercode;
	private Integer agregatcode;
	private StringAndIntegerProperty workercode;
	private java.lang.String montername;
	private java.lang.String workername;
	private java.lang.String agregatname;
	private java.lang.String montertitle;
	private java.lang.String workertitle;
	private java.lang.String agregateserial;
	private java.lang.String oldconfig;
	private java.lang.String newconfig;

	private boolean transferToStorage;
	private StringAndIntegerProperty storage;
	private String storagename;
	private String dState;
	private java.lang.String agregatmodel;
	private boolean browseBySerial;
	private java.lang.String inventserial;
	private java.lang.String localserial;
	
	public DAssactBForm() {
		workercode = new StringAndIntegerProperty();
		montercode = new StringAndIntegerProperty();
		blankdate = new StringAndSqlDateProperty();
		blanknumber = "";
		blankindex = new StringAndIntegerProperty();
		montertitle = "";
		storage = new StringAndIntegerProperty();
		transferToStorage = false;
	}
	
public StorageCardAccessBean constructAgregates() throws Exception {

	if (agrs == null) {	
		// Construct Org bean
		if (getAgregateserial() != null) {
			StorageCardAccessBean bean = new StorageCardAccessBean();
			agrs = bean.findBySerial(getAgregateserial());
			setAgregatcode(new Integer(agrs.getStoragecard()));
		}
	}
	return agrs;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setDocument(keyGen.getNextKey("tables.documents"));
    AssemblingActAccessBean bean = new AssemblingActAccessBean(
	    getDocument(),
	    getOwnercode(),
	    getComplectcode(),
	    getExpeditioncode(),
	    getBlankdate(),
	    getBlankindex(),
	    getBlanknumber(),
	    "1",
	    Boolean.TRUE,
	    Boolean.TRUE,
//	    getMontercode(),
	    getAgregatcode(),
	    "D");
    bean.setAgregateresource(getAgregatcode());	
	return bean;
}
public ExpeditionAccessBean constructExpedition()
	throws Exception
{
	ExpeditionAccessBean exp = null;
	try {
		exp = new ExpeditionAccessBean();
		java.util.Enumeration en = exp.findExpeditionByExpeditor(new WorkerKey(workercode.getInteger().intValue()));
		if(en.hasMoreElements()) {
			exp = (ExpeditionAccessBean)en.nextElement();
			exp.refreshCopyHelper();
		} else {
			throw new Exception();
		}
	} catch(Exception e) {
		exp = new ExpeditionAccessBean();
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		exp = new ExpeditionAccessBean(
			keyGen.getNextKey("tables.storageplaces"), null, "", ""
		);
		WorkerAccessBean w = constructWorkers();
		exp.setOrganization(null);
		exp.setExpeditor((Worker)w.getEJBRef());
		exp.setName(w.getMan().getLastname());
		exp.commitCopyHelper();
	}
	
	return exp;
}
public WorkerAccessBean constructMonters() throws Exception {
	if (monters == null) {	
		// Construct Org bean
		if (!montercode.isEmpty()) 
		  if (montercode.isOk()) {
				monters = new WorkerAccessBean();
				monters.setInitKey_worker(getMontercode().intValue());
				monters.refreshCopyHelper();
		  }
	}
	return monters;
}
public OrganizationAccessBean constructOrganizations() throws Exception {

	if (orgs == null) {	
		// Construct Org bean
		if (getOwnercode() != null) {
			orgs = new OrganizationAccessBean();
			orgs.setInitKey_organization(getOwnercode().intValue());
			orgs.refreshCopyHelper();
		}
	}
	return orgs;
}
public StoragePlaceAccessBean constructStorages() throws Exception {
//	if(storageplace == null) {	
		if (getComplectcode() != null) {
			storageplace = new StoragePlaceAccessBean();
			storageplace.setInitKey_storageplace(getComplectcode().intValue());
			storageplace.refreshCopyHelper();
		}
//	}
	return storageplace;
}
public WorkerAccessBean constructWorkers() throws Exception {
	if (workers == null) {	
		// Construct Org bean
		if (!workercode.isEmpty()) 
		  if (workercode.isOk()) {
				workers = new WorkerAccessBean();
				workers.setInitKey_worker(getWorkercode().intValue());
				workers.refreshCopyHelper();
		  }
	}
	return workers;
}
public void fillPosition(PositionAccessBean newPosition) throws Exception {
	if (newPosition == null) {
		positioncode = null;
		positionname = "";
		positionid = "";
	} else {
		positioncode = new Integer(newPosition.getStorageplace());
		positionname = newPosition.getName();
		positionid = "";
		if(newPosition.getGsmid() != null) {
			positionid = positionid + "D" + newPosition.getGsmid();
		}
		positionid = positionid + " ";
		if(newPosition.getDampsid() != null) {
			positionid = positionid + "A" + newPosition.getDampsid();
		}
	}
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	
	try {
		AssemblingActAccessBean abean = (AssemblingActAccessBean)bean;
		setOldconfig(abean.getOldConfiguration());
		setNewconfig(abean.getNewConfiguration());

		Integer key = abean.getAgregateresource();
		if(key!=null){
			ResourceAccessBean rab = new ResourceAccessBean();
			rab.setInitKey_resource(key.intValue());
			setAgregatcode(new Integer(rab.getResource()));
			setAgregatname(rab.getName());
			setAgregatmodel(rab.getModel());
		}
		
	} catch (Exception e) {
		e.printStackTrace(System.out);
		setOldconfig("");
		setNewconfig("");
	}

	
	/*if(com.hps.july.util.AppUtils.getInventoryVariant() == 2) {
		if(getAgregateserial() != null && !"".equals(getAgregateserial())) {
			try {
				StorageCardAccessBean sc = (new StorageCardAccessBean()).findBySerial(getAgregateserial());
				agregatcode = new Integer(sc.getStoragecard());
				String s = sc.getResource().getName();
				if (sc.getResource().getModel() != null)
					s = s + ", " + sc.getResource().getModel();
				agregatname = s;
				agregateserial = sc.getSerialnumber();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
	}*/
}
public StorageCard getAgregat() throws Exception {
	if(AppUtils.getInventoryVariant() == 2) {
		return null;
	}
	StorageCardAccessBean bean = constructAgregates();
	if (bean != null) {
	  bean.refreshCopyHelper();
	  return (StorageCard)bean.getEJBRef();
	} else {
	  return null;
	}
}
public java.lang.Integer getAgregatcode() {
	return agregatcode;
}
public java.lang.String getAgregateserial() {
	return agregateserial;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 10:49:16)
 * @return java.lang.String
 */
public java.lang.String getAgregatmodel() {
	return agregatmodel;
}
public java.lang.String getAgregatname() {
	return agregatname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 13:30:48)
 * @return java.sql.Date
 */
public java.sql.Date getBlankdate() {
	return blankdate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 13:32:29)
 * @return java.lang.String
 */
public java.lang.String getBlankdateFrm() {
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
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 13:34:36)
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
public java.lang.Integer getComplectcode() {
	return complectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 14:13:40)
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	AssemblingActAccessBean bean = new AssemblingActAccessBean();
	bean.setInitKey_document( getDocument() );
	if(getAgregatcode()!=null){	
		bean.setAgregateresource(getAgregatcode());
	}	
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 13:04:45)
 * @return int
 */
public int getDocument() {
	return document;
}
public Integer getDocumentId() {
	return new Integer(document);
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getdState() {
	try{
		AssemblingActAccessBean bean = new AssemblingActAccessBean();
		bean.setInitKey_document(getDocument());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return "1";
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDState() {
	try{
		AssemblingActAccessBean bean = new AssemblingActAccessBean();
		bean.setInitKey_document(getDocument());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return "1";
	}
}
public java.lang.Integer getExpeditioncode() {
	try {
		return new Integer(constructExpedition().getStorageplace());
	} catch(Exception e) {
		return null;
	}
}
public StoragePlace getFrom() throws Exception {
	try {
		StoragePlaceAccessBean bean = constructStorages();
		if (bean != null) {
			return (StoragePlace)javax.rmi.PortableRemoteObject.narrow(bean.getEJBRef(),StoragePlace.class);
		} else
		  return null;
	} catch(Exception e) {
		//System.out.println("### getFrom()");
		e.printStackTrace(System.out);
		throw e;
	}
}
public java.util.ListIterator getListItems() {
	com.hps.july.cdbc.objects.CDBCDocuments c = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = c.listDemountBlocksItems(new Integer(getDocument()),new Integer(1));
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public Worker getMonter() throws Exception {

	WorkerAccessBean bean = constructMonters();
	if (bean != null)
	  return (Worker)bean.getEJBRef();
	else
	  return null;
}
public java.lang.Integer getMontercode() {
	return montercode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 15:15:07)
 * @return java.lang.String
 */
public java.lang.String getMontercodeFrm() {
	return montercode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 10:00:50)
 * @return java.lang.String
 */
public java.lang.String getMontername() {
	return montername;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 11:01:57)
 * @return java.lang.String
 */
public java.lang.String getMontertitle() {
	return montertitle;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 15:06:45)
 * @return java.lang.String
 */
public java.lang.String getNewconfig() {
	return newconfig;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 15:06:30)
 * @return java.lang.String
 */
public java.lang.String getOldconfig() {
	return oldconfig;
}
public Organization getOwner() throws Exception {

	OrganizationAccessBean bean = constructOrganizations();
	if (bean != null) {
		bean.refreshCopyHelper();
		return (Organization)bean.getEJBRef();
	} else {
	  return null;
	}
}
public java.lang.Integer getOwnercode() {
	return ownercode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2002 16:12:47)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getOwners() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
public java.lang.Integer getPositioncode() {
	return positioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 14:40:47)
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 14:40:47)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
public Boolean getReadonly() {
	return new Boolean(!("1".equals(getDState()) && !getIsautodoc()));
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.inventory.APPStates.EDITDASSB;
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
public Worker getStorageManager() throws Exception {
	/*
	WorkerAccessBean bean = constructWorkers();
	if (bean != null)
		return (Worker)bean.getEJBRef();
	else
		return null;
	*/
	return null;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStoragename() {
	return storagename;
}
public StoragePlace getTo() throws Exception {
	try {
		ExpeditionAccessBean bean = constructExpedition();
		if (bean != null) {
			return (StoragePlace)javax.rmi.PortableRemoteObject.narrow(bean.getEJBRef(),StoragePlace.class);
		} else {
			return null;
		}
	} catch(Exception e) {
		//System.out.println("### getTo()");
		e.printStackTrace(System.out);
		throw e;
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
public java.lang.Integer getWorkercode() {
	return workercode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 9:59:47)
 * @return java.lang.String
 */
public java.lang.String getWorkercodeFrm() {
	return workercode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 10:01:02)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 11:02:11)
 * @return java.lang.String
 */
public java.lang.String getWorkertitle() {
	return workertitle;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	orgs = null;
	storageplace = null;
	workers = null;
	agrs = null;
	monters = null;
	positioncode = null;
	positionid = "";
	positionname = "";
	complectcode = null;
	complectname = "";
	agregatcode = null;
	montername = "";
	workername = "";
	agregatname = "";
	montertitle = "";
	workertitle = "";
	agregateserial = "";
	oldconfig = "";
	newconfig = "";
	
	workercode = new StringAndIntegerProperty();
	montercode = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	blanknumber = "";
	blankindex = new StringAndIntegerProperty();
	montertitle = "";
	storage = new StringAndIntegerProperty();
	transferToStorage = false;
	storagename = "";
	dState = "1";
	ownercode = null;

	super.initRecord(request);
	document = 0;
	try {
		DAssactBListForm aform = (DAssactBListForm)request.getSession().getAttribute( "DAssactBListForm" );
		setOwnercode(aform.getOrganization());
		setPositioncode(aform.getPosition());
		setPositionname(aform.getPositionname());
		setPositionid(aform.getPositionid());
	} catch (Exception e) {
	}
	setInventserial("");
	setLocalserial("");
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 10:51:18)
 * @return boolean
 */
public boolean isBrowseBySerial() {
	return browseBySerial;
}
public void setAgregat(StorageCardAccessBean newStorage) throws Exception {
	if(AppUtils.getInventoryVariant() == 2) {
		return;
	}
	if (newStorage == null) {
	    agregatcode = null;
	    agregateserial = "";
	    agregatname = "";
	}
	else {
		agregatcode = new Integer(newStorage.getStoragecard());
		String s = newStorage.getResource().getName();
		if (newStorage.getResource().getModel() != null)
			s = s + ", " + newStorage.getResource().getModel();
		agregatname = s;
		agregateserial = newStorage.getSerialnumber();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 9:56:10)
 * @param newAgregatcode java.lang.Integer
 */
public void setAgregatcode(java.lang.Integer newAgregatcode) {
	agregatcode = newAgregatcode;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 11:16:50)
 * @param newAgregateserial java.lang.String
 */
public void setAgregateserial(java.lang.String newAgregateserial) {
	agregateserial = newAgregateserial;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 10:49:16)
 * @param newAgregatmodel java.lang.String
 */
public void setAgregatmodel(java.lang.String newAgregatmodel) {
	agregatmodel = newAgregatmodel;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 10:38:24)
 * @param newAgregatname java.lang.String
 */
public void setAgregatname(java.lang.String newAgregatname) {
	agregatname = newAgregatname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 13:30:48)
 * @param newBlankdate java.sql.Date
 */
public void setBlankdate(java.sql.Date newBlankdate) {
	blankdate.setSqlDate(newBlankdate);
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 13:32:29)
 * @param newBlankdateFrm java.lang.String
 */
public void setBlankdateFrm(java.lang.String newBlankdateFrm) {
	blankdate.setString(newBlankdateFrm);
}
public void setBlankindex(int newBlankindex) {
	blankindex.setInteger(new Integer(newBlankindex));
}
public void setBlankindexFrm(String newBlankindex) {
	blankindex.setString(newBlankindex);
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 13:34:36)
 * @param newBlanknumber java.lang.String
 */
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 10:51:18)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 14:13:40)
 * @param newComplectcode java.lang.Integer
 */
public void setComplectcode(java.lang.Integer newComplectcode) {
	complectcode = newComplectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 14:13:40)
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 13:04:45)
 * @param newDocument int
 */
public void setDocument(int newDocument) {
	document = newDocument;
}
public void setFrom(StoragePlaceAccessBean newStorage) throws Exception {
	if (newStorage == null) {
		complectcode = null;
		positioncode = null;
	}
	else {
		EquipmentSetAccessBean b = new EquipmentSetAccessBean();
		b.setInitKey_storageplace(newStorage.getStorageplace());
		b.refreshCopyHelper();
		complectcode = new Integer(newStorage.getStorageplace());
		complectname = com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(b);
		fillPosition(b.getPosition());
	}
}
public void setMonter(WorkerAccessBean newWorker) throws Exception {
	if (newWorker == null) {
	    montercode.setString("");
	    montername = "";
	    montertitle = "";
	}
	else {
		montercode.setInteger(new Integer(newWorker.getWorker()));
	    montername = newWorker.getMan().getFullName();
	    montertitle = newWorker.getPosition().getName();
	}
}
public void setMontercode(java.lang.Integer newMontercode) {
	montercode.setInteger(newMontercode);
}
public void setMontercodeFrm(java.lang.String newMontercodeFrm) {
	montercode.setString(newMontercodeFrm);
}
public void setMontername(java.lang.String newMontername) {
	montername = newMontername;
}
public void setMontertitle(java.lang.String newMontertitle) {
	montertitle = newMontertitle;
}
public void setNewconfig(java.lang.String newNewconfig) {
	newconfig = newNewconfig;
}
public void setOldconfig(java.lang.String newOldconfig) {
	oldconfig = newOldconfig;
}
public void setOwner(OrganizationAccessBean newOwner) throws Exception {
	if (newOwner == null) {
	    ownercode = null;
	}
	else {
		ownercode = new Integer(newOwner.getOrganization());
	}
}
public void setOwnercode(java.lang.Integer newOwnercode) {
	ownercode = newOwnercode;
}
public void setPositioncode(java.lang.Integer newPositioncode) {
	positioncode = newPositioncode;
}
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
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
public void setStorageManager(WorkerAccessBean newWorker) throws Exception {
	/*
	if (newWorker == null) {
	    workercode.setString("");
	    workername = "";
	    workertitle = "";
	}
	else {
		workercode.setInteger(new Integer(newWorker.getWorker()));
	    workername = newWorker.getMan().getFullName();
	    workertitle = newWorker.getPosition().getName();
	}
	*/
}
/**
 * 
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
public void setTo(StoragePlaceAccessBean newStorage) throws Exception {
	if (newStorage == null) {
		workercode.setString("");
		workername = "";
		workertitle = "";
	}
	else {
		try {
		ExpeditionAccessBean b = new ExpeditionAccessBean();
		b.setInitKey_storageplace(newStorage.getStorageplace());
		b.refreshCopyHelper();
		if(b.getExpeditor() != null) {
			workercode.setInteger(new Integer(b.getExpeditor().getWorker()));
			workername = b.getExpeditor().getMan().getFullName();
			workertitle = b.getExpeditor().getPosition().getName();
		} else {
			workercode = null;
		}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
public void setTo2(Integer to2)
	throws Exception
{
	storage.setInteger(to2);
	if(to2 != null) {
		try {
			StorageAccessBean s = new StorageAccessBean();
			s.setInitKey_storageplace(to2.intValue());
			s.refreshCopyHelper();
			storagename = s.getName();
		} catch(Exception e) {
		}
	}
}
public void setTransfer(String newTransfer) {
	transferToStorage = newTransfer != null && "true".equals(newTransfer);
}
public void setWorkercode(java.lang.Integer newWorkercode) {
	workercode.setInteger(newWorkercode);
}
public void setWorkercodeFrm(java.lang.String newWorkercodeFrm) {
	workercode.setString(newWorkercodeFrm);
}
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
public void setWorkertitle(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
}

/**
 * @return
 */
public java.lang.String getInventserial() {
	return inventserial;
}

/**
 * @return
 */
public java.lang.String getLocalserial() {
	return localserial;
}

/**
 * @param string
 */
public void setInventserial(java.lang.String string) {
	inventserial = string;
}

/**
 * @param string
 */
public void setLocalserial(java.lang.String string) {
	localserial = string;
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

	setBrowseBySerial(false);

	if(agregatcode==null){
		setAgregatmodel("");
		setAgregatname("");
	}

	if (agregatcode==null) {
		// Find resource by serialnumber/party if its empty
		if (getAgregateserial() != null && getAgregateserial().length() > 0) {
				// Only serial number specified - find resource by serial number

				Connection conn = null;
				int result = 0;

				try {
					
					conn = new JdbcConnection().getConnection();
					result = CDBCStoragecardsObject.findBySerialM(conn,getAgregateserial());
					
				} catch(Exception e) {
					e.printStackTrace(System.err);
				}finally{
					try{
						if(conn!=null) conn.close();
					}catch(Exception e){
						e.printStackTrace(System.err);
					}
					
				}

				if(result >= 2){
					setBrowseBySerial(true);
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assemblingppos.several"));
					throw new ValidationException();
				}	
				
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(getAgregateserial());
					agregatcode = new Integer(card.getResource().getResource());
					agregatname = card.getResource().getName();
					agregatmodel = card.getResource().getModel();
					setInventserial(card.getManufserial());
					setLocalserial(card.getLocalserial());
				} catch(Exception e) {
					e.printStackTrace();
				}	
		}
	}


	if (getComplectcode()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectcode()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.alertgsm"));
	
	if (getOwnercode() == null)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactb.owner"));
	else {
		try {
			constructOrganizations();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactb.owner"));
		}
	}
//System.out.println("COMCODE:"+getComplectcode());
	if (getPositioncode() == null)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactb.position"));
	else {
		try {
			constructStorages();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactb.position"));
		}
	}

	if (getComplectcode() == null)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactb.complect"));
	else {
		try {
			constructStorages();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactb.complect"));
		}
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
	
	if (blankdate.isEmpty())
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactb.date"));
	else if (!blankdate.isOk())
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactb.date"));
	
	if ((agregateserial == null) || (agregateserial.length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactb.agregat"));
	else {
		/*try {
			constructAgregates();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactb.agregat"));
		}*/
	}

	if(AppUtils.isNewInventory() && transferToStorage) {
		if(storage.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactb.storage2"));
		} else if(!storage.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactb.storage2"));
		} else {
			try {
				StorageAccessBean st = new StorageAccessBean();
				st.setInitKey_storageplace(storage.getInteger().intValue());
				st.refreshCopyHelper();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactb.storage2"));
			}
		}
	}
	
	if (workercode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactb.worker"));
	} else if (!workercode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactb.worker"));
	} else {
		try {
			constructWorkers();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactb.worker"));
		}
	}
	  
	if (!montercode.isEmpty()) {
//	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactb.monter"));
//	else
		if (!montercode.isOk())
		  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactb.monter"));
		else {
			try {
				constructMonters();
			} catch (Exception ex) {
				if (ErrorProcessor.isRecordNotExistException(ex))
				  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactb.monter"));
			}
		}
	} 
	  
	if (!errors.empty())
		throw new ValidationException();
}

}
