package com.hps.july.sitedoc.actionbean;

import com.hps.july.persistence.*;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.sitedoc.*;
import com.hps.july.constants.Applications;
import com.hps.july.web.util.*;

/**
 * Обработчик удаления отмеченных файлов
 */
public class DeleteSiteDocFileListAction extends org.apache.struts.action.Action {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
    try {
        SiteDocFileAccessBean bean;
        String[] params = request.getParameterValues("check_del");
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                bean = new SiteDocFileAccessBean();
                bean.setInitKey_sitedocfile(Integer.parseInt(params[i]));
                bean.refreshCopyHelper();
                bean.getEJBRef().remove();
            }
        }
        ParamsParser.setState(request, Applications.SITEDOC, APPStates.SiteDocForm);
        return mapping.findForward("main");
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw new ServletException(e);

    }
}
}
