package com.hps.july.arenda.actionbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.arenda.formbean.FactsLeasePageForm;
//import com.hps.july.jdbcpersistence.lib.TimeCounter;
/**
* "Фактические данные по договорам Аренды" Action.
* Creation date: (24.02.2005 11:33:18)
* @author: Shafigullin Ildar
*/
public class FactsLeasePageAction extends org.apache.struts.action.Action {
/**
 * Creation date: (24.02.2005 11:34:30)
 */
public FactsLeasePageAction() {
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
    String mappingStr = null;
    //start counter:
    //TimeCounter counter = new TimeCounter("PERF.ARENDA.FactsLeasePageAction");
    //counter.start();

    FactsLeasePageForm listForm = (FactsLeasePageForm) form;
    ActionErrors errors = new ActionErrors();
    ActionForward forward = new ActionForward();
    //выполняем запрос:
    String cmdStr = listForm.getComand();
    if (cmdStr.equalsIgnoreCase("factsLeaseExcel")) {
        //listForm.doTask(errors, request);
        mappingStr = "factsLeaseExcel";
        listForm.setComand(FactsLeasePageForm.NULL_COMAND);
    } else {
        listForm.doTask(errors, request);
        mappingStr = "factsLeasePage";
    }

    // If a message is required, save the specified key(s)
    // into the request for use by the <struts:errors> tag.
    if (!errors.empty()) {
        saveErrors(request, errors);
    }
    // Write logic determining how the user should be forwarded.
    //forward = mapping.findForward(listForm.getComand());
    forward = mapping.findForward(mappingStr);
    //counter end
    //counter.finish("action");
    return (forward);
}
}
