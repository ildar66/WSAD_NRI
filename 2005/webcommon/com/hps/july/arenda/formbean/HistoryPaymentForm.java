package com.hps.july.arenda.formbean;

/**
 * Form-Bean.
 * "История платежей"
 * Creation date: (07.08.2002 11:23:59)
 * @author: Sergey Gourov
 */
public class HistoryPaymentForm extends PaymentForm {
/**
 * Insert the method's description here.
 * Creation date: (07.08.2002 15:43:30)
 */
public HistoryPaymentForm() {
	super();
	listForm = "HistoryPaymentsListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_PAYMENT_EDIT;
}
}
