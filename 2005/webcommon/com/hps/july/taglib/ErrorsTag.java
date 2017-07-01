package com.hps.july.taglib;

import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.util.BeanUtils;
import org.apache.struts.util.ErrorMessages;
import org.apache.struts.util.MessageResources;
import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;

/**
 * Вывод сообщений об ошибках с красивым форматированием.
 * Creation date: (19.04.2002 10:59:47)
 * @author: Dmitry Dneprov
 */
public class ErrorsTag extends org.apache.struts.taglib.html.ErrorsTag {

    private java.lang.String shortformat;
    private java.lang.String color= "red";
    private java.lang.String headerKey =  "errors.header";
    private java.lang.String footerKey = "errors.footer";
/**
 * Конструктор.
 * Creation date: (18.10.2004 20:55:34)
 */
public ErrorsTag() {
	setShortformat("false");
}
/**
 * Обработка открывающего тага
*/
public int doStartTag() throws JspException {

    // Were any error messages specified?
    ActionErrors errors = new ActionErrors();
    try {
        Object value = pageContext.getAttribute(name, PageContext.REQUEST_SCOPE);
        if (value == null) {
            ;
        } else
            if (value instanceof String) {
                errors.add(ActionErrors.GLOBAL_ERROR, new ActionError((String) value));
            } else
                if (value instanceof String[]) {
                    String keys[] = (String[]) value;
                    for (int i = 0; i < keys.length; i++)
                        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(keys[i]));
                } else
                    if (value instanceof ErrorMessages) {
                        String keys[] = ((ErrorMessages) value).getErrors();
                        if (keys == null)
                            keys = new String[0];
                        for (int i = 0; i < keys.length; i++)
                            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(keys[i]));
                    } else
                        if (value instanceof ActionErrors) {
                            errors = (ActionErrors) value;
                        } else {
                            JspException e = new JspException(messages.getMessage("errorsTag.errors", value.getClass().getName()));
                            RequestUtils.saveException(pageContext, e);
                            throw e;
                        }
    } catch (Exception e) {
        ;
    }
    if (errors.empty())
        return (EVAL_BODY_INCLUDE);

    Iterator reports = null;
    if (property == null)
        reports = errors.get();
    else
        reports = errors.get(property);

    if (!reports.hasNext())
        return EVAL_BODY_INCLUDE;        

    // Check for presence of header and footer message keys
    boolean headerPresent = RequestUtils.present(pageContext, bundle, locale, headerKey);
    boolean footerPresent = RequestUtils.present(pageContext, bundle, locale, footerKey);

    boolean isShortFormat = "true".equalsIgnoreCase(getShortformat());
    if (isShortFormat) {
        headerPresent = false;
        footerPresent = false;
    }

    // Temproraly exclude some applications from navigation
    boolean isNewNavigator = false;
    int app = 0;
    try {
        app =
            Integer.parseInt(
                (String) pageContext.getRequest().getAttribute(com.hps.july.web.util.ParamsParser.APPLICATION_PARAM_NAME));
    } catch (Exception e) {
        e.printStackTrace(System.out);
    }

    if (com.hps.july.web.util.NavigatedAction.isNavigateModule(app)) {
        isNewNavigator = true;
    }

    // Render the error messages appropriately
    StringBuffer results = new StringBuffer();

    if (!isNewNavigator && !isShortFormat)
        results.append("<TABLE class='main' width='100%' valign='top' style='height:20'>");
    String message = null;
    if (headerPresent)
        message = RequestUtils.message(pageContext, bundle, locale, headerKey);
    if (message != null) {
        results.append(
            "<TR style='height:10'><TD valign='top'><FONT class='" + color + "'><B>" + message + "</B></FONT></TD></TR>");
        results.append("\r\n");
    }

    if (!isShortFormat)
        results.append("<TR style='height:10'><TD valign='top'><FONT class='" + color + "'><UL>");

    while (reports.hasNext()) {
        ActionError report = (ActionError) reports.next();
        message = RequestUtils.message(pageContext, bundle, locale, report.getKey(), report.getValues());
        results.append("<FONT class='" + color + "'><LI>" + ((message != null) ? message : report.getKey()) + "</LI></FONT>");
        results.append("\r\n");
    }
    if (!isShortFormat)
        results.append("</UL></FONT></TD></TR>");
    message = null;
    if (footerPresent)
        message = RequestUtils.message(pageContext, bundle, locale, footerKey);
    if (message != null) {
        results.append("<TR style='height:10'><TD><FONT class='" + color + "'>" + message + "</FONT></TD></TR>");
        results.append("\r\n");
    }

    if (!isNewNavigator && !isShortFormat)
        results.append("</TABLE>");

    results.append("\r\n");

    // Print the results to our output writer
    ResponseUtils.write(pageContext, results.toString());

    // Continue processing this page
    return (EVAL_BODY_INCLUDE);
}
/**
 * Insert the method's description here.
 * Creation date: (01.12.2004 16:55:33)
 * @return java.lang.String
 */
public java.lang.String getColor() {
	return color;
}
/**
 * Insert the method's description here.
 * Creation date: (01.12.2004 17:04:29)
 * @return java.lang.String
 */
public java.lang.String getFooterKey() {
	return footerKey;
}
/**
 * Insert the method's description here.
 * Creation date: (01.12.2004 17:04:29)
 * @return java.lang.String
 */
public java.lang.String getHeaderKey() {
	return headerKey;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 20:55:17)
 * @return java.lang.String
 */
public java.lang.String getShortformat() {
	return shortformat;
}
/**
 * Insert the method's description here.
 * Creation date: (01.12.2004 16:55:33)
 * @param newColor java.lang.String
 */
public void setColor(java.lang.String newColor) {
	color = newColor;
}
/**
 * Insert the method's description here.
 * Creation date: (01.12.2004 17:04:29)
 * @param newFooterKey java.lang.String
 */
public void setFooterKey(java.lang.String newFooterKey) {
	footerKey = newFooterKey;
}
/**
 * Insert the method's description here.
 * Creation date: (01.12.2004 17:04:29)
 * @param newHeaderKey java.lang.String
 */
public void setHeaderKey(java.lang.String newHeaderKey) {
	headerKey = newHeaderKey;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 20:55:17)
 * @param newShortformat java.lang.String
 */
public void setShortformat(java.lang.String newShortformat) {
	shortformat = newShortformat;
}
}
