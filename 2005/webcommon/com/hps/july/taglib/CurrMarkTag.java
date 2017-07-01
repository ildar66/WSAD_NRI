package com.hps.july.taglib;

import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;
/**
 * Таг для выделения текущего пункта в навигаторе страниц.
 * Creation date: (29.04.2002 13:43:45)
 * @author: Dmitry Dneprov
 */
public class CurrMarkTag extends javax.servlet.jsp.tagext.TagSupport {
	
    /**
     * Сonstructor.
     */
    public CurrMarkTag() {
        super();
    }
    
    /**
     * Обработка закрывающего тага
    */
    public int doEndTag() throws javax.servlet.jsp.JspException {

        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results = new StringBuffer("");

        results.append("</b></font>");

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

        results.append("<font class=\"attention\"><b>");

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        return (EVAL_BODY_INCLUDE);
    }
}