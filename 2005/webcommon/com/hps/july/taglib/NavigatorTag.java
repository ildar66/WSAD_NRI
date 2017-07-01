package com.hps.july.taglib;

import javax.servlet.http.*;
import org.apache.struts.util.*;

/**
 * Навигатор для перемещения между страницами в browse.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class NavigatorTag extends org.apache.struts.taglib.html.BaseFieldTag {

    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        // Create an appropriate "form" element based on our parameters
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results = new StringBuffer("");
        results.append(
            "<A HREF=\"#\" onclick=\"setAction('TOP'); return false;\"><img src=\"/images/back_all.gif\" border=\"0\" alt=\"В начало\"></A>&nbsp;");
        results.append(
            "<A HREF=\"#\" onclick=\"setAction('PREVIOUS'); return false;\"><img src=\"/images/back.gif\" border=\"0\" alt=\"Назад\"></A>&nbsp;");
        results.append(
            "<A HREF=\"#\" onclick=\"setAction('NEXT'); return false;\"><img src=\"/images/next.gif\" border=\"0\" alt=\"Вперед\"></A>&nbsp;");
        results.append(
            "<A HREF=\"#\" onclick=\"setAction('BOTTOM'); return false;\"><img src=\"/images/next_all.gif\" border=\"0\" alt=\"В конец\"></A>");
        results.append(
            "<SPAN style=\"height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;\">&nbsp;Стр.&nbsp;<INPUT VSPACE=0 HEIGHT=16 class=\"page\" style=\"font-size:8pt; text-align: right; height:16; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;\" TYPE=\"text\" name=\"currentPageN\" ");
        results.append(
            "onchange=\"document.forms(0).currentPage.value=value\" size=\"3\" value=\"");
        // Look up the requested property value
        Object valuePage = RequestUtils.lookup(pageContext, name, "currentPage", null);
        if (valuePage != null) {
            results.append(valuePage.toString());
        }
        results.append("\">&nbsp;/&nbsp;");
        // Look up the requested property value
        Object value = RequestUtils.lookup(pageContext, "numberOfPages", null, null);
        if (value != null) {
            results.append(value.toString().trim());
        }
        results.append(
            "&nbsp;</SPAN><A HREF=\"#\" onclick=\"submitForm(); return false;\"><img src=\"/images/go.gif\" border=\"0\" alt=\"Перейти\"></A>");

        results.append(
            "<SCRIPT language=\"JScript\" FOR=\"abody\" EVENT=\"onkeydown\"> \r\n");
        results.append("if ((event.keyCode == 36) && (event.ctrlKey)) { \r\n");
        results.append("  event.returnValue=false; \r\n");
        results.append("  setAction('TOP'); submitForm(); \r\n");
        results.append("} \r\n");
        results.append("if ((event.keyCode == 35) && (event.ctrlKey)) { \r\n");
        results.append("  event.returnValue=false; \r\n");
        results.append("  setAction('BOTTOM'); submitForm(); \r\n");
        results.append("} \r\n");
        results.append("if ((event.keyCode == 33) && (event.ctrlKey)) { \r\n");
        results.append("  event.returnValue=false; \r\n");
        results.append("  setAction('PREVIOUS'); submitForm(); \r\n");
        results.append("} \r\n");
        results.append("if ((event.keyCode == 34) && (event.ctrlKey)) { \r\n");
        results.append("  event.returnValue=false; \r\n");
        results.append("  setAction('NEXT'); submitForm(); \r\n");
        results.append("} \r\n");
        results.append("</SCRIPT> \r\n");

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        return (EVAL_BODY_TAG);

    }
}