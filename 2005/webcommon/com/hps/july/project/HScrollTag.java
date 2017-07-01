package com.hps.july.project;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *  ласс дл€ отображени€ горизонтального скроллинга.
 * Creation date: (16.01.2002 15:02:14)
 * @author: Administrator
 */
public class HScrollTag extends TagSupport {
    private String elemId;
    private int visibleAmount;
    private int from;
    private int amount;
	private java.lang.String startVisible;
public int doEndTag() throws JspException {
    try {
        if (Integer.parseInt(getAmount()) > Integer.parseInt(getVisibleAmount()))
            pageContext.getOut().print(script() + setButtonsStyle() + drawScroll());
        /*
             else
             pageContext.getOut().print("");
        */
    } catch (java.io.IOException ex) {
        throw new JspException(ex.getMessage());

    }
    return EVAL_PAGE;
}
private String drawScroll() {

    StringBuffer results = new StringBuffer("");
	results.append("<SCRIPT language=\"JScript\" FOR=\"abody\" EVENT=\"onkeyup\"> \r\n");
	results.append("if (event.keyCode == 37) { \r\n");
	results.append("  event.returnValue=false; \r\n");
	results.append("  to_left(); \r\n");
	results.append("} \r\n");
	results.append("if (event.keyCode == 39) { \r\n");
	results.append("  event.returnValue=false; \r\n");
	results.append("  to_right(); \r\n");
	results.append("} \r\n");
	results.append("</SCRIPT> \r\n");
	
    results.append("<tr class='title'>\n");
    results.append("<td class='button' colspan='"+(from - 1)+"' border='0' >&nbsp;</td> \n  ");
    results.append("<td class='button'  colspan ='"+ amount + "'>\n");
    results.append("<table class='buttons'  width='100%' border='0' >\n");
    results.append("<tr class='title'  >\n");
    results.append("<td class='button' align='left' > <button name='left' style='width: 16; height:16; background-image: url(/images/arleft.gif)' onmouseup='to_left()'></button> </td>\n");
    results.append("<td class='button' style='width: 100%; height:12;'>" );
    results.append("<TABLE class='buttons'  width='100%' border='0' HEIGHT='12'>");
    results.append("  <tr class='title' HEIGHT='12'>\n");
    results.append("    <td class='button' style='width: 100%; height:12; background-image: url(/images/setka.gif)'></td></tr></TABLE>" );
    results.append("</td>\n");
    results.append("<td class='button'  align='right'> <button name='right' style='width: 16; height:16; background-image: url(/images/arright.gif)' onmouseup='to_right()'></button> </td>\n");
    results.append("</tr>\n");
    results.append("</table>\n");
    results.append(" </td>\n");
    results.append("</tr>\n");

    // Draw Separator
	results.append("<tr> \r\n");
	results.append("<td class=\"probel\" colspan=\"" + (from+amount-1));
	results.append("\"><img src=\"/images/empty.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\"></td> \r\n");
	results.append("</tr> \r\n");

    return results.toString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 13:59:09)
 * @return java.lang.String
 */
public java.lang.String getAmount() {
    return String.valueOf(amount);
}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 13:57:12)
 * @return java.lang.String
 */
public java.lang.String getElemId() {
	return elemId;
}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 13:59:09)
 * @return java.lang.String
 */
public java.lang.String getFrom() {
    return String.valueOf(from);
}
/**
 * Insert the method's description here.
 * Creation date: (06.01.2004 11:47:21)
 * @return java.lang.String
 */
public java.lang.String getStartVisible() {
	return startVisible;
}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 13:59:09)
 * @return java.lang.String
 */
public java.lang.String getVisibleAmount() {
    return String.valueOf(visibleAmount);
}
private String script() {
    String elemId1 = '"'+this.elemId+'"';

    if ( (getStartVisible() == null) || (getStartVisible().trim().length() == 0) ) 
	    setStartVisible("0");
	    
    StringBuffer results = new StringBuffer("");
	
	results.append(
    	  "<script language=javascript>\n"
        + "<!--\n"
        + "var state=0;\n"
        + "var count="+amount+";\n"
        + "var visAmount="+visibleAmount+";\n"
        //+ "var len="+elemId+".length;\n"
        //+ "var elemId="+elemId1+";\n"
        
        + "function switch_visible(){ \n"
        + "  if (state > 0) {\n"
        + "    document.styleSheets[1].rules.item(state-1).style.visibility='hidden';\n"
        + "    document.styleSheets[1].rules.item(state-1).style.display='none';\n"
        + "  }\n"
        + "  document.styleSheets[1].rules.item(state).style.visibility='visible';\n"
        + "  document.styleSheets[1].rules.item(state).style.display='block';\n"
        + "  document.styleSheets[1].rules.item(state+visAmount-1).style.visibility='visible';\n"
        + "  document.styleSheets[1].rules.item(state+visAmount-1).style.display='block';\n"
        + "  if (state + visAmount < count) {\n"
        + "    document.styleSheets[1].rules.item(state + visAmount).style.visibility='hidden';\n"
        + "    document.styleSheets[1].rules.item(state + visAmount).style.display='none';\n"
        + "  }\n"
        + "}\n"
        
        + "function to_left(){ \n"
        + "  state--;\n"
        + "  if (state < 0) {\n"
        + "    state = 0;\n"
        + "  }\n"
        + "  switch_visible();\n"
        + "}\n"
        
        + "function to_right(){ \n"
        + "  state++;\n"
        + "  if (state > count-visAmount) {\n"
        + "    state = count-visAmount;\n"
        + "  }\n"
        + "  switch_visible();\n"
        + "}\n"
        
        + "function init(){\n"
        + "   state = " + getStartVisible() + "; \n" 
        + "   for (var i = 0; i < count; i++) {\n"
        + "      if ( (i < " + getStartVisible() + ") || (i >= (visAmount + " + getStartVisible() + ") ) ) { \n"
        + "         document.styleSheets[1].rules.item(i).style.visibility='hidden';\n"
        + "         document.styleSheets[1].rules.item(i).style.display='none';\n"
        + "      }\n"
        + "   }\n"
        + "}\n"
        
        + "function getState(){\n"
        + "   return state; \n" 
        + "}\n"
        
        + "init();\n"
        + "//-->\n"
        + "</script>\n"
        + "\n"
        + "\n");

    return results.toString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 13:59:09)
 * @param newCount java.lang.String
 */
public void setAmount(java.lang.String newAmount) {
    amount = Integer.parseInt(newAmount);
}
private String setButtonsStyle() {

    return "<style>"
        + "<!--"
        + "button"
        + "{"
        + "font-family: 'Wingdings 3';font-weight:bold; color: #CCCCCC background-color: #33CCFF; font-size: 6pt;"
        + "}"
        + "-->"
        + "</style>";


}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 13:57:12)
 * @param newElemId java.lang.String
 */
public void setElemId(java.lang.String newElemId) {
	elemId = newElemId;
}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 13:59:09)
 * @param newFrom java.lang.String
 */
public void setFrom(java.lang.String newFrom) {
    from = Integer.parseInt(newFrom);
}
/**
 * Insert the method's description here.
 * Creation date: (06.01.2004 11:47:21)
 * @param newStartVisible java.lang.String
 */
public void setStartVisible(java.lang.String newStartVisible) {
	startVisible = newStartVisible;
}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 13:59:09)
 * @param newVisAmount java.lang.String
 */
public void setVisibleAmount(java.lang.String newVisAmount) {
    visibleAmount = Integer.parseInt(newVisAmount);
}
}
