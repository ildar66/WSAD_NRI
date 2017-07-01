package com.hps.july.web.util;

import java.util.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Автоматический навигатор страниц.
 * Creation date: (07.10.2003 17:42:31)
 * @author: Dmitry Dneprov
 */
public class StateNavigator {
	public final static String NAVIGATOR_PARAM = "StateNavigator";
	private ArrayList navlist;
	StateNavigatorObject prevstate;
/**
 * StateNavigator constructor.
 */
public StateNavigator() {
	super();
	navlist = new ArrayList();
	prevstate=null;
}
/**
 * Добавление страницы в навигатор.
 * Creation date: (07.10.2003 17:47:08)
 * @param mapping org.apache.struts.action.ActionMapping
 */
public void add(ActionMapping mapping, ActionServlet servlet, HttpServletRequest request, boolean returnable) {

	//System.out.println("NAVIGATOR: #1");
	// Create current navigator object
	StateNavigatorObject stobj = new StateNavigatorObject();
	stobj.setContext(request.getContextPath());
	stobj.setUrl(mapping.getPath());
	stobj.setParams(request.getQueryString());
	stobj.setReturnable(returnable);
	String messagekey = "navtitle." + stobj.getUrl().substring(1, stobj.getUrl().length());
	String aname = servlet.getResources().getMessage(messagekey);
	if (aname != null)
		stobj.setName( aname );
	else
		stobj.setName( stobj.getUrl() );

	//System.out.println("NAVIGATOR: #2, url='" + stobj.getUrl() + "', params='" + stobj.getParams() + 
	//	"', messagekey='" + messagekey + "', message='" + stobj.getName() + "', " +
	//	"context='" + stobj.getContext() + "'");

	// Find navigator object in history & recreate navigation list
	ArrayList newnav = new ArrayList();
	prevstate = null; // Will be recalculated in cycle
	ListIterator it = navlist.listIterator();
	while (it.hasNext()) {
		StateNavigatorObject curobj = (StateNavigatorObject)it.next();
		if (curobj.getUrl().equals(stobj.getUrl()))
			break;
		if (curobj.isReturnable())
			prevstate = curobj;
		newnav.add(curobj);
	}
	newnav.add(stobj);
	navlist = newnav;

	// Check if return params were specified
	String sParam = request.getParameter("retparams");
	int c = -1;
	//System.out.println("NAVIGATOR: #3, retparams=" + sParam);
	if (sParam != null) {
		// Return params found - extract from brackets
		sParam = sParam.substring(1);
		sParam = sParam.substring(0, sParam.length()-1);
		c = sParam.indexOf("#");
		// Return params found - replace them in prevstate
		if (prevstate != null)
			prevstate.setParams(sParam);
		//System.out.println("NAVIGATOR: #3, replacing params, new params=" + sParam);
	}
	//add to provide selectedList on the return page //vg
	if(c == -1) {
		if(prevstate != null) {
			Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
			StringBuffer anchor = new StringBuffer("");
			if(profile != null) {
				String anchorName = profile.getSelectableAnchor(profile.getPreviousURL());
				String paramName = profile.getSelectableParamName(profile.getPreviousURL());
				String value = profile.getSelectableCurrentParameter(profile.getPreviousURL(), paramName);
				anchor.append("#");
				if(anchorName != null && value != null) {
					anchor.append(anchorName);
					anchor.append(value);
				}
				prevstate.setAnchor(anchor.toString());
			}
		}
	}
}
/**
 * Очистка навигатора.
 * Creation date: (07.10.2003 17:44:46)
 */
public void clear() {
	navlist.clear();
	prevstate = null;
}
/**
 * Возвращает итератор по коллекции страниц, сохраненных в навигаторе.
 * Creation date: (07.10.2003 19:18:34)
 * @return java.util.Iterator
 */
public Iterator getNSIterator() {
	return navlist.iterator();
}
/**
 * Возвращает предыдущую страницу, используется для возврата на предыдущий режим.
 * Creation date: (09.10.2003 12:44:16)
 * @return com.hps.july.web.util.StateNavigatorObject
 */
public StateNavigatorObject getPrevState() {
	return prevstate;
}
/**
 * Формирует URL для перехода.
 * Creation date: (09.10.2003 12:51:26)
 * @return java.lang.String
 * @param so com.hps.july.web.util.StateNavigatorObject
 */
public String makeActionUrl(StateNavigatorObject so) {

	String result;
	
	if (so == null) {
		result = "main.do?navclear=1";
	} else {
		result = so.getUrl().substring(1, so.getUrl().length());
		if(so.isStruts()) result += ".do";
		int c = -1;
		if (so.getParams() != null) {
			result = result + "?" + so.getParams();
			c = so.getParams().indexOf("#");
		}
		if(so.getAnchor() != null && c == -1) {
			result = result + so.getAnchor();
		}
	}
	return result;
}
/**
 * Формирует URL для перехода.
 * Creation date: (09.10.2003 12:51:26)
 * @return java.lang.String
 * @param so com.hps.july.web.util.StateNavigatorObject
 */
public String makeLinkUrl(StateNavigatorObject so) {

	String result;
	
	if (so == null) {
		result = "main.do?navclear=1";
	} else {
		result = so.getContext() + so.getUrl();
		if(so.isStruts()) result += ".do";
		int c = -1;
		if (so.getParams() != null) {
			result = result + "?" + so.getParams();
			c = so.getParams().indexOf("#");
		}
		if(so.getAnchor() != null && c == -1) {
			result = result + so.getAnchor();
		}
	}
	return result;
}

