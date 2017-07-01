package com.hps.july.taglib;

import javax.servlet.http.*;
//import com.ibm.servlet.jsp.db.*;
import org.apache.struts.util.*;

/**
 * Таг для отображения наименования текущего action: Добавить/Изменить/Удалить.
 * Для использования в навигаторе страниц.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class ActionAlertTag extends org.apache.struts.taglib.html.BaseFieldTag {


	
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

        Object hasChildren = null;
        try {
          hasChildren = RequestUtils.lookup(pageContext, name, "children", "request");
        } catch(Exception e) {
        }
        
	    results.append("<FONT class=\"attention\">");
        if ("Delete".equals(valueAction)) {
	    	results.append("<B>Режим удаления записи</B>");
	    	if(hasChildren != null && hasChildren instanceof Boolean && ((Boolean)hasChildren).booleanValue()) {
		    	results.append("<br>");
		    	results.append("<b>Внимание! Документ содержит строки. Подтвердите удаление документа...</b>");
	    	}
        } else if ("Add".equals(valueAction)) {
	    	results.append("<B>Режим добавления записи</B>");
        } else if ("Edit".equals(valueAction)) {
	    	results.append("<B>Режим редактирования записи</B>");
        } else if ("View".equals(valueAction)) {
	    	results.append("<B>Просмотр данных</B>");
        } else {
	    	results.append(valueAction);
        }
	    results.append("</FONT>");
	     
		// Print this field to our output writer
	    ResponseUtils.write(pageContext, results.toString());

		// Continue processing this page
		return (EVAL_BODY_TAG);
	}
}
