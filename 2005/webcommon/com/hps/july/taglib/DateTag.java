package com.hps.july.taglib;

import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.http.*;
//import com.ibm.servlet.jsp.db.*;
import org.apache.struts.util.*;
import java.math.BigDecimal;

/**
 * Таг ввода даты. Использует ActiveX для выбора даты.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class DateTag extends org.apache.struts.taglib.html.BaseFieldTag {
    public static final long DAYS_FROM_1900_TO_1970 = 25569;
    public static final long MSEC_PER_DAY = 86400000;
    public static final long MSEC_PER_MIN = MSEC_PER_DAY / 24 / 60;

    private java.lang.String insertable;
    private java.lang.String updatable;

    private java.lang.String required;
    private java.lang.String onchange;
    protected static long calcDays(java.sql.Date date) {
        return DAYS_FROM_1900_TO_1970
            + (date.getTime() - date.getTimezoneOffset() * MSEC_PER_MIN) / MSEC_PER_DAY;
    }
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results = new StringBuffer("");

        // Look up the requested property value
        Object valueAction =
            RequestUtils.lookup(pageContext, name, "action", "request");

        if ("Add".equals(valueAction)) {
            if ("true".equals(insertable))
                results.append(prepareEditTag());
            else
                results.append(prepareViewTag());
        } else
            if ("Edit".equals(valueAction)) {
                if ("true".equals(updatable))
                    results.append(prepareEditTag());
                else
                    results.append(prepareViewTag());
            } else
                if ("Delete".equals(valueAction)) {
                    results.append(prepareViewTag());
                } else
                    if ("View".equals(valueAction)) {
                        results.append(prepareViewTag());
                    } else
                        results.append(prepareEditTag());

        results.append(prepareEventHandlers());
        results.append(prepareStyles());
        results.append(">");
        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        return (EVAL_BODY_TAG);

    }
    
    /**
     * Возвращает признак "доступно при добавлении".
     * Creation date: (30.01.2002 10:43:54)
     * @return java.lang.String
     */
    public java.lang.String getInsertable() {
        return insertable;
    }
    
    /**
     * Обработчик события "onchange".
     * Creation date: (15.12.2003 11:51:44)
     * @return java.lang.String
     */
    public java.lang.String getOnchange() {
        return onchange;
    }
    
    /**
     * Признак обязательности даты.
     * Creation date: (03.07.2002 11:55:27)
     * @return java.lang.String
     */
    public java.lang.String getRequired() {
        return required;
    }
    
    /**
     * Возвращает признак "доступно при изменении".
     * Creation date: (30.01.2002 10:44:20)
     * @return java.lang.String
     */
    public java.lang.String getUpdatable() {
        return updatable;
    }

    /**
     * Подготовка тага к редактированию значения.
     * Creation date: (30.01.2002 10:44:20)
     */
    public String prepareEditTag() throws javax.servlet.jsp.JspException {
        StringBuffer results = new StringBuffer("");

        if (getStyleId() == null)
            setStyleId("id_" + Math.round(Math.random() * 1000));

        String value = (String) RequestUtils.lookup(pageContext, name, property, null);

        if ("false".equals(required)) {
            results.append(
                "<INPUT TYPE=\"checkbox\" id=\"cb_"
                    + getStyleId()
                    + "\" onclick=\"switch"
                    + getStyleId()
                    + "(document.all.cb_"
                    + getStyleId()
                    + ".checked, false); if (document.all.cb_"
                    + getStyleId()
                    + ".checked) { document.all."
                    + getStyleId()
                    + "_dt.focus(); } \" ");
            if ((value != null) && (value.length() > 0))
                results.append("checked");

            results.append("> \r\n");
        }

        if ((value == null) || (value.length() == 0)) {
            if ("false".equals(required)) {
                value = "";
            } else {
                java.text.SimpleDateFormat format =
                    new java.text.SimpleDateFormat("dd.MM.yyyy");
                Date date = new Date();
                value = format.format(date);
            }
        }

        // Helper functions
        results.append("<SCRIPT language=\"javascript\"> \r\n");
        results.append("  function getDate_" + getStyleId() + "() { \r\n");
        results.append(
            "       return document.all." + getStyleId() + "_dt.gDate; \r\n");
        results.append("  } \r\n");
        results.append("  function setDate_" + getStyleId() + "(anewdate) { \r\n");
        results.append(
            "       document.all." + getStyleId() + "_dt.gDate=anewdate; \r\n");
        results.append(
            "       d = new Date((document.all."
                + getStyleId()
                + "_dt.gDate-"
                + DAYS_FROM_1900_TO_1970
                + ")*"
                + MSEC_PER_DAY
                + ");\r\n");
        results.append(
            "       document.all."
                + getStyleId()
                + ".value = d.getDate() + \".\" + (d.getMonth()+1) + \".\" + d.getFullYear();\r\n");
        results.append("  } \r\n");
        results.append("</SCRIPT>\r\n");

        results.append(
            "<SCRIPT LANGUAGE=\"JavaScript\" FOR=\""
                + getStyleId()
                + "_dt\" EVENT=\"OnChange()\">");
        results.append("\r\n\r\n");
        results.append(
            "d = new Date(("
                + getStyleId()
                + "_dt.gDate-"
                + DAYS_FROM_1900_TO_1970
                + ")*"
                + MSEC_PER_DAY
                + ");\r\n");
        results.append(
            "document.all."
                + getStyleId()
                + ".value = d.getDate() + \".\" + (d.getMonth()+1) + \".\" + d.getFullYear();\r\n");
        results.append("\r\n");
        if (getOnchange() != null) {
            results.append(getOnchange() + ";\r\n");
        }
        results.append("</SCRIPT>\r\n");
        results.append(
            "<OBJECT class='date' ID=\"" + getStyleId() + "_dt\" WIDTH=100 HEIGHT=25 \r\n");
        if (getStyle() != null) {
            results.append(" STYLE=\"");
            results.append(getStyle());
            results.append("\" \r\n ");
        }
        //results.append(" CODEBASE=\"/MSComCt2.cab\" \r\n");
        results.append(" CLASSID=\"CLSID:1FC68BD5-20B2-4133-9131-8DD3CBD155ED\">\r\n");

        //results.append("    <PARAM NAME=\"Format\" VALUE=\"662831105\">\r\n");
        results.append("    <PARAM NAME=\"Format\" VALUE=\"\">\r\n");

        results.append("    <PARAM NAME=\"CalAlignment\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"ShowCheckbox\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"Checked\" VALUE=\"-1\"> \r\n");
        results.append("    <PARAM NAME=\"Color\" VALUE=\"2147483653\"> \r\n");
        results.append("    <PARAM NAME=\"DateFormat\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"DateMode\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"DragCursor\" VALUE=\"-12\"> \r\n");
        results.append("    <PARAM NAME=\"DragMode\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"Enabled\" VALUE=\"-1\"> \r\n");
        results.append("    <PARAM NAME=\"Font\" VALUE=\"Arial\"> \r\n");
        results.append("    <PARAM NAME=\"ImeMode\" VALUE=\"3\"> \r\n");
        results.append("    <PARAM NAME=\"ImeName\" VALUE=\"\"> \r\n");
        results.append("    <PARAM NAME=\"Kind\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"MaxDate\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"MinDate\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"ParseInput\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"ParentColor\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"Visible\" VALUE=\"-1\"> \r\n");
        results.append("    <PARAM NAME=\"DoubleBuffered\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"Cursor\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"DateTime\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"Time\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"BevelInner\" VALUE=\"2\"> \r\n");
        results.append("    <PARAM NAME=\"BevelOuter\" VALUE=\"1\"> \r\n");
        results.append("    <PARAM NAME=\"BevelKind\" VALUE=\"0\"> \r\n");
        results.append("    <PARAM NAME=\"HelpType\" VALUE=\"1\"> \r\n");
        results.append("    <PARAM NAME=\"HelpKeyword\" VALUE=\"\"> \r\n");
        java.sql.Date date = null;
        if ((value != null) && (value.length() > 0)) {
            try {
                date =
                    com.hps.july.web.util.StringAndSqlDateProperty.parseDateString((String) value);
            } catch (ParseException e) {
                date = new java.sql.Date(new Date().getTime());
            }
        } else {
            date = new java.sql.Date(new Date().getTime());
        }
        results.append(
            "    <PARAM NAME=\"gDate\" VALUE=\"" + calcDays(date) + "\">\r\n");

        results.append("</OBJECT>\r\n");

        if ("false".equals(required)) {
            results.append("<SCRIPT language=\"javascript\"> \r\n");
            results.append("  function switch" + getStyleId() + "(state, isFirst) { \r\n");
            results.append("	if(state) { \r\n");
            results.append(
                "       document.all." + getStyleId() + "_dt.enabled=true; \r\n");
            results.append("	   if(!isFirst) { \r\n");
            //results.append("         d = new Date(document.all." + getStyleId() + "_dt.value);\r\n");
            results.append(
                "         d = new Date((document.all."
                    + getStyleId()
                    + "_dt.gDate-"
                    + DAYS_FROM_1900_TO_1970
                    + ")*"
                    + MSEC_PER_DAY
                    + ");\r\n");
            results.append(
                "         document.all."
                    + getStyleId()
                    + ".value = d.getDate() + \".\" + (d.getMonth()+1) + \".\" + d.getFullYear();\r\n");
            results.append("       } \r\n");
            results.append("    } else { \r\n");
            results.append(
                "       document.all." + getStyleId() + "_dt.enabled=false; \r\n");
            results.append("	   if(!isFirst) { \r\n");
            results.append("         document.all." + getStyleId() + ".value = \"\";\r\n");
            results.append("       } \r\n");
            results.append("    } \r\n");
            results.append("  } \r\n");
            results.append(
                "  switch"
                    + getStyleId()
                    + "(document.all.cb_"
                    + getStyleId()
                    + ".checked, true);\r\n");
            results.append("</SCRIPT> \r\n");
        }

        results.append("<INPUT TYPE=\"HIDDEN\" ");
        if (property != null) {
            results.append(" NAME=\"");
            results.append(property);
            results.append("\" ");
        }
        if (getStyleId() != null) {
            results.append(" ID=\"");
            results.append(getStyleId());
            results.append("\" ");
        }
        results.append(" VALUE=\"");
        results.append(ResponseUtils.filter(value.toString()));
        results.append("\"");

        return results.toString();
    }

    /**
     * Подготовка тага к просмотру значения
    */
    public String prepareViewTag() throws javax.servlet.jsp.JspException {
        StringBuffer results = new StringBuffer("");

        Object value = RequestUtils.lookup(pageContext, name, property, null);
        if (value == null) {
            java.text.SimpleDateFormat format =
                new java.text.SimpleDateFormat("dd.MM.yyyy");
            Date date = new Date();
            value = format.format(date);
        }

        if (getStyleClass() == null) {
            setStyleClass("editsmalldisabled");
        }

        results.append("<INPUT TYPE=\"TEXT\" ");
        if (property != null) {
            results.append(" NAME=\"");
            results.append(property);
            results.append("\" ");
        }
        if (id != null) {
            results.append(" ID=\"");
            results.append(id);
            results.append("\" ");
        }
        results.append(" VALUE=\"");
        results.append(ResponseUtils.filter(value.toString()));
        results.append("\"");
        results.append(" READONLY=\"TRUE\" ");

        return results.toString();
    }
    
    /**
     * Устанавливает признак "доступно при добавлении".
     * Creation date: (30.01.2002 10:43:54)
     * @param newInsertable java.lang.String
     */
    public void setInsertable(java.lang.String newInsertable) {
        insertable = newInsertable;
    }
    
    /**
     * Обработчик события "onchange".
     * Creation date: (15.12.2003 11:51:44)
     * @param newOnchange java.lang.String
     */
    public void setOnchange(java.lang.String newOnchange) {
        onchange = newOnchange;
    }
    /**
     * Признак обязательности даты.
     * Creation date: (03.07.2002 11:55:27)
     * @param newRequired java.lang.String
     */
    public void setRequired(java.lang.String newRequired) {
        required = newRequired;
    }
    
    /**
     * Устанавливает признак "доступно при изменении".
     * Creation date: (30.01.2002 10:44:20)
     * @param newUpdatable java.lang.String
     */
    public void setUpdatable(java.lang.String newUpdatable) {
        updatable = newUpdatable;
    }
}