package com.hps.july.project;

import java.util.*;
import com.hps.july.persistence.*;
import javax.servlet.http.*;

/**
 * Утилитарный класс. Работа с cookie.
 * Creation date: (29.11.2002 19:42:37)
 * @author: Administrator
 */
public class Util_Alex {
    public final static boolean isDebug = false;
    public final static String DATE_FORMAT="dd.MM.yyyy";
/**
 * Util_Alex constructor comment.
 */
public Util_Alex() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (19.03.2002 12:11:03)
 * @return java.lang.String
 * @param str java.lang.String
 */
public static String convertString(Object ob) {
    try {
        String str = ob.toString();
        if(!isDebug) return str;
        
        //String cMessage = new String(str.getBytes("Cp1251"));
        //String cMessage = new String(str.getBytes("ISO-8859-1"));
        //String cMessage =  new String(str.getBytes(),"Cp1251");//!!!!!!!!!!!!!!!!!!!!!!!
        //String cMessage =  new String(str.getBytes("ISO-8859-1"),"Cp1251");
        //String cMessage =  new String(str.getBytes("ISO-8859-5"),"Cp1251");
        String cMessage = new String(str.getBytes("ISO-8859-1"));
        //String cMessage = new String(str.getBytes("windows-1251"),"UTF-8");
        //System.out.println("str =" + str);
        //System.out.println("str.length =" + str.length());
        //System.out.println("cMessage =" + cMessage);
        //System.out.println("cMessage.length =" + cMessage.length());
        //return str;
        return cMessage.length() == 0 ? str : cMessage;
        //Изменить
        //Финансовый план

        //Список белых билетов по статье        

    } catch (Exception e) {

        System.out.println(e);
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (25.12.2002 11:23:40)
 * @return boolean
 * @param name java.lang.String
 */
public static void createCookie(
	    String name,
	    String value,
	    HttpServletRequest request,
	    HttpServletResponse response) {
	    
    Cookie cookie = new Cookie(name, "true");
    cookie.setMaxAge(31536000);  // 60 * 60 * 24 * 365
    cookie.setValue(value);
    response.addCookie(cookie);
}
/**
 * Insert the method's description here.
 * Creation date: (25.12.2002 11:23:40)
 * @return boolean
 * @param name java.lang.String
 */
public static void createCookie(
	    String name,
	    HttpServletRequest request,
	    HttpServletResponse response) {
		    
    Cookie cookie = new Cookie(name, "true");
    cookie.setMaxAge(31536000); // 60 * 60 * 24 * 365
    response.addCookie(cookie);
}
/**
 * Insert the method's description here.
 * Creation date: (25.12.2002 11:23:40)
 * @return boolean
 * @param name java.lang.String
 */
public static void deleteCookie(
    String name,
    HttpServletRequest request,
    HttpServletResponse response) {

    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals(name)) {
            cookies[i].setValue("false");
            cookies[i].setMaxAge(0);
            response.addCookie(cookies[i]);
            break;
        }

    }
    return;
}
/**
 * Insert the method's description here.
 * Creation date: (02.01.2003 20:16:17)
 * @return java.util.Vector
 */
public Vector enumToVector() {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (02.01.2003 20:16:17)
 * @return java.util.Vector
 */
public static Vector enumToVector(Enumeration enum) {
    Vector vec = new Vector();
    while (enum.hasMoreElements())
        vec.add(enum.nextElement());

    return vec;
}
/**
 * Insert the method's description here.
 * Creation date: (25.12.2002 11:23:40)
 * @return boolean
 * @param name java.lang.String
 */
public static String getCookie(
    Object name,
    javax.servlet.http.HttpServletRequest request) {
	    
    javax.servlet.http.Cookie[] cookies = request.getCookies();
     for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals(name))
            return cookies[i].getValue();
    }

    return "";
}
/**
 * Insert the method's description here.
 * Creation date: (25.12.2002 11:23:40)
 * @return boolean
 * @param name java.lang.String
 */
public static boolean hasParam(
    String name,
    String paramStr) {

	StringTokenizer st = new StringTokenizer(paramStr, "&");

	while (st.hasMoreTokens()) {
		String tok = st.nextToken();
		if (tok.indexOf(name) == 0) {
			// String found
			return true;
		}
    }

    return false;
}
public static boolean isUserInDivision(
    int division,
    javax.servlet.http.HttpServletRequest request)
    throws Exception {

    if (request.getRemoteHost().equals("127.0.0.1"))
        return true;
	    
	    
	    String login = request.getRemoteUser();
    System.out.println("isUser " + login + " InDivision " + division + " ?");
    OperatorAccessBean operator = new OperatorAccessBean().findByLogin(login);
    try {
        Enumeration enum =
            new WorkerAccessBean().findWorkersByMan(operator.getManKey());
        if (enum == null)
            throw new javax.ejb.FinderException();
        while (enum.hasMoreElements()) {
            if (((WorkerAccessBean) enum.nextElement()).getDivisionKey().division
                == division) {
                System.out.println("isUserInDivision " + division + " ?");
                System.out.println("true");
                return true;
            }
        }
        System.out.println("false");
        return false;
    } catch (javax.ejb.FinderException e) {
        System.out.println("user " + login + " not find");
        return false;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 14:06:54)
 * @return boolean
 */
public static boolean isUserInSecurity(
    String[] security,
    javax.servlet.http.HttpServletRequest request) {
System.out.println("isUserInSecurity  request.toString() "+request.toString());	    
System.out.println("request.getRemoteUser() "+request.getRemoteUser());
System.out.println("request.getAuthType() "+request.getAuthType());
System.out.println("request.getUserPrincipal() "+request.getUserPrincipal());
    if (request.getRemoteHost().equals("127.0.0.1"))
        return true;
/* 
    if (!com.hps.july.web.util.Constants.CHECK_ROLES ||) {
        System.out.print("check roles " + com.hps.july.web.util.Constants.CHECK_ROLES);
        return true;
    }
*/
    for (int i = 0; i < security.length; i++) {
        System.out.print("request.isUserInRole " + security[i] + "?");
        if (request.isUserInRole(security[i])) {
            System.out.println("role " + security[i] + " true");
            return true;
        }
    System.out.println(" false");
        }
    
    return false;
}
public static void pr(Exception ex, String methodName,Object thisObject) {
	System.out.println(new java.util.Date());
	System.out.println(ex.getClass().getName() + "in " + thisObject.getClass().getName() +"."+ methodName + 
		". Message is:" + ex.getMessage());
	System.err.println(ex.getClass().getName() + "in " + thisObject.getClass().getName() +"."+ methodName + 
		". Message is:" + ex.getMessage());
}
public static void pr(Exception ex, String methodName,String className) {
	System.out.println(new java.util.Date());
	System.out.println(ex.getClass().getName() + "in " + className +"."+ methodName + 
		". Message is: " + ex.getMessage());
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 14:50:45)
 * @return java.lang.String
 * @param State java.lang.String
 */
public static String projectStateNameKey(String state) {
	return "label.projectstate."+state;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 22:34:32)
 * @return java.lang.String
 * @param date java.sql.Date
 */
public static String sqlDateToString(java.sql.Date date) {
    if (date == null)
        return "";
    else
        return new java.text.SimpleDateFormat(DATE_FORMAT).format(
            new Date(date.getTime()));
}
}
