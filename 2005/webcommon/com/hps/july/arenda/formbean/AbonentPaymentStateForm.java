package com.hps.july.arenda.formbean;

import com.hps.july.web.util.ValidationException;
import org.apache.struts.action.ActionErrors;
/**
 * Form-Bean 
 * состояние "абонентских оплат".
 * Creation date: (18.12.2002 22:41:40)
 * @author: Sergey Gourov
 */
public class AbonentPaymentStateForm extends PaymentStateForm {
public AbonentPaymentStateForm() {
	super();
	listForm = "AbonentPaymentsListForm";
}
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_STATE_PAYMENT_EDIT;
}
public void validateValues(ActionErrors errors)
	throws Exception
{
	super.validateValues(errors);
}
}
