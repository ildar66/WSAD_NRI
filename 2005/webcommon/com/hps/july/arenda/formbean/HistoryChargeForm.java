package com.hps.july.arenda.formbean;

/**
 * "История начислений"
 * Form-Bean.
 * Creation date: (07.08.2002 16:22:42)
 * @author: Sergey Gourov
 */
public class HistoryChargeForm extends ChargeForm {
/**
 * HistoryChargeForm constructor comment.
 */
public HistoryChargeForm() {
	super();
	listForm = "HistoryChargesListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_CHARGE_EDIT;
}
}
