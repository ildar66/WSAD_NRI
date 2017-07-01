package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "позиция фактуры из истории контракта".
 * Creation date: (26.05.2003 11:43:18)
 * @author: Sergey Gourov
 */
public class FromHistoryFacturaPosMutactForm extends FacturaPosMutactForm {
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 11:37:39)
 * @return java.lang.String
 */
String getListForm() {
	return "FromHistoryFacturaPosMutactList";
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2003 14:37:54)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMHISTORY_FACTURA_POS_MUTACT_EDIT;
}
}
