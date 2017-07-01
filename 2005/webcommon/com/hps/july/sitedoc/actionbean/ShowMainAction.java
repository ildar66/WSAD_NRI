package com.hps.july.sitedoc.actionbean;

import com.hps.july.jdbcpersistence.lib.AppConstants;
import com.hps.july.sitedoc.*;
import com.hps.july.constants.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;

/**
 * Обработчик главной формы модуля
 */
public class ShowMainAction extends NavigatedAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform( mapping, form, request, response );
	  	ParamsParser.setState( request, Applications.SITEDOC, APPStates.MAIN );
	  	request.getSession().setAttribute(AppConstants.APP_HOME,new Integer(Applications.SITEDOC));
		return mapping.findForward( "main" );
	}
}
