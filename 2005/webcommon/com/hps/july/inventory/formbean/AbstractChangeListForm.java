package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Базовый класс для форм списков документов "Акт замены"
 */
public abstract class AbstractChangeListForm extends com.hps.july.web.util.BrowseForm {
	private StringAndSqlDateProperty datefrom;
	private StringAndSqlDateProperty dateto;
	private java.lang.Boolean isowner;
	private StringAndIntegerProperty owner;
	private String ownername;
	private String acttype;
	private Boolean _isadmin;
	private String _username;
	private Integer sortType = new Integer(1);
public AbstractChangeListForm() {
	datefrom = new StringAndSqlDateProperty();
	datefrom.setSqlDate(new java.sql.Date(new java.util.Date().getTime()));
	dateto = new StringAndSqlDateProperty();
	dateto.setSqlDate(new java.sql.Date(new java.util.Date().getTime()));
	isowner = Boolean.FALSE;
	try {
		java.util.Enumeration en = getOwners();
		if(en.hasMoreElements()) {
			OrganizationAccessBean o = (OrganizationAccessBean)en.nextElement();
			setOwner(new Integer(o.getOrganization()));
			setOwnername(o.getName());
		}
	} catch(Exception e) {
	}
	owner = new StringAndIntegerProperty();
	ownername = "";
	acttype = "A";
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean get_isadmin() {
	return _isadmin;
}
public java.lang.String get_username() {
	return (_username == null)?"":_username;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getActtype() {
	return acttype;
}
public java.sql.Date getDatefrom() {
	return datefrom.getSqlDate();
}
public String getDatefromstr() {
	return datefrom.getString();
}
public java.sql.Date getDateto() {
	return dateto.getSqlDate();
}
public String getDatetostr() {
	return dateto.getString();
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
	};
}
public java.lang.Boolean getIsowner() {
	return isowner;
}
public Integer getOrderBy() {
	if(sortType == null) {
		sortType = new Integer(1);
	}
	return sortType;
}
public Integer getOwner() {
	return owner.getInteger();
}
public String getOwnercode() {
	return owner.getString();
}
public java.lang.String getOwnername() {
	return ownername;
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
public ActionForward initBrowse(ActionMapping mapping, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
	throws java.io.IOException, javax.servlet.ServletException
{
	String s = super.getFinderMethodName();
	try {
		sortType = Integer.valueOf(s);
	} catch (NumberFormatException e) {
	}

	_isadmin = new Boolean(request.isUserInRole("administrator"));
	_username = request.getRemoteUser();
	return null;
}
/**
 * 
 * @param newActtype java.lang.String
 */
public void setActtype(java.lang.String newActtype) {
	acttype = newActtype;
}
public void setDatefrom(java.sql.Date newDate) {
	datefrom.setSqlDate(newDate);
}
public void setDatefromstr(String newDate) {
	datefrom.setString(newDate);
}
public void setDateto(java.sql.Date newDate) {
	dateto.setSqlDate(newDate);
}
public void setDatetostr(String newDate) {
	dateto.setString(newDate);
}
public void setIsowner(java.lang.Boolean newIsowner) {
	isowner = newIsowner;
}
public void setOwner(Integer newOwner) {
	owner.setInteger(newOwner);
}
public void setOwnercode(String newOwner) {
	owner.setString(newOwner);
}
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
}
