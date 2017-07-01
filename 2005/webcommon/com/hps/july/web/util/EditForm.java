package com.hps.july.web.util;

import org.apache.struts.action.ActionErrors;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.util.BeanUtils;

/**
 * �����, �� ������� ���������� ����������� ����� ��������������. ��������� Action.
 * Creation date: (07.02.2002 14:33:47)
 * @author: Dmitry Dneprov
 */
abstract public class EditForm extends org.apache.struts.action.ActionForm {
	private java.lang.String action;
	private java.lang.String returnPage;
	private java.lang.String returnParam = null;
	private boolean lastVisited = false;
	public final static String ACTION_ADD = "Add";
	public final static String ACTION_EDIT = "Edit";
	public final static String ACTION_VIEW = "View";
	public final static String ACTION_DELETE = "Delete";
	
	public final static String MOCK_DOC_ID = "-9999";
	
	public static final String FALSE_STR = Boolean.FALSE.toString();
	public static final String TRUE_STR = Boolean.TRUE.toString();
	
/**
 * ����� ���������� ����� �������� �������� ������.
 * Creation date: (13.02.2002 10:17:44)
 */
public void afterDelete(javax.servlet.http.HttpServletRequest request) throws Exception  {}
/**
 * ����� ���������� ����� ����������/��������� �������� ������.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {}
/**
 * ����� ���������� ����� ��������� �������� ������.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception 
	{
	}
/**
 * ����� ���������� ����� ���������� �������� ������.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {}
/**
 * ����� ��� �������� ����� ������.
 * Creation date: (13.02.2002 10:20:36)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	throw new Exception("/!\\ Form method constructBean is not implemented!");
}
/**
 * ����� ��� ���������� ����� ����� ������������.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {}
/**
 * ������� ����� ������.
 * Creation date: (07.02.2002 14:34:18)
 * @return java.lang.String
 */
public java.lang.String getAction() {
	return action;
}
/**
 * ������� ����������.
 * Creation date: (13.02.2002 10:24:14)
 * @return int
 */
public abstract int getApplication();
/**
 * ����� ��� ������ ������� ������.
 * Creation date: (13.02.2002 10:12:41)
 */
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	throw new Exception("/!\\ Form method getDataBean is not implemented!");
}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2005 16:59:20)
 * @return boolean
 */
public boolean getLastVisited() {
	return this.lastVisited;
}
/**
 * ���� ��� �������� ������ ��������.
 * Creation date: (27.06.2002 18:24:47)
 * @return java.lang.String
 */
public java.lang.String getReturnPage() {
	return returnPage;
}
/**
 * Insert the method's description here.
 * Creation date: (14.09.2004 20:20:29)
 * @return java.lang.String
 */
public java.lang.String getReturnParam() {
	return returnParam;
}
/**
 * ������� ��������� ����������.
 * Creation date: (13.02.2002 10:24:14)
 * @return int
 */
public abstract int getState();
/**
 * ������������� ��������� ����� ������������ ������������.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {}
/**
 * ������������� ����� � ������ ���������� ������.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2005 16:59:20)
 * @return boolean
 */
public boolean isLastVisited() {
	return lastVisited;
}
/**
 * ����� �������� ������ � �����
 * Creation date: (13.02.2002 10:12:41)
 */
public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
   	AbstractEntityAccessBean bean = getDataBean(request);
	BeanUtils.copyProperties( this, bean ); 
	fillRecord( bean );
}
/**
 * ���� ����� ���������� � ������ �������� ������.
 * Creation date: (10.02.2004 14:01:52)
 */
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
	AbstractEntityAccessBean bean = null;
	bean = getDataBean(request);
	bean.refreshCopyHelper();
	beforeDelete(bean, request);
	bean.getEJBRef().remove();
	afterDelete(request);
	return null;
}
/**
 * ���� ����� ���������� � ������ ���������� ������.
 * Creation date: (10.02.2004 14:06:40)
 */
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
	AbstractEntityAccessBean bean = null;
	bean = constructBean(request);
	BeanUtils.copyProperties(bean, this);
	beforeUpdate(bean, request);
	bean.commitCopyHelper();
	afterUpdate(bean, request);
	return null;
}
/**
 * ���� ����� ���������� � ������ ��������� ������.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors)  throws Exception{
	AbstractEntityAccessBean bean = null;
	bean = getDataBean(request);
	BeanUtils.copyProperties(bean, this);
	beforeUpdate(bean, request);
	bean.commitCopyHelper();
	afterUpdate(bean, request);
	return null;
}
/**
 * ������� ����� ������.
 * Creation date: (07.02.2002 14:34:18)
 * @param newAction java.lang.String
 */
public void setAction(java.lang.String newAction) {
	action = newAction;
}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2005 16:59:20)
 * @param newLastVisited boolean
 */
public void setLastVisited(boolean newLastVisited) {
	this.lastVisited = newLastVisited;
}
/**
 * ���� ��� �������� ������ ��������.
 * Creation date: (27.06.2002 18:24:47)
 * @param newReturnPage java.lang.String
 */
public void setReturnPage(java.lang.String newReturnPage) {
	returnPage = newReturnPage;
}
/**
 * Insert the method's description here.
 * Creation date: (14.09.2004 20:20:29)
 * @param newReturnParam java.lang.String
 */
public void setReturnParam(java.lang.String newReturnParam) {
	returnParam = newReturnParam;
}
/**
 * ����� ��� �������� ������������ ����� �������� � ���� �����.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException - 
 * ��� ���� ���������� ������ ������������ ������������.
 */
public void validateValues(ActionErrors errors) throws Exception {}

public static String getUniqueMockParams() {
	StringBuffer theSB = new StringBuffer();
	theSB.append(Math.round(Math.random()*1000000));
	theSB.append("=");
	theSB.append(Math.round(Math.random()*1000000));
	return theSB.toString();
}

}
