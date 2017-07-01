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
 * Права доступа по суперрегионам.
 * Creation date: (24.03.2003 19:25:58)
 * @author: Alexander Makanin
 */
public class ShowSuperRegionAccessListAction extends BrowseAction {
    /**
     * ShowSuperRegionAccessListAction constructor comment.
     */
    public ShowSuperRegionAccessListAction() {
        super();
    }
    /**
     * @return String browse bean name.
     * Creation date: (24.03.2003 19:29:29)
     * @return java.lang.String
     */
    public String getBrowseBeanName() {
        return "com.hps.july.persistence.SuperRegionAccessBean";
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

        SuperRegionAccessListForm frm = (SuperRegionAccessListForm)form;
        int operator = frm.getOperator().intValue();

        try {	  		
	  		OperatorAccessBean bean = new OperatorAccessBean();
	  		bean.setInitKey_operator( operator );
	  		bean.refreshCopyHelper();
		    request.getSession().setAttribute( "operator", bean );
	  	} catch (Exception e) {
			throw new ServletException( e );
	  	}
             
        SuperRegionAccAccessBean ab = new SuperRegionAccAccessBean();
        try {
            Enumeration enum = ab.findSuperRegionAccsByOperator(new OperatorKey(operator));
            ArrayList accessCollection = new ArrayList();
            while (enum.hasMoreElements()) {
	            SuperRegionAccAccessBean sab = (SuperRegionAccAccessBean)enum.nextElement();
	            SuperRegionAccess sra = new SuperRegionAccess(sab);
	            sra.setOperator(operator);
                accessCollection.add(sra);
            }
            form = SuperRegionAccess.formFromCollection(accessCollection, (SuperRegionAccessListForm) form);
        } catch (javax.ejb.FinderException fe) {
            fe.printStackTrace();
        } catch (javax.naming.NamingException ne) {
            ne.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ParamsParser.setState(request, Applications.SECURITY, APPStates.SPRREGLIST);
     	ActionForward fwd = super.perform(mapping, form, request, response);
    	if (fwd != null)
    		return fwd;
       return mapping.findForward("main");
}
}
