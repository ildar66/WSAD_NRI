package com.hps.july.security.formbean;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.security.*;

import com.hps.july.persistence.*;
import com.hps.july.persistence.OperatorKey;
import com.hps.july.persistence.PeopleKey;
/**
 * Форма списка ролей оператора.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class Operator2roleListForm extends com.hps.july.web.util.BrowseForm {
	private int operator;
	private java.util.List listAnoveRoleForOperator;
	private java.lang.String orderBy;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public Operator2roleListForm() {
    //this.setFinderMethodName("findOperators2RolesByOperator");
	this.setFinderMethodName("findList");
    operator = 0;
    setOrderBy("");
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { String.valueOf(operator), getOrderBy() };
}
/**
 * Insert the method's description here.
 * Creation date: (03.11.2005 12:30:44)
 * @return java.util.List
 */
public java.util.List getListAnoveRoleForOperator() {
	return listAnoveRoleForOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 11:11:58)
 * @return int
 */
public int getOperator() {
	return operator;
}
/**
 * Insert the method's description here.
 * Creation date: (03.11.2005 14:02:27)
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
    java.util.List list = com.hps.july.cdbc.objects.CDBC_Role_Object.findListAnoveRoleForOperator(String.valueOf(operator), getOrderBy());
    setListAnoveRoleForOperator(list);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (03.11.2005 12:30:44)
 * @param newListAnoveRoleForOperator java.util.List
 */
private void setListAnoveRoleForOperator(java.util.List newListAnoveRoleForOperator) {
	listAnoveRoleForOperator = newListAnoveRoleForOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 11:11:58)
 * @param newOperator int
 */
public void setOperator(int newOperator) {
	operator = newOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (03.11.2005 14:02:27)
 * @param newOrderBy java.lang.String
 */
public void setOrderBy(java.lang.String newOrderBy) {
	orderBy = newOrderBy;
}
}
