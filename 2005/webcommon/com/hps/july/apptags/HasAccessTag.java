package com.hps.july.apptags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.http.*;
import javax.servlet.jsp.JspException;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Таг для определения возможности доступа к URL по правам в web.xml, используется при проверке прав доступа.
 * Creation date: (09.02.2003 19:49:45)
 * @author: Alexander Shrago
 */
public class HasAccessTag extends TagSupport implements DefaultAccessCheck {
    private String file;
    private String href;
    
/**
 * Insert the method's description here.
 * Creation date: (27.06.2003 22:23:23)
 * @return java.lang.String
 */
private String checkingAction() {
    String url = getHref();
    int i = 0;
    
    if (url.indexOf("?") != -1) {
        i = url.indexOf("?");
        url = url.substring(0, i);
    }

    
    return url;
}
public int doStartTag() throws JspException {

    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    file = (file == null ? FILE : file);
    file = pageContext.getServletContext().getRealPath(file);

    HasAccessBean parser = new HasAccessBean();
    boolean hasAccess;

    try {
        DebugSupport.printlnTest("HasAccessTag doStartTag() started href=" + href+" file="+file);
        hasAccess = !com.hps.july.web.util.Constants.CHECK_ROLES || parser.hasAccess(request, checkingAction(), file);
        DebugSupport.printlnTest("HasAccessTag doStartTag() finished hasAccess=" + hasAccess);
    } catch (Exception ex) {
        throw new JspException(ex.getMessage());
    }

    if (hasAccess)
        return EVAL_BODY_INCLUDE;

    else
        return SKIP_BODY;
}
    public java.lang.String getFile() {
        return file;
    }
    public java.lang.String getHref() {
        return href;
    }
public static boolean hasAccess(
    javax.servlet.jsp.PageContext pageContext,
    String href)
    throws Exception {

    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    String file = pageContext.getServletContext().getRealPath(FILE);

    HasAccessBean parser = new HasAccessBean();
    boolean hasAccess;

    try {
        DebugSupport.printlnTest("HasAccessTag doStartTag() started href=" + href);
        hasAccess =
            !com.hps.july.web.util.Constants.CHECK_ROLES
                || parser.hasAccess(request, href, file);
        DebugSupport.printlnTest(
            "HasAccessTag doStartTag() finished hasAccess=" + hasAccess);
        return hasAccess;
    } catch (Exception ex) {
        throw new JspException(ex.getMessage());
    }

}
    public void setFile(java.lang.String newFileName) {
        file = newFileName;
    }
    public void setHref(java.lang.String newUrl) {
        href = newUrl;
    }
}
