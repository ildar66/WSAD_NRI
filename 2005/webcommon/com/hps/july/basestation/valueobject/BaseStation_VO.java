package com.hps.july.basestation.valueobject;

import java.sql.*;
/**
 * Базовые станции VO(Перечень комплектов оборудования типа "Базовая станция" на позиции).
 * Creation date: (13.07.2005 12:00:56)
 * @author: Shafigullin Ildar
 */
public class BaseStation_VO extends Equipment_VO {
    /** Таблица содержит специфические поля для функциональных комплектов оборудования
    * (ФКО) типа "Базовая станция" на позиции.
    * Таблица используется совместно с таблицами "Комплекты оборудования" (equipment)
    * и "Места хранения" (storageplaces).
    */
	private java.lang.Integer controller;//Ссылка на контроллер
	private java.lang.Integer switchRef;//Ссылка на комутатор
	private java.lang.String type;//стандарт(D-DAMPS; S-GSM 900; C-DCS 1800; G-GSM 900/1800)
	private java.lang.String repeater;//устарело
	private java.lang.Integer number;//Номер БС
	private java.lang.String name;//Наименование БС
	private java.lang.Integer n_stoek;//Количество стоек
	private java.lang.String st_transp;//Количество транспортных стоек
	private java.lang.String time_backup;//Время бэкап
	private java.sql.Date date_assemb_afs;//Дата монтажа и тестир_ АФС
	private java.sql.Date date_assemb_afs2;//Дата монтажа и тестир_ АФС2
	private java.sql.Date date_connect;//Дата подключения к MSC
	private java.sql.Date date_connect2;//Дата подключения к MSC2
	private java.sql.Date date_onair;//Дата включения в эфир
	private java.sql.Date date_onair2;//Дата включения в эфир2
	private java.lang.Integer net_stage;//Этап расширения сети
	private java.lang.String con_type;//Тип подключения к сети(R-Radio; O-Optic; C-Copper)
	private java.lang.Integer e1_qty;//Количество потоков Е1
	private java.lang.String on_air;//Признак БС в эфире(Y-да; N-нет)
	private java.sql.Date date_bldbeg2;//Дата начала строительства
	private java.sql.Date date_assemb2;//Дата монтажа
	private java.sql.Date date_pr2;//Дата приемки
	private java.sql.Date date_test2;//Дата тестирования
	private java.lang.Integer prefixcellid;//Префикс CELLID
/**
 * BaseStation_VO constructor comment.
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public BaseStation_VO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
    super(ro);
    setNumber((Integer) ro.getColumn("number").asObject());
    setName(ro.getColumn("name").asString());
    setType(ro.getColumn("type").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:17:42)
 * @return java.lang.String
 */
public java.lang.String getCon_type() {
	return con_type;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:03:36)
 * @return java.lang.Integer
 */
public java.lang.Integer getController() {
	return controller;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:12:44)
 * @return java.sql.Date
 */
public java.sql.Date getDate_assemb_afs() {
	return date_assemb_afs;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:13:28)
 * @return java.sql.Date
 */
public java.sql.Date getDate_assemb_afs2() {
	return date_assemb_afs2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:22:10)
 * @return java.sql.Date
 */
public java.sql.Date getDate_assemb2() {
	return date_assemb2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:21:48)
 * @return java.sql.Date
 */
public java.sql.Date getDate_bldbeg2() {
	return date_bldbeg2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:14:23)
 * @return java.sql.Date
 */
public java.sql.Date getDate_connect() {
	return date_connect;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:14:52)
 * @return java.sql.Date
 */
public java.sql.Date getDate_connect2() {
	return date_connect2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:15:15)
 * @return java.sql.Date
 */
public java.sql.Date getDate_onair() {
	return date_onair;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:15:42)
 * @return java.sql.Date
 */
public java.sql.Date getDate_onair2() {
	return date_onair2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:25:10)
 * @return java.sql.Date
 */
public java.sql.Date getDate_pr2() {
	return date_pr2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:25:47)
 * @return java.sql.Date
 */
public java.sql.Date getDate_test2() {
	return date_test2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:19:58)
 * @return java.lang.Integer
 */
public java.lang.Integer getE1_qty() {
	return e1_qty;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:10:52)
 * @return java.lang.Integer
 */
public java.lang.Integer getN_stoek() {
	return n_stoek;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:10:09)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:16:05)
 * @return java.lang.Integer
 */
public java.lang.Integer getNet_stage() {
	return net_stage;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:52:51)
 * @return java.lang.Integer
 */
