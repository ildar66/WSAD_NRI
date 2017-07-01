package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

import com.hps.july.basestation.formbean.FreqLicenceHistoryListForm;

/**
 * Обработчик формы списка частотных разрешений
 */
public class ShowFreqLicenceHistoryListAction
	extends com.hps.july.web.util.BrowseAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	super.perform(mapping, form, request, response);
  	ParamsParser.setState(request, Applications.BASESTATION, APPStates.FREQLICENCE_HIST);
	return mapping.findForward("main");
}
}
