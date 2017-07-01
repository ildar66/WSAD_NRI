package com.hps.july.apptags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.http.*;
import javax.servlet.jsp.JspException;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Таг для определения невозможности доступа к URL по правам в web.xml, 
 используется при проверке прав доступа. Обратный к тагу HasAccessBean
 * Creation date: (09.02.2003 19:49:45)
 * @author: Alexander Shrago
 */
public class HasNotAccessTag extends HasAccessTag {
    
    
    
public int doStartTag() throws JspException {

    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    setFile(getFile() == null ? FILE : getFile());
    setFile(pageContext.getServletContext().getRealPath(getFile()));

    HasAccessBean parser = new HasAccessBean();
    boolean hasAccess;

    try {
        DebugSupport.printlnTest("HasAccessTag doStartTag() started href=" + getHref());
        hasAccess =
            !com.hps.july.web.util.Constants.CHECK_ROLES
                || parser.hasAccess(request, getHref(), getFile());
        DebugSupport.printlnTest(
            "HasAccessTag doStartTag() finished hasAccess=" + hasAccess);
    } catch (Exception ex) {
        throw new JspException(ex.getMessage());
    }

    if (!hasAccess)
        return EVAL_BODY_INCLUDE;

    else
        return SKIP_BODY;
}
}
