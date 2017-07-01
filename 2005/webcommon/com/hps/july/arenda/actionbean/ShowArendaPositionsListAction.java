package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.arenda.formbean.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * действие для "поиск позиций"
 * Creation date: (01.07.2002 11:52:19)
 * @author: Sergey Gourov
 */
public class ShowArendaPositionsListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	LeaseOnPositionAccessBean bean = (LeaseOnPositionAccessBean) o;
	LeaseOnPositionValueObject valueObject = new LeaseOnPositionValueObject(bean);
	
	try {
		PositionResponsibleWorkersAccessBean workResponsibility = new PositionResponsibleWorkersAccessBean();
		workResponsibility.setInitKey_position_storageplace(new Integer(bean.getPosition().getStorageplace()));

		NamedValueAccessBean namedValue = new NamedValueAccessBean();
		namedValue.setInitKey_id("RESPONSIBLE_ARENDA");
		namedValue.refreshCopyHelper();

		workResponsibility.setInitKey_type_responsibilityType(new Integer(namedValue.getIntvalue()));
		workResponsibility.setInitKey_resptype("W");
		workResponsibility.refreshCopyHelper();

		valueObject.setMainManager(workResponsibility.getWorker().getMan().getFullName());
	} catch(Exception ex) {
		ex.printStackTrace();
		valueObject.setMainManager("");
	}

	return valueObject;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 11:52:19)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseOnPositionAccessBean";
}
public ActionForward perform(
	ActionMapping mapping,
	ActionForm form,
	HttpServletRequest request,
	HttpServletResponse response)
	throws IOException, ServletException {
	ParamsParser.setState(request, Applications.ARENDA, APPStates.ARENDA_POS_LIST);

	ArendaPositionsListForm oform = (ArendaPositionsListForm) form;

	try {
		LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
		bean.setInitKey_leaseDocument(oform.getLeaseDocument());
		bean.refreshCopyHelper();

		if (bean.getMainDocument() != null) {
			oform.setLeaseDocument(bean.getMainDocument().intValue());
			bean = new LeaseArendaAgreementNewAccessBean();
			bean.setInitKey_leaseDocument(oform.getLeaseDocument());
			bean.refreshCopyHelper();
		}

		oform.setDocumentNumber(bean.getDocumentNumber());
		oform.setStateOfContract(bean.getContractState());
		oform.setStartDate(bean.getStartDate());
		oform.setEndDate(bean.getEndDate());
		oform.setOrgCustomer(bean.getOrgCustomer().getName());
		oform.setOrgExecutor(bean.getOrgExecutor().getName());
		if (bean.getEconomist() != null) {
			oform.setMainEconomist(bean.getEconomist().getMan().getFullName());
		} else {
			oform.setMainEconomist("");
		}
		oform.setCurrency1(bean.getSumm1());
		oform.setCurrency2(bean.getSumm2());
		oform.setCurr1(bean.getCurrency1().getShortname());
		if (bean.getCurrency2() != null) {
			oform.setCurr2(bean.getCurrency2().getShortname());
		} else {
			oform.setCurr2("");
		}
		//patch SI start
		String setMainPosition = request.getParameter("setMainPosition.x");
		if ((setMainPosition != null) && (Integer.parseInt(setMainPosition) > 0)) {
			//Изменение главной позизии
			try {
				PositionAccessBean positionAB = new PositionAccessBean();
				positionAB.setInitKey_storageplace(oform.getMainPosition().intValue());
				positionAB.refreshCopyHelper();
				bean.setMainposition((Position) positionAB.getEJBRef());
				bean.refreshCopyHelper();
			} catch (Exception e) {
				e.printStackTrace(System.out);
				// Errors during change
				ActionErrors errors = new ActionErrors();
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.change.positionMain"));
				saveErrors(request, errors);
			}
		}
		if (bean.getMainpositionKey() != null) {
			oform.setMainPosition(new Integer(bean.getMainpositionKey().storageplace));
		} else {
			oform.setMainPosition(null);
		}
		//patch SI end
	} catch (Exception e) {
		e.printStackTrace();
		oform.setDocumentNumber("");
		oform.setStateOfContract("");
		oform.setStartDate(null);
		oform.setEndDate(null);
		oform.setOrgCustomer("");
		oform.setOrgExecutor("");
		oform.setMainEconomist("");
		oform.setCurrency1(null);
		oform.setCurrency2(null);
		oform.setCurr1("");
		oform.setCurr2("");
	}

	/* Антон Стефанов:
	 * Обработка включения позиции в список.
	 * Если включение проходит не удачно то ошибки выводятся только в лог.
	 */
	String incPos = request.getParameter("incpos");
	if (incPos != null && "add".equals(incPos)) {
		oform.addPosition();
	}
	super.perform(mapping, form, request, response);
	return mapping.findForward("main");
}
}
