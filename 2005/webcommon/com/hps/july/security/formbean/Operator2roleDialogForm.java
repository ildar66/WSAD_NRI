/*
 * Created on 27.03.2007
 *
 * Форма ролей оператора.
 */
package com.hps.july.security.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.cdbc.objects.CDBC_Role_Object;
import com.hps.july.valueobject.Role_VO;
import com.hps.july.web.util.EditForm;

/**
 * @author IShaffigulin
 *
 * Форма ролей оператора.
 */
public class Operator2roleDialogForm extends EditForm {
	private String role;
	private boolean flagOperation;
	private Role_VO vo;

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getApplication()
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.SECURITY;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.security.APPStates.OPERATOR_2_ROLE_DIALOG;
	}

	/**
	 * @return
	 */
	public boolean isFlagOperation() {
		return flagOperation;
	}

	/**
	 * @return
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @return
	 */
	public Role_VO getVo() {
		return vo;
	}

	/**
	 * @param b
	 */
	public void setFlagOperation(boolean b) {
		flagOperation = b;
	}

	/**
	 * @param i
	 */
	public void setRole(String i) {
		role = i;
	}

	/**
	 * @param role_VO
	 */
	public void setVo(Role_VO role_VO) {
		vo = role_VO;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initCollections(javax.servlet.http.HttpServletRequest)
	 */
	public void initCollections(HttpServletRequest request) throws Exception {
		setFlagOperation(false);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#loadRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void loadRecord(HttpServletRequest request) throws Exception {
		vo = CDBC_Role_Object.find(getRole());
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:24:59)
	 * @return java.lang.String
	 * @param flag boolean
	 */
	private String process(boolean ok, ActionErrors errors) {
		if (!ok) {
			String errorStr = "Ошибка CRUD операции :" + getVo().getRole();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			setFlagOperation(false);
		} else {
			setFlagOperation(true);
		}
		return "success";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processUpdate(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processUpdate(HttpServletRequest request, ActionErrors errors) throws Exception {
		boolean flag = CDBC_Role_Object.edit(getVo());
		return process(flag, errors);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void initRecord(HttpServletRequest request) throws Exception {
		setRole(null);
		vo = new Role_VO(null, null);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processInsert(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processInsert(HttpServletRequest request, ActionErrors errors) throws Exception {
		boolean flag = CDBC_Role_Object.add(getVo());
		return process(flag, errors);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processDelete(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processDelete(HttpServletRequest request, ActionErrors errors) throws Exception {
		boolean flag = CDBC_Role_Object.delete(getVo());
		return process(flag, errors);
	}

}
