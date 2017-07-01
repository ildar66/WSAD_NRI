package com.hps.july.taglib;

import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;
/**
 * Таг поддержки лицензии для ActiveX-ов.
 * Требуется по технологии Microsoft
 * Creation date: (29.04.2002 13:43:45)
 * @author: Dmitry Dneprov
 */
public class LicenceTag extends javax.servlet.jsp.tagext.TagSupport {
    private java.lang.String licence;
    /**
     * Сonstructor.
     */
    public LicenceTag() {
        super();
    }
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results = new StringBuffer("");

        results.append(
            "<OBJECT CLASSID=\"clsid:5220cb21-c88d-11cf-b347-00aa00a28331\"> \r\n");
        results.append("<PARAM NAME=\"LPKPath\" VALUE=\"" + getLicence() + "\"> \r\n");
        results.append("</OBJECT> \r\n");

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        return (EVAL_BODY_INCLUDE);

    }
    
    /**
     * Файл лицензии.
     * Creation date: (17.05.2002 9:57:17)
     * @return java.lang.String
     */
    public java.lang.String getLicence() {
        return licence;
    }
    
    /**
     * Файл лицензии.
     * Creation date: (17.05.2002 9:57:17)
     * @param newLicence java.lang.String
     */
    public void setLicence(java.lang.String newLicence) {
        licence = newLicence;
    }
}