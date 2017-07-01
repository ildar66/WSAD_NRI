package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.valueobject.*;
import com.hps.july.persistence.*;
import java.util.*;
import java.lang.reflect.*;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
//import com.hps.july.security.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.basestation.APPStates;
import org.apache.struts.util.MessageResources;
import com.hps.july.basestation.formbean.*;

/**
 * Обработчик списка результатов загрузки данных
 */
public class ShowXlsLoadResultsAction
	extends ShowXlsMaxReportAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {

	try{
		super.perform(mapping, form, request, response);
	    ParamsParser.setState(request, Applications.BASESTATION, APPStates.LOADRESULTS);
	    return mapping.findForward("main");
	}catch(Exception ex){
	    ex.printStackTrace(System.out);
	    ActionErrors errors = new ActionErrors();
	    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("xls.error.view"));		
		saveErrors(request, errors);


        ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLS);
        return mapping.findForward("main");
	}
}
}
