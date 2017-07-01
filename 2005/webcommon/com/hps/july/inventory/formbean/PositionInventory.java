package com.hps.july.inventory.formbean;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.Connection;
import java.util.*;
import java.util.Enumeration;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.CDBCDocuments;
import com.hps.july.cdbc.objects.*;

/**
 * Форма редактирования документа "Акт инвентаризации на позиции"
 * Форма объединяет параметры документа и список строк документа
 */
public class PositionInventory extends DocumentForm {
	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	private int document;
	private StringAndSqlDateProperty blankdate;
	private String dState;
	private String type;
	private Integer ownercode;
	private String ownername;
	private Integer equipcode;
	private String equipname;
	private String equipserial;
	private Integer storagemancode;
	private String storagemanname;
	private Integer techniciancode;
	private String technicianname;
	private Integer position;
	private String positionid;
	private String positionname;
	private Integer complect;
	private String complectname;

	private String decreasePrice;
	private java.lang.String equipmodel;
	private boolean browseBySerial;
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:38:00)
 */
public PositionInventory() {
	blankdate = new StringAndSqlDateProperty();
	blankindex = new StringAndIntegerProperty();
	dState = "1";
	type = "F";
//	fromto = null;
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	super.afterUpdate(bean,request); // Support for document calculation
	if("Add".equals(getAction())) {
		setAction("Edit");
	}
}
public void clearAll() {
	setBlankdate(null);
	setBlankindexFrm("");
	setBlanknumber("");
	setComplect(null);
	setComplectname("");
	setDocument(0);
	setEquipcode(null);
	setEquipname("");
	setEquipserial("");
//	fromto = null;
	setOwnercode(null);
	setOwnername("");
	setPosition(null);
	setPositionid("");
	setPositionname("");
	dState = "1";
	setStoragemancode(null);
	setStoragemanname("");
	setTechniciancode(null);
	setTechnicianname("");
	setType("F");
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
	I13nActAccessBean bean = new I13nActAccessBean(
		getDocument(),
		getOwnercode(),
		getComplect(),
		getComplect(),
		getBlankdate(),
		getBlankindex(),
		getBlanknumber(),
		getDState(),
		getStoragemancode(),
		getType()
	);
	bean.setAgregateresource(getEquipcode());
	return bean;
}
public void fillRecord(AbstractEntityAccessBean bean)
{
	super.fillRecord(bean);
	try {
		I13nActAccessBean nbean = (I13nActAccessBean)bean;
		setOwnercode(new Integer(nbean.getOwner().getOrganization()));
		setOwnername(nbean.getOwner().getName());

		Integer key = nbean.getAgregateresource();
		if(key!=null){
			ResourceAccessBean rab = new ResourceAccessBean();
			rab.setInitKey_resource(key.intValue());
			setEquipcode(new Integer(rab.getResource()));
			setEquipname(rab.getName());
			setEquipmodel(rab.getModel());
		}
		/*
		try {
			if(nbean.getAgregate() != null) {
				setEquipcode(new Integer(nbean.getAgregateKey().storagecard));
				setEquipname(nbean.getAgregate().getSerialnumber());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		try {
			if(nbean.getFrom() != null) {
				setComplect(new Integer(nbean.getFrom().getStorageplace()));
//				setComplectname(nbean.getFrom().getName());
				try {
					EquipmentSetAccessBean eqa = new EquipmentSetAccessBean();
					eqa.setInitKey_storageplace(getComplect().intValue());
					eqa.refreshCopyHelper();
					setComplectname(com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(eqa));
					setPosition(new Integer(eqa.getPosition().getStorageplace()));
					setPositionname(eqa.getPosition().getName());
					positionid = "";
					if(eqa.getPosition().getGsmid() != null) {
						positionid = positionid + "D" + eqa.getPosition().getGsmid();
					}
					positionid = positionid + " ";
					if(eqa.getPosition().getDampsid() != null) {
						positionid = positionid + "A" + eqa.getPosition().getDampsid();
					}
				} catch(Exception e) {
					setPosition(new Integer(0));
					setPositionname("");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		setStoragemancode(null);
		setStoragemanname("");
		try {
			if(nbean.getStorageManager() != null) {
				setStoragemancode(new Integer(nbean.getStorageManager().getWorker()));
				setStoragemanname(nbean.getStorageManager().getMan().getFullName());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		setTechniciancode(null);
		setTechnicianname("");
		try {
			if(nbean.getTechStuff() != null) {
				setTechniciancode(new Integer(nbean.getTechStuff().getWorker()));
				setTechnicianname(nbean.getTechStuff().getMan().getFullName());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		/*if(com.hps.july.util.AppUtils.getInventoryVariant() == 2) {
			if("F".equals(getType())) {
				setEquipcode(null);
				setEquipname("");
				setEquipserial("");
			} else {
				if(getAgregateserial() != null && !"".equals(getAgregateserial())) {
					try {
						StorageCardAccessBean sc = (new StorageCardAccessBean()).findBySerial(getAgregateserial());
						setEquipcode(new Integer(sc.getStoragecard()));
						String name = sc.getResource().getName();
						if(sc.getResource().getModel() != null) {
							name += " " + sc.getResource().getModel();
						}
						if(sc.getConfiguration() != null) {
							name += " " + sc.getConfiguration();
						}
						setEquipname(name);
						setEquipserial(sc.getSerialnumber());
					} catch (Exception e) {
						e.printStackTrace(System.out);
					}
				} else {
					setEquipcode(null);
					setEquipname("");
					setEquipserial("");
				}
			}
		}*/
	} catch(Exception e) {
		e.printStackTrace();
	}
	
}
public StorageCard getAgregate() {
	if(com.hps.july.util.AppUtils.getInventoryVariant() == 2) {
		return null;
	} else {
		try {
			if(equipserial != null && !"".equals(equipserial.trim())) {
				StorageCardAccessBean agr = (new StorageCardAccessBean()).findBySerial(equipserial);
		//		agr.setInitKey_storagecard(equipcode.intValue());
				agr.refreshCopyHelper();
				return (StorageCard)agr.getEJBRef();
			} else {
				return null;
			}
		} catch(Exception e) {
			return null;
		}
	}
}
public java.lang.String getAgregateserial() {
	return equipserial;
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
 * Creation date: (20.05.2002 18:33:47)
 * @param newDate java.sql.Date
 */
public java.sql.Date getBlankdate()
{
	return blankdate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:33:47)
 * @param newDate java.sql.Date
 */
public String getBlankdatestr()
{
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
 * Creation date: (20.05.2002 18:21:05)
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 17:52:44)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplect() {
	return complect;
}
public StoragePlaceAccessBean getComplectBean() {
	StoragePlaceAccessBean b = null;
	try {
		b = new StoragePlaceAccessBean();
		b.setInitKey_storageplace(complect.intValue());
		b.refreshCopyHelper();
	} catch(Exception e) {
	}
	return b;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 17:52:56)
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	try {
		I13nActAccessBean bean = new I13nActAccessBean();
		bean.setInitKey_document(getDocument());
		bean.refreshCopyHelper();
		if("View".equals(getAction()) || "Edit".equals(getAction())) {
			if("2".equals(bean.getDocumentState())) {
				setAction("View");
			} else if("1".equals(bean.getDocumentState())) {
				setAction("Edit");
			}
		}
		if(getEquipcode()!=null){	
			bean.setAgregateresource(getEquipcode());
		}	
		return bean;
	} catch(Exception e) {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:33:27)
 * @return java.lang.String
 */
public String getDatestr() {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:21:35)
 * @return int
 */
public int getDocument() {
	return document;
}
public Integer getDocumentId() {
	return new Integer(document);
}
/**
 * Возвращает список позиций текущего документа
 */
public Iterator getDocumentItems() {
	CDBCDocuments docCatalog = new CDBCDocuments();
	return docCatalog.listPositionInventoryItems(new Integer(getDocument()),null).listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:22:54)
 * @return java.lang.String
 */
public java.lang.String getdState() {
	try{
		I13nActAccessBean bean = new I13nActAccessBean();
		bean.setInitKey_document(getDocument());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return "1";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:22:54)
 * @return java.lang.String
 */
public java.lang.String getDState() {
	try{
		I13nActAccessBean bean = new I13nActAccessBean();
		bean.setInitKey_document(getDocument());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return "1";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:27:31)
 * @return java.lang.Integer
 */
public java.lang.Integer getEquipcode() {
	return equipcode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 12:25:14)
 * @return java.lang.String
 */
public java.lang.String getEquipmodel() {
	return equipmodel;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:27:46)
 * @return java.lang.String
 */
public java.lang.String getEquipname() {
	return equipname;
}
public java.lang.String getEquipserial() {
	return equipserial;
}
public StoragePlace getFrom() {
	try {
		return (StoragePlace)getComplectBean().getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 18:37:01)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getOrganizations() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
public Organization getOwner() {
	if(ownercode != null) {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(ownercode.intValue());
			bean.refreshCopyHelper();
			return (Organization)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:26:05)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwnercode() {
	return ownercode;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:26:18)
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
	return ownername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 17:51:30)
 * @return java.lang.Integer
 */
public java.lang.Integer getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2002 13:31:33)
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 17:52:29)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.inventory.APPStates.EDITINV;
}
public Worker getStorageManager() {
	if(storagemancode != null) {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(storagemancode.intValue());
			bean.refreshCopyHelper();
			return (Worker)bean.getEJBRef();
		} catch(Exception e) {
		}
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:28:42)
 * @return java.lang.Integer
 */
public java.lang.Integer getStoragemancode() {
	return storagemancode;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:28:56)
 * @return java.lang.String
 */
public java.lang.String getStoragemanname() {
	return storagemanname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 18:36:33)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getStorages() {
	try {
		StorageAccessBean bean = new StorageAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:31:46)
 * @return java.lang.Integer
 */
public java.lang.Integer getTechniciancode() {
	return techniciancode;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:32:07)
 * @return java.lang.String
 */
public java.lang.String getTechnicianname() {
	return technicianname;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 10:06:31)
 * @return com.hps.july.persistence.Worker
 */
public Worker getTechStuff() {
	if(techniciancode != null) {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(techniciancode.intValue());
			bean.refreshCopyHelper();
			return (Worker)bean.getEJBRef();
		} catch(Exception e) {
		}
	}
	return null;
}
public StoragePlace getTo() {
	try {
		return (StoragePlace)getComplectBean().getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:24:18)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	clearAll();
	super.initRecord(request);
	try {
		PositionInventoryList f = (PositionInventoryList)request.getSession().getAttribute( "PositionInventoryList" );
		setBlankdate(f.getDateto());
		if(!f.getShowallowner().booleanValue()) {
			setOwnercode(f.getOwner());
			setOwnername(f.getOwnername());
		}
		if(!f.getShowallstorage().booleanValue()) {
			setPosition(f.getPosition());
			setPositionid(f.getPositionid());
			setPositionname(f.getPositionname());
			setComplect(f.getComplect());
			setComplectname(f.getComplectname());
		}
	} catch(Exception e) {
		setBlankdate(new java.sql.Date(System.currentTimeMillis()));
		setOwnercode(new Integer(1));
		setOwnername("");
		setPosition(null);
		setPositionid("");
		setPositionname("");
		setComplect(null);
		setComplectname("");
	}
	try {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		setBlankindex(keyGen.getNextKey("tables.i13nactnumber"));
		setBlanknumber(new Integer(getBlankindex()).toString());
	} catch(Exception e) {
		setBlankindex(1);
	}
	dState = "1";
	type = "F";
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 12:27:05)
 * @return boolean
 */
public boolean isBrowseBySerial() {
	return browseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (04.09.2002 14:35:22)
 * @param newAgregate com.hps.july.persistence.StorageCardAccessBean
 */
public void setAgregate(com.hps.july.persistence.StorageCardAccessBean newAgregate) {
	if(com.hps.july.util.AppUtils.getInventoryVariant() == 2) {
		return;
	}
	setEquipcode(null);
	setEquipname("");
	setEquipserial("");
	if (newAgregate != null) {
		try {
			setEquipcode(new Integer(newAgregate.getStoragecard()));
			String name = newAgregate.getResource().getName();
			if(newAgregate.getResource().getModel() != null) {
				name += " " + newAgregate.getResource().getModel();
			}
			if(newAgregate.getConfiguration() != null) {
				name += " " + newAgregate.getConfiguration();
			}
			setEquipname(name);
			setEquipserial(newAgregate.getSerialnumber());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
public void setAgregateserial(java.lang.String newEquipserial) {
	equipserial = newEquipserial;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:34:17)
 * @param newDatestr java.lang.String
 */
public void setBlankdate(java.sql.Date newDate)
{
	blankdate.setSqlDate(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:34:17)
 * @param newDatestr java.lang.String
 */
public void setBlankdatestr(String newDatestr)
{
	blankdate.setString(newDatestr);
}
public void setBlankindex(int newBlankindex) {
	blankindex.setInteger(new Integer(newBlankindex));
}
public void setBlankindexFrm(String newBlankindex) {
	blankindex.setString(newBlankindex);
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:21:05)
 * @param newBlanknumber java.lang.String
 */
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 12:27:05)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 17:52:44)
 * @param newComplect java.lang.Integer
 */
public void setComplect(java.lang.Integer newComplect) {
	complect = newComplect;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 17:52:56)
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:21:35)
 * @param newDocument int
 */
public void setDocument(int newDocument) {
	document = newDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:27:31)
 * @param newEquipcode java.lang.Integer
 */
public void setEquipcode(java.lang.Integer newEquipcode) {
	equipcode = newEquipcode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2005 12:25:14)
 * @param newEquipmodel java.lang.String
 */
public void setEquipmodel(java.lang.String newEquipmodel) {
	equipmodel = newEquipmodel;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:27:46)
 * @param newEquipname java.lang.String
 */
public void setEquipname(java.lang.String newEquipname) {
	equipname = newEquipname;
}
/**
 * 
 * @param newEquipserial java.lang.String
 */
public void setEquipserial(java.lang.String newEquipserial) {
	equipserial = newEquipserial;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:26:05)
 * @param newOwnercode java.lang.Integer
 */
public void setOwnercode(java.lang.Integer newOwnercode) {
	ownercode = newOwnercode;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:26:18)
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 17:51:30)
 * @param newPosition java.lang.Integer
 */
public void setPosition(java.lang.Integer newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2002 13:31:33)
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 17:52:29)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:28:42)
 * @param newStoragemancode java.lang.Integer
 */
