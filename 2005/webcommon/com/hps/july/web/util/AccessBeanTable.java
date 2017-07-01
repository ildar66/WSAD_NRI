package com.hps.july.web.util;

import java.util.Enumeration;
/**
 * Таблица с возвращаемыми результатами. Реализует возможность произвольного доступа к строке.
 * Creation date: (22.01.2002 14:46:59)
 * @author: Administrator
 */
public class AccessBeanTable extends com.ibm.ivj.ejb.runtime.AbstractAccessBeanTable {
/**
 * AccessBeanTable constructor.
 */
public AccessBeanTable() {
	super();
}
/**
 * AccessBeanTable constructor.
 */
public AccessBeanTable( Enumeration enum ) {
	super.setTable( enum );
}
/**
 * Метод позволяет осуществлять произвольный доступ к строке.
 * Creation date: (22.01.2002 17:31:08)
 * @return java.lang.Object
 * @param index int
 */
public Object getRow(int index) {
	return super.getRow( index );
}
}
