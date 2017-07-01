package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "акты из истории контракта".
 * Creation date: (11.12.2002 11:20:05)
 * @author: Sergey Gourov
 */
public class FromHistoryMutualActForm extends MutualActForm {
/**
 * FromHistoryMutualActForm constructor comment.
 */
public FromHistoryMutualActForm() {
	super();
	listForm = "FromHistoryMutualActsListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 15:11:50)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMHISTORY_MUTACT_EDIT;
}
}
