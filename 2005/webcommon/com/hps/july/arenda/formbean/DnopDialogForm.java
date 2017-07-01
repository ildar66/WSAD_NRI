/*
 * Created on 20.12.2006
 *
 * "Чем оплачено начисление" EditForm.
 */
package com.hps.july.arenda.formbean;

import javax.servlet.http.HttpServletRequest;

import com.hps.july.arenda.cdbcobjects.CDBC_DnopObject;
import com.hps.july.arenda.valueobject.Dnop_TO;
import com.hps.july.web.util.EditForm;

/**
 * @author IShaffigulin
 *
 * "Чем оплачено начисление" EditForm.
 */
public class DnopDialogForm extends EditForm {
	private int leaseCharge = -1;
	private int leasePayment = -1;
	private boolean flagOperation = false;
	private Dnop_TO to;
	private java.lang.String operation = "";

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getApplication()
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.DNOP_DIALOG;
	}

	/**
	 * @return
	 */
	public int getLeaseCharge() {
		return leaseCharge;
	}

	/**
	 * @return
	 */
	public int getLeasePayment() {
		return leasePayment;
	}

	/**
	 * @param i
	 */
	public void setLeaseCharge(int i) {
		leaseCharge = i;
	}

	/**
	 * @param i
	 */
	public void setLeasePayment(int i) {
		leasePayment = i;
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
	public java.lang.String getOperation() {
		return operation;
	}

	/**
	 * @return
	 */
	public Dnop_TO getTo() {
		return to;
	}

	/**
	 * @param string
	 */
	public void setOperation(java.lang.String string) {
		operation = string;
	}

	/**
	 * @param dnop_TO
	 */
	public void setTo(Dnop_TO dnop_TO) {
		to = dnop_TO;
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
		to = CDBC_DnopObject.findTO(getLeaseCharge(), getLeasePayment());
	}

}
