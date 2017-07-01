package com.hps.july.taglib;

import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;

/**
 * Прорисовка области меню со скрыванием.
 * Находится в процессе разработки, пока не используется
 * Creation date: (11.06.2003 17:48:47)
 * @author: Dmitry Dneprov
 */
public class MenuAreaTag extends javax.servlet.jsp.tagext.TagSupport {
	
    /**
     * Сonstructor.
     */
    public MenuAreaTag() {
        super();
    }
    
    /**
     * Обработка закрывающего тага
    */
    public int doEndTag() throws JspException {

        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results = new StringBuffer("");

        results.append("</TD> \r\n");

        results.append(
            "<SCRIPT language=\"JScript\" FOR=\"menutd\" EVENT=\"onmouseout\"> \r\n");
        results.append("document.all.menutd.style.width=30; \r\n");
        results.append("</SCRIPT> \r\n");

        results.append(
            "<SCRIPT language=\"JScript\" FOR=\"menutd\" EVENT=\"onmouseover\"> \r\n");
        results.append("document.all.menutd.style.width=200; \r\n");
        results.append("</SCRIPT> \r\n");

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        return (EVAL_PAGE);

    }
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results = new StringBuffer("");

        results.append("<TD vAlign=top width=180 ID='menutd'> \r\n");

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        return (EVAL_BODY_INCLUDE);

    }
}