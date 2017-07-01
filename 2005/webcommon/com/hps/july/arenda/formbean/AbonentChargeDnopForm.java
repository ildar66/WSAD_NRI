package com.hps.july.arenda.formbean;

/**
 * "Оплаты абонентских начислений"
 * Form-Bean.
 * Creation date: (01.07.2003 10:01:06)
 * @author: Sergey Gourov
 */
public class AbonentChargeDnopForm extends ChargeDnopForm {
/**
 * AbonentChargeDnopForm constructor comment.
 */
public AbonentChargeDnopForm() {
	listForm = "AbonentChargeDnopListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:12:14)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_CHARGE_DNOP_EDIT;
}
}
