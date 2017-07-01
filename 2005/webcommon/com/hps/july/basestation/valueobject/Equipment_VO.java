package com.hps.july.basestation.valueobject;

import  java.sql.Date;

import com.hps.july.basestation.formbean.EquipmentStatusConstants;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.CDBCBaseStationObject;
/**
 * Функциональные комплекты оборудования.
 * Базовые характеристики функциональных комплектов оборудования
 * Creation date: (09.07.2005 14:20:10)
 * @author: Shafigullin Ildar
 */
public class Equipment_VO extends EquipmentStatusConstants  {
    /**
    * Базовая таблица функциональных комплектов оборудования, 
    * в которой  содержатся основные стандартные характеристики комплектов оборудования.
    * Функциональные комплекты оборудования - условная группировка оборудования,
    * которое работает совместно и выполняет заданную функцию 
    * (например, базовая станция, коммутатор, контроллер и т.д.), 
    * хранилище для основных настроек этого оборудования.
    */
	private java.lang.Integer equipment;//Функциональный узел
	private java.lang.Integer position;//Ссылка на позицию
	private java.lang.String state;//Состояние комплекта оборудования(P-Планируется, M-Монтируется, R-Смонтировано, T-Оттестировано, W-Запущено в работу, D-Демонтировано)
	private java.math.BigDecimal pwr_val;//Потребление эл_ энергии
	private java.lang.String pwr_cat;//Категория основной пит_ сети
	private java.lang.String pwr_reserve;//Признак наличия резервного питания
	private java.lang.String pwr_res_cat;//Категория резервного питания сети
	private java.sql.Date date_bldbeg;//Дата начала строительства
	private java.sql.Date date_assemb;//Дата монтажа
	private java.sql.Date date_test;//Дата тестирования
	private java.sql.Date date_pr;//Дата приемки
	private java.lang.String equipcomment;//Комментарий к оборудованию
	private java.lang.Integer cardCount;
/**
 * Equipment_VO constructor comment.
 */
public Equipment_VO(CDBCRowObject ro) {
    super();
    setEquipment((Integer) ro.getColumn("equipment").asObject());
    setPosition((Integer) ro.getColumn("position").asObject());
    setState(ro.getColumn("state").asString());
    setPwr_cat(ro.getColumn("pwr_cat").asString());
    setPwr_reserve(ro.getColumn("pwr_reserve").asString());
    setPwr_res_cat(ro.getColumn("pwr_res_cat").asString());
    setDate_bldbeg((Date) ro.getColumn("date_bldbeg").asObject());
    setDate_assemb((Date) ro.getColumn("date_assemb").asObject());
    setDate_test((Date) ro.getColumn("date_test").asObject());
    setDate_pr((Date)ro.getColumn("date_pr").asObject());
    setEquipcomment(ro.getColumn("equipcomment").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:32:33)
 * @return java.sql.Date
 */
public java.sql.Date getDate_assemb() {
	return date_assemb;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:30:58)
 * @return java.sql.Date
 */
public java.sql.Date getDate_bldbeg() {
	return date_bldbeg;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:34:12)
 * @return java.sql.Date
 */
public java.sql.Date getDate_pr() {
	return date_pr;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:33:45)
 * @return java.sql.Date
 */
public java.sql.Date getDate_test() {
	return date_test;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:37:18)
 * @return java.lang.String
 */
public java.lang.String getEquipcomment() {
	return equipcomment;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:24:00)
 * @return java.lang.Integer
 */
public java.lang.Integer getEquipment() {
	return equipment;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:24:36)
 * @return java.lang.Integer
 */
public java.lang.Integer getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:29:15)
 * @return java.lang.String
 */
public java.lang.String getPwr_cat() {
	return pwr_cat;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:30:24)
 * @return java.lang.String
 */
public java.lang.String getPwr_res_cat() {
	return pwr_res_cat;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:30:04)
 * @return java.lang.String
 */
public java.lang.String getPwr_reserve() {
	return pwr_reserve;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:28:41)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPwr_val() {
	return pwr_val;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:25:00)
 * @return java.lang.String
 */
public java.lang.String getState() {
	return state;
}

public java.lang.String getStateLabel() {
	return getStateEqLabel(state);
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:32:33)
 * @param newDate_assemb java.sql.Date
 */
public void setDate_assemb(java.sql.Date newDate_assemb) {
	date_assemb = newDate_assemb;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:30:58)
 * @param newDate_bldbeg java.sql.Date
 */
public void setDate_bldbeg(java.sql.Date newDate_bldbeg) {
	date_bldbeg = newDate_bldbeg;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:34:12)
 * @param newDate_pr java.sql.Date
 */
public void setDate_pr(java.sql.Date newDate_pr) {
	date_pr = newDate_pr;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:33:45)
 * @param newDate_test java.sql.Date
 */
public void setDate_test(java.sql.Date newDate_test) {
	date_test = newDate_test;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:37:18)
 * @param newEquipcomment java.lang.String
 */
public void setEquipcomment(java.lang.String newEquipcomment) {
	equipcomment = newEquipcomment;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:24:00)
 * @param newEquipment java.lang.Integer
 */
public void setEquipment(java.lang.Integer newEquipment) {
	equipment = newEquipment;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:24:36)
 * @param newPosition java.lang.Integer
 */
public void setPosition(java.lang.Integer newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:29:15)
 * @param newPwr_cat java.lang.String
 */
public void setPwr_cat(java.lang.String newPwr_cat) {
	pwr_cat = newPwr_cat;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:30:24)
 * @param newPwr_res_cat java.lang.String
 */
public void setPwr_res_cat(java.lang.String newPwr_res_cat) {
	pwr_res_cat = newPwr_res_cat;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:30:04)
 * @param newPwr_reserve java.lang.String
 */
public void setPwr_reserve(java.lang.String newPwr_reserve) {
	pwr_reserve = newPwr_reserve;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:28:41)
 * @param newPwr_val java.math.BigDecimal
 */
public void setPwr_val(java.math.BigDecimal newPwr_val) {
	pwr_val = newPwr_val;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:25:00)
 * @param newState java.lang.String
 */
public void setState(java.lang.String newState) {
	state = newState;
}
	/**
	 * @return
	 */
	public java.lang.Integer getCardCount() {
		// делаем запрос к хранимой процедуре
		cardCount = CDBCBaseStationObject.getCardCount(getEquipment());
		System.out.println("getEquipped() for getEquipment() = "+getEquipment()+" cardCount = "+cardCount);
		return cardCount;
	}

	/**
	 * @param boolean1
	 */
	public void setCardCount(java.lang.Integer mockInt) {
	}

}
