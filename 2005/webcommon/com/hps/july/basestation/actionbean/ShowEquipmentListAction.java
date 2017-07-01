package com.hps.july.basestation.actionbean;

import java.lang.reflect.*;
import java.util.*;
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
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Базовый обработчик для списков оборудования
 */
public class ShowEquipmentListAction
	extends BrowsePageAction
{
public String getBrowseBeanName() {
	return null;
}
public int getRowsOnPage() {
	return 150;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	EquipmentListForm listForm = (EquipmentListForm) form;
	listForm.prepare(request);
	DebugSupport.printlnTest("ShowEquipmentListAction listForm.getState()" + listForm.getState());
    super.perform(mapping, form, request, response);

    //for map started
	HttpSession session = request.getSession();
	session.setAttribute("mapState", "0");
	session.setAttribute("mapbyPositionState", "0");

	String showOnMap = request.getParameter("onMap.x");
	DebugSupport.printlnTest("!!!!!!ShowEquipmentListAction showOnMap=" + showOnMap);

	DebugSupport.printlnTest("!!!!listForm.mapUrl()="+listForm.mapUrl());
    
	if (showOnMap != null && Integer.parseInt(showOnMap) != 0) {
		ServletContext context = getServlet().getServletContext().getContext("/siteinfo");
		RequestDispatcher dispatcher = context.getRequestDispatcher(listForm.mapUrl());
		dispatcher.forward(request, response);
		return null;
	}

	//map finished

	ParamsParser.setState(request, Applications.BASESTATION, listForm.getState());
    return mapping.findForward("main");
}
}
