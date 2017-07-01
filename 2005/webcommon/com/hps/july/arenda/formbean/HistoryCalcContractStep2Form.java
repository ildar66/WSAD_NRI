package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "вызов истории контракта аренды" шаг2.
 * Creation date: (20.01.2003 17:59:36)
 * @author: Sergey Gourov
 */
public class HistoryCalcContractStep2Form extends CalcContractStep2Form {
/**
 * HistoryCalcContractStep2Form constructor comment.
 */
public HistoryCalcContractStep2Form() {
	super();
	listForm2 = "HistoryCalcContractStep1Form";
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:54:23)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_CALC_CONTRACT_STEP2;
}
}
