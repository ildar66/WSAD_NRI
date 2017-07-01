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
 * Кнопка "сохранить".
 * Creation date: (23.05.2002 12:27:23)
 * @author: Dmitry Dneprov
 */
public class SaveButtonTag extends LinkTag {
    private boolean canAdd;
    
    /**
     * Обработка закрывающего тага
    */
    public int doEndTag() throws javax.servlet.jsp.JspException {

        /*
        if (canAdd) {
        	return super.doEndTag();
        }
        */

        // Evaluate the body of this tag
        return EVAL_PAGE;
    }
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        canAdd = RolesValidation.canModify(pageContext);

        StringBuffer results = new StringBuffer("");
        if (canAdd) {
            // Generate the opening anchor element
            //results.append("<INPUT TYPE=\"IMAGE\" NAME=\"com.hps.july.web.util.PROCESS\" SRC=\"/images/save.gif\" " +
            //	" ALT=\"Сохранить\">");
            if (getTitle() == null)
                if (getAlttext() == null)
                    setAlttext("button.save");
            alterTitle();
            results.append(
                "<IMG SRC=\"/images/save.gif\" onclick=\"window.document.forms(0).all('action_process').value='1';window.document.forms(0).submit();\""
                    + " ALT=\""
                    + getTitle()
                    + "\">");
            results.append("<IMG SRC=\"/images/empty.gif\" BORDER='0' ALT='' WIDTH='3'>");
        } else {
            //results.append("&nbsp;");
        }
        // Print this element to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Evaluate the body of this tag
        return (EVAL_BODY_TAG);
    }
}