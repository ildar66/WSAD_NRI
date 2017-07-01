package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
/**
 * Form-Bean.
 * канал "платежей"
 * Creation date: (09.08.2002 10:24:51)
 * @author: Sergey Gourov
 */
public class ChannelPaymentForm extends UsPaymentForm {
/**
 * ChannelPaymentForm constructor comment.
 */
public ChannelPaymentForm() {
	super();
	listForm = "ChannelPaymentsListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CHANNEL_PAYMENT_EDIT;
}
}
