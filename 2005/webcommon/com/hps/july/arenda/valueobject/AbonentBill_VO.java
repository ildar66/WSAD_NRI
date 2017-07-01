package com.hps.july.arenda.valueobject;

import java.sql.*;
import java.math.*;
import com.hps.july.cdbc.lib.*;
/**
* Bean-Wrapper "Счета по абоненстским договорам"
* Creation date: (16.09.2004 14:48:42)
* @author: Shafigullin Ildar
*/
public class AbonentBill_VO {
	private java.lang.Integer leasebill; //ID счета
	private java.lang.Integer leasedocument; //Код документа
	private Date billdate; //Дата счета
	private java.lang.String billnumber; //Номер счета
	private java.sql.Date billperiodstart; //Начало периода
	private java.sql.Date billperiodend; //Конец периода
	private java.lang.Integer factbill;//Счет_фактура
	private java.lang.String billstatus; //Статус счета
	private java.lang.String billtype;//Тип счета(U-услуги; O-оборудование; S-смешанный)
	private BigDecimal sum;//Сумма счета
	private java.math.BigDecimal sumNds;//Сумма НДС
/**
 * AbonentBil_VO constructor comment.
 */
public AbonentBill_VO() {
  super();
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 16:58:58)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public AbonentBill_VO(CDBCRowObject ro) {
	leasebill = (Integer)ro.getColumn("leasebill").asObject();
	setLeasedocument((Integer)ro.getColumn("leasedocument").asObject()) ;
	setBilldate( (Date)ro.getColumn("billdate").asObject() );
	setBillnumber(ro.getColumn("billnumber").asString());
	setBillperiodstart((Date)ro.getColumn("billperiodstart").asObject());
	setBillperiodend((Date)ro.getColumn("billperiodend").asObject());
	setFactbill((Integer)ro.getColumn("factbill").asObject());
	setBillstatus(ro.getColumn("billstatus").asString());
	setBilltype(ro.getColumn("billtype").asString());
	setSum((BigDecimal)ro.getColumn("sum").asObject());
	setSumNds((BigDecimal)ro.getColumn("sumnds").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:50:50)
 * @return java.sql.Date
 */
public Date getBilldate() {
	return billdate;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:53:09)
 * @return java.lang.String
 */
public java.lang.String getBillnumber() {
	return billnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:54:26)
 * @return java.lang.String
 */
public java.sql.Date getBillperiodend() {
	return billperiodend;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:53:51)
 * @return java.sql.Date
 */
public java.sql.Date getBillperiodstart() {
	return billperiodstart;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:58:38)
 * @return java.lang.String
 */
public java.lang.String getBillstatus() {
	return billstatus;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 15:00:16)
 * @return java.lang.String
 */
public java.lang.String getBilltype() {
	return billtype;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:59:22)
 * @return java.lang.Integer
 */
public java.lang.Integer getFactbill() {
	return factbill;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:51:36)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeasebill() {
	return leasebill;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:52:03)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeasedocument() {
	return leasedocument;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 15:19:55)
 * @return java.math.BigDecimal
 */
public BigDecimal getSum() {
	return sum;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 15:20:47)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumNds() {
	return sumNds;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:50:50)
 * @param newBilldate java.sql.Date
 */
public void setBilldate(Date newBilldate) {
	billdate = newBilldate;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:53:09)
 * @param newBillnumber java.lang.String
 */
public void setBillnumber(java.lang.String newBillnumber) {
	billnumber = newBillnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:54:26)
 * @param newBillperiodend java.sql.Date
 */
public void setBillperiodend(java.sql.Date newBillperiodend) {
	billperiodend = newBillperiodend;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:53:51)
 * @param newBillperiodstart java.sql.Date
 */
public void setBillperiodstart(java.sql.Date newBillperiodstart) {
	billperiodstart = newBillperiodstart;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:58:38)
 * @param newBillstatus java.lang.String
 */
public void setBillstatus(java.lang.String newBillstatus) {
	billstatus = newBillstatus;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 15:00:16)
 * @param newBilltype java.lang.String
 */
public void setBilltype(java.lang.String newBilltype) {
	billtype = newBilltype;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:59:22)
 * @param newFactbill java.lang.Integer
 */
public void setFactbill(java.lang.Integer newFactbill) {
	factbill = newFactbill;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:51:36)
 * @param newLeasebill java.lang.Integer
 */
public void setLeasebill(java.lang.Integer newLeasebill) {
	leasebill = newLeasebill;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 14:52:03)
 * @param newLeasedocument java.lang.Integer
 */
public void setLeasedocument(java.lang.Integer newLeasedocument) {
	leasedocument = newLeasedocument;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 15:19:55)
 * @param newSum java.math.BigDecimal
 */
public void setSum(BigDecimal newSum) {
	sum = newSum;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2004 15:20:47)
 * @param newSumNds java.math.BigDecimal
 */
public void setSumNds(java.math.BigDecimal newSumNds) {
	sumNds = newSumNds;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	return "AbonentBill: id=" + getLeasebill() + "; number=" + getBillnumber();
}
}
