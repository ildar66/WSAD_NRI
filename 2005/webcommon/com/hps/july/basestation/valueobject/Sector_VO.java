package com.hps.july.basestation.valueobject;

import java.math.*;
/**
* "Сектора базовых станций на позиции" - VO.
* Creation date: (08.08.2005 10:43:20)
* @author: Shafigullin Ildar
*/
public class Sector_VO {
    private java.lang.Integer id_sect; //Идентификатор сектора
    private java.lang.Integer equipment; //Ссылка на БС
    private java.lang.String name_sect; //Наименование сектора
    private java.lang.Short band; //Диапазон
    private java.lang.String num_sect; //Номер сектора
    private java.math.BigDecimal azimut; //Азимут
    private java.math.BigDecimal power; //Установленная мощность излучения сектора
    private java.lang.String bts_number; //Номер BTS (стойка)
    private java.lang.String con_abis; //Подключение к A_bis(1-Звезда, 2-Кольцо, 3-Цепь)
    private java.lang.Integer port_abis; //Номер A_bis порта
    private java.lang.String num_po; //Номер версии ПО
    private boolean ddk; //Признак наличия ДДК(Y, N)
    private java.lang.Integer trx_num; //Число TRX
    private java.math.BigDecimal tx_pwr; //Мощность на выходе трансивера
    private java.lang.Integer trx_num2; //Число TRX2
    private java.math.BigDecimal tx_pwr2; //Мощность на выходе трансивера2
    private java.math.BigDecimal tx_set_pwr; //Установленная мощность на выходе трансиверов
    private java.lang.Integer trx_ovr_num; //Число TRX в оверлее
    private java.math.BigDecimal tx_ovr_set_pwr; //Установленная мощность на выходе трансивера в оверлее
    private boolean has_flt; //Признак наличия фильтра(Y, N)
    private boolean has_lna; //Признак наличия МШУ	
    private boolean has_buster; //Признак наличия бустера(Y, N)
    //Конфигурация сектора БС(1-Макросота (normal), 2-Макросота (umbrella), 3-Микросота (in door), 4-Микросота (out door)):
    private java.lang.String conf;
    private boolean is_hr; //Признак установки HR
    private boolean cap_gprs; //Признак поддержки GPRS
    private java.lang.Integer operator; //Ссылка на оператора
    private java.lang.String byhand; //Признак ручного ввода
    private java.lang.Integer lac; //LAC
    private java.lang.Integer rac; //RAC
	private java.lang.Integer cellname;//Наименование ячейки
	private java.lang.Integer datasource;//Источник данных
	private java.lang.Short ncc;//Network Color Code
	private java.lang.Short bcc;//Base station Color Code
/**
 * Sector_VO constructor comment.
 */
public Sector_VO(Integer id) {
    super();
    id_sect = id;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:47:48)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAzimut() {
	return azimut;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:46:38)
 * @return java.lang.Short
 */
public java.lang.Short getBand() {
	return band;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 18:27:15)
 * @return java.lang.Short
 */
public java.lang.Short getBcc() {
	return bcc;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:49:15)
 * @return java.lang.String
 */
public java.lang.String getBts_number() {
	return bts_number;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:04:33)
 * @return java.lang.String
 */
public java.lang.String getByhand() {
	return byhand;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:03:29)
 * @return boolean
 */
public boolean getCap_gprs() {
	return cap_gprs;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 18:25:24)
 * @return java.lang.Integer
 */
public java.lang.Integer getCellname() {
	return cellname;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:49:41)
 * @return java.lang.String
 */
public java.lang.String getCon_abis() {
	return con_abis;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:00:47)
 * @return java.lang.String
 */
public java.lang.String getConf() {
	return conf;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 18:25:59)
 * @return java.lang.Integer
 */
public java.lang.Integer getDatasource() {
    return datasource;
}
/**
 * Insert the method's description here.
 * Creation date: (31.08.2005 18:04:32)
 */
public String getDatasourceStr() {
    if (datasource != null) {
        int ds = datasource.intValue();
        if (ds == 0)
            return "Внесено вручную";
        else if (ds == 1)
            return "Внесено Автоматом";
        else if (ds == 2)
            return "Внес Козловцев";
        else if (ds == 3)
            return "Внес Гальченков";
    }
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:51:58)
 * @return boolean
 */
public boolean getDdk() {
	return ddk;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:45:54)
 * @return java.lang.Integer
 */
public java.lang.Integer getEquipment() {
	return equipment;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:58:32)
 * @return boolean
 */
public boolean getHas_buster() {
	return has_buster;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:57:53)
 * @return boolean
 */
public boolean getHas_flt() {
	return has_flt;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:59:49)
 * @return boolean
 */
public boolean getHas_lna() {
	return has_lna;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:45:19)
 * @return java.lang.Integer
 */
public java.lang.Integer getId_sect() {
	return id_sect;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:02:56)
 * @return boolean
 */
public boolean getIs_hr() {
	return is_hr;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:05:15)
 * @return java.lang.Integer
 */
public java.lang.Integer getLac() {
	return lac;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:46:13)
 * @return java.lang.String
 */
public java.lang.String getName_sect() {
	return name_sect;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 18:26:44)
 * @return java.lang.Short
 */
public java.lang.Short getNcc() {
	return ncc;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:51:01)
 * @return java.lang.String
 */
public java.lang.String getNum_po() {
	return num_po;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:46:59)
 * @return java.lang.String
 */
public java.lang.String getNum_sect() {
	return num_sect;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:04:00)
 * @return java.lang.Integer
 */
public java.lang.Integer getOperator() {
	return operator;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:50:41)
 * @return java.lang.Integer
 */
public java.lang.Integer getPort_abis() {
	return port_abis;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:48:18)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPower() {
	return power;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:05:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getRac() {
	return rac;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:52:49)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrx_num() {
	return trx_num;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:53:57)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrx_num2() {
	return trx_num2;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:56:47)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrx_ovr_num() {
	return trx_ovr_num;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:57:21)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getTx_ovr_set_pwr() {
	return tx_ovr_set_pwr;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:53:14)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getTx_pwr() {
	return tx_pwr;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:54:35)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getTx_pwr2() {
	return tx_pwr2;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:55:22)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getTx_set_pwr() {
	return tx_set_pwr;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:47:48)
 * @param newAzimut java.math.BigDecimal
 */
public void setAzimut(java.math.BigDecimal newAzimut) {
	azimut = newAzimut;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:46:38)
 * @param newBand java.lang.Short
 */
public void setBand(java.lang.Short newBand) {
	band = newBand;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 18:27:15)
 * @param newBcc java.lang.Short
 */
public void setBcc(java.lang.Short newBcc) {
	bcc = newBcc;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:49:15)
 * @param newBts_number java.lang.String
 */
public void setBts_number(java.lang.String newBts_number) {
	bts_number = newBts_number;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:04:33)
 * @param newByhand java.lang.String
 */
public void setByhand(java.lang.String newByhand) {
	byhand = newByhand;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:03:29)
 * @param newCap_gprs boolean
 */
public void setCap_gprs(boolean newCap_gprs) {
	cap_gprs = newCap_gprs;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 18:25:24)
 * @param newCellname java.lang.Integer
 */
public void setCellname(java.lang.Integer newCellname) {
	cellname = newCellname;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:49:41)
 * @param newCon_abis java.lang.String
 */
public void setCon_abis(java.lang.String newCon_abis) {
	con_abis = newCon_abis;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:00:47)
 * @param newConf java.lang.String
 */
public void setConf(java.lang.String newConf) {
	conf = newConf;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 18:25:59)
 * @param newDatasource java.lang.Integer
 */
public void setDatasource(java.lang.Integer newDatasource) {
	datasource = newDatasource;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:51:58)
 * @param newDdk boolean
 */
public void setDdk(boolean newDdk) {
	ddk = newDdk;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:45:54)
 * @param newEquipment java.lang.Integer
 */
public void setEquipment(java.lang.Integer newEquipment) {
	equipment = newEquipment;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:58:32)
 * @param newHas_buster boolean
 */
public void setHas_buster(boolean newHas_buster) {
	has_buster = newHas_buster;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:57:53)
 * @param newHas_flt boolean
 */
public void setHas_flt(boolean newHas_flt) {
	has_flt = newHas_flt;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:59:49)
 * @param newHas_lna boolean
 */
public void setHas_lna(boolean newHas_lna) {
	has_lna = newHas_lna;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:45:19)
 * @param newId_sect java.lang.Integer
 */
public void setId_sect(java.lang.Integer newId_sect) {
	id_sect = newId_sect;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:02:56)
 * @param newIs_hr boolean
 */
public void setIs_hr(boolean newIs_hr) {
	is_hr = newIs_hr;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:05:15)
 * @param newLac java.lang.Integer
 */
public void setLac(java.lang.Integer newLac) {
	lac = newLac;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:46:13)
 * @param newName_sect java.lang.String
 */
public void setName_sect(java.lang.String newName_sect) {
	name_sect = newName_sect;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 18:26:44)
 * @param newNcc java.lang.Short
 */
public void setNcc(java.lang.Short newNcc) {
	ncc = newNcc;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:51:01)
 * @param newNum_po java.lang.String
 */
public void setNum_po(java.lang.String newNum_po) {
	num_po = newNum_po;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:46:59)
 * @param newNum_sect java.lang.String
 */
public void setNum_sect(java.lang.String newNum_sect) {
	num_sect = newNum_sect;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:04:00)
 * @param newOperator java.lang.Integer
 */
public void setOperator(java.lang.Integer newOperator) {
	operator = newOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:50:41)
 * @param newPort_abis java.lang.Integer
 */
public void setPort_abis(java.lang.Integer newPort_abis) {
	port_abis = newPort_abis;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:48:18)
 * @param newPower java.math.BigDecimal
 */
public void setPower(java.math.BigDecimal newPower) {
	power = newPower;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:05:55)
 * @param newRac java.lang.Integer
 */
public void setRac(java.lang.Integer newRac) {
	rac = newRac;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:52:49)
 * @param newTrx_num java.lang.Integer
 */
public void setTrx_num(java.lang.Integer newTrx_num) {
	trx_num = newTrx_num;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:53:57)
 * @param newTrx_num2 java.lang.Integer
 */
public void setTrx_num2(java.lang.Integer newTrx_num2) {
	trx_num2 = newTrx_num2;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:56:47)
 * @param newTrx_ovr_num java.lang.Integer
 */
public void setTrx_ovr_num(java.lang.Integer newTrx_ovr_num) {
	trx_ovr_num = newTrx_ovr_num;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:57:21)
 * @param newTx_ovr_set_pwr java.math.BigDecimal
 */
public void setTx_ovr_set_pwr(java.math.BigDecimal newTx_ovr_set_pwr) {
	tx_ovr_set_pwr = newTx_ovr_set_pwr;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:53:14)
 * @param newTx_pwr java.math.BigDecimal
 */
public void setTx_pwr(java.math.BigDecimal newTx_pwr) {
	tx_pwr = newTx_pwr;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:54:35)
 * @param newTx_pwr2 java.math.BigDecimal
 */
public void setTx_pwr2(java.math.BigDecimal newTx_pwr2) {
	tx_pwr2 = newTx_pwr2;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 10:55:22)
 * @param newTx_set_pwr java.math.BigDecimal
 */
public void setTx_set_pwr(java.math.BigDecimal newTx_set_pwr) {
	tx_set_pwr = newTx_set_pwr;
}
}
