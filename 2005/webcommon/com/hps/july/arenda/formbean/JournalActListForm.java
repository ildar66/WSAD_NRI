package com.hps.july.arenda.formbean;

/**
 * Form-Bean.
 * "Журнал актов"(лист)
 * Creation date: (10.01.2003 17:06:23)
 * @author: Sergey Gourov
 */
public class JournalActListForm extends com.hps.july.web.util.BrowseForm {
	private int actCode;
	private java.lang.String actNumber;
	private java.sql.Date actDate;
	private java.sql.Date actStartDate;
	private java.sql.Date actEndDate;
	private java.lang.Integer taskStart;
	private java.lang.String taskType;
	private java.lang.String operatorname;
	private java.sql.Timestamp startDate;
	private java.sql.Timestamp endDate;
	private java.lang.Boolean isJrnType;
	private java.lang.String jrnType;
	protected String listForm;
	private int order;
/**
 * JournalActListForm constructor comment.
 */
public JournalActListForm() {
	super();
	setFinderMethodName("3");
	order = 3;
	setIsJrnType(new Boolean(true));
	setJrnType("E");
	listForm = "StartActListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:03:27)
 * @return int
 */
public int getActCode() {
	return actCode;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:03:27)
 * @return java.sql.Date
 */
public java.sql.Date getActDate() {
	return actDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:03:27)
 * @return java.sql.Date
 */
public java.sql.Date getActEndDate() {
	return actEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:03:27)
 * @return java.lang.String
 */
public java.lang.String getActNumber() {
	return actNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:03:27)
 * @return java.sql.Date
 */
public java.sql.Date getActStartDate() {
	return actStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:53:08)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getEndDate() {
	return endDate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.01.2003 17:06:23)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	try {
		order = Integer.parseInt(super.getFinderMethodName());
	} catch (NumberFormatException e) {}
	
	/*java.lang.Integer taskStart, Boolean isJrnType, String jrnType, java.lang.Integer order*/
	return new Object[] { getTaskStart(), isJrnType.booleanValue() ? Boolean.FALSE : Boolean.TRUE, getJrnType(), new Integer(order) };
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findByTaskStartType";
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:53:47)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsJrnType() {
	return isJrnType;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:54:22)
 * @return java.lang.String
 */
public java.lang.String getJrnType() {
	return jrnType;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 19:32:40)
 * @return java.lang.String
 */
public java.lang.String getListForm() {
	return listForm;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:51:14)
 * @return java.lang.String
 */
public java.lang.String getOperatorname() {
	return operatorname;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:52:50)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getStartDate() {
	return startDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:24:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getTaskStart() {
	return taskStart;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:50:58)
 * @return java.lang.String
 */
public java.lang.String getTaskType() {
	return taskType;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:03:27)
 * @param newActCode int
 */
public void setActCode(int newActCode) {
	actCode = newActCode;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:03:27)
 * @param newActDate java.sql.Date
 */
public void setActDate(java.sql.Date newActDate) {
	actDate = newActDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:03:27)
 * @param newActEndDate java.sql.Date
 */
public void setActEndDate(java.sql.Date newActEndDate) {
	actEndDate = newActEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:03:27)
 * @param newActNumber java.lang.String
 */
public void setActNumber(java.lang.String newActNumber) {
	actNumber = newActNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:03:27)
 * @param newActStartDate java.sql.Date
 */
public void setActStartDate(java.sql.Date newActStartDate) {
	actStartDate = newActStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:53:08)
 * @param newEndDate java.sql.Timestamp
 */
public void setEndDate(java.sql.Timestamp newEndDate) {
	endDate = newEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:53:47)
 * @param newIsJrnType java.lang.Boolean
 */
public void setIsJrnType(java.lang.Boolean newIsJrnType) {
	isJrnType = newIsJrnType;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:54:22)
 * @param newJrnType java.lang.String
 */
public void setJrnType(java.lang.String newJrnType) {
	jrnType = newJrnType;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 19:32:40)
 * @param newListForm java.lang.String
 */
public void setListForm(java.lang.String newListForm) {
	listForm = newListForm;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:51:14)
 * @param newOperatorname java.lang.String
 */
public void setOperatorname(java.lang.String newOperatorname) {
	operatorname = newOperatorname;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:52:50)
 * @param newStartDate java.sql.Timestamp
 */
public void setStartDate(java.sql.Timestamp newStartDate) {
	startDate = newStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:24:38)
 * @param newTaskStart java.lang.Integer
 */
public void setTaskStart(java.lang.Integer newTaskStart) {
	taskStart = newTaskStart;
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 18:50:58)
 * @param newTaskType java.lang.String
 */
public void setTaskType(java.lang.String newTaskType) {
	taskType = newTaskType;
}
}
