package com.hps.july.organizer.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.organizer.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;


/**
 * ѕоказ режима перерегистрации в системе.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowReregisterAction extends org.apache.struts.action.Action {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform( mapping, form, request, response );
	  	ParamsParser.setState( request, Applications.ORGANIZER, APPStates.REREGISTER );
		Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
		ProcessProfile pp = new ProcessProfile();
		if(profile != null) {
			if(profile.getLogin() == null) profile.setLogin(request);
			//update profile
			pp.updateProfile(profile);
		}
		return mapping.findForward( "main" );
	}
}
