package com.hps.july.siteinfo.actionbean;

import java.sql.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.siteinfo.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;

/**
 * Обработчик показа оборудования из систем OSS
 * @author: Dmitry Dneprov
 */
public class ShowOSSEquipmentAction
	extends org.apache.struts.action.Action
{
public ActionForward perform(ActionMapping mapping, ActionForm form, 
	HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	super.perform(mapping, form, request, response);

	CDBCOSSEquipmentObject ossobj = new CDBCOSSEquipmentObject();

	Integer gsmid = null;
	try {
		gsmid = new Integer(Integer.parseInt(request.getParameter("gsmid")));
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	gsmid = ossobj.convertGSMID(gsmid);

	int nettype = ossobj.getOSSNetType(gsmid);
	switch (nettype) {
		case 1:  	
				ParamsParser.setState( request, Applications.SITEINFO, APPStates.OSSEQUIPALCATEL );
				break;
		case 2:
				ParamsParser.setState( request, Applications.SITEINFO, APPStates.OSSEQUIPNOKIA );
				break;
		case 3:
				ParamsParser.setState( request, Applications.SITEINFO, APPStates.OSSEQUIPERICSSON );
				break;
		default:
				ParamsParser.setState( request, Applications.SITEINFO, APPStates.OSSEQUIPABSENT );
				break;
	}
	return mapping.findForward("main");
}
}
