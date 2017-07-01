package com.hps.july.basestation.formbean;

import java.util.*;
/**
* Insert the type's description here.
* Creation date: (07.08.2005 14:56:47)
* @author: Shafigullin Ildar
*/
public class SectorListDialogForm extends com.hps.july.web.util.EditForm {
    private int equipment;
	private java.lang.String sectorSortBy;
	private java.util.List sectorList;
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 12:12:25)
 */
public SectorListDialogForm() {
    setSectorSortBy("name_sect");
}
/**
 * Текущее приложение.
 * Creation date: (07.08.2005 14:56:47)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
/**
 * Insert the method's description here.
 * Creation date: (07.08.2005 15:01:20)
 * @return int
 */
public int getEquipment() {
	return equipment;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:40:34)
 * @return java.util.List
 */
public java.util.List getSectorList() {
	return sectorList;
}
/**
 * Insert the method's description here.
 * Creation date: (07.08.2005 15:04:59)
 * @return java.lang.String
 */
public java.lang.String getSectorSortBy() {
	return sectorSortBy;
}
/**
 * Текущее состояние приложения.
 * Creation date: (07.08.2005 14:56:47)
 * @return int
 */
public int getState() {
	return com.hps.july.basestation.APPStates.SECTOR_LIST_DIALOG_FORM;
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    if (getEquipment() != 0) {
        List list = com.hps.july.cdbc.objects.CDBC_Sector_Object.getList(getEquipment(), getSectorSortBy());
        setSectorList(list);
        //System.out.println("list size=" + list.size());//temp
    } else {
        setSectorList(Collections.EMPTY_LIST);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (07.08.2005 15:01:20)
 * @param newEquipment int
 */
public void setEquipment(int newEquipment) {
	equipment = newEquipment;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:40:34)
 * @param newSectorList java.util.List
 */
public void setSectorList(java.util.List newSectorList) {
	sectorList = newSectorList;
}
/**
 * Insert the method's description here.
 * Creation date: (07.08.2005 15:04:59)
 * @param newAntennaSectorSortBy java.lang.String
 */
public void setSectorSortBy(java.lang.String newSectorSortBy) {
	sectorSortBy = newSectorSortBy;
}
}
