package com.hps.july.taglib;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.web.util.BrowseForm;
import javax.servlet.jsp.tagext.*;
import org.apache.struts.taglib.html.*;
import javax.servlet.jsp.PageContext;
import org.apache.struts.util.*;

/**
 * Кнопка печати содержимого текущего окна.
 * Creation date: (27.06.2002 17:22:10)
 * @author: Dmitry Dneprov
 */
public class PrinterButtonTag extends TagSupport {
/**
 * Обработка открывающего тага
*/	
		public int doStartTag() throws javax.servlet.jsp.JspException {

		    StringBuffer results = new StringBuffer("");
			
	        // Generate the opening anchor element
			results.append("<A HREF='#'><IMG SRC=\"/images/print.gif\" BORDER='0' onclick='window.print()' ALT='Напечатать'></A>");
			results.append("<IMG SRC=\"/images/empty.gif\" BORDER='0' ALT='' WIDTH='3'>");
			
			// Print this element to our output writer
		    ResponseUtils.write(pageContext, results.toString());

			// Evaluate the body of this tag
			return EVAL_BODY_INCLUDE;

		}
}
