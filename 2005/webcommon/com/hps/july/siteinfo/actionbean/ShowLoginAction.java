package com.hps.july.siteinfo.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.siteinfo.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.siteinfo.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;


/**
 * Обработчик входа в систему
 */
public class ShowLoginAction extends org.apache.struts.action.Action {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform( mapping, form, request, response );
	  	ParamsParser.setState( request, Applications.SITEINFO, APPStates.LOGIN );
		return mapping.findForward( "main" );
	}
}
