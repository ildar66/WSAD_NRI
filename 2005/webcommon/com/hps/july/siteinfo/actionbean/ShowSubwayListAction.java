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
 * Обработчик списка станций метро
 */
public class ShowSubwayListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.siteinfo.formbean.SubwayLookupListForm";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    SubwayLookupListForm f = (SubwayLookupListForm) form;
    String subway = request.getParameter("subway");

    String action = f.getBrowseAction();
    	
    if (subway != null && subway.length() != 0){
    	f.setSubway(subway);
    	super.perform(mapping, form, request, response);
    } else{
	    request.setAttribute( "browseList", new Object[]{} );
	    request.setAttribute( "numberOfPages", new Integer(0) );
    }

    
    ParamsParser.setState(request, Applications.SITEINFO, APPStates.SUBWAY);
    return mapping.findForward("main");
}
}
