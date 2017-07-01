package com.hps.july.security.actionbean;

import com.hps.july.security.formbean.*;
//
import org.apache.struts.action.*;
//
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
//
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.security.*;
import com.hps.july.security.valueobject.*;
import com.hps.july.constants.*;

/**
 * Режим копирования оператора (с правами) - вход.
 * Creation date: (28.03.2003 16:55:04)
 * @author: Alexander Makanin
 */
public class CopyOperatorAccessAction extends Action {

/*
* @param ActionMapping mapping
* @param ActionForm form
* @param HttpServletRequest request
* @param HttpServletResponse response
* @throws IOException - something wrong
* @throws ServletException - something wrong
* @return ActionForward
*/
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {

    CopyOperatorAccessForm cform = (CopyOperatorAccessForm) form;
    if (mapping.findForward("goback") != null)
        cform.setReturnPage(mapping.findForward("goback").getPath());
    try {
        OperatorAccessBean bean = new OperatorAccessBean();
        int operator = (cform.getOperator()!=0) ? (cform.getOperator()) : ((OperatorAccessBean)request.getSession().getAttribute("operator")).getOperator();
        bean.setInitKey_operator(operator);
        bean.refreshCopyHelper();
        request.getSession().setAttribute("operator", bean);
    } catch (Exception e) {
        throw new ServletException(e);
    }
    ParamsParser.setState(request, Applications.SECURITY, APPStates.ACCRIGHTCPY);
    return mapping.findForward("main");
}
}
