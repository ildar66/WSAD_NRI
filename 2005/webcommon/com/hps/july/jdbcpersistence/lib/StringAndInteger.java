package com.hps.july.jdbcpersistence.lib;

/**
 * Двойное свойство с проверкой разрядности.
 * Creation date: (23.03.2003 14:58:32)
 * @author: Alexander Shrago
 */
public class StringAndInteger extends com.hps.july.web.util.StringAndIntegerProperty {
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:21:53)
 * @return java.math.BigDecimal
 */
public int getInt() {
    try {
        return getInteger().intValue();
    } catch (Exception e) {
        return 0;

    }
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:21:18)
 * @return java.lang.String
 */
public String getString() {
	return super.getString()!=null?super.getString():"";
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2003 15:11:32)
 * @return boolean
 */
public boolean isOkAndNotEmpty() {
    return isOk() && !isEmpty();
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:15:32)
 * @param argBD java.math.BigDecimal
 */
public void setInt(int argBD) {
	setInteger(new Integer(argBD));
	
	}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:18:05)
 * @param argStr java.lang.String
 */
public void setString(String argStr) {
    //DebugSupport.printlnTest("!!!StringAndInteger setString arg=" + argStr);
    super.setString(argStr != null ? argStr.trim() : "");
}
}
