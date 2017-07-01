package com.hps.july.basestation.actionbean;

import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.hps.july.basestation.formbean.ReportFinderForm;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
/**
 * Atcion для проверки наличия в базе данных для введенного номера файла. 
 * Creation date: (16.08.2004 10:56:06)
 */
public class CheckReportsForFileNumberAction extends Action {
/**
 * Creation date: (16.08.2004 11:01:38)
 * @return boolean
 * @param finderForm com.hps.july.basestation.formbean.ReportFinderForm
 * @param errors org.apache.struts.action.ActionErrors
 * @exception java.lang.Exception The exception description.
 */
public boolean checkIfFileExists(ReportFinderForm finderForm, ActionErrors errors) throws java.lang.Exception {
	if(null == finderForm)
		return false;
	int filenumber = finderForm.getFilenumber();
	String sql = "select * from freqpermissions where filenumber=" + filenumber;
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	boolean haveResult = false;
	try {
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		if(resultSet.next()) {
			haveResult = true;
		}
		statement.close();
		connection.close();
	} catch(Exception e) {
		e.printStackTrace();
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
		throw new Exception();
	} finally {
		statement.close();
		connection.close();
	}
	return haveResult;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 10:58:28)
 */
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
												throws java.io.IOException, ServletException {

	ReportFinderForm finderForm = (ReportFinderForm)form;
	com.hps.july.web.util.ParamsParser.setState( request, finderForm.getApplication(), finderForm.getState() );
	ActionErrors errors = new ActionErrors();
	try {
		finderForm.validateValues(errors);
		if(checkIfFileExists(finderForm, errors)) {
			request.setAttribute("fileexists", new Boolean(true));
			request.setAttribute("filenumber", finderForm.getFilenumberFrm());
		} else {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.reports.filenotfound"));
			throw new Exception();
		}
	} catch(Exception e) {
  	    saveErrors(request, errors);
	}
	return mapping.findForward("main");
}
}
