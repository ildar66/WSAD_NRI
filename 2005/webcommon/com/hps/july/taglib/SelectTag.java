package com.hps.july.taglib;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import org.apache.struts.util.BeanUtils;
import org.apache.struts.util.MessageResources;
import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;
import javax.servlet.http.*;
//import com.ibm.servlet.jsp.db.*;
import org.apache.struts.util.*;

/**
 * Поле ввода - список выбора.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class SelectTag extends org.apache.struts.taglib.html.SelectTag {

    private java.lang.String insertable;
    private java.lang.String updatable;
    private java.lang.String collection;
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

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
                setStyleClass("editdisabled");
            else
                setStyleClass("edit");
        }

        String beanName = getName();
        if (beanName == null)
            beanName = org.apache.struts.taglib.html.Constants.BEAN_KEY;
        Object bean = pageContext.findAttribute(beanName);
        if (bean == null)
            throw new JspException(messages.getMessage("getter.bean", beanName));

        // Identify the collection itself
        Object acollection = bean;
        if (getCollection() != null) {
            try {
                acollection = PropertyUtils.getProperty(bean, getCollection());
            } catch (IllegalAccessException e) {
                throw new JspException(messages.getMessage("getter.access", property, name));
            } catch (InvocationTargetException e) {
                Throwable t = e.getTargetException();
                throw new JspException(
                    messages.getMessage("getter.result", property, t.toString()));
            } catch (NoSuchMethodException e) {
                throw new JspException(messages.getMessage("getter.method", property, name));
            }
            pageContext.setAttribute(getCollection(), acollection);
        }

        if (getDisabled()) {
            StringBuffer results = new StringBuffer("");

            results.append("<INPUT TYPE=\"HIDDEN\" NAME=\"");
            results.append(getProperty());
            results.append("\" VALUE=\"");
            Object value = RequestUtils.lookup(pageContext, name, property, null);
            if (value == null)
                value = "";
            results.append(ResponseUtils.filter(value.toString()));
            results.append("\"> \r\n");
            // Print this field to our output writer
            ResponseUtils.write(pageContext, results.toString());
        }
        super.doStartTag();

        // Continue processing this page
        return EVAL_BODY_TAG;
    }
    
    /**
     * Коллекция для показа опций.
     * Creation date: (23.05.2002 18:09:27)
     * @return java.lang.String
     */
    public java.lang.String getCollection() {
        return collection;
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
     * Коллекция для показа опций.
     * Creation date: (23.05.2002 18:09:27)
     * @param newCollection java.lang.String
     */
    public void setCollection(java.lang.String newCollection) {
        collection = newCollection;
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