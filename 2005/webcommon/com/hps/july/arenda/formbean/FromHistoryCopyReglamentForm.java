package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "копия регламента из истории контракта".
 * Creation date: (09.12.2002 10:18:35)
 * @author: Sergey Gourov
 */
public class FromHistoryCopyReglamentForm extends CopyReglamentForm {
/**
 * Insert the method's description here.
 * Creation date: (22.11.2002 12:00:27)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMHISTORY_COPY_REGLAMENT;
}
}
