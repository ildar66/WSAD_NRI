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
 * Обработчик подробного журнала загрузок
 */
public class ShowXlsMaxReportAction
	extends BrowseAction
{
	public String getBrowseBeanName() {
		return "com.hps.july.persistence.ImportRecordAccessBean";
	}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {

	try{
		int pk = 0;
		try{pk = Integer.parseInt(request.getParameter("impsesid"));}catch(Exception e){}
		if(pk == 0){
	    	try{pk = ((Integer)request.getSession().getAttribute("impsesid")).intValue();}catch(Exception e){}
		}
	    if(pk == 0) throw new Exception("Error in ShowXlsMaxReportAction. int pk = ((Integer)request.getSession().getAttribute('impsesid')).intValue();");

	    XlsMaxReportForm f = (XlsMaxReportForm)form;
		f.setImpsesid(pk);
	    super.perform(mapping, form, request, response);
	    
	    ImportSessionAccessBean ab = new ImportSessionAccessBean();
	    ab.setInitKey_impsesid(pk);
	    ab.refreshCopyHelper();

	    request.setAttribute("minReportForm", ab);
	    
	    ParamsParser.setState(request, Applications.BASESTATION, APPStates.XLSLOADEXTENDEDRESULT);
	    return mapping.findForward("main");
	}catch(Exception ex){
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
