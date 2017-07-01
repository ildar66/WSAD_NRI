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
 * Сохранение прав доступа на регионы.
 * Creation date: (28.03.2003 11:16:24)
 * @author: Alexander Makanin
 */
public class ProcessRegionAccessAction extends Action {
    /**
     * ProcessRegionAccessAction constructor comment.
     */
    public ProcessRegionAccessAction() {
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

        RegionAccessListForm regfrm =
            (RegionAccessListForm) request.getSession().getAttribute(
                "RegionAccessListForm");
        int superregionid = regfrm.getSuperregionid();
        boolean allsuperregions = regfrm.isAllsuperregions();
        OperatorAccessBean oab =
            (OperatorAccessBean) request.getSession().getAttribute("operator");
        ArrayList list = RegionAccess.collectionFromForm(regfrm);

        //delete all regionaccesses by operator
        RegionAccAccessBean ab0 = new RegionAccAccessBean();
        try {
            int operator = oab.getOperator();
            RegionAccAccessBean ab = new RegionAccAccessBean();
            Enumeration enum =
                ab.findByQBE(
                    new Integer(operator),
                    new Boolean(!allsuperregions),
                    new Integer(superregionid),
                    null);
            while (enum.hasMoreElements()) {
                RegionAccAccessBean sab = (RegionAccAccessBean) enum.nextElement();
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
                RegionAccess sra = (RegionAccess) itr.next();
                int accessid = gen.getNextKey("tables.regionsaccess");
                RegionAccAccessBean ab =
                    new RegionAccAccessBean(
                        accessid,
                        operator,
                        sra.getRegionid(),
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
            retVal = mapping.findForward("errorgoback");
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
             ((RegionAccessListForm) form).setViewplan(new int[0]);
        if (request.getParameter("editplan") == null)
             ((RegionAccessListForm) form).setEditplan(new int[0]);
        if (request.getParameter("viewfact") == null)
             ((RegionAccessListForm) form).setViewfact(new int[0]);
        if (request.getParameter("editfact") == null)
             ((RegionAccessListForm) form).setEditfact(new int[0]);
    }
}
