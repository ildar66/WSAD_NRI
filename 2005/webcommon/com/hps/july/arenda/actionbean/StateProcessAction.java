package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.formbean.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.util.*;
/**
 * Изменяет состояние договора(доп соглашения).
 * Creation date: (18.11.2002 16:49:40)
 * @author: Sergey Gourov
 */
public class StateProcessAction extends com.hps.july.web.util.AbstractProcessAction {
/**
 * Изменяет состояние документа.
 * Creation date: (22.03.2004 11:32:24)
 */
private void changeState(HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	WeStateForm weStateForm = (WeStateForm) editForm;
	Integer leaseDoc = new Integer(weStateForm.getLeaseDocument());
	String fromState = weStateForm.getInitialState();
	String toState = weStateForm.getContractState();
	//String datecloseStr = weStateForm.getDatecloseFrm();
	//String errorTxt = com.hps.july.logic.DocumentLogic.changeStateDocument(leaseDoc, fromState, toState, datecloseStr);	
	java.sql.Date dateclose = weStateForm.getDateclose();
	String errorTxt = com.hps.july.logic.DocumentLogic.changeStateDocument(leaseDoc, fromState, toState, dateclose);
	if (!errorTxt.equals("")) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorTxt));
		throw new ValidationException();
	}
	weStateForm.afterUpdate(null, request);
}
/**
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processUpdate( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
  		AbstractEntityAccessBean bean = null;
		((WeStateForm) editForm).validateValues(errors, request);
        bean = editForm.getDataBean(request);
        BeanUtils.copyProperties( bean, editForm ); 
        editForm.beforeUpdate( bean, request );
        bean.commitCopyHelper();
        editForm.afterUpdate( bean, request );
      	return null;
}
/**
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processUpdate( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	//processUpdate( request, errors, editForm);
	changeState(request, errors, editForm);//замена processUpdate() вызовом процедуры
	return mapping.findForward("success");
}
}
