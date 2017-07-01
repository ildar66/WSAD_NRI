package com.hps.july.arenda.formbean;

import com.hps.july.arenda.valueobject.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import java.util.*;
/**
 * Insert the type's description here.
 * Creation date: (23.10.2005 14:10:32)
 * @author: Shafigullin Ildar
 */
public class LoanContractStateForm extends com.hps.july.web.util.EditForm {
    private int id;
    private boolean flagOperation;
    private com.hps.july.arenda.valueobject.LoanContractVO vo;
    private java.lang.String idTD;
/**
 * Текущее приложение.
 * Creation date: (23.10.2005 14:10:32)
 * @return int
 */
public int getApplication() {
    return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (23.10.2005 14:15:40)
 * @return int
 */
public int getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (23.10.2005 14:40:49)
 * @return java.lang.String
 */
public java.lang.String getIdTD() {
	return idTD;
}
/**
 * Текущее состояние приложения.
 * Creation date: (23.10.2005 14:10:32)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.LOAN_CONTRACT_STATE;
}
/**
 * Insert the method's description here.
 * Creation date: (23.10.2005 14:16:34)
 * @return com.hps.july.arenda.valueobject.LoanContractVO
 */
public com.hps.july.arenda.valueobject.LoanContractVO getVo() {
	return vo;
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    setFlagOperation(false);
}
/**
 * Insert the method's description here.
 * Creation date: (23.10.2005 14:16:05)
 * @return boolean
 */
public boolean isFlagOperation() {
	return flagOperation;
}
/**
 * Метод загрузки данных в форму
 * Creation date: (13.02.2002 10:12:41)
 */
public void loadRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    vo = com.hps.july.arenda.cdbcobjects.CDBC_LoanContract_Object.find(getId());
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    String errorStr = com.hps.july.arenda.cdbcobjects.CDBC_LoanContract_Object.changeStateLoanContract(getVo().getLeaseDocument(), getVo().getContractState());
    if (errorStr != null) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
        setFlagOperation(false);
    } else {
        setFlagOperation(true);
    }
    return "success";
}
/**
 * Insert the method's description here.
 * Creation date: (23.10.2005 14:16:05)
 * @param newFlagOperation boolean
 */
public void setFlagOperation(boolean newFlagOperation) {
	flagOperation = newFlagOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (23.10.2005 14:15:40)
 * @param newId int
 */
public void setId(int newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (23.10.2005 14:40:49)
 * @param newIdTD java.lang.String
 */
public void setIdTD(java.lang.String newIdTD) {
	idTD = newIdTD;
}
/**
 * Insert the method's description here.
 * Creation date: (23.10.2005 14:16:34)
 * @param newVo com.hps.july.arenda.valueobject.LoanContractVO
 */
public void setVo(com.hps.july.arenda.valueobject.LoanContractVO newVo) {
	vo = newVo;
}
}
