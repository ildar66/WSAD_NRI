package com.hps.july.basestation.formbean;

import java.util.*;
/**
* Insert the type's description here.
* Creation date: (29.07.2005 17:34:46)
* @author: Shafigullin Ildar
*/
public class EquipsdetListDialogForm extends com.hps.july.web.util.EditForm {
    private int equipment;
    private java.util.List equipDetList;
	private java.lang.String equipDetSortBy;
	private boolean isContent = false;
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 18:55:16)
 */
public EquipsdetListDialogForm() {
    setEquipDetSortBy("name");
}
/**
 * Текущее приложение.
 * Creation date: (29.07.2005 17:34:46)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 18:17:13)
 * @return java.util.List
 */
public java.util.List getEquipDetList() {
	return equipDetList;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 18:54:22)
 * @return java.lang.String
 */
public java.lang.String getEquipDetSortBy() {
	return equipDetSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 17:35:20)
 * @return int
 */
public int getEquipment() {
	return equipment;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 20:04:57)
 * @return boolean
 */
public boolean getIsContent() {
	return isContent;
}
/**
 * Текущее состояние приложения.
 * Creation date: (29.07.2005 17:34:46)
 * @return int
 */
public int getState() {
	return com.hps.july.basestation.APPStates.EQUIPDETLIST_DIALOG_FORM;
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    if (getEquipment() != 0) {
        List list = com.hps.july.cdbc.objects.CDBCBaseStationObject.getEquipDetList(getEquipment(), getEquipDetSortBy(), getIsContent());
        setEquipDetList(list);
        //System.out.println("list size=" + list.size());//temp
    } else {
        setEquipDetList(Collections.EMPTY_LIST);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 18:17:13)
 * @param newEquipDetList java.util.List
 */
public void setEquipDetList(java.util.List newEquipDetList) {
	equipDetList = newEquipDetList;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 18:54:22)
 * @param newEquipDetSortBy java.lang.String
 */
public void setEquipDetSortBy(java.lang.String newEquipDetSortBy) {
	equipDetSortBy = newEquipDetSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 17:35:20)
 * @param newEquipment int
 */
public void setEquipment(int newEquipment) {
	equipment = newEquipment;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 20:04:57)
 * @param newIsContent boolean
 */
public void setIsContent(boolean newIsContent) {
	isContent = newIsContent;
}
}
