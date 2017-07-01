package com.hps.july.basestation.actionbean;

import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.basestation.formbean.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.hps.july.basestation.valueobject.ReportHavePlanValue;
import com.hps.july.basestation.formbean.ReportFinderForm;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
/**
 * Вывод документа "Письмо-заказ"
 */
public class GetOrderLetterAction
	extends Action
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws java.io.IOException, ServletException
{
	FrequencyLicencePositionsListForm frm = (FrequencyLicencePositionsListForm)form;
	ActionErrors errors = new ActionErrors();
	CDBCSitedocsObject sdo = new CDBCSitedocsObject();
	CDBCResultSet rs = sdo.findFrequencyLicencePositions(frm.getSelectedpos());
	request.setAttribute("reportList", rs);
	request.setAttribute("filenumber", frm.getFilenumber());

	return mapping.findForward("success");
}
}
