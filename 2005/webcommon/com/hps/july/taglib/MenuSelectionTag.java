package com.hps.july.taglib;

import javax.servlet.http.*;
import org.apache.struts.util.*;
/**
 * ��������� ���������� �������� ����.
 * Creation date: (29.04.2002 13:43:45)
 * @author: Dmitry Dneprov
 */
public class MenuSelectionTag extends org.apache.struts.taglib.bean.MessageTag {
	private int stateId;
/**
 * MenuTag constructor.
 */
public MenuSelectionTag() {
	super();
}
/**
 * ��������� ������������ ����
*/	
		public int doStartTag() throws javax.servlet.jsp.JspException {

			HttpServletResponse response =
			  (HttpServletResponse) pageContext.getResponse();
			  
			MenuItemTag wrapper = (MenuItemTag)findAncestorWithClass(this, MenuItemTag.class);
			if (wrapper == null) {
				throw new javax.servlet.jsp.JspTagException("MenuSelection not inside MenuItem");
			} else {
				wrapper.addState(getStateId());
			}
				
			// Continue processing this page
			return (EVAL_BODY_INCLUDE);

		}
/**
 * ��������� ID (state) ��� ������� ������������ ����� ���� ����� ���������.
 * Creation date: (29.04.2002 15:03:44)
 * @return int
 */
public int getStateId() {
	return stateId;
}
/**
 * ��������� ID (state) ��� ������� ������������ ����� ���� ����� ���������.
 * Creation date: (29.04.2002 15:03:44)
 * @param newStateId int
 */
public void setStateId(int newStateId) {
	stateId = newStateId;
}
}
