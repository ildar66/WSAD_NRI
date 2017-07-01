package com.hps.july.arenda.formbean;

/**
 * Form-Bean.
 * канал "состояний платежей"
 * Creation date: (18.12.2002 22:44:12)
 * @author: Sergey Gourov
 */
public class ChannelPaymentStateForm extends PaymentStateForm {
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:42:21)
 */
public ChannelPaymentStateForm() {
	super();
	listForm = "ChannelPaymentsListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 22:34:36)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CHANNEL_STATE_PAYMENT_EDIT;
}
}
