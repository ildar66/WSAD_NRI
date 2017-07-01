package com.hps.july.web.util;

import java.lang.Integer;
/**
 * Класс для проверки значений типа Integer.
 * Creation date: (24.04.2002 12:13:35)
 * @author: Oleg Gashnikov
 */
public class StringAndIntegerProperty extends TwainProperty {
	private String stringVal;
	private Integer integerVal;
/**
 * Получить Integer.
 * Creation date: (24.04.2002 12:21:53)
 * @return java.lang.Integerl
 */
public Integer getInteger() {
	return integerVal;
}
/**
 * Получить строковое представление.
 * Creation date: (24.04.2002 12:21:18)
 * @return java.lang.String
 */
public String getString() {
	return stringVal;
}
/**
 * Проверка пустого значения.
 */
public boolean isEmpty() {
	return ((stringVal == null) || (stringVal.length() == 0));
}
/**
 * Установка значения типа Integer.
 * Creation date: (24.04.2002 12:15:32)
 * @param argBD java.lang.Integer
 */
public void setInteger(Integer argBD) {
	integerVal = argBD;
	if (argBD == null)
	  	stringVal = "";
	else
		stringVal = argBD.toString();
	setOk( true );
	}
/**
 * Установить строковое представление.
 * Creation date: (24.04.2002 12:21:18)
 */
public void setString(String argStr) {
	stringVal = argStr;
	if (argStr == null || argStr.length() == 0) {
		integerVal = null;
		setOk( true );
	} else {
		try {
			integerVal = new Integer( argStr );
			setOk( true );
		} catch( NumberFormatException e ) {
			integerVal = null;
			setOk( false );
		}
	}
}
}
