package com.hps.july.arenda.formbean;

/**
 * Form-Bean.
 * "История правил платежей"
 * Creation date: (08.08.2002 9:51:13)
 * @author: Sergey Gourov
 */
public class HistoryPayRuleForm extends PayRuleForm {
/**
 * HistoryPayRuleForm constructor comment.
 */
public HistoryPayRuleForm() {
	super();
	listForm = "HistoryPayRulesListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_PAY_RULE_EDIT;
}
}
