package com.hps.july.apptags;

import java.util.StringTokenizer;
import javax.servlet.http.*;
import org.apache.struts.util.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * “аг описани€ полей возврата из lookup, генерирует javascript.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class LookupResultTag extends org.apache.struts.taglib.html.BaseFieldTag {


	
	private java.lang.String resultCols;
	private java.lang.String tableId;
		public int doStartTag() throws javax.servlet.jsp.JspException {

        DebugSupport.printlnTest("LookupResultTag started");
		// Create an appropriate "form" element based on our parameters
		HttpServletResponse response =
		  (HttpServletResponse) pageContext.getResponse();
		  
		StringBuffer results = new StringBuffer("<SCRIPT language=\"JScript\">");

		results.append("var myObject = new Object();");

		results.append("function setParams(fName");
		StringTokenizer st = new StringTokenizer(resultCols, ";");
		int i = 0;
		while (st.hasMoreTokens()) {
			i++;
			results.append(", field_" + i );
			st.nextToken();
		}
		results.append(") {");
		results.append("  myObject.fName = fName;");
		st = new StringTokenizer(resultCols, ";");
		i = 0;
		while (st.hasMoreTokens()) {
			i++;
			results.append(" myObject.field_" + i + " = field_" + i + ";");
			st.nextToken();
		}
		results.append("}");

		results.append("function retval(code) {");
		results.append("  if (code != 0) {");
		
		st = new StringTokenizer(resultCols, ";");
		i = 0;
		while (st.hasMoreTokens()) {
			i++;
			//results.append("    opener.document.forms(myObject.fName).elements(myObject.field_" + i + ").value =");
			
			results.append("    opener.document.all.item(myObject.field_" + i + ").value =");
			results.append("       document.all." + getTableId() + ".rows(code).cells(" + st.nextToken() + ").innerText;");
		}
		
		results.append("  }");
		results.append("  window.close();");
		results.append("}");

		results.append("opener.execScript(\"lookup_params()\");");
		
		results.append("</SCRIPT>");
  
		
		// Print this field to our output writer
	    ResponseUtils.write(pageContext, results.toString());

		// Continue processing this page
		return (EVAL_BODY_TAG);

	}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2002 11:26:52)
 * @return java.lang.String
 */
public java.lang.String getResultCols() {
	return resultCols;
}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2002 11:27:31)
 * @return java.lang.String
 */
public java.lang.String getTableId() {
	return tableId;
}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2002 11:26:52)
 * @param newResultCols java.lang.String
 */
public void setResultCols(java.lang.String newResultCols) {
	resultCols = newResultCols;
}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2002 11:27:31)
 * @param newTableId java.lang.String
 */
public void setTableId(java.lang.String newTableId) {
	tableId = newTableId;
}
}
