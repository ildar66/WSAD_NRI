package com.hps.july.arenda.formbean;

import javax.servlet.http.HttpServletRequest;
import com.hps.july.persistence.*;
import java.util.Vector;
import org.apache.struts.action.*;
import com.ibm.ivj.ejb.runtime.*;
import java.sql.*;
import java.util.Enumeration;
/**
 * Bean-form
 * Форма "параметры из контракта"(лист).
 * Creation date: (29.10.2002 15:56:24)
 * @author: Sergey Gourov
 */
public class FromContractMainParamsMutReglmntForm extends MainParamsMutReglmntForm {
	protected java.lang.String listForm;
	private java.util.Vector contract;
/**
 * FromContractMainParamsMutReglmntForm constructor comment.
 */
public FromContractMainParamsMutReglmntForm() {
	super();
	listForm = "FromContractMutualReglamentsListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	if (getAction().equals("Add") && contract.get(0) != null) {
		Enumeration e = new ResourceAccessBean().findResourcesByLeaseChargeRules(contract);
		while (e.hasMoreElements()) {
			ResourceAccessBean rBean = (ResourceAccessBean) e.nextElement();
			LeaseMutualContractsAccessBean lmcBean = new LeaseMutualContractsAccessBean(
				new Integer(getLeaseDocument()),
				(Integer) contract.get(0),
				new Integer(rBean.getResource())
			);
			lmcBean.commitCopyHelper();
		}
	}
}
public int getState() {
	return com.hps.july.arenda.APPStates.FROMCONTRACT_MAINPARAMS_MUTREGLMNT_EDIT;
}
public void initRecord(HttpServletRequest request)
	throws Exception
{
	initForm(request);
	
	contract = null;
	Date date = new Date(System.currentTimeMillis());
	setDocumentDate(date);
	
	setDocumentNumber("");
	setActType("");
	setMutualPeriod("M");
	setCommonRate(new Boolean(false));
	setCalcRateType("B");
	setMutState("A");
	
	MutualReglamentsListForm form = (MutualReglamentsListForm) request.getSession().getAttribute(listForm);
	Integer lc = form.getLeaseContract();

System.out.println("FCREGL: init: lc="+lc);
	
	contract = new Vector(1);
	contract.addElement(lc);

	// Если по договору нет регламентов то устанавливать дату начала равную
	// дате начала действия договора
	setStartDateByContract(lc,form.getStartDate());
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (getAction().equals("Add") && contract.get(0) != null) {
		Enumeration e = new ResourceAccessBean().findResourcesByLeaseChargeRules(contract);
		if (!e.hasMoreElements()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.nochargerules"));
		}
	}
	
	super.validateValues(errors);
}
}
