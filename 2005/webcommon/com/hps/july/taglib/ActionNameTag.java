package com.hps.july.taglib;

import javax.servlet.http.*;
//import com.ibm.servlet.jsp.db.*;
import org.apache.struts.util.*;

/**
 * Таг для отображения наименования текущего action: Добавить/Изменить/Удалить.
 * Для использования в заголовке формы редактирования.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class ActionNameTag extends org.apache.struts.taglib.html.BaseFieldTag {


	
/**
 * Обработка открывающего тага
*/	
		public int doStartTag() throws javax.servlet.jsp.JspException {

		// Create an appropriate "form" element based on our parameters
		HttpServletResponse response =
		  (HttpServletResponse) pageContext.getResponse();
		  
		StringBuffer results = new StringBuffer("");
		
        // Look up the requested property value
        Object valueAction =
          RequestUtils.lookup(pageContext, name, "action", "request");
        
	    results.append("<FONT class=\"attention\"><B>");
        if ("Delete".equals(valueAction))
	    	results.append("Удалить");
        else if ("Add".equals(valueAction))
	    	results.append("Добавить");
        else if ("Edit".equals(valueAction))
	    	results.append("Изменить");
        else if ("View".equals(valueAction))
	    	results.append("Просмотр");
        else
	    	results.append(valueAction);
	    results.append("</B></FONT>");
	     
		
		// Print this field to our output writer
	    ResponseUtils.write(pageContext, results.toString());

		// Continue processing this page
		return (EVAL_BODY_TAG);

	}
}
