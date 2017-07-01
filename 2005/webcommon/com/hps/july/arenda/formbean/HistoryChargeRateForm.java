package com.hps.july.arenda.formbean;

/**
 * "История ставок начислений"
 * Form-Bean.
 * Creation date: (22.01.2003 18:48:43)
 * @author: Sergey Gourov
 */
public class HistoryChargeRateForm extends ChargeRateForm {
/**
 * HistoryChargeRateForm constructor comment.
 */
public HistoryChargeRateForm() {
	super();
	listForm = "HistoryChargeRatesListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:40:35)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_CHARGE_RATE_EDIT;
}
}
