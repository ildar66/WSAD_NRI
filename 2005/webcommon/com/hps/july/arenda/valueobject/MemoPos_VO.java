package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;
import java.sql.Date;
import com.hps.july.cdbc.lib.*;
/**
* контейнер "Позиция служебной записки".
* Creation date: (26.08.2004 11:48:22)
* @author: Shafigullin Ildar
*/
public class MemoPos_VO {
	private java.lang.Integer idPos; //Код позиции
	private java.lang.Integer idHeader; //Код служебной записки
	private java.lang.String phoneNumber; //Избирательный номер
	private java.lang.String tarifplan; //Тарифный план
	private java.lang.Integer comcardcnt; //Количество карт связи
	private BigDecimal cardamount; //Номинал карт
	private java.lang.Integer simcardcnt;//Количество SIM карт
	private java.lang.String equipname;//Наименование оборудования
	private java.lang.Integer equipcnt = new Integer(1);//Количество оборудования
	private java.lang.String defectdescr;//Описание дефекта оборудования
	private java.lang.String service;//Услуга для подключения
	private java.lang.String opertype = "C";//Тип операции подключения(C-подключение; D-отключение;)
	private Date startdate;//Дата начала
	private java.sql.Date enddate;//Дата окончания
	private Boolean isgarantie;//Взимание гарантийного взноса
	private java.lang.String cardname;//Наименование карты услуг связи
	private java.lang.Integer equipcode;//код оборудования из таблицы "leaseresbil2nri"
	private java.lang.Integer idTarifPlan;//Код тарифного плана
	private java.lang.Integer idService;//Код услуги связи
	private java.lang.Integer billdelivery;//Тип доставки счета
	private java.lang.String billaddress;//Адрес доставки счета
/**
 * MemoPos_VO constructor comment.
 */
public MemoPos_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:16:57)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public MemoPos_VO(CDBCRowObject ro) {
	idPos = (Integer) ro.getColumn("idpos").asObject();
	idHeader = (Integer) ro.getColumn("idheader").asObject();
	phoneNumber = ro.getColumn("phonenumber").asString();
	tarifplan = (String) ro.getColumn("tarifplan").asObject();
	comcardcnt = (Integer) ro.getColumn("comcardcnt").asObject();
	cardamount = (BigDecimal) ro.getColumn("cardamount").asObject();
	simcardcnt = (Integer) ro.getColumn("simcardcnt").asObject();
	equipname = (String) ro.getColumn("equipname").asObject();
	equipcnt = (Integer) ro.getColumn("equipcnt").asObject();
	defectdescr = (String) ro.getColumn("defectdescr").asObject();
	service = (String) ro.getColumn("service").asObject();
	opertype = (String) ro.getColumn("opertype").asObject();
	startdate = (Date) ro.getColumn("startdate").asObject();
	enddate = (Date) ro.getColumn("enddate").asObject();
	initIsGarantie(ro);
	cardname = (String) ro.getColumn("cardname").asObject();
	equipcode = (Integer) ro.getColumn("equipcode").asObject();
	idTarifPlan = (Integer)ro.getColumn("idtarifplan").asObject();
	idService = (Integer) ro.getColumn("idservice").asObject();
	billdelivery = (Integer) ro.getColumn("billdelivery").asObject();
	billaddress = (String) ro.getColumn("billaddress").asObject();
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2005 15:43:18)
 * @return java.lang.String
 */
public java.lang.String getBilladdress() {
	return billaddress;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2005 15:42:43)
 * @return java.lang.Integer
 */
public java.lang.Integer getBilldelivery() {
	return billdelivery;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:04:01)
 * @return java.math.BigDecimal
 */
public BigDecimal getCardamount() {
	return cardamount;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:12:02)
 * @return java.lang.String
 */
public java.lang.String getCardname() {
	return cardname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:02:07)
 * @return java.lang.Integer
 */
public java.lang.Integer getComcardcnt() {
	return comcardcnt;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:07:14)
 * @return java.lang.String
 */
public java.lang.String getDefectdescr() {
	return defectdescr;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:09:32)
 * @return java.sql.Date
 */
public java.sql.Date getEnddate() {
	return enddate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:06:34)
 * @return java.lang.Integer
 */
public java.lang.Integer getEquipcnt() {
	return equipcnt;
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2004 11:52:17)
 * @return java.lang.Integer
 */
public java.lang.Integer getEquipcode() {
	return equipcode;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:05:59)
 * @return java.lang.String
 */
public java.lang.String getEquipname() {
	return equipname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:00:22)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdHeader() {
	return idHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 11:59:44)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdPos() {
	return idPos;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 14:02:54)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdService() {
	return idService;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 14:02:32)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdTarifPlan() {
	return idTarifPlan;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:09:59)
 * @return Boolean
 */
public Boolean getIsgarantie() {
	return isgarantie;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:08:15)
 * @return java.lang.String
 */
public java.lang.String getOpertype() {
	return opertype;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:00:57)
 * @return java.lang.String
 */
