package com.hps.july.arenda.valueobject;

import java.sql.Date;
/**
* Контейнер "Акты взаимозачета".
* Creation date: (07.04.2005 15:42:32)
* @author: Shafigullin Ildar
*/
public class LeaseMutualActVO extends LeaseDocumentVO {
    private java.lang.Integer mutualreglament; //Доп соглашение о взаимозачете
    private java.lang.String actState; //Состояние акта взаимозачета
    private java.sql.Date actstartdate; //Дата начала периода акта
    private java.sql.Date actenddate; //Дата окончания периода акта
    private java.lang.String header; //Шапка для печати
    private java.lang.String footer; //Footer для печати
    private boolean isSchetFakt; //Признак получения сч _ф
    private boolean isTemp; //Признак временного акта
/**
 * LeaseMutualActNewVO constructor comment.
 */
public LeaseMutualActVO() {
	super();
}
/**
 * LeaseMutualActNewVO constructor comment.
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public LeaseMutualActVO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
	super(ro);
	setActState(ro.getColumn("actstate").asString());
	setActenddate((Date)ro.getColumn("actenddate").asObject());
	setActstartdate((Date)ro.getColumn("actstartdate").asObject());
	setIsSchetFakt(getBooleanFromString("isschetfakt", ro));
	//header, footer, istemp, actfilename - не запролнены .Но они есть в запросе
	setMutualreglament((Integer)ro.getColumn("mutualreglament").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:49:27)
 * @return java.sql.Date
 */
public java.sql.Date getActenddate() {
	return actenddate;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:48:28)
 * @return java.sql.Date
 */
public java.sql.Date getActstartdate() {
	return actstartdate;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:47:47)
 * @return java.lang.String
 */
public java.lang.String getActState() {
	return actState;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 17:27:28)
 */
public boolean getBooleanFromString(String str, com.hps.july.cdbc.lib.CDBCRowObject ro) {
    String booleanStr = ro.getColumn(str).asString();
    if (booleanStr.equalsIgnoreCase("Y")) {
        return true;
    } else {
        return false;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:50:20)
 * @return java.lang.String
 */
public java.lang.String getFooter() {
	return footer;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:50:01)
 * @return java.lang.String
 */
public java.lang.String getHeader() {
	return header;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:46:26)
 * @return java.lang.Integer
 */
public java.lang.Integer getMutualreglament() {
	return mutualreglament;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:58:41)
 * @return boolean
 */
public boolean isIsSchetFakt() {
	return isSchetFakt;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:59:10)
 * @return boolean
 */
public boolean isIsTemp() {
	return isTemp;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:49:27)
 * @param newActenddate java.sql.Date
 */
public void setActenddate(java.sql.Date newActenddate) {
	actenddate = newActenddate;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:48:28)
 * @param newActstartdate java.sql.Date
 */
public void setActstartdate(java.sql.Date newActstartdate) {
	actstartdate = newActstartdate;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:47:47)
 * @param newActState java.lang.String
 */
public void setActState(java.lang.String newActState) {
	actState = newActState;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:50:20)
 * @param newFooter java.lang.String
 */
public void setFooter(java.lang.String newFooter) {
	footer = newFooter;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:50:01)
 * @param newHeader java.lang.String
 */
public void setHeader(java.lang.String newHeader) {
	header = newHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:58:41)
 * @param newIsSchetFakt boolean
 */
public void setIsSchetFakt(boolean newIsSchetFakt) {
	isSchetFakt = newIsSchetFakt;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:59:10)
 * @param newIstemp boolean
 */
public void setIsTemp(boolean newIsTemp) {
	isTemp = newIsTemp;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 15:46:26)
 * @param newMutualreglament java.lang.Integer
 */
public void setMutualreglament(java.lang.Integer newMutualreglament) {
	mutualreglament = newMutualreglament;
}
}
