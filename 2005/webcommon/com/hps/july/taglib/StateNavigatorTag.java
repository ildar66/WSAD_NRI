package com.hps.july.taglib;

import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;
import com.hps.july.web.util.*;
import javax.servlet.jsp.PageContext;

/**
 * Таг вывода автоматического навигатора режимов.
 * Creation date: (29.04.2002 13:43:45)
 * @author: Dmitry Dneprov
 */
public class StateNavigatorTag extends javax.servlet.jsp.tagext.TagSupport {
/**
 * Сonstructor.
 */
public StateNavigatorTag() {
	super();
}
/**
 * Обработка открывающего тага
*/	
		public int doStartTag() throws javax.servlet.jsp.JspException {

			HttpServletResponse response =
			  (HttpServletResponse) pageContext.getResponse();
			  
			StringBuffer results = new StringBuffer("");

			StateNavigator nav = (StateNavigator)pageContext.getAttribute(StateNavigator.NAVIGATOR_PARAM, 
				PageContext.SESSION_SCOPE);

			if (nav != null) {

				Iterator it = nav.getNSIterator();
				boolean isFirst = true;
				while (it.hasNext()) {
					if (!isFirst) {
						results.append("&nbsp;<img src=\"/images/strelka.gif\" border=\"0\" alt=\"\">&nbsp;");
					} else {
						isFirst = false;
					}
					StateNavigatorObject so = (StateNavigatorObject)it.next();

					// Do not show link for the last object
					if (it.hasNext()) {
						results.append("<A HREF='" + nav.makeLinkUrl(so) + "' ");
						results.append(" onclick='document.body.style.cursor=\"wait\";' ");
						results.append(" class='navigator'>" + so.getName() + "</A>");
					} else {
						results.append("<font class=\"attention\"><b>");
						results.append(so.getName());
						results.append("</b></font>");
					}
				}

				// Print this field to our output writer
			    ResponseUtils.write(pageContext, results.toString());
			} else {
				System.out.println("NO navigator in REQUEST");
			}

			// Continue processing this page
			return (EVAL_BODY_INCLUDE);

		}
}
