package com.hps.july.web.util;

import javax.servlet.http.HttpServletRequest;
/**
 * Вспомогательный класс для работы с текущим состоянием приложения.
 * Creation date: (16.01.2002 14:33:34)
 * @author: Administrator
 */
public class ParamsParser {
	public final static java.lang.String APPLICATION_PARAM_NAME = "CURRENT_APPLICATION";
	public final static java.lang.String STATE_PARAM_NAME = "CURRENT_STATE";
	public final static java.lang.String ROOTAPP_PARAM_NAME = "ROOT_APPLICATION";
	public final static java.lang.String ROOTSTATE_PARAM_NAME = "ROOT_STATE";
/**
 * ParamsParser constructor.
 */
private ParamsParser() {
	super();
}
/**
 * Получает текущее приложение.
 * Creation date: (16.01.2002 14:37:01)
 * @return int
 * @param context javax.servlet.jsp.PageContext
 */
public static int getApplication(javax.servlet.jsp.PageContext context) {
	return Integer.parseInt( (String)context.getRequest().getAttribute( APPLICATION_PARAM_NAME ) );
}

/**
 * Получает исходное приложение (при переходе между приложениями).
 * Creation date: (16.01.2002 14:37:01)
 * @return int
 * @param context javax.servlet.jsp.PageContext
 */
public static int getRootApp(javax.servlet.http.HttpSession session) {

	int rootApp = 0;

	try {
		rootApp =  Integer.parseInt( (String) session.getAttribute( ROOTAPP_PARAM_NAME ) );
	} catch (Exception e) {
		// Root app not found - assuming 0
		//e.printStackTrace(System.out);
	}
	
	return rootApp;
}

/**
 * Получает исходное приложение (при переходе между приложениями).
 * Creation date: (16.01.2002 14:37:01)
 * @return int
 * @param context javax.servlet.jsp.PageContext
 */
public static int getRootApp(javax.servlet.jsp.PageContext context) {

	int rootApp = getRootApp( context.getSession() );
	return rootApp;
}

/**
 * Получает исходное состояние приложения (при переходе между приложениями).
 * Creation date: (16.01.2002 14:37:01)
 * @return int
 * @param context javax.servlet.jsp.PageContext
 */
public static int getRootState(javax.servlet.http.HttpSession session) {

	int rootState = 0;

	try {
		rootState = Integer.parseInt( (String)session.getAttribute( ROOTSTATE_PARAM_NAME ) );
	} catch (Exception e) {
		// No root state - assuming 0
		//e.printStackTrace(System.out);
	}
	
	return rootState;
}
/**
 * Получает исходное состояние приложения (при переходе между приложениями).
 * Creation date: (16.01.2002 14:37:01)
 * @return int
 * @param context javax.servlet.jsp.PageContext
 */
public static int getRootState(javax.servlet.jsp.PageContext context) {

	int rootState = getRootState( context.getSession() );
	return rootState;
}
/**
 * Получает текущее состояние приложения.
 * Creation date: (16.01.2002 14:37:01)
 * @return int
 * @param context javax.servlet.jsp.PageContext
 */
public static int getState(javax.servlet.jsp.PageContext context) {
	return Integer.parseInt( (String)context.getRequest().getAttribute( STATE_PARAM_NAME ) );
}
/**
 * Устанавливает исходное приложение (при переходе между приложениями).
 * Creation date: (16.01.2002 14:46:09)
 * @param application String
 */
public static void setRootApp( HttpServletRequest request, String application ) {
	request.getSession().setAttribute( ROOTAPP_PARAM_NAME, application );
}
/**
 * Устанавливает исходное состояние приложения (при переходе между приложениями).
 * Creation date: (16.01.2002 14:46:09)
 * @param state String
 */
public static void setRootState( HttpServletRequest request, String state ) {
	request.getSession().setAttribute(ROOTSTATE_PARAM_NAME, state);
}
/**
 * Устанавливает текущее состояние приложения.
 * Creation date: (16.01.2002 14:46:09)
 * @param application int
 * @param state int
 */
public static void setState( HttpServletRequest request, int application, int state ) {
	request.setAttribute( STATE_PARAM_NAME, String.valueOf( state ) );
	request.setAttribute( APPLICATION_PARAM_NAME, String.valueOf( application ) );
	}
}
