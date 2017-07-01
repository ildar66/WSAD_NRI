package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "фактура из истории контракта".
 * Creation date: (23.05.2003 12:20:57)
 * @author: Sergey Gourov
 */
public class FromHistoryFacturaMutactForm extends FacturaMutactForm {
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 15:20:16)
 * @return java.lang.String
 */
String getListForm() {
	return "FromHistoryFacturaMutactList";
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 11:06:28)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMHISTORY_FACTURA_MUTACT_EDIT;
}
}
