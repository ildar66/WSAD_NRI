package com.hps.july.arenda.formbean;

import com.hps.july.web.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;
/**
* Insert the type's description here.
* Creation date: (23.07.2005 13:40:35)
* @author: Shafigullin Ildar
*/
public class LawyearNoteDialogForm extends com.hps.july.web.util.EditForm {
    private int positionId;
	private com.hps.july.arenda.valueobject.LawyearNoteOnPosition_VO lawyearNote;
	private int id;
	private boolean flagOperation;
	private com.hps.july.arenda.valueobject.PeopleVO operatorVO;
/**
 * Текущее приложение.
 * Creation date: (23.07.2005 13:40:35)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2005 14:10:16)
 * @return int
 */
public int getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2005 14:01:19)
 * @return com.hps.july.arenda.valueobject.LawyearNoteOnPosition_VO
 */
public com.hps.july.arenda.valueobject.LawyearNoteOnPosition_VO getLawyearNote() {
	return lawyearNote;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2005 18:00:17)
 * @return com.hps.july.arenda.valueobject.PeopleVO
 */
public com.hps.july.arenda.valueobject.PeopleVO getOperatorVO() {
	return operatorVO;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 16:20:28)
 */
private PeopleVO getPeopleVO_fromOperatorCode(javax.servlet.http.HttpServletRequest request) {
	//инициализируем исполнителя:
	PeopleVO peopleVO = null;
	try {
		Integer oper = OperatorObject.getOperatorCode(request.getRemoteUser());
		OperatorAccessBean oab = new OperatorAccessBean();
		oab.setInitKey_operator(oper.intValue());
		oab.refreshCopyHelper();
		int man = oab.getManKey().man;
		PeopleAccessBean pab = new PeopleAccessBean();
		pab.setInitKey_man(man);
		peopleVO = new PeopleVO(new Integer(man));
		peopleVO.setName(pab.getFullName());
	} catch (Exception e) {
		System.out.println("Cannot determine operator");
		e.printStackTrace(System.out);
	}
	return peopleVO;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2005 13:48:11)
 * @return int
 */
public int getPositionId() {
	return positionId;
}
/**
 * Текущее состояние приложения.
 * Creation date: (23.07.2005 13:40:35)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.LAWYERS_NOTE_DIALOG;
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    if (operatorVO == null)
        operatorVO = getPeopleVO_fromOperatorCode(request);
    lawyearNote = null;
    setFlagOperation(false);
}
/**
 * Инициализация полей в режиме добавления записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    //стандартная инициализация:
    KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
    int key = keyGen.getNextKey("tables.lawyearNoteOnPosition");
    //System.out.println("key=" + key); //temp
    setId(key);
    setLawyearNote(new LawyearNoteOnPosition_VO(new Integer(key)));
    getLawyearNote().setIdPosition(new Integer(getPositionId()));
    Integer num = CDBC_LawyearNote_Object.findCountLawyearNote_byPosition(getPositionId());
    getLawyearNote().setNumber(new Integer(num.intValue()+1)); 
    getLawyearNote().setCreated(new java.sql.Timestamp(System.currentTimeMillis()));
    //пока так:
    if (getOperatorVO() != null) {
        getLawyearNote().setCreatedBy(getOperatorVO().getMan());
        getLawyearNote().setCreatedName(getOperatorVO().getName());
    } else {
        System.err.println("LawyearNoteDialogForm: код оператора не инициализирован");
    }
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2005 14:58:45)
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
    CDBCRowObject ro = CDBC_LawyearNote_Object.findLawyearNote(getId());
    if (ro != null) {
        lawyearNote = new LawyearNoteOnPosition_VO(ro);
        lawyearNote.setCreatedName(ro.getColumn("createdname").asString());
        lawyearNote.setModifiedName(ro.getColumn("modifiedname").asString());
    } else {
        System.out.println("Нет записи с id=" + getId());
        throw new Exception("Нет записи с id=" + getId());
    }
}
/**
 * Этот метод вызывается в режиме удаления записи.
 * Creation date: (10.02.2004 14:01:52)
 */
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    try {
        boolean ok = CDBC_LawyearNote_Object.deleteLawyearNote(getId());
        if (!ok) {
            String errorStr = "Ошибка удаления записи: LawyearNote:id" + getId();
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorStr));
            setFlagOperation(false);
        } else {
            setFlagOperation(true);
        }
    } catch (Exception e) {
        System.out.println("LawyearNoteDialogForm.processDelete():errorTxt: " + e);
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", e));
        e.printStackTrace();
    }
    return "success";
}
/**
 * Этот метод вызывается в режиме добавления записи.
 * Creation date: (10.02.2004 14:06:40)
 */
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    try {
        boolean ok = CDBC_LawyearNote_Object.addLawyearNote(getLawyearNote());
        if (!ok) {
            String errorStr = "Ошибка добаления записи: LawyearNote:id" + getLawyearNote().getId();
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
            setFlagOperation(false);
        } else {
            setFlagOperation(true);
        }
    } catch (Exception e) {
        System.out.println("LawyearNoteDialogForm.processInsert():errorTxt: " + e);
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
        e.printStackTrace();
    }
    return "success";
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    try {
        getLawyearNote().setModified(new java.sql.Timestamp(System.currentTimeMillis()));
        //пока так:
        if (getOperatorVO() != null) {
            getLawyearNote().setModifiedBy(getOperatorVO().getMan());
         } else {
            System.err.println("LawyearNoteDialogForm: код оператора не инициализирован");
        }
        boolean ok = CDBC_LawyearNote_Object.editLawyearNote(getLawyearNote());
        if (!ok) {
            String errorStr = "Ошибка редактирования записи: LawyearNote:id" + getLawyearNote().getId();
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
            setFlagOperation(false);
        } else {
            setFlagOperation(true);
        }
    } catch (Exception e) {
        System.out.println("LawyearNoteDialogForm.processUpdate():errorTxt: " + e);
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
        e.printStackTrace();
    }
    return "success";
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2005 14:58:45)
 * @param newFlagOperation boolean
 */
public void setFlagOperation(boolean newFlagOperation) {
	flagOperation = newFlagOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2005 14:10:16)
 * @param newId int
 */
public void setId(int newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2005 14:01:19)
 * @param newLawyearNote com.hps.july.arenda.valueobject.LawyearNoteOnPosition_VO
 */
public void setLawyearNote(com.hps.july.arenda.valueobject.LawyearNoteOnPosition_VO newLawyearNote) {
	lawyearNote = newLawyearNote;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2005 18:00:17)
 * @param newOperatorVO com.hps.july.arenda.valueobject.PeopleVO
 */
private void setOperatorVO(com.hps.july.arenda.valueobject.PeopleVO newOperatorVO) {
	operatorVO = newOperatorVO;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2005 13:48:11)
 * @param newPositionId int
 */
public void setPositionId(int newPositionId) {
	positionId = newPositionId;
}
}
