package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма"начало платежей".
 * Creation date: (29.08.2002 11:44:42)
 * @author: Sergey Gourov
 */
public class StartPaymentForm extends StartProlongationForm {
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 15:44:04)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.START_PAYMENT_FORM;
}
}
