package com.hps.july.security.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.security.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.security.formbean.*;
import com.hps.july.security.valueobject.PeopleWrap;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Выбор физического лица.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowPeopleLookupListAction extends com.hps.july.web.util.BrowseAction {

/**
* Insert the method's description here.
* Creation date: (22.05.2002 16:35:23)
* @return java.lang.Object
* @param o java.lang.Object
*/
public Object constructRowModelBean(Object o) { //
    PeopleAccessBean pab = (PeopleAccessBean) o;
    PeopleWrap wrap = new PeopleWrap();
    wrap.setAb(pab);
    try {
        OperatorAccessBean oab = new OperatorAccessBean();
        Enumeration operators = oab.findOperatorsByMan(new PeopleKey(pab.getMan()));
        if (operators.hasMoreElements()) {
	        OperatorAccessBean firstAB = (OperatorAccessBean) operators.nextElement();
            String firstOperator = firstAB.getLogin();
            wrap.setFirstOperator(firstOperator);
            int operatorToCopy = firstAB.getOperator();
            wrap.setOperatorToCopy(operatorToCopy);
        } else {
            wrap.setFirstOperator("");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return wrap;
}
    /**
     * Insert the method's description here.
     * Creation date: (22.01.2002 12:02:58)
     * @return java.lang.String
     */
    public java.lang.String getBrowseBeanName() {
        return "com.hps.july.persistence.PeopleAccessBean";
    }
    public ActionForward perform(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response)
        throws IOException, ServletException {
        super.perform(mapping, form, request, response);
        ParamsParser.setState(request, Applications.SECURITY, APPStates.PPLLOOKUP);
        return mapping.findForward("main");
    }
}
