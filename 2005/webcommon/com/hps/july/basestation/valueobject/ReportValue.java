package com.hps.july.basestation.valueobject;


import java.math.*;/**
 * Служебный класс для общих полей других классов раздела отчетности..
 * Creation date: (16.08.2004 15:26:30)
 */
public class ReportValue {
	private java.lang.String address1;//Адрес позиции 1
	private java.lang.String address2;//Адрес позиции 2
	private int gsmid1;//Номер GSM позиции 1
	private int gsmid2;//Номер GSM позиции 2
	private java.lang.String name1;//Наименование позиции 1
	private java.lang.String name2;//Наименование позиции 2
	private java.lang.String linktogosnet_lat1;// Координаты ГСПИ позиции 1, широта
	private java.lang.String linktogosnet_lat2;// Координаты ГСПИ позиции 2, широта
	private java.lang.String linktogosnet_lon1; //Координаты ГСПИ позиции 1, долгота
	private java.lang.String linktogosnet_lon2;//Координаты ГСПИ позиции 1, долгота
/**
 * ReportValue constructor comment.
 */
public ReportValue() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:27:30)
 * @return java.lang.String
 */
public java.lang.String getAddress1() {
	return address1;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:27:47)
 * @return java.lang.String
 */
public java.lang.String getAddress2() {
	return address2;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2004 11:37:56)
 * @return java.lang.String
 * @param parameter java.math.BigDecimal
 */
public String getBigDecimalParameterFrm(BigDecimal parameter) {
	if(parameter.floatValue() == 0) 
		return "";
	else return parameter.toString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:28:13)
 * @return int
 */
public int getGsmid1() {
	return gsmid1;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2004 15:21:10)
 * @return java.lang.String
 */
public String getGsmid1Frm() {
	if(getGsmid1() == 0)
		return "";
	else return new String("" + getGsmid1());
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:28:34)
 * @return int
 */
public int getGsmid2() {
	return gsmid2;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2004 15:24:20)
 * @return java.lang.String
 */
public String getGsmid2Frm() {
	if(getGsmid2() == 0)
		return "";
	else return new String("" + getGsmid2());
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 16:44:05)
 * @return java.lang.String
 */
public java.lang.String getLinktogosnet_lat1() {
	return linktogosnet_lat1;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 16:44:47)
 * @return java.lang.String
 */
public java.lang.String getLinktogosnet_lat2() {
	return linktogosnet_lat2;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 16:45:30)
 * @return java.lang.String
 */
public java.lang.String getLinktogosnet_lon1() {
	return linktogosnet_lon1;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 16:45:59)
 * @return java.lang.String
 */
public java.lang.String getLinktogosnet_lon2() {
	return linktogosnet_lon2;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:30:07)
 * @return java.lang.String
 */
public java.lang.String getName1() {
	return name1;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:30:25)
 * @return java.lang.String
 */
public java.lang.String getName2() {
	return name2;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:27:30)
 * @param newAddress1 java.lang.String
 */
public void setAddress1(java.lang.String newAddress1) {
	address1 = newAddress1;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:27:47)
 * @param newAddress2 java.lang.String
 */
public void setAddress2(java.lang.String newAddress2) {
	address2 = newAddress2;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:28:13)
 * @param newGsmid1 int
 */
public void setGsmid1(int newGsmid1) {
	gsmid1 = newGsmid1;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:28:34)
 * @param newGsmid2 int
 */
public void setGsmid2(int newGsmid2) {
	gsmid2 = newGsmid2;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 16:44:05)
 * @param newLinktogosnet_lat1 java.lang.String
 */
public void setLinktogosnet_lat1(java.lang.String newLinktogosnet_lat1) {
	linktogosnet_lat1 = newLinktogosnet_lat1;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 16:44:47)
 * @param newLinktogosnet_lat2 java.lang.String
 */
public void setLinktogosnet_lat2(java.lang.String newLinktogosnet_lat2) {
	linktogosnet_lat2 = newLinktogosnet_lat2;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 16:45:30)
 * @param newLinktogosnet_lon1 java.lang.String
 */
public void setLinktogosnet_lon1(java.lang.String newLinktogosnet_lon1) {
	linktogosnet_lon1 = newLinktogosnet_lon1;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 16:45:59)
 * @param newLinktogosnet_lon2 java.lang.String
 */
public void setLinktogosnet_lon2(java.lang.String newLinktogosnet_lon2) {
	linktogosnet_lon2 = newLinktogosnet_lon2;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:30:07)
 * @param newName1 java.lang.String
 */
public void setName1(java.lang.String newName1) {
	name1 = newName1;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 15:30:25)
 * @param newName2 java.lang.String
 */
public void setName2(java.lang.String newName2) {
	name2 = newName2;
}
}
