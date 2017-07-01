package com.hps.july.taglib;

import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;

/**
 * Таг для отрисовки меню - использует ActiveX.
 * Creation date: (29.04.2002 13:43:45)
 * @author: Dmitry Dneprov
 */
public class MenuTag extends javax.servlet.jsp.tagext.TagSupport {
    private java.lang.String styleId;
    private java.util.ArrayList actions;
    private java.util.ArrayList states;
    private int selectedId;
    private java.lang.String height;
    /**
     * MenuTag constructor.
     */
    public MenuTag() {
        super();
        styleId = "mainmenu";
        actions = new ArrayList();
        states = new ArrayList();
    }
    
    /**
     * Добавление действия в меню.
     * Creation date: (06.05.2002 12:50:40)
     * @param argKey int
     * @param argAction java.lang.String
     */
    public void addAction(int argKey, String argAction) {
        actions.add(new MenuAction(argKey, argAction));
    }
    
    /**
     * Добавление состояния в меню.
     * Creation date: (06.05.2002 12:50:40)
     * @param argKey int
     * @param argAction java.lang.String
     */
    public void addState(int argKey, int argState) {
        states.add(new MenuState(argKey, argState));
    }
    
    /**
     * Обработка закрывающего тага
    */
    public int doEndTag() throws JspException {

        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results = new StringBuffer("");

        results.append("<SCRIPT language=\"JScript\"> \r\n");
        results.append("function newBigWin(url, name) { \r\n");
	    results.append(" window.open(url, name, \"top=0, left=0, height=\" + (screen.availHeight-30) + \", width=\" + (screen.availWidth-10) + \", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=yes,titlebar=yes,toolbar=no\").focus();   \r\n");
        results.append("} \r\n");
        results.append("</SCRIPT> \r\n");
        

        results.append("<SCRIPT language=\"VBScript\"> \r\n");

        results.append("DIM " + getStyleId() + "_cursel \r\n");

        for (Iterator i = states.iterator(); i.hasNext();) {
            MenuState state = (MenuState) i.next();
            if (state.getState() == getSelectedId()) {
                results.append(
                    getStyleId()
                        + ".Nodes.Item(\"key"
                        + state.getKey()
                        + "\").Selected = true \r\n");
                results.append(getStyleId() + "_cursel = " + state.getKey() + "\r\n");
                break;
            }
        }
        //results.append(getStyleId() + ".Nodes.Item(\"key" + getSelectedId() + "\").Selected = true \r\n");

        // Check for mouse click
        results.append("sub " + getStyleId() + "_Click() \r\n");
        for (Iterator i = actions.iterator(); i.hasNext();) {
            MenuAction act = (MenuAction) i.next();
            results.append(
                "  if "
                    + getStyleId()
                    + ".SelectedItem.Key = \"key"
                    + act.getKey()
                    + "\" then ");
            results.append(
                "  if " + getStyleId() + "_cursel <> " + act.getKey() + " then ");
            if(act.getTarget() != null && "1".equals(act.getTarget())) {
	            //results.append("     document.body.style.cursor=\"wait\":");
		        long millis = Math.round(Math.random()*10000);
		        String sMils = (new Long(millis)).toString();
		        String urlName = "url" + sMils;
	            StringBuffer nameWin = new StringBuffer("newWin");
		        nameWin.append(sMils);
	            results.append(" dim " + urlName + ", " + nameWin.toString() + " :");
	            results.append(urlName + " =\"" + act.getAction() + "\":");
	            results.append(" Set " + nameWin.toString() + " = Window.Open(" + urlName + ", \"" + act.getWindowName() + "\", \"top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes\"):");
	            results.append(nameWin.toString() + ".focus() \r\n");
            } else if("2".equals(act.getTarget())) {
	            results.append(" newBigWin \"" + act.getAction() + "\",\"" + act.getWindowName() + "\"   \r\n");
            } else {
	            results.append("     document.body.style.cursor=\"wait\":");
	            results.append("     window.location.href=\"" + act.getAction() + "\" \r\n");
            }
        }
        results.append("end sub  \r\n");
        results.append("</SCRIPT> \r\n");

        // Check for enter key
        results.append(
            "<SCRIPT language=\"VBScript\" FOR=\""
                + getStyleId()
                + "\" EVENT=\"KeyPress(KeyAscii)\"> \r\n");
        for (Iterator i = actions.iterator(); i.hasNext();) {
            MenuAction act = (MenuAction) i.next();
            results.append(
                "  if "
                    + getStyleId()
                    + ".SelectedItem.Key = \"key"
                    + act.getKey()
                    + "\" then ");
            if(act.getTarget() != null && "1".equals(act.getTarget())) {
		        long millis = Math.round(Math.random()*10000);
		        String sMils = (new Long(millis)).toString();
		        String urlName = "url" + sMils;
	            StringBuffer nameWin = new StringBuffer("newWin");
		        nameWin.append(sMils);
	            results.append(" dim " + urlName + ", " + nameWin.toString() + " :");
	            results.append(urlName + " =\"" + act.getAction() + "\":");
	            results.append(" Set " + nameWin.toString() + " = Window.Open(" + urlName + ", \"" + act.getWindowName() + "\", \"top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes\"):");
	            results.append(nameWin.toString() + ".focus() \r\n");
            } else if("2".equals(act.getTarget())) {
	            results.append(" window.open(\"" + act.getAction() + "\",\"" + act.getWindowName() + "\", \"top=0, left=0, height=\" + (screen.availHeight-30) + \", width=\" + (screen.availWidth-10) + \", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=yes,titlebar=yes,toolbar=no\").focus()   \r\n");
            } else {
	            results.append("     document.body.style.cursor=\"wait\":");
	            results.append("     window.location.href=\"" + act.getAction() + "\" \r\n");
            }
        }
        results.append("</SCRIPT> \r\n");

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        return (EVAL_PAGE);
    }
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results = new StringBuffer("");

