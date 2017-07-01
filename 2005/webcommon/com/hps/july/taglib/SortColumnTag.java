package com.hps.july.taglib;

import javax.servlet.http.*;
//import com.ibm.servlet.jsp.db.*;
import org.apache.struts.util.*;

/**
 * ��� ������������ ������� ���������� � Browse.
 * Creation date: (29.04.2002 13:43:45)
 * @author: Dmitry Dneprov
 */

public class SortColumnTag extends org.apache.struts.taglib.bean.MessageTag {
	private java.lang.String colspan;
	private java.lang.String rowspan;
	private java.lang.String ascFinder;
	private java.lang.String descFinder;
	private java.lang.String colType;
	private java.lang.String style;
/**
 * ��������� ������������ ����
*/	
	public int doStartTag() throws javax.servlet.jsp.JspException {

		// Create an appropriate "form" element based on our parameters
		HttpServletResponse response =
		  (HttpServletResponse) pageContext.getResponse();
		  
		StringBuffer results = new StringBuffer("<td class=\"title\"");
		/*
		if ("string".equals(colType))
		  results.append("titletext");
		else if ("number".equals(colType))
		  results.append("titlenumber");
		else if ("link".equals(colType))
		  results.append("titlelink");
		else if ("date".equals(colType))
		  results.append("titledate");
		else
		  results.append("");
		*/

		if(colspan != null) {
			results.append(" colspan=\""+colspan+"\"");
		}
		if(rowspan != null) {
			results.append(" rowspan=\""+rowspan+"\"");
		}

		if (getStyle() != null)
			results.append(" style=\"" + getStyle() + "\"");
			
		results.append(">");
		
		results.append("<table class=\"main\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" ");		if (getStyle() != null)
			results.append(" style=\"" + getStyle() + "\"");
		results.append(">");
		results.append("		<tr>");
		results.append("	<td><B>");
		
		// Print this field to our output writer
	    ResponseUtils.write(pageContext, results.toString());
		           
	    // Put Label
		super.doStartTag();
		
		results = new StringBuffer("</B></td>");
		results.append("<td align=\"right\">");
		
		results.append("<A href=\"#\" onclick=\"setFinder('");
		results.append(ascFinder);
		results.append("'); return false;\">");
		results.append("<img src=\"/images/up.gif\"  border=\"0\" alt=\"����������� �� �����������\">");
		results.append("</A>");
			
		results.append("<A href=\"#\" onclick=\"setFinder('");
	    results.append(descFinder);
	    results.append("'); return false;\">");
		results.append("<img src=\"/images/down.gif\"  border=\"0\" alt=\"����������� �� ��������\">");
	    results.append("</A>");
		results.append("   </td>");
		results.append("		</tr>");
		results.append("	</table>");
        results.append("</td>");
        
		// Print this field to our output writer
	    ResponseUtils.write(pageContext, results.toString());

		// Continue processing this page
		return (EVAL_BODY_INCLUDE);

	}
/**
 * ��� �������-������ ��� ���������� �� �����������.
 * Creation date: (29.01.2002 16:40:51)
 * @return java.lang.String
 */
public java.lang.String getAscFinder() {
	return ascFinder;
}
/**
 * �������� colspan - ������������ ��� �������������� �� ���������� ���� <TD>.
 * @return java.lang.String
 */
public java.lang.String getColspan() {
	return colspan;
}
/**
 * ��� ������� (��� ��������������): string, number, link, date.
 * Creation date: (30.01.2002 9:49:37)
 * @return java.lang.String
 */
public java.lang.String getColType() {
	return colType;
}
/**
 * ��� �������-������ ��� ���������� �� ��������.
 * Creation date: (29.01.2002 16:41:12)
 * @return java.lang.String
 */
public java.lang.String getDescFinder() {
	return descFinder;
}
/**
 * �������� rowspan, ������� ����� ���������� �� ���������� ���� <TD>.
 * @return java.lang.String
 */
public java.lang.String getRowspan() {
	return rowspan;
}
/**
 * ����� - ��� ��������� ����������.
 * Creation date: (28.10.2003 12:26:30)
 * @return java.lang.String
 */
public java.lang.String getStyle() {
	return style;
}
/**
 * ��� �������-������ ��� ���������� �� �����������.
 * Creation date: (29.01.2002 16:40:51)
 * @param newAscFinder java.lang.String
 */
public void setAscFinder(java.lang.String newAscFinder) {
	ascFinder = newAscFinder;
}
/**
 * �������� colspan - ������������ ��� �������������� �� ���������� ���� <TD>.
 * @param newColspan java.lang.String
 */
public void setColspan(java.lang.String newColspan) {
	colspan = newColspan;
}
/**
 * ��� ������� (��� ��������������): string, number, link, date.
 * Creation date: (30.01.2002 9:49:37)
 * @param newColType java.lang.String
 */
public void setColType(java.lang.String newColType) {
	colType = newColType;
}
/**
 * ��� �������-������ ��� ���������� �� ��������.
 * Creation date: (29.01.2002 16:41:12)
 * @param newDescFinder java.lang.String
 */
public void setDescFinder(java.lang.String newDescFinder) {
	descFinder = newDescFinder;
}
/**
 * �������� rowspan, ������� ����� ���������� �� ���������� ���� <TD>.
 * @param newRowspan java.lang.String
 */
public void setRowspan(java.lang.String newRowspan) {
	rowspan = newRowspan;
}
/**
 * ����� - ��� ��������� ����������.
 * Creation date: (28.10.2003 12:26:30)
 * @param newStyle java.lang.String
 */
public void setStyle(java.lang.String newStyle) {
	style = newStyle;
}
}
