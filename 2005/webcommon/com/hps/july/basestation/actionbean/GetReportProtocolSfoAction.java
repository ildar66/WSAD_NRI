package com.hps.july.basestation.actionbean;

import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.basestation.formbean.ReportFinderForm;
import com.hps.july.cdbc.objects.CDBCComlinesObject;
import com.hps.july.cdbc.lib.*;

public class GetReportProtocolSfoAction
	extends GetReportProtocolAction
{
public Object getReportList(String sfonumber, ActionErrors errors) throws Exception {
	ReportProtocolValue reportVal = null;
	LinkedList reportList = new LinkedList();
	try {
		CDBCComlinesObject co = new CDBCComlinesObject();
		CDBCResultSet rs = co.getReportProtocolSFO(sfonumber);
		Iterator it = rs.listIterator();
		while(it.hasNext()) {
			reportVal = this.constructReportLine((CDBCRowObject)it.next());
			reportList.add(reportVal);
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
		throw new Exception();
	}
	return reportList;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws java.io.IOException, ServletException
{
	System.out.println("CALL SFO PROTOCOL REPORT!");
	ActionErrors errors = new ActionErrors();
	com.hps.july.web.util.ParamsParser.setState( request, com.hps.july.constants.Applications.BASESTATION, com.hps.july.basestation.APPStates.SFO_PROTOCOL );
	try {
		String sfo = request.getParameter("sfonumber");
	System.out.println("SFO:'"+sfo+"'");
		if(sfo != null && sfo.length() > 255) {
			// Too big
			sfo = sfo.substring(0,255);
		}
		if(sfo != null && "".equals(sfo.trim())) {
			sfo = null;
		}
		Object reportList = this.getReportList(sfo, errors);
		request.setAttribute("reportList", reportList);
		setUnderlineParamsToRequest(request);
		setRegionString(request);
	} catch(Exception e) {
		e.printStackTrace(System.out);
  	    request.setAttribute("reportList", new LinkedList());
  	    saveErrors(request, errors);
  	    return mapping.findForward( "main" );
	}
	return mapping.findForward("success");
}
}
