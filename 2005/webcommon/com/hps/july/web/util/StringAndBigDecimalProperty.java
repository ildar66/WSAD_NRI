package com.hps.july.web.util;

import java.math.BigDecimal;
/**
 * Класс для проверки значений типа BigDecimal.
 * Creation date: (24.04.2002 12:13:35)
 * @author: Oleg Gashnikov
 */
public class StringAndBigDecimalProperty extends TwainProperty {
	private String stringVal;
	private BigDecimal bdProperty;
/**
 * Получить BigDecimal.
 * Creation date: (24.04.2002 12:21:53)
 * @return java.math.BigDecimal
 */
public BigDecimal getBigDecimal() {
	return bdProperty;
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
 * Установка значения типа BigDecimal.
 * Creation date: (24.04.2002 12:15:32)
 * @param argBD java.math.BigDecimal
 */
public void setBigDecimal(BigDecimal argBD) {
	bdProperty = argBD;
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
	if(stringVal != null) {
		stringVal = stringVal.trim();
	}
	try {
		if (argStr == null || argStr.length() == 0) {
			bdProperty = null;
			setOk( true );
		} else {
			argStr = argStr.trim();
			int c = 0,i = 0;
			while((i = argStr.indexOf((int)'-',i)+1) > 0) {
				c++;
			}
			if(c > 1) {
				setOk(false);
				bdProperty = null;
			} else {
				try {
					bdProperty = new BigDecimal( argStr );
					setOk( true );
				} catch( NumberFormatException e ) {
					// Due to locale settings we can get comma instead of point - change it			
					try {
						argStr = argStr.trim();
						if (argStr.indexOf(",") > 0)
							argStr = argStr.replace(',', '.');
						java.util.StringTokenizer st = new java.util.StringTokenizer(argStr," ");
						argStr = "";
						while(st.hasMoreTokens()) {
							argStr += st.nextToken();
						}
						if(argStr != null && !"".equals(argStr.trim())) {
							bdProperty = new java.math.BigDecimal( argStr );
							setOk( true );
						} else {
							setOk( false );
						}
					} catch( NumberFormatException e1 ) {
						bdProperty = null;
						setOk( false );
					}
				}
			}
		}
	} catch(Exception e) {
		setOk(false);
		bdProperty = null;
	}
}
}
