/*
 * Created on 31.01.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.arenda.sessionbean.ArendaDocumentProcessorAccessBean;
import com.hps.july.persistence.OperatorAccessBean;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChargeAutomaticDialogForm extends StartProlongationForm {
	private boolean flagOperation;
	private int taskStartcode;
	/**
	 * 
	 */
	public ChargeAutomaticDialogForm() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.CHARGE_AUTOMATIC_DIALOG_FORM;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processInsert(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processInsert(HttpServletRequest request, ActionErrors errors) throws Exception {
		boolean isOk = false;
		Integer economist = null;
		Integer contract = null;
		int iOperator = 0;

		if (getCondition().equals("E")) {
			economist = getEconomistcode();
		} else if (getCondition().equals("C")) {
			contract = getLeaseDocumentcode();
		}
		try {
			//System.out.println("operator Name="+ request.getUserPrincipal().getName());
			iOperator = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator();
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
		System.out.println("getOperator()=" + iOperator + " getDate2=" + getDate2());//temp
		int taskCode =
			new ArendaDocumentProcessorAccessBean().makeAutomaticCharges(
				getDate2(),
				getEconomistcode(),
				contract,
				new Integer(iOperator));
		setTaskStartcode(taskCode);
		if (taskCode == 0)
			isOk = true;
			
		return process(isOk, errors);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:24:59)
	 * @return java.lang.String
	 * @param flag boolean
	 */
	private String process(boolean ok, ActionErrors errors) {
		if (!ok) {
			String errorStr =
				"Ошибка операции : см. Журнал (код задачи =" + getTaskStartcode() + ")";
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			errorStr = "<A href='JournalList.do?taskStartcode=" + getTaskStartcode()+ "' onclick='window.open(this.href, \"JournalList\", \"top=250, left=470, width=500, height=500, scrollbars=yes, resizable=yes\").focus(); return false;'>Журнал</A>";
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
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

	/**
	 * @return
	 */
	public int getTaskStartcode() {
		return taskStartcode;
	}

	/**
	 * @param i
	 */
	public void setTaskStartcode(int i) {
		taskStartcode = i;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initCollections(javax.servlet.http.HttpServletRequest)
	 */
	public void initCollections(HttpServletRequest request) throws Exception {
		setFlagOperation(false);
	}

}
