package com.hps.july.arenda.actionbean;

import com.hps.july.platinum.sessionbean.*;
import com.hps.july.arenda.valueobject.*;
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
 * Действие для "платежей".
 * Creation date: (27.06.2002 17:15:17)
 * @author: Sergey Gourov
 */
public class ShowPaymentsListAction extends com.hps.july.web.util.BrowseAction {
public void clearAllParams(PaymentsListForm oform)
{
	oform.setDocumentNumber("");
	oform.setDocumentDate(null);
	oform.setStateOfContract("");
	oform.setStartDate(null);
	oform.setEndDate(null);
	oform.setOrgCustomer("");
	oform.setOrgExecutor("");
	oform.setOrgExecutorcode(0);
	oform.setCurrency1(null);
	oform.setCurrency2(null);
	oform.setCurr1("");
	oform.setCurr2("");
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	return o;

	/*
	LeasePaymentAccessBean bean = (LeasePaymentAccessBean) o;
	LeasePaymentValueObject valueObject = new LeasePaymentValueObject(bean);
	
	try {
		if (bean.getPaymentType().equals("O")) {
			LeasePayOrderAccessBean lpoBean = new LeasePayOrderAccessBean();
			lpoBean.setInitKey_leaseDocPosition(bean.getLeaseDocPosition());
			lpoBean.refreshCopyHelper();
			
			valueObject.setOrgExecutor(lpoBean.getOrgAcc().getOrganization());
			valueObject.setOrgAcc(lpoBean.getOrgAcc());
			valueObject.setPayPurpose(lpoBean.getPayPurpose());
			valueObject.setBillDate(lpoBean.getBillDate());
			valueObject.setBillNumber(lpoBean.getBillNumber());
			valueObject.setPptype(lpoBean.getPpType());
			
			try {
				DopInfoLPaymentAccessBean dilpBean = new DopInfoLPaymentAccessBean();
				dilpBean.setInitKey_leasedocposition(bean.getLeaseDocPosition());
				dilpBean.refreshCopyHelper();
				
				if (dilpBean.getPurposepay() != null && !dilpBean.getPurposepay().equals("")) {
					valueObject.setPayPurpose(dilpBean.getPurposepay());
				}
			} catch (javax.ejb.ObjectNotFoundException ex) {}
		} else {
			valueObject.setOrgExecutor(bean.getLeaseContract().getOrgExecutor());
			valueObject.setOrgAcc(null);
			valueObject.setPayPurpose("");
			valueObject.setBillDate(null);
			valueObject.setBillNumber("");
			valueObject.setPptype("");
		}
	} catch (Exception ex) {
		ex.printStackTrace();
		valueObject.setOrgExecutor(null);
		valueObject.setOrgAcc(null);
		valueObject.setPayPurpose("");
		valueObject.setBillDate(null);
		valueObject.setBillNumber("");
		valueObject.setPptype("");
	}
	
	try {
		DopInfoLPaymentAccessBean pie = new DopInfoLPaymentAccessBean();
		pie.setInitKey_leasedocposition(bean.getLeaseDocPosition());
		pie.refreshCopyHelper();
		
		valueObject.setNumpayplatinum(pie.getNumpayplatinum());
	} catch (Exception e) {
		e.printStackTrace();
		valueObject.setNumpayplatinum("");
	}
	
	return valueObject;
	*/
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 17:15:17)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCLeasePaymentObject";
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
	//TimeCounter counter = new TimeCounter("PERF.ARENDA.ShowPaymentsList");
	//counter.start();

	ParamsParser.setState(request, Applications.ARENDA, APPStates.PAYMENTS_LIST);

	PaymentsListForm oform = (PaymentsListForm) form;
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
		e.printStackTrace(System.out);
		clearAllParams(oform);
	}

	if (request.getParameter("document") != null) {
		try {
			LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
			lpBean.setInitKey_leaseDocPosition(Integer.parseInt((String) request.getParameter("document")));
			lpBean.refreshCopyHelper();

			if (lpBean.getIsSchetFakt().equals("Y")) {
				lpBean.setIsSchetFakt("N");
			} else if (lpBean.getIsSchetFakt().equals("N")) {
				lpBean.setIsSchetFakt("Y");
			}

			lpBean.commitCopyHelper();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	oform.setIsSyncnriplatinumarenda(false);
	try {
		oform.setIsSyncnriplatinumarenda(new ArendaPlatinumProcessorAccessBean().isProcessingEnabled());
	} catch (Exception e) {
		e.printStackTrace();
	}

	super.perform(mapping, form, request, response);
	
	//counter end
	//counter.finish("action");
	
	return mapping.findForward("main");
}
public void setCurrencyParams(PaymentsListForm oform, LeaseArendaAgreementNewAccessBean bean)
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
		System.out.println("ShowPAYMENTS.setCurrencyParams, EXCEPTION.");
		e.printStackTrace(System.out);
	}
}
public void setMainParams(PaymentsListForm oform, LeaseArendaAgreementNewAccessBean bean)
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
		oform.setOrgExecutorcode(bean.getOrgExecutor().getOrganization());
		oform.setMainPosition(getNameMainPosition(bean));
	} catch(Exception e) {
		System.out.println("ShowPAYMENTS.setMainParams, EXCEPTION.");
		e.printStackTrace(System.out);
	}
}
}
