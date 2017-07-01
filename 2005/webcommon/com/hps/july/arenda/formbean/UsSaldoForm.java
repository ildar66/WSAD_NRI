package com.hps.july.arenda.formbean;

/**
 * Форма "Сальдо"
 * Form-Bean.
 * Creation date: (23.12.2002 16:06:03)
 * @author: Sergey Gourov
 */
public class UsSaldoForm extends SaldoForm {
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:32:03)
 */
public UsSaldoForm() {
	super();
	listForm = "UsSaldoListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:09:52)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.US_SALDO_EDIT;
}
}
