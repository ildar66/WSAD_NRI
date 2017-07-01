package com.hps.july.arenda.formbean;

/**
 * Form-Bean.
 * "Èסעמנטÿ סאכüהמ"
 * Creation date: (23.12.2002 16:04:28)
 * @author: Sergey Gourov
 */
public class HistorySaldoForm extends SaldoForm {
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:31:15)
 */
public HistorySaldoForm() {
	super();
	listForm = "HistorySaldoListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:09:52)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_SALDO_EDIT;
}
}
