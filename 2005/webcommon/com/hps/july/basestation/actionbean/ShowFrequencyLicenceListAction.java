package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

import com.hps.july.basestation.formbean.FrequencyLicenceListForm;

/**
 * ���������� ����� ������ ��������� ����������
 */
public class ShowFrequencyLicenceListAction
	extends com.hps.july.web.util.BrowseAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	FrequencyLicenceListForm f = (FrequencyLicenceListForm)form;
	f.setAdmin(request.isUserInRole("administrator"));
	f.setUsername(request.getRemoteUser());
	super.perform(mapping, form, request, response);
  	ParamsParser.setState(request, Applications.BASESTATION, APPStates.FREQLICENCE_LIST);
  	
	return mapping.findForward("main");
}
}
