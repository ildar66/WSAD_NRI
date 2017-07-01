package com.hps.july.web.util;

import java.util.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.hps.july.constants.Applications;

/**
 * Insert the type's description here.
 * Creation date: (13.09.2004 14:31:55)
 * @author: Vadim Glushkov
 */
public class ProfileAction extends org.apache.struts.action.Action {
	/**
	 * Insert the method's description here.
	 * Creation date: (27.09.2004 12:55:38)
	 * @return java.lang.String
	 * @param mapping org.apache.struts.action.ActionMapping
	 * @param form org.apache.struts.action.ActionForm
	 * @param request javax.servlet.http.HttpServletRequest
	 */
	protected String getAnchor(String path, HttpServletRequest request) {
		return JulyProfileTool.getAnchor(path, request);
		
		
// deprecated 		
//		StringBuffer result = null;
//		Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
//		if(profile != null && path != null) {
//			result =  new StringBuffer();
//			String context = request.getContextPath();
//			//System.out.println("--- ["+context+"] ["+path+"]");
//			int i = path.indexOf(".do");
//			String key = null;
//			if(i != -1) {
//				key = context + "/" + path.substring(0, i);
//			} else {
//				key = context + "/" + path;
//			}
//			//System.out.println("--- ["+key+"]");
//			if(key != null) {
//				String anchor = profile.getSelectableAnchor(key);
//				if(anchor != null) {
//					String id = profile.getSelectableCurrentParameter(key, anchor);
//					//System.out.println("---!!!!----- ["+anchor+"] ["+id+"]");
//					if(anchor != null && id != null) {
//						result.append("#");
//						result.append(anchor);
//						result.append(id);
//					}
//				}
//			}
//		}
//		//System.out.println("---!!!!----- ["+((result != null)?result.toString():null)+"]");
//		return (result != null)?result.toString():null;
	}
	
    /**
     * Process the specified HTTP request, and create the corresponding HTTP
     * response (or forward to another web component that will create it).
     * Return an <code>ActionForward</code> instance describing where and how
     * control should be forwarded, or <code>null</code> if the response has
     * already been completed.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param actionForm The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet exception occurs
     */
    public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {

    	JulyProfileTool.executeProfiling(mapping, form, request);    	
    	
    	return null;
    	
//		super.perform(mapping, form, request, response);
//		
//		boolean include = true;
//		try {
//			String app = request.getContextPath();
//			if((app.indexOf("crystalclear") > 0)) include = false;
//		} catch(Exception e) {}
//		
//		if(include) {
//			updateProfile(mapping, form, request, response);
//		}
//        return null;
    }
    
    
///**
// * Insert the method's description here.
// * Creation date: (13.09.2004 14:38:25)
// * @param mapping org.apache.struts.action.ActionMapping
// * @param form org.apache.struts.action.ActionForm
// * @param request javax.servlet.http.HttpServletRequest
// * @param response javax.servlet.http.HttpServletResponse
// */
//private void updateProfile(
//    ActionMapping mapping,
//    ActionForm form,
//    HttpServletRequest request,
//    HttpServletResponse response) {
//
//    Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
//    ProcessProfile pp = new ProcessProfile();
//    String userName = request.getRemoteUser();
//    if (profile == null && userName != null) {
//        profile = new Profile(userName);
//        request.getSession().setAttribute(Profile.PROFILE, profile);
//        //update profile
//        pp.loadProfile(profile);
//    }
//    if (profile != null) {
//        profile.add(mapping, request);
//
//        if (form != null) {
//            String menuItem = request.getParameter(Profile.MENU_ITEM);
//            if (menuItem != null) profile.addSystemMenuItem(menuItem);
//
//            if (form instanceof BrowseForm) {
//                if (((BrowseForm) form).getLastVisited()) {
//                    String url = pp.computeURL(mapping, request);
//                    profile.addSystemLastURL(url);
//                }
//            } else
//                if (form instanceof EditForm) {
//                    if (((EditForm) form).getLastVisited()) {
//                        String url = pp.computeURL(mapping, request);
//                        profile.addSystemLastURL(url);
//                    }
//                }
//        }
//    }
//    //pp.updateProfile(profile); //-- сохранение перенесли на процедуру выхода их системы
//}
}
