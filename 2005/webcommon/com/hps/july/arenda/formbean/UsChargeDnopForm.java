package com.hps.july.arenda.formbean;

/**
 * Форма "Оплаты начислений"
 * Form-Bean.
 * Creation date: (25.01.2003 15:21:37)
 * @author: Sergey Gourov
 */
public class UsChargeDnopForm extends ChargeDnopForm {
/**
 * UsChargeDnopForm constructor comment.
 */
public UsChargeDnopForm() {
	super();
	listForm = "UsChargeDnopListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:12:14)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.US_CHARGE_DNOP_EDIT;
}
}
