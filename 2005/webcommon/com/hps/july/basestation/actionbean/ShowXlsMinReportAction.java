package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.APPStates;
import com.hps.july.basestation.formbean.*;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик краткого журнала загрузок
 */
public class ShowXlsMinReportAction 
	extends NavigatedAction
{
	public String getBrowseBeanName() {
		return "com.hps.july.persistence.ImportSessionAccessBean";
	}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {

    super.perform(mapping, form, request, response);

    try {
        int pk = ((Integer) request.getSession().getAttribute("impsesid")).intValue();
        if (pk == 0)
            throw new Exception("Error in ShowXlsMinReportAction. int pk = ((Integer)request.getSession().getAttribute('impsesid')).intValue();");
        ImportSessionAccessBean ab = new ImportSessionAccessBean();
        ab.setInitKey_impsesid(pk);
        ab.refreshCopyHelper();

        request.setAttribute("minReportForm", ab);

        ParamsParser.setState(
            request,
            Applications.BASESTATION,
            APPStates.XLSLOADRESULT);
        return mapping.findForward("main");
    } catch (Exception ex) {
        ex.printStackTrace(System.out);
        ActionErrors errors = new ActionErrors();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("xls.error.view"));
        saveErrors(request, errors);

        int state;
        if (((Integer)request.getSession().getAttribute("task")).intValue()==3) {
            state = APPStates.IMPORTXLS_BS;
        } else {
            state = APPStates.IMPORTXLS;
        }
        ParamsParser.setState(request, Applications.BASESTATION, state);
        return mapping.findForward("main");
    }
}
}
