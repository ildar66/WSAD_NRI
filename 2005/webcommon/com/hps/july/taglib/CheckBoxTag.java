package com.hps.july.taglib;

import javax.servlet.jsp.JspException;
import org.apache.struts.util.*;

/**
 * Поле ввода типа checkbox.
 * Creation date: (01.03.2002 12:38:57)
 * @author: Dmitry Dneprov
 */
public class CheckBoxTag extends org.apache.struts.taglib.html.CheckboxTag {
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
                setStyleClass("editcheckboxdisabled");
            else
                setStyleClass("editcheckbox");
        }

        // Create an appropriate "input" element based on our parameters
        StringBuffer results = new StringBuffer("<input type=\"checkbox\"");
        results.append(" name=\"");
        results.append(getProperty());
        results.append("\"");
        if (getAccesskey() != null) {
            results.append(" accesskey=\"");
            results.append(getAccesskey());
            results.append("\"");
        }
        if (getTabindex() != null) {
            results.append(" tabindex=\"");
            results.append(getTabindex());
            results.append("\"");
        }
        results.append(" value=\"");

        if (getValue() == null)
            results.append("on");
        else
            results.append(getValue());
        results.append("\"");

        Object result =
            RequestUtils.lookup(pageContext, getName(), getProperty(), null);
        if (result == null)
            result = "";

        // Special case - array of ints
        if (result instanceof int[]) {

            int[] arr = (int[]) result;

            for (int i = 0; i < arr.length; i++) {
                if (getValue() != null) {
                    int val = Integer.parseInt(getValue());
                    if (val == arr[i])
                        results.append(" checked=\"checked\"");
                }
            }
            if (getDisabled()) {
                results.append(" READONLY='true' ");
            }
            results.append(prepareEventHandlers());
            results.append(prepareStyles());
            results.append(">");
        } else
            if (result instanceof String[]) {

                String[] arr = (String[]) result;

                for (int i = 0; i < arr.length; i++) {
                    if (getValue() != null) {
                        if (getValue().compareTo(arr[i]) == 0)
                            results.append(" checked=\"checked\"");
                    }
                }
                if (getDisabled()) {
                    results.append(" READONLY='true' ");
                }
                results.append(prepareEventHandlers());
                results.append(prepareStyles());
                results.append(">");
            } else {
                if (!(result instanceof String))
                    result = result.toString();

                String checked = (String) result;
                boolean isChecked = false;

                if (getValue() != null) {
                    if (checked.equalsIgnoreCase(getValue())) {
                        results.append(" checked=\"checked\"");
                        isChecked = true;
                    }
                } else {
                    if (checked.equalsIgnoreCase("true")
                        || checked.equalsIgnoreCase("yes")
                        || checked.equalsIgnoreCase("on")) {
                    		    results.append(" checked=\"checked\"");
                        		isChecked = true;
                        }
                }
                if (getDisabled()) {
                    results.append(" READONLY='true' ");
                }
                results.append(prepareEventHandlers());
                results.append(prepareStyles());
                results.append(">");
                
                results.append("<INPUT TYPE='HIDDEN' NAME=\"");
                results.append(getProperty());
                results.append("\" VALUE='");
                if (getDisabled()) {
	                if (isChecked) {
		                if (getValue() != null)
                			results.append(getValue());
                		else
                			results.append("on");
	                } else {
                		results.append("off");
	                }
                } else {
                	results.append("off");
                }
		        results.append("'>");
            }
        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        // this.text = null;
        return (EVAL_BODY_TAG);

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