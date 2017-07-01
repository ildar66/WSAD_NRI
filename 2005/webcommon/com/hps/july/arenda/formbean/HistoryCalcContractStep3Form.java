package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "вызов истории контракта аренды" шаг3.
 * Creation date: (20.01.2003 18:03:04)
 * @author: Sergey Gourov
 */
public class HistoryCalcContractStep3Form extends CalcContractStep3Form {
/**
 * Insert the method's description here.
 * Creation date: (20.01.2003 18:04:18)
 */
public HistoryCalcContractStep3Form() {
	super();
	listForm = "HistoryCalcContractStep2Form";
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2003 12:43:52)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_CALC_CONTRACT_STEP3;
}
}
