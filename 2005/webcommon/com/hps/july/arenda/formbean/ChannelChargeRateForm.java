package com.hps.july.arenda.formbean;

/**
 * Form-Bean.
 * канал "ставок начислений"
 * Creation date: (22.01.2003 18:53:06)
 * @author: Sergey Gourov
 */
public class ChannelChargeRateForm extends ChargeRateForm {
/**
 * ChannelChargeRateForm constructor comment.
 */
public ChannelChargeRateForm() {
	super();
	listForm = "ChannelChargeRatesListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:40:35)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CHANNEL_CHARGE_RATE_EDIT;
}
}
