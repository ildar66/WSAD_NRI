package com.hps.july.basestation.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;
import com.hps.july.basestation.formbean.*;

/**
 * Обработчик входа в форму редактирования параметров эксплуатационных характеристик
 */
public class ParamsEditAction
	extends NavigatedAction
{
public ActionForward perform(ActionMapping mapping, ActionForm aform, HttpServletRequest request, HttpServletResponse response)
	throws javax.servlet.ServletException, java.io.IOException
{
	navigate(mapping,aform,request,response);
	try {
		ParamsEditForm form = (ParamsEditForm)aform;
		form.setReturnPage("");
		form.setAction("Edit");
		if(mapping.findForward("errorgoback") != null) {
			form.setReturnPage(mapping.findForward("errorgoback").getPath());
		}
		try {
			form.initData(request);
		} catch(Exception e) {
			ActionErrors errors = new ActionErrors();
			if(e.getMessage() != null && e.getMessage().startsWith("error.")) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(e.getMessage()));
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.params.initdata"));
			}
			saveErrors(request, errors);
			return mapping.findForward("errorgoback"); 
		}
  		ParamsParser.setState( request, form.getApplication(), form.getState() );
	} catch(Exception e) {
		e.printStackTrace(System.out);
		ActionErrors errors = new ActionErrors();
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.params.formcast"));
		saveErrors(request, errors);
	}
	return mapping.findForward("main"); 
}
}
