package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "вызов истории контракта аренды" шаг1.
 * Creation date: (20.01.2003 17:50:15)
 * @author: Sergey Gourov
 */
public class HistoryCalcContractStep1Form extends CalcContractStep1Form {
/**
 * HistoryCalcContractStep1Form constructor comment.
 */
public HistoryCalcContractStep1Form() {
	super();
	listForm = "HistoryForm";
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:54:23)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_CALC_CONTRACT_STEP1;
}
}
