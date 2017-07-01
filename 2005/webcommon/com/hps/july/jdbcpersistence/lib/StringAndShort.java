package com.hps.july.jdbcpersistence.lib;

import java.lang.Integer;
/**
 * Двойное свойство с проверкой разрядности.
 * Creation date: (24.04.2002 12:13:35)
 * @author: Oleg Gashnikov
 */
public class StringAndShort extends com.hps.july.web.util.TwainProperty {
	private String stringVal;
	private Short shortVal;
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:21:53)
 * @return java.math.BigDecimal
 */
public Short getShort() {
	return shortVal;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:21:53)
 * @return java.math.BigDecimal
 */
public short getshort() {
	return shortVal.shortValue();
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:21:18)
 * @return java.lang.String
 */
public String getString() {
	return stringVal;
}
/**
 * isEmpty method comment.
 */
public boolean isEmpty() {
	return ((stringVal == null) || (stringVal.trim().length() == 0));
}
/**
 * isEmpty method comment.
 */
public boolean isOkAndNotEmpty() {
    return isOk() && !isEmpty();
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:15:32)
 * @param argBD java.math.BigDecimal
 */
public void setShort(Short argBD) {
	shortVal = argBD;
	if (argBD == null)
	  	stringVal = "";
	else
		stringVal = argBD.toString();
	setOk( true );
	}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:15:32)
 * @param argBD java.math.BigDecimal
 */
public void setShort(short argBD) {
	shortVal = new Short(argBD);
	/*
	if (argBD == null)
	  	stringVal = "";
	else
	*/
		stringVal = argBD+"";
	setOk( true );
	}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:18:05)
 * @param argStr java.lang.String
 */
public void setString(String argStr) {
	stringVal = argStr;
	if (argStr == null || argStr.length() == 0) {
		shortVal = null;
		setOk( true );
	} else {
		try {
			shortVal = new Short( argStr );
			setOk( true );
		} catch( NumberFormatException e ) {
			shortVal = null;
			setOk( false );
		}
	}
}
}
