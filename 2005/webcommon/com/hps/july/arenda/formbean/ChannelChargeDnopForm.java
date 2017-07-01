package com.hps.july.arenda.formbean;

/**
 * канал "Оплаты начислений"
 * Form-Bean.
 * Creation date: (25.01.2003 15:23:13)
 * @author: Sergey Gourov
 */
public class ChannelChargeDnopForm extends ChargeDnopForm {
/**
 * ChannelChargeDnopForm constructor comment.
 */
public ChannelChargeDnopForm() {
	super();
	listForm = "ChannelChargeDnopListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:12:14)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CHANNEL_CHARGE_DNOP_EDIT;
}
}