        results.append(
            "<OBJECT class=\"menu\" ID=\"" + getStyleId() + "\" WIDTH='200' HEIGHT='");
        if (getHeight() != null)
            results.append(getHeight());
        else
            results.append("500");
        results.append("' \r\n");
        //results.append(" CODEBASE=\"/MSComCt2.cab\" \r\n");
        results.append(" CODEBASE=\"/ComCtl32.cab\" \r\n");
        //results.append("CLASSID=\"CLSID:C74190B6-8589-11D1-B16A-00C0F0283628\">\r\n");
        results.append("CLASSID=\"CLSID:0713E8A2-850A-101B-AFC0-4210102A8DA7\">\r\n");
        //results.append("<PARAM NAME=\"_ExtentX\" VALUE=\"5292\">\r\n");
        //results.append("<PARAM NAME=\"_ExtentY\" VALUE=\"7938\">\r\n");
        //results.append("<PARAM NAME=\"_Version\" VALUE=\"393217\">\r\n");
        results.append("<PARAM NAME=\"Indentation\" VALUE=\"250\">\r\n");
        results.append("<PARAM NAME=\"LabelEdit\" VALUE=\"1\">\r\n");
        results.append("<PARAM NAME=\"HideSelection\" VALUE=\"0\">\r\n");
        results.append("<PARAM NAME=\"Style\" VALUE=\"6\">\r\n");
        results.append("<PARAM NAME=\"Appearance\" VALUE=\"0\">\r\n");
        results.append("</OBJECT>\r\n");

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        return (EVAL_BODY_INCLUDE);
    }
    
    /**
     * Высота меню в пикселах.
     * Creation date: (24.05.2002 10:28:30)
     * @return java.lang.String
     */
    public java.lang.String getHeight() {
        return height;
    }
    
    /**
     * Текущий выбранный пункт меню - для подсветки.
     * Creation date: (30.04.2002 10:55:26)
     * @return java.lang.String
     */
    public int getSelectedId() {
        return selectedId;
    }
    
    /**
     * ID объекта меню.
     * Creation date: (29.04.2002 13:55:00)
     * @return java.lang.String
     */
    public java.lang.String getStyleId() {
        return styleId;
    }
    
    /**
     * Высота меню в пикселах.
     * Creation date: (24.05.2002 10:28:30)
     * @param newHeight java.lang.String
     */
    public void setHeight(java.lang.String newHeight) {
        height = newHeight;
    }
    
    /**
     * Текущий выбранный пункт меню - для подсветки.
     * Creation date: (30.04.2002 10:55:26)
     * @param newSelectedId java.lang.String
     */
    public void setSelectedId(int newSelectedId) {
        selectedId = newSelectedId;
    }
    
    /**
     * ID объекта меню.
     * Creation date: (29.04.2002 13:55:00)
     * @param newStyleId java.lang.String
     */
    public void setStyleId(java.lang.String newStyleId) {
        styleId = newStyleId;
    }

	/**
	 * Insert the method's description here.
	 * Creation date: (11.10.2004 13:05:02)
	 * @param argKey int
	 * @param argAction java.lang.String
	 * @param target java.lang.String
	 */
	public void addAction(int argKey, String argAction, String target) {
        actions.add(new MenuAction(argKey, argAction, target));
    }

	/**
	 * Insert the method's description here.
	 * Creation date: (11.10.2004 16:46:57)
	 * @param argKey int
	 * @param argAction java.lang.String
	 * @param target java.lang.String
	 * @param wn java.lang.String
	 */
	public void addAction(int argKey, String argAction, String target, String wn) {
        actions.add(new MenuAction(argKey, argAction, target, wn));
    }
}