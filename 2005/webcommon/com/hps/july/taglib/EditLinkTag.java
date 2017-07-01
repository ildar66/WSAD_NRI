package com.hps.july.taglib;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.web.util.BrowseForm;
import org.apache.struts.taglib.html.*;
import javax.servlet.jsp.PageContext;
/**
 * “аг - ссылка "»зменить запись" - аналогично EditButtonTag, только в виде ссылки.
 * Creation date: (27.06.2002 17:22:10)
 * @author: Dmitry Dneprov
 */
public class EditLinkTag extends LinkTag {
    private boolean canEdit;
    private java.lang.String action;
    
    /**
     * ќбработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        canEdit = RolesValidation.canModify(pageContext);

        // If we cannot edit change to view mode
        if (!canEdit) {
            if ("Edit".equals(action))
                setAction("View");
        }

        // If no hint specified - display defualt hint	
        if (getAlttext() == null) {
            if ("Edit".equals(action))
                setAlttext("label.edit");
            if ("View".equals(action))
                setAlttext("label.view");
        }

        if (getPage().indexOf("?") > 0)
            setPage(getPage() + "&action=" + getAction());
        else
            setPage(getPage() + "?action=" + getAction());

        return super.doStartTag();

    }
    
    /**
     * ѕараметр action, передаваемый в форму редактировани€.
     * Creation date: (27.06.2002 17:31:04)
     * @return java.lang.String
     */
    public java.lang.String getAction() {
        return action;
    }
    
    /**
     * ѕараметр action, передаваемый в форму редактировани€.
     * Creation date: (27.06.2002 17:31:04)
     * @param newAction java.lang.String
     */
    public void setAction(java.lang.String newAction) {
        action = newAction;
    }
}