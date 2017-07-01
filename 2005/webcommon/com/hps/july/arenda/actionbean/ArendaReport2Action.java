package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.arenda.*;
/**
 * Action-class.
 * "Запрос для отчета 2"
 * Creation date: (20.02.2003 12:08:57)
 * @author: Sergey Gourov
 */
public class ArendaReport2Action extends NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
  	ParamsParser.setState(request, Applications.ARENDA, APPStates.ARENDA_REPORT2);
	return mapping.findForward("main");
}
}
