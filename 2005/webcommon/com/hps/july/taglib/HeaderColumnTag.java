package com.hps.july.taglib;

import javax.servlet.http.*;
import org.apache.struts.util.*;

/**
 * ��� ��� ���������������� ����������� �������� �������.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class HeaderColumnTag extends org.apache.struts.taglib.bean.MessageTag {
    private java.lang.String colspan;
    private java.lang.String rowspan;
    private java.lang.String colType;
    
    /**
     * ��������� ������������ ����
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
     * �������� colspan, ������� ����� ���������� �� ���������� ���� <TD>.
     * ����������� ��� �������������� �������.
     * @return java.lang.String
     */
    public java.lang.String getColspan() {
        return colspan;
    }
    
    /**
     * ��� ������� (��� ��������������): string, number, link, date.
     * Creation date: (30.01.2002 9:49:37)
     * @return java.lang.String
     */
    public java.lang.String getColType() {
        return colType;
    }
    
    /**
     * �������� rowspan, ������� ����� ���������� �� ���������� ���� <TD>.
     * ����������� ��� �������������� �������.
     * @return java.lang.String
     */
    public java.lang.String getRowspan() {
        return rowspan;
    }
    
    /**
     * �������� colspan, ������� ����� ���������� �� ���������� ���� <TD>.
     * ����������� ��� �������������� �������.
     * @param newColspan java.lang.String
     */
    public void setColspan(java.lang.String newColspan) {
        colspan = newColspan;
    }
    
    /**
     * ��� ������� (��� ��������������): string, number, link, date.
     * Creation date: (30.01.2002 9:49:37)
     * @param newColType java.lang.String
     */
    public void setColType(java.lang.String newColType) {
        colType = newColType;
    }
    
    /**
     * �������� rowspan, ������� ����� ���������� �� ���������� ���� <TD>.
     * ����������� ��� �������������� �������.
     * @param newRowspan java.lang.String
     */
    public void setRowspan(java.lang.String newRowspan) {
        rowspan = newRowspan;
    }
}