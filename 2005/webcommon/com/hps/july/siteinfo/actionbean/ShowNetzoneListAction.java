package com.hps.july.siteinfo.actionbean;

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

/**
 * Обработчик списка зон сети
 */
public class ShowNetzoneListAction extends com.hps.july.web.util.BrowseAction {
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.persistence.NetZoneAccessBean";
	return "com.hps.july.cdbc.objects.CDBCRegionsObject";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	NetzoneListForm nzf = (NetzoneListForm)form;
	nzf.setRequestData(request);
	super.perform( mapping, form, request, response );

	HttpSession session = request.getSession();
	session.setAttribute("mapState", "0");
	session.setAttribute("mapbyPositionState", "0");
	
  	ParamsParser.setState( request, Applications.SITEINFO, APPStates.NZONELIST );
	return mapping.findForward( "main" );
}
}
