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
 * Кнопка исключить - аналогична кнопке удалить.
 * Creation date: (23.05.2002 12:27:23)
 * @author: Dmitry Dneprov
 */
public class ExcludeButtonTag extends LinkTag {
    private boolean canDel;
    
    /**
     * Обработка закрывающего тага
    */
    public int doEndTag() throws javax.servlet.jsp.JspException {

        if (canDel) {
            return super.doEndTag();
        }

        // Evaluate the body of this tag
        return EVAL_PAGE;
    }
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        canDel = RolesValidation.canModify(pageContext);

        StringBuffer results = new StringBuffer("");
        if (canDel) {
            if (getTitle() == null)
                if (getAlttext() == null)
                    setAlttext("button.exclude");
            super.doStartTag();
            // Generate the opening anchor element
            results.append(
                "<IMG SRC=\"/images/iskl.gif\" BORDER='0' ALT='" + getTitle() + "'>");
        }

        // Print this element to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Evaluate the body of this tag
        return (EVAL_BODY_TAG);

    }
}