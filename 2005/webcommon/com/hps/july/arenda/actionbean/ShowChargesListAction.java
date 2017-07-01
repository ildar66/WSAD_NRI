package com.hps.july.arenda.actionbean;

import java.math.*;
import com.hps.july.persistence.*;
import com.hps.july.arenda.formbean.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.TimeCounter;
/**
 * Action-class.
 * действие для "начислений(лист)".
 * Creation date: (27.06.2002 17:15:17)
 * @author: Sergey Gourov
 */
public class ShowChargesListAction extends com.hps.july.web.util.BrowseAction {
public void clearAllParams(ChargesListForm oform)
{
	oform.setDocumentNumber("");
	oform.setDocumentDate(null);
	oform.setStateOfContract("");
	oform.setStartDate(null);
	oform.setEndDate(null);
	oform.setOrgCustomer("");
	oform.setOrgExecutor("");
	oform.setCurrency1(null);
	oform.setCurrency2(null);
	oform.setCurr1("");
	oform.setCurr2("");
	oform.setOrgCustomercode(null);
	oform.setOrgExecutorcode(null);
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 17:15:17)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseChargesAccessBean";
}
/**
 * Поиск главной позиции.
 * Creation date: (01.03.2004 13:41:28)
 */

private String getNameMainPosition(LeaseArendaAgreementNewAccessBean arendaBean) throws Exception {
	String name = "";
	PositionAccessBean bean = arendaBean.getMainposition();
	if (bean != null) {
		name = com.hps.july.basestation.valueobject.PositionModel.getPositionFullName(bean);
	}
	return name;
}
public ActionForward perform(
	ActionMapping mapping,
	ActionForm form,
	HttpServletRequest request,
	HttpServletResponse response)
	throws IOException, ServletException {
	//start counter:
	//TimeCounter counter = new TimeCounter("PERF.ARENDA.ShowChargesList");
	//counter.start();

	ParamsParser.setState(request, Applications.ARENDA, APPStates.CHARGES_LIST);

	ChargesListForm oform = (ChargesListForm) form;
	try {
		LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
		bean.setInitKey_leaseDocument(oform.getLeaseContract());
		bean.refreshCopyHelper();

		if (bean.getMainDocument() != null) {
			oform.setSourceContract(oform.getLeaseContract());
			oform.setLeaseContract(bean.getMainDocument().intValue());
			LeaseArendaAgreementNewAccessBean mbean = new LeaseArendaAgreementNewAccessBean();
			mbean.setInitKey_leaseDocument(oform.getLeaseContract());
			mbean.refreshCopyHelper();
			setMainParams(oform, mbean);
			//из активного:
			try {
				LeaseArendaAgreementNewAccessBean active =
					com.hps.july.logic.DocumentLogic.getActiveDocument(mbean, bean.getMainDocument());
				if (active == null)
					active = mbean;
				setCurrencyParams(oform, active);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Find Source bean
			setMainParams(oform, bean);
			//из активного:
			try {
				LeaseArendaAgreementNewAccessBean active =
					com.hps.july.logic.DocumentLogic.getActiveDocument(bean, new Integer(bean.getLeaseDocument()));
				if (active == null)
					active = bean;
				setCurrencyParams(oform, active);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	} catch (Exception e) {
		e.printStackTrace();
		clearAllParams(oform);
	}

	super.perform(mapping, form, request, response);
	//counter end
	//counter.finish("action");
	
	return mapping.findForward("main");
}
public void setCurrencyParams(ChargesListForm oform, LeaseArendaAgreementNewAccessBean bean)
{
	if(bean == null || oform == null) {
		return;
	}
	try {
		oform.setCurrency1(bean.getSumm1());
		oform.setCurrency2(bean.getSumm2());
		oform.setCurr1(bean.getCurrency1().getShortname());
		if (bean.getCurrency2() != null) {
			oform.setCurr2(bean.getCurrency2().getShortname());
		} else {
			oform.setCurr2("");
		}
	} catch(Exception e) {
		System.out.println("ShowCHARGES.setCurrencyParams, EXCEPTION.");
		e.printStackTrace(System.out);
	}
}
public void setMainParams(ChargesListForm oform, LeaseArendaAgreementNewAccessBean bean)
{
	if(bean == null || oform == null) {
		return;
	}
	try {
		oform.setDocumentNumber(bean.getDocumentNumber());
		oform.setDocumentDate(bean.getDocumentDate());
		oform.setStateOfContract(bean.getContractState());
		oform.setStartDate(bean.getStartDate());
		oform.setEndDate(bean.getEndDate());
		oform.setOrgCustomer(bean.getOrgCustomer().getName());
		oform.setOrgExecutor(bean.getOrgExecutor().getName());
		oform.setOrgCustomercode(new Integer(bean.getOrgCustomer().getOrganization()));
		oform.setOrgExecutorcode(new Integer(bean.getOrgExecutor().getOrganization()));
		oform.setMainPosition(getNameMainPosition(bean));
	} catch(Exception e) {
		System.out.println("ShowCHARGES.setMainParams, EXCEPTION.");
		e.printStackTrace(System.out);
	}
}
}
