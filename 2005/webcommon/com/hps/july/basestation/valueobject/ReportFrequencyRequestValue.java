package com.hps.july.basestation.valueobject;

import java.math.*;

/**
 * Служебный класс для документа "заявка на частоты".
 * Creation date: (16.08.2004 15:21:47)
 */
public class ReportFrequencyRequestValue extends ReportValue {
	private java.math.BigDecimal height_a;//Высота подвеса антенны в точке А (из таблицы rrl_hops2)
	private java.math.BigDecimal height_b;//Высота подвеса антенны в точке B (из таблицы rrl_hops2)
	private java.math.BigDecimal azimuth_a;//Азимут А (из таблицы rrl_hops2)
	private java.math.BigDecimal azimuth_b;//Азимут В (из таблицы rrl_hops2)
	private java.math.BigDecimal distance;//Расстояние (рассчитывается)
	private java.math.BigDecimal frequency_a;//Частота А - передача (из таблицы rrl_hops2)
	private java.math.BigDecimal frequency_b;//Частота В - передача (из таблицы rrl_hops2)
	private java.math.BigDecimal power;//Мощность излучения А (из таблицы rrl_hops2)
	private java.lang.String model;//Тип оборудования А (из таблицы resources)
	private java.lang.String speed;//Скорость передачи (из таблицы rrl_hops2)
	private java.math.BigDecimal antdiam_a;//Диаметр антенны А (из таблицы rrl_hops2)
	private java.math.BigDecimal antdiam_b;//Диаметр антенны В (из таблицы rrl_hops2)
	private java.math.BigDecimal amplifkoeff_a;//Коэффициент усиления антенны А (из таблицы rrlantparams)
	private java.math.BigDecimal amplifkoeff_b;//Коэффициент усиления антенны B (из таблицы rrlantparams)
	private java.math.BigDecimal dnangleh_a;//ДНА по вертикали для антенны А (из таблицы rrlantparams)
	private java.math.BigDecimal dnangleh_b;//ДНА по вертикали для антенны B (из таблицы rrlantparams)
	private java.math.BigDecimal dnanglew_a;//ДНА по горизонтали для антенны А (из таблицы rrlantparams)
	private java.math.BigDecimal dnanglew_b;//ДНА по горизонтали для антенны В (из таблицы rrlantparams)
	private java.lang.String radiationclass_a;//Класс излучения антенны A
	private java.lang.String radiationclass_b;//Класс излучения антенны B
	private java.lang.String docaddress_a;//Адресс по разрешению A
	private java.lang.String docaddress_b;//Адресс по разрешению B
/**
 * ReportFrequencyRequest constructor comment.
 */
public ReportFrequencyRequestValue() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:36:45)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAmplifkoeff_a() {
	return amplifkoeff_a;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:38:09)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAmplifkoeff_b() {
	return amplifkoeff_b;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:29:26)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAntdiam_a() {
	return antdiam_a;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:33:12)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAntdiam_b() {
	return antdiam_b;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:30:39)
 * @return float
 */
public java.math.BigDecimal getAzimuth_a() {
	return azimuth_a;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 15:42:30)
 * @return java.lang.String
 */
public String getAzimuth_aFrm() {
	if(getAzimuth_a().floatValue() == 0) 
		return "";
	else return getAzimuth_a().toString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:02:32)
 * @return float
 */
public java.math.BigDecimal getAzimuth_b() {
	return azimuth_b;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 15:43:55)
 * @return java.lang.String
 */
public String getAzimuth_bFrm() {
	if(getAzimuth_b().floatValue() == 0) 
		return "";
	else return getAzimuth_b().toString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:06:41)
 * @return float
 */
public java.math.BigDecimal getDistance() {
	return distance;
}
/**
 * 
 * @return java.lang.String
 */
