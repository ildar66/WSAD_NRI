package com.hps.july.taglib;

import javax.servlet.http.*;
//import com.ibm.servlet.jsp.db.*;
import org.apache.struts.util.*;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import javax.servlet.jsp.PageContext;

/**
 * Поле ввода типа строка.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class StringTag extends org.apache.struts.taglib.html.BaseFieldTag {

    private java.lang.String insertable;
    private java.lang.String updatable;
    private java.lang.String mask;

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

        // Специальный случай - если есть ошибки с именем свойства - отобразим их
        ActionErrors errors = (ActionErrors)pageContext.getAttribute(Action.ERROR_KEY, PageContext.REQUEST_SCOPE);
        if (errors != null) {
        	java.util.Iterator reports = errors.get(property);
        	if (reports.hasNext()) {
	        	if (getStyle() == null)
	        		setStyle("");
	        	setStyle(getStyle() + ";background-color: #FF7F9A;");
            	ActionError report = (ActionError) reports.next();
				String            	message =
                RequestUtils.message(
                    pageContext,
                    Action.MESSAGES_KEY,
                    Action.LOCALE_KEY,
                    report.getKey(),
                    report.getValues());
	        	setTitle( ((message != null) ? message : report.getKey()));
        	}
        }
            
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
     * Маска ввода. Пока не реализовано.
     * Creation date: (30.01.2002 10:44:33)
     * @return java.lang.String
     */
    public java.lang.String getMask() {
        return mask;
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

        if (cols == null)
            setSize("10");
        if (getStyleClass() == null) {
            if (Integer.parseInt(cols) <= 5)
                setStyleClass("editkod");
            else
                if (Integer.parseInt(cols) <= 10)
                    setStyleClass("editsmall");
                else
                    if (Integer.parseInt(cols) < 30)
                        setStyleClass("edit");
                    else
                        if (Integer.parseInt(cols) < 40)
                            setStyleClass("editbig");
                        else
                            setStyleClass("editbigest");
        }

        StringBuffer results = new StringBuffer("<INPUT TYPE=\"TEXT\" ");
        if (cols != null) {
            results.append(" SIZE=\"");
            results.append(cols);
            results.append("\" ");
        }
        if (maxlength != null) {
            results.append(" MAXLENGTH=\"");
            results.append(maxlength);
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
        results.append(" VALUE=\"");
        Object value = RequestUtils.lookup(pageContext, name, property, null);
        if (value == null)
            value = "";
        results.append(ResponseUtils.filter(value.toString().trim()));
        results.append("\" ");
        if (getTitle() == null)
            setTitle(ResponseUtils.filter(value.toString().trim()));
        return results.toString();
    }
    /**
     * Подготовка тага к просмотру
    */
    public String prepareViewTag() throws javax.servlet.jsp.JspException {

        if (getStyleClass() == null) {
            if (Integer.parseInt(cols) <= 5)
                setStyleClass("editkoddisabled");
            else
                if (Integer.parseInt(cols) <= 10)
                    setStyleClass("editsmalldisabled");
                else
                    if (Integer.parseInt(cols) < 30)
                        setStyleClass("editdisabled");
                    else
                        if (Integer.parseInt(cols) < 40)
                            setStyleClass("editbigdisabled");
                        else
                            setStyleClass("editbigestdisabled");
        }

        StringBuffer results = new StringBuffer(prepareEditTag());
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
     * Маска ввода. Пока не реализовано.
     * Creation date: (30.01.2002 10:44:33)
     * @param newMask java.lang.String
     */
    public void setMask(java.lang.String newMask) {
        mask = newMask;
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
