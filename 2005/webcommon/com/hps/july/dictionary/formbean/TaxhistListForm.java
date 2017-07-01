package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка истории налогов
 */
public class TaxhistListForm extends com.hps.july.web.util.BrowseForm {
	private StringAndSqlDateProperty date;
	private Integer resource;
	private java.lang.String resourcename;
	private java.lang.String resourcemodel;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public TaxhistListForm() {
	this.setFinderMethodName( "findByResourceOrderByDateDesc" );
	date = new StringAndSqlDateProperty();
	date.setSqlDate(new java.sql.Date(System.currentTimeMillis()));
	resource = new Integer(0);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:43:56)
 * @return java.sql.Date
 */
public java.sql.Date getDate() {
	return date.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:44:38)
 * @return java.lang.String
 */
public String getDatestr() {
	return date.getString();
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
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { getResource() };
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:43:21)
 * @return int
 */
public Integer getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 9:29:55)
 * @return java.lang.String
 */
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 13:57:37)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:44:20)
 * @param newDate java.sql.Date
 */
public void setDate(java.sql.Date newDate) {
	date.setSqlDate(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:45:16)
 * @param newDatestr java.lang.String
 */
public void setDatestr(String newDatestr) {
	date.setString(newDatestr);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:43:21)
 * @param newResource int
 */
public void setResource(Integer newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 9:29:55)
 * @param newResourcemodel java.lang.String
 */
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 13:57:37)
 * @param newResourcesubtypename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
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