	/**
	 * Insert the method's description here.
	 * Creation date: (21.10.2004 15:34:21)
	 * @param sno com.hps.july.web.util.StateNavigatorObject
	 */
	public void add(StateNavigatorObject stobj) {
		// Find navigator object in history & recreate navigation list
		ArrayList newnav = new ArrayList();
		prevstate = null; // Will be recalculated in cycle
		ListIterator it = navlist.listIterator();
		while (it.hasNext()) {
			StateNavigatorObject curobj = (StateNavigatorObject)it.next();
			if (curobj.getUrl().equals(stobj.getUrl()))
				break;
			if (curobj.isReturnable())
				prevstate = curobj;
			newnav.add(curobj);
		}
		newnav.add(stobj);
		navlist = newnav;
	}

/**
 * Добавление страницы в навигатор.
 * Creation date: (21.10.2004 12:07:47)
 * @param request javax.servlet.http.HttpServletRequest
 * @param returnable boolean
 */
public void add(HttpServletRequest request, boolean returnable) {

	// Create current navigator object
	StateNavigatorObject stobj = new StateNavigatorObject();
	stobj.setContext(request.getContextPath());
	stobj.setUrl(request.getRequestURI());
	stobj.setParams(request.getQueryString());
	stobj.setReturnable(returnable);
	stobj.setName(stobj.getUrl());

	// Find navigator object in history & recreate navigation list
	ArrayList newnav = new ArrayList();
	prevstate = null; // Will be recalculated in cycle
	ListIterator it = navlist.listIterator();
	while (it.hasNext()) {
		StateNavigatorObject curobj = (StateNavigatorObject)it.next();
		if (curobj.getUrl().equals(stobj.getUrl()))
			break;
		if (curobj.isReturnable())
			prevstate = curobj;
		newnav.add(curobj);
	}
	newnav.add(stobj);
	navlist = newnav;

	// Check if return params were specified
	String sParam = request.getParameter("retparams");
	int c = -1;
	if (sParam != null) {
		// Return params found - extract from brackets
		sParam = sParam.substring(1);
		sParam = sParam.substring(0, sParam.length()-1);
		c = sParam.indexOf("#");
		// Return params found - replace them in prevstate
		if (prevstate != null)
			prevstate.setParams(sParam);
	}
	//add to provide selectedList on the return page //vg
	if(c == -1) {
		if(prevstate != null) {
			Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
			StringBuffer anchor = new StringBuffer("");
			if(profile != null) {
				String anchorName = profile.getSelectableAnchor(profile.getPreviousURL());
				String paramName = profile.getSelectableParamName(profile.getPreviousURL());
				String value = profile.getSelectableCurrentParameter(profile.getPreviousURL(), paramName);
				anchor.append("#");
				if(anchorName != null && value != null) {
					anchor.append(anchorName);
					anchor.append(value);
				}
				prevstate.setAnchor(anchor.toString());
			}
		}
	}
}
}
