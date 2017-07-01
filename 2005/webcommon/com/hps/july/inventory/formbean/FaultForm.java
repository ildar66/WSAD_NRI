package com.hps.july.inventory.formbean;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.Connection;
import java.math.BigDecimal;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.Enumeration;
import java.util.Calendar;
import java.util.Vector;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.*;

/**
 * Форма ввода и редактирования документа "Fault Report"
 */
public class FaultForm
	extends DocumentForm
{
	private StringAndIntegerProperty owner;
	private String ownername;
	
	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	
	private StringAndSqlDateProperty blankdate;
	
	private StringAndIntegerProperty worker;
	private String workername;
	private String workertitle;

	private StringAndIntegerProperty division;
	private String divisionname;

	private String placetype;

		private StringAndIntegerProperty position;
		private String positionname;
		private String positionid;

		private StringAndIntegerProperty complect;
		private String complectname;

		private StringAndIntegerProperty storage;
		private String storagename;
	
	private String deviceserial;
	private String devicename;
	private int device;

	// Malformed resource
	private StringAndIntegerProperty mres;
	private String mresname;
	private String mresmodel;
	private String msn;
	private String mms;
	private String comments;

	// Replaced by
	private StringAndIntegerProperty rres;
	private String rresname;
	private String rresmodel;
	private String rsn;
	private String rms;

	// additional params
	private int document;
	private StringAndIntegerProperty expedition;

	private String dState;

	private java.math.BigDecimal price;

	private Integer storageplace;
	private boolean browseBySerialMsn;
	private boolean browseBySerialRsn;
	private boolean browseBySerialD;
	private java.lang.String devicemodel;
	private java.lang.Integer devicecode;
public FaultForm() {
	owner = new StringAndIntegerProperty();
	blankindex = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	worker = new StringAndIntegerProperty();
	division = new StringAndIntegerProperty();
	storage = new StringAndIntegerProperty();

	placetype = "P";

		position = new StringAndIntegerProperty();
		complect = new StringAndIntegerProperty();

	// Malformed resource
	mres = new StringAndIntegerProperty();

	// Replaced by
	rres = new StringAndIntegerProperty();

	// additional params
	expedition = new StringAndIntegerProperty();

	dState = "1";

	price = new BigDecimal("0.00");

	browseBySerialMsn = false;
	browseBySerialRsn = false;
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	super.afterUpdate(bean,request); // Support for document calculation
	if("Add".equals(getAction())) {
		setAction("Edit");
	}
	// find or create position for document
	/*
	boolean createNew = false;
	try {
		Enumeration en = (new DocumentPositionAccessBean()).findDocumentPositionByDocument(new DocumentKey(document.getInteger().intValue()));
		if(en.hasMoreElements()) {
			DocumentPositionAccessBean dp = (DocumentPositionAccessBean)en.nextElement();
			dp.setResource((Resource)constructResource().getEJBRef());
			dp.setSerialnumber(serialnumber);
			dp.setNotes(notes);
			dp.commitCopyHelper();
		} else {
			createNew = true;
		}
	} catch(Exception e) {
		createNew = true;
	}
	if(createNew) {
		try {
			KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
			int docpos = keyGen.getNextKey("tables.docpositions");
			DocumentPositionAccessBean dp = new DocumentPositionAccessBean(
				docpos,
				resource.getInteger(),
				owner.getInteger(),
				document.getInteger(),
				1,
				new java.math.BigDecimal("1.0"),
				price,
				Boolean.FALSE,
				Boolean.FALSE,
				Boolean.TRUE,
				Boolean.TRUE,
				Boolean.FALSE,
				Boolean.FALSE
			);
			dp.setSerialnumber(serialnumber);
			dp.setNotes(notes);
			dp.commitCopyHelper();
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	*/
}
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
		FaultReportAccessBean f = (FaultReportAccessBean)bean;
		f.setBlankindex(blankindex.getInteger().intValue());
		f.setBlanknumber(blanknumber);
		f.setBlankdate(blankdate.getSqlDate());
		f.setOwner((Organization)constructOwner().getEJBRef());
		if(storageplace!=null){
			f.setFrom((StoragePlace)constructStorageplace().getEJBRef());
			f.setTo((StoragePlace)constructStorageplace().getEJBRef());
		}
		f.setDivision((Division)constructDivision().getEJBRef());
		f.setTechStuff((Worker)constructWorker().getEJBRef());
		f.setEqplace(placetype);
		if(com.hps.july.util.AppUtils.getInventoryVariant() == 2) {
			f.setAgregateserial(getDeviceserial());
		} else {
			try {
				f.setOldagregate((StorageCard)constructDevice().getEJBRef());
			} catch(Exception e) {
				e.printStackTrace(System.out);
				f.setOldagregate(null);
			}
		}
		f.setOldserial(msn);
		f.setNewserial(rsn);
		f.setOldresource(mres.getInteger());
		f.setNewresource(rres.getInteger());
		f.setComment(comments);
		
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setDocument(keyGen.getNextKey("tables.documents"));

	FaultReportAccessBean bean = new FaultReportAccessBean(
		getDocument(), // int argDocument
		owner.getInteger(), // java.lang.Integer argOwner
		storageplace, // java.lang.Integer argFrom
		storageplace, // java.lang.Integer argTo
		blankdate.getSqlDate(), // java.sql.Date argBlankDate
		getBlankindex().getInteger().intValue(), // int argBlankindex
		blanknumber, // java.lang.String argBlankNumber
		"1", // java.lang.String argState
		Boolean.TRUE, // java.lang.Boolean argProcessSource
		Boolean.TRUE, // java.lang.Boolean argProcessDestination
		division.getInteger(), // java.lang.Integer argDivision
		worker.getInteger(), // java.lang.Integer argTechStuff
		placetype, // java.lang.String argEqPlace
		msn // java.lang.String argOldSerial
	);
	bean.setAgregateresource(getDevicecode());
	bean.setAgregateserial(getDeviceserial());
	return bean;
}
private StorageCardAccessBean constructDevice() throws java.lang.Exception {
	StorageCardAccessBean bean = new StorageCardAccessBean();
	bean.setInitKey_storagecard(device);
	bean.refreshCopyHelper();
	return bean;
}
private DivisionAccessBean constructDivision() throws java.lang.Exception {
	DivisionAccessBean bean = new DivisionAccessBean();
	bean.setInitKey_division(division.getInteger().intValue());
	bean.refreshCopyHelper();
	return bean;
}
private OrganizationAccessBean constructOwner() throws java.lang.Exception {
	OrganizationAccessBean bean = new OrganizationAccessBean();
	bean.setInitKey_organization(owner.getInteger().intValue());
	bean.refreshCopyHelper();
	return bean;
}
private PositionAccessBean constructPosition() throws java.lang.Exception {
	PositionAccessBean bean = new PositionAccessBean();
	bean.setInitKey_storageplace(position.getInteger().intValue());
	bean.refreshCopyHelper();
	setPositionAttribute(bean);
	return bean;
}
private StoragePlaceAccessBean constructStorageplace() throws java.lang.Exception {
	StoragePlaceAccessBean bean = new StoragePlaceAccessBean();
	bean.setInitKey_storageplace(storageplace.intValue());
	bean.refreshCopyHelper();
	return bean;
}
private WorkerAccessBean constructWorker() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(worker.getInteger().intValue());
	bean.refreshCopyHelper();
	setWorkername(bean.getMan().getFullName());
	setWorkertitle(bean.getPosition().getName());
	return bean;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	FaultReportAccessBean ab = (FaultReportAccessBean)bean;
	try {
		OrganizationAccessBean o = ab.getOwner();
		if(o != null) {
			owner.setInteger(new Integer(o.getOrganization()));
			ownername = o.getName();
		} else {
			owner.setInteger(null);
			ownername = "";
		}
		DivisionAccessBean d = ab.getDivision();
		if(d != null) {
			division.setInteger(new Integer(d.getDivision()));
			divisionname = d.getName();
		} else {
			division.setInteger(null);
			divisionname = "";
		}
		WorkerAccessBean w = ab.getTechStuff();
		if(w != null) {
			worker.setInteger(new Integer(w.getWorker()));
			workername = w.getMan().getFullName();
			workertitle = w.getPosition().getName();
		} else {
			worker.setInteger(null);
			workername = "";
			workertitle = "";
		}
		blanknumber = ab.getBlanknumber();
		blankindex.setInteger(new Integer(ab.getBlankindex()));
		blankdate.setSqlDate(ab.getBlankdate());
		placetype = ab.getEqplace();
		if("P".equals(placetype)) {
			EquipmentSetAccessBean eq = new EquipmentSetAccessBean();
			eq.setInitKey_storageplace(ab.getFrom().getStorageplace());
			eq.refreshCopyHelper();
			setComplectAttribute(eq);
			PositionAccessBean p = eq.getPosition();
			setPositionAttribute(p);
			setStoragecode("");
			setStoragename("");
		} else if("S".equals(placetype)) {
			storage.setInteger(new Integer(ab.getFrom().getStorageplace()));
			storagename = ab.getFrom().getName();
			setComplectAttribute(null);
			setPositionAttribute(null);
		} else if("W".equals(placetype)) {
		} else {
		}


		Integer key = ab.getAgregateresource();
		if(key!=null){
			ResourceAccessBean rab = new ResourceAccessBean();
			rab.setInitKey_resource(key.intValue());
			setDevicecode(new Integer(rab.getResource()));
			setDevicename(rab.getName());
			setDevicemodel(rab.getModel());
		}
		setDeviceserial(ab.getAgregateserial());
		/*if(com.hps.july.util.AppUtils.getInventoryVariant() == 2) {
			setDeviceserial(ab.getAgregateserial());
			if(getDeviceserial() != null && !"".equals(getDeviceserial().trim())) {
				try {
					StorageCardAccessBean sc = (new StorageCardAccessBean()).findBySerial(getDeviceserial());
					device = sc.getStoragecard();
					devicename = sc.getResource().getName();
					if(sc.getResource().getModel() != null) {
						devicename += " " + sc.getResource().getModel();
					}
				} catch(Exception e) {
					devicename = "?";
				}
			} else {
				device = 0;
				deviceserial = "";
				devicename = "";
			}
		} else {
			StorageCardAccessBean dev = ab.getOldagregate();
			if(dev != null) {
				device = dev.getStoragecard();
				deviceserial = dev.getSerialnumber();
				devicename = dev.getResource().getName();
				if(dev.getResource().getModel() != null) {
					devicename += " " + dev.getResource().getModel();
				}
			} else {
				device = 0;
				deviceserial = "";
				devicename = "";
			}
		}	*/		
		
		msn = ab.getOldserial();
		if(msn != null && !"".equals(msn.trim())) {
			/*StorageCardAccessBean sb = new StorageCardAccessBean();
			StorageCardAccessBean sbr = sb.findBySerial(msn);*/

			ResourceAccessBean rab = new ResourceAccessBean();
			if(ab.getOldresource()!=null){
				rab.setInitKey_resource(ab.getOldresource().intValue());
				
				mres.setInteger(ab.getOldresource());
				mresname = rab.getName();
				mresmodel = rab.getModel();
			}else{
				mres.setInteger(null);
				mresname = "";
				mresmodel = "";
				mms = "";
			}
		} else {
			mres.setInteger(null);
			mresname = "";
			mresmodel = "";
			mms = "";
		}
		rsn = ab.getNewserial();
		if(rsn != null && !"".equals(rsn.trim())) {
			/*StorageCardAccessBean sb = new StorageCardAccessBean();
			StorageCardAccessBean sbr = sb.findBySerial(rsn);*/

			ResourceAccessBean rab = new ResourceAccessBean();
			if(ab.getNewresource()!=null){
				rab.setInitKey_resource(ab.getNewresource().intValue());
			
				rres.setInteger(ab.getNewresource());
				rresname = rab.getName();
				rresmodel = rab.getModel();
			}else{
				rres.setInteger(null);
				rresname = "";
				rresmodel = "";
				rms = "";
			}
			/*rms = sbr.getManufserial();*/
		} else {
			rres.setInteger(null);
			rresname = "";
			rresmodel = "";
			rms = "";
		}
		comments = ab.getComment();
		dState = ab.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
private Integer findExpedition(Integer w) {
	if(w == null) return null;
	ExpeditionAccessBean ex = new ExpeditionAccessBean();
	try {
		Enumeration en = ex.findExpeditionByExpeditor(new WorkerKey(w.intValue()));
		ExpeditionAccessBean exn = (ExpeditionAccessBean)en.nextElement();
		return new Integer(exn.getStorageplace());
	} catch(Exception e) {
		e.printStackTrace(System.out);
		try {
			KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
			setDocument(keyGen.getNextKey("tables.expedition"));
			ex = new ExpeditionAccessBean(keyGen.getNextKey("tables.expedition"),division.getInteger(),workername,"");
			return new Integer(ex.getStorageplace());
		} catch(Exception ee) {
			ee.printStackTrace(System.out);
			return null;
		}
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public com.hps.july.web.util.StringAndSqlDateProperty getBlankdate() {
	return blankdate;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getBlankindex() {
	return blankindex;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComments() {
	return comments;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getComplect() {
	return complect;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	FaultReportAccessBean bean = new FaultReportAccessBean();
	bean.setInitKey_document(getDocument());
	if(getDevicecode()!=null){	
		bean.setAgregateresource(getDevicecode());
	}
	if(getDeviceserial()!=null){	
		bean.setAgregateserial(getDeviceserial());
	}
	return bean;
}
/**
 * 
 * @return int
 */
public int getDevice() {
	return device;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 14:38:12)
 * @return java.lang.Integer
 */
public java.lang.Integer getDevicecode() {
	return devicecode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 14:05:48)
 * @return java.lang.String
 */
public java.lang.String getDevicemodel() {
	return devicemodel;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDevicename() {
	return devicename;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDeviceserial() {
	return deviceserial;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getDivision() {
	return division;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDivisionname() {
	return divisionname;
}
public int getDocument() {
	return document;
}
public java.lang.Integer getDocumentId() {
	return new Integer(document);
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDState() {
	try{
		FaultReportAccessBean bean = new FaultReportAccessBean();
		bean.setInitKey_document(getDocument());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		//e.printStackTrace(System.out);
		return "1";
	}
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getExpedition() {
	return expedition;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getMms() {
	return mms;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getMres() {
	return mres;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getMresmodel() {
	return mresmodel;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getMresname() {
	return mresname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getMsn() {
	return msn;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getOwner() {
	return owner;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
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
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPlacetype() {
	return placetype;
}
public com.hps.july.web.util.StringAndIntegerProperty getPosition() {
	return position;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPrice() {
	return price;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRms() {
	return rms;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getRres() {
	return rres;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRresmodel() {
	return rresmodel;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRresname() {
	return rresname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRsn() {
	return rsn;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITFLT;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getStorage() {
	return storage;
}
public String getStoragecode() {
	return storage.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStoragename() {
	return storagename;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getWorker() {
	return worker;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getWorkertitle() {
	return workertitle;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.initRecord(request);

	// Инициализировать все поля.
	// Форма хранится в сессии!!!

	blankdate.setSqlDate(null);
	blankindex.setInteger(null);
	blanknumber = "";
	comments = "";
	complect.setInteger(null);
	complectname = "";
	device = 0;
	devicecode = null;
	devicename = "";
	deviceserial = "";
	division.setInteger(null);
	divisionname = "";
	dState = "1";
	placetype = "P";
		position.setInteger(null);
		positionname = "";
		positionid = "";

		storage.setInteger(null);
		storagename = "";

	// Malformed resource
	mres.setInteger(null);
	mresname = "";
	mresmodel = "";
	msn = "";
	mms = "";
	comments = "";

	// Replaced by
	rres.setInteger(null);
	rresname = "";
	rresmodel = "";
	rsn = "";
	rms = "";

	// additional params
	expedition.setInteger(null);
	price = new BigDecimal("0.00");
	storageplace = null;
	worker.setInteger(null);
	workername = "";
	workertitle = "";

	setDocument(0);
	FaultListForm aform = (FaultListForm)request.getSession().getAttribute("FaultListForm");
	
	if(aform.getDateto() != null) {
		blankdate.setSqlDate(aform.getDateto());
	}

	if(Boolean.FALSE.equals(aform.getIsowner())) {
		owner.setString(aform.getOwnercode());
		setOwnername(aform.getOwnername());
	}

	if(Boolean.FALSE.equals(aform.getIsdivision())) {
		division.setInteger(aform.getDivision());
		setDivisionname(aform.getDivisionname());
	}

	if(Boolean.FALSE.equals(aform.getIsworker())) {
		worker.setInteger(aform.getWorker());
		setWorkername(aform.getWorkername());
		setWorkertitle(aform.getWorkertitle());
	}

	if(Boolean.FALSE.equals(aform.getIsposition())) {
		position.setInteger(aform.getPosition());
		setPositionname(aform.getPositionname());
		setPositionid(aform.getPositionid());
	}

	if(Boolean.FALSE.equals(aform.getIsresource())) {
		mres.setInteger(aform.getResource());
		setMresname(aform.getResourcename());
		setMresmodel(aform.getResourcemodel());
	}

}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 13:43:24)
 * @return boolean
 */
public boolean isBrowseBySerialD() {
	return browseBySerialD;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2005 11:55:23)
 * @return boolean
 */
public boolean isBrowseBySerialMsn() {
	return browseBySerialMsn;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2005 11:55:45)
 * @return boolean
 */
public boolean isBrowseBySerialRsn() {
	return browseBySerialRsn;
}
/**
 * 
 * @param newBlanknumber java.lang.String
 */
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 13:43:24)
 * @param newBrowseBySerialD boolean
 */
public void setBrowseBySerialD(boolean newBrowseBySerialD) {
	browseBySerialD = newBrowseBySerialD;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2005 11:55:23)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerialMsn(boolean browseBySerial) {
	browseBySerialMsn = browseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2005 11:55:45)
 * @param newBrowseBySerialNew boolean
 */
public void setBrowseBySerialRsn(boolean browseBySerial) {
	browseBySerialRsn = browseBySerial;
}
/**
 * 
 * @param newComments java.lang.String
 */
public void setComments(java.lang.String newComments) {
	comments = newComments;
}
public void setComplectAttribute(EquipmentSetAccessBean eq) {
	try {
		if(eq != null) {
			complect.setInteger(new Integer(eq.getStorageplace()));
			complectname = com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(eq);
		} else {
			complect.setInteger(null);
			complectname = "";
		}
	} catch(Exception e) {
	}
}
/**
 * 
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * 
 * @param newDevice int
 */
public void setDevice(int newDevice) {
	device = newDevice;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 14:38:12)
 * @param newDevicecode java.lang.Integer
 */
public void setDevicecode(java.lang.Integer newDevicecode) {
	devicecode = newDevicecode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 14:05:48)
 * @param newDeviceModel java.lang.String
 */
public void setDevicemodel(java.lang.String newDevicemodel) {
	devicemodel = newDevicemodel;
}
/**
 * 
 * @param newDevicename java.lang.String
 */
public void setDevicename(java.lang.String newDevicename) {
	devicename = newDevicename;
}
/**
 * 
 * @param newDeviceserial java.lang.String
 */
public void setDeviceserial(java.lang.String newDeviceserial) {
	deviceserial = newDeviceserial;
}
/**
 * 
 * @param newDivisionname java.lang.String
 */
public void setDivisionname(java.lang.String newDivisionname) {
	divisionname = newDivisionname;
}
public void setDocument(int newDocument) {
	document = newDocument;
}
/**
 * 
 * @param newMms java.lang.String
 */
public void setMms(java.lang.String newMms) {
	mms = newMms;
}
/**
 * 
 * @param newMresmodel java.lang.String
 */
public void setMresmodel(java.lang.String newMresmodel) {
	mresmodel = newMresmodel;
}
/**
 * 
 * @param newMresname java.lang.String
 */
public void setMresname(java.lang.String newMresname) {
	mresname = newMresname;
}
/**
 * 
 * @param newMsn java.lang.String
 */
public void setMsn(java.lang.String newMsn) {
	msn = newMsn;
}
/**
 * 
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
/**
 * 
 * @param newPlacetype java.lang.String
 */
public void setPlacetype(java.lang.String newPlacetype) {
	placetype = newPlacetype;
}
public void setPositionAttribute(PositionAccessBean p) {
	try {
		if(p != null) {
			position.setInteger(new Integer(p.getStorageplace()));
			positionname = p.getName();
			positionid = "";
			if(p.getGsmid() != null) {
				positionid += "D"+p.getGsmid()+" ";
			}
			if(p.getDampsid() != null) {
				positionid += "A"+p.getDampsid()+" ";
			}
		} else {
			position.setInteger(null);
			positionname = "";
			positionid = "";
		}
	} catch(Exception e) {
	}
}
/**
 * 
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * 
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * 
 * @param newPrice java.math.BigDecimal
 */
public void setPrice(java.math.BigDecimal newPrice) {
	price = newPrice;
}
/**
 * 
 * @param newRms java.lang.String
 */
public void setRms(java.lang.String newRms) {
	rms = newRms;
}
/**
 * 
 * @param newRresmodel java.lang.String
 */
public void setRresmodel(java.lang.String newRresmodel) {
	rresmodel = newRresmodel;
}
/**
 * 
 * @param newRresname java.lang.String
 */
public void setRresname(java.lang.String newRresname) {
	rresname = newRresname;
}
/**
 * 
 * @param newRsn java.lang.String
 */
public void setRsn(java.lang.String newRsn) {
	rsn = newRsn;
}
public void setStoragecode(String newStorage) {
	storage.setString(newStorage);
}
/**
 * 
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
/**
 * 
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
/**
 * 
 * @param newWorkertitle java.lang.String
 */
public void setWorkertitle(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	setBrowseBySerialRsn(false);
	setBrowseBySerialMsn(false);
	setBrowseBySerialD(false);
	
	if(mres.isEmpty()){
		setMresmodel("");
		setMresname("");
	}

	if(rres.isEmpty()){
		setRresmodel("");
		setRresname("");
	}
	
	if(devicecode==null){
		setDevicemodel("");
		setDevicename("");
	}
	
	if (!getComplect().getString().equalsIgnoreCase(""))
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplect().getInteger()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.alertgsm"));

	if (mres.isEmpty()) {
		// Find new resource by serialnumber if its empty
		if ( (msn != null && msn.length() > 0) ) {

				Connection conn = null;
				int result = 0;

				try {
					
					conn = new JdbcConnection().getConnection();
					result = CDBCStoragecardsObject.findBySerialM(conn,getMsn());
					
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
					setBrowseBySerialMsn(true);
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assemblingppos.several"));
					throw new ValidationException();
				}
				
				// Only serial number specified - find resource by serial number
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(getMsn());
					mres.setInteger(new Integer(card.getResource().getResource()));	
					setMms(card.getManufserial());
				} catch(Exception e) {
					e.printStackTrace();
				}
		} else{ 
				//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.serialparty"));
		}
	 }

	if (rres.isEmpty()) {
		// Find new resource by serialnumber if its empty
		if ( (rsn != null && rsn.length() > 0) ) {

				Connection conn = null;
				int result = 0;

				try {
					
					conn = new JdbcConnection().getConnection();
					result = CDBCStoragecardsObject.findBySerialM(conn,getRsn());
					
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
					setBrowseBySerialRsn(true);
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assemblingppos.several"));
					throw new ValidationException();
				}
				
				// Only serial number specified - find resource by serial number
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(getRsn());
					rres.setInteger(new Integer(card.getResource().getResource()));	
					setRms(card.getManufserial());
				} catch(Exception e) {
					e.printStackTrace();
				}
		} else{ 
				//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.serialparty"));
		}
	 } 	

	if (devicecode==null) {
		// Find resource by serialnumber/party if its empty
		if (getDeviceserial() != null && getDeviceserial().length() > 0) {
				// Only serial number specified - find resource by serial number

				Connection conn = null;
				int result = 0;

				try {
					
					conn = new JdbcConnection().getConnection();
					result = CDBCStoragecardsObject.findBySerialM(conn,getDeviceserial());
					
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
					setBrowseBySerialD(true);
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assemblingppos.several"));
					throw new ValidationException();
				}	
				
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(getDeviceserial());
					devicecode = new Integer(card.getResource().getResource());
					devicename = card.getResource().getName();
					devicemodel = card.getResource().getModel();
				} catch(Exception e) {
					e.printStackTrace();
				}	
		}
	}

	
	if("Edit".equals(getAction()) || "Delete".equals(getAction())) {
		if(document <= 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fault.document"));
		}
	}

	// owner
	if(owner.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fault.owner"));
	}
	else if(!owner.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fault.owner"));
	}
	else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(owner.getInteger().intValue());
			bean.refreshCopyHelper();
			setOwnername(bean.getName());
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.fault.owner"));
		}
	}

	// document number
	if(blankindex.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.empty"));
	} else if(!blankindex.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.invalid"));
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

	// document date	
	if(blankdate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fault.blankdate"));
	}
	else if(!blankdate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fault.blankdate"));
	}

	// worker and division
	if(worker.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fault.worker"));
	}
	else if(!worker.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fault.worker"));
	}
	else {
		try {
			constructWorker();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.fault.worker"));
		}
	}
	if(division.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fault.division"));
	} else if(!division.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fault.division"));
	} else {
		try {
			constructDivision();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.fault.division"));
		}
	}
	
	if(comments != null && comments.length() > 255) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fault.notes"));
	}

	// storageplace check
	if("P".equals(placetype)) {
		if(position.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fault.position"));
		}
		else if(!position.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fault.position"));
		}
		else {
			try {
				constructPosition();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.fault.position"));
			}
		}
		
		if(complect.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fault.complect"));
		}
		else if(!complect.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fault.complect"));
		}
		else {
			try {
				EquipmentSetAccessBean bean = new EquipmentSetAccessBean();
				bean.setInitKey_storageplace(complect.getInteger().intValue());
				bean.refreshCopyHelper();
				complectname = com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(bean);
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.fault.complect"));
			}
		}

		// check for malfunctional resource
		if (mres.isEmpty()) {
			if(msn != null && "".equals(msn.trim())) {
				msn = null;
			}
			if (msn != null && msn.length() > 0) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(msn);
					mres.setInteger(new Integer(card.getResource().getResource()));
					mresname = card.getResource().getName();
					mresmodel = card.getResource().getModel();
					mms = card.getManufserial();
				} catch(Exception e) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notfound.fault.mrescard"));
				}
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fault.msn"));
			}
		}
		if(mres.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fault.mres"));
		} else if(!mres.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fault.mres"));
		}

		storageplace = complect.getInteger();
	} else if("S".equals(placetype)) {
		// check for malfunctional resource
		try {
			StorageAccessBean s = new StorageAccessBean();
			s.setInitKey_storageplace(storage.getInteger().intValue());
			s.refreshCopyHelper();
			storagename = s.getName();
		} catch(Exception e) {
		}
		if (mres.isEmpty()) {
			if(msn != null && "".equals(msn.trim())) {
				msn = null;
			}
			if (msn != null && msn.length() > 0) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(msn);
					mres.setInteger(new Integer(card.getResource().getResource()));
					mresname = card.getResource().getName();
					mresmodel = card.getResource().getModel();
					mms = card.getManufserial();
				} catch(Exception e) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notfound.fault.mrescard"));
				}
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fault.msn"));
			}
		}
		if(mres.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fault.mres"));
		} else if(!mres.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fault.mres"));
		}

		storageplace = storage.getInteger();
	} else if("W".equals(placetype)) {
		// check for malfunctional resource
		if (mres.isEmpty()) {
			if(msn != null && "".equals(msn.trim())) {
				msn = null;
			}
			if (msn != null && msn.length() > 0) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(msn);
					mres.setInteger(new Integer(card.getResource().getResource()));
					mresname = card.getResource().getName();
					mresmodel = card.getResource().getModel();
					mms = card.getManufserial();
				} catch(Exception e) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notfound.fault.mrescard"));
				}
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fault.msn"));
			}
		}
		if(mres.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fault.mres"));
		} else if(!mres.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fault.mres"));
		}

		storageplace = findExpedition(worker.getInteger());
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.unknown.fault.placetype"));
	}
	
	/*if(deviceserial != null && "".equals(deviceserial.trim())) {
		deviceserial = null;
	}
	if(deviceserial != null && !"".equals(deviceserial.trim())) {
		try {
			StorageCardAccessBean scb = new StorageCardAccessBean();
			StorageCardAccessBean scbagr = scb.findBySerial(deviceserial);
			device = scbagr.getStoragecard();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.fault.device"));
		}
	}*/

	// check for replaced by resource
	if (rres.isEmpty()) {
		if(rsn != null && "".equals(rsn.trim())) {
			rsn = null;
		}
		if(rsn != null && rsn.length() > 0) {
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findBySerial(rsn);
				rres.setInteger(new Integer(card.getResource().getResource()));
				rresname = card.getResource().getName();
				rresmodel = card.getResource().getModel();
				rms = card.getManufserial();
			} catch(Exception e) {
//				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notfound.fault.rrescard"));
			}
		}
	}
	if(!rres.isEmpty() && !rres.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fault.rres"));
	}

	if(!"1".equals(dState) && !"2".equals(dState)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fault.state"));
	}

	if (!errors.empty())
		throw new ValidationException();
}

public String getNfsResCode() {
	return getNfsCommonCode(rres.getInteger());
}

public String getNfsMresCode() {
	return getNfsCommonCode(mres.getInteger());
}

private String getNfsCommonCode(Integer resCode) {
	StringBuffer outSB = new StringBuffer();
	CDBCResultSet res = CDBCResourcesObject.findLinkedNFSResources(resCode);
	//
	java.util.ListIterator it = res.listIterator();
	System.out.println("# getNfsCommonCode resCode = " + resCode);
	System.out.println("# getNfsCommonCode getRowsCount() = " + res.getRowsCount());
	while (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		String curCode = ro.getColumn("segment1").asString();
		System.out.println("# getNfsCommonCode curCode = " + curCode);
		if (outSB.length() == 0) {
			outSB.append(curCode);
		} else {
			outSB.append(", ").append(curCode);
		}
	}
	System.out.println("# getNfsCommonCode outSB.toString() = " + outSB.toString());
	return outSB.toString();
}

public String getEqStorageName() {
	return CDBCResourcesObject.getFullStorageName(complect.getString(), 1);
}
}
