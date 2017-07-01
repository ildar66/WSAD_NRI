package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик формы выбора организации
 */
public class ShowOrganizationLookupListAction
	extends com.hps.july.web.util.LookupBrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.OrganizationAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
	  	ParamsParser.setState(request, Applications.BASESTATION, APPStates.ORG_LOOKUP);
		return mapping.findForward("main");
	}
}
