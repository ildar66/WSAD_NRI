package com.hps.july.taglib;

import java.net.*;
import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;

/**
 * Кнопка закрыть. Закрывает текущее окно.
 * Creation date: (23.05.2002 12:27:23)
 * @author: Dmitry Dneprov
 */
public class CloseButtonTag extends LinkTag {
	
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        if (getTitle() == null)
            if (getAlttext() == null)
                setAlttext("button.close");
        if (getOnclick() != null)
            setOnclick("document.body.style.cursor='auto';" + getOnclick());
        else
            setOnclick("document.body.style.cursor='auto';");
        super.doStartTag();
        // Generate the opening anchor element
        StringBuffer results = new StringBuffer("");
        results.append(
            "<IMG SRC=\"/images/cancel.gif\" BORDER='0' ALT='"
                + getTitle()
                + "' onclick=\"document.body.style.cursor='auto'; if (opener != null) {opener.focus();} window.close();\">");

        // Print this element to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Evaluate the body of this tag
        return (EVAL_BODY_TAG);

    }
}