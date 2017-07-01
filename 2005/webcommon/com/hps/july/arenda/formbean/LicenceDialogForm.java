package com.hps.july.arenda.formbean;

import com.hps.july.arenda.valueobject.*;
import org.apache.struts.action.*;
/**
* Insert the type's description here.
* Creation date: (01.08.2005 12:22:15)
* @author: Shafigullin Ildar
*/
public class LicenceDialogForm extends com.hps.july.web.util.EditForm {
    private int position;
    private int typelicence;
    private LicenciesOnPos_VO vo;
    private boolean flagOperation;
	private java.lang.String operator;
	private java.lang.String id;
/**
 * Текущее приложение.
 * Creation date: (01.08.2005 12:22:15)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 17:31:28)
 * @return java.lang.String
 */
public java.lang.String getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 15:27:05)
 * @return java.lang.String
 */
public java.lang.String getOperator() {
	return operator;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 14:02:36)
 * @return int
 */
public int getPosition() {
	return position;
}
/**
 * Текущее состояние приложения.
 * Creation date: (01.08.2005 12:22:15)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.LICENCE_DIALOG;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 14:03:38)
 * @return int
 */
public int getTypelicence() {
	return typelicence;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 14:04:13)
 * @return com.hps.july.arenda.valueobject.LicenciesOnPos_VO
 */
public LicenciesOnPos_VO getVo() {
	return vo;
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    vo = null;
    setFlagOperation(false);
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 14:04:39)
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
    vo =
        com.hps.july.arenda.cdbcobjects.LicenceDAO.findLicenceOnPosition(
            new Integer(getPosition()),
            new Integer(getTypelicence()));
    if (vo == null) {
	    /**
         * String errStr = "Нет записи с position=" + getPosition() + " typelicence=" + getTypelicence();
         * System.out.println(errStr);
         * throw new Exception(errStr);
       	*/
       //инициализируем сами:
        vo = new LicenciesOnPos_VO();
        vo.setPosition(new Integer(getPosition()));
        vo.setTypeLicence(new Integer(getTypelicence()));
    }
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    String errorTxt =
        new com.hps.july.arenda.cdbcobjects.LicenceDAO().updateDateLicence(
            position,
            typelicence,
            getVo().getDateLicence(),
            operator,
            getVo().getNoteLicence());
    if (!errorTxt.equals("")) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.txt", "SQLException: Ошибка выполнения LicenceProcessAction.doTask ERROR:code=" + errorTxt));
        setFlagOperation(false);
    } else {
        setFlagOperation(true);
    }
    return "success";
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 14:04:39)
 * @param newFlagOperation boolean
 */
public void setFlagOperation(boolean newFlagOperation) {
	flagOperation = newFlagOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 17:31:28)
 * @param newId java.lang.String
 */
public void setId(java.lang.String newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 15:27:05)
 * @param newOperator java.lang.String
 */
public void setOperator(java.lang.String newOperator) {
	operator = newOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 14:02:36)
 * @param newPosition int
 */
public void setPosition(int newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 14:03:38)
 * @param newTypelicence int
 */
public void setTypelicence(int newTypelicence) {
	typelicence = newTypelicence;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 14:04:13)
 * @param newVo com.hps.july.arenda.valueobject.LicenciesOnPos_VO
 */
public void setVo(LicenciesOnPos_VO newVo) {
	vo = newVo;
}
}