public void setStoragemancode(java.lang.Integer newStoragemancode) {
	storagemancode = newStoragemancode;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:28:56)
 * @param newStoragemanname java.lang.String
 */
public void setStoragemanname(java.lang.String newStoragemanname) {
	storagemanname = newStoragemanname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:31:46)
 * @param newTechniciancode java.lang.Integer
 */
public void setTechniciancode(java.lang.Integer newTechniciancode) {
	techniciancode = newTechniciancode;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:32:07)
 * @param newTechnicianname java.lang.String
 */
public void setTechnicianname(java.lang.String newTechnicianname) {
	technicianname = newTechnicianname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:24:18)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	setBrowseBySerial(false);

	if(equipcode==null){
		setEquipmodel("");
		setEquipname("");
	}

	if (equipcode==null) {
		// Find resource by serialnumber/party if its empty
		if (getEquipserial() != null && getEquipserial().length() > 0) {
				// Only serial number specified - find resource by serial number

				Connection conn = null;
				int result = 0;

				try {
					
					conn = new JdbcConnection().getConnection();
					result = CDBCStoragecardsObject.findBySerialM(conn,getEquipserial());
					
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
					StorageCardAccessBean card = ab.findBySerial(getEquipserial());
					equipcode = new Integer(card.getResource().getResource());
					equipname = card.getResource().getName();
					equipmodel = card.getResource().getModel();
				} catch(Exception e) {
					e.printStackTrace();
				}	
		}
	}

	if (getComplect()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplect()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.alertgsm"));
	
	if (blankdate.isEmpty())
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.inventory.blankdate"));
	else if (!blankdate.isOk())
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.blankdate"));

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

	if (ownercode == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.inventory.owner"));
	} else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(ownercode.intValue());
			bean.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.owner"));
		}
	}
	
	if (complect == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.inventory.complect"));
	} else {
		try {
			EquipmentSetAccessBean bean = new EquipmentSetAccessBean();
			bean.setInitKey_storageplace(complect.intValue());
			bean.refreshCopyHelper();
			setComplectname(com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(bean));
			setPosition(new Integer(bean.getPosition().getStorageplace()));
			setPositionname(bean.getPosition().getName());
			positionid = "";
			if(bean.getPosition().getGsmid() != null) {
				positionid = positionid + "D" + bean.getPosition().getGsmid();
			}
			positionid = positionid + " ";
			if(bean.getPosition().getDampsid() != null) {
				positionid = positionid + "A" + bean.getPosition().getDampsid();
			}
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.complect"));
		}
	}

	if(!"F".equals(type) && !"P".equals(type) && !"A".equals(type)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.type"));
	}

	if("A".equals(type)) {
		if (equipserial == null || "".equals(equipserial)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.inventory.equip"));
		} else {
			try {
				StorageCardAccessBean bean = (new StorageCardAccessBean()).findBySerial(equipserial);
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.equip"));
			}
		}
	}
	
	if (storagemancode == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.inventory.tech1"));
	} else {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(storagemancode.intValue());
			bean.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.tech1"));
		}
	}

	if (techniciancode != null) {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(techniciancode.intValue());
			bean.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.tech2"));
		}
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
