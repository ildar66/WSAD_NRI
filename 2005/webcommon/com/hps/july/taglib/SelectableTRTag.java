package com.hps.july.taglib;

import com.hps.july.web.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.http.*;
import org.apache.struts.*;
import org.apache.struts.taglib.html.*;
import org.apache.struts.util.*;

import java.io.*;

/**
 * Insert the type's description here.
 * Creation date: (16.09.2004 14:42:29)
 * @author: Vadim Glushkov
 */
public class SelectableTRTag extends BaseSelectableTag {
	private java.lang.String paramName = "selectedID";
	private java.lang.String selectable = "0";
	private java.lang.String modelName = "list";
	private java.lang.String selectedClass = "color3";
	private java.lang.String name;
    /**
     * Render the end of this form.
     *
     * @exception JspException if a JSP exception has occurred
     */
    public int doEndTag() throws JspException {
	    StringBuffer result = new StringBuffer("</tr>\r\n");
		// Print this value to our output writer
		JspWriter writer = pageContext.getOut();
		try {
		    writer.print(result.toString());
		} catch (IOException e) {
		    throw new JspException
		        (messages.getMessage("common.io", e.toString()));
		}

		// Continue processing this page
		return (EVAL_PAGE);

    }
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

	    if(getStyleClass() == null) setStyleClass("normal");

	    boolean selectableB = false;
	    try {
			selectableB = (getSelectable() != null && "1".equals(getSelectable()))?true:false;
			paramName = getParamName();
			if(!selectableB && paramName == null) {
			    SelectableTableTag wrapper = (SelectableTableTag)findAncestorWithClass(this, SelectableTableTag.class);
			    if(wrapper != null) {
				    selectableB = (wrapper.getSelectable() != null && "1".equals(wrapper.getSelectable()))?true:false;
					paramName = wrapper.getParamName();
			    }
			}
	    } catch(Exception e) {
		}

		String selectableID = getStyleId();
        if(getStyleId() == null) setStyleId(paramName);
        else setStyleId(paramName + getStyleId());

        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		StringBuffer results = new StringBuffer("<tr ");
        if(selectableID != null) {
            results.append(" selectableID=\"");
            results.append(selectableID);
            results.append("\"");
        }
		if(modelName != null) {
			results.append(" modelName=\"");
			results.append(modelName);
			results.append("\"");
		}
        if(getStyleClass() != null) {
            results.append(" class=\"");
            results.append(getStyleClass());
            results.append("\"");
            results.append(" classReal=\"");
            results.append(getStyleClass());
            results.append("\"");
        }
        if(getStyle() != null) {
            results.append(" style=\"");
            results.append(getStyle());
            results.append("\"");
        }
        if(getStyleId() != null) {
            results.append(" id=\"");
            results.append(getStyleId());
            results.append("\"");
        }
        if(getOnclick() != null) {
            results.append(" onclick=\"");
            results.append(getOnclick());
            results.append("\"");
        }
        if(getOnmouseover() != null) {
            results.append(" onmouseover=\"");
            results.append(getOnmouseover());
            results.append("\"");
        }
        if(getOnmouseout() != null) {
            results.append(" onmouseout=\"");
            results.append(getOnmouseout());
            results.append("\"");
        }
		results.append(">");

		// Print this field to our output writer
	    ResponseUtils.write(pageContext, results.toString());

		// Continue processing this page
		return EVAL_BODY_INCLUDE;
    }
/**
 * Insert the method's description here.
 * Creation date: (23.09.2004 20:52:13)
 * @return java.lang.String
 */
public java.lang.String getModelName() {
	return modelName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2004 21:00:46)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2004 20:47:16)
 * @return java.lang.String
 */
public java.lang.String getParamName() {
	return paramName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2004 20:50:15)
 * @return java.lang.String
 */
public java.lang.String getSelectable() {
	return selectable;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2004 20:57:55)
 * @return java.lang.String
 */
public java.lang.String getSelectedClass() {
	return selectedClass;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2004 20:52:13)
 * @param newModelName java.lang.String
 */
public void setModelName(java.lang.String newModelName) {
	modelName = newModelName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2004 21:00:46)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2004 20:47:16)
 * @param newParamName java.lang.String
 */
public void setParamName(java.lang.String newParamName) {
	paramName = newParamName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2004 20:50:15)
 * @param newSelectable java.lang.String
 */
public void setSelectable(java.lang.String newSelectable) {
	if(newSelectable != null && ("1".equals(newSelectable) || "true".equals(newSelectable))) {
		selectable = "1";
	} else selectable = "0";
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2004 20:57:55)
 * @param newSelectedClass java.lang.String
 */
public void setSelectedClass(java.lang.String newSelectedClass) {
	selectedClass = newSelectedClass;
}
}