public java.lang.String getPhoneNumber() {
	return phoneNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:07:44)
 * @return java.lang.String
 */
public java.lang.String getService() {
	return service;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:04:53)
 * @return java.lang.Integer
 */
public java.lang.Integer getSimcardcnt() {
	return simcardcnt;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:09:05)
 * @return java.sql.Date
 */
public Date getStartdate() {
	return startdate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:01:27)
 * @return java.lang.String
 */
public java.lang.String getTarifplan() {
	return tarifplan;
}
/**
 * Insert the method's description here.
 * Creation date: (31.08.2004 16:39:49)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initIsGarantie(CDBCRowObject ro) {
	String isGarantieStr = ro.getColumn("isgarantie").asString();
	if (isGarantieStr.equalsIgnoreCase("Y")) {
		setIsgarantie(Boolean.TRUE);
	} else {
		setIsgarantie(Boolean.FALSE);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2005 15:43:18)
 * @param newBilladdress java.lang.String
 */
public void setBilladdress(java.lang.String newBilladdress) {
	billaddress = newBilladdress;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2005 15:42:43)
 * @param newBilldelivery java.lang.Integer
 */
public void setBilldelivery(java.lang.Integer newBilldelivery) {
	billdelivery = newBilldelivery;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:04:01)
 * @param newCardamount java.math.BigDecimal
 */
public void setCardamount(BigDecimal newCardamount) {
	cardamount = newCardamount;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:12:02)
 * @param newCardname java.lang.String
 */
public void setCardname(java.lang.String newCardname) {
	cardname = newCardname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:02:07)
 * @param newComcardcnt java.lang.Integer
 */
public void setComcardcnt(java.lang.Integer newComcardcnt) {
	comcardcnt = newComcardcnt;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:07:14)
 * @param newDefectdescr java.lang.String
 */
public void setDefectdescr(java.lang.String newDefectdescr) {
	defectdescr = newDefectdescr;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:09:32)
 * @param newEnddate java.sql.Date
 */
public void setEnddate(java.sql.Date newEnddate) {
	enddate = newEnddate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:06:34)
 * @param newEquipcnt java.lang.Integer
 */
public void setEquipcnt(java.lang.Integer newEquipcnt) {
	equipcnt = newEquipcnt;
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2004 11:52:17)
 * @param newEquipcode java.lang.Integer
 */
public void setEquipcode(java.lang.Integer newEquipcode) {
	equipcode = newEquipcode;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:05:59)
 * @param newEquipname java.lang.String
 */
public void setEquipname(java.lang.String newEquipname) {
	equipname = newEquipname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:00:22)
 * @param newIdHeader java.lang.Integer
 */
public void setIdHeader(java.lang.Integer newIdHeader) {
	idHeader = newIdHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 11:59:44)
 * @param newIdPos java.lang.Integer
 */
public void setIdPos(java.lang.Integer newIdPos) {
	idPos = newIdPos;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 14:02:54)
 * @param newIdService java.lang.Integer
 */
public void setIdService(java.lang.Integer newIdService) {
	idService = newIdService;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 14:02:32)
 * @param newIdTarifPlan java.lang.Integer
 */
public void setIdTarifPlan(java.lang.Integer newIdTarifPlan) {
	idTarifPlan = newIdTarifPlan;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:09:59)
 * @param newIsgarantie Boolean
 */
public void setIsgarantie(Boolean newIsgarantie) {
	isgarantie = newIsgarantie;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:08:15)
 * @param newOpertype java.lang.String
 */
public void setOpertype(java.lang.String newOpertype) {
	opertype = newOpertype;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:00:57)
 * @param newPhoneNumber java.lang.String
 */
public void setPhoneNumber(java.lang.String newPhoneNumber) {
	phoneNumber = newPhoneNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:07:44)
 * @param newService java.lang.String
 */
public void setService(java.lang.String newService) {
	service = newService;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:04:53)
 * @param newSimcardcnt java.lang.Integer
 */
public void setSimcardcnt(java.lang.Integer newSimcardcnt) {
	simcardcnt = newSimcardcnt;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:09:05)
 * @param newStartdate java.sql.Date
 */
public void setStartdate(Date newStartdate) {
	startdate = newStartdate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:01:27)
 * @param newTarifplan java.lang.String
 */
public void setTarifplan(java.lang.String newTarifplan) {
	tarifplan = newTarifplan;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	return "MemoPos_VO: idHeader=" + idHeader + "; idPos= " + getIdPos() + "; opertype= " + getOpertype() + "; Startdate=" + getStartdate();
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 12:04:01)
 * @return java.math.BigDecimal
 */
public BigDecimal getCardAmountSumm() {
	BigDecimal cardAmountSumm = null;
	if(cardamount != null && comcardcnt != null){
		cardAmountSumm = cardamount.multiply(new BigDecimal(comcardcnt.toString()));
	}
	return cardAmountSumm;
}
}
