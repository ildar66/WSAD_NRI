package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "телефоны из истории контракта".
 * Creation date: (15.11.2002 16:20:36)
 * @author: Sergey Gourov
 */
public class FromHistoryPhoneMutReglmntForm extends PhoneMutReglmntForm {
/**
 * Insert the method's description here.
 * Creation date: (15.11.2002 17:05:37)
 */
public FromHistoryPhoneMutReglmntForm() {
	super();
	listForm = "FromHistoryPhonesMutReglmntListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMHISTORY_PHONE_MUTREGLMNT_EDIT;
}
}
