package com.hps.july.taglib;

import java.net.*;
import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;
import com.hps.july.web.util.*;
import javax.servlet.jsp.PageContext;
import com.hps.july.constants.Applications;

/**
 *  нопка возврата на предыдущую страницу.
 * Creation date: (23.05.2002 12:27:23)
 * @author: Dmitry Dneprov
 */
public class BackButtonTag extends LinkTag {
	
    /**
     * ќбработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        if (getTitle() == null)
            if (getAlttext() == null)
                setAlttext("button.back");

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

        if (com.hps.july.web.util.NavigatedAction.isNavigateModule(app)) {
            StateNavigator nav =
                (StateNavigator) pageContext.getAttribute(
                    StateNavigator.NAVIGATOR_PARAM,
                    PageContext.SESSION_SCOPE);

            if (nav != null) {
                if ((getPage() == null) && (getHref() == null))
                    setHref(nav.makeLinkUrl(nav.getPrevState()));
            }
        }

        super.doStartTag();
        // Generate the opening anchor element
        StringBuffer results = new StringBuffer("");
		// System.out.println("### BackButtonTag getTitle()= "+getTitle());
        results.append(
            "<IMG SRC=\"/images/cancel.gif\" BORDER='0' ALT='" + getTitle() + "'>");

        // Print this element to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Evaluate the body of this tag
        return (EVAL_BODY_TAG);

    }
}