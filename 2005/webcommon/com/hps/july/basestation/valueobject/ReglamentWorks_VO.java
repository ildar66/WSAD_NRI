package com.hps.july.basestation.valueobject;

import java.sql.Date.*;
/**
* Insert the type's description here.
* Creation date: (27.07.2005 19:15:58)
* @author: Shafigullin Ildar
*/
public class ReglamentWorks_VO {
    private java.lang.Integer idWork; //not null, -- id записи
	private java.lang.Integer equipment;//not null, -- ссылка на комплект оборудования
    private java.lang.Integer man; //not null, -- работник сcылка на People 
    private java.sql.Date dateWork; //not null, -- дата работы
    private java.lang.Integer typeWork; //not null, -- тип работы (вызов из ComboBox из таблицы ReglamentWorkTypes)
    private java.lang.String noteWork; //-- примечание 
    private java.lang.Integer createdBy; //-- кто создал   
    private java.sql.Timestamp created; //-- когда создал
    private java.lang.Integer modifiedBy; //-- кто модифицировал
    private java.sql.Timestamp modified; //-- когда модифицировал
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 20:19:11)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public ReglamentWorks_VO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
	setIdWork((Integer)ro.getColumn("idwork").asObject());
	setEquipment((Integer)ro.getColumn("equipment").asObject());
	setMan((Integer)ro.getColumn("man").asObject());
	setDateWork((java.sql.Date)ro.getColumn("datework").asObject());
	setTypeWork((Integer)ro.getColumn("typework").asObject());
	setNoteWork(ro.getColumn("notework").asString());
    setCreated((java.sql.Timestamp) ro.getColumn("created").asObject());
    setCreatedBy((Integer) ro.getColumn("createdby").asObject());
    setModified((java.sql.Timestamp) ro.getColumn("modified").asObject());
    setModifiedBy((Integer) ro.getColumn("modifiedby").asObject());
}
/**
 * ReglamentWorks_VO constructor comment.
 */
public ReglamentWorks_VO(Integer id) {
	super();
	idWork = id;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:22:15)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getCreated() {
	return created;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:21:39)
 * @return java.lang.Integer
 */
public java.lang.Integer getCreatedBy() {
	return createdBy;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:18:51)
 * @return java.sql.Date
 */
public java.sql.Date getDateWork() {
	return dateWork;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:20:24)
 * @return java.lang.Integer
 */
public java.lang.Integer getEquipment() {
	return equipment;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:33:19)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdWork() {
	return idWork;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:17:53)
 * @return java.lang.Integer
 */
public java.lang.Integer getMan() {
	return man;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:27:06)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getModified() {
	return modified;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:26:09)
 * @return java.lang.Integer
 */
public java.lang.Integer getModifiedBy() {
	return modifiedBy;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:20:47)
 * @return java.lang.String
 */
public java.lang.String getNoteWork() {
	return noteWork;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:20:08)
 * @return java.lang.Integer
 */
public java.lang.Integer getTypeWork() {
	return typeWork;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:22:15)
 * @param newCreated java.sql.Timestamp
 */
public void setCreated(java.sql.Timestamp newCreated) {
	created = newCreated;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:21:39)
 * @param newCreatedBy java.lang.Integer
 */
public void setCreatedBy(java.lang.Integer newCreatedBy) {
	createdBy = newCreatedBy;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:18:51)
 * @param newDateWork java.sql.Date
 */
public void setDateWork(java.sql.Date newDateWork) {
	dateWork = newDateWork;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:20:24)
 * @param newEquipment java.lang.Integer
 */
public void setEquipment(java.lang.Integer newEquipment) {
	equipment = newEquipment;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:33:19)
 * @param newIdWork java.lang.Integer
 */
public void setIdWork(java.lang.Integer newIdWork) {
	idWork = newIdWork;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:17:53)
 * @param newMan java.lang.Integer
 */
public void setMan(java.lang.Integer newMan) {
	man = newMan;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:27:06)
 * @param newModified java.sql.Timestamp
 */
public void setModified(java.sql.Timestamp newModified) {
	modified = newModified;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:26:09)
 * @param newModifiedBy java.lang.Integer
 */
public void setModifiedBy(java.lang.Integer newModifiedBy) {
	modifiedBy = newModifiedBy;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:20:47)
 * @param newNoteWork java.lang.String
 */
public void setNoteWork(java.lang.String newNoteWork) {
	noteWork = newNoteWork;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 19:20:08)
 * @param newTypeWork java.lang.Integer
 */
public void setTypeWork(java.lang.Integer newTypeWork) {
	typeWork = newTypeWork;
}
}
