package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
/**
 * Form-Bean.
 * "Абонентские начислений"
 */
public class AbonentChargeForm extends ChargeForm {
public AbonentChargeForm() {
	super();
	listForm = "AbonentChargesListForm";
}
public java.util.Enumeration getResources() {
	try {
		NamedValueAccessBean bean = new NamedValueAccessBean();
		bean.setInitKey_id("ARENDA_TYPE");
		bean.refreshCopyHelper();

		return new ResourceAccessBean().findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()),
			new Boolean(false), null, new Boolean(false), null, new Integer(3));
	} catch(Exception e) {
		e.printStackTrace();
		return new java.util.Vector().elements();
	}	
}
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_CHARGE_EDIT;
}
}
