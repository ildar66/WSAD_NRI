package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "регламент из истории контракта".
 * Creation date: (05.12.2002 17:17:33)
 * @author: Sergey Gourov
 */
public class FromHistoryContractMutReglmntForm extends ContractMutReglmntForm {
/**
 * Insert the method's description here.
 * Creation date: (09.12.2002 11:20:52)
 */
public FromHistoryContractMutReglmntForm() {
	super();
	whereForm = "FromHistoryContractsMutReglmntListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMHISTORY_CONTRACT_MUTREGLMNT_EDIT;
}
}
