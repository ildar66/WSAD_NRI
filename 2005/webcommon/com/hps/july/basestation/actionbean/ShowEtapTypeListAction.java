package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.formbean.*;
import com.hps.july.basestation.formbean.GKRCHDocsListForm;
import com.hps.july.basestation.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * ���������� ����� ������ ����� ������ ��� ��������� ����������
 */
public class ShowEtapTypeListAction
	extends com.hps.july.web.util.BrowseAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	EtapTypeListForm f = (EtapTypeListForm)form;
	super.perform(mapping, form, request, response);
  	ParamsParser.setState(request, Applications.BASESTATION, APPStates.ETAPTYPE_LIST);
	return mapping.findForward("main");
}
}
