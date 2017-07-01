package com.hps.july.arenda.valueobject;

/**
 * контейнер "информация для Служебной записки по договору аренды".
 * Creation date: (01.09.2004 14:58:01)
 * @author: Shafigullin Ildar
 */
public class Memo_ArendaContractInfo_VO {
	private java.lang.Integer arendacontractID;
	private java.lang.String info;
/**
 * Memo_ArendaContractInfo_VO constructor comment.
 */
public Memo_ArendaContractInfo_VO(Integer arendacontractID) {
	this.arendacontractID = arendacontractID;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 14:58:42)
 * @return java.lang.Integer
 */
public java.lang.Integer getArendacontractID() {
	return arendacontractID;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 14:59:01)
 * @return java.lang.String
 */
public java.lang.String getInfo() {
	return info;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 14:58:42)
 * @param newArendacontractID java.lang.Integer
 */
public void setArendacontractID(java.lang.Integer newArendacontractID) {
	arendacontractID = newArendacontractID;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 14:59:01)
 * @param newInfo java.lang.String
 */
public void setInfo(java.lang.String newInfo) {
	info = newInfo;
}
}
