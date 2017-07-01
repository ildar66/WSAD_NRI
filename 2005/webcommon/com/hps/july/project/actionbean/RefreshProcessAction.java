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
 * —тандартна€ обработка данных формы с выставлением флага автоматического обновлени€.
 * Creation date: (09.01.2004 11:39:13)
 * @author: Dmitry Dneprov
 */
public class RefreshProcessAction extends com.hps.july.web.util.AbstractProcessAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// Update Refresh counter from application
		com.hps.july.project.valueobject.RefreshCounter.markRefreshNeeded(getServlet().getServletContext());
		
	    return super.perform(mapping, form, request, response);    
	}
}
