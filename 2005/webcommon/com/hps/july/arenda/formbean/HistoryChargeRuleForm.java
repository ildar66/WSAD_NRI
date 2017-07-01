package com.hps.july.arenda.formbean;

/**
 * "История правил начислений"
 * Form-Bean.
 * Creation date: (08.08.2002 9:56:41)
 * @author: Sergey Gourov
 */
public class HistoryChargeRuleForm extends ChargeRuleForm {
/**
 * HistoryChargeRuleForm constructor comment.
 */
public HistoryChargeRuleForm() {
	super();
	listForm = "HistoryChargeRulesListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_CHARGE_RULE_EDIT;
}
}
