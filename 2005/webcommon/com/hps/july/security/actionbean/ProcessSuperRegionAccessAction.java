package com.hps.july.security.actionbean;

import java.util.*;
import com.hps.july.security.formbean.*;
//
import org.apache.struts.action.*;
//
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
//
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.security.*;
import com.hps.july.security.valueobject.*;
import com.hps.july.constants.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Сохранение прав доступа на суперрегионы.
 * Creation date: (26.03.2003 19:11:28)
 * @author: Alexander Makanin
 */
public class ProcessSuperRegionAccessAction extends Action {
    /**
     * ProcessSuperRegionAccess constructor comment.
     */
    public ProcessSuperRegionAccessAction() {
        super();
    }
    /*
    *
    **/
    public ActionForward perform(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response)
        throws IOException, ServletException {

	    validateEmptyArrays(form,request);
	        
        ActionForward retVal = null;
        ActionErrors errors = new ActionErrors();

        SuperRegionAccessListForm sprregfrm =
            (SuperRegionAccessListForm) request.getSession().getAttribute(
                "SuperRegionAccessListForm");
        OperatorAccessBean oab =
            (OperatorAccessBean) request.getSession().getAttribute("operator");
        ArrayList list = SuperRegionAccess.collectionFromForm(sprregfrm);

        //delete all superregionaccesses by operator
        SuperRegionAccAccessBean ab0 = new SuperRegionAccAccessBean();
        try {
            int operator = oab.getOperator();
            Enumeration enum = ab0.findSuperRegionAccsByOperator(new OperatorKey(operator));
            while (enum.hasMoreElements()) {
                SuperRegionAccAccessBean sab = (SuperRegionAccAccessBean) enum.nextElement();
                sab.getEJBRef().remove();
            }
        } catch (javax.ejb.FinderException fe) {
            fe.printStackTrace();
        } catch (javax.naming.NamingException ne) {
            ne.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //insert
        try {
            int operator = oab.getOperator();
            KeyGeneratorAccessBean gen = new KeyGeneratorAccessBean();
            Iterator itr = list.iterator();
            while (itr.hasNext()) {
                SuperRegionAccess sra = (SuperRegionAccess) itr.next();
                int accessid = gen.getNextKey("tables.regionsaccess");
                SuperRegionAccAccessBean ab =
                    new SuperRegionAccAccessBean(
                        accessid,
                        operator,
                        sra.getSuperregionid(),
                        sra.isViewplan(),
                        sra.isViewfact(),
                        sra.isEditplan(),
                        sra.isEditfact());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //process errors
        if (!errors.empty()) {
            saveErrors(request, errors);
            retVal = mapping.findForward("error");
        } else {
            retVal = mapping.findForward("success");
        }
        return retVal;
    }
    /**
    * Insert the method's description here.
    * Creation date: (03.04.2003 11:17:40)
    * @param form org.apache.struts.action.ActionForm
    * @param request javax.servlet.http.HttpServletRequest
    */
    public void validateEmptyArrays(ActionForm form, HttpServletRequest request) {
        if (request.getParameter("viewplan") == null)
             ((SuperRegionAccessListForm) form).setViewplan(new int[0]);
        if (request.getParameter("editplan") == null)
             ((SuperRegionAccessListForm) form).setEditplan(new int[0]);
        if (request.getParameter("viewfact") == null)
             ((SuperRegionAccessListForm) form).setViewfact(new int[0]);
        if (request.getParameter("editfact") == null)
             ((SuperRegionAccessListForm) form).setEditfact(new int[0]);
    }
}
