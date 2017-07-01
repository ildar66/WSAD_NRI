package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "телефоны из контракта".
 * Creation date: (15.11.2002 16:18:28)
 * @author: Sergey Gourov
 */
public class FromContractPhoneMutReglmntForm extends PhoneMutReglmntForm {
/**
 * Insert the method's description here.
 * Creation date: (15.11.2002 17:02:31)
 */
public FromContractPhoneMutReglmntForm() {
	super();
	listForm = "FromContractPhonesMutReglmntListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMCONTRACT_PHONE_MUTREGLMNT_EDIT;
}
}
