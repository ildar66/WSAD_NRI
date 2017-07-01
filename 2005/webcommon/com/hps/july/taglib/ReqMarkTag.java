package com.hps.july.taglib;

import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;
/**
 * Обозначение обязательного поля ввода (*).
 * Creation date: (29.04.2002 13:43:45)
 * @author: Dmitry Dneprov
 */
public class ReqMarkTag extends javax.servlet.jsp.tagext.TagSupport {
/**
 * Сonstructor.
 */
public ReqMarkTag() {
	super();
}
/**
 * Обработка открывающего тага
*/	
		public int doStartTag() throws javax.servlet.jsp.JspException {

			HttpServletResponse response =
			  (HttpServletResponse) pageContext.getResponse();
			  
			StringBuffer results = new StringBuffer("");

			results.append("<font class=\"red\">*&nbsp;</font>");

			// Print this field to our output writer
		    ResponseUtils.write(pageContext, results.toString());

			// Continue processing this page
			return (EVAL_BODY_INCLUDE);

		}
}
