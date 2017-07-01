package com.hps.july.arenda.formbean;

/**
 * Форма "Состояние платежей"
 * Form-Bean.
 * Creation date: (18.12.2002 22:43:13)
 * @author: Sergey Gourov
 */
public class UsPaymentStateForm extends PaymentStateForm {
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:41:24)
 */
public UsPaymentStateForm() {
	super();
	listForm = "UsPaymentsListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 22:34:36)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.US_STATE_PAYMENT_EDIT;
}
}
