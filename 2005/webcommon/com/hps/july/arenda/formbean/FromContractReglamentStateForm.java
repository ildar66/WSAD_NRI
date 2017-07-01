package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "состояние регламента из контракта".
 * Creation date: (10.12.2002 10:14:03)
 * @author: Sergey Gourov
 */
public class FromContractReglamentStateForm extends ReglamentStateForm {
/**
 * FromContractReglamentStateForm constructor comment.
 */
public FromContractReglamentStateForm() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 11:38:03)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMCONTRACT_STATE_MUTREGLMNT_EDIT;
}
}
