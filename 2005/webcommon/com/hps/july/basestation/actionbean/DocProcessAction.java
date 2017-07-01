package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.formbean.DocForm;
import com.hps.july.basestation.formbean.SitedocFileForm;
import com.hps.july.web.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

/**
 * Базовый класс для обработчиков форм документов
 */
public class DocProcessAction
	extends com.hps.july.web.util.FormProcessAction
{
public ActionForward processUpdate(ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) 
	throws Exception
{
	if(editForm instanceof DocForm) {
		DocForm fform = (DocForm)editForm;
		if("selected".equals(request.getParameter("delfiles"))) {
			fform.deleteSelected();
			ParamsParser.setState(request,editForm.getApplication(),editForm.getState());
			return mapping.findForward("main");
		}
	}
	return super.processUpdate(mapping, request, errors, editForm);
}
}
