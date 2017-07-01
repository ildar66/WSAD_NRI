package com.hps.july.arenda.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.arenda.formbean.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;
/**
 * Action-class.
 * действие для "состояние абонента"
 * Creation date: (28.09.2002 12:44:01)
 * @author: Sergey Gourov
 */
public class ProcessAbonentState extends NavigatedAction {
    public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ActionForward retVal = null;	
	    ActionErrors errors = new ActionErrors();

		PositionMultiListForm pm = (PositionMultiListForm) request.getSession().getAttribute("PositionMultiListForm");
		ArendaPositionsListForm ap = (ArendaPositionsListForm) request.getSession().getAttribute("ArendaPositionsListForm");
		
	    // Add all positions to our leaseArendaAgreement
		for (int i = 0; i < pm.getSelectedPos().length; i++) {
			int code = pm.getSelectedPos() [i];
			if (code != 0) {
				int leaseDocument = ap.getLeaseDocument();
				try {
					LeaseOnPositionAccessBean lopBean = new LeaseOnPositionAccessBean();
					lopBean.setInitKey_leaseArendaAgreementNew_leaseDocument(new Integer(leaseDocument));
					lopBean.setInitKey_position_storageplace(new Integer(code));
					lopBean.refreshCopyHelper();
					
					// If we are here, then position is already in leaseArendaAgreement
					PositionAccessBean posBean = new PositionAccessBean();
					posBean.setInitKey_storageplace(code);
					posBean.refreshCopyHelper();
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.dup.we.position.multi",
						new Integer(code), posBean.getName()));
				} catch(Exception e) {
					try {			
						LeaseOnPositionAccessBean lopBean = new LeaseOnPositionAccessBean(new Integer(leaseDocument), new Integer(code));
					} catch(Exception ex) {
					    ErrorProcessor.processException(errors, ex);
					}
				}
			}
		}
	    
		//process errors
		if( !errors.empty() ) {
			saveErrors(request, errors);
			retVal = mapping.findForward("errorgoback");
  		} else {
			retVal = mapping.findForward("success");
		}
		
	    return retVal;
    }
}
