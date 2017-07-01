package com.hps.july.apptags;

import org.apache.struts.taglib.html.*;
import org.apache.struts.action.ActionFormBean;
import java.net.MalformedURLException;
import java.util.StringTokenizer;
import javax.servlet.http.*;
import org.apache.struts.util.*;
import javax.servlet.jsp.JspException;
import com.hps.july.taglib.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Кнопка вызова lookup-окна.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class LookupButtonTag extends org.apache.struts.taglib.html.BaseFieldTag {
	private String width;
	private String height;
	private java.lang.String action;
	private java.lang.String fieldNames;
	private java.lang.String newWindowName;
	private java.lang.String insertable;
	private java.lang.String updatable;
	private String href;
	private String formId;
		public int doStartTag() throws javax.servlet.jsp.JspException {

		// Create an appropriate "form" element based on our parameters
		DebugSupport.printlnTest("LookupButtonTag started");
		
		HttpServletResponse response =
		  (HttpServletResponse) pageContext.getResponse();
		  
		StringBuffer results = new StringBuffer("");
		
        // Look up the requested property value
        Object valueAction =
          RequestUtils.lookup(pageContext, name, "action", "request");

		if(width == null || "".equals(width)) {
			width = "830";
		}
		if(height == null || "".equals(height)) {
			height = "630";
		}
		
        if ("Add".equals(valueAction)) {
	        if ("true".equals(insertable))
          		results.append(prepareEditTag());
	        else
          		results.append(prepareViewTag());
        } else if ("Edit".equals(valueAction)) {
	        if ("true".equals(updatable))
          		results.append(prepareEditTag());
	        else
          		results.append(prepareViewTag());
        } else if ("Delete".equals(valueAction)) {
          	results.append(prepareViewTag());
        } else if ("View".equals(valueAction)) {
          	results.append(prepareViewTag());
        } else
          	results.append(prepareEditTag());
    
		// Print this field to our output writer
	    ResponseUtils.write(pageContext, results.toString());

		// Continue processing this page
		return (EVAL_BODY_TAG);

	}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2002 10:45:19)
 * @return java.lang.String
 */
public java.lang.String getAction() {
	return action;
}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2002 10:59:05)
 * @return java.lang.String
 */
public java.lang.String getFieldNames() {
	return fieldNames;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 13:31:29)
 * @return java.lang.String
 */
