package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "из состояния акта контракта".
 * Creation date: (12.12.2002 20:33:06)
 * @author: Sergey Gourov
 */
public class FromContractActStateForm extends ActStateForm {
/**
 * Insert the method's description here.
 * Creation date: (12.12.2002 20:27:31)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMCONTRACT_STATE_MUTACT_EDIT;
}
}
