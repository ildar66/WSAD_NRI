package com.hps.july.web.util;

/**
 * ������ - ��������� �������� - ������������ � ������������� ���������.
 * Creation date: (07.10.2003 17:34:57)
 * @author: Dmitry Dneprov
 */
public class StateNavigatorObject {
	private java.lang.String url;
	private java.lang.String params;
	private java.lang.String name;
	private java.lang.Integer menuid;
	private java.lang.String context;
	private boolean returnable;
	private java.lang.String anchor;
	private boolean struts = true;
/**
 * StateNavigatorObject constructor.
 */
public StateNavigatorObject() {
	super();
	this.anchor = null;
}
/**
 * Insert the method's description here.
 * Creation date: (13.09.2004 14:47:02)
 * @return java.lang.String
 */
public java.lang.String getAnchor() {
	return anchor;
}
/**
 * ���������� ������� �������� ����������.
 * Creation date: (07.10.2003 20:02:40)
 * @return java.lang.String
 */
public java.lang.String getContext() {
	return context;
}
/**
 * ���������� ����� ����, ��������������� ��������.
 * Creation date: (07.10.2003 17:41:07)
 * @return java.lang.Integer
 */
public java.lang.Integer getMenuid() {
	return menuid;
}
/**
 * ���������� ������������ ������.
 * Creation date: (07.10.2003 17:37:20)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * ���������� ���������, ������������ ��� �������� �� �����.
 * Creation date: (07.10.2003 17:35:59)
 * @return java.lang.String
 */
public java.lang.String getParams() {
	return params;
}
/**
 * ���������� URL �������� �� �����.
 * Creation date: (07.10.2003 17:35:45)
 * @return java.lang.String
 */
public java.lang.String getUrl() {
	return url;
}
/**
 * ������� ����, ��� �� ����� ����� ������������.
 * Creation date: (16.10.2003 14:48:48)
 * @return boolean
 */
public boolean isReturnable() {
	return returnable;
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2004 16:52:37)
 * @return boolean
 */
public boolean isStruts() {
	return struts;
}
/**
 * Insert the method's description here.
 * Creation date: (13.09.2004 14:47:02)
 * @param newSelectableParam java.lang.String
 */
public void setAnchor(java.lang.String newAnchor) {
	anchor = newAnchor;
}
/**
 * ������������� �������� ����������.
 * Creation date: (07.10.2003 20:02:40)
 * @param newContext java.lang.String
 */
public void setContext(java.lang.String newContext) {
	context = newContext;
}
/**
 * ������������� ����� ����, ��������������� ��������.
 * Creation date: (07.10.2003 17:41:07)
 * @param newMenuid java.lang.Integer
 */
public void setMenuid(java.lang.Integer newMenuid) {
	menuid = newMenuid;
}
/**
 * ������������� ������������ ������.
 * Creation date: (07.10.2003 17:37:20)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * ������������� ���������, ������������ ��� �������� �� �����.
 * Creation date: (07.10.2003 17:35:59)
 * @param newParams java.lang.String
 */
public void setParams(java.lang.String newParams) {
	params = newParams;
}
/**
 * ������� ����, ��� �� ����� ����� ������������.
 * Creation date: (16.10.2003 14:48:48)
 * @param newReturnable boolean
 */
public void setReturnable(boolean newReturnable) {
	returnable = newReturnable;
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2004 16:52:37)
 * @param newStruts boolean
 */
public void setStruts(boolean newStruts) {
	struts = newStruts;
}
/**
 * ������������� URL �������� �� �����.
 * Creation date: (07.10.2003 17:35:45)
 * @param newUrl java.lang.String
 */
public void setUrl(java.lang.String newUrl) {
	url = newUrl;
}
}
