package com.hps.july.arenda.valueobject;


import java.math.*;
import com.hps.july.cdbc.lib.*;/**
 * Контейнер для "Начисления".
 * Creation date: (15.04.2004 16:40:33)
 * @author: Shafigullin Ildar
 */
public class LeaseChargeVO extends LeaseDocPositionVO {
	private BigDecimal remaindersum;//Остаток начисления не связанного с платежами в валюте начисления
	private java.lang.String billnumber;//Номер счета для печати
	private boolean byhandraterur;//Признак исправления курса руками
/**
 * LeaseChargeVO constructor comment.
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public LeaseChargeVO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
	super(ro);
	setRemaindersum((BigDecimal)ro.getColumn("remaindersum").asObject());
	initByhandraterur(ro);
	setBillnumber(ro.getColumn("billnumber").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:44:04)
 * @return java.lang.String
 */
public java.lang.String getBillnumber() {
	return billnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:42:06)
 * @return java.math.BigDecimal
 */
public BigDecimal getRemaindersum() {
	return remaindersum;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 17:55:03)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initByhandraterur(CDBCRowObject ro) {
	if (ro.getColumn("byhandraterur").asObject() != null) {
		String byhandraterurStr = ro.getColumn("byhandraterur").asString();
		if (byhandraterurStr.equalsIgnoreCase("Y"))
			setByhandraterur(true);
		else
			setByhandraterur(false);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 17:52:56)
 * @return boolean
 */
public boolean isByhandraterur() {
	return byhandraterur;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:44:04)
 * @param newBillnumber java.lang.String
 */
public void setBillnumber(java.lang.String newBillnumber) {
	billnumber = newBillnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 17:52:56)
 * @param newByhandraterur boolean
 */
public void setByhandraterur(boolean newByhandraterur) {
	byhandraterur = newByhandraterur;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:42:06)
 * @param newRemaindersum java.math.BigDecimal
 */
public void setRemaindersum(BigDecimal newRemaindersum) {
	remaindersum = newRemaindersum;
}
}
