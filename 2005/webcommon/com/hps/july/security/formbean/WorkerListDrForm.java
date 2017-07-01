package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
/**
 * Форма списка работников дирекции.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class WorkerListDrForm extends com.hps.july.web.util.BrowseForm {
	private int direction;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkerListDrForm() {
	this.setFinderMethodName( "findWorkersByDivision" );
	direction = 0;
	}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 14:26:31)
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
	return new Object[] { new DivisionKey(direction) };
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 14:26:31)
 * @param newDirection int
 */
public void setDirection(int newDirection) {
	direction = newDirection;
}
}
