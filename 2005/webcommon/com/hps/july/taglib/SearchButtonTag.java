package com.hps.july.taglib;

import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;
/**
 * Кнопка "поиск". Используется в Browse для отправки параметров фильтра на сервер.
 * Creation date: (29.04.2002 13:43:45)
 * @author: Dmitry Dneprov
 */
public class SearchButtonTag extends javax.servlet.jsp.tagext.TagSupport {
/**
 * Сonstructor.
 */
public SearchButtonTag() {
	super();
}
/**
 * Обработка открывающего тага
*/	
		public int doStartTag() throws javax.servlet.jsp.JspException {

			HttpServletResponse response =
			  (HttpServletResponse) pageContext.getResponse();
			  
			StringBuffer results = new StringBuffer("");

			results.append("&nbsp;<INPUT TYPE='image' src='/images/refresh.gif'  onclick='document.body.style.cursor=\"wait\"' border='0' alt='Искать'>");

			// Print this field to our output writer
		    ResponseUtils.write(pageContext, results.toString());

			// Continue processing this page
			return (EVAL_BODY_INCLUDE);

		}
}
