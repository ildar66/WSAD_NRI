package com.hps.july.web.util;

import java.util.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.hps.july.constants.Applications;

/**
 * Action, от которого надо наследоваться чтобы работала автоматическая навигация по страницам.
 * Creation date: (07.10.2003 18:39:31)
 * @author: Dmitry Dneprov
 */
public class NavigatedAction extends ProfileAction {
	public final static String CLEAR_NAVIGATOR = "navclear";
	public final static String ROOT_APP = "rootapp";
	public final static String ROOT_STATE = "rootstate";
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return true;
}
/**
	* Модули, которые будут участвовать в схеме автоматической навигации страниц
*/
public static boolean isNavigateModule(int app) {
	return JulyNavigateTool.isNavigateModule(app);
	
//	return 
//		(app == Applications.BASESTATION) ||
//		(app == Applications.ORGANIZER) ||
//		(app == Applications.PROJECT) ||
//		(app == Applications.SITEDOC) ||
//		(app == Applications.SITEINFO) ||
//		(app == Applications.ARENDA) ||
//		(app == Applications.INVENTORY) ||
//		(app == Applications.DICTIONARY);
}
/**
 * Признак возврата на текущий режим.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isReturnable() {
	return true;
}
    /**
     * Основной метод, производящий автоматическое добавление страниц а навигатор
     */
    public void navigate(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {

    	JulyNavigateTool.navigate(mapping, request, getServlet(), isReturnable(), isAddtoHistory());
    	
//		// Get navigator object
//		StateNavigator nav = (StateNavigator)request.getSession().getAttribute(StateNavigator.NAVIGATOR_PARAM);
//		if (nav == null) {
//			nav = new StateNavigator();
//			request.getSession().setAttribute(StateNavigator.NAVIGATOR_PARAM, nav);
//		}
//
//		// Check for clear request
//		if (request.getParameter(CLEAR_NAVIGATOR) != null) {
//			nav.clear();
//		}
//
//		// Add current url to navigator history
//		if (isAddtoHistory()) {
//			nav.add(mapping, getServlet(), request, isReturnable());
//		}
//			
//		// Check for root app set request
//		String srootapp = request.getParameter(ROOT_APP);
//		if (srootapp != null) {
//			ParamsParser.setRootApp(request, srootapp);
//		}
//		
//		// Check for root state set request
//		String srootstate = request.getParameter(ROOT_STATE);
//		if (srootstate != null) {
//			ParamsParser.setRootState(request, srootstate);
//		}
    }
    /**
     * Основной метод обработки запроса.
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

    	JulyNavigateTool.executeNavigate(mapping, form, request, getServlet(), isReturnable(), isAddtoHistory());
    	
    	return null;
    	
//		super.perform(mapping, form, request, response);
//
//		//save current url
//		StringBuffer url = new StringBuffer();
//		url.append(request.getScheme()).append("://");
//		url.append(request.getServerName()).append(":").append(request.getServerPort());
//		url.append(request.getContextPath());
//		url.append(mapping.getPath()).append(".do");
//		String query = request.getQueryString();
//		if(query != null) url.append("?").append(query);
//		url = new StringBuffer(java.net.URLEncoder.encode(url.toString()));
//
//		HttpSession session = request.getSession();
//		if(session != null) {
//			session.setAttribute(Constants.CURRENT_URL, url.toString());
//		}
//
//		// Temproraly exclude some applications from navigation
//		boolean include = false;
//		try {
//			String app = request.getContextPath();
//			
//			if ( (app.indexOf("basestation") > 0) || (app.indexOf("project") > 0) ||
//				(app.indexOf("sitedoc") > 0) || (app.indexOf("siteinfo") > 0) || 
//				(app.indexOf("arenda") > 0) || (app.indexOf("dict") > 0) ||
//				(app.indexOf("inventory") > 0))
//			
//					include = true;
//			
//		} catch (Exception e) {
//			e.printStackTrace(System.out);
//		}
//
//
//		if (include) {
//		
//				// Call navigator
//				navigate(mapping, form, request, response);
//
//		}
//		
//        return (null);  // Override this method to provide functionality
//
    }
}
