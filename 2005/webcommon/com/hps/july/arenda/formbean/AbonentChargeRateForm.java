package com.hps.july.arenda.formbean;

/**
 * Form-Bean.
 * "������ ����������� ����������"
 */
public class AbonentChargeRateForm extends ChargeRateForm {
public AbonentChargeRateForm() {
	super();
	listForm = "AbonentChargeRatesListForm";
}
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_CHARGE_RATE_EDIT;
}
}
