/*
 * Created on 18.08.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.taglib;
import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;

/**
 * @author irogachev
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class WordEditMasterTag extends javax.servlet.jsp.tagext.TagSupport {
	private java.lang.String styleId;
/**
 * WordEditTag constructor.
 */
public WordEditMasterTag() {
	super();
}

		/**
		 * Обработка открывающего тага
		*/	
		public int doStartTag() throws javax.servlet.jsp.JspException {

			HttpServletResponse response =
			  (HttpServletResponse) pageContext.getResponse();
			HttpServletRequest request =
			  (HttpServletRequest) pageContext.getRequest();

			StringBuffer results = new StringBuffer("");

			results.append("<SPAN style='display:none; visibility: hidden;'><OBJECT  ID=\"" + getStyleId() + "\" WIDTH=1 HEIGHT=1 ");
			results.append(" CODEBASE=\"/nriword.cab\" \r\n");
			results.append("CLASSID=\"CLSID:9B91E4FE-5713-41FF-BF1A-3933E379E847\">\r\n");
			results.append("</OBJECT></SPAN>\r\n");
			
			// Print this field to our output writer
			ResponseUtils.write(pageContext, results.toString());

			// Continue processing this page
			return (EVAL_BODY_INCLUDE);

		}
/**
 * Атрибут ID для обращения к тагу из JavaScript.
 * Creation date: (23.01.2004 14:50:36)
 * @return java.lang.String
 */
public java.lang.String getStyleId() {
	return styleId;
}
/**
 * Атрибут ID для обращения к тагу из JavaScript.
 * Creation date: (23.01.2004 14:50:36)
 * @param newStyleId java.lang.String
 */
public void setStyleId(java.lang.String newStyleId) {
	styleId = newStyleId;
}
}
