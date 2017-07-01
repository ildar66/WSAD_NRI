package com.hps.july.taglib;

import org.apache.struts.util.*;

/**
 * Insert the type's description here.
 * Creation date: (09.09.2004 14:35:53)
 * @author: Vadim Glushkov
 */
public class AnchorLinkTag extends LinkTag {
   /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

	    boolean selectableB = false;
	    String paramName = null;
	    try {
		    SelectableTRTag wrapper1 = (SelectableTRTag)findAncestorWithClass(this, SelectableTRTag.class);
		    if(wrapper1 != null) {
			    selectableB = (wrapper1.getSelectable() != null && "1".equals(wrapper1.getSelectable()))?true:false;
			    if(!selectableB) {
				    SelectableTableTag wrapper = (SelectableTableTag)findAncestorWithClass(this, SelectableTableTag.class);
				    if(wrapper != null) {
					    selectableB = (wrapper.getSelectable() != null && "1".equals(wrapper.getSelectable()))?true:false;
				    }
			    }
				paramName = wrapper1.getParamName();
				id = wrapper1.getStyleId();
		    } else {
			    SelectableTableTag wrapper = (SelectableTableTag)findAncestorWithClass(this, SelectableTableTag.class);
			    if(wrapper != null) {
				    selectableB = (wrapper.getSelectable() != null && "1".equals(wrapper.getSelectable()))?true:false;
					paramName = wrapper.getParamName();
			    }
		    }
	    } catch(Exception e) {
		}
	    if(selectableB) {
		    if(id != null) {
	            StringBuffer results = new StringBuffer("<a name=\"");
	            results.append(id);
	            results.append("\">");
	            ResponseUtils.write(pageContext, results.toString());
			}
	    } else {
	        if(name != null) {
	            StringBuffer results = new StringBuffer("<a name=\"");
	            results.append(name);
	            results.append("\">");
	            ResponseUtils.write(pageContext, results.toString());
	        }
	    }
        return EVAL_BODY_TAG;
    }
}
