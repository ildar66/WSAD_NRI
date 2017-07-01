package com.hps.july.project.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Тестовый обработчик. Не используется.
 * @deprecated
 * Creation date: (24.10.2002 16:35:55)
 * @author: Maksim Gerasimov
 */
public class TestAction extends org.apache.struts.action.Action {
public ActionForward perform(ActionMapping mapping, ActionForm form, 
	HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		//super.perform( mapping, form, request, response );
		//request.getSession().setAttribute("test", form)	; 
		return mapping.findForward( "ok" );
}
}
