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
import com.hps.july.security.valueobject.RegionAccess;
import com.hps.july.constants.*;

/**
 * Список прав доступа по региону.
 * Creation date: (28.03.2003 9:10:06)
 * @author: Alexander Makanin
 */
public class ShowRegionAccessListAction extends BrowseAction {
    /**
     * ShowRegionAccessListAction constructor comment.
     */
    public ShowRegionAccessListAction() {
        super();
    }
    /**
     * @return String browse bean name.
     * Creation date: (24.03.2003 19:29:29)
     * @return java.lang.String
     */
    public String getBrowseBeanName() {
        return "com.hps.july.persistence.RegionAccessBean";
    }
    /**
    * Insert the method's description here.
    * Creation date: (22.01.2002 17:12:04)
    * @return int
    */
    public int getRowsOnPage() {
        return 200;
    }
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
	
  	
	    RegionAccessListForm frm = (RegionAccessListForm)form;
        int operator = frm.getOperator().intValue();

        try {
            OperatorAccessBean bean = new OperatorAccessBean();
            bean.setInitKey_operator(operator);
            bean.refreshCopyHelper();
            request.getSession().setAttribute("operator", bean);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        RegionAccessListForm frm2 =
            (RegionAccessListForm) request.getSession().getAttribute(
                "RegionAccessListForm");
        int superregionid = frm2.getSuperregionid();
        boolean allsuperregions = frm2.isAllsuperregions();
        RegionAccAccessBean ab = new RegionAccAccessBean();
        try { //isSuperregion??
            Enumeration enum =
                ab.findByQBE(
                    new Integer(operator),
                    new Boolean(!allsuperregions),
                    new Integer(superregionid),
                    null);
            ArrayList accessCollection = new ArrayList();
            while (enum.hasMoreElements()) {
                RegionAccAccessBean rab = (RegionAccAccessBean) enum.nextElement();
                RegionAccess ra = new RegionAccess(rab);
                ra.setOperator(operator);
                accessCollection.add(ra);
            }
            form =
                RegionAccess.formFromCollection(accessCollection, (RegionAccessListForm) form);
        } catch (javax.ejb.FinderException fe) {
            fe.printStackTrace();
        } catch (javax.naming.NamingException ne) {
            ne.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ParamsParser.setState(request, Applications.SECURITY, APPStates.REGLIST);
    	ActionForward fwd = super.perform(mapping, form, request, response);
    	if (fwd != null)
    		return fwd;
        return mapping.findForward("main");
}
}
