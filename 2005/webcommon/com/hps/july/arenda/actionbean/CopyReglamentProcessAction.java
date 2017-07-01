package com.hps.july.arenda.actionbean;

import java.util.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;

import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.Currency;
/**
 * Action-class.
 * действие для "Копирование регламента"
 * Creation date: (22.11.2002 12:13:03)
 * @author: Sergey Gourov
 */
public class CopyReglamentProcessAction extends com.hps.july.web.util.AbstractProcessAction {
/**
 * Insert the method's description here.
 * Creation date: (09.12.2002 10:24:26)
 * @return java.lang.String
 */
protected String getWhereForm() {
	return "";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	    ActionErrors errors = new ActionErrors();
		EditForm editForm = (EditForm) form;
	    editForm.setReturnPage("");
	    if (mapping.findForward("success") != null) {
			editForm.setReturnPage(mapping.findForward("success").getPath());
	    }

		MainParamsMutReglmntForm mpmrForm = (MainParamsMutReglmntForm) request.getSession().getAttribute(getWhereForm() + "MainParamsMutReglmntForm");
		int code = 0;
		
		try {
			LeaseMutualReglamentAccessBean sourceBean = new LeaseMutualReglamentAccessBean();
			sourceBean.setInitKey_leaseDocument(mpmrForm.getLeaseDocument());
			sourceBean.refreshCopyHelper();

			KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
			
			// copy with all parameters (state - редактируется)
			code = keyGen.getNextKey("tables.leasedocuments");
			LeaseMutualReglamentAccessBean targetBean = new LeaseMutualReglamentAccessBean(
				code, 															// argLeaseDocument int
				sourceBean.getDocumentDate(), 									// argDocDate java.sql.Date
				Integer.toString(keyGen.getNextKey("tables.leasemutualrglmnt")),// argDocNumber java.lang.String
				sourceBean.getMutualPeriod(), 									// argMutualPeriod java.lang.String
				new Integer(sourceBean.getMaincurrencyKey().currency), 			// argMainCurrency java.lang.Integer
				sourceBean.getCommonRate(), 									// argCommonRate java.lang.Boolean
				sourceBean.getActType(), 										// argActType java.lang.String
				"A", 															// argMutstate java.lang.String - edit
				sourceBean.getDutyraterule(), 									// argDutyraterule java.lang.String
				sourceBean.getStartdate(), 										// argStartDate java.sql.Date
				sourceBean.getEnddate() 										// argEndDate java.sql.Date
			);
			if (sourceBean.getAdditionalCurrency() != null) {
				targetBean.setAdditionalCurrency((Currency) sourceBean.getAdditionalCurrency().getEJBRef());
			} else {
				targetBean.setAdditionalCurrency(null);
			}
			targetBean.setCalcRateType(sourceBean.getCalcRateType());
			targetBean.setRegionid(sourceBean.getRegionid());
			setControlAccess(request, targetBean);
			targetBean.commitCopyHelper();
			
			// copy all other tables - contracts
			Enumeration e = new LeaseMutualContractsAccessBean().findLeaseMutualContractsByReglament(new LeaseDocumentKey(sourceBean.getLeaseDocument()));
			while (e.hasMoreElements()) {
				LeaseMutualContractsAccessBean lmcSourceBean = (LeaseMutualContractsAccessBean) e.nextElement();
				LeaseMutualContractsAccessBean lmcTargetBean = new LeaseMutualContractsAccessBean(
					new Integer(code), 											// argReglament java.lang.Integer
					new Integer(lmcSourceBean.getContractKey().leaseDocument), 	// argContract java.lang.Integer
					new Integer(lmcSourceBean.getResourceKey().resource) 		// argResource java.lang.Integer
				);
				lmcTargetBean.commitCopyHelper();
			}

			// copy rules
			e = new LeaseMutualRuleNewAccessBean().findLeaseMutualRulesByReglament(new LeaseDocumentKey(sourceBean.getLeaseDocument()));
			while (e.hasMoreElements()) {
				LeaseMutualRuleNewAccessBean lmrSourceBean = (LeaseMutualRuleNewAccessBean) e.nextElement();
				LeaseMutualRuleNewAccessBean lmcTargetBean = new LeaseMutualRuleNewAccessBean(
					new Integer(code),											// argReglament java.lang.Integer
					new Integer(lmrSourceBean.getResourceKey().resource),		// argResource java.lang.Integer
					lmrSourceBean.getChargedaterule(),							// argChargeDateRule java.lang.String
					lmrSourceBean.getPaydaterule(),								// argPayDateRule java.lang.String
					lmrSourceBean.getDopchargdatrul(),                          // argDopChargeDateRule java.lang.String
					lmrSourceBean.getRateType().intValue()							
				);
				lmcTargetBean.commitCopyHelper();
			}

			// copy phones
			e = new LeaseMutualPhoneAccessBean().findLeaseMutualPhoneByLeaseDocument(new LeaseDocumentKey(sourceBean.getLeaseDocument()));
			while (e.hasMoreElements()) {
				LeaseMutualPhoneAccessBean lmpSourceBean = (LeaseMutualPhoneAccessBean) e.nextElement();
				LeaseMutualPhoneAccessBean lmpTargetBean = new LeaseMutualPhoneAccessBean(
					new Integer(code),			// argDocument java.lang.Integer
					lmpSourceBean.getPhone()	// argPhone java.lang.String
				);
				lmpTargetBean.commitCopyHelper();
			}

			// copy priopity
			e = new LeaseMRCntPriorAccessBean().findLeaseMRCntPriorsByReglament(new LeaseDocumentKey(sourceBean.getLeaseDocument()));
			while (e.hasMoreElements()) {
				LeaseMRCntPriorAccessBean lpSourceBean = (LeaseMRCntPriorAccessBean) e.nextElement();
				LeaseMRCntPriorAccessBean lpTargetBean = new LeaseMRCntPriorAccessBean(
					new Integer(code),											// argReglament java.lang.Integer
					new Integer(lpSourceBean.getContract1Key().leaseDocument),	// argContract1 java.lang.Integer
					new Integer(lpSourceBean.getContract2Key().leaseDocument),	// argContract2 java.lang.Integer
					lpSourceBean.getPriority()									// argPriority java.lang.Short
				);
				lpTargetBean.commitCopyHelper();
			}
		} catch(Exception ex) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.copy"));
		}
	    
		//process errors
		if (errors.empty()) {
			return new ActionForward("View" + getWhereForm() + "MainParamsMutReglmnt.do?action=View&isShowMessage=1&leaseDocument=" + code);
		} else {
			saveErrors(request, errors);
			ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
			return mapping.findForward("main");
		}
	}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2005 14:10:15)
 */
private void setControlAccess(HttpServletRequest request, LeaseMutualReglamentAccessBean bean) {
    PeopleVO operatorVO = com.hps.july.arenda.cdbcobjects.CDBC_Helper.getPeopleVO_fromOperatorCode(request.getRemoteUser());
    //контроль доступа:
    if (operatorVO != null) {
        bean.setCreatedby(operatorVO.getMan());
        bean.setCreated(new java.sql.Timestamp(System.currentTimeMillis()));
        bean.setModifiedby(operatorVO.getMan());
        bean.setModified(new java.sql.Timestamp(System.currentTimeMillis()));
    }
}
}
