package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "Правила из контракта".
 * Creation date: (06.12.2002 12:23:19)
 * @author: Sergey Gourov
 */
public class FromContractMutualRuleForm extends MutualRuleForm {
/**
 * FromContractMutualRuleForm constructor comment.
 */
public FromContractMutualRuleForm() {
	super();
	whereForm = "FromContractMutualRulesListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMCONTRACT_MUTUAL_RULE_EDIT;
}
}
