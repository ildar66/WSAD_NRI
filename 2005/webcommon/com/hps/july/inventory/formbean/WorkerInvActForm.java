package com.hps.july.inventory.formbean;

import java.util.Enumeration;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма ввода и редактирования шапки документа "Акт инвентаризации на складе"
 */
public class WorkerInvActForm extends DocumentForm {
	private java.lang.String blanknumber;
	private StringAndIntegerProperty blankindex;
	private int document;
	private StringAndSqlDateProperty blankdate;
	private java.lang.String dState;
	private java.lang.String type;
	private StorageCardAccessBean agregates;
	private java.lang.Integer ownercode;
	private java.lang.String ownername;
	private java.lang.Integer equipcode;
	private java.lang.String equipname;
	private java.lang.Integer storagemancode;
	private java.lang.String storagemanname;
	private java.lang.Integer techniciancode;
	private java.lang.String technicianname;
	private java.lang.String equipserial;
	private StringAndIntegerProperty workercode = new StringAndIntegerProperty();
	private java.lang.String workername;
	private StringAndIntegerProperty orgcode = new StringAndIntegerProperty();
	private java.lang.String orgname;
	private java.lang.String expedtype;
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:38:00)
 */
public WorkerInvActForm() {
	blankdate = new StringAndSqlDateProperty();
	blankindex = new StringAndIntegerProperty();
	dState = "1";
	type = "F";
	expedtype = "W";
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public StorageCardAccessBean constructAgregates() throws Exception {

	if (agregates == null) {	
		// Construct organizations bean
		if (getEquipserial() != null) {
			agregates = (new StorageCardAccessBean()).findBySerial(getEquipserial());
			setAgregate(agregates);
			/*
			agregates.setInitKey_storagecard(equipcode.intValue());
			agregates.refreshCopyHelper();
			*/
		}
	}
	return agregates;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	Expedition exp = getExpedition();
	
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setDocument(keyGen.getNextKey("tables.documents"));
	I13nActAccessBean bean = new I13nActAccessBean(
		getDocument(), getOwnercode(), new Integer(exp.getStorageplace()), new Integer(exp.getStorageplace()),
		getBlankdate(), getBlankindex(), getBlanknumber(), getDState(), getStoragemancode(), getType()
	);
	return bean;
}
/**
 * Заполнение полей на экране при вызове формы на редактирование.
 * Creation date: (30.04.2002 17:53:47)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean)
{
	super.fillRecord(bean);
	try {
		I13nActAccessBean nbean = (I13nActAccessBean)bean;
		setOwnercode(new Integer(nbean.getOwner().getOrganization()));
		//setOwnername(nbean.getOwner().getName());
		if(nbean.getFrom() != null) {
			Expedition exp = (Expedition)nbean.getFrom().getEJBRef();
			if (exp.getExpeditor() != null) {
				setExpedtype("W");
				workercode.setInteger(new Integer(exp.getExpeditor().getWorker()));
				setWorkername(exp.getExpeditor().getMan().getFullName());
				setOrgcode("");
				setOrgname("");
			} else if (exp.getOrganization() != null) {
				setExpedtype("O");
				orgcode.setInteger(new Integer(exp.getOrganization().getOrganization()));
				setOrgname(exp.getOrganization().getName());
				setWorkercode("");
				setWorkername("");
			}
		}
		if(nbean.getStorageManager() != null) {
			setStoragemancode(new Integer(nbean.getStorageManager().getWorker()));
			setStoragemanname(nbean.getStorageManager().getMan().getFullName());
		}
		if(nbean.getTechStuff() != null) {
			setTechniciancode(new Integer(nbean.getTechStuff().getWorker()));
			setTechnicianname(nbean.getTechStuff().getMan().getFullName());
		}
		if(com.hps.july.util.AppUtils.getInventoryVariant() == 2) {
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
				
			}
		}
	} catch(Exception e) {
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.09.2002 14:35:22)
 * @return com.hps.july.persistence.StorageCardAccessBean
 */
public com.hps.july.persistence.StorageCard getAgregate() {
	if(com.hps.july.util.AppUtils.getInventoryVariant() == 2) {
		return null;
	} else {
		try {
			StorageCardAccessBean bean = constructAgregates();
			bean.refreshCopyHelper();
			agregates = bean;
			return (StorageCard)(bean.getEJBRef());
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
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	/*
	ComplectContentListForm aform = (ComplectContentListForm)request.getSession().getAttribute( "ComplectContentListForm" );
	setResourceset(aform.getResourceset());
	setResourcesetname(aform.getResourcesetname());
	ResourceSetPartAccessBean bean = new ResourceSetPartAccessBean();
	bean.setInitKey_set_resourceset(new Integer(getResourceset()));
	bean.setInitKey_part_resource(new Integer(getResourcepart()));
	return bean;
	*/
	I13nActAccessBean bean = new I13nActAccessBean();
	bean.setInitKey_document(getDocument());
	return bean;
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
public java.lang.Integer getEquipcode() {
	return equipcode;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:27:46)
 * @return java.lang.String
 */
public java.lang.String getEquipname() {
	return equipname;
}
/**
 * Insert the method's description here.
 * Creation date: (04.09.2002 14:45:01)
 * @return java.lang.String
 */
public java.lang.String getEquipserial() {
	return equipserial;
}
/**
 * Нахождение и возврат экспедиции.
 * Creation date: (06.06.2005 11:21:08)
 * @return com.hps.july.persistence.Expedition
 */
public Expedition getExpedition() {
	if ("W".equals(getExpedtype())) {
		if (workercode.isOk() && !workercode.isEmpty()) {
			try {
				java.util.Enumeration en = new ExpeditionAccessBean().findExpeditionByExpeditor(new WorkerKey(workercode.getInteger().intValue()));
				if (en.hasMoreElements()) {
					ExpeditionAccessBean ab = (ExpeditionAccessBean)javax.rmi.PortableRemoteObject.narrow(en.nextElement(), ExpeditionAccessBean.class);
					Expedition result = (Expedition)javax.rmi.PortableRemoteObject.narrow(ab.getEJBRef(), Expedition.class);
					return result;
				} else {
					WorkerAccessBean wrk = new WorkerAccessBean();
					wrk.setInitKey_worker(workercode.getInteger().intValue());
					wrk.refreshCopyHelper();
					KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
					int expid = keyGen.getNextKey("tables.storageplaces");
					ExpeditionAccessBean eab = new ExpeditionAccessBean(expid, null, wrk.getMan().getFullName(), "");
					eab.setExpeditor((Worker)wrk.getEJBRef());
					eab.commitCopyHelper();
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
	} else if ("O".equals(getExpedtype())) {
		if (orgcode.isOk() && !orgcode.isEmpty()) {
			try {
				java.util.Enumeration en = new ExpeditionAccessBean().findExpeditionByOrganization(new OrganizationKey(orgcode.getInteger().intValue()));
				if (en.hasMoreElements()) {
					ExpeditionAccessBean ab = (ExpeditionAccessBean)javax.rmi.PortableRemoteObject.narrow(en.nextElement(), ExpeditionAccessBean.class);
					Expedition result = (Expedition)javax.rmi.PortableRemoteObject.narrow(ab.getEJBRef(), Expedition.class);
					return result;
				} else {
					OrganizationAccessBean org = new OrganizationAccessBean();
					org.setInitKey_organization(orgcode.getInteger().intValue());
					org.refreshCopyHelper();
					KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
					int expid = keyGen.getNextKey("tables.storageplaces");
					ExpeditionAccessBean eab = new ExpeditionAccessBean(expid, null, org.getName(), "");
					eab.setOrganization((Organization)org.getEJBRef());
					eab.commitCopyHelper();
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2005 10:56:46)
 * @return java.lang.String
 */
public java.lang.String getExpedtype() {
	return expedtype;
}
public StoragePlace getFrom() {
	return (StoragePlace)getExpedition();
}
public java.util.ListIterator getListItems() {
	com.hps.july.cdbc.objects.CDBCDocuments c = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = c.listStorageInventoryItems(new Integer(getDocument()),new Integer(1));
	return rs.listIterator();
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
/**
 * Insert the method's description here.
 * Creation date: (06.06.2005 10:39:27)
 * @return java.lang.String
 */
public java.lang.String getOrgcode() {
	return orgcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2005 10:39:42)
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
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
 * Текущее состояние приложения.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.inventory.APPStates.WRKINVFORM;
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
	return (StoragePlace)getExpedition();
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:24:18)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2005 10:38:37)
 * @return java.lang.String
 */
public java.lang.String getWorkercode() {
	return workercode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2005 10:38:58)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.initRecord(request);
	setDocument(0);
	WorkerInvActListForm f = (WorkerInvActListForm)request.getSession().getAttribute( "WorkerInvActListForm" );
	setBlankdate(f.getDateto());
	if(f.getIsowner() == null || !f.getIsowner().booleanValue()) {
		setOwnercode(f.getOwnercode());
		if (getOwnercode() != null) {
			OrganizationAccessBean oab = new OrganizationAccessBean();
			oab.setInitKey_organization(getOwnercode().intValue());
			oab.refreshCopyHelper();
			setOwnername(oab.getName());
		} else
			setOwnername("");
	}
	setExpedtype(f.getExpedtype());
	setWorkercode(f.getWorkercode());
	setWorkername(f.getWorkername());
	setOrgcode(f.getOrgcode());
	setOrgname(f.getOrgname());
	try {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		setBlankindex(keyGen.getNextKey("tables.i13nactnumber"));
	} catch(Exception e) {
		setBlankindex(0);
	}
	dState = "1";
	type = "F";
	setStoragemancode(null);
	setTechniciancode(null);
	setStoragemanname("");
	setTechnicianname("");
}
/**
 * Insert the method's description here.
 * Creation date: (04.09.2002 14:35:22)
 * @param newAgregate com.hps.july.persistence.StorageCardAccessBean
 */
public void setAgregate(com.hps.july.persistence.StorageCardAccessBean newAgregate) {
	if(com.hps.july.util.AppUtils.getInventoryVariant() == 2) {
		agregates = null;
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
 * Creation date: (20.05.2002 18:27:46)
 * @param newEquipname java.lang.String
 */
public void setEquipname(java.lang.String newEquipname) {
	equipname = newEquipname;
}
/**
 * Insert the method's description here.
 * Creation date: (04.09.2002 14:45:01)
 * @param newEquipserial java.lang.String
 */
public void setEquipserial(java.lang.String newEquipserial) {
	equipserial = newEquipserial;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2005 10:56:46)
 * @param newExpedtype java.lang.String
 */
public void setExpedtype(java.lang.String newExpedtype) {
	expedtype = newExpedtype;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2005 10:39:27)
 * @param newOrgcode java.lang.String
 */
public void setOrgcode(java.lang.String newOrgcode) {
	orgcode.setString(newOrgcode);
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2005 10:39:42)
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
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
 * Creation date: (06.06.2005 10:38:37)
 * @param newWorkercode java.lang.String
 */
public void setWorkercode(java.lang.String newWorkercode) {
	workercode.setString(newWorkercode);
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2005 10:38:58)
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
/**
 * Проверка правильности введенных значений.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
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

	if ("W".equals(getExpedtype())) {
		if (workercode.isEmpty())
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.inventory.worker"));
		else if (!workercode.isOk())
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.worker"));
		else if (getExpedition() == null)
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.worker"));
	} else if ("O".equals(getExpedtype())) {
		if (orgcode.isEmpty())
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.inventory.org"));
		else if (!orgcode.isOk())
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.org"));
		else if (getExpedition() == null)
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.org"));
	}
	

	if(!"F".equals(type) && !"P".equals(type) && !"A".equals(type)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.type"));
	}

	if("A".equals(type)) {
		if (equipserial == null || "".equals(equipserial)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.inventory.equip"));
		} else {
			try {
				constructAgregates();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.equip"));
			}
		}
	}
	
	if (storagemancode == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.inventory.storageman"));
	} else {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(storagemancode.intValue());
			bean.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.storageman"));
		}
	}

	if (techniciancode != null) {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(techniciancode.intValue());
			bean.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.inventory.tech"));
		}
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
