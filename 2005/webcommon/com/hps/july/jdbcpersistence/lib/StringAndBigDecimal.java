package com.hps.july.jdbcpersistence.lib;

import java.math.BigDecimal;
/**
 * Двойное свойство с проверкой разрядности.
 * Creation date: (24.04.2002 12:13:35)
 * @author: Oleg Gashnikov
 */
public class StringAndBigDecimal extends com.hps.july.web.util.StringAndBigDecimalProperty {

private int digitAmount=6;
private int scale=2;
	
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:40:29)
 */
public StringAndBigDecimal() {
	super();
	
	}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:40:29)
 */
public StringAndBigDecimal(int digitAmount, int scale ) {
	super();
	this.digitAmount=digitAmount;
	this.scale=scale;
	
	}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:30:43)
 * @return java.lang.String
 */
public String formatMessage() {
    //return "Decimal("+digitAmount+","+scale+")";
    return "не более "
        + (digitAmount - scale)
        + " цифр до запятой и не более "
        + scale
        + " цифр после запятой";
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:52:13)
 * @return boolean
 */
public boolean isOk() {
    return isEmpty()||(super.isOk()&&getBigDecimal().scale() <= scale
        && Math.abs(getBigDecimal().doubleValue()) < Math.pow(10,(digitAmount - scale))
         );

}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:52:13)
 * @return boolean
 */
public boolean isOkAndNotEmpty() {
    return isOk() && !isEmpty();

}
}
