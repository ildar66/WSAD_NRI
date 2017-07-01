package com.hps.july.taglib;

import com.hps.july.web.util.BrowseForm;
import java.net.*;
import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;
import javax.servlet.http.*;
import org.apache.struts.util.*;
import org.apache.struts.taglib.html.*;
import javax.servlet.jsp.PageContext;

/**
 * Таг вывода отчета.
 * Creation date: (23.05.2002 12:27:23)
 * @author: Dmitry Dneprov
 */
public class ReportTag extends org.apache.struts.taglib.html.LinkTag {
    private boolean canAdd;
    private java.lang.String report;
    private java.lang.String version;
    
    /**
     * Обработка закрывающего тага
    */
    public int doEndTag() throws javax.servlet.jsp.JspException {

        //return super.doEndTag();

        // Evaluate the body of this tag
        return EVAL_PAGE;
    }
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        StringBuffer results = new StringBuffer("");

        //super.doStartTag();

        //setHref("/crystalclear/" + getReport());
        //if ("2".equals(getVersion()))
        setHref(
            "http://"
                + pageContext.getRequest().getServerName()
                + "/crystalclear/"
                + getReport());
        // Generate the hyperlink URL
        Map params =
            RequestUtils.computeParameters(
                pageContext,
                paramId,
                paramName,
                paramProperty,
                paramScope,
                name,
                property,
                scope,
                transaction);
        String url = null;
        try {
            url =
                RequestUtils.computeURL(
                    pageContext,
                    forward,
                    href,
                    page,
                    params,
                    anchor,
                    false);
            if (url.indexOf("?") >= 0)
                url = url + "&reportversion=" + Math.round(Math.random() * 1000);
            else
                url = url + "?reportversion=" + Math.round(Math.random() * 1000);
        } catch (MalformedURLException e) {
            RequestUtils.saveException(pageContext, e);
            throw new JspException(messages.getMessage("rewrite.url", e.toString()));
        }

        String cabPath = "/crystaljava";
        if ("2".equals(getVersion()))
            cabPath = "/crystaljava2";

        results.append("<applet code=\"com.inet.viewer.ReportViewerBean\" \r\n");
        results.append("  codebase=\"/crystaljava\"  \r\n");
        results.append("  id=ReportViewer width=\"780\" height=\"500\" > \r\n");
        results.append("<param name=HasGroupTree value=false> \r\n");
        results.append("<param name=ShowGroupTree value=false> \r\n");
        results.append("<param name=HasExportButton value=true> \r\n");
        results.append("<param name=HasRefreshButton value=true> \r\n");
        results.append("<param name=HasPrintButton value=true> \r\n");

        results.append("<param name=ReportName value=\"" + url + "\"> \r\n");
        results.append(
            "<param name=cabbase value=\"" + cabPath + "/JavaClient.cab\"> \r\n");
        results.append(
            "<param name=Archive value=\"" + cabPath + "/JavaClient.jar\"> \r\n");
        results.append("</applet> \r\n");

        // Print this element to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Evaluate the body of this tag
        return (EVAL_BODY_TAG);

    }
    
    /**
     * Наименование RPT-файла.
     * Creation date: (20.08.2002 17:51:40)
     * @return java.lang.String
     */
    public java.lang.String getReport() {
        return report;
    }
    /**
     * Используемая на клиенте версия Java (1 или 2).
     * Creation date: (18.11.2003 17:49:21)
     * @return java.lang.String
     */
    public java.lang.String getVersion() {
        return version;
    }
    /**
     * Наименование RPT-файла.
     * Creation date: (20.08.2002 17:51:40)
     * @param newReport java.lang.String
     */
    public void setReport(java.lang.String newReport) {
        report = newReport;
    }
    
    /**
     * Используемая на клиенте версия Java (1 или 2).
     * Creation date: (18.11.2003 17:49:21)
     * @param newVersion java.lang.String
     */
    public void setVersion(java.lang.String newVersion) {
        version = newVersion;
    }
}