public String getDistanceFrm() {
	if(distance.doubleValue() == 0)
		return "";
	else
		return distance.toString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:39:17)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDnangleh_a() {
	return dnangleh_a;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:40:47)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDnangleh_b() {
	return dnangleh_b;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:41:29)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDnanglew_a() {
	return dnanglew_a;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:41:46)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDnanglew_b() {
	return dnanglew_b;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDocaddress_a() {
	return docaddress_a;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDocaddress_b() {
	return docaddress_b;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:08:52)
 * @return float
 */
public java.math.BigDecimal getFrequency_a() {
	return frequency_a;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 15:44:53)
 * @return java.lang.String
 */
public String getFrequency_aFrm() {
	if(getFrequency_a().floatValue() == 0) 
		return "";
	else return getFrequency_a().toString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:11:26)
 * @return float
 */
public java.math.BigDecimal getFrequency_b() {
	return frequency_b;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 15:45:55)
 * @return java.lang.String
 */
public String getFrequency_bFrm() {
	if(getFrequency_b().floatValue() == 0) 
		return "";
	else return getFrequency_b().toString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:38:50)
 * @return float
 */
public java.math.BigDecimal getHeight_a() {
	return height_a;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 15:32:25)
 * @return java.lang.String
 */
public java.lang.String getHeight_aFrm() {
	if(getHeight_a().floatValue() == 0) 
		return "";
	else return getHeight_a().toString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:56:19)
 * @return float
 */
public java.math.BigDecimal getHeight_b() {
	return height_b;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 15:41:01)
 * @return java.lang.String
 */
public java.lang.String getHeight_bFrm() {
	if(getHeight_b().floatValue() == 0) 
		return "";
	else return getHeight_b().toString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:25:52)
 * @return java.lang.String
 */
public java.lang.String getModel() {
	return model;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:21:24)
 * @return float
 */
public java.math.BigDecimal getPower() {
	return power;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 15:46:47)
 * @return java.lang.String
 */
public String getPowerFrm() {
	if(getPower().floatValue() == 0) 
		return "";
	else return getPower().toString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2004 12:01:16)
 * @return java.lang.String
 */
public java.lang.String getRadiationclass_a() {
	return radiationclass_a;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2004 12:01:28)
 * @return java.lang.String
 */
public java.lang.String getRadiationclass_b() {
	return radiationclass_b;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:34:37)
 * @return java.lang.String
 */
public java.lang.String getSpeed() {
	return speed;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:36:45)
 * @param newAmplifkoeff_a java.math.BigDecimal
 */
public void setAmplifkoeff_a(java.math.BigDecimal newAmplifkoeff_a) {
	amplifkoeff_a = newAmplifkoeff_a;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:38:09)
 * @param newAmplifkoeff_b java.math.BigDecimal
 */
public void setAmplifkoeff_b(java.math.BigDecimal newAmplifkoeff_b) {
	amplifkoeff_b = newAmplifkoeff_b;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:29:26)
 * @param newAntdiam_a java.math.BigDecimal
 */
public void setAntdiam_a(java.math.BigDecimal newAntdiam_a) {
	antdiam_a = newAntdiam_a;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:33:12)
 * @param newAntdiam_b java.math.BigDecimal
 */
public void setAntdiam_b(java.math.BigDecimal newAntdiam_b) {
	antdiam_b = newAntdiam_b;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:30:39)
 * @param newAzimuth_a float
 */
public void setAzimuth_a(java.math.BigDecimal newAzimuth_a) {
	azimuth_a = newAzimuth_a.setScale(0, BigDecimal.ROUND_HALF_UP);
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:02:32)
 * @param newAzimuth_b float
 */
public void setAzimuth_b(java.math.BigDecimal newAzimuth_b) {
	azimuth_b = newAzimuth_b.setScale(0, BigDecimal.ROUND_HALF_UP);
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:06:41)
 * @param newDistance float
 */
public void setDistance(java.math.BigDecimal latitude1, java.math.BigDecimal longitude1,
						java.math.BigDecimal latitude2, java.math.BigDecimal longitude2) {
	if((latitude1 == null)||(latitude2 == null)||(longitude1 == null)||(longitude2 == null)||
			(latitude1.doubleValue() == 0)||
			(latitude2.doubleValue() == 0)||
			(longitude1.doubleValue() == 0)||
			(longitude2.doubleValue() == 0))   {
		distance = new java.math.BigDecimal(0);
	} else {
		distance = com.hps.july.basestation.formbean.ComlineRForm.calcLength(latitude1, longitude1,
																			 latitude2, longitude2);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:39:17)
 * @param newDnangleh_a java.math.BigDecimal
 */
public void setDnangleh_a(java.math.BigDecimal newDnangleh_a) {
	dnangleh_a = newDnangleh_a;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:40:47)
 * @param newDnangleh_b java.math.BigDecimal
 */
public void setDnangleh_b(java.math.BigDecimal newDnangleh_b) {
	dnangleh_b = newDnangleh_b;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:41:29)
 * @param newDnanglew_a java.math.BigDecimal
 */
public void setDnanglew_a(java.math.BigDecimal newDnanglew_a) {
	dnanglew_a = newDnanglew_a;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:41:46)
 * @param newDnanglew_b java.math.BigDecimal
 */
public void setDnanglew_b(java.math.BigDecimal newDnanglew_b) {
	dnanglew_b = newDnanglew_b;
}
/**
 * 
 * @param newDocaddress_a java.lang.String
 */
public void setDocaddress_a(java.lang.String newDocaddress_a) {
	docaddress_a = newDocaddress_a;
}
/**
 * 
 * @param newDocaddress_b java.lang.String
 */
public void setDocaddress_b(java.lang.String newDocaddress_b) {
	docaddress_b = newDocaddress_b;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:08:52)
 * @param newFrequency_a1 float
 */
public void setFrequency_a(java.math.BigDecimal newFrequency_a) {
	frequency_a = newFrequency_a.setScale(2, BigDecimal.ROUND_HALF_UP);
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:11:26)
 * @param newFrequency_b1 float
 */
public void setFrequency_b(java.math.BigDecimal newFrequency_b) {
	frequency_b = newFrequency_b.setScale(2, BigDecimal.ROUND_HALF_UP);
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:38:50)
 * @param newHeight_a float
 */
public void setHeight_a(java.math.BigDecimal newHeight_a) {
	height_a = newHeight_a.setScale(1, BigDecimal.ROUND_HALF_UP);
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 15:32:25)
 * @param newHeight_aFrm java.lang.String
 */
public void setHeight_aFrm(java.lang.String newHeight_aFrm) {
	//height_a.setString(newHeight_aFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:56:19)
 * @param newHeight_b float
 */
public void setHeight_b(java.math.BigDecimal newHeight_b) {
	height_b = newHeight_b.setScale(1, BigDecimal.ROUND_HALF_UP);
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:25:52)
 * @param newModel_a java.lang.String
 */
public void setModel(java.lang.String newModel) {
	model = newModel;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:21:24)
 * @param newPower_a float
 */
public void setPower(java.math.BigDecimal newPower) {
	power = newPower.setScale(1, BigDecimal.ROUND_HALF_UP);
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2004 12:01:16)
 * @param newRadiationclass_a java.lang.String
 */
public void setRadiationclass_a(java.lang.String newRadiationclass_a) {
	radiationclass_a = newRadiationclass_a;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2004 12:01:28)
 * @param newRadiationclass_b java.lang.String
 */
public void setRadiationclass_b(java.lang.String newRadiationclass_b) {
	radiationclass_b = newRadiationclass_b;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 16:34:37)
 * @param newSpeed java.lang.String
 */
public void setSpeed(java.lang.String newSpeed) {
	speed = newSpeed;
}
}
