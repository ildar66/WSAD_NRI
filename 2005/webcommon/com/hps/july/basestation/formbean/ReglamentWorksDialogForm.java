package com.hps.july.basestation.formbean;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import com.hps.july.basestation.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
/**
* Insert the type's description here.
* Creation date: (27.07.2005 21:27:33)
* @author: Shafigullin Ildar
*/
public class ReglamentWorksDialogForm extends com.hps.july.web.util.EditForm {
    private int idWork;
    private com.hps.july.basestation.valueobject.ReglamentWorks_TO regWork;
    private com.hps.july.basestation.valueobject.PeopleVO operatorVO;
    private boolean flagOperation;
    private int positionId;
    private java.util.List equipNameList;
    private java.util.List reglamentWorkTypesList;
    private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	private com.hps.july.basestation.valueobject.ReglamentWorkType_VO regWorkType;
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 18:44:34)
 */
public ReglamentWorksDialogForm() {
    initReglamentWorkTypesList();
}
/**
 * “екущее приложение.
 * Creation date: (27.07.2005 21:27:33)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 19:01:02)
 */
public String getDateWorkStr() {
	if (regWork.getVo() != null && regWork.getVo().getDateWork() != null)
		return format.format(new java.util.Date(regWork.getVo().getDateWork().getTime()));
	else
		return "";
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 18:01:03)
 * @return java.util.List
 */
public java.util.List getEquipNameList() {
	return equipNameList;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:30:50)
 * @return int
 */
public int getIdWork() {
	return idWork;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:37:19)
 * @return com.hps.july.basestation.valueobject.PeopleVO
 */
public com.hps.july.basestation.valueobject.PeopleVO getOperatorVO() {
	return operatorVO;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 16:20:28)
 */
private PeopleVO getPeopleVO_fromOperatorCode(javax.servlet.http.HttpServletRequest request) {
	//инициализируем исполнител€:
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
 * Creation date: (27.07.2005 21:46:05)
 * @return int
 */
public int getPositionId() {
	return positionId;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 18:42:23)
 * @return java.util.List
 */
public java.util.List getReglamentWorkTypesList() {
	return reglamentWorkTypesList;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:33:15)
 * @return com.hps.july.basestation.valueobject.ReglamentWorks_TO
 */
public com.hps.july.basestation.valueobject.ReglamentWorks_TO getRegWork() {
	return regWork;
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2005 15:09:14)
 * @return com.hps.july.basestation.valueobject.ReglamentWorkType_VO
 */
public com.hps.july.basestation.valueobject.ReglamentWorkType_VO getRegWorkType() {
	return regWorkType;
}
/**
 * “екущее состо€ние приложени€.
 * Creation date: (27.07.2005 21:27:33)
 * @return int
 */
public int getState() {
	return com.hps.july.basestation.APPStates.REGLAMENT_WORKS_DIALOG;
}
/**
 * »нициализаци€ коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    initReglamentWorkTypesList();
    if (operatorVO == null)
        operatorVO = getPeopleVO_fromOperatorCode(request);
    regWork = null;
    setFlagOperation(false);
    initEquipNameList();
    initRegWorkType();
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 18:02:18)
 */
private void initEquipNameList() {
    java.util.List list = CDBC_ReglamentWorks_Object.findListEquipNameFromPosition(getPositionId(), "'B', 'R', 'O'", null);
    setEquipNameList(list);
}
/**
 * »нициализаци€ полей в режиме добавлени€ записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    //стандартна€ инициализаци€:
    KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
    int key = keyGen.getNextKey("tables.ReglamentWorks");
    //System.out.println("tables.ReglamentWorks key=" + key); //temp
    setIdWork(key);
    ReglamentWorks_VO vo = new ReglamentWorks_VO(new Integer(key));
    setRegWork(new ReglamentWorks_TO(vo));
    getRegWork().getVo().setCreated(new java.sql.Timestamp(System.currentTimeMillis()));
    //пока так:
    if (getOperatorVO() != null) {
        getRegWork().getVo().setCreatedBy(getOperatorVO().getMan());
        getRegWork().setCreatedName(getOperatorVO().getName());
        //по умолчанию работник из оператора:
        getRegWork().getVo().setMan(getOperatorVO().getMan());
        getRegWork().setManName(getOperatorVO().getName());
    } else {
        System.err.println("ReglamentWorkDialogForm: оператор не инициализирован");
    }
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 18:42:52)
 */
private void initReglamentWorkTypesList() {
    java.util.List list = CDBC_ReglamentWorks_Object.findListReglamentWorkTypes("UPPER(nametype)"); 
    setReglamentWorkTypesList(list);
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2005 15:10:34)
 */
private void initRegWorkType() throws RemoteException, CreateException, NamingException {
	//стандартна€ инициализаци€:
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	int key = keyGen.getNextKey("tables.ReglamentWorkTypes");
    // regWorkType = new ReglamentWorkType_VO(getReglamentWorkTypesList().size() +1, "");
	regWorkType = new ReglamentWorkType_VO(key, "");
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:37:41)
 * @return boolean
 */
public boolean isFlagOperation() {
	return flagOperation;
}
/**
 * ћетод загрузки данных в форму
 * Creation date: (13.02.2002 10:12:41)
 */
public void loadRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    CDBCRowObject ro = CDBC_ReglamentWorks_Object.findReglamentWork(getIdWork());
    if (ro != null) {
        regWork = new ReglamentWorks_TO(new ReglamentWorks_VO(ro));
        regWork.setManName(ro.getColumn("manname").asString());
        regWork.setCreatedName(ro.getColumn("createdname").asString());
        regWork.setModifiedName(ro.getColumn("modifiedname").asString());
    } else {
        System.out.println("Ќет записи с id=" + getIdWork());
        throw new Exception("Ќет записи с id=" + getIdWork());
    }
}
/**
 * Ётот метод вызываетс€ в режиме удалени€ записи.
 * Creation date: (10.02.2004 14:01:52)
 */
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    try {
        boolean ok = CDBC_ReglamentWorks_Object.deleteReglamentWork(getIdWork());
        if (!ok) {
            String errorStr = "ќшибка удалени€ записи: ReglamentWork:id" + getIdWork();
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
            setFlagOperation(false);
        } else {
            setFlagOperation(true);
        }
    } catch (Exception e) {
        System.out.println("ReglamentWorkDialogForm.processDelete():errorTxt: " + e);
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
        e.printStackTrace();
    }
    return "success";
}
/**
 * Ётот метод вызываетс€ в режиме добавлени€ записи.
 * Creation date: (10.02.2004 14:06:40)
 */
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    try {
        boolean ok = false;
        //создан новый тип работ:
        if (getRegWork().getVo().getTypeWork().intValue() == -1) {
            ok = CDBC_ReglamentWorks_Object.addReglamentWorkType(getRegWorkType());
            getRegWork().getVo().setTypeWork(new Integer(getRegWorkType().getIdtype()));
        } else {
            ok = true;
        }
        //добавл€ем ReglamentWork:
        if (ok)
            ok = CDBC_ReglamentWorks_Object.addReglamentWork(getRegWork().getVo());
        if (!ok) {
            String errorStr = "ќшибка добалени€ записи: ReglamentWorks:id" + getRegWork().getVo().getIdWork();
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
            setFlagOperation(false);
        } else {
            setFlagOperation(true);
        }
    } catch (Exception e) {
        System.out.println("ReglamentWorksDialogForm.processInsert():errorTxt: " + e);
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
        e.printStackTrace();
    }
    return "success";
}
/**
 * Ётот метод вызываетс€ в режиме изменени€ записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    try {
        getRegWork().getVo().setModified(new java.sql.Timestamp(System.currentTimeMillis()));
        //пока так:
        if (getOperatorVO() != null) {
            getRegWork().getVo().setModifiedBy(getOperatorVO().getMan());
        } else {
            System.err.println("ReglamentWorksDialogForm: код оператора не инициализирован");
        }
        boolean ok = false;
        //создан новый тип работ:
        if (getRegWork().getVo().getTypeWork().intValue() == -1) {
            ok = CDBC_ReglamentWorks_Object.addReglamentWorkType(getRegWorkType());
            getRegWork().getVo().setTypeWork(new Integer(getRegWorkType().getIdtype()));
        } else {
            ok = true;
        }
        //обновл€ем  ReglamentWork:
        if (ok)
            ok = CDBC_ReglamentWorks_Object.editReglamentWork(getRegWork().getVo());
        if (!ok) {
            String errorStr = "ќшибка редактировани€ записи: ReglamentWorks:id" + getRegWork().getVo().getIdWork();
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
            setFlagOperation(false);
        } else {
            setFlagOperation(true);
        }
    } catch (Exception e) {
        System.out.println("ReglamentWorksDialogForm.processUpdate():errorTxt: " + e);
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
        e.printStackTrace();
    }
    return "success";
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 18:57:53)
 */
