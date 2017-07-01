package com.hps.july.security.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import org.apache.struts.action.*;

import com.hps.july.web.util.*;
import com.hps.july.security.*;
import com.hps.july.constants.*;

/**
 * Insert the type's description here.
 * Creation date: (16.11.2004 15:43:29)
 * @author: Vadim Glushkov
 */
public class MsUsersListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String name = null;
/**
 * MsUsersListForm constructor comment.
 */
public MsUsersListForm() {
	super();
	this.name = "";
	setLastVisited(true);
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCMSUserObject";
}
/**
 * Возвращает список ролей, которым разрешено редактирование.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	if(this.name == null) this.name = "";
	return new Object[] { this.name };
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findByName";
}
/**
 * Insert the method's description here.
 * Creation date: (17.11.2004 13:05:01)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Для каждой строки броуза можно переопределить возвращаемый объект.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request,
    	HttpServletResponse response) throws IOException, ServletException {
	ParamsParser.setState(request, Applications.SECURITY, APPStates.MSUSERS_LIST);
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (17.11.2004 13:05:01)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	this.name = newName;
}
}
