package com.hps.july.basestation.valueobject;

/**
 * Контроллеры VO(Перечень комплектов оборудования типа "Контроллер").
 * Creation date: (19.07.2005 15:30:18)
 * @author: Shafigullin Ildar
 */
public class Controller_VO extends Equipment_VO {
	/**
	 *Таблица содержит специфические характеристики комплектов оборудования типа "Контроллер". 
	 *Таблица используется совместно с таблицами "Комплекты оборудования" (equipment) и "Места хранения" (storageplaces).
	*/
	private java.lang.Integer switchRef;//Ссылка на коммутатор
	private java.lang.Integer resource;//Тип оборудования контроллера
	private java.lang.Integer number;//Номер контроллера
	private java.lang.String con_type;//Тип подключения к сети(R-Radio; O-Optics)
	private java.lang.String ver_po;//Версия ПО
	private java.lang.Integer qty_shell;//Количество стоек (шкафов)
	private java.lang.Integer mfs_num;//Номер MFS
	private java.lang.Integer omcr_num;//Номер OMC_R
	private java.lang.String lac_numbers;//Номера LAC
	private java.lang.Integer trxfr_qty_max;//Max количество подключенных TRX_FR
	private java.lang.Integer trxfr_qty;//Фактическое количество подключенных TRX_FR
	private java.math.BigDecimal trx_use_percent;//Процент использования TRX
	private java.lang.Integer atr_qty_max;//Максимальное количество подключаемых ATR
	private java.lang.Integer trxhr_qty;//Фактическое количество подключенных TRX_HR
	private java.lang.Integer atr_qty;//Фактическое количество подключенных ATR
	private java.lang.Integer aint_qty;//Фактическое количество каналов 64 кбит_с_ на А_инт
	private java.lang.Integer hway_qty_voice;//Количество H_way_ голос
	private java.lang.Integer hway_qty_gprs;//Количество H_way_ GPRS
	private java.lang.String name;//Наименование контроллера
/**
 * Controller_VO constructor comment.
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public Controller_VO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
	super(ro);
	setNumber((Integer)ro.getColumn("number").asObject());
	setName(ro.getColumn("name").asString());
	//setResource((Integer)ro.getColumn("resource").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:43:14)
 * @return java.lang.Integer
 */
public java.lang.Integer getAint_qty() {
	return aint_qty;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:42:47)
 * @return java.lang.Integer
 */
public java.lang.Integer getAtr_qty() {
	return atr_qty;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:42:05)
 * @return java.lang.Integer
 */
public java.lang.Integer getAtr_qty_max() {
	return atr_qty_max;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:36:49)
 * @return java.lang.String
 */
public java.lang.String getCon_type() {
	return con_type;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:45:30)
 * @return java.lang.Integer
 */
public java.lang.Integer getHway_qty_gprs() {
	return hway_qty_gprs;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:45:07)
 * @return java.lang.Integer
 */
public java.lang.Integer getHway_qty_voice() {
	return hway_qty_voice;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:39:51)
 * @return java.lang.String
 */
public java.lang.String getLac_numbers() {
	return lac_numbers;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:38:56)
 * @return java.lang.Integer
 */
public java.lang.Integer getMfs_num() {
	return mfs_num;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 17:38:29)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:36:21)
 * @return java.lang.Integer
 */
public java.lang.Integer getNumber() {
	return number;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:39:20)
 * @return java.lang.Integer
 */
public java.lang.Integer getOmcr_num() {
	return omcr_num;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:38:25)
 * @return java.lang.Integer
 */
public java.lang.Integer getQty_shell() {
	return qty_shell;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:35:49)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:35:14)
 * @return java.lang.Integer
 */
public java.lang.Integer getSwitchRef() {
	return switchRef;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:41:19)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getTrx_use_percent() {
	return trx_use_percent;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:40:43)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrxfr_qty() {
	return trxfr_qty;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:40:13)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrxfr_qty_max() {
	return trxfr_qty_max;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:42:19)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrxhr_qty() {
	return trxhr_qty;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:37:55)
 * @return java.lang.String
 */
public java.lang.String getVer_po() {
	return ver_po;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:43:14)
 * @param newAint_qty java.lang.Integer
 */
public void setAint_qty(java.lang.Integer newAint_qty) {
	aint_qty = newAint_qty;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:42:47)
 * @param newAtr_qty java.lang.Integer
 */
public void setAtr_qty(java.lang.Integer newAtr_qty) {
	atr_qty = newAtr_qty;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:42:05)
 * @param newAtr_qty_max java.lang.Integer
 */
public void setAtr_qty_max(java.lang.Integer newAtr_qty_max) {
	atr_qty_max = newAtr_qty_max;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:36:49)
 * @param newCon_type java.lang.String
 */
public void setCon_type(java.lang.String newCon_type) {
	con_type = newCon_type;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:45:30)
 * @param newHway_qty_gprs java.lang.Integer
 */
public void setHway_qty_gprs(java.lang.Integer newHway_qty_gprs) {
	hway_qty_gprs = newHway_qty_gprs;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:45:07)
 * @param newHway_qty_voice java.lang.Integer
 */
public void setHway_qty_voice(java.lang.Integer newHway_qty_voice) {
	hway_qty_voice = newHway_qty_voice;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:39:51)
 * @param newLac_numbers java.lang.String
 */
public void setLac_numbers(java.lang.String newLac_numbers) {
	lac_numbers = newLac_numbers;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:38:56)
 * @param newMfs_num java.lang.Integer
 */
public void setMfs_num(java.lang.Integer newMfs_num) {
	mfs_num = newMfs_num;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 17:38:29)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:36:21)
 * @param newNumber java.lang.Integer
 */
public void setNumber(java.lang.Integer newNumber) {
	number = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:39:20)
 * @param newOmcr_num java.lang.Integer
 */
public void setOmcr_num(java.lang.Integer newOmcr_num) {
	omcr_num = newOmcr_num;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:38:25)
 * @param newQty_shell java.lang.Integer
 */
public void setQty_shell(java.lang.Integer newQty_shell) {
	qty_shell = newQty_shell;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:35:49)
 * @param newResource java.lang.Integer
 */
public void setResource(java.lang.Integer newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:35:14)
 * @param newSwitchRef java.lang.Integer
 */
public void setSwitchRef(java.lang.Integer newSwitchRef) {
	switchRef = newSwitchRef;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:41:19)
 * @param newTrx_use_percent java.math.BigDecimal
 */
public void setTrx_use_percent(java.math.BigDecimal newTrx_use_percent) {
	trx_use_percent = newTrx_use_percent;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:40:43)
 * @param newTrxfr_qty java.lang.Integer
 */
public void setTrxfr_qty(java.lang.Integer newTrxfr_qty) {
	trxfr_qty = newTrxfr_qty;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:40:13)
 * @param newTrxfr_qty_max java.lang.Integer
 */
public void setTrxfr_qty_max(java.lang.Integer newTrxfr_qty_max) {
	trxfr_qty_max = newTrxfr_qty_max;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:42:19)
 * @param newTrxhr_qty java.lang.Integer
 */
public void setTrxhr_qty(java.lang.Integer newTrxhr_qty) {
	trxhr_qty = newTrxhr_qty;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 15:37:55)
 * @param newVer_po java.lang.String
 */
public void setVer_po(java.lang.String newVer_po) {
	ver_po = newVer_po;
}
}
