package com.hps.july.organizer.locservlet;

import com.hps.july.web.util.Profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import com.hps.july.web.util.*;


/**
 * Insert the type's description here.
 * Creation date: (16.12.2004 12:53:13)
 * @author: Vadim Glushkov
 */
public class UpdateSystemParamsServlet extends HttpServlet {

	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Profile profile = (Profile)session.getAttribute(Profile.PROFILE);
        String userName = request.getRemoteUser();
        if(profile == null && userName != null) {
            profile = new Profile(userName);
            session.setAttribute(Profile.PROFILE, profile);
        }
        if(profile != null) {
	        profile.addSystemMenuStatus(request);
	        ProcessProfile pp = new ProcessProfile();
	        pp.updateSystemParameters(profile);
        }
		getServletContext().getRequestDispatcher("/organizer/updateSystemParams.jsp").include(request, response);
    }
}
