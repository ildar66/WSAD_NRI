package com.hps.july.web.util;

import java.util.Enumeration;
/**
 * ������� � ������������� ������������. ��������� ����������� ������������� ������� � ������.
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
 * ����� ��������� ������������ ������������ ������ � ������.
 * Creation date: (22.01.2002 17:31:08)
 * @return java.lang.Object
 * @param index int
 */
public Object getRow(int index) {
	return super.getRow( index );
}
}