public java.lang.Integer getNumber() {
	return number;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:20:43)
 * @return java.lang.String
 */
public java.lang.String getOn_air() {
	return on_air;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:26:17)
 * @return java.lang.Integer
 */
public java.lang.Integer getPrefixcellid() {
	return prefixcellid;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:08:22)
 * @return java.lang.String
 */
public java.lang.String getRepeater() {
	return repeater;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:11:34)
 * @return java.lang.String
 */
public java.lang.String getSt_transp() {
	return st_transp;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:05:56)
 * @return java.lang.Integer
 */
public java.lang.Integer getSwitchRef() {
	return switchRef;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:11:57)
 * @return java.lang.String
 */
public java.lang.String getTime_backup() {
	return time_backup;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:06:20)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:17:42)
 * @param newCon_type java.lang.String
 */
public void setCon_type(java.lang.String newCon_type) {
	con_type = newCon_type;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:03:36)
 * @param newController java.lang.Integer
 */
public void setController(java.lang.Integer newController) {
	controller = newController;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:12:44)
 * @param newDate_assemb_afs java.sql.Date
 */
public void setDate_assemb_afs(java.sql.Date newDate_assemb_afs) {
	date_assemb_afs = newDate_assemb_afs;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:13:28)
 * @param newDate_assemb_afs2 java.sql.Date
 */
public void setDate_assemb_afs2(java.sql.Date newDate_assemb_afs2) {
	date_assemb_afs2 = newDate_assemb_afs2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:22:10)
 * @param newDate_assemb2 java.sql.Date
 */
public void setDate_assemb2(java.sql.Date newDate_assemb2) {
	date_assemb2 = newDate_assemb2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:21:48)
 * @param newDate_bldbeg2 java.sql.Date
 */
public void setDate_bldbeg2(java.sql.Date newDate_bldbeg2) {
	date_bldbeg2 = newDate_bldbeg2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:14:23)
 * @param newDate_connect java.sql.Date
 */
public void setDate_connect(java.sql.Date newDate_connect) {
	date_connect = newDate_connect;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:14:52)
 * @param newDate_connect2 java.sql.Date
 */
public void setDate_connect2(java.sql.Date newDate_connect2) {
	date_connect2 = newDate_connect2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:15:15)
 * @param newDate_onair java.sql.Date
 */
public void setDate_onair(java.sql.Date newDate_onair) {
	date_onair = newDate_onair;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:15:42)
 * @param newDate_onair2 java.sql.Date
 */
public void setDate_onair2(java.sql.Date newDate_onair2) {
	date_onair2 = newDate_onair2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:25:10)
 * @param newDate_pr2 java.sql.Date
 */
public void setDate_pr2(java.sql.Date newDate_pr2) {
	date_pr2 = newDate_pr2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:25:47)
 * @param newDate_test2 java.sql.Date
 */
public void setDate_test2(java.sql.Date newDate_test2) {
	date_test2 = newDate_test2;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:19:58)
 * @param newE1_qty java.lang.Integer
 */
public void setE1_qty(java.lang.Integer newE1_qty) {
	e1_qty = newE1_qty;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:10:52)
 * @param newN_stoek java.lang.Integer
 */
public void setN_stoek(java.lang.Integer newN_stoek) {
	n_stoek = newN_stoek;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:10:09)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:16:05)
 * @param newNet_stage java.lang.Integer
 */
public void setNet_stage(java.lang.Integer newNet_stage) {
	net_stage = newNet_stage;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:52:51)
 * @param newNumber java.lang.Integer
 */
public void setNumber(java.lang.Integer newNumber) {
	number = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:20:43)
 * @param newOn_air java.lang.String
 */
public void setOn_air(java.lang.String newOn_air) {
	on_air = newOn_air;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:26:17)
 * @param newPrefixcellid java.lang.Integer
 */
public void setPrefixcellid(java.lang.Integer newPrefixcellid) {
	prefixcellid = newPrefixcellid;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:08:22)
 * @param newRepeater java.lang.String
 */
public void setRepeater(java.lang.String newRepeater) {
	repeater = newRepeater;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:11:34)
 * @param newSt_transp java.lang.String
 */
public void setSt_transp(java.lang.String newSt_transp) {
	st_transp = newSt_transp;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:05:56)
 * @param newSwitchRef java.lang.Integer
 */
public void setSwitchRef(java.lang.Integer newSwitchRef) {
	switchRef = newSwitchRef;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:11:57)
 * @param newTime_backup java.lang.String
 */
public void setTime_backup(java.lang.String newTime_backup) {
	time_backup = newTime_backup;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 12:06:20)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
}
