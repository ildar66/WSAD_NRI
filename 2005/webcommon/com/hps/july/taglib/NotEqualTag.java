package com.hps.july.taglib;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.web.util.BrowseForm;
import javax.servlet.jsp.tagext.*;
import org.apache.struts.taglib.html.*;
import javax.servlet.jsp.PageContext;
import org.apache.struts.util.PropertyUtils;
import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;

/**
 * ��� ��� ��������� �������� ���� �������.
 * Creation date: (27.06.2002 17:22:10)
 * @author: Dmitry Dneprov
 */
public class NotEqualTag extends TagSupport {
	private boolean evaluate;
	private java.lang.String propertyleft;
	private java.lang.String propertyright;
	private java.lang.String nameleft;
	private java.lang.String nameright;
	private java.lang.String scopeleft;
	private java.lang.String scoperight;
/**
 * ��������� ������������ ����
*/	
public int doStartTag() throws javax.servlet.jsp.JspException {
	if (RequestUtils.lookup(pageContext, nameleft, scopeleft) == null ||
		RequestUtils.lookup(pageContext, nameright, scoperight) == null)
	{
		return (SKIP_BODY);  // Nothing to output
	}

	Object leftvalue = RequestUtils.lookup(pageContext, nameleft, propertyleft, scopeleft);
	Object rightvalue = RequestUtils.lookup(pageContext, nameright, propertyright, scoperight);

	if(leftvalue != null && leftvalue instanceof String) {
		String lv = (String)leftvalue;
		if("".equals(lv.trim())) {
			leftvalue = null;
		}
	}

	if(rightvalue != null && rightvalue instanceof String) {
		String rv = (String)rightvalue;
		if("".equals(rv.trim())) {
			rightvalue = null;
		}
	}

	evaluate = false;

	if(leftvalue == null) {
		if(rightvalue != null) {
			evaluate = true;
		}
	} else {
		if(rightvalue == null) {
			evaluate = true;
		} else {
			evaluate = !leftvalue.equals(rightvalue);
		}
	}

	if (evaluate) {
		return EVAL_BODY_INCLUDE;
	}
	return SKIP_BODY;
}
/**
 * Bean ��� ������ ��������� ���������
 * @return java.lang.String
 */
public java.lang.String getNameleft() {
	return nameleft;
}
/**
 * Bean ��� ������� ��������� ���������
 * @return java.lang.String
 */
public java.lang.String getNameright() {
	return nameright;
}
/**
 * �������� ��� ������ ��������� ���������
 * @return java.lang.String
 */
public java.lang.String getPropertyleft() {
	return propertyleft;
}
/**
 * �������� ��� ������� ��������� ���������
 * @return java.lang.String
 */
public java.lang.String getPropertyright() {
	return propertyright;
}
/**
 * Bean ��� ������ ��������� ���������
 * @param newNameleft java.lang.String
 */
public void setNameleft(java.lang.String newNameleft) {
	nameleft = newNameleft;
}
/**
 * Bean ��� ������� ��������� ���������
 * @param newNameright java.lang.String
 */
public void setNameright(java.lang.String newNameright) {
	nameright = newNameright;
}
/**
 * �������� ��� ������ ��������� ���������
 * @param newPropertyleft java.lang.String
 */
public void setPropertyleft(java.lang.String newPropertyleft) {
	propertyleft = newPropertyleft;
}
/**
 * �������� ��� ������� ��������� ���������
 * @param newPropertyright java.lang.String
 */
public void setPropertyright(java.lang.String newPropertyright) {
	propertyright = newPropertyright;
}
}
