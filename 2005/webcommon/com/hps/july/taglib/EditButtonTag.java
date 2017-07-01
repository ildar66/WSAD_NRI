package com.hps.july.taglib;

import com.hps.july.web.util.BrowseForm;
import java.net.*;
import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;
import org.apache.struts.taglib.html.*;
import javax.servlet.jsp.PageContext;

/**
 * Кнопка "Изменить запись". Осуществляет проверку прав.
 * Если прав на редактирование нет, режим вызывается с action=View
 * Creation date: (23.05.2002 12:27:23)
 * @author: Dmitry Dneprov
 */
public class EditButtonTag extends LinkTag {
    private boolean canEdit;
    private java.lang.String action;
    
    /**
     * Обработка закрывающего тага
    */
    public int doEndTag() throws javax.servlet.jsp.JspException {

        if (canEdit) {
            return super.doEndTag();
        }

        // Evaluate the body of this tag
        return EVAL_PAGE;

    }
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        canEdit = RolesValidation.canModify(pageContext);

        // If we cannot edit change to view mode
        if (!canEdit) {
            if ("Edit".equals(action))
                setAction("View");
        }

        if (getPage().indexOf("?") > 0)
            setPage(getPage() + "&action=" + getAction());
        else
            setPage(getPage() + "?action=" + getAction());

        StringBuffer results = new StringBuffer("");
        if (canEdit) {
            if (getTitle() == null)
                if (getAlttext() == null)
                    setAlttext("button.edit");
            super.doStartTag();
            // Generate the opening anchor element
            // System.out.println("### EditButtonTag EDIT getTitle()= "+getTitle());
            results.append(
                "<IMG SRC=\"/images/izmena.gif\" BORDER='0' ALT='" + getTitle() + "'>");
        } else {
            if (getTitle() == null)
                setAlttext("button.view");
            super.doStartTag();
            // Generate the opening anchor element
			// System.out.println("### EditButtonTag VIEW getTitle()= "+getTitle());
            results.append(
                "<IMG SRC=\"/images/izmena.gif\" BORDER='0' ALT='" + getTitle() + "'>");
        }
        // Print this element to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Evaluate the body of this tag
        return (EVAL_BODY_TAG);

    }
    
    /**
     * Параметр action, передаваемый в форму редактирования.
     * Creation date: (08.07.2002 17:24:10)
     * @return java.lang.String
     */
    public java.lang.String getAction() {
        return action;
    }
    
    /**
     * Параметр action, передаваемый в форму редактирования.
     * Creation date: (08.07.2002 17:24:10)
     * @param newAction java.lang.String
     */
    public void setAction(java.lang.String newAction) {
        action = newAction;
    }
}