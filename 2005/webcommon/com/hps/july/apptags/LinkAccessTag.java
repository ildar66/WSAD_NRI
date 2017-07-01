package com.hps.july.apptags;

import javax.servlet.http.*;
import javax.servlet.jsp.JspException;

/**
 * Также, как link из struts, но с проверкой прав доступа по web.xml.
 * Creation date: (09.02.2003 19:47:22)
 * @author: Alexander Shrago
 */
public class LinkAccessTag extends org.apache.struts.taglib.html.LinkTag implements DefaultAccessCheck {
    private String file = FILE;
    private String checkAccess = CHECK;
    private Boolean hasAccess = null;
/**
 * MehuItemTag constructor comment.
 */
public LinkAccessTag() {
	super();
}
public int doEndTag() throws JspException {
    if (!isCheck() || hasAccess())
        return super.doEndTag();
    else
        return SKIP_BODY;

}
public int doStartTag() throws JspException {
    if (!isCheck() || hasAccess())
        return super.doStartTag();

    else
        return SKIP_BODY;
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
 * Creation date: (09.02.2003 22:15:54)
 * @return java.lang.String
 */
public String getUrl() {
    int num = getPage().indexOf("?");
    return num == -1 ? getPage() : getPage().substring(0, num);
}
/**
 * Insert the method's description here.
 * Creation date: (12.02.2003 21:15:21)
 * @return boolean
 */
private boolean hasAccess() throws JspException {
    if (hasAccess != null)
        return hasAccess.booleanValue();
    else {
        javax.servlet.http.HttpServletRequest request =
            (HttpServletRequest) pageContext.getRequest();
        file = pageContext.getServletContext().getRealPath(file);

        HasAccessBean parser = new HasAccessBean();
        try {

            hasAccess = new Boolean(parser.hasAccess(request, getUrl(), file));
            return hasAccess.booleanValue();

        } catch (Exception ex) {
            throw new JspException(ex.getMessage());
        }

    }

}
/**
 * Insert the method's description here.
 * Creation date: (09.02.2003 22:13:26)
 * @return boolean
 */
public boolean isCheck() {

	
	return new Boolean(checkAccess).booleanValue();
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
