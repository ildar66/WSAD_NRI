package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "акт из контракта".
 * Creation date: (11.12.2002 11:18:24)
 * @author: Sergey Gourov
 */
public class FromContractMutualActForm extends MutualActForm {
/**
 * FromContractMutualActForm constructor comment.
 */
public FromContractMutualActForm() {
	super();
	listForm = "FromContractMutualActsListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 15:11:50)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMCONTRACT_MUTACT_EDIT;
}
}
