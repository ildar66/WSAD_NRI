package com.hps.july.platinum.valueobject;

import java.util.*;
import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.*;

/**
 * Insert the type's description here.
 * Creation date: (18.02.2002 10:42:32)
 * @author: Oleg Gashnikov
 */
public class CurrencyValue {
	
 
	private java.util.Map url;
	private java.lang.String jspriznak;
	private int currencycodenri;
	private java.lang.String currencynamenri;
	private java.lang.String idvaluteplatinum;
	private java.lang.String nameplatinum;
	private java.lang.Integer idvalutenriplatinum;
	private java.lang.String pstatus;
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 10:16:00)
 * @return int
 */
public int getCurrencycodenri() {
	return currencycodenri;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 10:16:20)
 * @return java.lang.String
 */
public java.lang.String getCurrencynamenri() {
	return currencynamenri;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:09:52)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdvalutenriplatinum() {
	return idvalutenriplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 10:38:18)
 * @return java.lang.String
 */
public java.lang.String getIdvaluteplatinum() {
	return idvaluteplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:36:20)
 * @return java.lang.String
 */
public java.lang.String getJspriznak() {
	return jspriznak;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 10:38:58)
 * @return java.lang.String
 */
public java.lang.String getNameplatinum() {
	return nameplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (10.01.2003 13:55:49)
 * @return java.lang.String
 */
public java.lang.String getPstatus() {
	return pstatus;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:05:09)
 * @return java.util.Map
 */
public java.util.Map getUrl() {	
	return url;
	}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 10:16:00)
 * @param newCurrencycodenri int
 */
public void setCurrencycodenri(int newCurrencycodenri) {
	currencycodenri = newCurrencycodenri;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 10:16:20)
 * @param newCurrencynamenri java.lang.String
 */
public void setCurrencynamenri(java.lang.String newCurrencynamenri) {
	currencynamenri = newCurrencynamenri;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:09:52)
 * @param newIdvalutenriplatinum java.lang.Integer
 */
public void setIdvalutenriplatinum(java.lang.Integer newIdvalutenriplatinum) {
	idvalutenriplatinum = newIdvalutenriplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 10:38:18)
 * @param newIdvaluteplatinum java.lang.String
 */
public void setIdvaluteplatinum(java.lang.String newIdvaluteplatinum) {
	idvaluteplatinum = newIdvaluteplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:36:20)
 * @param newJspriznak java.lang.String
 */
public void setJspriznak(java.lang.String newJspriznak) {
	jspriznak = newJspriznak;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 10:38:58)
 * @param newNameplatinum java.lang.String
 */
public void setNameplatinum(java.lang.String newNameplatinum) {
	nameplatinum = newNameplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (10.01.2003 13:55:49)
 * @param newPstatus java.lang.String
 */
public void setPstatus(java.lang.String newPstatus) {
	pstatus = newPstatus;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:05:09)
 * @param newUrl java.util.Map
 */
public void setUrl(java.util.Map newUrl) {	
	url = newUrl;
	}
}
