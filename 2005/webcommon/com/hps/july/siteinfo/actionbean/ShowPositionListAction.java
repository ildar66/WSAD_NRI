package com.hps.july.siteinfo.actionbean;

import java.lang.reflect.*;
import java.util.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.siteinfo.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.siteinfo.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик списка позиций
 */
public class ShowPositionListAction extends BrowsePageAction {
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.siteinfo.valueobject.Position";
	return "com.hps.july.cdbc.objects.CDBCPositionObject";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	PositionListForm pForm=(PositionListForm)form;
	pForm.setRequestData(request);
	super.perform( mapping, form, request, response );

	HttpSession session = request.getSession();
	session.setAttribute("mapState", "0");
	session.setAttribute("mapbyPositionState", "0");

	String showOnMap = request.getParameter("onMap.x");
	if(showOnMap != null && Integer.parseInt(showOnMap) != 0) {
		//ActionForward forw = mapping.findForward("SuitableMaps");
		//String path = forw.getPath()+"?posAndRegs=" + pForm.getPosAndRegs();
		//forw.setPath(path);
		//return forw;
	}
	ParamsParser.setState( request, Applications.SITEINFO, APPStates.POSLIST );

	return mapping.findForward("main");
}
}
