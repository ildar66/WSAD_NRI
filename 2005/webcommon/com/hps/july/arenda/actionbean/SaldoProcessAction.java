package com.hps.july.arenda.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.web.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Action-class.
 * הויסעגטו הכÿ "סאכüהמ"
 * Creation date: (24.12.2002 20:05:23)
 * @author: Sergey Gourov
 */
public class SaldoProcessAction extends com.hps.july.web.util.AbstractProcessAction {
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processDelete( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	try {
		SaldoForm form = (SaldoForm) editForm;
		form.beforeDelete(null, request);
		new LeaseSaldoProcessorAccessBean().deleteSaldo(form.getLeaseContract(), form.getSalDate(), new Integer(form.getResourcecode()));
	} catch (java.rmi.RemoteException e) {
		throw new UpdateValidationException("error.saldo.delete");
	}
	return null;
}
public ActionForward processInsert( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	try {
		editForm.validateValues(errors);
		SaldoForm form = (SaldoForm) editForm;

		new LeaseSaldoProcessorAccessBean().createSaldo(form.getLeaseContract(), form.getSalDate(), new Integer(form.getResourcecode()), 
			new Integer(form.getMaincurrencycode()), form.getMainsum(), form.getMainndssum(),
			form.getAdditionalcurrencycode(), form.getAdditionalsum(), form.getAdditionalndssum());

		AbstractEntityAccessBean bean = editForm.getDataBean(request);
        editForm.beforeUpdate( bean, request );
        bean.commitCopyHelper(); 
        editForm.afterUpdate( bean, request );
		
	} catch (java.rmi.RemoteException e) {
		throw new UpdateValidationException("error.saldo.insert");
	}
	
	return null;
}
public ActionForward processUpdate( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	try {
		editForm.validateValues(errors);
		SaldoForm form = (SaldoForm) editForm;
		
		AbstractEntityAccessBean bean = editForm.getDataBean(request);
		editForm.beforeUpdate( bean, request );
		bean.commitCopyHelper();
		editForm.afterUpdate( bean, request );
		
		new LeaseSaldoProcessorAccessBean().updateSaldo(form.getLeaseContract(), form.getSalDate(), new Integer(form.getResourcecode()),
			form.getMaincurrencycode(), form.getMainsum(), form.getMainndssum(),
			form.getAdditionalcurrencycode(), form.getAdditionalsum(), form.getAdditionalndssum());

	} catch (java.rmi.RemoteException e) {
		throw new UpdateValidationException("error.saldo.update");
	}

	return null;
}
}
