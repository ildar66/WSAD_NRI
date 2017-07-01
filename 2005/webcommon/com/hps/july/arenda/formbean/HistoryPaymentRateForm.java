package com.hps.july.arenda.formbean;

/**
 * Form-Bean.
 * "История ставок платежей"
 * Creation date: (17.01.2003 12:12:36)
 * @author: Sergey Gourov
 */
public class HistoryPaymentRateForm extends PaymentRateForm {
/**
 * HistoryPaymentRateForm constructor comment.
 */
public HistoryPaymentRateForm() {
	super();
	listForm = "HistoryPaymentRatesListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:40:35)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_PAYMENT_RATE_EDIT;
}
}
