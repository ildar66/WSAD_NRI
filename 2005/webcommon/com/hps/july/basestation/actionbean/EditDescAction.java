package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.formbean.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик редактирования эксплуатационных характеристик коммутатора и контроллера
 */
public class EditDescAction
	extends com.hps.july.web.util.AbstractEditAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	navigate(mapping,form,request,response);
	EditForm editForm = (EditForm)form;
	if (editForm != null) {
	    String action = editForm.getAction();
	    if("Add".equals(action) || "Edit".equals(action) || "Delete".equals(action)) {
		    return super.perform(mapping,form,request,response);
	    } else {
		    editForm.setReturnPage("");
		    if (mapping.findForward("errorgoback") != null) {
			    editForm.setReturnPage(mapping.findForward("errorgoback").getPath());
		    }
		    
			try {
				editForm.initCollections(request);
			} catch (Exception e) {
				ActionErrors errors = new ActionErrors();
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
				saveErrors(request, errors);
				return mapping.findForward("errorgoback");
			}
			
			try {
				AbstractEntityAccessBean bean = editForm.getDataBean(request);
				if (bean != null) {
					com.hps.july.util.BeanUtils.copyProperties(editForm, bean);
					editForm.fillRecord(bean);
				}
		    	ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
			} catch (Exception e) {   	
				ActionErrors errors = new ActionErrors();
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.absent"));
				saveErrors(request, errors);
				return mapping.findForward( "errorgoback" ); 
			}
	    }
    } else {
	    ActionErrors errors = new ActionErrors();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
 	  	saveErrors(request, errors);
		return mapping.findForward("errorgoback");
    }
	return mapping.findForward("main");
}
}
