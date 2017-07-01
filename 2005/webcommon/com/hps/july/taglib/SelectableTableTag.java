package com.hps.july.taglib;

import com.hps.july.web.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.apache.struts.util.*;

import java.io.*;

/**
 * Insert the type's description here.
 * Creation date: (08.09.2004 11:32:18)
 * @author: Vadim Glushkov
 */
public class SelectableTableTag extends SelectableTRTag {
    /**
     * Render the end of this form.
     *
     * @exception JspException if a JSP exception has occurred
     */
    public int doEndTag() throws JspException {

	    
		StringBuffer result = new StringBuffer("</table> ");

		if (getSelectable() != null && "1".equals(getSelectable())) {
			String selectedId = null;
			String nextSelectedId = null;
			try {
				Profile profile = (Profile)pageContext.getSession().getAttribute(Profile.PROFILE);
				if(profile != null) {
					selectedId = profile.getSelectableCurrentParameter(profile.getCurrentURL(), getParamName());
					nextSelectedId = profile.getSelectableNextParameter(profile.getCurrentURL(), getParamName());
				}
				//selectedId = pageContext.getRequest().getParameter(paramName);
			} catch(Exception e) {}
			if(selectedId == null) selectedId = "";
			if(nextSelectedId == null) nextSelectedId = "";
			String anotherParamName = "selectable_" + getParamName();
		    result.append("\r\n");
			result.append("    <script src='/jsSelectableTable.js'></script>\r\n");
			result.append("    <input type='hidden' name='" + anotherParamName + "' id='" + anotherParamName + "' value='" + selectedId + "'/>\r\n");
			result.append("    <input type='hidden' name='" + anotherParamName + "_next' id='" + anotherParamName + "_next' value='" + nextSelectedId + "'/>\r\n");
			result.append("    <script language='javascript'>\r\n");
			result.append("        <!-- \r\n");
			result.append("			try { \r\n");
			result.append("            var ");
			result.append(getModelName());
			result.append(" = new SelectableTable(); \r\n");
			result.append("            var table = document.getElementById('" + getStyleId() + "');\r\n");
			result.append("            " + getModelName() + ".setItem(table);                   \r\n");
			result.append("            " + getModelName() + ".setSelectedClass('" + getSelectedClass() + "');\r\n");
			result.append("            " + getModelName() + ".setParamName('" + getParamName() + "');\r\n");
			result.append("            var id = document.getElementById('" + anotherParamName + "');\r\n");
			result.append("            " + getModelName() + ".setSelectedId(id.value);\r\n");
			result.append("            " + getModelName() + ".setSelectedRow();\r\n");
			result.append("			} catch(e){} \r\n");
			result.append("        -->\r\n");
			result.append("    </script>\r\n");
		}

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

        if (getStyleId() == null) {
	        long millis = System.currentTimeMillis();
	        String sMils = (new Long(millis)).toString();
	        sMils = sMils.substring(sMils.length() - 5);
            setStyleId("tableID" + sMils);
        }

		HttpServletResponse response =
		  (HttpServletResponse) pageContext.getResponse();
		StringBuffer results = new StringBuffer("<table ");
		if(getSelectable() != null && "1".equals(getSelectable())) {
			results.append(" itype=\"selectableTable\" ");
		}
		if(getName() != null) {
			results.append(" name=\"");
			results.append(getName());
			results.append("\"");
		}
		if(getModelName() != null) {
			results.append(" modelName=\"");
			results.append(getModelName());
			results.append("\"");
		}
        if (getStyleClass() != null) {
            results.append(" class=\"");
            results.append(getStyleClass());
            results.append("\"");
        }
        if (getStyle() != null) {
            results.append(" style=\"");
            results.append(getStyle());
            results.append("\"");
        }
        if (getStyleId() != null) {
            results.append(" id=\"");
            results.append(getStyleId());
            results.append("\"");
        }
		results.append(">");

	    ResponseUtils.write(pageContext, results.toString());

		return EVAL_BODY_INCLUDE;
    }
}
