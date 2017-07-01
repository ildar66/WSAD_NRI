package com.hps.july.taglib;

import javax.servlet.http.*;
//import com.ibm.servlet.jsp.db.*;
import org.apache.struts.util.*;

/**
 * Таг для ввода textarea.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class TextAreaTag extends org.apache.struts.taglib.html.BaseFieldTag {

    private java.lang.String insertable;
    private java.lang.String updatable;

    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        // Create an appropriate "form" element based on our parameters
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results = new StringBuffer("");

        // Look up the requested property value
        Object valueAction =
            RequestUtils.lookup(pageContext, name, "action", "request");

        // Lookup value
        Object value = RequestUtils.lookup(pageContext, name, property, null);
        if (value == null)
            value = "";

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

        if (getTitle() == null)
            setTitle(ResponseUtils.filter(value.toString()));

        results.append(prepareEventHandlers());
        results.append(prepareStyles());
        results.append(">");

        results.append(ResponseUtils.filter(value.toString().trim()));

        results.append("</TEXTAREA>");
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
     * Возвращает признак "доступно при изменении".
     * Creation date: (30.01.2002 10:44:20)
     * @return java.lang.String
     */
    public java.lang.String getUpdatable() {
        return updatable;
    }
    
    /**
     * Подготовка тага к редактированию
    */
    public String prepareEditTag() throws javax.servlet.jsp.JspException {
        StringBuffer results = new StringBuffer("<TEXTAREA ");
        if (cols != null) {
            results.append(" cols=\"");
            results.append(cols);
            results.append("\" ");
        }
        if (rows != null) {
            results.append(" rows=\"");
            results.append(rows);
            results.append("\" ");
        }
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
        if (getStyleClass() != null) {
            results.append(" class=\"");
            results.append(getStyleClass());
            results.append("\" ");
        } else {
            results.append(" class=\"editbigest\"");
        }
        return results.toString();
    }
    
    /**
     * Подготовка тага к просмотру
    */
    public String prepareViewTag() throws javax.servlet.jsp.JspException {
        StringBuffer results = new StringBuffer("<TEXTAREA ");
        if (cols != null) {
            results.append(" cols=\"");
            results.append(cols);
            results.append("\" ");
        }
        if (rows != null) {
            results.append(" rows=\"");
            results.append(rows);
            results.append("\" ");
        }
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
        if (getStyleClass() != null) {
            results.append(" class=\"");
            results.append(getStyleClass());
            results.append("\" ");
        } else {
            results.append(" class=\"editbigestdisabled\"");
        }
        results.append(" READONLY=\"true\" ");
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
     * Устанавливает признак "доступно при изменении".
     * Creation date: (30.01.2002 10:44:20)
     * @param newUpdatable java.lang.String
     */
    public void setUpdatable(java.lang.String newUpdatable) {
        updatable = newUpdatable;
    }
}