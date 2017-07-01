package com.hps.july.taglib;

import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;
/**
 * Таг вывода элемента дизайна - разделителя строк.
 * Creation date: (29.04.2002 13:43:45)
 * @author: Dmitry Dneprov
 */
public class SeparatorTag extends javax.servlet.jsp.tagext.TagSupport {
	private java.lang.String colspan;
	private java.lang.String trid;
/**
 * Сonstructor.
 */
public SeparatorTag() {
	super();
}
/**
 * Обработка открывающего тага
*/	
		public int doStartTag() throws javax.servlet.jsp.JspException {

			HttpServletResponse response =
			  (HttpServletResponse) pageContext.getResponse();
			  
			StringBuffer results = new StringBuffer("");

			results.append("<tr");
			if (getTrid() != null)
				results.append(" ID=\"" + getTrid() + "\" ");
			results.append("> \r\n");
    		results.append("<td class=\"probel\" colspan=\"");
    		if (getColspan() != null)
    			results.append(getColspan());
    		else
    			results.append("2");
    		results.append("\"><img src=\"/images/empty.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\"></td> \r\n");
			results.append("</tr> \r\n");


			// Print this field to our output writer
		    ResponseUtils.write(pageContext, results.toString());

			// Continue processing this page
			return (EVAL_BODY_INCLUDE);

		}
/**
 * Параметр colspan - используется для форматирования во внутреннем таге <TD>.
 * Creation date: (23.05.2002 11:56:16)
 * @return java.lang.String
 */
public java.lang.String getColspan() {
	return colspan;
}
/**
 * Присваивает ID внутреннему тагу <TR> для использования в JavaScript-e.
 * Creation date: (26.11.2003 16:15:46)
 * @return java.lang.String
 */
public java.lang.String getTrid() {
	return trid;
}
/**
 * Параметр colspan - используется для форматирования во внутреннем таге <TD>.
 * Creation date: (23.05.2002 11:56:16)
 * @param newColspan java.lang.String
 */
public void setColspan(java.lang.String newColspan) {
	colspan = newColspan;
}
/**
 * Присваивает ID внутреннему тагу <TR> для использования в JavaScript-e.
 * Creation date: (26.11.2003 16:15:46)
 * @param newTrid java.lang.String
 */
public void setTrid(java.lang.String newTrid) {
	trid = newTrid;
}
}
