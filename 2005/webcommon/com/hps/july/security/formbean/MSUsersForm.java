package com.hps.july.security.formbean;

import com.hps.july.web.util.ValidationException;
import org.apache.struts.action.*;
import com.hps.july.persistence2.*;
import com.hps.july.commonbean.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * Insert the type's description here.
 * Creation date: (16.11.2004 16:22:19)
 * @author: Vadim Glushkov
 */
public class MSUsersForm extends com.hps.july.web.util.EditForm {
	private int msucode;
	private java.lang.String msuser = null;
	private java.lang.String mspassword = null;
/**
 * Метод для создания новой записи.
 * Creation date: (13.02.2002 10:20:36)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request)
	throws Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	Integer id = new Integer(keyGen.getNextKey("tables.msusers"));
    MSUserAccessBean bean = new MSUserAccessBean(id.intValue(), this.msuser);
	setReturnParam(id.toString());
	this.msucode = id.intValue();
	return bean;
}
/**
 * Текущее приложение.
 * Creation date: (13.02.2002 10:24:14)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SECURITY;
}
/**
 * Метод для поиска текущей записи.
 * Creation date: (13.02.2002 10:12:41)
 */
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request)
	throws Exception {
	MSUserAccessBean bean = new MSUserAccessBean();
	bean.setInitKey_msucode(this.msucode);
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 16:31:33)
 * @return java.lang.String
 */
public java.lang.String getMspassword() {
	return mspassword;
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 16:30:32)
 * @return int
 */
public int getMsucode() {
	return msucode;
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 16:30:59)
 * @return java.lang.String
 */
public java.lang.String getMsuser() {
	return msuser;
}
/**
 * Текущее состояние приложения.
 * Creation date: (13.02.2002 10:24:14)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.EDITMSU;
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 16:31:33)
 * @param newMspassword java.lang.String
 */
public void setMspassword(java.lang.String newMspassword) {
	mspassword = newMspassword;
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 16:30:32)
 * @param newMsucode int
 */
public void setMsucode(int newMsucode) {
	msucode = newMsucode;
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 16:30:59)
 * @param newMsuser java.lang.String
 */
public void setMsuser(java.lang.String newMsuser) {
	msuser = newMsuser;
}
	/**
	 * Метод для проверки правильности ввода значений в поля ввода.
	 * Creation date: (22.02.2002 17:29:04)
	 * @exception com.hps.july.web.util.ValidationException - 
	 * при этом исключении ошибки отображаются пользователю.
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		if((getMsuser() == null) || (getMsuser().length() == 0))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.msuser.name"));
		if((getMspassword() == null) || (getMspassword().length() == 0))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.msuser.password"));
		if(!errors.empty())
			throw new ValidationException();
		
	}
}
