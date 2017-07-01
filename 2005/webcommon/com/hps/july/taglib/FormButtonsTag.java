package com.hps.july.taglib;

import com.hps.july.web.util.EditForm;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.apache.struts.util.*;
import org.apache.struts.taglib.html.*;
import javax.servlet.jsp.PageContext;
import com.hps.july.web.util.StateNavigator;
import com.hps.july.web.util.ParamsParser;
import com.hps.july.constants.Applications;

/**
 * Кнопки, прорисовываемые в зависимости от текущего Action в форме редактирования.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class FormButtonsTag
    extends org.apache.struts.taglib.html.BaseFieldTag {

    private java.lang.String showdelete;
    private java.lang.String showsave;
    private java.lang.String showreset;
    private java.lang.String onsave;

	/**
	 * Обработка после тела тага
	*/  
    public int doAfterBody() {
        BodyContent body = getBodyContent();
        try {
            JspWriter out = body.getEnclosingWriter();
            out.print(body.getString());
        } catch (java.io.IOException ioe) {
            System.out.println("Error in FormbuttonsTag: " + ioe);
        }
        // SKIP_BODY means I'm done. If I wanted to evaluate
        // and handle the body again, I'd return EVAL_BODY_TAG.
        return (SKIP_BODY);
    }
    
    /**
     * Обработка закрывающего тага
    */
    public int doEndTag() throws javax.servlet.jsp.JspException {

        StringBuffer results = new StringBuffer("");

        results.append("</TD></TR>");

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());
        return super.doEndTag();

    }
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        // Create an appropriate "form" element based on our parameters
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results = new StringBuffer("");

        results.append("<TR class=\"title\"><TD colspan=\"2\">");

        // Look up the requested property value
        Object valueAction =
            RequestUtils.lookup(pageContext, name, "action", "request");

        // Check onsave handler
        if (getOnsave() == null)
            setOnsave("");

        if ("Delete".equals(valueAction)) {
            if (!"false".equalsIgnoreCase(getShowdelete())) {
                results.append(
                    "<INPUT TYPE=\"IMAGE\" NAME=\"submit\" onclick=\"document.body.style.cursor='wait'; if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; } "
                        + " else { document.forms(0).elements('wasposted').value=1; } \" SRC=\"/images/delconf.gif\" ALT=\"Удалить\">&nbsp;");
            }
        } else
            if ("View".equals(valueAction)) {
                // No additional buttons
            } else {
                if (!"false".equalsIgnoreCase(getShowsave())) {
                    results.append(
                        "<INPUT TYPE=\"IMAGE\" NAME=\"submit\" SRC=\"/images/save.gif\" "
                            + " ALT=\"Сохранить\" onclick=\""
                            + getOnsave()
                            + ";document.body.style.cursor='wait';if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; }"
                            + " else { document.forms(0).elements('wasposted').value=1; } \">&nbsp;");
                }
                if (!"false".equalsIgnoreCase(getShowreset())) {
                    results.append(
                        "<A ID=\"ResetButton\" HREF='#'><IMG SRC=\"/images/restore.gif\" onclick=\"document.forms(0).reset()\" ALT=\"Отменить правку\" border=0></A>&nbsp;");
                }
            }

        EditForm wrapForm =
            (EditForm) pageContext.getAttribute(
                Constants.BEAN_KEY,
                PageContext.REQUEST_SCOPE);
        if (wrapForm != null) {
            // Temproraly exclude some applications from navigation
            int app = 0;
            try {
                app =
                    Integer.parseInt(
                        (String) pageContext.getRequest().getAttribute(
                            ParamsParser.APPLICATION_PARAM_NAME));
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }

            StateNavigator nav = null;

            if (com.hps.july.web.util.NavigatedAction.isNavigateModule(app)) {
                nav =
                    (StateNavigator) pageContext.getAttribute(
                        StateNavigator.NAVIGATOR_PARAM,
                        PageContext.SESSION_SCOPE);
            }

            if (nav != null) {
                results.append(
                    "<A HREF='"
                        + nav.makeLinkUrl(nav.getPrevState())
                        + "' TITLE=\"Отказ и возврат\"><IMG SRC=\"/images/cancel.gif\" ALT=\"Отказ и возврат\" onclick=\"document.body.style.cursor='wait';\" BORDER=0></A>");
            } else
                results.append(
                    "<A HREF='"
                        + wrapForm.getReturnPage()
                        + "' TITLE=\"Отказ и возврат\"><IMG SRC=\"/images/cancel.gif\" ALT=\"Отказ и возврат\" onclick=\"document.body.style.cursor='wait';\" BORDER=0></A>");
        } else {
            results.append(
                "<INPUT TYPE=\"IMAGE\" NAME=\"org.apache.struts.taglib.html.CANCEL\" SRC=\"/images/cancel.gif\" onclick=\"document.body.style.cursor='wait';\" ALT=\"Отказ и возврат\">");
        }

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        return EVAL_BODY_TAG;

    }
    
    /**
     * Событие - нажатие на кнопку "Сохранить".
     * Creation date: (15.12.2003 12:09:42)
     * @return java.lang.String
     */
    public java.lang.String getOnsave() {
        return onsave;
    }
    /**
     * Признак "показывать кнопку 'удалить' ".
     * Creation date: (11.09.2003 12:06:51)
     * @return java.lang.String
     */
    public java.lang.String getShowdelete() {
        return showdelete;
    }
    /**
     * Признак "показывать кнопку 'сброс' ".
     * Creation date: (11.09.2003 12:07:31)
     * @return java.lang.String
     */
    public java.lang.String getShowreset() {
        return showreset;
    }
    /**
     * Признак "показывать кнопку 'сохранить' ".
     * Creation date: (11.09.2003 12:07:15)
     * @return java.lang.String
     */
    public java.lang.String getShowsave() {
        return showsave;
    }
    /**
     * Событие - нажатие на кнопку "Сохранить".
     * Creation date: (15.12.2003 12:09:42)
     * @param newOnsave java.lang.String
     */
    public void setOnsave(java.lang.String newOnsave) {
        onsave = newOnsave;
    }
    /**
     * Признак "показывать кнопку 'удалить' ".
     * Creation date: (11.09.2003 12:06:51)
     * @param newShowdelete java.lang.String
     */
    public void setShowdelete(java.lang.String newShowdelete) {
        showdelete = newShowdelete;
    }
    /**
     * Признак "показывать кнопку 'сброс' ".
     * Creation date: (11.09.2003 12:07:31)
     * @param newShowreset java.lang.String
     */
    public void setShowreset(java.lang.String newShowreset) {
        showreset = newShowreset;
    }
    /**
     * Признак "показывать кнопку 'сохранить' ".
     * Creation date: (11.09.2003 12:07:15)
     * @param newShowsave java.lang.String
     */
    public void setShowsave(java.lang.String newShowsave) {
        showsave = newShowsave;
    }
}