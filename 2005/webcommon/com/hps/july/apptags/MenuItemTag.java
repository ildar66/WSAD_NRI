package com.hps.july.apptags;

import javax.servlet.http.*;
import javax.servlet.jsp.JspException;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * “аг пункта меню с проверкой прав доступа.
 * Creation date: (09.02.2003 19:47:22)
 * @author: Alexander Shrago
 */
public class MenuItemTag extends com.hps.july.taglib.MenuItemTag implements DefaultAccessCheck {
    private String file = FILE;
    private String checkAccess = CHECK;
    private boolean hasAccess = false;
/**
 * MehuItemTag constructor comment.
 */
public MenuItemTag() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2003 22:23:23)
 * @return java.lang.String
 */
private String checkingAction() {
    String url = getAction();
    int i = 0;
    if (!getFile().equals(FILE)) {
        while (url.indexOf("/") != -1) {
            i = url.indexOf("/");
            url = url.substring(i + 1);
        }
    }
    if (url.indexOf("?") != -1) {
        i = url.indexOf("?");
        url = url.substring(0, i);
    }

    
    return url;
}
public int doEndTag() throws JspException {
    if (!new Boolean(checkAccess).booleanValue())
        return super.doEndTag();
    else {

        if (hasAccess)
            return super.doEndTag();

        else
            return SKIP_BODY;
    }
}
public int doStartTag() throws JspException {
    if (!new Boolean(checkAccess).booleanValue())
        return super.doStartTag();
    else {
        javax.servlet.http.HttpServletRequest request =
            (HttpServletRequest) pageContext.getRequest();
        //DebugSupport.printlnTest("file before=" + file);
        file = pageContext.getServletContext().getRealPath(file);
        //DebugSupport.printlnTest("file after=" + file);

        HasAccessBean parser = new HasAccessBean();
        try {
            
            hasAccess = parser.hasAccess(request, "/" + checkingAction(), file);
            DebugSupport.printlnTest("action=" + getAction() + " hasAccess=" + hasAccess+" file="+file);
        } catch (Exception ex) {
            throw new JspException(ex.getMessage());
        }

        if (hasAccess)
            return super.doStartTag();

        else
            return SKIP_BODY;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (09.02.2003 20:28:06)
 * @return java.lang.String
 */
public java.lang.String getCheckAccess() {
	return checkAccess;
}
public java.lang.String getFile() {
        return file;
    }
/**
 * Insert the method's description here.
 * Creation date: (09.02.2003 20:28:06)
 * @param newCheckAccess java.lang.String
 */
public void setCheckAccess(java.lang.String newCheckAccess) {
	checkAccess = newCheckAccess;
}
    public void setFile(java.lang.String newFileName) {
        file = newFileName;
    }
}
