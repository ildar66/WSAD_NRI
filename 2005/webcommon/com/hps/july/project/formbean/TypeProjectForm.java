package com.hps.july.project.formbean;

import com.hps.july.commonbean.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.ValidationException;
import com.hps.july.project.*;
 
/**
 * Форма редактирования типа проекта.
 * Creation date: (25.09.2002 19:26:04)
 * @author: Maksim Gerasimov
 */
public class TypeProjectForm extends com.hps.july.web.util.EditForm {
	private String name;
	private int projecttype;
	

public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {

	KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
	projecttype = keygen.getNextKey("tables.projecttype");
	ProjectTypeAccessBean bean = new ProjectTypeAccessBean(projecttype, name);
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.PROJECT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {

	ProjectTypeAccessBean bean = new ProjectTypeAccessBean();
	bean.setInitKey_projecttype( projecttype );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (25.09.2002 19:26:04)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { };
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 17:05:34)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 17:05:34)
 * @return int
 */
public int getProjecttype() {
	return projecttype;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.project.APPStates.TYPEPROJECTFORM;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 17:05:34)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name=newName;
	//name = Util_Alex.convertString(newName);
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 17:05:34)
 * @param newProjecttype int
 */
public void setProjecttype(int newProjecttype) {
	projecttype = newProjecttype;
}
public void validateValues(ActionErrors errors) throws Exception {
	
	if ((name == null) || (name.length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.projecttype.name"));
	  
	if (!errors.empty())
		throw new ValidationException();
		
	//if ((getName() == null) || (getName().length() == 0))
	  //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.currency.name"));
	  
	//if ((getShortname() == null) || (getShortname().length() == 0))
	  //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.currency.shortname"));
	
	//if (!errors.empty())
		//throw new ValidationException();
}
}
