package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "Приоритеты зачета между договорами из контракта".
 * Creation date: (19.12.2002 5:15:57)
 * @author: Sergey Gourov
 */
public class FromContractMRCntPriorForm extends MRCntPriorForm {
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 7:17:55)
 */
public FromContractMRCntPriorForm() {
	super();
	listForm = "FromContractMRCntPriorsListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:14:23)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMCONTRACT_REGLAMENT_CONTRACT_PRIOR_EDIT;
}
}
