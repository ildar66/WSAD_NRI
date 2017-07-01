package com.hps.july.arenda.actionbean;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;
import java.sql.*;

import com.hps.july.arenda.formbean.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.arenda.cdbcobjects.*;
/**
* Insert the type's description here.
* Creation date: (24.02.2005 11:33:18)
* @author: Shafigullin Ildar
*/
public class ReportPageAction extends org.apache.struts.action.Action {
/**
 * Insert the method's description here.
 * Creation date: (24.02.2005 11:34:30)
 */
public ReportPageAction() {
    super();
}
/**
 * Process the specified HTTP request, and create the corresponding HTTP
 * response (or forward to another web component that will create it).
 * Return an <code>ActionForward</code> instance describing where and how
 * control should be forwarded, or <code>null</code> if the response has
 * already been completed.
 *
 * @param mapping The ActionMapping used to select this instance
 * @param actionForm The optional ActionForm bean for this request (if any)
 * @param request The HTTP request we are processing
 * @param response The HTTP response we are creating
 *
 * @exception IOException if an input/output error occurs
 * @exception ServletException if a servlet exception occurs
 */
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
    //start counter:
    TimeCounter counter = new TimeCounter("PERF.ARENDA.ReportPageAction");
    counter.start();

    ArendaReport3ParamsForm reportForm = (ArendaReport3ParamsForm) form;    

    ActionErrors errors = new ActionErrors();
    ActionForward forward = new ActionForward();
    Connection connection = null;
    try {
        JdbcConnection jdbcCon = new JdbcConnection();
        connection = jdbcCon.getConnection();
		ReportDAO reportDAO = new ReportDAO();
        Page page = reportDAO.executeSelect(connection, reportForm.getReport(), 0, 100000, "");
		page = reportDAO.executePostSelect(page, connection, reportForm.getReport(), 0, 100000, "");
        //System.out.println("Page size=" + page.getList().size());//temp
        request.setAttribute("reportPage", page);
    } catch (SQLException e) {
        System.out.println("SQLException ReportPageAction.perform: ");
        System.out.println("ERROR: code=" + e.getErrorCode() + ", msg=" + e.getMessage());
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.txt", "SQLException: Ошибка выполнения ReportPageAction.perform ERROR: code=" + e.getErrorCode() + ", msg=" + e.getMessage()));
        e.printStackTrace();
    } catch (Exception exc) {
        System.out.println("Exception ReportPageAction.perform: " + exc);
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.txt", "Exception: Ошибка выполнения ReportPageAction.perform: exc=" + exc));
        exc.printStackTrace();
    } finally {
        try {
            if (connection != null)
                connection.close();
        } catch (Exception exc) {
        }
    }
    //reportForm.doTask(errors);

    // If a message is required, save the specified key(s)
    // into the request for use by the <struts:errors> tag.
    if (!errors.empty()) {
        saveErrors(request, errors);
    }
    // Write logic determining how the user should be forwarded.
    forward = mapping.findForward(reportForm.getComand());
    if(forward == null)
		forward = mapping.findForward("reportPage");
    //counter end
    counter.finish("action");
    return (forward);
}
}
