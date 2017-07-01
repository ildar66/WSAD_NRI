package com.hps.july.web.util;

import java.sql.Timestamp;
/**
 * Класс для проверки значений типа Timestamp.
 * Creation date: (24.04.2002 12:13:35)
 * @author: Oleg Gashnikov
 */
public class StringAndSqlTimestampProperty extends TwainProperty {
	private String stringVal;
	private Timestamp dateVal;
	private java.text.SimpleDateFormat format;

	/**
		Constructor
	*/
	public StringAndSqlTimestampProperty() {
		format = new java.text.SimpleDateFormat( "dd.MM.yyyy HH:mm:ss" );
	}
/**
 * Возвращает Timestamp.
 * Creation date: (24.04.2002 12:21:53)
 * @return java.math.BigDecimal
 */
public Timestamp getSqlTimestamp() {
	return dateVal;
}
/**
 * Возвращает строковое представление.
 * Creation date: (24.04.2002 12:21:18)
 * @return java.lang.String
 */
public String getStringDate() {
	return stringVal;
}
/**
 * Проверка пустого значения.
 */
public boolean isEmpty() {
	return ((stringVal == null) || (stringVal.length() == 0));
}
/**
 * Устанавливает Timestamp.
 * Creation date: (24.04.2002 12:15:32)
 * @param argBD java.math.BigDecimal
 */
public void setSqlTimestamp(Timestamp argBD) {
	dateVal = argBD;
	if (argBD == null)
	    stringVal = "";
	else
		stringVal =   
			format.format( new java.util.Date( argBD.getTime() ) );
	setOk( true );
	}
/**
 * Установить строковое представление.
 * Creation date: (24.04.2002 12:21:18)
 */
public void setString(String argStr) {
	stringVal = argStr;
	if (argStr == null || argStr.length() == 0) {
		dateVal = null;
		setOk( true );
	} else {
		dateVal = new Timestamp( format.parse( argStr, 
			new java.text.ParsePosition(0) ).getTime() );
		if( stringVal != null && stringVal.length() != 0 && dateVal == null )
			setOk( false );
		else
			setOk( true );
	}
}
}
