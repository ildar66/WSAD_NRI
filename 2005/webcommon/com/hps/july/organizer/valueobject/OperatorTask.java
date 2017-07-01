package com.hps.july.organizer.valueobject;

/**
 * Объект-значение для хранения характеристик задачи.
 * Creation date: (18.02.2002 10:42:32)
 * @author: Oleg Gashnikov
 */
public class OperatorTask implements Comparable, java.io.Serializable {
	private int taskCode;
	private java.lang.String taskName;
	private java.lang.String roleList;
	private java.lang.String context;
/**
 * OperatorTask constructor comment.
 */
public OperatorTask() {
	super();
}
/**
 * OperatorTask constructor comment.
 */
public OperatorTask( int argTaskCode, String argTaskName, String argRole, String argContext ) {
	super();
	taskCode = argTaskCode;
	taskName = argTaskName;
	roleList = argRole;
	context  = argContext;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 11:46:18)
 * @param role java.lang.String
 */
public void addRole(String role) {
	roleList += ", "+role;
	}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 11:49:34)
 * @return int
 * @param o java.lang.Object
 */
public int compareTo(Object o) {
	if( ! (o instanceof OperatorTask) )
		return -1;
	return new Integer( getTaskCode() ).compareTo( new Integer( ((OperatorTask)o).getTaskCode()) );
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 11:19:23)
 * @return boolean
 * @param obj java.lang.Object
 */
public boolean equals(Object obj) {
	if( ! (obj instanceof OperatorTask) )
		return false;
	if( ((OperatorTask)obj).getTaskCode() == getTaskCode() )
		return true;
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 19:50:43)
 * @return java.lang.String
 */
public java.lang.String getContext() {
	return context;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 10:45:26)
 * @return java.lang.String
 */
public java.lang.String getRoleList() {
	return roleList;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 10:43:23)
 * @return int
 */
public int getTaskCode() {
	return taskCode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 10:45:02)
 * @return java.lang.String
 */
public java.lang.String getTaskName() {
	return taskName;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 11:22:11)
 * @return int
 */
public int hashCode() {
	return getTaskCode();
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 19:50:43)
 * @param newContext java.lang.String
 */
public void setContext(java.lang.String newContext) {
	context = newContext;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 10:45:26)
 * @param newRoleList java.lang.String
 */
public void setRoleList(java.lang.String newRoleList) {
	roleList = newRoleList;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 10:43:23)
 * @param newTaskCode int
 */
public void setTaskCode(int newTaskCode) {
	taskCode = newTaskCode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 10:45:02)
 * @param newTaskName java.lang.String
 */
public void setTaskName(java.lang.String newTaskName) {
	taskName = newTaskName;
}
}
