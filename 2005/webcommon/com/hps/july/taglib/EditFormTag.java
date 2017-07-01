package com.hps.july.taglib;

import javax.servlet.http.*;
import org.apache.struts.util.*;

/**
 * Таг формы редактирования. Содержит вспомогательный javascript для организации lookup-полей.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class EditFormTag extends org.apache.struts.taglib.html.FormTag {

    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        lookup();
        if (getStyleId() == null) {
            //setStyleId(getName());
            setStyleId("thefirstform");
        }
        super.doStartTag();
        // Create an appropriate "form" element based on our parameters
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results = new StringBuffer("<SCRIPT language=\"JScript\">");

        results.append("var myWindow;");
        results.append("function lookup_params() {");
        results.append("  var s = new String(\"s\");");
        results.append("  var a = s.lookup(\"s\");");
        results.append("}");

        results.append("</SCRIPT>");

        results.append("<INPUT TYPE=\"hidden\" name=\"dummy1\" value=''>");
        results.append("<INPUT TYPE=\"hidden\" name=\"dummy2\" value=''>");
        results.append("<INPUT TYPE=\"hidden\" name=\"dummy3\" value=''>");

        results.append(
            "<INPUT TYPE='hidden' name='wasposted' id='wasposted' value='0'>");
        results.append("<INPUT TYPE=\"hidden\" name=\"action\" value='");

        // Look up the requested property value
        Object value = RequestUtils.lookup(pageContext, name, "action", scope);
        if (value != null) {
            results.append(value.toString());
        }

        results.append("'>");

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        return (EVAL_BODY_INCLUDE);
    }
}