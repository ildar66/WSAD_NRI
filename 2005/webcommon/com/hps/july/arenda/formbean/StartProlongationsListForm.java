package com.hps.july.arenda.formbean;

import java.sql.Date;
import com.hps.july.web.util.*;
/**
 * Bean-form
 * Форма"начало продления(лист)".
 * Creation date: (19.09.2002 17:40:34)
 * @author: Sergey Gourov
 */
public class StartProlongationsListForm extends com.hps.july.web.util.BrowseForm {
	private StringAndSqlDateProperty beginStartDate;
	private StringAndSqlDateProperty endStartDate;
	private Integer workercode;
	private java.lang.String workername;
	private java.lang.Boolean isStartDate;
	private java.lang.Boolean isWorker;
/**
 * StartProlongationsListForm constructor comment.
 */
public StartProlongationsListForm() {
	super();
	setFinderMethodName("findByQBE");

	java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
	beginStartDate = new StringAndSqlDateProperty();
	beginStartDate.setSqlDate(date);
	endStartDate = new StringAndSqlDateProperty();
	endStartDate.setSqlDate(date);

	setIsStartDate(new Boolean(false));
	setIsWorker(new Boolean(true));
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 17:47:41)
 * @return java.sql.Date
 */
public java.sql.Date getBeginStartDate() {
	return beginStartDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 17:47:41)
 * @return java.sql.Date
 */
public String getBeginStartDateFrm() {
	return beginStartDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 17:48:03)
 * @return java.sql.Date
 */
public java.sql.Date getEndStartDate() {
	return endStartDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 17:48:03)
 * @return java.sql.Date
 */
public String getEndStartDateFrm() {
	return endStartDate.getString();
}
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
		new Boolean(!getIsWorker().booleanValue()), getWorkercode(), new Boolean(true), "1", new Integer(1) };
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 10:22:41)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsStartDate() {
	return isStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 10:24:07)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsWorker() {
	return isWorker;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 17:57:10)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getWorkercode() {
	return workercode;
}
/**
 * Insert the method's description here.
 * Creation date: (20.09.2002 10:10:42)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 17:47:41)
 * @param newBeginStartDate java.sql.Date
 */
public void setBeginStartDate(java.sql.Date newBeginStartDate) {
	beginStartDate.setSqlDate(newBeginStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 17:47:41)
 * @param newBeginStartDate java.sql.Date
 */
public void setBeginStartDateFrm(String newBeginStartDate) {
	beginStartDate.setString(newBeginStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 17:48:03)
 * @param newEndStartDate java.sql.Date
 */
public void setEndStartDate(java.sql.Date newEndStartDate) {
	endStartDate.setSqlDate(newEndStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 17:48:03)
 * @param newEndStartDate java.sql.Date
 */
public void setEndStartDateFrm(String newEndStartDate) {
	endStartDate.setString(newEndStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 10:22:41)
 * @param newIsStartDate java.lang.Boolean
 */
public void setIsStartDate(java.lang.Boolean newIsStartDate) {
	isStartDate = newIsStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 10:24:07)
 * @param newIsWorker java.lang.Boolean
 */
public void setIsWorker(java.lang.Boolean newIsWorker) {
	isWorker = newIsWorker;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 17:57:10)
 * @param newEconomist com.hps.july.web.util.StringAndIntegerProperty
 */
public void setWorkercode(Integer newWorker) {
	workercode = newWorker;
}
/**
 * Insert the method's description here.
 * Creation date: (20.09.2002 10:10:42)
 * @param newEconomistname java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
}
