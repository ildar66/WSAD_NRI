package com.hps.july.basestation.actionbean;

import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.*;
import com.hps.july.basestation.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import com.hps.july.constants.Applications;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.*;
import com.hps.july.basestation.formbean.*;
import org.apache.struts.upload.FormFile;
//import com.hps.july.dataimport.beans.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик инициализации формы загрузки данных по БС.
 * Вызывается при входе в форму из меню
 */
public class InitLoadXlsBs extends NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
{
	navigate(mapping,form,request,response);
		
    int task = 3;
    request.getSession().setAttribute("task", new Integer(task));

    ActionErrors errors = new ActionErrors();
    try {
        DebugSupport.println("loadXlsBs perform started");
		LoadXlsBsForm aform = (LoadXlsBsForm) form;
        //aform.setRequest(request);
        aform.setRequestParams(request);
        if (request.getParameter("maxReport") == null) {
            aform.setMaxReport(false);
        }
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }
    ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLS_BS);
    return mapping.findForward("main");
}
}
