package com.hps.july.security.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.security.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.security.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Выбор оператора.
 * Creation date: (01.04.2003 11:50:37)
 * @author: Alexander Makanin
 */
public class ShowOperatorLookupListAction extends com.hps.july.web.util.BrowseAction {
    /**
     * Insert the method's description here.
     * Creation date: (01.04.2003 11:50:37)
     * @return java.lang.String
     */
    public String getBrowseBeanName() {
        return "com.hps.july.persistence.OperatorAccessBean";
    }
    public ActionForward perform(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response)
        throws IOException, ServletException {
        super.perform(mapping, form, request, response);
        ParamsParser.setState(request, Applications.SECURITY, APPStates.OPERLOOKUP);
        return mapping.findForward("main");
    }
}
