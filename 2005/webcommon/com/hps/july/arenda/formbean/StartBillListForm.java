package com.hps.july.arenda.formbean;

import java.sql.Date;
/**
 * Bean-form
 * Форма "начало лист bills".
 * Creation date: (16.04.2003 11:14:42)
 * @author: Sergey Gourov
 */
public class StartBillListForm extends StartProlongationsListForm {
	private java.lang.String querytype = "6";
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 17:40:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
/*  java.lang.Boolean isStartDate, java.sql.Date beginStartDate, java.sql.Date endStartDate, // период
    java.lang.Boolean isEconomist, java.lang.Integer economist,
    java.lang.Boolean isTaskType, java.lang.String taskType,
    java.lang.Integer order*/
	
    java.util.GregorianCalendar c = new java.util.GregorianCalendar();
    c.setTime(getEndStartDate());
    c.add(java.util.Calendar.DAY_OF_MONTH, 1);
    
	return new Object[] { new Boolean(!getIsStartDate().booleanValue()), getBeginStartDate(), new Date(c.getTime().getTime()),
		new Boolean(!getIsWorker().booleanValue()), getWorkercode(), new Boolean(true), getQuerytype(), new Integer(2) };
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2003 12:42:18)
 * @return java.lang.String
 */
public java.lang.String getQuerytype() {
	return querytype;
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2003 12:42:18)
 * @param newQuerytype java.lang.String
 */
public void setQuerytype(java.lang.String newQuerytype) {
	querytype = newQuerytype;
}
}
