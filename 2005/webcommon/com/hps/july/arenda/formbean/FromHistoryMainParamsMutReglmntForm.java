package com.hps.july.arenda.formbean;

import com.ibm.ivj.ejb.runtime.*;
import java.sql.*;
/**
 * Bean-form
 * ‘орма "параметры регламента из истории контракта".
 * Creation date: (29.10.2002 15:58:58)
 * @author: Sergey Gourov
 */
public class FromHistoryMainParamsMutReglmntForm extends FromContractMainParamsMutReglmntForm {
/**
 * FromHistoryMainParamsMutReglmntForm constructor comment.
 */
public FromHistoryMainParamsMutReglmntForm() {
	super();
	listForm = "FromHistoryMutualReglamentsListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 10:47:35)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FROMHISTORY_MAINPARAMS_MUTREGLMNT_EDIT;
}
}
