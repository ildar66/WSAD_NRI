package com.hps.july.basestation.valueobject;

/**
 * Служебный класс для документа "Заявка на назначение радиочастот для 
 *	радиорелейных линий связи"
 */
public class ReportRadioFreqRequestValue {
	private int resource; // идентификатор ресурса
	private java.lang.String streamspeed; // скорость передачи данных
	private java.lang.String radiationclass; // Класс излучения
	private java.math.BigDecimal recvsensitivity; // Чувствительность приемника
	private java.lang.String model; // Название обрудования
	private java.lang.String mkkrrecomm; // Рекомендации МККР
	private java.lang.String orgshortname; // Краткое наименование производителя
	private java.lang.String orgname; // Полное наименование производителя
	private java.math.BigDecimal power; // Мощность несущей передатчика
	private java.math.BigDecimal antdiam1; // Диаметр антенны 1
	private java.math.BigDecimal antdiam2; // Диаметр антенны 2
	private java.math.BigDecimal amplifkoeff1; // Коэффициент усиления антенны 1
	private java.math.BigDecimal amplifkoeff2; // Коэффициент усиления антенны 2
	private java.math.BigDecimal dnangleh1; // Ширина ДН по горизонтали антенны 1
	private java.math.BigDecimal dnangleh2; // Ширина ДН по горизонтали антенны 2
	private java.math.BigDecimal dnanglew1; // Ширина ДН по вертикали антенны 1
	private java.math.BigDecimal dnanglew2; // Ширина ДН по вертикали антенны 2
	private java.lang.String gkrchblanknumber; // Номер решения ГКРЧ
	private java.sql.Date gkrchblankdate; // Дата решения ГКРЧ
	private java.lang.String rrlblanknumber; // Номер сертификата соответствия
	private java.sql.Date rrlblankdate; // Дата сертификата соответствия
	private java.math.BigDecimal freqdevlowk; // Нестабильность частоты нижн K
	private int freqdevlowlog10; // Нестабильность частоты нижн log10
	private java.lang.String freqrange; // Диапазон частот
/**
 * ReportRadioFreqRequestValue constructor comment.
 */
public ReportRadioFreqRequestValue() {
	super();
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAmplifkoeff1() {
	return amplifkoeff1;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAmplifkoeff2() {
	return amplifkoeff2;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAntdiam1() {
	return antdiam1;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAntdiam2() {
	return antdiam2;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDnangleh1() {
	return dnangleh1;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDnangleh2() {
	return dnangleh2;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDnanglew1() {
	return dnanglew1;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDnanglew2() {
	return dnanglew2;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getFreqdevlowk() {
	return freqdevlowk;
}
/**
 * 
 * @return int
 */
public int getFreqdevlowlog10() {
	return freqdevlowlog10;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFreqrange() {
	return freqrange;
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getGkrchblankdate() {
	return gkrchblankdate;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getGkrchblanknumber() {
	return gkrchblanknumber;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getMkkrrecomm() {
	return mkkrrecomm;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getModel() {
	return model;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOrgshortname() {
	return orgshortname;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPower() {
	return power;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRadiationclass() {
	return radiationclass;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRecvsensitivity() {
	return recvsensitivity;
}
/**
 * 
 * @return int
 */
public int getResource() {
	return resource;
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getRrlblankdate() {
	return rrlblankdate;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRrlblanknumber() {
	return rrlblanknumber;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStreamspeed() {
	return streamspeed;
}
/**
 * 
 * @param newAmplifkoeff1 java.math.BigDecimal
 */
public void setAmplifkoeff1(java.math.BigDecimal newAmplifkoeff1) {
	amplifkoeff1 = newAmplifkoeff1;
}
/**
 * 
 * @param newAmplifkoeff2 java.math.BigDecimal
 */
public void setAmplifkoeff2(java.math.BigDecimal newAmplifkoeff2) {
	amplifkoeff2 = newAmplifkoeff2;
}
/**
 * 
 * @param newAntdiam1 java.math.BigDecimal
 */
public void setAntdiam1(java.math.BigDecimal newAntdiam1) {
	antdiam1 = newAntdiam1;
}
/**
 * 
 * @param newAntdiam2 java.math.BigDecimal
 */
public void setAntdiam2(java.math.BigDecimal newAntdiam2) {
	antdiam2 = newAntdiam2;
}
/**
 * 
 * @param newDnangleh1 java.math.BigDecimal
 */
public void setDnangleh1(java.math.BigDecimal newDnangleh1) {
	dnangleh1 = newDnangleh1;
}
/**
 * 
 * @param newDnangleh2 java.math.BigDecimal
 */
public void setDnangleh2(java.math.BigDecimal newDnangleh2) {
	dnangleh2 = newDnangleh2;
}
/**
 * 
 * @param newDnanglew java.math.BigDecimal
 */
public void setDnanglew1(java.math.BigDecimal newDnanglew1) {
	dnanglew1 = newDnanglew1;
}
/**
 * 
 * @param newDnanglew2 java.math.BigDecimal
 */
public void setDnanglew2(java.math.BigDecimal newDnanglew2) {
	dnanglew2 = newDnanglew2;
}
/**
 * 
 * @param newFreqdevlowk java.math.BigDecimal
 */
public void setFreqdevlowk(java.math.BigDecimal newFreqdevlowk) {
	freqdevlowk = newFreqdevlowk;
}
/**
 * 
 * @param newFreqdevlowlog10 int
 */
public void setFreqdevlowlog10(int newFreqdevlowlog10) {
	freqdevlowlog10 = newFreqdevlowlog10;
}
/**
 * 
 * @param newFreqrange java.lang.String
 */
public void setFreqrange(java.lang.String newFreqrange) {
	freqrange = newFreqrange;
}
/**
 * 
 * @param newGkrchblankdate java.sql.Date
 */
public void setGkrchblankdate(java.sql.Date newGkrchblankdate) {
	gkrchblankdate = newGkrchblankdate;
}
/**
 * 
 * @param newGkrchblanknumber java.lang.String
 */
public void setGkrchblanknumber(java.lang.String newGkrchblanknumber) {
	gkrchblanknumber = newGkrchblanknumber;
}
/**
 * 
 * @param newMkkrrecomm java.lang.String
 */
public void setMkkrrecomm(java.lang.String newMkkrrecomm) {
	mkkrrecomm = newMkkrrecomm;
}
/**
 * 
 * @param newModel java.lang.String
 */
public void setModel(java.lang.String newModel) {
	model = newModel;
}
/**
 * 
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
}
/**
 * 
 * @param newOrgshortname java.lang.String
 */
public void setOrgshortname(java.lang.String newOrgshortname) {
	orgshortname = newOrgshortname;
}
/**
 * 
 * @param newPower java.math.BigDecimal
 */
public void setPower(java.math.BigDecimal newPower) {
	power = newPower.setScale(1, java.math.BigDecimal.ROUND_HALF_UP);
}
/**
 * 
 * @param newRadiationclass java.lang.String
 */
public void setRadiationclass(java.lang.String newRadiationclass) {
	radiationclass = newRadiationclass;
}
/**
 * 
 * @param newRecvsensitivity java.math.BigDecimal
 */
public void setRecvsensitivity(java.math.BigDecimal newRecvsensitivity) {
	recvsensitivity = newRecvsensitivity;
}
/**
 * 
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * 
 * @param newRrlblankdate java.sql.Date
 */
public void setRrlblankdate(java.sql.Date newRrlblankdate) {
	rrlblankdate = newRrlblankdate;
}
/**
 * 
 * @param newRrlblanknumber java.lang.String
 */
public void setRrlblanknumber(java.lang.String newRrlblanknumber) {
	rrlblanknumber = newRrlblanknumber;
}
/**
 * 
 * @param newStreamspeed java.lang.String
 */
public void setStreamspeed(java.lang.String newStreamspeed) {
	streamspeed = newStreamspeed;
}
}
