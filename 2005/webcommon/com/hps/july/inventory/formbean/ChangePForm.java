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
 * Форма редактирования шапки документа "Акт замены/модернизации на позиции"
 */
public class ChangePForm
	extends AbstractChangeForm
{
	private StringAndIntegerProperty position;
	private String positionname;
	private String positionid;
	private StringAndIntegerProperty complect;
	private String complectname;
	private StringAndIntegerProperty tech;
	private String techname;
	private String techtitle;
public ChangePForm() {
	super();
	position = new StringAndIntegerProperty();
	positionname = "";
	positionid = "";
	complect = new StringAndIntegerProperty();
	complectname = "";
	tech = new StringAndIntegerProperty();
	techname = "";
	techtitle = "";
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
	super.beforeUpdate(bean,request);
}
public EquipmentSetAccessBean constructComplect() throws Exception {
	EquipmentSetAccessBean e = new EquipmentSetAccessBean();
	e.setInitKey_storageplace(complect.getInteger().intValue());
	e.refreshCopyHelper();
	complectname = com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(e);
	return e;
}
public PositionAccessBean constructPosition() throws Exception {
	PositionAccessBean p = new PositionAccessBean();
	p.setInitKey_storageplace(position.getInteger().intValue());
	p.refreshCopyHelper();
	positionname = p.getName();
	positionid = "";
	if(p.getGsmid() != null) {
		positionid += "D"+p.getGsmid()+" ";
	}
	if(p.getDampsid() != null) {
		positionid += "D"+p.getDampsid()+" ";
	}
	return p;
}
public WorkerAccessBean constructWorkers()
	throws Exception
{
	WorkerAccessBean workers = null;
	if (!tech.isEmpty() && tech.isOk()) {
//		try {
			workers = new WorkerAccessBean();
			workers.setInitKey_worker(tech.getInteger().intValue());
			workers.refreshCopyHelper();
//		} catch(Exception e) {
//		}
	}
	return workers;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	ChangeActAccessBean ab = (ChangeActAccessBean)bean;
	try {
		if("2".equals(ab.getDocumentState()) && "Edit".equals(getAction())) {
			setAction("View");
		} else
		if("1".equals(ab.getDocumentState()) && "View".equals(getAction())) {
			setAction("Edit");
		}
		// Position & complect
		StoragePlaceAccessBean s = ab.getFrom(); // to = from
		if(s != null) {
			try {
				EquipmentSetAccessBean es = new EquipmentSetAccessBean();
				es.setInitKey_storageplace(s.getStorageplace());
				es.refreshCopyHelper();
				complect.setInteger(new Integer(es.getStorageplace()));
				complectname = com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(es);
				PositionAccessBean p = es.getPosition();
				position.setInteger(new Integer(p.getStorageplace()));
				positionname = p.getName();
				positionid = "";
				if(p.getGsmid() != null) {
					positionid += "D"+p.getGsmid()+" ";
				}
				if(p.getDampsid() != null) {
					positionid += "D"+p.getDampsid()+" ";
				}
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
		}
		WorkerAccessBean w = ab.getStorageManager();
		if(w != null) {
			try {
				tech.setInteger(new Integer(w.getWorker()));
				techname = w.getMan().getFullName();
				techtitle = w.getPosition().getName();
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public java.lang.Integer getComplect() {
	return complect.getInteger();
}
public String getComplectcode() {
	return complect.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
}
/**
 * getFormName method comment.
 */
protected java.lang.String getFormName() {
	return "ChangePListForm";
}
protected java.lang.Integer getFromKey() {
	return getComplect();
}
public java.util.ListIterator getListItems() {
	com.hps.july.cdbc.objects.CDBCDocuments c = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = c.listChangeActOnPositionItems(new Integer(getDocument()),new Integer(1));
	return rs.listIterator();
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
public java.lang.Integer getPositionI() {
	return position.getInteger();
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
public int getState() {
	return com.hps.july.inventory.APPStates.EDITCHP;
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
public Enumeration getStorages() {
	try {
		StorageAccessBean bean = new StorageAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new Vector()).elements();
	}
}
public java.lang.Integer getTech() {
	return tech.getInteger();
}
public String getTechcode() {
	return tech.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getTechname() {
	return techname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getTechtitle() {
	return techtitle;
}
protected java.lang.Integer getToKey() {
	return getComplect();
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception 
{
	super.initRecord(request);
	ChangePListForm aform = (ChangePListForm)request.getSession().getAttribute(getFormName());
	position.setInteger(aform.getPosition());
	positionname = aform.getPositionname();
	positionid = aform.getPositionid();
	complect.setInteger(null);
	complectname = "";
	tech.setInteger(null);
	techname = "";
	techtitle = "";
	setOwnercode("");
	setOwnername("");
	setBlankdate(null);
	setBlankindexFrm("");
	setBlanknumber("");
}
public void setComplect(Integer number) {
	complect.setInteger(number);
}
public void setComplectcode(String number) {
	complect.setString(number);
}
/**
 * 
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
public void setPositioncode(String number) {
	position.setString(number);
}
public void setPositionI(Integer number) {
	position.setInteger(number);
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
public void setTech(Integer number) {
	tech.setInteger(number);
}
public void setTechcode(String number) {
	tech.setString(number);
}
/**
 * 
 * @param newTechname java.lang.String
 */
public void setTechname(java.lang.String newTechname) {
	techname = newTechname;
}
/**
 * 
 * @param newTechtitle java.lang.String
 */
public void setTechtitle(java.lang.String newTechtitle) {
	techtitle = newTechtitle;
}
protected void specialValidate(org.apache.struts.action.ActionErrors errors)
{
	if (!getComplectcode().equalsIgnoreCase(""))
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(new Integer(getComplectcode())))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.alertgsm"));

	// check position and complect
	if (position.getInteger() == null)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changep.position"));
	else {
		try {
			constructPosition();
		} catch (Exception ex) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changep.position"));
		}
	}

	if (complect.getInteger() == null)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changep.complect"));
	else {
		try {
			constructComplect();
		} catch (Exception ex) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changep.complect"));
		}
	}

	if (tech.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changep.tech"));
	} else if (!tech.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changep.tech"));
	} else {
		try {
			constructWorkers();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notfound.changep.tech"));
		}
	}
}
}
