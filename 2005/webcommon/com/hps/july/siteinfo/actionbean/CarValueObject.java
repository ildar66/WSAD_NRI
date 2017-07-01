package com.hps.july.siteinfo.actionbean;

/**
 * Класс-контейнер с информацией об автомобилях юридического лица
 * Используется при выводе карты прохода.
 */
public class CarValueObject
{
	private int car;
	private String carmodel;
	private String carnumber;
	private String orgname;
/**
 * 
 * @return int
 */
public int getCar() {
	return car;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCarmodel() {
	return carmodel;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCarnumber() {
	return carnumber;
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
 * @param newCar int
 */
public void setCar(int newCar) {
	car = newCar;
}
/**
 * 
 * @param newCarmodel java.lang.String
 */
public void setCarmodel(java.lang.String newCarmodel) {
	carmodel = newCarmodel;
}
/**
 * 
 * @param newCarnumber java.lang.String
 */
public void setCarnumber(java.lang.String newCarnumber) {
	carnumber = newCarnumber;
}
/**
 * 
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
}
}
