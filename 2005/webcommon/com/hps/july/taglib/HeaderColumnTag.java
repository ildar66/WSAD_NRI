package com.hps.july.taglib;

import javax.servlet.http.*;
import org.apache.struts.util.*;

/**
 * “аг дл€ форматированного отображени€ названи€ колонки.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class HeaderColumnTag extends org.apache.struts.taglib.bean.MessageTag {
    private java.lang.String colspan;
    private java.lang.String rowspan;
    private java.lang.String colType;
    
    /**
     * ќбработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        // Create an appropriate "form" element based on our parameters
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results = new StringBuffer("<td class=\"title\"");
        /*
        if ("string".equals(colType))
          results.append("titletext");
        else if ("number".equals(colType))
          results.append("titlenumber");
        else if ("link".equals(colType))
          results.append("titlelink");
        else if ("date".equals(colType))
          results.append("titledate");
        else
          results.append("");
        */
        if (colspan != null) {
            results.append(" colspan=\"" + colspan + "\"");
        }
        if (rowspan != null) {
            results.append(" rowspan=\"" + rowspan + "\"");
        }
        results.append("><B>");

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Put Label
        super.doStartTag();

        results = new StringBuffer("</B></td>");

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        return (EVAL_BODY_INCLUDE);

    }
    /**
     * ѕараметр colspan, который будет установлен во внутреннем теге <TD>.
     * ѕримен€етс€ дл€ форматировани€ колонок.
     * @return java.lang.String
     */
    public java.lang.String getColspan() {
        return colspan;
    }
    
    /**
     * “ип колонки (дл€ форматировани€): string, number, link, date.
     * Creation date: (30.01.2002 9:49:37)
     * @return java.lang.String
     */
    public java.lang.String getColType() {
        return colType;
    }
    
    /**
     * ѕараметр rowspan, который будет установлен во внутреннем теге <TD>.
     * ѕримен€етс€ дл€ форматировани€ колонок.
     * @return java.lang.String
     */
    public java.lang.String getRowspan() {
        return rowspan;
    }
    
    /**
     * ѕараметр colspan, который будет установлен во внутреннем теге <TD>.
     * ѕримен€етс€ дл€ форматировани€ колонок.
     * @param newColspan java.lang.String
     */
    public void setColspan(java.lang.String newColspan) {
        colspan = newColspan;
    }
    
    /**
     * “ип колонки (дл€ форматировани€): string, number, link, date.
     * Creation date: (30.01.2002 9:49:37)
     * @param newColType java.lang.String
     */
    public void setColType(java.lang.String newColType) {
        colType = newColType;
    }
    
    /**
     * ѕараметр rowspan, который будет установлен во внутреннем теге <TD>.
     * ѕримен€етс€ дл€ форматировани€ колонок.
     * @param newRowspan java.lang.String
     */
    public void setRowspan(java.lang.String newRowspan) {
        rowspan = newRowspan;
    }
}