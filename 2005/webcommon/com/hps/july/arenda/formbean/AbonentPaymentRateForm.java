package com.hps.july.arenda.formbean;

/**
 * Form-Bean 
 * "������ ����������� �����".
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
