package com.hps.july.contract.valueobject;

import java.sql.*;

/**
 * Класс-контейнер с необходимой информацией о поставке по контракту
 */
public class ContractSupply {
	private java.lang.Integer document;			//-da document
	private Date blankdateTransport;
	private java.lang.String blanknumberTransport;
	private java.lang.String blanknumberDisagreement;
	private java.lang.String gtdnumber;
	private Date blankdateInventory;
	private java.lang.String blanknumberInventory;
	private java.math.BigDecimal sumInventory;
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 17:12:07)
 * @return java.sql.Date
 */
public java.sql.Date getBlankdateInventory() {
	return blankdateInventory;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:10:12)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getBlankdateTransport() {
	return blankdateTransport;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 10:03:23)
 * @return java.lang.String
 */
public java.lang.String getBlanknumberDisagreement() {
	return blanknumberDisagreement;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 17:13:22)
 * @return java.lang.String
 */
public java.lang.String getBlanknumberInventory() {
	return blanknumberInventory;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 9:49:20)
 * @return java.lang.String
 */
public java.lang.String getBlanknumberTransport() {
	return blanknumberTransport;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 17:12:07)
 * @return int
 */
//-da
public int getDocument() {
        return document.intValue();
    }
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 17:06:39)
 * @return java.lang.String
 */
public java.lang.String getGtdnumber() {
	return gtdnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 17:26:48)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumInventory() {
	return sumInventory;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 17:12:07)
 * @param newBlankdateInventory java.sql.Date
 */
public void setBlankdateInventory(java.sql.Date newBlankdateInventory) {
	blankdateInventory = newBlankdateInventory;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:10:12)
 * @param newBlankdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBlankdateTransport(Date newBlankdate) {
	blankdateTransport = newBlankdate;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 10:03:23)
 * @param newBlanknumberDisagreement java.lang.String
 */
public void setBlanknumberDisagreement(java.lang.String newBlanknumberDisagreement) {
	blanknumberDisagreement = newBlanknumberDisagreement;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 17:13:22)
 * @param newBlanknumberInventory java.lang.String
 */
public void setBlanknumberInventory(java.lang.String newBlanknumberInventory) {
	blanknumberInventory = newBlanknumberInventory;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 9:49:20)
 * @param newBlanknumberTransport java.lang.String
 */
public void setBlanknumberTransport(java.lang.String newBlanknumberTransport) {
	blanknumberTransport = newBlanknumberTransport;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 17:12:07)
 * @return void
 */
//-da
public void setDocument(int newValue) {
        document=new Integer(newValue);
    }
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 17:06:39)
 * @param newGtdnumber java.lang.String
 */
public void setGtdnumber(java.lang.String newGtdnumber) {
	gtdnumber = newGtdnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 17:26:48)
 * @param newSumInventory java.math.BigDecimal
 */
public void setSumInventory(java.math.BigDecimal newSumInventory) {
	sumInventory = newSumInventory;
}
}
