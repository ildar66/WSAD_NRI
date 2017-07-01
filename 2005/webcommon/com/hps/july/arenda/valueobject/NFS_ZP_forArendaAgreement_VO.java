package com.hps.july.arenda.valueobject;

import com.hps.july.cdbc.lib.*;
/**
 * Контейнер "Заказы на приобретения из NFS для договора аренды"
 * Creation date: (02.07.2004 15:02:56)
 * @author: Shafigullin Ildar
 */
public class NFS_ZP_forArendaAgreement_VO extends NFS_ZP_VO {
	private java.lang.Boolean isActive; //признак активности (ДА\НЕТ)-(Y/N)
/**
 * NFS_ZP_forArendaAgreement_VO constructor comment.
 */
public NFS_ZP_forArendaAgreement_VO() {
	super();
}
/**
 * NFS_ZP_forArendaAgreement_VO constructor comment.
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public NFS_ZP_forArendaAgreement_VO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
	super(ro);
	initIsActive(ro);
	initVendor(ro);
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2004 15:08:31)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsActive() {
	return isActive;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2004 15:08:31)
 * @param ro CDBCRowObject
 */
private void initIsActive(CDBCRowObject ro) {
	String isActiveStr = ro.getColumn("isactive").asString();
	if (isActiveStr.equalsIgnoreCase("Y")) {
		setIsActive(Boolean.TRUE);
	} else {
		setIsActive(Boolean.FALSE);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2004 15:08:31)
 * @param newIsActive java.lang.Boolean
 */
public void setIsActive(java.lang.Boolean newIsActive) {
	isActive = newIsActive;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	// Insert code to print the receiver here.
	// This implementation forwards the message to super. You may replace or supplement this.
	return "ZpForAgreement: id=" + getIdZpNfs() + "; Num= " + getNumZp() + "; active= " + getIsActive();
}
}
