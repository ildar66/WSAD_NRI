package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
/**
 * Форма списка служб.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class ServiceListForm extends com.hps.july.web.util.BrowseForm {
	private int direction;
	private int activestate = 2;
	private int order;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public ServiceListForm() {
	this.setFinderMethodName("1");
	direction = 0;
	}
/**
 * Insert the method's description here.
 * Creation date: (31.07.2003 11:02:20)
 * @return int
 */
public int getActivestate() {
	return activestate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.02.2002 13:23:56)
 * @return int
 */
public int getDirection() {
	return direction;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	try {
		order = Integer.parseInt(super.getFinderMethodName());
	} catch (NumberFormatException e) {}
	
	return new Object[] { new Boolean(true), new Integer(direction),	// Boolean isParent, Integer parent
		new Boolean(getActivestate() != 1), new Boolean(getActivestate() == 2),	// Boolean isIsActive, Boolean isActive
		new Integer(order) };
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findByQBE";
}
/**
 * Insert the method's description here.
 * Creation date: (31.07.2003 11:02:20)
 * @param newActivestate int
 */
public void setActivestate(int newActivestate) {
	activestate = newActivestate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.02.2002 13:23:56)
 * @param newDirection int
 */
public void setDirection(int newDirection) {
	direction = newDirection;
}
}
