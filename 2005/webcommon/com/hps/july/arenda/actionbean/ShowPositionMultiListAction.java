package com.hps.july.arenda.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.arenda.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.arenda.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Action-class.
 * �������� ��� "���� �������".
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowPositionMultiListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.PositionAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.POS_MULTI);

		PositionMultiListForm oform = (PositionMultiListForm) form;
		if((oform.getSearchmode() == 1 || oform.getSearchmode() == 2) && !oform.getSearchstr().equals("")){
			try {
				int position = Integer.parseInt(oform.getSearchstr());
			} catch (Exception e) {
				ActionErrors errors = new ActionErrors();
                errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.positionnumber.invalid"));
                saveErrors(request, errors);
                request.setAttribute("browseList", new Object[0]);
		        request.setAttribute("numberOfPages", new Integer(1));
                return mapping.findForward("main");
			}
		}
    	try {
	    	OrganizationAccessBean bean = new OrganizationAccessBean();
 	 		bean.setInitKey_organization(oform.getOrganization().intValue());
 	 		bean.refreshCopyHelper();
			oform.setOrgname(bean.getName());
	    } catch (Exception e) {
		    e.printStackTrace();
		    oform.setOrganization(new Integer(0));
 	 		oform.setOrgname("");
    	}

    	try {
	    	WorkerAccessBean bean = new WorkerAccessBean();
 	 		bean.setInitKey_worker(oform.getWorker().intValue());
 	 		bean.refreshCopyHelper();
			oform.setWorkername(bean.getMan().getFullName());
	    } catch (Exception e) {
		    e.printStackTrace();
		    oform.setWorker(new Integer(0));
 	 		oform.setWorkername("");
    	}
	    
		ActionForward retVal = super.perform(mapping, form, request, response);
		if (retVal == null) {
			retVal = mapping.findForward("main");
		}
		return retVal;
	}
}
