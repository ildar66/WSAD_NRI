package com.hps.july.taglib;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.web.util.BrowseForm;
import javax.servlet.jsp.tagext.*;
import org.apache.struts.taglib.html.*;
import javax.servlet.jsp.PageContext;

/**
 * Проверка прав редактирования. Обратный для тага CanEditTag
 * Если прав нет - содержимое тага включается в JSP.
 * Creation date: (27.06.2002 17:22:10)
 * @author: Dmitry Dneprov
 */
public class CannotEditTag extends TagSupport {
    private boolean canEdit;
    private java.lang.String rolesProperty;
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        if (getRolesProperty() != null)
            canEdit = RolesValidation.canModify(pageContext, getRolesProperty());
        else
            canEdit = RolesValidation.canModify(pageContext);

        // If we cannot edit change to view mode
        if (!canEdit) {
            return EVAL_BODY_INCLUDE;
        }

        return SKIP_BODY;
    }
    
    /**
     * Свойство из которого берется список ролей для проверки прав.
     * Creation date: (19.07.2002 12:53:33)
     * @return java.lang.String
     */
    public java.lang.String getRolesProperty() {
        return rolesProperty;
    }
    
    /**
     * Свойство из которого берется список ролей для проверки прав.
     * Creation date: (19.07.2002 12:53:33)
     * @param newRolesProperty java.lang.String
     */
    public void setRolesProperty(java.lang.String newRolesProperty) {
        rolesProperty = newRolesProperty;
    }
}