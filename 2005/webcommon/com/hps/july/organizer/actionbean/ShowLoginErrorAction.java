package com.hps.july.organizer.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.organizer.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;


/**
 * Отображение ошибки входа в систему.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowLoginErrorAction extends org.apache.struts.action.Action {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ActionErrors errors = new ActionErrors();
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.login"));
	 	saveErrors(request, errors);
		super.perform( mapping, form, request, response );
	  	ParamsParser.setState( request, Applications.ORGANIZER, APPStates.LOGIN );
		return mapping.findForward( "main" );
	}
}
