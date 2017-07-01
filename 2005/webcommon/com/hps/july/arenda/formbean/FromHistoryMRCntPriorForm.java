package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "Приоритеты зачета между договорами из контракта".
 * Creation date: (19.12.2002 5:17:44)
 * @author: Sergey Gourov
 */
public class FromHistoryMRCntPriorForm extends MRCntPriorForm {
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 7:17:26)
 */
public FromHistoryMRCntPriorForm() {
	super();
	listForm = "FromHistoryMRCntPriorsListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:14:23)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMHISTORY_REGLAMENT_CONTRACT_PRIOR_EDIT;
}
}
