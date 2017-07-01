package com.hps.july.arenda.formbean;

/**
 * Form-Bean 
 * "ставки абонентских оплат".
 */
public class AbonentPaymentRateForm extends PaymentRateForm {
public AbonentPaymentRateForm() {
	super();
	listForm = "AbonentPaymentRatesListForm";
}
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_PAYMENT_RATE_EDIT;
}
}
