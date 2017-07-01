package com.hps.july.siteinfo.actionbean;

import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.hps.july.web.util.*;

/**
 * Запись комментария к карточке учета оборудования в базу.
 * Creation date: (13.10.2004 16:20:23)
 * @author: Dmitry Dneprov
 */
public class ProcessEquipComment extends com.hps.july.web.util.AbstractProcessAction {
/**
 * Метод, который вызывается в режиме изменения записи (action=Edit).
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processUpdate( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	processUpdate( request, errors, editForm);
	return mapping.findForward("success");
}
}
