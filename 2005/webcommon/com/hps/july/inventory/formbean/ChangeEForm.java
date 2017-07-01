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
 * Форма редактирования шапки документа "Акт замены при ремонте"
 */
public class ChangeEForm extends AbstractChangeForm {
	private StringAndIntegerProperty expedition;
	private StringAndIntegerProperty organization;
	private String organizationname;
	private StringAndIntegerProperty worker;
	private String workername;
	private String workertitle;
	private String type;
	private String insuranseMan;
public ChangeEForm() {
	super();
	expedition = new StringAndIntegerProperty();
	organization = new StringAndIntegerProperty();
	organizationname = "";	
	worker = new StringAndIntegerProperty();
	workername = "";
	workertitle = "";
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
	ChangeActAccessBean ab = (ChangeActAccessBean)bean;
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	ExpeditionAccessBean exp = null;

	try {
		exp = findExpedition();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		exp = constructExpedition();
	}
	
	ab.setTo((Expedition)exp.getEJBRef());
	ab.setFrom((Expedition)exp.getEJBRef());

	try {
		ab.setStorageManager((Worker)constructWorker().getEJBRef());
	} catch(Exception e) {
		ab.setStorageManager(null);
	}
}
public ExpeditionAccessBean constructExpedition() throws Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	ExpeditionAccessBean exp = new ExpeditionAccessBean(
		keyGen.getNextKey("tables.storageplaces"), null, "", ""
	);
	if("P".equals(type)) {
		OrganizationAccessBean o = new OrganizationAccessBean();
		o.setInitKey_organization(organization.getInteger().intValue());
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
	expedition.setInteger(new Integer(exp.getStorageplace()));
	exp.commitCopyHelper();
	return exp;
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
	ChangeActAccessBean ab = (ChangeActAccessBean)bean;
	try {
		// Expedition
		StoragePlaceAccessBean s = ab.getFrom(); // to = from
		if(s != null) {
			try {
				ExpeditionAccessBean exp = new ExpeditionAccessBean();
				exp.setInitKey_storageplace(s.getStorageplace());
				exp.refreshCopyHelper();
				if(exp.getOrganization() != null) {
					organization.setInteger(new Integer(exp.getOrganization().getOrganization()));
					organizationname = exp.getOrganization().getName();
					type = "P";
				}
				expedition.setInteger(new Integer(exp.getStorageplace()));
//				if(exp.getExpeditor() != null) {
//					worker.setInteger(new Integer(exp.getExpeditor().getWorker()));
//					workername = exp.getExpeditor().getMan().getFullName();
//					workertitle = exp.getExpeditor().getPosition().getName();
//					type = "W";
//				} else
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
		}

		WorkerAccessBean w = ab.getStorageManager();
		if(w != null) {
			worker.setInteger(new Integer(w.getWorker()));
			workername = w.getMan().getFullName();
			workertitle = w.getPosition().getName();
		}
	} catch(Exception e) {
	}
}
public ExpeditionAccessBean findExpedition() throws java.lang.Exception {
	ExpeditionAccessBean fexp = new ExpeditionAccessBean();
	Enumeration en;
	ExpeditionAccessBean exp;
	if("W".equals(type)) {
		en = fexp.findExpeditionByExpeditor(new WorkerKey(worker.getInteger().intValue()));
		if(en.hasMoreElements()) {
			ExpeditionAccessBean e = (ExpeditionAccessBean)en.nextElement();
			exp = new ExpeditionAccessBean();
			exp.setInitKey_storageplace(e.getStorageplace());
			exp.refreshCopyHelper();
		} else {
			throw new Exception();
		}
	} else if("P".equals(type)) {
		en = fexp.findExpeditionByOrganization(new OrganizationKey(organization.getInteger().intValue()));
		if(en.hasMoreElements()) {
			ExpeditionAccessBean e = (ExpeditionAccessBean)en.nextElement();
			exp = new ExpeditionAccessBean();
			exp.setInitKey_storageplace(e.getStorageplace());
			exp.refreshCopyHelper();
		} else {
			throw new Exception();
		}
	} else {
		throw new UpdateValidationException("error.invalid.change.type");
	}
	return exp;

}
public Enumeration getCurrencies() {
	try {
		CurrencyAccessBean bean = new CurrencyAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
public Integer getExpedition() {
	return expedition.getInteger();
}
public String getExpeditionstr() {
	return expedition.getString();
}
/**
 * getFormName method comment.
 */
protected java.lang.String getFormName() {
	return "ChangeEListForm";
}
protected java.lang.Integer getFromKey() {
	return null;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getInsuranseMan() {
	return insuranseMan;
}
public java.util.ListIterator getListItems() {
	com.hps.july.cdbc.objects.CDBCDocuments c = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = c.listChangeActOnExpeditionItems(new Integer(getDocument()),new Integer(1));
	return rs.listIterator();
}
public String getOrganizationcode() {
	return organization.getString();
}
public java.lang.String getOrganizationname() {
	return organizationname;
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
public int getState() {
	return com.hps.july.inventory.APPStates.EDITCHE;
}
public Enumeration getStorages() {
	try {
		StorageAccessBean bean = new StorageAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new Vector()).elements();
	}
}
/**
 * getToKey method comment.
 */
protected java.lang.Integer getToKey() {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 11:58:34)
 * @return java.lang.String
 */
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
	expedition = new StringAndIntegerProperty();
	organization = new StringAndIntegerProperty();
	organizationname = "";	
	worker = new StringAndIntegerProperty();
	workername = "";
	workertitle = "";

	super.initRecord(request);
	
	ChangeEListForm aform = (ChangeEListForm)request.getSession().getAttribute(getFormName());
	
	if("P".equals(aform.getType())) {
		setOrganizationcode(aform.getOrganizationcode());
		setOrganizationname(aform.getOrganizationname());
		setWorkercode("");
		setWorkername("");
		setWorkertitle("");
		setType("P");
	} else
	if("W".equals(aform.getType())) {
		setOrganizationcode("");
		setOrganizationname("");
		setWorkercode(aform.getWorkercode());
		setWorkername(aform.getWorkername());
		setWorkertitle(aform.getWorkertitle());
		setType("W");
	}
}
public void setExpeditionstr(String newDocument) {
	expedition.setString(newDocument);
}
/**
 * 
 * @param newInsuranseMan java.lang.String
 */
public void setInsuranseMan(java.lang.String newInsuranseMan) {
	insuranseMan = newInsuranseMan;
}
public void setOrganizationcode(String newOrganization) {
	organization.setString(newOrganization);
}
public void setOrganizationname(java.lang.String newOrganizationname) {
	organizationname = newOrganizationname;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 11:58:34)
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
/**
 * specialValidate method comment.
 */
protected void specialValidate(org.apache.struts.action.ActionErrors errors)
{
	type = "P";
	if(organization.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changee.organization"));
	}
	else if(!organization.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changee.organization"));
	}
	else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(organization.getInteger().intValue());
			bean.refreshCopyHelper();
			setOrganizationname(bean.getName());
			if(Boolean.FALSE.equals(bean.getIsprovider())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changee.notorganization"));
			}
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.changee.organization"));
		}
	}

	if(insuranseMan == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changee.remontnikbig"));
	} else if(insuranseMan.length() > 40) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changee.remontnikbig"));
	}
	
	if(worker.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changee.worker"));
	}
	else if(!worker.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changee.worker"));
	}
	else {
		try {
			constructWorker();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.changee.worker"));
		}
	}
}
}
