package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "состояние акта из истории контракта".
 * Creation date: (12.12.2002 20:34:15)
 * @author: Sergey Gourov
 */
public class FromHistoryActStateForm extends ActStateForm {
/**
 * Insert the method's description here.
 * Creation date: (12.12.2002 20:27:31)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMHISTORY_STATE_MUTACT_EDIT;
}
}
