package com.hps.july.arenda.formbean;

import org.apache.struts.util.*;
import com.hps.july.web.util.*;
/**
 * Form-Bean "Журнал продлений договоров"
 * Creation date: (26.09.2002 11:57:38)
 * @author: Sergey Gourov
 */
public class JournalProlongationsListForm extends com.hps.july.web.util.BrowseForm {
	private int taskStartcode;
	private java.sql.Date firstDate;
	private java.sql.Date secondDate;
	private java.lang.String operatorname;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private com.hps.july.web.util.StringAndSqlDateProperty tempDate;
	private java.lang.Boolean isError;
	private java.lang.Boolean isWarning;
	private java.lang.Boolean isSuccess;
/**
 * JournalProlongationsListForm constructor comment.
 */
public JournalProlongationsListForm() {
	super();
	setFinderMethodName("findByTaskStartOrderByJrndateAscAndTaskjournalAsc"); // findByTaskStartOrderByJrnDate
	tempDate = new StringAndSqlDateProperty();

	setIsError(new Boolean(true));
	setIsSuccess(new Boolean(false));
	setIsWarning(new Boolean(true));
}
/**
 * Insert the method's description here.
 * Creation date: (07.02.2003 18:29:25)
 * @return java.lang.String
 * @param param java.sql.Date
 */
public String getCertainDate(java.sql.Date param) {
	tempDate.setSqlDate(param);
	return tempDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (12.02.2003 15:18:35)
 * @return java.lang.String
 * @param param java.lang.String
 */
public String getContractType(String param, MessageResources messageResources) {
	try {
		String message = "";
		if (param.equals("A")) {
			message = messageResources.getMessage("label.contracttype.arenda");
		} else if (param.equals("B")) {
			message = messageResources.getMessage("label.contracttype.arendaus");
		} else if (param.equals("C")) {
			message = messageResources.getMessage("label.contracttype.user");
		} else if (param.equals("D")) {
			message = messageResources.getMessage("label.contracttype.channel");
		}
		return new String(ResponseUtils.filter(message).getBytes("Cp1251"));
	} catch (Exception e) {
		e.printStackTrace();
		return "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 13:56:03)
 * @return java.sql.Date
 */
public java.sql.Date getEndDate() {
	return endDate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 11:57:38)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Integer(getTaskStartcode()), getIsError(), getIsWarning(), getIsSuccess() };
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 13:52:39)
 * @return java.sql.Date
 */
public java.sql.Date getFirstDate() {
	return firstDate;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 12:07:23)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsError() {
	return isError;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 12:09:13)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsSuccess() {
	return isSuccess;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 12:08:21)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsWarning() {
	return isWarning;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 13:54:44)
 * @return java.lang.String
 */
public java.lang.String getOperatorname() {
	return operatorname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 13:53:17)
 * @return java.sql.Date
 */
public java.sql.Date getSecondDate() {
	return secondDate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 13:55:37)
 * @return java.sql.Date
 */
public java.sql.Date getStartDate() {
	return startDate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 12:47:39)
 * @return int
 */
public int getTaskStartcode() {
	return taskStartcode;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 13:56:03)
 * @param newEndDate java.sql.Date
 */
public void setEndDate(java.sql.Date newEndDate) {
	endDate = newEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 13:52:39)
 * @param newFirstDate java.sql.Date
 */
public void setFirstDate(java.sql.Date newFirstDate) {
	firstDate = newFirstDate;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 12:07:23)
 * @param newIsError java.lang.Boolean
 */
public void setIsError(java.lang.Boolean newIsError) {
	isError = newIsError;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 12:09:13)
 * @param newIsSuccess java.lang.Boolean
 */
public void setIsSuccess(java.lang.Boolean newIsSuccess) {
	isSuccess = newIsSuccess;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 12:08:21)
 * @param newIsWarning java.lang.Boolean
 */
public void setIsWarning(java.lang.Boolean newIsWarning) {
	isWarning = newIsWarning;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 13:54:44)
 * @param newOperatorname java.lang.String
 */
public void setOperatorname(java.lang.String newOperatorname) {
	operatorname = newOperatorname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 13:53:17)
 * @param newSecondDate java.sql.Date
 */
public void setSecondDate(java.sql.Date newSecondDate) {
	secondDate = newSecondDate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 13:55:37)
 * @param newStartDate java.sql.Date
 */
public void setStartDate(java.sql.Date newStartDate) {
	startDate = newStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 12:47:39)
 * @param newTaskStartcode int
 */
public void setTaskStartcode(int newTaskStartcode) {
	taskStartcode = newTaskStartcode;
}
}
