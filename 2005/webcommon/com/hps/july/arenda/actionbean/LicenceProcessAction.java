package com.hps.july.arenda.actionbean;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;
import java.sql.*;

import com.hps.july.arenda.formbean.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.util.*;
import com.hps.july.arenda.cdbcobjects.*;
import java.text.SimpleDateFormat;
/**
* Insert the type's description here.
* Creation date: (24.02.2005 11:33:18)
* @author: Shafigullin Ildar
*/
public class LicenceProcessAction extends org.apache.struts.action.Action {
/**
 * Insert the method's description here.
 * Creation date: (24.02.2005 11:34:30)
 */
public LicenceProcessAction() {
    super();
}
/**
 * Insert the method's description here.
 * Creation date: (13.05.2005 14:17:23)
 */
private void doTask(HttpServletRequest request, ActionErrors errors) {
    String positionStr = request.getParameter("positionStr");
    String typeStr = request.getParameter("typeStr");
    String dateStr = request.getParameter("dc");
    String operatorStr = request.getParameter("operatorStr");
    //System.out.println("positionStr=" + positionStr + "  typeStr=" + typeStr + " operatorStr=" + operatorStr); //tmp
    int position = Integer.valueOf(positionStr).intValue();
    int type = Integer.valueOf(typeStr).intValue();
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    Date date = null;
    try {
        if (dateStr != null && !dateStr.equals(""))
            date = new Date(format.parse(dateStr).getTime());
    } catch (java.text.ParseException pe) {
        pe.printStackTrace(System.out);
    }
    try {
        String errorTxt = new LicenceDAO().updateDateLicence(position, type, date, operatorStr, "");
        if (!errorTxt.equals("")) {
            errors.add(
                ActionErrors.GLOBAL_ERROR,
                new ActionError("error.txt", "SQLException: Ошибка выполнения LicenceProcessAction.doTask ERROR:code=" + errorTxt));
        }
    } catch (SQLException e) {
        System.out.println("SQLException LicenceProcessAction.doTask : ");
        System.out.println("ERROR: code=" + e.getErrorCode() + ", msg=" + e.getMessage());
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError(
                "error.txt",
                "SQLException: Ошибка выполнения LicenceProcessAction.doTask ERROR:code=" + e.getErrorCode()));
        e.printStackTrace(System.out);
    } catch (ServiceLocatorException exc) {
        System.out.println("ServiceLocatorException LicenceProcessAction.doTask:" + exc);
        exc.printStackTrace(System.out);
    }
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
    String forwardStr = "calendar";
    //start counter:
    TimeCounter counter = new TimeCounter("PERF.ARENDA.LicenceProcessAction");
    counter.start();

    ActionErrors errors = new ActionErrors();
    ActionForward forward = new ActionForward();
    //выполняем запрос:
    doTask(request, errors);
    // If a message is required, save the specified key(s)
    // into the request for use by the <struts:errors> tag.
    if (!errors.empty()) {
        saveErrors(request, errors);
        forwardStr = "error";
    }
    // Write logic determining how the user should be forwarded.
    //forward = mapping.findForward(listForm.getComand());
    forward = mapping.findForward(forwardStr);
    //counter end
    counter.finish("action");
    return (forward);
}
}
