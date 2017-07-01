package com.hps.july.taglib;

import javax.servlet.http.*;
import org.apache.struts.util.*;

/**
 * Таг формы поиска внутри browse.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class BrowseFormTag extends org.apache.struts.taglib.html.FormTag {

    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        if (getStyleId() == null) {
            setStyleId("thefirstform");
        }

        super.doStartTag();
        // Create an appropriate "form" element based on our parameters
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results =
            new StringBuffer("<SCRIPT FOR='abody' EVENT=onkeypress language=\"JScript\">");
        results.append(
            "if (window.event.keyCode == 13) {window.event.cancelBubble=true; submitForm();}");
        results.append("</SCRIPT>");

        results.append("<SCRIPT language=\"JScript\">");

        results.append("var myWindow;");
        results.append("function lookup_params() {");
        results.append("  var s = new String(\"s\");");
        results.append("  var a = s.lookup(\"s\");");
        results.append("}");

        results.append("function setFinder(finderName) {");
        results.append(
            "  document.forms(0).elements(\"finderMethodName\").value = finderName;");
        results.append("  submitForm();");
        results.append("}");

        results.append("function setAction(actionName) {");
        results.append(
            "  document.forms(0).elements(\"browseAction\").value = actionName;");
        results.append("  submitForm();");
        results.append("}");

        results.append("function submitForm() {");
        //results.append(" alert('Before Submit Form ');");
        results.append(
            " if (document.forms(0).elements('wasposted').value == 1) { alert('Форма уже отправлена на сервер'); return; }");
        results.append(" else { document.forms(0).elements('wasposted').value=1; ");
        results.append("  document.body.style.cursor=\"wait\";");
        results.append("  document.forms(0).submit(); }");
        results.append("}");

        results.append("</SCRIPT>");

        results.append("<INPUT TYPE=\"hidden\" name=\"dummy1\" value=''>");
        results.append("<INPUT TYPE=\"hidden\" name=\"dummy2\" value=''>");
        results.append("<INPUT TYPE=\"hidden\" name=\"dummy3\" value=''>");

        results.append(
            "<INPUT TYPE='hidden' name='wasposted' id='wasposted' value='0'>");
        results.append("<INPUT TYPE=\"HIDDEN\" NAME=\"action_process\" VALUE='0'>");
        results.append(
            "<INPUT TYPE=\"hidden\" name=\"currentPage\" ID=\"currentPage\" value=\"");
        // Look up the requested property value
        Object valuePage = RequestUtils.lookup(pageContext, name, "currentPage", null);
        if (valuePage != null) {
            results.append(valuePage.toString());
        }
        results.append("\">");
        results.append(
            "<INPUT TYPE=\"hidden\" name=\"finderMethodName\" ID=\"finderMethodName\" value='");

        // Look up the requested property value
        Object value =
            RequestUtils.lookup(pageContext, name, "finderMethodName", scope);
        if (value != null) {
            results.append(value.toString());
        }

        results.append("'>");
        results.append(
            "<INPUT TYPE=\"hidden\" name=\"browseAction\" ID=\"browseAction\">");

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        return (EVAL_BODY_INCLUDE);
    }
}
