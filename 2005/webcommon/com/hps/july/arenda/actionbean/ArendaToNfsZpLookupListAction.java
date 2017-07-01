/*
 * Created on 22.05.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.actionbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.arenda.APPStates;
import com.hps.july.arenda.formbean.ArendaToNfsZpLookupListForm;
import com.hps.july.constants.Applications;
import com.hps.july.persistence.LeaseArendaAgreementNewAccessBean;
import com.hps.july.web.util.ParamsParser;

/**
 * @author IShaffigulin
 *
 *  LookupListAction "Связывает заказы на приобретение из NFS с договором аренды".
 */
public class ArendaToNfsZpLookupListAction extends ArendaToNfsZpListAction {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#perform(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ActionErrors errors = new ActionErrors();
		ArendaToNfsZpLookupListForm eform = (ArendaToNfsZpLookupListForm) form;
		try {
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
			bean.setInitKey_leaseDocument(eform.getLeaseDocument());
			bean.refreshCopyHelper();
			if (bean.getMainDocument() != null) {
				Integer mainKey = bean.getMainDocument();
				bean = new LeaseArendaAgreementNewAccessBean();
				bean.setInitKey_leaseDocument(mainKey.intValue());
				bean.refreshCopyHelper();
			}
			setParametersFromMainLeaseDocumet(eform, bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (eform.getAction().equalsIgnoreCase("Add")) {
			addZP(errors, eform.getIdZpNfs(), eform.getAgreement().getO().getMainLeaseDocument());
			eform.setAction("View");
		} else if (eform.getAction().equalsIgnoreCase("Delete")) {
			deleteZP(eform.getIdZpNfs(), eform.getAgreement().getO().getMainLeaseDocument());
			eform.setAction("View");
		} else if (eform.getAction().equalsIgnoreCase("Edit")) {
			String isActive = request.getParameter("isActive.x");
			if ((isActive != null) && (Integer.parseInt(isActive) > 0)) {
				editIsActiveZP(eform.getIdZpNfs(), eform.getAgreement().getO().getMainLeaseDocument());
				eform.setAction("View");
			}
		}
		if (!errors.empty())
			saveErrors(request, errors);
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.ARENDA_TO_NFS_ZP_LOOKUP_LIST);
		return mapping.findForward("main");

	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.NavigatedAction#isAddtoHistory()
	 */
	public boolean isAddtoHistory() {
		return false;
	}

}
