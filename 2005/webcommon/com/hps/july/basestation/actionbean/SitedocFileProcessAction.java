package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.formbean.SitedocFileForm;
import com.hps.july.web.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

/**
 * Обработчик загрузки присоединяемых к документу файлов.
 */
public class SitedocFileProcessAction
	extends com.hps.july.web.util.AbstractProcessAction
{
public ActionForward processDelete( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) 
	throws Exception
{
	SitedocFileForm fform = (SitedocFileForm)editForm;
	if("selected".equals(fform.getDelete())) {
		fform.deleteSelected();
		ParamsParser.setState(request,editForm.getApplication(),editForm.getState());
		return mapping.findForward("main");
	} else {
		return super.processDelete( mapping, request, errors, editForm);
	}
}
}
