package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "копия регламента из контракта"(лист).
 * Creation date: (09.12.2002 10:17:07)
 * @author: Sergey Gourov
 */
public class FromContractCopyReglamentForm extends CopyReglamentForm {
/**
 * Insert the method's description here.
 * Creation date: (22.11.2002 12:00:27)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMCONTRACT_COPY_REGLAMENT;
}
}
