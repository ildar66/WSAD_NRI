package com.hps.july.arenda.valueobject;

import com.hps.july.cdbc.lib.*;
/**
* контейнер "Получатели служебных записок".
* Creation date: (27.07.2004 15:38:42)
* @author: Shafigullin Ildar
*/
public class MemoTarget_VO {
	private java.lang.Integer idTarget; //Код получателя
	private java.lang.String name; //Наименование
/**
 * MemoTarget constructor comment.
 */
public MemoTarget_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2004 17:10:32)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public MemoTarget_VO(CDBCRowObject ro) {
	idTarget = (Integer)ro.getColumn("idtarget").asObject();
	setName(ro.getColumn("name").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 15:41:06)
 * @param idtarget java.lang.Integer
 */
public MemoTarget_VO(Integer idtarget) {
	this.idTarget = idtarget;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 15:39:08)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdTarget() {
	return idTarget;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 15:39:27)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 15:39:08)
 * @param newIdtarget java.lang.Integer
 */
public void setIdTarget(java.lang.Integer newIdTarget) {
	idTarget = newIdTarget;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 15:39:27)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	return "MemoTarget_VO: idTarget=" + idTarget + "; Name= " + getName();	
}
}
