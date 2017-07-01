package com.hps.july.web.util;

import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * �����, �� ������� ���������� ����������� ����� ������ � browse. �������� �� ���������.
 * Creation date: (15.01.2002 14:08:44)
 * @author: Administrator
 */
public abstract class BrowseForm extends org.apache.struts.action.ActionForm {
	private java.lang.String finderMethodName;
	private int currentPage;
	private String browseAction;
	private java.lang.String action;
	private boolean lastVisited = false;
/**
 * �����������.
 * Creation date: (25.04.2002 13:50:58)
 */
public BrowseForm() {
	action = "Add";
}
/**
 * ��� ������ ������ ������ ����� �������������� ������������ ������.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	//return constructRowModelBean(o);
	return null;
}
/**
 * ���������� ������, ������������ ������� ����� ������: 
 * Add - ����������, Edit - ��������������, Delete - ��������, View - ��������.
 * Creation date: (25.04.2002 13:50:02)
 * @return java.lang.String
 */
public java.lang.String getAction() {
	return action;
}
/**
 * ���������� ������ ������������ ������� ����� ������ browse:
 * ��. Constants.BROWSE_ACTION_*.
 * Creation date: (22.01.2002 16:44:42)
 * @return int
 */
public String getBrowseAction() {
	return browseAction;
}
/**
 * ���������� ��� bean ��� ������.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return null;
}
/**
 * ���������� ����� ������� �������� ��� �����������.
 * Creation date: (22.01.2002 16:31:56)
 * @return int
 */
public int getCurrentPage() {
	return currentPage;
}
/**
 * ���������� ������ �����, ������� ��������� ��������������.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("AllAuthenticated");
	return roles;
}
/**
 * ���������� ���������, ������� ����� ������������ � ����� ������ ������.
 * Creation date: (22.01.2002 11:17:33)
 * @return java.lang.Object[]
 */
public abstract Object[] getFilterParams();
/**
 * ���������� ��� ������ ������.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return finderMethodName;
}
/**
 * ���������� ���� ����������� ������.
 * ���� true �� ����� �������� ����������� � ������ ���������� � ���� �������� ��������� ���������,
 * �� ��� ��������� ����������� ������������ ������������� �������� �� ��� ��������. 
 * ���� false �� ����� �������� �� �����������.
 * �� ��������� ���� ��������������� � false
 * Creation date: (23.12.2004 16:07:08)
 * @return boolean
 */
public boolean getLastVisited() {
	return this.lastVisited;
}
/**
 * ������������� ������ ��������� ������.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request,
    	HttpServletResponse response) throws IOException, ServletException {
	return null;
}
/**
 * ������������� ������, ������������ ������� ����� ������: 
 * Add - ����������, Edit - ��������������, Delete - ��������, View - ��������.
 * Creation date: (25.04.2002 13:50:02)
 * @param newAction java.lang.String
 */
public void setAction(java.lang.String newAction) {
	action = newAction;
}
/**
 * ������������� ������ ������������ ������� ����� ������ browse:
 * ��. Constants.BROWSE_ACTION_*.
 * Creation date: (22.01.2002 16:44:42)
 * @param newBrowseAction int
 */
public void setBrowseAction(String newBrowseAction) {
	browseAction = newBrowseAction;
}
/**
 * ������������� ����� ������� ��������.
 * Creation date: (22.01.2002 16:31:56)
 * @param newCurrentPage int
 */
public void setCurrentPage(int newCurrentPage) {
	currentPage = newCurrentPage;
}
/**
 * ������������� ��� ������ ������.
 * Creation date: (22.01.2002 11:20:35)
 * @param newFinderMethodName java.lang.String
 */
public void setFinderMethodName(java.lang.String newFinderMethodName) {
	finderMethodName = newFinderMethodName;
}
/**
 * ������������� ���� �����������.
 * ���� true �� ����� �������� ����������� � ������ ���������� � ���� �������� ��������� ���������,
 * �� ��� ��������� ����������� ������������ ������������� �������� �� ��� ��������. 
 * ���� false �� ����� �������� �� �����������.
 * �� ��������� ���� ��������������� � false
 * Creation date: (23.12.2004 16:07:08)
 * @param newLastVisited boolean
 */
public void setLastVisited(boolean lastVisited) {
	this.lastVisited = lastVisited;
}
/**
 * ����� ��� �������� ������������ �������� ��������.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(org.apache.struts.action.ActionErrors errors) throws Exception {}
}
