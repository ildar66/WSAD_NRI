package com.hps.july.arenda.actionbean;

import java.util.Enumeration;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.arenda.formbean.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.persistence.*;
import javax.servlet.http.*;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
/**
 * Action-class.
 * действие для "Оплаты начислений"
 * Creation date: (27.01.2003 15:46:57)
 * @author: Sergey Gourov
 */
public class ChargeDnopProcessAction extends com.hps.july.web.util.AbstractProcessAction {
private int getOperatorID(HttpServletRequest request) throws Exception{

	OperatorAccessBean operator = new OperatorAccessBean().findByLogin(request.getRemoteUser());
	return operator.getOperator();
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processDelete( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	LeaseDNOPAccessBean bean = (LeaseDNOPAccessBean) editForm.getDataBean(request);
	bean.refreshCopyHelper();
	
	try {
		if (!new ArendaTransactionMethodAccessBean().clearCharge2Pay(bean.getEJBRef().getHandle(), 0)) {
			new UpdateValidationException("error.chargednop.delete");
		}
	} catch (java.rmi.RemoteException e) {
		throw new UpdateValidationException("error.chargednop.delete");
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processInsert( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	editForm.validateValues(errors);
	ChargeDnopForm oform = (ChargeDnopForm) editForm;
	
	// при добавлении - найти курс по валюте начисления и коду платежа, если есть, то изменяем его, иначе добавляем
	LeaseCalcRateAccessBean lcrBean = new LeaseCalcRateAccessBean();
	try {
		
		lcrBean.setInitKey_docposition_leaseDocPosition(oform.getLeasePaymentcode());
		lcrBean.setInitKey_currency_currency(new Integer(oform.getCurrencycode()));
		lcrBean.refreshCopyHelper();

		lcrBean.setRate(oform.getPaymentRate());
	} catch (javax.ejb.ObjectNotFoundException e) {
		lcrBean = new LeaseCalcRateAccessBean(oform.getLeasePaymentcode(), new Integer(oform.getCurrencycode()),
			oform.getPaymentRate(), new Boolean(true));
	}
	lcrBean.commitCopyHelper();

	LeaseChargesAccessBean lcBean = new LeaseChargesAccessBean();
	lcBean.setInitKey_leaseDocPosition(oform.getLeaseChargecode());
	lcBean.refreshCopyHelper();
	
	LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
	lpBean.setInitKey_leaseDocPosition(oform.getLeasePaymentcode().intValue());
	lpBean.refreshCopyHelper();

	try {
		JournalAccessBean jrn = new JournalAccessBean();
		int taskid = jrn.taskStart(getOperatorID(request), "L");
		
		if (!new ArendaTransactionMethodAccessBean()._linkCharge2Pay(lpBean.getEJBRef().getHandle(), lcBean.getEJBRef().getHandle(),
			lcrBean.getRate(), null, new Boolean(true), "M", taskid)) {
			throw new UpdateValidationException("error.chargednop.insert");
		}
			
		jrn.taskEnd(taskid);
	} catch (java.rmi.RemoteException e) {
		throw new UpdateValidationException("error.chargednop.insert");
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processUpdate( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	AbstractEntityAccessBean bean = null;
	editForm.validateValues(errors);
	bean = editForm.getDataBean(request);
	((LeaseDNOPAccessBean) bean).setChargerurrate(((ChargeDnopForm) editForm).getChargerurrate());
	((LeaseDNOPAccessBean) bean).setChargerursum(((ChargeDnopForm) editForm).getChargerursum());
	bean.commitCopyHelper();
	return null;
}
}
