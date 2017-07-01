package com.hps.july.basestation.formbean;

import java.util.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.basestation.valueobject.*;
/**
* Insert the type's description here.
* Creation date: (19.08.2005 11:51:16)
* @author: Shafigullin Ildar
*/
public class Kzl_IndexDialogForm extends com.hps.july.web.util.EditForm {
    private int positionID;
    private java.util.List kzlRegionList;
    private int regionID;
    private java.util.List kzlRegionPrefixList;
	private java.lang.String operation = "";
	private java.lang.String formname;
	private java.lang.String fieldnames;
	private java.lang.Integer index;
/**
 * Текущее приложение.
 * Creation date: (19.08.2005 11:51:16)
 * @return int
 */
public int getApplication() {
    return com.hps.july.constants.Applications.BASESTATION;
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2005 15:25:34)
 * @return java.lang.String
 */
public java.lang.String getFieldnames() {
	return fieldnames;
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2005 15:25:15)
 * @return java.lang.String
 */
public java.lang.String getFormname() {
	return formname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2005 15:35:44)
 * @return java.lang.Integer
 */
public java.lang.Integer getIndex() {
	return index;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2005 16:29:28)
 * @return java.util.List
 */
public java.util.List getKzlRegionList() {
	return kzlRegionList;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2005 17:09:00)
 * @return java.util.List
 */
public java.util.List getKzlRegionPrefixList() {
	return kzlRegionPrefixList;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2005 17:27:51)
 * @return java.lang.String
 */
public java.lang.String getOperation() {
	return operation;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2005 16:25:52)
 * @return int
 */
public int getPositionID() {
	return positionID;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2005 16:32:34)
 * @return int
 */
public int getRegionID() {
	return regionID;
}
/**
 * Текущее состояние приложения.
 * Creation date: (19.08.2005 11:51:16)
 * @return int
 */
public int getState() {
	return com.hps.july.basestation.APPStates.KZL_INDEX_DIALOG_FORM;
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    if (operation.equals("changeRegionID")) {
        initKzlRegionPrefixList();
        setOperation("");
    } else {
	    initIndex();
        initKzlRegionList();
        int regID = ((KzlRegion_VO) getKzlRegionList().get(0)).getRegionid().intValue();
        setRegionID(regID);
        initKzlRegionPrefixList();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2005 15:34:42)
 */
private void initIndex() { 
    Integer index = CDBC_SuperRegions_Object.getIndexFromPosition(new Integer(getPositionID()));
    setIndex(index);
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2005 16:32:58)
 */
private void initKzlRegionList() {
    Integer regionType = new Integer(3);
    java.util.List list = CDBC_KzlRegion_Object.getKzlRegionList(new Integer(getPositionID()), regionType, "regionname");
    setKzlRegionList(list);
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2005 17:09:57)
 */
private void initKzlRegionPrefixList() {
    List list =
        CDBC_KzlRegionsPrefix_Object.getKzlRegionPrefixList(
            new Integer(getPositionID()),
            new Integer(getRegionID()),
            "cellid_prefix");
    setKzlRegionPrefixList(list);
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2005 15:25:34)
 * @param newFieldnames java.lang.String
 */
public void setFieldnames(java.lang.String newFieldnames) {
	fieldnames = newFieldnames;
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2005 15:25:15)
 * @param newFormname java.lang.String
 */
public void setFormname(java.lang.String newFormname) {
	formname = newFormname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2005 15:35:44)
 * @param newIndex java.lang.Integer
 */
public void setIndex(java.lang.Integer newIndex) {
	index = newIndex;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2005 16:29:28)
 * @param newKzlRegionList java.util.List
 */
private void setKzlRegionList(java.util.List newKzlRegionList) {
	kzlRegionList = newKzlRegionList;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2005 17:09:00)
 * @param newKzlRegionPrefixList java.util.List
 */
private void setKzlRegionPrefixList(java.util.List newKzlRegionPrefixList) {
    kzlRegionPrefixList = newKzlRegionPrefixList;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2005 17:27:51)
 * @param newOperation java.lang.String
 */
public void setOperation(java.lang.String newOperation) {
	operation = newOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2005 16:25:52)
 * @param newPositionID int
 */
public void setPositionID(int newPositionID) {
/**	
    if (newPositionID != positionID) {
        initKzlRegionList();
    }
*/    
    positionID = newPositionID;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2005 16:32:34)
 * @param newRegionID int
 */
public void setRegionID(int newRegionID) {
	regionID = newRegionID;
}
}
