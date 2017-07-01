package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.formbean.XlsJournalForm;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.persistence.*;
import java.util.Enumeration;
import java.util.ArrayList;
import java.lang.reflect.*;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
//import com.hps.july.security.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.basestation.APPStates;
import org.apache.struts.util.MessageResources;

/**
 * Обработчик журнала загрузки данных
 */
public class ShowXlsJournalAction extends com.hps.july.web.util.BrowseAction {
private boolean checkForm(ActionForm form, HttpServletRequest request)
{
	XlsJournalForm f = (XlsJournalForm)form;
	String key_ses = f.getKey_ses();

	ActionErrors errors = new ActionErrors();
	
	if(f.getIsImpsesid().equals(Boolean.TRUE)) {
		try{
			new Integer(key_ses);
		} catch(Exception ex){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("xls.error.sessionid", key_ses));
		}
	}

	if(!errors.empty()){
		saveErrors(request, errors);
		return false;
	}
	return true;
	
}
	public String getBrowseBeanName() {
		return "com.hps.july.persistence.ImportSessionAccessBean";
	}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
	if(!checkForm(form, request)) {
		navigate(mapping,form,request,response);
	    request.setAttribute( "browseList", new Object[]{} );
	    request.setAttribute( "numberOfPages", new Integer(0) );	
	} else {
		Integer task = (Integer)request.getSession().getAttribute("task");
		XlsJournalForm f = (XlsJournalForm)form;
		f.setTaskid(task);
		super.perform(mapping, form, request, response);		
    }
   
    ParamsParser.setState(request, Applications.BASESTATION, APPStates.XLSLOADJOURNAL);
    return mapping.findForward("main");

}
}
