package com.hps.july.arenda.formbean;

import java.sql.Date;
/**
 * Bean-form
 * Форма"начало платежей(лист)".
 * Creation date: (25.09.2002 10:59:55)
 * @author: Sergey Gourov
 */
public class StartChargesListForm extends StartProlongationsListForm {
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
		new Boolean(!getIsWorker().booleanValue()), getWorkercode(), new Boolean(true), "2", new Integer(1) };
}
}
