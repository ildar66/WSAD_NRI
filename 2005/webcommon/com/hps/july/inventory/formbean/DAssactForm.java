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
 * Форма ввода и редактирования документа "Акт демонтажа блоков на складе"
 */
public class DAssactForm
	extends DocumentForm
{
	private int document;
	private StringAndSqlDateProperty blankdate;
	private StringAndIntegerProperty blankindex;
	private String blanknumber;
	private Integer ownercode;
	private Integer storagecode;
	private StringAndIntegerProperty montercode;
	private Integer agregatcode;
	private StringAndIntegerProperty workercode;
	private String montername;
	private String workername;
	private String agregatname;
	private String montertitle;
	private String workertitle;
	private String agregateserial;
	private String oldconfig;
	private String newconfig;

	private String storagename;
	private String dState;
	private java.lang.String agregatmodel;
	private boolean browseBySerial;
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 9:57:16)
 */
public DAssactForm() {
	workercode = new StringAndIntegerProperty();
	montercode = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	blanknumber = "";
	blankindex = new StringAndIntegerProperty();
}
public StorageCardAccessBean constructAgregates() throws Exception {
	StorageCardAccessBean agrs = null;
	// Construct Org bean
	if (getAgregateserial() != null) {
		StorageCardAccessBean bean = new StorageCardAccessBean();
		agrs = bean.findBySerial(getAgregateserial());
		setAgregatcode(new Integer(agrs.getStoragecard()));
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
    AssemblingActAccessBean bean = 
    	new AssemblingActAccessBean(
	    	getDocument(),
	    	getOwnercode(),
	    	getStoragecode(),
			getStoragecode(),
			getBlankdate(),
			getBlankindex(),
			getBlanknumber(),
			"1",
			Boolean.TRUE,
			Boolean.TRUE,
//			getMontercode(),
			getAgregatcode(),
			"D"
		);
    bean.setAgregateresource(getAgregatcode());	
	return bean;
}
public WorkerAccessBean constructMonters() throws Exception {
	WorkerAccessBean monters = null;
	// Construct Org bean
	if (!montercode.isEmpty()) 
	  if (montercode.isOk()) {
			monters = new WorkerAccessBean();
			monters.setInitKey_worker(getMontercode().intValue());
			monters.refreshCopyHelper();
	  }
	return monters;
}
public OrganizationAccessBean constructOrganizations() throws Exception {
	OrganizationAccessBean orgs = null;
	// Construct Org bean
	if (getOwnercode() != null) {
		orgs = new OrganizationAccessBean();
		orgs.setInitKey_organization(getOwnercode().intValue());
		orgs.refreshCopyHelper();
	}
	return orgs;
}
public StorageAccessBean constructStorages() throws Exception {
	if (getStoragecode() != null) {
		StorageAccessBean storages = new StorageAccessBean();
		storages.setInitKey_storageplace(getStoragecode().intValue());
		storages.refreshCopyHelper();
		storagename = storages.getName();
		return storages;
	} else {
		return null;
	}
}
public WorkerAccessBean constructWorkers() throws Exception {
	WorkerAccessBean workers = null;
	// Construct Org bean
	if (!workercode.isEmpty()) 
	  if (workercode.isOk()) {
			workers = new WorkerAccessBean();
			workers.setInitKey_worker(getWorkercode().intValue());
			workers.refreshCopyHelper();
	  }
	return workers;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	try {
		AssemblingActAccessBean abean = (AssemblingActAccessBean)bean;
		Integer key = abean.getAgregateresource();
		if(key!=null){
			ResourceAccessBean rab = new ResourceAccessBean();
			rab.setInitKey_resource(key.intValue());
			setAgregatcode(new Integer(rab.getResource()));
			setAgregatname(rab.getName());
			setAgregatmodel(rab.getModel());
		}
		setOldconfig(abean.getOldConfiguration());
		setNewconfig(abean.getNewConfiguration());
		//setDocState(abean.getDocumentState());
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
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 9:56:10)
 * @return java.lang.Integer
 */
public java.lang.Integer getAgregatcode() {
	return agregatcode;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 11:16:50)
 * @return java.lang.String
 */
public java.lang.String getAgregateserial() {
	return agregateserial;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2005 16:30:18)
 * @return java.lang.String
 */
public java.lang.String getAgregatmodel() {
	return agregatmodel;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 10:38:24)
 * @return java.lang.String
 */
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
public StoragePlace getFrom() throws Exception {
	StorageAccessBean bean = constructStorages();
	if (bean != null)
	  return (StoragePlace)bean.getEJBRef();
	else
	  return null;
}
public java.util.ListIterator getListItems() {
	com.hps.july.cdbc.objects.CDBCDocuments c = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = c.listStorageDemountItems(new Integer(getDocument()),new Integer(1));
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
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 15:14:47)
 * @return java.lang.Integer
 */
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
 * Creation date: (08.08.2002 15:11:14)
 * @return java.lang.String
 */
public java.lang.String getNewconfig() {
	return newconfig;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 15:10:49)
 * @return java.lang.String
 */
public java.lang.String getOldconfig() {
	return oldconfig;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public Organization getOwner() throws Exception {

	OrganizationAccessBean bean = constructOrganizations();
	if (bean != null) {
		bean.refreshCopyHelper();
		return (Organization)bean.getEJBRef();
	} else {
	  return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 13:44:11)
 * @return java.lang.Integer
 */
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
public Boolean getReadonly() {
	return new Boolean(!("1".equals(getDState()) && !getIsautodoc() && ("View".equals(getAction()) || "Edit".equals(getAction()))));
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.inventory.APPStates.EDITDASS;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 14:48:27)
 * @return java.lang.Integer
 */
public java.lang.Integer getStoragecode() {
	return storagecode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public Worker getStorageManager() throws Exception {

	WorkerAccessBean bean = constructWorkers();
	if (bean != null)
	  return (Worker)bean.getEJBRef();
	else
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
	StorageAccessBean bean = constructStorages();
	if (bean != null) {
		bean.refreshCopyHelper();
	  return (StoragePlace)bean.getEJBRef();
	} else {
	  return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 9:59:28)
 * @return java.lang.Integer
 */
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
	ownercode = null;
	storagecode = null;
	agregatcode = null;
	montername = "";
	workername = "";
	agregatname = "";
	montertitle = "";
	workertitle = "";
	agregateserial = "";
	oldconfig = "";
	newconfig = "";

	storagename = "";
	dState = "1";

	workercode = new StringAndIntegerProperty();
	montercode = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	blanknumber = "";
	blankindex = new StringAndIntegerProperty();

	super.initRecord(request);
	document = 0;
	try {
		DAssactListForm aform = (DAssactListForm)request.getSession().getAttribute( "DAssactListForm" );
		setOwnercode(aform.getOwner().getInteger());
		setStoragecode(aform.getStorage().getInteger());
	} catch (Exception e) {
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2005 16:30:56)
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
 * Creation date: (15.07.2005 16:30:18)
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
 * Creation date: (15.07.2005 16:30:56)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
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
	    storagecode = null;
	    storagename = "";
	}
	else {
		storagecode = new Integer(newStorage.getStorageplace());
		storagename = newStorage.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
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
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 15:14:47)
 * @param newMontercode java.lang.Integer
 */
public void setMontercode(java.lang.Integer newMontercode) {
	montercode.setInteger(newMontercode);
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 15:15:07)
 * @param newMontercodeFrm java.lang.String
 */
public void setMontercodeFrm(java.lang.String newMontercodeFrm) {
	montercode.setString(newMontercodeFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 10:00:50)
 * @param newMontername java.lang.String
 */
public void setMontername(java.lang.String newMontername) {
	montername = newMontername;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 11:01:57)
 * @param newMontertitle java.lang.String
 */
public void setMontertitle(java.lang.String newMontertitle) {
	montertitle = newMontertitle;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 15:11:14)
 * @param newNewconfig java.lang.String
 */
public void setNewconfig(java.lang.String newNewconfig) {
	newconfig = newNewconfig;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 15:10:49)
 * @param newOldconfig java.lang.String
 */
public void setOldconfig(java.lang.String newOldconfig) {
	oldconfig = newOldconfig;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setOwner(OrganizationAccessBean newOwner) throws Exception {
	if (newOwner == null) {
	    ownercode = null;
	}
	else {
		ownercode = new Integer(newOwner.getOrganization());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 13:44:11)
 * @param newOwnercode java.lang.Integer
 */
public void setOwnercode(java.lang.Integer newOwnercode) {
	ownercode = newOwnercode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 14:48:27)
 * @param newStoragecode java.lang.Integer
 */
public void setStoragecode(java.lang.Integer newStoragecode) {
	storagecode = newStoragecode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setStorageManager(WorkerAccessBean newWorker) throws Exception {
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
}
/**
 * 
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 9:59:28)
 * @param newWorkercode java.lang.Integer
 */
public void setWorkercode(java.lang.Integer newWorkercode) {
	workercode.setInteger(newWorkercode);
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 9:59:47)
 * @param newWorkercodeFrm java.lang.String
 */
public void setWorkercodeFrm(java.lang.String newWorkercodeFrm) {
	workercode.setString(newWorkercodeFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 10:01:02)
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 11:02:11)
 * @param newWorkertitle java.lang.String
 */
public void setWorkertitle(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
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
				} catch(Exception e) {
					e.printStackTrace();
				}	
		}
	}
	
	if (getOwnercode() == null)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassact.owner"));
	else {
		try {
			constructOrganizations();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassact.owner"));
		}
	}
	
	if (getStoragecode() == null)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassact.storage"));
	else {
		try {
			constructStorages();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassact.storage"));
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
	  
	if (blankdate.isEmpty())
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassact.date"));
	else if (!blankdate.isOk())
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassact.date"));
	
	/*if ((agregateserial == null) || (agregateserial.length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassact.agregat"));
	else {
		try {
			constructAgregates();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassact.agregat"));
		}
	}*/
	
	if (!workercode.isEmpty())
	    if (!workercode.isOk())
	       errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassact.worker"));
		else {
			try {
				constructWorkers();
			} catch (Exception ex) {
				if (ErrorProcessor.isRecordNotExistException(ex))
				  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassact.worker"));
			}
		}
		
	if (montercode.isEmpty())
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassact.monter"));
	else if (!montercode.isOk())
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassact.monter"));
	else {
		try {
			constructMonters();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassact.monter"));
		}
	}
	  
	  
	if (!errors.empty())
		throw new ValidationException();
}
}
