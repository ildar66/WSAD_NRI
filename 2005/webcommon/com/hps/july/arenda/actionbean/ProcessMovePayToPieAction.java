package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.sessionbean.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Action-class.
 * действие для "передачи платежей к 'PIE'"
 * Creation date: (07.04.2003 18:12:31)
 * @author: Sergey Gourov
 */
public class ProcessMovePayToPieAction extends com.hps.july.web.util.NavigatedAction {
/**
 * Insert the method's description here.
 * Creation date: (01.08.2003 11:20:15)
 * @return java.lang.String
 */
String getErrorMovePayToPie() {
	return "errorMovePayToPie";
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2003 17:09:40)
 * @return java.lang.String
 */
public String getStateForPie() {
	return "wepaystate";
}
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return false;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	Object[] o = (Object[]) request.getSession().getAttribute(getStateForPie());
	try {
		o = new ArendaDocumentProcessorAccessBean().movePayToPie(((Integer) o[0]).intValue(), (String) o[1], (String) o[2]);
		if (((Integer) o[0]).intValue() == 0) {
			return mapping.findForward("success");
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	request.getSession().setAttribute(getErrorMovePayToPie(), o[1]);
	return mapping.findForward("error");
}
}
