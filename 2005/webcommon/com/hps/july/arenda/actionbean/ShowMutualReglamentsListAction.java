package com.hps.july.arenda.actionbean;

import java.util.Enumeration;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.persistence.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * Действие для "Для создания отчетов(лист регламентам)".
 * Creation date: (09.07.2002 10:25:49)
 * @author: Sergey Gourov
 */
public class ShowMutualReglamentsListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Не используется(см. MutualReglamentListForm).
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	LeaseMutualReglamentAccessBean bean = (LeaseMutualReglamentAccessBean) o;
	LeaseMutualReglamentValueObject valueObject = new LeaseMutualReglamentValueObject(bean);
	valueObject.setContractList("");
	valueObject.setResourceList("");
	
	try {
		Enumeration e = new LeaseContractAccessBean().findLeaseContractsByReglamentOrderByCodeAsc(new Integer(bean.getLeaseDocument()));
		while (e.hasMoreElements()) {
			LeaseContractAccessBean lcBean = (LeaseContractAccessBean) e.nextElement();
			StringAndSqlDateProperty s = new StringAndSqlDateProperty();
			s.setSqlDate(lcBean.getDocumentDate());
			
			if (valueObject.getContractList().equals("")) {
				valueObject.setContractList(lcBean.getDocumentNumber() + "-" + s.getString());
			} else {
				valueObject.setContractList(valueObject.getContractList() + "; " + lcBean.getDocumentNumber() + "-" + s.getString());
			}
		}

		e = new ResourceAccessBean().findResourceByReglamentOrderByCodeAsc(new Integer(bean.getLeaseDocument()));
		while (e.hasMoreElements()) {
			ResourceAccessBean rBean = (ResourceAccessBean) e.nextElement();
			if (valueObject.getResourceList().equals("")) {
				valueObject.setResourceList(rBean.getName());
			} else {
				valueObject.setResourceList(valueObject.getResourceList() + "; " + rBean.getName());
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
		valueObject.setContractList("");
		valueObject.setResourceList("");
	}
	
	return valueObject;
}
/**
 * Не используется(см. MutualReglamentListForm).
 * Creation date: (09.07.2002 10:25:50)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseMutualReglamentAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.MUTUAL_REGLMNTS_LIST);
		
		MutualReglamentsListForm oform = (MutualReglamentsListForm) form;
		if (!oform.getIsLeaseContract().booleanValue()) {
			
			try {
				LeaseContractAccessBean bean = new LeaseContractAccessBean();
				bean.setInitKey_leaseDocument(oform.getLeaseContract().intValue());
				bean.refreshCopyHelper();

				if (bean.getContractType().equals("A")) {
					oform.setLeaseContract(new Integer(
						new LeaseArendaAgreementProcessorAccessBean().getBaseContract(oform.getLeaseContract().intValue())));
					bean = new LeaseContractAccessBean();
					bean.setInitKey_leaseDocument(oform.getLeaseContract().intValue());
					bean.refreshCopyHelper();
				}
				
				oform.setLeaseContractname(bean.getDocumentNumber());
				oform.setStartDate(bean.getStartDate());
				oform.setEndDate(bean.getEndDate());
				oform.setOrgCustomer(bean.getOrgCustomer().getName());
				oform.setOrgExecutor(bean.getOrgExecutor().getName());
				oform.setCurrency1(bean.getSumm1());
				oform.setCurr1(bean.getCurrency1().getShortname());
				if (bean.getSumm2() != null) {
					oform.setCurrency2(bean.getSumm2());
					oform.setCurr2(bean.getCurrency2().getShortname());
				} else {
					oform.setCurrency2(null);
					oform.setCurr2("");
				}
			} catch(Exception ex) {
				//ex.printStackTrace();
				oform.setLeaseContract(new Integer(0));
				oform.setLeaseContractname("");
				oform.setStartDate(null);
				oform.setEndDate(null);
				oform.setOrgCustomer("");
				oform.setOrgExecutor("");
				oform.setCurrency1(null);
				oform.setCurr1("");
				oform.setCurrency2(null);
				oform.setCurr2("");
			}
			
		} else {
			oform.setLeaseContract(new Integer(0));
			oform.setLeaseContractname("");
		}
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
