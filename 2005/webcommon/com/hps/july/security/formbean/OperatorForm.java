package com.hps.july.security.formbean;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.OperatorAccessBean;
import com.hps.july.security.util.SecurityUtils;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
/**
 * Форма редактирования оператора.
 * Creation date: (15.01.2002 14:08:44)
 * @author: Administrator
 */
public class OperatorForm extends com.hps.july.web.util.EditForm {
	private int operator;
	private java.lang.String login;
	private java.lang.String notInCipherPassword;
	private java.lang.Boolean enabled;
	private CDBCResultSet msUsers = new CDBCResultSet();
	private Integer msucode = null;
	private boolean validated = true;
/**
 * Метод вызывается после добавления/изменения основной записи.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {
		//System.out.println("Before update MSUCode=" + getMsucode());
		OperatorAccessBean bean1 = (OperatorAccessBean)getDataBean(request);
		bean1.refreshCopyHelper();
		bean1.setMsucode(getMsucode());
		bean1.commitCopyHelper();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	OperatorListForm oprListFrm = (OperatorListForm)request.getSession().getAttribute( "OperatorListForm" );
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setOperator(keyGen.getNextKey("tables.operators"));

    OperatorAccessBean bean = new OperatorAccessBean( getOperator(), new Integer( oprListFrm.getMan() ), 
	    getLogin(), "", getEnabled()  );	

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
	OperatorAccessBean bean = new OperatorAccessBean();
	bean.setInitKey_operator( getOperator() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (12.02.2002 10:31:57)
 * @return java.lang.String
 */
public java.lang.Boolean getEnabled() {
	return enabled;
}
/**
 * Insert the method's description here.
 * Creation date: (12.02.2002 19:02:02)
 * @return java.lang.String
 */
public java.lang.String getLogin() {
	return login;
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 13:00:09)
 * @return int
 */
public Integer getMsucode() {
	return msucode;
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 12:58:33)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 */
public Iterator getMsUsers() {
	return this.msUsers.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (12.02.2002 10:31:01)
 * @return int
 */
public int getOperator() {
	return operator;
}
/**
 * Insert the method's description here.
 * Creation date: (12.02.2002 10:31:42)
 * @return java.lang.String
 */
public java.lang.String getNotInCipherPassword() {
	return notInCipherPassword;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.EDITOPR;
}



	/**
	 * Insert the method's description here.
	 * Creation date: (16.11.2004 12:54:00)
	 * @param request javax.servlet.http.HttpServletRequest
	 * @exception java.lang.Exception The exception description.
	 */
	public void initCollections(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
		try{
		    StringBuffer sqlQuery = new StringBuffer("SELECT msucode, msuser FROM msusers ");
		    this.msUsers.executeQuery(sqlQuery.toString(), new Object [] {});
		}catch(Exception e1) {}
	}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setEnabled(new java.lang.Boolean("true"));
	generatePassword();
}

public void generatePassword(){
	setNotInCipherPassword(SecurityUtils.generatePassword());
}

/**
 * Insert the method's description here.
 * Creation date: (12.02.2002 10:31:57)
 * @param newIsenabled java.lang.String
 */
public void setEnabled(java.lang.Boolean newIsenabled) {
	enabled = newIsenabled;
}
/**
 * Insert the method's description here.
 * Creation date: (12.02.2002 19:02:02)
 * @param newLoiginid java.lang.String
 */
public void setLogin(java.lang.String newLoiginid) {
	login = newLoiginid;
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 13:00:09)
 * @param newMsucode int
 */
public void setMsucode(Integer newMsucode) {
	msucode = newMsucode;
}
/**
 * Insert the method's description here.
 * Creation date: (12.02.2002 10:31:01)
 * @param newOperator int
 */
public void setOperator(int newOperator) {
	operator = newOperator;
}

/* (non-Javadoc)
 * @see com.hps.july.web.util.EditForm#beforeUpdate(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean, javax.servlet.http.HttpServletRequest)
 */
public void beforeUpdate(AbstractEntityAccessBean bean, HttpServletRequest request) throws Exception {
	OperatorAccessBean operatorAccessBean = (OperatorAccessBean) bean; 

	if (getNotInCipherPassword() != null){
		String encryptPassword = SecurityUtils.encryptToMD5(getNotInCipherPassword());
		operatorAccessBean.setPassword(encryptPassword);
		// disable store not encrypt password
		// operatorAccessBean.setOldpwd(getNotInCipherPassword());
	}
}

/**
 * Insert the method's description here.
 * Creation date: (12.02.2002 10:31:42)
 * @param newPassword java.lang.String
 */
public void setNotInCipherPassword(java.lang.String newPassword) {
	notInCipherPassword = newPassword;
}

/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if (!isValidated()) 
		throw new ValidationException();
	
	if ((getLogin() == null) || (getLogin().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.operator.login"));
	else {
		for (int i=0; i < getLogin().length(); i++) {
			if ( ( new Character('z').compareTo(new Character(getLogin().charAt(i))) < 0) || 
				( new Character('0').compareTo(new Character(getLogin().charAt(i))) > 0 ) ) {
	  			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.operator.login"));
	  			break;
			}
		}
	}

	if (getNotInCipherPassword() != null) {
		if (getNotInCipherPassword().length() == 0) 
	  		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.operator.password"));
		else {
			// validate password
//			if (getNotInCipherPassword().length() < 8)
//				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.incorrect.operator.password"));
						
//			for (int i=0; i < getNotInCipherPassword().length(); i++) {
//				if ( ( new Character('z').compareTo(new Character(getNotInCipherPassword().charAt(i))) < 0) || 
//					( new Character('0').compareTo(new Character(getNotInCipherPassword().charAt(i))) > 0 ) ) {
//		  			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.operator.password"));
//		  			break;
//				}
//			}
		}
	}

	if (getEnabled() == null)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.operator.enabled"));

	if (errors.empty()) {
		OperatorAccessBean bean = new OperatorAccessBean();
		try {
			bean = bean.findByLogin(getLogin());
			if ( (bean != null) && (bean.getOperator() != getOperator()) )
		  		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.dup.operator"));
		} catch (javax.ejb.ObjectNotFoundException e) {
			// No operator - all OK
	 	}
	}
	
	
	if (!errors.empty())
		throw new ValidationException();

}
	/**
	 * @return
	 */
	public boolean isValidated() {
		return validated;
	}

	/**
	 * @param b
	 */
	public void setValidated(boolean b) {
		validated = b;
	}

}
