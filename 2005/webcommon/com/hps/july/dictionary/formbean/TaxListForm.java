package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка налогов
 */
public class TaxListForm extends com.hps.july.web.util.BrowseForm {
	private StringAndSqlDateProperty date;
	private Integer resourcesubtype;
	private java.lang.String resourcesubtypename;
	private java.lang.Integer resourcetype;
	private java.lang.String resourcetypename;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public TaxListForm() {
	this.setFinderMethodName( "findBySubtypeDateOrderByResourceAsc" );
	date = new StringAndSqlDateProperty();
	date.setSqlDate(new java.sql.Date(System.currentTimeMillis()));
	resourcesubtype = null; //new Integer(0);
	resourcetype = null; //new Integer(0);
	resourcesubtypename = "";
	resourcetypename = "";
	setLastVisited(true);
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictResAdmin");
	//roles.add("dictResOperator");
	roles.add("ArendaMainEconomist");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:43:56)
 * @return java.sql.Date
 */
public java.sql.Date getFilterdate() {
	return date.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:44:38)
 * @return java.lang.String
 */
public String getFilterdatestr() {
	return date.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { 
		getResourcesubtype() != null ? getResourcesubtype() : new Integer(0),
		getFilterdate() != null ? getFilterdate() : new java.sql.Date(System.currentTimeMillis())
	};
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:43:21)
 * @return int
 */
public Integer getResourcesubtype() {
	return resourcesubtype;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 13:57:37)
 * @return java.lang.String
 */
public java.lang.String getResourcesubtypename() {
	return resourcesubtypename;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:21:23)
 * @return java.lang.Integer
 */
public java.lang.Integer getResourcetype() {
	return resourcetype;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:21:40)
 * @return java.lang.String
 */
public java.lang.String getResourcetypename() {
	return resourcetypename;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:44:20)
 * @param newDate java.sql.Date
 */
public void setFilterdate(java.sql.Date newDate) {
	date.setSqlDate(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:45:16)
 * @param newDatestr java.lang.String
 */
public void setFilterdatestr(String newDatestr) {
	date.setString(newDatestr);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:43:21)
 * @param newResource int
 */
public void setResourcesubtype(Integer newResourcesubtype) {
	resourcesubtype = newResourcesubtype;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 13:57:37)
 * @param newResourcesubtypename java.lang.String
 */
public void setResourcesubtypename(java.lang.String newResourcesubtypename) {
	resourcesubtypename = newResourcesubtypename;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:21:23)
 * @param newResourcetype java.lang.Integer
 */
public void setResourcetype(java.lang.Integer newResourcetype) {
	resourcetype = newResourcetype;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:21:40)
 * @param newResourcetypename java.lang.String
 */
public void setResourcetypename(java.lang.String newResourcetypename) {
	resourcetypename = newResourcetypename;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:50:26)
 * @param errors org.apache.struts.action.ActionErrors
 * @exception java.lang.Exception The exception description.
 */
public void validateValues(ActionErrors errors) throws java.lang.Exception {
	if(date.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.restax.date"));
	}
	if (!date.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.restax.date"));
	}
	if (!errors.empty())
		throw new ValidationException();
}
}