public java.lang.String getFormId() {
	return formId;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHeight() {
	return height;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 12:30:10)
 * @return java.lang.String
 */
public java.lang.String getHref() {
	return href;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 12:12:22)
 * @return java.lang.String
 */
public java.lang.String getInsertable() {
	return insertable;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 17:14:15)
 * @return java.lang.String
 */
public java.lang.String getNewWindowName() {
	return newWindowName;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 12:12:49)
 * @return java.lang.String
 */
public java.lang.String getUpdatable() {
	return updatable;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getWidth() {
	return width;
}
public String prepareEditTag() throws javax.servlet.jsp.JspException {

    StringBuffer results = new StringBuffer("<SCRIPT language=\"JScript\">");

    results.append(" var opt_params_" + getStyleId() + " = \"\"; ");

    results.append("function set_opt_params_" + getStyleId() + "(paramStr) {");
    results.append("  opt_params_" + getStyleId() + " = paramStr;");
    results.append("}");

    results.append("function lookup_params_" + getStyleId() + "() {");
    /*
    FormTag wrapper = (FormTag)findAncestorWithClass(this, EditFormTag.class);
    if (wrapper == null)
    	wrapper = (FormTag)findAncestorWithClass(this, BrowseFormTag.class);
    results.append("  myWindow.execScript(\"setParams('" + wrapper.getStyleId() + "'");
    */
    try {
        FormTag wrapper = (FormTag) findAncestorWithClass(this, EditFormTag.class);
        if (wrapper == null)
            wrapper = (FormTag) findAncestorWithClass(this, BrowseFormTag.class);
        results.append(
            "  myWindow.execScript(\"setParams('" + wrapper.getStyleId() + "'");
    } catch (Exception e) {
        if (getFormId() != null) {
            results.append("  myWindow.execScript(\"setParams('" + getFormId() + "'");
        } else {
            results.append("  myWindow.execScript(\"setParams('" + "notused" + "'");
        }

    }

    //alex
    StringTokenizer st = new StringTokenizer(fieldNames, ";");
    while (st.hasMoreTokens())
        results.append(", '" + st.nextToken() + "'");
    results.append(")\");");
    results.append("  return 0;");
    results.append("}");

    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

    //String url = request.getContextPath() + getAction();
    //alexshr
    String url;
    if (getAction() != null) {
        url = request.getContextPath() + getAction();
    } else if (getHref() != null) {
        url = getHref();
    } else {
        throw new JspException("action or href attributes must be defined!!");
    }

    if (getNewWindowName() == null)
        setNewWindowName("myWindow");

    results.append("function lookup_" + getStyleId() + "() {\n");
    results.append(
        "  if(document.all['lookupimg_"
            + getStyleId()
            + "'].src.substr(document.all['lookupimg_"
            + getStyleId()
            + "'].src.length-12,12) == 'disabled.gif') { return; } ");
    results.append(
        "  String.prototype.lookup = lookup_params_" + getStyleId() + ";");
    results.append(
        "  myWindow = window.open(\""
            + url
            + "\" + opt_params_"
            + getStyleId()
            + ", \""
            + getNewWindowName()
            + "\", \"top=40, left=100, width="
            + getWidth()
            + ", height="
            + getHeight()
            + ", scrollbars=yes, resizable=yes\");");
    results.append("  myWindow.focus();");
    results.append("}");
    results.append("</SCRIPT>");

    if (getOnclick() != null)
        results.append(
            "<A HREF=\"#\" name=\"lookupbtn_"
                + getStyleId()
                + "\" onclick=\""
                + getOnclick()
                + ";"
                + "lookup_"
                + getStyleId()
                + "(); return false;\"><img name=\"lookupimg_"
                + getStyleId()
                + "\" src=\"/images/lookup.gif\" border=\"0\" alt=\"Справочник\"></A>");
    else
        results.append(
            "<A HREF=\"#\" name=\"lookupbtn_"
                + getStyleId()
                + "\" onclick=\"lookup_"
                + getStyleId()
                + "(); return false;\"><img name=\"lookupimg_"
                + getStyleId()
                + "\" src=\"/images/lookup.gif\" border=\"0\" alt=\"Справочник\"></A>");

    return results.toString();
}
	public String prepareViewTag() throws javax.servlet.jsp.JspException {
		StringBuffer results = new StringBuffer("<img src=\"/images/lookup_disabled.gif\" border=\"0\" alt=\"Справочник\">");
		return results.toString();
	}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2002 10:45:19)
 * @param newAction java.lang.String
 */
public void setAction(java.lang.String newAction) {
	action = newAction;
}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2002 10:59:05)
 * @param newFieldNames java.lang.String
 */
public void setFieldNames(java.lang.String newFieldNames) {
	fieldNames = newFieldNames;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 13:31:29)
 * @param newFormId java.lang.String
 */
public void setFormId(java.lang.String newFormId) {
	formId = newFormId;
}
/**
 * 
 * @param newHeight java.lang.String
 */
public void setHeight(java.lang.String newHeight) {
	height = newHeight;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 12:30:10)
 * @param newHref java.lang.String
 */
public void setHref(java.lang.String newHref) {
	href = newHref;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 12:12:22)
 * @param newInsertable java.lang.String
 */
public void setInsertable(java.lang.String newInsertable) {
	insertable = newInsertable;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 17:14:15)
 * @param newNewWindowName java.lang.String
 */
public void setNewWindowName(java.lang.String newNewWindowName) {
	newWindowName = newNewWindowName;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 12:12:49)
 * @param newUpdatable java.lang.String
 */
public void setUpdatable(java.lang.String newUpdatable) {
	updatable = newUpdatable;
}
/**
 * 
 * @param newWidth java.lang.String
 */
public void setWidth(java.lang.String newWidth) {
	width = newWidth;
}
}
