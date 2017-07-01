package com.hps.july.security.formbean;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

import com.hps.july.web.util.*;
import com.hps.july.security.*;
import com.hps.july.constants.*;
/**
 * Форма lookup по выбору должности.
 * Creation date: (15.01.2002 14:06:31)
 * @author: ildar
 */
public class WorkPositionLookupListForm extends com.hps.july.web.util.BrowseForm {
    private java.lang.String name;
    private String orderBy;
    private java.lang.String activestate;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkPositionLookupListForm() {
    name = "";
    setActivestate("Y");
    setOrderBy("name");
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:35:47)
 * @return java.lang.String
 */
public java.lang.String getActivestate() {
	return activestate;
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBC_WorkPosition_Object";
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    return new Object[] {
        new Boolean(true),        getName(),
        new Boolean(true),        getActivestate(),
        getOrderBy()};
}
/**
 * Возвращает имя метода поиска.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
    return "findList";
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:35:47)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:35:47)
 * @return java.lang.String
 */
public java.lang.String getOrderBy() {
	return orderBy;
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.SECURITY, APPStates.WPOSLOOKUP);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:35:47)
 * @param newActivestate java.lang.String
 */
public void setActivestate(java.lang.String newActivestate) {
	activestate = newActivestate;
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:35:47)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:35:47)
 * @param newOrderBy java.lang.String
 */
public void setOrderBy(java.lang.String newOrderBy) {
	orderBy = newOrderBy;
}
}
