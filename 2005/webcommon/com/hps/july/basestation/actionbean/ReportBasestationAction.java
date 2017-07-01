package com.hps.july.basestation.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.basestation.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Insert the type's description here.
 * Creation date: (12.08.2004 14:59:26)
 * @author: Dmitry Dneprov
 */
public class ReportBasestationAction extends com.hps.july.web.util.NavigatedAction {
/**
 * Insert the method's description here.
 * Creation date: (12.08.2004 15:02:32)
 * @return org.apache.struts.action.ActionForward
 */
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform( mapping, form, request, response );
	ReportFinderForm reportForm = (ReportFinderForm)form;
	ParamsParser.setState( request, reportForm.getApplication(), reportForm.getState());
	//System.out.println("!!!!!  mapping = " + mapping.findForward("main").getPath());
	return mapping.findForward("main");
}
}
