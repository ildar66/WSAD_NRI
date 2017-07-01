package com.hps.july.web.util;

import org.apache.struts.action.ActionErrors;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.util.BeanUtils;

/**
 * Форма, от которой необходимо наследовать форму редактирования. Поддержка Action.
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
 * Метод вызывается после удаления основной записи.
 * Creation date: (13.02.2002 10:17:44)
 */
public void afterDelete(javax.servlet.http.HttpServletRequest request) throws Exception  {}
/**
 * Метод вызывается после добавления/изменения основной записи.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {}
/**
 * Метод вызывается перед удалением основной записи.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception 
	{
	}
/**
 * Метод вызывается перед изменением основной записи.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {}
/**
 * Метод для создания новой записи.
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
 * Метод для вычисления полей перед отображением.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {}
/**
 * Текущий режим работы.
 * Creation date: (07.02.2002 14:34:18)
 * @return java.lang.String
 */
public java.lang.String getAction() {
	return action;
}
/**
 * Текущее приложение.
 * Creation date: (13.02.2002 10:24:14)
 * @return int
 */
public abstract int getApplication();
/**
 * Метод для поиска текущей записи.
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
 * Поле для хранения адреса возврата.
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
 * Текущее состояние приложения.
 * Creation date: (13.02.2002 10:24:14)
 * @return int
 */
public abstract int getState();
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {}
/**
 * Инициализация полей в режиме добавления записи.
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
 * Метод загрузки данных в форму
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
 * Этот метод вызывается в режиме удаления записи.
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
 * Этот метод вызывается в режиме добавления записи.
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
 * Этот метод вызывается в режиме изменения записи.
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
 * Текущий режим работы.
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
 * Поле для хранения адреса возврата.
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
 * Метод для проверки правильности ввода значений в поля ввода.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException - 
 * при этом исключении ошибки отображаются пользователю.
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
