package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.arenda.*;
import com.hps.july.cdbc.lib.*;
import java.util.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.cdbcobjects.*;
import com.hps.july.jdbcpersistence.lib.*;
/**
 * Action-class.
 * "Подготовка данных для отчета 3"
 * Creation date: (20.02.2003 12:08:57)
 * @author: Sergey Gourov
 */
public class ArendaReport3xlsAction extends NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
  	ParamsParser.setState(request, Applications.ARENDA, APPStates.ARENDA_REPORT3XLS);
  	
  	// Подготовим данные для отчета 3
  	//start counter:
/**  	
	TimeCounter counter = new TimeCounter("PERF.ARENDA.ArendaReport3xslAction");
	counter.start();
	
	ArendaReport3ParamsForm aform = (ArendaReport3ParamsForm)form;
  	CDBCResultSet res = CDBC_ArendaReports.reportArendaCosts(new Integer(1), aform.getStartdate(), aform.getFinishdate());
	request.setAttribute("results", res.listIterator());
    //counter end
	counter.finish("action"); 
*/			
	return mapping.findForward("success");

}
}
