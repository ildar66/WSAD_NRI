package com.hps.july.arenda.formbean;

/**
* Form-Bean.
 * "История состояний платежей"
 * Creation date: (18.12.2002 22:41:40)
 * @author: Sergey Gourov
 */
public class HistoryPaymentStateForm extends PaymentStateForm {
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:43:02)
 */
public HistoryPaymentStateForm() {
	super();
	listForm = "HistoryPaymentsListForm";
	forMove2pie = "historypaystate";
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 22:34:36)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_STATE_PAYMENT_EDIT;
}
}
