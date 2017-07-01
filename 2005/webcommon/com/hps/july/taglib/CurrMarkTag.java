package com.hps.july.taglib;

import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;
/**
 * ��� ��� ��������� �������� ������ � ���������� �������.
 * Creation date: (29.04.2002 13:43:45)
 * @author: Dmitry Dneprov
 */
public class CurrMarkTag extends javax.servlet.jsp.tagext.TagSupport {
	
    /**
     * �onstructor.
     */
    public CurrMarkTag() {
        super();
    }
    
    /**
     * ��������� ������������ ����
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
     * ��������� ������������ ����
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