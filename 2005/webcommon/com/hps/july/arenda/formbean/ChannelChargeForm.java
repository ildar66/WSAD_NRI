package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
/**
 * Form-Bean.
 * канал "начислений"
 * Creation date: (09.08.2002 10:38:22)
 * @author: Sergey Gourov
 */
public class ChannelChargeForm extends ChargeForm {
/**
 * ChannelChargeForm constructor comment.
 */
public ChannelChargeForm() {
	super();
	listForm = "ChannelChargesListForm";
}
public java.util.Enumeration getCurrencies() {
	try {
		return new CurrencyAccessBean().findAllOrderByNameAsc();
	} catch(Exception e) {
		e.printStackTrace();
		return (new java.util.Vector()).elements();	
	}	
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
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CHANNEL_CHARGE_EDIT;
}
}
