package com.hps.july.taglib;

import javax.servlet.http.*;
import org.apache.struts.util.*;
/**
 * ����� ����.
 * Creation date: (29.04.2002 13:43:45)
 * @author: Dmitry Dneprov
 */
public class MenuItemTag extends org.apache.struts.taglib.bean.MessageTag {
	private java.lang.String styleId;
	private java.lang.String action;
	private int stateId;
	/**
	 *	0 - ��������� � �������  ����
	 *	1 - ��������� � ����� ����
	 */
	private java.lang.String target = "0";
	//���� ��������� ���������� � ������ ���� - �������� ��� 
	private java.lang.String windowName = "newWindowObj";
/**
 * MenuTag constructor.
 */
public MenuItemTag() {
	super();
}
/**
 * �������� ���������, ��� ������� ������ ����� ���� ��������������.
 * Creation date: (09.07.2002 14:11:39)
 * @param argState int
 */
public void addState(int argState) throws javax.servlet.jsp.JspTagException {
	MenuTag wrapMenu = (MenuTag)findAncestorWithClass(this, MenuTag.class);
	if (wrapMenu == null) {
		throw new javax.servlet.jsp.JspTagException("MenuItem not inside menu");
	} else {
		wrapMenu.addState(getStateId(), argState);
	}
}
/**
 * ��������� ������������ ����
*/	
		public int doStartTag() throws javax.servlet.jsp.JspException {

			HttpServletResponse response =
			  (HttpServletResponse) pageContext.getResponse();
			  
			StringBuffer results = new StringBuffer("");

			results.append("<SCRIPT language=\"JScript\"> \r\n");

			MenuItemTag wrapper = (MenuItemTag)findAncestorWithClass(this, MenuItemTag.class);
			MenuTag wrapMenu = (MenuTag)findAncestorWithClass(this, MenuTag.class);
			if (wrapper == null) {
				if (wrapMenu == null) {
					throw new javax.servlet.jsp.JspTagException("MenuItem not inside menu");
				} else {
					// This is root item
					setStyleId(wrapMenu.getStyleId());
					results.append("  var nd = window.document.all." + getStyleId() + ".Nodes; \r\n");
					results.append("  var nds = nd.Add(null, null, \"key" + getStateId() + "\", \"");
			        ResponseUtils.write(pageContext, results.toString());
					super.doStartTag();
					results = new StringBuffer("");
					results.append("\"); \r\n");
					results.append("  nds.Expanded = 1; \r\n");
					//��������� �������� ��� ���������� ��������� ����
					//  boolean newWin = (getTarget() != null && "1".equals(getTarget()))?true:false; - �����-�� ����
					boolean newWin = "1".equals(getTarget()) || "2".equals(getTarget());
					if (getAction() != null) {
						if(newWin) {
							wrapMenu.addAction(getStateId(), getAction(), getTarget(), getWindowName());
						} else wrapMenu.addAction(getStateId(), getAction());
					}
				}
			} else {
				if (wrapMenu == null) {
					throw new javax.servlet.jsp.JspTagException("MenuItem not inside menu");
				} else {
					setStyleId(wrapper.getStyleId());
					results.append("  var nd = window.document.all." + getStyleId() + ".Nodes; \r\n");
					results.append("  var nds = nd.Add(\"key" + wrapper.getStateId() + "\", 4, \"key" + getStateId() + 
						"\", \"");
		            ResponseUtils.write(pageContext, results.toString());
					super.doStartTag();
					results = new StringBuffer("");
					results.append("\"); \r\n");
					//��������� �������� ��� ���������� ��������� ����
					//boolean newWin = (getTarget() != null && "1".equals(getTarget()))?true:false;
					boolean newWin = "1".equals(getTarget()) || "2".equals(getTarget());
					if (getAction() != null) {
						if(newWin) {
							wrapMenu.addAction(getStateId(), getAction(), getTarget(), getWindowName());
						} else wrapMenu.addAction(getStateId(), getAction());
					}
						
				}
			}
				
			results.append("</SCRIPT> \r\n");
			
			// Print this field to our output writer
		    ResponseUtils.write(pageContext, results.toString());

			// Continue processing this page
			return (EVAL_BODY_INCLUDE);

		}
/**
 * �������� (URL), ������� ���������� ��� ������� �� ������ ����� ����.
 * Creation date: (29.04.2002 14:49:50)
 * @return java.lang.String
 */
public java.lang.String getAction() {
	return action;
}
/**
 * ������� ID ������, ������� ������������ ������������.
 * Creation date: (29.04.2002 15:03:44)
 * @return int
 */
public int getStateId() {
	return stateId;
}
/**
 * ID ������ ���� ��� ������������� �� JavaScript.
 * Creation date: (29.04.2002 14:44:36)
 * @return java.lang.String
 */
public java.lang.String getStyleId() {
	return styleId;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 12:43:11)
 * @return java.lang.String
 */
public java.lang.String getTarget() {
	return target;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 16:40:24)
 * @return java.lang.String
 */
public java.lang.String getWindowName() {
	return windowName;
}
/**
 * �������� (URL), ������� ���������� ��� ������� �� ������ ����� ����.
 * Creation date: (29.04.2002 14:49:50)
 * @param newAction java.lang.String
 */
public void setAction(java.lang.String newAction) {
	action = newAction;
}
/**
 * ������� ID ������, ������� ������������ ������������.
 * Creation date: (29.04.2002 15:03:44)
 * @param newStateId int
 */
public void setStateId(int newStateId) {
	stateId = newStateId;
}
/**
 * ID ������ ���� ��� ������������� �� JavaScript.
 * Creation date: (29.04.2002 14:44:36)
 * @param newStyleId java.lang.String
 */
public void setStyleId(java.lang.String newStyleId) {
	styleId = newStyleId;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 12:43:11)
 * @param newTarget java.lang.String
 */
public void setTarget(java.lang.String newTarget) {
	target = newTarget;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 16:40:24)
 * @param newWindowName java.lang.String
 */
public void setWindowName(java.lang.String newWindowName) {
	windowName = newWindowName;
}
}
