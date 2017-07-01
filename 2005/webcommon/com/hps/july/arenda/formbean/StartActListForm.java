package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "начало акта(лист)".
 * Creation date: (10.01.2003 16:49:08)
 * @author: Sergey Gourov
 */
public class StartActListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.Boolean isTaskType;
	private java.lang.String taskType;
	private java.lang.Integer document;
	private int actCode;
	private java.lang.String actNumber;
	private java.sql.Date actDate;
	private java.sql.Date actStartDate;
	private java.sql.Date actEndDate;
	private int order;
/**
 * StartActListForm constructor comment.
 */
public StartActListForm() {
	super();
	setFinderMethodName("2");
	order = 2;
	setIsTaskType(new Boolean(true));
	setTaskType("4");
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:39:12)
 * @return int
 */
public int getActCode() {
	return actCode;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:40:04)
 * @return java.sql.Date
 */
public java.sql.Date getActDate() {
	return actDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:40:44)
 * @return java.sql.Date
 */
public java.sql.Date getActEndDate() {
	return actEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:39:36)
 * @return java.lang.String
 */
public java.lang.String getActNumber() {
	return actNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:40:26)
 * @return java.sql.Date
 */
public java.sql.Date getActStartDate() {
	return actStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:37:30)
 * @return java.lang.Integer
 */
public java.lang.Integer getDocument() {
	return document;
}
/**
 * Insert the method's description here.
 * Creation date: (10.01.2003 16:49:08)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	try {
		order = Integer.parseInt(super.getFinderMethodName());
	} catch (NumberFormatException e) {}
	
	return new Object[] { isTaskType.booleanValue() ? Boolean.FALSE : Boolean.TRUE, getTaskType(),
		new Boolean(true), getDocument(), new Integer(order) };
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findByQBE2";
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:30:02)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsTaskType() {
	return isTaskType;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:36:06)
 * @return java.lang.String
 */
public java.lang.String getTaskType() {
	return taskType;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:39:12)
 * @param newActCode int
 */
public void setActCode(int newActCode) {
	actCode = newActCode;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:40:04)
 * @param newActDate java.sql.Date
 */
public void setActDate(java.sql.Date newActDate) {
	actDate = newActDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:40:44)
 * @param newActEndDate java.sql.Date
 */
public void setActEndDate(java.sql.Date newActEndDate) {
	actEndDate = newActEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:39:36)
 * @param newActNumber java.lang.String
 */
public void setActNumber(java.lang.String newActNumber) {
	actNumber = newActNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:40:26)
 * @param newActStartDate java.sql.Date
 */
public void setActStartDate(java.sql.Date newActStartDate) {
	actStartDate = newActStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:37:30)
 * @param newDocument java.lang.Integer
 */
public void setDocument(java.lang.Integer newDocument) {
	document = newDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:30:02)
 * @param newIsTaskType java.lang.Boolean
 */
public void setIsTaskType(java.lang.Boolean newIsTaskType) {
	isTaskType = newIsTaskType;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 15:36:06)
 * @param newTaskType java.lang.String
 */
public void setTaskType(java.lang.String newTaskType) {
	taskType = newTaskType;
}
}
