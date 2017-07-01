package com.hps.july.arenda.formbean;

/**
 * "История Оплаты начислений"
 * Form-Bean.
 * Creation date: (25.01.2003 15:18:23)
 * @author: Sergey Gourov
 */
public class HistoryChargeDnopForm extends ChargeDnopForm {
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:20:36)
 */
public HistoryChargeDnopForm() {
	super();
	listForm = "HistoryChargeDnopListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:12:14)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_CHARGE_DNOP_EDIT;
}
}
