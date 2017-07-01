package com.hps.july.arenda.formbean;

/**
 * Form-Bean.
 * канал "ставок платежей"
 * Creation date: (17.01.2003 12:15:07)
 * @author: Sergey Gourov
 */
public class ChannelPaymentRateForm extends PaymentRateForm {
/**
 * ChannelPaymentRateForm constructor comment.
 */
public ChannelPaymentRateForm() {
	super();
	listForm = "ChannelPaymentRatesListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:40:35)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CHANNEL_PAYMENT_RATE_EDIT;
}
}
