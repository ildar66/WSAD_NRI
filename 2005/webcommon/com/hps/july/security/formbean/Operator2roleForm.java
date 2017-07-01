package com.hps.july.security.formbean;

import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.*;
/**
 * Форма установки связи оператора и роли.
 * Creation date: (15.01.2002 14:08:44)
 * @author: Administrator
 */
public class Operator2roleForm extends com.hps.july.web.util.EditForm {
	private String roles_role;
	private java.lang.String rolename;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	Operator2roleListForm aform = (Operator2roleListForm)request.getSession().getAttribute( "Operator2roleListForm" );
    Operators2RolesAccessBean bean = new Operators2RolesAccessBean( new Integer(aform.getOperator()), getRoles_role());	
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public RoleAccessBean constructRole() throws Exception {

	RoleAccessBean bean = null;
	if (getRoles_role() != null) {
		bean = new RoleAccessBean();
		bean.setInitKey_role(getRoles_role());
		bean.refreshCopyHelper();
	}
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SECURITY;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	Operator2roleListForm aform = (Operator2roleListForm)request.getSession().getAttribute( "Operator2roleListForm" );
	Operators2RolesAccessBean bean = new Operators2RolesAccessBean();
	bean.setInitKey_operator_operator( new Integer(aform.getOperator()) );
	bean.setInitKey_role_role( getRoles_role() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (26.02.2002 15:12:21)
 * @return java.lang.String
 */
public java.lang.String getRolename() {
	return rolename;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 11:28:27)
 * @return int
 */
public String getRoles_role() {
	return roles_role;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.EDITORL;
}
/**
 * Insert the method's description here.
 * Creation date: (26.02.2002 15:14:11)
 * @param newRoles com.hps.july.security.persistence.RolesAccessBean
 */
public void setRole(com.hps.july.persistence.RoleAccessBean newRoles) throws Exception {
	if (newRoles == null) {
	    rolename = "";
	}
	else {
		rolename = newRoles.getRolename();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (26.02.2002 15:12:21)
 * @param newRolename java.lang.String
 */
public void setRolename(java.lang.String newRolename) {
	rolename = newRolename;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 11:28:27)
 * @param newRoles_role int
 */
public void setRoles_role(String newRoles_role) {
	roles_role = newRoles_role;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if ((getRoles_role() == null) || (getRoles_role().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.operator2role.role"));
	else {
		// Check if role exists
		try {
			constructRole(); 
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.operator2role.role"));
		}
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
