package com.hps.july.taglib;

import com.hps.july.web.util.BrowseForm;
import java.net.*;
import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;
import org.apache.struts.taglib.html.*;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

/**
 * Кнопка печати документов для задачи "Учет движения оборудования".
 * Creation date: (18.09.2002 11:37:40)
 * @author: Dmitry Dneprov
 */
public class DocPrintButtonTag extends PrintButtonTag {
    private java.lang.String docstate;
    private java.lang.String docstatebean;
    private java.lang.String docstateproperty;

    /**
     * Обработка закрывающего тага
    */
    public int doEndTag() throws JspException {

        if (com.hps.july.web.util.Constants.PRINT_INCOMPLETE)
            return super.doEndTag();
        else {
            if ("2".equals(getDocstate()))
                return super.doEndTag();
            else
                return EVAL_PAGE;
        }
    }
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        String beanName = getDocstatebean();
        if (beanName == null)
            beanName = org.apache.struts.taglib.html.Constants.BEAN_KEY;
        Object bean = pageContext.findAttribute(beanName);
        if (bean == null)
            throw new JspException(messages.getMessage("getter.bean", beanName));

        // find bean
        if (getDocstateproperty() != null) {
            try {
		        // Look up the requested property value
		        Object value = null;
		        if (bean instanceof com.hps.july.cdbc.lib.CDBCRowObject) {
			        value = ((com.hps.july.cdbc.lib.CDBCRowObject)bean).getColumn(getDocstateproperty()).asString();
		        } else {
                	value = PropertyUtils.getProperty(bean, getDocstateproperty());
		        }
                setDocstate((String) value);
            } catch (IllegalAccessException e) {
                throw new JspException(
                    messages.getMessage("getter.access", getDocstatebean(), getDocstateproperty()));
            } catch (InvocationTargetException e) {
                Throwable t = e.getTargetException();
                throw new JspException(
                    messages.getMessage("getter.result", getDocstateproperty(), t.toString()));
            } catch (NoSuchMethodException e) {
                throw new JspException(
                    messages.getMessage("getter.method", getDocstateproperty(), getDocstatebean()));
            }
        } else {
            if (bean instanceof String) {
                setDocstate((String) bean);
            } else {
                throw new JspException(
                    messages.getMessage(
                        "getter.result",
                        beanName,
                        "Instance is not of String type"
                            + ((bean != null) ? ", Class:" + bean.getClass().getName() : ".")));
            }
        }

        if (com.hps.july.web.util.Constants.PRINT_INCOMPLETE)
            return super.doStartTag();
        else {
            if ("2".equals(getDocstate()))
                return super.doStartTag();
            else
                return EVAL_BODY_TAG;
        }
    }
    
    /**
     * Текущее состояние документа (печатаются только обсчитанные документы).
     * Creation date: (18.09.2002 11:38:09)
     * @return java.lang.String
     */
    public java.lang.String getDocstate() {
        return docstate;
    }
    
    /**
     * Алтернативный метод получения состояния документа - bean + property.
     * Creation date: (18.09.2002 12:49:50)
     * @return java.lang.String
     */
    public java.lang.String getDocstatebean() {
        return docstatebean;
    }
    
    /**
     * Алтернативный метод получения состояния документа - bean + property.
     * Creation date: (18.09.2002 12:50:19)
     * @return java.lang.String
     */
    public java.lang.String getDocstateproperty() {
        return docstateproperty;
    }
    
    /**
     * Текущее состояние документа (печатаются только обсчитанные документы).
     * Creation date: (18.09.2002 11:38:09)
     * @param newDocstate java.lang.String
     */
    public void setDocstate(java.lang.String newDocstate) {
        docstate = newDocstate;
    }
    
    /**
     * Алтернативный метод получения состояния документа - bean + property.
     * Creation date: (18.09.2002 12:49:50)
     * @param newDocstatebean java.lang.String
     */
    public void setDocstatebean(java.lang.String newDocstatebean) {
        docstatebean = newDocstatebean;
    }
    
    /**
     * Алтернативный метод получения состояния документа - bean + property.
     * Creation date: (18.09.2002 12:50:19)
     * @param newDocstateproperty java.lang.String
     */
    public void setDocstateproperty(java.lang.String newDocstateproperty) {
        docstateproperty = newDocstateproperty;
    }
}