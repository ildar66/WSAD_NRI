package com.hps.july.project.formbean;

import org.apache.struts.action.ActionErrors;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.ValidationException;
import com.hps.july.project.*;
import com.hps.july.project.valueobject.*;
import java.util.*;

/**
 * Форма редактирования значения пользовательской колонки.
 * Creation date: (09.06.2003 10:15:43)
 * @author: Dmitry Dneprov
 */
public class UserColValForm extends com.hps.july.web.util.EditForm {
	private java.lang.String colvalue;
	private com.hps.july.persistence.ProjectDivColumnsAccessBean projectDivColumn;
	private com.hps.july.persistence.ProjectAccessBean project;
	private int projectcode;
	private java.lang.String projectname;
	private int divcolid;
	private java.lang.String divcolname;
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:15:43)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
	setDivcolid(keygen.getNextKey("tables.projectdivcolumns"));

	ProjectDivColValAccessBean bean = new ProjectDivColValAccessBean(getDivcolid(), getProjectcode(), getColvalue()); 
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	// Determine column name here
	try {
		setDivcolname(((ProjectDivColValAccessBean)bean).getProjectDivColumn().getColname());
	} catch (Exception e) {
		e.printStackTrace(System.out);
		setDivcolname("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:15:43)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.PROJECT;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2003 17:30:31)
 * @return java.lang.String
 */
public java.lang.String getColvalue() {
	return colvalue;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:15:43)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ProjectDivColValAccessBean bean = new ProjectDivColValAccessBean();
	try {
		// try to find column value
		bean.setInitKey_projectDivColumn_divcolid(new Integer(getDivcolid()));
		bean.setInitKey_project_project(new Integer(getProjectcode()));
		bean.refreshCopyHelper();
	} catch (Exception e) {
		// Value not found - create it
		try {
			bean = new ProjectDivColValAccessBean(getDivcolid(), getProjectcode(), "");
		} catch (Exception ee) {
			ee.printStackTrace(System.out);
			bean = null;
		}
	}
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2003 17:40:14)
 * @return int
 */
public int getDivcolid() {
	return divcolid;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2003 17:40:36)
 * @return java.lang.String
 */
public java.lang.String getDivcolname() {
	return divcolname;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2003 17:39:11)
 * @return int
 */
public int getProjectcode() {
	return projectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2003 17:39:51)
 * @return java.lang.String
 */
public java.lang.String getProjectname() {
	return projectname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:15:43)
 * @return int
 */
public int getState() {
	return com.hps.july.project.APPStates.EDITUSRVAL;
}
/**
 * Lookup names.
 * Creation date: (09.06.2003 11:24:01)
 */
private void initFields() {
	/*
	try {
		DivisionAccessBean dab = new DivisionAccessBean();
		dab.setInitKey_division(getDivcode());
		dab.refreshCopyHelper();
		setDivname(dab.getName());
	} catch (Exception e) {
		setDivname("");
	}
	try {
		ProjectTypeAccessBean pab = new ProjectTypeAccessBean();
		pab.setInitKey_projecttype(getPrjtypecode());
		pab.refreshCopyHelper();
		setPrjtypename(pab.getName());
	} catch (Exception e) {
		setPrjtypename("");
	}
	*/
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	initFields();
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2003 17:30:31)
 * @param newColvalue java.lang.String
 */
public void setColvalue(java.lang.String newColvalue) {
	colvalue = newColvalue;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2003 17:40:14)
 * @param newDivcolid int
 */
public void setDivcolid(int newDivcolid) {
	divcolid = newDivcolid;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2003 17:40:36)
 * @param newDivcolname java.lang.String
 */
public void setDivcolname(java.lang.String newDivcolname) {
	divcolname = newDivcolname;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2003 17:38:17)
 * @param newProject com.hps.july.persistence.ProjectAccessBean
 */
public void setProject(com.hps.july.persistence.ProjectAccessBean newProject) {
	project = newProject;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2003 17:39:11)
 * @param newProjectcode int
 */
public void setProjectcode(int newProjectcode) {
	projectcode = newProjectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2003 17:33:31)
 * @param newProjectDivColumn com.hps.july.persistence.ProjectDivColumnsAccessBean
 */
public void setProjectDivColumn(com.hps.july.persistence.ProjectDivColumnsAccessBean newProjectDivColumn) {
	projectDivColumn = newProjectDivColumn;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2003 17:39:51)
 * @param newProjectname java.lang.String
 */
public void setProjectname(java.lang.String newProjectname) {
	projectname = newProjectname;
}
/**
 * Validating form values.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	
	// Delete empty user columns
	if ((getColvalue() == null) || (getColvalue().trim().length() == 0))
		setAction("Delete");
	  
	if (!errors.empty())
		throw new ValidationException();
}
}
