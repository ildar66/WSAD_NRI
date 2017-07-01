package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Форма списка документов "Внутренние расходные накладные"
 */
public class InternalRListForm
	extends BaseStorageListForm
{
/*
	private StringAndSqlDateProperty datefrom;
	private StringAndSqlDateProperty dateto;
	private java.lang.Boolean isowner;
	private StringAndIntegerProperty owner;
	private String ownername;
	private java.lang.Boolean isstorage;
	private StringAndIntegerProperty storage;
	private String storagename;
*/
	private String type;
	private StringAndIntegerProperty renter;
	private String rentername;
	private StringAndIntegerProperty worker;
	private String workername;
	private String workertitle;
//	private Integer sortType = new Integer(1);
public InternalRListForm() {
	super();
	worker = new StringAndIntegerProperty();
	workername = "";
	renter = new StringAndIntegerProperty();
	rentername = "";
	type = "A";
	this.setFinderMethodName( "findInternalOutBillByQBE" );
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:28:57)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] { 
		Boolean.TRUE, getDatefrom(), getDateto(),
		Boolean.TRUE.equals(getIsowner())?Boolean.FALSE:Boolean.TRUE, (getOwner().getInteger() == null)?new Integer(0):getOwner().getInteger(),
		Boolean.TRUE.equals(getIsstorage())?Boolean.FALSE:Boolean.TRUE, (getStorage().getInteger() == null)?new Integer(0):getStorage().getInteger(),
		new Boolean("P".equals(type)), (renter.getInteger() == null)?new Integer(0):renter.getInteger(),
		new Boolean("W".equals(type)), (worker.getInteger() == null)?new Integer(0):worker.getInteger(),
		get_isadmin(),(get_username() != null?get_username():""),
		getOrderBy()
	};
}
public String getFinderMethodName() {
	return "listInternalStorageOutDocuments";
}
public Integer getRenter() {
	return renter.getInteger();
}
public String getRentercode() {
	return renter.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @return java.lang.String
 */
public java.lang.String getRentername() {
	return rentername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
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
	super.initBrowse(mapping,request,response);
    ParamsParser.setState(request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.IORLIST);
	if(getRenter() != null) {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(getRenter().intValue());
			bean.refreshCopyHelper();
			setRentername(bean.getName());
		} catch(Exception e) {
		}
	}
	if(getWorker() != null) {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(getWorker().intValue());
			bean.refreshCopyHelper();
			setWorkername(bean.getMan().getFullName());
			setWorkertitle(bean.getPosition().getName());
		} catch(Exception e) {
		}
	}
	return null;
}
public void setRentercode(String newRenter) {
	renter.setString(newRenter);
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @param newRentername java.lang.String
 */
public void setRentername(java.lang.String newRentername) {
	rentername = newRentername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
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
