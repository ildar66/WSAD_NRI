package com.hps.july.security.formbean;

import com.hps.july.persistence.PeopleKey;
/**
 * Форма списка операторов.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class OperatorListForm extends com.hps.july.web.util.BrowseForm {
	private int man;
	/**
	 * Insert the method's description here.
	 * Creation date: (22.01.2002 13:30:34)
	 */
	public OperatorListForm() {
		man = 0;
	}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCOperatorObject";
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Integer(man) };
}
/**
 * Возвращает имя метода поиска.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findOperatorsByMan";
}
/**
 * Insert the method's description here.
 * Creation date: (12.02.2002 10:26:03)
 * @return int
 */
public int getMan() {
	return man;
}
/**
 * Insert the method's description here.
 * Creation date: (12.02.2002 10:26:03)
 * @param newMan int
 */
public void setMan(int newMan) {
	man = newMan;
}
}
