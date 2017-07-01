package com.hps.july.project.actionbean;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.project.APPStates;
import com.hps.july.project.formbean.*;
import com.hps.july.project.*;
import com.hps.july.persistence.*;
import java.io.IOException;
import java.util.*;

/**
 * Вывод документа по проекту.
 * Устарело. Не используется.
 * @deprecated
 * Creation date: (25.09.2002 18:01:10)
 * @author: Maksim Gerasimov
 */
public class OpenFileAction extends org.apache.struts.action.Action {
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
    super.perform(mapping, form, request, response);

    try {

        int document =
            Integer.parseInt((String) request.getParameter("projectactiondocument"));

        ServletOutputStream out = response.getOutputStream();

        // Get AccessBean
        ProjectActionDocumentAccessBean bean = new ProjectActionDocumentAccessBean();
        bean.setInitKey_projectactiondocument(document);
        bean.refreshCopyHelper();

        // Get BLOB field
        byte[] blob = bean.getDocbody();
        String name = bean.getDocname();

        // Output blob to stream
        if ((name != null) && (name.length() > 0) && (blob != null)) {
            response.setContentType("application/octet-stream; name=" + name);
            response.setHeader("Content-Disposition", "inline;filename=" + name);
            out.write(blob);
            out.flush();
            out.close();
        }
    } catch (Exception e) {
        Util_Alex.pr(e,"perform",this);
        throw new ServletException(e);
    } finally {
        return null;
    }
}
}
