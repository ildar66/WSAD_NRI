package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Форма списка документов "Акты замены при ремонте"
 */
public class ChangeEListForm
	extends AbstractChangeListForm
{
	private Boolean isorganization;
	private StringAndIntegerProperty organization;
	private String organizationname;
	private Boolean isworker;
	private StringAndIntegerProperty worker;
	private String workername;
	private String workertitle;
	private String type;
public ChangeEListForm() {
	super();
	isworker = Boolean.TRUE;
	worker = new StringAndIntegerProperty();
	workername = "";
	isorganization = Boolean.TRUE;
	organization = new StringAndIntegerProperty();
	organizationname = "";
	this.setFinderMethodName("listChangeActOnExpeditionDocuments");
	this.type = "A";
	setLastVisited(true);
}
public ExpeditionAccessBean findExpedition() throws java.lang.Exception {
	ExpeditionAccessBean fexp = new ExpeditionAccessBean();
	java.util.Enumeration en;
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
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	roles.add("siteExploitor");
	roles.add("siteStation");
	roles.add("siteTransport");
	return roles;
}
public Integer getExpeditionCode() {
	try {
		return new Integer(findExpedition().getStorageplace());
	} catch(Exception e) {
		return new Integer(0);
	}
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		Boolean.TRUE, getDatefrom(), getDateto(),
		Boolean.TRUE.equals(getIsowner())?Boolean.FALSE:Boolean.TRUE, (getOwner() == null)?new Integer(0):getOwner(),
		(isorganization != null && !isorganization.booleanValue())?"O":"*", (getOrganization() == null)?new Integer(0):getExpeditionCode(), new Integer(0),
		new Character('C'),
		getOrderBy()
	};
}
public String getFinderMethodName() {
	return "listChangeActOnExpeditionDocuments";
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 14:19:10)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsorganization() {
	return isorganization;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 14:19:10)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsworker() {
	return isworker;
}
public Integer getOrganization() {
	return organization.getInteger();
}
public String getOrganizationcode() {
	return organization.getString();
}
public java.lang.String getOrganizationname() {
	return organizationname;
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
/**
 * Insert the method's description here.
 * Creation date: (18.06.2002 16:12:27)
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
 * Creation date: (06.08.2002 15:51:52)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
public Integer getWorker() {
	return worker.getInteger();
}
public String getWorkercode() {
	return worker.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @return java.lang.String
 */
public java.lang.String getWorkertitle() {
	return workertitle;
}
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
    ParamsParser.setState(request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.CHELIST);
	if(this.getWorker() != null) {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(this.getWorker().intValue());
			bean.refreshCopyHelper();
			this.setWorkername(bean.getMan().getFullName());
			this.setWorkertitle(bean.getPosition().getName());
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	if(this.getOrganization() != null) {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(this.getOrganization().intValue());
			bean.refreshCopyHelper();
			this.setOrganizationname(bean.getName());
		} catch(Exception e) {
		}
	}
	return super.initBrowse(mapping,request,response);
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 14:19:10)
 * @param newIsorganization java.lang.Boolean
 */
public void setIsorganization(java.lang.Boolean newIsorganization) {
	isorganization = newIsorganization;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 14:19:10)
 * @param newIsworker java.lang.Boolean
 */
public void setIsworker(java.lang.Boolean newIsworker) {
	isworker = newIsworker;
}
public void setOrganizationcode(String newOrganization) {
	organization.setString(newOrganization);
}
public void setOrganizationname(java.lang.String newOrganizationname) {
	organizationname = newOrganizationname;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 15:51:52)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
public void setWorkercode(String newWorker) {
	worker.setString(newWorker);
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
public void setWorkertitle(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
}
}
