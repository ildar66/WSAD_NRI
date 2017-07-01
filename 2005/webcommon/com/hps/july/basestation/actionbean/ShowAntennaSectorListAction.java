package com.hps.july.basestation.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.basestation.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.basestation.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик списка антенн сектора
 */
public class ShowAntennaSectorListAction
	extends NavigatedAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	super.perform(mapping, form, request, response);
	ParamsParser.setState(request, Applications.BASESTATION, APPStates.BS_EQ_LIST);

	AntennaSectorListForm eForm = (AntennaSectorListForm) form;
	FactBaseStationForm bsForm =
		(FactBaseStationForm) request.getSession().getAttribute("FactBaseStationForm");

	eForm.setBsForm(bsForm);
//	request.setAttribute("sectors",eForm.findSectors());
//	request.setAttribute("antennes",eForm.findAntennes());

	return mapping.findForward("main");
}
}
