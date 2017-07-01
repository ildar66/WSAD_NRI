package com.hps.july.web.util;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;

/**
 * Стандартный AbstractProcessAction, который возвращается на success.
 * Creation date: (26.11.2003 13:00:23)
 * @author: Dmitry Dneprov
 */
public class SuccessProcessAction extends AbstractProcessAction {
/**
 * Обработка режима удаления записи.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processDelete( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	ActionForward result = processDelete( request, errors, editForm);
	if (result == null)
		result = mapping.findForward("success");
	return result;
}
/**
 * Обработка режима добавления записи.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processInsert( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	ActionForward result = processInsert( request, errors, editForm);
	if (result == null)
		result = mapping.findForward("success");
	return result;
}
/**
 * Обработка режима изменения записи.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processUpdate( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	ActionForward result = processUpdate( request, errors, editForm);
	if (result == null)
		result = mapping.findForward("success");
	return result;
}
}
