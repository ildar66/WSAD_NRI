package com.hps.july.taglib;

import javax.servlet.jsp.JspException;
import org.apache.struts.util.*;

/**
 * Поле ввода - радио кнопка.
 * Creation date: (01.03.2002 12:38:57)
 * @author: Dmitry Dneprov
 */
public class RadioTag extends org.apache.struts.taglib.html.RadioTag {
    private java.lang.String insertable;
    private java.lang.String updatable;
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws JspException {

        // Look up the requested property value
        Object valueAction =
            RequestUtils.lookup(pageContext, name, "action", "request");

        if ("Add".equals(valueAction)) {
            if (!"true".equals(insertable))
                setDisabled(true);
        } else
            if ("Edit".equals(valueAction)) {
                if (!"true".equals(updatable))
                    setDisabled(true);
            } else
                if ("Delete".equals(valueAction)) {
                    setDisabled(true);
                } else
                    if ("View".equals(valueAction)) {
                        setDisabled(true);
                    } else
                        setDisabled(false);

        if (getStyleClass() == null) {
            if (getDisabled())
                setStyleClass("editkoddisabled");
            else
                setStyleClass("editkod");
        }

        if (getDisabled()) {
            StringBuffer results = new StringBuffer("");

            Object avalue = RequestUtils.lookup(pageContext, name, property, null);
            if (avalue == null)
                avalue = "";

            if (avalue.equals(getValue())) {
                results.append("<INPUT TYPE=\"HIDDEN\" NAME=\"");
                results.append(getProperty());
                results.append("\" VALUE=\"");
                results.append(ResponseUtils.filter(avalue.toString()));
                results.append("\"> \r\n");
                // Print this field to our output writer
                ResponseUtils.write(pageContext, results.toString());
            }
        }

        super.doStartTag();

        return EVAL_BODY_TAG;
    }
    
    /**
     * Возвращает признак "доступно при добавлении".
     * Creation date: (01.03.2002 12:39:19)
     * @return java.lang.String
     */
    public java.lang.String getInsertable() {
        return insertable;
    }
    
    /**
     * Возвращает признак "доступно при изменении".
     * Creation date: (01.03.2002 12:39:37)
     * @return java.lang.String
     */
    public java.lang.String getUpdatable() {
        return updatable;
    }
    
    /**
     * Устанавливает признак "доступно при добавлении".
     * Creation date: (01.03.2002 12:39:19)
     * @param newInsertable java.lang.String
     */
    public void setInsertable(java.lang.String newInsertable) {
        insertable = newInsertable;
    }
    
    /**
     * Устанавливает признак "доступно при изменении".
     * Creation date: (01.03.2002 12:39:37)
     * @param newUpdatable java.lang.String
     */
    public void setUpdatable(java.lang.String newUpdatable) {
        updatable = newUpdatable;
    }
}