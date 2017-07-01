/*
 * Created on 27.12.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;

import com.hps.july.web.util.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.*;
/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class OrganizationDialogForm extends AbstractOrganizationForm {
	private boolean flagOperation;
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.dictionary.APPStates.ORGANIZATION_DIALOG;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:24:59)
	 * @return java.lang.String
	 * @param flag boolean
	 */
	private String process(boolean ok, ActionErrors errors) {
		if (!ok) {
			String errorStr = "Ошибка CRUD операции : OrganizationDialogForm";
			errors.add(
				ActionErrors.GLOBAL_ERROR,
				new ActionError("error.txt", errorStr));
			setFlagOperation(false);
		} else {
			setFlagOperation(true);
		}
		return "success";
	}
	/**
	 * @return
	 */
	public boolean isFlagOperation() {
		return flagOperation;
	}

	/**
	 * @param b
	 */
	public void setFlagOperation(boolean b) {
		flagOperation = b;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processDelete(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processDelete(
		HttpServletRequest request,
		ActionErrors errors)
		throws Exception {
		super.processDelete(request, errors);
		setFlagOperation(true);
		return "success";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processInsert(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processInsert(
		HttpServletRequest request,
		ActionErrors errors)
		throws Exception {
		super.processInsert(request, errors);
		setFlagOperation(true);
		return "success";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processUpdate(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processUpdate(
		HttpServletRequest request,
		ActionErrors errors)
		throws Exception {
		super.processUpdate(request, errors);
		setFlagOperation(true);
		return "success";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initCollections(javax.servlet.http.HttpServletRequest)
	 */
	public void initCollections(HttpServletRequest request) throws Exception {
		setFlagOperation(false);
	}

}
