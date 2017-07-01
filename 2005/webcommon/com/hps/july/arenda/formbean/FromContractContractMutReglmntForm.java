package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "из регламента".
 * Creation date: (05.12.2002 17:15:00)
 * @author: Sergey Gourov
 */
public class FromContractContractMutReglmntForm extends ContractMutReglmntForm {
/**
 * FromContractContractMutReglmntForm constructor comment.
 */
public FromContractContractMutReglmntForm() {
	super();
	whereForm = "FromContractContractsMutReglmntListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMCONTRACT_CONTRACT_MUTREGLMNT_EDIT;
}
}
