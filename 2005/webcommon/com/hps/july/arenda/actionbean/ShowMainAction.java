package com.hps.july.arenda.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.arenda.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.arenda.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Action-class.
 * Действие для "main".
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowMainAction extends com.hps.july.web.util.NavigatedAction {
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return false;
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
	  	ParamsParser.setState(request, Applications.ARENDA, APPStates.MAIN);
	  	setCurRegion(request);
		return mapping.findForward("main");
	}
/**
 * Insert the method's description here.
 * Creation date: (22.11.2005 16:17:31)
 */
private void setCurRegion(HttpServletRequest request) {
    String curRegID = request.getParameter("curRegID");
    if (curRegID != null) {
        Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
        boolean ok = profile.getProfileAccess().setCurrRegionID(new Integer(curRegID));
        if (!ok)
            System.out.println("Текущий регион с curRegID=" + curRegID + " не установлен");
    }
}
}
