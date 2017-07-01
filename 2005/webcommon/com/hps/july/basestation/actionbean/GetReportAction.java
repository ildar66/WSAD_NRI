package com.hps.july.basestation.actionbean;

import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.hps.july.basestation.valueobject.ReportHavePlanValue;
import com.hps.july.basestation.formbean.ReportFinderForm;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
/**
 * Общий Action для получения отчетов 
 */
public class GetReportAction extends Action {
/**
 * Insert the method's description here.
 * Creation date: (13.08.2004 17:36:21)
 * @return boolean
 */
public Object getReportList(ReportFinderForm finderForm, ActionErrors errors) throws Exception{
	return null;
}
/**
 * Creation date: (10.08.2004 16:39:17)
 * @return org.apache.struts.action.ActionForward
 */
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
												throws java.io.IOException, ServletException {

	ReportFinderForm finderForm = (ReportFinderForm)form;
	ActionErrors errors = new ActionErrors();
	try {
		Object reportList = this.getReportList(finderForm, errors);
		request.setAttribute("reportList", reportList);
		request.setAttribute("filenumber", finderForm.getFilenumberFrm());
		setUnderlineParamsToRequest(request);
		setRegionString(request);
	} catch(Exception e) {
		com.hps.july.web.util.ParamsParser.setState( request, finderForm.getApplication(), finderForm.getState() );
  	    request.setAttribute("reportList", new LinkedList());
  	    saveErrors(request, errors);
  	    return mapping.findForward( "main" );
	}
	String type = request.getParameter("type");
	if((null != type) && (!"".equals(type))) {
		if(2 == Integer.parseInt(type))
			return mapping.findForward("success2");
	}	
	return mapping.findForward("success");
}
/**
 * 
 * @param request javax.servlet.http.HttpServletRequest
 */
public void setRegionString(HttpServletRequest request) {}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 14:17:51)
 * @param request javax.servlet.http.HttpServletRequest
 * @exception java.lang.Exception The exception description.
 */
public void setUnderlineParamsToRequest(HttpServletRequest request) throws java.lang.Exception {}
}
