package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.arenda.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * Действие для "поиск операторов".
 * Creation date: (27.09.2002 12:48:35)
 * @author: Sergey Gourov
 */
public class ShowOperatorLookupListAction extends com.hps.july.web.util.LookupBrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (27.09.2002 12:48:35)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.OperatorAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
	  	ParamsParser.setState(request, Applications.ARENDA, APPStates.OPERATOR_LOOKUP);
		return mapping.findForward("main");
	}
}
