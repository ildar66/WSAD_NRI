package com.hps.july.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;

import com.hps.july.constants.Applications;

/**
 * @author dimitry
 * Created 28.04.2006
 */
public class JulyNavigateTool {

	public final static String CLEAR_NAVIGATOR = "navclear";
	public final static String ROOT_APP = "rootapp";
	public final static String ROOT_STATE = "rootstate";
	
	/**
	 * Модули, которые будут участвовать в схеме автоматической навигации страниц
	 */
	public static boolean isNavigateModule(int app) {
		return 
			(app == Applications.BASESTATION) ||
			(app == Applications.ORGANIZER) ||
			(app == Applications.PROJECT) ||
			(app == Applications.SITEDOC) ||
			(app == Applications.SITEINFO) ||
			(app == Applications.ARENDA) ||
			(app == Applications.INVENTORY) ||
			(app == Applications.DICTIONARY);
	}

	/**
	 * Основной метод, производящий автоматическое добавление страниц а навигатор
	 * 
	 * @param mapping - ActionMapping
	 * @param request - HttpServletRequest
	 * @param actionServlet - ActionServlet
	 * <br>
	 * isReturnable set to true - Признак возврата на текущий режим. <br>
	 * isAddtoHistory set to true - Shows if to add current URL to history.
	 */
	public static void executeNavigate(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, 
    		ActionServlet actionServlet) {
    	executeNavigate(mapping, actionForm, request, actionServlet, true, true);
    }
	
	/**
	 * Основной метод, производящий автоматическое добавление страниц а навигатор
	 * 
	 * @param mapping - ActionMapping
	 * @param request - HttpServletRequest
	 * @param actionServlet - ActionServlet
	 * @param isReturnable - Признак возврата на текущий режим.
	 * @param isAddtoHistory - Shows if to add current URL to history.
	 */
    public static void executeNavigate(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, 
    		ActionServlet actionServlet, boolean isReturnable, boolean isAddtoHistory) {
	
		JulyProfileTool.executeProfiling(mapping, actionForm, request);
	
		//save current url
		StringBuffer url = new StringBuffer();
		url.append(request.getScheme()).append("://");
		url.append(request.getServerName()).append(":").append(request.getServerPort());
		url.append(request.getContextPath());
		url.append(mapping.getPath()).append(".do");
	
		String query = request.getQueryString();
		if(query != null) url.append("?").append(query);
		url = new StringBuffer(java.net.URLEncoder.encode(url.toString()));
	
		HttpSession session = request.getSession();
		if(session != null) {
			session.setAttribute(Constants.CURRENT_URL, url.toString());
		}
	
		// Temproraly exclude some applications from navigation
		boolean include = false;
		try {
			String app = request.getContextPath();
			
			if ( (app.indexOf("basestation") > 0) || (app.indexOf("project") > 0) ||
				(app.indexOf("sitedoc") > 0) || (app.indexOf("siteinfo") > 0) || 
				(app.indexOf("arenda") > 0) || (app.indexOf("dict") > 0) ||
				(app.indexOf("inventory") > 0))
			
					include = true;
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	
		if (include) {
				// Call navigator
				navigate(mapping, request, actionServlet, isReturnable, isAddtoHistory);
		}
    }

//    private static void navigate(ActionMapping mapping, HttpServletRequest request, 
//    		ActionServlet actionServlet) {
//    	navigate(mapping, request, actionServlet, true, true);
//    }
    
    /**
     * Основной метод, производящий автоматическое добавление страниц а навигатор
     */
    public static void navigate(ActionMapping mapping, HttpServletRequest request, 
    		ActionServlet actionServlet, boolean isReturnable, boolean isAddtoHistory) {
	
		// Get navigator object
		StateNavigator nav = (StateNavigator)request.getSession().getAttribute(StateNavigator.NAVIGATOR_PARAM);
		if (nav == null) {
			nav = new StateNavigator();
			request.getSession().setAttribute(StateNavigator.NAVIGATOR_PARAM, nav);
		}
	
		// Check for clear request
		if (request.getParameter(CLEAR_NAVIGATOR) != null) {
			nav.clear();
		}
	
		// Add current url to navigator history
		if (isAddtoHistory) {
			nav.add(mapping, actionServlet, request, isReturnable);
		}
			
		// Check for root app set request
		String srootapp = request.getParameter(ROOT_APP);
		if (srootapp != null) {
			ParamsParser.setRootApp(request, srootapp);
		}
		
		// Check for root state set request
		String srootstate = request.getParameter(ROOT_STATE);
		if (srootstate != null) {
			ParamsParser.setRootState(request, srootstate);
		}
    }

	
}