public void setDateWorkStr(String dateStr) throws java.text.ParseException {
	if (regWork.getVo() != null && dateStr != null && !dateStr.equals("")) {
		java.util.Date d = format.parse(dateStr);
		java.sql.Date data = new java.sql.Date(d.getTime());
		regWork.getVo().setDateWork(data);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 18:01:03)
 * @param newEquipNameList java.util.List
 */
private void setEquipNameList(java.util.List newEquipNameList) {
	equipNameList = newEquipNameList;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:37:41)
 * @param newFlagOperation boolean
 */
public void setFlagOperation(boolean newFlagOperation) {
	flagOperation = newFlagOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:30:50)
 * @param newIdWork int
 */
public void setIdWork(int newIdWork) {
	idWork = newIdWork;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:37:19)
 * @param newOperatorVO com.hps.july.basestation.valueobject.PeopleVO
 */
public void setOperatorVO(com.hps.july.basestation.valueobject.PeopleVO newOperatorVO) {
	operatorVO = newOperatorVO;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:46:05)
 * @param newPositionId int
 */
public void setPositionId(int newPositionId) {
	positionId = newPositionId;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 18:42:23)
 * @param newReglamentWorkTypesList java.util.List
 */
private void setReglamentWorkTypesList(java.util.List newReglamentWorkTypesList) {
	reglamentWorkTypesList = newReglamentWorkTypesList;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:33:15)
 * @param newRegWork com.hps.july.basestation.valueobject.ReglamentWorks_TO
 */
public void setRegWork(com.hps.july.basestation.valueobject.ReglamentWorks_TO newRegWork) {
	regWork = newRegWork;
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2005 15:09:14)
 * @param newRegWorkType com.hps.july.basestation.valueobject.ReglamentWorkType_VO
 */
public void setRegWorkType(com.hps.july.basestation.valueobject.ReglamentWorkType_VO newRegWorkType) {
	regWorkType = newRegWorkType;
}
}
