package com.hps.july.taglib;

import java.util.StringTokenizer;
import javax.servlet.http.*;
import org.apache.struts.util.*;

/**
 * Таг возврата результата из lookup.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class LookupReturnTag extends org.apache.struts.taglib.html.LinkTag {

    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        setHref("#");
        setOnclick(
            "retval("
                + (Integer.parseInt(pageContext.getAttribute("index").toString()) * 2 + 1)
                + "); return false;");

        // Continue processing this page
        return super.doStartTag();

    }
}