package com.hps.july.taglib;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.web.util.BrowseForm;
import javax.servlet.jsp.tagext.*;
import org.apache.struts.taglib.html.*;
import javax.servlet.jsp.PageContext;

/**
 * ѕроверка прав редактировани€.
 * ≈сли права есть - содержимое тага включаетс€ в JSP.
 * Creation date: (27.06.2002 17:22:10)
 * @author: Dmitry Dneprov
 */
public class CanEditTag extends TagSupport {
    private boolean canEdit;
    private java.lang.String rolesProperty;
    
    /**
     * ќбработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        if (getRolesProperty() != null)
            canEdit = RolesValidation.canModify(pageContext, getRolesProperty());
        else
            canEdit = RolesValidation.canModify(pageContext);

        // If we cannot edit change to view mode
        if (canEdit) {
            return EVAL_BODY_INCLUDE;
        }

        return SKIP_BODY;
    }
    
    /**
     * —войство из которого беретс€ список ролей дл€ проверки прав.
     * Creation date: (19.07.2002 12:53:07)
     * @return java.lang.String
     */
    public java.lang.String getRolesProperty() {
        return rolesProperty;
    }
    
    /**
     * —войство из которого беретс€ список ролей дл€ проверки прав.
     * Creation date: (19.07.2002 12:53:07)
     * @param newRolesProperty java.lang.String
     */
    public void setRolesProperty(java.lang.String newRolesProperty) {
        rolesProperty = newRolesProperty;
    }
}