package com.hps.july.arenda.formbean;

/**
 * Форма "Ставки начислений"
 * Form-Bean.
 * Creation date: (22.01.2003 18:51:42)
 * @author: Sergey Gourov
 */
public class UsChargeRateForm extends ChargeRateForm {
/**
 * UsChargeRateForm constructor comment.
 */
public UsChargeRateForm() {
	super();
	listForm = "UsChargeRatesListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:40:35)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.US_CHARGE_RATE_EDIT;
}
}
