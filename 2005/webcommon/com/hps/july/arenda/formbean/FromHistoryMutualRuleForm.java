package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "правила из истории контракта".
 * Creation date: (06.12.2002 12:23:19)
 * @author: Sergey Gourov
 */
public class FromHistoryMutualRuleForm extends MutualRuleForm {
/**
 * FromContractMutualRuleForm constructor comment.
 */
public FromHistoryMutualRuleForm() {
	super();
	whereForm = "FromHistoryMutualRulesListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMHISTORY_MUTUAL_RULE_EDIT;
}
}
