package com.hps.july.arenda.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
/**
* Insert the type's description here.
* Creation date: (27.09.2005 14:18:01)
* @author: Shafigullin Ildar
*/
public class ContractCommentDialogForm extends com.hps.july.web.util.EditForm {
    private boolean flagOperation;
    private int contractID;
    private java.lang.String comment;
/**
 * Текущее приложение.
 * Creation date: (27.09.2005 14:18:01)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (27.09.2005 14:33:35)
 * @return java.lang.String
 */
public java.lang.String getComment() {
	return comment;
}
/**
 * Insert the method's description here.
 * Creation date: (27.09.2005 14:26:57)
 * @return int
 */
public int getContractID() {
	return contractID;
}
/**
 * Текущее состояние приложения.
 * Creation date: (27.09.2005 14:18:01)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CONTRACT_COMMENT_DIALOG;
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    setFlagOperation(false);
    setComment("");
}
/**
 * Insert the method's description here.
 * Creation date: (27.09.2005 14:26:01)
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
    LeaseContractBLOBAccessBean beanBLOB = new LeaseContractBLOBAccessBean();
    beanBLOB.setInitKey_leaseDocument(getContractID());
    beanBLOB.refreshCopyHelper();

    java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
    String dataStr = format.format(new java.util.Date(System.currentTimeMillis()));
    setComment(beanBLOB.getComment().trim() + "\n" + dataStr + ":");
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    try {
        LeaseContractBLOBAccessBean beanBLOB = new LeaseContractBLOBAccessBean();
        beanBLOB.setInitKey_leaseDocument(getContractID());
        beanBLOB.refreshCopyHelper();

        beanBLOB.setComment(getComment());
        //System.out.println("bform.getComment() :"+bform.getComment());
        //beanBLOB.setSubject(getSubject());
        beanBLOB.commitCopyHelper();
        setFlagOperation(true);
    } catch (Exception e) {
        System.out.println("ContractCommentDialogForm.java, Exception after update comment! contract=" + getContractID());
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.txt", "Ошибка выполнения ContractCommentDialogForm.processUpdate"));
        setFlagOperation(false);
        e.printStackTrace();
    }
    return "success";
}
/**
 * Insert the method's description here.
 * Creation date: (27.09.2005 14:33:35)
 * @param newComment java.lang.String
 */
public void setComment(java.lang.String newComment) {
	comment = newComment;
}
/**
 * Insert the method's description here.
 * Creation date: (27.09.2005 14:26:57)
 * @param newContractID int
 */
public void setContractID(int newContractID) {
	contractID = newContractID;
}
/**
 * Insert the method's description here.
 * Creation date: (27.09.2005 14:26:01)
 * @param newFlagOperation boolean
 */
public void setFlagOperation(boolean newFlagOperation) {
	flagOperation = newFlagOperation;
}
}
