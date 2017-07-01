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
* Creation date: (30.07.2005 13:04:10)
* @author: Shafigullin Ildar
*/
public class FlagsFromLeaseChargesDialogForm extends com.hps.july.web.util.EditForm {
    private int leaseDocPosition;
    private boolean flagOperation;
    private FlagsFromLeaseCharges_TO vo;
	private java.lang.String headerUpdLeaseRates;
/**
 * Текущее приложение.
 * Creation date: (30.07.2005 13:04:10)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (30.07.2005 16:06:45)
 * @return java.lang.String
 */
public java.lang.String getHeaderUpdLeaseRates() {
	return headerUpdLeaseRates;
}
/**
 * Insert the method's description here.
 * Creation date: (30.07.2005 13:10:53)
 * @return int
 */
public int getLeaseDocPosition() {
	return leaseDocPosition;
}
/**
 * Текущее состояние приложения.
 * Creation date: (30.07.2005 13:04:10)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FLAGS_FROM_LEASE_CHARGES_DIALOG;
}
/**
 * Insert the method's description here.
 * Creation date: (30.07.2005 13:12:10)
 * @return com.hps.july.arenda.valueobject.FlagsFromLeaseCharges_TO
 */
public com.hps.july.arenda.valueobject.FlagsFromLeaseCharges_TO getVo() {
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
 * Creation date: (30.07.2005 16:06:03)
 */
private void initHeaderUpdLeaseRates() {
    Object[] ret = com.hps.july.arenda.cdbcobjects.CDBC_LeaseCalcRates_Object.getHeaderUpdLeaseRates(new Integer(getLeaseDocPosition()));
    headerUpdLeaseRates = (String) ret[0];
    //isCalcAct = ((Integer) ret[1]).intValue();
}
/**
 * Insert the method's description here.
 * Creation date: (30.07.2005 13:11:12)
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
    FlagsFromLeaseCharges_TO to =
        com.hps.july.arenda.cdbcobjects.CDBC_DogHistory_Object.findFlagsFromLeaseCharges(new Integer(getLeaseDocPosition()));
    if (to != null) {
        setVo(to);
    } else {
        System.out.println("Нет записи с id=" + getLeaseDocPosition());
        throw new Exception("Нет записи с id=" + getLeaseDocPosition());
    }
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    boolean ok = com.hps.july.arenda.cdbcobjects.CDBC_DogHistory_Object.editFlagsFromLeaseCharges(getVo());
    if (!ok) {
        String errorStr = "Ошибка редактирования записи: FlagsFromLeaseCharges:id" + getLeaseDocPosition();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
        setFlagOperation(false);
    } else {
        setFlagOperation(true);
    }
    return "success";
}
/**
 * Insert the method's description here.
 * Creation date: (30.07.2005 13:11:12)
 * @param newFlagOperation boolean
 */
public void setFlagOperation(boolean newFlagOperation) {
	flagOperation = newFlagOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (30.07.2005 16:06:45)
 * @param newHeaderUpdLeaseRates java.lang.String
 */
public void setHeaderUpdLeaseRates(java.lang.String newHeaderUpdLeaseRates) {
	headerUpdLeaseRates = newHeaderUpdLeaseRates;
}
/**
 * Insert the method's description here.
 * Creation date: (30.07.2005 13:10:53)
 * @param newLeaseDocPosition int
 */
public void setLeaseDocPosition(int newLeaseDocPosition) {
	leaseDocPosition = newLeaseDocPosition;
	initHeaderUpdLeaseRates();
}
/**
 * Insert the method's description here.
 * Creation date: (30.07.2005 13:12:10)
 * @param newVo com.hps.july.arenda.valueobject.FlagsFromLeaseCharges_TO
 */
public void setVo(com.hps.july.arenda.valueobject.FlagsFromLeaseCharges_TO newVo) {
	vo = newVo;
}
}
