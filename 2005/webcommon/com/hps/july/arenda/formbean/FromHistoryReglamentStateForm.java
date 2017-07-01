package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * ‘орма "состо€ние регламента из истории контракта"..
 * Creation date: (10.12.2002 10:16:41)
 * @author: Sergey Gourov
 */
public class FromHistoryReglamentStateForm extends ReglamentStateForm {
/**
 * FromHistoryReglamentStateForm constructor comment.
 */
public FromHistoryReglamentStateForm() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 11:38:03)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMHISTORY_STATE_MUTREGLMNT_EDIT;
}
}
