package com.hps.july.project.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;

/**
 * Быстрое сохранение события план-графика.
 * Creation date: (14.11.2003 19:41:22)
 * @author: Dmitry Dneprov
 */
public class ProcessProjectFAction extends com.hps.july.web.util.AbstractProcessAction {
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return false;
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// Update Refresh counter from application
		com.hps.july.project.valueobject.RefreshCounter.markRefreshNeeded(getServlet().getServletContext());
		
		super.perform(mapping, form, request, response);
		return mapping.findForward( "success" ); 
	}
}
