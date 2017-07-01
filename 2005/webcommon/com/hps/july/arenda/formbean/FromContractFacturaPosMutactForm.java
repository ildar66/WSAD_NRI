package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "позиция фактуры из контракта".
 * Creation date: (26.05.2003 11:43:00)
 * @author: Sergey Gourov
 */
public class FromContractFacturaPosMutactForm extends FacturaPosMutactForm {
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 11:37:39)
 * @return java.lang.String
 */
String getListForm() {
	return "FromContractFacturaPosMutactList";
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2003 14:37:54)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMCONTRACT_FACTURA_POS_MUTACT_EDIT;
}
}
