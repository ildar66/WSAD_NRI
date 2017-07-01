package com.hps.july.arenda.formbean;

/**
 * Form-Bean.
 * "История получения платежей по контракту"
 * Creation date: (16.07.2003 15:53:51)
 * @author: Sergey Gourov
 */
public class HistoryGetPaysByContractForm extends GetPaysByContractForm {
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 15:52:08)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_GETPAYS_BYCONTRACT;
}
}
