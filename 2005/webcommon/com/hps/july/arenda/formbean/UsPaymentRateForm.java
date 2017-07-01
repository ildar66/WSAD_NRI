package com.hps.july.arenda.formbean;

/**
 * Форма "Ставки платежей"
 * Form-Bean.
 * Creation date: (17.01.2003 12:13:56)
 * @author: Sergey Gourov
 */
public class UsPaymentRateForm extends PaymentRateForm {
/**
 * UsPaymentRateForm constructor comment.
 */
public UsPaymentRateForm() {
	super();
	listForm = "UsPaymentRatesListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:40:35)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.US_PAYMENT_RATE_EDIT;
}
}
