package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "фактура из контракта".
 * Creation date: (23.05.2003 12:19:58)
 * @author: Sergey Gourov
 */
public class FromContractFacturaMutactForm extends FacturaMutactForm {
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 15:20:16)
 * @return java.lang.String
 */
String getListForm() {
	return "FromContractFacturaMutactList";
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 11:06:28)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMCONTRACT_FACTURA_MUTACT_EDIT;
}
}
